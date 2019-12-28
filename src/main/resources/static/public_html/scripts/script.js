$(function() {

    let hideBtn = $("#hide-group");

    let groupInfo = $("#group-info");

    $(hideBtn).on("click", function () {
        $(groupInfo).toggle();
    });

});