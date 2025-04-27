package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __catablogin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATabLogin.jsp", 1738424539837L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>Untitled Document</title>\n\n<link href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eCommon/html/login.css\" rel=\"stylesheet\" type=\"text/css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eCA/js/CATabLogin.js\" language=\"javascript\"></script>\n\t<script type=\"text/javascript\">\n\t\tvar contextPath = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t \n</head>\n\n<body>\n\n<form id=\'login_form\' name=\'login_form\' id=\'login_form\' method=\"post\" action=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/tablogin\" class=\"mform\">\n<div id=\"Maincontainer\">\t\t\n    <div id=\"Contentcontainer\" style=\"background-image:url(\'../../eCommon/images/LoginBg.jpg\')\">\n       \t<div id=\"Contentcontainerbg\" >\n       \t  <table align=\"center\" width=\"637px\" height=\"425px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"background-image:url(\'../../eCommon/images/LoginWidget.png\')\">\n     <tr>\n    <td height=\"140\" colspan=\"2\" valign=\"bottom\">\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n      <tr>\n        <td  class=\"version\">12.9.1</td>\n      </tr>\n      <tr>\n        <td style=\"padding-right:20px;\" align=\"right\" class=\"version\">&nbsp;</td>\n      </tr>\n    </table></td>\n  </tr>\n\n\t<tr>\n\t\t\t<td width=\"387\" valign=\"top\" style=\"padding-left:40px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr><td>&nbsp;</td>      </tr>\n     \n\t  <tr><td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"username\" id=\"displayUserID\" style=\"display:none\">\n\t\t\t\t\t\t\t\t\t\t\t</td><td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n      <tr>\n        <td class=\"heading\" height=\"35px\" id=\"userNameID\" >User ID</td>\n      </tr>\n\t\t<tr>\n        <td id=\"userNameTextID\" class=\"heading\">\n          <input name=\"name\" id=\"name\" style=\"padding-top:5px;\"  type=\"text\" size=\"46\" maxlength=\"40\" height=\"30px\" onkeypress=\"\" onblur=\"\" onkeydown=\"\" tabindex=\"1\"/ AUTOCOMPLETE=\"OFF\" class=\"inputH\" />\n       </td>\n      </tr>\n\t\t<tr>\n        <td class=\"heading\" id=\"passwordID\" height=\"35px\">Password </td>\n      </tr>\n      <tr>\n        <td id=\"passwordTextID\"><span class=\"heading\">\n          <input class=\"inputH\" style=\"padding-top:3px;\" name=\"password\" id=\"password\" type=\"password\" size=\"47\" maxlength=\"30\" onkeypress=\"\" onkeydown=\"\" tabindex=\"2\" autocomplete=\"off\" />  <!--41670 autocomplete=\"off\"-->\n        </span></td>\n      </tr>\n\t   <tr>\n        <td>&nbsp;</td>\n      </tr>\n <tr>\n        <td><table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n          <tr>\n            <td><table  style=\"border-collapse: collapse;\">\n              <tr>\n\t\t\t  <td width=\"8px\">&nbsp;</td>\n                <td width=\"auto\" height=\"36px;\">\n                \t<input type=\"button\" value=\"Login\" class=\"button\" style=\"cursor:pointer; color:#FFFFFF;\" tabindex=\"3\"  onclick=\"submit_user_pwd()\" />\n                </td>\n                <td>&nbsp</td>\n              </tr>\n            </table></td>\n            <td>&nbsp;&nbsp; </td>\n            <td><table style=\"border-collapse: collapse;\">\n              <tr>\n                <td width=\"8px\">&nbsp;</td>\n                <td width=\"auto\"><input type=\"button\" class=\"button\" tabindex=\"4\" onclick=\"\" onkeypress=\"\" id=\"cancelID\" style=\"cursor:pointer;color:#FFFFFF;\" value=\"Cancel\" /></td>\n                <td>&nbsp;</td>\n              </tr>\n            </table></td>\n          </tr>\n        </table></td>\n      </tr>\n\n\t\t<tr>\n        <td>&nbsp;</td>\n      </tr>\n\t\t </table></td>\n    <td ><table width=\"250px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\n\n\t<tr>\n        <td align=\"left\">Logo</td>\n        <td width=\"90%\" class=\"heading\" ><span style=\"width:100px;\">DXC</span></td>\n      </tr>\n\n\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr id=\"errMSGID0\" style=\"display:none\">\n        <td colspan=\"2\"><img src=\"../../eCommon/images/Alert.png\" /></img>\n\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\"></span></td>\n      </tr>\n  <tr >\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      </table></td>\n  </tr>\n  </table>\n</div>\n</div>\n</div>  \n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"begin\"/> \n\t\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" id=\"responsibility_id\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" id=\"responsibility_name\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"null\"/>\n\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" id=\"facility_name\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"level\" id=\"level\" id=\"level\" value=\"1\"/> \n\t\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" id=\"clientIP\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"user\" id=\"user\" id=\"user\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"TAB\" id=\"compname\"/> \n\t\t<input type=\"hidden\" name=\"domain\" id=\"domain\" id=\"domain\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" id=\"error_num\" value=\"0\"/> \n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"en\"/>\n\t\t<input type=\"hidden\" name=\"RespFaciList\" id=\"RespFaciList\" id=\"RespFaciList\" value=\"en\"/>   \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
15/03/2023		IN41670								15/03/2023								<Security>Privacy Violation: Autocomplete:AuthorizePinAccess.jsp
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
  String path = request.getContextPath(); 
  
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(path));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(path));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(path));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(path));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
