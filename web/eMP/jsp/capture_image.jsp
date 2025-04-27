<%@ page contentType="text/html;charset=UTF-8" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" >
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script>
	var userAgent = navigator.userAgent;
	//Get the browser's name and version.
	//var browserName = userAgent.split(' ')[0];
	//var browserVersion = userAgent.split(' ')[1];

	//Display the browser name and version.
	//alert("document.documentMode1  "+userAgent);

	</script>
	
    <title>Webcam Photo Capture</title>
  </head>
  <%
  
  
  String patient_id = request.getParameter("patient_id");
  String photo_count = request.getParameter("photo_count");
  String module_id = request.getParameter("module_id");
  String patient_name = request.getParameter("patient_name");
  String facility_id = request.getParameter("facility_id");
  String user_id = request.getParameter("user_id");
  String ws_no = request.getParameter("ws_no");
  String locale = request.getParameter("locale");

  %>
  <body onload="startCam()">
  	<div class='container'>
  	  	<div class='row'>
      		<div class='col-6'>
    			<video class="rounded" id="webcam" autoplay></video>
    		</div>
	  		<div class='col-6'>
				<img class="rounded" id="capturedPhoto" alt="Captured Image" />
   			</div>   
		<div class="row justify-content-center">
			<div class="col-4">
			    <button class="btn btn-secondary" id="captureBtn">Capture Photo</button>
				<button class="btn btn-secondary" onclick="submit()" id="submitBtn">Submit</button>
			</div>
		</div>

    <canvas hidden id="canvas" width="640" height="480"></canvas>
    </div>  
	</div>
	<input type="hidden" name="patient_id" id ="patient_id" value="<%= patient_id %>"/>
	<input type="hidden" name="photoCount" id ="photoCount" value="<%=photo_count%>"/>
	
	<input type="hidden" name="module_id" id ="module_id" value="<%=module_id%>"/>
	<input type="hidden" name="patient_name" id ="patient_name" value="<%=patient_name%>"/>
	<input type="hidden" name="facility_id" id ="facility_id" value="<%=facility_id%>"/>
	<input type="hidden" name="user_id" id ="user_id" value="<%=user_id%>"/>
	<input type="hidden" name="ws_no" id ="ws_no" value="<%=ws_no%>"/>
	<input type="hidden" name="locale" id ="locale" value="<%=locale%>"/>
    <script>	
	function getImgName(){
		const currentDate = new Date();
		// Get the individual components of the date and time
		const year = currentDate.getFullYear(); // Get the year (four digits)
		const month = ((currentDate.getMonth() + 1)+'').padStart(2, '0'); // Get the month (0-11, add 1 for human-readable format)
		const day = (currentDate.getDate() + '').padStart(2, '0'); // Get the day of the month (1-31)
		const hours = (currentDate.getHours() + '').padStart(2, '0'); // Get the hour (0-23)
		const minutes = (currentDate.getMinutes() + '').padStart(2, '0'); // Get the minutes (0-59)
		const seconds = (currentDate.getSeconds() + '').padStart(2, '0'); // Get the seconds (0-59)

		const formattedDateTime = year+''+month+''+day+''+hours+''+minutes+''+seconds;

		return 'img_' + formattedDateTime+'.jpeg';
	}
	
	function submit(){
			var imgData = document.getElementById("capturedPhoto");
			var patient_id = document.getElementById("patient_id");

			var photoCount = document.getElementById("photoCount");
			var module_id = document.getElementById("module_id");
			var patient_name = document.getElementById("patient_name");
			var facility_id = document.getElementById("facility_id");
			var user_id = document.getElementById("user_id");
			var ws_no = document.getElementById("ws_no");
			var photoCount = document.getElementById("photoCount");
			var locale = document.getElementById("locale");

            
            var canvas = document.getElementById("canvas");
            var img_data1 = canvas.toDataURL("image/jpeg");
   
            const image = canvas.getContext('2d').getImageData(0, 0, canvas.width, canvas.height);
		
            canvas.toBlob((blobImage) => {
        		const fileName = getImgName();
                const formData = new FormData();
                formData.append('patFile', blobImage,fileName)
                formData.append('patient_id',patient_id.value);
                formData.append('photoCount',photoCount.value);

                var xhr = new XMLHttpRequest();
                xhr.open('POST', '../../servlet/eMP.PhotoUploadServlet', true);
                xhr.onreadystatechange = function() {
					if (xhr.readyState === 4 && xhr.status === 200) {
						console.log('Image submitted successfully');
						onSuccess();
						window.close();
					}
                };
                xhr.send(formData); 
            });
	}
	
	function onSuccess(){
		if (window.opener && !window.opener.closed) {
			window.opener.reloadPline();
		} else {
			alert("Parent window is closed or not accessible.");
		}	
	
	}
	
     /*function startCam(){
		alert("inside start cam 134");
		 
    	  var submitBtn = document.getElementById("submitBtn");
		  submitBtn.style.visibility="hidden";
		  
          var video = document.getElementById("webcam");

          var captureBtn = document.getElementById("captureBtn");
          var canvas = document.getElementById("canvas");
          var capturedPhoto = document.getElementById("capturedPhoto");
		
		video.setAttribute("style","width:500px")
		capturedPhoto.setAttribute("style","width:500px")
          // Check if the browser supports getUserMedia
			//"use strict"; 

		 navigator.mediaDevices.getUserMedia({
		if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
		    video: true
		  }).then(function (stream) {
		    video.srcObject = stream;
		  })["catch"](function (error) {
		    console.log("Error accessing webcam:", error);
		  });
		  captureBtn.addEventListener("click", function () {
		    // Capture a photo from the webcam
		   
		    var context = canvas.getContext("2d");
		    context.drawImage(video, 0, 0, canvas.width, canvas.height);
		    // Display the captured photo
			capturedPhoto.src = canvas.toDataURL("image/jpeg");
			if(capturedPhoto.src != ''){
				captureBtn.innerHTML = "Retake";
				submitBtn.style.visibility="visible";
			}
		  });
		} else {
		  alert("getUserMedia is not supported in this browser");
		}
				  
	}*/
	async function startCam() {  //changes by vijayan for EDGE work
		
    var submitBtn = document.getElementById("submitBtn");
    submitBtn.style.visibility = "hidden";

    var video = document.getElementById("webcam");
    var captureBtn = document.getElementById("captureBtn");
    var canvas = document.getElementById("canvas");
    var capturedPhoto = document.getElementById("capturedPhoto");

    video.setAttribute("style", "width:500px");
    capturedPhoto.setAttribute("style", "width:500px");

    if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
        try {
            let stream = await navigator.mediaDevices.getUserMedia({ video: true });
            video.srcObject = stream;
        } catch (error) {
            console.log("Error accessing webcam:", error);
        }
        captureBtn.addEventListener("click", function () {
            var context = canvas.getContext("2d");           
            canvas.width = video.videoWidth;
            canvas.height = video.videoHeight;
            context.drawImage(video, 0, 0, canvas.width, canvas.height);           
            capturedPhoto.src = canvas.toDataURL("image/jpeg");
            if (capturedPhoto.src !== '') {
                captureBtn.innerHTML = "Retake";
                submitBtn.style.visibility = "visible";
            }
        });
    } else {
        alert("getUserMedia is not supported in this browser");
    }
}

    </script>
  </body>
</html>

	<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>