var login = {
    init : function(){
        const _this = this
        $('#btn-login').on('click', function(){
            _this.save()
        })
    },

    save : function(){
        let data = {
            id : $('#id').val(),
            password : $('#password').val()
        }

        $.ajax({
            type: 'GET',
            url: '/login.do',
            dataType: 'json',
            contentType: 'application/json; charset=utf8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('success')
        }).fail(function(e){
            alert(JSON.stringify(e))
        })
    }

}
login.init()
