/*js脚本*/
/* window.onload = function(){
    var tabs = document.getElementById('tabs').getElementsByTagName('li');
    for (var i = 0; i < tabs.length; i++) {
        tabs[i].onclick = showlist;
    }
    function showlist() {
        for (var i = 0; i < tabs.length; i++) {
            if (tabs[i] === this) {
                tabs[i].className = "active";
            } else {
                tabs[i].className = " ";
            }
        }
    }
} */
window.onload = function () {
    var tabs = document.getElementById('tabs').getElementsByTagName('li');
    var lists = document.getElementById('lists').getElementsByTagName('ul');
    var seckillNav = document.getElementById('seckillNav');
    window.onscroll = function(){
        var scrollTop = document.documentElement.scrollTop;
        if (scrollTop >= 280) {
            seckillNav.className = "seckill-nav seckill-navfixed";
        } else {
            seckillNav.className = "seckill-nav";
        }
    }
    for (var i = 0; i < tabs.length; i++) {
        tabs[i].onclick = function(){
            for (var i = 0; i < tabs.length; i++) {
                if (tabs[i] === this) {
                    tabs[i].className = "active";
                    lists[i].className = "clearfix active"
                } else {
                    tabs[i].className = " ";
                    lists[i].className = "clearfix";
                }
            }
        }
    }
}