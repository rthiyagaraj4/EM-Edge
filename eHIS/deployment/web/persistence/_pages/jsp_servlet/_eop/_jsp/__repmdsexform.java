package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __repmdsexform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repMDSExForm.jsp", 1720529970773L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<HEAD>\n<TITLE></TITLE>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eOP/js/repMDSEx.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\"../../eOP/js/OPPractitionerComponent.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\n/**\n    added by parimala\n**/\n    \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n    \n    async function searchCode(obj,target)\n    {\n            var sql=\"\";\n            var sqlSecond=\"\";\n\t\t\tvar facilityid = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n            var tit=\"\";\n\t\t\t/*var practitionerName=\"\";\n\t\t\tvar practitionerValue=\"\";\n\t\t\tvar practitionerTypeValue=\"\";*/\n\t\t\tvar locale = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\t\ttarget.value=trimString(target.value);\n\n\t\t\tif(target.value==\"\" && window.event.target == target)\n\t\t\t\treturn;\n\t\t\t\n\t\t\tvar argumentArray=new Array(8);\n\n            if(obj.name==\"toservice\" || obj.name==\"fromservice\")\n            {\n                tit=getLabel(\"Common.service.label\",\"Common\");\n\n\t\t\t\t//SQL\n\n                //argumentArray[0]=\"select SERVICE_CODE code, short_desc description from am_service where \'1\' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n                \n\t\t\t\targumentArray[0]=\"select SERVICE_CODE code, short_desc description from am_service_lang_vw where language_id=\'\"+locale+\"\' and \'1\' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n\n\t\t\t\targumentArray[1]=new Array(\"\'1\'\");\n\t\t\t\targumentArray[2]=new Array(\"1\");\n\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\targumentArray[5]=target.value;\n\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\targumentArray[7]=CODE_DESC;\n\n\t\t\t}\n\t\t\telse if(obj.name==\"tosubservice\" || obj.name==\"fromsubservice\")\n            {\n                tit=getLabel(\"Common.subservice.label\",\"Common\");\n\n\t\t\t\t//SQL\n\n                argumentArray[0]=\"select SUBSERVICE_CODE code, short_desc description from am_subservice_lang_vw where language_id=\'\"+locale+\"\' and \'1\' like ? and upper(subservice_code) like upper(nvl(?,subservice_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2\";\n                \n\t\t\t\targumentArray[1]=new Array(\"\'1\'\");\n\t\t\t\targumentArray[2]=new Array(\"1\");\n\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\targumentArray[5]=target.value;\n\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\targumentArray[7]=CODE_DESC;\n\n            }\n\t\t\telse if(obj.name==\"tolocn\" || obj.name==\"fromlocn\")\n            {\n                tit=getLabel(\"Common.Location.label\",\"Common\");\n\n\t\t\t\t//SQL\n\n                argumentArray[0]=\"select clinic_code code, long_desc description from op_clinic_lang_vw where language_id=\'\"+locale+\"\' and  facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2\";\n                \n\t\t\t\targumentArray[1]=new Array(\"facility_id\");\n\t\t\t\targumentArray[2]=new Array(facilityid);\n\t\t\t\targumentArray[3]=new Array(STRING);\n\t\t\t\targumentArray[4]=\"2,3\";\n\t\t\t\targumentArray[5]=target.value;\n\t\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\t\targumentArray[7]=CODE_DESC;\n\n                \n            }\n\t\t\telse\n\t\t\t{\n\t\t\t\t/*\n\n\t\t\t\t//sql=\"select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, \'CC\', \'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr.Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\', \'Trainee\',NULL,\'\',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\') like nvl(upper(?),decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\')) and upper(nvl(job_title,\'123\')) like upper(nvl(?,nvl(job_title,\'123\'))) order by 2 \";\n\n\t\t\t\tsql=\"SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,\'\"+locale+\"\',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,\'\"+locale+\"\',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)))) AND  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\')) AND  UPPER(NVL(position_code,\'123\')) LIKE UPPER(NVL(?,NVL(position_code,\'123\')))AND eff_status=\'E\' ORDER BY 2 \";\n\n\t\t\t\t\n\t\t\t\t//sqlSecond=\"select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, \'CC\', \'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr.Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\', \'Trainee\',NULL,\'\',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\') like nvl(upper(?),decode(upper(gender),\'MALE\',\'M\',\'FEMALE\',\'F\',\'UNKNOWN\',\'U\')) and upper(nvl(job_title,\'123\')) like upper(nvl(?,nvl(job_title,\'123\'))) order by 2 \";\n\n\t\t\t\tsqlSecond=\"SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,\'\"+locale+\"\',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,\'\"+locale+\"\',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,\'\"+locale+\"\',1)))) AND  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),\'M\',\'MALE\',\'F\',\'FEMALE\',\'U\',\'Unknown\')) AND  UPPER(NVL(position_code,\'123\')) LIKE UPPER(NVL(?,NVL(position_code,\'123\')))AND eff_status=\'E\' ORDER BY 2 \";\n\n\t\t\t\t\n\t\t\t\tpractitionerName=target.name;\n\t\t\t\tpractitionerValue=target.value;\n\n\t\t\t\t*/\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(obj.name==\"pract_id1\" && document.forms[0].fm_pract_type)\n\t\t\t\t\tpractitionerTypeValue=document.forms[0].fm_pract_type.value;\n\t\t\t\telse if(document.forms[0].to_pract_type)\n\t\t\t\t\t\tpractitionerTypeValue=document.forms[0].to_pract_type.value;\n\n\t\t\t\tawait getPractitioner(obj,target,\'\',\'\',practitionerTypeValue,\'\',\'\',\'\',\'\',\'\',\"Q2\");\n\t\t\t\t\n\n\t\t\t\t/*\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\t\txmlStr += \" practName_FName=\\\"\" + practitionerName + \"\\\"\"\t;\n\t\t\t\txmlStr += \" practName_FValue=\\\"\" + practitionerValue + \"\\\"\";\n\t\t\t\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\t\t\t\txmlStr += \" sqlSec=\\\"\" +escape(sqlSecond)+ \"\\\"\";\n\t\t\t\txmlStr += \" practitioner_type=\\\"\" + practitionerTypeValue + \"\\\"\";\n\t\t\t\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\t\t\t\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\t\t\t\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\n\t\t\t\txmlStr +=\" /></root>\" ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\teval(responseText);\n\t\t\t\t*/\n\t\t\t\treturn;            \n\n\t\t\t}\n\n\t\t\tvar retVal=await CommonLookup(tit,argumentArray);\n\n\t\t\tvar ret1=unescape(retVal);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\t\n\t \t\t}\n\t\t\tif(retVal==null || retVal==\"\")\n\t\t\t\ttarget.value=\"\";\n\t\t\telse\n\t\t\t\ttarget.value=arr[0];\n\t\t            \n    }\n\n\n\tfunction PractLookupRetVal(retVal,objName)\n\t{\n\n\t\tvar arr;\n\n\t\tif (retVal != null)\n\t\t{\n\t\t\tarr=retVal.split(\"~\");\n\t\t\n\t\t\tif(objName==\"p_fm_pract_id\")\n\t\t\t\tdocument.forms[0].p_fm_pract_id.value=arr[0];\n\t\t\telse\n\t\t\t\tdocument.forms[0].p_to_pract_id.value=arr[0];\n\t\t\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\n\t\t\tif(objName==\"p_fm_pract_id\")\n\t\t\t\tdocument.forms[0].p_fm_pract_id.value=\"\";\n\t\t\telse\n\t\t\t\tdocument.forms[0].p_to_pract_id.value=\"\";\n\t\t\t\t\t\t\n\t\t}\n\t\n\t}\n\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n</script>\n<!--Added for this SCF TTM-SCF-0154 -->\n<script>\nfunction valDate(obj, format, localeName)\n\t{ \n\t\tif(obj.name==\"p_fm_visit_date1\")\n\t\t{ \n\t\t\t\tvar from =\'\';\n\t\t\t\tif(obj.value!=\'\'){\n\t\t\t\t\tfrom = convertDate(obj.value,\"DMY\",localeName,\"en\");\n\t\t\t\t\tdocument.forms[0].p_fm_visit_date.value = from;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].p_fm_visit_date.value = \'\';\n\t\t\t\t}\n\t\t\t\t\n\t\t}\n\t\tif(obj.name==\"p_to_visit_date1\")\n\t\t{ \n\t\t\t\tvar from =\'\';\n\t\t\t\tif(obj.value!=\'\'){\n\t\t\t\t\tfrom = convertDate(obj.value,\"DMY\",localeName,\"en\");\n\t\t\t\t\tdocument.forms[0].p_to_visit_date.value = from;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.forms[0].p_to_visit_date.value = \'\';\n\t\t\t\t}\n\t\t\t\t\n\t\t}\n\t\t\n\t}\n\n\n\n</script>\n</HEAD>\n<center>\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\'>\n<form name=\"VisitWoMDS_form\" id=\"VisitWoMDS_form\"  action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<br><br><br><br>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table cellpadding=\'0\' border = \'0\' cellspacing=\'0\' width=\'70%\'>\n<th class=\'columnheader\' align=\"left\" width=\'100%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n</table>\n\n<table cellpadding=\'2\' cellspacing=\'0\' width=\'70%\' border=\'0\'>\n\n\t<tr>\n\t\t<td width=\'33%\'>&nbsp;</td>\n\t\t<td class=\"querydata\" width=\'33\' style=\"font-weight: bold;\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\n\t\t<td class=\"querydata\" width=\'33\' style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td class=\'fields\'><input type=\"text\" id=\'mdsfrom\' name=\"p_fm_visit_date1\" id=\"p_fm_visit_date1\" size=\"10\" maxlength=\"10\" onBlur=\'valDate(this,\"DMY\",localeName);validDateObj(this,\"DMY\",localeName);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'mdsfrom\');\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\t\t\n\t\t<td class=\'fields\'><input type=\"text\" id=\'mdsto\' name=\"p_to_visit_date1\" id=\"p_to_visit_date1\" size=\"10\" maxlength=\"10\" onBlur=\'valDate(this,\"DMY\",localeName);validDateObj(this,\"DMY\",localeName);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'mdsto\');\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t\n\t\t<input type=\"hidden\" name=\"p_fm_visit_date\" id=\"p_fm_visit_date\">\n\t\t<input type=\"hidden\" name=\"p_to_visit_date\" id=\"p_to_visit_date\">\n\t\t\n    </tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_service_code\" id=\"p_fm_service_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(fromservice,this)\'><input type=\'button\' name=\'fromservice\' id=\'fromservice\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_service_code)\'>\n\t\t</td>\t\t\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_to_service_code\" id=\"p_to_service_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(toservice,this)\'><input type=\'button\' name=\'toservice\' id=\'toservice\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_service_code)\'>\n\t\t</td>   \n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_subservice_code\" id=\"p_fm_subservice_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(fromsubservice,this)\'><input type=\'button\' name=\'fromsubservice\' id=\'fromsubservice\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_subservice_code)\'>\n\t\t</td>\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_to_subservice_code\" id=\"p_to_subservice_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(tosubservice,this)\'><input type=\'button\' name=\'tosubservice\' id=\'tosubservice\' value=\'?\' class=\'button\' onclick=\'searchCode(this,p_to_subservice_code)\'>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_locn_code\" id=\"p_fm_locn_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(fromlocn,this)\'><input type=\'button\' name=\'fromlocn\' id=\'fromlocn\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fm_locn_code)\'>\n\t\t</td>\t\t\n\t\t<td class=\'fields\'><input type=\"text\" name=\"p_to_locn_code\" id=\"p_to_locn_code\" size=\"4\" maxlength=\"4\" onBlur=\'searchCode(tolocn,this)\'><input type=\'button\' name=\'tolocn\' id=\'tolocn\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_locn_code)\'>\n\t\t</td>\n\t</tr>\n    <tr>\n        <td class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n        <td class=\'fields\'>\n\t\t<select name=\"fm_pract_type\" id=\"fm_pract_type\">\n\t\t<option value=\"\">&nbsp;-------- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" --------&nbsp;</option>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</select>\n\t\t</td>\t\t\t\t\n\t\t<td class=\'fields\'><select name=\"to_pract_type\" id=\"to_pract_type\">\t\n\t\t<option value=\"\">&nbsp;-------- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</select>\n\t\t</td>\n\t</tr>\n                \n<tr>\n    <td class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n    \n    <td class=\'fields\'><input type=\"text\" name=\"p_fm_pract_id\" id=\"p_fm_pract_id\" size=\"15\" maxlength=\"15\" onBlur=\'searchCode(pract_id1,this)\'><input type=\'button\' name=\'pract_id1\' id=\'pract_id1\' value=\'?\' class=\'button\' onclick=\'searchCode(this,p_fm_pract_id)\'>   \n    </td>    \n    <td class=\'fields\'>\n    <input type=\"text\" name=\"p_to_pract_id\" id=\"p_to_pract_id\" size=\"15\" maxlength=\"15\" onBlur=\'searchCode(pract_id2,this)\'><input type=\'button\' name=\'pract_id2\' id=\'pract_id2\' value=\'?\' class=\'button\' onclick=\'searchCode(this,p_to_pract_id)\'>   \n    </td>\n</tr>\n<tr>\n    <td class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>    \n    <td class=\'fields\'><select name=\"p_order_by\" id=\"p_order_by\" >\n    <option value=\'VISIT_ADM_DATE_TIME\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n    <option value=\'PATIENT_ID\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n    <option value=\'VISIT_TYPE_DESC\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n    </option>\n    </select>   \n    </td>    \n    <td colspan=\'2\'>&nbsp;&nbsp;</td>\n</tr>\n</table>\n\n    <br>\n\n    <input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"       value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n    <input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"         value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n    <input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"         value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n    <input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"         value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n</form>\n</body>\n</center>\n\n<br>\n<br>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

    String p_module_id      = "OP" ;
    String p_report_id      = "OPRMDSEX" ;
    String p_facility_id        = (String) session.getValue( "facility_id" );
    String p_user_name      = (String) session.getValue( "login_user" );

            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);

    Connection con  =null;
    Statement stmt = null;
	ResultSet rset =null;
    String sql = "" ;
	StringBuffer StrVal =new StringBuffer();
	try
    {
		con  =  ConnectionManager.getConnection(request);
		stmt = con.createStatement(); 
    sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_LANG_VW Where language_id='"+localeName+"' and EFF_STATUS = 'E' order by 2" ;
    rset = stmt.executeQuery(sql);
	StrVal.setLength(0);

    
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append( "<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
			if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
	 }
	 catch(Exception e){
		 
		 //out.println(e);
		 e.printStackTrace();
		 
		 }
	 finally
	 {
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }


            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(StrVal.toString()));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(StrVal.toString()));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block2Bytes, _wl_block2);

StrVal.setLength(0);

            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.SubServiceCode.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.DateTimeOfVisit.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
