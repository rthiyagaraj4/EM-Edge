package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __repoprefstatyearwiseform_srr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repOPRefStatYearwiseform_SRR.jsp", 1720528700624L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HEAD>\n<script>\n\tfunction searchCode(obj,target)\n{\n\tvar sql=\"\";\n\tvar sqlSecond=\"\";\n\tvar facilityid = document.forms[0].p_for_facility_id.value;\n\tvar tit=\"\";\n\t/*var practitionerName=\"\";\n\tvar practitionerValue=\"\";\n\tvar practitionerTypevalue=\"\";*/\n\tvar locale = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\n\ttarget.value=trimString(target.value);\n\n\tif(target.value==\"\" && window.event.target == target)\n\t\treturn;\n\t\n\tvar argumentArray=new Array(8);\n\n\tif(obj.name==\"tolocn\" || obj.name==\"fromlocn\")\n    {\n        tit=getLabel(\"Common.Location.label\",\"Common\");\n\n\t\t//SQL\n\n        //argumentArray[0]=\"select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n\t\targumentArray[0]=\"select clinic_code code, long_desc description from op_clinic_lang_vw where language_id=\'\"+locale+\"\' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2\";\n                \n\t\targumentArray[1]=new Array(\"facility_id\");\n\t\targumentArray[2]=new Array(facilityid);\n\t\targumentArray[3]=new Array(STRING);\n\t\targumentArray[4]=\"2,3\";\n\t\targumentArray[5]=target.value;\n\t\targumentArray[6]=CODE_DESC_LINK;\n\t\targumentArray[7]=CODE_DESC;\n\n                \n    }\t\n\telse if(obj.name==\"tospecialty\" || obj.name==\"fromspecialty\")\n            {\n\t\t\t\t\n                tit=getLabel(\"Common.speciality.label\",\"Common\");\n\n\t\t\t\t//SQL\n\n                //argumentArray[0]=\"select speciality_code code, short_desc description from am_speciality where \'1\' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n\n\t\t\t\targumentArray[0]=\"select speciality_code code, short_desc description from am_speciality_lang_vw where \'1\' like ? and language_id=\'\"+locale+\"\' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n                \n\t\t\t\targumentArray[1]=new Array(\"\'1\'\");\n\t\t\t\targumentArray[2]=new Array(\"1\");\n\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\targumentArray[5]=target.value;\n\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\targumentArray[7]=CODE_DESC;\n\n            }\n\telse\n\t{\n\t\t/*\n\t\t//sql=\"select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, \'CC\', \'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr.Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\', \'Trainee\',NULL,\'\',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\') like nvl(upper(?),decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\')) and upper(nvl(job_title,\'123\')) like upper(nvl(?,nvl(job_title,\'123\'))) order by 2 \";\n\n\t\tsql=\"SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,\'\"+locale+\"\',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,\'\"+locale+\"\',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)))) AND  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\')) AND  UPPER(NVL(position_code,\'123\')) LIKE UPPER(NVL(?,NVL(position_code,\'123\')))AND eff_status=\'E\' ORDER BY 2 \";\n\n\t\t\t\t\n\t\t//sqlSecond=\"select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, \'CC\', \'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr.Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\', \'Trainee\',NULL,\'\',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\') like nvl(upper(?),decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\')) and upper(nvl(job_title,\'123\')) like upper(nvl(?,nvl(job_title,\'123\'))) order by 2 \";\n\n\t\tsqlSecond=\"SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,\'\"+locale+\"\',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,\'\"+locale+\"\',2)  primary_specialty FROM  am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)))) AND  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\')) AND  UPPER(NVL(position_code,\'123\')) LIKE UPPER(NVL(?,NVL(position_code,\'123\')))AND eff_status=\'E\' ORDER BY 2 \";\n\n\t\t\t\t\n\t\tpractitionerName=target.name;\n\t\tpractitionerValue=target.value;\n\t\t\t\t\n\t\t*/\n\t\t\n\t\tif(obj.name==\"pract_id1\" && document.forms[0].fm_pract_type)\n\t\t\tpractitionerTypeValue=document.forms[0].fm_pract_type.value;\n\t\telse if(document.forms[0].to_pract_type)\n\t\t\tpractitionerTypeValue=document.forms[0].to_pract_type.value;\n\n\t\tgetPractitioner(obj,target,\'\',\'\',practitionerTypeValue,\'\',\'\',\'\',\'\',\'\',\"Q2\");\n\t\t\t\t\n\t\t/*\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\txmlStr += \" practName_FName=\\\"\" + practitionerName + \"\\\"\"\t;\n\t\txmlStr += \" practName_FValue=\\\"\" + practitionerValue + \"\\\"\";\n\t\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\t\txmlStr += \" sqlSec=\\\"\" +escape(sqlSecond)+ \"\\\"\";\n\t\txmlStr += \" practitioner_type=\\\"\" + practitionerTypeValue + \"\\\"\";\n\t\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\n\t\txmlStr +=\" /></root>\" ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\teval(responseText);\n\t\t*/\t\t\n\t\treturn;            \n\n\t}\n\t\n\tvar retVal=CommonLookup(tit,argumentArray);\n\n\tif(retVal==null || retVal==\"\")\n\t\ttarget.value=\"\";\n\telse\n\t\ttarget.value=retVal[0];\n\t\t            \n}\n\n\nfunction PractLookupRetVal(retVal,objName)\n{\n\n\tvar arr;\n\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\n\t\tif(objName==\"p_fm_pract_id\")\n\t\t\tdocument.forms[0].p_fm_pract_id.value=arr[0];\n\t\telse\n\t\t\tdocument.forms[0].p_to_pract_id.value=arr[0];\n\t\t\t\t\t\t\n\t}\n\telse\n\t{\n\t\t\n\t\tif(objName==\"p_fm_pract_id\")\n\t\t\tdocument.forms[0].p_fm_pract_id.value=\"\";\n\t\telse\n\t\t\tdocument.forms[0].p_to_pract_id.value=\"\";\n\t\t\t\t\t\t\n\t}\n\t\n}\n\nfunction setDate(Object)    { \n\nvar currentDate = new Date();\n     if(Object.value!=\"\")\n\t{\n\t   if (isBeforeNow(Object.value,\"YY\",localeName))\n        {\n          return true;\n        }\n        else\n        {\n               alert(getMessage(\"DATE_LESS_EQL_SYS_DATE\",\'FM\'));\n\t\t\t\tObject.value=\"\";\n                Object.focus();\n            \n        }\n    }\n}\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n\n</script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\"../../eOP/js/repResetRunlist_SRR.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> </script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<br>\n<br>\n<form name=\"repOPRefStatYearwiseform\" id=\"repOPRefStatYearwiseform\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\t<tr>\n    <td class=\'columnheader\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n    </tr>\n</table>\n      \n\t\t\t\t<table width=\'80%\' cellPadding=\"2\" cellSpacing=\"0\"  align=\'center\' border=\'0\'>\n\t\t\t\t\t<tr>\n               \t\t<td class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n                    <td class=\'fields\' colspan=\'2\'><select name=\'p_for_facility_id\' id=\'p_for_facility_id\' >\n                    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n                    </select>\n                    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n                    </td>\n                </tr> \n\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'33%\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\"querydata\" width=\'33%\' style=\"font-weight: bold;\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class=\"querydata\" width=\'33%\' style=\"font-weight: bold;\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t <tr>\n                    <td class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n                    <td class=\'fields\'><input type=text  id=\'mdsfrom\' name=\'p_fr_year\' id=\'p_fr_year\' size=\"4\" maxlength=\"4\" onBlur=\"if(validateYear(this)){setDate(this)};\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'mdsfrom\',\'y\', null);\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>\t\t\t\t\n                    <td class=\'fields\'><input type=text  id=\'mdsto\' name=\'p_to_year\' id=\'p_to_year\' size=\"4\" maxlength=\"4\" onBlur=\"if(validateYear(this)){setDate(this)};\"><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'mdsto\',\'y\', null);\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img>\n                    </td>              \n                </tr>                \n          <!--   <tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_locn_code\" id=\"p_fm_locn_code\" size=\"4\" maxlength=\"4\"  onBlur=\'if(this.value !=\"\") searchCode1(this,p_fm_locn_code,p_fm_locn_code1)\'><input type=\"hidden\" name=\"p_fm_locn_code1\" id=\"p_fm_locn_code1\"><input type=\'button\' name=\'location\' id=\'location\' value=\'?\' class=\'button\' onclick=\'searchCode1(this,p_fm_locn_code,p_fm_locn_code1)\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"p_to_locn_code\" id=\"p_to_locn_code\" size=\"4\" maxlength=\"4\" onBlur=\'if(this.value !=\"\") searchCode1(this,p_to_locn_code,p_to_locn_code1)\'><input type=\"hidden\" name=\"p_to_locn_code1\" id=\"p_to_locn_code1\"><input type=\'button\' name=\'location1\' id=\'location1\' value=\'?\' class=\'button\' onclick=\'searchCode1(this,p_to_locn_code,p_to_locn_code1)\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t<td  class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t</td>\n\n\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t<input type=\"text\" name=\"P_FM_SPECIAL\" id=\"P_FM_SPECIAL\" size=\"4\" maxlength=\"4\" onblur=\'if(this.value !=\"\") searchCode1(this, P_FM_SPECIAL,p_fm_speciality)\' ><input type=\"hidden\" name=\"p_fm_speciality\" id=\"p_fm_speciality\"><input type=\'button\' name=\'speciality\' id=\'speciality\' value=\'?\' class=\'button\'  onclick=\'searchCode1(this, P_FM_SPECIAL,p_fm_speciality)\'>\n\t\t\t</td>\n\t\t\t\n\n\t\t\t<td class=\'fields\' nowrap>\n\t\t\t\t<input type=\"text\" name=\"P_TO_SPECIAL\" id=\"P_TO_SPECIAL\" size=\"4\" maxlength=\"4\" onblur=\'if(this.value !=\"\") searchCode1(this, P_TO_SPECIAL,p_to_speciality)\'><input type=\"hidden\" name=\"p_to_speciality\" id=\"p_to_speciality\"><input type=\'button\' name=\'speciality1\' id=\'speciality1\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, P_TO_SPECIAL,p_to_speciality)\'>\n\t\t\t</td>\n\t  </tr>-->\n\t <tr class=\'fields\'>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_specialty_code\" id=\"p_fm_specialty_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(fromspecialty,this)\'><input type=\'button\' name=\'fromspecialty\' id=\'fromspecialty\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_specialty_code)\'>\n\t</td>\n\t<td class=\'fields\'><input type=\"text\" name=\"p_to_specialty_code\" id=\"p_to_specialty_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(tospecialty,this)\'><input type=\'button\' name=\'tospecialty\' id=\'tospecialty\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_specialty_code)\'>\n\t</td>\n</tr>\n\n\t <tr>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_locn_code\" id=\"p_fm_locn_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(fromlocn,this)\'><input type=\'button\' name=\'fromlocn\' id=\'fromlocn\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_locn_code)\'>\n\t</td>\n\t<td class=\'fields\'><input type=\"text\" name=\"p_to_locn_code\" id=\"p_to_locn_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(tolocn,this)\'><input type=\'button\' name=\'tolocn\' id=\'tolocn\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_locn_code)\'>\n\t</td>\n</tr>\n\n               \n            </table>       \n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"       value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"         value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"         value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"         value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'></input>\n\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</form>\n</BODY>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n</HTML>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

    request.setCharacterEncoding("UTF-8"); 
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con=null; 

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBYRRFC" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
    String ID="";
    String dat="";
    String en="";
    try{
	con=ConnectionManager.getConnection(request); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( localeName ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

                    stmt=con.createStatement();
                    //rset=stmt.executeQuery("SELECT FACILITY_NAME,FACILITY_ID from sm_facility_for_user_vw WHERE APPL_USER_ID='"+p_user_name+"'  order by FACILITY_NAME ");
					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");
                    if(rset!=null)
                    {
                    while(rset.next())
                    {
                    dat=rset.getString("FACILITY_NAME");
                    ID=rset.getString("FACILITY_ID");

                    out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
                    }
            _bw.write(_wl_block12Bytes, _wl_block12);
  }

                    
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);
 }
catch(Exception e) {out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
if(con!=null)
    ConnectionManager.returnConnection(con,request);

}
                    
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialtyCode.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialtyCode.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
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
}
