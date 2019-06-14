

function submit() {
    var url = "http://localhost:8080/convert";
    var conversion = $('#select').val();
    var value = $('#value').val();

    if(value == null || value == undefined){
        alert("Please provide a valid value");
        return;
    }

    conversion = conversion.split(",");
    var from = conversion[0];
    var to = conversion[1];
    url = url + "?from="+ from + "&to=" + to + "&value=" + value

    $.ajax({
        type: "GET",
        url: url,
        success: function (result, status, xhr) {
            $('#results').css("color", "green").text(result);
        },
        error: function (xhr, status, error) {
            $('#results').css("color","red").text(error)
            console.log("Error occured while performing task. " + error);
        }
    });

};