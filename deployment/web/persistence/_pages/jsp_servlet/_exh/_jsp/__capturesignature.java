package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __capturesignature extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CaptureSignature.jsp", 1709122305211L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n<!DOCTYPE html>\n<html dir=\"ltr\" lang=\"en-US\">\n<head>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\" />\n<title>Patient E-signature</title>\n<link rel=\"stylesheet\" href=\"../../eXH/html/DigitalSignature.css\">\n  <script type=\"text/javascript\" src=\"../../eXH/jsp/SigWebTablet.jsp\"></script>\n\n\n\t\t\n<script type=\"text/javascript\">\n\nfunction init() {\n\t\n    // Clear forms here\n    document.getElementById(\'captureSign\').disabled = true;\n    \n}\nwindow.onload=init;\n\n\tvar tmr;\n\nfunction onSign()\n{\n\t//alert(document.documentMode);\n   var ctx = document.getElementById(\'cnv\').getContext(\'2d\');         \n  \n   SetDisplayXSize( 350 );\n   SetDisplayYSize( 100 );\n   SetTabletState(0, tmr);\n   SetJustifyMode(0);\n   ClearTablet();\n   if(tmr == null)\n   {\n      tmr = SetTabletState(1, ctx, 50);\n   }\n   else\n   {\n      SetTabletState(0, tmr);\n      tmr = null;\n      tmr = SetTabletState(1, ctx, 50);\n   }\n   document.getElementById(\'captureSign\').disabled = false;\n   \n}\n\nfunction onClear()\n{\n   ClearTablet();\n   ClearSigWindow (1);\n}\n\nfunction onCaptureSignature()\n{\n\t\n   if(NumberOfTabletPoints() == 0)\n   {\n      alert(\"Please sign before continuing\");\n   }\n   else\n   {\n      SetTabletState(0, tmr);\n      //RETURN TOPAZ-FORMAT SIGSTRING\n      SetSigCompressionMode(1);\n      document.FORM1.bioSigData.value=GetSigString();\n      document.FORM1.sigStringData.value = GetSigString();\n      //this returns the signature in Topaz\'s own format, with biometric information\n\n\n      //RETURN BMP BYTE ARRAY CONVERTED TO BASE64 STRING\n      SetImageXSize(350);\n      SetImageYSize(100);\n      SetImagePenWidth(5);\n      GetSigImageB64(SigImageCallback);\n      var sigimg = onImage();\n      //alert(\"*** 3 :\"+sigimg);\n      window.returnValue=sigimg;\n      window.close();\n      \n   \t}\n   \n   \n  \n   \n}\n\nfunction SigImageCallback( str )\n{\n    document.FORM1.sigImageData.value = str;\n}\n    \nfunction onClose(){\n\twindow.close();\n}\n\nfunction onImage(){\n\tvar img = new Image();\n\talert(\"eSignature Captured Successfully\");\n\tfunction getBase64Img() {\n\t    var x = \"data:image/png;base64,\"+ document.getElementById(\'h\').value;\n\t    return x;\n\t    \n\t}\n\t\n\tvar base64img = getBase64Img();\n\n\tfunction Base64ToImage(base64img, callback) {\n\t    img.onload = function() {\n\t        callback(img);\n\t    };\n\t    img.src = base64img;\n\t    \n\t    \n\t}\n\tBase64ToImage(base64img, function(img) {\n\t\tdocument.getElementById(\'main\').appendChild(img) ;\t\t  \t\t  \n\t});\t\n\t\n\treturn base64img;\n}\n\n</script> \n</head> \n<body>\n \n<br>\n<form action=\"#\"  name=FORM1 onload=\'init()\'>\n<div class=\"modal\" id=\"modal\" >\t\n <div class=\"modal-header\">\n   <div class=\"title\"> Patient E-signature</div>\n   \n   <div ><input class=\"button\" id=\"button\" type=\"button\" value=\"X\" onclick=\"onClose()\"/></div>\n   \n </div>\n\n<p>\n<table border=\"1\" cellpadding=\"0\"  width=\"300\" id=\"table\">\n  <tr>\n    <td height=\"100\" width=\"300\">\n     <canvas id=\"cnv\" name=\"cnv\" width=\"300\" height=\"100\">\n    </td>\n  </tr>\n</table>\n<div>\n<br>\n</div>\n<div>\n<input id=\"button1\"  name=\"SignBtn\" id=\"SignBtn\"  type=\"button\" value=\"Sign\"  onclick=\"javascript:onSign()\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n<input id=\"captureSign\"  name=\"CaptureSignature\" id=\"CaptureSignature\" type=\"button\" value=\"CaptureSignature\"  onclick=\"javascript:onCaptureSignature()\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n<input id=\"button3\"  name=\"ClearBtn\" id=\"ClearBtn\" type=\"button\" value=\"Clear\" onclick=\"javascript:onClear()\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n</div>\n\n\n<input TYPE=HIDDEN name=\"bioSigData\" id=\"bioSigData\">\n<input TYPE=HIDDEN name=\"sigImgData\" id=\"sigImgData\">\n<br>\n<br>\n<textarea style=\"display : none\" name=\"sigStringData\" rows=\"20\" cols=\"50\">SigString: </textarea>\n<textarea style=\"display : none\" name=\"sigImageData\" id=\"h\" rows=\"20\" cols=\"50\">Base64 String: </textarea>\n<br>\n<div id=\"main\" name=\"ImageData\" ></div>\n</p>\n</div>\n</form>\n<br>\n<br> \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
