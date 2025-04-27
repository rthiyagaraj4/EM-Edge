package jsp_servlet._emr._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mrlookupcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRLookupCriteria.jsp", 1743143723168L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eIP/js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\n\t\n\t<script src=\"../../eMR/js/MRPatientMovementHistory.js\" language=\"JavaScript\" ></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n \n<script>\n\nfunction compareDates1()\n{ \n\tvar from = document.forms[0].from_date1;\n\tvar to = document.forms[0].to_date1;\n\t\n\tif(from.value !=\'\' && to.value !=\'\')// DateUtils.js\n\t{\n\t\tif(validDate(from.value,\"DMY\",localeName) && validDate(to.value,\"DMY\",localeName))\n\t\t{  \n\t\t\tvar fromDt\t= convertDate(document.forms[0].from_date1.value,\"DMY\",localeName,\"en\");\n\t\t\tvar toDt\t= convertDate(document.forms[0].to_date1.value,\"DMY\",localeName,\"en\");\n\t\t\t\n\t\t\tif(!isBefore(fromDt,toDt,\'DMY\',\"en\"))// DateUtils.js // modified by mujafar for SRR20056-SCF-16103\n\t\t\t{\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\t\tdocument.forms[0].to_date1.select();\n\t\t\t}\n\t\t}\n\t}\n\n}\nfunction callGetPractitioner(obj,target)\n\t\t{ //alert(\'iiii\');\n\t\t\t\n\t\t\tvar facility_id = document.forms[0].facilityID.value;\n\t\t\tvar loginuser   = document.forms[0].loginUser.value;\n            var locale=document.forms[0].locale.value; \n\n\t\t\ttarget.value=trimString(target.value);\n\t\t\tif(target.value==\"\" && window.event.target == target)\n\t\t\t{\n\t\t\t\tdocument.forms[0].practid1.value=\"\";\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t\n\t\t\tif(document.forms[0].speciality_desc && document.forms[0].speciality_desc.value!=null)\n\t\t\t\tspeciality=document.forms[0].speciality_desc.value;     \n\t\t\t\n\t\t\tgetPractitioner1(obj,target,facility_id,speciality,\'\',\'\',\'\',\'\',\'\',\'\',\"Q2\");\n\t\t\t\n\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\n\t\t}\n\t\t\n\t\t\n\t\t\n\t\t\n\t\tfunction chkEncounter()\n\t\t{\n\t\t\t\n\t\t\tclearList();\n\t\t\tdocument.forms[0].Qloctype.value=\"\";\n\t\t\tdocument.forms[0].nursing_unit_desc.value=\"\";\n\t\t\tdocument.forms[0].nursing_unit.value=\"\"; \n\t\t\tdocument.forms[0].admn_date_from.value=\"\";\n\t\t\tdocument.forms[0].admn_date_from1.value=\"\";\n\t\t\tdocument.forms[0].admn_date_to.value=\"\";\n\t\t\tdocument.forms[0].admn_date_to1.value=\"\"; \n\t\t\tdocument.forms[0].specialty_desc.value=\"\";\n\t\t\tdocument.forms[0].speciality_desc.value=\"\";\n\t\t\tdocument.forms[0].Splcode.value=\"\";\n\t\t\tdocument.forms[0].speciality_code.value=\"\"; \n\t\t\tdocument.forms[0].practid_desc.value=\"\";\n\t\t\tdocument.forms[0].practid_desc1.value=\"\";\n\t\t\tdocument.forms[0].practid.value=\"\";\n\t\t\tdocument.forms[0].practid1.value=\"\";\n\t\t\tdocument.forms[0].encounter_id.value=\"\";\n\t\t\tdocument.forms[0].encounter_id1.value=\"\";\n\t\t\tparent.frames[1].document.forms[0].patient_id.value=\"\";\n\t\t\t\n\t\t\tif(document.forms[0].encounter_type_sel.value == \"IP\" || document.forms[0].encounter_type_sel.value == \"DC\" )\n\t\t\t{\t\n\t\t\t\tdocument.getElementById(\"check1\").style.display=\"none\";\n\t\t\t\tdocument.getElementById(\"check\").style.display=\"inline\";\n\t\t\t\t\n\t\t\t}\n\t\t\tif(document.forms[0].encounter_type_sel.value == \"OP\" || document.forms[0].encounter_type_sel.value == \"EM\" )\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"check\").style.display=\"none\";\n\t\t\t\tdocument.getElementById(\"check1\").style.display=\"inline\";\n\t\t\t}\n\t\t} \n\t\t\n\t function clearList()\n{\n\ndocument.forms[0].Qloc.value=\"\";    \ndocument.forms[0].Qloc1.value=\"\";     \nclearAll();   \n\n \n\n}\t\n\t\t\n\nasync function getValues(obj,target,targetId)\n\t\t{\n\t\t\tvar locale=document.forms[0].locale.value\n\t\t\tvar tit=\"\";\n\t\t\tvar facilityid =document.forms[0].facilityID.value;\n\t\t\tvar dataNameArray  = new Array() ;\n\t\t     var dataValueArray = new Array() ;\n\t\t     var dataTypeArray  = new Array() ;\n\t\t\tvar argumentArray=new Array(8);\n\t\t\tvar sql=\"\";\n\t\t\tvar sqlSecond=\"\";\n\t\t\ttarget.value=trimString(target.value);\n\t\t\tif(target.value==\"\" && window.event.target == target)\n\t\t\t{\n\t\t\t\ttargetId.value=\"\";\n\t\t\t\treturn;\n\t\t\t}\n\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tif(obj.name==\"speciality_button\")\n\t\t\t{\n\t\t\t\ttit=getLabel(\"Common.speciality.label\",\"Common\");\t\t\t\t\t\t\t\n\n\t\t\t\targumentArray[0]=\"select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,\'\"+locale+\"\',2) description from AM_SPECIALITY where EFF_STATUS = \'E\' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,\'\"+locale+\"\',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,\'\"+locale+\"\',2)))\"; \n\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4]=\"1,2\";\n\t\t\t\targumentArray[5]=target.value;\n\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\targumentArray[7]=CODE_DESC;\n\n\t\t\t}\n\t\t\t\n\t\t\tvar retVal=await CommonLookup(tit,argumentArray);\n\t\t\t\n\t\t\tif(retVal ==null || retVal==\"\" || !retVal)\n\t\t\t{\n\t\t\t\ttarget.value=\"\";\n\t\t\t\ttargetId.value=\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\ttargetId.value=retVal[0];\n\t\t\t\ttarget.value=retVal[1];\n\t\t\t}\n\t\t}\nfunction onBlurgetLoc(loginuser,oper_id,fac_id,objval,target)\n{ \n\n\t\t \n\t\tif(target.value == \"\")\n\t\t{\n\t\t\ttarget.value=\"\";\n\t\t\tdocument.forms[0].Qloc.value=\"\";\n\t\t\treturn;\n\t\t}\n getLocn(loginuser,oper_id,fac_id,objval,target);\n\n}\nasync function getLocn(loginuser,oper_id,fac_id,objval,target)\n{  \n//alert(objval);\n   var retVal =    new String();\n   var argumentArray  = new Array() ;\n   var dataNameArray  = new Array() ;\n   var dataValueArray = new Array() ;\n   var dataTypeArray  = new Array() ;\n   var tit=\"\";\t\t\t\t\n   locale=document.forms[0].locale.value; \n   \n   tit=getLabel(\"Common.Location.label\",\'Common\')\n   \n   if(document.forms[0].encounter_type_sel.value == \"OP\" )\n   {\n\t\tsql =\"SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = \'\"+fac_id+\"\' AND a.language_id=\'\"+locale+\"\' AND a.level_of_care_ind = \'A\' AND a.eff_status=\'E\' AND a.clinic_type = \'\"+objval+\"\' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = \'\"+loginuser+\"\' and b.oper_stn_id = \'\"+oper_id+\"\' and b.manage_queue_yn = \'Y\' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = \'N\' \";\n   }\n   else\n\t  {\n\t\tsql =\"SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = \'\"+fac_id+\"\' AND a.language_id=\'\"+locale+\"\' AND a.level_of_care_ind = \'E\' AND a.eff_status=\'E\' AND a.clinic_type = \'\"+objval+\"\' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = \'\"+loginuser+\"\' and b.oper_stn_id = \'\"+oper_id+\"\' and b.manage_queue_yn = \'Y\' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = \'N\' \";\n\t\t   \n\t   }\n\n\t\t\n\t\tsql=sql+\"  ORDER BY  2\";\n\t\t\n  //alert(sql);\n   \n  \t\t\t\t\n\t\t\t\targumentArray[0] =sql;\n\t\t\t\targumentArray[1] = dataNameArray ;\n\t\t\t\targumentArray[2] = dataValueArray ;\n\t\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\t\targumentArray[4] = \"1,2\";\n\t\t\t\targumentArray[5] = target.value;\n\t\t\t\targumentArray[6] = DESC_LINK  ;\n\t\t\t\targumentArray[7] = DESC_CODE ;\n\n\t\t\t\tretVal = await CommonLookup( tit, argumentArray );\n\t\t\t\t\n\t\t\t\tif(retVal != null && retVal != \"\" )\n                {\n\n\t             var ret1=unescape(retVal);\n\t\t\t\t\tarr=ret1.split(\",\");\n\t\t\t\t\ttarget.value=arr[1];\n\t\t\t\tdocument.forms[0].Qloc.value=arr[0];\n\n\n          }\n}\nfunction clearAll()\n{\n\t\t//document.forms[0].reset(); \n\t\tparent.frames[2].document.location.href =\'../../eCommon/html/blank.html\';\nif(parent.messageFrame)\n\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\n\tdocument.forms[0].search.disabled=false;\n}\nfunction BeforeGetPractitioner(obj, target, details)\n{ \n\t\tif(document.forms[0].practid_desc1.value !=\"\")\n\t\t\tgetPractitionerLocal(obj, target, details);\n\t\telse\n\t\t\tdocument.forms[0].practid1.value =\"\"\n\t\n\n}\nfunction PractLookupRetVal(retVal,objName)\n{ \n\tvar arr;\n\tif (retVal != null)\n\t{ \n\t\t\n\t\tarr=retVal.split(\"~\");\n\t\t\n\t\t\tif(objName == \"practid_desc\"){ \n\t\t\tdocument.forms[0].practid.value=arr[0];\n\t\t\tdocument.forms[0].practid_desc.value=arr[1];\n\t\t\t}\n\t\t\t\tif(objName == \"practid_desc1\")\n\t\t\t\t{ \n\t\t\t\t\tdocument.forms[0].practid1.value=arr[0];\n\t\t\t\t\tdocument.forms[0].practid_desc1.value=arr[1];\n\t\t\t\t}\n\t\t\n\t}\n\telse\n\t{ \n\t\tif(objName == \"practid_desc\")\n\t\t{\n\t\t\tdocument.forms[0].practid.value=\"\";\n\t\t\tdocument.forms[0].practid_desc.value=\"\";\t\n\t\t}\n\t\tif(objName == \"practid_desc1\")\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].practid1.value=\"\";\n\t\t\t\t\tdocument.forms[0].practid_desc1.value=\"\";\n\t\t\t\t}\n\t\t\n\t\t\n\t}\n}\nfunction getPractitionerLocal(obj, target, details)\n{ \n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\n\tpractName_FName=target.name;\n\tpractName_FValue=target.value;\n\t\n\t\tpractId_FName=document.forms[0].practid.name;\n\n\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tvar locale\t\t\t= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q3\");\n\n}\nfunction submitPage()\n{\n\t\n\tvar condition=\"\"\n\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t{\n\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ escape(document.forms[0].elements[i].value)+\"&\"\n\t}\n\t\n\t//alert(\"condition==>\"+condition);\n\t\n\tdocument.forms[0].search.disabled=true;\n\toper_stn = document.forms[0].operstn.value;\n\troutine_tfr_yn = document.forms[0].routine_tfr_yn.value;\n\tcall_function =document.forms[0].call_function.value;\n\t//alert(\'document.forms[0].modal.value::\'+document.forms[0].modal.value);\n\t\n\t\n\t\tvar patient_class_val = document.forms[0].encounter_type_sel.value ;\n\tif(document.forms[0].modal.value == \'yes\')\n\t{\n\t\t\n\t\t\n\t\t\t\n\t\t\tparent.frames[1].location.href= \'../jsp/MRLookupQueryResult.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&routine_tfr_yn =\'+routine_tfr_yn+\'&pat_class=\'+patient_class_val+\'&call_function=\'+call_function+\'&show_bed_yn=Y&opst=\'+oper_stn+\'\';\n\t\t\n\t}\n\telse\n\t{  \n\t\t\n\t\t\t\tvar exclude_nda_pats=\"N\";\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tparent.frames[2].location.href= \'../jsp/MRLookupQueryResult.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&\'+condition+\'&oper_stn_id=\'+oper_stn+\'&routine_tfr_yn =\'+routine_tfr_yn+\'&pat_class=\'+patient_class_val+\'&show_bed_yn=Y&opst=\'+oper_stn+\'&exclude_nda_pats=\'+exclude_nda_pats+\'\';\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\n\t\t\n\t}\n\t\n\t\n}\n</script>\n</head>\n\t<body onSelect=\"codeArrestThruSelect();\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\"FocusFirstElement();//checkForMPRequest();\">\n\t\t<form name=\'Inpatientlookup_Form\' id=\'Inpatientlookup_Form\' action=\'../../eIP/jsp/BookingReferenceLookupResult.jsp\' target=\'result\' >\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\n\t\t\t<tr>\n\t\t\t<td class=label width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=fields width=\'25%\' ><select name=\"encounter_type_sel\" id=\"encounter_type_sel\" onchange=\"chkEncounter();\" >\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</select></td>\n\t\t<td width=\'25%\' ></td><td width=\'25%\' ></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<div id=\"check\" style=\"display:inline\"> \n\t\t\t\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<!-- <td class=\'label\' width=\'25%\'><script>getLabel(\"Common.nursingUnit.label\",\"common\")</script>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td CLASS=\'fields\' width=\'25%\'><input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\" size=15 maxlength=\'15\' onblur=\"BeforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'to\');\"><input type=hidden  name=\"nursing_unit\" id=\"nursing_unit\" size=15 ><input type=button class=button name=\'nursing_unit_lookup\' id=\'nursing_unit_lookup\' value=\'?\' onClick=\"getNursingUnitValue(nursing_unit_desc, \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'to\');\" ></td>-->\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\' width=\'25%\'><script>getLabel(\"Common.nursingUnit.label\",\"common\")</script>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'to\');\" ></td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'  nowrap width=\"25%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\n\t\t\t\t\t<td   class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' id=\"admn_date_from\" maxlength=\'10\' size=\'10\' name=\'from_date\' id=\'from_date\'  onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");compareDates();\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].admn_date_from.focus();return showCalendar(\'admn_date_from\');\"> - ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;<input type=\'text\' id=\"admn_date_to\"   maxlength=\'10\' size=\'10\' name=\'to_date\' id=\'to_date\' onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");compareDates();\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].admn_date_to.focus();return showCalendar(\'admn_date_to\');\" ></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=text name=\'specialty_desc\' id=\'specialty_desc\' size=\'15\' maxlength=\'15\' onblur=\"BeforeGetSpecialtyValue(this, \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'to\');\"><input type=\'hidden\' class=\'label\' name=\'Splcode\' id=\'Splcode\' size=15 readonly><input type=\'button\' class=\'button\' name=\'specialty_lookup\' id=\'specialty_lookup\' value=\'?\' onClick=\"getSpecialtyValue(specialty_desc, \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'to\');\"></td>\n\t\t\t\t\t\n\t\t\t\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].practid,practid_desc,\'to\');\" value=\"\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid, practid_desc,\'to\');\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\'  size=\'12\'  maxlength=\'12\' name=\'encounter_id\' id=\'encounter_id\' onKeyPress=\"return allowValidNumber(this,event,12,0)\" onBlur=\"validSplchars1(this);CheckNum(this)\"></td>\n\t\t\t<td width=\'25%\' ></td><td width=\'25%\' ></td>\n\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n</table>\n\n</div>\n<div id=\"check1\" style=\"display:none\"> \n<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\' >\n<tr>\n<td   class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td  class=\'Fields\' width=\'25%\' nowrap>\n\t\t\t\t\t<select name=\"Qloctype\" id=\"Qloctype\" onChange=\"clearList()\">\n\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="-------\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\'25%\'  >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td class=\'Fields\' width=\'25%\' >\n\t\t\t<INPUT TYPE=\"text\" name=\"Qloc1\" id=\"Qloc1\"  onBlur=\"onBlurgetLoc(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',document.forms[0].Qloctype.value,document.forms[0].Qloc1)\"><input type=\"button\" name=\"qloc_butt\" id=\"qloc_butt\" value=\"?\" class=\"button\" onClick=\"getLocn(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',document.forms[0].Qloctype.value,document.forms[0].Qloc1)\" >\n\t\t\t<input type=\"hidden\" name=\"Qloc\" id=\"Qloc\">\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\n\t\t\t<td class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t<td class=\'fields\' width=\'25%\' ><input type=\"text\" name =\"speciality_desc\" maxlength=\"15\" size=\"15\" onBlur=\"getValues(speciality_button,this,speciality_code)\"><input type=\'button\' class=\'button\'  name=\'speciality_button\' id=\'speciality_button\' value=\'?\' onclick=\"getValues(this,speciality_desc,speciality_code)\"><input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'\'></td>\n\t\t\n\t\t<td class=\'label\'  nowrap width=\"25%\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\n\t\t\t\t\t<td   class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' id=\"admn_date_from1\" maxlength=\'10\' size=\'10\' name=\'from_date1\' id=\'from_date1\'  onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\");compareDates1();\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].admn_date_from1.focus();return showCalendar(\'admn_date_from1\');\"> - ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;<input type=\'text\' id=\"admn_date_to1\"   maxlength=\'10\' size=\'10\' name=\'to_date1\' id=\'to_date1\' onBlur=\'validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\");compareDates1();\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].admn_date_to1.focus();return showCalendar(\'admn_date_to1\');\" ></td>\n\t\t\t\n\t\t\t</tr>\n\t\t<tr>\n\t\t<td class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\'  size=\'12\'  maxlength=\'12\' name=\'encounter_id1\' id=\'encounter_id1\' onKeyPress=\"return allowValidNumber(this,event,12,0)\" onBlur=\"validSplchars1(this);CheckNum(this)\"></td>\t\t\n\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'  nowrap><input type=\'text\' name=\'practid_desc1\' id=\'practid_desc1\' size=\"25\" maxlength=\"30\" onblur=\"callGetPractitioner(document.forms[0].pract_id_search1,practid_desc1);\" value=\"\"><input type=\'hidden\' name=\'practid1\' id=\'practid1\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search1\' id=\'pract_id_search1\' value=\'?\' class=\'button\' onClick=\"callGetPractitioner(this,practid_desc1);\"></td>\n\t\t\n\t\t\n\t\t</tr>\n\t\t\n\t\t\t\n\n\n\n</tr>\n</table>\n\n</div>\n\n<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n<tr>\n\t\t\t\n\t\t\t<td colspan=6>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width = \"75%\" class=\'white\' >&nbsp;</td>\n\t\t\t<td width = \"25%\" class=\'white\' align=\"right\"><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' class=\'button\' onclick=\'clearAll()\'>\n\n\t\t\t</td>\n\t\t</tr>\n\t\n\n\t\t\n\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\'hidden\' name=\'targetURL\' id=\'targetURL\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\'hidden\' name=\'wherecondn\' id=\'wherecondn\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\'hidden\' name=\'bed_block_period_max\' id=\'bed_block_period_max\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t<input type=\'hidden\' name=\'bedBlock_normal\' id=\'bedBlock_normal\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\'hidden\' name=\'max_blk_type\' id=\'max_blk_type\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t<input type=\'hidden\' name=\'systemdate\' id=\'systemdate\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t<input type=\'hidden\' name=\'chk_in_lodger_min_date\' id=\'chk_in_lodger_min_date\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\'hidden\' name=\'chg_nurs_unit_in_assign_bed_yn\' id=\'chg_nurs_unit_in_assign_bed_yn\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" >\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t<input type=\'hidden\' name=\'patient_id_length\' id=\'patient_id_length\' value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t<input type=\'hidden\' name=\'facilityID\' id=\'facilityID\' value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n</form>\n</body>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</html>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con 			= null;
	Statement  stmt			= null;
	PreparedStatement pstmt = null;
	ResultSet  rs 			= null;
	ResultSet rset	= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		// added for assign bed on 3/8/2005 by Sridhar R 
		String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");

		String chk_in_lodger_max_period		= checkForNull(request.getParameter("chk_in_lodger_max_period"),"0");
		String bed_block_period_max			= checkForNull(request.getParameter("bed_block_period_max"));
		String bl_install_yn						= checkForNull(request.getParameter("bl_install_yn"));
		String bedBlock_normal					= checkForNull(request.getParameter("bedBlock_normal"));
		String max_blk_type						= checkForNull(request.getParameter("max_blk_type"));
		String oper_stn_id						= checkForNull(request.getParameter("oper_stn_id"));
		String routine_tfr_yn						= "";
		String jsp_name							= checkForNull(request.getParameter("jsp_name"));
		String win_height							= checkForNull(request.getParameter("win_height"));
		String win_width							= checkForNull(request.getParameter("win_width"));
		String call_function						= checkForNull(request.getParameter("call_function"));
		String modal								= checkForNull(request.getParameter("modal"));
		String dialogTop							= checkForNull(request.getParameter("dialogTop"));
		String module								= checkForNull(request.getParameter("module"));
		String model_window						= checkForNull(request.getParameter("model_window"));
		String function_id							= checkForNull(request.getParameter("function_id"));
		String function_name					= checkForNull(request.getParameter("function_name"));
		String prog_id								= checkForNull(request.getParameter("prog_id"));
		String wherecondn						= checkForNull(request.getParameter("wherecondn"));
		String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String targetURL							= checkForNull(request.getParameter("targetURL"));
		String facilityID							= (String)session.getValue("facility_id");
		String loginUser							= (String)session.getValue("login_user");
		String practitioner_id						= checkForNull(request.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice		= checkForNull(request.getParameter("encounter_id"));
		StringBuffer sbSql							= new StringBuffer();
		String systemdate							= "";
		String chk_in_lodger_min_date				= "";
		String systemdate_converted					= "";
		String patient_id_length					= "";
		String dis_adv_chk							= "";
		String dis_adv_val							= "N";
		String display_discharge_pat_list			= "";
		//out.println("oper_stn_id::"+oper_stn_id);
		//out.println("call_function::"+call_function);
		String loctype ="";
		String loctypedesc="";
		
		try
		{
			if(oper_stn_id.equals("") || call_function.equals("TransferPatientOut"))
			{
				sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
				sbSql.append(" where a.facility_id=? and a.facility_id=b.facility_id	   ");
				sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =?   ");
				sbSql.append( " and trunc(sysdate) between b.eff_date_from and ");
				sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				//stmt = con.createStatement();
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString(1,facilityID);
			    pstmt.setString(2,loginUser);
				rs = pstmt.executeQuery();

				if(rs!=null)
				{
					while(rs.next())
					{
						systemdate		= checkForNull(rs.getString("systemdate"));
						if(!(systemdate==null || systemdate.equals("")))
						systemdate_converted = DateUtils.convertDate(systemdate,"DMY","en",locale); 			
						operstn			= checkForNull(rs.getString("oper_stn_id"));
						routine_tfr_yn	= checkForNull(rs.getString("routine_tfr_yn"));
						patient_id_length	= checkForNull(rs.getString("patient_id_length"));
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			else
			{
					sbSql.append(" select patient_id_length,to_char(sysdate,'dd/mm/rrrr'), to_char(trunc(sysdate)-round(");
					sbSql.append("?");
					sbSql.append("/24),'dd/mm/yyyy') from mp_param where  module_id = 'MP' ");
					//stmt = con.createStatement();
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString(1,chk_in_lodger_max_period);
					rs = pstmt.executeQuery();

					if(rs!=null && rs.next())
					{
						patient_id_length	= checkForNull(rs.getString(1));
						systemdate	= checkForNull(rs.getString(2));
						if(!(systemdate==null || systemdate.equals("")))
							systemdate_converted = DateUtils.convertDate(systemdate,"DMY","en",locale); 
						chk_in_lodger_min_date	= checkForNull(rs.getString(3));
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}
				
				
				operstn = oper_stn_id;
			}

		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if (sbSql.length() > 0)
          	sbSql.delete(0, sbSql.length());
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
	
		try{	
		stmt = con.createStatement();
			rset = null;
			rset = stmt.executeQuery("select PATIENT_CLASS, short_desc from  Am_PATIENT_CLASS where patient_class not in ('XT') ")  ;
			if(rset != null)
			{									
				while (rset.next())
				{	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("PATIENT_CLASS")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset.getString("short_desc")));
            _bw.write(_wl_block16Bytes, _wl_block16);
     }
			}
		}
		catch(Exception e)
		{
			if(rset != null) rset.close();
			if(stmt!=null) stmt.close();
		}
		
			
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
	StringBuffer sql = new StringBuffer();
							     rset = null;
								sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");

								rset=stmt.executeQuery(sql.toString());
								if(rset != null)
								{
									while(rset.next())
									{
										loctype=rset.getString("locn_type");
										loctypedesc=rset.getString("short_desc");
										
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(loctypedesc));
            _bw.write(_wl_block35Bytes, _wl_block35);

									}
								}						  
							  if (rset != null)       rset.close();
							 // sql.setLength(0);						

				
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            {java.lang.String __page ="../../eIP/jsp/IPPatientLookUpDetailCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id_length"), weblogic.utils.StringUtils.valueOf(patient_id_length
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(module));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(systemdate));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(chk_in_lodger_min_date));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block80Bytes, _wl_block80);
 
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

            _bw.write(_wl_block81Bytes, _wl_block81);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmDateFrom.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateFrom.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
}
