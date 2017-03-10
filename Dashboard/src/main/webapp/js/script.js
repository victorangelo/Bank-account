$(function(){
    $("#progressbar").progressbar();
    $("#progressbar").hide();
    $("#upload_btn").click(upload);
});

function upload(){
    var fileIn = $("#fileToUpload")[0];
    
    //Has any file been selected yet?
    if (fileIn.files === undefined || fileIn.files.length == 0) {
        alert("Please select a file");
        return;
    }
    
    //Show the progress bar
    $("#progressbar").show();
    
    $.ajax({
        url: "transacts?file=" + file,
        type: "POST",
        data: file,
        processData: false, //Work around #1
        contentType: file.type, //Work around #2
        success: function(){
            $("#progressbar").hide();
        },
        error: function(){alert("Upload Failed");},
        //Work around #3
        xhr: function() {
            myXhr = $.ajaxSettings.xhr();
            if(myXhr.upload){
                myXhr.upload.addEventListener('progress',showProgress, false);
            } else {
                console.log("Uploadress is not supported.");
            }
            return myXhr;
        }
    });
}

function showProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = (evt.loaded / evt.total) * 100;
        $('#progressbar').progressbar("option", "value", percentComplete );
    }  
}
