package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptiondetail_1_45_17527 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePH/jsp/PrescriptionDetail_1-17527.jsp", 1698293812192L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/Prescription_1.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../js/PrescriptionTest.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script src=\"../../eCommon/js/jquery.js\"></script>  \n\t\t<script src=\"../../eCommon/js/jquery-ui.js\"></script>  \n\t\t<link rel=\"Stylesheet\" href=\"../../eCommon/html/jquery-ui.css\" />  \n\t\t<!--<script src=\"http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.8.0.js\"></script>  //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start \n\t\t<script src=\"http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.22/jquery-ui.js\"></script>  \n\t\t<link rel=\"Stylesheet\" href=\"http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/redmond/jquery-ui.css\" /><!--//added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end-->\n\t</head>\n\t<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin\t-->\n\t<script language=\"VBScript\">\n\t\tFunction vbConfirm(msg)\n\t\t   butVal = 32 + 4 + 0 + 0\n\t\t   vbConfirm = MsgBox(msg,butVal,\"Duplicate Drug\")\n\t\tEnd Function\n\t</script> <!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end\t-->\n\t<script> //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start\n\t\t$(document).ready(function(){\n\t\t\t$(function() {\n\t\t\t\tvar drug_seach_autocomplete_yn\t= parent.f_header.document.prescription_header_form.drug_seach_autocomplete_yn.value;\n\t\t\t\tif(drug_seach_autocomplete_yn ==\'Y\'){\n\t\t\t\t\tvar pract_type\t\t= parent.f_header.document.prescription_header_form.pract_type.value;\n\t\t\t\t\tvar practitionerId\t= parent.f_header.document.prescription_header_form.pract_id.value;\n\t\t\t\t\tvar resp_id\t\t\t= parent.f_header.document.prescription_header_form.resp_id.value;\n\t\t\t\t\tvar res_by_service\t=parent.f_header.document.prescription_header_form.service_search_yn.value;\n\t\t\t\t\tvar service_code\t=parent.f_header.document.prescription_header_form.servide_code.value;\n\t\t\t\t\tvar take_home_medication_yn = parent.f_header.document.prescription_header_form.take_home_medication.value;\n\t\t\t\t\tvar patient_class;\n\t\t\t\t\tif(take_home_medication_yn==\'Y\')\n\t\t\t\t\t\tpatient_class = parent.f_header.document.prescription_header_form.patient_class.value;\n\t\t\t\t\telse\n\t\t\t\t\t\tpatient_class = parent.f_header.document.prescription_header_form.actual_patient_class.value;\n\t\t\t\t\tvar patient_id = parent.f_header.document.prescription_header_form.patient_id.value;\n\t\t\t\t\tvar encounter_id= parent.f_header.document.prescription_header_form.encounter_id.value;\n\t\t\t\t\tvar language_id= parent.f_header.document.prescription_header_form.language_id.value;\n\t\t\t\t\tvar called_from_verbal_order= parent.f_header.document.prescription_header_form.called_from_verbal_order.value;\n\t\t\t\t\tvar default_prev_drug_sel= parent.f_header.document.prescription_header_form.default_prev_drug_sel.value;\n\t\t\t\t\tvar allow_priv_to_order_yn= parent.f_header.document.prescription_header_form.allow_priv_to_order_yn.value;\n\t\t\t\t\t$(\"#drug_name_id\").autocomplete({          \t\n\t\t\t\t\t\tsource: function (request, response) {  \n\t\t\t\t\t\t\tvar drugText=$(\'#drug_name_id\').val();\n\t\t\t\t\t\t\tvar xmlHttp = new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\t\t\t\t\t\t\t$.ajax({  \n\t\t\t\t\t\t\t\turl : \"/servlet/ePH.AutoCompleteServlet\",\n\t\t\t\t\t\t\t\tdata : {\n\t\t\t\t\t\t\t\t\tEvent : \"SEARCHDATA\",\n\t\t\t\t\t\t\t\t\tpract_type : pract_type,\n\t\t\t\t\t\t\t\t\tpractitionerId : practitionerId,\n\t\t\t\t\t\t\t\t\tresp_id : resp_id,\n\t\t\t\t\t\t\t\t\tres_by_service : res_by_service,\n\t\t\t\t\t\t\t\t\tservice_code : service_code,\n\t\t\t\t\t\t\t\t\ttake_home_medication_yn : take_home_medication_yn,\n\t\t\t\t\t\t\t\t\tpatient_class : patient_class,\n\t\t\t\t\t\t\t\t\tpatient_id : patient_id,\n\t\t\t\t\t\t\t\t\tencounter_id : encounter_id,\n\t\t\t\t\t\t\t\t\tdrugText : drugText,\n\t\t\t\t\t\t\t\t\tcalled_from_verbal_order : called_from_verbal_order,\n\t\t\t\t\t\t\t\t\tdefault_prev_drug_sel : default_prev_drug_sel,\n\t\t\t\t\t\t\t\t\tdrug_priv_ssn_ynm : allow_priv_to_order_yn,\n\t\t\t\t\t\t\t\t\tlanguage_id : language_id\n\t\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\t\tdataType: \"json\",  \n\t\t\t\t\t\t\t\tsuccess:function (data){\n\t\t\t\t\t\t\t\t\tresponse(data);\n\t\t\t\t\t\t\t\t\tresponse($.map(data.data, function (items) {\n\t\t\t\t\t\t\t\t\t\treturn {\n\t\t\t\t\t\t\t\t\t\t\tvalue: items.drug_name,\n\t\t\t\t\t\t\t\t\t\t\tid:items.drug_code +\"~\"+items.trade_code\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t));\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t});  \n\t\t\t\t\t\t},\n\t\t\t\t\t\tminLength: 3,\n\t\t\t\t\t\tselect:function (event, ui) {\n\t\t\t\t\t\t\tvar drug_code = new Array();\n\t\t\t\t\t\t\tvar trade_code = new Array();\n\t\t\t\t\t\t\tvar codesList = ui.item.id.split(\"~\");\n\t\t\t\t\t\t\tdrug_code[0]=codesList[0];\n\t\t\t\t\t\t\ttrade_code[0]=codesList[1];\n\t\t\t\t\t\t\tloadDrugDetails(drug_code,trade_code,\'\');\n\t\t\t\t\t\t}\n\t\t\t\t\t});\n\t\t\t\t}\n\t\t\t});\n\t\t});\n\t</script> <!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete-end -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- Drug Attributes ends-->\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\"prescription_detail_form\" >\n\t<!-- Below table for CurrentRx details-->\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td  width=\"15%\">\n\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  onClick=\"javascript:callActiveOrders(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\"></td>\n\t\t\t\t<td class=\"CURRTEXT\"  width=\"85%\">&nbsp;\n\t\t\t\t<!-- <marquee scrollamount=\"3\" title=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'><font  style=\"font-weight:bold;color:black\" size=1></font></marquee> -->\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"  width=\"15%\"><input type=\'button\' class=\'button\' onClick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'Prescription\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></td> <!--encounter_id added for AAKH-CRF-0088.2 --> \n\t\t\t</tr>\n\t\t</table>\n<!--CurrentRx table ends-->\n\n<!-- Prescription Writer Table starts-->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\"  width=\"15%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t<td class=\"label\"  width=\"45%\" colspan=\"3\" ><input type=\"text\" name=\"drug_name\" id=\'drug_name_id\' size=\"42\"  maxlength=\"42\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><input type=\"button\" name=\"drug_search\" value=\"?\" class=\"button\"  onClick=\"searchDrugName();\" onFocus=\"searchDrugName();\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">&nbsp;<img  src=\"../../eCommon/images/mandatory.gif\"></img><!-- alternateDisable\t//added for  JD-CRF-0198 [IN:058599] -->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<img style=\"cursor:hand;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=\'20\'  width=\'20\' onClick=\"openEDLDetails(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\"></img>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="                     \n\t\t\t\t\t\t\t<img style=\"cursor:hand;filter:Chroma(Color=#FFFFFF)\" name=\"preg_alert\" value=\"\" src=\"../../ePH/images/Pregnancy.bmp\" height=\'20\'  width=\'20\' onClick=\"chkPregnencyAlert();\" style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\"12%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<!--  ** Added a new function to change the Build MAR Check Box based on priority selection  - RUT - CRF- 0062\n\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"28%\">&nbsp;<select name=\"priority\" onchange=\"defFreq(this);freqChange(frequency,\'Y\')\">\n\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t<!--  RUT-CRF-0062 [IN029600]  Added getBuildMARDefaulting() function to change Build MAR based on Build MAR Rule  -->\t\t\t\t\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"28%\">&nbsp;<select name=\"priority\" onchange=\"getBuildMARDefaulting();defFreq(this);\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<option value=\"U\" selected>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"U\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"28%\"><select name=\"priority\" >\n\t\t\t\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\"   width=\"15%\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<td class=\"data\" id=\"strength\" width=\"20%\">&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"data\" id=\"strength\" width=\"20%\">&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<td class=\"label\"  width=\"25%\" colspan=\"2\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;&nbsp;<label id=\"form\" style=\"font-weight:bold\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</label></td>\n\t\t\t\t\t\t<td class=\"label\"  width=\"15%\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;</td>\n\t\t\t\t\t\t<td class=\"label\"  width=\"30%\"><select name=\"route_code\" onChange=\"getFormatId(this);getActionText(this,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');changeRoute();\" onBlur=\"(this);\" style=\"width:150;\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="><!-- add getActionText function for SKR-CRF-0006[IN029561]  //changeRoute added for SKR-SCF-0586 IN[034375] Reopened-->\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="---&nbsp;&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<td class=\'label\' width=\"15%\"> ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t<td class=\"label\"  width=\"20%\" >\n\n\t\t\t\t\t\t\t<select name=\"trade_code_option\" onChange=\"assignTradeCode(this)\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_code\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_name\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td><!--added for alignment issue for SKR-CRF-0006 ICN 29561 -->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_code\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trade_name\' value=\'\'>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<td class=\'label\' colspan=\'3\'> <!-- change colspan=\'5\' to colspan=\'3\'  for  SKR-CRF-0006[IN029561]-->\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" onclick=\'assignValue1(this);\'>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<!-- &nbsp;<input type=\'hidden\' name=\'buildMAR_yn\' value=\'N\'> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!-- add this td and label for  SKR-CRF-0006[IN029561]-- start -->\n\t\t\t\t\t\t<td class=\'label\'><label style=\'color:red;\' id=\"actionTextval\" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t </label></td>\n\t\t\t\t\t\t<!-- add this td and label for  SKR-CRF-0006[IN029561]-- end -->\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td >&nbsp;</td>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_authorize\' style=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =";";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</label></td>\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t<td class=\"label\"  align=\'center\' colspan=\'2\'><label id=\'lbl_splapprvl\' style=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</label></td>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t<td class=\"label\" align=\'center\'><label id=\'lbl_cosign\' style=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</label></td>\n\t\t\t\t\t\t<td  class=\"label\"><a href=\"javascript:viewReasonforRequest(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" id=\"tdm_details\"  style=\"font-size:9;";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\"  title=\"TDM Result\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" </a>&nbsp;</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\"  >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t\t<td  class=\"label\" colspan=\"2\"><select name=\"dosage\" onChange=\"dosageChange(this);makeDefaultQtyvalueEmpty();\" style=\"width:100;\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="><!--makeDefaultQtyvalueEmpty added for AAKH-CRF-089-->\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t<td  align=\'right\'><input type=\"text\" id=\'id_qty_value\' name=\"qty_value\" size=\"10\" maxlength=\"13\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" onchange=\"if(lookForChange(this)) {durationConversn(document.prescription_detail_form.durn_desc);} getTotalTaperQty(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\',\'TAP_LVL_QTY\',\'N\');\"  onKeyPress=\"checkBeforeDecimal(this, event); return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =");\" oncopy=\"return false\" onpaste=\"return false\"></td><!--added checkBeforeDecimal() function for ML-BRU-SCF-1437 -->\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t<td align=\'right\'><input type=\"text\" id=\'id_qty_value\' name=\"qty_value\" size=\"10\" maxlength=\"13\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" onchange=\"if(freqChange(frequency,\'Y\',\'N\',\'ChangeFreq\')){ changedoseoverridevalue();durationConversn(document.prescription_detail_form.durn_desc);} getTotalTaperQty(\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\',\'TAP_LVL_QTY\',\'N\');\" onKeyPress=\"checkBeforeDecimal(this, event); return allowValidNumber(this,event,8,";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\"qty_desc\" style=\"width:110;\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" onchange=\'extDosageCheck();onChangeUOM();\'> <!--added for SKR-SCF-0309.1  [IN030625]  -->\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t<option VALUE=\"\">&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" id=\"dosage_label\" colspan=\"1\" style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr nowrap>\n\t\t\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"5\"><select name=\"frequency\" onChange=\"freqChange(this,\'Y\',\'N\',\'ChangeFreq\',\'pBilling\');getTotalTaperQty(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\',\'TAP_LVL_QTY\',\'N\',\'pBilling\');assignHomeDuration();getChargeDetails(\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\');\" style=\"width:465;\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="><!-- //added pBilling for performance issue MMS -->\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\t\n\t\t\t\t\t\t\t<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t</select>&nbsp;\n\t\t\t\t\t\t<input id=\"dis_split_dose\" type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' style=\"visibility:visible\" name=\"split_dose\" onClick=\"DisplaySchedule()\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="></td>\n                       </tr>  \n                       <tr>\n\t\t\t\t\t\t<td  class=\"label\" colspan=\"3\" style=\'TEXT-ALIGN:right;\'><a href=\"javascript:callPRNDetails();\" id=\"prn_remarks\" style=\"visibility:hidden\" title=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</a><img   style=\"visibility:hidden\"  id=\"prn_remarks_image\" src=\"../../eCommon/images/mandatory.gif\"></img></td>\n                    \n\t\t\t\t\t\t<td class=\"label\" colspan=\"2\"><label id=\'rec_legend\' onclick=\'changeschedule()\' style=\"visibility:hidden\">\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t<font id=\'rec_legend_font\' class=\'HYPERLINK\' onmouseover=\'changeCursor(this);\'>\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t<font id=\'rec_legend_font\' class=\'\' >\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</font></label>\n\t\t\t\t\t\t\t<label id=\"rec_value\" style=\"font-size:11;font-weight:bold;color:red;\"></label>\n\t\t\t\t\t\t\t&nbsp;<label id=\"rec_uom\" style=\"font-size:11;font-weight:bold;color:red\"></label>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t\t\t\t<td class=\"label\"  ><input type=\"text\" size=\"1\" maxlength=\"3\" name=\"durn_value\" class=\"NUMBER\"  value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"  onblur=\"validateDuration(this);putDecimal(this,3,0);durationConversn(document.prescription_detail_form.durn_desc);populateEndDate();chkPopulateRefill();extDosageCheck();getTotalTaperQty(\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\',\'TAP_LVL_QTY\',\'N\');assignHomeDuration();\"  onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">&nbsp;<!--Added onchange=\"assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]  getChargeDetails(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\');-->\n\t\t\t\t\t\t\t<select name=\"durn_desc\" onChange=\"validateDuration(durn_value);populateEndDate();durationConversn(this);getTotalTaperQty(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\',\'TAP_LVL_QTY\',\'N\');assignHomeDuration();\" ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="> <!-- getChargeDetails(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'); -->\n\t\t\t\t\t\t\t<!-- <option>-";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="-</option> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_value\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tmp_durn_desc\"  value=\"D\">\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t<td  class=\'label\' align=\'right\' colspan=\'2\'><label id=\"ord_qty_lbl\" style=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =";color:red;font-weight:bold;\" >";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</label>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"data\" >&nbsp;\n\t\t\t\t\t\t\t\t<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"5\" name=\"absol_qty\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" onchange=\"ValidateAbs(this);getChargeDetails(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\',\'ABS_QTY\'); populateEndDate();\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" style=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =">&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<label id=\"ord_qty_uom\" style=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</label></td>\n\t\t\t\t\t\t\t<td  class=\'label\' align=\'right\' style=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\t\t\t\t\t\t\t<label id=\"tap_lvl_qty_lbl\" style=\"color:red;font-weight:bold;font-size:9;\" >";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="    <!--  Modified for RUT-CRF-0088 [IN036978]-->\n\t\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"tap_lvl_qty\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"  onchange=\"ValidateAbs(this,\'TAP_LVL_CHANGE\', \'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\');getTotalTaperQty(\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\',\'TAP_LVL_CHANGE\',\'N\');\" onKeyPress=\"return(ChkNumberInput(this,event,\'\'))\" > &nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<label id=\"tap_lvl_qty_uom\"  style=\"font-size:9;\">";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</label> <!--  Modified for RUT-CRF-0088 [IN036978]-->\n\t\t\t\t\t\t\t</td>\n\t\t<!-- added populateEndDate() onChangefor IN26267 --02/02/2011-- priya -->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\n\t\t\t\t\t\t\t<td class=\"label\"  ><input type=\"text\" name=\"start_date\" size=\"14\"  maxlength=\"16\" onblur=\"chkBackFutureDate(this,\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\');assignHomeDuration();\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="><img SRC=\"../../eCommon/images/CommonCalendar.gif\" name=\'stateDateImg\' ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" onclick=\"if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar(\'start_date\',null,\'hh:mm\');document.prescription_detail_form.start_date.focus();return false;\" ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="></td><!--Added assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\" nowrap>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="&nbsp;&nbsp;<input type=\"text\" name=\"end_date\" size=\"14\"  maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" readonly onblur=\"validateEndDate(this,\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\');\" ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="><img SRC=\"../../eCommon/images/CommonCalendar.gif\"  name=\'endDateImg\' ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =" onclick=\"if(document.prescription_detail_form.end_date.disabled){return false;};showCalendar(\'end_date\',null,\'hh:mm\');document.prescription_detail_form.end_date.focus();return false;\" ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="></td><!--Added assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t<!-- code modified for External Prescription..  -->\n\t\t\t\t\t\t\t<td class=\"label\"    style=\"\" >   <!--Modified for RUT-CRF-0088 [IN036978]-->\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'  style=\"visibility:visible\" name=\"allow_refill\" onClick=\"loadRefillDetails(\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\')\" ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =">&nbsp;&nbsp;<!-- \t\talternateDisable//added for  JD-CRF-0198 [IN:058599] -->\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'  style=\"visibility:hidden\" name=\"allow_refill\" ";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'  style=\"visibility:hidden;\" id=\"dosage_limit\" onclick=\"showOverRideRemarks(document.prescription_detail_form)\" >&nbsp;\n\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"label\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" style=\"visibility:hidden\" name=\"override_remarks\" ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" onclick=\"checkOverRideRemarks(document.prescription_detail_form)\"  >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"practitioner_name\" value=\"\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"checkEnabled\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\'label\' align=\'right\' style=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>    <!--Moved down for RUT-CRF-0088 [IN036978]  -->\n\t\t\t\t\t\t\t\t<label id=\"tot_tap_qty_lbl\" style=\"color:red;font-weight:bold;font-size:9;\" >";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t</label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\t\t\t<input class=\'NUMBER\' type=\"text\" size=\"3\" maxlength=\"3\" name=\"totTapperQty\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\"  onchange=\"ValidateAbs(this,\'TOT_TAPER\');populateEndDate();updateTapLvlQty(\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\',this,\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\')\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" > &nbsp;&nbsp;\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" disabled onchange=\"ValidateAbs(this,\'TOT_TAPER\');populateEndDate();updateTapLvlQty(\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t<label id=\"taper_qty_uom\"  style=\"font-size:9;\">";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'prevTotalTaperQty\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'totalTaperQtyDisplay\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"label\"><input type=\"text\" size=\"20\" maxlength=\"20\" name=\"disp_locn_desc\" disabled value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"></td>\n\t\t\t\t\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:callOrder();\" id=\"drug_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</a>\n\t\t\t\t\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start -->\n\t\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 --end -->\n\t\t\t\t\t\t\t\t\t<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->\n\t\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\">\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:drugindication_remarks();\" id=\"drug_ind_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</a>\n\t\t\t\t\t\t\t\t<!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\"  >\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t\t\t\t<select name=\"disp_locn_code\">\n";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" selected>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</option>\n";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"20\" maxlength=\"20\" name=\"disp_locn_desc\" disabled value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t\t<!-- <td class=\"label\"   >&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"label\" ><input type=\"hidden\" name=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"></td> -->\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\" style=\'TEXT-ALIGN:right;\'>\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="&nbsp;<input type=\"checkbox\"  name=\"pat_counseling_reqd\" value =\"N\" onClick=\"assignValue1(this);\"  ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =">&nbsp;\n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t\t\t\t\t<!-- Below parent_disable Condition is Added By SureshKumar T For SRR20056-SCF-7079[inc:26839] -->\n\t\t\t\t\t\t\t\t<br>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="&nbsp;<input type=\"checkbox\" name=\"brought_by_pat\" onClick=\"assignValue2(this);\" ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"label\" >\n\t\t\t\t\t\t\t\t<a href=\"javascript:callOrder();\" id=\"drug_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</a>\n\t\t\t\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start -->\n\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'display:none;\' id=\'DrugRemarksMandImg\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksMandatory\' value=\'N\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'DrugRemarksEntered\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 --end -->\n\t\t\t\t\t\t\t\t<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->\n\t\t\t\t\t\t\t<td class=\"label\"  colspan=\"2\">\n\t\t\t\t\t\t\t\t<a href=\"javascript:drugindication_remarks();\" id=\"drug_ind_remarks\" style=\"visibility:visible\" title=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</a>\n\t\t\t\t\t\t\t<!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t<tr style=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" id=\'trDupDrugInfo\'>\n\t\t\t\t\t\t<td colspan=\"6\" class=\"CURRTEXT\">\n\t\t\t\t\t\t<marquee  scrollamount=\"4\" ><font  style=\"font-weight:bold;color:black\" size=1>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</font></marquee>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr> <!-- tr moved from inside if condition for MO-GN-5490 [IN:054620] -->\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t<INPUT TYPE=\"hidden\" NAME=\"sql_ph_prescription_bl_action_select_lookup\" VALUE=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t<tr id=\'BL_HEADERBAR\' style=\'display:none;\'>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"6\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr id=\'BL_HEADER\' style=\'display:none;\'>\n\t\t\t\t\t \t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td class=\"label\" width=\'9%\' id=\'bl_override_excl_incl_ind_lbl\'>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td  class=\"label\" width=\'40%\'>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" nowrap width=\'13%\' style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\"  width=\'20%\'style=\'TEXT-ALIGN:center;\'>";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr id=\'BL_VALUES\' style=\'display:none;\'>\n\t\t\t\t\t\t <td align=\'center\' id=\'bl_def_override_excl_incl_ind_gif\'>&nbsp;\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<td class=\"label\" id=\'td_bl_override_excl_incl_ind\'>\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n                      <select name=\"bl_override_excl_incl_ind\" onchange=\"assignOverrideExclInclInd(this)\"  >\n\t\t\t\t\t\t  <!--  <option value=\"SEL\">---";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="---</option> --> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t     <option value=\"SEL\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =">---";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="---</option>\n\t\t\t\t\t\t\t\t<option value=\"E\" ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" >";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t    <option value=\"SEL\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="---</option>\n\t\t\t\t\t\t\t    <option value=\"I\" ";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</option>\n\t\t\t\t\t\t\t    <option value=\"E\" ";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t\t\t      <option value=\"SEL\"selected>---";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="---</option>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_def_override_excl_incl_ind\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_override_allowed_yn\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'>\n\t\t\t\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t\t\t\t<input type=\'text\' name=\'bl_incl_excl_override_reason_desc\' size=\'40\'  value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\' readonly >\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\');\" disabled><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:hidden;\'></img>\n";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t\t\t\t\t<input type=\"button\" name=\"bl_overriden_action_reason_lkp\" value=\"?\" class=\"button\" onClick=\"searchBLOverrideReason(\'";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\');\"><img  src=\"../../eCommon/images/mandatory.gif\" id=\'bl_overriden_action_reason_img\' style=\'visibility:visible;\'></img>\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_incl_excl_override_reason_code\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"data\" id=\'bl_total_charge_amt\' align=\'center\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"data\" id=\'bl_patient_payable_amt\' align=\'center\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\'center\'id=\'bl_approval_reqd_yn\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n<!-- Prescription Writer Table ends-->\n\n<!-- Hidden values starts-->\n";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" name=\"presBean_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\" name=\"presBean_name\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" name=\"bean_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\" name=\"bean_name\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" name=\"patient_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" name=\"encounter_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" name=\"bed_num\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" name=\"room_num\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" name=\"mode\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" name=\"drug_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" name=\"ext_prod_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\" name=\"srl_no\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\" name=\"tapper_srl_no\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" name=\"form_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\" name=\"strength_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" name=\"strength_uom_desc\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" name=\"pres_base_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" name=\"pres_base_uom_desc\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" name=\"dosage_type\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\" name=\"tab_qty_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" name=\"strength_value\">\n\t\t<input type=\"hidden\" value=\"\" name=\"freq_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" name=\"interval_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" name=\"repeat_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" name=\"freq_nature\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" name=\"repeat_durn_type\">\t\t\n\t\t<input type=\"hidden\" value=\"\" name=\"calcualted_durn_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" name=\"max_durn_value\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" name=\"chk_for_max_durn_action\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\" name=\"calling_mode\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\" name=\"max_refills_for_pres\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" name=\"max_durn_for_refill_pres\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" name=\"order_type_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" name=\"back_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" name=\"future_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\" name=\"rowVal\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" name=\"ord_auth_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" name=\"force_auth_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" name=\"ord_spl_appr_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" name=\"ord_cosign_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" name=\"ord_approved_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" name=\"authroize_yn_val\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" name=\"ord_authorized_prev_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\" name=\"ord_cosigned_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" name=\"split_dose_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" name=\"split_dose_yn_val\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" name=\"scheduled_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" name=\"admin_time\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" name=\"admin_qty\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" name=\"allergy_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" name=\"limit_ind\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" name=\"current_rx\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" name=\"mono_graph\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\" name=\"monograph\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" name=\"generic_id\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\" name=\"generic_name\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_desc\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_durn_value\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_dispensed_qty\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_dispensed_uom\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_bms_qty\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_strength_value\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_strength_uom\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_pres_qty_value\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_pres_qty_uom\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_total_strength\">\n\t\t<input type=\"hidden\" value=\"\" name=\"in_total_strength_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\" name=\"dflt_qty_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\" name=\"qty_desc_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" name=\"allergy_override\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" name=\"dose_override\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" name=\"currentrx_override\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\" name=\"sch_over_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" name=\"unit_dose\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" name=\"daily_dose\">\n\t\t<input type=\"hidden\" value=\"\" name=\"conv_factor\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" name=\"strength_per_pres_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\" name=\"strength_per_value_pres_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" name=\"qty_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\" name=\"consider_stock_for_pres_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" name=\"source\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\" name=\"refill_cont_order_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" name=\"consent_reqd_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" name=\"min_daily_dose\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\" name=\"min_unit_dose\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\"\tname=\"freq_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" name=\"init_qty\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" name=\"prn_dose\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" name=\"no_refill\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" name=\"refill_start_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\" name=\"refill_end_date\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" name=\"ph_version\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\" name=\"stock_uom\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" name=\"calc_by_ind\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" name=\"dosage_std\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" name=\"dosage_unit\">\t \n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\" name=\"dosage_unit_uom\">\t<!-- code added for IN050721-->\n\t\t<INPUT TYPE=\"hidden\" NAME=\"recomm_dosage_by\" VALUE=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" name=\"recomm_yn\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" name=\"patient_class\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\" name=\"allow_duplicate\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" name=\"take_home\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" name=\"allow_without_diag\">\t\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" name=\"prn_remarks_flag\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" name=\"prn_yn\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" name=\"man_rem_on_prn_freq_yn\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" name=\"order_set_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" name=\"order_set_occur_num\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" name=\"ord_set_reqd_or_opt\">\t\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" name=\"sliding_scale_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" name=\"def_freq_found\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" name=\"fract_dose_appl_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" name=\"fract_dose_round_up_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" name=\"dup_found\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" name=\"in_formulary_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" name=\"drug_class\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" name=\"calc_def_dosage_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\" name=\"dsg_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\" name=\"dup_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" name=\"con_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\" name=\"int_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" name=\"alg_reason\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\" name=\"DurnDescDetails\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" name=\"refill_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" name=\"refill_yn_from_param\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" name=\"amend_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" name=\"billable_item_yn\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" name=\"tappered_over\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\" name=\"drug_tapered\">\n\t\t<input type=\"hidden\" name=\"DrugIndicationRemarks\" value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->\n\t\t<input type=\"hidden\" name=\"intr_restric_trn\" value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\"><!--Added for  RUT-CRF-0066 -->\n\t\t<input type=\"hidden\" name=\"intr_msg_content\" value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\"><!--Added for  RUT-CRF-0066 -->\n\t\t<input type=\"hidden\" name=\"interaction_override\" value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\"><!--Added for  RUT-CRF-0066 -->\n\t\t<input type=\"hidden\" name=\"interaction_exists\" value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\"><!--Added for  RUT-CRF-0066 -->\n\t\t<input type=\"hidden\" name=\"ATC_Duplicate_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"calc_dosg_by_freq_durn_yn\" value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\"><!-- added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595] -->\n\t\t\t<!--  added for CRF RUT-CRF-0063[29601]--start -->\n\t\t<input type=\"hidden\" name=\"pregnency_yn\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" name=\"preg_effect\">\n        <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\" name=\"preg_category_code\">\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\" name=\"pregnency_cat\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\" name=\"pregnency_cat_desc\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" name=\"preg_remarks\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\" name=\"drug_desc\" >\n\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" name=\"preg_warn_req_yn\" >\n\t\t<input type=\"hidden\" name=\"trimester\" value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\n\t\t<label id=\"tool_tip\" style=\"visibility:hidden\"></label><!--  added for CRF RUT-CRF-0063[29601]--end -->\n\t\t<input type=\"hidden\" name=\"external_patient_id\" value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\"><!--added for  [IN:040734]-->\t\t\t\n\t\t<input type=\"hidden\" name=\"taper_disable\" value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\"><!--Added for RUT-CRF-0066 -->\n\t\t<input type=\"hidden\" name=\"take_home_start_date\" value=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\"><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t<input type=\"hidden\" name=\"take_home_end_date\" value=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\"><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->\n\t\t<input type=\"hidden\" name=\"order_id_copy\" value=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\"><!--Added for ML-BRU-SCF-1333 [IN:049124]-->\n\t\t<input type=\"hidden\" name=\"order_line_no_copy\" value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\"><!--Added for ML-BRU-SCF-1333 [IN:049124]--> \n\t\t<input type=\"hidden\" name=\"default_dosage_by_yn\" value=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\"><!--AAKH-CRF-089--> \n\t\t<input type=\"hidden\" name=\"parent_stat_yn\" value=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\t<!--AAKH-CRF-0091-->\n\n\t\t<input type=\"hidden\" name=\"stat_yn\" value=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\"><!--AAKH-CRF-0091-->\n\t\t<input type=\"hidden\" name=\"chk_missing_sch_yn\" value=\"N\"><!--AAKH-CRF-0091-->\n\t\t<input type=\"hidden\" name=\"chk_missing_sch_yn_1\" value\"\"><!--AAKH-CRF-0091-->\n\n\t\t\n<!-- Hidden values ends-->\n\n\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t</table>\n\t\t</div>\n\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\n\t\t\t\t\t\t<script>\t\t\tdocument.prescription_detail_form.all.current_rx.value = \"Y\"; </script>\n\t";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\n\t\t\t\t\t\t\t\t\t<script>\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.prescription_detail_form.all.current_rx.value = \"Y\"; \n\t\t\t\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\n\t\t\t\t\t\t\t\t\t\t<script>\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tdocument.prescription_detail_form.all.ATC_Duplicate_yn.value = \"Y\"; \n\t\t\t\t\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\n\t\t\t\t<script>\n\t\t\t\t\talertIntr(\'";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\', \'";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\',\'N\')\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\n\t\t<script>\n\t\t\tassignDurnTypeList(\'";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\');\n";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\n\t\t\t\tdisableItems();\n";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t\t\t\tduplicateWarning();\n";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\n\t\t\t\t\talert(getMessage(\"PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND\",\'PH\'));\n\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\'";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\'); //Commented for IN25242 --10/12/2010-- priya //Uncommented for ML-BRU-SCF-1664[58792]\n";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\n\t\t\t\t//freqChange(document.prescription_detail_form.frequency,\"Y\");\n\t\t\t\t//reloadDurnTypeList(); //commented to stop max duration alert from displaying twice on load --priya-- 02/03/2010\n\t\t\t\t//dfltDurnDesc(\'";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\');\n\t\t\t\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\n\t\t\t\t\tdfltDurnDesc(\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\n\t\t\t\t\tstoreSchedule(); // added while fixing IN25532 -- priya-- 27/12/2010\n";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\n\t\t\t\t\t\tpopulateQtyDesc(\'";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\n\t\t\t\tpopulateEndDate();\n\t\t\t\tgetFormatId();  \n";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\n\t\t\t\t\tdocument.prescription_detail_form.all.dosage_limit.style.visibility=\"visible\";\t\t\n\t\t\t\t\tdocument.prescription_detail_form.all.override_remarks.style.visibility=\"visible\";\n";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\n\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\n\t\t\t\tdocument.prescription_detail_form.start_date.disabled=true;\n\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n\t\t\t\tdocument.prescription_detail_form.priority.disabled=true;\n\t\t\t\tdocument.prescription_detail_form.dosage.disabled=true;\n";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\n\t\t\t\tdocument.prescription_detail_form.start_date.disabled=true;\n\t\t\t\tdocument.prescription_detail_form.priority.disabled=true;\n\t\t\t\tdocument.prescription_detail_form.dosage.disabled=true;\n";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\n\t\t\t\t//setfocus(document.prescription_detail_form.qty_value);\n\t\t\t\t// for Stat freq\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\'==\'O\'){\n\t\t\t\t\tdocument.prescription_detail_form.in_durn_desc.value=\"\";\n\t\t\t\t\tdocument.prescription_detail_form.in_durn_value.value=\"\";\n\t\t\t\t\tdocument.prescription_detail_form.durn_desc.value=\"D\";\n\t\t\t\t\tdocument.prescription_detail_form.durn_value.value=\"1\";\n\t\t\t\t\tdocument.prescription_detail_form.durn_value.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.end_date.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.endDateImg.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.durn_desc.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.calcualted_durn_value.value=\"1\";\n\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.no_refill.value=\"\";\n\t\t\t\t\tdocument.prescription_detail_form.refill_start_date.value=\"\";\n\t\t\t\t\tdocument.prescription_detail_form.refill_end_date.value=\"\";\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\'==\'P\'){\n\t\t\t\t\tdocument.prescription_detail_form.durn_desc.value=\"D\";\n\t\t\t\t\tdocument.prescription_detail_form.durn_desc.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.durn_value.disabled=false;\n\t\t\t\t\tdocument.prescription_detail_form.allow_refill.disabled=true;\n\t\t\t\t\tdocument.prescription_detail_form.end_date.disabled=false;\n\t\t\t\t\tdocument.prescription_detail_form.endDateImg.disabled=false;\n\t\t\t\t\tif(document.prescription_detail_form.no_refill!=null) {\n\t\t\t\t\t\tdocument.prescription_detail_form.no_refill.value=\"\";\n\t\t\t\t\t\tdocument.prescription_detail_form.no_refill.disabled=true;\n\t\t\t\t\t\tdocument.prescription_detail_form.refill_start_date.value=\"\";\n\t\t\t\t\t\tdocument.prescription_detail_form.refill_end_date.value=\"\";\n\t\t\t\t\t}\n\t\t\t\t\tinterval_value=\"1\";\n\t\t\t\t\trepeat_value=\"1\";\n\t\t\t\t}\n";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\n\t\t\t\tif(document.prescription_detail_form.freq_nature.value==\"P\"){\n\t\t\t\t\tdocument.all.prn_remarks.style.visibility\t= \"visible\";\n\t\t\t\t\tif(document.prescription_detail_form.man_rem_on_prn_freq_yn.value == \'Y\'){\n\t\t\t\t\t\tdocument.all.prn_remarks_image.style.visibility\t= \"visible\";\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tdocument.all.prn_remarks_image.style.visibility\t= \"hidden\";\n\t\t\t\t\t}\n\t\t\t\t\tdocument.all.dis_split_dose.style.visibility\t= \"hidden\";\n\t\t\t\t}\n\t\t\t\tcheckWtAndHt(prescription_detail_form);\n";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\'N\', \'N\', \'ChangeFreq\');\n\t\t\t\t\tdocument.all.priority.disabled\t= true;\n";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\n\t\t\t\t\tfreqChange(document.prescription_detail_form.frequency,\'N\',\'N\',\'ChangeFreq\');\n";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\n\t\t\t\t\t//dfltDurnDesc(\'";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\');\n\t\t\t\t\tvalidateAllDates(); //added for IN24020 to update the end date correctly for copied order --28/09/2010-- priya\n\t\t\t\t\tdurationConversn(document.prescription_detail_form.durn_desc);\n";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\n\t\t\t\t\tlookForChange(document.prescription_detail_form.qty_value);\n";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\n\t\t\t\t\t\t\tdocument.prescription_detail_form.all.dosage_limit.style.visibility=\"visible\";\n\t\t\t\t\t\t\tdocument.prescription_detail_form.all.override_remarks.style.visibility=\"visible\";\n";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\"ATC_DUPLICATION\",\'PH\'));\n";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\n\t\t\t\t\tif(document.prescription_detail_form.all.prn_yn.value==\"N\"){\n\t\t\t\t\t\tdocument.all.prn_remarks_image.style.visibility\t= \"hidden\";\n\t\t\t\t\t}\n";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\t\t\t\t\t\t\tif(parent.f_button.document.forms(0).btnDiscOrders!=undefined)//added for icn after click on confirm system not responding \n\t\t\t\t\t\t\tparent.f_button.document.forms(0).btnDiscOrders.style.display = \"inline\";\t\t\t\t\tcallDiscCancelOrders(\'";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\',\'\',\'N\',\'";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\'); <!--skip_duplicte_alert,ph_drug_overlap_period,locale,previous_order_date Added for MO-CRF-20085.1 [IN057392] -->\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\t\t\t\t\t\t\tif(parent.f_button.document.forms(0).btnDiscOrders!=undefined)\n\t\t\t\t\t\t\tparent.f_button.document.forms(0).btnDiscOrders.style.display = \"inline\";\n";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\t\t\t\t\t\t\tif(parent.f_button.document.forms(0).btnDiscOrders!=undefined)\n\t\t\t\t\t\t\tparent.f_button.document.forms(0).btnDiscOrders.style.display = \"none\";\n";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\tdocument.prescription_detail_form.durn_desc.value=\'";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\';\n\t\t\t\t\tpopulateEndDate(); //aded for IN25777 --07/01/2011-- priya\n";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\n\t\t\t\ttry{\n\t\t\t\t\tif(document.prescription_detail_form.absol_qty.style.display != \'none\'){\n\t\t\t\t\t\tif((document.prescription_detail_form.absol_qty.value!=\'\') && parseInt(document.prescription_detail_form.absol_qty.value)== 0){\n\t\t\t\t\t\t\tValidateAbs(document.prescription_detail_form.absol_qty);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\n\t\t\t\t\t//Below code added for IN25596 reopen --24/12/2010-- priya\n\t\t\t\t\tif(document.prescription_detail_form.qty_value.value!=\"\") {\n\t\t\t\t\t\tdocument.prescription_detail_form.qty_value.value =Math.abs(document.prescription_detail_form.qty_value.value);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tcatch(e){\n\t\t\t\t}\t\n";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t\tchkPregnencyAlert();\n";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\n\t\t\t\t\tdefHdrDuration();\n";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\n\t\t\t\t\tcalulateDurnValue(\'";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\',\'normaldetail\');\n";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\n\tmakeDefaultQtyvalueEmpty(\'";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\');  \n\t\t\t";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\t\n\t\t\tdocument.prescription_detail_form.chk_missing_sch_yn.value=\"Y\";\n\t";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\tdocument.prescription_detail_form.drug_name.disabled=true;\n\t\tdocument.prescription_detail_form.drug_search.disabled=true;\n\t\tdocument.prescription_detail_form.priority.disabled=true;\n\t\tdocument.prescription_detail_form.route_code.disabled=true;\n\t\tdocument.prescription_detail_form.buildMAR_yn.disabled=true;\n\t\tdocument.prescription_detail_form.dosage.disabled=true;\n\t\tdocument.prescription_detail_form.qty_value.disabled=true;\n\t\tdocument.prescription_detail_form.qty_desc.disabled=true;\n\t\tdocument.prescription_detail_form.frequency.disabled=true;\n\t\tdocument.prescription_detail_form.dosage_limit.disabled=true;\n\t\tdocument.prescription_detail_form.override_remarks.disabled=true;\n\t\t\n\t\tdocument.prescription_detail_form.dis_split_dose.disabled=true;\n\t\tdocument.prescription_detail_form.durn_value.disabled=true;\n\t\tdocument.prescription_detail_form.durn_desc.disabled=true;\n\t\tdocument.prescription_detail_form.start_date.disabled=true;\n\t\t\n\t\tdocument.prescription_detail_form.end_date.disabled=true;\n\t\t\n";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\t\t\tdocument.prescription_detail_form.dosage_limit.style.visibility=\"hidden\";\n\t\t\tdocument.prescription_detail_form.override_remarks.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t</script>\n";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\n</html>";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 											AAKH-CRF-0091 [IN061197] 
--------------------------------------------------------------------------------------------------------------
*/
		request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{

	HttpSession xx = request.getSession(false);
	Properties jdbc_props = (Properties)xx.getValue("jdbc");
	String patient_id				= "";
	String encounter_id				= "";
	String priority					= "";
	String hr_start_time			= "";
	String drug_code				= "";
	String srl_no					= "";
	String bsa						= "";	
	String prn_yn					="N";
	String man_rem_on_prn_freq_yn	="";
	String order_id					="";
	String order_set_code			="";
	String 	bed_num					= "" ;
	String 	room_num				= "";
	String drug_db_interface_yn		= "";
	String bl_install_yn			= "";
	String bl_disp_charge_dtl_in_rx_yn = "";
	String buildMAR_yn				= "";
	String MAR_app_yn				= "";
	String buildMAR_checked			= "";
	String buildMAR_enable			= "";
	String trade_display_yn			= "";
	int tapper_srl_no				= 1;
	int dose_decimal				= 6;
	String buildMAR_rule			= "";   	//  RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule
	String actionText				=	""; // add for SKR-CRF-0006[IN029561]
	String default_dosage_by					=	"";  //add this for SKR-CRF-PHIS-003[IN028182]
	String default_route_yn				=	"";
	String interaction_exists	=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", severity_level="" ; //Added for	RUT-CRF-0066 IN[029604] 
	String values_changed="";//added for ML-BRU-SCF-1231 [IN:046657]

	String calling_mode			= request.getParameter("mode") ==null?"blank": request.getParameter("mode");
	String modeC      = "";
	String order_idC  = "";
	String order_line = "";
	String taper_disable = ""; //Added for [IN:038913] Bru-HIMS-CRF-093/18
	String tapSlNo="";  //Added for RUT-CRF-0088 [IN036978]
	String tap_lvl_qty="";  //Added for RUT-CRF-0088 [IN036978]
	String freq_chng_durn_value=""; //Added for RUT-CRF-0088 [IN036978]
	String conv_factor=""; //Added for RUT-CRF-0088 [IN036978]
	boolean statFeqFound = false;
	boolean skip_dup_flag = true; //added for CRF-20085.1
	int no_of_days = 0;

	modeC         = request.getParameter("modeC")==null?"":request.getParameter("modeC");
	order_idC     = request.getParameter("order_idC")==null?"":request.getParameter("order_idC");
	order_line    = request.getParameter("order_line")==null?"":request.getParameter("order_line");
	drug_code	  = request.getParameter("drug_code")==null?"":request.getParameter("drug_code") ;
	srl_no		  = request.getParameter("srl_no")==null?"":request.getParameter("srl_no") ;
	tapSlNo		  = request.getParameter("tapSlNo")==null?"":request.getParameter("tapSlNo") ;   //Added for RUT-CRF-0088 [IN036978]
	bsa			  = request.getParameter("bsa") ;
	MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"Y":request.getParameter("MAR_app_yn");
	drug_db_interface_yn        = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	bl_install_yn               = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	trade_display_yn            = request.getParameter("trade_display_yn")==null?"Y":request.getParameter("trade_display_yn");

	patient_id		= request.getParameter("patient_id") ;
	encounter_id	= request.getParameter("encounter_id") ;
	priority		= request.getParameter("priority") ;
	hr_start_time	= request.getParameter("start_date") ;
	bed_num			= request.getParameter("bed_num")==null?"":request.getParameter("bed_num") ; 
	room_num		= request.getParameter("room_num")==null?"":request.getParameter("room_num") ;
	order_set_code	= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");

	String patient_class		= request.getParameter("patient_class");
	String allow_without_diag	= request.getParameter("allow_without_diag");

	String frm_rx_button_yn			=request.getParameter("frm_rx_button_yn")==null?"N":request.getParameter("frm_rx_button_yn");
	String from_sliding_scale_yn			=request.getParameter("from_sliding_scale_yn")==null?"N":request.getParameter("from_sliding_scale_yn");
	String alternateOrder = request.getParameter("alternateOrder")==null?"N":request.getParameter("alternateOrder");//added for  JD-CRF-0198 [IN:058599]
	String alternateDisable	=	"";//added for  JD-CRF-0198 [IN:058599]
	if(allow_without_diag==null) 
		allow_without_diag	=	"Y";
	if(bsa==null) 
		bsa	=	"";
	if(priority==null)	 priority	=	"";

	if(alternateOrder.equals("Y"))//added for  JD-CRF-0198 [IN:058599]
		alternateDisable = "disabled";
	ArrayList presDetails				    =	null;
	HashMap drugDetails					    =	null;
	HashMap taperdrugDetails				=	null;//Added for  RUT-SCF-0321 [IN044816]
	HashMap taperDetails					=	null;//Added for  RUT-SCF-0321 [IN044816]
	String		extdrugCode					=	"";
	String		srlNo						=	"";
	String		allow_duplicate				=	"";
	//IN30118-SCF No: MO-GN-5400. Adding OutPatient Duplicate Drug Check.
	String		allow_duplicate_op			=	"";
	String ph_drug_overlap_period           =   ""; // Added for MO-CRF-20085.1 [IN057392]
        String previous_order_date              =   ""; // Added for MO-CRF-20085.1 [IN057392]
        String skip_duplicte_alert              =   ""; // Added for MO-CRF-20085.1 [IN057392]
	String		ext_prod_id				    =	"";
	String		drug_desc					=	"";
	String		generic_id					=	"";
	String		generic_name				=	"";
	String		drug_class					=	"";
	String		form_code					=	"";
	String		form_desc					=	"";
	String		route_code					=	"";
	String		pres_base_uom				=	"";
	String		pres_base_uom_desc			=	"";
	String		strength_value				=	"";
	String		strength_uom				=	"";
	String		strength_uom_desc			=	"";
	String		strength_per_pres_uom		=   "";
	String		strength_per_value_pres_uom	= 	"";
	String		ord_auth_reqd_yn			= 	"";
	String		ord_authorized_prev_yn		= 	"";
	String		ord_spl_appr_reqd_yn		= 	"";
	String		ord_cosign_reqd_yn			= 	"";
	String		ord_authorized_yn			= 	"";
	String		ord_approved_yn				= 	"";
	String		ord_cosigned_yn				= 	"";
	String		consent_reqd_yn				= 	"";
	String		limit_ind					= 	"";
	String		daily_dose					= 	"";
	String		unit_dose					= 	"";
	String		min_daily_dose				= 	"";
	String		min_unit_dose				= 	"";
	String		mono_graph					= 	"";
	String		qty_value					=   "";
	String		tab_qty_value				= 	"";
	String		freq_code					= 	"";
	String		durn_value					= 	"";
	String		durn_type					= 	"";
	String		consider_stock_for_pres_yn	= 	"";
	String		qty_desc_code				= 	"";
	String		chk_for_max_durn_action		= 	"";
	String		qty_reqd_yn					= 	"";
	String		max_durn_value				= 	"";
	String		allergy_yn					= 	"";
	String		refill_cont_order_yn		= 	"";
	String		start_date					= 	"";
	String		end_date					= 	"";
	String		dosage_type					= 	"";
	String		scheduled_yn				= 	"";
	String		ori_dosage_type				=   "";
	String		repeat_durn_type			= 	"";
	String		max_refills_for_pres		= 	"";
	String		order_type_code				= 	"";
	String		back_date					= 	"";
	String		future_date					= 	"";
	String		split_dose_yn				= 	"";
	String		rowVal						= 	"";
	String		max_durn_for_refill_pres	= 	"";
	String		no_refill					= 	"";
	String		refill_start_date			= 	"";
	String		refill_end_date				= 	"";
	String		admin_time					= 	"";
	String		admin_qty					= 	"";
	String		repeat_value				=   "";
	String		freq_nature					= 	"";
	String		allergy_override			= 	"";
	String		dose_override				= 	"";
	String		currentrx_override			= 	"";
	String		current_rx					= 	"";
	String		dflt_qty_uom				= 	"";
	String		tappered_over				= 	"";
	String		sch_over_yn					= 	"";
	String		disp_locn_code				= 	"";
	String		disp_locn_desc				= 	"";
	String		stock_uom					= 	"";
	String		absol_qty					= 	"";
	String		prn_dose					= 	"";
	String		dosage_option				=	"";
	String		dosage_legend				=	"";
	String		qty_option					=	"";
	String		freq_option					=	"";				
	String		duration_option				=	"";
	String		trade_code					=	"";
	String		trade_name					=	"";
	String		in_formulary_yn				=	"";
	String		freq_chng_durn_desc			=   "";
	String		force_auth_yn			    =   "";
	String statFreqCode="";// added for ML-BRU-SCF-1046 [IN:043889]
	String pregnency_yn				=	"";//added for  RUT-CRF-0063 [IN:029601] -start
	String preg_remarks				=   ""; 
	String pregnency_cat ="";
	String preg_effect   ="";
	String preg_category_code="";
	String preg_warn_req_yn="";
	String preg_icon_disp   ="display:none;";
    String pregnency_cat_desc ="";//added for  RUT-CRF-0063 [IN:029601] -End
	//Code Added For 29927	RUT-CRF-0034 -Start
	String backgrndColor= "";
	String fntColor="";
	String route_color = "";
	//Code Added For 29927	RUT-CRF-0034 -End
	String bl_incl_excl_override_reason_code = "";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind     = "";
	String bl_override_excl_incl_ind         = "";
	String bl_override_allowed_yn            = "";

	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues			=	null;
	String selected_disp				=	"";
	String calendar_status				=	"";
	String route_option					=	"";
	ArrayList		code				=	new ArrayList();
	ArrayList		desc				=	new ArrayList();
	boolean			entered				=	false;
	HashMap taperDateParams				=	null;
	String schedule_status				=	"";
	String absol_qty_status				=	"";
	String u_priority					=	"";
	String r_priority					=	"";
	String refill_status				=	"disabled";
	String brought_by_pat				=	"";
	String brought_by_pat_status		=	"";
	String qty_legend_style				=	"display:none";
	String interval_value				=	"";
	String calc_by_ind					=	"";
	String dosage_std					=	"";
	String dosage_unit					=	"";
	String recomm_yn					=	"";
	String orig_current_rx				=	"";
	HashMap prn_remarks					=	null;
	String prn_remarks_dtl				=	"";
	String prn_remarks_yn				=	"";
	String prn_remarks_code				=	"";
	String pt_coun_reqd_yn				=	"";
	String chk_pat_couns_req			=	"";
	String Disable_recc_dose            =   "";
	String split_dose_yn_val			=   "N";
	String atc_level4_duplication		=   "";
	String ord_set_reqd_or_opt			=	"";
	String sliding_scale_yn				=	"";
	String fract_dose_round_up_yn		=	"";
	int codeCount_1						=   0;
	int codeCount_2						=   0;
	HashMap ext_drugData				=	null;
	String ext_drug_code				=	null;
	String ext_srl_no					=	null;
	boolean def_freq_found				=	false;
	int drug_index=0;
	String parent_disable				=	"";
	String dsg_reason					=	"";
	String dup_reason					=	"";
	String int_reason					=	"";
	String con_reason					=	"";
	String alg_reason					=	"";
	String trade_option					=	"";	
	String trade_option_disable			=	"";
	String fract_dose_appl_yn			=	"";
	String calc_def_dosage_yn			=	"";
	String refill_yn		            =	"";
	String refill_yn_from_param	        =	"";
	//introduced to fix bug when 2 drugs, one split and one non-split drug is copied from prev orders.
	String copied_drug_yn				=	"";
	String split_dose					=	"";
	String split_dose_yn_copy			=	"";
	String order_id_copy				=	"";
	String order_line_no_copy			=	"";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
	Hashtable DurnDescDetails			=   new Hashtable();
	String start_date1 = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	String end_date1 = null;
	String sys_date = null;	
	String tempstartdate1="";
	String tempenddate1 = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
	String default_dosage_by_yn=		"";// AAKH-CRF-089 chithra
	boolean checkflag	=	false;//AAKH-CRF-089
	if(priority.equals("U")) {
		u_priority		=	"selected";
	}
	else {
		r_priority		=	"selected";
	}
	drug_db_interface_yn	    = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	orbean.setLanguageId(locale);

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);

	String presBean_id					= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name				= "ePH.PrescriptionBean";
	PrescriptionBean presBean			= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
System.err.println("PrescriptionDetail_1.jsp-=----410---loading Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
	bean.setLanguageId(locale);
	presBean.setLanguageId(locale);
	int profile_count		= bean.getDrugProfileCount();  //added for Bru-HIMS-CRF-0265 [IN032315]
	String discCancFlag		=""; //added for Bru-HIMS-CRF-0265 [IN032315]
	skip_duplicte_alert       = bean.getSkipDuplicateAlertIp_yn(); // Added for MO-CRF-20085.1 [IN057392]
	//Added code For the incident number 21598 for clearing the chargedetails after selecting the medical item and onclick of RXtab. 
   if(frm_rx_button_yn.equals("Y")){

    String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String consumable_bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
	    consumable_bean.clear();
		putObjectInBean(consumable_bean_id,consumable_bean,request);
   }

	//corrected during PE By Naveen value is getting setted when checkDiagnosis is called from PrescriptionHeader_1.jsp
	//ArrayList diagnosis	=	bean.checkDiagnosis(patient_id);
	//int diag_size	=	(diagnosis).size();
	int diag_size	=	bean.getDiagnosisSize();
	String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
	pregnency_yn	=presBean.getPregnencyYN(patient_id);//added for  RUT-CRF-0063 [IN:029601]
	String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
	String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
	
	int take_home= 0;
	if(encounter_id!=null && !(encounter_id.equals(""))){
		//take_home=bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		take_home=(int)bean.getTakeHomeCount();
	}
	String ph_version				=	(String)PhLicenceRights.getKey();
	String Override_Check		="";
	String Override_Checked		="";
	String checkEnabled			="";
	String display_tdm			="display:none";
	String display_auth_rule	="visibility:hidden";
	String color_auth_rule	    = "RED";
	String order_set_occur_num	= "";
	String recomm_dosage_by     ="";
	String drug_db_allergy_flag         = "";
	String drug_db_duptherapy_flag      = "";
	String drug_db_interact_check_flag  = "";
	String drug_db_contraind_check_flag = "";
	String drug_db_dosage_check_flag    = "";
	String amend_yn					    = "";
	String uom_disp					    = "";

	String include_selected             ="";
	String exclude_selected             ="";
	String Select_selected              ="";
	String billable_item_yn			   ="";
	String check_pat_con	 = "";
	String drug_tapered	 = "";
	float totTapperQty =0;
	float temps = 0.0f;//Added for  RUT-SCF-0321 [IN044816]
	float prevTotTapperQty =0;
	String calc_dosg_by_freq_durn_yn = ""; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	boolean drug_found = false;
	String trimester="";
	//AAKH-CRF-0091 
	String stat_yn = "";
	String parent_stat_yn			= "";
	String chk_missing_sch_yn	="";  //AAKH-CRF-0091 
	String chk_missing_sch_yn_1 ="";  //AAKH-CRF-0091 
		

	if(!calling_mode.equals("blank")){
			presDetails					= (ArrayList) bean.getpresDetails();
			chkValuescheduleFrequency	= bean.getscheduleFrequency();
			start_date					= hr_start_time;
	//		prn_yn						= bean.getchkforPRN();
	//commented during PE By Naveen now taking from drug details
			//man_rem_on_prn_freq_yn 		= bean.getchkforPRN();
			if(presDetails ==null || presDetails.size()==0){
				calling_mode = "blank";
			}		
			if(presDetails!=null && presDetails.size()>0){
				for(int j=0;j<presDetails.size();j++){
					ext_drugData=(HashMap) presDetails.get(j);
					ext_drug_code = (String) ext_drugData.get("DRUG_CODE");
					ext_srl_no    = (String) ext_drugData.get("SRL_NO");
					if(drug_code.equals(ext_drug_code)){
						drug_found = true;
						break;
					}
				}
				if(!drug_found){
					ext_drugData = (HashMap) presDetails.get(0);
					drug_code    = (String) ext_drugData.get("DRUG_CODE");
					srl_no       = (String) ext_drugData.get("SRL_NO"); 
				}
			}
			order_id				    = bean.getOorderIdForTDMDtls(patient_id,drug_code);
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}
			else{
				display_tdm="display:inline";
			} 		
		}
		if(presDetails!=null && presDetails.size()>0){
			for(int i=0;i<presDetails.size();i++){

				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
				//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD");
				if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
			
		//AAKH-CRF-0091	starts				
		stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");
		parent_stat_yn  = (String)drugDetails.get( "parent_stat_yn" )==null?"":(String)drugDetails.get("parent_stat_yn");
		//AAKH-CRF-0091	ends
		
					
					taperdrugDetails = drugDetails;//Added for  RUT-SCF-0321 [IN044816]
					if(drugDetails.containsKey("Override_Check")) {
						Override_Check	=(String)drugDetails.get("Override_Check");
					//Added for AAKH-CRF-0091 start
						if(stat_yn.equals("Y")){ 
							Override_Check="Y";
						}
						// added for AAKH-CRF-0091 end
						if(Override_Check.equals("Y")){
							Override_Checked="Checked";
							checkEnabled="disabled";
						}
						else{
							Override_Checked="";
							checkEnabled="";
						}
					}
					order_set_occur_num    = (String) drugDetails.get("ORDER_SET_OCCUR_NUM")==null?"":(String) drugDetails.get("ORDER_SET_OCCUR_NUM");
					if(order_set_code.equals("")){
						order_set_code	   = (String) drugDetails.get("ORDER_SET_CODE")==null?"":(String) drugDetails.get("ORDER_SET_CODE");
					}
					ext_prod_id			   = (String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					man_rem_on_prn_freq_yn = (String)drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
					
					if( drug_code.equals(extdrugCode) && (String.valueOf(srl_no)).equals(srlNo) ){ //replaced ext_srl_no with srlNo for IN25872 --17-01-2011-- priya
						drug_db_dosage_check_flag    = (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag = (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag  = (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");
						drug_db_duptherapy_flag      = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag         = (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");
					}

					copied_drug_yn				= (String) drugDetails.get("COPIED_DRUG_YN")==null?"N":(String) drugDetails.get("COPIED_DRUG_YN");// if the current drug is copied?
					split_dose					= (String) drugDetails.get("SPLIT_DOSE_PREVIEW")==null?"":(String) drugDetails.get("SPLIT_DOSE_PREVIEW");//the dosage schedule string
					split_dose_yn_copy			= (String) drugDetails.get("SPLIT_YN")==null?"":(String) drugDetails.get("SPLIT_YN");//if the copied drug is split?
					order_id_copy				= (String) drugDetails.get("ORDER_ID")==null?"":(String) drugDetails.get("ORDER_ID");
					order_line_no_copy			= (String) drugDetails.get("ORD_LINE")==null?"":(String) drugDetails.get("ORD_LINE");
					allow_duplicate				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
					//IN30118-SCF No: MO-GN-5400. Assingning OutPatient Duplicate Drug Check.
					allow_duplicate_op				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
					if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
						allow_duplicate = allow_duplicate_op;
						skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
						//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
					}
					/*else{
						ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_IP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
					}*/
					drug_desc					= (String) drugDetails.get("DRUG_DESC");
					prn_remarks					=	bean.getPRNRemarks((String)drugDetails.get("DRUG_CODE"));
					if(prn_remarks != null){
						prn_remarks_dtl			= prn_remarks.get("prn_remarks_dtl")==null?"":(String)prn_remarks.get("prn_remarks_dtl");
						prn_remarks_code		= prn_remarks.get("prn_remarks_code")==null?"":(String)prn_remarks.get("prn_remarks_code");
					}
					DrugIndicationRemarks = (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for ML-BRU-CRF-072[Inc:29938]
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 
					// added for CRF RUT-CRF-0063[29601]-start
					preg_remarks = (String) drugDetails.get("PREG_REMARKS")==null?"":(String)drugDetails.get("PREG_REMARKS");// code "PREG_REMRKS" is replaced by "PREG_REMARKS" for  IN040512
					if(!preg_remarks.equals(""))
						preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8");
					// added for CRF RUT-CRF-0063[29601]-end
					generic_id					= (String) drugDetails.get("GENERIC_ID");
					generic_name				= (String) drugDetails.get("GENERIC_NAME");
					drug_class					= (String) drugDetails.get("DRUG_CLASS");
					form_code					= (String) drugDetails.get("FORM_CODE");
					form_desc					= (String) drugDetails.get("FORM_DESC");
					pres_base_uom				= (String) drugDetails.get("PRES_BASE_UOM");
					pres_base_uom_desc			= (String) drugDetails.get("PRES_BASE_UOM_DESC");
					strength_value				= (String) drugDetails.get("STRENGTH_VALUE");
					strength_uom				= (String) drugDetails.get("STRENGTH_UOM");
					strength_uom_desc			= (String) drugDetails.get("STRENGTH_UOM_DESC");
					strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
					strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
					force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED
					ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
					ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
					ord_authorized_prev_yn		= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
					ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");
					consent_reqd_yn				= (String) drugDetails.get("CONSENT_REQD_YN");
					limit_ind					= (String) drugDetails.get("LIMIT_IND");
					daily_dose					= (String) drugDetails.get("DAILY_DOSE");
					unit_dose					= (String) drugDetails.get("UNIT_DOSE");
					min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
					min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
					mono_graph					= (String) drugDetails.get("MONO_GRAPH");
					qty_value					= (String) drugDetails.get("QTY_VALUE");
					tab_qty_value				= (String) drugDetails.get("TAB_QTY_VALUE");
					freq_code					= (String) drugDetails.get("FREQ_CODE")==null?"":(String) drugDetails.get("FREQ_CODE");
					values_changed				= (String) drugDetails.get("VALUES_CHANGED")==null?"":(String) drugDetails.get("VALUES_CHANGED");//added for ML-BRU-SCF-1231 [IN:046657]
					durn_value					= (String) drugDetails.get("DURN_VALUE");
					durn_type					= (String) drugDetails.get("DURN_TYPE");
					recomm_yn					= ((String)drugDetails.get("RECOMM_YN"));
					consider_stock_for_pres_yn	= (String) drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
					qty_desc_code				= (String) drugDetails.get("QTY_DESC_CODE");
					chk_for_max_durn_action		= (String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION");
					qty_reqd_yn					= (String) drugDetails.get("QTY_REQD_YN");
					max_durn_value				= (String) drugDetails.get("MAX_DURN_VALUE");
					allergy_yn					= (String) drugDetails.get("ALLERGY_YN");
					refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
					start_date					= (String) drugDetails.get("START_DATE");
					end_date					= (String) drugDetails.get("END_DATE");
					drug_tapered				= drugDetails.get("DRUG_TAPERED_YN")==null?"":(String)drugDetails.get("DRUG_TAPERED_YN");
					tappered_over				= (String)drugDetails.get("TAPPERED_OVER")==null?"":(String)drugDetails.get("TAPPERED_OVER");
					dosage_type					=  drugDetails.get("DOSAGE_TYPE")==null?"":(String) drugDetails.get("DOSAGE_TYPE");
					totTapperQty				=  Float.parseFloat(drugDetails.get("TOTTAPPERQTY")==null?"0":(String) drugDetails.get("TOTTAPPERQTY"));
					prevTotTapperQty				=  Float.parseFloat(drugDetails.get("PREVTOTALTAPERQTY")==null?"0":(String) drugDetails.get("PREVTOTALTAPERQTY"));
					tap_lvl_qty					=  drugDetails.get("TAP_LVL_QTY")==null?"":drugDetails.get("TAP_LVL_QTY").toString(); //Added for RUT-CRF-0088 [IN036978]
					/*if(from_sliding_scale_yn.equals("Y")){ // added for IN25532 --27/12/2010-- priya (drug was displaying as absolute on unchecking sliding scale)
						dosage_type					=  drugDetails.get("ORI_DOSAGE_TYPE")==null?"":(String) drugDetails.get("ORI_DOSAGE_TYPE");
					}*/
					//dosage_type					=  drugDetails.get("ORI_DOSAGE_TYPE")==null?"":(String) drugDetails.get("ORI_DOSAGE_TYPE"); //replaced "DOSAGE_TYPE" with "ORI_DOSAGE_TYPE" for IN25014 --15/11/2010-- priya (Commented for IN25274 --29/11/2010)
					scheduled_yn				= (String) drugDetails.get("SCHEDULED_YN")==null?"N":(String) drugDetails.get("SCHEDULED_YN");
					//2nd occurrence of getDrug_schd_flag_yn()
			//AAKH-CRF-0091	starts		
			
			
				if(stat_yn.equals("Y")){
						priority					= "U";
					}
					else{
						priority					= (String)drugDetails.get("PRIORITY");	// IN21582 --26/05/2010 -- priya	
					}
			//AAKH-CRF-0091	ends		  
					if(priority.equals("U")) {
						scheduled_yn = "N";
					}
					ori_dosage_type				= (String) drugDetails.get("ORI_DOSAGE_TYPE");
					repeat_durn_type			= drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String) drugDetails.get("REPEAT_DURN_TYPE");
					max_refills_for_pres		= (String) drugDetails.get("MAX_REFILLS_FOR_PRES");
					order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
					back_date					= (String) drugDetails.get("BACK_DATE");
					future_date					= (String) drugDetails.get("FUTURE_DATE");
					split_dose_yn				= (String) drugDetails.get("SPLIT_DOSE_YN")==null?"":(String) drugDetails.get("SPLIT_DOSE_YN");
					split_dose_yn_val			= (String) drugDetails.get("SPLIT_DOSE_YN_VAL")==null?"":(String) drugDetails.get("SPLIT_DOSE_YN_VAL");
					rowVal						= (String) drugDetails.get("rowVal");
					max_durn_for_refill_pres	= (String) drugDetails.get("MAX_DURN_FOR_REFILL_PRES");
					no_refill					= (String) drugDetails.get("NO_REFILL");
					refill_start_date			= (String) drugDetails.get("REFILL_START_DATE");
					refill_end_date				= (String) drugDetails.get("REFILL_END_DATE");
					admin_time					= (String) drugDetails.get("ADMIN_TIME");
					admin_qty					= (String) drugDetails.get("ADMIN_QTY");
					repeat_value				= (String) drugDetails.get("REPEAT_VALUE")==null?"1":(String) drugDetails.get("REPEAT_VALUE");
					in_formulary_yn				= (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");
					freq_nature					= (String) drugDetails.get("FREQ_NATURE")==null?"": (String) drugDetails.get("FREQ_NATURE");
					fract_dose_appl_yn			= (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					calc_def_dosage_yn			= (String) drugDetails.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drugDetails.get("CALC_DEF_DOSAGE_YN");
					default_dosage_by_yn			=(String)drugDetails.get("DEFAULT_DOSAGE_BY_YN").toString();// AAKH-CRF-089 chithra  
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					
					interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS"); //Added for	RUT-CRF-0066 IN[029604] -Start
					intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
					severity_level				= (String) drugDetails.get("SEVERITY_LEVEL")==null?"": (String) drugDetails.get("SEVERITY_LEVEL");
					intr_msg_content			= (String) drugDetails.get("INTR_MSG_CONTENT")==null?"": (String) drugDetails.get("INTR_MSG_CONTENT"); //Added for	RUT-CRF-0066 IN[029604] -end
					amend_yn					= (String) drugDetails.get("AMEND_YN")==null?"N": (String) drugDetails.get("AMEND_YN");
					fract_dose_round_up_yn		= (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					trade_code					= (String) drugDetails.get("TRADE_CODE")==null?"": (String) drugDetails.get("TRADE_CODE");
					trade_name					= (String) drugDetails.get("TRADE_NAME")==null?"": (String) drugDetails.get("TRADE_NAME");
					recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
					default_dosage_by			= (String)drugDetails.get("DEFAULT_DOSAGE_BY")==null?"":(String)drugDetails.get("DEFAULT_DOSAGE_BY"); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
					default_route_yn			= (String)drugDetails.get("DEFAULT_ROUTE_YN")==null?"":(String)drugDetails.get("DEFAULT_ROUTE_YN"); 
					calc_dosg_by_freq_durn_yn  = (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN"); //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
					if(pregnency_yn.equals("Y") && amend_yn.equals("Y") && trimester!=null && !trimester.equals(""))
						trimester=(String) drugDetails.get("trimester");
					else
						trimester=bean.getPregTrimester();
					pregnency_cat  = (String)drugDetails.get("PREG_CATEGORY_GROUP_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_GROUP_CODE");	//added for  RUT-CRF-0063 [IN:029601] -start
					preg_effect  = (String)drugDetails.get("PREG_EFFECT")==null?"":(String)drugDetails.get("PREG_EFFECT");
					preg_effect=java.net.URLEncoder.encode(preg_effect,"UTF-8");//code added for IN040512
					preg_category_code  = (String)drugDetails.get("PREG_CATEGORY_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_CODE");
                    preg_warn_req_yn  = (String)drugDetails.get("PREG_WARN_REQ_YN")==null?"":(String)drugDetails.get("PREG_WARN_REQ_YN");
					pregnency_cat_desc  = (String)drugDetails.get("CATEGORY_GROUP_DESC")==null?"":(String)drugDetails.get("CATEGORY_GROUP_DESC"); 
					//added for  RUT-CRF-0063 [IN:029601]- end
					   
					if(amend_yn.equals("Y")||default_route_yn.equals("Y")||tappered_over.equals("Y")||copied_drug_yn.equals("Y"))//added copied_drug_yn.equals("Y") for SKR-SCF-0586 [IN034375]
						route_code					= (String) drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get("ROUTE_CODE");
					if(pregnency_yn.equals("Y") && !preg_effect.equals("") ) //if block added for  RUT-CRF-0063 [IN:029601]
						preg_icon_disp="display:inline;";
					else
						preg_icon_disp="display:none;";
					if(recomm_dosage_by.equals("B"))
						recomm_dosage_by = "Q";

					if(durn_value==null || durn_value.equals("") || durn_value.equals("0"))
						durn_value="1";
					freq_chng_durn_desc   =  drugDetails.get("freq_chng_durn_desc")==null?"D":(String) drugDetails.get("freq_chng_durn_desc");

					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn			  = (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
		/*========= Swapped the values for IN17378 on 21/12/2009	--Shyampriya =============================================*/			
						bl_override_excl_incl_ind        = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  
						bl_def_override_excl_incl_ind    = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
						//if(!bl_override_allowed_yn.equals("Y"))
							//bl_override_allowed_yn = "disabled";
					}
					sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN")==null?"N":(String)drugDetails.get("SLIDING_SCALE_YN"); 
					sliding_scale_yn = "N";
					drugDetails.put("SLIDING_SCALE_YN","N");	
	//				drugDetails.put("SLIDING_SCALE_YN",sliding_scale_yn);	

	//  RUT-CRF-0062 [IN029600]  Added / Commented to change  Checked / Disabled Properties of Build MAR Checkbox -- begin
	
					/*if(drugDetails.get("BUILDMAR_YN")==null || ((String)drugDetails.get("BUILDMAR_YN")).equals("")){
						drugDetails.put("BUILDMAR_YN",MAR_app_yn);
					}
					buildMAR_yn = (String)drugDetails.get("BUILDMAR_YN");
					*/					
					buildMAR_yn="N";
					if(MAR_app_yn.equals("Y")){						
						/*if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";		
						*/						
						buildMAR_rule=(String) drugDetails.get("BUILD_MAR_RULE")==null?"":(String) drugDetails.get("BUILD_MAR_RULE");						
						if(drugDetails.get("BUILDMAR_YN")==null || drugDetails.get("BUILDMAR_YN").toString().equals("")){
							if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
								buildMAR_checked="";
								buildMAR_yn="N";
							}
						}
						else{
							buildMAR_yn=drugDetails.get("BUILDMAR_YN").toString();

							if(buildMAR_yn.equals("Y"))
								buildMAR_checked ="checked";		
							else
								buildMAR_checked ="";		
						}
						
						if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						}
						
						//  RUT-CRF-0062 [IN029600]  Added to change  Checked / Disabled Properties of Build MAR Checkbox -- end
						
						/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						if(patient_class.equals("IP") || calling_mode.equals("taper")|| calling_mode.equals("tapered"))
			 SRR20056-CRF-0649.1 */
						if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
							buildMAR_enable ="disabled";
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
					}

					allergy_override			= (String) drugDetails.get("ALLERGY_OVERRIDE");
					dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
					currentrx_override			= (String) drugDetails.get("CURRENTRX_OVERRIDE");
					interaction_override			= (String) drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String) drugDetails.get("INTERACTION_OVERRIDE");
					current_rx					= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
					dsg_reason					= (String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
					dup_reason					= (String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
					con_reason					= (String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
					int_reason					= (String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
					alg_reason					= (String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
					atc_level4_duplication	    = (String) drugDetails.get("ATC_LEVEL4_DUPLICATION")==null?"":(String) drugDetails.get("ATC_LEVEL4_DUPLICATION");
					ord_set_reqd_or_opt	        = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");
					//code added for Patient counselling req 
					pt_coun_reqd_yn					= (String) drugDetails.get("PT_COUN_REQD_YN");

					if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
						orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
					}

					dflt_qty_uom				= (String) drugDetails.get("DFLT_QTY_UOM");
					sch_over_yn					= (String)drugDetails.get("SCH_OVER_YN");
					disp_locn_code				= (String) drugDetails.get("DISP_LOCN_CODE")==null?"":(String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc				= (String) drugDetails.get("DISP_LOCN_DESC")==null?"":(String) drugDetails.get("DISP_LOCN_DESC");
					stock_uom					= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty					= (String)drugDetails.get("ABSOL_QTY"); 
					prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
				/*	priority					= (String)drugDetails.get("PRIORITY");	
					if(priority.equals("U")) {
						scheduled_yn = "N";
					} */
					brought_by_pat				= (String)drugDetails.get("BROUGHT_BY_PAT");	
					interval_value				= (String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
					calc_by_ind					= (String)drugDetails.get("CALC_BY_IND");
					dosage_std					= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
					check_pat_con			    = (String)drugDetails.get("PAT_COUNSELING_REQD");
					billable_item_yn		 =		 (String) drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String) drugDetails.get("BILLABLE_ITEM_YN");
					DrugRemarksEntered		 =		 (String) drugDetails.get("DrugRemarksEntered")==null?"":(String) drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					if(drugDetails.containsKey("REFILL_YN")){
						refill_yn =drugDetails.get("REFILL_YN")==null?"N":(String)drugDetails.get("REFILL_YN");
					}
					if(drugDetails.containsKey("REFILL_YN_FROM_PARAM")){
						refill_yn_from_param =drugDetails.get("REFILL_YN_FROM_PARAM")==null?"N":(String)drugDetails.get("REFILL_YN_FROM_PARAM");
					}
					if(check_pat_con != null && check_pat_con.equals("Y")){
						chk_pat_couns_req = "checked";
					}

					if(prn_dose==null || prn_dose.equals("")) {
						prn_dose	=	"1";
					}

					if(priority!=null && priority.equals("R")) {
						r_priority	=	"selected";
						u_priority	=	"";
					}
					else if(priority!=null && priority.equals("U")) {
						u_priority	=	"selected";
						r_priority	=	"";
					}

					if(brought_by_pat!=null && brought_by_pat.equals("Y")) {
						brought_by_pat_status	=	"checked";
					}
					
					if(strength_value.equals("0"))
						strength_value			=	"";

					if(limit_ind==null)
							limit_ind	=	"Y";
					if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
						frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
					}

					selected_disp				=	bean.getDispLocation(srlNo);

					if(absol_qty==null || absol_qty.equals(""))
						absol_qty		=	"0";

					if(freq_nature.equals("P") && absol_qty.equals("0")) {
						absol_qty		=	prn_dose;	
					}
				}
			}
			for(int j=0;j<presDetails.size();j++){
				ext_drugData=(HashMap) presDetails.get(j);

				ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				if(drug_code.equals(ext_drug_code)){
					codeCount_1++;
				}
				if(drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no))
					drug_index = j;
			}

			if(codeCount_1>1){
				for(int k=drug_index;k<presDetails.size();k++){
					ext_drugData=(HashMap) presDetails.get(k);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					if(drug_code.equals(ext_drug_code)){
						codeCount_2++;
					}
				}
			}
			if((codeCount_1>1 && codeCount_2>1) || stat_yn.equals("Y")){    //AAKH-CRF-0091	starts

				parent_disable="disabled readOnly";
			}
			tapper_srl_no = bean.getSrlNo();// +1 // modified on 14/04/2010 -- priya
		}
		if(from_sliding_scale_yn.equals("Y")){     // added for IN22691 -- 20/07/2010-- priya
			 bean.getclearscheduleFrequency(drug_code+srl_no); 
			 if(ori_dosage_type.equals("S"))
				qty_value =strength_value;
			 else
				 qty_value = tab_qty_value;
		}
		//delete frequency on reset/without confirm

		if(frequencyValues!=null && frequencyValues.size()>0  && scheduled_yn.equals("N")) { 
			bean.getclearscheduleFrequency(drug_code+srl_no);
			frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
		}
		// enable/disable calendar gif
		if(start_date==null || start_date.equals(""))
			calendar_status	=	"disabled";       //AAKH-CRF-0091	

		
		if(stat_yn.equals("Y") || parent_stat_yn.equals("Y"))    //AAKH-CRF-0091	

			calendar_status	=	"disabled";
		//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
		if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){
			start_date1 = (String)bean.getTakeHomeDates().get(0);
			end_date1=(String)bean.getTakeHomeDates().get(1);
			tempstartdate1 = start_date1;
			tempenddate1 = end_date1;
			sys_date=(String) presBean.getSysdate();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date stdate =sdf.parse(start_date1);
			java.util.Date sydate  = sdf.parse(sys_date);
			if(stdate.compareTo(sydate)<0){
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
				tempstartdate1 = formatter.format(sydate);
				String tempendString  = end_date1.substring(0, 10);
				String systempString =tempstartdate1.substring(11, tempstartdate1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			else if(stdate.compareTo(sydate)>0){
				String tempendString = end_date1.substring(0, 10);
				String systempString =start_date1.substring(11, start_date1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			
			String checked_yn = bean.getHome_leave_checked();
			if(checked_yn==null)
				checked_yn = "";
			if(checked_yn.equalsIgnoreCase("Y")){
				//String tempstartString  = start_date1.substring(0, 10);
				//String tempendString  = end_date1.substring(0, 10);
				//String systempString =sys_date.substring(11, sys_date.length());
				//start_date1 = tempstartString.concat(" "+systempString);
				//end_date1 = tempendString.concat(" "+systempString);
				buildMAR_enable="disabled";//Added for ML-BRU-SCF-1407 [IN 050482]
				buildMAR_checked="";//Added for ML-BRU-SCF-1407 [IN 050482]
				if(presDetails!=null && presDetails.size()>0 && (!amend_yn.equals("Y") && tappered_over.equalsIgnoreCase("N"))){
					start_date = tempstartdate1;
					end_date = tempenddate1;
				}
			}
		}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		
		// Current Rx 
		//corrected for PE by Naveen new method getPatientActiveOrders1(String patient_id,String patient_class) added in Prescription Bean
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();
		for(int i=0; i<size; i++)	{
			record					=	(HashMap)active_orders.get(i); 
			drug_description.append((String)record.get("drug_desc"));
			drug_description.append(" , ");
		}*/
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders1(patient_id,patient_class);
		int active_orders_size			=	active_orders.size();
		StringBuffer drug_description	=	new StringBuffer();
		for(int i=0; i<active_orders_size; i++)	{
			drug_description.append(active_orders.get(i));
			drug_description.append(" , ");
		}*/	//PE corrections ends here

	// load applicable routes
	if(!calling_mode.equals("blank")) {	
		if(route_code==null || route_code.equals ("") )
			route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
		else
			actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]					
		ArrayList routes				=	presBean.getRoutes(form_code); 
		for(int l=0; l<routes.size(); l+=3) { 
			backgrndColor="FFFFFF";
			fntColor="000000";
			route_color = (String)routes.get(l+2);
			if(route_color!= null && !route_color.equals("")){
				if(route_color.length()==12){
				    fntColor= route_color.substring(0, 6);
					backgrndColor= route_color.substring(6, 12);
				}
			}
			if( ((String)routes.get(l)).equals(route_code) ) {  
				route_option	= route_option + "<option style='color:"+fntColor+";background-color:"+backgrndColor+";' value='"+(String)routes.get(l)+"'selected>"+(String)routes.get(l+1)+"</option>";				 
			}
			else {	
				route_option	= route_option + "<option value='"+(String)routes.get(l)+"'   style='color:"+fntColor+";background-color:"+backgrndColor+";'>"+(String)routes.get(l+1)+"</option>";				
			}	
		}
		// Code Ends Here 

		ArrayList trades	=	presBean.getTrades(drug_code); 
System.err.println("PrescriptionDetail_1.jsp-=--1004---loading-Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
		if(trades != null){
			for(int l=0; l<trades.size(); l+=2) { 
				if( ((String)trades.get(l)).equals(trade_code)) {  
					trade_option	= trade_option +"<option value='"+(String)trades.get(l)+"' selected>"+(String)trades.get(l+1)+"</option>";
				} 
				else {	
					trade_option	= trade_option+ "<option value='"+(String)trades.get(l)+"'>"+(String)trades.get(l+1)+"</option>";
				}	
			}
		}
		else
			trade_option="<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";

		if(trade_option.equals("")|| calling_mode.equals("taper") || calling_mode.equals("tapered"))
			trade_option_disable = "disabled";
		else
			trade_option_disable="";
	}
	// Legend and dosage unit is controlled based on dosage type
	if(dosage_type.equals("A")){
		dosage_legend	= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels");
		dosage_option	= "<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels")+"</option>";
	}
	else if(dosage_type.equals("S")){
		dosage_legend	= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");
		dosage_option	= "<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
	}
	else if(dosage_type.equals("Q")){
		dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
		if(ori_dosage_type.equals("S")){
			dosage_option	= "<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}
		else{
			dosage_option	= "<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}		
	}
	// Get the unit dose for scheduled
	if(!calling_mode.equals("blank") && split_dose_yn.equals("N")) {
		ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		if(schedule!=null && schedule.size() > 0) {
			 ArrayList dose_list	= (ArrayList)schedule.get(4);
			 if(dose_list!=null && dose_list.size()>0)
			    qty_value	= (String)dose_list.get(0);
		}
	}
	// Default Strength uom
	if(dosage_type.equals("S")){
		qty_option	=  "<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";
	} 
	if(qty_option.equals("")){
		qty_option  =  "<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
	}
	boolean dup_found	=	false;
	// Load Frequency
	HashMap freqValues = null;

	if(!calling_mode.equals("blank")) {	
		if(calling_mode.equals("modify")){
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
		}
		else{
			
		//AAKH-CRF-0091	starts
			
			if(stat_yn.equals("Y")){
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"modify",patient_class);
			
			}
			else{
		//AAKH-CRF-0091	ends
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"taper",patient_class);
			}
		}
		if(((orig_current_rx.equals("Y") && !amend_yn.equals("Y") )||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && !calling_mode.equals("tapered") && !calling_mode.equals("taper")) { //(patient_class.equals("IP") || take_home>0) && removed for IN30118-SCF No: MO-GN-5400.//&& !amend_yn.equals("Y") added for MO-GN-5490 [IN:054620]
			dup_found	=	true;
		}
//Below if part added for IN25872 --17/01/2011-- priya
//When 2 drugs with same FDB code were placed, on click of the first drug hyperlink, the frequency of the first drug was changed to Stat 
		ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){ 

			/*if((priority != null && priority.equals("U") )) {
				for(int i=0;i<freqCode.size();i++){
					if( (bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) {
						if(calling_mode.equals("modify")){
							if(freq_code.equals((String) freqCode.get(i))){
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
								freq_nature	    = "O";
								freq_code	    = ((String) freqCode.get(i));
								def_freq_found  = true;
							}
							else{
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
							}
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
				}
			} 
			else */ //Commented for ML-BRU-SCF-1046 [IN:043889]
			if(allow_duplicate.equals("N")){
				ArrayList stat_freqs	=	presBean.loadStatFreqs();//commented for performance ML-MMOH-SCF-0684
//				ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performaceML-MMOH-SCF-0684
//				if(stat_freqs!=null && stat_freqs.size()==0){ // if() Added for Performance
//					stat_freqs	= (ArrayList)presBean.loadStatFreqs();
//				}
				for(int i=0;i<stat_freqs.size();i+=2){
					if(freq_code.equals((String) stat_freqs.get(i))){
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
						freq_code	    = ((String) stat_freqs.get(i));
					}
					else{
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
					}
					freq_nature	    = "O";
					//def_freq_found = true;
				}
			}
			else{
				for(int i=0;i<freqCode.size();i++){
					if( dup_found  && !amend_yn.equals("Y")) {
						if( ((String) FreqNature.get(i)).equals("O")) { //(bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) changed for tuning
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
					else {
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature	    = (String) FreqNature.get(i); //bean.getFreqNature((String) freqCode.get(i));
							def_freq_found  = true;
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			} 
		}
		else if(freqValues.size()>0 && !(dup_found)){ // && !(dup_found) added while fixing IN25797 --14-01-2011-- priya
			/*if(priority != null && priority.equals("U")) {
				for(int i=0;i<freqCode.size();i++){
					if( (bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) {
						if(calling_mode.equals("modify")){
							if(freq_code.equals((String) freqCode.get(i))){
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
								freq_nature	    = "O";
								freq_code	    = ((String) freqCode.get(i));
								def_freq_found  = true;
							}
							else{
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
								def_freq_found  = true; //added for IN26318 --07/02/2011-- priya
							}
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
				}
			} 
			else{*/
				statFreqCode = freq_code;
				if(priority.equals("U") && !amend_yn.equals("Y")){
					//ArrayList stat_freqs	=	presBean.loadStatFreqs();//commented for performance ML-MMOH-SCF-00684
					ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performaceML-MMOH-SCF-00684
					if(stat_freqs !=null && stat_freqs.size()==0){ //if () added for Performance ML-MMOH-SCF-00684
						stat_freqs	= (ArrayList)presBean.loadStatFreqs();
					}
					if(stat_freqs.size()>0){
						for(int i=0;i<stat_freqs.size();i+=2){
							statFreqCode=(String) stat_freqs.get(i);
							for(int j=0;j<freqCode.size();j++){
								freq_code=(String) freqCode.get(j);
								if(statFreqCode.equals(freq_code)){
									statFeqFound = true;
									break;
								}
							}
						}
					}
				}

				if(stat_yn.equals("Y")){    //AAKH-CRF-0091
					statFeqFound = true;
					dup_found=true;
				}
				int freq_count=0; //AAKH-CRF-0091 
				String prior=""; //AAKH-CRF-0091 
				for(int i=0;i<freqCode.size();i++){
					if( dup_found ) {
						if( ((String) FreqNature.get(i)).equals("O")) { //bean.getFreqNature(((String) freqCode.get(i)))
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
							statFeqFound = true;
						}
					}
					else {
						if(((String) FreqNature.get(i)).equals("O"))//bean.getFreqNature(((String) freqCode.get(i))
							statFeqFound = true;
						if(((String) freqCode.get(i)).equals(statFreqCode)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							def_freq_found  = true;
							freq_nature	    = (String) FreqNature.get(i); //bean.getFreqNature((String) freqCode.get(i));
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
							//def_freq_found  = true; //added while fixing IN26318 --07/02/2011-- priya //commented for ICN 31700 Reopened point
						}
					}
				}
					
				
			
			if(amend_yn.equals("Y"))
				def_freq_found  = true;
		}
		else if(dup_found ) { 
			for(int i=0;i<freqCode.size();i++){//added for MO-GN-5490 [IN:054620]
				if(((String) FreqNature.get(i)).equals("O")){
					freq_code = (String)freqCode.get(i);
					statFeqFound = true;
					break;
				}
			}
//			ArrayList stat_freqs	=	presBean.loadStatFreqs();	
			ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace ML-MMOH-SCF-00684
			if(stat_freqs !=null && stat_freqs.size()==0){ //Addded for Performance ML-MMOH-SCF-00684
				stat_freqs	= (ArrayList)presBean.loadStatFreqs();
			}
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	    = "O";
				//statFeqFound = true;//commented for MO-GN-5490 [IN:054620]
				//freq_code	    = ((String) stat_freqs.get(i)); //commented for MO-GN-5490 [IN:054620]
				//def_freq_found = true;
			}
		} 

		if(freq_option.equals("")) {
//			ArrayList stat_freqs	=	presBean.loadStatFreqs();
			ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace
			if(stat_freqs !=null && stat_freqs.size()==0){ // Added for Performance
				stat_freqs	= (ArrayList)presBean.loadStatFreqs();
			}
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				//def_freq_found = true;
				statFeqFound = true;
				freq_nature	   =	"O";
				freq_code	   = ((String) stat_freqs.get(i));
			}
		}
	}
	// Duration values
	if(!calling_mode.equals("blank")) {	
	//	DurnDescDetails	= (Hashtable)presBean.getDurnDesc();//added for performace ML-MMOH-SCF-0684
	//	if(DurnDescDetails !=null && DurnDescDetails.size()==0){ // if() Added for Performance
			DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		//}
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements())	{
			durn_code		= (String)keys_des.nextElement();
			duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
		}
	}

	// Dispense Location values
/*	if(!calling_mode.equals("blank")  && !(PhLicenceRights.getKey()).equals("PHBASIC") ) { 
		StringTokenizer disp_code	=	new StringTokenizer(disp_locn_code,"|");
		StringTokenizer disp_desc	=	new StringTokenizer(disp_locn_desc,"|");

		while(disp_code.hasMoreTokens()) {
			code.add(disp_code.nextToken());
		}

		while(disp_desc.hasMoreTokens()) {
			desc.add(disp_desc.nextToken());
		}
	}*/

	if(dosage_type.equals("A")) {
		//schedule_status		=	"disabled";
		absol_qty_status	=	"enabled";
	}
	else {
		if(!freq_nature.equals("P"))
			absol_qty			=	"1";
	}

	if(scheduled_yn.equals("N")) {
		schedule_status		=	"disabled";
	}
	// enable/disable refill button
	if(refill_cont_order_yn!=null && refill_cont_order_yn.equals("Y") && refill_yn.equals("Y") && refill_yn_from_param.equals("Y")){
		refill_status="";
	}
	// enable/disable order quantity legend
	if(dosage_type.equals("A") || freq_nature.equals("P")) {
		qty_legend_style	=	"display:inline";
	}
	if(split_dose_yn.equals("Y")){
		Disable_recc_dose  =   "disabled";
	}

	if(freq_nature.equals("P")){
		prn_yn = "Y";
	}
	if( drug_tapered.equals("Y") || stat_yn.equals("Y")) //Added for [IN:038913] Bru-HIMS-CRF-093/18 //|| tappered_over.equals("Y")) - commented for SKR-SCF-0955 [IN:047620]	//stat_yn.equals("Y") added for AAKH-CRF-0091
		taper_disable="disabled";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	if((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) ){
		//if(allergic_yn.equals("N")||allergic_yn.equals("")){

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alternateDisable ));
            _bw.write(_wl_block21Bytes, _wl_block21);

							if(!drug_code.equals(""))	{

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block23Bytes, _wl_block23);

							}                    

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(preg_icon_disp));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

						if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("") ){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block28Bytes, _wl_block28);
//AAKH-CRF-0091 starts						
									if(stat_yn.equals("Y")){
										
										
								
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 
									}
									else{
						//AAKH-CRF-0091 ends			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(r_priority));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(u_priority));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

									//AAKH-CRF-0091
									}
								
            _bw.write(_wl_block35Bytes, _wl_block35);

						}
						else{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(r_priority));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

						}

            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
						
						if(!calling_mode.equals("blank")) { 
							uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
							if(uom_disp == null || uom_disp.equals("null"))
								uom_disp = "";
							if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
								strength_value = Float.parseFloat(strength_value)+"";//"0"+strength_value ;

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(uom_disp));
            _bw.write(_wl_block26Bytes, _wl_block26);

						}	else{

            _bw.write(_wl_block41Bytes, _wl_block41);

						}	

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block47Bytes, _wl_block47);

						if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

						} 

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(route_option));
            _bw.write(_wl_block51Bytes, _wl_block51);
						if(trade_display_yn.equals("Y")){

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(trade_option_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);

							if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

							} 

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(trade_option));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(java.net.URLEncoder.encode(trade_name,"UTF-8")));
            _bw.write(_wl_block59Bytes, _wl_block59);
						}
						else{


            _bw.write(_wl_block60Bytes, _wl_block60);
						}

            _bw.write(_wl_block61Bytes, _wl_block61);

						if(MAR_app_yn.equals("Y")){

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block65Bytes, _wl_block65);

						}
						else{

            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

						}

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(actionText));
            _bw.write(_wl_block69Bytes, _wl_block69);

						display_auth_rule = "visibility:hidden";
						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";

						}

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						}

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(display_auth_rule));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(color_auth_rule));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(display_tdm));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block83Bytes, _wl_block83);

						if(calling_mode.equals("blank")) {

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
	
						}	

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(dosage_option));
            _bw.write(_wl_block84Bytes, _wl_block84);
	//Added for RUT-CRF-0088 [IN036978] --begin				
						String sch_size			=	"1";
						ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
						if(schedule!=null && schedule.size() > 0) {
	 						ArrayList dose_list	= (ArrayList)schedule.get(4);
							
							if(dose_list != null && dose_list.size() > 0 && (split_dose_yn_val.equals("N")) && !(freq_nature.equals("O"))) {
								sch_size		=	""+dose_list.size();
								if(freq_nature.equals("I")) 
									sch_size = "1";
							}
						}
						freq_chng_durn_value = durn_value;
						if(!freq_chng_durn_desc.equals(repeat_durn_type)){
							freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value,freq_chng_durn_desc);
						}
						if(dosage_type.equals("Q"))
							conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
						//RUT-CRF-0088 [IN036978] -- end
						if(!(calling_mode.equals("blank"))) {
							if(qty_value == null || qty_value.equals("") || qty_value.equals("0") )
								qty_value = "1";
							else
								qty_value = java.lang.Math.abs(Float.parseFloat(qty_value))+"";
						}
					
						if(qty_value != null && qty_value.equals("") && !drug_code.equals("")){
							qty_value = "1";

							if( Float.parseFloat(qty_value) < 1)
								qty_value = Float.parseFloat(qty_value)+"";
						}
						if(split_dose_yn.equals("Y")){ 

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block89Bytes, _wl_block89);

						}
						else{

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dose_decimal));
            _bw.write(_wl_block89Bytes, _wl_block89);

						}

            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block94Bytes, _wl_block94);

							if(calling_mode.equals("blank")) {

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
	
							}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(qty_option));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(dosage_legend));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block101Bytes, _wl_block101);

						if(calling_mode.equals("blank")) { 

            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
	
						}	

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(freq_option));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(schedule_status));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

						if(split_dose_yn.equals("N") && (dosage_type.equals(recomm_dosage_by))){

            _bw.write(_wl_block108Bytes, _wl_block108);

						}
						else{

            _bw.write(_wl_block109Bytes, _wl_block109);

						}

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(durn_value));
            _bw.write(_wl_block122Bytes, _wl_block122);

							String tot_taper_visible="display:none;";
							//String editTotTaper="";
							if((tappered_over.equals("Y") || drug_tapered.equals("Y"))&& totalTaperQtyDisplay.equals("Y")){
								if(!parent_disable.equals("") || tappered_over.equals("Y")){
									tot_taper_visible="display:inline;";
									qty_legend_style = "display:none"; //added for RUT-SCF-0155 [IN:033595]
								}
								//if(tappered_over.equals("Y"))
									//editTotTaper="readOnly";
								if(totTapperQty==0 || (tappered_over.equals("N") && drug_tapered.equals("Y") && tap_lvl_qty.equals(""))){    //Commented for RUT-CRF-0088 [IN036978]
									//totTapperQty = bean.getTotalTaperQty(drug_code, srl_no,"ONTAPER",qtyValue,durnValue,repeatValue,intervalValue);
									float qtyValue=1.0f;
									float durnValue=1.0f;
									float repeatValue=1.0f;
									float intervalValue=1.0f;
									if(dosage_type.equals("A"))
										qty_value = absol_qty;
									for(int i=0;i<presDetails.size();i++){//Added for  RUT-SCF-0321 [IN044816]--start
										taperDetails		= (HashMap)presDetails.get(i);
										extdrugCode			= (String)taperDetails.get("DRUG_CODE");
										if(extdrugCode.equals(drug_code)){
											totTapperQty				=  Float.parseFloat(taperDetails.get("TOTTAPPERQTY")==null?"0":(String) taperDetails.get("TOTTAPPERQTY"));
											if(temps < totTapperQty)
												temps=totTapperQty;
										}
									}
									totTapperQty = temps;//Added for  RUT-SCF-0321 [IN044816]--end
									tap_lvl_qty = bean.getOrderQty(taperdrugDetails,qty_value,"",durn_value,"",dosage_type,conv_factor,split_dose_yn.equals("Y"));
									taperdrugDetails.put("TAP_LVL_QTY", tap_lvl_qty+"");
									if(totTapperQty==0){
										totTapperQty = Float.parseFloat(tap_lvl_qty);
									}
								}
								if((taperdrugDetails.get("LOADED_YN")==null || taperdrugDetails.get("LOADED_YN").equals("N")) && !amend_yn.equals("Y") ){
									totTapperQty+= Float.parseFloat(tap_lvl_qty);
									taperdrugDetails.put("LOADED_YN", "Y");
									taperdrugDetails.put("TOTTAPPERQTY", totTapperQty+"");//Added for  RUT-SCF-0321 [IN044816]
								}
								if(!tap_lvl_qty.equals(""))
									tap_lvl_qty = ((int)Float.parseFloat(tap_lvl_qty))+"";
								if(dosage_type.equals("A"))
									taperdrugDetails.put("ABSOL_QTY", tap_lvl_qty+"");
									//drugDetails.put("TOTTAPPERQTY", totTapperQty+"");//Commeneted for  RUT-SCF-0321 [IN044816]
							}
							drugDetails = taperdrugDetails;//Added for  RUT-SCF-0321 [IN044816]

            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(absol_qty));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(absol_qty_status));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(qty_legend_style));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(tot_taper_visible));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(tap_lvl_qty));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tappered_over));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(calendar_status));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(calendar_status));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block148Bytes, _wl_block148);

							if( (bean.getExternalpatient_id()==null ||  bean.getExternalpatient_id().equals("")) && !(patient_class.equals("IP"))){

            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(max_refills_for_pres));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(refill_status));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alternateDisable ));
            _bw.write(_wl_block152Bytes, _wl_block152);

							}
							else{

            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(alternateDisable ));
            _bw.write(_wl_block152Bytes, _wl_block152);

							}

            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(Override_Check));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(Override_Checked));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkEnabled));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(checkEnabled));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tot_taper_visible));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);

								if(calling_mode.equalsIgnoreCase("tapered")|| calling_mode.equalsIgnoreCase("taper")){// Modified for RUT-SCF-321[IN044816]--begin 

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf((int)totTapperQty));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf((int)totTapperQty));
            _bw.write(_wl_block164Bytes, _wl_block164);

								}								
								else{

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf((int)totTapperQty));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf((int)totTapperQty));
            _bw.write(_wl_block164Bytes, _wl_block164);

								}//Modified for RUT-SCF-321[IN044816]--end

            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(((int)totTapperQty)));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(totalTaperQtyDisplay));
            _bw.write(_wl_block169Bytes, _wl_block169);
		
						String dup_drug_info	=	""; //moved from inside if condition forMO-GN-5490 [IN:054620] -start
						ArrayList curr_info	=null;
						if(allow_duplicate.equals("N")){
							curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
							HashMap  dup_info		=	null;
							if(curr_info.size()>=1) {
								dup_info	  =	(HashMap)curr_info.get(0);
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
								dup_drug_info = dup_drug_info+"Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
							}
							/*else{ //Commented else condition for MO-GN-5498 [IN:056880] and added below inside the if condition
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
							}*/
						} //moved from inside if condition for MO-GN-5490 [IN:054620] -end
						if(current_rx != null && (current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) { // && (patient_class.equals("IP")||  take_home>0)

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

							if(allow_duplicate.equals("N") && curr_info!=null && curr_info.size()==0) //added for MO-GN-5498 [IN:056880]
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
						}
						else {	//IN30118-SCF No: MO-GN-5400. OutPatient Duplicate Drug Check.

            _bw.write(_wl_block177Bytes, _wl_block177);
 
								//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 	

            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

		// Dispense Location is displayed in list or text based on the no of values
	    // the below code for list box For External Prescription
									if(bean.getExternalpatient_id()!=null && !bean.getExternalpatient_id().equals("")){
										ArrayList ExternalPresDispCodes			= bean.getExternalPresDispCodes();
										ArrayList ExternalPresDispDesc			= bean.getExternalPresDispDesc();

            _bw.write(_wl_block180Bytes, _wl_block180);
		
										if(ExternalPresDispCodes!= null && ExternalPresDispDesc !=null){
											for(int k=0; k<ExternalPresDispCodes.size(); k++) { 
												if(selected_disp.equals((String)ExternalPresDispCodes.get(k)) ) {

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

												}
												else if(selected_disp.equals("") && !entered){	
													entered	=	true;

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

												}
												else {	

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf((String)ExternalPresDispCodes.get(k)));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf((String)ExternalPresDispDesc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

												}
											}
										}	

            _bw.write(_wl_block184Bytes, _wl_block184);
  
									}
									else if(code.size() > 1 ) {

            _bw.write(_wl_block180Bytes, _wl_block180);
		
										for(int k=0; k<code.size(); k++) { 
											if(selected_disp.equals((String)code.get(k)) ) {

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

											}
											else	if(selected_disp.equals("") && !entered){	
												entered	=	true;

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

											}
											else {

            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf((String)code.get(k)));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf((String)desc.get(k)));
            _bw.write(_wl_block183Bytes, _wl_block183);

											}
										}	

            _bw.write(_wl_block184Bytes, _wl_block184);
  // below code for text box
									}
									else { 

            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(disp_locn_desc));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block188Bytes, _wl_block188);
	
									}

            _bw.write(_wl_block189Bytes, _wl_block189);
	
							/*}
							else {	*/

            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block191Bytes, _wl_block191);

							//}	

            _bw.write(_wl_block192Bytes, _wl_block192);

							//if( (patient_class.equals("OP") || patient_class.equals("EM") || drug_class.equals("C") || drug_class.equals("N"))&& !(take_home>0)) {

							if(pt_coun_reqd_yn!=null && pt_coun_reqd_yn.equals("Y")){

            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(chk_pat_couns_req));
            _bw.write(_wl_block195Bytes, _wl_block195);

							}
							if(!(patient_class.equals("OP") || patient_class.equals("EM"))) {	

            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(brought_by_pat_status));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(parent_disable));
            _bw.write(_wl_block54Bytes, _wl_block54);

							}

            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(DrugRemarksEntered));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);

					}
					String duspInfoDisplay = "display:none"; //Added for MO-GN-5490 [IN:054620]
					if(dup_drug_info!= null && !(dup_drug_info.equals("")))
						duspInfoDisplay = "display:inline;";

            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(duspInfoDisplay));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(dup_drug_info));
            _bw.write(_wl_block204Bytes, _wl_block204);

				if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") ));
            _bw.write(_wl_block188Bytes, _wl_block188);

				}

            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
     
					include_selected ="";  
					exclude_selected =""; 	
					Select_selected  ="";

					if(bl_override_excl_incl_ind.equals("I")){
						include_selected ="selected";
					}
					else if(bl_override_excl_incl_ind.equals("E")){
						exclude_selected ="selected";
					}
					else {
						Select_selected ="selected";
					}

            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
if(bl_override_allowed_yn.equals("I")){
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

							}
							if(bl_override_allowed_yn.equals("E")){

            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

							}
							if(bl_override_allowed_yn.equals("B")){

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(Select_selected));
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(include_selected));
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(exclude_selected));
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

							}
							if(bl_override_allowed_yn.equals("")){

            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);

							}

            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(bl_def_override_excl_incl_ind));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(bl_override_allowed_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(bl_incl_excl_override_reason_desc));
            _bw.write(_wl_block229Bytes, _wl_block229);

						if(bl_incl_excl_override_reason_desc.equals("")){

            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block231Bytes, _wl_block231);

						}
						else{

            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block233Bytes, _wl_block233);

						}

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(bl_incl_excl_override_reason_code));
            _bw.write(_wl_block235Bytes, _wl_block235);

			//}
		}

            _bw.write(_wl_block236Bytes, _wl_block236);

		if(prn_remarks != null && !prn_remarks_dtl.equals("")) {
			prn_remarks_yn	=	"true";
		}
		else {
			prn_remarks_yn	=	"false";
		}

            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(presBean_id));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(presBean_name ));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf( bed_num ));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf( room_num ));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(tapper_srl_no));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(pres_base_uom_desc));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(tab_qty_value));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(interval_value));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(repeat_value));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(max_refills_for_pres));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(max_durn_for_refill_pres));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(back_date));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(future_date));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(rowVal));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(ord_auth_reqd_yn));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(force_auth_yn));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(ord_spl_appr_reqd_yn));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(ord_cosign_reqd_yn));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(ord_approved_yn));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(ord_authorized_yn));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(ord_authorized_prev_yn));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(ord_cosigned_yn));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(split_dose_yn_val));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(scheduled_yn));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(admin_time));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(admin_qty));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(dflt_qty_uom));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(allergy_override));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(dose_override));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(currentrx_override));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(sch_over_yn));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(qty_reqd_yn));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(consider_stock_for_pres_yn));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(refill_cont_order_yn));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(consent_reqd_yn));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(prn_dose));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(no_refill));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(refill_start_date));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(refill_end_date));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(ph_version));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(calc_by_ind));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit)));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf( recomm_dosage_by ));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(recomm_yn));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(allow_duplicate));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(take_home));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(allow_without_diag));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(prn_remarks_yn));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(prn_yn));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(man_rem_on_prn_freq_yn));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(order_set_occur_num));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(ord_set_reqd_or_opt));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(def_freq_found));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(fract_dose_appl_yn));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(dup_found));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(calc_def_dosage_yn));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(dsg_reason));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(dup_reason));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(con_reason));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(int_reason));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(alg_reason));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(refill_yn));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(refill_yn_from_param));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(billable_item_yn));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(tappered_over));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(drug_tapered));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(DrugIndicationRemarks));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(intr_restric_trn));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(intr_msg_content));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(interaction_override));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(interaction_exists));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(calc_dosg_by_freq_durn_yn));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(pregnency_yn));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(preg_effect));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(preg_category_code));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(pregnency_cat));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(pregnency_cat_desc));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(preg_remarks));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(preg_warn_req_yn));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(trimester));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(bean.getExternalpatient_id()==null?"":bean.getExternalpatient_id()));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(taper_disable));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(start_date1));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(end_date1));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(order_id_copy));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(order_line_no_copy));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(default_dosage_by_yn));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(parent_stat_yn));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block375Bytes, _wl_block375);
		
// added for CRF-20085.1 - start
			if(patient_class.equals("OP"))
				ph_drug_overlap_period = overlap_period_for_op;
		
			if (patient_class.equals("IP"))
				ph_drug_overlap_period = overlap_period_for_ip;
			if(amend_yn!=null && amend_yn.equals("N") && (!calling_mode.equals("blank"))){
			if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
					previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
				if(previous_order_date==null || previous_order_date.equals(""))
					previous_order_date = start_date;
					no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
				   if(!locale.equals("en"))
					previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
					if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
						skip_dup_flag = false;
			}
		}
// added for CRF-20085.1 - end
//		if((modeC!=null && modeC.equals("copied_drugs")) || copied_drug_yn.equals("Y")){
		if(copied_drug_yn.equals("Y") && amend_yn!=null && amend_yn.equals("N")){
			// && split_dose_yn_copy.equals("Y")){
			//ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			StringTokenizer  stDrugOrder = new StringTokenizer(order_idC,"!");
			String drugOrd = "";
			String  ord_id = "";
			String line_no = "";
			ArrayList admin_qtyc = new ArrayList();
			boolean split_chk = false;
			while(stDrugOrder.hasMoreTokens()) {
				drugOrd = stDrugOrder.nextToken();
				if(drugOrd.indexOf(drug_code) != -1){
					ord_id = drugOrd.substring(0,drugOrd.indexOf(","));
					line_no = drugOrd.substring((drugOrd.indexOf(",")+1),drugOrd.indexOf("$"));
				}
			}

			if(split_dose!=null && !(split_dose.equals(""))&& scheduled_yn.equals("Y")){
				StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");

				while(vals.hasMoreTokens()) {
					String code1		= (String)vals.nextToken();
					code1=code1+"=";
					StringTokenizer	 inner_vals	=	new StringTokenizer(code1,"=");
					int n=0;
					while(inner_vals.hasMoreTokens()) {
						if(!(n%2==0)){

							String qty		= (String)inner_vals.nextToken();
							if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
								split_chk	=	true;
							}
							admin_qtyc.add(qty);
						}
						n++;				
					}
				}
			}
			split_dose_yn = split_dose_yn_copy;
		
			if(scheduled_yn.equals("Y")  && !(dup_found) && !values_changed.equals("Y")) { // && !(dup_found) added for IN25797 --14/01/2011-- priya //values_changed added for ML-BRU-SCF-1231 [IN:046657]
			 //if(scheduled_yn.equals("Y") ) {
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				//schedule_val.put("start_time_day_param", drug_start_date);
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code+srl_no);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",srl_no);
				sch_output.put("start_date_time",start_date);
				bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null ) { 
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",srl_no);
				sch_output.put("start_time_assign","");

				line_no = order_line_no_copy;
				ord_id = order_id_copy;
				ArrayList values	=	presBean.getFreqDet(ord_id,line_no);
				ArrayList tmp_freq_values = new ArrayList();
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				// date conversion done for IN22002 --11/06/2010-- priya
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale, "en")); 
				freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
					//time_list.add(values.get(p+2));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}

				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);
							if (temp == null || temp.equals("")){
								temp = "0";
							}
							if (!temp.equals("0")){
								if(((Integer.parseInt(temp))-1)< week_days.size())
									day_names.add(week_days.get((Integer.parseInt(temp))-1));
							}
						}
					}
				}
				tmp_freq_values.add(freqCharctValues.get(0));
				tmp_freq_values.add(day_list);
				tmp_freq_values.add(day_names);
				tmp_freq_values.add(time_list);
				tmp_freq_values.add(dose_list);
                sch_output.put(drug_code+srl_no,tmp_freq_values);
				/*int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}
				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						//sch_output.put("admin_day"+(q),"");
					}
				}*/
				bean.setScheduleFrequencyStr(sch_output);
			}
			chkValuescheduleFrequency	= bean.getscheduleFrequency();
		}
	//  duplicate check based on atc -- starts	   [SRR20056-SCF-7916, Rawther, Below 2 lines uncommented ]
	if((!drug_db_interface_yn.equals("Y")) || drug_db_duptherapy_yn.equals("N") || (ext_prod_id.equals(""))){//Added drug_db_duptherapy_yn.equals("N") for  BRU-HIMS-CRF-403
		if(current_rx.equals("Y")) {

			//if((drug_db_duptherapy_flag == null || !drug_db_duptherapy_flag.equals("Y"))&&(!drug_db_duptherapy_yn.equals("Y"))	){
			//commented above if codition for the incident no : 27465
			//replaced drug_db_duptherapy_yn with drug_db_duptherapy_flag for IN21942 --11/06/2010-- priya
		// This condition is commented for IN 17323 for making the override reason button appear on load when drug is tappered down  12/01/2010  - Shyampriya -- comment removed
			String atc_level_1		=	"";
			String atc_level_2		=	"";
			String atc_level_3		=	"";
			String atc_level_4		=	"";
			String atc_level_5		=	"";
			String generic_atc_name =   "";
			String provide_taper	=	"";
			String temp_generic_id	=	"";
			String temp_drug_code	=	"";
			String temp_drug_desc	=	"";
			String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
			ArrayList atc_values	=  new ArrayList();
			ArrayList atc_dup_drug_code= null; // added for the incident no 27465
			HashMap drug_detail		=	null;
System.err.println("PrescriptionDetail_1.jsp-=----2381---loading-end Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);			
				if(presDetails!=null && presDetails.size()>0){
					for(int i=0;i<presDetails.size();i++){			
						drug_detail=(HashMap) presDetails.get(i);
						duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
						if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
							atc_level_1	    =	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
							atc_level_2	    =	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
							atc_level_3	    =	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
							atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
							atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
							generic_atc_name=  	(String)drug_detail.get("GENERIC_ATC_NAME");
							temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
							temp_drug_desc	=	(String)drug_detail.get("DRUG_DESC");
							temp_drug_code  =   (String)drug_detail.get("DRUG_CODE");
							temp_drug_desc=temp_drug_desc.replaceAll(" ","%20");
							temp_drug_desc = java.net.URLEncoder.encode(temp_drug_desc,"UTF-8");
							temp_drug_desc=temp_drug_desc.replaceAll("%2520","%20");

							if(drug_detail.get("TAPPERED_OVER")!=null)
								 provide_taper	= (String)drug_detail.get("TAPPERED_OVER");
							if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {	
								atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
								if(atc_dup_drug_code == null)
									atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
								if(atc_values.contains(temp_generic_id)) {
									current_rx = "Y";
	
            _bw.write(_wl_block376Bytes, _wl_block376);

									drug_detail.put("CURRENT_RX","Y");
									if(drug_code.equals(temp_drug_code)  && skip_dup_flag ){ //skip_dup_flag added for CRF-20085.1
										out.println("<script>alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswithGeneric.label", "ph_labels")+"','"+generic_name+"',''); </script>");
										if(!atc_dup_drug_code.contains(temp_drug_code))//Added to avoid duplicate drugcode on atc list for TTM-SCF-0073[IN046928]
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
									}
								}	// SRR20056-SCF-7689 - Generic name is queried and defaulted (earlier it was code)
									// SRR20056-SCF-6437 - Logic change (removed ATC Level1, ATC Level 2, ATC Level 3)
									// Newly added ATC Level 5 and ATC Level 4, Attached mail in spira for logic details
								else if(atc_values.contains(atc_level_5)&&(drug_code.equals(temp_drug_code))) {
									drug_detail.put("CURRENT_RX","Y");
									current_rx="Y";
	
            _bw.write(_wl_block377Bytes, _wl_block377);

									if(drug_code.equals(temp_drug_code) && skip_dup_flag){ //skip_dup_flag added for CRF-20085.1
										out.println("<script>alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswith.label", "ph_labels")+"','"+atc_values.get(atc_values.indexOf(atc_level_5)-5)+"','"+" at ATC Classification Level 5') </script>");
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
	
            _bw.write(_wl_block378Bytes, _wl_block378);

										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
									}
								}
								else if(atc_values.contains(atc_level_4)&&(drug_code.equals(temp_drug_code))) {
									drug_detail.put("CURRENT_RX","Y");
									current_rx="Y";
	
            _bw.write(_wl_block377Bytes, _wl_block377);

									if(drug_code.equals(temp_drug_code) && skip_dup_flag ){ //skip_dup_flag added for CRF-20085.1
										out.println("<script>alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswith.label", "ph_labels")+"','"+atc_values.get(atc_values.indexOf(atc_level_4)-4)+"','"+"at ATC Classification Level 4') </script>");
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
	
            _bw.write(_wl_block378Bytes, _wl_block378);

									}
								}
								else {

									//drug_detail.put("CURRENT_RX","Y");
									atc_values.add(temp_drug_desc);
									atc_values.add(temp_drug_code);
									atc_values.add(temp_generic_id);
									if(!(generic_atc_name==null || generic_atc_name.equals(""))){
										atc_values.add(generic_atc_name);
									}
									if(!(atc_level_1==null || atc_level_1.equals(""))){
										atc_values.add(atc_level_1);
									}
									if(!(atc_level_2==null || atc_level_2.equals(""))){
										atc_values.add(atc_level_2);
									}
									if(!(atc_level_3==null || atc_level_3.equals(""))){
										atc_values.add(atc_level_3);
									}
									if(!(atc_level_4==null || atc_level_4.equals(""))){
										atc_values.add(atc_level_4);
									}
									if(!(atc_level_5==null || atc_level_5.equals(""))){
										atc_values.add(atc_level_5);
									}
								}
							}
						} //if duplicate_check_at_atc_yn end
					} //for presDetails End 
				} //if presDetails end
			}
			if((amend_yn==null || !amend_yn.equals("Y") || copied_drug_yn.equals("Y")) && interaction_exists.equals("Y")){// && (intr_restric_trn.equals("Y") || severity_level.equals("H"))){ //Added for  RUT-CRF-0066 

            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block381Bytes, _wl_block381);

			}
		} //end drug_db_duptherapy_yn condition	//  duplicate check based on atc -- ends

            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block383Bytes, _wl_block383);
 
			if(calling_mode.equals("blank")){

            _bw.write(_wl_block384Bytes, _wl_block384);
 
			}
			else { 	//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
				//6th occurrence of getDrug_schd_flag_yn()
	//AAKH-CRF-0091
					
				if(stat_yn.equals("Y")){
					statFeqFound=true;
					def_freq_found=true;
					
					
				}
				
				if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)

            _bw.write(_wl_block385Bytes, _wl_block385);

				}
				else if(!amend_yn.equals("Y") && !statFeqFound && priority.equals("U")){
					out.println("alert(getMessage('APPICABLE_STAT_FREQUENCIES_NOT_DEFINED','PH'));");
					out.println("document.prescription_detail_form.priority.value='R'");
				}
				else if(!def_freq_found &&  !amend_yn.equals("Y")){

            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(sliding_scale_yn));
            _bw.write(_wl_block387Bytes, _wl_block387);

				}

            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block383Bytes, _wl_block383);
		
				if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){//code added for 26089 ---by naveen -24Jan2011

            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block383Bytes, _wl_block383);
		
				}
				if(from_sliding_scale_yn.equals("Y")) {

            _bw.write(_wl_block391Bytes, _wl_block391);
	
				}
				if(!dosage_type.equals("S")) {	
					if(copied_drug_yn.equals("Y") || amend_yn.equals("Y")){

            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qty_desc_code));
            _bw.write(_wl_block383Bytes, _wl_block383);
	
					}
					else if(!amend_yn.equals("Y")){

            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block383Bytes, _wl_block383);
	
					}
				}

            _bw.write(_wl_block393Bytes, _wl_block393);
		
				if(((allergy_yn != null && allergy_yn.equals("Y")) || current_rx.equals("Y") || interaction_exists.equals("Y")) && (ext_prod_id== null  ||  ext_prod_id.equals("") || !drug_db_interface_yn.equals("Y")|| drug_db_duptherapy_yn.equals("N")) ) {//Added for Duplicate button issue

            _bw.write(_wl_block394Bytes, _wl_block394);

				}
				if(tappered_over!=null && tappered_over.equals("Y")){// If tappered Disable Refill Button 

            _bw.write(_wl_block395Bytes, _wl_block395);

				}
			}	
			if( calling_mode.equals("taper")){ 

            _bw.write(_wl_block396Bytes, _wl_block396);

				ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
				bean.addScheduleFrequencyStr(schedule,drug_code+tapper_srl_no);
			}	
			if( calling_mode.equals("tapered")){ 

            _bw.write(_wl_block397Bytes, _wl_block397);

			}
			//if(calling_mode.equals("modify") || calling_mode.equals("taper") || calling_mode.equals("tapered") ) { //priya
			if(!calling_mode.equals("blank") ) { //priya

            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block400Bytes, _wl_block400);
	
				//if(amend_yn!=null && amend_yn.equals("N")) {	
				//	HashMap data		=	null;
				//String att			=	null;
				String adm_time		=	"";
				String adm_qty		=	"";
				float total_qty		= 0.0f;
				String final_qty	= "";
System.err.println("PrescriptionDetail_1.jsp-=--2639---loading-Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
								
				if(chkValuescheduleFrequency!=null)
					frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);

				ArrayList dose_list = null;
				if(frequencyValues!=null && frequencyValues.size()>0 && def_freq_found){
					dose_list	= (ArrayList)frequencyValues.get(4);
					if(dose_list!=null && dose_list.size()>0){
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
							final_qty	=	(String)dose_list.get(tqI);
						} 
						String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
						adm_time = tooltiptable;
						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						if(split_chk){
							final_qty		=	String.valueOf(total_qty);
						}
						out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','onLoad')");
					}
				}
				//	else{  // Commented for IN26326 --04/02/2011-- priya (extDosageCheck was not getting called after dose_uom was loaded)
					//out.println("getChargeDetails('"+in_formulary_yn+"','','"+amend_yn+"')"); -- MMS perf
					//if(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals("")) // Commented for IN26326 --04/02/2011-- priya (extDosageCheck was not getting called after dose_uom was loaded)
					out.println("extDosageCheck('onLoad')");
				//}
				/* below code added  for SKR-CRF-PHIS-003[IN028182] -- Start */
				if( !copied_drug_yn.equals("Y") &&!ori_dosage_type.equals(default_dosage_by) && !amend_yn.equals("Y") &&  !calling_mode.equals("taper") && !calling_mode.equals("tapered")) //conditions amend_yn,calling_mode added for  ML-BRU-SCF-0168 [IN:032501]
					out.println("dosageChange(document.prescription_detail_form.dosage);");
				/*    SKR-CRF-PHIS-003[IN028182] -- End */		

            _bw.write(_wl_block401Bytes, _wl_block401);

				if((orig_current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) {	 // && (patient_class.equals("IP") || take_home>0)

            _bw.write(_wl_block402Bytes, _wl_block402);

				}
				else if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		

            _bw.write(_wl_block403Bytes, _wl_block403);

				}
				else if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){

            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(durn_type));
            _bw.write(_wl_block405Bytes, _wl_block405);

				}
				if(!modeC.equals("copied_drugs") && !(split_dose_yn.equals("Y"))){ //  && !(split_dose_yn.equals("Y")) added for IN25596 --21/12/2010-- priya

            _bw.write(_wl_block406Bytes, _wl_block406);
	
				} 
				//if(calling_mode.equals("modify") || calling_mode.equals("taper") || calling_mode.equals("tapered")) {

            _bw.write(_wl_block1Bytes, _wl_block1);
		
// if condition Added for MO-CRF-20085.1 [IN057392] - End
				if(!calling_mode.equals("blank")) {
					if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
						if(atc_level4_duplication.equals("Y")&& currentrx_override.equals("N")){

            _bw.write(_wl_block407Bytes, _wl_block407);
							if(skip_dup_flag){ //skip_dup_flag added for CRF-20085.1

            _bw.write(_wl_block408Bytes, _wl_block408);
							}
						}
					}

            _bw.write(_wl_block409Bytes, _wl_block409);
 
				}		
				discCancFlag=bean.getCancelDiscConDupOrders();//added for Bru-HIMS-CRF-0265 [IN032315] - begin
				if(discCancFlag.equals("Y") ){
					if(profile_count>=1 && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) ){
						boolean dupExists = presBean.checkDuplicateDrug(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code,""); //Added for ML-BRU-SCF-1340 [IN:049282]
						//if((orig_current_rx.equals("Y") || drug_db_duptherapy_flag.equals("Y"))&& !amend_yn.equals("Y") ){//current_rx //Commented for ML-BRU-SCF-1340 [IN:049282]
						if(dupExists && !amend_yn.equals("Y") ){//Added for ML-BRU-SCF-1340 [IN:049282] - replaced the above if condition with this
						/*	if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){// if condition Added for MO-CRF-20085.1 [IN057392] - Start							
									previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);		
							        if(!locale.equals("en"))
							        previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
							} // if condition Added for MO-CRF-20085.1 [IN057392] - End
							*/

            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_db_interface_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ext_prod_id));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(skip_duplicte_alert));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ph_drug_overlap_period));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(previous_order_date));
            _bw.write(_wl_block412Bytes, _wl_block412);

						}
						else if(dupExists) {//orig_current_rx.equals("Y") replaced with dupExists for ML-BRU-SCF-1340 [IN:049282]

            _bw.write(_wl_block413Bytes, _wl_block413);

						}
						else{

            _bw.write(_wl_block414Bytes, _wl_block414);

						}
					}
				}//added for Bru-HIMS-CRF-0265 [IN032315] - end
				if( calling_mode.equals("taper")){  //if block Code added for IN24540 to default duration same as of parent order --21/10/2010-- priya

            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block416Bytes, _wl_block416);

				}

            _bw.write(_wl_block417Bytes, _wl_block417);

				if(pregnency_yn.equals("Y") && !preg_effect.equals("") && preg_warn_req_yn.equals("Y") && !amend_yn.equals("Y") ){ //if block added for  RUT-CRF-0063 [IN:029601]

            _bw.write(_wl_block418Bytes, _wl_block418);

				}
				if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		

            _bw.write(_wl_block419Bytes, _wl_block419);

				}
				if(!amend_yn.equals("Y") && tappered_over.equalsIgnoreCase("N")){//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start

            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(start_date1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end_date1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tempstartdate1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tempenddate1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block421Bytes, _wl_block421);

				}//Added for IN047223--end
			}
			if(default_dosage_by_yn.equals("N")&&amend_yn.equals("N"))	{ //AAKH-CRF-089  Start   //added Newly amend_yn condition	
				
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(stat_yn));
            _bw.write(_wl_block423Bytes, _wl_block423);
}// AAKH-CRF-089  END  Chithra stat_yn added for AAKH-CRF-0091
//AAKH-CRF-0091
	boolean aakh_site=false;
	aakh_site	=presBean.isSiteSpecific("PH","STAT_PARENT_CHILD");
	if(aakh_site==true){
		boolean chk_date = false;
		if(amend_yn.equals("N") && !freq_nature.equals("O") && !freq_nature.equals("I") ){
			
			
			
			ArrayList time_list = new ArrayList();
			
			
			chkValuescheduleFrequency=bean.getscheduleFrequency();
			if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
			}
			
			if(frequencyValues !=null && frequencyValues.size()>0){
				
				time_list		= (ArrayList)frequencyValues.get(3);
				
			}
			
			String sch_first_time = "";
			if(time_list!=null && time_list.size()>0){ // if condition added  for AAKH-SCF-0340 
				sch_first_time=(String)time_list.get(0);
				chk_date=bean.callingSchedule(start_date,sch_first_time,locale);
			}
			
		}
		if(chk_date){
	
            _bw.write(_wl_block424Bytes, _wl_block424);
	}

	}
	if((stat_yn.equals("Y") && !stat_yn.equals(""))|| (parent_stat_yn.equals("Y") && !parent_stat_yn.equals("")) ){
		
            _bw.write(_wl_block425Bytes, _wl_block425);
		if(!stat_yn.equals("") && (stat_yn.equals("Y"))){

            _bw.write(_wl_block426Bytes, _wl_block426);
		}
		
	}//AAKH-CRF-0091

            _bw.write(_wl_block427Bytes, _wl_block427);
 
	System.err.println("PrescriptionDetail_1.jsp-=----2867---loading-end Drug--System.currentTimeMillis()---> " +System.currentTimeMillis());
		putObjectInBean(or_bean_id,orbean,request); 
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block428Bytes, _wl_block428);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ClickCurrentRxbuttontoViewCurrentMedication.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugProfile.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetail.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Form.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.splapproval.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.TDM.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Recom.Dose.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DurationDetail.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Refill.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Refill.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientCounsellingRequired.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientBroughtMedication.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideIncl/Excl.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }
}
