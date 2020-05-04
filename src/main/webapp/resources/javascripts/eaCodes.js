/**
 * Created by User on 4/24/2016.
 */
$("select").change(
        function displayVals() {
            var multipleValues9001 = $("#multiple9001").val() || [];
            $("#ea9001").val(multipleValues9001.join( "," ));
            var multipleValues14001 = $("#multiple14001").val() || [];
            $("#ea14001").val(multipleValues14001.join( "," ));
        });
// $("select").change(
//     function displayVals() {
//         var multipleValues = $("#multiple14001").val() || [];
//         console.log(multipleValues);
//         $("#ea14001").val(multipleValues.join( "," ));
//     });



