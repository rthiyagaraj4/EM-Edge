package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __capture_image extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/emp/jsp/capture_image.jsp", 1728472486463L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n  <head>\r\n\r\n    <meta charset=\"UTF-8\" />\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" >\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\r\n\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\r\n\t<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n    <script>\r\n\tvar userAgent = navigator.userAgent;\r\n\t//Get the browser\'s name and version.\r\n\t//var browserName = userAgent.split(\' \')[0];\r\n\t//var browserVersion = userAgent.split(\' \')[1];\r\n\r\n\t//Display the browser name and version.\r\n\t//alert(\"document.documentMode1  \"+userAgent);\r\n\r\n\t</script>\r\n\t\r\n    <title>Webcam Photo Capture</title>\r\n  </head>\r\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n  <body onload=\"startCam()\">\r\n  \t<div class=\'container\'>\r\n  \t  \t<div class=\'row\'>\r\n      \t\t<div class=\'col-6\'>\r\n    \t\t\t<video class=\"rounded\" id=\"webcam\" autoplay></video>\r\n    \t\t</div>\r\n\t  \t\t<div class=\'col-6\'>\r\n\t\t\t\t<img class=\"rounded\" id=\"capturedPhoto\" alt=\"Captured Image\" />\r\n   \t\t\t</div>   \r\n\t\t<div class=\"row justify-content-center\">\r\n\t\t\t<div class=\"col-4\">\r\n\t\t\t    <button class=\"btn btn-secondary\" id=\"captureBtn\">Capture Photo</button>\r\n\t\t\t\t<button class=\"btn btn-secondary\" onclick=\"submit()\" id=\"submitBtn\">Submit</button>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\r\n    <canvas hidden id=\"canvas\" width=\"640\" height=\"480\"></canvas>\r\n    </div>  \r\n\t</div>\r\n\t<input type=\"hidden\" name=\"patient_id\" id =\"patient_id\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\r\n\t<input type=\"hidden\" name=\"photoCount\" id =\"photoCount\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\r\n\t\r\n\t<input type=\"hidden\" name=\"module_id\" id =\"module_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\r\n\t<input type=\"hidden\" name=\"patient_name\" id =\"patient_name\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\r\n\t<input type=\"hidden\" name=\"facility_id\" id =\"facility_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\r\n\t<input type=\"hidden\" name=\"user_id\" id =\"user_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\r\n\t<input type=\"hidden\" name=\"ws_no\" id =\"ws_no\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\r\n\t<input type=\"hidden\" name=\"locale\" id =\"locale\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\r\n    <script>\t\r\n\tfunction getImgName(){\r\n\t\tconst currentDate = new Date();\r\n\t\t// Get the individual components of the date and time\r\n\t\tconst year = currentDate.getFullYear(); // Get the year (four digits)\r\n\t\tconst month = ((currentDate.getMonth() + 1)+\'\').padStart(2, \'0\'); // Get the month (0-11, add 1 for human-readable format)\r\n\t\tconst day = (currentDate.getDate() + \'\').padStart(2, \'0\'); // Get the day of the month (1-31)\r\n\t\tconst hours = (currentDate.getHours() + \'\').padStart(2, \'0\'); // Get the hour (0-23)\r\n\t\tconst minutes = (currentDate.getMinutes() + \'\').padStart(2, \'0\'); // Get the minutes (0-59)\r\n\t\tconst seconds = (currentDate.getSeconds() + \'\').padStart(2, \'0\'); // Get the seconds (0-59)\r\n\r\n\t\tconst formattedDateTime = year+\'\'+month+\'\'+day+\'\'+hours+\'\'+minutes+\'\'+seconds;\r\n\r\n\t\treturn \'img_\' + formattedDateTime+\'.jpeg\';\r\n\t}\r\n\t\r\n\tfunction submit(){\r\n\t\t\tvar imgData = document.getElementById(\"capturedPhoto\");\r\n\t\t\tvar patient_id = document.getElementById(\"patient_id\");\r\n\r\n\t\t\tvar photoCount = document.getElementById(\"photoCount\");\r\n\t\t\tvar module_id = document.getElementById(\"module_id\");\r\n\t\t\tvar patient_name = document.getElementById(\"patient_name\");\r\n\t\t\tvar facility_id = document.getElementById(\"facility_id\");\r\n\t\t\tvar user_id = document.getElementById(\"user_id\");\r\n\t\t\tvar ws_no = document.getElementById(\"ws_no\");\r\n\t\t\tvar photoCount = document.getElementById(\"photoCount\");\r\n\t\t\tvar locale = document.getElementById(\"locale\");\r\n\r\n            \r\n            var canvas = document.getElementById(\"canvas\");\r\n            var img_data1 = canvas.toDataURL(\"image/jpeg\");\r\n   \r\n            const image = canvas.getContext(\'2d\').getImageData(0, 0, canvas.width, canvas.height);\r\n\t\t\r\n            canvas.toBlob((blobImage) => {\r\n        \t\tconst fileName = getImgName();\r\n                const formData = new FormData();\r\n                formData.append(\'patFile\', blobImage,fileName)\r\n                formData.append(\'patient_id\',patient_id.value);\r\n                formData.append(\'photoCount\',photoCount.value);\r\n\r\n                var xhr = new XMLHttpRequest();\r\n                xhr.open(\'POST\', \'../../servlet/eMP.PhotoUploadServlet\', true);\r\n                xhr.onreadystatechange = function() {\r\n\t\t\t\t\tif (xhr.readyState === 4 && xhr.status === 200) {\r\n\t\t\t\t\t\tconsole.log(\'Image submitted successfully\');\r\n\t\t\t\t\t\tonSuccess();\r\n\t\t\t\t\t\twindow.close();\r\n\t\t\t\t\t}\r\n                };\r\n                xhr.send(formData); \r\n            });\r\n\t}\r\n\t\r\n\tfunction onSuccess(){\r\n\t\tif (window.opener && !window.opener.closed) {\r\n\t\t\twindow.opener.reloadPline();\r\n\t\t} else {\r\n\t\t\talert(\"Parent window is closed or not accessible.\");\r\n\t\t}\t\r\n\t\r\n\t}\r\n\t\r\n     /*function startCam(){\r\n\t\talert(\"inside start cam 134\");\r\n\t\t \r\n    \t  var submitBtn = document.getElementById(\"submitBtn\");\r\n\t\t  submitBtn.style.visibility=\"hidden\";\r\n\t\t  \r\n          var video = document.getElementById(\"webcam\");\r\n\r\n          var captureBtn = document.getElementById(\"captureBtn\");\r\n          var canvas = document.getElementById(\"canvas\");\r\n          var capturedPhoto = document.getElementById(\"capturedPhoto\");\r\n\t\t\r\n\t\tvideo.setAttribute(\"style\",\"width:500px\")\r\n\t\tcapturedPhoto.setAttribute(\"style\",\"width:500px\")\r\n          // Check if the browser supports getUserMedia\r\n\t\t\t//\"use strict\"; \r\n\r\n\t\t navigator.mediaDevices.getUserMedia({\r\n\t\tif (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {\r\n\t\t    video: true\r\n\t\t  }).then(function (stream) {\r\n\t\t    video.srcObject = stream;\r\n\t\t  })[\"catch\"](function (error) {\r\n\t\t    console.log(\"Error accessing webcam:\", error);\r\n\t\t  });\r\n\t\t  captureBtn.addEventListener(\"click\", function () {\r\n\t\t    // Capture a photo from the webcam\r\n\t\t   \r\n\t\t    var context = canvas.getContext(\"2d\");\r\n\t\t    context.drawImage(video, 0, 0, canvas.width, canvas.height);\r\n\t\t    // Display the captured photo\r\n\t\t\tcapturedPhoto.src = canvas.toDataURL(\"image/jpeg\");\r\n\t\t\tif(capturedPhoto.src != \'\'){\r\n\t\t\t\tcaptureBtn.innerHTML = \"Retake\";\r\n\t\t\t\tsubmitBtn.style.visibility=\"visible\";\r\n\t\t\t}\r\n\t\t  });\r\n\t\t} else {\r\n\t\t  alert(\"getUserMedia is not supported in this browser\");\r\n\t\t}\r\n\t\t\t\t  \r\n\t}*/\r\n\tasync function startCam() {  //changes by vijayan for EDGE work\r\n\t\t\r\n    var submitBtn = document.getElementById(\"submitBtn\");\r\n    submitBtn.style.visibility = \"hidden\";\r\n\r\n    var video = document.getElementById(\"webcam\");\r\n    var captureBtn = document.getElementById(\"captureBtn\");\r\n    var canvas = document.getElementById(\"canvas\");\r\n    var capturedPhoto = document.getElementById(\"capturedPhoto\");\r\n\r\n    video.setAttribute(\"style\", \"width:500px\");\r\n    capturedPhoto.setAttribute(\"style\", \"width:500px\");\r\n\r\n    if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {\r\n        try {\r\n            let stream = await navigator.mediaDevices.getUserMedia({ video: true });\r\n            video.srcObject = stream;\r\n        } catch (error) {\r\n            console.log(\"Error accessing webcam:\", error);\r\n        }\r\n        captureBtn.addEventListener(\"click\", function () {\r\n            var context = canvas.getContext(\"2d\");           \r\n            canvas.width = video.videoWidth;\r\n            canvas.height = video.videoHeight;\r\n            context.drawImage(video, 0, 0, canvas.width, canvas.height);           \r\n            capturedPhoto.src = canvas.toDataURL(\"image/jpeg\");\r\n            if (capturedPhoto.src !== \'\') {\r\n                captureBtn.innerHTML = \"Retake\";\r\n                submitBtn.style.visibility = \"visible\";\r\n            }\r\n        });\r\n    } else {\r\n        alert(\"getUserMedia is not supported in this browser\");\r\n    }\r\n}\r\n\r\n    </script>\r\n  </body>\r\n</html>\r\n\r\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

  
  
  String patient_id = request.getParameter("patient_id");
  String photo_count = request.getParameter("photo_count");
  String module_id = request.getParameter("module_id");
  String patient_name = request.getParameter("patient_name");
  String facility_id = request.getParameter("facility_id");
  String user_id = request.getParameter("user_id");
  String ws_no = request.getParameter("ws_no");
  String locale = request.getParameter("locale");

  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(photo_count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
