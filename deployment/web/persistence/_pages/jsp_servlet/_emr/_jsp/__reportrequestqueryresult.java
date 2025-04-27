package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.net.URLEncoder;
import org.json.simple.*;
import java.util.*;

public final class __reportrequestqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ReportRequestQueryResult.jsp", 1743671457019L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n/**\n* Added by SRIDHAR R on 3/31/2005 ...\n* Indication of Function ID with thier REQUEST_STATUS inserted into MR_REPORT_REQUEST_HDR table after each transaction is complete... \n* Query is fired based on the foll function id & req status as where clauses...\n* All the following functions use this page for displaying records in result page...\n\n* @Transaction Name = \"MEDICAL REPORT\"\n **************************************************************************************\n\t\t\tFunction name\t\t\t\t|\t\tFunction ID\t\t\t| REQUEST_STATUS \n ************************************************************************************** \n\tMedical Report Request\t\t\t\t|\tMEDICAL_REPORT_REQUEST\t|\t\t1\n\tStatus of Medical Report Request\t|\tMEDICAL_REPORT_STATUS\t|\t\t2 \n\tForward Medical Report Request\t\t|\tFORWARD_MEDICAL_REPORT\t|\t\t3 \n\tPrepare Med Report By Practitioner\t|\tPREPARE_MEDICAL_REPORT\t|\t\t4 \n\tReceive Medical Report\t\t\t\t|\tRECEIVE_MEDICAL_REPORT\t|\t\t5 \n\tDeliver Medical Report\t\t\t\t|\tDELIVER_MEDICAL_REPORT\t|\t\t6 \n\tRevise Medical Report\t\t\t\t|\tREVISE_MEDICAL_REPORT\t|\t\t0\n\tStatus of Medical Report Request\n\tIncomplete\t\t\t\t\t\t\t|\tINCOMPLETE_REPORT_STATUS|\t\t7\n\tMedical Report Cancelled\t\t\t|\tCANCELLED_MEDICAL_REPORT|\t\t8\n\tMedical Report Auto Cancelled\t\t|\t\t\t\t\t\t\t|\t\t99\n **************************************************************************************\n\n* @Transaction Name = \"MEDICAL BOARD\"\n **************************************************************************************\n\t\t\tFunction name\t\t\t\t|\t\tFunction ID\t\t\t| REQUEST_STATUS \n **************************************************************************************\n\tRequest For Medical Board\t\t\t| MEDICAL_BOARD_REQUEST\t\t|\t\t1\n\tStatus of Medical Board Request\t\t| MEDICAL_BOARD_STATUS\t\t|\t\t2\n\tFormation of Medical Board\t\t\t| MEDICAL_BOARD_FORMATION\t|\t\t4\n\tForward Medical Board Request\t\t| FORWARD_MEDICAL_BOARD\t\t|\t\t4\n\tAppointment for Med Board request\t| MEDICAL_BOARD_APPT\t\t|\t\t5\n\tIntimate Appointment of Med Board\t| MEDICAL_BOARD_INT_APPT\t|\t\t6\n\tPrepare Medical Report by Board\t\t| PREPARE_MEDICAL_BOARD\t\t|\t\t7\n\tReceive Medical Report\t\t\t\t| RECEIVE_MEDICAL_BOARD\t\t|\t\t8\n\tDeliver/Dispatch Medical Report\t\t| DELIVER_MEDICAL_REPORT\t|\t\t9\n\tRevise Medical Board\t\t\t\t| REVISE_MEDICAL_BOARD\t\t|\t\t0\n **************************************************************************************\n*/\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\"></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\t<script>\n\tasync function callModalWindow(revise_stat, req_id, call_func, pat_id, appointment_date, med_board_type, enc_id, appt_ref_no, req_status, overdue_yn,curr_dt,request_status ) // request_status added by mujafar for ML-MMOH-CRF-0714\n\t{\t\n\t\tvar req_type = document.forms[0].request_type.value;\n\t\trequest_status = request_status.replace(\"_\",\" \"); // request_status added by mujafar for ML-MMOH-CRF-0714\n\t\t\n\t\tvar isMedicalTeamApplicable= document.forms[0].isMedicalTeamApplicable.value; //  added by mujafar for ML-MMOH-CRF-0710\n\t\tvar isAcceptRequestByPractAppl = document.forms[0].isAcceptRequestByPractAppl.value;\n\t\t// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\t\n\t\t\n\t\t\n\t\tif(req_type == \"MB\"){\n\t\t\tif(req_status == \"1\")\t{\n\t\t\t\tcall_func = \"MEDICAL_BOARD_STATUS\";\n\t\t\t//dialogHeight= \"31\";\t\n\t\t\t}else if(req_status == \"2\" ){\n\t\t\t\tcall_func = \"MEDICAL_BOARD_FORMATION\";\n\t\t\t//dialogHeight= \"32\";\t\n\t\t\t}else if(req_status == \"3\"){\n\t\t\t\tcall_func = \"FORWARD_MEDICAL_BOARD\";\n\t\t\t//dialogHeight= \"30\";\t\n\t\t\t}else if(req_status == \"4\"){\n\t\t\t\tcall_func = \"MEDICAL_BOARD_APPT\";\n\t\t\t//dialogHeight= \"34\";\t\n\t\t\t}else if(req_status == \"5\"){\n\t\t\tcall_func = \"MEDICAL_BOARD_INT_APPT\";\n\t\t\t//dialogHeight= \"32\";\t\n\t\t\t}else if(req_status == \"6\"){\n\t\t\t\tcall_func = \"PREPARE_MEDICAL_BOARD\";\n\t\t\t//dialogHeight= \"32\";\t\n\t\t\t}else if(req_status == \"7\"){\n\t\t\t\tcall_func = \"RECEIVE_MEDICAL_BOARD\";\n\t\t\t//dialogHeight= \"30\";\t\n\t\t\t}else if(req_status == \"8\"){\n\t\t\t\tcall_func = \"DELIVER_MEDICAL_BOARD\";\n\t\t\t//dialogHeight= \"32\";\t\n\t\t\t}if(overdue_yn == \"Y\" ){ // do not add this in IfElse loop..\n\t\t\t\tcall_func = \"REVISE_MEDICAL_BOARD\";\n\t\t\t//dialogHeight= \"30\";\t\n\t\t\t}\n\t\t\tif(req_status == \"9\"){ // do not add this in IfElse loop..\n\t\t\t\tcall_func = \"MEDICAL_BOARD_COMPLETED\";\n\t\t\t//dialogHeight= \"32\";\t\n\t\t\t}\n\t\t}\n\t\tif(req_type == \"MR\" && overdue_yn == \"Y\" ){\n\t\t\tcall_func = \"REVISE_MEDICAL_REPORT\";\n\t\t\t//dialogHeight= \"30\";\t\n\t\t}\t\t\n\t\n\t\tif(call_func == \'MEDICAL_BOARD_APPT\' ){\n\t\t\t//getApptDetails(req_id, call_func, pat_id, appointment_date );\n\t\t\tgetApptDetails(req_id, call_func, pat_id, appointment_date,\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"MR\",\"\",\"\",\"\",\"\",curr_dt);\n\t\t}else{\n\t\t\tvar called_from = parent.criteriaFrame.document.forms[0].called_from.value;\n\t\t\tvar jsp_name\t= \"\";\n\t\t\tif(call_func == \'MEDICAL_BOARD_STATUS\' || call_func == \'FORWARD_MEDICAL_BOARD\' || call_func == \'PREPARE_MEDICAL_BOARD\' || call_func == \'RECEIVE_MEDICAL_BOARD\' || call_func == \'MEDICAL_BOARD_INT_APPT\' || call_func == \'DELIVER_MEDICAL_BOARD\' || call_func == \'MEDICAL_BOARD_COMPLETED\' || call_func == \'REVISE_MEDICAL_BOARD\'){\n\t\t\t\tjsp_name\t= \"MedBoardTransactionsFrames.jsp\";\n\t\t\t}else if(call_func == \'MEDICAL_BOARD_FORMATION\'){\n\t\t\t\tjsp_name\t= \"MedBoardRequestFormation.jsp\";\n\t\t\t}else{\n\t\t\t\tjsp_name\t= \"MedRecRequestRecordMain.jsp\";\n\t\t\t}\n\t\t\tif(call_func == \'PREPARE_MEDICAL_BOARD\'){\n\t\t\t\tif(appt_ref_no != \'\'){\n\t\t\t\t\tif(pat_id ==\'\'){\n\t\t\t\t\t\talert(getMessage(\'PATIENT_NOT_REGISTERED\',\'MR\')); \n\t\t\t\t\t\treturn;\n\t\t\t\t\t}else if(enc_id ==\'\'){\n\t\t\t\t\t\tvar err = getMessage(\'PATIENT_NOT_REGISTERED\',\'MR\'); \n\t\t\t\t\t\terr= err.replace(getLabel(\"Common.patient.label\",\"Common\"), getLabel(\"Common.encounter.label\",\"Common\"));\n\t\t\t\t\t\talert(err);\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\talert(getMessage(\'APPT_NOT_GIVEN\',\'MR\')); \n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\t\t\t\t\n\t\t\tvar dialogHeight= \"94vh\";\t\n\t\t\tvar dialogWidth\t= \"90vw\";\t\t\t\t\n\t\t\t//Added for this CRF ML-MMOH-CRF-0716\n            if(isMedicalTeamApplicable==\"true\")\tdialogWidth\t= \"90vw\";\t\n\t\t\t\n\t\t\tvar dialogTop\t= \"72\";\n\t\t\tvar retVal\t\t= new String();\n\t\t\tvar center\t\t= \"1\" ;\n\t\t\tvar status\t\t= \"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tif(called_from == \'CA\'){\n\t\t\t\tif(call_func == \'PREPARE_MEDICAL_REPORT\' || call_func == \'PREPARE_MEDICAL_BOARD\'){ \n\t\t\t\t\t//retVal\t\t\t= window.open(\"../../eMR/jsp/\"+jsp_name+\"?revise_stat=\"+revise_stat+\"&call_function=\"+call_func+\"&request_id=\"+req_id+\"&PatientId=\"+pat_id+\"&called_from=\"+called_from+\"&med_board_type=\"+med_board_type+\"&req_status=\"+req_status+\"&overdue_status=\"+overdue_yn,\'MR\',\'height=600,width=1100,top=72,left=0,resizable=no,toolbar=no,menubar=no\');\n\t\t\t\t\tretVal\t\t\t= await top.window.showModalDialog(\"../../eMR/jsp/\"+jsp_name+\"?isAcceptRequestByPractAppl=\"+isAcceptRequestByPractAppl+\"&revise_stat=\"+revise_stat+\"&call_function=\"+call_func+\"&request_id=\"+req_id+\"&PatientId=\"+pat_id+\"&called_from=\"+called_from+\"&med_board_type=\"+med_board_type+\"&req_status=\"+req_status+\"&overdue_status=\"+overdue_yn,arguments,features);/*Modified on 18-Nov-15 against IN058304*/\n\t\t\t\t\t// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\t\t\n\t\t\t\t}\n\t\t\t}else{ \n\t\t\t\n\t\t\t\tretVal\t\t\t= await top.window.showModalDialog(\"../../eMR/jsp/\"+jsp_name+\"?isAcceptRequestByPractAppl=\"+isAcceptRequestByPractAppl+\"&revise_stat=\"+revise_stat+\"&call_function=\"+call_func+\"&request_id=\"+req_id+\"&PatientId=\"+pat_id+\"&called_from=\"+called_from+\"&med_board_type=\"+med_board_type+\"&req_status=\"+req_status+\"&overdue_status=\"+overdue_yn+\"&request_status_des=\"+request_status,arguments,features); // request_status added by mujafar for ML-MMOH-CRF-0714\n\t\t\t\t// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tif(called_from == \'CA\'){\n\t\t\tparent.resultFrame.document.location.reload();\n\t\t}\n\t\tif(parent.frames[3].name == \"resultFrame\"){\n\t\t\t\tparent.frames[3].document.location.reload();\n\t\t}else{\n\t\t\tparent.resultFrame.document.location.reload();\n\t\t}\n\t}\n\t//function getApptDetaisl added by kishore on 3/30/2005\n\tasync function getApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,module_id,no_dwm,visittype,dwm_desc,curr_dt){\n\n\t\tvar retVal\t\t= \tnew String();\n\t\tvar dialogHeight= \"40vh\" ;\n\t\tvar dialogWidth = \"65vw\" ;\n\t\tvar dialogTop \t= \"71\";\n\t\tvar center\t\t= \"1\" ;\n\t\tvar status\t\t= \"no\";\n\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\n\t\t//var P_practitioner_id,P_practitioner_id,P_patient_id,P_locn_code,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode;\n\t\t//var referral_id = \"N\" ;\n\t\tvar referral_id = \"\" ;\n\n\t\tvar parameters\t= \"i_practitioner_id=\"+P_practitioner_id+\"&practitioner_id=\"+P_practitioner_id+\"&patient_id=\"+pat_id+\"&i_clinic_code=\"+P_locn_code+\"&clinic_code=\"+P_locn_code+\"&recall_date=\"+recall_date+\"&location_code=\"+P_locn_code+\"&care_locn_ind=\"+P_locn_type+\"&specialty_code=\"+splty_code+\"&selectedPractId=\"+selectedPractId+\"&selectedLocnCode=\"+selectedLocnCode+\"&referral_id=\"+referral_id+\"&request_id=\"+req_id+\"&appt_date=\"+appt_date+\"&callingMode=MR&module_id=\"+module_id+\"&no_dwm=\"+no_dwm+\"&visittype=\"+visittype+\"&dwm_desc=\"+dwm_desc;\n\n\n\t\tvar splitdate1\t=appt_date.split(\"/\")\n\t\tvar splitsysdate\t= curr_dt.split(\"/\")\n\t\tvar mon = eval(splitdate1[1]) - 1; // because in the date constructor, months must be specified in the range  0 - 11\n\n\t\tvar from_date  =new Date(splitdate1[2], mon, splitdate1[0])\n\t\tmon = eval(splitsysdate[1]) - 1;\n\n\t\tvar to_date  =new Date(splitsysdate[2], mon,splitsysdate[0])\n\n\n\t\t//condition modified for the incident ML-BRU-SCF-0055 [31055] by Shanthi on 15-2-2012\n\n\t\tif(Date.parse(to_date) > Date.parse(from_date)){\n//\t\tif(Date.parse(to_date) < Date.parse(from_date)){\n\t\t//if(isBeforeNow(appt_date,\'DMY\',\'en\')){\n\t\t//if(isBefore(appt_date,\'30/03/2010\',\"DMY\",\'en\')){\n\t\t\talert(getMessage(\'APPT_LESS_THAN_SYSDATE_CANT_PROCEED\',\'MR\'));\n\t\t}\n\t\telse{\n\t\t\tretVal =await window.showModalDialog(\"../../eOA/jsp/CAOAAppointment.jsp?\"+parameters,arguments,features);\n\t\t}\n\t\tif(retVal != null && retVal != \"\"){\n\t\t\tvar Val = retVal.split(\"^\");\n\t\t\tvar mode = Val[0];\n\t\t\tparameters = Val[1];\n\t\t\tif (mode==\"1\"){\n\t\t\t\t\n\t\t\t\tparameters=parameters+ \"&title=\"+encodeURIComponent(getLabel(\"eMR.AppointmentforMedicalBoardRequest.label\",\"MR\"));\n\t\t\t\treturnVal =await window.showModalDialog(\"../../eOA/jsp/SinglePractVwNew.jsp?\"+parameters,arguments,features);\n\t\t\t}else if (mode==\"2\"){\n\t\t\t\t\n\t\t\t\tparameters=parameters+ \"&title=\"+encodeURIComponent(getLabel(\"eMR.AppointmentforMedicalBoardRequest.label\",\"MR\"));\n\t\t\t\treturnVal =await window.showModalDialog(\"../../eOA/jsp/MultiPract2VwMain.jsp?\"+parameters,arguments,features);\n\t\t\t}else if (mode==\"3\"){\n\t\t\t\t\n\t\t\t\tparameters=parameters+ \"&title=\"+encodeURIComponent(getLabel(\"eMR.AppointmentforMedicalBoardRequest.label\",\"MR\"));\n\t\t\t\treturnVal =await window.showModalDialog(\"../../eOA/jsp/MultiPract3VwMain.jsp?\"+parameters,arguments,features);\n\t\t\t}\n\t\t\tif(returnVal != null && returnVal != \"\"){\n\t\t\t\tvar arr=new Array();\n\t\t\t\t arr=returnVal.split(\"&\");\n\t\t\t\t var i=0;\n\t\t\t\t while(arr[i]!=null){\n\t\t\t\t\t var arrayElement =arr[i];\n\t\t\t\t\t if(arrayElement.indexOf(\"specialty_code\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t splty_code = arrayOfValue[1];\n\t\t\t\t\t}\n\t\t\t\t\t if(arrayElement.indexOf(\"practitioner_id\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t P_practitioner_id = arrayOfValue[1];\n\t\t\t\t\t}\n\t\t\t\t\tif(arrayElement.indexOf(\"clinic_code\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t P_locn_code = arrayOfValue[1];\n\t\t\t\t\t}\n\t\t\t\t\tif(arrayElement.indexOf(\"recall_date\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t recall_date = arrayOfValue[1];\n\t\t\t\t\t} \n\t\t\t\t\tif(arrayElement.indexOf(\"care_locn_ind\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t P_locn_type = arrayOfValue[1];\n\t\t\t\t\t} \n\t\t\t\t\tif(arrayElement.indexOf(\"no_dwm\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t no_dwm = arrayOfValue[1];\n\t\t\t\t\t} \n\t\t\t\t\tif(arrayElement.indexOf(\"visittype\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t visittype = arrayOfValue[1];\n\t\t\t\t\t} \n\t\t\t\t\tif(arrayElement.indexOf(\"dwm_desc\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\t var arrayOfValue = new Array();\n\t\t\t\t\t\t arrayOfValue = arrayElement.split(\"=\");\n\t\t\t\t\t\t dwm_desc = arrayOfValue[1];\n\t\t\t\t\t} \n\t\t\t\t\ti++;\n\t\t\t\t}\n\n\t\t\t\t//parameters\t= \"i";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="_practitioner_id=\"+P_practitioner_id+\"&practitioner_id=\"+P_practitioner_id+\"&patient_id=\"+pat_id+\"&i_clinic_code=\"+P_locn_code+\"&clinic_code=\"+P_locn_code+\"&recall_date=\"+recall_date+\"&location_code=\"+P_locn_code+\"&care_locn_ind=\"+P_locn_type+\"&specialty_code=\"+splty_code+\"&referral_id=\"+referral_id+\"&request_id=\"+req_id+\"&appt_date=\"+appt_date+\"&callingMode=MR&module_id=OA\";\n\n\t\t\t\tif(returnVal !=\"\")\n\t\t\t\t{\n\t\t\t\t\t//retVal = window.showModalDialog(\"../../eOA/jsp/CAOAAppointment.jsp?\"+parameters,arguments,features);\n\t\t\t\t\tgetApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,\"OA\",no_dwm,visittype,dwm_desc);\n\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}else {\n\t\t\t\t\tvar result = returnVal.split(\"*\");\n\t\t\t\t\tif(result[0] != \"MR\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar ApptNo\t\t= result[0];\n\t\t\t\t\t\t//eval(\"document.getElementById(\"apptLabel\")\"+i).innerText\t= ApptNo;\n\t\t\t\t\t\t//alert(\"ApptNo : \"+ApptNo);\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].Refresh.onclick();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\t</script>\n\t";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\n\t</head>\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name = \'ReportRequestResult_form\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<!--<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>-->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\t\t\t\t\t   \n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\n\t\t\t\t\t\t\t<!--Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<!--End ML-MMOH-CRF-0701-->\n\n\t\t\t\t\t\t\t\t<!-- Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<!--Added by Manivannan  for ML-MMOH-CRF-0715 Start-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<th wrap>\n\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" <!-- added by mujafar for ML-MMOH-CRF-0713 -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th wrap>\n\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t<!--End-->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\t\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</th>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</th>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\n\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\t\t\t<th wrap>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</th> \n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="-->\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="-->\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</th>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\t\t\t\t\t<th wrap>\n\t\t\t\t\t<!--";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t</th>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' align=\'center\' nowrap>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' align=\'center\' nowrap>\n\t\t\t\t\t\t\t\t<a href=javascript:callModalWindow(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\')>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' nowrap>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' nowrap><font color=\'red\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n\t\t\t\t\t\t<!--Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t<!-- End ML-MMOH-CRF-0701-->\n\n\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td> \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!--Added by Manivannan  for ML-MMOH-CRF-0715 Start-->\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' nowrap><font color=\"red\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</font>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="<!-- modified by mujafar for ML-MMOH-CRF-0713 -->\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' nowrap>&nbsp;";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" - ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="&nbsp;&nbsp;<img alt=\"Reason - ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" src=\"../../eCommon/images/information.png\" width=\"14\" height=\"14\"/>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' style=\"text-align: center;\" nowrap>\n\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="&nbsp;&nbsp;<img align=\"center\" alt=\"Remarks - ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" src=\"../../eCommon/images/information.png\" width=\"14\" height=\"14\"/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t<!--End-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\n\t\t\t<tr>\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</a>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td> \n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<img align=\"center\" alt=\"Remarks - ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' nowrap>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\n\t\t\t\n  ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\t\n\t\t\t</tr>\t\n\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t<script >\n\t\t\t\t\tparent.document.getElementById(\"criteriaFrame\").style.height = \"44vh\";\n\t\t\t\t\tparent.document.getElementById(\"resultFrame\").style.height = \"37vh\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t<script >\n\t\t\t\t\tparent.document.getElementById(\"criteriaFrame\").style.height = \"56vh\";\n\t\t\t\t\tparent.document.getElementById(\"resultFrame\").style.height = \"26vh\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n    </table>\n    <br><center></center>\n\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n \t\t\t<input type=\"hidden\" name=\"request_type\" id=\"request_type\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" >\n\t\t\t<input type=\'hidden\' name=\'status_to_show\' id=\'status_to_show\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" > \n\t\t\t<input type=\'hidden\' name=\'isMedicalTeamApplicable\' id=\'isMedicalTeamApplicable\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" >   <!--Mujafar added ML-MMOH-CRF-0716 -->\n\t\t\t<input type=\'hidden\' name=\'isAcceptRequestByPractAppl\' id=\'isAcceptRequestByPractAppl\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" > <!--  added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 -->\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );
 
public String singleToDoubleQuotes(String strDB)
{
    /*
	StringBuffer stringbuffer = new StringBuffer(strDB);
    String strModified="";
	int i = 0;
	
	for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
	{
		i = strDB.indexOf('\'', i);
		stringbuffer.insert(i + j, "'");
		i++;
	}
	strModified=stringbuffer.toString();
	return strModified;
	*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String call_function	= checkForNull(request.getParameter("call_function"));
	String title	= checkForNull(request.getParameter("title"));
	String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user"); // added by mujafar for ML-MMOH-CRF-1280
	String loginPractId  = ((String)session.getValue("ca_practitioner_id")==null)?"":(String)session.getValue("ca_practitioner_id"); 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
	if(title.equals("PREV_DEL_REPORT"))
	{	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
	}	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);

		request.setCharacterEncoding("UTF-8");
		//CallableStatement	Cs_book = null;
		Connection			con		= null;
		Statement			stmt	= null;
		PreparedStatement pstmt=null;
		Statement			dtlStmt	= null;
		//Statement			ipstmt	= null;
		ResultSet			rs		= null;
		ResultSet			dtlRs	= null;
		//ResultSet			iprs	= null;
		Statement			srlStmt	= null;
		ResultSet			srlRS	= null;
		

		Boolean isIncompReqCancelApplicable = false;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
		Boolean isRejectRequestAppl = false; //Added by mujafar  for ML-MMOH-CRF-0713
		Boolean isRejectReportApplicable = false; // added by mujafar for ML-MMOH-CRF-0714
		
		Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
		Boolean isDuedateAppl = false; // added by mujafar for ML-MMOH-CRF-706		
		boolean isSpecialtyDefaultApp = false;//Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454

		
		//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
		Boolean isDeliveredRepModifyAppl = false;
		String modificationRemarks = "";
		String modificationYN = "N";

		StringBuffer where_criteria	= new StringBuffer();
//		StringBuffer sql		= new StringBuffer();
		String overdue_status	= "N";
		String class_val		= "QRYEVEN";
		String booking_stat		= "";
		String encounter_id		= ""; 
		String facility_id		= (String)session.getValue("facility_id");
		String param			= checkForNull(request.getParameter("param"));
		String status_to_show	= checkForNull(request.getParameter("status_to_show"));
		String called_from		= checkForNull(request.getParameter("called_from"));
		String request_type		= checkForNull(request.getParameter("request_type"));
		String whereClause		= request.getParameter("whereclause");
		String from				= request.getParameter("from") ;
		String to				= request.getParameter("to");
		String requestor_code	= checkForNull(request.getParameter("requestor_code"));
		String requestor_type	= checkForNull(request.getParameter("requestor_type"));
		String due_date_sel     = checkForNull(request.getParameter("due_date_sel")); // added by mujafar for ML-MMOH-CRF-706
		String soundex_type		= checkForNull(request.getParameter("soundex"));
		String from_date		= checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
		String to_date			= checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 

		String patient_id		= checkForNull(request.getParameter("PatientId"));
		String gender			= checkForNull(request.getParameter("gender"));
		String name_prefix		= checkForNull(request.getParameter("name_prefix"));
		String name_suffix		= checkForNull(request.getParameter("name_suffix"));
		String first_name		= checkForNull(request.getParameter("first_name"));
		String second_name		= checkForNull(request.getParameter("second_name"));
		String third_name		= checkForNull(request.getParameter("third_name"));
		String family_name		= checkForNull(request.getParameter("family_name"));
		String national_id_no	= checkForNull(request.getParameter("national_id_no"));
		String alt_id1_no		= checkForNull(request.getParameter("alt_id1_no"));
		String alt_id2_no		= checkForNull(request.getParameter("alt_id2_no"));
		String alt_id3_no		= checkForNull(request.getParameter("alt_id3_no"));
		String alt_id4_no		= checkForNull(request.getParameter("alt_id4_no"));
		String other_alt_type	= checkForNull(request.getParameter("other_alt_type"));
		String other_alt_Id		= checkForNull(request.getParameter("other_alt_Id"));
		String loc_lang			= checkForNull(request.getParameter("loc_lang"));

		//Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
		String sum_comp_id		= checkForNull(request.getParameter("sum_comp_id"));

		//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
		String nav_menu_id		= checkForNull(request.getParameter("nav_menu_id"));

		/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
		String speciality				= checkForNull(request.getParameter("speciality"));
		String fwd_practitioner_id		= checkForNull(request.getParameter("fwd_practitioner_id"));
		String prep_practitioner_id		= checkForNull(request.getParameter("prep_practitioner_id"));
		String rep_prep_date			= checkForNull(request.getParameter("rep_prep_date"));
		if(!rep_prep_date.equals(""))
		rep_prep_date = DateUtils.convertDate(rep_prep_date,"DMY",locale,"en");
		/*End MO-CRF-20149*/

		booking_stat = checkForNull(request.getParameter("booking_stat"));
		String searchby = checkForNull(request.getParameter("searchby"));
		if (searchby.equals("")) searchby="S";
		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
		
		String isAcceptRequestByPractAppl = checkForNull(request.getParameter("isAcceptRequestByPractAppl"));
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
		
		String isMRConfigurationAppl = checkForNull(request.getParameter("isMRConfigurationAppl"));  // added by mujafar for ML-MMOH-CRF-1280
		JSONObject fieldOrderJSON	= new JSONObject();
		int recCnt = 0;
		ArrayList arrList = new ArrayList();
		
		if(name_prefix != null)
		name_prefix=singleToDoubleQuotes(name_prefix);

		if(name_suffix != null)
		name_suffix=singleToDoubleQuotes(name_suffix);              

		if (booking_stat==null) booking_stat="";

		String request_id				= "";
		String med_board_type_code		= "";
		String prepare_pract_id			= "";
		String team_id					= "";
		String request_status			= "";
		String revise_status			= "";
		String patient_name_from_vw		= "";
		String appointment_date_from_vw	= "";
		String patient_id_from_vw		= "";
		String gender_from_vw			= "";
		String revised_dt				= "";
		String appt_ref_no_from_vw		= "";
		String request_type_desc		= "";

		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		String cancelledDate			= "";
		String cancelReason				= "";
		String cancelledBy				= "";
		String reqStatusNum				= "";
		/*End*/
		
		// Added by mujafar for ML-MMOH-CRF-0713 start
		String reject_date = "";
		String rejected_by = "";
		String reason_rejection="";		
		// end
		// added by mujafar for ML-MMOH-CRF-0714 start
		String received_date = "";
		String mrp_rejected_by = "";
		String mrp_reason_rejection = "";
		String due_days = ""; // added by mujafar for ML-MMOH-CRF-706
		int pract_days = 0; // added by mujafar for ML-MMOH-CRF-1278
		
		// end
		int	p_max_rec_cnt=0;
		//Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
		String forwarded_hod_date		 = "";
		Boolean IsPendingAssignPractAvbl = false;

	
            _bw.write(_wl_block11Bytes, _wl_block11);

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		//ipstmt	= con.createStatement();
		Boolean isRequestStatus_YN	= eCommon.Common.CommonBean.isSiteSpecific(con, "MR","REQUEST_STATUS_VISIBLE");//Manivannan added for the ML-MMOH-CRF 0715
		isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719
		IsPendingAssignPractAvbl    =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","PENDING_ASSIGN_TO_PRACT"); //Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
		isRejectRequestAppl         =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); //Added by mujafar  for ML-MMOH-CRF-0713
		isRejectReportApplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //Added by mujafar  for ML-MMOH-CRF-0714
		//Below line added for this CRF ML-MMOH-CRF-0712
		Boolean isMedicalReportRequest = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CANCEL_MEDICAL_REQUEST");	 
		
		isDeliveredRepModifyAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MODIFY_ISSUED_MEDICAL_REPORT");//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233

		Boolean isOverduePractitionerApplicable =eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OVERDUE_PRACT_APPL"); //Added by Shaik Mujafar for ML-MMOH-CRF-0710
		
		isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
		isDuedateAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DUE_DATE_APPL"); // added by mujafar for ML-MMOH-CRF-706
		isSpecialtyDefaultApp	= 	eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_SPECIALTY_DEF_APPL_YN"); //Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454
	if(whereClause==null)
	{
/// Added by Sridhar R for Medical Board & Medical Report...
		if(call_function.equals("") && request_type.equals("MB"))
			where_criteria.append(" where REQUEST_TYPE='MB' ");
		else if(call_function.equals("") && request_type.equals("MR"))
			where_criteria.append(" where REQUEST_TYPE='MR' ");
	
		
		if(call_function.equals("") && request_type.equals("MR"))
		{
			
			if(status_to_show.equals(""))
			{
				if(isRejectReportApplicable)
				{ // below if-else added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				if(isAcceptRequestByPractAppl.equals("true"))
				where_criteria.append(" and (request_status <= 11 or (request_status>=13 and request_status<=15) or request_status = 99 or request_status = 98 ) "); 
				else
				where_criteria.append(" and (request_status <= 11 or request_status = 99 or request_status = 98 ) "); 
				
				}
				else
				where_criteria.append(" and (request_status <= 11 or request_status = 99) ");
				
				
				
				
			}
			else if(status_to_show.equals("0-4"))
			{
				if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				where_criteria.append(" and ((request_status <= 5) or (request_status = 7) or (request_status >=9 and request_status <= 11) or (request_status>=13 and request_status<=15) or request_status = 98 )");	
				else
				where_criteria.append(" and ((request_status <= 5) or (request_status = 7) or (request_status >=9 and request_status <= 11) or request_status = 98 )");	
			}
			else if(status_to_show.equals("0")){
				where_criteria.append(" and (overdue_status = 'Y' and request_status NOT IN ('6','99','8')) "); 
			//and  request_status = 98 added by mujafar for ML-MMOH-CRF-0714
			}
			else if(status_to_show.equals("2")){
				where_criteria.append(" and request_status = '"+status_to_show+"' /*and (collect_date > sysdate or revised_collect_date > sysdate)*/ ");}
			else if(status_to_show.equals("3")){
				where_criteria.append(" and request_status in ('3','0')/* and (collect_date > sysdate or revised_collect_date > sysdate)*/");
			/*Added by Thamizh selvi on 17th July 2017 against ML-MMOH-CRF-0719 Start*/
			}
			else if(status_to_show.equals("8")){
			where_criteria.append(" and request_status in ('8','99') ");}
			/*End*/
			else
			{where_criteria.append(" and request_status = '"+status_to_show+"' ");}
		}
		else if(call_function.equals("") && request_type.equals("MB"))
		{
			if(status_to_show.equals(""))
				where_criteria.append(" and request_status <= 9 ");
			else if(status_to_show.equals("0"))
				where_criteria.append(" and overdue_status = 'Y' and request_status < '9' ");
			else if(status_to_show.equals("1"))
				where_criteria.append(" and request_status = '"+status_to_show+"' ");
			else if(status_to_show.equals("2") || status_to_show.equals("3") || status_to_show.equals("4") || status_to_show.equals("5") || status_to_show.equals("6") || status_to_show.equals("7") || status_to_show.equals("8"))
				where_criteria.append(" and request_status = '"+status_to_show+"' and (collect_date > sysdate or revised_collect_date > sysdate) ");
			else if(status_to_show.equals("0-9"))
				where_criteria.append(" and request_status <= 8 /* and (collect_date > sysdate or revised_collect_date > sysdate) */ ");
			else
				where_criteria.append(" and request_status = '"+status_to_show+"'  ");
		}

		/// Added by Sridhar R on 3/29/2005..
		/// Criteria for MEDICAL BOARD ...
		if(call_function.equals("MEDICAL_BOARD_STATUS"))//Status of Medical Board Request
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("FORWARD_MEDICAL_BOARD"))//Forward Medical Board Request
			where_criteria.append(" where REQUEST_TYPE='MB' ");	

		if(call_function.equals("RECEIVE_MEDICAL_BOARD"))//Receive Medical Report
			where_criteria.append(" where and REQUEST_TYPE='MB'");		
		if(call_function.equals("MEDICAL_BOARD_FORMATION"))//Formation of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("MEDICAL_BOARD_APPT"))//Formation of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB' and trunc(appt_date) >= trunc(sysdate)");	
		if(call_function.equals("MEDICAL_BOARD_INT_APPT"))//Intimate Appointment of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	
		if(call_function.equals("DELIVER_MEDICAL_BOARD"))//Deliver of Medical Board
			where_criteria.append(" where REQUEST_TYPE='MB'");	

		
		/// Criteria for MEDICAL REPORT ...
		if(call_function.equals("MEDICAL_REPORT_STATUS"))
			where_criteria.append(" where REQUEST_TYPE='MR'");	
		if(call_function.equals("FORWARD_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR' ");	

		// Common Criteria for Both MEDICAL BOARD && MEDICAL REPORT ...
		if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR'");		
		if(call_function.equals("DELIVER_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR'");
		
		/// Criteria for MEDICAL REPORT ...
		if(call_function.equals("REVISE_MEDICAL_REPORT"))
			where_criteria.append(" where REQUEST_TYPE='MR' and ( COLLECT_DATE < sysdate or revised_collect_date < sysdate ) ");	
		
		if(called_from.equals("CA") && call_function.equals("PREPARE_MEDICAL_BOARD"))
		{
			where_criteria.append(" where request_status = '6' and  REQUEST_TYPE='MB' and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate)");	
		}
		else if(called_from.equals("CA") )
		{
			//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
			//sumCompQry Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 & Status 15 added for 1451 
			String sumCompQry = " WHERE request_status IN ('3', '98', '9', '11')  AND request_type = 'MR' AND overdue_status !='Y' ";			
			
			if(nav_menu_id.equals("VW_PREPD_MED_REP"))
			{
				where_criteria.append(" WHERE request_status = '4' AND request_type = 'MR' AND overdue_status !='Y' ");
			}
			// if else block added by mujafar for ML-MMOH-CRF-0716.2 and ML-MMOH-CRF-904	
			else if(isMedicalReportRequest && !(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")))
			{
			//where_criteria.append(" where (request_status = '3' or request_status = 98 or request_status = '9' or request_status = '11' or request_status = '13' )  and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) and  REQUEST_TYPE='MR' "); // 98 status added by mujafar for ML-MMOH-CRF-0714	
			where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11','13','15')  AND request_type = 'MR' AND overdue_status !='Y' and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) ");		
			} // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			/*Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701*/
			else if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28"))
			{
				where_criteria.append(sumCompQry);
				if(sum_comp_id.equals("MR_MED_REPT_15")){
					//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 15 AND 19 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 15 AND 19 ");
				}
				else if(sum_comp_id.equals("MR_MED_REPT_20")) {
					//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 20 AND 27 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) BETWEEN 20 AND 27 ");
				}
				else if(sum_comp_id.equals("MR_MED_REPT_28")) {
				//where_criteria.append(" WHERE request_status IN ('3', '98', '9', '11') AND TRUNC (SYSDATE) - TRUNC (appl_completion_date) >= 28 AND request_type = 'MR' AND overdue_status !='Y' ");
					where_criteria.append(" AND TRUNC (SYSDATE) - TRUNC (appl_completion_date)  >= 28 ");
				}
			}
			/*End ML-MMOH-CRF-0701*/
			else{
				where_criteria.append(" where (request_status = '3' or request_status = 98)  and ( COLLECT_DATE >= sysdate or revised_collect_date >= sysdate) and  REQUEST_TYPE='MR' "); // 98 status added by mujafar for ML-MMOH-CRF-0714
			}
			if(due_date_sel != null && !due_date_sel.equals("") && call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl)
			{ // added by mujafar for ML-MMOH-CRF-0706
				
					where_criteria.append(" and  medcle_rprt_due_dt_calc(facility_id,request_id)<=NVL("+due_date_sel+",9999)");
				
				
			}
			/*Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 Start*/
			if(isSpecialtyDefaultApp){
				where_criteria.append(" and (forwarded_hod_cord_id = '"+loginPractId+"' or (FORWARDED_PRACT_ID = '"+loginPractId+"' and request_status!=15 ) ");
				where_criteria.append(" or EXISTS ( SELECT a.team_id FROM am_medical_team a, am_pract_for_team b WHERE b.practitioner_id =  '"+loginPractId+"' ");
				where_criteria.append(" AND a.team_id = b.team_id AND a.facility_id = b.facility_id AND appl_for_mr_yn = 'Y' AND a.team_id = forwarded_medical_team ))");
			}
			/*Added By Dharma on 5th Dec 2019 against ML-MMOH-CRF-1454 End*/
		}
		
		/// End of addition by Sridhar R ...
		if(call_function.equals("QUERY_DELAY_IN_MRR"))
		{
			where_criteria.append(" where (request_status < '6'  or request_status = 98) and overdue_status = 'Y' "); // status added for ML-MMOH-CRF-0714
		}


		where_criteria.append(" and facility_id='"+facility_id+"'");

		//requestor code
		if(requestor_code!=null && !requestor_code.equals(""))
			where_criteria.append(" and requestor_code = '"+requestor_code+"'");

		//requestor requestor_type
		if(requestor_type!=null && !requestor_type.equals(""))
			where_criteria.append(" and INDICATOR = '"+requestor_type+"'");


		//from_date
		if(from_date!=null && !from_date.equals(""))
			where_criteria.append(" and trunc(added_date) >= to_date('"+from_date+"' , 'dd/mm/yyyy') ");
		
		//to_date
		if(to_date!=null && !to_date.equals(""))
			where_criteria.append( " and trunc(added_date) <= to_date('"+to_date+"' , 'dd/mm/yyyy') ");

		//patient_id
		if(patient_id!=null && !patient_id.equals(""))
			where_criteria.append( " and patient_id like '"+patient_id+"%' ");

		//gender
		if(gender!=null && !gender.equals(""))
		{
			where_criteria.append( " and sex='"+gender+"' ");
		}

		//name_prefix
		if(name_prefix!=null && !name_prefix.equals(""))
		   where_criteria.append(" and name_prefix='"+name_prefix+"' ");

		//name_suffix
		if(name_suffix!=null && !name_suffix.equals(""))
			where_criteria.append( " and name_suffix='"+name_suffix+"' ");
		
		if(national_id_no!=null && !national_id_no.equals(""))
			where_criteria.append(" and national_id_no='"+national_id_no+"'");
		
		if(alt_id1_no!=null && !alt_id1_no.equals(""))
			where_criteria.append( " and alt_id1_no='"+alt_id1_no+"'");

		if(alt_id2_no!=null && !alt_id2_no.equals(""))
			where_criteria.append(" and alt_id2_no='"+alt_id2_no+"'");

		if(alt_id3_no!=null && !alt_id3_no.equals(""))
			where_criteria.append(" and alt_id3_no='"+alt_id3_no+"'");

		if(alt_id4_no!=null && !alt_id4_no.equals(""))
			where_criteria.append( " and alt_id4_no='"+alt_id4_no+"'");

		if(other_alt_type!=null && !other_alt_type.equals(""))
			where_criteria.append( " and oth_alt_id_type='"+other_alt_type+"'");

		if(other_alt_Id!=null && !other_alt_Id.equals(""))
			where_criteria.append( " and oth_alt_Id_no='"+other_alt_Id+"'");

		/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
		if(speciality!=null && !speciality.equals(""))
			where_criteria.append( " and specialty_code='"+speciality+"'");

		if(fwd_practitioner_id!=null && !fwd_practitioner_id.equals(""))
			where_criteria.append( " and forwarded_pract_id='"+fwd_practitioner_id+"'");

		if(prep_practitioner_id!=null && !prep_practitioner_id.equals(""))
			where_criteria.append( " and prepare_pract_id='"+prep_practitioner_id+"'");

		if(rep_prep_date!=null && !rep_prep_date.equals(""))
			where_criteria.append(" and trunc(prepared_date)=to_date('"+rep_prep_date+"' , 'dd/mm/yyyy') ");
		/*End MO-CRF-20149*/

	if(soundex_type.equals("E"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(FIRST_NAME_LOC_LANG)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(SECOND_NAME_LOC_LANG)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(THIRD_NAME_LOC_LANG)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(family_name)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(FAMILY_NAME_LOC_LANG)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
		}
	}
	else if(soundex_type.equals("G"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(first_name)) like upper(soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(FIRST_NAME_LOC_LANG)) like upper(soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(second_name)) like upper(soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(SECOND_NAME_LOC_LANG)) like upper(soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(third_name)) like upper(soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(THIRD_NAME_LOC_LANG)) like upper(soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(family_name)) like upper(soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(FAMILY_NAME_LOC_LANG)) like upper(soundex('" +fam_name_search+"')) || '%' ");
		}
	}
	else
	{
		if (pat_name_as_multipart_yn.equals("Y"))
		{
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(first_name) like upper('" +first_name +"') || '%' ");
				else
					where_criteria.append(" and upper(FIRST_NAME_LOC_LANG) like upper('" +first_name +"') || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(second_name) like upper('" + second_name +"') || '%' ");
				else
					where_criteria.append(" and upper(SECOND_NAME_LOC_LANG) like upper('" + second_name +"') || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(third_name) like upper('"+ third_name+"') || '%' ");
				else
					where_criteria.append( " and upper(THIRD_NAME_LOC_LANG) like upper('"+ third_name+"') || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(family_name) like upper('" +family_name+"') || '%' ");
				else
					where_criteria.append( " and upper(FAMILY_NAME_LOC_LANG) like upper('" +family_name+"') || '%' ");
			}
		}
		else
		{						
			if (searchby.equals("C"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(family_name) like '%' || upper('" +family_name+"') || '%' ");
					else
						where_criteria.append( " and upper(FAMILY_NAME_LOC_LANG) like '%' || upper('" +family_name+"') || '%' ");
				}
			}
			else if (searchby.equals("E"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(family_name) like '%' || upper('" +family_name+"') ");
					else
						where_criteria.append(" and upper(FAMILY_NAME_LOC_LANG) like '%' || upper('" +family_name+"') ");
				}
			}
			else
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(family_name) like upper('" +family_name+"') || '%' ");
					else
						where_criteria.append(" and upper(FAMILY_NAME_LOC_LANG) like upper('" +family_name+"') || '%' ");
				}
			}
		}
	}
	
	}
	else
	{
		where_criteria.append(whereClause);
	}

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null )
			end = 8 ;
		else
			end = Integer.parseInt( to ) ;

		int maxRecord = 0;
	  
		//sql.append(" SELECT count(*) from MR_REPORT_REQUEST_HDR_VW " +where_criteria);
//out.println("Count Sql : "+sql.toString());

		/*rs = stmt.executeQuery(sql.toString());
		rs.next();
		maxRecord = rs.getInt(1);
		if(rs!=null)rs.close();*/
//out.println("<br> maxRecord : "+maxRecord);

		/*if(maxRecord == 0)
		{*/	
            _bw.write(_wl_block12Bytes, _wl_block12);
	/*}	 
		else
		{*/
			
			StringBuffer sqlSb = new StringBuffer();
			//sqlSb.append(" SELECT request_type, med_board_type_code, facility_id, request_id, to_char(request_date, 'dd/mm/yyyy') request_date ,patient_name, patient_id, gender, practitioner_name, team_short_desc, to_char(collect_date,'DD/MM/YYYY hh24:mi')collect_date, to_char(appt_date, 'dd/mm/yyyy')appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'DD/MM/YYYY hh24:mi')prepared_date, request_status, revise_status, overdue_status from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" ");
			
			//Added forwarded_hod_date by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
			// below line commented and next line added by mujafar on 12-oct-2017 for ML-MMOH-CRF-0713
			//sqlSb.append(" select to_char(sysdate,'dd/mm/yyyy') curr_date,request_type, med_board_type_code, facility_id, request_id, to_char(request_date,'dd/mm/yyyy') request_date, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, patient_id, sex, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'"+locale+"','1')practitioner_name, am_get_desc.AM_MEDICAL_TEAM(facility_id, prepare_team_id,'"+locale+"','2') team_short_desc, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, to_char(appt_date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, request_status, revise_status, overdue_status, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by, to_char(cancelled_date, 'dd/mm/yyyy hh24:mi') cancelled_date, am_get_desc.am_contact_reason(cancel_reason_code,'"+locale+"','1') cancel_reason_code, trunc(sysdate)-trunc(forwarded_hod_cord_date) forwarded_hod_date from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" ");//Modified by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719	
			
			sqlSb.append(" select to_char(sysdate,'dd/mm/yyyy') curr_date,request_type, med_board_type_code, facility_id, request_id, to_char(request_date,'dd/mm/yyyy') request_date, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, patient_id, sex, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'"+locale+"','1')practitioner_name, am_get_desc.AM_MEDICAL_TEAM(facility_id, prepare_team_id,'"+locale+"','2') team_short_desc, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, to_char(appt_date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, request_status, revise_status, overdue_status, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by, to_char(cancelled_date, 'dd/mm/yyyy hh24:mi') cancelled_date, am_get_desc.am_contact_reason(cancel_reason_code,'"+locale+"','1') cancel_reason_code, /*trunc(sysdate)-trunc(forwarded_hod_cord_date) */ trunc(forwarded_hod_cord_date) - trunc(REQUEST_DATE) forwarded_hod_date,sm_get_desc.sm_appl_user(rejected_by,'"+locale+"','1') rejected_by, am_get_desc.am_contact_reason(reason_rejection,'"+locale+"','1') reason_rejection,to_char(ACCPT_REJCT_DATE, 'dd/mm/yyyy hh24:mi') reject_date,to_char(received_date, 'dd/mm/yyyy hh24:mi') received_date,mrp_rejected_by,am_get_desc.am_contact_reason(mrp_reason_rejection,'"+locale+"','1')mrp_reason_rejection,medcle_rprt_due_dt_calc(facility_id,request_id)due_days, to_char(appl_completion_date,'dd/mm/yyyy hh24:mi') appl_completion_date, modification_remarks from MR_REPORT_REQUEST_HDR_VW "+where_criteria+" "); // modified by mujafar for ML-MMOH-CRF-0714 and ML-MMOH-CRF-0706
			// appl_completion_date Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
            
			//sqlSb.append(" SELECT (CASE WHEN( REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE AND A.REQUEST_STATUS < '6'  )   THEN 'Overdue'  WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL AND A.REQUEST_STATUS < '6'  )   THEN 'Overdue'  ELSE   DECODE(A.REQUEST_STATUS, '1','Requested','2','Status Completed','3','Forwarded to Practitioner','4','Prepared by Practitioner','5','Received by Medical Record','6','Report Delivered','7','Delay in Preparation') END ) REQUEST_STATUS_DESC, request_type, med_board_type_code, facility_id, request_id, To_char(Request_Date,'dd/mm/yyyy') Request_Date, Patient_Name, patient_id, gender, AM_GET_DESC.AM_PRACTITIONER(PREPARE_PRACT_ID,'"+locale+"','1')Practitioner_Name, AM_GET_DESC.AM_MEDICAL_TEAM(facility_id, PREPARE_TEAM_ID,'"+locale+"','2') Team_Short_desc, To_char(Collect_Date,'DD/MM/YYYY hh24:mi') Collect_Date, To_char(appt_Date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, (CASE WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE AND REQUEST_STATUS < '9'   )   THEN 'Overdue'  WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL AND REQUEST_STATUS < '9' )THEN 'Overdue' ELSE DECODE(REQUEST_STATUS, '1','Requested','2','Status Completed','3','Medical Board Formed', '4','Forwarded to Practitioner','5','Appointment Given','6','Appointment Intimated','7','Prepared by Practitioner','8','Received by Medical Board','9','Report Delivered') END ) BOARD_REQUEST_STATUS_DESC, To_char(Prepared_Date,'DD/MM/YYYY hh24:mi') prepared_date, request_status, (CASE WHEN REQUEST_STATUS = '3' AND COLLECT_DATE < SYSDATE THEN 'Y' ELSE 'N' END ) REVISE_STATUS, (CASE WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE > SYSDATE) THEN 'N' WHEN(REVISED_COLLECT_DATE IS NOT NULL AND REVISED_COLLECT_DATE < SYSDATE) THEN 'Y' WHEN (COLLECT_DATE > SYSDATE) THEN 'N' WHEN (COLLECT_DATE < SYSDATE AND REVISED_COLLECT_DATE IS NULL) THEN 'Y' END) overdue_status from MR_REPORT_REQUEST_HDR "+where_criteria+" ");


			if(request_type.equals("MR"))
			{
				if(status_to_show.equals("") || status_to_show.equals("0-4"))
					sqlSb.append(" order by request_status_desc desc");
				else
					sqlSb.append(" order by request_id desc, request_date desc");
			}
			else if(request_type.equals("MB"))
			{
				if(status_to_show.equals("") || status_to_show.equals("0-9"))
					sqlSb.append(" order by board_request_status_desc desc");
				else
					sqlSb.append(" order by request_id desc, request_date desc");
			}

//			if (rs != null) rs.close();
//			if (stmt != null) stmt.close();
			//out.println(sqlSb.toString());
			/*
				Commented for PE  on 6/15/2010
				Statement was changed to Prepared Statement.
				stmt	= con.createStatement();
				rs      = stmt.executeQuery(sqlSb.toString());
			*/
			//out.println("sqlSb.toString(): -------------> "+sqlSb.toString());
			pstmt = con.prepareStatement(sqlSb.toString());


			rs=pstmt.executeQuery();
			if ( start != 1 ){
					for( int j=1; j<start; i++,j++ )	{
						rs.next() ;
					}
			}
			while ( rs!=null && i<=end && rs.next()){
					if(maxRecord==0){
						//if (( !(start <= 1) ) || ( !( (start+8) > maxRecord ) ))
						//{
						out.println("<p><table align='right'><tr>");
						if (!(start <= 1))
						out.println("<td align ='right' id='prev' ><A HREF='../jsp/ReportRequestQueryResult.jsp?called_from="+called_from+"&isDuedateAppl="+isDuedateAppl+"&isMRConfigurationAppl="+isMRConfigurationAppl+"&isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&param="+param+"&from="+(start-8)+"&to="+(end-8)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"&status_to_show="+status_to_show+"&sum_comp_id="+sum_comp_id+"&request_type="+request_type+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 & 1280
						//if ( !( (start+8) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/ReportRequestQueryResult.jsp?called_from="+called_from+"&isDuedateAppl="+isDuedateAppl+"&isMRConfigurationAppl="+isMRConfigurationAppl+"&isAcceptRequestByPractAppl="+isAcceptRequestByPractAppl+"&param="+param+"&from="+(start+8)+"&to="+(end+8)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"&status_to_show="+status_to_show+"&sum_comp_id="+sum_comp_id+"&request_type="+request_type+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>"); // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 & 1280
						out.println("</tr></table></p>");
						out.println("<br><br>");
						//}
						if(!(isMRConfigurationAppl.equals("true")) || (isMRConfigurationAppl.equals("true") && call_function.equals("QUERY_DELAY_IN_MRR") ) || (isMRConfigurationAppl.equals("true") && request_type.equals("MB") && !call_function.equals("QUERY_DELAY_IN_MRR") )  )
						{ // added by mujafar for ML-MMOH-CRF-1280 
						
						
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
	if(call_function.equals("QUERY_DELAY_IN_MRR")){	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(call_function.equals("PREPARE_MEDICAL_REPORT")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){ // added by mujafar for ML-MMOH-CRF-706 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(!call_function.equals("PREPARE_MEDICAL_REPORT")||(isRequestStatus_YN==true) ){ // modified by mujafar for ML-MMOH-CRF-0714
								if(isRejectReportApplicable && request_type.equals("MR"))
								{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}
								else{ 
								if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT")&& isDuedateAppl){ // added by mujafar for ML-MMOH-CRF-706
								
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
								else{
								
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}}
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(isIncompReqCancelApplicable == true && !call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
								if(isRejectRequestAppl && request_type.equals("MR") ) {
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
								 } 
            _bw.write(_wl_block37Bytes, _wl_block37);

					}
					else{ // added by mujafar for ML-MMOH-CRF-1280
					
					fieldOrderJSON = eMR.MRCommonBean.getFieldNames(con,facility_id,loginUser);
	
					arrList		= (ArrayList) fieldOrderJSON.get("fieldNames");

					recCnt		= (Integer) fieldOrderJSON.get("recCnt");
					
					
		
					
            _bw.write(_wl_block38Bytes, _wl_block38);

					for(int k=0;k<recCnt;k++)
					{
					String fieldName = "";
					fieldName = (String)arrList.get(k);
				
					  if(fieldName.equals("REQUEST_ID")){
					
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
}else if(fieldName.equals("PATIENT_ID")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}else if(fieldName.equals("PATIENT_NAME")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
}else if(fieldName.equals("GENDER")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}else if(fieldName.equals("PRACTITIONER")){
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}else if(fieldName.equals("REQUEST_DATE")){
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}else if(fieldName.equals("COLLECT_DATE")){
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){
						
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}}else if(fieldName.equals("REQUEST_TYPE")){
						if(call_function.equals("QUERY_DELAY_IN_MRR")){
						
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}}else if(fieldName.equals("APPL_COMP_DATE")){
					if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){	
						
					
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl && (status_to_show.equals("9") || status_to_show.equals("11"))){
						
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}}else if(fieldName.equals("REVISE_DATE")){
						if(call_function.equals("PREPARE_MEDICAL_REPORT")){
						
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
}}else if(fieldName.equals("DUE_DAYS")){
						if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){ 
						
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}}else if(fieldName.equals("REQUEST_STATUS")){
						if(!call_function.equals("PREPARE_MEDICAL_REPORT")||(isRequestStatus_YN==true) ){ 
								if(isRejectReportApplicable && request_type.equals("MR"))
								{
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
								else{ 
								if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT")&& isDuedateAppl){ 
								
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
								else{
								
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
}}}}else if(fieldName.equals("CANCELLED_DETAILS")){ 
					if(isIncompReqCancelApplicable == true && !call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
								if(isRejectRequestAppl && request_type.equals("MR") ) {
					
					
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

					}}}
					}
					
            _bw.write(_wl_block57Bytes, _wl_block57);

					}
					}
					

					/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
					cancelledBy		= rs.getString("cancelled_by");
					if(cancelledBy == null) cancelledBy="";
					cancelledDate	= rs.getString("cancelled_date");
					if(cancelledDate == null) cancelledDate="";
					cancelReason	= rs.getString("cancel_reason_code");
					if(cancelReason == null) cancelReason="";
					reqStatusNum	= rs.getString("request_status");
					if(reqStatusNum == null) reqStatusNum="";
					/*End*/
					// added by mujafar for ML-MMOH-CRF-0713 start
					  rejected_by = rs.getString("rejected_by");
					  if(rejected_by == null) rejected_by="";
					  reject_date = rs.getString("reject_date");
					  if(reject_date == null) reject_date=""; 
					  reason_rejection = rs.getString("reason_rejection");
					  if(reason_rejection == null) reason_rejection="";  
					// end
					
					modificationRemarks	= checkForNull(rs.getString("MODIFICATION_REMARKS"));//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
					
					// added by mujafar for ML-MMOH-CRF-0714 start
					received_date = rs.getString("received_date");
					  if(received_date == null) received_date="";
					  mrp_rejected_by = rs.getString("mrp_rejected_by");
					  if(mrp_rejected_by == null) mrp_rejected_by=""; 
					  mrp_reason_rejection = rs.getString("mrp_reason_rejection");
					  if(mrp_reason_rejection == null) mrp_reason_rejection="";
					
					// end
					due_days = rs.getString("due_days"); // added by mujafar for ML-MMOH-CRF-706
					  if(due_days == null) due_days="";

					overdue_status = rs.getString("OVERDUE_STATUS");
					if(overdue_status == null) overdue_status="N";
					request_id = rs.getString("REQUEST_ID");
					if(request_id == null) request_id="&nbsp;";
					med_board_type_code = rs.getString("MED_BOARD_TYPE_CODE");
					if(med_board_type_code == null) med_board_type_code="";
					prepare_pract_id=rs.getString("PRACTITIONER_NAME");
					if(prepare_pract_id == null) prepare_pract_id="&nbsp;";
					team_id=rs.getString("TEAM_SHORT_DESC");
					if(team_id == null) team_id="&nbsp;";
					
					//Added by Sangeetha on 22/08/17 for ML-MMOH-CRF-0705
					forwarded_hod_date = checkForNull(rs.getString("forwarded_hod_date"));
					
					if(!forwarded_hod_date.equals(""))
					pract_days = Integer.parseInt(forwarded_hod_date);
					
				
					/*Added by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1233 Start*/
					if(isDeliveredRepModifyAppl && reqStatusNum.equals("98") && !modificationRemarks.equals("") && !mrp_reason_rejection.equals("")){
						modificationYN = eMR.MRCommonBean.getlatestRejectionDate(con,facility_id,request_id);
					}else if(isDeliveredRepModifyAppl && reqStatusNum.equals("98") && !modificationRemarks.equals("") && mrp_reason_rejection.equals("")){
						modificationYN = "Y";
					}else{
						modificationYN = "N";
					}if(modificationYN == null || ("").equals(modificationYN)) modificationYN="N";
					/*End*/

					/*Added by Manivannan  for ML-MMOH-CRF-0715 Start*/
					if(call_function.equals("QUERY_DELAY_IN_MRR")||isRequestStatus_YN==true){ 
						request_type = rs.getString("request_type");
						if(request_type == null) request_type="";
					}
					if(request_type.equals("MR")){ 
						request_status = rs.getString("REQUEST_STATUS_DESC");
						request_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels");
						/*ML-MMOH-CRF-0713 */
						if(request_status.equals("RETURNED REQUEST") && isRejectRequestAppl)
						{
						//request_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");	
						request_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RejectedRequest.label","common_labels");	
						//request_status=request_status.toUpperCase(); 
						}	
						/* ML-MMOH-CRF-0713*/
					}else if(request_type.equals("MB")){
						request_status = rs.getString("BOARD_REQUEST_STATUS_DESC");
					
						request_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalBoard.label","mr_labels");
					}
					if(request_status == null) request_status="&nbsp;";
					if(request_type.equals("MB") && status_to_show.equals("9") )
					request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");
					revise_status=rs.getString("revise_status");
					if(revise_status == null) revise_status="N";

					//						if(revise_status.equals("Y"))
					//							request_status	 = "Overdue";

					patient_name_from_vw=rs.getString("PATIENT_NAME");
					if(patient_name_from_vw == null) patient_name_from_vw="&nbsp;";
					appointment_date_from_vw=rs.getString("APPT_DATE");
					if(appointment_date_from_vw == null) appointment_date_from_vw="";
					appt_ref_no_from_vw=rs.getString("appt_ref_no");
					if(appt_ref_no_from_vw == null) appt_ref_no_from_vw="";
					patient_id_from_vw=rs.getString("PATIENT_ID");
					if(patient_id_from_vw == null) patient_id_from_vw="&nbsp;";
					gender_from_vw=rs.getString("sex");
					if(gender_from_vw == null) gender_from_vw="&nbsp;";
					if(gender_from_vw == null ){
						gender_from_vw="";
					}else if (gender_from_vw.equals("M")){
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					}else if (gender_from_vw.equals("F")){
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					}else{
						gender_from_vw = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	     			}
					if(call_function.equals("PREPARE_MEDICAL_REPORT") ){
						int srlCount = 0;
						revised_dt = "&nbsp;";
						String Srl_Sql = "select NVL(MAX(srl_no),0) from MR_REPORT_REQUEST_REV_DTL where facility_id ='"+facility_id+"' and patient_id='"+patient_id_from_vw+"' and request_id='"+request_id+"' "; // request_id added by mujafar for ML-MMOH-CRF-706(existing issue)
						if(srlRS != null) 	srlRS = null;
						if(srlStmt != null) srlStmt = null;
						srlStmt	= con.createStatement();
						srlRS   = srlStmt.executeQuery(Srl_Sql);
						if(srlRS != null){
							if(srlRS.next()){
								srlCount = srlRS.getInt(1); 
							}
						}
						String revised_dtSql = "select srl_no, request_id, to_char(revised_date, 'dd/mm/yyyy hh24:mi') revised_dt from MR_REPORT_REQUEST_REV_DTL where facility_id ='"+facility_id+"' and patient_id = '"+patient_id_from_vw+"' and srl_no='"+srlCount+"'and request_id='"+request_id+"' ";
						if(srlRS != null) 	srlRS = null;
						if(srlStmt != null) srlStmt = null;
						srlStmt	= con.createStatement();
						srlRS   = srlStmt.executeQuery(revised_dtSql);
						if(srlRS != null){
							while(srlRS.next()){
								revised_dt = srlRS.getString("revised_dt"); 
							}
						}
						if(revised_dt == null) {
						revised_dt = "&nbsp;";
						}else if(!(revised_dt==null || revised_dt.equals("") || revised_dt.equals("&nbsp;"))){
							revised_dt = DateUtils.convertDate(revised_dt,"DMYHM","en",locale);
						}
					}
					String DtlSql = "select request_id, patient_id, encounter_id from MR_REPORT_REQUEST_DTL where facility_id ='"+facility_id+"' and patient_id='"+patient_id_from_vw+"' and request_id='"+request_id+"'";
					dtlStmt	= con.createStatement();
					dtlRs   = dtlStmt.executeQuery(DtlSql);
					if(dtlRs != null && dtlRs.next()){
						encounter_id = checkForNull(dtlRs.getString("ENCOUNTER_ID")); 
					}
					if(dtlRs != null) dtlRs.close();
					if(dtlStmt != null) dtlStmt.close();
					if(class_val.equals("QRYEVEN")){
						class_val = "QRYODD";
					}else{
						class_val = "QRYEVEN";
					}
		
		if(!(isMRConfigurationAppl.equals("true")) || (isMRConfigurationAppl.equals("true") && call_function.equals("QUERY_DELAY_IN_MRR") ) ||      (isMRConfigurationAppl.equals("true") && request_type.equals("MB") && !call_function.equals("QUERY_DELAY_IN_MRR") ))
			{  // if condition added by mujafar for ML-MMOH-CRF-1280
					
					
            _bw.write(_wl_block58Bytes, _wl_block58);

						String collect_dt = rs.getString("collect_date") ;
						String collect_dt_display = "";
						if(collect_dt == null) 	{ 
							collect_dt = "&nbsp;";
							collect_dt_display = "&nbsp;";
						}else{
							collect_dt_display = DateUtils.convertDate(collect_dt,"DMYHM","en",locale);
						}
						String prepared_dt = rs.getString("PREPARED_DATE") ;
						if(prepared_dt == null) prepared_dt = "&nbsp;";
						if( (call_function.equals("RECEIVE_MEDICAL_REPORT") && prepared_dt.equals("&nbsp;")) || (call_function.equals("QUERY_DELAY_IN_MRR")) || title.equals("PREV_DEL_REPORT")){	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{ 
						
						String request_status_des = request_status.replace(" ","_"); // added by mujafar for ML-MMOH-CRF-0714
						
						
						
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(revise_status));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("PATIENT_ID"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(appointment_date_from_vw));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(med_board_type_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(appt_ref_no_from_vw));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("request_status"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("overdue_status"),"N")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rs.getString("curr_date")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request_status_des));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block68Bytes, _wl_block68);
String req_date_display = rs.getString("request_date");
							if(req_date_display == null){ 
								req_date_display = "&nbsp;";
							}else{
								req_date_display = DateUtils.convertDate(req_date_display,"DMY","en",locale);
							}
							out.println(req_date_display);
							
            _bw.write(_wl_block69Bytes, _wl_block69);
if(call_function.equals("QUERY_DELAY_IN_MRR")){
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(request_type_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_id_from_vw));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_name_from_vw));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(gender_from_vw));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prepare_pract_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
if(IsPendingAssignPractAvbl == true && (status_to_show.equals("9") || status_to_show.equals("11"))){
							if(pract_days >= 4)
							{ // added by mujafar for ML-MMOH-CRF-1278
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(forwarded_hod_date));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

							}
							else{
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(forwarded_hod_date));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
}}
            _bw.write(_wl_block78Bytes, _wl_block78);
if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){

						String appl_comp_dt = rs.getString("appl_completion_date") ;
						String appl_comp_dt_display = "";

						if(appl_comp_dt == null)
						{ 
							appl_comp_dt = "&nbsp;";
							appl_comp_dt_display = "&nbsp;";
						}else
						{
							appl_comp_dt_display = DateUtils.convertDate(appl_comp_dt,"DMYHM","en",locale);
						}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(appl_comp_dt_display));
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(collect_dt_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
	if(call_function.equals("PREPARE_MEDICAL_REPORT")){
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(revised_dt));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl) { // added by mujafar for ML-MMOH-CRF-706 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(due_days));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);

if(!call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("QUERY_DELAY_IN_MRR")||(isRequestStatus_YN==true))
{             
			/*Below line added for this CRF ML-MMOH-CRF-0712*/
				if(isMedicalReportRequest && request_status.equals("MEDICAL REPORT CANCELLED") && reqStatusNum.equals("8")){
					 request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelRequestbymrd.label","mr_labels");
				}
			//End this CRF ML-MMOH-CRF-0712
			// below if condition added for ML-MMOH-CRF-713 (label change)
			
			if(reqStatusNum.equals("99"))
				request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AutoCancelRequest.label","mr_labels");
				

 
            _bw.write(_wl_block24Bytes, _wl_block24);

							
							if(isOverduePractitionerApplicable && request_status.equals("OVERDUE") && request_type.equals("MR") && (reqStatusNum.equals("3")||reqStatusNum.equals("98")))
							{  // if block added by mujafar for ML-MMOH-CRF-0710
							String request_status_dump=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OverduebyPractitioner.label","mr_labels");
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(request_status_dump));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
									if(request_type.equals("MR"))
									{
									if(request_status.equals("OVERDUE"))
									{
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
									}
									else
									{
										if(reqStatusNum.equals("1"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
										if(reqStatusNum.equals("2"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1279
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
												//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
										}
										if(reqStatusNum.equals("3")|| reqStatusNum.equals("0"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoPractitioner.label","mr_labels");
									   if(reqStatusNum.equals("4"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreparedbyPractitioner.label","mr_labels");	
									   if(reqStatusNum.equals("5"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceivedbyMedicalRecord.label","mr_labels");
									   if(reqStatusNum.equals("6")){
										   //Below conditoin Added By Dharma on Apr 9th 2020 against Ml-MMOH-CRF-1314
										   if(isAcceptRequestByPractAppl.equals("true")){
										   		request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDeliveredByMR.label","mr_labels");
									   		}else{
									   			request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");	
									   		}
											
									   }
									   if(reqStatusNum.equals("7"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.statusincomplete.label","common_labels");
										if(reqStatusNum.equals("8") && !isMedicalReportRequest)
											//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelledApplication.label","mr_labels");
										if(reqStatusNum.equals("9"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD_Coordinator.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD.label","mr_labels");	
										}
										if(reqStatusNum.equals("10") && !isRejectRequestAppl )
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										if(reqStatusNum.equals("11"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AcceptedRequest.label","common_labels");
										
										if(reqStatusNum.equals("13")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
										if(reqStatusNum.equals("14"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
										if(reqStatusNum.equals("15"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");
										// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
									   
										if(reqStatusNum.equals("98"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejectedreport.label","common_labels");	
									}
									}
								
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(request_status));
            _bw.write(_wl_block87Bytes, _wl_block87);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(!call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
							if(isIncompReqCancelApplicable == true && cancelledBy != "" && reqStatusNum.equals("8")){ 
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cancelledBy));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(cancelledDate));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cancelReason));
            _bw.write(_wl_block93Bytes, _wl_block93);
 }
							else
							if(isRejectRequestAppl == true && rejected_by != "" && reqStatusNum.equals("10") && request_status.equals("Rejected Request"))	
							{
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(reject_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(reason_rejection));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}else if(isDeliveredRepModifyAppl && modificationYN.equals("Y") && modificationRemarks != "" && reqStatusNum.equals("98") && request_status.equals("Rejected Report")){//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
							
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mrp_rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(modificationRemarks.trim()));
            _bw.write(_wl_block97Bytes, _wl_block97);

							}
							else
							if(isRejectReportApplicable && mrp_rejected_by!="" && reqStatusNum.equals("98") && request_status.equals("Rejected Report"))
							{  // ADDED BY MUJAFAR FOR ML-MMOH-CRF-0714
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(mrp_rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(mrp_reason_rejection));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}else
							if(isRejectReportApplicable && request_type.equals("MR"))
							{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block98Bytes, _wl_block98);
 }
						} 
            _bw.write(_wl_block99Bytes, _wl_block99);
 
			}
			else
			{ 
		// added by mujafar for ML-MMOH-CRF-1280 START
			
            _bw.write(_wl_block100Bytes, _wl_block100);

			
					String collect_dt = rs.getString("collect_date") ;
						String collect_dt_display = "";
						if(collect_dt == null) 	{ 
							collect_dt = "&nbsp;";
							collect_dt_display = "&nbsp;";
						}else{
							collect_dt_display = DateUtils.convertDate(collect_dt,"DMYHM","en",locale);
						}
						String prepared_dt = rs.getString("PREPARED_DATE") ;
						if(prepared_dt == null) prepared_dt = "&nbsp;";
					
					for(int k=0;k<recCnt;k++)
					{ 
					String fieldName = "";
					fieldName = (String)arrList.get(k);
					if(fieldName.equals("REQUEST_ID")){
					if( (call_function.equals("RECEIVE_MEDICAL_REPORT") && prepared_dt.equals("&nbsp;")) || (call_function.equals("QUERY_DELAY_IN_MRR")) || title.equals("PREV_DEL_REPORT")){		
					
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{ 
						String request_status_des = request_status.replace(" ","_"); // added by mujafar for ML-MMOH-CRF-0714
						
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(revise_status));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("PATIENT_ID"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(appointment_date_from_vw));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(med_board_type_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(appt_ref_no_from_vw));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("request_status"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(checkForNull(rs.getString("overdue_status"),"N")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rs.getString("curr_date")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request_status_des));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
}}else if(fieldName.equals("REQUEST_DATE")){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block68Bytes, _wl_block68);
String req_date_display = rs.getString("request_date");
							if(req_date_display == null){ 
								req_date_display = "&nbsp;";
							}else{
								req_date_display = DateUtils.convertDate(req_date_display,"DMY","en",locale);
							}
							out.println(req_date_display);
							
            _bw.write(_wl_block103Bytes, _wl_block103);
}else if(fieldName.equals("PATIENT_ID")){
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_id_from_vw));
            _bw.write(_wl_block105Bytes, _wl_block105);
}else if(fieldName.equals("PATIENT_NAME")){
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(patient_name_from_vw));
            _bw.write(_wl_block107Bytes, _wl_block107);
}else if(fieldName.equals("GENDER")){
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(gender_from_vw));
            _bw.write(_wl_block108Bytes, _wl_block108);
}else if(fieldName.equals("PRACTITIONER")){
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prepare_pract_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
}else if(fieldName.equals("PENDING_ASSIGN_PRACTITIONER")){
						if(IsPendingAssignPractAvbl == true && (status_to_show.equals("9") || status_to_show.equals("11"))){
							if(pract_days >= 4)
							{ // added by mujafar for ML-MMOH-CRF-1278 
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(forwarded_hod_date));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

							}
							else{
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(forwarded_hod_date));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
}}}else if(fieldName.equals("APPL_COMP_DATE")){
						if(sum_comp_id.equals("MR_MED_REPT_15") || sum_comp_id.equals("MR_MED_REPT_20") || sum_comp_id.equals("MR_MED_REPT_28")){
						String appl_comp_dt = rs.getString("appl_completion_date") ;
						String appl_comp_dt_display = "";
						if(appl_comp_dt == null)
						{ 
							appl_comp_dt = "&nbsp;";
							appl_comp_dt_display = "&nbsp;";
						}else
						{
							appl_comp_dt_display = DateUtils.convertDate(appl_comp_dt,"DMYHM","en",locale);
						}
						
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(appl_comp_dt_display));
            _bw.write(_wl_block105Bytes, _wl_block105);
}}else if(fieldName.equals("COLLECT_DATE")){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(collect_dt_display));
            _bw.write(_wl_block110Bytes, _wl_block110);
}else if(fieldName.equals("REVISE_DATE")){
						if(call_function.equals("PREPARE_MEDICAL_REPORT")){
						
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(revised_dt));
            _bw.write(_wl_block105Bytes, _wl_block105);
}}else if(fieldName.equals("DUE_DAYS")){
						if(called_from.equals("CA")&& call_function.equals("PREPARE_MEDICAL_REPORT") && isDuedateAppl){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(due_days));
            _bw.write(_wl_block111Bytes, _wl_block111);
}}else if(fieldName.equals("REQUEST_STATUS")){
						
						if(!call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("QUERY_DELAY_IN_MRR")||(isRequestStatus_YN==true))
						{  
			/*Below line added for this CRF ML-MMOH-CRF-0712*/
				if(isMedicalReportRequest && request_status.equals("MEDICAL REPORT CANCELLED") && reqStatusNum.equals("8")){
					 request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
				}
		
			
			if(reqStatusNum.equals("99"))
				request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AutoCancelApplication.label","mr_labels");
						
				
						
            _bw.write(_wl_block112Bytes, _wl_block112);

							
							if(isOverduePractitionerApplicable && request_status.equals("OVERDUE") && request_type.equals("MR") && (reqStatusNum.equals("3")||reqStatusNum.equals("98")))
							{  
							String request_status_dump=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OverduebyPractitioner.label","mr_labels");
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(request_status_dump));
            _bw.write(_wl_block86Bytes, _wl_block86);
}else{
									if(request_type.equals("MR"))
									{
									if(request_status.equals("OVERDUE"))
									{
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Overdue.label","common_labels");
									}
									else
									{
										if(reqStatusNum.equals("1"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
										if(reqStatusNum.equals("2"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1279
											//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusCompleted.label","mr_labels");
										}
										if(reqStatusNum.equals("3")|| reqStatusNum.equals("0"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoPractitioner.label","mr_labels");
									   if(reqStatusNum.equals("4"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PreparedbyPractitioner.label","mr_labels");	
									   if(reqStatusNum.equals("5"))
										   request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceivedbyMedicalRecord.label","mr_labels");
									   if(reqStatusNum.equals("6")){
										   //Below conditoin Added By Dharma on Apr 9th 2020 against Ml-MMOH-CRF-1314
										   if(isAcceptRequestByPractAppl.equals("true")){
										   		request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDeliveredByMR.label","mr_labels");
									   		}else{
									   			request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReportDelivered.label","mr_labels");	
									   		}
									   }
										if(reqStatusNum.equals("7"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.statusincomplete.label","common_labels");
										if(reqStatusNum.equals("8") && !isMedicalReportRequest){ 
										//request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CancelledApplication.label","mr_labels");
										}
										if(reqStatusNum.equals("9"))
										{
											if(isAcceptRequestByPractAppl.equals("true")) 
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD_Coordinator.label","mr_labels");
											else
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardedtoHOD.label","mr_labels");	
										}
										if(reqStatusNum.equals("10") && !isRejectRequestAppl )
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
										if(reqStatusNum.equals("11"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AcceptedRequest.label","common_labels");
										
										if(reqStatusNum.equals("13")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
										if(reqStatusNum.equals("14"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
										if(reqStatusNum.equals("15"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");

									   
										if(reqStatusNum.equals("98"))
											request_status  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejectedreport.label","common_labels");	
									}
									}
								
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(request_status));
            _bw.write(_wl_block113Bytes, _wl_block113);
}}}else if(fieldName.equals("CANCELLED_DETAILS")){
						 if(!call_function.equals("PREPARE_MEDICAL_REPORT") && !status_to_show.equals("6")){
							if(isIncompReqCancelApplicable == true && cancelledBy != "" && reqStatusNum.equals("8")){ 
						
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cancelledBy));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(cancelledDate));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cancelReason));
            _bw.write(_wl_block93Bytes, _wl_block93);
 }
							else
							if(isRejectRequestAppl == true && rejected_by != "" && reqStatusNum.equals("10") && request_status.equals("Rejected Request"))	
							{
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(reject_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(reason_rejection));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}else if(isDeliveredRepModifyAppl && modificationYN.equals("Y") && modificationRemarks != "" && reqStatusNum.equals("98") && request_status.equals("Rejected Report")){//Added by Thamizh selvi on 24th Jan 2019 for ML-MMOH-CRF-1233
							
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mrp_rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(modificationRemarks.trim()));
            _bw.write(_wl_block97Bytes, _wl_block97);

							}
							else
							if(isRejectReportApplicable && mrp_rejected_by!="" && reqStatusNum.equals("98") && request_status.equals("Rejected Report"))
							{  // ADDED BY MUJAFAR FOR ML-MMOH-CRF-0714
							
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(mrp_rejected_by));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(mrp_reason_rejection));
            _bw.write(_wl_block93Bytes, _wl_block93);

							}else
							if(isRejectReportApplicable && request_type.equals("MR"))
							{
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block116Bytes, _wl_block116);
 }}}
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
	
			} // added by mujafar for ML-MMOH-CRF-1280 END
					
					
					i++;
					p_max_rec_cnt++;
					maxRecord++;
		}
			if ( maxRecord > 5){
			
            _bw.write(_wl_block119Bytes, _wl_block119);

			}
			else
			{
			
            _bw.write(_wl_block120Bytes, _wl_block120);

			}
			if ( maxRecord < 8 || (!rs.next())){
				
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{
            _bw.write(_wl_block122Bytes, _wl_block122);
}
		if(maxRecord == 0 && title.equals("PREV_DEL_REPORT")){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
		}else if(maxRecord == 0){	
            _bw.write(_wl_block123Bytes, _wl_block123);
}	 
		if (rs != null) rs.close();
        if (pstmt != null) stmt.close();

		
            _bw.write(_wl_block124Bytes, _wl_block124);
//}
    }catch(Exception e) {
		//out.println(e.toString());
	e.printStackTrace();}
    finally
    {
	    if(srlRS != null) 	srlRS.close();
		if(srlStmt != null) srlStmt.close();

		if (rs != null) rs.close();
        if (stmt != null) stmt.close();
		//if (iprs != null) iprs.close();
		//if (ipstmt != null) ipstmt.close();
       	//if(Cs_book != null) Cs_book.close();
		 ConnectionManager.returnConnection(con,request);

    }
	
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(request_type));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(param));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(status_to_show));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(isMedicalTeamApplicable));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(isAcceptRequestByPractAppl));
            _bw.write(_wl_block132Bytes, _wl_block132);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PrevDelMedReport.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestID.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationCompletionDates.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PendingAssgnPract.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedDate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DueDays.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestOrReportStatus.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestOrReportStatus.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestStatus.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Rejected.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CancelledOrRejectedStatus.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestID.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDate.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CollectDate.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PendingAssgnPract.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestType.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ApplicationCompletionDates.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PendingAssgnPract.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RevisedDate.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DueDays.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestOrReportStatus.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.report.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestOrReportStatus.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestStatus.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Rejected.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CancelledOrRejectedStatus.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
