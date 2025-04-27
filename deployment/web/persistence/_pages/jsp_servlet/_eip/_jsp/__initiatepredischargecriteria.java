package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __initiatepredischargecriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/InitiatePreDischargeCriteria.jsp", 1738425833203L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<style type=\"text/css\">\n\t\ttable.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}\n\t\ttable.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;word-wrap:normal;}\n\t\ttable.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;word-wrap: break-word; word-break: break-all;}\n\t\ttable td {padding:2px;}\n\t</style>\n<script>\n\t\t// below code is added for the 17600 end  Wednesday, December 23, 2009\n\t\tfunction clearResultpage()\n\t\t{\n\t\t\tparent.frames[2].location.href =\'../../eCommon/html/blank.html\';\n\t\t}\n\n// Added by Sridhar on Jan 3rd 2006...\n// This Function will check for empty values before calling up the common lookup func..\nfunction BeforeGetPractitioner(obj, target, details)\n{\n\tif(details == \'from\')\n\t{\n\t\tif(document.forms[0].from_practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].from_practid.value =\"\"\n\t}\n\telse\n\t{\n\t\tif(document.forms[0].practid_desc.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].practid.value =\"\"\n\t}\n\n}\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\t{\n\t\tarr=retVal.split(\"~\");\n\t\tdocument.forms[0].practid.value=arr[0];\n\t\tdocument.forms[0].practid_desc.value=arr[1];\t\t\t\n\t\t\n\t}\n\telse{\n\t\tdocument.forms[0].practid.value=\"\";\n\t\tdocument.forms[0].practid_desc.value=\"\";\t\t\t\n\t\n\t}\n}\n\n// By Annadurai 2/6/2004 ., to use Common Lookup. starts.,\nfunction getPractitionerLocal(obj, target, details)\n{\n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\n\tpractName_FName=target.name;\n\tpractName_FValue=target.value;\n\tif(details == \'from\')\n\t\tpractId_FName=document.forms[0].from_practid.name;\n\telse\n\t\tpractId_FName=document.forms[0].practid.name;\n\n\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tvar locale\t\t\t= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q3\");\n\n} // End of getToPractitioner.\n\nfunction submitPage(){\n\t$(\"[name=search]\").attr(\"disabled\",true);\n\tvar nursing_unit\t= $(\"#nursing_unit\").val();\n\tvar dis_date_from\t= $(\"#dis_date_from\").val();\n\tvar dis_date_to\t\t= $(\"#dis_date_to\").val();\n\tvar Splcode\t\t\t= $(\"#Splcode\").val();\n\tvar practid\t\t\t= $(\"#practid\").val();\n\tvar patient_id\t\t= $(\"[name=patient_id]\").val();\n\tvar encounter_id\t= $(\"#encounter_id\").val();\n\tvar oper_stn_id\t\t= $(\"#oper_stn_id\").val();\n\tvar p_called_from_ca\t= $(\"#p_called_from_ca1\").val();\n\tif(nursing_unit==\"\" && dis_date_from==\"\" && dis_date_to==\"\" && Splcode==\"\" && practid==\"\" && patient_id==\"\" && encounter_id==\"\"){\n\t\t alert(getMessage(\'ATLEAST_ONE_VALUE\',\'IP\'));\n\t\t $(\"[name=search]\").attr(\"disabled\",false);\n\t\t return;\n\t}\n\n\t$.ajax({  \n\t     url:\'../../eIP/jsp/getdetailsIP.jsp\',  \n\t     type:\'post\',  \n\t     data:{\'action\':\'initiate_pre_discharge\',\'nursing_unit\':nursing_unit,\'dis_date_from\':dis_date_from,\'dis_date_to\':dis_date_to,\'Splcode\':Splcode,\'practid\':practid,\'patient_id\':patient_id,\'encounter_id\':encounter_id,\'oper_stn_id\':oper_stn_id},\n\t     dataType: \'json\',\n\t     success: function(data) {\n\t       \t $(\"[name=search]\").attr(\"disabled\",false);\n\t    \t var ResultString\t\t\t= \"\";\n\t    \t var recordlist\t\t\t\t= \"\";\n\t    \t var res_header_spec_pract\t= \"\"\n\t    \t var class_name\t\t\t\t= \"\";\n\t    \t var passvalue\t\t\t\t= \"\";\n\t    \t if(data.rowcnt > 0){\n\t    \t\trecordlist\t\t= eval(data.recordslist);\n\t    \t\tResultString\t+= \"<form name=\'InitiatePreDischargeResult\' id=\'InitiatePreDischargeResult\' id=\'InitiatePreDischargeResult\'  method=\'post\' action=\'../../servlet/eIP.InitiatePreDischargeServlet\'>\";\n\t    \t\tResultString\t+= \"<table border=\'1\' width=\'99%\' style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'dataTable\' class=\'mt\'>\";\n\t    \t\tResultString\t+= \"<tr>\";\n\t    \t\tResultString\t+=    \"<th>&nbsp;</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.AdmissionDateTime.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.encounterid.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.patientId.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.PatientName.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.gender.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.nursingUnit.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.bedno.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.roomno.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th>\"+getLabel(\'Common.currentlocation.label\',\'Common\')+\"</th>\";\n\t    \t\tResultString\t+=    \"<th width=\'8%\'> \"+getLabel(\'eIP.PreDischargeInitiated.label\',\'eIP\')+\"</th>\";\n\t\t\t\tResultString\t+= \"</tr>\";\n\t\t\t\tvar pre_dis_checked\t\t= \"\";\n\t\t\t\tvar existing_pat_id\t\t= \"\";\n\t\t\t\t$.each(recordlist,function(index,value){\n\t\t\t\t\tclass_name\t\t\t= value.classValue;\n\t\t\t\t\tpassvalue\t\t\t= value.encounter_id+\"~\"+value.patient_id;\n\t\t\t\t\t\n\t\t\t\t\tif(res_header_spec_pract!=value.res_header_spec_pract){\n\t\t\t\t\t\tResultString\t+= \"<tr><td colspan=\'13\'  class=\'CAGROUPHEADING\' >\"+value.res_header_spec_pract+\"</td></tr>\";\n\t\t\t\t\t}\n\t\t\t\t\tif(value.pre_dis_initiate_yn==\'Y\'){\n\t\t\t\t\t\tpre_dis_checked\t= \"checked\";\n\t\t\t\t\t\texisting_pat_id\t\t+= passvalue+\"|\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tpre_dis_checked\t= \"\";\n\t\t\t\t\t}\n\t\t\t\t\tResultString\t\t+= \"<tr>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'><a href=\'javascript:closeWin(\\\"\"+value.encounter_id+\"\\\",\\\"\"+value.patient_id+\"\\\")\'>+</a></td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.admission_date_time+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.encounter_id+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.patient_id+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\' width=\'100px;\'>\"+value.patient_name+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.gender+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.nursing_unit_short_desc+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.bed_no+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.room_no+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\'>\"+value.location_desc+\"</td>\";\n\t\t\t\t\tResultString\t\t+= \t\t\"<td class=\'\"+class_name+\"\' width=\'8%\'><input type=\'checkbox\' name=\'checkbox\' id=\'checkbox\' id=\'checkbox\' value=\\\"\"+passvalue+\"\\\" \"+pre_dis_checked+\" /></td>\";\n\t\t\t\t\tResultString\t\t+= \"</tr>\";\n\t\t\t\t\tres_header_spec_pract\t= value.res_header_spec_pract;\n\t\t\t\t});\n\t\t\t\tResultString\t+= \"</table>\";\n\t\t\t\tif(existing_pat_id!=\"\"){\n\t\t\t\t\texisting_pat_id\t= existing_pat_id.slice(0,-1);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'existing_pat_id\' id=\'existing_pat_id\' id=\'existing_pat_id\' value=\'\"+existing_pat_id+\"\'/>\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'selectedpat_id\' id=\'selectedpat_id\' id=\'selectedpat_id\'/>\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'selectedenc_id\' id=\'selectedenc_id\' id=\'selectedenc_id\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'mode\' id=\'mode\' id=\'mode\' value=\'update\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'p_called_from_ca\' id=\'p_called_from_ca\' id=\'p_called_from_ca\' value=\'\"+p_called_from_ca+\"\' />\";\n\t\t\t\t// For Update on form submit hidden fields start\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_nursing_unit\' id=\'res_nursing_unit\' id=\'res_nursing_unit\' value=\'\"+nursing_unit+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_dis_date_from\' id=\'res_dis_date_from\' id=\'res_dis_date_from\' value=\'\"+dis_date_from+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_dis_date_to\' id=\'res_dis_date_to\' id=\'res_dis_date_to\' value=\'\"+dis_date_to+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_Splcode\' id=\'res_Splcode\' id=\'res_Splcode\' value=\'\"+Splcode+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_practid\' id=\'res_practid\' id=\'res_practid\' value=\'\"+practid+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_patient_id\' id=\'res_patient_id\' id=\'res_patient_id\' value=\'\"+patient_id+\"\' />\";\n\t\t\t\tResultString\t+= \"<input type=\'hidden\' name=\'res_encounter_id\' id=\'res_encounter_id\' id=\'res_encounter_id\' value=\'\"+encounter_id+\"\' />\";\t\t\t\t\n\t\t\t\t\n\t\t\t\t// For Update on form submit hidden fields end\n\n\t\t\t\tResultString\t+= \"</form>\"; \n\t\t\t\t$(\"#divresultlist\").html(ResultString);\n\n\t\t\t\t\n\t\t\t\tif($(\"#dataTable\").length > 0){\n\t\t\t\t\tvar height=420;\n\t\t\t\t\tif(p_called_from_ca==\'Y\'){\n\t\t\t\t\t\theight=360;\n\t\t\t\t\t}\n\t\t    \t\tfxheaderInit(\'dataTable\',height);\t\n\t\t    \t}\n\t    \t }else{\n\t    \t\t alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t    \t\t $(\"#divresultlist\").html(\"\");\n\t      \t }\n\t\t } ,\n\t     error: function(jqXHR, textStatus, errorThrown) {\n\t         alert(\"incoming Text \" + jqXHR.responseText);\n\t     }\n \t});  \n\t/*Below line added fro this CRF GHL-CRF-0468*/\n\tif(parent.messageFrame){\n      \tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t}\t\t\n\t//End this CRF GHL-CRF-0468\t\n\n}\n\n\t\n\t\n\tfunction FnReset(value){\n\t\tif(value==\'all\'){\n\t\t\tdocument.forms[0].reset();\n\t\t}\n\t\t\n\t\tif(parent.messageFrame)\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t$(\"#divresultlist\").html(\"\");\n\t\tdocument.forms[0].search.disabled=false;\n\t}\n\t\n\tfunction FnGetCheckdValues(){\n\t\tvar VarCheckedValues\t= \"\";\n\t\t$(\"input[name=\'checkbox\']\").filter(\':checked\').each(function() {\n\t\t\tVarCheckedValues+=$(this).val()+\"|\";\n\t\t});\n\t\tif(VarCheckedValues!=\'\'){\n\t\t\tVarCheckedValues\t= VarCheckedValues.slice(0,-1);\n\t\t}\n\t\treturn VarCheckedValues;\n\t}\n\tfunction FnApply(){\n\t\tvar VarCheckedValues=FnGetCheckdValues();\n\t\t\n\t\tvar IsError\t\t\t= 0;\n\t\tvar existing_pat_id = $(\"#existing_pat_id\").val();\t\n\t\tvar encids_patids\t= \"\";\n\t\tvar enc_ids_grp\t\t= \"\";\n\t\tvar pat_ids_grp\t\t= \"\";\n\t\tvar AllIds\t\t\t= \'\';\t\t\n\t\tif(existing_pat_id!=VarCheckedValues){\n\t\t\tif(VarCheckedValues!=\"\"){\n\t\t\t\tAllIds\t\t\t= VarCheckedValues.split(\"|\");\n\t\t\t}\n\t\t\tif(AllIds!=\"\"){\n\t\t\t\t$.each(AllIds,function(index,value){\n\t\t\t\t\tencids_patids\t= value.split(\"~\");\n\t\t\t\t\tenc_ids_grp\t\t+= encids_patids[0]+\"|#|\";\n\t\t\t\t\tpat_ids_grp\t\t+= encids_patids[1]+\"|#|\";\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t});\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\t\t$(\"#selectedpat_id\").val(pat_ids_grp);\n\t\t\t\t$(\"#selectedenc_id\").val(enc_ids_grp);\n\t\t\t\t$(\"#InitiatePreDischargeResult\").submit();\t\t\t\n\t\t\t\n\t\t\n\t\t}else{\n\t\t\tvar error_id=getMessage(\"NO_CHANGE_TO_SAVE\",\"common\");\n\t\t\tparent.frames[1].location.href =\'../../eIP/jsp/InitiatePreDischargeCriteria.jsp\';\n\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+ error_id;\n\t\t}\n\t}\n\t\n\n</script>\n</head>\n\t<body onSelect=\"codeArrestThruSelect();\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\"FocusFirstElement();//checkForMPRequest();\">\n\t\t<form name=\'Inpatientlookup_Form\' id=\'Inpatientlookup_Form\' action=\'../../eIP/jsp/BookingReferenceLookupResult.jsp\' target=\'result\' >\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" size=15 maxlength=\'15\' onblur=\"BeforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'to\');\"><input type=hidden  name=\"nursing_unit\" id=\"nursing_unit\" id=\"nursing_unit\" size=15 ><input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\' value=\'?\' onClick=\"getNursingUnitValue(nursing_unit_desc, \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'to\');\" ></td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' id=\"dis_date_from\" maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  value=\"\" onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");compareDates();\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].dis_date_from.focus();return showCalendar(\'dis_date_from\');\"> - ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;<input type=\'text\' id=\"dis_date_to\" value=\"\" maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");compareDates();\'><img  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].dis_date_to.focus();return showCalendar(\'dis_date_to\',null);\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=text name=specialty_desc size=15 maxlength=\'15\' onblur=\"BeforeGetSpecialtyValue(this, \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'to\');\"><input type=hidden class=label name=Splcode id=\"Splcode\" size=15 readonly><input type=button class=button name=\'specialty_lookup\' id=\'specialty_lookup\' value=\'?\' onClick=\"getSpecialtyValue(specialty_desc, \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'to\');\"></td>\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].practid,practid_desc,\'to\');\" value=\"\"><input type=\'hidden\' name=\'practid\' id=\'practid\' id=\"practid\" value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid, practid_desc,\'to\');\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\'  size=\'12\'  maxlength=\'12\' name=\'encounter_id\' id=\'encounter_id\' id=\"encounter_id\" onKeyPress=\"return allowValidNumber(this,event,12,0)\" onBlur=\"validSplchars1(this);CheckNum(this);\"></td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=6 style=\"margin-left:-5px;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\t\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t<tr>\n\t\t\t<td width = \"75%\" class=\'white\' >&nbsp;</td>\n\t\t\t<td width = \"25%\" class=\'white\' align=\"right\"><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' class=\'button\' onclick=\'FnReset(\"clearresult\")\'>\n\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t<input type=\'hidden\' name=\'wherecondn\' id=\'wherecondn\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t<input type=\'hidden\' name=\'p_called_from_ca1\' id=\'p_called_from_ca1\' id=\'p_called_from_ca1\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\n\t\n</form>\n\t<div id=\"divresultlist\" style=\"margin-left:10px;margin-top:20px;\"></div>\n</body>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con 			= null;
	Statement  stmt			= null;
	ResultSet  rs 			= null;
	ResultSet rset	= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String function_id							= checkForNull(request.getParameter("function_id"));
		String function_name						= checkForNull(request.getParameter("function_name"));
		String wherecondn							= checkForNull(request.getParameter("wherecondn"));
		String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String call_function						= checkForNull(request.getParameter("call_function"));
		String facilityID							= (String)session.getValue("facility_id");
		String loginUser							= (String)session.getValue("login_user");
		String practitioner_id						= checkForNull(request.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice		= checkForNull(request.getParameter("encounter_id"));
		String bl_install_yn						= checkForNull(request.getParameter("bl_install_yn"));
		String p_called_from_ca						= checkForNull(request.getParameter("p_called_from_ca"));
		String systemdate	= "";
		String patient_id_length	= "";
	
		StringBuffer sbSql							= new StringBuffer();
		sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
		sbSql.append(" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   ");
		sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   ");
		sbSql.append( " and trunc(sysdate) between b.eff_date_from and ");
		sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sbSql.toString());
		
		if(rs!=null)
		{
			while(rs.next())
			{
				systemdate		= checkForNull(rs.getString("systemdate"));
				if(!(systemdate==null || systemdate.equals("")))
				operstn			= checkForNull(rs.getString("oper_stn_id"));
				patient_id_length	= checkForNull(rs.getString("patient_id_length"));
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		
	 	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            {java.lang.String __page ="IPPatientLookUpDetailCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id_length"), weblogic.utils.StringUtils.valueOf(patient_id_length
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block35Bytes, _wl_block35);
 
	if(rset != null) rset.close(); 
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
}catch(Exception e)	
{
	

	e.printStackTrace();
}
finally
{
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmDateFrom.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
