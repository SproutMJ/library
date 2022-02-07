const index_banner = {
    now : 0,
    init : function(){
        outer = document.querySelector('#content-wrap')
        list = document.querySelector('#banner-list')
        banners = document.querySelectorAll('.banner')

        banners.forEach((i)=>{
            i.style.width = outer.clientWidth
        })

        list.style.width = outer.clientWidth * banners.length + 'px'

        _this = this
        const left_btn = document.querySelector('#left-btn')
        const right_btn = document.querySelector('#right-btn')
        left_btn.style.opacity = 0
        left_btn.addEventListener('click', function(){
            _this.now--
            if(_this.now > 0){
                right_btn.style.opacity = 1
            }else{
                _this.now = 0
                left_btn.style.opacity = 0
            }
            list.style.marginLeft = `-${_this.now * outer.clientWidth}px`
        })
        right_btn.addEventListener('click', function(){
            _this.now++
            if(_this.now < banners.length - 1){
                
                left_btn.style.opacity = 1
            }else{
                _this.now = banners.length - 1
                right_btn.style.opacity = 0
            }
            list.style.marginLeft = `-${_this.now * outer.clientWidth}px`
        })
    }
}

index_banner.init()