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
import eCommon.XSSRequestWrapper;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class __login extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/login.jsp", 1745479511006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<head>\n\t <link href=\"../../eCommon/html/login.css\" rel=\"stylesheet\" type=\"text/css\" /> \n\t<!-- <link href=\"../../eCommon/html/style.css\" rel=\"stylesheet\" type=\"text/css\" /> -->\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eSM/js/login.js\" language=\"javascript\"></script>\n\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script> \n\t<!--  --> \n\n\t<script src=\"../../eCommon/js/logout.js\" language=\"javascript\"></script>\n\t\n\t<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\t\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\n$(document).ready(function() {   \n\t/*\n\tvar documentModeStr = document.documentMode;\n\talert(\" Document mode : \"+documentModeStr);\n\t*/\n\t\n\tvar computerName = document.getElementById(\"compname\").value;\n\tvar ipAddress = document.getElementById(\"clientIP\").value;\n\t\n\tconsole.log(\" Login JSP 220 ComputerName : \"+computerName+\" IP Address : \"+ipAddress);\n\n\t/*\n\t$.getJSON(\"https://api.ipify.org?format=json\", function(data) {\n\t     \n\t    // Setting text of element P with id gfg\n\t    //$(\"#gfg\").html(data.ip);\n\t    \n\t    //alert(\"IP Address for Computer Name : \"+data.ip);\t\n\t    //document.getElementById(\"compname\").value = data.ip;\n\t    \n\t    document.getElementById(\"compname\").value = \"BLESSAN-HP\";\n\t});\n\t*/\n\t\n});\n\n\n\n/*\n\n*/\n\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/\n\twindow.onbeforeunload = function (e) {\n\t\tif(document.getElementById(\"action\").value==\"logout\"){\n\t\t\tfnLogout(document.getElementById(\'login_user\').value);\n\t\t}\n\t}\n\t/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/\n\t</script>\n\n</head>\n<body class=\"main\" ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="onLoad=\"window.document.title=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';getLabels();Focusing(\'name\')\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="onLoad=\"loadResp();\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" scroll=\"no\" style=\"border:0px;\">\n\n<form   name=\"login_form\" id=\"login_form\" method=\"post\" action=\"../../servlet/eSM.LoginResponseServlet\"  >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<div id=\"Maincontainer\">\t\t\n    <div id=\"Contentcontainer\" style=\"background-image:url(\'../../eCommon/images/LoginBg.jpg\')\">\n       \t<div id=\"Contentcontainerbg\" >\n       \t  <table align=\"center\" width=\"637px\" height=\"425px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"background-image:url(\'../../eCommon/images/LoginWidget.png\')\"><!--Modified height=425px as 418px by Suji Keerthi for PMG2021-COMN-CRF-0002 US001--><!--Modified height=418px as 425px by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n     \n\t \n\t\n\t <tr>\n\t <!--<td height=\"140\" colspan=\"2\" valign=\"bottom\">--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t<!-- Added by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t<td height=\"33\" colspan=\"2\" valign=\"top\" style=\"PADDING-TOP: 123px; PADDING-LEFT: 25px\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t  <tr> \n\t\t    <td align=\"center\" class=\"version\" style=\"padding-top:15px;\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td><!--Modified padding-top:15px; as padding-top:16px; by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t    </tr>\n    </table></td>\n\t\t<td colspan=\"2\" style=\"padding-top: 45px;padding-right: 15px;\" align=\"right\">\n\t\t\t<br><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"97\" height=\"92\" /></br>\n\t\t\t<p class=\"heading\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</p>\n\t\t</td>\n\t\t<!-- <tr>\n\t\t\t<td class=\"heading\" style=\"padding-top: 0px;padding-right: 15px;\" align=\"right\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t</tr>-->\n\n\t</tr>\n\t<!-- Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n   <!--Below Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n      <!--<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n      <tr>\n        <td  class=\"version\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n      </tr>\n      <tr>\n        <td style=\"padding-right:20px;\" align=\"right\" class=\"version\">&nbsp;</td>\n      </tr>\n    </table>-->\n\t<!--</td>\n\t</tr>--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n      <!--Below added by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t <!--<tr>\n\t\t<td height=\"33\" colspan=\"2\" valign=\"top\" style=\"padding-left:40px;\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t  <tr> \n\t\t    <td align=\"center\" class=\"version\" style=\"padding-top:15px;\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>--><!--Modified padding-top:15px; as padding-top:16px; by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t    <!--</tr>\n    </table></td>\n  </tr>--> \n  <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002--> \n\n\t<tr>\n\t<!--Modified width=\"387\" as width=\"587\" by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t<td width=\"587\" valign=\"top\" style=\"padding-left:40px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\n\t  \n\t    <tr>\n\t      <td class=\"heading\" height=\"35px\" id=\"userNameID\"><strong>User ID</strong></td><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t      </tr>\n\t    <tr>\n\t\t  <!--Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t      <td id=\"userNameTextID\" class=\"heading\">\n\t\t  <input name=\"name\" id=\"name\" style=\"padding-top:5px; padding-left:5px;\" type=\"text\" size=\"40\" maxlength=\"40\" height=\"30px\" onKeyPress=\"checkvisible();return CheckForSpecChars(event);checkuser_event(event)\" onBlur=\"checkvisible();";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="checkADAndEMUserYN(this);";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onKeyDown=\"return noescUser()\" tabindex=\"1\"/ AUTOCOMPLETE=\"OFF\" class=\"inputH\" /><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t      </td>\n\t      </tr>\n\t    <tr>\n\t      <td class=\"heading\" id=\"passwordID\" height=\"35px\">Password </td>\n\t      </tr>\n\t    <tr>\n\t      <td id=\"passwordTextID\"><span class=\"heading\">\n\t        <input class=\"inputH\" style=\"padding-top:5px;padding-left:5px;\" name=\"password\" id=\"password\" type=\"password\" size=\"41\" maxlength=\"30\" \n\t\t\tonkeypress=\"login_enter_event(event)\" onKeyDown=\"return noescPassword()\" tabindex=\"2\"/><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t        </span></td>\n\t      </tr>\n\t    <tr>\n\t      <td>&nbsp;</td>\n\t      </tr>\n\t    <tr>\n\t      <td><table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t        <tr>\n\t          <td><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  style=\"border-collapse: collapse;\"><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t            <tr>\n\t\t\t\t  <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->\n\t              <!--  <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onClick=\"check_user_password();\" style=\"cursor:pointer\" /></td>-->\n\t              <td width=\"auto\" height=\"36px;\"><input type=\"button\" class=\"button\" id=\"loginID\" style=\"cursor:pointer;\" tabindex=\"3\" onClick=\"check_user_password();\" onKeyPress=\"check_user_password_event(event)\" value=\"Login\" /></td>\n\t              <!--<td><img src=\"../../eCommon/images/ButtonRight.PNG\" onClick=\"check_user_password();\" style=\"cursor:pointer\" /></td>-->\n\t              </tr>\n\t            </table></td>\n\t          <td>&nbsp;&nbsp; </td>\n\t          <td><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;\"><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t            <tr>\n\t\t\t\t   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->\n\t              <!-- <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onClick=\"cancelbutton();\" style=\"cursor:pointer\" /></td>-->\n\t              <td width=\"auto\"><input type=\"button\" class=\"button\" tabindex=\"4\" onClick=\"cancelbutton()\" onKeyPress=\"cancelbutton_event(event)\" id=\"cancelID\" style=\"cursor:pointer;\"  value=\"Cancel\" /></td>\n\t              <!-- <td><img src=\"../../eCommon/images/ButtonRight.PNG\" width=\"8\" height=\"36\" style=\"cursor:pointer\" onClick=\"cancelbutton();\" /></td>-->\n\t\t\t\t  <!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t\t\t<td><table align=\"centre\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t\t\t\t<tr id=\"errMSGID0\" style=\"display:none\">\n\t\t\t\t\t<td style=\"padding-left:10px;\"><img src=\"../../eCommon/images/Alert.png\" /></img> \n\t\t\t\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\" ></span></td>\n\t\t\t\t\t<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t\t\t\t</tr>\n\t              </tr>\n\t            </table></td>\n\t          </tr>\n\t        </table></td>\n\t      </tr>\n\t    <tr>\n\t      <td>&nbsp;</td>\n\t      </tr>\n\t    </table></td>\n\t  <!--<td><table width=\"250px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">-->\n\t  <!--below code commented for PMG2022-COMN-CRF-0012 US001-->\n\t    <!--<tr>\n\t      <td align=\"left\"><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"57\" height=\"52\" valign=\"middle\" /></td>\n\t      <td width=\"90%\" class=\"heading\" style=\"padding-left:10px;\"><span style=\"width:100px;\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span></td>--><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t      \n\t      <!--</tr>-->\n\t    <!--<tr>\n\t      <td colspan=\"2\">&nbsp;</td>\n\t    </tr>-->\n\t    <!--<tr id=\"errMSGID0\" style=\"display:none\">\n\t      <td colspan=\"2\"><img src=\"../../eCommon/images/Alert.png\" /></img> \n\t\t  <span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\"></span></td>\n\t    </tr>\n\t    <tr>-->\n\t\t<!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t     <!-- <td colspan=\"2\">&nbsp;</td>\n\t    </tr>\n\t    <tr>\n\t      <td colspan=\"2\">&nbsp;</td>\n\t    </tr>-->\n\t   <!-- </table></td>-->\n\t   <!--<tr>\n\t  \t<td align=\"right\" valign=\"top\" style=\"padding-right:10px;padding-bottom:5px\" class=\"heading\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n      </tr>--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t  </tr>\n\t  <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n      </table>\n\t  <!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t  <tr>\n\t  \t<td align=\"right\" valign=\"top\" style=\"padding-right:10px;padding-bottom:5px\" class=\"heading\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n      </tr>\n\t  <!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n</div>\n</div>\n</div>      \n       \t       \n\t\t\t\t\n\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n        \t\n    \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" value=\"\">\n\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"\">\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"dfltFacilityId\" id=\"dfltFacilityId\" value=\"\">\n\t<input type=\"hidden\" name=\"dfltFacilityIdName\" id=\"dfltFacilityIdName\" value=\"\">\n\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\"\">\n\t<input type=\"hidden\" name=\"level\" id=\"level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\t\t\t\n\t<input type=\"hidden\" name=\"user\" id=\"user\" value=\"\">\n\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t<input type=\"hidden\" name=\"domain\" id=\"domain\" value=\"\">\n\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"everyvisit\" id=\"everyvisit\" value=\"\">\n\t<input type=\"hidden\" name=\"ProxyEnable\" id=\"ProxyEnable\" value=\"\">\n\t<input type=\"hidden\" name=\"ProxyOverride\" id=\"ProxyOverride\" value=\"\">\n\t<input type=\"hidden\" name=\"url\" id=\"url\" value=\"\">\n\t<input type=\"hidden\" name=\"proxy_check\" id=\"proxy_check\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<input type=\"hidden\" name=\"first_login_change_password_yn\" id=\"first_login_change_password_yn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"change_password_mandatory_yn\" id=\"change_password_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t\n\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\"hidden\" name=\"case_sensitive_password_yn\" id=\"case_sensitive_password_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"><!---//Maheshwaran added for the MMS-QH-CRF-0149-->\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->\n\t<input type=\"hidden\" name=\"multiple_login_allowed_yn\" id=\"multiple_login_allowed_yn\" id=\"multiple_login_allowed_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> \n\t<input type=\'hidden\' name=\'action\' id=\'action\' value=\"\" />\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->\n\n\t<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t<input type=\'hidden\' name=\'isSSOIntegrationAppl\' id=\'isSSOIntegrationAppl\' value=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t<input type=\'hidden\' name=\'login_user_type\' id=\'login_user_type\' value=\"\">\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<script>\n\tFocusing(\'password\');\t\n\tlogin_form.password.focus();\n\t</script>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
	
	String computerName = "", ipAddress = "";
	String serverName = "", serverIPAddress = "";
	 try {
        InetAddress address = InetAddress.getLocalHost();        
        serverName = address.getHostName();
        serverIPAddress = address.getHostAddress();
        
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } 
    
    try {
    	computerName = request.getParameter("computerName");
    	ipAddress = request.getParameter("ipAddress");
    	
    	if (computerName == null)
    		computerName = serverName;
    	
    	if (ipAddress == null)
    		ipAddress = serverIPAddress;
    	
    } catch (Exception e) {
        e.printStackTrace();
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

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
    boolean isSSOIntegrationAppl = false;

	try{

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");

	
	String level			= request.getParameter( "level" ) ;
	String error_num			= request.getParameter( "error_num" ) ;
	if(error_num==null)
		error_num="0";
	String resp_count			= request.getParameter( "resp_count" ) ;
	int count_res=0;
	String checklogin		= request.getParameter( "invalidlogin" ) ;
	String name 			= (String) session.getValue( "login_user" ) ;
	String login_user 			= (String) session.getValue( "login_user" ) ;
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String responsibility_name	= (String) session.getValue( "responsibility_name" ) ;
	String has_resp	= request.getParameter( "resp" ) ;
	
	System.err.println("Level= "+level); //null
	System.err.println("resp_count= "+resp_count); //null
	System.err.println("checklogin= "+checklogin); //null
	System.err.println("name= "+name); //null
	System.err.println("login_user"+login_user); //null
	System.err.println("responsibility_id= "+responsibility_id);  //OP
	System.err.println("responsibility_name= "+responsibility_name);  //undefined
	System.err.println("has_resp= "+has_resp); // null


	Properties p;
	String userName="";
	if(has_resp==null)
		has_resp="";
	String locale = null;
	String mode="begin";
	String change_pass="";
	String user_name_pass="";

	if ( level 			== null ) level 			= "" ;
	if ( checklogin 			== null ) checklogin 			= "N" ;
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
		change_pass=request.getParameter( "change_pass" ) ;
		user_name_pass=request.getParameter( "user_name_pass" ) ;
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
	String copyrights_dtls = "";//Added by Kamatchi S for PMG2021-COMN-CRF-0002
	try{
		//Maheshwaran modified for the MMS-QH-CRF-0149
		//Modified By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		//Modified by Kamatchi S for PMG2021-COMN-CRF-0002
		String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,(select count(*) from sm_function_control x,sm_site_param y where module_id='SM' and FUNCTIONALITY_ID='CHECK_PROXY'        and x.site_id=y.customer_id) proxy_check,b.case_sensitive_password_yn,b.allowed_spl_char_in_password,b.enforce_password_policy_yn,b.first_login_change_password_yn,b.change_password_mandatory_yn,b.multiple_login_allowed_yn,a.COPYRIGHTS_DTLS COPYRIGHTS_DTLS from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
		if(pstmt!=null)
			pstmt.close();
		pstmt=con.prepareStatement(inst_info);
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
			copyrights_dtls=rs.getString("COPYRIGHTS_DTLS");//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			}
		if(version_info==null || version_info.equals(""))
		version_info="";
		if(copyright_info==null || copyright_info.equals(""))
			copyright_info="";
		//Added by Kamatchi S for PMG2021-COMN-CRF-0002
		if(copyrights_dtls==null || copyrights_dtls.equals(""))
				copyrights_dtls="";

		session.setAttribute("version_no",version_info);
		session.setAttribute("product_description",product_description);
		session.setAttribute("copyrights_dtls",copyrights_dtls);//Added by Kamatchi S for PMG2021-COMN-CRF-0002
	}catch(Exception ex){
		out.println(ex.toString());
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
if(level.equals("1")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isSSOIntegrationAppl){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(copyrights_dtls));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(copyrights_dtls));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(level));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ipAddress));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(computerName));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(error_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(proxy_check));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(enforce_password_policy_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(first_login_change_password_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(change_password_mandatory_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(java.net.URLEncoder.encode(allowed_spl_char_in_password)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(case_sensitive_password_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(multiple_login_allowed_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(isSSOIntegrationAppl));
            _bw.write(_wl_block36Bytes, _wl_block36);

if(change_pass.equals("change_pass")){

            _bw.write(_wl_block37Bytes, _wl_block37);

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

            _bw.write(_wl_block38Bytes, _wl_block38);
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
