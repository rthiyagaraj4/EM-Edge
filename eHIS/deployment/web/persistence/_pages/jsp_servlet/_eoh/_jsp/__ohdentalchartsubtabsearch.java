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

public final class __ohdentalchartsubtabsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDentalChartSubTabSearch.jsp", 1709119347770L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n   <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\t<script language=\"javascript\">\n\n\t\tfunction changeTab(objStr){\n\t\t\tvar frmObj=document.forms[0];\n\t\t\tif(document.getElementById(\"tablist\").disabled == false){\n\t\t\t\tselectTab(objStr);\n\t\t\t\tvar param=frmObj.param.value;\n\t\t\t    //written by parul on 26/11/07\n\t\t\t\tvar gs_dflt_tooth_no_Q1 = frmObj.gs_dflt_tooth_no_q1.value;\n\t            var gs_dflt_tooth_no_Q2 = frmObj.gs_dflt_tooth_no_q2.value;\n\t            var gs_dflt_tooth_no_Q3 = frmObj.gs_dflt_tooth_no_q3.value;\n\t            var gs_dflt_tooth_no_Q4 = frmObj.gs_dflt_tooth_no_q4.value;\n\n\t\t\t\tvar gs_dflt_tooth_no_s1 = frmObj.gs_dflt_tooth_no_s1.value;\n\t            var gs_dflt_tooth_no_s2 = frmObj.gs_dflt_tooth_no_s2.value;\n\t            var gs_dflt_tooth_no_s3 = frmObj.gs_dflt_tooth_no_s3.value;\n\t            var gs_dflt_tooth_no_s4 = frmObj.gs_dflt_tooth_no_s4.value;\n\t            var gs_dflt_tooth_no_s5 = frmObj.gs_dflt_tooth_no_s5.value;\n\t            var gs_dflt_tooth_no_s6 = frmObj.gs_dflt_tooth_no_s6.value;\n\n\t\t\t\tswitch(objStr){\n\t\t\t\t\t\n\t\t\t\t\tcase \"SendOut\": \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/OHTrmtSendOut.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\tbreak;\n\t\t\t\t\tcase \"Acknowledge\": \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/OHTrmtAcknowledge.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\tbreak;\n\t\t\t\t\tcase \"Recieve\": \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/OHTrmtRecieveDetails.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\tbreak;\t  \n\t\t\t\t\tcase \"DentalCondition\": \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/DentalCondition.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\tbreak;\n\t\t\t\t\tcase \"ExtTreatment\": \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/DentalExtTreatment.jsp?\"+param;\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\tbreak;\n\t\t\t\t\tcase \"GingivalStatus\": \n\t\t\t\t\t\t//written by parul on 26/11/07 \n\t\t\t\t\t\tparent.frames[1].location.href=\"../../eOH/jsp/GingivalStatus.jsp?\"+param+\"&gs_dflt_tooth_no_Q1=\"+gs_dflt_tooth_no_Q1+\"&gs_dflt_tooth_no_Q2=\"+gs_dflt_tooth_no_Q2+\"&gs_dflt_tooth_no_Q3=\"+gs_dflt_tooth_no_Q3+\"&gs_dflt_tooth_no_Q4=\"+gs_dflt_tooth_no_Q4+\"&called_from_viewchart_gingival=Y&gs_dflt_tooth_no_s1=\"+gs_dflt_tooth_no_s1+\"&gs_dflt_tooth_no_s2=\"+gs_dflt_tooth_no_s2+\"&gs_dflt_tooth_no_s3=\"+gs_dflt_tooth_no_s3+\"&gs_dflt_tooth_no_s4=\"+gs_dflt_tooth_no_s4+\"&gs_dflt_tooth_no_s5=\"+gs_dflt_tooth_no_s5+\"&gs_dflt_tooth_no_s6=\"+gs_dflt_tooth_no_s6;\n\n\t\t\t\t\t\tparent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t\t break;\n\t\t\t\t\t//case \"PeriodontalSummary\": \n\t\t\t\t\t\t\t //written by parul \n\t\t\t\t\t  //  var called_from_tab = \"Y\";\n\t\t\t\t\t\t//parent.frames[1].location.href=\"../../eOH/jsp/SummaryMainFrames.jsp?\"+param+\"&called_from_tab=\"+called_from_tab;\n\t\t\t\t        //parent.parent.parent.parent.parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\t//\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfunction setClinicalCode(){ //Un commented to get assign the oh_clinical_group value to the select box\n\t\t\t/*var formObj = document.forms[0];\n\t\t\tvar baseline_chart_yn = formObj.baseline_chart_yn.value;\n\t\t\tvar add_new_yn = formObj.add_new_yn.value;\n\t\t\tvar clinical_group_hid = formObj.clinical_group_hid.value;\n\n\t\t\talert(\"clinical_group_hid:==\"+clinical_group_hid);\n\t\t\tif(baseline_chart_yn != \"Y\" && clinical_group_hid != \"undefined\" && clinical_group_hid != undefined && clinical_group_hid != \"\" && clinical_group_hid != null && clinical_group_hid != \"null\"){\n\t\t\t\t//formObj.oh_clinical_group.value = clinical_group_hid;\n\t\t\t\tif(formObj.oh_clinical_group.value != \"\" && formObj.oh_clinical_group.value != \"null\" && formObj.oh_clinical_group.value != null){\n\t\t\t\t\tformObj.oh_clinical_group.disabled = \"true\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}*/\n\t\t\t\n\t\t\n\t\t\tvar formObj = document.forms[0];\n\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\tvar facility_id = formObj.facility_id.value;\n\t\t\tvar baseline_chart_yn = formObj.baseline_chart_yn.value;\n\t\t\tvar add_new_yn = formObj.add_new_yn.value;\n\t\t\tvar clinical_code = trimString(formObj.clinical_code.value);\n\t\t\t\tclinical_code = localTrimString(clinical_code);\n\t\t\tif(baseline_chart_yn != \"Y\" && clinical_code != \"undefined\" && clinical_code != undefined){\n\t\t\t\t//formObj.oh_clinical_group.value = clinical_code;\n\t\t\t\tif(formObj.oh_clinical_group.value != \"\" && formObj.oh_clinical_group.value != \"null\" && formObj.oh_clinical_group.value != null){\n\t\t\t\t\tformObj.oh_clinical_group.disabled = \"true\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t\n\t\t\tif(add_new_yn != \"Y\" && baseline_chart_yn != \"Y\"){\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"patient_id=\"+patient_id;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=onLoadClinicalCode&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tretVal = localTrimString(retVal);\n\t\t\t\tif(retVal.length>1){\n\t\t\t\t\tformObj.oh_clinical_group.value = retVal;\n\t\t\t\t\tformObj.clinical_group_hid.value = retVal;\n\t\t\t\t\tparent.frames[0].document.forms[0].clinical_group_hid.value = retVal;\n\t\t\t\t\t\n\t\t\t\t\tformObj.oh_clinical_group.disabled = \"true\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"setClinicalCode();\" >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name=\"OHSubTabForm\" id=\"OHSubTabForm\">\n\n<table id=\"tab\" cellspacing=0 cellpadding=3 border=\"0\" width=\'93%\'>\n<tr>\n\t<td width= \"100%\" class=\"white\">\n\t\t<ul id=\"tablist\" class=\"tablist\" ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">\n\t\t\t<li class=\"tablistitem\" title=\'DentalCondition\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  onclick=\"changeTab(\'DentalCondition\');\" id=\"DentalCondition\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"DentalConditionspan\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t\n\t\t\t <li class=\"tablistitem\" title=\'ExtTreatment\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  onclick=\"changeTab(\'ExtTreatment\');\" id=\"ExtTreatment\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"ExtTreatmentspan\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t          <li class=\"tablistitem\" title=\'GingivalStatus\'>\n\t\t\t\t          <a  class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  onclick=\"changeTab(\'GingivalStatus\');\" id=\"GingivalStatus\" >\n\t\t\t\t\t       <span class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"GingivalStatusspan\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t        </a>\n\t\t\t          </li>\n\t\t\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<!-- written by parul  -->\n\t\t\t\n\t\t\t\t<!--  <li class=\"tablistitem\" title=\'PeriodontalSummary\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  onclick=\"changeTab(\'PeriodontalSummary\');\" id=\"PeriodontalSummary\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"PeriodontalSummaryspan\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\n\t\t\t\t</a>\n\t\t\t</li> -->\n\t\t\t\n\t\t\t<!-- <li class=\"tablistitem\" title=\'sendOut\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  onclick=\"changeTab(\'SendOut\');\" id=\"SendOut\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"SendOutspan\">SendOut</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'Acknowledge\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  onclick=\"changeTab(\'Acknowledge\');\" id=\"Acknowledge\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"Acknowledgespan\">Acknowledge</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'Recieve\' >\n\t\t\t\t<a  class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  onclick=\"changeTab(\'Recieve\');\" id=\"Recieve\"> \n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"Recievespan\">Acknowledge</span>\n\t\t\t\t</a>\n\t\t\t</li> -->\n\t\t\t\n\t\t\t\n             \n\t\t</ul>\n\t\t\n\t</td>\n\t\n\n\t<td class=\"label\" nowrap width=\"25%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t<td align=\"right\">\n\t\t<select name = \"oh_clinical_group\" value =\"\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<option ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</select>\n\t</td>\n</tr>\n\t\n\n</table>\n<input type=\"hidden\" name=\"param\" id=\"param\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type = \"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type = \"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type = \"hidden\" name= \"facility_id\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"> \n<input type = \"hidden\" name= \"clinical_group_hid\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"> \n<input type = \"hidden\" name= \"called_from_viewchart_yn\" value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> \n<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"> \n<input type = \"hidden\" name= \"add_new_yn\" value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"> \n<input type = \"hidden\" name= \"baseline_chart_yn\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type = \"hidden\" name= \"clinical_code\" value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\n\n<!-- written by parul on 26/11/07 -->\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_q1\" id=\"gs_dflt_tooth_no_q1\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_q2\" id=\"gs_dflt_tooth_no_q2\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_q3\" id=\"gs_dflt_tooth_no_q3\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_q4\" id=\"gs_dflt_tooth_no_q4\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\n<!-- added by sridevi for Sextant -->\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s1\" id=\"gs_dflt_tooth_no_s1\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s2\" id=\"gs_dflt_tooth_no_s2\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s3\" id=\"gs_dflt_tooth_no_s3\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s4\" id=\"gs_dflt_tooth_no_s4\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s5\" id=\"gs_dflt_tooth_no_s5\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\"hidden\" name=\"gs_dflt_tooth_no_s6\" id=\"gs_dflt_tooth_no_s6\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\n<!--Added by Sharon Crasta on 7/28/2009 -->\n<!--Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab -->\n<input type=\"hidden\" name=\"called_from_Ext_Trmt\" id=\"called_from_Ext_Trmt\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<!--Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)-->\n<input type=\"hidden\" name=\"chart_type\" id=\"chart_type\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<!-- -->\n\n<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->\n<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\"hidden\" name=\"called_from_viewchart_gingival\" id=\"called_from_viewchart_gingival\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<!-- -->\t\n</form>\n\n\t<script>\n\t\tparent.frames[0].document.forms[0].clinical_group_hid.value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t</script>\n\n\t<!-- The below line is required to change the select state of Initial tab selected -->\n\t<script>\n\t\tprevTabObj=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t</script>\n\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\n\n\n\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
 
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

	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String db_clinical_group_code = "";
	String disabled="";
	String tab_disabled="";
	String selected="";
	String DC_tab_selected_class = "";
	String ET_tab_selected_class = "";
	String PC_tab_selected_class = "";
	String perio_selected_class = "";

	String DC_span_class = "";
	String ET_span_class = "";
	String PC_span_class = "";
	String perio_span_class = "";
	

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
	String chart_hdr_insert_yn = checkForNull(request.getParameter( "chart_hdr_insert_yn" )) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	String clinical_group_code = checkForNull(request.getParameter( "clinical_group_code" )) ;
	String defaultTab = checkForNull(request.getParameter( "defaultTab" )) ;
	String add_new_yn = checkForNull(request.getParameter( "add_new_yn" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	//String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
	String clinical_group_before_refresh = checkForNull(request.getParameter( "clinical_group_before_refresh" )) ;
	//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
	//String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));//added by parul  for other facility chart CRF#0423
	String clinical_code = "";
	if(!clinical_group_before_refresh.equals("")){
		clinical_code = clinical_group_before_refresh;
	}

   	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
//written by parul on 27/11/07
    String record_gingival_status_yn = checkForNull(request.getParameter( "record_gingival_status_yn" )) ;
    String gs_dflt_tooth_no_q1 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q1" )) ;
    String gs_dflt_tooth_no_q2 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q2" )) ;
    String gs_dflt_tooth_no_q3 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q3" )) ;
	String gs_dflt_tooth_no_q4 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q4" )) ;	 
    String called_from_viewchart_gingival = checkForNull(request.getParameter( "called_from_viewchart_gingival" )) ;

	String gs_dflt_tooth_no_s1 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s1" )) ;
    String gs_dflt_tooth_no_s2 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s2" )) ;
    String gs_dflt_tooth_no_s3 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s3" )) ;
	String gs_dflt_tooth_no_s4 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s4" )) ;
	String gs_dflt_tooth_no_s5 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s5" )) ;
	String gs_dflt_tooth_no_s6 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s6" )) ;	
	//Added by Sharon Crasta on 7/28/2009
	//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
	String called_from_Ext_Trmt = checkForNull(request.getParameter( "called_from_Ext_Trmt" )) ;
	//
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	//End
	
	//Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)
	String chart_type = checkForNull(request.getParameter("chart_type"));
	String called_from_Ging_Sts = checkForNull(request.getParameter("called_from_Ging_Sts"));
	//

	/*
	if(called_from_viewchart_yn.equals("Y")){
		if(defaultTab.equals("DentalCondition")){
			DC_tab_selected_class = "tabClicked";
			ET_tab_selected_class = "tabA";
			PC_tab_selected_class = "tabA";

			DC_span_class = "tabSpanclicked";
			ET_span_class = "tabAspan";
			PC_span_class = "tabAspan";

		}else if(defaultTab.equals("ExtTreatment")){
			DC_tab_selected_class = "tabA";
			ET_tab_selected_class = "tabClicked";
			PC_tab_selected_class = "tabA";

			DC_span_class = "tabAspan";
			ET_span_class = "tabSpanclicked";
			PC_span_class = "tabAspan";
		}
	}
	else{
		out.println(defaultTab);
		defaultTab = "DentalCondition";
		DC_tab_selected_class = "tabClicked";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";

		DC_span_class = "tabSpanclicked";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
	}
	*/
	
	//Commented and Added by Sharon Crasta on 7/28/2009
	//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
	//if(defaultTab.equals("ExtTreatment")){
	if(called_from_Ext_Trmt.equals("Y")){
		defaultTab="ExtTreatment";
	//
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabClicked";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabA";

		DC_span_class = "tabAspan";
		ET_span_class = "tabSpanclicked";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
	}
	//else if(defaultTab.equals("GingivalStatus")){
	else if(called_from_Ging_Sts.equals("Y")){
		//Added by Sharon Crasta on 7/28/2009
		//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
		defaultTab="GingivalStatus";
		//
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabA";
		perio_selected_class = "tabA";
		PC_tab_selected_class = "tabClicked";

		DC_span_class = "tabAspan";
		ET_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
		PC_span_class = "tabSpanclicked";
	}
	/*else if(defaultTab.equals("PeriodontalSummary")){
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabClicked";
		
		DC_span_class = "tabAspan";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabSpanclicked";
	}*/else {
		defaultTab="DentalCondition";
		DC_tab_selected_class = "tabClicked";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabA";

		DC_span_class = "tabSpanclicked";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
	}



	
	try{
		con=ConnectionManager.getConnection(request);
		if(chart_hdr_insert_yn.equals("N") && add_new_yn != "Y"){
			pstmt = con.prepareStatement("SELECT CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				db_clinical_group_code = checkForNull(rs.getString("CLINICAL_GROUP_CODE"));
				//out.println("309 db_clinical_group_code:=="+db_clinical_group_code);
			}
		}

		//out.println("db_clinical_group_code:=="+db_clinical_group_code);
		//out.println("facility_id:=="+facility_id);
		//out.println("patient_id:=="+patient_id);
		//out.println("add_new_yn:=="+add_new_yn);
		//out.println("chart_hdr_insert_yn:=="+chart_hdr_insert_yn);

		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)	
		 if(chart_type.equals("RA")){
			 if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,GS_DFLT_TOOTH_NO_Q1,GS_DFLT_TOOTH_NO_Q2,GS_DFLT_TOOTH_NO_Q3,GS_DFLT_TOOTH_NO_Q4, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,GS_DFLT_TOOTH_NO_Q1,GS_DFLT_TOOTH_NO_Q2,GS_DFLT_TOOTH_NO_Q3,GS_DFLT_TOOTH_NO_Q4, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S6"));
				}
		   }
		}
		//Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)
		else if(chart_type.equals("RD")){
			if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,DEC_GS_DFLT_TOOTH_NO_Q1,DEC_GS_DFLT_TOOTH_NO_Q2,DEC_GS_DFLT_TOOTH_NO_Q3,DEC_GS_DFLT_TOOTH_NO_Q4, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,DEC_GS_DFLT_TOOTH_NO_Q1,DEC_GS_DFLT_TOOTH_NO_Q2,DEC_GS_DFLT_TOOTH_NO_Q3,DEC_GS_DFLT_TOOTH_NO_Q4, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S6"));
				}
		   }		
		}
		else{
			if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,MD_GS_DFLT_TOOTH_NO_Q1,MD_GS_DFLT_TOOTH_NO_Q2,MD_GS_DFLT_TOOTH_NO_Q3,MD_GS_DFLT_TOOTH_NO_Q4, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,MD_GS_DFLT_TOOTH_NO_Q1,MD_GS_DFLT_TOOTH_NO_Q2,MD_GS_DFLT_TOOTH_NO_Q3,MD_GS_DFLT_TOOTH_NO_Q4, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S6"));
				}
		   }		
		}
		//End
		//}
		
		//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
		//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
		//if(called_from_viewchart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){

			//out.println("called_from_viewchart_yn:=="+called_from_viewchart_yn);
			//out.println("other_facilitychart_yn:=="+other_facilitychart_yn);
			//out.println("chart_disable_from_main:=="+chart_disable_from_main);

		if(called_from_viewchart_yn.equals("Y") || other_facilitychart_yn.equals("Y") || chart_disable_from_main.equals("Y")){//End
			disabled = "disabled";
			selected = "selected";
			tab_disabled = "disabled";
			db_clinical_group_code = clinical_group_code;
		}

		if(date_diff_flag.equals("disable")){
			tab_disabled = "disabled";
			disabled = "disabled";
		}
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tab_disabled));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(DC_tab_selected_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(DC_span_class));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ET_tab_selected_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ET_span_class));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				 //commented by parul on 7/13/2009 for CRF 0456 & 0457 ( ability to record ?Gingival Status? in restorative chart for patient at all age)
                   //  if(record_gingival_status_yn.equals("Y") && (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")) ){
                    if(record_gingival_status_yn.equals("Y")){
                     
				 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(PC_tab_selected_class));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(PC_span_class));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			   }

			  
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(perio_selected_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(perio_span_class));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ET_tab_selected_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ET_span_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ET_tab_selected_class));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ET_span_class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ET_tab_selected_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ET_span_class));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				pstmt=con.prepareStatement("SELECT CLINICAL_GROUP_CODE, CLINICAL_GROUP_DESC FROM OH_CLINICAL_GROUP_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 2");
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				while(rs.next()){
					selected="";
					if(db_clinical_group_code.equals(rs.getString("CLINICAL_GROUP_CODE")))
						selected = "selected";
			
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("CLINICAL_GROUP_CODE")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rs.getString("CLINICAL_GROUP_DESC")));
            _bw.write(_wl_block31Bytes, _wl_block31);

				}
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(db_clinical_group_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(called_from_viewchart_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(params));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(add_new_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(clinical_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(gs_dflt_tooth_no_q1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(gs_dflt_tooth_no_q2 ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(gs_dflt_tooth_no_q3));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(gs_dflt_tooth_no_q4));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(gs_dflt_tooth_no_s1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(gs_dflt_tooth_no_s2 ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(gs_dflt_tooth_no_s3));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(gs_dflt_tooth_no_s4));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(gs_dflt_tooth_no_s5));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(gs_dflt_tooth_no_s6));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(called_from_Ext_Trmt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(called_from_viewchart_gingival));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(db_clinical_group_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(defaultTab));
            _bw.write(_wl_block62Bytes, _wl_block62);

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

            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DentalCondition.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExternalTreatment.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.GingivalStatus.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ClinicalGroup.Label", java.lang.String .class,"key"));
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
}
