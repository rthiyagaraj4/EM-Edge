package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __ohdentalcharttabsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDentalChartTabSearch.jsp", 1709119347942L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6_0 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<!-- <style>\n\t.tabA{\n\t\tcolor: white;\n\t\tbackground: blue  url(\"../../eCommon/images/tab_left_corner.gif\")  left top no-repeat;\n\t\ttext-decoration: overline;color:black;\n\t\tpadding-left: 10px\n\t} \n\n\t.tabAspan {\n\t\tbackground: blue url(\"../../eCommon/images/tab_right_corner.gif\") right top no-repeat;\n\t\ttext-decoration: overline;color:white;\n\t\tpadding-right: 10px;\n\t\theight:15\n\t} \n\n\t.tabClicked {\n\t \n\t\tbackground: green url(\"../../eCommon/images/tab_left_corner_click.gif\") left top no-repeat;\n\t\ttext-decoration: overline;color: yellow;\n\t\tpadding-left: 10px\n\t}\n\n\t.tabSpanclicked {\n\t\tbackground: green url(\"../../eCommon/images/tab_right_corner_click.gif\") right top no-repeat;\n\t\ttext-decoration: overline;color:yellow;\n\t\tpadding-right: 10px;\n\t\theight:15\n\t}\n</style> -->\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n<script language=\"javascript\">\nfunction changeTab(objStr){\n\tvar frmObj=document.forms[0];\n\tvar baseline_chart_yn=frmObj.baseline_chart_yn.value;\n\tvar chart_flag=frmObj.chart_flag.value;\n\tvar patient_id=frmObj.patient_id.value;\n\tvar visit_id=frmObj.visit_id.value;\n\tvar episode_id=frmObj.episode_id.value;\n\tvar encounter_id=frmObj.encounter_id.value;\n\tvar location_code=frmObj.location_code.value;\n\tvar location_type=frmObj.location_type.value;\n\tvar episode_type=frmObj.episode_type.value;\n\tvar patient_class=frmObj.patient_class.value;\n\tvar other_facilitychart_yn=frmObj.other_facilitychart_yn.value;\n\tvar disable = \"\";\n\t//Added by Sharon Crasta on 1/11/2010 for IN017822\n\t//Added chart_disable_from_main as \"Y\" in order to disable the chart on click of Cancel button of APP-OH000153 message\n\tvar chart_disable_from_main = document.forms[0].chart_disable_from_main.value;\n\tif(baseline_chart_yn == \"Y\" || other_facilitychart_yn == \"Y\" || chart_disable_from_main == \"Y\"){//End\n\t\tdisable = \"disabled\";\n\t}\n\t//Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700\n\t//Added to display the print icon only when atleast one chart is present\n\tvar other_chart_facility_id = frmObj.other_chart_facility_id.value;\n\tvar oh_chart_level = frmObj.oh_chart_level.value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar query_print_params = \"patient_id=\"+patient_id+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=getCountOfCharts&\"+query_print_params,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal_print = trimString(xmlHttp.responseText);\n\tvar count_chart=localTrimString(retVal_print);\n\t//Added by Sharon Crasta on 2/22/2010 for IN019266\n\tif(count_chart == 0){\n\t\tdisable = \"disabled\";\n\t}\n\t//End\n\t\n\n//chart_flag=R&locale=en&patient_id=BL09000953&visit_id=&episode_id=100114530001&encounter_id=100114530001&location_code=CL34&location_type=C&episode_type=O&patient_class=OP\n\t//if(other_facilitychart_yn != \"Y\"){\n\t//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822\n\t//Added chart_disable_from_main != \"Y\" in order to disable the chart on click of Cancel button of APP-OH000153 message\n\t//if(baseline_chart_yn != \"Y\" && other_facilitychart_yn!=\"Y\"){ //added by parul  for other facility chart CRF#0423\n\tif(baseline_chart_yn != \"Y\" && other_facilitychart_yn!=\"Y\" && chart_disable_from_main != \"Y\"){\n\t\tselectTab(objStr);\n\t\tvar param=frmObj.param.value;\n\t\tvar hdr_param = \"\";\n\t    var called_from_cond_trt_tab_flag=\"\";\n\t\tvar change_tab_validity_yn = \"\";\n\t\t//param=parent.condTabDentalChartFrame.location.search;\n\t\tswitch(objStr){\n\t\t\tcase \"Condition\": \n\t\t\t\t  called_from_cond_trt_tab_flag = \"C\";\n\t\t\t\t  hdr_param = \"chart_flag=\"+chart_flag+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&episode_type=\"+episode_type+\"&patient_class=\"+patient_class;\n\t\t\t\t  //param = parent.frames[3].document.forms[0].ca_params.value;\n\t\t\t\t  param=param+\"&called_from_cond_trt_tab_flag=C\"+\"&change_tab_validity_yn=Y\";\n\t\t\t\t \n\t\t\t\t  parent.frames[2].location.href=\"../../eOH/jsp/OHCondDentalChartFrame.jsp?\"+param;\n\t\t\t\t  //parent.frames[2].location.href=\"../../eOH/jsp/OHCondDentalChartFrame.jsp?\"+param+\"&loaded_from_main_tab=Y\";\n\t\t\t\t  //parent.frames[0].location.href=\"../../eOH/jsp/OHDentalChartToolHeader.jsp?\"+hdr_param+\"&tab_clicked=C\";// This parameter is to display only condition images in the tool header frame\n\t\t\t\t  parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t  //window.location.href=\"../../eOH/jsp/ConditionFrame.jsp?\"+param;\n\n\t\t\t\t  //Added by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)\n\t\t\t\t  parent.conditionDentalChartToolHeader.document.getElementById(\"print_chart\").innerHTML = \"<img src=\'../../eOH/images/Refresh.gif\' alt=\'Refresh\' onclick=\'changeNumberingSystem()\'\"+disable+\" />\";\n\n\t\t\t\t  break;\n\n\n\t\t\tcase \"Diagnosis\": \n\t\t\t\t  //parent.frames[1].location.href=\"../../eOH/jsp/DiagnosisFrame.jsp?\"+param;\n\t\t\t\t  parent.frames[2].location.href=\"../../eMR/jsp/RecDiagnosis.jsp?\"+diag_params;\n\t\t\t\t   parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t  break;\n\t\t\tcase \"Treatment\": \n\t\t\t\t  called_from_cond_trt_tab_flag = \"T\";\n\t\t\t\t  hdr_param = \"chart_flag=\"+chart_flag+\"&patient_id=\"+patient_id+\"&visit_id=\"+visit_id+\"&episode_id=\"+episode_id+\"&encounter_id=\"+encounter_id+\"&location_code=\"+location_code+\"&location_type=\"+location_type+\"&episode_type=\"+episode_type+\"&patient_class=\"+patient_class;\n\t\t\t\t  param=param+\"&called_from_cond_trt_tab_flag=T&change_tab_validity_yn=Y\";\n\t\t\t\t  //parent.frames[2].location.href=\"../../eOH/jsp/OHTrmtDentalChartFrame.jsp?\"+param;\n\t\t\t\t  parent.frames[2].location.href=\"../../eOH/jsp/OHTrmtDentalChartFrame.jsp?\"+param+\"&loaded_from_main_tab=Y\";\n\t\t\t\t  //parent.frames[0].location.href=\"../../eOH/jsp/OHDentalChartToolHeader.jsp?\"+hdr_param+\"&tab_clicked=T\";// This parameter is to display only Trmts images in the tool header frame\n\t\t\t\t  parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\n\t\t\t\t  //Commented and Added by Sharon For Print Chart PMG20089-CRF-0700\n\t\t\t\t  //Added by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)\n\t\t\t\t  //parent.conditionDentalChartToolHeader.document.getElementById(\"print_chart\").innerHTML = \"<img id=\'print_img\' src=\'../../eOR/images/print-Preview.gif\' alt=\'Print\' style=\'cursor:pointer;\' onclick=\'printOverview();\' /><img src=\'../../eOH/images/Refresh.gif\' alt=\'Refresh\' onclick=\'changeNumberingSystem()\'\"+disable+\" />\";\n\t\t\t\t   //Commented and Added by Sharon Crasta on 2/22/2010 for IN019266\n\t\t\t\t  /*if(count_chart != 0){\n\t\t\t\t\t  parent.conditionDentalChartToolHeader.document.getElementById(\"print_chart\").innerHTML = \"<img id=\'print_img\' src=\'../../eOR/images/print-Preview.gif\' alt=\'Print\' style=\'cursor:pointer;\' onclick=\'printOverview();\' /><img src=\'../../eOH/images/Refresh.gif\' alt=\'Refresh\' onclick=\'changeNumberingSystem()\'\"+disable+\" />\";\n\t\t\t\t  }else{\n\t\t\t\t  \t   parent.conditionDentalChartToolHeader.document.getElementById(\"print_chart\").innerHTML = \"<img src=\'../../eOH/images/Refresh.gif\' alt=\'Refresh\' onclick=\'changeNumberingSystem()\'\"+disable+\" />\";\n\t\t\t\t  }\t*/\n\t\t\t\t   parent.conditionDentalChartToolHeader.document.getElementById(\"print_chart\").innerHTML = \"<img id=\'print_img\' src=\'../../eOR/images/print-Preview.gif\' alt=\'Print\' style=\'cursor:pointer;\' onclick=\'printOverview();\'\"+disable+\" /><img src=\'../../eOH/images/Refresh.gif\' alt=\'Refresh\' onclick=\'changeNumberingSystem()\' />\";\n\t\t\t\t //End\n\n\t\t\t\t  break;\n\t\t\tcase \"ClinicalNote\": \n\t\t\t\t  //parent.frames[1].location.href=\"../../eOH/jsp/ClinicalNoteFrame.jsp?\"+param;\n\t\t\t\t  parent.frames[2].location.href=\"../../eCA/jsp/RecClinicalNotesModal.jsp?\"+param;\n\t\t\t\t   parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t  break;\n\t\t\tcase \"PeriodontalSummary\": \n\t\t\t\t\tcalled_from_cond_trt_tab_flag = \"P\";\n\t\t\t\t\tparam=param+\"&called_from_cond_trt_tab_flag=P\";\n\t\t\t\t\t//parent.frames[2].location.href=\"../../eOH/jsp/PeriodontalSummaryFrame.jsp?\"+param;\n\t\t\t\t\tparent.frames[2].location.href=\"../../eOH/jsp/SummaryFrames.jsp?\"+param;\n\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\tbreak;\n\t\t}\n\t\t//changeTabColor(called_from_cond_trt_tab_flag);\n\t}\n\t//Commented by Sridevi Joshi on 28/10/09 for RHS disappearing issue(IN015790)\n\t//parent.conditionDentalChartToolHeader.location.href=\"../../eOH/jsp/OHDentalChartToolHeader.jsp?\"+param+\"&loaded_from_main_tab=N\";\n}\n\nfunction changeTabColor(called_from_cond_trt_tab_flag){\n\tvar cond_label = getLabel(\"eOH.Conditions.Label\",\"OH\");\n\tvar trmt_label = getLabel(\"Common.Treatment.label\",\"Common\");\n\tvar tabColorId   = document.getElementById(\"tabColor\");\n\tvar TreatmentId = document.getElementById(\"Treatment\");\n\tvar TreatmentSpanId = document.getElementById(\"Treatmentspan\");\n\n\tvar ConditionId = document.getElementById(\"Condition\");\n\tvar ConditionSpanId = document.getElementById(\"Conditionspan\");\n\tif(called_from_cond_trt_tab_flag == \"T\"){\n\t\tif(tabColorId != \"null\" && tabColorId != null){\n\t\t\ttabColorId.innerHTML = \'<font color=\"white\"><b>\'+trmt_label+\'</b></font>\';\n\t\t\ttabColorId.style.backgroundColor = \"green\";\n\t\t\ttabColorId.style.color=\"red\";\n\t\t}\n\t\t//ConditionId.className = \"tabA\";\n\t\t//ConditionSpanId.style.color = \"black\";\n\t\t//ConditionSpanId.className = \"tabAspan\";\n\n\t\t//TreatmentId.style.backgroundColor = \"green\";\n\t\t//TreatmentSpanId.style.color=\"white\";\n\n\t}\n\telse if(called_from_cond_trt_tab_flag == \"C\"){\n\t\tif(tabColorId != \"null\" && tabColorId != null){\n\t\t\ttabColorId.innerHTML = \'<font color=\"white\"><b>\'+cond_label+\'</b></font>\';\n\t\t\ttabColorId.style.backgroundColor = \"brown\";\n\t\t\ttabColorId.style.color=\"white\";\n\n\t\t\t//ConditionId.style.backgroundColor = \"brown\";\n\t\t\t//ConditionSpanId.style.color=\"white\";\n\n\t\t\t//TreatmentId.className = \"tabA\";\n\t\t\t//TreatmentSpanId.style.color = \"black\";\n\t\t\t//TreatmentSpanId.className = \"tabAspan\";\n\t\t}\n\t}\n\telse{\n\t\tif(tabColorId != \"null\" && tabColorId != null){\n\t\t\ttabColorId.innerHTML = \"\";\n\t\t\ttabColorId.style.backgroundColor = \"white\";\n\t\t\ttabColorId.style.color=\"white\";\n\t\t}\n\t\t//ConditionId.className = \"tabA\";\n\t\t//ConditionSpanId.style.color = \"black\";\n\t\t//ConditionSpanId.className = \"tabAspan\";\n\n\t\t//TreatmentId.className = \"tabA\";\n\t\t//TreatmentSpanId.style.color = \"black\";\n\t\t//TreatmentSpanId.className = \"tabAspan\";\n\n\t}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 =">\n<!-- Commented by Sharon Crasta on 7/16/2009 for IN012454-->\n<!-- <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onMouseOver=\'hideMenuOnOutFocus(\"DentalChartTabSearch\")\'>\n --><body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<!-- <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"alert(parent.frames[2].frames[1].frames[1].name)\"> -->\n<form name=\"OHCommonForm\" id=\"OHCommonForm\"> \n\n<table id=\"tab\" cellspacing=0 cellpadding=3 border=\"0\" width=\'100%\'>\n<tr>\n\t<td width= \"18%\" class=\"white\">\n\t<ul id=\"tablist\" class=\"tablist\" ";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 =">\n\t\t<li class=\"tablistitem\" title=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" >\n\t\t\t <a  class=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  onclick=\"changeTab(\'Condition\');\" id=\"Condition\"> \n\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"Conditionspan\" value=\"1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span> \n\t\t\t</a> \n\t\t\t\n\t\t</li>\n<!--\n\t\t<li class=\"tablistitem\" title=\'Diagnosis\' >\n\t\t\t<a  class=\"tabA\"  onclick=\"changeTab(\'Diagnosis\');\" id=\"Diagnosis\"> \n\t\t\t\t<span class=\"tabAspan\" id=\"Diagnosisspan\" value=\"10\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t</a>\n\t\t</li>\n-->\n\t\t<li class=\"tablistitem\" title=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n\t\t\t<a  class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  onclick=\"changeTab(\'Treatment\');\" id=\"Treatment\"> \n\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"Treatmentspan\" value=\"15\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t</a>\n\t\t</li> \n<!--\t\t\n\t\t <li class=\"tablistitem\" title=\'ClinicalNote\' >\n\t\t\t<a  class=\"tabA\"  onclick=\"changeTab(\'ClinicalNote\');\" id=\"ClinicalNote\"> \n\t\t\t\t<span class=\"tabAspan\" id=\"ClinicalNotespan\" value=\"20\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t</a>\n\t\t</li>\n-->\n<!--\n\t\t<li class=\"tablistitem\" title=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t\t\t<a  class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  onclick=\"changeTab(\'PeriodontalSummary\');\" id=\"PeriodontalSummary\"> \n\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"PeriodontalSummaryspan\" value=\"25\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t</a>\n\t\t</li> \n-->\n\t</ul>\n\t</td>\n\t<!-- <td width= \"100%\" align=\"center\" style=\"background-color:brown\" id=\"tabColor\"><font color=\"white\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></font></td> -->\n</tr>\n\t<!-- The below line is required to change the select state of Initial tab selected -->\n\t<script>\n\t\t//var ConditionId = document.getElementById(\"Condition\");\n\t\t//var ConditionSpanId = document.getElementById(\"Conditionspan\");\n\t\t//ConditionId.style.backgroundColor = \"brown\";\n\t\t//ConditionSpanId.style.color=\"white\";\n\t\tprevTabObj=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\n\t\t//alert(document.forms[0].cond_trmt_tab.value);\n\t\t//changeTabColor(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\n\t\t//alert(document.forms[0].Condition.className);\n\t\t//alert(document.forms[0].Treatment.className);\n\t\t\n\t</script>\n\t\n\n</table>\n\n<input type=\'hidden\' name=\'param\' id=\'param\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'diag_params\' id=\'diag_params\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type = \"hidden\" name= \"baseline_chart_yn\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type = \"hidden\" name= \"chart_flag\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type = \"hidden\" name= \"visit_id\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type = \"hidden\" name= \"episode_id\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type = \"hidden\" name= \"location_code\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type = \"hidden\" name= \"location_type\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type = \"hidden\" name= \"episode_type\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type = \"hidden\" name= \"other_facilitychart_yn\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<!-- Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700 -->\n<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<!-- Added by Sharon Crasta on 1/11/2010 for IN017822  -->\n<input type = \"hidden\" name= \"chart_disable_from_main\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<!-- -->\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
 
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String condition_tab_selected_class ="";
	String treatment_selected_class ="";
	String perio_selected_class ="";
	String condition_span_class ="";
	String treatment_span_class ="";
	String perio_span_class ="";
	String tab_disabled ="";
	String cond_trmt_tab ="";

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String practitioner_type =(String) session.getValue("practitioner_type");
	String practitioner_id =(String) session.getValue("practitioner_id");
	String default_head_tab =checkForNull(request.getParameter("default_head_tab"));

	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String chart_flag = checkForNull(request.getParameter( "chart_flag" )) ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
	String episode_id = checkForNull(request.getParameter( "episode_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String location_code = checkForNull(request.getParameter( "location_code" )) ;
	String location_type = checkForNull(request.getParameter( "location_type" )) ;
	String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
	String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	String diag_params = params+"&practitioner_type="+practitioner_type+"&practitioner_id="+practitioner_id+"&modal_yn=N";
	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;  
	String default_head_tab_add_new =checkForNull(request.getParameter("default_head_tab_add_new"));
    //Added by Sharon Crasta on 11/2/2009 for PrintChart PMG20089-CRF-0700 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	//
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
	//if(default_head_tab.equals("Treatment")){
	if(default_head_tab.equals("Treatment") || default_head_tab_add_new.equals("Treatment")){
		cond_trmt_tab = "T";
		condition_tab_selected_class = "tabA";
		treatment_selected_class = "tabClicked";
		perio_selected_class = "tabA";

		condition_span_class = "tabAspan";
		treatment_span_class = "tabSpanclicked";
		perio_span_class = "tabAspan";
	}
	else if(default_head_tab.equals("PeriodontalSummary") || default_head_tab_add_new.equals("PeriodontalSummary")){
		cond_trmt_tab = "P";
		condition_tab_selected_class = "tabA";
		treatment_selected_class = "tabA";
		perio_selected_class = "tabClicked";

		condition_span_class = "tabAspan";
		treatment_span_class = "tabAspan";
		perio_span_class = "tabSpanclicked";
	}
	else{
		cond_trmt_tab = "C";
		default_head_tab = "Condition";
		condition_tab_selected_class = "tabClicked";
		treatment_selected_class = "tabA";
		perio_selected_class = "tabA";

		condition_span_class = "tabSpanclicked";
		treatment_span_class = "tabAspan";
		perio_span_class = "tabAspan";
	}

	/*if(baseline_chart_yn.equals("Y")){//added by parul  for other facility chart CRF#0423
			tab_disabled = "disabled";
	}*/
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "N";
	  // baseline_chart_yn = "N";
	}
	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	//if(baseline_chart_yn.equals("Y")){
	if(baseline_chart_yn.equals("Y") || chart_disable_from_main.equals("Y")){//End
	/*if(baseline_chart_yn.equals("Y") || baseline_chart_yn.equals("N")){
		if(!other_chart_facility_id.equals(facility_id)){	*/
  		tab_disabled = "disabled";
	}
	if(other_facilitychart_yn.equals("Y")){
		tab_disabled = "disabled";
	}
	//}
	
	/* 
	occur_srl_no,term_code,term_set_id

	Params required for Calling Diagnosis function.
Age,Dob,Function,Sex,encounter_id,episode_type,function_id,location_code,location_type,modal_yn,occur_srl_no,patient_class,patient_id,practitioner_id,practitioner_type,relationship_id,term_code,term_set_id,visit_adm_date, ,

07/07/25 11:34:01 11:called_from=CA&chart_flag=R&option_id=OH_REST_CHART_REC1&patient_id=SD00000046&visit_id=&episode_id=100040640001&encounter_id=100040640001&location_code=CL30&location_type=C&bed_num=&room_num=&episode_type=O&discharge_date=&visit_adm_date=03/07/2007%2014:12&episode_Status=04&Sex=M&Age=55Y&Dob=21/10/1951&security_level=&protection_ind=&reln_req_yn=Y&patient_class=OP&PQ=Y&CA=Y&from_service_yn=&accession_number=&accession_type=&mode=R&RelnYn=&RelnReqYn=&relationship_id=ATTENDINGES&window_name=&child_window=Y&child_window=Y&limit_function_id=&chartTitle=&reln_req_yn=Y&limit_function_id=&chart_name=Restorative%20Chart&tooth_numbering_system=FDI&numbering_system_desc=FDI%20Numbering%20System&upper_arch_desc=Upper%20Arch&lower_arch_desc=Lower%20Arch&Q1_id=1&Q2_id=2&Q3_id=3&Q4_id=4&Q1_desc=Upper%20Right&Q2_desc=Upper%20Left&Q3_desc=Lower%20Left&Q4_desc=Lower%20Right&permanent_deciduous_flag=P&chart_type=RA&dflt_mixed_dentition_chart=P&mixed_dentition_YN=N&new_chart_num=1&cur_chart_num=

	*/

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            out.print( String.valueOf(tab_disabled));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(condition_tab_selected_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(condition_span_class));
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
            out.print( String.valueOf(treatment_selected_class));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(treatment_span_class));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(perio_selected_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(perio_span_class));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(default_head_tab));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cond_trmt_tab));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(diag_params));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chart_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chart_disable_from_main));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Condition.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNote.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions.Label", java.lang.String .class,"key"));
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
}
