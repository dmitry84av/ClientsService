document.addEventListener('DOMContentLoaded',function () {
    document.getElementById('submitAddUserForm').onclick = function (ev) {
        ev.preventDefault()
        ajaxSubmitForm()
    }
})

function ajaxSubmitForm(){
    let form = document.getElementById('AddUserForm')
    let formData = new FormData(form)
    let json=JSON.stringify(Object.fromEntries(formData))
    //
    let request=new XMLHttpRequest()
        request.open('post','/rest/AddUserForm')
        request.setRequestHeader('Content-Type', 'application/json; charset=utf-8')
    request.send(json)
    request.addEventListener('readystatechange',function (){
        if (request.readyState !==4)
            return
        if (request.status === 200) {
            let users = JSON.parse(request.responseText)
            users = {'users': users}
            console.log(users)
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
            let result = mustache.render(html, users)
            let output = document.getElementById('tableOutput')
            output.innerHTML = result
        } else alert(request.status)
    })
}