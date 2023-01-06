const html=`
<table>
<tr>
<th>ID</th>
<th>Surname</th>
<th>Name</th>
<th>Patronymic</th>
<th>Gender</th>
<th>Email</th>
</tr>
{{#clients}}
<tr>
<td>{{id}}"</td>
<td>{{surname}}</td>
<td>{{name}}</td>
<td>{{patronymic}}</td>
<td>{{client.gender}}</td>
<td>{{email}}</td>
<td>
<form action="@{/openClientForm}" method="post">
<input type="hidden" name="id" value="{{id}}">
<input type="submit" value="&#8942;">
</form>
</td>
</tr>
{{/clients}}
</table>
            `
$(document).ready(() => {
    $('#submitAddClientForm').click((ev) => {
        ev.preventDefault()
        ajaxSubmitForm()
    })
})

function ajaxSubmitForm() {
    let form = $('#addClientForm')
    let formData = new FormData(form)
    let json = JSON.stringify(Object.fromEntries(formData))
    //
    $.ajax({
        type:'post',
        url:'/rest/addClientForm',
        data:json,
        processData:false,
        contentType:'application/json; charset=utf-8',
        success:function (data, textStatus /*, reqInfo*/) {
            /*console.log(data)
            console.log(textStatus)
            console.log(reqInfo)
            let clients = JSON.parse(regInfo.responseText)*/
            let clients = {'clients': data}
            let result = mustache.render(html,clients)
            $('#tableOutput').html(result)
        },
        error: function (reqInfo, textStatus, errorThrows) {
            console.log(reqInfo)
            console.log(textStatus)
            console.log(errorThrows)
        }
    })
}