package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __caoaapptdairy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/CAOAApptDairy.jsp", 1720758979327L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n\t<SCRIPT>\n\t\tfunction populate(obj){\n\t\t\tvar pract_id=document.forms[0].practitioner_id.value;\n\t\t\tvar xmlDoc = \"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\txmlStr =\"<root><SEARCH clinic_type=\\\"\"+obj.value+\"\\\" pract_id=\\\"\"+pract_id+\"\\\" steps=\'CA\' /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"ServerSide.jsp\",false)\n\t\t\txmlHttp.send(xmlDoc)\n\t\t\tresponseText=xmlHttp.responseText\n\t\t\tresponseText = trimString(responseText)\n\t\t\teval(responseText) \n\t\t}\n\n\n\t\tfunction callDisplayOAResultsblock(date)\n\t\t{\n         alert(getMessage(\"SCHEDULE_BLOCK\",\"OA\")+\" \" +date);\n\t\t}\n\t\tfunction nextMonth(Totnum)\n\t\t{\n\t\t\t\tvar obj=document.forms[0].new_pract;\n\t\t\t\tvar  objvals=obj.value.split(\'&\')\n\t\t\t\tvar  cln_code=objvals[0];\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tTotnum=Totnum+1\n\t\t\t\tvar clinic_type= document.forms[0].locn_typee.value;\n\t\t\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&i_clinic_code=\"+cln_code+\"&i_appt_ref_no=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&i_appt_date=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&alcn_criteria=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&tfr_appt_across_catg_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&clinic_type=\"+clinic_type+\"&res_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&status=P1&TotNum=\"+Totnum+\"&callingMode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&ref=T&change_sch=1\";\n\t\t\t\tif(document.forms[0].new_pract.value==\'\'){\n\t\t\t\t\talert(getMessage(\"NO_LOCN_SPECIFIED\",\"OA\"))\n\t\t\t\t}else{\n\t\t\t\t\tself.location.href=param\n\t\t\t\t}\n\n\n\t\t}\n\n\t\tfunction previousMonth(Totnum)\n\t\t{\n\t\t\t\n\t\t\tif(Totnum>0)\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tTotnum=Totnum-1;\n\t\t\t\tvar clinic_type= document.forms[0].locn_typee.value;\n\t\t\t\tvar obj=document.forms[0].new_pract;\n\t\t\t\tvar  objvals=obj.value.split(\'&\')\n\t\t\t\tvar  cln_code=objvals[0];\n\n\t\t\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&status=M1&TotNum=\"+Totnum+\"&callingMode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&ref=T&change_sch=1\";\n\n\t\t\t\tif(document.forms[0].new_pract.value==\'\'){\n\t\t\t\t\talert(getMessage(\"NO_LOCN_SPECIFIED\",\"OA\"))\n\t\t\t\t}else{\n\t\t\t\t\tself.location.href=param\n\t\t\t\t}\n\n\n\t\t\t}\n\t\t}\n\n\t\tfunction rfresh(obj)\n\t\t{\n\t\t\t\t\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tvar clinic_type= document.forms[0].locn_typee.value;\n\n\t\t\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?i_practitioner_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&i_clinic_code=\"+obj.value+\"&callingMode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&ref=T\";\n\n\t\t\t\tself.location.href=param\n\t\t}\n\n\t\tfunction change_schedule(){\n\t\tvar obj=document.forms[0].new_pract;\n\t\tvar clinic_type= document.forms[0].locn_typee.value;\n\t\tvar  objvals=obj.value.split(\'&\')\n\t\tvar  cln_code=objvals[0];\n\t\tvar spl_code=objvals[1];\n\t\tdocument.forms[0].speciality_code.value=spl_code;\n\t\t\n\t\t//this line added for this CRF PMG2013-CRF-0016 [IN:044523]\n\t\tvar chck_flag=\"\"; \n\t\tif(obj.value==\"\")chck_flag=\"select\";\t\n\t\tvar param=\"../../eOA/jsp/CAOAApptDairy.jsp?spl_code=\"+spl_code+\"&i_practitioner_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&over_booked=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&alcn_criteria=\"+document.forms[0].alcn_criteria.value+\"&callingMode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&ref=T&change_sch=1&chck_flag=\"+chck_flag+\"&flag_cln_code=\"+cln_code+\"\";\n      /*Above line modified for this PMG2013-CRF-0016 [IN:044523]*/\t\t\n\t\tself.location.href=param\n\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t}\n\n\n\t\tfunction callDisplayOAResultsForOp(clinic, mon, yr,dt)\n\t\t{\n\t\t\tif(mon.length==1)\n\t\t\t\t\tmon=\"0\"+mon\n\t\t\tif(dt.length==1)\n\t\t\t\t\tdt=\"0\"+dt\n\t\t\tvar dt=dt+\"/\"+mon+\"/\"+yr;\n\t\t\tvar i_appt_ref_no=document.forms[0].apptrefno.value;\n\t\t\tvar i_clinic_code=document.forms[0].clinic_code.value;\n\t\t\tvar i_practitioner_id=document.forms[0].practitioner_id.value;\n\t\t\tvar i_appt_date=document.forms[0].old_date.value;\n\t\t\tvar new_appt_date=dt;\n\t\t\tvar old_alcn_catg_code=document.forms[0].old_alcn_catg_code.value;\t\t\t\n\t\t\tvar tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;\n\t\t\tvar over_booked=document.forms[0].over_booked.value;\n\t\t\tvar ca_mode=\'ca_mode\';\n\t\t\tvar from_page=\'ca_appt_dairy\';\n\t\t\tvar ca_patient_id=document.forms[0].ca_patient_id.value;\n\t\t\tvar callingMode=document.forms[0].callingMode.value;\n\t\t\tvar res_type=document.forms[0].res_type.value;\n\t\t\tvar clinic_type=document.forms[0].clinic_type.value;\n\t\t\tvar oper_stn_id=document.forms[0].oper_stn_id.value;\n\t\t\tvar slot_appt_ctrl = document.forms[0].slot_appt_ctrl.value;\n\t\t\tvar visit_limit_rule= document.forms[0].visit_limit_rule.value;\n\t\t\tvar alcn_criteria=document.forms[0].alcn_criteria.value;\n\t\t\tvar override_no_of_slots_yn=document.forms[0].override_no_of_slots_yn.value;\n\t\t\tvar capture_fin_dtls_yn=document.forms[0].capture_fin_dtls_yn.value;\n\t\t\tvar min_ela_per_resc_noshow_in_day=document.forms[0].min_ela_per_resc_noshow_in_day.value;\n\t\t\tvar noshow_ctrl_by_splty_or_clinic=document.forms[0].noshow_ctrl_by_splty_or_clinic.value;\n\t\t\tvar contact_num_reqd_yn= document.forms[0].contact_num_reqd_yn.value;\n\t\t\tvar no_of_noshow_appts_for_alert= document.forms[0].no_of_noshow_appts_for_alert.value;\n\t\t\tvar per_chk_for_no_show_alert= document.forms[0].no_of_noshow_appts_for_alert.value;\n\t\t\t\n\t\t\tvar param=\"../../eOA/jsp/SinglePractVw.jsp?tfr_appt_across_catg_yn=\"+tfr_appt_across_catg_yn+\"&old_alcn_catg_code=\"+old_alcn_catg_code+\"&alcn_criteria=\"+alcn_criteria+\"&i_appt_ref_no=\"+i_appt_ref_no+\"&clinic_code=\"+i_clinic_code+\"&practitioner_id=\"+i_practitioner_id+\"&over_booked=\"+over_booked+\"&callingMode=\"+callingMode+\"&old_date=\"+i_appt_date+\"&Date=\"+new_appt_date+\"&ca_patient_id=\"+ca_patient_id+\"&ca_mode=\"+ca_mode+\"&clinic_type=\"+clinic_type+\"&res_type=\"+res_type+\"&oper_stn_id=\"+oper_stn_id+\"&slot_appt_ctrl=\"+slot_appt_ctrl+\"&visit_limit_rule=\"+visit_limit_rule+\"&override_no_of_slots_yn=\"+override_no_of_slots_yn+\"&capture_fin_dtls_yn=\"+capture_fin_dtls_yn+\"&min_ela_per_resc_noshow_in_day=\"+min_ela_per_resc_noshow_in_day+\"&noshow_ctrl_by_splty_or_clinic=\"+noshow_ctrl_by_splty_or_clinic+\"&no_of_noshow_appts_for_alert=\"+no_of_noshow_appts_for_alert+\"&per_chk_for_no_show_alert=\"+per_chk_for_no_show_alert+\"&from_page=\"+from_page+\"&inv_visit_mpq_from_ca_yn=\"+document.forms[0].inv_visit_mpq_from_ca_yn.value+\"&contact_num_reqd_yn=\"+contact_num_reqd_yn;\n\n\t\t\tparent.frames[1].location.href=param;\n\n\n\n\t\t}\n\n\t\tfunction onBlurCallPractitionerSearchQuery(obj,target){\n\t\t\t\tif(target.value==\"\"){\n\t\t\t\t\treturn\n\t\t\t\t}else{\n\t\t\t\t\tcallPractSearchQuery(obj,target)\n\t\t\t\t}\n\t\t}\n\t\tfunction callPractSearchQuery(obj,target){\n\t\t\tvar locale\t\t\t  =document.forms[0].locale.value\n\t\t\tvar facility_id\t\t  =document.forms[0].facilityId.value\n\t\t\tvar clinic_code\t\t  =document.forms[0].new_pract.value\n\t\t\tvar firstSql\t\t  = \"\";\n\t\t\tvar secondSql\t\t  = \"\";\n\t\t\tvar opne_all_pract_yn=\"Y\";\n\t\t\tvar practitionerName=\"\";\n\t\t\tvar practitionerValue=\"\";\n\t\t\t\t\n\t\t\ttarget.value=trimString(target.value);\n\t\t\tpractitionerName=target.name;\n\t\t\tpractitionerValue=target.value;\n\t\t\tvar practitioner_type = \"\";\t\n\n\n\t\t\tif(opne_all_pract_yn==\"Y\"){\n\t\t\tfirstSql=\" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id=\'\"+locale+\"\' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, \'123\')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,\'123\'))) AND d.facility_id=\'\"+facility_id+\"\' AND d.clinic_code= \'\"+clinic_code+\"\' AND e.speciality_code = f.speciality_code and f.language_id = \'\"+locale+\"\'\";\n\n\t\t\tsecondSql=\" SELECT d.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.PRACT_TYPE_DESC  practitioner_type, f.short_desc primary_specialty, a.gender gender, a.position_code  job_title FROM OP_REGISTER_VISIT_PRACT_VW d, am_practitioner_lang_vw a, OP_CLINIC e, am_speciality_lang_vw f WHERE a.language_id=\'\"+locale+\"\' AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?) AND e.speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.practitioner_name) LIKE  UPPER(NVL(?,a.practitioner_name))) AND a.gender LIKE (?) AND UPPER(NVL(a.POSITION_CODE, \'123\')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,\'123\'))) AND d.facility_id=\'\"+facility_id+\"\' AND d.clinic_code= \'\"+clinic_code+\"\' AND e.speciality_code = f.speciality_code and f.language_id = \'\"+locale+\"\'\";\n\t\t\t}else{\n\t\t\tfirstSql= \" SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id=\'\"+locale+\"\' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, \'123\')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,\'123\'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,\'R\',\'\',\'E\',\'\',\'O\',\'\',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = \'\"+locale+\"\'  AND a.clinic_code=\'\"+clinic_code+\"\' AND  a.facility_id=\'\"+facility_id+\"\' AND a.eff_status = \'E\' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = \'\"+facility_id+\"\' and eff_status = \'E\' ) \";\n\n\t\t\tsecondSql= \" SELECT b.practitioner_id practitioner_id , b.practitioner_name practitioner_name, b.PRACT_TYPE_DESC practitioner_type, d.short_desc primary_specialty, b.gender gender , b.position_code job_title FROM op_pract_for_clinic a, am_practitioner_lang_vw b, op_clinic c, am_speciality_lang_vw d WHERE b.language_id=\'\"+locale+\"\' AND b.pract_type LIKE (?) AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id)) AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND b.gender LIKE (?) AND UPPER(NVL(b.POSITION_CODE, \'123\')) LIKE UPPER(NVL(?,NVL(b.POSITION_CODE,\'123\'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code and c.facility_id = a.facility_id AND b.pract_type=NVL(decode(c.PRIMARY_RESOURCE_CLASS,\'R\',\'\',\'E\',\'\',\'O\',\'\',c.pract_type),b.pract_type) AND c.speciality_code = d.speciality_code and d.language_id = \'\"+locale+\"\' AND a.clinic_code=\'\"+clinic_code+\"\' AND  a.facility_id=\'\"+facility_id+\"\' AND a.eff_status = \'E\' and exists ( select 1 from am_pract_for_facility where practitioner_id = b.practitioner_id and facility_id = \'\"+facility_id+\"\' and eff_status = \'E\' ) \";\t\t\n\t\t\t}\n\n\t\t\tvar xmlDoc=\"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\n\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\txmlStr += \" practName_FName=\\\"\" + practitionerName + \"\\\"\";\n\t\t\txmlStr += \" practName_FValue=\\\"\" +encodeURIComponent(practitionerValue) + \"\\\"\";\n\t\t\txmlStr += \" sql=\\\"\" +escape(firstSql)+\"\\\"\";\n\t\t\txmlStr += \" sqlSec=\\\"\" +escape(secondSql)+\"\\\"\";\n\t\t\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\t\t\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\t\t\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\t\t\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=xmlHttp.responseText;\n\t\t\tresponseText = trimString(responseText);\n\t\t\t//eval(responseText);\t\n\t\t\t//return;\n\t\t\teval(practSearch(practitionerName,encodeURIComponent(practitionerValue),responseText));\n\t\t}\n\t\t\n\t\tasync function practSearch(practName_FName,practName_FValue,responseText) {\n\tvar retVal = \tnew String();\n\tvar dialogTop = \"10px\" ;\n\tvar dialogHeight= \"450px\" ;\n\tvar dialogWidth\t= \"700px\" ;\n\t\t\n\tif(responseText ==\"true\") {        \t\n\t    dialogWidth=\"70.5\";\n\t}\n\t\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar tit=\"Pract Search\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\tvar sqlArray= new Array();\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\tvar objName=practName_FName;\n    arguments=\'\';\n\t\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\tretVal = await window.showModalDialog(\"../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name=\"+practName_FValue+\"&practitioner_type=\"+\"\\\"\"+\"&primary_specialty=\"+\"\\\"\"+\"&job_title=\"+\"\\\"\"+\"&gender=\"+\"\\\"\",arguments,features);\n\tPractLookupRetVal(retVal,objName);\n}\n\n\t\tfunction PractLookupRetVal(retVal,objName)\n\t\t{\n\t\t\tvar arr;\n\t\t\tif (retVal != null)\n\t\t\t{\n\t\t\t\tarr=retVal.split(\"~\");\n\t\t\t\tdocument.forms[0].attend_practitioner_id.value=arr[0];\n\t\t\t\tdocument.forms[0].attend_practitioner_name.value=arr[1];\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.forms[0].attend_practitioner_id.value=\"\";\n\t\t\t\tdocument.forms[0].attend_practitioner_name.value=\"\";\n\t\t\t}\n\t\t}\n\n\t\tfunction callOPPage(){\t\n\t\t\tvar spl_code=document.forms[0].speciality_code.value\n\t\t\n\t\t\tif(parent.parent.frames[1].name==\'myTasks\'){\t\n\t\t\t\tparent.parent.frames[5].location.href=\"../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code=\"+spl_code+\"&inv_visit_mpq_from_ca_yn=\"+document.forms[0].inv_visit_mpq_from_ca_yn.value;\n\t\t\t}else{\n\t\t\t\t//sep-10-2005 validation for 5028 patch\n\t\t\t\tif(parent.parent.frames[1].name==\'menuFrame\')\t\t\t\t\tparent.frames.location.href=\"../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code=\"+spl_code+\"&inv_visit_mpq_from_ca_yn=\"+document.forms[0].inv_visit_mpq_from_ca_yn.value;\n\t\t\t\telse\n\t\t\t\tparent.parent.frames[1].location.href=\"../../eOP/jsp/ManageSPatQueue.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA&speciality_code=\"+spl_code+\"&inv_visit_mpq_from_ca_yn=\"+document.forms[0].inv_visit_mpq_from_ca_yn.value;\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t</SCRIPT>\n\t</head>\n\n\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t<form name=\"ca_oaappt\" id=\"ca_oaappt\"> <!-- this line modified for this CRF PMG2013-CRF-0016 [IN:044523] -->\n\t\t\n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' > <!--this line moved here for this CRF PMG2013-CRF-0016 [IN:044523]   -->\n\t\t\t<table border=0 cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t<tr><td class=\'label\' colspan=\'3\'>&nbsp;</td></tr>\n\t\t\t<tr><td class=\'label\' colspan=\'3\'></td></tr><tr><td class=\'label\' colspan=\'3\'></td></tr>\n\t\t\t<tr><td class=\'label\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<td class=\'fields\' width=\'40%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<td class=\'fields\' width=\'40%\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<select name=\"locn_typee\" id=\"locn_typee\" onchange=\"populate(this);change_schedule();\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t <option value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' selected>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option> \t\n\t\t\t\t\t\t\t         \n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t    <option value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option> \t\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tobj=document.forms[0].locn_typee\n\t\t\t\t\tvar len=obj.options.length;\n\t\t\t\t\tvar i=0;\n\t\t\t\t\topt=document.createElement(\'OPTION\');\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tobj=document.forms[0].locn_typee\n\t\t\t\t\t\tvar len=obj.options.length;\n\t\t\t\t\t\tvar i=0;\n\t\t\t\t\t\topt=document.createElement(\'OPTION\');\n\n\t\t\t\t\t\topt.value=\'\';\n\t\t\t\t\t\topt.text=\'  ---";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="---  \';\n\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\tdocument.forms[0].locn_typee.value=\'\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<tr><td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t<td class=\'fields\' width=\'40%\'>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</b>\n\t\t\t\t<input type=\"hidden\" name=\"new_pract\" id=\"new_pract\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<select name=\'new_pract\' id=\'new_pract\' onchange=\'change_schedule()\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td></tr>\n\t\t\t<!--Below line Added for this CRF PMG2013-CRF-0016 [IN:044523]  -->\n\t\t\t\t<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n                <input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\t\t\t\t\n\t\t\t    <input type=\"hidden\" name=\"location_ind_flag\" id=\"location_ind_flag\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"> \n\t\t\t    <input type=\"hidden\" name=\"change_schedule_flag\" id=\"change_schedule_flag\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"> \n\t\t\t   <script> \n\t\t\t   //if(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'!=\"\" && \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'==\"\" || \'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'!=\"\" &&\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'!=\"\"){populate(document.ca_oaappt.locn_typee);}\t\t\t  \n\t\t\t   if(\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'==\"\" &&\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'!=\"\"){populate(document.ca_oaappt.locn_typee);}\n\t\t\t   if((document.ca_oaappt.new_pract && document.ca_oaappt.new_pract.value!=\"\") && (document.ca_oaappt.change_schedule_flag && document.ca_oaappt.change_schedule_flag.value==\"\")){change_schedule();}</script>\t\t\n\t          <!-- End PMG2013-CRF-0016 [IN:044523] -->\t\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<tr>\n\t\t\t<td class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t<td class=\'fields\' width=\'40%\' colspan=\'3\'>&nbsp;<b>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="/\n\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\t\t\t\n\t\t\t<tr><td></td><td class=\'fields\' width=\'40%\' colspan=\'3\'>&nbsp;<b>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td></tr>\n\t\t\t<tr><td class=\'label\' colspan=\'3\'></td></tr><tr><td class=\'label\' colspan=\'3\'></td></tr><tr><td class=\'label\' colspan=\'3\'></td></tr><tr><td class=\'label\' colspan=\'3\'></td></tr>\n\t\t\t<tr><td class=\'white\'>&nbsp;</td></tr>\n\t\t\t<tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr><tr><td class=\'white\'></td></tr>\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<table  align=\'center\' border=0 cellspacing=0 cellpadding=0 width=\'98%\'>\n\t\t\t<tr >\n\t\t\t\t<td  width=\'98%\' class=\'white\' >\n\t\t\t\t<table cellspacing=0 cellpadding=0  width=\'98%\' style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt\' border=\'0\'>\n\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"<---\" name=\'prev\' id=\'prev\'  onclick=previousMonth(";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =")></td>\n\t\t\t\t\t\t<td align=\'center\' class=\"DISPDATE\" width=\'140%\'><font size=3><b>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</b></font></td>\n\t\t\t\t\t\t<td align=\'center\' width=\'10%\'><input type=\'button\' class=\'button\' value=\"--->\" name=\'next\' onclick=nextMonth(";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =")></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'callingMode\' id=\'callingMode\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' >\n\t\t\t<input type=\'hidden\' name=\'old_alcn_catg_code\' id=\'old_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\n\t\t\t<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' >\n\t\t\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' >\n\t\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' >\n\t\t\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\"hidden\" name=\"capture_fin_dtls_yn\" id=\"capture_fin_dtls_yn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t<input type=\"hidden\" name=\"min_ela_per_resc_noshow_in_day\" id=\"min_ela_per_resc_noshow_in_day\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\"hidden\" name=\"noshow_ctrl_by_splty_or_clinic\" id=\"noshow_ctrl_by_splty_or_clinic\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t<input type=\"hidden\" name=\"contact_num_reqd_yn\" id=\"contact_num_reqd_yn\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\"no_of_noshow_appts_for_alert\" id=\"no_of_noshow_appts_for_alert\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=\"hidden\" name=\"per_chk_for_no_show_alert\" id=\"per_chk_for_no_show_alert\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"inv_visit_mpq_from_ca_yn\" id=\"inv_visit_mpq_from_ca_yn\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\n\t\t\t\t\n\t\t\n\t\t\t</form>\n\t\t<tr>\n\t\t<table width=\'96%\'  align=\'center\' cellpadding=0  style=\'mso-cellspacing:2.0pt;margin-left:2.75pt; border:inset 1.75pt;mso-padding-alt:0in 5.4pt 0in 5.4pt \'>\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<th width=\'3%\' align=\'center\' ><font size=1>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</th>\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t  <tr>\n\t\t\t\t  \t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t  \t\t\t<td class=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' align=\'center\' width=\'3%\'><font \tsize=2>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</a></td>\n\t\t\t\t\t  \t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' align=\'center\' width=\'3%\'><font size=2>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</a></td>\n\t\t\t\t  \t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</a></td>\n\t\t\t\t  \t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t  </tr>\n\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t</tr>\t\t\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t<table align=\'right\' width=\"25%\">\n\t\t<tr><td><input type=\'button\' class=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' onclick=\'callOPPage()\'></td></tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t<script>alert(getMessage(\"SCH_NOT_AVAILABLE\",\"OA\"));\n\t\t\tlocation.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\n\t\t\t<script>change_schedule()</script>\n\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t//alert(document.forms[0].new_pract.options.length)\n\t\t\t\t\t/*obj=document.forms[0].new_pract\n\t\t\t\t\tvar len=obj.options.length;\n\t\t\t\t\tvar i=0;\n\t\t\t\t\topt=document.createElement(\'OPTION\');\n\n\t\t\t\t\topt.value=\'\';\n\t\t\t\t\topt.text=\'  ---";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="---  \';\n\t\t\t\t\tobj.add(opt);*/\n\t\t\t\t\t//alert(document.forms[0].new_pract.options.length)\n\t\t\t\t\t//document.forms[0].new_pract.value=\'\';\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t<script>\n\t\tcallDisplayOAResultsForOp(\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');</script>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t<script>\n\t\tsetTimeout(\"callDisplayOAResultsblock(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\')\",300)</script>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );
 int TotNum=0;

			public String getCalendarString(Connection con,String arg)
			{
				
				Statement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				try
				{
					stmt=con.createStatement();
		   			sql="select get_calendar_string('"+arg+"') calen_val from dual";
					rs=stmt.executeQuery(sql);
					if(rs.next())
					RetString=rs.getString("calen_val");
					if(rs !=null) rs.close();
					if(stmt !=null)stmt.close();
				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
					e.printStackTrace();
				}
				return RetString;
			}
	

			public String getCalanderStatusColor(String Facility_Id,String Clinic_Code, String Pract_Id, Connection con,String arg)
			{
				Statement stmt=null;
				ResultSet rs=null;
				String sql="";
				String RetString="";
				
				try
				{
		   			stmt=con.createStatement();

					sql="SELECT GET_CALENDAR_STATUS_COLOR ('"+Facility_Id+"', '"+Clinic_Code+"', '"+Pract_Id+"','"+arg+"') sta_color FROM DUAL";

					rs=stmt.executeQuery(sql);
					if(rs.next())
						RetString=rs.getString("sta_color");
						if(rs !=null) rs.close();
						if(stmt !=null)stmt.close();

				}
				catch(Exception e)
				{
					RetString=e.toString()+"<br>sql:"+sql;
					e.printStackTrace();
				}
				return RetString;
			}
	


		public String getYearMonth(String state, int TotNum)
		{
			Calendar cal=Calendar.getInstance();
			int current=cal.get(Calendar.MONTH);

			String arg="";
			String mont="";
			if(state.equals("previous"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);

				if(cal.get(Calendar.MONTH)>=current)
					state="current";
			}

			if(state.equals("current"))
			{
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(state.equals("next"))
			{
				cal.add(Calendar.MONTH,+TotNum);
				arg=String.valueOf(cal.get(Calendar.YEAR));
				mont=String.valueOf(cal.get(Calendar.MONTH)+1);
			}

			if(mont.length()==1)
					mont=0+mont;
				arg=arg+mont;

				return arg;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block7Bytes, _wl_block7);


	request.setCharacterEncoding("UTF-8");	

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ca_patient_id=request.getParameter("patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	String locale=(String)session.getAttribute("LOCALE");

	String clinic_code=request.getParameter("location_code");
	String splty_code=request.getParameter("spl_code");

	if (clinic_code==null)
	clinic_code=request.getParameter("i_clinic_code");

	if (clinic_code==null) clinic_code="";


	String practitioner_id="";
	String callingMode="N";
	callingMode=request.getParameter("callingMode");
	session.putValue("callingMode_new",callingMode);
	String ref_md=request.getParameter("ref");
	if(ref_md==null) ref_md="F";
	if(callingMode==null || callingMode.equals("") || callingMode.equals("null")){
		callingMode="N";
	}
	if(callingMode.equals("OP"))
	{
		practitioner_id=request.getParameter("i_practitioner_id");
	}else{
		practitioner_id=(String)session.getValue("ca_practitioner_id");
	}
	
	boolean no_sch_flag=false;


	String i_Clinic_code_sel=clinic_code;
	if(i_Clinic_code_sel==null || i_Clinic_code_sel.equals("") || i_Clinic_code_sel.equals("null")){
		i_Clinic_code_sel="N";
	}
	int ij=0;
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("resource_class");
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	
	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
		care_locn_ind_desc="Clinic";
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc="Procedure Unit";
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc="Day Care Unit";
	}
	String res_class_desc="";
	if(res_type.equals("P")){
		res_class_desc="Practitioner";
	}else if(res_type.equals("E")){
		res_class_desc="Equipment";
	}else if(res_type.equals("R")){
		res_class_desc="Room";
	}else if(res_type.equals("O")){
		res_class_desc="Others";
	}else if(res_type.equals("B")){
		res_class_desc="Bed";
	} 
	int cnter=0;
	String apptrefno=request.getParameter("i_appt_ref_no");
	String old_date=request.getParameter("i_appt_date");
	String fid=(String)session.getValue("facility_id");
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	String old_alcn_catg_code="";
	String clinic_name="";
	String practitioner_name="";
	String clinic_id="";
	String INV_VISIT_MPQ_FROM_CA_YN="";
	String overbookedyn=request.getParameter("over_booked");
	if(apptrefno==null)apptrefno="";
	if(old_date==null)old_date="";
	boolean allow_click=true;
	boolean referesh_flag=true;
	Properties p=(Properties)session.getValue("jdbc");
	String globaluser = (String)p.getProperty("login_user");
	String slot_appt_ctrl="";
	String visit_limit_rule="";			
	//String alcn_criteria="";			
	String override_no_of_slots_yn ="";			
	String capture_fin_dtls_yn ="";
	String min_ela_per_resc_noshow_in_day ="";
	String noshow_ctrl_by_splty_or_clinic ="";
	String contact_num_reqd_yn ="";
	String no_of_noshow_appts_for_alert ="";
	String per_chk_for_no_show_alert ="";
	

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);

			
			Connection con = null;
			Statement stmt=null;
			Statement stmt1=null;
			/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
			Statement stmt3=null;
			ResultSet rs3=null;
			String loc_ind_flag="",loc_code="";	
			boolean schedule_chk_flag=false;
			String change_sch=request.getParameter("change_sch")==null?"":request.getParameter("change_sch");
			String chck_flag=request.getParameter("chck_flag")==null?"":request.getParameter("chck_flag");
			String flag_cln_code=request.getParameter("flag_cln_code")==null?"":request.getParameter("flag_cln_code");
			
			
			//End PMG2013-CRF-0016 [IN:044523]	
			
 			ResultSet rs=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			int coi=0;
			String week[]=new String[7];
			String day_type1[]=new String[7];
			String day_type2[]=new String[7];
			String day_type3[]=new String[7];
			String day_type4[]=new String[7];
			String day_type5[]=new String[7];
			String oper_stn_id="";
			boolean cur_day_flag=false; //PMG2013-CRF-0016 [IN:044523] 
			boolean cur_day_blocked_flag=false;//PMG2013-CRF-0016 [IN:044523] 
			String curr_date_flag="";
			try{

			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			stmt1 =con.createStatement();
			String sql2_oper_stn_id="SELECT a.oper_stn_id,a.book_appt_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+fid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			rs1 =stmt1.executeQuery(sql2_oper_stn_id);
			if(rs1 !=null && rs1.next())
			{
				oper_stn_id=rs1.getString("oper_stn_id");
			}
			if(rs1 !=null) rs1.close();
			String sql_alcn_slot_visit="SELECT SLOT_APPT_CTRL,VISIT_LIMIT_RULE,ALCN_CRITERIA,OVERRIDE_NO_OF_SLOTS_YN,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT FROM OA_PARAM WHERE MODULE_ID='OA'";
				rs2=stmt1.executeQuery(sql_alcn_slot_visit);
			if(rs2 !=null && rs2.next()){
				slot_appt_ctrl =rs2.getString("SLOT_APPT_CTRL");
				visit_limit_rule =rs2.getString("VISIT_LIMIT_RULE");
				alcn_criteria =rs2.getString("ALCN_CRITERIA");
				override_no_of_slots_yn =rs2.getString("OVERRIDE_NO_OF_SLOTS_YN");
				capture_fin_dtls_yn =rs2.getString("CAPTURE_FIN_DTLS_YN");
				min_ela_per_resc_noshow_in_day =rs2.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
				noshow_ctrl_by_splty_or_clinic =rs2.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
				contact_num_reqd_yn =rs2.getString("CONTACT_NUM_REQD_YN")==null?"N":rs2.getString("CONTACT_NUM_REQD_YN");
				no_of_noshow_appts_for_alert =rs2.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT")==null?"":rs2.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
				per_chk_for_no_show_alert =rs2.getString("PER_CHK_FOR_NO_SHOW_ALERT")==null?"":rs2.getString("PER_CHK_FOR_NO_SHOW_ALERT");
			}

			if(rs2 !=null) rs2.close();
			String sql_week="select substr(DAY_OF_WEEK,1,3) day_of_week,DAY_TYPE,DAY_NO,DAY_TYPE_WEEK_1,DAY_TYPE_WEEK_2,DAY_TYPE_WEEK_3,DAY_TYPE_WEEK_4,DAY_TYPE_WEEK_5 from sm_day_of_week order by DAY_NO";
				rs=stmt.executeQuery(sql_week);
					if(rs!=null){
					 while(rs.next()){
					  week[coi]=rs.getString("day_of_week");
					  day_type1[coi]=rs.getString("DAY_TYPE_WEEK_1");
					  day_type2[coi]=rs.getString("DAY_TYPE_WEEK_2");
					  day_type3[coi]=rs.getString("DAY_TYPE_WEEK_3");
					  day_type4[coi]=rs.getString("DAY_TYPE_WEEK_4");
					  day_type5[coi]=rs.getString("DAY_TYPE_WEEK_5");
					  coi++;
					}
					}

				if(rs !=null) rs.close();

			String inv_visit_frm_ca="SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fid+"'";
			rs=stmt.executeQuery(inv_visit_frm_ca);
			if(rs!=null && rs.next()){
				INV_VISIT_MPQ_FROM_CA_YN=rs.getString("INV_VISITREGN_MPQ_FROM_CA_YN");
			}
			if(rs !=null) rs.close();

			}
			catch(Exception es){
				out.println("Exec@4" +es);
				es.printStackTrace();
			}
			/*
			String Color_Code[]={"S","Y","G","R","B","H"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY"};*/
			/*Modified By Dharma on Dec 4th against ML-BRU-SCF-1504 [IN:052807]*/
			String Color_Code[]={"S","Y","G","R","B","H","L","D"};
			String Color_Val[]={"","OAYellow","OAGreen","OAFULL","OARed","OAHOLIDAY","OALIGHTGREEN","OADARKGREEN"};
			String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};

			String cliniccode=request.getParameter("location_code");
			if (cliniccode==null)
			cliniccode=request.getParameter("i_clinic_code");

			String colorclass="";
			String status=request.getParameter("status");
			String recall_date=request.getParameter("recall_date");
			String state="current";
			String cur_date="";
			String cur_dat="";
			
			/*Above line Added for this CRF PMG2013-CRF-0016 [IN:044523]*/
			
			if(status!=null)
			{
				if(status.equals("P1"))
					state="next";
				if(status.equals("M1"))
					state="previous";
			}
			
			try
			{
				if(rs !=null) rs.close();
				if(request.getParameter("TotNum")!=null){
				TotNum=Integer.parseInt(request.getParameter("TotNum"));
				}
				else{	
				int curr_month=0;
				String sql_date="select to_char(sysdate,'mm')curr_month,to_char(sysdate,'dd/mm/yyyy') old_date from dual";
				rs=stmt.executeQuery(sql_date);
					if(rs.next()){
					curr_month=rs.getInt("curr_month");
					old_date=rs.getString("old_date");
					if(old_date ==null) old_date="";
					}

					if(rs !=null) rs.close();

					if(recall_date ==null) recall_date=old_date;
				String mon_date="";	
				StringTokenizer stoken = new StringTokenizer(recall_date,"/");
				int count=0;
				while(stoken.hasMoreTokens())
				{
					String mon		= stoken.nextToken();
						if(count==1){
						mon_date=mon;}
						count++;
						

				}
				int month_of_year=Integer.parseInt(mon_date);
				TotNum=month_of_year-curr_month;	
				}

				if(TotNum==0)
				{
				state="current";
				}
				else
				{
					if(TotNum > 0)
					{
					   state="next";
					}
				}

				
				
			}
			catch(Exception e){
				out.println("Exec@1"+e);
				e.printStackTrace();
			}
			
			
			String arg=getYearMonth(state,TotNum);

			String CalString=(String)getCalendarString(con,arg);

			String ColorString=getCalanderStatusColor(fid,cliniccode,practitioner_id,con,arg);

			String yr=arg.substring(0,4);
			String yr_display=DateUtils.convertDate(yr,"YY","en",locale);
			int mon=Integer.parseInt(arg.substring(4,arg.length()));
			String month=months[mon-1];
				String month_display="";
			if(month.equals("January"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.January.label","common_labels");
				}else if(month.equals("February"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.February.label","common_labels");
				}else if(month.equals("March"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.March.label","common_labels");
				}else if(month.equals("April"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.April.label","common_labels");
				}else if(month.equals("May"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.May.label","common_labels");
				}else if(month.equals("June"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.June.label","common_labels");
				}else if(month.equals("July"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.July.label","common_labels");
				}else if(month.equals("August"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.August.label","common_labels");
				}else if(month.equals("September"))
				{
				month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.September.label","common_labels");
				}else if(month.equals("October"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.October.label","common_labels");
				}else if(month.equals("November"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.November.label","common_labels");
				}else if(month.equals("December"))
				{
					month_display=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.December.label","common_labels");
				}
			StringTokenizer splitdays=new StringTokenizer(CalString,"|");
			String[] NumOfDays=new String[splitdays.countTokens()];

			StringTokenizer ColVals=new StringTokenizer(ColorString,"|");
			String colors[]=new String[ColVals.countTokens()];

			for(int i=0;i<NumOfDays.length;i++)
				NumOfDays[i]=splitdays.nextToken();
			for(int i=0;i<colors.length;i++)
				colors[i]=ColVals.nextToken();

				int ro=NumOfDays.length/7;
				
				int rodup=1;
				int ccols=7;
				String dat="";
				int act=0;
			
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(!callingMode.equals("CA") && !callingMode.equals("CA_WIDGET")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else {			   
				/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/				
				if(chck_flag.equals("")){
				String loc_type_ind="SELECT DISTINCT (care_locn_type_ind) care_locn_type_ind,DECODE (care_locn_type_ind,'E', 'Procedure Unit','C', 'Clinic','D', 'Day Care Unit') descrip,TO_CHAR (start_time,'hh24:mi') strdate, TO_CHAR (end_time,'hh24:mi') enddate FROM oa_clinic_schedule WHERE facility_id ='"+fid+"'   AND practitioner_id = '"+practitioner_id+"'    AND  primary_resource_yn = 'Y' AND resource_class = 'P' and trunc(clinic_date,'dd') = trunc(sysdate,'dd') and to_char(sysdate ,'hh24:mi') between to_char(start_time,'hh24:mi') and to_char(end_time,'hh24:mi') order by strdate,enddate, descrip";
				
				
				stmt3 =con.createStatement();
				rs3 = stmt3.executeQuery(loc_type_ind);
				if(rs3!=null && rs3.next()){						
						loc_ind_flag=rs3.getString("care_locn_type_ind")==null?"":rs3.getString("care_locn_type_ind");
					
				}
				if(rs3!=null) rs3.close();
				if(stmt3!=null) stmt3.close();
				
				
				if(loc_ind_flag.equals("")){
				String loc_type_ind_chkdate="SELECT DISTINCT (care_locn_type_ind) care_locn_type_ind,DECODE (care_locn_type_ind,'E', 'Procedure Unit','C', 'Clinic','D', 'Day Care Unit') descrip FROM oa_clinic_schedule WHERE facility_id ='"+fid+"'   AND practitioner_id = '"+practitioner_id+"' and clinic_date >= trunc(sysdate)   AND  primary_resource_yn = 'Y' AND resource_class = 'P'  order by descrip";
				
				stmt3 =con.createStatement();
				rs3 = stmt3.executeQuery(loc_type_ind_chkdate);
				if(rs3!=null && rs3.next()){						
						loc_ind_flag=rs3.getString("care_locn_type_ind")==null?"":rs3.getString("care_locn_type_ind");
					
				}				
				if(rs3!=null) rs3.close();
				if(stmt3!=null) stmt3.close();
				}	
				}
				//End this CRF PMG2013-CRF-0016 [IN:044523]
				
				
			
            _bw.write(_wl_block32Bytes, _wl_block32);
String locn_typ_str="select distinct(CARE_LOCN_TYPE_IND) CARE_LOCN_TYPE_IND,decode(CARE_LOCN_TYPE_IND,'E', 'Procedure Unit','C','Clinic','D','Day Care Unit') descrip   from  oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y'";
				rs=null;
				rs = stmt.executeQuery(locn_typ_str);
				
            _bw.write(_wl_block33Bytes, _wl_block33);
if(ref_md.equals("T")){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
				
				if(rs !=null){
					while ( rs.next() )	{
						cnter=cnter+1;
						
						String car_loc_int=rs.getString("CARE_LOCN_TYPE_IND")==null?"":rs.getString("CARE_LOCN_TYPE_IND");
						String car_loc_desc=rs.getString("descrip")==null?"":rs.getString("descrip");

						 
						
						if(ref_md.equals("F")){ 
							//Below line Added this CRF PMG2013-CRF-0016 [IN:044523] 							
							 if(!loc_ind_flag.equals("") && car_loc_int.equals(loc_ind_flag)){ schedule_chk_flag=true;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(car_loc_int));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(car_loc_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(car_loc_int));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(car_loc_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
} //End this CRF PMG2013-CRF-0016 [IN:044523]
						
							 }else{
								if(car_loc_int.equals(clinic_type)){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(car_loc_int));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(car_loc_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(car_loc_int));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(car_loc_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
						}
					}
				}
				
				
            _bw.write(_wl_block44Bytes, _wl_block44);
if(cnter>=1){ //this line modified for this CRF  PMG2013-CRF-0016 
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
					//if(ref_md.equals("F")){
					/*Above line commented and below line added for this CRF PMG-CRF-16*/	
					  if(ref_md.equals("F") && loc_ind_flag.equals("")){
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
}
				}
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
String clinic_code1= request.getParameter("i_clinic_code");
            _bw.write(_wl_block51Bytes, _wl_block51);
String clinic_str="";
			if(callingMode.equals("OP")){
				clinic_str="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.clinic_code ='"+clinic_code1+"' and	a.facility_id ='"+fid+"' and a.language_id = '"+locale+"'";
			}else{
				clinic_str="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.facility_id ='"+fid+"' and a.language_id = '"+locale+"' and exists (select clinic_code from oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y' and facility_id = a.facility_id and clinic_code = a.clinic_code) order by long_desc";
				
			}
			rs=null;
			
			if(callingMode.equals("OP")){
				rs = stmt.executeQuery(clinic_str);

				if(rs !=null){
					while ( rs.next() )	{
						clinic_name= rs.getString("long_desc");
						clinic_id= rs.getString("clinic_code");							
						splty_code= rs.getString("speciality_code");							
						referesh_flag =false;							
					}					
				}
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(clinic_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);

					if(ref_md.equals("F")){
            _bw.write(_wl_block56Bytes, _wl_block56);
if (!ca_patient_id.equals("")){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
 //if (cnter==1){
                 		/*Above line commented and below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
						if (cnter>=1){
							rs = stmt.executeQuery(clinic_str);

							if(rs !=null){
							while ( rs.next() )	{
								ij++;
								clinic_name= rs.getString("long_desc");
								clinic_id= rs.getString("clinic_code");
								splty_code= rs.getString("speciality_code");
								if(! i_Clinic_code_sel.equals("N")){
									if(i_Clinic_code_sel.equals(clinic_id)){
										out.println("<option value='"+clinic_id+"&"+splty_code+"' selected>"+clinic_name);
										referesh_flag =false;
									}else{
										out.println("<option value='"+clinic_id+"&"+splty_code+"' >"+clinic_name);

									}
								}else{
									out.println("<option value='"+clinic_id+"&"+splty_code+"' >"+clinic_name);
								}
							}
							if(ij==0){
								no_sch_flag=true;
							}else{
								if(!i_Clinic_code_sel.equals("N")){
									referesh_flag =false;								
								}
							}
						}else{

							no_sch_flag=true;
						}
					}else{
						referesh_flag =false;
					}
				}else{
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

					clinic_str  ="select a.clinic_code, a.long_desc,a.speciality_code from op_clinic_lang_vw a where a.facility_id ='"+fid+"' and a.language_id ='"+locale+"' and exists (select clinic_code from oa_clinic_schedule where facility_id ='"+fid+"' and practitioner_id ='"+practitioner_id+"' and trunc(clinic_date) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y' and care_locn_type_ind='"+clinic_type+"' and facility_id = a.facility_id and clinic_code = a.clinic_code) order by long_desc " ;
					rs = stmt.executeQuery(clinic_str);

					 while(rs!=null && rs.next() ){
						if(clinic_code.equals(rs.getString("clinic_code"))){
							out.println("<option value='"+rs.getString("clinic_code")+"&"+rs.getString("speciality_code")+"' selected>"+rs.getString("long_desc"));
						}else{
							out.println("<option value='"+rs.getString("clinic_code")+"&"+rs.getString("speciality_code")+"' >"+rs.getString("long_desc"));
						}
					}
					referesh_flag =false;
				}
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(loc_ind_flag));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(change_sch));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(loc_ind_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(loc_ind_flag));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(change_sch));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(change_sch));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block71Bytes, _wl_block71);

 			try
 			{
				if(rs !=null) rs.close();
			
				String pract_str="";
				
				/*Below line modified for this CRF PMG-CRF-16*/ 
				if(res_type.equals("P")){
					pract_str="select practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_practitioner_lang_vw where  practitioner_id='"+practitioner_id+"' and language_id = '"+locale+"'";
				}else if(res_type.equals("R")){
					pract_str="select room_num Practitioner_id, long_desc practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_facility_room_lang_vw where Facility_id ='"+fid+"' and room_num='"+practitioner_id+"' and language_id = '"+locale+"' order by long_desc";

					//select Practitioner_id , practitioner_short_name practitioner_name description from op_pract_for_clinic_vw where clinic_code='"+clinic_code+"' and Facility_id ='"+fid+"' and resource_class='R' and Practitioner_id='"+practitioner_id+"' order by  practitioner_short_name
				}else{
				pract_str="select short_desc practitioner_name,to_char(sysdate,'dd/mm/yyyy') cur_date from am_resource_lang_vw where Facility_id='"+fid+"' and resource_id = '"+practitioner_id+"' and and language_id = '"+locale+"' order by a.short_desc";


				//	pract_str="select a.short_desc practitioner_name from am_resource a,op_pract_for_clinic b where a.resource_id =b.practitioner_id and a.resource_class= '"+res_type+"' and b.clinic_code='"+clinic_code+"' and a.Facility_id=b.facility_id and a.Facility_id='"+fid+"' and b.practitioner_id='"+practitioner_id+"' order by a.short_desc";
				}
				
				rs = stmt.executeQuery(pract_str);
				if(rs !=null){
					while ( rs.next() )
						{
							practitioner_name= rs.getString("practitioner_name");
							cur_date= rs.getString("cur_date");
						}
				}
							
					if(rs !=null) rs.close();

				if(practitioner_name==null) practitioner_name="";			
			
			if(rs !=null) rs.close();
		
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block75Bytes, _wl_block75);

				String my=month_display+","+yr_display;				
			
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(my));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(TotNum));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(old_alcn_catg_code));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(fid));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(INV_VISIT_MPQ_FROM_CA_YN));
            _bw.write(_wl_block102Bytes, _wl_block102);
for( int j=0;j<week.length;j++){
					String week1[]=new String[7];
						if(week[j].equals("SUN"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
		}else if(week[j].equals("MON"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
		}else if(week[j].equals("TUE"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
		}else if(week[j].equals("WED"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
		}else if(week[j].equals("THU"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
		}else if(week[j].equals("FRI"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
		}else if(week[j].equals("SAT"))
		{
			week1[j]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
		}
				
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(week1[j]));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
for( int j=0;j<ro;j++)
			{
			
			
            _bw.write(_wl_block106Bytes, _wl_block106);


				  	for(int k=0;k<ccols;k++)
				  	{
						
						if(k==1)
							{
						if(day_type1[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
						}

						if(k==2)
						{
						if(day_type2[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==3)
							{
						if(day_type3[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==4)
							{
						if(day_type4[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

								if(k==5)
							{
						if(day_type5[k].equals("W")){
						allow_click=true;
						}
						else{
						allow_click=false;
						}
							}

						if(act<NumOfDays.length)
				  		{
				  			if(!NumOfDays[act].equals("0"))
				  			{
				  				dat=NumOfDays[act];
				  				for(int i=0;i<Color_Code.length;i++)
				  				{
				  					if(Color_Code[i].equals(colors[act]))
				  						colorclass=Color_Val[i];
				  				}
				  			}
				  			else
				  			{
				  				if(rodup==(NumOfDays.length/7) && 	NumOfDays[act].equals("0"))
				  				{
				  					dat="&nbsp";
				  					break;
				  				}
				  				else{
				  					dat="&nbsp";
									
								}

				  			}
				  		}
				  		else{
				  			dat="&nbsp";
						}
						
				  			String anch=" ";
							//Below line added for this CRF PMG2013-CRF-0016 [IN:044523] 
				  			if(dat.length()<2)
				  				dat="0"+dat;
							
							/*Below line added for the incident [47524]*/
							String monofyesr=Integer.toString(mon);	
							if(monofyesr.length()<2)monofyesr="0"+monofyesr;							
							String title=dat+"/"+monofyesr+"/"+yr;
							//End 47524
							
				  			act++;
				  			if(!(colorclass==null || colorclass.equals("") || colorclass.equals("OABrown")) ){
							if (colorclass.equals("OARed")){
							anch=" <a href=javascript:callDisplayOAResultsblock('"+title+"') title='"+title+"'  >";
                            if(title.equals(cur_date)){ //Added for this CRF PMG2013-CRF-0016 [IN:044523] 
									cur_day_blocked_flag=true;
									curr_date_flag=title;
								}	
 							
							}else{
								anch=" <a  href=javascript:callDisplayOAResultsForOp('"+cliniccode+"','"+mon+"','"+yr+"','"+dat+"') title='"+title+"'  >";
								if(title.equals(cur_date)){ //Added for this CRF PMG2013-CRF-0016 [IN:044523] 
									cur_day_flag=true;
									cur_dat=dat;
								}
							}
							}
				  
					if(allow_click){
						if(colorclass.equals("OAHOLIDAY"))
						{
						
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block109Bytes, _wl_block109);

						}
					else
						{
						
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block109Bytes, _wl_block109);

						}
					}
					else{
					if(!(colorclass == null || colorclass.equals("")))
						{
                         if(colorclass.equals("OAHOLIDAY"))
							{
							
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block111Bytes, _wl_block111);

							}
							else							
							{
							
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(anch));
            out.print( String.valueOf(dat));
            _bw.write(_wl_block112Bytes, _wl_block112);

						}
						}
						else
						{
							
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colorclass));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block111Bytes, _wl_block111);

				  		}
					}
					colorclass="";	  	
						
					
					}

				  	
            _bw.write(_wl_block113Bytes, _wl_block113);
rodup++;
			}
            _bw.write(_wl_block114Bytes, _wl_block114);
if(INV_VISIT_MPQ_FROM_CA_YN.equals("Y") && ca_patient_id.equals("")){
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
}
		if(no_sch_flag){
            _bw.write(_wl_block117Bytes, _wl_block117);
}else{
			if (referesh_flag){
            _bw.write(_wl_block118Bytes, _wl_block118);

			}else{
				if(ref_md.equals("F")){
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
}	
			}
		}
		/*Below line added for this CRF PMG2013-CRF-0016 [IN:044523]*/
		if(cur_day_flag){
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(mon ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(yr));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(cur_dat));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
if(cur_day_blocked_flag && curr_date_flag!=""){
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(curr_date_flag));
            _bw.write(_wl_block125Bytes, _wl_block125);
}		
		//End this CRF PMG2013-CRF-0016 [IN:044523]
			if(rs !=null)		rs.close();
			if(rs1 !=null)      rs1.close();
			if(rs2 !=null)      rs2.close();
			if(rs !=null)		rs.close();
			if(stmt !=null)		stmt.close();
			if(stmt !=null)		stmt.close();
			if(stmt1 !=null)    stmt1.close();
			if(stmt !=null)		stmt.close();
				
}catch(Exception e)
{
	out.println("ERROR@2" +e);
	e.printStackTrace();
}finally
{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
			
            _bw.write(_wl_block126Bytes, _wl_block126);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ManageQueue.label", java.lang.String .class,"key"));
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
}
