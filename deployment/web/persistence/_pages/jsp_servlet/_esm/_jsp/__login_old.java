package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __login_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/login_OLD.jsp", 1710736887012L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<head>\n\t <link href=\"../../eCommon/html/login.css\" rel=\"stylesheet\" type=\"text/css\" /> \n\t<!-- <link href=\"../../eCommon/html/style.css\" rel=\"stylesheet\" type=\"text/css\" /> -->\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"requiresActiveX=true\"/>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eSM/js/login.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/logout.js\" language=\"javascript\"></script>\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/\n\twindow.onbeforeunload = function (e) {\n\t\tif(document.getElementById(\"action\").value==\"logout\"){\n\t\t\tfnLogout(document.getElementById(\'login_user\').value);\n\t\t}\n\t}\n\t/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/\n\t</script>\n\n</head>\n<body class=\"main\" ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="onLoad=\"window.document.title=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';getLabels();Focusing(\'name\')\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="onLoad=\"loadResp();\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" scroll=\"no\" style=\"border:0px;\">\n\n\t\t <script Language=\"vbscript\">\n\t\t\tOn Error Resume next\n\t\t\tDim everyvisit\n\t\t\tDim ProxyEnable\n\t\t\tDim ProxyOverride\n\t\t\tDim url\n\t\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\n\t\t\teveryvisit = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\SyncMode5\")\n\t\t\tProxyEnable=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyEnable\")\n\t\t\tProxyOverride=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyOverride\")\n\t\t\t\t\t\n\t\t\turl=window.location.href \n\t\t\n\t\t\tIf everyvisit <> 3  Then\n\t\t\t\tMsgBox \"Your browser setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator\"\n\t\t\t\twindow.opener=\"SOMETHING\"\n\t\t\t\tclose()\n\t\t\tEnd If\n\t\t\tIf ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" = 1 and ProxyEnable = 1 and InStr(ProxyOverride,\";<local>\") =0  Then\t\t\t\n\t\t\t\tMsgBox \"Your proxy setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator\"\n\t\t\t\twindow.opener=\"SOMETHING\"\n\t\t\t\tclose()\n\t\t\tEnd If\n\t </script>\n\n<form name=\"login_form\" id=\"login_form\" method=\"post\" action=\"../../servlet/eSM.LoginResponseServlet\"  >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<div id=\"Maincontainer\">\t\t\n    <div id=\"Contentcontainer\" style=\"background-image:url(\'../../eCommon/images/LoginBg.jpg\')\">\n       \t<div id=\"Contentcontainerbg\" >\n       \t  <table align=\"center\" width=\"637px\" height=\"425px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"background-image:url(\'../../eCommon/images/LoginWidget.png\')\">\n     <tr>\n    <td height=\"140\" colspan=\"2\" valign=\"bottom\">\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n      <tr>\n        <td  class=\"version\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n      </tr>\n      <tr>\n        <td style=\"padding-right:20px;\" align=\"right\" class=\"version\">&nbsp;</td>\n      </tr>\n    </table></td>\n  </tr>\n\n\t<tr>\n\t\t\t<td width=\"387\" valign=\"top\" style=\"padding-left:40px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr><td>&nbsp;</td>      </tr>\n     \n\t  <tr><td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"username\" id=\"displayUserID\" style=\"display:none\">\n\t\t\t\t\t\t\t\t\t\t\t</td><td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n      <tr>\n        <td class=\"heading\" height=\"35px\" id=\"userNameID\" >User ID</td>\n      </tr>\n\t\t<tr>\n        <td id=\"userNameTextID\" class=\"heading\">\n          <input name=\"name\" id=\"name\" style=\"padding-top:5px;\"  type=\"text\" size=\"46\" maxlength=\"40\" height=\"30px\" onkeypress=\"checkvisible();return CheckForSpecChars(event);checkuser_event(event)\" onblur=\"checkvisible()\" onkeydown=\"return noescUser()\" tabindex=\"1\"/ AUTOCOMPLETE=\"OFF\" class=\"inputH\" />\n       </td>\n      </tr>\n\t\t<tr>\n        <td class=\"heading\" id=\"passwordID\" height=\"35px\">Password </td>\n      </tr>\n      <tr>\n        <td id=\"passwordTextID\"><span class=\"heading\">\n          <input class=\"inputH\" style=\"padding-top:3px;\" name=\"password\" id=\"password\" type=\"password\" size=\"47\" maxlength=\"30\"  \n\t\t\t\t\t\t\t\t\t\t\t\tonkeypress=\"login_enter_event(event)\" onkeydown=\"return noescPassword()\" tabindex=\"2\"/>\n        </span></td>\n      </tr>\n\t   <tr>\n        <td>&nbsp;</td>\n      </tr>\n\t\t\t\n\n\n\n <tr>\n        <td><table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n          <tr>\n            <td><table  style=\"border-collapse: collapse;\">\n              <tr>\n\t\t\t  <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onclick=\"check_user_password();\" style=\"cursor:pointer\" /></td>\n                <td width=\"auto\" height=\"36px;\"><input type=\"button\" class=\"button\" id=\"loginID\" style=\"cursor:pointer; color:#FFFFFF;\" tabindex=\"3\" onclick=\"check_user_password();\" onkeypress=\"check_user_password_event(event)\" value=\"Login\" /></td>\n                <td><img src=\"../../eCommon/images/ButtonRight.PNG\" onclick=\"check_user_password();\" style=\"cursor:pointer\" /></td>\n              </tr>\n            </table></td>\n            <td>&nbsp;&nbsp; </td>\n            <td><table style=\"border-collapse: collapse;\">\n              <tr>\n                <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onclick=\"cancelbutton();\" style=\"cursor:pointer\" /></td>\n                <td width=\"auto\"><input type=\"button\" class=\"button\" tabindex=\"4\" onclick=\"cancelbutton()\" onkeypress=\"cancelbutton_event(event)\" id=\"cancelID\" style=\"cursor:pointer;color:#FFFFFF;\" value=\"Cancel\" /></td>\n                <td><img src=\"../../eCommon/images/ButtonRight.PNG\" width=\"8\" height=\"36\" style=\"cursor:pointer\" onclick=\"cancelbutton();\" /></td>\n              </tr>\n            </table></td>\n          </tr>\n        </table></td>\n      </tr>\n\n\t\t<tr>\n        <td>&nbsp;</td>\n      </tr>\n\t\t </table></td>\n    <td ><table width=\"250px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\n\n\t<tr>\n        <td align=\"left\"><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"57\" height=\"51\" valign=\"middle\" /></td>\n        <td width=\"90%\" class=\"heading\" ><span style=\"width:100px;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span></td>\n      </tr>\n\n\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr id=\"errMSGID0\" style=\"display:none\">\n        <td colspan=\"2\"><img src=\"../../eCommon/images/Alert.png\" /></img>\n\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\"></span></td>\n      </tr>\n\t\n\t\t\n\n  <tr >\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      </table></td>\n  </tr>\n  </table>\n</div>\n</div>\n</div>      \n       \t       \n\t\t\t\t\n\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n        \t\n    \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" value=\"\">\n\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"\">\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"dfltFacilityId\" id=\"dfltFacilityId\" value=\"\">\n\t<input type=\"hidden\" name=\"dfltFacilityIdName\" id=\"dfltFacilityIdName\" value=\"\">\n\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"level\" id=\"level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" value=\"\">\t\t\t\n\t<input type=\"hidden\" name=\"user\" id=\"user\" value=\"\">\n\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"\">\n\t<input type=\"hidden\" name=\"domain\" id=\"domain\" value=\"\">\n\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"everyvisit\" id=\"everyvisit\" value=\"\">\n\t<input type=\"hidden\" name=\"ProxyEnable\" id=\"ProxyEnable\" value=\"\">\n\t<input type=\"hidden\" name=\"ProxyOverride\" id=\"ProxyOverride\" value=\"\">\n\t<input type=\"hidden\" name=\"url\" id=\"url\" value=\"\">\n\t<input type=\"hidden\" name=\"proxy_check\" id=\"proxy_check\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\"hidden\" name=\"first_login_change_password_yn\" id=\"first_login_change_password_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"change_password_mandatory_yn\" id=\"change_password_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\t\n\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\"hidden\" name=\"case_sensitive_password_yn\" id=\"case_sensitive_password_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><!---//Maheshwaran added for the MMS-QH-CRF-0149-->\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->\n\t<input type=\"hidden\" name=\"multiple_login_allowed_yn\" id=\"multiple_login_allowed_yn\" id=\"multiple_login_allowed_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> \n\t<input type=\'hidden\' name=\'action\' id=\'action\' value=\"\" />\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->\n</form>\n</body>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<script>\n\tFocusing(\'password\');\t\n\tlogin_form.password.focus();\n\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\n<!-- added  on 7/2/2003 for ip/name-->\n<Script Language=\"VBScript\">\n\tDim objNet\n\tOn Error Resume Next\n    \n\tSet objNet = CreateObject(\"WScript.NetWork\") \n\t\n\tDim user\n\tDim compname\n\tDim domain\n\tSet TheForm = Document.forms(\"login_form\")\n\t\n\tTheForm.user.Value = objNet.UserName\n\tTheForm.compname.Value = objNet.ComputerName\n\tTheForm.domain.Value = objNet.UserDomain\n\t\'msgBox TheForm.user\n\n\tstrInfo = \"Your Logged User Name is: \" & TheForm.user.Value & vbCRLF & _\n\t\t\t\t\"Your PC Computer Name is: \" & TheForm.compname.Value & vbCRLF & _\n\t          \"Your Active Domain Name : \" & TheForm.domain.Value\n\t\n\n\n\tuser = objNet.UserName\n\tcompname = objNet.ComputerName\n\tdomain = objNet.UserDomain\n\n\tSet objNet = Nothing  \n\t\n\t\n\tDim everyvisitval\n\tDim ProxyEnableval\n\tDim ProxyOverrideval\n\tDim urlval\n\tSet WSHShell1 = CreateObject(\"WScript.Shell\")\n\n\teveryvisitval = WSHShell1.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\SyncMode5\")\n\tProxyEnableval=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyEnable\")\n\tProxyOverrideval=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyOverride\")\t\t\t\t\n\turlval=window.location.href \n\n\tSet TheForm1 = Document.forms(\"login_form\")\n\t\n\tTheForm1.everyvisit.Value = everyvisitval\n\tTheForm1.ProxyEnable.Value = ProxyEnableval\n\tTheForm1.ProxyOverride.Value = ProxyOverrideval\n\tTheForm1.url.Value = urlval\n</Script>\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
  
/* String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";*/
  
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con =null ;
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{

	request.setCharacterEncoding("UTF-8");

	
	String level				= request.getParameter( "level" ) ;
	String error_num			= request.getParameter( "error_num" ) ;
	if(error_num==null)
		error_num="0";
	String resp_count			= request.getParameter( "resp_count" ) ;
	int count_res=0;
	String checklogin			= request.getParameter( "invalidlogin" ) ;
	String name 				= (String) session.getValue( "login_user" ) ;
	String login_user 			= (String) session.getValue( "login_user" ) ;
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String responsibility_name	= (String) session.getValue( "responsibility_name" ) ;
	String has_resp	= request.getParameter( "resp" ) ;

	Properties p;
	String userName="";
	if(has_resp==null)
		has_resp="";
	String locale = null;
	String mode="begin";
	String change_pass="";
	String user_name_pass="";

	if ( level 			== null ) level 			= "" ;
	if ( checklogin 	== null ) checklogin 			= "N" ;
	if ( name 			== null ) name 			= "" ;
	if ( responsibility_id 	== null ) responsibility_id	= "" ;
	if ( responsibility_name== null ) responsibility_name = "" ;
	
	if ( level.equals( "" ) ) {
		level = "1" ;
	}
	locale = (String)session.getValue("LOCALE");
	if(level.equals("1")){
		if(locale == null || locale.equals("")){
			Locale  lc = request.getLocale();
			locale= lc.toString().substring(0,2);
			session.putValue("LOCALE",locale);
		}
	}
	locale = (locale == null || locale.equals(""))?"en":locale;
	if(level.equals("1")){
	change_pass=request.getParameter( "change_pass" );
	user_name_pass=request.getParameter( "user_name_pass" );
	if(change_pass==null) change_pass="";
	}
	if ( level.equals( "2" ) ){
	 count_res=Integer.parseInt(resp_count);
	}
	if(level.equals("2")){
	p=( java.util.Properties ) session.getValue( "jdbc" ) ;
	userName=p.getProperty("appl_user_name");
	if(userName==null || userName.equals(""))
		userName="";
	}
	request.setCharacterEncoding("UTF-8");
	String product_name="";
	String product_description="";
	String version_info="";
	String copyright_info="";
	String site_name="";
	String proxy_check="0";
	String case_sensitive_password_yn="";//Maheshwaran added for the MMS-QH-CRF-0149
	String allowed_spl_char_in_password="";
	String enforce_password_policy_yn="";
	String first_login_change_password_yn="";//Added by Maheshwaran for AMs-CRF-0098
	String change_password_mandatory_yn="";//Added by Maheshwaran for AMs-CRF-0098
	String multiple_login_allowed_yn	= "";//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
	try{
		//Maheshwaran modified for the MMS-QH-CRF-0149
		//Modified By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,(select count(*) from sm_function_control x,sm_site_param y where module_id='SM' and FUNCTIONALITY_ID='CHECK_PROXY'        and x.site_id=y.customer_id) proxy_check,b.case_sensitive_password_yn,b.allowed_spl_char_in_password,b.enforce_password_policy_yn,b.first_login_change_password_yn,b.change_password_mandatory_yn,b.multiple_login_allowed_yn from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
		if(pstmt!=null)
			pstmt.close();
		pstmt=con.prepareStatement(inst_info) ;
		if(rs!=null)rs=null;
		rs=pstmt.executeQuery() ;
		if(rs!=null && rs.next()){
			product_name=rs.getString("PRODUCT_NAME");
			product_description=rs.getString("PRODUCT_DESCRIPTION");
			version_info=rs.getString("VERSION_NO");
			copyright_info=rs.getString("COPYRIGHT_INFO");
			site_name=rs.getString("SITE_NAME");
			proxy_check=rs.getString("proxy_check");
			case_sensitive_password_yn=rs.getString("case_sensitive_password_yn");//Maheshwaran added for the MMS-QH-CRF-0149
			allowed_spl_char_in_password=rs.getString("allowed_spl_char_in_password");//Maheshwaran added for the MMS-QH-CRF-0149
			enforce_password_policy_yn=rs.getString("enforce_password_policy_yn");//Maheshwaran added for the MMS-QH-CRF-0149
			first_login_change_password_yn=rs.getString("first_login_change_password_yn");//Added by Maheshwaran for AMs-CRF-0098
			change_password_mandatory_yn=rs.getString("change_password_mandatory_yn");//Added by Maheshwaran for AMs-CRF-0098
			multiple_login_allowed_yn	= rs.getString("multiple_login_allowed_yn");//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
			}
		if(version_info==null || version_info.equals(""))
		version_info="";
		if(copyright_info==null || copyright_info.equals(""))
			copyright_info="";
		session.setAttribute("version_no",version_info);
		session.setAttribute("product_description",product_description);
	}catch(Exception ex){
		ex.printStackTrace();
	}


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block5Bytes, _wl_block5);
if(level.equals("1")){
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(product_name));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(level.equals("2")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(proxy_check));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(level.equals("1")){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(level));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(error_num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(proxy_check));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(enforce_password_policy_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(first_login_change_password_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(change_password_mandatory_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(allowed_spl_char_in_password)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(case_sensitive_password_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multiple_login_allowed_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);

if(change_pass.equals("change_pass")){

            _bw.write(_wl_block27Bytes, _wl_block27);

}

} catch (Exception e ) {
	out.println(e);
	e.printStackTrace();
	}
finally {
if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
if (con!=null)
ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         com.iba.autocomplete.tags.IbaAutoCompleteSetupTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  com.iba.autocomplete.tags.IbaAutoCompleteSetupTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
