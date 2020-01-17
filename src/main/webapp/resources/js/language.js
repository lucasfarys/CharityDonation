// $(document).ready(function() {
//     $("#locales").change(function () {
//         var selectedOption = $('#locales').val();
//         if (selectedOption != ''){
//             window.location.replace('international?lang=' + selectedOption);
//         }
//     });
// });

document.addEventListener("DOMContentLoaded", function() {
    console.log("test1");
    var locale = document.getElementById("locale");
    locale.addEventListener("change",function (ev) {
        var selectedOption = locale.options[locale.selectedIndex].value;
        console.log("test");
        console.log(selectedOption);
        window.location.replace('?lang=' + selectedOption);
    })

});
