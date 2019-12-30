$(function() {

    let hideBtn = $(".hide-group");

    let groupInfo = $(".group-info");

    let grInfo2 = hideBtn.parents(".message-header").siblings('.group-info:first');

    console.log(grInfo2);

    groupInfo.show();

    hideBtn.each(function () {
        $(this).on("click", function () {
            let groupInfo2 = $(this).parents('div').siblings('div:first');
            groupInfo2.toggle();
        });
    });
});