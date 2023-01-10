package com.example.clientsservice.srvices;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class ClientEmptyService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private MailingService mailingService;

    @Async
    public Future<List<Client>> checkClients(){
        List<Client> clientsList = clientService.findAllByAmountEquals(0);
        return new AsyncResult<>(clientsList);
    }
    @Scheduled(cron = "*/1 * * * *", zone = "Europe/Kiev")//ДЗ Проверка аккаунтов и рассылка сообщений должна происходить раз в минуту.
    @Async
    public void start(){
        try {
            Future<List<Client>> future = checkClients();
            while (!future.isDone())
                Thread.sleep(10);
            List<Client> clientsList = future.get();
            for (Client client : clientsList){
                for (Client ignored : client.getClients()){
                    mailingService.sendEmail(client.getEmail(), client.getSurname());
                }
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }

    }
}
