//load main panel
var loadContent = function (mythis, pageUrl) {
    $("#nav-list").find("li").each(function () {
        $(this).removeClass("active")
    })
    $(mythis).parent().addClass("active")
    $.get("page/" + pageUrl, function (res) {
        $("#page-content").html(res)
    })
}