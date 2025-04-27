package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.PortalConstants;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.login.response.LoginResponse;

public final class __loginpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/LoginPage.jsp", 1669269355891L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Home :::</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../css/style_ie.css\" type=\"text/css\"/>\r\n\r\n<script>\r\n  function Login()\r\n  {\r\n\t  var userName = document.getElementById(\"name\").value;\r\n\t  var pwd = document.getElementById(\"password\").value;\r\n\t  \r\n\t  if(userName == null || userName == \"\")\r\n\t\t  {\r\n\t\t    alert(\"Please Enter User Name\");\r\n\t\t    return false\r\n\t\t  }\r\n\t  \r\n\t  if(pwd == null || pwd == \"\")\r\n\t\t  {\r\n\t\t    alert(\"Please Enter Password\");\r\n\t\t    return false;\r\n\t\t  }\r\n\t return true; \r\n  }\r\n  \r\n  function showHomePage(){\r\n\t  var loginResult = Login();\r\n\t  if(loginResult == false){\r\n\t\t  return;\r\n\t  }else if(loginResult == true){\r\n\t\t  var formElement = document.getElementById(\"login_form\");\r\n\t\t  if(formElement){\r\n\t\t\t  var userName = document.getElementById(\"name\").value;\r\n\t\t\t  //formElement.action = \"../jsp/PatientPortalHome.jsp?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t\t  formElement.action = \"../servlet/LoginServlet?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t\t  formElement.submit();\r\n\t\t  }\r\n\t  }\r\n\t  \r\n  }\r\n  \r\n  document.onkeypress = keyPress;\r\n  function keyPress(e){\r\n\t  var x = e || window.event;\r\n\t  var key = (x.keyCode || x.which);\r\n\t    if(key == 13 || key == 3){\r\n\t    \tshowHomePage();\r\n\t    }\r\n\t}\r\n  \r\n</script>\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"wrapper\" style=\"background-image:url(../images/loginbg.png);background-repeat:repeat-x;\" class=\"LoginBackgroun\">\r\n \t\r\n<header id=\"headerlogin\">\r\n  <div id=\"loginHearBg\">\r\n  </div>\r\n</header>\r\n \r\n<form id=\'login_form\' name=\'login_form\' method=\"post\" action=\"../../servlet/LoginServlet\">\r\n<div id=\"logincontent\">\r\n<div id=\"mydiv\">\r\n\t<div class=\"row\">\r\n    \t<div id=\"loginlogo\">\r\n   \t\t<img src=\"../images/logo.png\"> </div>\r\n        <div id=\"logininput\">\r\n      \t\t<div id=\"logininputcontent\">\r\n\t\t\t\t\t\t<span class=\"signin\"> Sign In </span><br>\r\n\t\t\t  <span class=\"username\"> Username </span><br>\r\n                        <input id=\'name\' name=\'name\' type=\"text\" style=\"background: transparent url(\'../images/textbox.png\') no-repeat;width: 265px;color : #747862;height:30px;border:0;padding:0px 0px;margin-bottom:0px;\" class=\"textbo\"><br>\r\n                        <span class=\"username\"> Password </span><br>\r\n                        <input type=\"password\" id=\'password\' name=\'password\' style=\"background: transparent url(\'../images/textbox.png\') no-repeat;width: 265px;color : #747862;height:30px;border:0;padding:0px 0px;margin-bottom:0px;\" class=\"textbo\"><br>\r\n                        \r\n                        \r\n                        ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n                        <!-- place holder for error image -->\r\n                        <p>\r\n                        <span class=\"loginerror\">\r\n                        ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n                        </span>\r\n                        </p>\r\n                        ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n                        \r\n                        <span> <a href=\"#\" onclick=\"showHomePage()\" class=\"Signbtn\">Sign In</a></span><br>\r\n                        <span> <a href=\"#\" class=\"mainlink\">Unable to access my account</a></span><br>\r\n                        <span> <a href=\"#\" class=\"mainlink\">Click here to Register </a></span>\r\n\r\n\r\n                    \r\n            </div>\r\n        </div>\r\n    \r\n    </div>\r\n    \r\n</div>\r\n</div>\r\n    <!-- #content-->\r\n</form>    \r\n\r\n</div>\r\n\r\n\r\n<footer id=\"footer\">\r\n\r\n    \t <div id=\"poweredby\">\r\n        <p class=\"loginpoweredby\">Powered by <img src=\"../images/csc.png\" width=\"25\" height=\"14\"></p>\r\n        </div>\r\n    \r\n    \r\n\r\n</footer>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	LoginResponse loginResponse = null;
	/* loginResponse = (LoginResponse) getServletConfig()
			.getServletContext().getAttribute("loginResponse"); */
	loginResponse = (LoginResponse)session
			.getAttribute(PortalConstants.LOGINRESPONSE_SESSION_KEY);
	String errorMessage = "";
	if(loginResponse != null){
		if(!loginResponse.isSuccessful()){
			//errorMessage = errorInfo.getErrorMessage();
			//errorMessage = "Login failed. Please check the Username and Password.";
			errorMessage = loginResponse.getErrorMessage();
			// safe initialization
			/* if(errorMessage == null){
				errorMessage = "";
			} */
		}
	}


            _bw.write(_wl_block2Bytes, _wl_block2);

                        if(!errorMessage.trim().equals("")){
                        
            _bw.write(_wl_block3Bytes, _wl_block3);
	
							out.println(errorMessage);
                        
            _bw.write(_wl_block4Bytes, _wl_block4);

                        }
                        
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
