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

public final class __perioevalchartheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioEvalChartHeader.jsp", 1709119360598L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/PerioChart.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOH/js/HistPerioChart.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t<script>\n\t\tfunction refresh(){\n\t\t\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp\";\n\t\t\tvar formObj = document.forms[0];\n\t\t\tparent.perioChartMainDummyFrame.document.forms[0].main_chart_num.value = \"\"; // Clearing the chart_num ecah time whicen u refresh..This is to get the fresh chart_num whenever u insert record..\n\t\t\tvar show_new_active_yn = formObj.show_new_active_yn.value; \n\t\t\tvar chart_num = formObj.chart_num.value; \n\t\t\tvar chart_line_num = formObj.chart_line_num.value; \n\t\t\tvar perio_arch = formObj.perio_arch.value; \n\t\t\tvar perio_chart = formObj.perio_chart.value; \n\t\t\tvar patient_id = formObj.patient_id.value; \n\t\t\t//formObj.eval_active_yn.value = \'N\';\n\t\t\tvar messageFrame = parent.parent.messageFrame;\n\t\t\tvar added_date=\"\";\n\t\t\t/*\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_code=\"+perio_chart+\"&chart_num=\"+chart_num;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=checkForPerioChartValidity&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tvar retVal=localTrimString(retVal);\n\t\t\tif(retVal.length > 1){\n\t\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\t\tfor(k=0;k<retVal_arr.length-1;k++){\n\t\t\t\t\tvar validity_period_arr = retVal_arr[k].split(\"##\");\n\t\t\t\t\tif(parseInt(validity_period_arr[0]) > parseInt(validity_period_arr[1])){\n\t\t\t\t\t\talert(getMessage(\"APP-OH00072\",\"OH\"));\n\t\t\t\t\t\t//return;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t*/\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_code=\"+perio_chart+\"&chart_num=\"+chart_num;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"PerioCommonValidation.jsp?func_mode=checkForPerioChartCompleted&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tvar retVal=localTrimString(retVal);\n\t\t\tif(retVal.length > 1){\n\t\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\t\tadded_date=retVal_arr[0];\n\t\t\t\t\n\t\t\t}\n\n\t\t\tif(formObj != null){\n\t\t\t\tvar numbering_system_title=getLabel(\"eOH.NumberingSystem.Label\",\"OH\");\n\t\t\t\tvar chart_title = getLabel(\"Common.Chart.label\",\"Common\");\n\t\t\t\tvar arch_title = getLabel(\"eOH.Arch.Label\",\"OH\");\n\t\t\t\t\n\t\t\t\tvar fields = new Array (formObj.perio_numbering_system,formObj.perio_chart,formObj.perio_arch);\n\t\t\t\tvar names = new Array ( numbering_system_title,chart_title,arch_title);\n\n\t\t\t\tif(checkFieldsofMst( fields, names, messageFrame)){\t\n\t\t\t\t\tchangeNumberingSystem(perio_arch,added_date);\n\t\t\t\t}\n\n\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t\tfunction changeNumberingSystem(arch_code,added_date){ // This function is to rebuild the query without tooth_numbering_system parameter...\n\t\t\t\t\t\t\n\t\t\tvar formObj = document.forms[0];\n\t\n\t\t\tvar main_tab = \"\";\n\t\t\tvar perio_numbering_system = formObj.perio_numbering_system.value; // OnChange parameter\n\t\t\tvar tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..\n\n\t\t\tvar perio_chart = formObj.perio_chart.value; \n\t\t\tvar perio_arch = formObj.perio_arch.value; \n\t\t\tvar chart_num = formObj.chart_num.value; \n\t\t\tvar chart_line_num = formObj.chart_line_num.value; \n\t\t\tvar perio_arch_hid = formObj.perio_arch_hid.value; \n\t\t\tvar baseline_active_yn = formObj.baseline_active_yn.value; \n\t\t\tvar baseline_closed_yn = formObj.baseline_closed_yn.value; \n\t\t\tvar eval_active_yn = formObj.eval_active_yn.value; \n\t\t\tvar chart_date = formObj.chart_date.value; \n\t\t\tvar chart_close_date = formObj.chart_close_date.value; \n\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value; \n\t\t\tvar other_facilitychart_yn = formObj.other_facilitychart_yn.value; \n\t\t\tvar oh_chart_level = formObj.oh_chart_level.value; \n\t\t\t\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"oh_chart_level=\"+oh_chart_level;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=selectUserPrefferences&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tvar retVal=localTrimString(retVal);\n\t\t\tif(retVal.length > 1){\n\t\t\t\tretVal_arr = retVal.split(\"##\");\n\t\t\t\t//if(retVal_arr[0] == \"\" && (tooth_numbering_system == null || tooth_numbering_system == \"null\")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table\n\t\t\t\tif( (retVal_arr[0] == null || retVal_arr[0] == \"null\" || retVal_arr[0] == \"\") && (tooth_numbering_system == null || tooth_numbering_system == \"null\" || tooth_numbering_system==\"\")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table\n\t\t\t\t\ttooth_numbering_system = retVal_arr[1];\n\t\t\t\t\tformObj.tooth_numbering_system.value = retVal_arr[1];\n\t\t\t\t\tformObj.perio_numbering_system.value = retVal_arr[1];\n\t\t\t\t}\n\t\t\t\t//else if(retVal_arr[0] != \"\" && (tooth_numbering_system == null || tooth_numbering_system == \"null\" || tooth_numbering_system == \"\")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table\n\t\t\t\telse if( retVal_arr[0] != null && retVal_arr[0] != \"null\" && retVal_arr[0] != \"\" && (tooth_numbering_system == null || tooth_numbering_system == \"null\" ||tooth_numbering_system == \"\")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table\n\t\t\t\t\ttooth_numbering_system = retVal_arr[0];\n\t\t\t\t\tformObj.tooth_numbering_system.value = retVal_arr[0];\n\t\t\t\t\tformObj.perio_numbering_system.value = retVal_arr[0];\n\t\t\t\t}\n\t\t\t\telse{ // Loding page when you click on the refresh button and tooth_numbering_system is not null\n\t\t\t\t\tif(tooth_numbering_system != perio_numbering_system){\n\t\t\t\t\t\tvar copy_as_defult  = confirm(getMessage(\"APP-OH00032\",\"OH\"))\n\t\t\t\t\t\tif(copy_as_defult){ // If you want to set this numbering system as default numbering system\n\n\t\t\t\t\t\t\t// Insert a record in to OH_USER_PREFERENCES table\n\t\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\t\t\t\tvar params = \"tooth_numbering_system=\"+perio_numbering_system;\n\t\t\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=updateUserPrefferences&\"+params,false);\n\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\tvar retVal=localTrimString(retVal);\n\t\t\t\t\t\t\tif(retVal != 0){\n\t\t\t\t\t\t\t\tformObj.tooth_numbering_system.value = perio_numbering_system;\n\t\t\t\t\t\t\t\ttooth_numbering_system = perio_numbering_system;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{ //If you dont want to set this numbering system as default numbering system\n\t\t\t\t\t\t\tformObj.tooth_numbering_system.value = perio_numbering_system;\n\t\t\t\t\t\t\ttooth_numbering_system = perio_numbering_system;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\n\t\t\t// TO ADD ARCH PARAMETERS TO THE SELECT BOX perio_arch ACCORDING TO THE tooth_numbering_system\n\t\t\tclear_list(document.forms[0].perio_arch); \n\t\t\toptSel\t= document.createElement(\"OPTION\");\n\t\t\toptSel.text = getLabel(\"eOH.DefaultSelect.Label\",\"OH\");\n\t\t\toptSel.value= \'\'; \n\t\t\tdocument.forms[0].perio_arch.add(optSel);\n\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"tooth_numbering_system=\"+tooth_numbering_system;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"PerioCommonValidation.jsp?func_mode=populateArch&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tif(retVal.length>1){\n\t\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\t\tfor(var i=0;i<retVal_arr.length-1;i++){\n\t\t\t\t\tvar code_desc_arr = retVal_arr[i].split(\"##\");\n\t\t\t\t\tvar element \t= document.createElement(\'OPTION\') ;\n\t\t\t\t\telement.value \t= code_desc_arr[0];\n\t\t\t\t\telement.text \t= code_desc_arr[1] ;\n\t\t\t\t\tdocument.forms[0].perio_arch.add(element);\n\t\t\t\t}\n\t\t\t}\n\t\t\tdocument.forms[0].perio_arch.value = perio_arch;\n\t\t\t  if(eval_active_yn == \"Y\" && other_facilitychart_yn==\"Y\"){\n\t\t\t\tdocument.forms[0].perio_arch.value = perio_arch_hid;\n\t\t\t\tperio_arch = perio_arch_hid;\n\t\t\t\tdocument.forms[0].perio_numbering_system.disabled = true;\n\t\t\t\tdocument.forms[0].perio_chart.disabled = true;\n\t\t\t\tif(document.forms[0].perio_status != null){\n\t\t\t\t\tdocument.forms[0].perio_status.disabled = true;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(eval_active_yn == \"N\" || other_facilitychart_yn==\"Y\"){\n\t\t\t\tdocument.forms[0].perio_arch.value = perio_arch_hid;\n\t\t\t\tperio_arch = perio_arch_hid;\n\t\t\t\tdocument.forms[0].perio_numbering_system.disabled = true;\n\t\t\t\tdocument.forms[0].perio_chart.disabled = true;\n\t\t\t\tif(document.forms[0].perio_status != null){\n\t\t\t\t\tdocument.forms[0].perio_status.disabled = true;\n\t\t\t\t}\n\n\t\t\t} else if(eval_active_yn == \"Y\"){\n\t\t\t\tdocument.forms[0].perio_arch.value = perio_arch_hid;\n\t\t\t\tperio_arch = perio_arch_hid;\n\t\t\t}\n\n\t\t\t\n\n\t\t\tif(arch_code != \"undefined\" && arch_code != undefined){\n\t\t\t\tdocument.forms[0].perio_arch.value = arch_code;\n\t\t\t\tperio_arch = arch_code;\n\t\t\t}\n\n\t\t\tif(parent.frames[1].EvaluationChart != null && parent.frames[1].EvaluationChart != \"null\" && parent.frames[1].EvaluationChart != undefined && parent.frames[1].EvaluationChart != \"undefined\" ){\n\t\t\t\tif(parent.frames[1].EvaluationChart.className == \"tabClicked\"){\n\t\t\t\t\tmain_tab = \"EvaluationChart\";\n\t\t\t\t}\n\t\t\t\telse if(parent.frames[1].Compare.className == \"tabClicked\"){\n\t\t\t\t\tmain_tab = \"Compare\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tmain_tab = \"BaselineChart\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tformObj.main_tab.value = main_tab;\n\t\t\t//var params_str = formObj.params.value;\n\t\t\t//var params_str = parent.frames[2].document.forms[0].ca_params.value //PerioChartMain\n\t\t\tvar params_str = parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain\n\t\t\t\t\t\n\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\tvar chart_flag = formObj.chart_flag.value;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"numbering_system=\"+tooth_numbering_system+\"&patient_id=\"+patient_id+\"&chart_flag=\"+chart_flag+\"&oh_chart_level=\"+oh_chart_lev";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="el;\n\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"buildPerioParameters.jsp?func_mode=buildPerioParameters&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tvar ret_params=localTrimString(retVal);\n\n\t\t\t\n\t\t\t//params=params_str+ret_params+\"&perio_arch=\"+perio_arch+\"&perio_chart=\"+perio_chart+\"&main_tab=\"+main_tab+\"&baseline_active_yn=\"+baseline_active_yn+\"&baseline_closed_yn=\"+baseline_closed_yn+\"&chart_num=\"+chart_num; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.\n\t\t\t// This to set the Chart_num in the Header page bcoz we are not reloding this page on click og Refresh button\n\t\t\tformObj.chart_num.value = chart_num;\n\t\t\tvar called_from_BC_EV_yn = formObj.called_from_BC_EV_yn.value;\n\t\t\tif(formObj.perio_status.value == \"CM\" || formObj.baseline_status.value==\"CM\"    || formObj.perio_status.value == \"CD\" || formObj.baseline_status.value==\"CD\"){\n\t\t\t\tcalled_from_BC_EV_yn = \"Y\";\n\t\t\t}\n\t\t\telse{\n\t\t\t\tcalled_from_BC_EV_yn = \"N\";\n\t\t\t}\n\n\t\t\t//Check for Perio Chart Validity days\n\t\t\tif(formObj.perio_status.value == \"PE\" || formObj.baseline_status.value==\"PE\" ){\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_code=\"+perio_chart+\"&chart_num=\"+chart_num;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=checkForPerioChartValidity&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar retVal=localTrimString(retVal);\n\t\t\t\tif(retVal.length > 1){\n\t\t\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\t\t\tfor(k=0;k<retVal_arr.length-1;k++){\n\t\t\t\t\t\tvar validity_period_arr = retVal_arr[k].split(\"##\");\n\t\t\t\t\t\tif(parseInt(validity_period_arr[1]) > 0){\n\t\t\t\t\t\t\tif(parseInt(validity_period_arr[0]) > parseInt(validity_period_arr[1])){\n\t\t\t\t\t\t\t\talert(getMessage(\"APP-OH00072\",\"OH\"));\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tparams=params_str+ret_params+\"&perio_arch=\"+perio_arch+\"&perio_chart=\"+perio_chart+\"&main_tab=\"+main_tab+\"&eval_active_yn=\"+eval_active_yn+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+chart_line_num+\"&called_from_BC_EV_yn=\"+called_from_BC_EV_yn+\"&chart_date=\"+chart_date+\"&chart_close_date=\"+chart_close_date+\"&added_date=\"+added_date+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&other_facilitychart_yn=\"+other_facilitychart_yn;\n\t\t\t\t;  //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.\n\t\t\t//formObj.params.value = params;\n\n\t\t\tif(main_tab == \"EvaluationChart\"){\n\t\t\t\t//parent.frames[2].location.href=\"../../eOH/jsp/OHTrmtDentalChartFrame.jsp?\"+params;\n\t\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params;\n\t\t\t\t\n\t\t\t\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params;\n\t\t\t}\n\t\t\telse if(main_tab == \"Compare\"){\n\t\t\t\t//parent.frames[2].location.href=\"../../eOH/jsp/PeriodontalSummaryFrame.jsp?\"+params;\n\t\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params;\n\t\t\t\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params;\n\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params;\n\t\t\t\tparent.perioChartRecordFrame.location.href=\"../../eOH/jsp/PerioChartLoadParamsFrame.jsp?\"+params; \n\t\t\t\t//parent.frames[2].location.href=\"../../eOH/jsp/PerioBaselineChart.jsp?\"+params;\n\t\t\t}\n\t\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onLoad=\"assignDBValue();\">\n\t<form name=\"perioChartHeaderForm\" id=\"perioChartHeaderForm\" method=\"post\" target=\"messageFrame\">\n\t\t<table width=\"100%\" cellpadding =4 cellspacing=0 border=0>\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t\t<select name=\"perio_numbering_system\" id=\"perio_numbering_system\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</select> <img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t<select name=\"perio_chart\" id=\"perio_chart\" onchange=\"getHeaderChartNum();clearChartStatus(\'EC\');\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t</select> <img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t<select name=\"perio_arch\" id=\"perio_arch\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t\t</select> <img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"25%\" class=\'LABEL\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"field\" nowrap>\n\t\t\t\t\t<select name=\"perio_status\" id=\"perio_status\" onChange=\"closeChart(this,\'EC\')\" DB_Value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t<option value=\"PE\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n\t\t\t\t\t\t<option value=\"CM\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t\t<option value=\"ME\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t</select> &nbsp;&nbsp;\n\t\t\t\t<!-- </td>\n\t\t\t\t<td width=\"25%\" align=\"right\" colspan=\"2\">  -->\n\t\t\t\t\t<img src=\"../../eOH/images/Refresh.gif\" alt=\"Refresh\" onclick=\"refresh()\"/>&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"reset\" id=\"reset\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onclick =\"reset_header()\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<!-- <tr>\n\t\t\t\t<td width=\"25%\" class=\'LABEL\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td width=\"25%\" class=\"field\">\n\t\t\t\t\t<select name=\"perio_status\" id=\"perio_status\">\n\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t\t\t\t</select> <img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"25%\" colspan=\"2\" class=\"button\">\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"close\" id=\"close\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onclick =\"closeChart()\">&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr> -->\n\t\t\t\n\t\t</table>\n\t\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type = \"hidden\" name= \"chart_flag\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type = \"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type = \"hidden\" name= \"perio_chart_hid\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type = \"hidden\" name= \"perio_arch_hid\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type = \"hidden\" name= \"baseline_status\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type = \"hidden\" name= \"baseline_active_yn\" value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type = \"hidden\" name= \"baseline_closed_yn\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type = \"hidden\" name= \"eval_active_yn\" value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type = \"hidden\" name= \"show_new_active_yn\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type = \"hidden\" name= \"active_closed_chart\" value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type = \"hidden\" name= \"chart_code\" value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type = \"hidden\" name= \"chart_date\" value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type = \"hidden\" name= \"chart_close_date\" value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type = \"hidden\" name= \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\n\n\t\t<input type = \"hidden\" name= \"main_tab\" value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type = \"hidden\" name= \"called_from_BC_EV_yn\" value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t</form>\n\t<script>\n\t\tchangeNumberingSystem();\n\t</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "";
	String chart_selected = "";
	String qry_chart_status = "";
	String facility_id = (String)session.getValue("facility_id") ;
	String chart_flag = (String)session.getValue("chart_flag") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;

	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String main_tab = checkForNull(request.getParameter("main_tab"));

	//out.println("chart_num : ----"+chart_num);
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));

	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String chart_code = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn"));
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
	String eval_active_yn = checkForNull(request.getParameter("eval_active_yn"));
	String baseline_status = checkForNull(request.getParameter("baseline_status"));
	String active_closed_chart = checkForNull(request.getParameter("active_closed_chart"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String chart_date = checkForNull(request.getParameter("chart_date"));
	String chart_close_date = checkForNull(request.getParameter("chart_close_date"));
//	String chart_desc = checkForNull(request.getParameter("chart_desc"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
		String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
		}


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);

try{
	con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2");
							pstmt.setString(1,locale);
							rs=pstmt.executeQuery();
							while(rs.next()){
								String DB_numbering_system = rs.getString("NUMBERING_SYSTEM");
								String DB_numbering_system_desc = rs.getString("NUMBERING_SYSTEM_DESC");
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(DB_numbering_system));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(DB_numbering_system_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

							}
						
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

							if(active_closed_chart.equals("menuEBCC") ||active_closed_chart.equals("menuEFCC") ){
								qry_chart_status = "CD";
							}
							else{
								qry_chart_status = "CM";
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							if (oh_chart_level.equals("E")){
								sql="SELECT A.CHART_CODE, C.CHART_DESC||'-'||TO_CHAR(SM_CONVERT_DATE(CHART_COMPLETED_DATE,?),'DD/MM/YYYY') ||'-'||CHART_COMPLETED_BY CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_PERIODONTAL_CHART_DEF_HDR C WHERE A.PATIENT_ID = ? AND B.CHART_LINE_NUM = '1' AND A.CHART_STATUS = ? AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.CHART_CODE = C.CHART_CODE ORDER BY 2";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,locale);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,qry_chart_status);
								rs=pstmt.executeQuery();
							}else{
								sql="SELECT A.CHART_CODE, C.CHART_DESC||'-'||TO_CHAR(SM_CONVERT_DATE(CHART_COMPLETED_DATE,?),'DD/MM/YYYY') ||'-'||CHART_COMPLETED_BY CHART_DESC FROM OH_PERIODONTAL_CHART_HDR A, OH_PERIODONTAL_CHART_HDR_LINE B, OH_PERIODONTAL_CHART_DEF_HDR C WHERE  A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND B.CHART_LINE_NUM = '1' AND A.CHART_STATUS = ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.CHART_CODE = C.CHART_CODE ORDER BY 2";
								pstmt=con.prepareStatement(sql);
								pstmt.setString(1,locale);
								pstmt.setString(2,other_chart_facility_id);
								pstmt.setString(3,patient_id);
								pstmt.setString(4,qry_chart_status);
								rs=pstmt.executeQuery();
							}
					while(rs.next()){
								if(rs.getString("CHART_CODE").equals(perio_chart)){
									chart_selected = "selected";

								}
								else{
									chart_selected = "";
								}
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString("CHART_CODE")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chart_selected));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("CHART_DESC")));
            _bw.write(_wl_block9Bytes, _wl_block9);

							
							}
					
						
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(baseline_status));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chart_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(perio_chart));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(perio_arch));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(baseline_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(baseline_active_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(baseline_closed_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(eval_active_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(show_new_active_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(active_closed_chart));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(chart_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(chart_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chart_close_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(main_tab));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(request.getParameter("called_from_BC_EV_yn")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(request.getParameter("patient_class")));
            _bw.write(_wl_block55Bytes, _wl_block55);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.NumberingSystem.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.BaselineChart.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Arch.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MarkError.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Status.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
