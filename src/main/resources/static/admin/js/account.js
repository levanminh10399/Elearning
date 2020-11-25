Dropzone.autoDiscover = false;
$(document).ready(function(){
	var uploadUrl = $("#dZUpload").data("upload");
	var loadUrl = $("#dZUpload").data("load");
	$("#dZUpload").dropzone({
		url:uploadUrl,
		addRemoveLinks: true,
		paramName: "file",
		maxFilesize: 2,
		acceptedFiles: 'image/*,.jpg,.png,jpeg',
		success: function (file,response){
			var imgName = response.url;
			file.previewElement.classList.add("dz-success");
			$('#avatar').val(imgName);
			console.log("Successfully uploaded :"+ imgName);
		},
		error: function (file, response){
			console.log(response)
			file.previewElement.classList.add("dz-error");
		}
	});
});