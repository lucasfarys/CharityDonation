document.addEventListener("DOMContentLoaded", function() {
    var locale = document.getElementById("locale");
    locale.addEventListener("change",function (ev) {
        var selectedOption = locale.options[locale.selectedIndex].value;
        console.log("test");
        console.log(selectedOption);
        window.location.replace('?lang=' + selectedOption);
    })

});
