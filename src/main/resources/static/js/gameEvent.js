

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


            var http = new XMLHttpRequest();
            http.onreadystatechange = function() {
                if (http.readyState == XMLHttpRequest.DONE) {

                    var result = JSON.parse(http.responseText);


                    for (var key in result){
                        var actucalDiv = document.getElementById(key);
                        var valueList = result[key];
                        if(valueList[1] == "true"){
                            actucalDiv.style.backgroundColor = "green";

                        }
                        else{
                            actucalDiv.style.backgroundColor = "red";
                            var actualButton = document.getElementById(key + '-' + valueList[0]);
                            actualButton.style.backgroundColor = "green";
                        }
                    }

                    var buttons = document.getElementsByClassName('game-button');
                    for(var elem in buttons){
                        buttons[elem].disabled = true;
                    }
                    var validateButton = document.getElementById('validate-button');
                    validateButton.disabled = true;


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
