package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;

public final class __aebedavailchartgraphicresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEBedAvailChartGraphicResult.jsp", 1743148881919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<meta http-equiv=\"REFRESH\" content=\"600\">\n<html>\n\n\t<head>\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3_0 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<script>\n\t\t\tvar bodwidth=0\n\t\t\tvar bodheight=0\n\n\t\t\tfunction buildTable(val)\n\t\t\t{\n\t\t\t\tvar rowval = val.split (\"<br>\");\n\t\t\t\tvar nowrapval = \"\";\n\t\t\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\"\n\n\t\t\t\tfor( var i=0; i<rowval.length; i++ )\n\t\t\t\t{\n\t\t\t\t\tif(rowval.length > 6)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar tempValue = i/2;\n\n\t\t\t\t\t\tif(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6)\n\t\t\t\t\t\t\ttab_dat += \"<tr>\"\n\n\t\t\t\t\t\tvar colval = rowval[i].split(\"��\")\n\t\t\t\t\t\tif (colval[0] != \"Blocked Remarks\")\n\t\t\t\t\t\t\t\tnowrapval = \"nowrap\";\n\t\t\t\t\t\telse\tnowrapval = \"\";\n\t\t\t\t\t\tif (colval[0] != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\ttab_dat += \"<td class = \'label\' nowrap align= \'right\'> \"+ colval[0] +\": </td>\"\n\t\t\t\t\t\t\ttab_dat += \"<td class = \'QUERYDATA\' \"+nowrapval+\"> \"+ colval[1] +\" </td>\"\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5)\n\t\t\t\t\t\t\ttab_dat += \"</tr> \"\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar colval = rowval[i].split(\"��\")\n\t\t\t\t\t\tif (colval[0] != \"Blocked Remarks\")\n\t\t\t\t\t\t\t\tnowrapval = \"nowrap\";\n\t\t\t\t\t\telse\tnowrapval = \"\";\n\t\t\t\t\t\tif (colval[0] != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\ttab_dat += \"<tr>\"\n\t\t\t\t\t\ttab_dat += \"<td class = \'label\' nowrap align= \'right\'> \"+ colval[0] +\": </td>\"\n\t\t\t\t\t\ttab_dat += \"<td class = \'QUERYDATA\' \"+nowrapval+\" > \"+ colval[1] +\" </td>\"\n\t\t\t\t\t\ttab_dat += \"</tr> \"\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\ttab_dat += \"</table> \"\n\t\t\t\tif (document.getElementById(\"t\") != null)\n\t\t\t\t\tdocument.getElementById(\"t\").innerHTML = tab_dat\n\t\t\t}\n\n\t\t\tfunction displayToolTip(val,obj)\n\t\t\t{\n\t\t\t\tval = unescape(val)\n\t\t\t\tbuildTable (val)\n\t\t\t\tbodwidth = parent.frames[1].document.body.offsetWidth\n\t\t\t\tbodheight = parent.frames[1].document.body.offsetHeight\n\n\t\t\t\tvar x =event.x\n\t\t\t\tvar y =event.y;\n\t\t\t\t\n\t\t\t\t\tvar x1=x;\n\t\t\t\t\tvar y1=y;\n\t\t\t\tx = x + (document.getElementById(\"tooltiplayer\").offsetWidth)\n\t\t\t\ty = y + (document.getElementById(\"tooltiplayer\").offsetHeight)\n\n\t\t\t\tif(x<bodwidth)\n\t\t\t\t\tx =event.x \n\t\t\t\telse\n\t\t\t\t\tx = x - (document.getElementById(\"tooltiplayer\").offsetWidth*2)\n\n\t\t\t\tif(y<bodheight )\n\t\t\t\t\ty =event.y\n\t\t\t\telse if(event.y>bodheight)\n\t\t\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2)\n\t\t\t\telse\n\t\t\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight);\n\n\t\t\t\t\ty+=document.body.scrollTop\n\t\t\t\t\tx+=document.body.scrollLeft \n\n\n\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x\n\n\t\t\t\t\tif(document.getElementById(\"tooltiplayer\").offsetWidth > 250)\n\t\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posLeft = 111\t\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posLeft = 275 \n\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.posTop = y \n\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\' \n\t\t\t}\n\n\t\t\tfunction hideToolTip()\n\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'hidden\'\n\t\t\t}\n\t\t\t\n\t\t\tvar val2;\n\n\t\t\tasync function closeWin(val,val2,clinic_code,clinic_desc,clinic_type,patient_id, queue_status, encounter_id, triage_area, trauma_yn, treatment_area_code,practitioner_id, practitioner_name,treatment_area_desc, open_to_all_prac_for_clinic_yn, check_in_date_time, sys_date_time, queue_date, patient_gender,brought_dead,assign_tmt_area_time,open_to_all_pract_yn,patient_class,current_status,date_of_birth,fs_locn_code,patient_name,info)\n\t\t\t{\t\t\n\t\t\t\t\n\t\t\t\tif(current_status==\'R\'){\n\t\t\t\t\tvar retVal\t\t\t=\t\"\";\n\t\t\t\t\tvar selection_mode\t=\t\"\";\n\t\t\t\t\tvar query_string\t=\t\"\";\n\t\t\t\t\tvar dialogHeight\t=\t\"0\";\n\t\t\t\t\tvar dialogWidth\t\t=\t\"12vw\" ;\n\t\t\t\t\tvar dialogTop\t\t=\t\"190\";\n\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\n\n\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMPAllowedOperationMain.jsp?detail_fn=Y&fn=un_reserve_bed\";\n\t\t\t\t\n\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status + \";\";\n\t\t\t\t\tretVal\t\t\t\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tif(retVal!=null){\n\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eAE/jsp/Insbedpat.jsp\'><input name=\'mode\' id=\'mode\' type=\'hidden\' value=\'UnreserveBed\'><input name=\'clinic_code\' id=\'clinic_code\' type=\'hidden\' value=\'\"+clinic_code+\"\'><input name=\'treatment_area_code\' id=\'treatment_area_code\' type=\'hidden\' value=\'\"+treatment_area_code+\"\'><input name=\'bed_no\' id=\'bed_no\' type=\'hidden\' value=\'\"+val+\"\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\tparent.parent.frames[2].document.form1.submit();\n\t\t\t\t\t}\n\t\t\t\t}else if(current_status==\'A\'){\n\t\t\t\t\t\tvar str=parent.frames[3].document.forms[0].chk_Select.value;\n\n\t\t\t\t\t\tif(str != \'\'){\n\t\t\t\t\t\t\tstr=str.split(\"*\");\n\t\t\t\t\t\t\tvar pat_id=str[0];\n\t\t\t\t\t\t\tvar enc_id=str[1];\n\t\t\t\t\t\t\tvar service_id=str[2];\n\t\t\t\t\t\t\tvar pract_id=str[3];\n\t\t\t\t\t\t\tvar msg=getMessage(\"ASSIGN_BED_YN\",\"AE\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'$\',val)\n\n\t\t\t\t\t\t\tif(window.confirm(msg+\' \'+pat_id+\'?\')){\n\t\t\t\t\t\t\t\tif(pract_id==\'\')\n\t\t\t\t\t\t\t\t\tpract_id=\"*All\";\n\n\t\t\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eAE/jsp/Insbedpat.jsp\'><input name=\'mode\' id=\'mode\' type=\'hidden\' value=\'BookBed\'><input name=\'clinic_code\' id=\'clinic_code\' type=\'hidden\' value=\'\"+clinic_code+\"\'><input name=\'practitioner_id\' id=\'practitioner_id\' type=\'hidden\' value=\'\"+pract_id+\"\'><input name=\'encounter_id\' id=\'encounter_id\' type=\'hidden\' value=\'\"+enc_id+\"\'><input name=\'treatment_area_code\' id=\'treatment_area_code\' type=\'hidden\' value=\'\"+treatment_area_code+\"\'><input name=\'bed_no\' id=\'bed_no\' type=\'hidden\' value=\'\"+val+\"\'><input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value=\'\"+pat_id+\"\'><input name=\'service_code\' id=\'service_code\' type=\'hidden\' value=\'\"+service_id+\"\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\t\t\tparent.parent.frames[2].document.form1.submit();\n\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tvar retVal\t\t\t=\t\"\";\n\t\t\t\t\t\t\tvar selection_mode\t=\t\"\";\n\t\t\t\t\t\t\tvar query_string\t=\t\"\";\n\t\t\t\t\t\t\tvar dialogHeight\t=\t\"1vh\";\n\t\t\t\t\t\t\tvar dialogWidth\t\t=\t\"12vw\" ;\n\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"190\";\n\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\t\t\t\t\t\t\n\t\t\t\n\n\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMPAllowedOperationMain.jsp?detail_fn=Y&fn=reserve_bed\";\n\n\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status + \";\";\n\t\t\t\t\t\t\tretVal\t\t\t\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\tif(retVal!=null){\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tselection_mode\t\t=\t\"ReserveBed\";\n\t\t\t\t\t\t\t\tvar dialogHeight\t=\t\"29vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t=\t\"35vw\";\n\t\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"150\";\n\t\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEReserveBedMain.jsp?clinic_code=\"+clinic_code+\"&treatment_area_code=\"+treatment_area_code+\"&bedno=\"+val+\"&clinic_desc=\"+clinic_desc+\"&treatment_area_desc=\"+treatment_area_desc+\"&home_reqd_yn=N&module_id=AE&function_id=AE_RESERVE_BED&function_name=Reserve%20Bay&function_type=F&menu_id=AE_TRANSACTIONS&access=NYNNN\";\n\n\n\n\t\t\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\"+dialogHeight+\"; dialogWidth:\" + dialogWidth + \"; status:no; scroll:no; dialogTop:\"+dialogTop+\";\";\n\t\t\t\t\t\t\t\tretVal\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\tif(retVal!=null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(retVal==\"Success\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].refresh.click();\n\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\n\n\t\t\t\t\t}else if(current_status==\'O\'){\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar retVal\t\t\t=\t\"\";\n\t\t\t\t\t\tvar selection_mode\t=\t\"\";\n\t\t\t\t\t\tvar query_string\t=\t\"\";\n\t\t\t\t\t\tvar dialogHeight\t=\t\"20.5vh\";\n\t\t\t\t\t\tvar dialogWidth\t\t=\t\"12vw\" ;\n\t\t\t\t\t\tvar dialogTop\t\t=\t\"50\";\n\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar highrisk=\"\";\n\t\t\t\t\t\tvar allergy=\"\";\n\t\t\t\t\t\n\t\t\t\t\t\tvar conditions=info.split(\"/\");\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar highrisk=conditions[0];\n\t\t\t\t\t\tvar allergy=conditions[1];\n\t\t\t\t\t\tvar result=conditions[2];\n\n\t\t\t\t\t\tif(highrisk){\n\t\t\t\t\t\t\thighrisk=\'Y\';\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\thighrisk=\'N\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(allergy){\n\t\t\t\t\t\t\tallergy=\'Y\';\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tallergy=\'N\';\n\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tquery_string\t\t= \"patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&queue_status=\"+queue_status+\"&triage_area=\"+triage_area+\"&trauma_yn=\"+trauma_yn+\"&open_to_all_pract_yn=\"+open_to_all_pract_yn+\"&clinic_code=\"+clinic_code+\"&clinic_type=\"+clinic_type+\"&queue_date=\"+queue_date+\"&encounter_id=\"+encounter_id+\"&assign_tmt_area_time=\"+assign_tmt_area_time+\"&brought_dead=\"+brought_dead+\"&orig_tmt_area_code=\"+treatment_area_code+\"&treatment_area_code=\"+treatment_area_code+\"&practitioner_id=\"+practitioner_id+\"&clinic_desc=\"+escape(clinic_desc)+\"&treatment_area_desc=\"+escape(treatment_area_desc)+\"&open_to_all_prac_for_clinic_yn=\"+open_to_all_prac_for_clinic_yn+\"&check_in_date_time=\"+check_in_date_time+\"&sys_date_time=\"+sys_date_time+\"&patient_gender=\"+patient_gender+\"&open_to_all_pract_yn=\"+open_to_all_pract_yn+\"&practitioner_name=\"+escape(practitioner_name);\n\t\t\t\n\n\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMPAllowedOperationMain.jsp?detail_fn=Y&selection_mode=\"+retVal+\"&\"+query_string+\"&info=\"+info+\"&allergy=\"+allergy+\"&highrisk=\"+highrisk;\n\n\t\t\t\t\t\t\n\t\t\t\t\t\tqueue_status=\'04\';\n\n\t\t\t\t\t\tif(queue_status==\"01\") dialogHeight\t=\t\"10\" ;\n\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\" + dialogTop +\" ; scroll=no; status:\" + status + \";\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tretVal\t\t\t\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif (retVal != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif( retVal==\"AssignTreatmentArea\" || retVal==\"AssignReassignPractitioner\" || retVal==\"ReassignTreatmentArea\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tselection_mode\t\t=\t\"AssignTreatmentArea\";\n\t\t\t\t\t\t\t\tvar dialogHeight\t=\t\"22vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t=\t\"28vw\";\n\t\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"150\";\n\t\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=\"+retVal+\"&\"+query_string+\"&bed_no=\"+val+\"&practitioner_name=\"+escape(practitioner_name)+\"&tmt_area_code=\"+treatment_area_code;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar ";
    private final static byte[]  _wl_block3_0Bytes = _getBytes( _wl_block3_0 );

    private final static java.lang.String  _wl_block3_1 ="features\t\t=\t\"dialogHeight:\"+dialogHeight+\"; dialogWidth:\" + dialogWidth + \"; status:no; scroll:no; dialogTop:\"+dialogTop+\";\";\n\n\t\t\t\t\t\t\t\tretVal\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\tif(retVal!=null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(retVal==\"Success\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].refresh.click();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"StartConsultation\")\n\t\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight\t=\t\"13vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t=\t\"40vw\";\n\t\t\t\t\t\t\t\tvar dialogTop\t\t=\t\"150\";\n\t\t\t\t\t\t\t\tvar status\t\t\t=\t\"no\";\n\t\t\t\t\t\t\t\tvar arguments\t\t=\t\"\" ;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=\"+retVal+\"&\"+query_string;\n\t\t\t\t\t\t\t\tvar features\t\t=\t\"dialogHeight:\"+dialogHeight+\"; dialogWidth:\" + dialogWidth + \"; status:no; scroll:no; dialogTop:\"+dialogTop+\";\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tretVal\t=await\twindow.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\tif(retVal!=null)\n\t\t\t\t\t\t\t\t\tif(retVal==\"Success\")\n\t\t\t\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].refresh.click();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"PrimaryAssessment\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\t\t\t\tvar dialogHeight= \"37vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"54\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/PrimaryAssessmentFrameset.jsp?\"+query_string;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"TraumaAssessment\")\n\t\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\t\t\t\tvar dialogHeight= \"34vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"54\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/SecondaryAssessmentFrameset.jsp?\"+query_string;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"TraumaScore\")\n\t\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\t\t\t\tvar dialogHeight= \"34vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"54\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/TraumaScoreFrameset.jsp?modify_flag=N&\"+query_string;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t}//ViewPatHistoryDetails\n\t\t\t\t\t\t\telse if(retVal==\"Triage\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(\"../../eAE/jsp/AETriageFrameset.jsp?selection_mode=\"+retVal+\"&\"+query_string,arguments,features);\n\t\t\t\t\t\t\t}else if(retVal==\"ChartHistory\"){\n\t\t\t\t\t\t\t\tvar param = \"../../eCA/jsp/InvokePatientHistoryAE.jsp?patient_id=\"+patient_id+\"&child_window=Y&from_service_yn=Y&episode_id=&reln_req_yn=N&CA=Y&relationship_id=O&episode_type=&mode=V&location_code=\"+clinic_code+\"&location_type=\"+clinic_type+\"&patient_class=EM\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\twindow.open(param,\'\',\'height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no\');\n\t\t\t\t\t\t\t}else if(retVal==\"RecordNotes\"){\n\t\t\t\t\t\t\t\tvar pline=patient_id+\"/\"+patient_name;\n\t\t\t\t\t\t\t\tvar action_url\t=\t\"../../eCA/jsp/RecClinicalNotesModal.jsp?patient_id=\"+patient_id+\"&visit_id=&episode_id=\"+encounter_id+\"&bed_num=\"+val+\"&room_num=&episode_type=O&visit_adm_date=13/05/2004%2020:20&patient_class=EM&PQ=Y&CA=Y&title=\"+pline;\n\t\t\t\t\t\t\t\tvar child_window\t=\twindow.open(action_url,null,\"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no\");\n\t\t\t\t\t\t\t\tchild_window.focus();\n\n\t\t\t\t\t\t\t}else if(retVal==\"ViewAllergies\"){\n\n\t\t\t\t\t\t\t\tvar pline=patient_id+\"/\"+patient_name;\n\t\t\t\t\t\t\t\tvar dialogHeight= \"9vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"25vw\" ;\n\t\t\t\t\t\t\t\tvar features    = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; status=no;\';\n\t\t\t\t\t\t\t\tvar retVal=\tawait window.showModalDialog(\"../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id=\"+patient_id+\"&modal_yn=Y\",arguments,features);\n\n\t\t\t\t\t\t\t}else if(retVal==\"ViewHighRisk\"){\n\t\t\t\t\t\t\t\tvar pline=patient_id+\"/\"+patient_name;\n\n\t\t\t\t\t\t\t\tvar dialogHeight= \"9vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"25vw\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" \n\t\t\t\t\t\t\t\tvar arguments   = \'\';\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar url =\"../../eCA/jsp/AuthorizeMRAccess.jsp?Patient_Id=\"+patient_id+\"&modal_yn=Y&constr=V/HR/D\";\n\t\t\t\t\t\t\t\tvar retVal=\tawait window.showModalDialog(url,arguments,features);\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tif(retVal!=null){\n\t\t\t\t\t\t\t\t\tif(retVal==\'T\'){\n\t\t\t\t\t\t\t\t\t\tdialogHeight    = \'9vh\';\n\t\t\t\t\t\t\t\t\t\tdialogWidth = \'25vw\';\n\t\t\t\t\t\t\t\t\t\tfeatures    = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; status=no;\';\n\t\t\t\t\t\t\t\t\t\tif(retVal ==\"T\"){\n\t\t\t\t\t\t\t\t\t\t\tvar retVal=await window.showModalDialog(\'../../eCA/jsp/PatHighRiskQueryResult.jsp?Patient_Id=\'+patient_id+\'&modal_yn=Y\',arguments,features);\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t}else if(retVal==\"MedicationAdministration\"){\n\t\t\t\t\t\t\t\tvar action_url\t=\t\"../../ePH/jsp/MedicationAdministration.jsp?called_from=CA&clinic_code=\"+clinic_code+\"&facility_id=&date_from=&date_to=&order_include=B&patient_id=\"+patient_id+\"&admin_status=A\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal = await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t}else if(retVal==\"ViewResults\"){\n\t\t\t\t\t\t\t\tvar param = \"../../eOR/jsp/PatientPendingOrders.jsp?Patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(param,arguments,features);\n\n\t\t\t\t\t\t\t}else if(retVal==\"ReviewResults\"){\n\t\t\t\t\t\t\t\tvar param = \"../../eOR/jsp/ReviewResults.jsp?patient_id=\"+patient_id;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal = await window.showModalDialog(param,arguments,features);\n\t\t\t\t\t\t\t\t}else if(retVal==\"RequestFile\"){\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\tvar param = \"../../eFM/jsp/FMRequestFiles.jsp?module_id=FM&function_id=FM_REQUEST_FILES&function_name=Request File&function_type=F&menu_id=FM_TRANSACTIONS&access=NYNNN&patient_id=\"+patient_id+\"&location_identity=C&clinic_code=\"+clinic_code+\"&fs_locn_code=\"+fs_locn_code+\"&ae=Y\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(param,arguments,features);\n\n\t\t\t\t\t\t\t\t}else if(retVal==\"Charting\"){\n\n\t\t\t\t\t\t\t\tvar pline=patient_id+\"/\"+patient_name;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar action_url=\"../../eNM/jsp/ChartInModal.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&patient_class=EM&Dob=\"+date_of_birth+\"&Sex=\"+patient_gender+\"&title=\"+pline;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar child_window\t=\twindow.open(action_url,null,\"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no\");\n\t\t\t\t\t\t\t\tchild_window.focus();\n\t\t\t\t\t\t\t}else if(retVal==\"ViewAEDetails\"){\n\n\t\t\t\t\t\t\t\tvar url\t= \"../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID=\"+patient_id+\"&EncounterId=\"+encounter_id;\n\t\t\t\t\t\t\t\tvar dialogTop\t\t= \"85\";\n\t\t\t\t\t\t\t\tvar dialogHeight\t= \"38vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t= \"64vw\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n\t\t\t\t\t\t\t\tvar returnval =await window.showModalDialog( url, arguments, features ) ;\n\n\t\t\t\t\t\t\t}else if(retVal==\"PatientTracking\"){\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar url\t= \"../../eOP/jsp/ArrivedDeparted.jsp?module_id=OP&function_id=REC_PATIENT_MOVEMENT&function_name=Record%20Patient%20Movement&function_type=F&menu_id=OPDTRANS&access=NNNNN\";\n\t\t\t\t\t\t\t\tvar dialogTop\t\t= \"70\";\n\t\t\t\t\t\t\t\tvar dialogHeight\t= \"36vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t= \"50vw\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n\t\t\t\t\t\t\t\tvar returnval =await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t}else if(retVal==\"PlaceOrder\"){\n\t\t\t\t\t\t\t\tvar pline=patient_id+\"/\"+patient_name;\n\t\t\t\t\t\t\t\tvar param = \"../../eOR/jsp/OrderEntryModalMain.jsp?p_called_from_ca =Y&option_id=NEW_ORDER1&patient_id=\"+patient_id+\"&visit_id=&episode_id=\"+encounter_id+\"&location_code=\"+clinic_code+\"&location_type=C&bed_num=&room_num=&episode_type=O&discharge_date=&visit_adm_date=18/05/2004%2014:21&episode_Status=undefined&Sex=M&Age=28Y&Dob=22/03/1976&security_level=&protection_ind=&reln_req_yn=N&patient_class=EM&PQ=Y&CA=Y&relationship_id=&window_name=PR00000061100003110001&child_window=Y&child_window=Y&mode=R&mode=R&function_name=AE&title=\"+pline;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight= \"32vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"50vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"60\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \" \";\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(param,arguments,features);\n\n\n\t\t\t\t\t\t\t}else if(retVal==\"CheckOut\"";
    private final static byte[]  _wl_block3_1Bytes = _getBytes( _wl_block3_1 );

    private final static java.lang.String  _wl_block3_2 =")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tLoadChkOut(encounter_id,brought_dead,treatment_area_code,patient_id,open_to_all_prac_for_clinic_yn,clinic_code,open_to_all_pract_yn)\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"ViewPatient\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar url\t\t\t= \"../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID=\"+patient_id+\"&EncounterId=\"+encounter_id;\n\t\t\t\t\t\t\t\tvar dialogTop\t\t= \"85\";\n\t\t\t\t\t\t\t\tvar dialogHeight\t= \"38vh\";\n\t\t\t\t\t\t\t\tvar dialogWidth\t\t= \"64vw\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n\t\t\t\t\t\t\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(retVal==\"MovementHistory\")\n\t\t\t\t\t\t\t{// Added/Modified by Nanda - 11/14/2002\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = \"\";\n\t\t\t\t\t\t\t\tvar dialogHeight= \"15vh\" ;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"40vw\" ;\n\t\t\t\t\t\t\t\tvar dialogTop =\"150\";\n\t\t\t\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\t\t\t\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AEMovementHistoryMain.jsp?modify_flag=N&\"+query_string;\n\t\t\t\t\t\t\t\tretVal =await window.showModalDialog(action_url,arguments,features);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t \n\t\t\t\t\t}\n\t\t\t}\t\n\n\t\t\tfunction resetValues()\n\t\t\t{\n\t\t\t\t\n\t\t\t\t//parent.processBar.document.location.href = \"../../eCommon/html/blank.html\";\n\n\t\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block3_2Bytes = _getBytes( _wl_block3_2 );

    private final static java.lang.String  _wl_block4 ="\n\n\t<body  id=\'b\' onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<script> \n\t\t\t\tresetValues(); \n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\')); \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</table>\n\n\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<script>\n\t\t\t//parent.processBar.document.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t//parent.criteria0.document.AEBedAvailChartForm.clinic_code.disabled = true;\n\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
  
			public String specialCharacter(String single)
			{
				StringBuffer sb = new StringBuffer(single);
					return (sb.toString());
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3_0Bytes, _wl_block3_0);
            _bw.write(_wl_block3_1Bytes, _wl_block3_1);
            _bw.write(_wl_block3_2Bytes, _wl_block3_2);

			request.setCharacterEncoding("UTF-8");
			Connection	con			= null;
			java.sql.Statement	stmt		= null;
			ResultSet	rs			= null;
			java.sql.Statement stmt_cnt		= null;
			ResultSet rs_cnt		= null;
			PreparedStatement pstmt = null;
    	    String locale					= (String)session.getAttribute("LOCALE");
			String facility_id			= checkForNull((String) session.getAttribute("facility_id"));
			String clinic_code			= checkForNull(request.getParameter("clinic_code"));
			String treatment_area		= checkForNull(request.getParameter("treatment_area_code"));
			String bed_no				= checkForNull(request.getParameter("bed_no"));
			String gender				= checkForNull(request.getParameter("gender"));
			String bed_status			= checkForNull(request.getParameter("bed_status"));
			String treatment_area_code_prev		= "" ;
			String disp_content="";
			String info="";

			String practitioner_id1= checkForNull(request.getParameter("practitioner_id"));
			String priority1	= checkForNull(request.getParameter("priority"));
			String patient_id1			= checkForNull(request.getParameter("patient_id"));
			String patient_id			= checkForNull(request.getParameter("patient_id"));

			String SERVICE_DESC="";
			String PATIENT_PRIORITY_NO="";
			String PAT_CURR_LOCN_DESC="";
			String fs_locn_code="";
			String reason_for_reserve="";
			
			if (bed_status.equals(""))
				bed_status = "A";
			int		bed_col_num		= 1;
		
            _bw.write(_wl_block4Bytes, _wl_block4);

			StringBuffer whereBuffer = new StringBuffer();
			StringBuffer whereBuffer1 = new StringBuffer();
			StringBuffer whereBuffer2 = new StringBuffer();

			StringBuffer queryBuffer = new StringBuffer();
			StringBuffer queryBuffer1 = new StringBuffer();
	try
	{
		con= ConnectionManager.getConnection(request);
		queryBuffer.append("select to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.locn_code,a.TREATMENT_AREA_CODE,'"+locale+"'    ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn, a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"'    ,'1') practitioner_full_name, a.priority_indicator, a.priority_zone, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,  a.patient_id,(decode('"+locale+"'    ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time,to_char(a.queue_date,'dd/mm/yyyy') queue_date1,to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date,a.queue_status,a.queue_status queue_status_desc, a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.AE_BED_NO bed_no,'O' current_status, d.pseudo_bed_yn, null high_risk, null allergy, null result, A.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"'  ,'2') SERVICE_DESC, a.priority_indicator PATIENT_PRIORITY_NO, AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PATIENT_PRIORITY_DESC, DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"'    ,'2'), OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"' ,'1')) pat_curr_locn_desc, c.mr_location_code fs_locn_code, null reason_for_reserve from op_patient_queue a, mp_patient b, op_clinic_lang_vw c, ae_bed_for_trmt_area d where a.facility_id = '"+facility_id+"'  and a.queue_status <= '07'  and  TRUNC(TO_DATE(a.Queue_date,'dd/mm/yyyy'))BETWEEN TRUNC(TO_DATE(SYSDATE-1,'dd/mm/yyyy')) AND SYSDATE  and TRUNC(TO_DATE(a.Queue_date,'dd/mm/yyyy'))BETWEEN TRUNC(TO_DATE(SYSDATE-1,'dd/mm/yyyy')) AND SYSDATE  and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id and a.locn_code = c.clinic_code and a.facility_id = d.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no and a.bed_no is not null");
		
		if (!clinic_code.equals("")){
			whereBuffer.append(" and a.locn_code = '"+clinic_code+"'");
			whereBuffer2.append(" and clinic_code = '"+clinic_code+"'");

		}

	   whereBuffer.append(" and a.patient_class = 'EM' ");
	   whereBuffer2.append(" and patient_class = 'EM' ");

		if (!treatment_area.equals("")){
			whereBuffer.append(" and a.treatment_area_code = '"+treatment_area+"' ");
			whereBuffer2.append(" and treatment_area_code = '"+treatment_area+"' ");
			
		}

		if (!practitioner_id1.equals("")){
			whereBuffer.append(" and a.practitioner_id = '"+practitioner_id1+"' ");
			
		}

		if (!patient_id1.equals("")){
			whereBuffer.append(" and a.patient_id = '"+patient_id1+"' ");
			
		}

		if (!priority1.equals("")){
			whereBuffer.append(" and a.priority_no = '"+priority1+"' ");
			
		}
		


		if(!bed_status.equals("B")){
			whereBuffer.append(" and current_status = '"+bed_status+"' ");
			
		}

		if (!patient_id1.equals("")){
			queryBuffer1.append(" minus ");
			
		}else{
			queryBuffer1.append(" union ");
		}
		queryBuffer1.append(" SELECT null date_of_birth, a.clinic_code locn_code,b.short_desc locn_desc,null locn_type,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.clinic_code, a.treatment_area_code,'"+locale+"'    ,'2') treatment_area_desc, null triage_area,null open_to_all_pract_yn,null practitioner_id, null practitioner_name, null practitioner_full_name ,null priority_indicator, c.priority_zone priority_zone, null queue_date_time, null check_in_date_time, null sys_date_time, null patient_id, null patient_name, null gender, 0 encounter_id,  null waiting_time, null queue_date1, null  assign_date,  null queue_status, null queue_status_desc, null trauma_yn, null brought_dead_yn,  null open_to_all_prac_for_clinic_yn, null patient_class, a.bed_no, a.current_status,a.pseudo_bed_yn, null high_risk,null allergy,null result ,null SERVICE_CODE, null SERVICE_DESC,null PATIENT_PRIORITY_NO,null PATIENT_PRIORITY_DESC,null PAT_CURR_LOCN_DESC, null fs_locn_code,substr(a.reason_for_reserve,1,30) reason_for_reserve from ae_bed_for_trmt_area a,op_clinic_lang_vw b, ae_tmt_area_for_clinic c where a.facility_id = '"+facility_id+"' and b.language_id = '"+locale+"'  and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = c.facility_id and a.clinic_code = c.clinic_code and a.treatment_area_code = c.treatment_area_code ");
		
		if (!clinic_code.equals("")){
			whereBuffer1.append(" and a.clinic_code = '"+clinic_code+"'");

		}
		
		if (!treatment_area.equals("")){
			whereBuffer1.append(" and a.treatment_area_code = '"+treatment_area+"' ");
			
		}
		
		if (!patient_id1.equals("")){
			whereBuffer1.append(" and d.occupying_patient_id = '"+patient_id1+"' ");
			
		}else{
			whereBuffer1.append(" and d.occupying_patient_id is null ");
		}
		if(!bed_status.equals("B")){
			whereBuffer1.append(" and d.current_status = '"+bed_status+"' ");
			
		}
		
		whereBuffer1.append("order by locn_desc, locn_code, treatment_area_desc, treatment_area_code  ,bed_no  ");		
		
		
		queryBuffer.append(whereBuffer.toString());
		
		queryBuffer1.append(whereBuffer1.toString());

		String sqlCount = "Select count(*) count_val from ae_bed_for_trmt_area_lookup_vw where facility_id = '" +facility_id+"' "+ whereBuffer2.toString();

		if(!bed_status.equals("B")){
			sqlCount=sqlCount+ " and current_status = '"+bed_status+"'";
		}
		
		queryBuffer.append(queryBuffer1.toString());

		int max_count	= 0;
		pstmt			= con.prepareStatement(sqlCount);
		rs				= pstmt.executeQuery();
		if(rs.next())
		{
			max_count = rs.getInt(1);
		}
		if(max_count == 0)
		{
		
            _bw.write(_wl_block5Bytes, _wl_block5);

		}
		else
		{
				stmt = con.createStatement() ;

				rs     = stmt.executeQuery(queryBuffer.toString()) ;
				int count_buttn = 0 ;
				//String TableStr = "";
				StringBuffer tip = new StringBuffer();
				StringBuffer TableStr = new StringBuffer();

				TableStr.append("<table cellspacing=0 cellpadding=0 align='left' border='0' width='10%'>");
		
				TableStr.append("<tr>");
				
				if(rs!=null)
				{	
					TableStr.append("<form name='query_form' id='query_form'>");

					String clinic_desc				=  ""; 
					String treatment_area_code		=  ""; 
					String trmt_area_short_desc		=  ""; 
					String pseudo_bed_yn			=  ""; 
					String patient_name				=  ""; 
					String date_of_birth			=  ""; 
					String current_status			=  ""; 
					String nationality_short_desc	=  ""; 
					String butt_color 				=  "";
					String placeholder 				=  "";
 					//String tip						=  "";
					//String sqlCnt					=  "";

					String clinic_type=  "";
					String queue_status=  "";
					String encounter_id=  "";
					String triage_area=  "";
					String trauma_yn=  "";
					String practitioner_id=  "";
					String practitioner_full_name=  "";
					String open_to_all_prac_for_clinic_yn=  "";
					String queue_date_time=  "";
					String sys_date_time=  "";
					String queue_date=  "";
					String brought_dead_yn=  "";
					String assign_tmt_area_time=  "";
					String open_to_all_pract_yn=  "";
					String patient_class=  "";

					String highrisk=  "";
					String allergy=  "";
					String result=  "";
		
 					while(rs.next())
					{
						clinic_code					= checkForNull(rs.getString("locn_code")) ;
						clinic_desc					= checkForNull(rs.getString("locn_desc")) ;
						treatment_area_code			= checkForNull(rs.getString("treatment_area_code")) ;
						trmt_area_short_desc		= checkForNull(rs.getString("treatment_area_desc")) ;
						bed_no						= checkForNull(rs.getString("bed_no")) ;
						pseudo_bed_yn				= checkForNull(rs.getString("pseudo_bed_yn")) ;
						patient_id					= checkForNull(rs.getString("patient_id")) ;
						patient_name				= checkForNull(rs.getString("patient_name")) ;
						gender						= checkForNull(rs.getString("gender")) ;
						date_of_birth				= checkForNull(rs.getString("date_of_birth")) ;
						current_status				= checkForNull(rs.getString("current_status")) ;
						clinic_type= checkForNull(rs.getString("locn_type")) ;
						queue_status= checkForNull(rs.getString("queue_status")) ;
						encounter_id= checkForNull(rs.getString("encounter_id")) ;
						triage_area= checkForNull(rs.getString("triage_area")) ;
						trauma_yn= checkForNull(rs.getString("trauma_yn")) ;
						practitioner_id= checkForNull(rs.getString("practitioner_id")) ;
						practitioner_full_name= checkForNull(rs.getString("practitioner_full_name")) ;
						open_to_all_prac_for_clinic_yn= checkForNull(rs.getString("open_to_all_prac_for_clinic_yn")) ;
						queue_date_time= checkForNull(rs.getString("queue_date_time")) ;
						sys_date_time= checkForNull(rs.getString("sys_date_time")) ;
						queue_date= checkForNull(rs.getString("queue_date1")) ;
						brought_dead_yn= checkForNull(rs.getString("brought_dead_yn")) ;
						assign_tmt_area_time= checkForNull(rs.getString("assign_date")) ;
						open_to_all_pract_yn= checkForNull(rs.getString("open_to_all_pract_yn")) ;
						patient_class= checkForNull(rs.getString("patient_class")) ;

						highrisk= checkForNull(rs.getString("high_risk")) ;
						allergy= checkForNull(rs.getString("allergy")) ;
						result= checkForNull(rs.getString("result")) ;


						SERVICE_DESC= checkForNull(rs.getString("SERVICE_DESC")) ;
						PATIENT_PRIORITY_NO= checkForNull(rs.getString("PATIENT_PRIORITY_NO")) ;
						PAT_CURR_LOCN_DESC= checkForNull(rs.getString("PAT_CURR_LOCN_DESC")) ;
						fs_locn_code= checkForNull(rs.getString("fs_locn_code")) ;
						reason_for_reserve= checkForNull(rs.getString("reason_for_reserve")) ;


						butt_color 					= "IP_GreenButton";
						placeholder					= "";
						//sqlCnt = "SELECT   clinic_code, clinic_desc, SUM (DECODE (NVL(current_status,'X'), 'A', 1, 'X',1,0)) available, SUM (DECODE (current_status, 'O', 1, 0)) occupied, SUM (DECODE (current_status, 'R', 1, 0)) reserved, SUM (DECODE (NVL(current_status,'X'), 'A', 1, 'O',1,'R',1,'X',1)) total_bed FROM ae_bed_for_trmt_area_lookup_vw WHERE facility_id = '"+facility_id+"' and clinic_code='"+clinic_code+"' and treatment_area_code = '"+treatment_area_code+"' group by clinic_code, clinic_desc ORDER BY clinic_code, clinic_desc";
						
						disp_content="                 ";
						//tip = "" ;
						tip.setLength(0);
						placeholder = "";
						info="";
						String info1="";
						
						
						highrisk= checkForNull(rs.getString("high_risk")) ;
						allergy= checkForNull(rs.getString("allergy")) ;
						result= checkForNull(rs.getString("result")) ;

						if(! highrisk.equals("")){
							info=highrisk+"/" ;
							info1=highrisk+"/" ;							
						}else{
							info1="/" ;
						}
						if(! allergy.equals("")){
							info=info+allergy+"/" ;
							info1=info1+allergy+"/" ;							
						}else{
							info1=info1+"/" ;
						}

						if(! result.equals("")){
							info=info+result+"/" ;	
							info1=info1+result+"/" ;							
						}else{
							info1=info1+"/" ;
						}
						
						if(info.length()>0)
							info=info.substring(0,info.length()-1);
						

						placeholder = specialCharacter(bed_no);
						tip.append("Bed No ��"+placeholder+"<br>");
						disp_content="Bay:"+placeholder+" " ;
						
						placeholder = "";
						placeholder = specialCharacter(clinic_desc);
						tip.append("Clinic ��"	+placeholder+"<br>");
						
						placeholder = "";
						placeholder = specialCharacter(trmt_area_short_desc);
						tip.append("Treatment Area ��"+placeholder+"<br>");
						
						if ((current_status.equals("O")) || ((current_status.equals("R"))))
						{
							if (current_status.equals("O"))
								butt_color	= "IP_RedButton";
							
					
							placeholder = "";
							placeholder = specialCharacter(patient_id);
							tip.append("ID ��"+placeholder+"<br>");
							if(current_status.equals("O")){
								disp_content=disp_content+ "    ID:"+placeholder+"\n" ;
							}
							
							placeholder = "";
							placeholder = specialCharacter(patient_name);
							tip.append("Patient Name ��"+placeholder+"<br>");
							if(placeholder != null && placeholder.length() >27){
								String tmp="";
								tmp=placeholder.substring(0,27);
								disp_content=disp_content+tmp+"\n" ;

							}else{
								disp_content=disp_content+placeholder+"\n" ;
							}
							
							
							placeholder = "";
							placeholder = specialCharacter(gender);
							tip.append("Gender ��"+placeholder+"<br>");
							disp_content=disp_content+placeholder +"      ";


							disp_content=disp_content+SERVICE_DESC+"\n" ;
							disp_content=disp_content+PAT_CURR_LOCN_DESC ;
							if(!reason_for_reserve.equals("")){
								disp_content=disp_content+reason_for_reserve;
							}

							 
							

							if(! info.equals("")){
								disp_content=disp_content+"           " + info;
							}
							
							placeholder = "";
							placeholder = specialCharacter(date_of_birth);
							tip.append("Date of Birth ��"+placeholder+"<br>") ;
							
							placeholder = "";
							placeholder = specialCharacter(nationality_short_desc);
							tip.append("Nationality ��"+placeholder+"<br>");
						}
						
						if ((current_status.equals("O")) && (pseudo_bed_yn.equals("Y")))
							butt_color = "IP_LPinkButton";
						
						if((current_status.equals("A")) && (pseudo_bed_yn.equals("Y"))) 
							butt_color = "IP_LGreenButton";
						if(current_status.equals("R") ) 
							butt_color = "IP_BrownButton";
						if(current_status.equals("O")){
							if(PATIENT_PRIORITY_NO.equals("1")){
								butt_color="IP_RESUSCITATION";
							}else if(PATIENT_PRIORITY_NO.equals("2")){
								butt_color="IP_EMERGENT";
							}else if(PATIENT_PRIORITY_NO.equals("3")){
								butt_color="IP_URGENT";
							}else if(PATIENT_PRIORITY_NO.equals("3")){
								butt_color="IP_SEMIURGENT";
							}else if(PATIENT_PRIORITY_NO.equals("5")){
								butt_color="IP_NONURGENT";
							}else{
								butt_color="IP_NONTRIAGE";
							}
						}
						if(treatment_area_code.equals(treatment_area_code_prev)){
						}else{ 
							String header = "" ;
							header			 = clinic_desc +"/"+ trmt_area_short_desc;
							treatment_area_code_prev=treatment_area_code;

							TableStr.append("</tr><tr><table width='100%' border=0><th class='TEXTGROUPING' align='left' width='100%' colspan=2> "+ header +"</th></table></tr><tr>");
							bed_col_num = 1;
						}
						
						TableStr.append("<script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\")</script>");
						TableStr.append(" <td width='2%'> <input type='button' value=\""+disp_content+"\"  class='"+butt_color+"' style='width:190;height:58;text-align:left;font-size: 7pt' onclick='closeWin(\""+bed_no+"\",\""+butt_color+"\",\""+clinic_code+"\",\""+clinic_desc+"\",\""+clinic_type+"\",\""+patient_id+"\",\""+queue_status+"\",\""+encounter_id+"\",\""+triage_area+"\",\""+trauma_yn+"\",\""+treatment_area_code+"\",\""+practitioner_id+"\",\""+practitioner_full_name+"\",\""+trmt_area_short_desc+"\",\""+open_to_all_prac_for_clinic_yn+"\",\""+queue_date_time+"\",\""+sys_date_time+"\",\""+queue_date+"\",\""+gender+"\",\""+brought_dead_yn+"\",\""+assign_tmt_area_time+"\",\""+open_to_all_pract_yn+"\",\""+patient_class+"\",\""+current_status+"\",\""+date_of_birth+"\",\""+fs_locn_code+"\",\""+patient_name+"\",\""+info1+"\")' > </td> ");

						
						

						if ( bed_col_num == 9)
						{
							bed_col_num = 0;
							TableStr.append("</tr><tr>");
						}

						bed_col_num++ ;
						count_buttn++ ;
					}
				}
				TableStr.append("</form></tr>");
				out.print(TableStr.toString());
				out.println("<script> resetValues(); </script>");
				tip.setLength(0);
				TableStr.setLength(0);
		}
		

	}catch(Exception e) {e.printStackTrace();}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (rs_cnt != null) rs_cnt.close();
		if (stmt_cnt != null) stmt_cnt.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
