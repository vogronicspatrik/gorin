

/**
 * Created by patrik on 2017.05.14..
 */

$(function () {


$('.game-button').click(function(){
    $('.selected', $(this).parent()).removeClass('selected');
    $(this).addClass('selected');
    });
});

$(function () {

    $('.validate-button').click(function (){

        var dict = {};

        try {
            $(this).parent().children('.questions').each(function (i, elem) {

                var key = $(elem).data().japanese;
                var value = $(elem).children('.selected').data().hungarian;
                dict[key] = value

            });

            var json = JSON.stringify(dict);


            console.log(dict);
            console.log("-----");
            console.log(json);

            var http = new XMLHttpRequest();
            http.onreadystatechange = function() {
                if (http.readyState == XMLHttpRequest.DONE) {
                    alert(http.responseText);
                }
            };
            var url = "/get_data";
            http.open("POST", url, true);
            http.setRequestHeader("Content-type", "application/json");
            http.send(json);



        }
        catch (err){
            alert('Töltsd ki mindegyik feladatot!');
        }

    });



});
