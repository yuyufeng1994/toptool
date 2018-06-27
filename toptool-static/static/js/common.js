//load main panel
$(function () {
    var locationUrl = window.location.href;
    //激活按钮
    $("#nav-list").find("li").each(function () {
        if (locationUrl.indexOf($(this).find("a").attr("href")) != -1) {
            $(this).addClass("active")
        }
    })
})

var loadContent = function (pageUrl) {
    $.get("page/" + pageUrl, function (res) {
        $("#page-content").html(res)
    })
}

var myUtils = {
    getUrlParam: function (url, name) {
        var pattern = new RegExp("[?&]" + name + "\=([^&]+)", "g");
        var matcher = pattern.exec(url);
        var items = null;
        if (null != matcher) {
            try {
                items = decodeURIComponent(decodeURIComponent(matcher[1]));
            } catch (e) {
                try {
                    items = decodeURIComponent(matcher[1]);
                } catch (e) {
                    items = matcher[1];
                }
            }
        }
        return items;
    }
}