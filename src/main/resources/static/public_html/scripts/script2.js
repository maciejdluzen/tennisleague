document.addEventListener("DOMContentLoaded", function() {

    let hideBtns = document.querySelectorAll(".hide-group");

    let groupInfo = document.querySelectorAll(".group-info");

    let bar = document.querySelectorAll(".message-header");


    console.log(bar);

    console.log(hideBtns);

    console.log(groupInfo);

    for(let i = 0; i < bar.length; i++) {
        bar[i].addEventListener("click", function () {
            this.nextElementSibling.classList.toggle("hideElement");
        })
    }

});