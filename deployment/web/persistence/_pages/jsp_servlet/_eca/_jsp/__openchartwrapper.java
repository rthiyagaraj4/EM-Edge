package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCA.CAOpenChartServlet;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __openchartwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/OpenChartWrapper.jsp", 1743759275988L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\t\n\t  \n      <input type=\"hidden\" id=\"practitioner_id\"  name=\"practitioner_id\" id=\"practitioner_id\" value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'><!-- 32902  --> \n     \n      \n<html>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=javascript src=\'../../eCA/js/CAMenu.js\'></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\nasync function patClick()\n{\n\tvar patient_id = document.WrapperPatCriteriaFrm.patient_id.value;\n\tvar episode_id = document.WrapperPatCriteriaFrm.episode_id.value;\n\tvar episode_visit_id = document.WrapperPatCriteriaFrm.episode_visit_id.value;\n\tvar wname = patient_id + episode_id + episode_visit_id;\n\tvar AEStartConsult_flag =";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =";//Added for IN065070\n\tvar obj = \"\";\n\tvar tempVar = \"\";\n\tif(top.content!=null)\n\t\tobj = top.content.CommonToolbar;\n\t\n\tvar winNameStr = \"\";\n\tvar i = 0;\n\t\n\tvar result = \"T\";\n\tif(top.content!=null && top.content.CommonToolbar != null )\n\t{\t\t\n\t\tif(obj.pat_info != null)\n\t\t{\n\t\t\tvar pat_info_temp = [];\n\t\t\tvar j = 0;\n\t\t\tvar tempStr = \"\";\n\t\t\t\n\t\t\tfor(i=0;i<obj.pat_info.length;i++)\n\t\t\t{\n\t\t\t\tif(obj.pat_info[i].window_obj &&!obj.pat_info[i].window_obj.closed)\n\t\t\t\t{\t\n\t\t\t\t\tpat_info_temp[j++] = obj.pat_info[i];\n\t\t\t\t}\n\t\t\t}\n\t\t\tobj.pat_info = pat_info_temp;\t\n\t\t\ti = 0;\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\ttempStr = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\tif(wname == tempStr)\n\t\t\t\t{\n\t\t\t\t\tvar element =  obj.pat_info[";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="];\n\t\t\t\t\tif (typeof(element) != \'undefined\' && element != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(!obj.pat_info[";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="].window_obj.closed)\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tobj.pat_info[";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="].window_obj.focus();\n\t\t\t\t\t\t\tresult = \"F\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t}\n\t}\n\n\tif(result == \"T\")\n\t{\n\t\tvar episode_type = document.WrapperPatCriteriaFrm.episode_type.value;\n\t\tvar location_type = document.WrapperPatCriteriaFrm.location_type.value;\n\t\tvar location_code = document.WrapperPatCriteriaFrm.location_code.value;\n\t\tvar age = document.WrapperPatCriteriaFrm.age.value;\n\t\tvar sex = document.WrapperPatCriteriaFrm.sex.value;\n\t\tvar dob = document.WrapperPatCriteriaFrm.dob.value;\n\t\tvar room_num = document.WrapperPatCriteriaFrm.room_num.value;\n\t\tvar bed_num = document.WrapperPatCriteriaFrm.bed_num.value;\n\t\tvar patient_class = document.WrapperPatCriteriaFrm.patient_class.value;\n\t\tvar physician_id = document.WrapperPatCriteriaFrm.physician_id.value;\n\t\tvar discharge_date = document.WrapperPatCriteriaFrm.discharge_date.value;\n\t\tvar episode_Status = document.WrapperPatCriteriaFrm.episode_Status.value;\n\t\tvar visit_adm_date = document.WrapperPatCriteriaFrm.visit_adm_date.value;\n\t\tvar queue_status = document.WrapperPatCriteriaFrm.queue_status.value;\n\t\tvar consultDateTime = document.WrapperPatCriteriaFrm.consultDateTime.value;\n\t\tvar cons_srvc_start_date_time = document.WrapperPatCriteriaFrm.cons_srvc_start_date_time.value;//IN066859\n\t\t//IN034536 Start\n\t\tvar p_queue_date = document.WrapperPatCriteriaFrm.p_queue_date.value;\n\t\tvar isPatientEncMovement = document.WrapperPatCriteriaFrm.isPatientEncMovement.value;\n\t\tvar Sydate = document.WrapperPatCriteriaFrm.Sydate.value;\t\n\t\tvar curr_queue_status = document.WrapperPatCriteriaFrm.curr_queue_status.value; \n\t\t//IN034536 Ends\n\t\t//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081\n\t\tvar isPracApplicable = document.WrapperPatCriteriaFrm.isPracApplicable.value;\n\t\t//patient_class condition added by Dharma against GDOH-SCF-0250 [IN:063706] on 13th Mar 2017\n\t\tif(isPracApplicable==\"true\" && curr_queue_status < 04 && physician_id !=\"\" && patient_class==\"EM\"){\n\t\tphysician_id=\"\";\n\t\t}//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081\n\t\tif(episode_visit_id == null || episode_visit_id ==\'null\')\n\t\t\tepisode_visit_id = \'\';\n\t\n\t\tif((physician_id==null || physician_id==\'null\' || physician_id  == \"\") && episode_type == \"O\")\n\t\t{ \n\t\t\tif(self.document.WrapperPatCriteriaFrm.patient_class.value == \'EM\')\n\t\t\t{\t\n\t\t\t\t//IN042989 - Start\n\t\t\t\tvar actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;\n\t\t\t\tvar visit_status = document.WrapperPatCriteriaFrm.visit_status.value;\n\t\t\t\tvar patient_class = document.WrapperPatCriteriaFrm.patient_class.value;\n\t\t\t\tvar actionOnPendingBillfalg = false;\n\n\t\t\t\tif(actionOnPendingBill==\"N\")\n\t\t\t\t{\n\t\t\t\t\tactionOnPendingBillfalg = true;\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\t\t\tactionOnPendingBillfalg = OPQBlValidation();\t\n\t\t\t\t}\n\n\t\t\t\tif(actionOnPendingBillfalg)\n\t\t\t\t{\t\n\t\t\t\t\t//old code - Start\n\t\t\t\t\tvar features   = \'dialogHeight:700px; dialogWidth:1000px; dialogTop:150; status=no\';\n\t\t\t\t\tvar arguments  = \'\';\t\t\t\t\t\n\t\t\t\t\tvar queryString = \"option_id=AEMODAL&patient_id=\"+patient_id + \"&visit_id=\" + episode_visit_id + \"&episode_id=\" + episode_id + \"&encounter_id=\" + episode_id + \"&location_code=\" + location_code + \"&location_type=\" + location_type + \"&bed_no=\" + bed_num + \"&room_num=\" + room_num + \"&episode_type=\" + episode_type + \"&discharge_date=\" + discharge_date + \"&visit_adm_date=\" + visit_adm_date + \"&episode_Status=\" + episode_Status + \"&sex=\" + sex + \"&Age=\" + age + \"&Dob=\" + dob + \"&security_level=&protection_ind=&reln_req_yn=\" + self.document.WrapperPatCriteriaFrm.reln_req_yn.value + \"&patient_class=EM&PQ=Y&CA=Y&child_window=Y&practitioner_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&detail_fn=Y&fn=lower\";\t\t\n\t\t\t\t\t\n\t\t\t\t\tvar retValAE = await top.window.showModalDialog(\'../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=AssignTreatmentArea&\' + queryString ,arguments,features);\n\n\t\t\t\t\n\t\t\t\t\tif(retValAE == \'*ALL\')\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"ATTEND_PRACT_NOT_ASSIGNED\",\"CA\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tif(retValAE != null && retValAE != \'\')\n\t\t\t\t\t{ \n\t\t\t\t\t\t//IN065070 starts\n\t\t\t\t\t\t   //32902 start\n\t         \t           var practitioner_id=document.getElementById(\"practitioner_id\").value;\n\t         \t\t     \tvar facility_id \t= document.WrapperPatCriteriaFrm.facility_id.value;\n\t         \t        \tvar patientid = document.WrapperPatCriteriaFrm.patient_id.value;\n\t         \t         var xmlStr =\"<root><SEARCH \";\n\t\t\t\t\t\t xmlStr += \" p_action=\\\"IS_PAT_RESTRICTED\\\"\";\n\t\t\t\t\t\t xmlStr += \" facility_id=\\\"\"+ facility_id + \"\\\" \";\n\t\t\t\t\t\t xmlStr += \" patientid=\\\"\"+ patientid + \"\\\" \";\n\t\t\t\t\t\t xmlStr += \" practitioner_id=\\\"\"+ practitioner_id + \"\\\" \";\n\t\t\t\t\t\t xmlStr +=\" /></root>\";\n\t\t\t\t\t\t var temp_jsp=\"../../eCA/jsp/CAGetAcccessRightPatientDtl.jsp\";\n\t\t\t\t\t\t var xmlDoc = \"\";\n\t\t\t\t\t\t var xmlHttp =new XMLHttpRequest();;\n\t\t\t\t\t\t //xmlDoc.loadXML(xmlStr);\n\t\t\t\t\n\t\t\t\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t xmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t\t\t xmlHttp.send(xmlDoc);\n\t\t\t\t\t\t var responseText = xmlHttp.responseText;\n\t\t\t\t\t\t var response = trimString(xmlHttp.responseText);\n\t\t\t\t         if(response == \"Y\"){\n\t\t\t\t\t\t alert(getMessage(\"AC_RSTR_PAT_LMT_AUT\",\"CA\")); \n\t\t\t\t\t\t return;\n\t\t\t\t\t\t } \n\t\t\t\t         //32902  end\n\t\t\t\t\t\tif(AEStartConsult_flag)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\t\tvar dialogTop\t= \"150\";\n\t\t\t\t\t\t\tvar dialogHeight =\"400px\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"700px\" ;\n\t\t\t\t\t\t\tvar features\t= \"Width:\" + dialogWidth +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; dialogTop:\"+dialogTop +\"; scroll=no; status=no\";\n\t\t\t\t\t\t\tvar arguments\t= \"patChartCalledFrm=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\t\t//var returnVal = window.showModalDialog(\'../jsp/StartConsultationDialog.jsp?patChartCalledFrm=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&p_queue_date=\"+p_queue_date+\"&isPatientEncMovement=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Sydate=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',arguments,features); //Commented for IN065070\n\t\t\t\t\t\t\tvar returnVal = await window.showModalDialog(\'../../eCA/jsp/StartConsultationDialog.jsp?pat_class=AE&patChartCalledFrm=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',arguments,features); //Modified for IN065070\n\t\t\t\t\t\t\tvar patChartType = document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value;\n\t\t\t\t\t\t\tif(returnVal!= undefined)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturnArray = returnVal.split(\"#\");\n\t\t\t\t\t\t\t\tif(returnArray[1] == \'Yes\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar retVal\t\t= new String();\n\t\t\t\t\t\t\t\t\tvar dialogTop\t= \"\";\n\t\t\t\t\t\t\t\t\tvar dialogHeight= \"15\";                     \n\t\t\t\t\t\t\t\t\tvar dialogWidth = \"70\";\n\t\t\t\t\t\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\t\t\t\t\t\tvar scroll\t\t= \"no\";\n\t\t\t\t\t\t\t\t\tvar features    = \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\t\t\t\t\tvar arguments   = \"\";\n\t\t      \t\t\t\t\t\tvar parameters\t= \"p3=\"+episode_id+\"&module_id=AE&p2=\"+patient_id;\n\t\t\t\t\t\t\t\t\tvar action_url\t=\"../../eOP/jsp/CallConsStart.jsp?\"+parameters;  \n\t\t\t\t\t\t\t\t\tretVal = await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\t\tif(retVal == \"Y\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\twindow.location.href = window.location.href;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t\t\t}else if(retVal == undefined || retVal == null || retVal==\"N\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(returnArray[1] == \'No\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\n\t\t\t\t\t\t\t\tif(returnArray[0] == \'PCWOE\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'episode_id\').value=\'\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(returnVal == undefined || returnVal == null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//IN065070 Ends\n\t\t\t\t\t\tdocument.WrapperPatCriteriaFrm.physician_id.value = retValAE;\n\t\t\t\t\t\tdocument.WrapperPatCriteriaFrm.Opphysician_id.value = \'\' ;\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.insert_op.value = \'N\';\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t//IN045186 - to reload the result page to refresh the status change from AE and CA - Start\n\t\t\t\t\t\tif(top.content.workAreaFrame != null && top.content.workAreaFrame != undefined)\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tif(top.content.frames[3].frames[1].frames[0].name == \"AEMPSearchCriteriaFrame\")//IN045246\n\t\t\t\t\t\t\t\ttop.content.frames[3].frames[1].frames[2].location.reload();//IN045246\n\t\t\t\t\t\t\telse\t\n\t\t\t\t\t\t\t\ttop.content.workAreaFrame.PatResultFr.location.reload();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(top.content.frames[1].name == \"f_query_add_mod\")//IN045246\n\t\t\t\t\t\t\ttop.content.frames[1].frames[2].location.reload();\t//IN045246\t\n\t\t\t\t\t}else{\t\t\t\t\t\t\n\t\t\t\t\t\tif(top.content.frames[1].name == \"f_query_add_mod\")\n\t\t\t\t\t\t\ttop.content.frames[1].frames[2].location.reload();\n\t\t\t\t\t\telse if(top.content.frames[3].frames[1].frames[0].name == \"AEMPSearchCriteriaFrame\")//IN045246\n\t\t\t\t\t\t\ttop.content.frames[3].frames[1].frames[2].location.reload();//IN045246\n\t\t\t\t\t\telse\t\n\t\t\t\t\t\t\ttop.content.workAreaFrame.PatResultFr.location.reload();\t\n\t\t\t\t\t}\n\t\t\t\t\t//IN045186 - end\n\t\t\t\t\t//old code - End\n\t\t\t\t}else{\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\t//IN042989 - End\n\t\t\t}\n\t\t\telse if(self.document.WrapperPatCriteriaFrm.patient_class.value == \'OP\')\n\t\t\t{\t\n\t\t\t\tvar features   = \'dialogHeight:25; dialogWidth:45; dialogTop:180; status=no\';\n\t\t\t\tvar arguments  = \'\';\n\t\t\t\t//var queryString = \"practitioner_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&p3=\" + episode_id + \"&patient_id=\" + patient_id + \"&locn_type=\" + location_type + \"&locn_code=\" + location_code + \"&p16=\"+visit_adm_date+\"&module_id=CA&p10=A&visit_adm_date=\"+visit_adm_date + \"&p15=\" + escape(queue_status);//IN034536\n\t\t\t\tvar queryString = \"practitioner_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&p3=\" + episode_id + \"&patient_id=\" + patient_id + \"&locn_type=\" + location_type + \"&locn_code=\" + location_code + \"&p16=\"+visit_adm_date+\"&module_id=CA&p10=A&visit_adm_date=\"+visit_adm_date + \"&p15=\" + escape(queue_status)+\"&p1=\"+curr_queue_status+\"&isPatientEncMovement=\"+isPatientEncMovement+\"&Sydate=\"+Sydate;//IN034536\n\t\t\t\tvar a = confirm(getMessage(\"PAT_UNASSIGN\",\"CA\"));\n\t\t\t\tif (a)\n\t\t\t\t{\n\t\t\t\t\tvar retValOP = await window.showModalDialog(\"../../eOP/jsp/CallAssign.jsp?\" + queryString, arguments, features);\n\t\t\t\t\t\n\t\t\t\t\tif(retValOP != null && retValOP != \'\' && retValOP !=\'ok\')\n\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\tdocument.WrapperPatCriteriaFrm.physician_id.value = retValOP;\n\t\t\t\t\t\tdocument.WrapperPatCriteriaFrm.Opphysician_id.value =retValOP ;\t\t\t\t\t\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.insert_op.value = \'N\';\n\n\t\t\t\t\t\tif((document.WrapperPatCriteriaFrm.mngPatQueueYN.value == \'Y\' && \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' == \'OP\') ||(document.WrapperPatCriteriaFrm.CAPatListLocn.value == \'Y\' && \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' == \'\'))\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\t\tvar dialogTop\t= \"150\";\n\t\t\t\t\t\t\tvar dialogHeight =\"400px\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"700px\" ;\n\t\t\t\t\t\t\tvar features\t= \"Width:\" + dialogWidth +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; dialogTop:\"+dialogTop +\"; scroll=no; status=no\";\n\t\t\t\t\t\t\tvar arguments\t= \"patChartCalledFrm=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',arguments,features);//IN034536\n\t\t\t\t\t\t\t//var returnVal =  window.showModalDialog(\'../jsp/StartConsultationDialog.jsp?patChartCalledFrm=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',arguments,features);//IN034536//Commented for IN065070\n\t\t\t\t\t\t\tvar returnVal = await window.showModalDialog(\'../../eCA/jsp/StartConsultationDialog.jsp?pat_class=OP&patChartCalledFrm=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',arguments,features);//Modified for IN065070\n\t\t\t\t\t\t\tvar patChartType = document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(returnVal!= undefined)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturnArray = returnVal.split(\"#\");\n\t\t\t\t\t\t\t\tif(returnArray[1] == \'Yes\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'Y\';\n\t\t\t\t\t\t\t\telse if(returnArray[1] == \'No\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t\tif(returnArray[0] == \'PCWOE\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'episode_id\').value=\'\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(returnVal == undefined || returnVal == null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}//IN033233 Starts\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t\t}//IN033233 Ends\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\n\t\t\t\talert(getMessage(\"TRD_PTN_NO_PRACT\",\'CA\'));\t\t\t\n\t\t\t\tvar queryString = \"option_id=AE_ASSIGN_DA1&patient_id=\"+patient_id + \"&visit_id=\" + episode_visit_id + \"&episode_id=\" + episode_id + \"&encounter_id=\" + episode_id + \"&location_code=\" + location_code + \"&location_type=\" + location_type + \"&bed_no=\" + bed_num + \"&room_num=\" + room_num + \"&episode_type=\" + episode_type + \"&discharge_date=\" + discharge_date + \"&visit_adm_date=\" + visit_adm_date + \"&episode_Status=\" + episode_Status + \"&sex=\" + sex + \"&Age=\" + age + \"&Dob=\" + dob + \"&security_level=&protection_ind=&reln_req_yn=\" + self.document.WrapperPatCriteriaFrm.reln_req_yn.value + \"&patient_class=EM&PQ=Y&CA=Y&child_window=Y&practitioner_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&detail_fn=Y&fn=lower&";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\n\t\t\t\t\n\t\t\t\tvar action_url = \'../../eCA/jsp/OpenChartWrapperPatListGetValues.jsp?\' + queryString;\t\t\t\t\t\n\t\t\t\tvar htmlVal = \"<html><head><link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' type=\'text/css\'></link></head>\"+\n\t\t\t\t\"<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'><form name=\'form1\' method=\'post\' action=\'\"+action_url+\"\' OnMouseDown=\'CodeArrest()\' OnKeyDown=\'disableKeys()\'>\"+\t\t\t\n\t\t\t\t \"</form></body></html>\";\n\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',htmlVal);\t\t\t\t\n\t\t\t\ttop.content.messageFrame.document.form1.submit();\n\t\t\t}\n\t\t}\n\t\telse if(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' == \"N\")\n\t\t{\n\t\t\tvar practId = self.document.WrapperPatCriteriaFrm.practId_yn.value;\n\t\t\t//IN048704 Starts\n\t\t\tvar assign_confirm_referral_yn  = self.document.WrapperPatCriteriaFrm.assign_confirm_referral_yn.value;\n\t\t\tif(practId == \'Y\')\n\t\t\t{\n\t\t\t\tif(assign_confirm_referral_yn == \"Y\")\n\t\t\t\t{\t\n\t\t\t\t\tvar dialogTop\t= \"150\";\n\t\t\t\t\tvar dialogHeight =\"7\" ;\n\t\t\t\t\tvar dialogWidth = \"20\" ;\n\t\t\t\t\tvar features\t= \"Width:\" + dialogWidth +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; dialogTop:\"+dialogTop +\"; scroll=no; status=no\";\n\t\t\t\t\t\n\t\t\t\t\tvar returnVal = await window.showModalDialog(\'../../eCA/jsp/AssignAndConfirmDialog.jsp\',arguments,features);\n\t\t\t\t\tvar arguments  = \'\';\n\t\t\t\t\tif(returnVal==\'A\')\n\t\t\t\t\t{\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t\t//top.content.workAreaFrame.PatResultFr.location.reload();\n\t\t\t\t\t}\n\t\t\t\t\telse if(returnVal == \'AC\')\n\t\t\t\t\t{\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.assignorConfirmKey.value = returnVal;\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t\t//top.content.workAreaFrame.PatResultFr.location.reload();\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\tvar a = confirm(getMessage(\"PAT_UNASSIGN\",\"CA\"));\n\t\t\t\t\tif(a)\n\t\t\t\t\t{\n\t\t\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//IN048704 Ends\n\t\t\t}\n\t\t\telse\n\t\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tself.document.WrapperPatCriteriaFrm.insert_op.value = \'N\';\n\t\t\t//[IN042884] Start.\n\t\t\tvar actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;\n\t\t\tvar visit_status = document.WrapperPatCriteriaFrm.visit_status.value;\n\t\t\tvar patient_class = document.WrapperPatCriteriaFrm.patient_class.value;\n\t\t\tvar actionOnPendingBillfalg = false;\n\t\t\tif(actionOnPendingBill==\"N\" || parseInt(visit_status) >=4 || patient_class!=\"OP\"){\n\t\t\t\tactionOnPendingBillfalg = true;\n\t\t\t}else{\t\t\t\t\n\t\t\t\tactionOnPendingBillfalg = OPQBlValidation();\t\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\tif(actionOnPendingBillfalg){\t\n\t\t\t//[IN042884] End.\n\t\t\t\tif((document.WrapperPatCriteriaFrm.mngPatQueueYN.value == \'Y\' && \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' == \'\'))\n\t\t\t\t{\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(patient_class == \'OP\' && consultDateTime == \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\t\t\tvar dialogTop\t= \"150\";\n\t\t\t\t\t\t\t\tvar dialogHeight =\"5\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth = \"23\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"Width:\" + dialogWidth +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; dialogTop:\"+dialogTop +\"; scroll=no; status=no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"patChartCalledFrm=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\t//var returnVal = window.showModalDialog(\'../jsp/StartConsultationDialog.jsp?patChartCalledFrm=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',arguments,features);//IN034536\n\t\t\t\t\t\t\t\t//var returnVal = window.showModalDialog(\'../jsp/StartConsultationDialog.jsp?patChartCalledFrm=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',arguments,features);//IN034536   //Commented for IN065070\n\t\t\t\t\t\t\t\tvar returnVal = await window.showModalDialog(\'../../eCA/jsp/StartConsultationDialog.jsp?pat_class=OP&patChartCalledFrm=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',arguments,features);//IN034536   //Modified for IN065070\n\t\t\t\t\t\t\t\tvar patChartType = document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value;\n\n\t\t\t\t\t\t\t\tif(returnVal!= undefined)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\treturnArray = returnVal.split(\"#\");\n\t\t\t\t\t\t\t\t\tif(returnArray[1] == \'Yes\')\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'Y\';\n\t\t\t\t\t\t\t\t\telse if(returnArray[1] == \'No\')\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t\t\tif(returnArray[0] == \'PCWOE\')\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'episode_id\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(returnVal == undefined || returnVal == null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//IN065070 starts\n\t\t\t\t//if(AEStartConsult_flag && patient_class == \'EM\' &&  curr_queue_status != \"04\")//Commented for IN066859\n\t\t\t\tif(AEStartConsult_flag && patient_class == \'EM\' &&  curr_queue_status < 04 && cons_srvc_start_date_time ==\"\")//Modified for IN066859\n\t\t\t\t{\n\t\t\t\t\tif((document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == \'Y\' && \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' == \'AE\') ||(document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == \'Y\' && \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' == \'\'))\n\t\t\t\t\t{\n\t\t\t\t\t\t\tvar retVal;\n\t\t\t\t\t\t\tvar dialogTop\t= \"150\";\n\t\t\t\t\t\t\tvar dialogHeight =\"5\" ;\n\t\t\t\t\t\t\tvar dialogWidth = \"23\" ;\n\t\t\t\t\t\t\tvar features\t= \"Width:\" + dialogWidth +\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; dialogTop:\"+dialogTop +\"; scroll=no; status=no\";\n\t\t\t\t\t\t\tvar arguments\t= \"patChartCalledFrm=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\t\t\tvar returnVal = await window.showModalDialog(\'../../eCA/jsp/StartConsultationDialog.jsp?pat_class=AE&patChartCalledFrm=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',arguments,features);\n\t\t\t\t\t\t\tvar patChartType = document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value;\n\t\t\t\t\t\t\tif(returnVal!= undefined)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturnArray = returnVal.split(\"#\");\n\t\t\t\t\t\t\t\tif(returnArray[1] == \'Yes\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar retVal\t\t= new String();\n\t\t\t\t\t\t\t\t\tvar dialogTop\t= \"\";\n\t\t\t\t\t\t\t\t\tvar dialogHeight= \"15\";                     \n\t\t\t\t\t\t\t\t\tvar dialogWidth = \"70\";\n\t\t\t\t\t\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\t\t\t\t\t\tvar scroll\t\t= \"no\";\n\t\t\t\t\t\t\t\t\tvar features    = \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\t\t\t\t\tvar arguments   = \"\";\n\t\t      \t\t\t\t\t\tvar parameters\t= \"p3=\"+episode_id+\"&module_id=AE&p2=\"+patient_id;\n\t\n\t\t\t\t\t\t\t\t\tvar action_url\t=\"../../eOP/jsp/CallConsStart.jsp?\"+parameters;  \n\n\t\t\t\t\t\t\t\t\tretVal = await window.showModalDialog(action_url,arguments,features);\n\t\n\t\t\t\t\t\t\t\t\tif(retVal == \"Y\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\twindow.location.href = window.location.href;\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t\t\t}else if(retVal == undefined || retVal == null || retVal==\"N\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse if(returnArray[1] == \'No\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(returnArray[0] == \'PCWOE\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'episode_id\').value=\'\';\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(returnVal == undefined || returnVal == null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t}\n\n\n\t\t\t\t\t}else if((document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == \'N\' || document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == \'\'  && \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' == \'AE\') ||(document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == \'N\' || document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == \'\' && \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' == \'\'))\n\t\t\t\t\t{\n\t\t\t\t\t\t\tvar retVal\t\t= new String();\n\t\t\t\t\t\t\tvar dialogTop\t= \"\";\n\t\t\t\t\t\t\tvar dialogHeight= \"15\";                     \n\t\t\t\t\t\t\tvar dialogWidth = \"70\";\n\t\t\t\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\t\t\t\tvar scroll\t\t= \"no\";\n\t\t\t\t\t\t\tvar features    = \"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\t\t\tvar arguments   = \"\";\n\t\t      \t\t\t\tvar parameters\t= \"p3=\"+episode_id+\"&module_id=AE&p2=\"+patient_id;\n\t\n\t\t\t\t\t\t\tvar action_url\t=\"../../eOP/jsp/CallConsStart.jsp?\"+parameters;  \n\n\t\t\t\t\t\t\tretVal = await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\tif(retVal == \"Y\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\twindow.location.href = window.location.href;\n\t\t\t\t\t\t\t\tdocument.getElementById(\'startConsYN\').value=\'N\';\n\t\t\t\t\t\t\t}else if(retVal == undefined || retVal == null || retVal==\"N\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\n\t\t\t\t}\n\t\t\t\t//IN065070 Ends\n\t\t\t//[IN042884] Start.\t\n\t\t\t}else{\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t//[IN042884] End.\n\t\t\tself.document.WrapperPatCriteriaFrm.submit();\n\t\t\t\n\t\t\t//IN065070\n\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' == \'AE\')\n\t\t\t\t{\n\t\t\t\t\tif(top.content.frames[1].frames[0] != null && top.content.frames[1].frames[0] != undefined)\n\t\t\t\t\t{\t\n\t\t\t\t\t\tif(top.content.frames[1].frames[0].name == \"AEMPSearchCriteriaFrame\"){\n\t\t\t\t\t\t\t//top.content.frames[1].frames[1].location.reload();//Commented for IN068016\n\t\t\t\t\t\t\ttop.content.frames[1].frames[1].location.href = top.content.frames[1].frames[1].location.href;//Modified for IN068016\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t//IN065070\n\t\t}\n\t}\n}\n//[IN042884] Start.\nfunction OPQBlValidation(){\n\n\t\n\t\tvar facility_id \t= document.WrapperPatCriteriaFrm.facility_id.value;\n\t\tvar patient_id = document.WrapperPatCriteriaFrm.patient_id.value;\n\t\tvar visit_id\t\t= document.WrapperPatCriteriaFrm.visit_id.value;\n\t\tvar episode_id_new\t= document.WrapperPatCriteriaFrm.episode_id_new.value;\n\t\tvar actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;\t\n\t\t//IN042989 - Start\n\t\tvar patient_class = document.WrapperPatCriteriaFrm.patient_class.value;\n\t\tvar episode_type = \"O\";\n\t\t\n\t\tif(patient_class == \"EM\")\n\t\t\tepisode_type = \"E\";\n\t\t//IN042989 - End\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr+=\" facility_id=\\\"\"+facility_id+\"\\\" \";\n\t\txmlStr+=\" p_patient_id=\\\"\"+patient_id+\"\\\"\";\n\t\txmlStr+=\" p_episode_type=\\\"\"+episode_type+\"\\\" \";\n\t\txmlStr+=\" p_episode_id=\\\"\"+episode_id_new+\"\\\"\";\n\t\txmlStr+=\" p_visit_id=\\\"\"+visit_id+\"\\\" \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\n\t\tvar url = \"../../eCA/jsp/CABLValidation.jsp\";\n\t\txmlHttp.open(\"POST\", url, false);\n\t\txmlHttp.setRequestHeader(\"Content-type\" ,\"application/x-www-form-urlencoded\");\n\t\txmlHttp.send(xmlDoc);\t\n\t\t\n\t\tvar unbilledArr = trim(xmlHttp.responseText).split(\"|\");\n\t\tvar p_unbilled_amt\t= parseInt(unbilledArr[0]);\n\t\tvar p_unsettled_amt\t= parseInt(unbilledArr[1]);\t\n\t\tif(p_unbilled_amt==0 && p_unsettled_amt==0){\n\t\t\tactionOnPendingBillfalg = true;\n\t\t}else{\n\t\t\tif(actionOnPendingBill==\'W\'){\n\t\t\t\tif(confirm(getMessage(\"UNSETTLED_UNBILLED_AMT_WARNING\",\"OP\"))){\n\t\t\t\t\tactionOnPendingBillfalg = true;\n\t\t\t\t}else\n\t\t\t\t\tactionOnPendingBillfalg = false;//IN045246\n\t\t\t}else{\n\t\t\t\talert(getMessage(\"UNSETTLED_UNBILLED_AMT_STOP\",\"OP\"));\n\t\t\t\tactionOnPendingBillfalg = false;\n\t\t\t}\n\t\t}\n\t\n\treturn actionOnPendingBillfalg;\n}\n\nfunction trim(str) {\n        return str.replace(/^\\s+|\\s+$/g,\"\");\n}\n//[IN042884] End.\n</SCRIPT>\n<BODY CLASS=\"MESSAGE\"  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'WrapperPatCriteriaFrm\' id=\'WrapperPatCriteriaFrm\' action=\'../../servlet/eCA.CAOpenChartServlet\' method = \'post\'  >\n\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"\">\n\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"\">\n\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"\">\n\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"\">\t\t\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"\">\n\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\" value=\"\">\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"\">\n\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"\">\n\t<input type=\"hidden\" name=\"physician_id\" id=\"physician_id\" value=\"\">\n\t<input type=\"hidden\" name=\"episode_Status\" id=\"episode_Status\" value=\"\">\n\t<input type=\"hidden\" name=\"discharge_date\" id=\"discharge_date\" value=\"\">\n\t<input type=\"hidden\" name=\"episode_visit_id\" id=\"episode_visit_id\" value=\"\">      \n\t<input type=\"hidden\" name=\"pline\" id=\"pline\" value=\"\">\n\t<input type=\"hidden\" name=\"security_level\" id=\"security_level\" value=\"\">\n\t<input type=\"hidden\" name=\"protection_ind\" id=\"protection_ind\" value=\"\">        \n\t<input type=\"hidden\" name=\"Opphysician_id\" id=\"Opphysician_id\" value=\"\">\n\t<input type=\"hidden\" name=\"reln_req_yn\" id=\"reln_req_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"attending_doc\" id=\"attending_doc\" value=\"\">\n\t<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">        \n\t<input type=\"hidden\" name=\"medical_team\" id=\"medical_team\" value=\"\">\n\t<input type=\"hidden\" name=\"queue_status\" id=\"queue_status\" value=\"\">\n\t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"\">\n\t<input type=\"hidden\" name=\"reln_reqYn\" id=\"reln_reqYn\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"reln_Yn\" id=\"reln_Yn\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"from_service_yn\" id=\"from_service_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"called_function_id\" id=\"called_function_id\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"accession_number\" id=\"accession_number\"\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"accession_type\" id=\"accession_type\"\t\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"unAssigned_yn\" id=\"unAssigned_yn\"\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"referral_id\" id=\"referral_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"fromNewFunction\" id=\"fromNewFunction\"\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"practId_yn\" id=\"practId_yn\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"ConsOrdChartYn\" id=\"ConsOrdChartYn\"\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"startConsYN\" id=\"startConsYN\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"consultDateTime\" id=\"consultDateTime\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"mngPatQueueYN\" id=\"mngPatQueueYN\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"CAPatListLocn\" id=\"CAPatListLocn\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"CA_PATLIST_BY_LOCN_CHART_TYPE\" id=\"CA_PATLIST_BY_LOCN_CHART_TYPE\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"MNG_PAT_QUEUE_CHART_TYPE\" id=\"MNG_PAT_QUEUE_CHART_TYPE\"\tvalue=\"\">\n\t<!--IN065070-->\n\t<input name=\'AE_CURR_EMR_PATIENT\' id=\'AE_CURR_EMR_PATIENT\' type=\'hidden\' value=\'\'/>\n\t<input name=\'AE_CURR_EMR_PATIENT_CHART_TYPE\' id=\'AE_CURR_EMR_PATIENT_CHART_TYPE\' type=\'hidden\' value=\'\'/>\n\t<input name=\'AE_CA_PATLIST_BY_LOCN\' id=\'AE_CA_PATLIST_BY_LOCN\' type=\'hidden\' value=\'\'/>\n\t<input name=\'AE_PATLIST_BY_LOCN_CHART_TYPE\' id=\'AE_PATLIST_BY_LOCN_CHART_TYPE\' type=\'hidden\' value=\'\'/>\n\t<!--IN065070-->\n\t<input type=\"hidden\" name=\"patChartCalledFrm\" id=\"patChartCalledFrm\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">  <!-- IN038776-->\n\t<!--  [IN042884] Start.-->\n\t<input type=\"hidden\" name=\"actionOnPendingBill\" id=\"actionOnPendingBill\"\tvalue=\"\">\t\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"\"> \n\t<input type=\"hidden\" name=\"episode_id_new\" id=\"episode_id_new\"\tvalue=\"\">\n\t<input type=\"hidden\" name=\"visit_status\" id=\"visit_status\"\tvalue=\"\">\n\t<!--  [IN042884] End.-->\n\t<!--IN034536 Starts-->\n\t<input type=\"hidden\" name=\"isPatientEncMovement\" id=\"isPatientEncMovement\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n\t<input type=\"hidden\" name=\"p_queue_date\" id=\"p_queue_date\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\"hidden\" name=\"cons_srvc_start_date_time\" id=\"cons_srvc_start_date_time\" value=\"\" ><!--IN066859-->\n\t<input type=\"hidden\" name=\"Sydate\" id=\"Sydate\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t<input type=\"hidden\" name=\"curr_queue_status\" id=\"curr_queue_status\" value=\"\">\n\t<!--IN034536 Ends -->\n\t<input type=\"hidden\" name=\"assign_confirm_referral_yn\" id=\"assign_confirm_referral_yn\" value=\"\"><!-- //IN048704-->\n\t<input type=\"hidden\" name=\"assignorConfirmKey\" id=\"assignorConfirmKey\" value=\"\"><!-- //IN048704-->\n\n\t<input type=\"hidden\" name=\"isPracApplicable\" id=\"isPracApplicable\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"><!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->\n</form>\n</BODY>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<script>\n\t\tdocument.WrapperPatCriteriaFrm.practId_yn.value = \'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\';\n\t</script>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t<script>\n\t\tdocument.WrapperPatCriteriaFrm.actionOnPendingBill.value = \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';\n\t\tdocument.WrapperPatCriteriaFrm.facility_id.value = \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\';\n\t</script>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<script>\n\t\t\tdocument.WrapperPatCriteriaFrm.actionOnPendingBill.value = \'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\tdocument.WrapperPatCriteriaFrm.facility_id.value = \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n</HEAD>\n</HTML>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n<SCRIPT LANGUAGE=\"JavaScript\">patClick();</SCRIPT>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
01/11/2011    	IN29355        		Menaka      Manage Specimen>New List
												System not allow to record new list if orders were placed from Place Order function
25/01/2012	  	IN030563 & 			Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the
				IN030566						Patient chart is not closed.												
14/06/2012	  	IN033233			Menaka V	Patient chart does not open when selecting unassigned consultation patient from By location
												function.	
13/06/2013		IN038776			Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes		
29/08/2013		IN042884			Ramesh G    A Validations on Doctor Consultation should not start if there are Unbilled and unsettled for the current encounter.
06/11/2013		IN042989			Chowminya   MMS-QH-CRF-0126.3 AE Parameter to check unbilled/unsettled amounts when opening up patient chart in CA
25/11/2013		IN045186			Chowminya   MMS-QH-CRF-0126.3 - linked_AE/CA pages reload issue 
27/11/2013		IN045246			Chowminya   MMS-QH-CRF-0126.3 - linked_Patient List By Bed/Bay Chart>System throws the warning message twice		
03/12/2013		IN045375			Chowminya   MMS-QH-CRF-0126.3 - linked_System overlaps OP Parameter settings and reflects AE Parameter settings	
16/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133	
06/04/2015		IN048704		Nijitha S 		HSA-CRF-0175	
13/04/2015		IN054965			Nijitha						HSA-CRF-0175
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
05/03/2018		IN066859	Raja S		05/03/2018		Ramesh G			ML-MMOH-SCF-0948
25/06/2018		IN068016	Thamizh		26/06/2018							ML-MMOH-SCF-1028
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Connection  con = null;//IN034536
	Connection  con = ConnectionManager.getConnection(request);//IN034536
	ResultSet rs = null;
	PreparedStatement stmt = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	String locale = (String) p.getProperty("LOCALE");
	String practitioner_id		= checkForNull((String)session.getValue("ca_practitioner_id"));
	String from_service_yn		= checkForNull(request.getParameter("from_service_yn"));
	String from_module			= checkForNull(request.getParameter("from_module"));
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String accession_number		= checkForNull(request.getParameter("accession_number"));
	String accession_type		= checkForNull(request.getParameter("accession_type"));
	String called_function_id	= checkForNull(request.getParameter("called_function_id"));
	String strRelnReqYn			= checkForNull(request.getParameter("reln_ReqYn"));
	String strRelnYn			= checkForNull(request.getParameter("reln_Yn"));
	String patChartCalledFrm	= checkForNull(request.getParameter("patChartCalledFrm"));
	//IN034536 Starts
	String p_queue_date	= checkForNull(request.getParameter("p_queue_date"));
	String isPatientEncMovement	= checkForNull(request.getParameter("isPatientEncMovement"));
	
	boolean isPatMovement = false;
	if("".equals(isPatientEncMovement))
	{
		
		isPatMovement=eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT");	
		
		isPatientEncMovement=Boolean.toString(isPatMovement);
	}
	String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	if("".equals(Sydate))
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Sydate = dateFormat.format(cal.getTime());
		
	}
	//IN034536 Ends
	String patient_class		= "";
	String actionOnPendingBill	= ""; //[IN042884]
	//[IN030566] Starts

	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	Boolean isPracApplicable	= eOP.QMSInterface.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE"); 
	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	try{			
		if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
			HashMap mHash = new HashMap();
			mHash = (HashMap) session.getAttribute("TEMP_PASS");
			if(mHash.containsKey(patient_id)){
				mHash.remove(patient_id);
			}
			session.setAttribute("TEMP_PASS",mHash);
		}
	}catch(Exception ee)
	{	
		out.println("Exception in OpenChartWrapper.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
		ee.printStackTrace();
	}
	//[IN030566] Ends
	String loginUser			= checkForNull((String)session.getValue("login_user"));	
	String episode_id			= checkForNull(request.getParameter("encounter_id"));
		
	if(episode_id.equals("") )
		episode_id				=	checkForNull(request.getParameter("episode_id"));

	if(episode_id==null||episode_id.equals("null"))
	episode_id="";
	patient_class				= (from_module.equals("AE")?"EM":checkForNull(request.getParameter("patient_class")));
	
	String unAssigned_yn = request.getParameter("unAssigned_yn") == null ? "Y" : request.getParameter("unAssigned_yn");
	String fromNewFunction = request.getParameter("fromNewFunction") == null ? "N" : request.getParameter("fromNewFunction");
	String referral_id = request.getParameter("referral_id") == null ? "" : request.getParameter("referral_id");
	String ConsOrdChartYn = request.getParameter("ConsOrdChartYn") == null ? "N" : request.getParameter("ConsOrdChartYn");
	String practId_yn = "";
	//IN065070 Starts
	boolean isAEStartConsulation = false;
	isAEStartConsulation=CommonBean.isSiteSpecific(con,"AE","AE_START_CONSULTATION");	
	//IN065070 Ends

	HashMap sessionMainMap = new HashMap();
	ArrayList sessList = new ArrayList();
	
	try
	{	
		if(strRelnReqYn.equals("Y") )
		{
			if(strRelnYn.equals("Y"))
			{
				sessionMainMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					
				if(sessionMainMap == null || sessionMainMap.size() == 0)
					session.setAttribute("sessionMainMap"+session.getId(),new HashMap());

				sessList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

				if(sessList == null || sessList.size() == 0)
					session.setAttribute("sessionList"+session.getId(),new ArrayList());
			}
		}
		else
		{
				sessionMainMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					
				if(sessionMainMap == null || sessionMainMap.size() == 0)
					session.setAttribute("sessionMainMap"+session.getId(),new HashMap());

				sessList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

				if(sessList == null || sessList.size() == 0)
					session.setAttribute("sessionList"+session.getId(),new ArrayList());
		}
	
	}
	
	catch(Exception ee)
	{
		
		out.println("Exception 1 in OpenChartWrapper.jsp -- "+ee.toString()+"--");
		ee.printStackTrace();
	}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(isAEStartConsulation));
            _bw.write(_wl_block8Bytes, _wl_block8);

			for(int i=0; i< sessList.size();i++){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sessList.get(i)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(unAssigned_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(from_module));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strRelnReqYn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strRelnYn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(from_service_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(accession_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(unAssigned_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fromNewFunction));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ConsOrdChartYn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(isPracApplicable));
            _bw.write(_wl_block59Bytes, _wl_block59);

try
{	

	String facility_id			= checkForNull((String)session.getValue("facility_id"));

	String queue_status = "";
	String establish_reln_req_yn="";
	String ses_pract_id="";
	String ses_pract_name="";
	String ses_pract_type="";

	//con = ConnectionManager.getConnection(request);//IN034536
	out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script><script language='JavaScript'>");
	
	session.putValue("ca_patient_class",patient_class);  //[IN038776]
	if((patient_class.equals("OP") || patient_class.equals("EM")) && !episode_id.equals("") )
	{
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'C' LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";
		//[IN042884] String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//Modified by Menaka for issue IN29355
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//[IN042884]//IN034536
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date,(SELECT TO_CHAR(QUEUE_DATE, 'dd/mm/yyyy') QUEUE_DATE FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//[IN042884]//IN034536//Commented for IN066859
		String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date,(SELECT TO_CHAR(QUEUE_DATE, 'dd/mm/yyyy') QUEUE_DATE FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_date,(SELECT TO_CHAR(CONS_SRVC_START_DATE_TIME, 'dd/mm/yyyy') CONS_SRVC_START_DATE_TIME FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID) cons_srvc_start_date_time from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//Modified for IN066859
		stmt = con.prepareStatement(query);
		stmt.setString(1, facility_id);
		stmt.setString(2, episode_id);
		rs = stmt.executeQuery();

		if (rs.next())
		{	
				if(queue_status.equals ("01"))
				{				
					queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
				}	

				else if(queue_status.equals("02"))
				{
				queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
				}	

				else if(queue_status.equals("03"))
				{
					queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
				
				}
				else if(queue_status.equals("04"))
				{
				
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
				}	

				else if(queue_status.equals("05"))
				{
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
				}
				else if(queue_status.equals("06"))
				{
				queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
				}	
			out.println("document.WrapperPatCriteriaFrm.visit_adm_date.value='" + checkForNull(rs.getString("ADM_VISIT_DATE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_type.value='" + checkForNull(rs.getString("EPISODE_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id.value='" + checkForNull(rs.getString("EPISODE_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + checkForNull(rs.getString("PATIENT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='" + checkForNull(rs.getString("PATIENT_CLASS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_type.value='" + checkForNull(rs.getString("LOCN_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_code.value='" + checkForNull(rs.getString("LOCN_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.room_num.value='" + checkForNull(rs.getString("ROOM_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.bed_num.value='" + checkForNull(rs.getString("BED_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.physician_id.value='" + checkForNull(rs.getString("PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.Opphysician_id.value='" + checkForNull(rs.getString("ACTUAL_PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.discharge_date.value='" + checkForNull(rs.getString("DISCHARGE_DATE_TIME")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='" + checkForNull(rs.getString("VISIT_EPISODE_STATUS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("DOB")) + "';");
			out.println("document.WrapperPatCriteriaFrm.visit_id.value='" + checkForNull(rs.getString("VISIT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='" + checkForNull(rs.getString("UNASSIGN_PATIENT_YN")) + "';");
			out.println("document.WrapperPatCriteriaFrm.queue_status.value='" + checkForNull(queue_status) + "';");
			out.println("document.WrapperPatCriteriaFrm.specialty_code.value='" + checkForNull(rs.getString("SPECIALTY_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.consultDateTime.value='" + checkForNull(rs.getString("visit_status_set_on_date")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id_new.value='" + checkForNull(rs.getString("EPISODE_ID_NEW")) + "';"); //[IN042884]
			out.println("document.WrapperPatCriteriaFrm.visit_status.value='" + checkForNull(rs.getString("VISIT_STATUS")) + "';"); //[IN042884]
			out.println("document.WrapperPatCriteriaFrm.p_queue_date.value='" + checkForNull(rs.getString("queue_date")) + "';"); //IN034536
			out.println("document.WrapperPatCriteriaFrm.curr_queue_status.value='" + checkForNull(rs.getString("QUEUE_STATUS")) + "';"); //IN034536
			out.println("document.WrapperPatCriteriaFrm.cons_srvc_start_date_time.value='" + checkForNull(rs.getString("cons_srvc_start_date_time")) + "';"); //IN066859
			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		
		//starts,DineshT,32881 
		//query = "select ca_patlist_by_locn,mng_pat_queue,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE from ca_cons_param";//commented for IN065070
		query = "select ca_patlist_by_locn,mng_pat_queue,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE from ca_cons_param";//Modified for IN065070
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();

		if(rs.next())
		{
			out.println("document.WrapperPatCriteriaFrm.mngPatQueueYN.value='" + checkForNull(rs.getString("mng_pat_queue")) + "';");
			out.println("document.WrapperPatCriteriaFrm.CAPatListLocn.value='" + checkForNull(rs.getString("ca_patlist_by_locn")) + "';");
			out.println("document.WrapperPatCriteriaFrm.CA_PATLIST_BY_LOCN_CHART_TYPE.value='" + checkForNull(rs.getString("CA_PATLIST_BY_LOCN_CHART_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.MNG_PAT_QUEUE_CHART_TYPE.value='" + checkForNull(rs.getString("MNG_PAT_QUEUE_CHART_TYPE")) + "';");
			//IN065070 changes starts
			out.println("document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value='" + checkForNull(rs.getString("AE_CURR_EMR_PATIENT")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT_CHART_TYPE.value='" + checkForNull(rs.getString("AE_CURR_EMR_PATIENT_CHART_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value='" + checkForNull(rs.getString("AE_CA_PATLIST_BY_LOCN")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_PATLIST_BY_LOCN_CHART_TYPE.value='" + checkForNull(rs.getString("AE_PATLIST_BY_LOCN_CHART_TYPE")) + "';");
			//IN065070 changes ends
		}

		if(rs != null) 
			rs.close();
		if(stmt != null) 
			stmt.close();
		//ends,DineshT,32881 	
	}
	else if((patient_class.equals("IP") || patient_class.equals("DC")) && !episode_id.equals(""))
	{
		//String query =  " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADMISSION_DATE_TIME, get_age(b.DATE_OF_BIRTH) AGE, to_char(b.DATE_OF_BIRTH,'dd/mm/yyyy') DOB, B.SEX, 'I' EPISODE_TYPE, A.EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'W'  LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE  CUR_WARD_CODE, A.ASSIGN_ROOM_NUM CUR_ROOM_NUM, A.ASSIGN_BED_NUM CUR_BED_NUM, A.ATTEND_PRACTITIONER_ID CUR_PHYSICIAN_ID, A.ADT_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.SPECIALTY_CODE,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID   ";
		String query =  " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADMISSION_DATE_TIME, get_age(b.DATE_OF_BIRTH) AGE, to_char(b.DATE_OF_BIRTH,'dd/mm/yyyy') DOB, B.SEX, 'I' EPISODE_TYPE, A.EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'W'  LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE  CUR_WARD_CODE, A.ASSIGN_ROOM_NUM CUR_ROOM_NUM, A.ASSIGN_BED_NUM CUR_BED_NUM, A.ATTEND_PRACTITIONER_ID CUR_PHYSICIAN_ID, A.ADT_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.SPECIALTY_CODE,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,(select c.ASSGN_CONF_REF_YN from ca_encntr_param c ) ASSIGN_CONFIRM_REFERRAL_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID   "; //IN048704
		stmt = con.prepareStatement(query);
		stmt.setString(1, facility_id);
		stmt.setString(2, episode_id);
		rs = stmt.executeQuery();
		if (rs.next())
		{	
			out.println("document.WrapperPatCriteriaFrm.visit_adm_date.value='" + checkForNull(rs.getString("ADMISSION_DATE_TIME")) + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_type.value='" + checkForNull(rs.getString("EPISODE_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id.value='" + checkForNull(rs.getString("EPISODE_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + checkForNull(rs.getString("PATIENT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='" + checkForNull(rs.getString("PATIENT_CLASS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_type.value='" + checkForNull(rs.getString("LOCN_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_code.value='" + checkForNull(rs.getString("CUR_WARD_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.room_num.value='" + checkForNull(rs.getString("CUR_ROOM_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.bed_num.value='" + checkForNull(rs.getString("CUR_BED_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.physician_id.value='" + checkForNull(rs.getString("CUR_PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.Opphysician_id.value='';");		
			out.println("document.WrapperPatCriteriaFrm.discharge_date.value='" + checkForNull(rs.getString("DISCHARGE_DATE_TIME")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='" + checkForNull(rs.getString("ADT_STATUS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("DOB")) + "';");
			out.println("document.WrapperPatCriteriaFrm.visit_id.value='';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='';");
			out.println("document.WrapperPatCriteriaFrm.specialty_code.value='" + checkForNull(rs.getString("SPECIALTY_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.assign_confirm_referral_yn.value='" + checkForNull(rs.getString("ASSIGN_CONFIRM_REFERRAL_YN")) + "';");//IN048704

			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();	
	}
	else if(!patient_id.equals("") && episode_id.equals(""))
	{
		String query =  " select sex, get_age(date_of_birth) age, TO_CHAR(date_of_birth,'DD/MM/YYYY') date_of_birth,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from mp_patient where patient_id=? ";
		stmt = con.prepareStatement(query);
		stmt.setString(1, patient_id);
		rs = stmt.executeQuery();
		//out.println("alert('####');");
		if (rs.next())
		{
			
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + patient_id + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("date_of_birth")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='XT';");
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='0';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='N';");
			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
	
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	else
	{
		//out.println("alert('APP-002416 Parameters passed to the wrapper are not enough...');");
	}
	out.println("</script>");
    out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");
		
	
	//stmt = con.prepareStatement("select func_role_id, practitioner_name, pract_type, c.ESTABLISH_RELN_REQ_YN from sm_appl_user a, am_practitioner_lang_vw b  ,ca_encntr_param c where b.practitioner_id=a.func_role_id and a.appl_user_id = ? and a.func_role ='P' and a.language_id = ?");	
	
	 ses_pract_id = (String)(session.getValue("ca_practitioner_id")==null?"":session.getValue("ca_practitioner_id"));
	 ses_pract_name=(String)(session.getValue("practitioner_name")==null?"":session.getValue("practitioner_name"));
	 ses_pract_type=(String)(session.getValue("practitioner_type")==null?"":session.getValue("practitioner_type"));
	if((ses_pract_id.equals(""))||(ses_pract_name.equals(""))||(ses_pract_type.equals("")))
	{
		stmt = con.prepareStatement("select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P'");
	
	stmt.setString(1, locale);
	stmt.setString(2, loginUser);
	
	rs = stmt.executeQuery();
	if(rs.next())
	{
		String ca_practitioner_id = (rs.getString("func_role_id")==null?"":rs.getString("func_role_id"));
		String pract_type = (rs.getString("pract_type")==null?"":rs.getString("pract_type"));
		if(pract_type == null)	
			pract_type="";
		String practitioner_name = (rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
		establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		if(practitioner_name == null) 
			practitioner_name="";		
		if(ca_practitioner_id.equals(""))
		{
			out.println("<script>alert(getMessage('NO_USER_FOUND','CA'));</script>");
				if(from_service_yn.equals("Y")){
					out.println("<script>parent.window.close();</script>");	
				}else{
					out.println("<script>location.href='../../eCommon/jsp/dmenu.jsp'</script>");
				}
		}
		

		session.putValue("ca_practitioner_id",ca_practitioner_id);
	    session.putValue("practitioner_name",practitioner_name);
	    session.putValue("practitioner_type",pract_type);
		out.println("<script>");
		out.println("self.document.WrapperPatCriteriaFrm.reln_req_yn.value ='" + establish_reln_req_yn + "'");
		out.println("</script>");
	}
	} // end if
	else
	{

		out.println("<script>");
		out.println("self.document.WrapperPatCriteriaFrm.reln_req_yn.value ='" + establish_reln_req_yn + "'");
		out.println("</script>");
	
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

	String sqlCheck = "select 'Y' from PR_REFERRAL_REGISTER where REFERRAL_ID = ? and TO_PRACT_ID is null";
	stmt = con.prepareStatement(sqlCheck.toString());
	stmt.setString(1, referral_id);
					
	rs = stmt.executeQuery();
	if(rs.next())
	{
		practId_yn = rs.getString(1);
	}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(practId_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	//[IN042884] Start...
	stmt = con.prepareStatement("SELECT ACTION_ON_PENDING_BILL FROM OP_PARAM WHERE OPERATING_FACILITY_ID=?");
	stmt.setString(1, facility_id);					
	rs = stmt.executeQuery();
	if(rs.next())	
		actionOnPendingBill = rs.getString(1);
	
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(actionOnPendingBill));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block64Bytes, _wl_block64);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();	
	
	//[IN042884] End...
	
	//IN042989 - Start
	//IN045375 - Added if condition
	if("EM".equals(patient_class))
	{
		stmt = con.prepareStatement("SELECT ACTION_ON_PENDING_BILL FROM AE_PARAM WHERE OPERATING_FACILITY_ID=?");
		stmt.setString(1, facility_id);					
		rs = stmt.executeQuery();
		if(rs.next())	
			actionOnPendingBill = rs.getString(1);
		
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(actionOnPendingBill));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block67Bytes, _wl_block67);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	//IN042989 - End
}
catch(Exception e)
{
	//out.println("Exception @ OpenChartWrapper->"+e.toString());//COMMON-ICN-0181
	out.println("Open the Error log for the StackTrace....");
	e.printStackTrace();
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block68Bytes, _wl_block68);
            _bw.write(_wl_block69Bytes, _wl_block69);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
