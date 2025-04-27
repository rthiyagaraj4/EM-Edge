package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __medrecrequestresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequestResult.jsp", 1743670929716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<script>\n\nasync function RecodeDiagnosis(encID, PatID, ln_code, Patient_Class, sex,dob,FacilityId,practitioner_id)\n{\n\tvar call_function = \"DIAG_RECODE\";\n\t\n\tvar dialogHeight= \"72vh\";\n\tvar dialogWidth = \"65vw\";\n\tvar dialogTop\t= \"150\";\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\t//RecDiagnosis.jsp\n\t//retVal = \twindow.showModalDialog(\"../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id=\"+encID+\"&FacilityId=\"+FacilityId+\"&PatientId=\"+PatID+\"&call_function=\"+call_function+\"&location_code=\"+ln_code+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex,arguments,features);\n\n\tretVal = \tawait window.showModalDialog(\"../../eMR/jsp/DiagRecodePatProblemMain.jsp?modal_yn=Y&Encounter_Id=\"+encID+\"&ip_practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&PatientId=\"+PatID+\"&call_function=\"+call_function+\"&location_code=\"+ln_code+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex+\"&Dob=\"+dob,arguments,features);\n}\n\nfunction RecordDiagnosis(encID, PatID, ln_code, Patient_Class, sex,dob,pract_type,speciality_code,bed_num,loc_type,room_num,enc_date,FacilityId,practitioner_id)\n{\n\t\n\tvar call_function = \"RECORD_DIAGNOSIS\";\n\t//var FacilityId = document.forms[0].FacilityId.value;\n\t//var practitioner_id = document.forms[0].attend_practitioner_id.value;\n\t/*var dialogHeight= \"72\";\n\tvar dialogWidth = \"65\";\n\tvar dialogTop\t= \"150\";*/\n\tvar dialogHeight=\"41vh\";\n\tvar dialogWidth=\"65vw\";\n\tvar dialogTop=\"72\";\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n//RecDiagnosis.jsp\n\t//retVal = \twindow.showModalDialog(\"../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id=\"+encID+\"&FacilityId=\"+FacilityId+\"&PatientId=\"+PatID+\"&call_function=\"+call_function+\"&location_code=\"+ln_code+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex,arguments,features);\n\tvar action_url=\"../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id=\"+encID+\"&practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&patient_id=\"+PatID+\"&Function=\"+call_function+\"&location_code=\"+ln_code+\"&location_type=\"+loc_type+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&IP_YN=N&practitioner_type=\"+pract_type+\"&speciality_code=\"+speciality_code+\"&bed_num=\"+bed_num+\"&room_num=\"+room_num+\"&visit_adm_date=\"+enc_date;\n\t\n\t//var action_url=\"../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id=\"+encID+\"&practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&patient_id=\"+PatID+\"&Function=\"+call_function+\"&location_code=\"+ln_code+\"&location_type=\"+loc_type+\"&patient_class=\"+Patient_Class+\"&IP_YN=N&practitioner_type=\"+pract_type+\"&speciality_code=\"+speciality_code+\"&bed_num=\"+bed_num+\"&room_num=\"+room_num+\"&visit_adm_date=\"+enc_date;\n\n\tvar title=\"\";\n\n\n\t//retVal = \twindow.showModalDialog(\"../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id=\"+encID+\"&practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&patient_id=\"+PatID+\"&Function=\"+call_function+\"&location_code=\"+ln_code+\"&location_type=\"+loc_type+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&IP_YN=N&practitioner_type=\"+pract_type+\"&speciality_code=\"+speciality_code+\"&bed_num=\"+bed_num+\"&room_num=\"+room_num+\"&visit_adm_date=\"+enc_date,arguments,features);\n\tvar bodwidth  = window.screen.width+window.screen.width;\n\tvar\tbodheight = window.screen.height+window.screen.height;\n\t\n\n\twindow.open(action_url,title,\"height=\"+bodheight+\",width=\"+bodwidth+\",top=0,status=0,toolbar=no,menubar=no,location=no,left=0,right=0,bottom=0,this.minimise=no\");\n\t\n}\n\nfunction RecordProcedure(encID, PatID, ln_code, Patient_Class, sex,dob,pract_type,speciality_code,bed_num,loc_type,room_num,enc_date,FacilityId,practitioner_id)\n{\n\t\n\tvar call_function = \"PROCEDURE_RECORDING\";\n\t//var FacilityId = document.forms[0].FacilityId.value;\n\t//var practitioner_id = document.forms[0].attend_practitioner_id.value;\n\t/*var dialogHeight= \"72\";\n\tvar dialogWidth = \"65\";\n\tvar dialogTop\t= \"150\";*/\n\t/*var dialogHeight=\"41\";\n\tvar dialogWidth=\"65\";\n\tvar dialogTop=\"72\";\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;*/\n\n\t//retVal = \twindow.showModalDialog(\"../../eCA/jsp/PatProcRecordWrapper.jsp?modal_yn=Y&mode=R&encounter_id=\"+encID+\"&practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&patient_id=\"+PatID+\"&Function=\"+call_function+\"&location_code=\"+ln_code+\"&location_type=\"+loc_type+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&IP_YN=N&practitioner_type=\"+pract_type+\"&speciality_code=\"+speciality_code+\"&bed_num=\"+bed_num+\"&room_num=\"+room_num+\"&visit_adm_date=\"+enc_date,arguments,features);\n\n\t\n\tvar queryString = \"modal_yn=Y&mode=R&encounter_id=\"+encID+\"&practitioner_id=\"+practitioner_id+\"&episode_id=\"+encID+\"&FacilityId=\"+FacilityId+\"&patient_id=\"+PatID+\"&Function=\"+call_function+\"&location_code=\"+ln_code+\"&location_type=\"+loc_type+\"&patient_class=\"+Patient_Class+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&IP_YN=N&practitioner_type=\"+pract_type+\"&speciality_code=\"+speciality_code+\"&bed_num=\"+bed_num+\"&room_num=\"+room_num+\"&visit_adm_date=\"+enc_date+\"&called_from=MR\";\n\n\tvar HTMLVal = \"<html><BODY onKeyDown=\'lockKey()\'>\";\n\tHTMLVal += \"<form name=\'wrapperForm\' id=\'wrapperForm\' action=\'../../eCA/jsp/PatProcRecordWrapper.jsp?\"+queryString+\"\' method=\'post\'>\";\n\tHTMLVal += \"</form></BODY>\";\t\t\t\n\tHTMLVal += \"</html>\";\n\t\n\t//parent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t//top.content.messageFrame.document.wrapperForm.submit();\t\n\t\n\t//parent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.dummy_frame.document.write(HTMLVal);\n\tparent.dummy_frame.document.wrapperForm.submit();\t\t\n\n}\n\nasync function patientValuables(encID, PatID, locn_code, splty_code,FacilityId)\n{\n\t//var function_name=document.forms[0].call_function.value;\n\t//document.forms[0].PatientId.value=PatID;\n\t//modified for SCR 5008 \n\tvar function_name=parent.frames[1].document.forms[0].call_function.value;\n\t\n\t//Tuesday, June 09, 2009 parent.frames[1].document.forms[0].PatientId.value=PatID;\n    if(function_name== \"MR_REC_PAT_VAL\")\n\t{\n\t\tvar call_function = \"MR_REC_PAT_VAL\";\n\t\t//modified for SCR 5008 \n\t\t//var FacilityId = document.forms[0].FacilityId.value;\n\t\tvar dialogHeight= \"500px\";\n\t\tvar dialogWidth = \"1000px\";\n\t\tvar dialogTop\t= \"175\";\n\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/PatientValuablesMain.jsp?encounterId=\"+encID+\"&FacilityId=\"+FacilityId+\"&patientId=\"+PatID+\"&locn_code=\"+locn_code+\"&splty_code=\"+splty_code+\"&call_function=\"+call_function,arguments,features);\n\t}\n\telse if(function_name==\"REPRINT_PAT_VAL\")\n\t{\n\t\t\n\t\t\tdocument.forms[0].Enc_id.value\t= encID;\n\t\t\tdocument.forms[0].Pat_id.value\t= PatID;\n\t\t\tdocument.forms[0].target=\"messageFrame\";\n\t\t\tdocument.forms[0].action=\'../../servlet/eMR.PatientValuablesServlet\';\n\t\t\tdocument.forms[0].submit();\t\t\n\t}\n\telse if(function_name==\"MR_INTERNAL_REPORTS_REPRINT\")\n\t{\n\t\tif(document.getElementById(\"reportname\").value==\"MRBPATVL\")\n\t\t{\n\t\t\t//alert(function_name);\n\t\t\t//alert(PatID);\n\t\t\t//alert(encID);\n\t\t\tdocument.getElementById(\"Enc_id\").value\t= encID;\n\t\t\tdocument.getElementById(\"Pat_id\").value\t= PatID;\n\t\t\tdocument.forms[0].target=\"messageFrame\";\n\t\t\tdocument.forms[0].action=\'../../servlet/eMR.PatientValuablesServlet?call_function=\'+function_name+\'&Enc_id=\'+encID+\'&Pat_id=\'+PatID;\n\t\t\tdocument.forms[0].submit();\n\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"EncounterId\").value\t= encID;\n\t\t\tdocument.getElementById(\"Pat_id\").value\t= PatID;\n\t\t\tdocument.getElementById(\"facility_id\").value\t= FacilityId;\n\t\t\tdocument.getElementById(\"p_language_id\").value\t= document.getElementById(\"p_language_id\").value;\n\t\t\tdocument.forms[0].target=\"messageFrame\";\n\t\t\tdocument.forms[0].action=\'../../servlet/eMR.DRGCalculationServlet?req_mode=report\'+\'&EncounterId=\'+encID+\'&Pat_id=\'+PatID;\n\t\t\tdocument.forms[0].submit();\n\t\t}\n\n\t}\n\t//parent.frames[2].location.reload();\n}\n\nfunction sendtomain(encounter_id1){\n\t\t\t/* parent.window.returnValue=encounter_id1;\n\t\t\tparent.window.close(); */\n\tvar dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    \n    dialogBody.contentWindow.returnValue = encounter_id1;\n    \n    var dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); \n\t}\n\n\nasync function showModalCurEnc(enc,patid,changefunc,Patient_Class)\n{\n\t\n\tvar bl_install_yn=document.forms[0].bl_install;\n\tvar call_function = document.forms[0].call_function.value;\n\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"41vh\";\n\tvar dialogWidth = \"65vw\";\n\tvar dialogTop\t= \"72\";\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tretVal = await window.showModalDialog(\"../../eMR/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&bl_instal=\"+bl_install_yn.value+\"&call_function=\"+call_function+\"&patientId=\"+patid+\"&Patient_Class=\"+Patient_Class,arguments,features);\n\tif(retVal!=null && retVal!=\'\')\n\n\tparent.content.document.location.reload();\n}\n\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<script src=\"../../eMR/js/MedRecRequestMain.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOP/js/menu.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eMR/js/MedRecRequestResult.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/showModalDialog.js\" language=\"javascript\"></script>\n\t\n\t<style type=\"text/css\">\n\t\ttable.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}\n\t\ttable.mt th {border-width: 1px;padding: 1px;white-space: normal; text-align:left;word-wrap:normal;width:8%;}\n\t\ttable.mt td {white-space:normal;word-wrap: break-word; word-break: break-all;}\n\t</style>\n\n\t<script type=\"text/javascript\">\n\t\t$(window).on(\'load\',(function () {\n\t\t   /*Below line modified for existing issue fixed*/\n\t\t\tif(document.getElementById(\"reportname\") && document.getElementById(\"reportname\").value==\"MR\"){\n\t\t\t\tFnListAllStatus();\n\t\t\t}\n\t\t}));\n\t</script>\n\n</head>\n<body OnMouseDown=\'CodeArrest();\' onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' onKeyDown=\'lockKey()\'>\n<form name=\'MedRecRequestResult\' id=\'MedRecRequestResult\'  action=\"../../eMR/jsp/MedRecRequestResult.jsp\" method=\"post\"  >\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<div id=\"paginatoinContainer\" style=\"float:right;margin:0 50px 10px 0\"></div>\n\t<div class=\"cont\" id=\"listReportStatus\" style=\"clear:both\"></div>\n    \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<script>\n\t\tif(parent.document.getElementById(\"frmst_1\"))\t\n\t\tparent.document.getElementById(\"frmst_1\").rows=\'0%,0%,15%,*%,10%,0%,0%\'\n\t</script>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t<table width=\'100%\' id=\'navigate_table\' style=\"display:none\">\n\t\t\t\t<tr>\n\t\t\t\t\t<table align=\'right\' border=\'0\' >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t<td align =\'right\'><A HREF=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"Previous\")\' text-decoration=\'none\'  id=\'prev\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</A></td>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<td align =\'right\' ><A HREF=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",\"Next\")\' text-decoration=\'none\' style=\"display:none;\" id=\'next\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</A></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\" id=\"pat_line\" style=\"display:none\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\n\t\t\t<table border=\"1\" style=\"width: 100vw;\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t\t\t<thead id=\"table_header\" style=\"display:none\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<th align=\'center\' nowrap>&nbsp;</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="<BR><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\");\'></th>\n\t\t\t\t\t\t<!--<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<BR><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll_S(this);\'></th>-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<!-- <th align=\'center\' nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t\t\t\t\t<th align=\'center\' nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</th>\n\t\t\t</thead>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\tdocument.getElementById(\"navigate_table\").style.display=\"\";\n\t\t\t\t\t\t\t\tdocument.getElementById(\"table_header\").style.display=\"\";\n\t\t\t\t\t\t\t//-->\n\t\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' style=\"color:blue;cursor:pointer;\" onclick=\"closeWindowval(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'N\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\" >+</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<!--<td nowrap class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="><input type = \'checkbox\' name = \'chk";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'check_box\' value=\'\' onClick=\"javascript:react_chkbox(this.value,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\"/></td>-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<a href=\"javascript:RecordDiagnosis(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<a href=\"javascript:RecordProcedure(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\',\'\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t<!--<a href=\'javascript:DummyRef()\'\tonClick=\"sendtomain(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a>-->\n\t\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' style=\"color:blue;cursor:pointer;\" onclick=\"sendtomain(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td> \n\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.getElementById(\"pat_line\").style.display=\"\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t\tparent.window.close();\n\t\t\t\t\t    </script>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t</script>\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.document.getElementById(\"frmst_1\")){\n\t\t\t\t\t\t\t\t\tparent.document.getElementById(\"frmst_1\").rows=\'0%,0%,0%,*%,10%,0%,0%\'\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tif(document.getElementById(\"pat_line\")){\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"pat_line\").style.display=\"none\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t\t</script> ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\")){\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\'none\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\")){\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\'\';\n\t\t\t\t\t\t}\n\t\t\t\t</script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t</table>\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t<TR><td colspan=6 class=\"white\">&nbsp;</td></TR>\n\t\t</table>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t<TR>\n\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td> \n\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t<th class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t</TR>\n\t\t\t<input type=\'hidden\' name=\'tempIDS\' id=\'tempIDS\'  >\n\t\t\t<input type=\'hidden\' name=\'encIDS\' id=\'encIDS\' >\n\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t<script>\n\t\t\tenc_id\t= \'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\';\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n\n\t\t</script>\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<script>\n\t\t\tenc_id\t= \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n\n\t\t</script>\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t</TABLE>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\n\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >\n\t<input type=\'hidden\' name=\'PatientId\' id=\'PatientId\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" >\n\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" >\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\n\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t<input type=\'hidden\' name=\'temp1\' id=\'temp1\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t<input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t<input type=\'hidden\' name=\'lstPatientClass\' id=\'lstPatientClass\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" >\n\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" >\n\t<input type=\'hidden\' name=\'orderBy_ind\' id=\'orderBy_ind\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_exp_date\' id=\'alt_id1_exp_date\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_exp_date\' id=\'alt_id2_exp_date\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" >\n\t<input type=\'hidden\' name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" >\n\t<input type=\'hidden\' name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" >\n\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t<input type=\'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" >\n\t<input type=\'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_type\' id=\'other_alt_type\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" >\n\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t<input type=\'hidden\' name=\"selectAll_yn\" id=\"selectAll_yn\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t<input type=\'hidden\' name=\"hddEncID\" id=\"hddEncID\" value=\"\">\n\t<input type=\'hidden\' name=\"p_encounter_id\" id=\"p_encounter_id\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t<input type=\'hidden\' name=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t<input type=\'hidden\' name=\"marked_status\" id=\"marked_status\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type=\'hidden\' name=\"status_to_show\" id=\"status_to_show\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t<input type=\'hidden\' name=\"from_date\" id=\"from_date\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<input type=\'hidden\' name=\"to_date\" id=\"to_date\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\'hidden\' name=\"attend_practitioner_id\" id=\"attend_practitioner_id\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\'hidden\' name=\"Enc_id\" id=\"Enc_id\" value=\"\">\n\t<input type=\'hidden\' name=\"EncounterId\" id=\"EncounterId\" value=\"\">\n\t<input type=\'hidden\' name=\"Pat_id\" id=\"Pat_id\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\'hidden\' name=\"temp2\" id=\"temp2\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\'hidden\' name=\"enc_temp\" id=\"enc_temp\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\'hidden\' name=\"pat_temp\" id=\"pat_temp\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\'hidden\' name=\'finalSelect1\' id=\'finalSelect1\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t<input type=\'hidden\' name=\'Patient_ID\' id=\'Patient_ID\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t<input type=\'hidden\' name=\'sel_cnt\' id=\'sel_cnt\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t<input type=\'hidden\' name=\'enc_cnt\' id=\'enc_cnt\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n\t<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n\t<input type=\'hidden\' name=\'reportname\' id=\'reportname\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n\t<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t<input type=\'hidden\' name=\'discharge_val\' id=\'discharge_val\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t<br>\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\n\n<table align=\'right\'>\n\n\t<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t<td class=\'label\' >&nbsp;</td>\n\t<td class=\"button\"><input type=\'button\' name=\'select_but\' id=\'select_but\' id=\'select1\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' onClick=\"recodeModal(\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\');\"></td>\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

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
            webbeans.eCommon.RecordSet MedicalReportReq= null;synchronized(session){
                MedicalReportReq=(webbeans.eCommon.RecordSet)pageContext.getAttribute("MedicalReportReq",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(MedicalReportReq==null){
                    MedicalReportReq=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("MedicalReportReq",MedicalReportReq,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
	String locale = (String)session.getAttribute("LOCALE");
	//String loginUser = (String)session.getValue("login_user");

            _bw.write(_wl_block7Bytes, _wl_block7);
	

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//StringBuffer recode_where = new StringBuffer();

	StringBuffer where_condition = new StringBuffer();

	String call_from		=checkForNull(request.getParameter("call_from"));
	String title =request.getParameter("title")==null?"":request.getParameter("title");	
	String locn_type="";		
	String locn_code="";		
	String classValue	 = "";
	String attend_practitioner_id  = "";
	StringBuffer sqlbuff = new StringBuffer();
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String criteria =request.getParameter("criteria")==null?"":request.getParameter("criteria");
	if(criteria == null) criteria="";
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");
//	String flagSelect = request.getParameter("fromSelect")==null?"":request.getParameter("fromSelect");
	String finalSelect="",temp1="";
	String temp2="";
	String enc_temp="";
	String pat_temp="";
	String finalSelect1="";
	String status="";
	String stage_no="";
	String search_by="";

	int fetchRecord=0;
	String loc_type="";
    
	String sel_cnt = request.getParameter("sel_cnt")==null?"":request.getParameter("sel_cnt");
	String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String create_file_yn = request.getParameter("create_file_yn")==null?"N":request.getParameter("create_file_yn");

	String speciality_val = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	
	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");
	if(selectAll_yn == null) selectAll_yn="";

	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	String chkSelect=request.getParameter("chkSelect")==null?"":request.getParameter("chkSelect");
	if(chkSelect == null) chkSelect="";
//out.println("<script>alert(\"chkSelect in result"+chkSelect+"\");</script>");

	finalSelect=request.getParameter("finalSelect1")==null?"":request.getParameter("finalSelect1");
	if(finalSelect1 == null) finalSelect1="";

	status=request.getParameter("status")==null?"":request.getParameter("status");
	if(status == null) status="";

	stage_no=request.getParameter("stage_no")==null?"":request.getParameter("stage_no");
	if(stage_no == null) stage_no="";
	search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");
	if(search_by == null) search_by="";
//



	
	String Enc_Type = request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");


	String orderBy_ind=checkForNull(request.getParameter("orderBy"));
	String orderBy="";
	/*Modified on 9/28/2010 for IN024006*/
//	if(orderBy_ind.equals("") || orderBy_ind.equals("ET")){ 
	if(orderBy_ind.equals("ET")){ 
//		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') asc";
		orderBy = " a.patient_class asc";
	}else if(orderBy_ind.equals("ED")) {
		orderBy = "a.visit_adm_date_time asc";
	}
    String Patient_ID="";
	String cause_ind	=	request.getParameter("cause_ind")==null?"":request.getParameter("cause_ind");
	
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");

	if(alt_id1_exp_date == null) 
		alt_id1_exp_date="";
	else
		alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");

	

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");

	if(alt_id2_exp_date == null) 
		alt_id2_exp_date="";
	else
		alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");


	
	
	String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");


	if(!(p_discharge_date_from==null || p_discharge_date_from.equals("")))
	{
		if(p_discharge_date_from.length() >10)
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMYHM",locale,"en");
		else
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMY",locale,"en");
	}

	String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");

	if(!(p_discharge_date_to==null || p_discharge_date_to.equals("")))
	{
		if(p_discharge_date_to.length() >10)
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMYHM",locale,"en");
		else
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMY",locale,"en");
	}



	String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	if(national_id_no == null) national_id_no="";

	String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
	if(other_alt_type == null) other_alt_type="";
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";

	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";

	temp2=request.getParameter("temp2")==null?"":request.getParameter("temp2");
	if(temp2 == null) temp2="";

	enc_temp=request.getParameter("enc_temp")==null?"":request.getParameter("enc_temp");
	if(enc_temp == null) enc_temp="";

	pat_temp=request.getParameter("pat_temp")==null?"":request.getParameter("pat_temp");
	if(pat_temp == null) pat_temp="";

	String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
	String status_to_show = request.getParameter("status_to_show")==null?"":request.getParameter("status_to_show");
	String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String flag="";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
    req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	
	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String Encounter_ID="";
	
	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";

	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";
	
	//out.println("call_function" + call_function);

	String no_of_days			=request.getParameter("no_of_days");
	if(no_of_days == null) no_of_days="";
	
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";	

	if(call_function.equals("REPRINT_PAT_VAL"))
		{
			PatientId= "";
		}
	String EncounterId		=	request.getParameter("p_encounter_id") ;

	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
	if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";

	
	//String recode_action = "";

	
	String DischargeDate	=	request.getParameter("DischargeDate") ;
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";

	

	String Discharge	=	request.getParameter("discharge_val") ;
	if(Discharge	== null || Discharge.equals("null"))Discharge = "";

	String reportname	=	request.getParameter("reportname") ;
	if(reportname	== null || reportname.equals("null"))reportname = "";



	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	else
	{
		//sql = whereClause;
	}


	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" )) ;
	String modal_yn = checkForNull(request.getParameter("modal_yn")) ;
	String install_yn="";
	if(modal_yn.equals("Y"))
		install_yn =checkForNull(request.getParameter( "bl_install_yn" )) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;

//out.println("<script>alert(\""+end+"\");</script>");

        //if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        //if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }

	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

//out.println("<script>alert(\""+start+"\");</script>");
//out.println("<script>alert(\""+end+"\");</script>");

	Statement pstmt				   = null;
	PreparedStatement p_stmt  = null;
	ResultSet rs						   = null;
	Statement stmt_bl				   = null;
	ResultSet rs_bl					   = null;

	Connection conn = ConnectionManager.getConnection(request);	
try{
//Check for bl_interfaced_yn condition.......added by kishore
	if(!modal_yn.equals("Y"))
	{
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from IP_PARAM where facility_id='"+FacilityId+"'";
		try
		{
			stmt_bl=conn.createStatement();
			rs_bl=stmt_bl.executeQuery(query_bl_interface);
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
			}
		
		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(call_function.equals("MEDICAL_REPORT_REQUEST")){
	
	title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewEncounterDetails.label","mr_labels");
	out.println("<title>"+title+"</title>");
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);

int maxRecord = 0;

if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && reportname.equals("MR")){
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{

	String flagSelect = checkForNull(request.getParameter("clear"));
			        
			if(!flagSelect.equals(""))
				MedicalReportReq.clearAll();

	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("select_chk"+(i)) != null)
			 {
				
				 checkedOnes = request.getParameter("select_val"+(i));
				 if(!(MedicalReportReq.containsObject(checkedOnes)))
				 {
					  
					 MedicalReportReq.putObject(checkedOnes);
					 
				 }
				 j++;
			 }

		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
		i = 1 ;
	//String Where  = "";
	//Where  = " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ";
	where_condition.append( " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ");

	if(!PatientId.equals(""))
	{
		//Where  = Where +" and b.patient_id like '"+PatientId+"' ";
		where_condition.append(" and b.patient_id like '"+PatientId+"' ");
	}

	if(call_function.equals("TRANSMIT_NOTIFY_REP"))
	{
		//Where  = Where +" and exists (select enc_dtl.facility_id, enc_dtl.encounter_id from pr_diagnosis_enc_dtl enc_dtl, mr_term_code m where enc_dtl.term_set_id = m.term_set_id and enc_dtl.term_code = m.term_code and enc_dtl.facility_id = a.facility_id and enc_dtl.encounter_id = a.encounter_id and m.notifiable_yn = 'Y') ";

		where_condition.append("and exists (select enc_dtl.facility_id, enc_dtl.encounter_id from pr_diagnosis_enc_dtl enc_dtl, mr_term_code m where enc_dtl.term_set_id = m.term_set_id and enc_dtl.term_code = m.term_code and enc_dtl.facility_id = a.facility_id and enc_dtl.encounter_id = a.encounter_id and m.notifiable_yn = 'Y') ");
	}

	if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{
		//Where  = Where +" and EXISTS (SELECT facility_id, encounter_id FROM mr_diag_transmission WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id ) ";

		where_condition.append("and EXISTS (SELECT facility_id, encounter_id FROM mr_diag_transmission WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id ) ");
	}
	if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && reportname.equals("MRDGRCSM"))
	{

		//Where  = Where +" AND EXISTS (select 1	From	Mr_Diagnosis_Recoding_Dtl rec_dtl,Mr_Diag_Proc_Recoding_Hdr rec_hdr Where	rec_dtl.Facility_Id = rec_hdr.Facility_Id And	rec_dtl.Encounter_Id = rec_hdr.Encounter_Id	And	rec_dtl.Facility_Id = a.facility_id	And	rec_dtl.Encounter_Id = a.encounter_id And	rec_dtl.Status != 'E' And	rec_dtl.Trx_No Is Not Null And	(rec_hdr.level1_status = 'A' or rec_hdr.level2_status = 'A' or rec_hdr.level3_status = 'A'))	";

		where_condition.append("AND EXISTS (select 1	From	Mr_Diagnosis_Recoding_Dtl rec_dtl,Mr_Diag_Proc_Recoding_Hdr rec_hdr Where	rec_dtl.Facility_Id = rec_hdr.Facility_Id And	rec_dtl.Encounter_Id = rec_hdr.Encounter_Id	And	rec_dtl.Facility_Id = a.facility_id	And	rec_dtl.Encounter_Id = a.encounter_id And	rec_dtl.Status != 'E' And	rec_dtl.Trx_No Is Not Null And	(rec_hdr.level1_status = 'A' or rec_hdr.level2_status = 'A' or rec_hdr.level3_status = 'A'))	");


	}
	if(call_function.equals("MR_REC_PAT_VAL")){	
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('08','09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				where_condition.append(" and visit_status < '07' ");
			}
		}
	}else if(call_function.equals("RECORD_DIAGNOSIS") || call_function.equals("PROCEDURE_RECORDING")){
		// else if block added for  SRR20056-SCF-6679 ---IN026201
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				where_condition.append(" and visit_status not in ('99')");
			}
		}else{
				where_condition.append(" AND ((a.patient_class in ('OP','EM') and a.visit_status!=99) OR (a.patient_class in ('IP','DC') and a.adt_status !=09))");
		}

	}else{

		if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and adt_status = '08'";
				where_condition.append(" and adt_status = '08'");
			}else{
				//Where  = Where +" and adt_status not in ('08','09')";
				where_condition.append(" and adt_status not in ('09')");
			}
		}else if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
			if (Discharge.equals("Y")){
				//Where  = Where +" and visit_status in ('07','08', '09')";
				where_condition.append(" and visit_status in ('07','08', '09')");
			}else{
				//Where  = Where +" and visit_status < '07' ";
				//where_condition.append(" and visit_status < '07' ");
				where_condition.append(" and visit_status!=99 ");/**/
			}
		}else{
				where_condition.append(" AND ((a.patient_class in ('OP','EM') and a.visit_status!=99) OR (a.patient_class in ('IP','DC') and a.adt_status !=09))");
		}
	}


	if(call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
		if(cause_ind.equals(""))
		{
			//Where = Where + " and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ";

			where_condition.append(" and disposition_type in ( select discharge_type_code from ip_discharge_type where maternal_death_yn = 'Y' and eff_status = 'E') ");
		}
		else
		{
			//Where = Where + " and disposition_type ='"+cause_ind+"'  ";
			where_condition.append(" and disposition_type ='"+cause_ind+"'  ");
		}
	}

	if ( !(Enc_Type == null || Enc_Type.equals("")) )
	{
		//Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"') ";
		where_condition.append("    and PATIENT_CLASS = '"+Enc_Type+"' ");
	}
	
		if ( !(speciality_val == null || speciality_val.equals("")) )
		{
			
			//Where = Where + " and a.SPECIALTY_CODE like upper('"+speciality_val+"')  ";
			where_condition.append(" and a.SPECIALTY_CODE = '"+speciality_val+"'  ");
		}


		if ( !(location_code == null || location_code.equals("")) )
		{
			
			//Where = Where + " and a.Assign_Care_Locn_Code like upper('"+location_code+"')  ";
			where_condition.append(" and a.Assign_Care_Locn_Code like upper('"+location_code+"')  ");
		}

	/*if ( !(speciality_val == null || speciality_val.equals("")) )
	{
		Where = Where + " and a.SPECIALTY_CODE = '"+speciality_val+"' )";
	}*/

	if ( !(EncounterId == null || EncounterId.equals("")) )
	{
		//Where = Where + " and upper(a.encounter_id) like upper('"+EncounterId+"%') ";
		where_condition.append(" and a.encounter_id ='"+EncounterId+"' ");
	}

	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";

		where_condition.append(" and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
	}

	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && (alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')";
		where_condition.append(" and trunc(a.visit_adm_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')");
	}

	if ( (alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		//Where = Where + " and trunc(a.visit_adm_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
		where_condition.append(" and trunc(a.visit_adm_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
	}

	
	/*if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
	{
		Where = Where + " and a.DISCHARGE_DATE_TIME >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy hh24:mi')";
	}

	if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
	{
		Where = Where + " and a.DISCHARGE_DATE_TIME <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy hh24:mi')";
	}*/

	if ( !(national_id_no == null || national_id_no.equals("")) )
	{
		//Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
		where_condition.append(" and upper(b.NATIONAL_ID_NO) = upper('"+national_id_no+"') ");//Removed '%' after national_id_no on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
		where_condition.append("  and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
		where_condition.append(" and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
		where_condition.append(" and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}
	if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
	{
		//Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
		where_condition.append( " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}

	if ( !(other_alt_type == null || other_alt_type.equals("")) )
	{
		//Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
		where_condition.append( " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ");
	}
	if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
	{
		//Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
		where_condition.append( " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ");//Modified '=' to 'like' on 14th mar 2017 for ML-MMOH-SCF-0666
	}

	if(call_function.equals("QUERY_MARK_MLC_OSCC"))
	{
		if(PatientId.equals("") && EncounterId.equals(""))
		{
			if (mlc_oscc.equals(""))
			{
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append(  "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}	
			else if (mlc_oscc.equals("O"))
			{
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append( "and a.oscc_yn = 'Y' ");
			}	
			else if (mlc_oscc.equals("M"))
			{
				//Where = Where + "and a.mlc_yn='Y' ";
				where_condition.append("and a.mlc_yn='Y' ");

			}	
		}
		else if (!PatientId.equals("") && !EncounterId.equals(""))
		{
			if (mlc_oscc.equals("")){
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append("and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}else if (mlc_oscc.equals("O")){
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append("and a.oscc_yn = 'Y' ");
			}else if (mlc_oscc.equals("M")){
				//Where = Where + "and a.mlc_yn='Y' ";
				where_condition.append(" and a.mlc_yn='Y' ");
			}	
		}
		else if (!PatientId.equals(""))
		{
			if (mlc_oscc.equals("")){
				//Where = Where + "and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ";
				where_condition.append("and (a.mlc_yn='Y' or a.oscc_yn = 'Y') ");
			}else if (mlc_oscc.equals("O")){
				//Where = Where + "and a.oscc_yn = 'Y' ";
				where_condition.append("and a.oscc_yn = 'Y' ");
			}else if (mlc_oscc.equals("M")){
				//Where = Where + "and a.mlc_yn='Y'";
				where_condition.append("and a.mlc_yn='Y'");
			}	
		}
	}

	if((call_function.equals("MARK_MLC_OSCC") || call_function.equals("QUERY_MARK_MLC_OSCC")) && (create_file_yn.equals("Y")))
	{
		//Where  = Where +" AND EXISTS (SELECT 1 FROM mr_pat_file_index WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ";
		where_condition.append(" AND EXISTS (SELECT 1 FROM mr_pat_file_index WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ");
	}

	if(call_function.equals("MR_REC_PAT_VAL")) 
	{	
		if (Discharge.equals("Y"))
		{
			//Where = Where +"and exists ( select 1 from pr_patient_valuables where facility_id = a.facility_id and encounter_id = a.encounter_id) ";
			where_condition.append("and exists ( select 1 from pr_patient_valuables where facility_id = a.facility_id and encounter_id = a.encounter_id) ");
		}
		
	}

	if ( !(orderBy == null || orderBy.equals("")) )
	{
		//Where = Where + " order by "+orderBy+" ";
		where_condition.append(" order by "+orderBy+" ");
	}


	//out.println("modal_yn==>" +modal_yn);
	//modal_yn="N";
	if(!modal_yn.equals("Y"))
	{

		//modied the below query for this SCF SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
		sqlbuff.append(" SELECT   a.Patient_Id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time, COUNT(*) OVER () rowCount  FROM PR_ENCOUNTER a, MP_PATIENT b ");
		
		sqlbuff.append(where_condition.toString());
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
		//pstmt = conn.prepareStatement(sqlbuff.toString());
		
		//out.println("sqlbuff.toString()==>"+sqlbuff.toString());

		p_stmt = conn.prepareStatement(sqlbuff.toString());
		p_stmt.setString(1,locale);
		p_stmt.setString(2,locale);
		p_stmt.setString(3,locale);
		p_stmt.setString(4,locale);
		p_stmt.setString(5,locale);
		p_stmt.setString(6,locale);
		p_stmt.setString(7,locale);
		rs = p_stmt.executeQuery();
		/*rs.last();
		fetchRecord = rs.getRow();
		maxRecord=fetchRecord;
		rs.beforeFirst();*/
		//if(rs.next())
		  // maxRecord = rs.getInt(1);
	}
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
	int maxRecords=0;
	int nRowCount =0; // added for this SCF SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
	
            _bw.write(_wl_block14Bytes, _wl_block14);

		if(!title.equals(""))	{
				out.println("<title>"+title+"</title>");
			}
			if(call_from.equals("MAIN"))
			{
				title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterdetails.label","common_labels");
				out.println("<title>"+title+"</title>");
			}
	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		if(!flag.equals("true")){
            _bw.write(_wl_block15Bytes, _wl_block15);

									if ( !(start <= 1)){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fetchRecord));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fetchRecord));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			if(!PatientId.equals("")){
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST")){	
            _bw.write(_wl_block24Bytes, _wl_block24);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!call_function.equals("QUERY_MATERNAL_REPORT")){
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(	!call_function.equals("MARK_MLC_OSCC") && 
					!call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")&&  !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
					!call_function.equals("QUERY_MARK_MLC_OSCC") &&
					!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING") && !call_from.equals("MAIN")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
					//if(call_function.equals("DIAG_RECODE"))	{
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
//}
					
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
	if(!call_function.equals("QUERY_MARK_MLC_OSCC")){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
}	
					//if(call_function.equals("DIAG_RECODE")){
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
//}
					
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
if(call_function.equals("QUERY_MARK_MLC_OSCC") || call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL")){
						if (PatientId.equals("")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
} 
					}
					if(call_function.equals("MR_INTERNAL_REPORTS_REPRINT")){
						if (PatientId.equals("")){	
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
}
					}
					if(call_function.equals("QUERY_MATERNAL_REPORT")){	
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}	
					if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL")  && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING")){	
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

			String chkAttribute = "";
			if (rs != null){
					if (start !=1){
						for( int j=1; j<start; i++,j++ ){
						rs.next() ;
					}
				}
				while ( rs.next() && i<=end ){
					nRowCount = Integer.parseInt(rs.getString("rowCount"));//Added for SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
						if(maxRecords==0){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
						if ( i % 2 == 0 ){
							classValue = "QRYEVENSMALL" ;
						}else{
							classValue = "QRYODDSMALL" ;
						}
						Patient_ID					= rs.getString("patient_id");	
						String Patient_Name		= rs.getString("patient_name");				
						String conGender			= rs.getString("gender");				
						String Date_of_Birth		= rs.getString("birth_date");				
						String Age						= rs.getString("AGE");				
						String Patient_Class		= rs.getString("patient_class");	
						String Encounter_Date	= rs.getString("encounter_date");				
						Encounter_ID				= rs.getString("encounter_id");				
						String con_Speciality		= rs.getString("speciality_desc");				
						String specialty_code	= checkForNull(rs.getString("specialty_code"));				
						String con_Location		= rs.getString("locn_desc");				
						String con_Practitioner	= rs.getString("practitioner_name");				
						attend_practitioner_id	= rs.getString("attend_practitioner_id");				
						String room_no				= checkForNull(rs.getString("room_no"));				
						String bed_no				= checkForNull(rs.getString("bed_no"));				
						locn_type						= checkForNull(rs.getString("locn_type"));		
						locn_code						= rs.getString("locn_code");				
						String Encounter_Type = rs.getString("locn_type");
						String Patient_Class_code	 = rs.getString("patient_class_code");
						String Encounter_Date_display = "";
						String pract_type						= checkForNull(rs.getString("Pract_type"));
						loc_type									= checkForNull(rs.getString("loc_type"));
						String pat_det=Patient_ID+"`"+Encounter_ID;
						if(MedicalReportReq.containsObject(pat_det)){  
							chkAttribute = "CHECKED";
						}else{
							chkAttribute="";
						}
						out.println("<input type='hidden' name='select_val"+i+"' id='select_val"+i+"' value='"+pat_det+"'>");
						int recordIndex = MedicalReportReq.indexOfObject(pat_det);
						if(recordIndex!=-1)
						if(chkAttribute.equals("CHECKED")){
							MedicalReportReq.removeObject(recordIndex);
						}
						//String level1_status = "";
						//String level2_status = "";
						//String level3_status = "";
						//String Lvl_disp="";
						if(Patient_ID==null||Patient_ID.equals("null")){		    
							Patient_ID = "";
						}
						if(Patient_Name==null||Patient_Name.equals("null")){
							Patient_Name = "";
						}
						if(conGender==null|| conGender.equals("null")){
							conGender = "";
						}
						if(Date_of_Birth==null || Date_of_Birth.equals("null")){
							Date_of_Birth = "";
						}
						if(Patient_Class==null|| Patient_Class.equals("null")){
							Patient_Class = "";
						}
						if(Encounter_Date==null || Encounter_Date.equals("null")){
							Encounter_Date = "";
							Encounter_Date_display = "";
						}else{
							Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
						}
						if(Encounter_ID==null|| Encounter_ID.equals("null")){
							Encounter_ID = "";
						}
						if(con_Speciality==null|| con_Speciality.equals("null")){
							con_Speciality = "&nbsp;";
						}
						if(con_Location==null|| con_Location.equals("null")){
							con_Location = "&nbsp;";
						}
						if(con_Practitioner==null || con_Practitioner.equals("null")){
							con_Practitioner = "&nbsp;";
						}
						if(room_no==null || room_no.equals("null")){
							room_no = "&nbsp;";
						}
						if(bed_no==null || bed_no.equals("null")){
							bed_no = "&nbsp;";
						}
						if(locn_type==null || locn_type.equals("null")){
							locn_type = "&nbsp;";
						}
						if(Encounter_Type==null || Encounter_Type.equals("null")){
							Encounter_Type = "&nbsp;";
						}
						out.println("<tr>");

						if(!call_function.equals("QUERY_MATERNAL_REPORT"))	{
							if(call_from!=null && call_from.equals("MAIN")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Patient_ID));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Patient_Class_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
								out.println("<td  class='"+classValue+"'>");
								out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"','"+call_function+"','"+install_yn+"')\">");	
								out.print("+</a></td>");
							}
						}
						if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT")  && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING") && !call_from.equals("MAIN")){
							out.println("<td nowrap class='"+classValue+"' ><input type=checkbox name='chk"+i+"' id='chk"+i+"' id='check_box' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
						
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);

						}
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
						if(!call_function.equals("QUERY_MARK_MLC_OSCC")){
							out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
						}
						if(call_function.equals("MARK_MLC_OSCC") ){
							out.println("<td nowrap class='"+classValue+"'><a href=\"javascript:calladdmodifyMark('"+Encounter_ID+"','MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')\">"+Encounter_ID+"</a></td>");
						}else if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") || call_function.equals("MR_INTERNAL_REPORTS_REPRINT")){
							//if(reportname.equals("MRBPATVL"))
							//{
							if (!PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
								//added  FacilityId for SCR 5008 
							}else if(PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
								out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
							}
							//}
						}else if(call_function.equals("TRANSMIT_NOTIFY_REP")){
							out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososTransmissionDtls('"+Encounter_ID+"','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							//added FacilityId for SCR 4943
						}else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
							out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososConfirmationDtls('"+Encounter_ID+"','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							//added FacilityId for SCR 4943
						}else if(call_function.equals("QUERY_MARK_MLC_OSCC")){
							if (!PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");
							}else if(PatientId.equals("")){
								out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
								out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"','"+FacilityId+"')>"+Patient_ID+"</a></td>");
							}
						}else if(call_function.equals("QUERY_MATERNAL_REPORT")){	
							out.println("<td class='"+classValue+"'>");
							out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+""+"')\">");	
							out.print(""+Encounter_ID+"</a></td>");
						}else if(call_function.equals("RECORD_DIAGNOSIS")){
							//out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecordDiagnosis('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+Patient_Class_code+"','"+conGender+"','"+Date_of_Birth+"','"+pract_type+"','"+specialty_code+"','"+bed_no+"','','"+room_no+"','')>"+Encounter_ID+"</a></td>");
							out.println("<td nowrap class='"+classValue+"'>");
							
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Patient_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Patient_Class_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(conGender));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Date_of_Birth));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(loc_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Encounter_Date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else if(call_function.equals("PROCEDURE_RECORDING")){
							//out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecordProcedure('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+Patient_Class_code+"','"+conGender+"','"+Date_of_Birth+"','"+pract_type+"','"+specialty_code+"','"+bed_no+"','','"+room_no+"')>"+Encounter_ID+"</a></td>");
							out.println("<td nowrap class='"+classValue+"'>");
							
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Patient_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Patient_Class_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(conGender));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Date_of_Birth));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Encounter_Date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block58Bytes, _wl_block58);

						}else if(call_from.equals("MAIN")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{	
							out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
						}
						if(call_function.equals("QUERY_MATERNAL_REPORT")){	
							out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
						}
						if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&& !call_function.equals("DIAG_RECODE") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_INTERNAL_REPORTS_REPRINT") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("RECORD_DIAGNOSIS") && !call_function.equals("PROCEDURE_RECORDING")){	
							out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
						}
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
						//out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
						//out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
						
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block66Bytes, _wl_block66);

						out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
						out.println("</tr>");
						i++;
						maxRecords++;
					}//End of while
				}//End of If
				if(maxRecords>0){
				if(!PatientId.equals("")){
            _bw.write(_wl_block70Bytes, _wl_block70);
}
				}
			if (maxRecords==0 && !modal_yn.equals("Y")){
					if (call_from.equals("MAIN")){
            _bw.write(_wl_block71Bytes, _wl_block71);
}else if (call_function.equals("MARK_MLC_OSCC") || call_function.equals("PROCEDURE_RECORDING")){
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
            _bw.write(_wl_block73Bytes, _wl_block73);

							out.println("<script>if(parent.frames[3].name!='messageFrame'  && parent.frames[3].document.forms[0].showPrevDtls)parent.frames[3].document.forms[0].showPrevDtls.disabled=true;</script>");
							}
				}
				//if ( maxRecords<10 || (!rs.next()) ) { 
				//Above line commented and added for SKR-SCF-0970 [IN:047716] & SKR-SCF-0971 [IN:047717]
				if ( maxRecords<10 || (end >= nRowCount) ) { 
				
            _bw.write(_wl_block74Bytes, _wl_block74);
}else{
            _bw.write(_wl_block75Bytes, _wl_block75);
}
					if(rs != null)rs.close();
					if(pstmt  != null)pstmt.close();
				
            _bw.write(_wl_block76Bytes, _wl_block76);
}else{ //if(flag.equals("true"))
	/// DISPLAY IN MODAL WINDOW
	if(call_function.equals("MEDICAL_REPORT_REQUEST")){
		sqlbuff.append(" SELECT   a.Patient_Id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time FROM PR_ENCOUNTER a, MP_PATIENT b ");
		
		sqlbuff.append(where_condition.toString());
		// added by N Munisekhar on 20-AUG-2013 against RUT-SCF-0282 [IN:042499]
		sqlbuff.append(" order by "+orderBy_ind+" ");
		//if(rs != null)rs.close();
		//if(pstmt  != null)pstmt.close();
		//pstmt = conn.prepareStatement(sqlbuff.toString());					
		p_stmt = conn.prepareStatement(sqlbuff.toString());
		p_stmt.setString(1,locale);
		p_stmt.setString(2,locale);
		p_stmt.setString(3,locale);
		p_stmt.setString(4,locale);
		p_stmt.setString(5,locale);
		p_stmt.setString(6,locale);
		p_stmt.setString(7,locale);
		rs = p_stmt.executeQuery();
	}
	
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);


//	out.println("<script>alert(\"chkSelect "+chkSelect+"\");</script>");

	if(!chkSelect.equals("") && !chkSelect.equals("SELECTALL"))
	{
		TreeMap ssm=new TreeMap();
		String selitem="";
		selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
		if(!selitem.equals("")){
		selitem=selitem.substring(1);
		selitem=selitem.substring(0,selitem.length()-1);
		}
		
		StringTokenizer st=new StringTokenizer(chkSelect,"~");	
		

		int temp=st.countTokens();
		String practId="";
		/*String objName="";*/
		String enable_dis="";
		for(int u2=0;u2<temp;u2++)
		{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			practId=st1.nextToken();
			st1.nextToken();
			enable_dis=st1.nextToken(); 			
			if(enable_dis.equals("E")) 
			ssm.put(practId,practId);
			else
			{
				if(ssm.containsKey(practId))
				ssm.remove(practId);
			}
		}


		//StringTokenizer st=new StringTokenizer(selitem,",");
		/*st=new StringTokenizer(selitem,",");
		while(st.hasMoreTokens())
		{
			String key=st.nextToken();			
			ssm.put(key,key);
		}*/
//out.println("RS====>" +rs);
		if (rs != null)
		{
			//if (start != 1 )
			//for(int j=1; j<start; i++,j++ )
			//rs.next() ;
			int clsCnt=1;

		while(rs.next())
		{   
			if(ssm.containsKey(new String(i+"")))
			{  
				
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Age=rs.getString("AGE");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
//				String specialty_code=rs.getString("specialty_code");				
				String con_Location=rs.getString("locn_desc");				
//				locn_code=rs.getString("locn_code");				
				String con_Practitioner=rs.getString("practitioner_name");				
				attend_practitioner_id=rs.getString("attend_practitioner_id");		
				//String pract_type = checkForNull(rs.getString("Pract_type"));
				locn_type=rs.getString("locn_type");	
				String Encounter_Date_display = "";
				if(locn_type==null	      || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("discharge_date_time");	
				String Dis_dateTime_display = "";
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
				{
					Dis_dateTime = "&nbsp;";
					Dis_dateTime_display = "&nbsp;";
				}
				else
					Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "&nbsp";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
				if(Age==null	  || Age.equals("null"))		Age = "&nbsp;";
				if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
				
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
				{
					Encounter_Date = "";
					Encounter_Date_display = "";
				}
				else
					Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
				
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))		Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))		con_Speciality = "&nbsp;";
				if(con_Location==null	  || con_Location.equals("null"))		con_Location = "&nbsp;";
				if(con_Practitioner==null || con_Practitioner.equals("null"))	con_Practitioner = "&nbsp;";
				out.println("<tr>");				
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
				out.println("</tr>");
				clsCnt++;
	
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rs.getString("encounter_id")));
            _bw.write(_wl_block83Bytes, _wl_block83);

				}
				i++;
			}
			if(clsCnt == 1)
			{
				out.println("<script>alert(getMessage('ENC_CANNOT_BLANK','MR'));parent.window.close();</script>");
				
			}
		}
	}
	else if(chkSelect.equals("") || chkSelect.equals("SELECTALL"))
	{


		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVENSMALL" ;
				else
					classValue = "QRYODDSMALL" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Age=rs.getString("AGE");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
//				String specialty_code=rs.getString("specialty_code");				
				String con_Location=rs.getString("locn_desc");				
//				locn_code=rs.getString("locn_code");				
				String con_Practitioner=rs.getString("practitioner_name");			
				attend_practitioner_id=rs.getString("attend_practitioner_id");			
				locn_type=rs.getString("locn_type");
				//String pract_type = checkForNull(rs.getString("Pract_type"));
				
				String Encounter_Date_display = "";
				if(locn_type==null || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
				String Dis_dateTime_display = "&nbsp;";
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
				{
					Dis_dateTime = "&nbsp;";
					Dis_dateTime_display = "&nbsp;";
				}
				else
					Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))
					Patient_Name = "";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
					Date_of_Birth = "";
				if(Age==null	  || Age.equals("null"))
					Age = "";
				if(Patient_Class==null	  || Patient_Class.equals("null"))
					Patient_Class = "";
				
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
				{
					Encounter_Date = "";
					Encounter_Date_display = "";
				}
				else
					Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);

				if(Encounter_ID==null	  || Encounter_ID.equals("null"))
					Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))
					con_Speciality = "";
				if(con_Location==null	  || con_Location.equals("null"))
					con_Location = "";
				if(con_Practitioner==null || con_Practitioner.equals("null"))
					con_Practitioner = "";
				out.println("<tr>");				
//				out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
				out.println("</tr>");


            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block85Bytes, _wl_block85);
	

				clsCnt++;
				i++;
			}
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
	}// E.O SelectAll
	
            _bw.write(_wl_block86Bytes, _wl_block86);
}	}
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(module));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(start));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(end));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(temp1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(criteria));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Enc_Type));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(orderBy_ind));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(p_discharge_date_from));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(p_discharge_date_to));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(other_alt_type));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(other_alt_Id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(selectAll_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(mlc_oscc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(status_to_show));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(temp2));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(enc_temp));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(pat_temp));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(finalSelect1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(status));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(Patient_ID));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(speciality_val));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(sel_cnt));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(reportname));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(start));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(end));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(Discharge));
            _bw.write(_wl_block152Bytes, _wl_block152);

if(!finalSelect.equals("SELECTALL")){
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName="";
	String enable_dis="";
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		//st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		//else
			//out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if(call_function.equals("DIAG_RECODE") && maxRecord != 0)
	{


            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Select.label","mr_labels")));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(fetchRecord));
            _bw.write(_wl_block155Bytes, _wl_block155);

	}



}catch ( Exception e ){ 
	e.printStackTrace();
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
	session.setAttribute("MedicalReportReq", MedicalReportReq);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block156Bytes, _wl_block156);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specialty.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
}
