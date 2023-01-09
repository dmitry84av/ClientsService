package com.example.clientsservice.ui.errorcontrollers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class ErrController implements ErrorController {

    @RequestMapping("error")
    public ModelAndView handleError(HttpServletResponse request) {
        Integer statusAttr = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusAttr == null)
            return new ModelAndView("error");
        HttpStatus status = HttpStatus.valueOf(statusAttr);
        /*if(status == HttpStatus.FORBIDDEN.value())
            return new ModelAndView("redirect:");*/
        return new ModelAndView("error", new ModelMap("request", Map.of(
                "timestamp", LocalDateTime.now(),
                "error", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                "message", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                "status", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                "path", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                "exception", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),
                "trace", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        )));
    }
}
