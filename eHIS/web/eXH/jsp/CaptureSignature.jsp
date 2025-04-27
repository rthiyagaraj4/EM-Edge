
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="IE=edge" />
<title>Patient E-signature</title>
<link rel="stylesheet" href="../../eXH/html/DigitalSignature.css">
  <script type="text/javascript" src="../../eXH/jsp/SigWebTablet.jsp"></script>


		
<script type="text/javascript">

function init() {
	
    // Clear forms here
    document.getElementById('captureSign').disabled = true;
    
}
window.onload=init;

	var tmr;

function onSign()
{
	//alert(document.documentMode);
   var ctx = document.getElementById('cnv').getContext('2d');         
  
   SetDisplayXSize( 350 );
   SetDisplayYSize( 100 );
   SetTabletState(0, tmr);
   SetJustifyMode(0);
   ClearTablet();
   if(tmr == null)
   {
      tmr = SetTabletState(1, ctx, 50);
   }
   else
   {
      SetTabletState(0, tmr);
      tmr = null;
      tmr = SetTabletState(1, ctx, 50);
   }
   document.getElementById('captureSign').disabled = false;
   
}

function onClear()
{
   ClearTablet();
   ClearSigWindow (1);
}

function onCaptureSignature()
{
	
   if(NumberOfTabletPoints() == 0)
   {
      alert("Please sign before continuing");
   }
   else
   {
      SetTabletState(0, tmr);
      //RETURN TOPAZ-FORMAT SIGSTRING
      SetSigCompressionMode(1);
      document.FORM1.bioSigData.value=GetSigString();
      document.FORM1.sigStringData.value = GetSigString();
      //this returns the signature in Topaz's own format, with biometric information


      //RETURN BMP BYTE ARRAY CONVERTED TO BASE64 STRING
      SetImageXSize(350);
      SetImageYSize(100);
      SetImagePenWidth(5);
      GetSigImageB64(SigImageCallback);
      var sigimg = onImage();
      //alert("*** 3 :"+sigimg);
      window.returnValue=sigimg;
      window.close();
      
   	}
   
   
  
   
}

function SigImageCallback( str )
{
    document.FORM1.sigImageData.value = str;
}
    
function onClose(){
	window.close();
}

function onImage(){
	var img = new Image();
	alert("eSignature Captured Successfully");
	function getBase64Img() {
	    var x = "data:image/png;base64,"+ document.getElementById('h').value;
	    return x;
	    
	}
	
	var base64img = getBase64Img();

	function Base64ToImage(base64img, callback) {
	    img.onload = function() {
	        callback(img);
	    };
	    img.src = base64img;
	    
	    
	}
	Base64ToImage(base64img, function(img) {
		document.getElementById('main').appendChild(img) ;		  		  
	});	
	
	return base64img;
}

</script> 
</head> 
<body>
 
<br>
<form action="#"  name=FORM1 onload='init()'>
<div class="modal" id="modal" >	
 <div class="modal-header">
   <div class="title"> Patient E-signature</div>
   
   <div ><input class="button" id="button" type="button" value="X" onclick="onClose()"/></div>
   
 </div>

<p>
<table border="1" cellpadding="0"  width="300" id="table">
  <tr>
    <td height="100" width="300">
     <canvas id="cnv" name="cnv" width="300" height="100">
    </td>
  </tr>
</table>
<div>
<br>
</div>
<div>
<input id="button1"  name="SignBtn" id="SignBtn"  type="button" value="Sign"  onclick="javascript:onSign()"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input id="captureSign"  name="CaptureSignature" id="CaptureSignature" type="button" value="CaptureSignature"  onclick="javascript:onCaptureSignature()"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input id="button3"  name="ClearBtn" id="ClearBtn" type="button" value="Clear" onclick="javascript:onClear()"/>&nbsp;&nbsp;&nbsp;&nbsp;
</div>


<input TYPE=HIDDEN name="bioSigData" id="bioSigData">
<input TYPE=HIDDEN name="sigImgData" id="sigImgData">
<br>
<br>
<textarea style="display : none" name="sigStringData" rows="20" cols="50">SigString: </textarea>
<textarea style="display : none" name="sigImageData" id="h" rows="20" cols="50">Base64 String: </textarea>
<br>
<div id="main" name="ImageData" ></div>
</p>
</div>
</form>
<br>
<br> 
</body>
</html>

