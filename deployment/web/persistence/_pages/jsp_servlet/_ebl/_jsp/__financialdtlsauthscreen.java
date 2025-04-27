package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.jaxen.util.FollowingAxisIterator;
import eCommon.XSSRequestWrapper;
import eBL.*;

public final class __financialdtlsauthscreen extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/FinancialDtlsAuthScreen.jsp", 1719296526000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="    \r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Financial Modification Authorization</title>\r\n\r\n    <link rel=\'StyleSheet\' href=\'../../eCommon/html/IeStyle_new.css\' type=\'text/css\'/>\r\n    <script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\r\n    <script language=\'javascript\' src=\'../../eBL/js/BLModifyFinancialDetails.js\'></script>\r\n    <style type=\"text/css\">\r\n        .authContainer {\r\n            background-color: #F7F7F7;\r\n            width: 100%;\r\n            height: 100%;\r\n            display: flex;\r\n            flex-direction: column;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding: 5px; /* Add padding to the container */\r\n            box-sizing: border-box; /* Ensure padding is included in the element\'s total width and height */\r\n        }\r\n        .auth-headercontainer {\r\n            background-color: #00A0DD;\r\n            width: 100%;\r\n            max-width: 525px; /* Increased width by 5% */\r\n            height: 110%; /* Increase height by 10% */\r\n            border-radius: 3%;\r\n            display: flex;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding: 1%;\r\n            margin-bottom: 1%;\r\n            box-sizing: border-box; /* Ensure padding is included in the element\'s total width and height */\r\n        }\r\n        .auth-subcontainer {\r\n            background-color: white;\r\n            width: 100%;\r\n            max-width: 525px; /* Increased width by 5% */\r\n            border-radius: 2%;\r\n            padding: 5px; /* Add padding inside the container */\r\n            margin-bottom: .5rem; /* Add margin for spacing */\r\n            box-sizing: border-box; /* Ensure padding is included in the element\'s total width and height */\r\n        }\r\n        .auth-title {\r\n            text-align: left;\r\n            font: normal normal bold 20px Segoe UI; /* Increased font size */\r\n            color: white;\r\n            margin: 2%;\r\n            flex: 1;\r\n            white-space: nowrap; /* Ensure text stays on one line */\r\n        }\r\n        .input-wrapper {\r\n            margin-bottom: 0.2rem; /* Reduced margin for spacing */\r\n        }\r\n        .inputsmallContainer {\r\n            display: flex;\r\n            flex-direction: column;\r\n        }\r\n        .label-select {\r\n            margin-bottom: 0.5rem;\r\n        }\r\n        .input {\r\n            padding: 0.5rem; /* Add padding inside input box */\r\n            margin-top: 0.5rem; /* Add margin above input box */\r\n            box-sizing: border-box; /* Ensure padding is included in the element\'s total width and height */\r\n        }\r\n        .button_container {\r\n            background-color: white;\r\n            height: fit-content;\r\n            display: flex;\r\n            justify-content: flex-end;\r\n            gap: 10px;\r\n            width: 100%;\r\n            max-width: 525px; /* Increased width by 5% */\r\n        }\r\n    </style>\r\n\t<script>\r\n\t\twindow.onload = function() {\r\n            const inputElement = document.getElementById(\'user_id\');\r\n            inputElement.addEventListener(\'keydown\', makeUpperCase);\r\n        };\r\n\t\t\r\n\t\tfunction makeUpperCase(event) {\r\n            const inputElement = event.target;\r\n            const char = String.fromCharCode(event.keyCode);\r\n\r\n            // Check if the character is a lowercase letter\r\n            if (char >= \'a\' && char <= \'z\') {\r\n                const uppercaseChar = char.toUpperCase();\r\n                \r\n                // Prevent the default lowercase character from being inserted\r\n                event.preventDefault();\r\n\r\n                // Insert the uppercase character\r\n                const start = inputElement.selectionStart;\r\n                const end = inputElement.selectionEnd;\r\n                inputElement.value = inputElement.value.substring(0, start) + uppercaseChar + inputElement.value.substring(end);\r\n\r\n                // Move the cursor position\r\n                inputElement.setSelectionRange(start + 1, start + 1);\r\n            }\r\n        }\r\n\t</script>\r\n</head>\r\n<body>\r\n <div class=\"authContainer\">\r\n    <div id=\"headerDiv\" class=\"auth-headercontainer\">\r\n        <div class=\"auth-title\">&nbsp;Financial Modification Authorization&nbsp;</div>\r\n    </div>\r\n    <div id=\"userid\" class=\'auth-subcontainer\'>\r\n        <div class=\'input-wrapper inputsmallContainer\'>\r\n            <label class=\"label-select\">User ID</label>\r\n            <input type=\"text\" class=\"input\" id=\"user_id\" autocomplete=\"off\" autofocus onKeyPress=\'return makeUpperCase(event)\' onblur=\"if(this.value != \'\'){validateUserId(this);}\">\r\n        </div>\r\n    </div>\r\n    <div id=\"password\" class=\'auth-subcontainer\'>\r\n        <div class=\'input-wrapper inputsmallContainer\'>\r\n            <label class=\"label-select\">Pin No.</label>\r\n            <input type=\"password\" class=\"input\" id=\"passwrd\" autocomplete=\"off\" onblur=\"if(this.value != \'\'){validatePassword(this);}\">\r\n        </div>\r\n    </div>\r\n    <div id=\"remarks\" class=\'auth-subcontainer\'>\r\n        <div class=\'input-wrapper inputsmallContainer\'>\r\n            <label class=\"label-select\">Remarks</label>\r\n            <input type=\"text\" class=\"input\" id=\"remark\" autocomplete=\"off\">\r\n        </div>\r\n    </div>\r\n    <div class=\"button_container\">\r\n        <input type=\"button\" class=\"btn btn-primary\" value=\"OK\" onclick=\"isValidUser();\">\r\n        <input type=\"button\" class=\"btn btn-primary\" value=\"Cancel\" onClick=\"closeAuthPopup();\">\r\n    </div>\r\n </div>\r\n \t<input type=\'hidden\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'> \r\n \t<input type=\'hidden\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patientid=request.getParameter("patientid");
	String facility_id=request.getParameter("facility_id");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
