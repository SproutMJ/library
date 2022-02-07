var login = {
    init : function(){
        const _this = this
        $('#btn-login').on('click', function(){
            _this.save()
        })
    },

    save : function(){
        const data = {
             id : $('#id').val(),
             password : $('#password').val()
        }
        $.ajax({
            type: 'POST',
            url: '/login.do',
            contentType: 'application/json; charset=UTF-8;',
            data: JSON.stringify(data),
            dataType: 'json'
        }).done(function(){
            alert('success')
        }).fail(function(e){
            alert(JSON.stringify(e))
        })
    }

}
login.init()
