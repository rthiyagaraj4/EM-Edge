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

public final class __ohmixeddentalertframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHMixedDentAlertFrame.jsp", 1709119349505L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n<script>\n\nvar deciduous_grace_period_valid = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\';\nfunction checkForActiveChart(){\n\n\tvar date_diff_flag           = document.forms[0].date_diff_flag.value\n\tvar formObj\t\t\t\t\t = document.OHFrameForm;\n\tvar patient_id               = formObj.patient_id.value;\n\tvar facility_id              = formObj.facility_id.value;\n\tvar encounter_id             = formObj.encounter_id.value;\n\tvar patient_class            = formObj.patient_class.value;\n\tvar mixed_dentition_YN       = formObj.mixed_dentition_YN.value;\n\tvar permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;\n\tvar cur_chart_num            = formObj.cur_chart_num.value;\n\tvar new_chart_num            = formObj.new_chart_num.value;\n\tvar show_new_active_yn       = formObj.show_new_active_yn.value;\n\tvar main_tab                 = formObj.main_tab.value;\n\tvar called_from_cond_trt_tab_flag = formObj.called_from_cond_trt_tab_flag.value;\n\tvar add_new_yn                 = formObj.add_new_yn.value;\n\tvar old_facility_id                 = formObj.old_facility_id.value;\n\tif(show_new_active_yn != \"Y\"){\n\t\tshow_new_active_yn = \'N\';\n\t}\n\tvar episode_id\t\t\t\t= formObj.episode_id.value;\n\tvar episode_type            = formObj.episode_type.value;\n\tvar visit_id\t\t\t\t= formObj.visit_id.value;\n\tvar location_code\t\t\t\t= formObj.location_code.value;\n\tvar location_type\t\t\t\t= formObj.location_type.value;\n\tvar new_baseline_yn\t\t\t\t= formObj.new_baseline_yn.value;\n\tformObj.new_baseline_yn.value=\"N\"; //Initialize to NO after calling\n\tvar chart_num = new_chart_num;\n\n\tvar oh_chart_level = formObj.oh_chart_level.value;\n\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\tvar add_new_done_flag = formObj.add_new_done_flag.value;\n\tvar default_head_tab_add_new = formObj.default_head_tab_add_new.value;\n\tvar change_tab_validity_yn = formObj.change_tab_validity_yn.value;\n\t//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\tvar dflt_mixed_dentition_chart = formObj.dflt_mixed_dentition_chart.value;\n\tvar chart_type = formObj.chart_type.value;\n\t//\n\t//Added by Sharon Crasta on 1/7/2010 for IN017822\n\t//If passed from treatment tab, Add New , The value will be \"Y\".\n\tvar loaded_from_trmt_tab = formObj.loaded_from_trmt_tab.value;\n\tvar date_diff_chart_num = formObj.date_diff_chart_num.value;//Added by Sridevi Joshi on 6/15/2010 for IN022000\n\n\tvar dentist_comments = \"\";\n\n\tif(cur_chart_num != \"\"){ //Added by Sridevi Joshi on 4/23/2010 for PE\n\t\t//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\tvar loaded_from_main_tab = formObj.loaded_from_main_tab.value;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar params = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=getDentistComments&\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar dentist_comments = trimString(xmlHttp.responseText);\n\t}\n\n\t //added by parul on 15/06/2010 for IN022086\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar params = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"ChatViewValidation.jsp?func_mode=CheckChartStatus&\"+params,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal_status = trimString(xmlHttp.responseText);\n\t\n\t//Added by Sharon Crasta on 1/6/2010 for IN017822\n\t//Not to load anything if the Chart Type flags are not in the forward sequence\n\tvar flag_disable = false;\n\t//End\n\t/*if(add_new_done_flag==\"Y\"){\n\t\tadd_new_yn = \"Y\";\n\t} */\n\t\t//if(add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\"){\n\t\tif(show_new_active_yn==\"Y\"){\n\t\t\tchart_num=new_chart_num;\n\t\t}else if(called_from_cond_trt_tab_flag == \'P\'){ // Bcoz we shud not get alert msg in case of periodontal summary tab (added on 14/12/07)\n\t\t\tchart_num=cur_chart_num;\n\t\t\tshow_new_active_yn = \"N\";\n\t\t}\n\t\telse{\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"patient_id=\"+patient_id+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=checkForActiveChart&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\tif(retVal.length>1){\n\t\t\t\tvar retVal_arr = retVal.split(\"~\");\n\t\t\t\tfor(var i=0;i<retVal_arr.length-1;i++){\n\t\t\t\t\tvar code_desc_arr = retVal_arr[i].split(\"##\");\n\t\t\t\t\tif(code_desc_arr[2] == \"Y\"){ //active_chart\n\t\t\t\t\t\t//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t//Added so that the permanent_deciduous_flag can be set on refresh if the chart is \"RM\".\n\n\t\t\t\t\t\tif(code_desc_arr[3]==\"RM\"){\n\t\t\t\t\t\t\tif(code_desc_arr[4] == \"D\"){\n\t\t\t\t\t\t\t permanent_deciduous_flag = \"D\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t permanent_deciduous_flag = \"P\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t} \n\t\t\t\t\t\tif(chart_type == \"RA\"){\n\t\t\t\t\t\t\t permanent_deciduous_flag = \"P\";\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//\n\t\t\t\t\t\t//Addded by Sharon Crasta on 1/6/2010 for IN017822\n\t\t\t\t\t\t//If the active chart is Mixed and the chart_type is Deciduous then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. \n\t\t\t\t\t\tif(code_desc_arr[3] == \"RM\" && (chart_type == \"RD\" && deciduous_grace_period_valid == \"N\")) {\n\t\t\t\t\t\t   //\tvar allow_flag = confirm(\"The Active chart should be closed. Do you want to create a new chart?\");\n\t\t\t\t\t\t   \tvar allow_flag = confirm(getMessage(\"APP-OH000153\",\"OH\"));\n\t\t\t\t\t\t\tif(allow_flag){\n\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&chart_type=\"+chart_type;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t/*if(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t//parent.frames[0].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\t//parent.parent.condTabDentalChartFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\tflag_disable = true;\n\t\t\t\t\t\t\t\tchart_type = code_desc_arr[3];\n\t\t\t\t\t\t\t\tif(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tchart_num = cur_chart_num;\n\t\t\t\t\t\t\t\tmixed_dentition_YN = \"Y\";\n\t\t\t\t\t\t\t\t//top.history.back();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//If the active chart is Permanent and the chart_type is Deciduous then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. \n\t\t\t\t\t\telse if(code_desc_arr[3] == \"RA\" && (chart_type == \"RD\" && deciduous_grace_period_valid == \"N\")){\n\t\t\t\t\t\t   //\tvar allow_flag = confirm(\"The Active chart should be closed. Do you want to create a new chart?\");\n\t\t\t\t\t\t   \tvar allow_flag = confirm(getMessage(\"APP-OH000153\",\"OH\"));\n\t\t\t\t\t\t\tif(allow_flag){\n\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&chart_type=\"+chart_type;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t/*if(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t} */\n\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t//parent.frames[0].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\t//parent.parent.condTabDentalChartFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\tflag_disable = true;\n\t\t\t\t\t\t\t\tchart_type = code_desc_arr[3];\n\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\tchart_num = cur_chart_num;\n\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t//top.history.back();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//If the active chart is Permanent and the chart_type is Mixed then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. \n\t\t\t\t\t\telse if(code_desc_arr[3] == \"RA\" && (chart_type == \"RD\" && deciduous_grace_period_valid == \"Y\")){\n\t\t\t\t\t\t   //\tvar allow_flag = confirm(\"The Active chart should be closed. Do you want to create a new chart?\");\n\t\t\t\t\t\t   \tvar allow_flag = confirm(getMessage(\"APP-OH000153\",\"OH\"));\n\t\t\t\t\t\t\tif(allow_flag){\n\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&chart_type=RM\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\tif(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t//parent.frames[0].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\t//parent.parent.condTabDentalChartFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\tflag_disable = true;\n\t\t\t\t\t\t\t\tchart_type = code_desc_arr[3];\n\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\tchart_num = cur_chart_num;\n\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t//top.history.back();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//If the active chart is Permanent and the chart_type is Mixed then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. \n\t\t\t\t\t\telse if(code_desc_arr[3] == \"RA\" && chart_type == \"RM\"){\n\t\t\t\t\t\t   //\tvar allow_flag = confirm(\"The Active chart should be closed. Do you want to create a new chart?\");\n\t\t\t\t\t\t   \tvar allow_flag = confirm(getMessage(\"APP-OH000153\",\"OH\"));\n\t\t\t\t\t\t\tif(allow_flag){\n\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&chart_type=\"+chart_type;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\tif(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t//parent.frames[0].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\t//parent.parent.condTabDentalChartFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\t\tflag_disable = true;\n\t\t\t\t\t\t\t\tchart_type = code_desc_arr[3];\n\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\tchart_num = cur_chart_num;\n\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t//top.history.back();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}//End\n\t\t\t\t\t\telse if(mixed_dentition_YN == \"Y\" && code_desc_arr[3] == \"RD\"){\n\t\t\t\t\t\t\tif(deciduous_grace_period_valid == \'Y\'){\n\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t\t//if(other_chart_facility_id == facility_id){\n\n\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\t//if((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\"))) {\n\t\t\t\t\t\t\t\tif((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\")) && (loaded_from_main_tab == \"Y\" || loaded_from_main_tab == \"\" || loaded_from_main_tab == \"null\" || loaded_from_main_tab == null || loaded_from_main_tab == \"undefined\")) {\n\t\t\t\t\t\t\t\t if (retVal_status>0){\t//added by parul on 15/06/2010 for IN022086\n\t\t\t\t\t\t\t\t\tvar msg=getMessage(\"APP-OH000186\",\"OH\");\n\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\tchart_type=\"RD\"\n\t\t\t\t\t\t\t\t\tmixed_dentition_YN=\"N\"\t\t\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\";\n\t\t\t\t\t\t\t\t }else{\n\t\t\t\t\t\t\t\t\t\tvar new_old = confirm(getMessage(\"APP-OH0007\",\'OH\'));\n\t\t\t\t\t\t\t\t\t\tif(new_old){\n\t\t\t\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\t\t\t\t//show_new_active_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t\t\t\t\t\t\t\t\t//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t\t\t\t\t//params = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&chart_type=RM\";\n\t\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&chart_type=RM\";\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\t\t\t\tif(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\t\t  \t}else{\n\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\";\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t }\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t/*}else{\n\n\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\tmixed_dentition_YN = \"N\";\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flsg = \"D\";\n\t\t\t\t\t\t\t\t} */\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t\t//if(other_chart_facility_id == facility_id){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t\t\t\t\t\t//if((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\"))) {\n\t\t\t\t\t\t\t\tif((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\")) && (loaded_from_main_tab == \"Y\" || loaded_from_main_tab == \"\" || loaded_from_main_tab == \"null\" || loaded_from_main_tab == null || loaded_from_main_tab == \"undefined\")) {\n\t\t\t\t\t\t\t\t  if (retVal_status>0){\t//added by parul on 15/06/2010 for IN022086\n\t\t\t\t\t\t\t\t\tvar msg=getMessage(\"APP-OH000186\",\"OH\");\n\t\t\t\t\t\t\t\t\talert(msg)\n\t\t\t\t\t\t\t\t\tchart_type=\"RD\"\n\t\t\t\t\t\t\t\t\tmixed_dentition_YN=\"N\"\t\t\n\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\";\n\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\"APP-OH0008\",\'OH\'));\n\t\t\t\t\t\t\t\t\t\t//show_new_active_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&chart_type=RM\";\n\n\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\n\t\t\t\t\t\t\t\t\t\tif(dflt_mixed_dentition_chart==\"D\"){\n\t\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"D\"; // Deciduous\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\tpermanent_deciduous_flag = \"P\"; // Permament\n\t\t\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}//\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(permanent_deciduous_flag == \"P\" && (code_desc_arr[3] == \"RD\" || code_desc_arr[3] == \"RM\") && (mixed_dentition_YN == \"N\")){\n\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t//if(other_chart_facility_id == facility_id){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t\t\t\t\t//if((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\"))) {\n\t\t\t\t\t\t\tif((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\")) && (loaded_from_main_tab == \"Y\" || loaded_from_main_tab == \"\" || loaded_from_main_tab == \"null\" || loaded_from_main_tab == null || loaded_from_main_tab == \"undefined\")) {\n\t\t\t\t\t\t\t\t if (retVal_status>0){\t//added by parul on 15/06/2010 for IN022086\n\t\t\t\t\t\t\t\t\talert(getMessage(\"APP-OH000186\",\'OH\'));\n\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t//chart_type=\"RM\"\n\t\t\t\t\t\t\t\t\tmixed_dentition_YN=\"Y\"\n\t\t\t\t\t\t\t\t\tif(code_desc_arr[4]==\"D\"){\n\t\t\t\t\t\t\t\t\t   permanent_deciduous_flag=\"D\";\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t    permanent_deciduous_flag=\"P\";\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t }else{\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\"APP-OH0009\",\'OH\'));\n\t\t\t\t\t\t\t\t\t\t/*commented on 03/09/07 and";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 =" added the below uncommented line\n\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id;\n\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=paintNewChart&\"+params,false);\n\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\t\t//show_new_active_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782\n\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&chart_type=RA\";\n\n\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=updateChartStatus&\"+params,false);\n\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t} \n\t\t\t\t\t\telse if((permanent_deciduous_flag == \"D\" && code_desc_arr[3] == \"RD\") || (permanent_deciduous_flag == \"P\" && code_desc_arr[3] == \"RA\") || mixed_dentition_YN == \"Y\"){\n\t\t\t\t\t\t\tcode_desc_arr[0] = parseInt(code_desc_arr[0]);\n\t\t\t\t\t\t\tcode_desc_arr[1] = parseInt(code_desc_arr[1]);\n\t\t\t\t\t\t\tif(code_desc_arr[0] < code_desc_arr[1]){ //chart_days < rest_chrt_val_days\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tchart_num=cur_chart_num; // added this line after uncommenting the chart_days in CommomValidation\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(code_desc_arr[0] >= code_desc_arr[1] && code_desc_arr[1] > 0){  //chart_days >= rest_chrt_val_days //condition for code_desc_arr[1] > 0 is added by Sridevi Joshi on 6/2/2010 for IN021769\n\t\t\t\t\t\t\t//else if(code_desc_arr[0] >= code_desc_arr[1]){  //chart_days >= rest_chrt_val_days //condition for code_desc_arr[1] > 0 is added by Sridevi Joshi on 6/2/2010 for IN021769\n\t\t\t\t\t\t\t\tif((other_chart_facility_id == facility_id) && ((add_new_yn == \"N\" || add_new_yn == \"\" || add_new_yn == \"null\" || add_new_yn == null || add_new_yn == \"undefined\") || (add_new_done_flag == \"N\" || add_new_done_flag == \"\" || add_new_done_flag == \"null\" || add_new_done_flag == null || add_new_done_flag == \"undefined\") || (change_tab_validity_yn == \"Y\")) && (loaded_from_main_tab == \"Y\" || loaded_from_main_tab == \"\" || loaded_from_main_tab == \"null\" || loaded_from_main_tab == null || loaded_from_main_tab == \"undefined\")) {\n\t\t\t\t\t\t\t\t\t\n                                 if (retVal_status>0){\t//added by parul on 15/06/2010 for IN022086\n\t\t\t\t\t\t\t\t\t\tvar msg=getMessage(\"APP-OH000187\",\"OH\");\n\t\t\t\t\t\t\t\t\t\talert(msg);\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t}else{//end added by parul on 15/06/2010 for IN022086\n\n\t\t\t\t\t\t\t\t\t\tvar new_old = confirm(getMessage(\"APP-OH00010\",\'OH\'));\n\t\t\t\t\t\t\t\t\t\tif(new_old){\n\t\t\t\t\t\t\t\t\t\t\tchart_num=new_chart_num;\n\t\t\t\t\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id;\n\t\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=paintNewChart&\"+params,false);\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\t\t\tvar copy_yn = confirm(getMessage(\"APP-OH00022\",\"OH\")) \n\t\t\t\t\t\t\t\t\t\t\tif(copy_yn){\n\t\t\t\t\t\t\t\t\t\t\t//Added by Sharon Crasta on 4/1/2009 for CRF #0423\n\t\t\t\t\t\t\t\t\t\t\t\tcopy_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\t\tcopy_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\t\t//show_new_active_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\t\tadd_new_yn = \"Y\"; // This is to clear the clinical group code for new chart...\n\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t//\n\t\t\t\t\t\t\t\t\t\t\t//Commented by sharon Crasta on 4/1/2009 for CRF #0423\n\t\t\t\t\t\t\t\t\t\t\t//params = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type;\n\t\t\t\t\t\t\t\t\t\t\t//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)\n\t\t\t\t\t\t\t\t\t\t\t//params = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&copy_yn=\"+copy_yn;\n\t\t\t\t\t\t\t\t\t\t\tparams = \"patient_id=\"+patient_id+\"&chart_num=\"+cur_chart_num+\"&old_facility_id=\"+facility_id+\"&encounter_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&episode_id=\"+episode_id+\"&episode_type=\"+episode_type+\"&visit_id=\"+visit_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id+\"&dentist_comments=\"+dentist_comments+\"&copy_yn=\"+copy_yn;\n\t\t\t\t\t\t\t\t\t\t\txmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"DentalChartCommonValidation.jsp?func_mode=copyPrevTrmtCond&\"+params,false);\n\t\t\t\t\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\t\t\t\t\t\t\tretVal = trimString(xmlHttp.responseText);\n\n\t\t\t\t\t\t\t\t\t\t\t\t//show_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\t//}\n\t\t\t\t\t\t\t\t\t\t\t/*else{\n\t\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"Y\";\n\t\t\t\t\t\t\t\t\t\t\t\tadd_new_yn = \"Y\"; // This is to clear the clinical group code for new chart...\n\t\t\t\t\t\t\t\t\t\t\t} */\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\t\t\t   chart_num=cur_chart_num;\n\t\t\t\t\t\t\t\t\t\t\t//chart_num=new_chart_num;\n\t\t\t\t\t\t\t\t\t//}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{ //Added by Sridevi Joshi on 6/7/2010 for IN021769\n\t\t\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t\t\t\tchart_num=cur_chart_num;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t//}\n\t\t\t\t}else{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t//chart_num=cur_chart_num;\n\t\t\t\t\t\tshow_new_active_yn = \"N\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t//}\n\t\tif(date_diff_flag == \"disable\"){//Addded by Sridevi Joshi on 6/15/2010 for IN022000\n\t\t\tchart_num = date_diff_chart_num;\n\t\t}\n\t\tformObj.show_new_active_yn.value=show_new_active_yn;\n\t\t/* modified by bshankar for Add/New logic from BaseLine chart\n\t\t// Modified to parent.parent.condTabDentalChartFrame.location.search\n\t\tparams = formObj.params.value; \n\t\t*/\n\n\t\t//params = parent.parent.condTabDentalChartFrame.location.search;\n\t\t// above line is modified by bshankar on 14th Jan 2008. The frame parent.parent.parent.condTabDentalChartFrame will be used for Periodontal Chart Summary Tab. Initially this is being called from single Tab and now it has been called from Secondary Tab Under the Summary Tab.\n\t\t// Changed from here\n\t\tif(parent.parent.parent.condTabDentalChartFrame!=null){\n\t\t\t// Used for Summary Tab\n\t\t\tparams = parent.parent.parent.condTabDentalChartFrame.location.search;\n\t\t}else{\n\t\t\t// Used for Condition Tab and Treatments Tab\n\t\t\tparams = parent.parent.condTabDentalChartFrame.location.search;\n\n\t\t}\n\t\t// Changed till here\n\t\tchart_hdr_insert_yn=show_new_active_yn;//initialize\n\t\tif(cur_chart_num==\"0\" || cur_chart_num==null ||cur_chart_num==\"\")\n\t\t\tchart_hdr_insert_yn=\"Y\";\n\t\t//parent.conditionDentalChart.location.href=\"../../eOH/jsp/OHCondDentalChartFrame.jsp?\"+params;\n\t\tvar default_head_tab = \"\";\n\t\t\n\t\tif(called_from_cond_trt_tab_flag==null || called_from_cond_trt_tab_flag==\"\"){\n\t\t\tif(main_tab != \"\" && main_tab != null){ //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.\n\t\t\t\tif(main_tab == \"Treatment\"){\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"T\";\n\t\t\t\t}\n\t\t\t\t//Commented and Added by Sharon Crasta on 1/7/2010 for IN017822\n\t\t\t\t//Added to display the treatment related frames when Add new done from Trmt Tab. After some continuous iterations of Add New, the condition frames were getting loaded.\n\t\t\t\t//else if(main_tab == \"Condition\"){\n\t\t\t\telse if(main_tab == \"Condition\" && loaded_from_trmt_tab != \"Y\"){\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"C\";\n\t\t\t\t}\n\t\t\t\telse if(loaded_from_trmt_tab == \"Y\"){\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"T\";\n\t\t\t\t\tmain_tab = \"Treatment\";\n\t\t\t\t}//End\n\t\t\t\telse{\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"P\";\n\t\t\t\t}\n\t\t\t\tdefault_head_tab = main_tab;\n\t\t\t}\n\t\t\telse{// Added by Sharon Crasta on 1/7/2010 for IN017822\n\t\t\t\t//Added to display the treatment related frames when Add new done from Trmt Tab. After some continuous iterations of Add New, the condition frames were getting loaded.\n\t\t\t\tif(loaded_from_trmt_tab == \"Y\"){\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"T\";\n\t\t\t\t\tdefault_head_tab = \"Treatment\";\n\t\t\t\t}else{//End\n\t\t\t\t\tcalled_from_cond_trt_tab_flag=\"C\";\n\t\t\t\t\tdefault_head_tab = \"Condition\";\n\t\t\t\t}\n\t\t\t}\n\t\n\t\t\n\t\t//parent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab;\n\t\t// above line is modified by bshankar on 14th Jan 2008. The frame parent.parent.parent.mainTabHeaderFrame will be used for Periodontal Chart Summary Tab. Initially this is being called from single Tab and now it has been called from Secondary Tab Under the Summary Tab.\n\t\t// Changed from here\n\n\t\tif(parent.parent.parent.mainTabHeaderFrame!=null){\t\n\t\t\t// Used for summary Tab\n\t\t\tif(flag_disable){\n\t\t\t\tparent.parent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab+\"&chart_disable_from_main=Y\";\n\t\t\t}else{\n\t\t\t\tparent.parent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab;\n\t\t\t}\n\t\t}\n\t\t//Added by Sharon Crasta on 1/6/2010 for IN017822\n\t\t//This flag is not to load the Tabs when the Chart Type flags are not in the forward sequence. For e.g., if the active chart is RM and the DOB is changed to a deciduous chart, then the tabs should not be loaded.\n\t\t/*else if(flag_disable){\n\t\t\t//parent.parent.mainTabHeaderFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\ttop.history.back();\n\t\t}*///End\n\t\telse{\t\t\t\n\t\t\t// Used for Condition Tab and Treatments Tab\n\t\t\t//parent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab;\n\t\t\t//parent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block7_3 ="_add_new=\"+default_head_tab_add_new+\"&add_new_yn=\"+add_new_yn;\n\t\t\tif(flag_disable){\n\t\t\t\tparent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab+\"&add_new_yn=\"+add_new_yn+\"&chart_disable_from_main=Y\";\n\t\t\t}else{\n\t\t\t\tparent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab+\"&add_new_yn=\"+add_new_yn;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t/*\n\t\tif((called_from_cond_trt_tab_flag!=null || called_from_cond_trt_tab_flag!=\"\") && (add_new_done_flag == \"Y\" || add_new_yn == \"Y\")){\n\t\t\tif(called_from_cond_trt_tab_flag == \"C\"){\n\t\t\t\tdefault_head_tab=\"Condition\";\n\t\t\t}else if(called_from_cond_trt_tab_flag == \"T\"){\n\t\t\t\tdefault_head_tab=\"Treatment\";\n\t\t\t}\n\t\t\tparent.parent.mainTabHeaderFrame.location.href=\"../../eOH/jsp/OHDentalChartTabSearch.jsp?\"+params+\"&default_head_tab=\"+default_head_tab;\n\t\t\n\t\t} */\n\n\t\t//alert(\"called_from_cond_trt_tab_flag:==\"+called_from_cond_trt_tab_flag);\n\t\tif(called_from_cond_trt_tab_flag==\"C\"){\n\t\t\t//params1=parent.parent.mainTabHeaderFrame.location.search;\n\t\t\t//params1=parent.parent.conditionDentalChartView.frames[0].frames[2].location.search;\n\t\t\t\t//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)\n\t\t\t\t//Commented and added by Sharon Crasta on 1/6/2010 for IN017822\n\t\t\t\t//A new parameter params_cond is written so that the newly craeted params are placed 1st in the query string \n\t\t\t\t//params=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=C&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn;\n\t\t\t\tvar params_cond =\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=C&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn;\n\n\t\t\t\n\t\t\t\tparams =  params_cond + params;\n\t\t\t\tif(flag_disable){\n\t\t\t\t\tparams = params + \"&chart_disable_from_main=Y\";\n\t\t\t\t\tparent.parent.frames[0].document.getElementById(\"numbering_system\").disabled = true;\n\t\t\t\t\tparent.parent.frames[0].document.getElementById(\"asOnDate\").disabled = true;\n\t\t\t\t\tparent.parent.frames[0].document.getElementById(\"asOnDateCal\").disabled = true;\n\t\t\t\t\tparent.parent.frames[0].document.getElementById(\"refresh_icon\").disabled = true;\n\t\t\t\t}\n\t\t\t\t//End\n\t\t\t   \t//params=\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=C&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn+\"&\"+params;\n\t\t\t\tparent.conditionDentalChart.location.href=\"../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?\"+params;\n\t\t}\n\t\telse if(called_from_cond_trt_tab_flag==\"T\"){\n\t\t\t//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)\n\t\t\t//params=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn;\n\t\t\t//var params1=\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn+\"&\"+params;\n\t\t\tvar params1=\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn+\"&default_head_tab=\"+default_head_tab+\"&main_tab=\"+main_tab+\"&\"+params;\n\t\t\t//var params1=\"&\"+params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn;\n\n\t\t\t//alert(\"params1:==\"+params1);\n\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?\"+params;\n\t\t\t//Added by Sharon Crasta on 1/8/2010 for IN017822\n\t\t\t//Sometimes the trmtDentalChart frame is not got. So if it is null, then load the higher frame in the else loop.\n\t\t\tif(flag_disable){\n\t\t\t\tparams1 = params1 + \"&chart_disable_from_main=Y\";\n\t\t\t}\n\t\t\tif(parent.trmtDentalChart != null){\n\t\t\t\tparent.trmtDentalChart.location.href=\"../../eOH/jsp/OHDentalChartTrmtDetailsFrame.jsp?\"+params1;\n\t\t\t}else{\n\t\t\t   parent.frames[1].location.href=\"../../eOH/jsp/OHDentalChartTrmtDetailsFrame.jsp?\"+params1;\n\t\t\t}  //End\n\t\t}\n\t\telse{\t\t\t\n\t\t\t//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)\n\t\t\t//params=params+\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn;\n\n\t\t\tparams=\"&show_new_active_yn=\"+show_new_active_yn+\"&chart_num=\"+chart_num+\"&chart_hdr_insert_yn=\"+chart_hdr_insert_yn+\"&header_tab=T&new_chart_num=\"+new_chart_num+\"&cur_chart_num=\"+cur_chart_num+\"&permanent_deciduous_flag=\"+permanent_deciduous_flag+\"&mixed_dentition_YN=\"+mixed_dentition_YN+\"&date_diff_flag=\"+date_diff_flag+\"&add_new_yn=\"+add_new_yn+\"&\"+params;\n\n\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?\"+params;\n\t\t\t//parent.perioSummaryFrame.location.href=\"../../eOH/jsp/PeriodontalSummary.jsp?\"+params;\n\t\t\t// Modified the below code by bshankar as the Tab is changed. Backup is taken (Folder: D:\\Work\\1_Projects\\10.2\\OH\\Backups\\12012008)\n\t\t\tparent.parent.SummaryTabDetailsFrame.perioSummaryFrame.location.href=\"../../eOH/jsp/PeriodontalSummary.jsp?\"+params;\n\t\t}\n\n\t//changeTabColor(called_from_cond_trt_tab_flag);\n\t\n}\n/*\nfunction changeTabColor(called_from_cond_trt_tab_flag){\n\t//var main_tab = document.forms[0].main_tab.value;\n\tvar cond_label = getLabel(\"eOH.Conditions.Label\",\"OH\");\n\tvar trmt_label = getLabel(\"eOH.Treatments.Label\",\"OH\");\n\tif(called_from_cond_trt_tab_flag == \"T\"){\n\t\tif(parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != \"null\" && parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != null){\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").innerHTML = \'<font color=\"white\"><b>\'+trmt_label+\'</b></font>\';\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.backgroundColor = \"green\";\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.color=\"red\";\n\t\t}\n\t}\n\telse if(called_from_cond_trt_tab_flag == \"C\"){\n\t\tif(parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != \"null\" && parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != null){\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").innerHTML = \'<font color=\"white\"><b>\'+cond_label+\'</b></font>\';\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.backgroundColor = \"brown\";\n\t\t\tparent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.color = \"white\";\n\t\t}\n\t}\n\telse{\n\t\tif(parent.parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != \"null\" && parent.parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\") != null){\n\t\t\tparent.parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").innerHTML = \"\";\n\t\t\tparent.parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.backgroundColor = \"white\";\n\t\t\tparent.parent.parent.mainTabHeaderFrame.document.getElementById(\"tabColor\").style.color = \"white\";\n\t\t}\n\t}\n}\n*/\n</script>\n\n<html>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" >\n<form name=\"OHFrameForm\" id=\"OHFrameForm\"  >\n     <input type=\"hidden\" name=\'locale\' id=\'locale\' value=";
    private final static byte[]  _wl_block7_3Bytes = _getBytes( _wl_block7_3 );

    private final static java.lang.String  _wl_block8 =" >\n\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type = \"hidden\" name= \"cur_chart_num\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type = \"hidden\" name= \"new_chart_num\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type = \"hidden\" name= \"mixed_dentition_YN\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type = \"hidden\" name= \"called_from_cond_trt_tab_flag\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\n\t<input type = \"hidden\" name= \"show_new_active_yn\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type = \"hidden\" name= \"date_diff_flag\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type = \"hidden\" name= \"main_tab\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type = \"hidden\" name= \"add_new_yn\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\n\t<input type = \"hidden\" name= \"episode_id\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type = \"hidden\" name= \"episode_type\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type = \"hidden\" name= \"visit_id\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type = \"hidden\" name= \"location_code\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type = \"hidden\" name= \"location_type\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type = \"hidden\" name= \"new_baseline_yn\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type = \"hidden\" name= \"add_new_done_flag\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type = \"hidden\" name= \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type = \"hidden\" name= \"old_facility_id\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type = \"hidden\" name= \"default_head_tab_add_new\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type = \"hidden\" name= \"change_tab_validity_yn\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->\n\t<input type=\"hidden\" name=\"dflt_mixed_dentition_chart\" id=\"dflt_mixed_dentition_chart\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"chart_type\" id=\"chart_type\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<!-- -->\n\t<!--Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)-->\n\t<input type=\"hidden\" name = \"loaded_from_main_tab\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name = \"dentist_comments\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<!-- -->\n\t<!--Added by Sharon Crasta on 1/7/2010 for IN017822-->\n\t<input type=\"hidden\" name = \"loaded_from_trmt_tab\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name = \"date_diff_chart_num\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\n</form>\n\t<script>\n\t\tcheckForActiveChart();\t\t\n\t</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	

	String facility_id = (String)session.getValue("facility_id");
	//String patient_id = "SD00000085";//request.getParameter("patient_id");
	String patient_id = request.getParameter("patient_id");
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	String encounter_id = request.getParameter("encounter_id"); 
	String patient_class = request.getParameter("patient_class"); 
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag")); 
	String main_tab = checkForNull(request.getParameter("main_tab")); 
	String add_new_yn = checkForNull(request.getParameter("add_new_yn")); 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")); 
//	String cur_chart_num = checkForNull(request.getParameter("cur_chart_num")); 
//	String new_chart_num = checkForNull(request.getParameter("new_chart_num")); 
	String new_chart_num = "1"; 
	String cur_chart_num = ""; 

	String mixed_dentition_YN = checkForNull(request.getParameter("MD_yn")); 
	String permanent_deciduous_flag = checkForNull(request.getParameter("PD_flag")); 
	String deciduous_grace_period_valid = checkForNull(request.getParameter("deciduous_grace_period_valid")); 
	String called_from_cond_trt_tab_flag = checkForNull(request.getParameter("called_from_cond_trt_tab_flag")); 
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String other_facilitychart_yn  = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;			
	String add_new_done_flag = checkForNull(request.getParameter( "add_new_done_flag" )) ;			
	String old_facility_id = checkForNull(request.getParameter( "old_facility_id" )) ;			
	String change_tab_validity_yn = checkForNull(request.getParameter( "change_tab_validity_yn" )) ;			
	//String other_facility_yn = checkForNull(request.getParameter( "other_facility_yn" )) ;			
	// When clicked from the Add/New link in BaseLine Chart on RHS Menu of Dental Condition Tab
	String new_baseline_yn = checkForNull(request.getParameter("new_baseline_yn"));

	new_baseline_yn=new_baseline_yn==null?"N":new_baseline_yn;
	new_baseline_yn=new_baseline_yn.equals("null")?"N":new_baseline_yn;
	new_baseline_yn=new_baseline_yn.equals("")?"N":new_baseline_yn;

		//String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	}
 	String default_head_tab_add_new =checkForNull(request.getParameter("default_head_tab_add_new"));
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}
			
	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
    String loaded_from_main_tab = checkForNull(request.getParameter( "loaded_from_main_tab" )) ;
    String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;
	//
	
	//Added by Sharon Crasta on 1/7/2010 for IN017822
	//If passed from treatment tab, Add New , The value will be "Y".
	String loaded_from_trmt_tab = checkForNull(request.getParameter( "loaded_from_trmt_tab" )) ;
	String date_diff_chart_num = checkForNull(request.getParameter( "date_diff_chart_num" )) ;//Added by Sridevi Joshi on 6/15/2010 for IN022000
	

/*
	if(chart_flag.equals("R")){ // Restorative Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else if(chart_flag.equals("P")){ // Periodontal Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}
*/
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

try{
	con = ConnectionManager.getConnection(request);
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}
	if(oh_chart_level.equals("E")){

		//Get the Active Chart
	//	pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM,CHART_NUM CUR_CHART_NUM, CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,SYSDATE FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}

	}
	else{
		//Get the Active Chart
		//pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM,CHART_NUM CUR_CHART_NUM, CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,SYSDATE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID,CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		if(add_new_yn.equals("Y")){
			pstmt.setString(1,facility_id);
		
		}else{
				pstmt.setString(1,other_chart_facility_id);
		}
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
			other_chart_facility_id = rs.getString("OPERATING_FACILITY_ID");
		}
	}
		
		
		pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ?  ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			new_chart_num = rs.getString("NEW_CHART_NUM");
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(deciduous_grace_period_valid));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            _bw.write(_wl_block7_3Bytes, _wl_block7_3);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cur_chart_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_chart_num));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from_cond_trt_tab_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(show_new_active_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(main_tab));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(add_new_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(new_baseline_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(add_new_done_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(default_head_tab_add_new));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(change_tab_validity_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dflt_mixed_dentition_chart));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(loaded_from_main_tab));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dentist_comments));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(loaded_from_trmt_tab));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(date_diff_chart_num));
            _bw.write(_wl_block41Bytes, _wl_block41);

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
}
