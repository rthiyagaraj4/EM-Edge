package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcashierreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCashierReport.jsp", 1729230539649L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n <base target=\"_self\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../js/BLAmount.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<!--  <Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script> -->\n<script language=\"javascript\" src=\"../../eCommon/js/showModalDialog.js\" ></script>\n\n\n\n\n<script>\n\tvar facility_id = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\n\tfunction disable(bool,err_mess)\n\t{\n\t\tif(err_mess==\"\")\n\t\t{\n\t\t\tif (bool == true)\n\t\t\t{\n\t\t\t\tvar process_label=getLabel(\"Common.processing.label\",\"common\");\n//\t\t\t\tdocument.forms[0].report_button.disabled =  true;\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+process_label;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n//\t\t\tdocument.forms[0].report_button.disabled =  false;\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+err_mess;\n\t\t}\n\t}\n\n\tfunction funSubmitReport()\n\t{\n\t\tvar operator_id = document.forms[0].operator_id.value;\n\t\tvar cashcounter_code = document.forms[0].cashcounter_code.value;\n\t\tvar login_time = document.forms[0].login_time.value;\n\t\tvar logout_time = document.forms[0].logout_time.value;\t\n\n\t\tvar log_rep_success_mes=getMessage(\"BL9323\",\"BL\");\n\t\tdocument.forms[0].log_rep_success_mes.value=log_rep_success_mes;\n\t\n\t\tif ((operator_id == null) || (operator_id==\'\') || (operator_id == \' \'))\n\t\t{\n\t\t\talert(getMessage(\"BL9784\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif ((cashcounter_code == null) || (cashcounter_code==\'\') || (cashcounter_code == \' \'))\n\t\t{\n\t\t\talert(getMessage(\"BL9538\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif ((login_time == null) || (login_time==\'\') || (login_time == \' \'))\n\t\t{\n\t\t\talert(getMessage(\"BL9785\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif ((logout_time == null) || (logout_time==\'\') || (logout_time == \' \'))\n\t\t{\n\t\t\treturn;\n\t\t}\n\t\tdocument.forms[0].submit();\n\t\tdisable(true);\n\t}\n\nasync function funOperator(clng_evnt)\n\t{\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( document.forms[0].operator_id.value == \"\")\n\t\t\t{\t\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\n\t\t/* var dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ; */\n\t\tvar dialogTop = \"10px\" ;\n\t\tvar dialogHeight= \"450px\" ;\n\t    var dialogWidth\t= \"700px\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\n//\t\tvar title=\"User Search\";\n\t\tvar title=getLabel(\"eBL.CASH_COUNTER_USER_SEARCH.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\n\n\t\tvar column_sizes = escape(\"100%,\");               \n//\t\tvar column_descriptions = escape(\"Cash Counter User,\"); \n\t\tvar cashcounteruser=getLabel(\"eBL.CASH_COUNTER_USER.label\",\"BL\");\n\t\tcashcounteruser=encodeURIComponent(cashcounteruser);\n\n\t\tvar column_descriptions = cashcounteruser+\",\"; \n\t\tvar sql = escape(\"select distinct CASH_COUNTER_USER_ID CNTR_USER \"+\n\t\t\t\t\t\" from bl_cash_counter_slmt_hdr where \"+\n\t\t\t\t\t\" OPERATING_FACILITY_ID = \'\"+facility_id+\"\' \"+\n\t\t\t\t\t\" AND LOGOUT_DATE_TIME IS NOT NULL \");\n\t\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].operator_id.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=Y\";\n\t\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\t\tvar arr=new Array();\n\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\n\t\t\t\tdocument.forms[0].operator_id.value = arr[0];\n\t\t\t}\n\t\t\telse\t\t\n\t\t\t{\n\t\t\t\tdocument.forms[0].operator_id.value = \'\';\n\t\t\t}\n\t\t}\n\t}\n\n\tasync function funCashCounter(clng_evnt)\n\t{\t\n\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( document.forms[0].cashcounter_code.value == \'\')\n\t\t\t{\t\n\t\t\t\tdocument.forms[0].cashcounter_code.value = \'\';\n\t\t\t\tdocument.getElementById(\"cashcounter_desc\").innerText= \'\';\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\n\t\t/* var dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\" ;\n\t\tvar dialogWidth\t\t\t= \"40\" ; */\n\t\tvar dialogTop = \"10px\" ;\n\t\tvar dialogHeight= \"500px\" ;\n\t    var dialogWidth\t= \"700px\" ;\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\n//\t\tvar title=\"Cash Counter Search\";\n\t\tvar title=getLabel(\"eBL.CASH_COUNTER_SEARCH.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\n\n\t\tvar column_sizes = escape(\"20%,80%\");               \n//\t\tvar column_descriptions = escape(\"Cash Counter Code,Description\"); \n\t\tvar cashcntrcode=getLabel(\"eBL.CASH_COUNTER_CODE.label\",\"BL\");\n\t\tcashcntrcode=encodeURIComponent(cashcntrcode);\n\t\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\t\tdesc=encodeURIComponent(desc);\n\n\t\tvar column_descriptions = cashcntrcode+\",\"+desc;\n\t\tvar locale=document.forms[0].locale.value;\n\t\tvar sql = escape(\"select cash_counter_code CNTR_CODE, \"+\n\t\t\t\" short_desc CNTR_DESC from bl_cash_counter_lang_vw where language_id=\'\"+locale+\"\' and \"+\n\t\t\t\" operating_facility_id =\'\"+facility_id+\"\'\");\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&target=\"+encodeURIComponent(document.forms[0].cashcounter_code.value)+\"&srch_by_clmn_index=2\"+\"&col_show_hide=YY\";\n\t\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\t\tvar arr=new Array();\n\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\'\')\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\n\t\t\t\tdocument.forms[0].cashcounter_code.value = arr[0];\n\t\t\t\tdocument.getElementById(\"cashcounter_desc\").innerText= arr[1];\n\t\t\t\tdocument.forms[0].login_time.value = \'\';\n\t\t\t\tdocument.forms[0].logout_time.value = \'\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].cashcounter_code.value = \'\';\n\t\t\t\tdocument.getElementById(\"cashcounter_desc\").innerText= \'\';\n\t\t\t}\n\t\t}\n\t}\n\nasync\tfunction funLogTime(clng_evnt)\n\t{\n\t\tif(clng_evnt == \'B\')\n\t\t{\n\t\t\tif( document.forms[0].login_time.value == \'\')\n\t\t\t{\t\n\t\t\t\tdocument.forms[0].login_time.value = \'\';\n\t\t\t\tdocument.forms[0].logout_time.value = \'\';\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\n\t\t/* var dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10\";\n\t\tvar dialogWidth\t\t\t= \"40\"; */\n\t\tvar dialogTop = \"10px\" ;\n\t\tvar dialogHeight= \"600px\" ;\n\t    var dialogWidth\t= \"900px\" ;\n\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar cashcounter_code\t= document.forms[0].cashcounter_code.value;\n\t\tvar operator_id = document.forms[0].operator_id.value;\n\t\tvar locale = document.forms[0].locale.value;\n\n\t\tif ((cashcounter_code == null) ||(cashcounter_code==\'\')|| (cashcounter_code ==\' \') )\n\t\t{\n\t\t\tcashcounter_code = \'\';\n\t\t}\n\t\tif ((operator_id == null) ||(operator_id==\'\')|| (operator_id==\' \') )\n\t\t{\n\t\t\toperator_id = \'\';\n\t\t}\n\n//\t\tvar title=\"Login Time Search\";\n\t\tvar title=getLabel(\"eBL.LOGIN_TIME_SEARCH.label\",\"BL\");\n\t\ttitle=encodeURIComponent(title);\n\n\t\tvar column_sizes = escape(\"35%,35%,10%,20%\");               \n\t//\tvar column_descriptions = escape(\"Login Time,Logout Time,Cash Counter,User\"); \n\t\tvar logintime=getLabel(\"eBL.LOGIN_TIME.label\",\"BL\");\n\t\tlogintime=encodeURIComponent(logintime);\n\t\tvar logouttime=getLabel(\"eBL.LOGOUT_TIME.label\",\"BL\");\n\t\tlogouttime=encodeURIComponent(logouttime);\n\t\tvar cashcntr=getLabel(\"eBL.CASH_COUNTER.label\",\"BL\");\n\t\tcashcntr=encodeURIComponent(cashcntr);\n\t\tvar user=getLabel(\"Common.user.label\",\"common\");\n\t\tuser=encodeURIComponent(user);\n\n\t\tvar column_descriptions =logintime+\",\"+logouttime+\",\"+cashcntr+\",\"+user; \n\t\tvar sql = escape(\"select to_date(TO_CHAR(login_date_time,\'DD/MM/YYYY HH24:MI:SS\'),\'DD/MM/YYYY HH24:MI:SS\') login_format_date,\"+\n\t\t\t\t\t\t \"    to_date(TO_CHAR(logout_date_time,\'DD/MM/YYYY HH24:MI:SS\'),\'DD/MM/YYYY HH24:MI:SS\') logout_format_date, \"+\n\t\t\t\t\t\t \" CASH_COUNTER_CODE CASH_COUNTER_ID, \"+\n\t\t\t\t\t     \" CASH_COUNTER_USER_ID USER_CODE \"+\n\t\t\t\t\t\t \" from bl_cash_counter_slmt_hdr where  \"+\n\t\t\t\t\t\t \" CASH_COUNTER_CODE like NVL(\'\"+cashcounter_code+\"\',CASH_COUNTER_CODE) AND \"+\n\t\t\t\t\t\t \" CASH_COUNTER_USER_ID like NVL(\'\"+operator_id+\"\',CASH_COUNTER_USER_ID) AND  \"+\n\t\t\t\t\t\t \" OPERATING_FACILITY_ID = \'\"+facility_id+\"\' \"+\n\t\t\t\t\t\t \" AND LOGOUT_DATE_TIME IS NOT NULL \");\n\n\t\t\n\t\tvar message = \'\';\n\t\tif (!(cashcounter_code == \'\'))\n\t\t{\n\t//\t\tmessage = escape(\"Cash Counter is Filtered for \"+cashcounter_code);\n\t\t\tmessage = getLabel(\"eBL.CASH_COUNTER_IS_FILTERED_FOR.label\",\"BL\")+\" \"+cashcounter_code;\n\t\t\tmessage = encodeURIComponent(message);\n\t\t}\n\t\t\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql+\"&\"+\"message=\"+message+\"&target=\"+encodeURIComponent(document.forms[0].login_time.value)+\"&srch_by_clmn_index=1\"+\"&col_show_hide=YYYY\";\n\t\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLLookupMain.jsp?\"+param,arguments,features);\n\t\tvar arr=new Array();\n\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"^~^\");\n\t\t\t\tdocument.forms[0].cashcounter_code.value = arr[2];\n\t\t\t\tdocument.forms[0].operator_id.value = arr[3];\n\t\t\t\tvar login_date_time = arr[0];\n\t\t\t\tvar logout_date_time = arr[1];\n\t\t\t\tif(locale !=\'en\')\n\t\t\t\t{\n\t\t\t\t\tlogin_date_time=convertDate(login_date_time,\'DMYHMS\',\'en\',locale);\n\t\t\t\t\tlogout_date_time=convertDate(logout_date_time,\'DMYHMS\',\'en\',locale);\n\t\t\t\t}\n\t\t\t\tdocument.forms[0].login_time.value = login_date_time;\n\t\t\t\tdocument.forms[0].logout_time.value = logout_date_time;\n\t\t\t\tdocument.getElementById(\"cashcounter_desc\").innerText= \'\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].login_time.value = \'\';\n\t\t\t\tdocument.forms[0].logout_time.value = \'\';\n\t\t\t}\n\t\t}\n\t}\n\n</script>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n\t<form name=\'report_form\' id=\'report_form\' action=\'../../servlet/eBL.BLCashierReportServlet\' method=\'post\' target=\'dummyFrame\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t\t<td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t    <td width=\"50%\" class=\"fields\">\n\t\t\t\t<input type=\'text\' name=\'operator_id\' id=\'operator_id\' size=\'20\' maxlength=\'50\' value=\'\' onBlur=\"funOperator(\'B\')\">\n\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funOperator(\'C\')\">\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td width=\"50%\" class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'cashcounter_code\' id=\'cashcounter_code\' size=\'30\' maxlength=\'40\' value=\'\' onBlur=\"funCashCounter(\'B\')\">\n\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funCashCounter(\'C\')\">\n\t\t\t\t<b id=\'cashcounter_desc\'></b>\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t    <td class=\"fields\" >\n\t\t\t\t<input type=\'text\' name=\'login_time\' id=\'login_time\' size=\'21\' maxlength=\'50\' value=\'\' onBlur=\"funLogTime(\'B\')\">\n\t\t\t\t<input type=\'button\' value=\'?\' class=\'button\' onClick=\"funLogTime(\'C\')\">\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t    <td width=\"50%\" class=\"fields\"  >\n\t\t\t\t<input type=\'text\' name=\'logout_time\' id=\'logout_time\' size=\'21\' maxlength=\'50\' value=\'\' readonly>\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td width=\"50%\" class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t    <td width=\"50%\" class=\"fields\" ><select name=\'report_option\' id=\'report_option\'>\n\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t</select>\n\t\t\t</td>\n\t</tr>\n<!--\n    <tr>\n\t    \t<td width=\"50%\"></td>\n\t\t\t<td width=\"50%\" class=\"fields\">\n\t\t\t<input type=\'button\' name=\'report_button\' id=\'report_button\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" class=\'button\' onClick=\'funSubmitReport()\'>\n\t\t\t</td>\n    </tr> \n-->\n\t<tr>\n\t\t\t<td width=\"50%\">&nbsp;</td>\n\t\t\t<td width=\"50%\">&nbsp;</td>\n\t</tr>\n</table>\n<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type= hidden name=\"log_rep_success_mes\" id=\"log_rep_success_mes\"  value=\'\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	HttpSession httpSession = request.getSession(false);

	String facility_id = "";	
	String locale			= (String)session.getAttribute("LOCALE");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		System.err.println("28,facility_id-->"+facility_id);
		//login_user =  p.getProperty("login_user");
	}
	catch(Exception eX)
	{
		out.println("Error= "+eX);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SUBMIT_REPORT.label","bl_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER_USER.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LOGIN_DATE_TIME.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LOGOUT_DATE_TIME.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Option.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
