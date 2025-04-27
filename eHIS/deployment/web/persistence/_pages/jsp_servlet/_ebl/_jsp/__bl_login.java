package jsp_servlet._ebl._jsp;

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

public final class __bl_login extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/bl_login.jsp", 1742819908857L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<head>\r\n\t<link href=\"../../eCommon/html/login.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"requiresActiveX=true\"/>\r\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\r\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\r\n\t<script src=\"../../eSM/js/login.js\" language=\"javascript\"></script>\r\n\r\n\t<script src=\"../../eCommon/js/jquery.js\" language=\"javascript\"></script> \r\n\t<script src=\"../../eCommon/js/logout.js\" language=\"javascript\"></script>\r\n\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\"javascript\"></script>\r\n\r\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\t\r\n\t\r\n\t<script>\r\n\tfunction loadFacilitiesForUser(){\r\n\t\tvar user_id = document.getElementById(\'user_id\');\r\n\t\t\r\n\t\tif(user_id.value != \"\"){\r\n\t\t\t$.ajax({\t\t\t\t\t\t\r\n\t\t\t\ttype:\'POST\',\r\n\t\t\t\turl:\"../jsp/BillingPasswrCheckAjax.jsp?user_id=\"+user_id.value+\"&called_from=facilityForUser\",\r\n\t\t\t\tasync:false,\r\n\t\t\t\tdataType:\"text\",\r\n\t\t\t\tsuccess : function(data){\r\n\t\t\t\t\tvar retValue= $.trim(data);\r\n\r\n\t\t\t\t\tvar cap_sep=retValue.split(\'^\')\r\n\t\t\t\t\tvar fc_value=cap_sep[0];\r\n\t\t\t\t\tvar fc_count=cap_sep[1];\r\n\t\t\t\t\t\r\n\t\t\t\t\tif(fc_count==\'0\'){\r\n\t\t\t\t\t\talert(\"APP-000096 NO Facilities Available.\");\r\n\t\t\t\t\t\tvar selectElement = document.getElementById(\"facilityID\");\r\n\t\t\t\t\t\tselectElement.innerHTML = \'\';\r\n\t\t\t\t\t\tselectElement.add(new Option(\' --Select--\', \'\'));\r\n\t\t\t\t\t\treturn false;\r\n\t\t\t\t\t}\r\n\t\t\t\t\telse{\r\n\t\t\t\t\t\tvar dol_facility=fc_value.split(\'$\');\r\n\t\t\t\t\t\tvar len=dol_facility.length;\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\tvar selectElement = document.getElementById(\"facilityID\");\r\n\t\t\t\t\t\tif(len > 0){\t\t\t\t\t\t\r\n\t\t\t\t\t\t\tselectElement.innerHTML = \'\';\r\n\t\t\t\t\t\t\tselectElement.add(new Option(\' --Select--\', \'\'));\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\tfor(var i=0;i<len;i++){\r\n\t\t\t\t\t\t\tvar split_fac=dol_facility[i].split(\'~\');\r\n\t\t\t\t\t\t\tvar fac_name  = split_fac[1];\r\n\t\t\t\t\t\t\tvar fac_id = split_fac[0];\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\tvar newOption = document.createElement(\"option\");\r\n\r\n\t\t\t\t\t\t\t// Set value and text content for the new option\r\n\t\t\t\t\t\t\tnewOption.value = fac_id;\r\n\t\t\t\t\t\t\tnewOption.textContent = fac_name;\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t//alert(fac_id+\"/\"+fac_name);\r\n\t\t\t\t\t\t\tselectElement.appendChild(newOption);\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t},\r\n\t\t\t\terror: function(data){\r\n\t\t\t\t}\r\n\t\t\t});\r\n\t\t\t\r\n\t\t}\r\n\t\telse{\r\n\t\t\treturn false;\r\n\t\t}\t\t\r\n\t}\r\nfunction check_user_password(){\r\n\tvar user_id = document.getElementById(\'user_id\');\r\n\tvar password = document.getElementById(\'password\');\r\n\tvar facilityID = document.getElementById(\'facilityID\');\r\n\tvar functionID = document.getElementById(\'functionID\');\r\n\tvar locale=document.getElementById(\'locale\');\r\n\tvar block = \"N\";\r\n\t//alert(\"user_id\"+user_id)\r\n\tif(user_id.value ==\'\'){\r\n\t\t\talert(\'APP-SM0019 User Id/Password Cannot be Blank\');\r\n\t\t\tuser_id.focus();\r\n\t\t\treturn false;\r\n\t}\r\n\t\r\n\tif(password.value == \'\'){\r\n\t\talert(\'APP-SM0007 Password Should be Entered\');\r\n\t\tpassword.focus();\r\n\t\treturn false;\r\n\t}\t\r\n\t\t\t\t\r\n\t$.ajax({\t\t\t\t\t\t\r\n\t\t\ttype:\'POST\',\r\n\t\t\turl:\"../jsp/BillingPasswrCheckAjax.jsp?user_id=\"+user_id.value+\"&password=\"+password.value+\"&called_from=authUser&facilityID=\"+facilityID.value,\r\n\t\t\tasync:false,\r\n\t\t\tdataType:\"text\",\r\n\t\t\tsuccess : function(data){\r\n\t\t\t\tvar retValue= $.trim(data);\r\n\r\n\t\t\t\tvar retArr = retValue.split(\":::\");\r\n\t\t\t\tif(retArr[0] == \'Y\')\r\n\t\t\t\t{\r\n\t\t\t\t\tif(facilityID.value == \'\'){\r\n\t\t\t\t\t\talert(\'APP-000094 Invalid Facility\');\r\n\t\t\t\t\t\tfacilityID.focus();\r\n\t\t\t\t\t\treturn false;\r\n\t\t\t\t\t}\r\n\t\t\t\t\t\r\n\t\t\t\t\t$.ajax({\t\t\t\t\t\t\r\n\t\t\t\t\t\ttype:\'POST\',\r\n\t\t\t\t\t\turl:\"../jsp/BillingPasswrCheckAjax.jsp?called_from=pageCalledYN\",\r\n\t\t\t\t\t\tasync:false,\r\n\t\t\t\t\t\tdataType:\"text\",\r\n\t\t\t\t\t\tsuccess : function(data){\r\n\t\t\t\t\t\t\t//alert(\"session set\");\r\n\t\t\t\t\t\t},\r\n\t\t\t\t\t\terror: function(data){\r\n\t\t\t\t\t\t\talert(\"session set failed!\");\r\n\t\t\t\t\t\t\tblock = \"Y\";\r\n\t\t\t\t\t\t\treturn false;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t});\r\n\t\t\t\t\tif(functionID.value == \'\'){\r\n\t\t\t\t\t\talert(\"BL00795 Invalid Function ID\");\r\n\t\t\t\t\t\tblock = \"Y\";\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif(block == \"N\") {\r\n\t\t\t\t\t\tvar popupURL = \"../../eBL/jsp/InvokeModifyFinDtls.jsp?facility_id=\"+facilityID.value+\"&responsibility_id=EBL_MANAGER&function_id=\"+functionID.value+\"&login_user=\"+user_id.value+\"&calledFrom=managePatientPopup&locale=\"+locale.value;\r\n\t\t\r\n\t\t\t\t\t\tvar  screenHeight=screen.height;\r\n\t\t\t\t\t\tvar  screenWidth=screen.width;\r\n\t\t\t\t\t\tvar features =\"location=0,height=\"+screenHeight+\",width=\"+screenWidth+\",top=0,left=0,resizable=yes,fullscreen=yes, location=no, toolbar=no\";\r\n\r\n\t\t\t\t\t\tvar newWindow = window.open(popupURL,\'eHIS\',features);\t\r\n\t\t\t\t\t\t//newWindow.opener = window;\r\n\t\t\t\t\t\tresetCredentials();\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\telse{\r\n\t\t\t\t\talert(\"APP-SM0040 Invalid User Name / Password\");\r\n\t\t\t\t\tblock = \"Y\";\r\n\t\t\t\t}\r\n\t\t\t},\r\n\t\t\terror: function(data){\r\n\t\t\t}\r\n\t\t});\r\n}\r\n\r\nfunction closeWindow() {\r\n    newWindow.postMessage(\'close\', \'*\');\r\n}\r\n\r\nfunction resetCredentials(){\r\n\tdocument.getElementById(\'user_id\').value = \"\";\r\n\tpassword = document.getElementById(\'password\').value = \"\"\r\n\t\r\n\tvar selectElement = document.getElementById(\"facilityID\");\r\n\tselectElement.innerHTML = \'\';\r\n\tselectElement.add(new Option(\' --Select--\', \'\'));\r\n\tdocument.getElementById(\'functionID\').value = \'\';\r\n}\r\n</script>\r\n\r\n</head>\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\r\n/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/\r\n\twindow.onbeforeunload = function (e) {\r\n\t\tif(document.getElementById(\'action\').value==\"logout\"){\r\n\t\t\tfnLogout(document.getElementById(\'login_user\').value);\r\n\t\t}\r\n\t}\r\n\t/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/\r\n\t</script>\r\n\r\n</head>\r\n<body class=\"main\" ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="onLoad=\"window.document.title=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';getLabels();Focusing(\'name\')\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="onLoad=\"loadResp();\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" scroll=\"no\" style=\"border:0px;\">\r\n\r\n\t\t <script Language=\"vbscript\">\r\n\t\t\tOn Error Resume next\r\n\t\t\tDim everyvisit\r\n\t\t\tDim ProxyEnable\r\n\t\t\tDim ProxyOverride\r\n\t\t\tDim url\r\n\t\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\r\n\r\n\t\t\teveryvisit = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\SyncMode5\")\r\n\t\t\tProxyEnable=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyEnable\")\r\n\t\t\tProxyOverride=WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ProxyOverride\")\r\n\t\t\t\t\t\r\n\t\t\turl=window.location.href \r\n\r\n\t\t\t\r\n\r\n\t\t\t\'Set WshShell33 = CreateObject(\"WScript.Shell\")\r\n\t\t\t\'WshShell33.SendKeys \"{F11}\"\r\n\t\t\r\n\t\t\tIf everyvisit <> 3  Then\r\n\t\t\t\tMsgBox \"Your browser setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator\"\r\n\t\t\t\twindow.opener=\"SOMETHING\"\r\n\t\t\t\tclose()\r\n\t\t\tEnd If\r\n\t\t\tIf ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" = 1 and ProxyEnable = 1 and InStr(ProxyOverride,\";<local>\") =0  Then\t\t\t\r\n\t\t\t\tMsgBox \"Your proxy setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator\"\r\n\t\t\t\twindow.opener=\"SOMETHING\"\r\n\t\t\t\tclose()\r\n\t\t\tEnd If\r\n\t </script> \r\n\r\n<form name=\"login_form\" id=\"login_form\" method=\"post\" action=\"../../servlet/eSM.LoginResponseServlet\"  >\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\r\n<div id=\"Maincontainer\">\t\t\r\n    <div id=\"Contentcontainer\" style=\"background-image:url(\'../../eCommon/images/LoginBg.jpg\')\">\r\n       \t<div id=\"Contentcontainerbg\" >\r\n       \t  <table align=\"center\" width=\"637px\" height=\"425px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"background-image:url(\'../../eCommon/images/LoginWidget_new2.png\')\">\r\n\t\t\t <tr>\t\r\n\t\t\t\t<td height=\"33\" colspan=\"2\" valign=\"top\" style=\"PADDING-TOP: 123px; PADDING-LEFT: 25px\">\r\n\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n\t\t\t\t\t\t<tr> \r\n\t\t\t\t\t\t\t<td align=\"center\" class=\"version\" style=\"padding-top:15px;\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\" style=\"padding-top: 45px;padding-right: 15px;\" align=\"right\">\r\n\t\t\t\t\t<br><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"97\" height=\"92\" /></br>\r\n\t\t\t\t\t<p class=\"heading\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</p>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"587\" valign=\"top\" style=\"padding-left:40px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\t  \r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td class=\"heading\" height=\"35px\" id=\"userNameID\" colspan=\"2\"><strong>User ID</strong></td><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t \r\n\t\t\t\t\t\t<td id=\"userNameTextID\" class=\"heading\" colspan=\"2\">\r\n\t\t\t\t\t\t\t<input name=\"name\" id = \"user_id\" style=\"padding-top:5px; padding-left:5px;\" type=\"text\" size=\"40\" maxlength=\"40\" height=\"30px\" onKeyPress=\"checkvisible();return CheckForSpecChars(event);checkuser_event(event)\" onBlur=\"loadFacilitiesForUser();\" onKeyDown=\"return noescUser()\" tabindex=\"1\"/ AUTOCOMPLETE=\"OFF\" class=\"inputH\" /><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td class=\"heading\" id=\"passwordID\" height=\"35px\" colspan=\"2\">Password </td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td id=\"passwordTextID\" colspan=\"2\">\r\n\t\t\t\t\t\t\t<span class=\"heading\">\r\n\t\t\t\t\t\t\t\t<input class=\"inputH\" style=\"padding-top:5px;padding-left:5px;\" id=\"password\" name=\"password\" type=\"password\" size=\"41\" maxlength=\"30\" \r\n\t\t\t\t\t\t\t\tonkeypress=\"login_enter_event(event)\" onKeyDown=\"return noescPassword()\" tabindex=\"2\"/><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td class=\"heading\"  height=\"35px\">Facility </td>\r\n\t\t\t\t\t\t<td class=\"heading\"  height=\"35px\">Function Name</td>\r\n\t\t\t\t\t</tr>\r\n\t\t  \r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td id=\"passwordTextID\">\r\n\t\t\t\t\t\t\t<span class=\"heading\">\r\n\t\t\t\t\t\t\t\t<select id=\"facilityID\" tabindex=\"3\">\r\n\t\t\t\t\t\t\t\t\t<option value=\'\'>--Select--</option>\r\n\t\t\t\t\t\r\n\r\n\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td id=\"passwordTextID\">\r\n\t\t\t\t\t\t\t<span class=\"heading\">\r\n\t\t\t\t\t\t\t\t<select id=\"functionID\" tabindex=\"3\">\r\n\t\t\t\t\t\t\t\t\t<option value=\'\'>--Select--</option>\r\n\t\t\t\t\t\t\t\t\t<option value=\"MOD_FIN_DTLS\">Modify Financial Details</option>\r\n\t\t\t\t\t\t\t\t\t<option value=\"PRICE_LIST\">Price List</option>\r\n\t\t\t\t\t\t\t\t\t<option value=\"ENC_TRF_CHARGES\">Review and Transfer Charges</option>\r\n\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>&nbsp;&nbsp; </td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  style=\"border-collapse: collapse;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"auto\" height=\"36px;\"><input type=\"button\" class=\"button\" id=\"loginID\" style=\"cursor:hand;\" tabindex=\"4\" onClick=\"check_user_password();\" onKeyPress=\"check_user_password_event(event)\" value=\"Login\" /></td>\r\n\t            \r\n\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>&nbsp;&nbsp; </td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"auto\"><input type=\"button\" class=\"button\" tabindex=\"5\" onClick=\"cancelbutton()\" onKeyPress=\"cancelbutton_event(event)\" id=\"cancelID\" style=\"cursor:hand;\"  value=\"Cancel\" /></td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table align=\"centre\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"errMSGID0\" style=\"display:none\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding-left:10px;\"><img src=\"../../eCommon/images/Alert.png\" /></img> \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\" ></span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t \r\n\t\t  <tr>\r\n\t\t\t<td align=\"right\" valign=\"top\" style=\"padding-right:10px;padding-bottom:5px\" class=\"heading\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\r\n\t\t  </tr>\r\n\t</div>\r\n\t</div>\r\n</div>    \t\r\n    \r\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\r\n\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" value=\"\">\r\n\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" value=\"\">\r\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"\">\r\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\r\n\t<input type=\"hidden\" name=\"dfltFacilityId\" id=\"dfltFacilityId\" value=\"\">\r\n\t<input type=\"hidden\" name=\"dfltFacilityIdName\" id=\"dfltFacilityIdName\" value=\"\">\r\n\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\"\">\r\n\t<input type=\"hidden\" name=\"level\" id=\"level\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\r\n\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" value=\"\">\t\t\t\r\n\t<input type=\"hidden\" name=\"user\" id=\"user\" value=\"\">\r\n\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"DHHCLH56YDB3\">\r\n\t<input type=\"hidden\" name=\"domain\" id=\"domain\" value=\"\">\r\n\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\r\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\r\n\t<input type=\"hidden\" name=\"everyvisit\" id=\"everyvisit\" value=\"\">\r\n\t<input type=\"hidden\" name=\"ProxyEnable\" id=\"ProxyEnable\" value=\"\">\r\n\t<input type=\"hidden\" name=\"ProxyOverride\" id=\"ProxyOverride\" value=\"\">\r\n\t<input type=\"hidden\" name=\"url\" id=\"url\" value=\"\">\r\n\t<input type=\"hidden\" name=\"proxy_check\" id=\"proxy_check\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\r\n\t<input type=\'hidden\' name=\'enforce_password_policy_yn\' id=\'enforce_password_policy_yn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\r\n\t<input type=\"hidden\" name=\"first_login_change_password_yn\" id=\"first_login_change_password_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\r\n\t<input type=\"hidden\" name=\"change_password_mandatory_yn\" id=\"change_password_mandatory_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\t\r\n\t<input type=\'hidden\' name=\'allowed_spl_char_in_password\' id=\'allowed_spl_char_in_password\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\r\n\t<input type=\"hidden\" name=\"case_sensitive_password_yn\" id=\"case_sensitive_password_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"><!---//Maheshwaran added for the MMS-QH-CRF-0149-->\r\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->\r\n\t<input type=\"hidden\" name=\"multiple_login_allowed_yn\" id=\"multiple_login_allowed_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> \r\n\t<input type=\'hidden\' name=\'action\' id=\'action\' value=\"\" />\r\n\t<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->\r\n\r\n\t<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\r\n\t<input type=\'hidden\' name=\'isSSOIntegrationAppl\' id=\'isSSOIntegrationAppl\' value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\r\n\t<input type=\'hidden\' name=\'login_user_type\' id=\'login_user_type\' value=\"\">\r\n\r\n</form>\r\n</body>\r\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t<script>\r\n\tFocusing(\'password\');\t\r\n\tlogin_form.password.focus();\r\n\t</script>\r\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\r\n\r\n\r\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	} 

 
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

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
	System.err.println("Locale= "+locale);  // en
	locale = (locale == null || locale.equals(""))?"en":locale;
	if(level.equals("1")){
		change_pass=request.getParameter( "change_pass" ) ;
		user_name_pass=request.getParameter( "user_name_pass" ) ;
		if(change_pass==null) change_pass="";
	}
	
	System.err.println("change_pass= "+change_pass);  //""
	System.err.println("user_name_pass= "+user_name_pass); //null
	
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

		 /*try
			{
				InetAddress addr;
				addr = InetAddress.getLocalHost();
				hostname = addr.getHostName();
			}
			catch (UnknownHostException ex)
			{
				out.println("Hostname can not be resolved");
			}
			*/


	}catch(Exception ex){
		out.println(ex.toString());
		ex.printStackTrace();
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block4Bytes, _wl_block4);
if(level.equals("1")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(product_name));
            _bw.write(_wl_block6Bytes, _wl_block6);
}else if(level.equals("2")){
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(proxy_check));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(level.equals("1")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(copyrights_dtls));
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
            out.print( String.valueOf(isSSOIntegrationAppl));
            _bw.write(_wl_block27Bytes, _wl_block27);

if(change_pass.equals("change_pass")){

            _bw.write(_wl_block28Bytes, _wl_block28);

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

            _bw.write(_wl_block29Bytes, _wl_block29);
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
