var inputs = document.getElementsByClassName("input-field");
var solutions = ["miyagi", "1888", "naha", "higaonna"];

$('.finish-button').click(function(){


    for(var i=0;i<inputs.length;i++){
        console.log(inputs[i].value);
        if(inputs[i].value.toLowerCase() == solutions[i]){
            inputs[i].style.backgroundColor = "green";
        }
        else {
            inputs[i].style.backgroundColor = "red";

        }
    }


});
