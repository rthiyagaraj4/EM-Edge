package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ohdentalcharttoolheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDentalChartToolHeader.jsp", 1709119348114L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t\t<script type=\'text/javascript\' src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<script>\n\t\t\tfunction onMouseClickOfImage(imgId){\n\t\t\t}\n\n\t\t\tfunction assignDBValue(tooth_numbering_system,locale){\n\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\tif(formObj.baseline_chart_yn.value != \"Y\"){\n\t\t\t\t\tvar cur_date = getCurrentDate(\"DMY\",\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\")\n\t\t\t\t\tformObj.asOnDate.value = cur_date;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction changeNumberingSystem(){ // This function is to rebuild the query without tooth_numbering_system parameter...\n\t\t\t\tvar formObj = document.forms[0];\n\n\t\t\t\tvar str = \"\";\n\t\t\t\tvar main_tab = \"\";\n\t\t\t\tvar numbering_system = formObj.numbering_system.value; // OnChange parameter\n\t\t\t\tvar tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..\n\t\t\t\tvar asOnDate = formObj.asOnDate.value;\n\t\t\t\tvar params_hid = formObj.params.value;\n\t\t\t\tvar baseline_chart_yn = formObj.baseline_chart_yn.value;\n\t\t\t\tvar operating_facility_id_1 = formObj.operating_facility_id_1.value;//Added by Sridevi Joshi on 6/1/2010 for IN021653\n\n\t\t\t\t//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)\n\t\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\t\t//\n\t\t\t\tparent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"\";\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\n\t\t\t\t//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)\n\t\t\t\t//xmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=selectUserPrefferences&\"+params,false);\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=selectUserPrefferences&\"+params+\"&oh_chart_level=\"+oh_chart_level,false);\n\t\t\t\t//\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar retVal=localTrimString(retVal);\n\t\t\t\tif(retVal.length > 1){\n\t\t\t\t\tretVal_arr = retVal.split(\"##\");\n\t\t\t\t\tif(retVal_arr[0] == \"\" && (tooth_numbering_system == null || tooth_numbering_system == \"null\")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table\n\t\t\t\t\t\ttooth_numbering_system = retVal_arr[1];\n\t\t\t\t\t\tformObj.tooth_numbering_system.value = retVal_arr[1];\n\t\t\t\t\t\tformObj.numbering_system.value = retVal_arr[1];\n\t\t\t\t\t}\n\t\t\t\t\telse if(retVal_arr[0] != \"\" && (tooth_numbering_system == null || tooth_numbering_system == \"null\")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table\n\t\t\t\t\t\ttooth_numbering_system = retVal_arr[0];\n\t\t\t\t\t\tformObj.tooth_numbering_system.value = retVal_arr[0];\n\t\t\t\t\t\tformObj.numbering_system.value = retVal_arr[0];\n\t\t\t\t\t}\n\t\t\t\t\telse{ // Loding page when you click on the refresh button and tooth_numbering_system is not null\n\t\t\t\t\t\tif(tooth_numbering_system != numbering_system){\n\t\t\t\t\t\t\tvar copy_as_defult  = confirm(getMessage(\"APP-OH00032\",\"OH\"))\n\t\t\t\t\t\t\tif(copy_as_defult){ // If you want to set this numbering system as default numbering system\n\n\t\t\t\t\t\t\t\t// Insert a record in to OH_USER_PREFERENCES table\n\t\t\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\t\t\tvar params = \"tooth_numbering_system=\"+numbering_system;\n\t\t\t\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=updateUserPrefferences&\"+params,false);\n\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\tvar retVal=localTrimString(retVal);\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\tif(retVal != 0){\n\t\t\t\t\t\t\t\t\tformObj.tooth_numbering_system.value = numbering_system;\n\t\t\t\t\t\t\t\t\ttooth_numbering_system = numbering_system;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{ //If you dont want to set this numbering system as default numbering system\n\t\t\t\t\t\t\t\tformObj.tooth_numbering_system.value = numbering_system;\n\t\t\t\t\t\t\t\ttooth_numbering_system = numbering_system;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//Added by Sharon Crasta on 1/19/2010 for IN018302\n\t\t\t\t//If the ASonDate field is made blank, then it should be populated with the Sysdate on click of refresh\n\t\t\t\tif(asOnDate == \"\"){\n\t\t\t\t   var sys_date = new Date();\n\t\t\t\t   var month = sys_date.getMonth();\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t   var year = sys_date.getFullYear();\n\t\t\t\t   var date = sys_date.getDate();\n\t\t\t\t   month = (month < 9) ? (\"0\" + (1+month)) : (1+month);\n\t\t\t\t   date = (date <= 9) ? (\"0\" + date) : date;\n\t\t\t\t   asOnDate = date+\"/\"+month+\"/\"+year;\n\t\t\t\t   document.getElementById(\"asOnDate\").value = asOnDate; \n\t\t\t\t}\n\t\t\t\t//Added by Sharon Crasta on 4/8/2010 for IN020567\n\t\t\t\t//If asOnDate is given as a date for whihc no chart exists then, the message no chart exists should be given.\n\t\t\t\telse{\n\t\t\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\t\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&asOnDate=\"+asOnDate+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=checkChartExists&\"+params,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\tretVal = localTrimString(retVal);\n\t\t\t\t\tif(retVal.length == 0){\n\t\t\t\t\t\t//alert(\"No Chart exists for the given date\");\n\t\t\t\t\t\talert(getMessage(\"APP-OH000183\",\"OH\"));\n\t\t\t\t\t\tvar sys_date = new Date();\n\t\t\t\t\t    var month = sys_date.getMonth();\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t    var year = sys_date.getFullYear();\n\t\t\t\t\t    var date = sys_date.getDate();\n\n\t\t\t\t\t    month = (month < 9) ? (\"0\" + (1+month)) : (1+month);\n\t\t\t\t\t\tdate = (date <= 9) ? (\"0\" + (date)) : date;\n\t\t\t\t\t    asOnDate = date+\"/\"+month+\"/\"+year;\n\t\t\t\t\t    document.getElementById(\"asOnDate\").value = asOnDate;\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t} \n\t\t\t\t//End\n\t\t\t\t// This is to validate the as on date field\n\t\t\t\tif(!checkDateNotGraterThanSysDate(formObj.asOnDate)){\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(parent.frames[1].Treatment != null && parent.frames[1].Treatment != \"null\" && parent.frames[1].Treatment != \"undefined\" && parent.frames[1].Treatment != undefined){\n\t\t\t\t\tif(parent.frames[1].Treatment.className == \"tabClicked\"){\n\t\t\t\t\t\tmain_tab = \"Treatment\";\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tmain_tab = \"Condition\";\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t\t//Added to display the print image icon only when Treatment tab is clicked.\n\t\t\t\telse{\n\t\t\t\t\t\tmain_tab = \"Condition\";\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t//Commented and added by Sharon Crasta on 11/20/2009 for IN016476\n\t\t\t\t//Was gettign a script error when clicking on the refresh icon.\n\t\t\t\t/*if(main_tab == \"Condition\"){\n\t\t\t\t\tdocument.getElementById(\"print_img\").style.visibility=\'hidden\';\n\t\t\t\t}*/\n\t\t\t\tvar chart_num_print = formObj.chart_num_for_print.value;\n\t\t\t\tif(chart_num_print != \"\" && chart_num_print != \"null\" && chart_num_print != null && chart_num_print != \"undefined\" && chart_num_print != undefined){\n\t\t\t\t\tif(main_tab == \"Treatment\"){\n\t\t\t\t\t\tdocument.getElementById(\"print_img\").style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//End\n\n\t\t\t\tvar params_str = formObj.params.value;\n\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\tvar chart_flag = formObj.chart_flag.value;\n\n\t\t\t\t//alert(oh_chart_level);\n\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"numbering_system=\"+tooth_numbering_system+\"&patient_id=\"+patient_id+\"&chart_flag=\"+chart_flag+\"&oh_chart_level=\"+oh_chart_level;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"buildOHParameters.jsp?func_mode=buildOHParameters&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700\n\t\t\t\t/*var retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar ret_params=localTrimString(retVal);\t  */\n\t\t\t\tvar retVal_print_params=localTrimString(xmlHttp.responseText);\n\t\t\t\tvar retVal_arr = retVal_print_params.split(\"~~\");\n\t\t\t\tvar ret_params=retVal_arr[0];\n\t\t\t\tvar code_desc_arr = retVal_arr[1].split(\"##\");\n\n\t\t\t\tformObj.upper_arch_desc.value = code_desc_arr[1];\n\t\t\t\tformObj.lower_arch_desc.value = code_desc_arr[2];\n\t\t\t\tformObj.Q1_id.value = code_desc_arr[3];\n\t\t\t\tformObj.Q2_id.value = code_desc_arr[4];\n\t\t\t\tformObj.Q3_id.value = code_desc_arr[5];\n\t\t\t\tformObj.Q4_id.value = code_desc_arr[6];\n\t\t\t\tformObj.Q1_desc.value = code_desc_arr[7];\n\t\t\t\tformObj.Q2_desc.value = code_desc_arr[8];\n\t\t\t\tformObj.Q3_desc.value = code_desc_arr[9];\n\t\t\t\tformObj.Q4_desc.value = code_desc_arr[10];\n\t\t\t\tformObj.permanent_deciduous_flag.value = code_desc_arr[11];\n\t\t\t\tformObj.mixed_dentition_YN.value = code_desc_arr[12];\n\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar query_params = \"asOnDate=\"+asOnDate;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t//Commented and Added by Sharon Crasta on 1/19/2010 for IN018302\n\t\t\t\t// If the AsOnDate was changed to a lesser value than the sysdate then recordings were being allowed. \n\t\t\t\t//Done to disable the chart.\n\t\t\t\t//xmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=getCountOfCharts&\"+query_params,false);\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=getDiffDate&\"+query_params,false);\n\t\t\t\t//End\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar date_diff_flag=localTrimString(retVal);\n\t\t\t\t//End\n\n\t\t\t\t//Added by sridevi Joshi on 6/1/2010 for IN021668\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar query_params = \"asOnDate=\"+asOnDate+\"&patient_id=\"+patient_id;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=getClosedCharNum&\"+query_params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar date_diff_chart_num=localTrimString(retVal);\n\n\t\t\t\tvar chart_num_lebel = getLabel(\"eOH.Chart.Label\",\"OH\");\n\n\t\t\t\tif(oh_chart_level == \"E\"){\n\t\t\t\t\tchart_num_lebel = chart_num_lebel+\" \"+date_diff_chart_num+\"(\"+operating_facility_id_1+\")\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tchart_num_lebel = chart_num_lebel+\" \"+date_diff_chart_num+\"(\"+other_chart_facility_id+\")\";\n\t\t\t\t}\n\n\t\t\t\t//if(date_diff_flag == \"disable\"){\n\t\t\t\t\tdocument.getElementById(\"chart_identity\").innerHTML = chart_num_lebel;//Added by sridevi Joshi on 6/1/2010 for IN021668\n\t\t\t\t//}\n\n\t\t\t\tparams=ret_params+\"&\"+params_str+\"&main_tab=\"+main_tab+\"&date_diff_flag=\"+date_diff_flag+\"&baseline_chart_yn=\"+baseline_chart_yn+\"&date_diff_chart_num=\"+date_diff_chart_num; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.\t\n\n\t\n\t\t\t\tif(main_tab == \"Treatment\"){\n\t\t\t\t\t//parent.frames[2].location.href=\"../../eOH/jsp/OHTrmtDentalChartFrame.jsp?\"+par";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="ams;\n\t\t\t\t\tparent.frames[2].location.href=\"../../eOH/jsp/OHTrmtDentalChartFrame.jsp?\"+params;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tparent.frames[2].location.href=\"../../eOH/jsp/OHCondDentalChartFrame.jsp?\"+params;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t\n\t\t\tfunction localTrimString(sInString) {\n\t\t\t\tsInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n\t\t\t\treturn sInString.replace( /\\s+$/g, \"\" );// strip trailing\n\t\t\t}\n\n\t\t\tfunction printOverview(){\n\n\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\t//var chart_num = formObj.chart_num.value;\n\t\t\t\tvar chart_flag = formObj.chart_flag.value;\n\n\t\t\t\t//var chart_line_num = formObj.chart_line_num.value;\n\t\t\t\t//var DentalChartFormObj = parent.trmtDentalChartDetails.document.forms[0];\n\t\t\t\t//var header_tab = formObj.header_tab.value;\n\t\t\t\tvar tooth_numbering_system = formObj.tooth_numbering_system.value;\n\t\t\t\tvar permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;\n\t\t\t\tvar mixed_dentition_YN = formObj.mixed_dentition_YN.value;\n\t\t\t\tvar upper_arch_desc = formObj.upper_arch_desc.value;\n\t\t\t\tvar lower_arch_desc = formObj.lower_arch_desc.value;\n\t\t\t\tvar Q1_id = formObj.Q1_id.value;\n\t\t\t\tvar Q2_id = formObj.Q2_id.value;\n\t\t\t\tvar Q3_id = formObj.Q3_id.value;\n\t\t\t\tvar Q4_id = formObj.Q4_id.value;\n\t\t\t\tvar Q1_desc = formObj.Q1_desc.value;\n\t\t\t\tvar Q2_desc = formObj.Q2_desc.value;\n\t\t\t\tvar Q3_desc = formObj.Q3_desc.value;\n\t\t\t\tvar Q4_desc = formObj.Q4_desc.value;  \n\t\t\t\tvar chart_num_print = formObj.chart_num_for_print.value;\n\t\t\t\tvar asOnDatePrint = formObj.asOnDate.value;\n\t\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\t\t\t\tvar baseline_chart_yn = formObj.baseline_chart_yn.value;\n\t\t\t\tvar chart_num = \"\";\n\t\t\t\t//Added by Sharon Crasta on 1/19/2010 for IN018302\n\t\t\t\t//If the ASonDate field is made blank, then it should be populated with the Sysdate on click of refresh\n\t\t\t\tif(asOnDatePrint == \"\"){\n\t\t\t\t   var sys_date = new Date();\n\t\t\t\t   var month = sys_date.getMonth();\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t   var year = sys_date.getFullYear();\n\t\t\t\t   var date = sys_date.getDate();\n\n\t\t\t\t   month = (month < 9) ? (\"0\" + (1+month)) : (1+month);\n\t\t\t\t   date = (date <= 9) ? (\"0\" + (date)) : date;\n\t\t\t\t   asOnDatePrint = date+\"/\"+month+\"/\"+year;\n\t\t\t\t   document.getElementById(\"asOnDate\").value = asOnDatePrint; \n\n\n\t\t\t\t}\n\t\t\t\t//Added by Sharon Crasta on 4/8/2010 for IN020567\n\t\t\t\t//If asOnDate is given as a date for whihc no chart exists then, the message no chart exists should be given.\n\t\t\t\telse{\n\t\t\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&asOnDate=\"+asOnDatePrint+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=checkChartExists&\"+params,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\tretVal = localTrimString(retVal);\n\t\t\t\t\tif(retVal.length == 0){\n\t\t\t\t\t\talert(getMessage(\"APP-OH000183\",\"OH\"));\n\t\t\t\t\t\tvar sys_date = new Date();\n\t\t\t\t\t    var month = sys_date.getMonth();\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t    var year = sys_date.getFullYear();\n\t\t\t\t\t    var date = sys_date.getDate();\n\n\t\t\t\t\t    month = (month < 9) ? (\"0\" + (1+month)) : (1+month);\n\t\t\t\t\t    date = (date <= 9) ? (\"0\" + (date)) : date;\n\t\t\t\t\t    asOnDatePrint = date+\"/\"+month+\"/\"+year;\n\t\t\t\t\t    document.getElementById(\"asOnDate\").value = asOnDatePrint;\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t//End\n\t\t\t\tif(baseline_chart_yn == \"Y\"){\n\t\t\t\t\t\n\t\t\t\t\tchart_num = formObj.chart_num_baseline_yn.value;\n\t\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_status=A\"+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\t\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=getMaxChartNum&\"+params,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\tretVal = localTrimString(retVal);\n\t\t\t\t\t\n\t\t\t\t\tif(retVal != \"null\" && retVal != \"\" && retVal != null && retVal.length >= 1){\n\t\t\t\t\t\t\n\t\t\t\t\t\tchart_num= retVal;\n\t\t\t\t\t}\n\t\t\t\t\t//chart_num = formObj.chart_num_for_print.value;\n\t\t\t\t//\tasOnDatePrint = formObj.asOnDatePrint_Baseline_YN.value;\n\t\t\t\t}\n\t\t\t\t//formObj.dentist_comments.value = checkSpl(formObj.dentist_comments.value);\n\t\t\t\t//var qry_string = \"patient_id=\"+patient_id+\"&header_tab=\"+header_tab+\"&tooth_numbering_system=\"+tooth_numbering_system+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&upper_arch_desc=\"+upper_arch_desc+\"&lower_arch_desc=\"+lower_arch_desc+\"&Q1_id=\"+Q1_id+\"&Q2_id=\"+Q2_id+\"&Q3_id=\"+Q3_id+\"&Q4_id=\"+Q4_id+\"&Q1_desc=\"+Q1_desc+\"&Q2_desc=\"+Q2_desc+\"&Q3_desc=\"+Q3_desc+\"&Q4_desc=\"+Q4_desc+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+chart_line_num;\n\t\t\t\tvar qry_string = \"patient_id=\"+patient_id+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&upper_arch_desc=\"+upper_arch_desc+\"&lower_arch_desc=\"+lower_arch_desc+\"&Q1_id=\"+Q1_id+\"&Q2_id=\"+Q2_id+\"&Q3_id=\"+Q3_id+\"&Q4_id=\"+Q4_id+\"&Q1_desc=\"+Q1_desc+\"&Q2_desc=\"+Q2_desc+\"&Q3_desc=\"+Q3_desc+\"&Q4_desc=\"+Q4_desc+\"&chart_num=\"+chart_num+\"&asOnDatePrint=\"+asOnDatePrint+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&baseline_chart_yn=\"+baseline_chart_yn+\"&tooth_numbering_system=\"+tooth_numbering_system;\n\t\t\t\t\n\t\t\t\tvar url\t= \"../../eOH/jsp/PrintChart.jsp?\"+qry_string;\n\t\t\t\t\n\t\t\t\t//location.href =  \"../../eOH/jsp/PrintChart.jsp?\"+qry_string;\n\n\t\t\t\t//var testwindow= window.open (url, \"WindowTitle\",\"location=0,status=0,scrollbars=2,width=800,height=450\");\n\n\t\t\t\tvar testwindow= window.open (url, \"PrintChart\",\"location=0,status=0,scrollbars=4,width=850,height=670\");\n\n\t\t\t\ttestwindow.moveTo(49,20);\n\n\t\t\t} \n\t\t\t\n\t\t\t//Added by Sharon Crasta on 1/22/2010 for IN018302\n\t\t\t//Added to display an alert message if the asOnDate value is blank.\n\t\t\t//Added to display an alert message if no chart exists for the given date.\n\t\t\tfunction checkForBlank(asOnDate,asOnDatCal){\n\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\tvar flag_blank = false;\n\t\t\t\tvar asOn_title = getLabel(\"eOH.Chartason.Label\",\"OH\");\n\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"COMMON\");\n\t\t\t\tvar msgArray = msg.split(\"$\");\n\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\tvar asOnDate = formObj.asOnDate.value;\n\t\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\t\t\t\tif(asOnDate == \"\" || asOnDate == \"null\"){\n\t\t\t\t\t//alert(msgArray[0]+ asOn_title + msgArray[1]);\n\t\t\t\t\tdocument.forms[0].asOnDate.focus();\n\t\t\t\t\tflag_blank = true;\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t/*else if(asOnDatCal == \"Cal\"){\n\t\t\t\t\treturn true;\t\t\t\t\n\t\t\t\t}*/\n\t\t\t\telse{\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&asOnDate=\"+asOnDate+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\t\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=checkChartExists&\"+params,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\tretVal = localTrimString(retVal);\n\t\t\t\t\tif(parseInt(retVal) >= 1){\n\t\t\t\t\t\tchangeNumberingSystem();\n\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&asOnDate=\"+asOnDate+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=checkasOnDateChartNum&\"+params,false);\n\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\tvar retVal_ason_chart_num = trimString(xmlHttp.responseText);\n\t\t\t\t\t\tretVal_ason_chart_num = localTrimString(retVal_ason_chart_num);\n\n\t\t\t\t\t\tif(retVal_ason_chart_num.length > 0){\n\t\t\t\t\t\t\tdocument.getElementById(\"asondate_chart_num\").value = retVal_ason_chart_num;\n\t\t\t\t\t\t}\n\t\t\t\t\t\treturn true;\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t//alert(\"No Chart exists for the given date\");\n\t\t\t\t\t\t//alert(getMessage(\"APP-OH000183\",\"OH\"))\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\t function CheckDate(Object2,focusflag) {\n\t\t\t\tvar datefield = Object2;\n\t\t\t\tif (Object2.value != undefined)\n\t\t\t\t{\n\t\t\t\t\tObject2 = Object2.value;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tObject2 = Object2;\n\t\t\t\t}\n\n\t\t\t\thasChanged= true;\n\t\t\t\tif (ChkDate(Object2) == false) {\n\t\t\t\t\tif(hasChanged){\n\t\t\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t\t\t\tif (datefield.value != undefined && focusflag == null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdatefield.select();\n\t\t\t\t\t\t\tdatefield.focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t\thasChanged = false;\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}\n\t\t\t//Date Validation Check\n\t\t\tfunction checkDateValidity(obj){\n\t\t\t\tif(obj.value!=null && obj.value!=\"\"){\n\t\t\t\t\tvar retVal = CheckDate(obj.value);\n\t\t\t\t\tif(retVal==false){\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\tobj.select();\n\t\t\t\t\t\t//return false;\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\t//End\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\t \n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload =\"assignDBValue(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');\">\n\n\t\t<form name=\"toolHeaderForm\" id=\"toolHeaderForm\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=center>\n\t\t\t\t<tr></tr><tr></tr><tr></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"15%\" valign=\"top\">\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" frame=\"below\" width=\"90%\" BORDERCOLOR=\"GRAY\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"10\" class=\"LABEL\">\n\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" frame=\"below\" > \n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"TRUMTH\" src=\"../../eOH/images/Trauma.gif\" alt=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\"onMouseClickOfImage(\'TRUMTH\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"ATRARER\" src=\"../../eOH/images/AttritionAbrationErotion.gif\" alt=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'   onclick=\"onMouseClickOfImage(\'ATRARER\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"SUPRTH\" src=\"../../eOH/images/SuperNumerary.gif\" alt=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'   onclick=\"onMouseClickOfImage(\'SUPRTH\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"MISSTH\" src=\"../../eOH/images/MissingTeeth.gif\" alt=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'   onclick=\"onMouseClickOfImage(\'MISSTH\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"PARERTH\" src=\"../../eOH/images/PartialEruption.gif\" alt=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  onclick=\"onMouseClickOfImage(\'PARERTH\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"UNERTH\" src=\"../../eOH/images/Uneruption.gif\" alt=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'    onclick=\"onMouseClickOfImage(\'UNERTH\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"IMPACTN\" src=\"../../eOH/images/Impaction-Normal.gif\" alt=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'    onclick=\"onMouseClickOfImage(\'IMPACTN\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"MOBILITY\" src=\"../../eOH/images/Mobility.gif\" alt=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'    onclick=\"onMouseClickOfImage(\'IMPACTN\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<!-- Added by Sharon Crasta on 1/28/2010 for SRR20056-CRF-0498(IN010982)-->\n\t\t\t\t\t\t\t\t\t\t\t<!-- Added to display the images for Mal position and Mal Occlusion-->\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"MALOCLN\" src=\"../../eOH/images/MalOcclution.gif\" alt=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'    onclick=\"onMouseClickOfImage(\'MALOCLN\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t\t <td width=\"7%\"><img border=\"1\" style=\"border-color:white\" id=\"MALPOSN\" src=\"../../eOH/images/MalPosition.gif\" alt=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'    onclick=\"onMouseClickOfImage(\'MALPOSN\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t\t<!-- -->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- <td width=\"20%\" valign=\"top\"> -->\n\t\t\t\t\t<td width=\"12%\" valign=\"top\">\n\t\t\t\t\t\t<table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" frame=\"below\"  width=\"90%\" bordercolor=\"GRAY\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"10\" class=\"LABEL\">\n\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" frame=\"below\"> \n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Extraction-CrownYellow.gif\" alt=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  onclick=\"onMouseClickOfImage(\'Extraction\');\" width=\"18\" height=\"16\"/></td>\n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Extraction-CrownGreen.gif\" alt=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'   onclick=\"onMouseClickOfImage(\'Extraction\');\" width=\"18\" height=\"16\"/></td>\n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Implantindicator.gif\" alt=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'   onclick=\"onMouseClickOfImage(\'Implant\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t <td width=\"7%\"><img src=\"../../eOH/images/Denture_indicator.gif\" alt=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'   onclick=\"onMouseClickOfImage(\'Denture\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Bridge.gif\" alt=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  onclick=\"onMouseClickOfImage(\'Bridge\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Ortho.gif\" alt=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onclick=\"onMouseClickOfImage(\'Ortho\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/Impaction-Treatment.gif\" alt=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  onclick=\"onMouseClickOfImage(\'Impaction-Treatment\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/TRMT_Planned.gif\"  alt=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'   onclick=\"onMouseClickOfImage(\'ToothTreatment\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/TRMT_Perf.gif\"  alt=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'   onclick=\"onMouseClickOfImage(\'ToothTreatment\');\"/></td> \n\t\t\t\t\t\t\t\t\t\t   <td width=\"7%\"><img src=\"../../eOH/images/CrownDownTool.gif\"  alt=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onclick=\"onMouseClickOfImage(\'Crownup\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/CrownUpTool.gif\"  alt=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  onclick=\"onMouseClickOfImage(\'Crowndown\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t  <!--<td width=\"7%\"><img src=\"../../eOH/images/AbutmentIcon.gif\"  alt=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  onclick=\"onMouseClickOfImage(\'Abutment\');\"/></td>\n\t\t\t\t\t\t\t\t\t\t  <td width=\"7%\"><img src=\"../../eOH/images/PonticIcon.gif\"  alt=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  onclick=\"onMouseClickOfImage(\'Pontic\');\"/></td>\t-->\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- <td width=\"43%\" valign=\"top\"> -->\n\t\t\t\t\t<td width=\"43%\" valign=\"top\">\n\t\t\t\t\t\t<table align=\"right\" cellpadding=\"0\" cellspacing=\"0\" >\n\t\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t\t<!-- Commented and Added by Sharon Crasta on 1/28/2010 forSRR20056-CRF-0498(IN010982)-->\n\t\t\t\t\t\t\t\t<!-- Added to display the images for Mal position and Mal Occlusion-->\n\t\t\t\t\t\t\t\t<!-- <td width=\"2%\"><font class=\"HYPERLINK\" style=\"font-size:15pt;color:blue;cursor:pointer;font-weight:normal\" title=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onClick=\"window.open(\'showCondTrmtImages.jsp\',\'\',\'height=400,width=230,top=100,left=770,status=NO,toolbar=no,menubar=no,location=no,scrollbar=auto,resize=yes\');\">...&nbsp;</font> -->\n\n\t\t\t\t\t\t\t\t<td width=\"2%\" ><font class=\"HYPERLINK\" style=\"font-size:15pt;color:blue;cursor:pointer;font-weight:normal\" title=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\"window.open(\'showCondTrmtImages.jsp\',\'\',\'height=500,width=350,top=100,left=640,status=NO,toolbar=no,menubar=no,location=no,scrollbar=auto,resize=yes\');\">...&nbsp;</font>\n\t\t\t\t\t\t\t\t<!-- End -->\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"LABEL\" style=\"text-align:center\">\n\t\t\t\t\t\t\t\t\t<select name=\"numbering_system\" id=\"numbering_system\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"LABEL\" style=\"text-align:center\" id=\"chart_identity\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="(";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =")\n\n                                    ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =")\n\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =")\n\n                                  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"LABEL\" style=\"text-align:center\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"asOnDate\" id=\"asOnDate\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" size=10 disabled>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' disabled >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"asOnDate\" id=\"asOnDate\" value=\"\" size=10 onKeyPress = \"NumberCheck(this);\" onBlur=\"checkDateNotGraterThanSysDate(this);checkDateValidity(this);\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'image\' id=\"asOnDateCal\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'asOnDate\');\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td id=\"print_chart\">\n\t\t\t\t\t\t\t\t\t<img id=\'print_img\' src=\"../../eOR/images/print-Preview.gif\" alt=\"Print\" style=\"cursor:pointer;\" onclick=\"printOverview();\" />\n\t\t\t\t\t\t\t\t\t<img id=\"refresh_icon\" src=\"../../eOH/images/Refresh.gif\" alt=\"Refresh\" onclick=\"changeNumberingSystem()\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\"hidden\" name=\"numbering_system_desc\" id=\"numbering_system_desc\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t<input type=\"hidden\" name=\"chart_flag\" id=\"chart_flag\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<input type=\"hidden\" name=\"baseline_chart_yn\" id=\"baseline_chart_yn\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<input type=\"hidden\" name=\"baseline_new_chart\" id=\"baseline_new_chart\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name = \"image_selected\" value = \"\">\n\t\t\t<input type=\"hidden\" name = \"params_hid\" value = \"\">\n\t\t\t<input type=\"hidden\" name = \"tooth_no\" value = \"\">\n\t\t\t<input type=\"hidden\" name = \"site_type\" value = \"\">\n\t\t\t<input type=\"hidden\" name = \"chart_status_from_view\" value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\"hidden\" name = \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\"hidden\" name = \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t<input type=\"hidden\" name = \"add_new_done_flag\" value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t<input type=\"hidden\" name = \"add_new_yn\" value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->\n\t\t\t<input type=\"hidden\" name = \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<!--Added by Sharon Crasta on 7/28/2009 for PMG20089-CRF-0700-->\n\t\t\t<input type=\"hidden\" name = \"upper_arch_desc\" value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name = \"lower_arch_desc\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q1_id\" value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q2_id\" value = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q3_id\" value = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q4_id\" value = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q1_desc\" value = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q2_desc\" value = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q3_desc\" value = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name = \"Q4_desc\" value = \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name = \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name = \"mixed_dentition_YN\" value = \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<!--Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700-->\n\t\t\t<input type=\"hidden\" name = \"chart_num_for_print\" value = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t<input type=\"hidden\" name = \"chart_num_baseline_yn\" value = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name = \"asOnDatePrint_Baseline_YN\" value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t<input type=\"hidden\" name = \"loaded_from_main_tab\" value = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name = \"dentist_comments\" value = \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t<input type=\"hidden\" name = \"called_from\" value = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\"hidden\" name = \"header_tab\" value = \"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<!--Added by Sharon Crasta on 1/7/2010 for IN017822-->\n\t\t\t<input type=\"hidden\" name = \"loaded_from_trmt_tab\" value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\"hidden\" name = \"operating_facility_id_1\" value = \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t</form>\n\t\t<script>\n\t\t\t/*\n\t\t\tvar called_from_ot = \'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\';\n\t\t\tif(called_from_ot != \"OT\"){\n\t\t\t\tvar formObj = document.forms[0];\n\t\t\t}else{\n\t\t\t\tvar formObj = document.forms[1];\n\t\t\t}*/\n\t\t\tvar formObj = document.forms[0];\n\t\t\tvar baseline_chart_yn = formObj.baseline_chart_yn.value;\n\t\t\tvar baseline_new_chart = formObj.baseline_new_chart.value;\n\t\t\tvar chart_status_from_view = formObj.chart_status_from_view.value;\n\t\t\t//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700\n\t\t\tvar header_tab = formObj.header_tab.value;\n\t\t\tif(baseline_chart_yn == \"Y\"){\n\t\t\t\tcur_chart_num = formObj.chart_num_baseline_yn.value;\n\t\t\t}\n\t\t\t//\n\t\t\n\t\t\tif(baseline_chart_yn != \"Y\" && baseline_new_chart != \"Y\"){\n\t\t\t\tchangeNumberingSystem();\n\t\t\t}\n\t\t\t//Added by Sharon Crasta on 11/2/2009 for Print Chart PMG20089-CRF-0700\n\t\t\t//When clicking from the baseline, the print icon was getting displayed in the Condition Tab. The print icon should be displayed only when the Treatment Tab is clicked.\n\t\t\tif(parent.frames[1].Treatment != null && parent.frames[1].Treatment != \"null\" && parent.frames[1].Treatment != \"undefined\" && parent.frames[1].Treatment != undefined){\n\t\t\t\tif(parent.frames[1].Treatment.className == \"tabClicked\"){\n\t\t\t\t\tmain_tab = \"Treatment\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tmain_tab = \"Condition\";\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t//Added to display the print image icon only when Treatment tab is clicked.\n\t\t\telse{\n\t\t\t\t\tmain_tab = \"Condition\";\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tif(main_tab == \"Condition\"){\n\t\t\t\tdocument.getElementById(\"print_img\").style.visibility=\'hidden\';\n\t\t\t}\n\t\t\t//Added by Sharon Crasta on 1/7/2010 for IN017822\n\t\t\t//If passed from treatment tab, Add New , The value will be \"Y\".\n\t\t\tvar params = formObj.params.value;\n\t\t\tvar loaded_from_trmt_tab = formObj.loaded_from_trmt_tab.value;\n\t\t\tparams = params+\"&loaded_from_trmt_tab=\"+loaded_from_trmt_tab;\n\t\t\t//End\n\t\t</script>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String disable = "";
	String numbering_system_selected = "";
	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");

	String tooth_numbering_system = request.getParameter("tooth_numbering_system");
	
	String numbering_system_desc = request.getParameter("numbering_system_desc");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag");
	String encounter_id = request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));
	String baseline_date = checkForNull(request.getParameter("baseline_date"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String baseline_new_chart = checkForNull(request.getParameter("baseline_new_chart"));
	//String refresh_hdr_flag = checkForNull(request.getParameter("refresh_hdr_flag"));
	//String tab_clicked = checkForNull(request.getParameter("tab_clicked"));
	String chart_status_from_view = checkForNull(request.getParameter("chart_status_from_view"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	//String baseline_new_char = checkForNull(request.getParameter("baseline_new_char"));
	String add_new_done_flag = checkForNull(request.getParameter( "add_new_done_flag" )) ;			
	String add_new_yn = checkForNull(request.getParameter( "add_new_yn" )) ;			
	String called_from = checkForNull(request.getParameter( "called_from" )) ;	
	
	//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String header_tab        =  checkForNull(request.getParameter("header_tab"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));

	//out.println("oh_chart_level:=="+oh_chart_level);
	String cur_chart_num="";
	/*if(baseline_chart_yn.equals("Y")){//added by parul  for other facility chart CRF#0423
		disable = "disabled";
	}*/
	//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
	String chart_num_baseline_yn = request.getParameter("chart_num_baseline_yn");
	String asOnDatePrint_Baseline_YN = request.getParameter("asOnDatePrint");
	String loaded_from_main_tab = request.getParameter("loaded_from_main_tab");
	String dentist_comments = request.getParameter("dentist_comments");
	//

	//Added by Sharon Crasta on 1/7/2010 for IN017822
	//If passed from treatment tab, Add New , The value will be "Y".
	String loaded_from_trmt_tab = request.getParameter("loaded_from_trmt_tab");
	//
	if(add_new_done_flag.equals("Y") || add_new_yn.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "N";
	   add_new_yn = "Y";
	}
	if(baseline_chart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){
		disable = "disabled";
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rst=null;



            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

	try{
			con=ConnectionManager.getConnection(request);
			//String oh_chart_level="";
			String operating_facility_id_1="";
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
		}
		pstmt1 = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rst = pstmt1.executeQuery();
				while (rst != null && rst.next()){
					oh_chart_level = checkForNull(rst.getString("CHART_LEVEL"));
				}

	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'  ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
	}else{

		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		//pstmt.setString(1,facility_id);
		pstmt.setString(1,other_chart_facility_id);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
	}
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}	
		
		pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM OH_RESTORATIVE_CHART_HDR WHERE CHART_NUM=? AND PATIENT_ID=? ");
		//pstmt.setString(1,facility_id);
		if (chart_num.equals("")||chart_num.equals("null")|| chart_num.equals(null)){
			pstmt.setString(1,cur_chart_num);
		}else{
			pstmt.setString(1,chart_num);
		}
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			operating_facility_id_1 = rs.getString("OPERATING_FACILITY_ID");
		}	

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block36Bytes, _wl_block36);

										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
										pstmt=con.prepareStatement("SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2");
										pstmt.setString(1,locale);
										rs=pstmt.executeQuery();
										while(rs.next()){
											String DB_numbering_system = rs.getString("NUMBERING_SYSTEM");
											String DB_numbering_system_desc = rs.getString("NUMBERING_SYSTEM_DESC");
											if(baseline_chart_yn.equals("Y") && tooth_numbering_system.equals(DB_numbering_system)){ //Closed baseline Chart
												numbering_system_selected = "selected";
											}
											else if(baseline_new_chart.equals("Y") && tooth_numbering_system.equals(DB_numbering_system)){ // New Baseline Chart
												numbering_system_selected = "selected";
											}
											else if(chart_status_from_view.equals("A") && tooth_numbering_system.equals(DB_numbering_system)){ //Active Baseline Chart
												numbering_system_selected = "selected";
											}
											else{
												numbering_system_selected = "";
											}
									
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(DB_numbering_system));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(numbering_system_selected));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(DB_numbering_system_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);

										}
									
            _bw.write(_wl_block41Bytes, _wl_block41);
if(oh_chart_level.equals("E")){
            _bw.write(_wl_block42Bytes, _wl_block42);
if (chart_num.equals("") || chart_num.equals("null") || chart_num.equals(null)){
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cur_chart_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(operating_facility_id_1));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(operating_facility_id_1));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
if (chart_num.equals("") || chart_num.equals("null") || chart_num.equals(null)){
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cur_chart_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(operating_facility_id_1));
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

										if(baseline_chart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){
										//if(baseline_chart_yn.equals("Y")){
									
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(baseline_date));
            _bw.write(_wl_block54Bytes, _wl_block54);

										}
										else{
									
            _bw.write(_wl_block55Bytes, _wl_block55);

										}
									
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(numbering_system_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(params));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(chart_flag));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(baseline_new_chart));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(chart_status_from_view));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(add_new_done_flag));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(add_new_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(cur_chart_num));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(chart_num_baseline_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(asOnDatePrint_Baseline_YN));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(loaded_from_main_tab));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(dentist_comments));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(header_tab));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(loaded_from_trmt_tab));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(operating_facility_id_1));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block96Bytes, _wl_block96);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Trauma.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.AttritionAbrationErotion.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.SuperNumerary.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.MissingTeeth.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PartialEruption.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Uneruption.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ImpactionNormal.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Mobility.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Malocclusion.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Malposition.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Extraction(Planned).Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Extraction(Performed).Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Implant.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Denture.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Bridge.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.OrthodonticAppliance.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ImpactionTreatment.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothTrmt(Planned).Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothTrmt(Performed).Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CrownForUA.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CrownForLA.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Abutment.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Pontic.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ImagesInfoTitle.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ImagesInfoTitle.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Chart.Label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Chart.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Chart.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Chart.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Chartason.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }
}
