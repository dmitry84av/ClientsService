const html = `
<table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Status</th>
        </tr>
        {{#users}}
            <tr>
                <td>{{id}}</td>
                <td>{{username}}</td>
                <td>{{password}}</td>
                <td>{{role}}</td>
                <td>{{status}}</td>
                <td>
                    <form action="/openUserForm" method="post">
                        <input type="hidden" name="id" value="{{id}}">
                        <input type="submit" value="&#8942;">
                    </form>
                </td>
            </tr>
        {{/users}}
    </table>
            `
$(document).ready(() => {
    $('#submitAddUserForm').click((ev) => {
        ev.preventDefault()
        ajaxSubmitForm()
    })
})

function ajaxSubmitForm() {
    let form = $('#AddUserForm')[0]
    let formData = new FormData(form)
    let json = JSON.stringify(Object.fromEntries(formData))
    //
    $.ajax({
        type:'post',
        url:'/rest/AddUserForm',
        data:json,
        processData:false,
        contentType:'application/json; charset=utf-8',
        success:function (data, textStatus /*, reqInfo*/) {
            /*console.log(data)
            console.log(textStatus)
            console.log(reqInfo)
            let clients = JSON.parse(regInfo.responseText)*/
            let users = {'users': data}
            let result = mustache.render(html,users)
            $('#tableOutput').html(result)
        },
        error: function (reqInfo, textStatus, errorThrown) {
            console.log(reqInfo)
            console.log(textStatus)
            console.log(errorThrown)
        }
    })
}