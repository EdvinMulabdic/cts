

function deleteCertificate(certificateId){
    $.ajax({
        data: {val: certificateId} ,
        type: "GET",
        url: "/delete_client_certificate"
    }).success(function() {
    });
};