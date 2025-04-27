package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portal.common.response.ErrorInfo;
import portal.login.response.LoginResponse;

public final class __portalloginpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/PortalLoginPage.jsp", 1669269355906L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Insert title here</title>\r\n<link rel=\"stylesheet\" href=\"../css/Portal.css\" type=\"text/css\" />\r\n<script>\r\n  function Login()\r\n  {\r\n\t  var userName = document.getElementById(\"name\").value;\r\n\t  var pwd = document.getElementById(\"password\").value;\r\n\t  \r\n\t  if(userName == null || userName == \"\")\r\n\t\t  {\r\n\t\t    alert(\"Please Enter User Name\");\r\n\t\t    return false\r\n\t\t  }\r\n\t  \r\n\t  if(pwd == null || pwd == \"\")\r\n\t\t  {\r\n\t\t    alert(\"Please Enter Password\");\r\n\t\t    return false;\r\n\t\t  }\r\n\t return true; \r\n  }\r\n  \r\n  function showHomePage(){\r\n\t  var loginResult = Login();\r\n\t  if(loginResult == false){\r\n\t\t  return;\r\n\t  }else if(loginResult == true){\r\n\t\t  var formElement = document.getElementById(\"login_form\");\r\n\t\t  if(formElement){\r\n\t\t\t  var userName = document.getElementById(\"name\").value;\r\n\t\t\t  //formElement.action = \"../jsp/PatientPortalHome.jsp?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t\t  formElement.action = \"../../servlet/LoginServlet?patientId=\"+userName+\"&useWebService=Y\";\r\n\t\t\t  formElement.submit();\r\n\t\t  }\r\n\t  }\r\n\t  \r\n  }\r\n</script>\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\t<form id=\'login_form\' name=\'login_form\' method=\"post\" action=\"../../servlet/LoginServlet\">\r\n\t\t\t<div class=\"center\">\r\n\t\t\t\t<div class=\"login\" id=\"loginFrame\" style = \"display:block\">\r\n\t\t\t\t\t<div class=\"loginFieldsBg\">\r\n\t\t\t\t\t\t\t<input class=\"name\" id=\'name\' name=\'name\' type=\"text\" placeholder =\"Username\" /><br /> \r\n\t\t\t\t\t\t\t<input\r\n\t\t\t\t\t\t\t\tclass=\"password\" type=\'password\' id=\'password\' name=\'password\' placeholder =\"Password\" /><br />\r\n\t\t\t\t\t\t\t<table border=0 cellpadding=\"0\" width=\"320px\" cellspacing=\"0\" style=\"text-wrap:normal;word-wrap:break-word;\">\t\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td style=\"text-wrap:normal;word-wrap:break-word;\">\r\n\t\t\t\t\t\t\t\t\t\t<span style=\"color:#dd0000;text-wrap:normal;word-wrap:break-word;\">\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</span>\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\t\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t<input\r\n\t\t\t\t\t\t\t\ttype=\"submit\" value=\"Login\" class=\"loginID\" onclick = \"Login()\" data-inline=\"true\"/> \r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\t\t\r\n\t\t  </div>\r\n\t</form>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	LoginResponse loginResponse = (LoginResponse) getServletConfig()
			.getServletContext().getAttribute("loginResponse");
	String errorMessage = "";
	if(loginResponse != null){
		ErrorInfo errorInfo = loginResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		if(ErrorInfo.SUCCESS_CODE != errorCode){
			//errorMessage = errorInfo.getErrorMessage();
			errorMessage = "Login failed. Please check the Username and Password";
			// safe initialization
			/* if(errorMessage == null){
				errorMessage = "";
			} */
		}
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
 if(!errorMessage.trim().equals("")){
											out.println(errorMessage);
										}
										
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
