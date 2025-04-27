package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __showallimages extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/showAllImages.jsp", 1744010691545L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5_0 ="\n<html>\n\t<head>\n\t\t <script> \t\t\n\t\t\tfunction callNoRecords(){\n\t\t\t\tvar msg = \"\";\n\t\t\t\tvar count_records_cond = document.showAllImagesForm.count_records_cond.value;\n\t\t\t\tvar count_records_trmt = document.showAllImagesForm.count_records_trmt.value;\n\t\t\t\tvar treatment_condition_tab_flag = document.showAllImagesForm.treatment_condition_tab_flag.value;\n\t\t\t\tvar tooth_numbering_system = document.showAllImagesForm.tooth_numbering_system.value;\n\t\t\t\tvar tooth_no = document.showAllImagesForm.tooth_no_hid.value;\n\t\t\t\tvar site_type = document.showAllImagesForm.site_type_hid.value;\n\t\t\t\tvar tooth_no_hid = document.showAllImagesForm.tooth_no.value;\n\t\t\t\tvar super_tooth_ref = document.showAllImagesForm.super_tooth_ref.value;\n\t\t\t\tvar title_desc = trimString(document.showAllImagesForm.title_desc_hid.value);\n\t\t\t\tvar arch=getLabel(\"eOH.Arch.Label\",\"OH\");\n\t\t\t\tvar quadrant=getLabel(\"eOH.Quadrant.Label\",\"OH\");\n\t\t\t\tvar title1=\"\";\n\t\t\t\t//added by parul on 28/12/2009 for retained changes\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"tooth_no=\"+tooth_no_hid+\"&numbering_system=\"+tooth_numbering_system;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=populateNSToothNo&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar retVal_arr=\"\";\n\t\t\t\tif(retVal.length > 0){\n\t\t\t\t\t retVal_arr = retVal.split(\"##\")\n\t\t\t\t}\n\t\t\t\tif(super_tooth_ref==\"RD\"){\n\t\t\t\t\ttooth_no=retVal_arr[0];\n\t\t\t\t}\n\t\t\t\t//end \n\t\t\t\tif(site_type==\"ARCH\"){\n\t\t\t\t\ttitle1=arch;\n\t\t\t\t}else if(site_type==\"QUAD\"){\n\t\t\t\t\ttitle1=quadrant;\n\t\t\t\t}\n\t\t\t\tif(count_records_cond==\"0\" && count_records_trmt==\"0\"){\n\t\t\t\t\tif(site_type==\"QUAD\" || site_type==\"ARCH\"){\n\t\t\t\t\t\tif(title_desc == \"\"){\n\t\t\t\t\t\t\ttitle_desc = tooth_no;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(treatment_condition_tab_flag == \"T\"){\n\t\t\t\t\t\tmsg = getMessage(\"APP-OH000101\",\"OH\");//treatments for A,Q\n\t\t\t\t\t\ttitle_desc = title_desc.replace(/\\s+/g,\" \");\n\t\t\t\t\t\t\talert(msg+\" \"+ title1+\" \'\"+title_desc+\"\'\");\n\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tmsg = getMessage(\"APP-OH000102\",\"OH\");//Conditions for A,Q\n\t\t\t\t\t\t\ttitle_desc = title_desc.replace(/\\s+/g,\" \");\n\t\t\t\t\t\t\talert(msg+\" \"+ title1+\" \'\"+title_desc+\"\'\");\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\n\t\t\t\t\t\tif(treatment_condition_tab_flag == \"T\"){\n\t\t\t\t\t\t\tmsg = getMessage(\"APP-OH00048\",\"OH\");//treatments for Tooth\n\t\t\t\t\t\t\talert(msg+\" \"+tooth_no);\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tmsg = getMessage(\"APP-OH00060\",\"OH\");//Conditions for A,Q\n\t\t\t\t\t\t\talert(msg+\" \"+tooth_no);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\twindow.close();\t\t\t\t\t\n\t\t\t\t}\t\n\t\t\t}\n/*\tfunction trimString(str){\n\t\t\t  return str.replace(/^\\s+|\\s+$/g,\"\");\n\t\t}\n\n\n\tfunction showRemarks(locale,title,rownum,remarks_flag){\n\n\t\tvar readOnlyYN = \"N\";\n\t\tvar formObj=document.forms[0];\n\t\tif (remarks_flag==\"C\"){\n\t\t\tvar remarks = eval(\"formObj.remarks_i\"+rownum).value;\n\t\t}else if(remarks_flag==\"E\"){\n\t\t\tvar remarks = eval(\"formObj.remarks_j\"+rownum).value;\n\t}\n\t\tvar remarks_hid = document.forms[0].remarks.value;\n\t//if(locale != \'en\'){\n\t\t//remarks =escape(remarks);\n\t\tremarks = trimString(remarks);\n\t\tremarks = encodeURIComponent(remarks);\n\t//}\n\n\t\tvar called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;\n\t\tvar date_diff_flag = document.forms[0].date_diff_flag.value;\n\n\t\tif((called_from_viewchart_yn == \"Y\"|| called_from_viewchart_yn==\"\"|| called_from_viewchart_yn==\"null\"|| called_from_viewchart_yn==null) || (date_diff_flag == \"disable\"|| date_diff_flag==\"\"|| date_diff_flag==\"null\"|| date_diff_flag==null)){\n\t\t\treadOnlyYN = \"Y\";\n\t\t}else{\n\t\t\treadOnlyYN = \"N\";\n\t\t}\n\t\n\t\tremarks = encodeURIComponent(remarks);\n\t\ttitle = encodeURIComponent(title);\n\t\tvar retVal = window.showModalDialog(\"../../eOH/jsp/TextArea.jsp?heading=\"+title+\"&remarks=\"+remarks+\"&readOnlyYN=\"+readOnlyYN,window,\"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;\");\n\t\t//retVal = encodeURIComponent(retVal);\n\t\tif(retVal == \"undefined\" || retVal == undefined || retVal == \"CL_REM\"){ // This when the user closed the TeaxtArea window with above \'X\' \n\t\t\tdocument.forms[0].remarks.value = remarks_hid;\n\t\t}\n\t\telse{\n\t\t\tdocument.forms[0].remarks.value = retVal;\n\t\t}\n\n\t}*/\n\t  async function showTasksWindow(i,condition_trmt_code_desc_for_task,from)\n\t  {\n\t\t\t\n\t\t\tvar formObj=document.forms[0];\n\t\t\tvar chart_num = formObj.chart_num.value;\n\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\n\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\tvar site_type = formObj.site_type_hid.value;\n\t\t\tvar title_desc_hid = formObj.title_desc_hid.value;\n\t\t\tvar super_tooth_ref = formObj.super_tooth_ref.value;\n\t\t\t\n\t\t\t\n\t\t\tvar tooth_no_hid = formObj.tooth_no_hid.value;\n\t\t\tif(from==\'TRMTTODO\')\n\t\t   {\n\t\t\tvar trmt_code = document.getElementById(\"trmt_code_do_\" + i).value;\n\t\t\tvar chart_line_num = document.getElementById(\"chart_line_num_do_\" + i).value;\n\t\t\tvar tooth_no_display_for_task = document.getElementById(\"tooth_no_display_for_task_do_\" + i).value;\n\t\t   }else{\n\t\t\tvar trmt_code = document.getElementById(\"trmt_code_done_\" + i).value;\n\t\t\tvar chart_line_num = document.getElementById(\"chart_line_num_done_\" + i).value;\n\t\t\tvar tooth_no_display_for_task = document.getElementById(\"tooth_no_display_for_task_done_\" + i).value;\n\t\t   }\n\n\t\t\tvar params = \'&patient_id=\'+patient_id+\'&chart_num=\'+chart_num+\'&trmt_code=\'+trmt_code+\'&chart_line_num=\'+chart_line_num+\'&tooth_no_display_for_task=\'+tooth_no_display_for_task+\'&oh_chart_level=\'+oh_chart_level+\'&condition_trmt_code_desc_for_task=\'+condition_trmt_code_desc_for_task+\'&site_type=\'+site_type+\'&title_desc_hid=\'+title_desc_hid;\n\t\t\tvar url\t= \"../../eOH/jsp/ShowTasksForTreatment.jsp?\"+params;\n\n\t\t\tvar dialogHeight= \"40vh\" ;\n\t\t\tvar dialogWidth\t= \"70vw\" ;\n\t\t\tvar dialogTop =\"170\";\n\t\t\tvar dialogLeft =\"10\";  \t\n\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop +\"  ;dialogLeft:\" + dialogLeft + \";scroll=auto; status:\" + status;\n\t\t\tawait window.showModalDialog(url,arguments,features);\n\t\t}\n\t\tasync function openNotes(i,progress_note_group,from){\n\t\t\tvar formObj                    = document.forms[0];\n\t\t\tvar chart_num                  = formObj.chart_num.value;\n\t\t\tvar patient_id                 = formObj.patient_id.value;\n\t\t\tvar oh_chart_level             = formObj.oh_chart_level.value;\n\t\t\tvar other_chart_facility_id    = formObj.other_chart_facility_id.value;\n\t\t\tvar patient_class              = formObj.patient_class.value;\n\t\t\tvar tooth_range                = document.getElementById(\"tooth_range_\" + i).value;\n\t\t\tif(from==\'TRMTTODO\')\n\t\t   {\n\t\t\tvar trmt_code = document.getElementById(\"trmt_code_do_\" + i).value;\n\t\t\tvar chart_line_num = document.getElementById(\"chart_line_num_do_\" + i).value;\n\t\t\t//var tooth_no_display_for_task = eval(\"document.getElementById(\"tooth_no_display_for_task_do_\")\"+i).value;\n\t\t   }else{\n\t\t\tvar trmt_code = document.getElementById(\"trmt_code_done_\" + i).value;\n\t\t\tvar chart_line_num = document.getElementById(\"chart_line_num_done_\" + i).value;\n\t\t\t//var tooth_no_display_for_task = eval(\"document.getElementById(\"tooth_no_display_for_task_done_\")\"+i).value;\n\t\t   }\n\t\t\tvar baseline_chart_yn          =formObj.baseline_chart_yn.value;\n\t\t\tvar progression_ref=\"\";\n\t\t\t//var params = formObj.params.value;\n\t\t\t/* Below Code is for getting progression_ref_num  from OH_RESTORATIVE_CHART_DTL table*/\n\t\t\tvar params1 = \"patient_id=\"+patient_id+\"&patient_class=\"+patient_class+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+chart_line_num+\"&trmt_code=\"+trmt_code+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\t\n\t\t\tvar xmlDoc =  \"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=getProgression_Ref&\"+params1,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal_ref_num = trimString(xmlHttp.responseText);\n\t\t\tif(retVal_ref_num!=\'undefined\')\n\t\t\t{\n            retVal_ref_num=localTrimString(retVal_ref_num);\n\t\t\t}\n\t\t\t\n\t\t\tprogression_ref=retVal_ref_num;\n            \n            var params = \"patient_id=\"+patient_id+\"&patient_class=\"+patient_class+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+chart_line_num+\"&trmt_code=\"+trmt_code+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\n\t\t\tif(from==\'TRMTDONE\' || baseline_chart_yn==\'Y\')\n\t\t\t{\n\t\t\tif(progression_ref==\'\')\n\t\t\t{\n\t\t\talert(getMessage(\"APP-OH000178\",\'OH\'));\n\t\t\treturn;\n\t\t\t}\n\t\t\t\n\t\t\tparams=\"&level=\"+\"PN\"+\"&note_group=\"+progress_note_group+\"&progression_ref=\"+progression_ref+\"&called_from=OH_TREATMENT\"+\"&\"+params;\n\t\t\t\n\t\t\tvar title = getLabel(\"eOH.ProgressNotes.Label\",\"OH\");\n\t\t\tvar url=\"../../eOH/jsp/OHProgressNotesView.jsp?title=\"+title+\"&module_id=OH&appl_task_id=PROGRESS_NOTES\"+params;\n\t\t\tvar dialogHeight = \"80vh\" ;\n\t\t\tvar dialogWidth  = \"80vw\" ;\n\t\t\t//var dialogWidth  \t\t= window.screen.availWidth;\n\t\t\tvar dialogTop    = \"10\";\n\t\t\tvar dialogLeft   = \"50\";\n\t\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" + \";title:\" +title ;\n\t\t\tvar retVal=await top.window.showModalDialog(url,\"CAWindow\",features);\n\t\t\t}else\n\t\t\t{\n\t\t\tif(progress_note_group==\'\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"APP-OH000177\",\'OH\'));\n\t\t\t\treturn;\n\t\t\t}\n\n\t\t\tparams=\"&note_group=\"+progress_note_group+\"&progression_ref=\"+progression_ref+\"&called_from=OH_TREATMENT\"+\"&\"+params;\n\n\t\t\tvar title = getLabel(\"eOH.ProgressNotes.Label\",\"OH\");\n\t\t\tvar \n\t\t\turl=\"../../eCA/jsp/ProgressNotesModal.jsp?title=\"+title+\"&module_id=OH&appl_task_id=PROGRESS_NOTES\"+params;\n\t\t\tvar dialogHeight = \"80vh\" ;\n\t\t\tvar dialogWidth  = \"80vw\" ;\n\t\t\t//var dialogWidth  \t\t= window.screen.availWidth;\n\t\t\tvar dialogTop    = \"10\";\n\t\t\tvar dialogLeft   = \"50\";\n\t\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" + \";title:\" +title ;\n\t\t\tvar retVal=await top.window.showModalDialog(url,\"CAWindow\",features);\n            if(typeof retVal==\'undefined\') retVal=\'\';\n\t\t\tretVal=localTrimString(retVal)\n\t\t\tprogression_ref=retVal;\n\n\t\t\tif(progression_ref!=\'undefined\' && progression_ref!=\'\')\n\t\t\t{\n\t\t    /* Updating Progression ref num in OH_RESTORATIVE_CHART_DTL so that next time we can pass to CAWindow just for identity*/\n\t\t\tvar xmlDoc =  new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params2 = \"patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&chart_line_num=\"+chart_line_num+\"&trmt_code=\"+trmt_code+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_i";
    private final static byte[]  _wl_block5_0Bytes = _getBytes( _wl_block5_0 );

    private final static java.lang.String  _wl_block5_1 ="d+\"&progression_ref=\"+progression_ref+\"&tooth_range=\"+tooth_range;\n\t\t\t\t\t\t\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"../../eOH/jsp/DentalTrmtValidation.jsp?func_mode=update_Progression_ref&\"+params2,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar flag = trimString(xmlHttp.responseText);\n\t\t\t}\n\t\t\t}\t\n\t\t}\n\t\t//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475\n\t\tfunction showPonticToothTooltip(pontic_dtls,tooth_no){\n\t\t\t//var tooth_no = document.forms[0].tooth_no.value;\n\t\t\tvar numbering_system = document.forms[0].tooth_numbering_system.value;\n\t\t\tvar pontic_dtl_arr = new Array();\n\t\t\tvar pontic_dtl_values = pontic_dtls.split(\"$$\");\n\t\t\tfor(var i =0; i < pontic_dtl_values.length; i++){\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"tooth_no=\"+pontic_dtl_values[i]+\"&numbering_system=\"+numbering_system;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"../../eOH/jsp/CommonValidation.jsp?func_mode=populateNSToothNoForJS&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tretVal=localTrimString(retVal);\n\t\t\t\tif(retVal.length !=0){\n\t\t\t\t\tdisply_tooth_no = retVal;\n\t\t\t\t}\n\t\t\t\tpontic_dtl_arr[i] = disply_tooth_no;\n\t\t\t}\n\t\t\tpontic_dtl_arr = pontic_dtl_arr.join(\",\");\n\t\t\t/*var msg = getMessage(\"APP-OH000169\",\"OH\");\n\t\t\tvar msgArray = msg.split(\"##\");\n\t\t\tvar msg_pontic = msgArray[0] + pontic_dtl_arr + msgArray[1]; */\n\t\t\tvar msg_pontic = \"Pontic \" + pontic_dtl_arr + \" excised during extraction of the Abutment Tooth.\";\n\t\t\tif(pontic_dtl_values != \"\"){\n\t\t\t\tvar tab_dat = \"<table cellpadding=\'1\' cellspacing=1 border=\'1\' width=\'100%\' height=\'100%\' align=\'right\' style=\'border:2px solid #666666\'>\"\n\t\t\t\ttab_dat\t\t+= \"<tr><td>\";\n\t\t\t\ttab_dat \t+= msg_pontic;\n\t\t\t\ttab_dat\t\t+= \"</td></tr>\";\n\t\t\t\ttab_dat\t\t+= \"</table>\";\n\t\t\t\tTip(tab_dat);\n\t\t\t}\n\t\t}//End\n\t\n\t\tfunction localTrimString(sInString) {\n\t\tsInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n\t\treturn sInString.replace( /\\s+$/g, \"\" );// strip trailing\n}\n\n\n \n\t\t</script>\n\t\t<title>\n\t\t";
    private final static byte[]  _wl_block5_1Bytes = _getBytes( _wl_block5_1 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t</title> \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t<script language=\'javascript\' src=\'../../eOH/js/wz_tooltip.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t\t<form name = \"showAllImagesForm\" >\n\t\t\t<!-- <table width=\"101.7%\"> \n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"button\">\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"\" id=\"\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\"window.close();\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table> -->\n <table width=\"101.1%\">\n\t\t<tr>\n\t\t<td align=\"right\" class=\"button\">\n\t\t<input type=\"button\" class=\"button\" name=\"\" id=\"\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onclick=\"window.close();\">\n\t\t</td>\n\t\t</tr>\n\t<tr>\n\t\t<td>\n\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<td class = \"CAGROUPHEADING\" style=\"text-align:center\" colspan=\"7\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<td class = \"CAGROUPHEADING\" style=\"text-align:center\" colspan=\"8\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<!-- <th WIDTH=\"10%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<th WIDTH=\"8%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<th WIDTH=\"18%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<!-- <th WIDTH=\"25%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th> -->\n\t\t\t\t\t\t\t<th WIDTH=\"18%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th> -->\n\n\t\t\t\t\t\t\t<th WIDTH=\"18%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t\t\t\t <th WIDTH=\"33%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th> \n \n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th> -->\n\t\t\t\t\t\t\t<th WIDTH=\"5%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<!-- <th WIDTH=\"25%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th> -->\n\t\t\t\t\t<th WIDTH=\"10%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<th WIDTH=\"20%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<th WIDTH=\"20%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\n\t\t\t</tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                                <input type=\"hidden\" name=\"tooth_no_display_for_task_do_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"tooth_no_display_for_task_do_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value =\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"chart_line_num_do_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"chart_line_num_do_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trmt_code_do_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"trmt_code_do_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tooth_range_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"tooth_range_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t \n\t\t\t\t\t\t\t\t<!-- <input type=\'hidden\' name=\'remarks_i";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'remarks_i";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" > -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tooth_no_display_for_task_do_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t<!-- \t<input type=\'hidden\' name=\'remarks_i";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\n\t\t\t</table>\n\t\t\t\n\t\t\t<br><br><br>\n\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</th>\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<th WIDTH=\"8%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</th>\n\t\t\t\t\t<th WIDTH=\"18%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</th>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</th>\n\t\t\t\t\t\t\t<th WIDTH=\"33%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t<th WIDTH=\"15%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t <th WIDTH=\"5%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</th> \n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t<th WIDTH=\"33%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</th>\n\t\t\t\t\t\t\t<th WIDTH=\"20%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t<th WIDTH=\"10%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</th>\n\t\t\t\t\t<th WIDTH=\"25%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tooth_no_display_for_task_done_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"tooth_no_display_for_task_done_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"chart_line_num_done_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"chart_line_num_done_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trmt_code_done_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"trmt_code_done_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t<!-- <input type=\'hidden\' name=\'remarks_j";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'remarks_j";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" > -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tooth_no_display_for_task_done_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"chart_line_num_done_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trmt_code_done_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tooth_range_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\n\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t <!--   <input type=\'hidden\' name=\'remarks_j";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" > -->\n\t\t\t\t\t\t\t \n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\n\t\t\t</table>\n\t\t\t<!-- added by parul on 01/03/2010 for CRF-477 -->\n\t\t\t<br><br><br>\n\t\t\t<table border=1 cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" \n\t\t\t\t<td class = \"CAGROUPHEADING\" style=\"text-align:center\" colspan=\"8\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</th>\n\t\t\t\n\t\t\t</tr>\n\t\t\t<tr> \n\t\t\t\t\t <th WIDTH=\"8%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</th>\n\t\t\t\t\t\n\t\t\t\t\t<th WIDTH=\"18%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</th>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" \n\t\t\t\t\t\t<th WIDTH=\"15%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<th WIDTH=\"33%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</th>\n\t\t\t\t\t\t<th WIDTH=\"20%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</th>\n\t\t\t\t\t\n\t\t\t\t\t<th WIDTH=\"10%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</th>\n\t\t\t\t\t<th WIDTH=\"15%\" style=\"text-align:center\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</th>\n\t\t\t\t</tr> \n\t\t\t\n\t\t\t\t<tr>\n\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\t\t\t<input type=\"hidden\" name=\"count_records_cond\" id=\"count_records_cond\" value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\"hidden\" name=\"count_records_trmt\" id=\"count_records_trmt\" value = \"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t<input type=\"hidden\" name=\"tooth_no_hid\" id=\"tooth_no_hid\" value = \"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t<input type=\"hidden\" name=\"tooth_no\" id=\"tooth_no\" value = \"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t<input type=\"hidden\" name=\"treatment_condition_tab_flag\" id=\"treatment_condition_tab_flag\" value = \"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t\t<input type=\"hidden\" name=\"site_type_hid\" id=\"site_type_hid\" value = \"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> \n\t\t\t<input type=\"hidden\" name=\"title_desc_hid\" id=\"title_desc_hid\" value = \"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t   \t<!--Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks-->\n\t\t\t<input type=\"hidden\" name=\"remarks\" id=\"remarks\" value =\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=\"hidden\" name=\"called_from_viewchart_yn\" id=\"called_from_viewchart_yn\" value =\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"hidden\" name=\"date_diff_flag\" id=\"date_diff_flag\" value =\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value =\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t<input type=\"hidden\" name=\"super_tooth_ref\" id=\"super_tooth_ref\" value =\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value =\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value =\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"trmt_code\" id=\"trmt_code\" value =\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value =\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value =\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=\"hidden\" name=\"baseline_chart_yn\" id=\"baseline_chart_yn\" value =\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value =\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\n\n\t\t\t<!-- -->\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n<script>\n\t\tcallNoRecords();\n</script>\n\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	PreparedStatement pstmt4=null;
	PreparedStatement pstmt5=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	ResultSet rs4=null;
	ResultSet rs5=null;									 
	String title = "";
	String PD_flag = "";
	String dtl_status = "";
	int count_records_cond = 0;
	int count_records_trmt = 0;
	String chart_line_num = "";
	String trmt_code = "";
	String condition_type = "";
	String progress_note_group = "";
	String tooth_range = "";
	
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String site_type = checkForNull(request.getParameter("site_type")) ;
	String treatment_condition_tab_flag = checkForNull(request.getParameter("treatment_condition_tab_flag")) ;
	String tooth_no = checkForNull(request.getParameter("tooth_no")) ;
	String display_tooth_no = checkForNull(request.getParameter("display_tooth_no")) ;
	String title_desc = checkForNull(request.getParameter("title_desc")) ;
	String arch_quad_desc = checkForNull(request.getParameter("title_desc")) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter("called_from_viewchart_yn")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag")) ;
	String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN"));
	
	//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	//Added by Sharon Crasta on 2/15/2009 for CRF #0423 to display the remarks field to display the chart at enterprise level or other facility-wise.
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String super_tooth_ref = checkForNull(request.getParameter( "super_retained_flag" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String patient_class = checkForNull(request.getParameter( "patient_class" )) ;

	String notes_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ProgressNotes.Label","ohlabels"); 
	if(("undefined").equals(super_tooth_ref))
	super_tooth_ref="";
	if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
		PD_flag = "P";
	}
	else{
		PD_flag = "D";
	}
	StringBuffer sqlBuffer = new StringBuffer();
	StringBuffer sqlBuffer1 = new StringBuffer();
	StringBuffer sqlBuffer2 = new StringBuffer();
	try{
		con=ConnectionManager.getConnection(request);

		String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
		}
			
		if(oh_chart_level.equals("E")){
			sqlBuffer.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID,A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN,");

			if(site_type.equals("QUAD")){
				sqlBuffer.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer.append("A.ARCH_SNO,");
			}else{
				sqlBuffer.append("A.TOOTH_NO,");
			}
			//Commented by Sharon Crasta on 1/7/2009 for CRF #0377 to retrieve the remarks field from the DTL table.
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
           //parul 09/03/2010
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");

			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer.append(" AND A.TOOTH_NO=?");
			}

			if(treatment_condition_tab_flag.equals("T")){
				sqlBuffer.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND NVL(STATUS,'X') IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))");
			}else{
				sqlBuffer.append(" AND A.TREATMENT_CONDITION = 'C' ");
			}
			 //end 
			  sqlBuffer.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");

			pstmt=con.prepareStatement(sqlBuffer.toString());
			int index=1;
			pstmt.setString(index++,locale);
			pstmt.setString(index++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt.setString(index++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}else{
			//}
			pstmt.setString(index++,tooth_no);
			rs=pstmt.executeQuery();
		}
		else{
			sqlBuffer.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID,A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN,");

			if(site_type.equals("QUAD")){
				sqlBuffer.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer.append("A.ARCH_SNO,");
			}else{
				sqlBuffer.append("A.TOOTH_NO,");
			}
			//Commented by Sharon Crasta on 1/7/2009 for CRF #0377 to retrieve the remarks field from the DTL table.
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//commented by parul on 07/12/2009
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.TOOTH_RANGE  FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, DECODE(TREATMENT_CONDITION,'C',(SELECT B.IMAGE_ID FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T',(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE)) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM ,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.TOOTH_RANGE  FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					
			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer.append(" AND A.TOOTH_NO=?");
			}

			if(treatment_condition_tab_flag.equals("T")){
				sqlBuffer.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND NVL(STATUS,'X') IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))");
			}else{
				sqlBuffer.append(" AND A.TREATMENT_CONDITION = 'C' ");
			}
			sqlBuffer.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");
			pstmt=con.prepareStatement(sqlBuffer.toString());
			int index=1;
			pstmt.setString(index++,locale);
//			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,other_chart_facility_id);
			pstmt.setString(index++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt.setString(index++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}else{
			//}
			pstmt.setString(index++,tooth_no);
			rs=pstmt.executeQuery();
		//Sharon Crasta
		}
		//
		if(oh_chart_level.equals("E")){
			sqlBuffer1.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.LOCATION, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,");
			if(site_type.equals("QUAD")){
				sqlBuffer1.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer1.append("A.ARCH_SNO,");
			}else{
				sqlBuffer1.append("A.TOOTH_NO,");
			}
			//Commented by Sharon Crasta on 1/7/2009 for CRF #0377 to retrieve the remarks field from the DTL table.	
			//sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID, (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");

			//sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID, (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//Sharon
			//sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID, (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM , A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");

			//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
			//sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW,(SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM , A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.PONTIC_TOOTH_DTLS,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW,(SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM , A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.PONTIC_TOOTH_DTLS,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer1.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer1.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer1.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer1.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer1.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer1.append(" AND A.TOOTH_NO=?");
			}
				
			if(treatment_condition_tab_flag.equals("T")){
				sqlBuffer1.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60')");
			}
			else{
				sqlBuffer1.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E' ");
			}
		

			sqlBuffer1.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");

			pstmt1=con.prepareStatement(sqlBuffer1.toString());
			int index_ext=1;
			//Sharon
			//pstmt1.setString(index_ext++,facility_id);
			pstmt1.setString(index_ext++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt1.setString(index_ext++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}else{
			//}

			pstmt1.setString(index_ext++,tooth_no);
		//Sharon Crasta
		}else{
			sqlBuffer1.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.LOCATION, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,");
			if(site_type.equals("QUAD")){
				sqlBuffer1.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer1.append("A.ARCH_SNO,");
			}else{
				sqlBuffer1.append("A.TOOTH_NO,");
			}
			//Commented by Sharon Crasta on 1/7/2009 for CRF #0377 to retrieve the remarks field from the DTL table.
			//sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID, (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
			sqlBuffer1.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW,(SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE, A.PONTIC_TOOTH_DTLS,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer1.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer1.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer1.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer1.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer1.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer1.append(" AND A.TOOTH_NO=?");
			}
				
			if(treatment_condition_tab_flag.equals("T")){
				sqlBuffer1.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60')");
			}
			else{
				sqlBuffer1.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E' ");
			}			
			sqlBuffer1.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");
   
			pstmt1=con.prepareStatement(sqlBuffer1.toString());
			int index_ext=1;
			pstmt1.setString(index_ext++,other_chart_facility_id);
			pstmt1.setString(index_ext++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt1.setString(index_ext++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}
			pstmt1.setString(index_ext++,tooth_no);
		 }

        //added by parul on 28/02/2010 for CRF-477

			if(oh_chart_level.equals("E")){
			sqlBuffer2.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.LOCATION, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,");
			if(site_type.equals("QUAD")){
				sqlBuffer2.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer2.append("A.ARCH_SNO,");
			}else{
				sqlBuffer2.append("A.TOOTH_NO,");
			}
			sqlBuffer2.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW,(SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM , A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE,A.PONTIC_TOOTH_DTLS,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer2.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer2.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer2.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer2.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer2.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer2.append(" AND A.TOOTH_NO=?");
			}
				
			sqlBuffer2.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E' ");

			sqlBuffer2.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");

			pstmt4=con.prepareStatement(sqlBuffer2.toString());
			int index_ext=1;
			pstmt4.setString(index_ext++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt4.setString(index_ext++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}else{
			//}

			pstmt4.setString(index_ext++,tooth_no);
		//Sharon Crasta
		}else{
			sqlBuffer2.append("SELECT A.TREATMENT_INT_EXT,A.TREATMENTS_OUTCOME,A.SITE_TYPE, A.HIDE_IMAGE_YN, TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.LOCATION, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,");
			if(site_type.equals("QUAD")){
				sqlBuffer2.append("A.QUADRANT_SNO,");
			}else if(site_type.equals("ARCH")){
				sqlBuffer2.append("A.ARCH_SNO,");
			}else{
				sqlBuffer2.append("A.TOOTH_NO,");
			}
	
			sqlBuffer2.append("(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC, (SELECT B.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE B WHERE A.TRMT_CATEGORY_TYPE = B.TRMT_CATEGORY_TYPE) IMAGE_ID,decode(instr((SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE),'..'),0,'',(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID_NEW,(SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE) CONDITION_TRMT_DESC, (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) CONDITION_TRMT_CODE_DESC,(SELECT B.PROGRESS_NOTE_GROUP FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE) PROGRESS_NOTE_GROUP,A.TRMT_CATEGORY_TYPE,A.REMARKS,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM,A.SURFACE_CODE,A.CHART_LINE_NUM,A.TRMT_CODE, A.PONTIC_TOOTH_DTLS,A.TOOTH_RANGE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL(A.STATUS,'X')!='E' AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
			
			/*if(called_from_viewchart_yn.equals("Y")){//Commented by Sridevi Joshi on 6/15/2010 for IN022000
				sqlBuffer2.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu
			}else{
				sqlBuffer2.append(" AND E.CHART_STATUS='A'"); // For any case when called after cliking on the Condition Tab
			}*/

			//Added by Sridevi Joshi on 6/15/2010 for IN022000
			sqlBuffer2.append(" AND A.CHART_NUM=?"); //This case occurs when called from Baseline charts from RHS Menu

			if(site_type.equals("QUAD")){
				sqlBuffer2.append(" AND A.QUADRANT_SNO=?");
			}else if(site_type.equals("ARCH")){
				sqlBuffer2.append(" AND A.ARCH_SNO=?");
			}else{
				sqlBuffer2.append(" AND A.TOOTH_NO=?");
			}
				
			sqlBuffer2.append(" AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E' ");
			sqlBuffer2.append(" ORDER BY A.CHART_NUM, A.CHART_LINE_NUM DESC");
   
			pstmt4=con.prepareStatement(sqlBuffer2.toString());
			int index_ext=1;
			pstmt4.setString(index_ext++,other_chart_facility_id);
			pstmt4.setString(index_ext++,patient_id);
			//if(called_from_viewchart_yn.equals("Y")){
				pstmt4.setString(index_ext++,chart_num); //This case occurs when called from Baseline charts from RHS Menu
			//}
			pstmt4.setString(index_ext++,tooth_no);
			
		 }

		if(site_type.equals("QUAD") || site_type.equals("ARCH")){
			//title = title_desc+ " " + site_type;
			title = title_desc;
		}
		else{
			title = display_tooth_no;
		}




            _bw.write(_wl_block5_0Bytes, _wl_block5_0);
            _bw.write(_wl_block5_1Bytes, _wl_block5_1);

			if(treatment_condition_tab_flag.equals("C")){
				if(site_type.equals("QUAD") || site_type.equals("ARCH")){
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else{
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
			}
			else if(treatment_condition_tab_flag.equals("T")){
				if(site_type.equals("QUAD") || site_type.equals("ARCH")){
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else{
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
			}
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}else if(treatment_condition_tab_flag.equals("T")){
					
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
					
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(treatment_condition_tab_flag.equals("T")){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(treatment_condition_tab_flag.equals("T")){
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}

						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(treatment_condition_tab_flag.equals("T")){
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
						if(site_type.equals("ARCH")){
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(site_type.equals("QUAD")){
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else{
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
					
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field in the history area.
						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
//added by parul on 4/16/2009
					}
					//
					
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

					rs=pstmt.executeQuery();
					int i=1;
					int j=1;
					String classValue = "";
					String imageId = "";
					String desc = "";
					String date = "";
					String doneby = "";
					String status = "";
					String status_desc = "";
					String trmt_category_type = "";
					String super_yn = "";
					String RD_yn = "";
					String tooth_no_display = "";
					String tooth_no_display_for_task = "";
					String hide_image_yn = "";
					String condition_trmt_code_desc = "";
					String condition_trmt_code_desc_for_task = "";
					String display_status_identifier = "";
					String super_tooth_no = "";
					String retained_tooth_no = "";
					String super_key_num = "";
					String surface_code = "";
					String image_id_new = "";
					String treatment_int_ext = "";
					String treatments_outcome= "";
					String db_site_type= "";//Added by Sridevi Joshi on 4/5/2010 for IN020488

					//String isCond_super_tooth_no = "";
					//String remarks_1 = "";
					 //Added by Sharon Crasta on 1/12/2009 for CRF #0377 to display the remarks in the history area.
					//String remarksEncode="";
					//String remarks1="";
					 //
					while(rs.next()){
						tooth_no_display = "";
						tooth_no_display_for_task = "";
						if ( i % 2 == 0 ){
							classValue = "QRYEVEN" ;
						}
						else{
							classValue = "QRYODD" ;
						}

						imageId = checkForNull(rs.getString("IMAGE_ID"));
						desc = checkForNull(rs.getString("CONDITION_TRMT_DESC"));
					//	date = checkForNull(rs.getString("TREATMENT_CONDITION_DATE"));
						date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("TREATMENT_CONDITION_DATE"),"DMYHM","en",locale));

						doneby = checkForNull(rs.getString("MODIFIED_BY_ID"));
						status = checkForNull(rs.getString("STATUS"));
						//status_desc = checkForNull(rs.getString("STATUS_DESC"));//Commented by Rameez against 37414 and changed the value as "STATUS"
						status_desc = checkForNull(rs.getString("STATUS"));
						status_desc = "["+status_desc+"]";    
						//Rameez against 37414
						trmt_category_type = checkForNull(rs.getString("TRMT_CATEGORY_TYPE"));
						super_yn =  checkForNull(rs.getString("SUPERNUMERARY_YN"));
						RD_yn =  checkForNull(rs.getString("MIXED_DENT_DECIDUOUS_YN"));
						hide_image_yn =  checkForNull(rs.getString("HIDE_IMAGE_YN"));
						condition_trmt_code_desc =  checkForNull(rs.getString("CONDITION_TRMT_CODE_DESC"));
						condition_trmt_code_desc_for_task=checkForNull(rs.getString("CONDITION_TRMT_CODE_DESC"));
						dtl_status =  checkForNull(rs.getString("DTL_STATUS")); //For Status ='Z'
						//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field in the history area.
						remarks = checkForNull(rs.getString("REMARKS"));
						super_tooth_no = checkForNull(rs.getString("SUPER_TOOTH_NO"));
						retained_tooth_no = checkForNull(rs.getString("RETAINED_TOOTH_NO"));
						super_key_num = checkForNull(rs.getString("SUPER_KEY_NUM"));
						surface_code = checkForNull(rs.getString("SURFACE_CODE"));
						
						chart_line_num = checkForNull(rs.getString("CHART_LINE_NUM"));
						trmt_code = checkForNull(rs.getString("TRMT_CODE"));
						//progress_note_group = checkForNull(rs.getString("PROGRESS_NOTE_GROUP"));progress_note_group = checkForNull(null);
						progress_note_group = checkForNull(null);//Rameez against 37414
						treatment_int_ext = checkForNull(rs.getString("TREATMENT_INT_EXT"));
						treatments_outcome = checkForNull(rs.getString("TREATMENTS_OUTCOME"));
						tooth_range = checkForNull(rs.getString("TOOTH_RANGE"));
						db_site_type = checkForNull(rs.getString("SITE_TYPE"));//Added by Sridevi Joshi on 4/5/2010 for IN020488 
						
						int reg_completed_count=0;
						if(pstmt5 != null) pstmt5.close();
						if(rs5 != null)    rs5.close();
						pstmt5=con.prepareStatement("SELECT COUNT(*) REG_COMPLETED_COUNT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (25,53,52,55,75,90,70,60,85))");
						pstmt5.setString(1,patient_id);
						pstmt5.setString(2,chart_num);
						pstmt5.setString(3,chart_line_num);
						pstmt5.setString(4,trmt_code);
						rs5 = pstmt5.executeQuery();
						while(rs5.next()){
						reg_completed_count = Integer.parseInt(checkForNull(rs5.getString("REG_COMPLETED_COUNT"),"0"));
						}
						
						if(!trmt_category_type.equals("")){
							image_id_new = checkForNull(rs.getString("IMAGE_ID_NEW"));
							if(trmt_category_type.equals("ROOTTMT")){
							  imageId="";
							  //imageId="Sridevi";
							}else{
								imageId=image_id_new;
							}
						}
					 

                        
						//if(!surface_code.equals("*A") && site_type.equals("CROWN")){
						if(!surface_code.equals("*A") && db_site_type.equals("CROWN")){//Added by Sridevi Joshi on 4/5/2010 for IN020488 ..site_type was coming as Crown from parameter when caries is recorded.so it was replacing all the images with site_type.equals("CROWN") condition.Now site_type is checked for perticular record which is taken from the table
							imageId="";
							// imageId="&nbsp;";
						}
						if(!surface_code.equals("*A") && trmt_category_type.equals("CROWN")){
							imageId="";
							// imageId="&nbsp;";
						}

						if (surface_code.equals("*A") && trmt_category_type.equals("CROWN")){//added by parul on 28/02/2010 for CRF-477
							if(permanent_deciduous_flag.equals("P")){
								 if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
												imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;
									}
								 }else  if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
											imageId = image_id_new;
									}
								 }
							}else{
								  if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
											imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
											imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;

									}
								 }else if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
											imageId = image_id_new;
									}
								 }
									
							}
						}
					
						if(trmt_category_type.equals("TOOTHTM") && !status.equals("60")){
							imageId = "../../eOH/images/TRMT_Planned.gif";
						}
						
						if(trmt_category_type.equals("EXTRACT") && !status.equals("60")){
							imageId = "../../eOH/images/Extraction-CrownYellow.gif";
						}
											
						if(treatment_condition_tab_flag.equals("T")){
							if(status.equals("10")){
								display_status_identifier = "[OS]"; //  Outstanding
							}
							else if(status.equals("15")){
								display_status_identifier = "[SC]"; //Scheduled
							}
							else if(status.equals("25")){
								display_status_identifier = "[RG]"; //Registered
							}
							else if(status.equals("52")){
								display_status_identifier = "[IM]"; //In Progress
							} 
							else if(status.equals("55") || status.equals("80")){ // Partial
								display_status_identifier = "[IR]"; //Registered
							}
							else if(status.equals("85") || status.equals("60")){
								display_status_identifier = "[RS]"; //ResultEntry(Result completed)
							}
                            
							condition_trmt_code_desc = condition_trmt_code_desc+status_desc;
						}
					
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							/*if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("1") && RD_yn.equals("M")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = "s1";
							}
							else if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("2") && RD_yn.equals("M")){ //Added by Sridevi Joshi on 1/20/2010 for  IN010894
								tooth_no_display = "s2";
							}*/
							
							if(!super_tooth_no.equals("") && RD_yn.equals("M")){ //Supernumerarary Case added by parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; //Added by Sridevi Joshi on 1/22/2010 for IN010894
							}
							else if(super_yn.equals("Y") && !RD_yn.equals("M")){ //Supernumerarary Case
								/* By Sridevi on 07/08/09 to Display tooth no for deciduous tooth for which SUPRTH is recorded*/
								if(!(tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
									
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}

                                    /*if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("1")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = "s1";
									}
									else if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("2")){ //Added by Sridevi Joshi on 1/20/2010 for  IN010894
										tooth_no_display = "s2";
									}*/

									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num; //Added by Sridevi Joshi on 1/22/2010 for IN010894
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
									
									
								}
								else{ /* By Sridevi on 07/08/09 to Display tooth no for permanent tooth for which SUPRTH is recorded*/
									/*if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("1")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = "s1";
									}
									else if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("2")){ //Added by Sridevi Joshi on 1/20/2010 for  IN010894
										tooth_no_display = "s2";
									}*/

									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num; //Added by Sridevi Joshi on 1/22/2010 for IN010894
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
								}
							}
							else if(RD_yn.equals("R") || RD_yn.equals("M")){
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
								/* Added by sathish for IN019908 on 11-03-2010*/
								if (!("").equals(super_key_num)){
								tooth_no_display = tooth_no_display+"["+super_key_num+"]";;
								tooth_no_display_for_task = tooth_no_display_for_task+"["+super_key_num+"]";
								}
							}
							else{
								
								//Commented by Sharon Crasta on 9/22/2009 for IN014657
								//Passed PERMANENT_DECIDUOUS as P, when RD_YN and super_yn are null 
								//pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}

								//Commented by Sharon Crasta on 9/22/2009 for IN014657
								//tooth_no_display = display_tooth_no;
								/* To Display tooth no for Permanennt tooth(After EXFOLTH--->ERUPTH) for conditions other than SUPRTH */
								if(tooth_no_display.equals("") || tooth_no_display.equals("null") || tooth_no_display.equals(null)){  
									//tooth_no_display = display_tooth_no;
									
								}/*else{
								    tooth_no_display = display_tooth_no;
								}*/
								

								/* By Sridevi on 07/08/09 to Display tooth no for extream tooth for conditions other than SUPRTH */
								if((tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									tooth_no_display = display_tooth_no;
									tooth_no_display_for_task = display_tooth_no;
								}
								/* Added by sathish for IN019908 on 11-03-2010*/
								if (!("").equals(super_key_num)){
								tooth_no_display = tooth_no_display+"["+super_key_num+"]";;
								tooth_no_display_for_task = tooth_no_display_for_task+"["+super_key_num+"]";
								}
							}

						}else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
								if(!super_tooth_no.equals("") && RD_yn.equals("D")){//added by parul (record Deciduoud,supernum.....than trauma on same tooth�?�Deciduous tooth no is C,super it will C,Cs �?�.than truma tooth no is comng 6,6s )
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
										pstmt2.setString(1,tooth_numbering_system);
										pstmt2.setString(2,tooth_no);
										pstmt2.setString(3,PD_flag);
										rs2 = pstmt2.executeQuery();
										while(rs2.next()){
											tooth_no_display = rs2.getString("NS_TOOTH_NO");
											tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
										}
											//tooth_no_display = tooth_no_display+"s";
											tooth_no_display = super_key_num;
											tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; //Added by Sridevi Joshi on 1/22/2010 for IN010894

								}
								else if(!super_tooth_no.equals("")){ //Added by parul for IN010894
									tooth_no_display = super_key_num;
									tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; //Added by Sridevi Joshi on 1/22/2010 for IN010894
								}
								else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									/* Added by sathish for IN019908 on 11-03-2010*/
									while(rs2.next()){

										/* commented by Sridevi Joshi ob 4/8/2010 for IN020562...Permanent tooth no was getting disaplyed for Deciduous tooth condition
										if(desc.equals("Deciduous Tooth")){
											tooth_no_display=display_tooth_no;
											tooth_no_display_for_task=display_tooth_no;
										}else{*/
											tooth_no_display = rs2.getString("NS_TOOTH_NO");
											tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
										//}
									}
									/* Added by sathish for IN019908 on 11-03-2010*/
									if (!("").equals(super_key_num)){
										tooth_no_display = tooth_no_display+"["+super_key_num+"]";;
										tooth_no_display_for_task = tooth_no_display_for_task+"["+super_key_num+"]";
									}
                                    
								}else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}
								}
							else{
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
								/* Added by sathish for IN019908 on 11-03-2010*/
								if (!("").equals(super_key_num)){
								tooth_no_display = tooth_no_display+"["+super_key_num+"]";;
								tooth_no_display_for_task = tooth_no_display_for_task+"["+super_key_num+"]";
								}
							}	
						}
						else{
							
							//if(super_yn.equals("Y")){ //commented by parul on 08/12/2009 for super change
							/*if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("1")){ //Supernumerarary Case
								tooth_no_display = "s1";
							}
							else if(!super_tooth_no.equals("") && isCond_super_tooth_no.equals("2")){ //Added by Sridevi Joshi on 1/20/2010 for  IN010894
								tooth_no_display = "s2";
							}*/
							
							if(!super_tooth_no.equals("") && !super_tooth_no.equals("null") && !super_tooth_no.equals(null)){ //Supernumerarary Case
								tooth_no_display = super_key_num; 
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
								//Added by Sridevi Joshi on 1/22/2010 for IN010894
							}
							else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
							
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
									
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}
							}
							else{
								
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
							   /* Added by sathish for IN019908 on 11-03-2010*/
								if (!("").equals(super_key_num)){
								tooth_no_display = tooth_no_display+"["+super_key_num+"]";;
								tooth_no_display_for_task = tooth_no_display_for_task+"["+super_key_num+"]";
								}
							}

						}	
						
						if(condition_type.equals("SUPRTH")){ //Added by Sridevi Joshi on 2/15/2010 for IN019343
							tooth_no_display = tooth_no_display+"["+super_key_num+"]";
						}
					/*
						if(super_yn.equals("Y") && RD_yn.equals("M") && mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){ //Supernumerarary Case
							tooth_no_display = display_tooth_no+"s";
						}
						else if(super_yn.equals("Y") && !mixed_dentition_YN.equals("Y") && !permanent_deciduous_flag.equals("D")){ //Supernumerarary Case
							tooth_no_display = display_tooth_no+"s";
						}
						else if(super_yn.equals("Y") && !RD_yn.equals("M")){ //Supernumerarary Case
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,tooth_no);
							pstmt2.setString(3,PD_flag);
							rs2 = pstmt2.executeQuery();
							while(rs2.next()){
								tooth_no_display = rs2.getString("NS_TOOTH_NO");
							}

							tooth_no_display = tooth_no_display+"s";
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && (RD_yn.equals("R") || RD_yn.equals("M"))){
							tooth_no_display = display_tooth_no;
						}
						else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,tooth_no);
							pstmt2.setString(3,PD_flag);
							rs2 = pstmt2.executeQuery();
							while(rs2.next()){
								tooth_no_display = rs2.getString("NS_TOOTH_NO");
							}
						}*/
						/*
						else if(RD_yn.equals("R") || RD_yn.equals("D") || (mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !RD_yn.equals("M"))){ //Retained Deciduous Case
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,tooth_no);
							pstmt2.setString(3,PD_flag);
							rs2 = pstmt2.executeQuery();
							while(rs2.next()){
								tooth_no_display = rs2.getString("NS_TOOTH_NO");
							}
						}
						*/
						/*
						else{
							if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !RD_yn.equals("M")){
								
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
								}
							}
							else{
								
								tooth_no_display = display_tooth_no;
							}
						}*/
					//	if(!dtl_status.equals("Z")){//commented by parul for IN012017 on 7/2/2009(in histroy if u record retained icon was not coming now if u recored icon wl come for permanent tooth for decidous tooth status is inserted as 'Z')
							out.println("<tr>");
							if(!trmt_category_type.equals("BRIDGE")){
								count_records_cond++;
								if(treatment_condition_tab_flag.equals("T")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_no_display_for_task));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_range));
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(reg_completed_count>0)
								{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=javascript:openNotes('"+i+"','"+progress_note_group+"','TRMTTODO') style='cursor:pointer;'><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></a></font></td>");
								}
								else
								{ out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></td>");
								}

								}
								if(imageId == null || imageId.equals(null) || imageId.equals("null") || imageId.equals("")){
									out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
								}
								else{
									out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
								}
								
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
								if(treatment_condition_tab_flag.equals("T")){
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:green;text-size:2><font color='blue'><a onClick=\"javascript:showTasksWindow('"+i+"','"+condition_trmt_code_desc_for_task+"','TRMTTODO')\" style='cursor:pointer;'>"+condition_trmt_code_desc+"</a></font></td>");
								}else{
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
								}


								 if(treatment_condition_tab_flag.equals("T")){

									//out.println("<td style='text-align:center' id='remarks"+i+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+i+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");	
									
									out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap>"+remarks+"</td>");

								}

								if(site_type.equals("ARCH") || site_type.equals("QUAD")){
									out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+arch_quad_desc+"</td>");
								}
								else{
									//out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
									out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
								}

								//out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
								out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
								
								//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field in the history area.

								if(treatment_condition_tab_flag.equals("C")){
								//	out.println("<td  id='remarks"+i+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+i+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");	
								
							   out.println("<td id='remarksCondition_"+i+"' WIDTH='30%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							
								}
								
								out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");
								out.println("</tr>");
								 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block44Bytes, _wl_block44);
 
								i++;
							}	
							else if(trmt_category_type.equals("BRIDGE")){
								if(treatment_condition_tab_flag.equals("T")){
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_no_display_for_task));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_range));
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(reg_completed_count>0)
								{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=javascript:openNotes('"+i+"','"+progress_note_group+"','TRMTTODO') style='cursor:pointer;'><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></a></font></td>");
								}
								else
								{ out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></td>");
								}

								}
								count_records_cond++;
								if(imageId == null || imageId.equals(null) || imageId.equals("null") || imageId.equals("")){
									out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
								}
								else{
									out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
								}
								
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
                                if(treatment_condition_tab_flag.equals("T")){
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=\"javascript:showTasksWindow('"+i+"','"+condition_trmt_code_desc_for_task+"','TRMTTODO')\" style='cursor:pointer;'>"+condition_trmt_code_desc+"</a></font></td>");
								}else{
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
								}

								 if(treatment_condition_tab_flag.equals("T")){
									   //String remarks_flag="C";

									//out.println("<td style='text-align:center' id='remarks"+i+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+i+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");						                                 							
							   out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");
	                                 							
														                                 							
								}
								out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");

								out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");

								//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field in the history area.

								if(treatment_condition_tab_flag.equals("C")){
							   out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");
									//out.println("<td style='text-align:center' id='remarks"+i+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+i+"','"+remarks_flag+"');><font class='HYPERLINK' style=''text-align:left';font-size:8pt;color:blue;cursor:pointer;font-weight:normal'>"+remarks_title+"</font></td>");		
							
            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								//
								out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");

							out.println("</tr>");
							
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block48Bytes, _wl_block48);

								i++;
							}
						//}
						
            _bw.write(_wl_block49Bytes, _wl_block49);

					}
				
            _bw.write(_wl_block50Bytes, _wl_block50);

						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}else if(treatment_condition_tab_flag.equals("T")){
					
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
					
            _bw.write(_wl_block52Bytes, _wl_block52);
if(treatment_condition_tab_flag.equals("T")){
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

						if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(treatment_condition_tab_flag.equals("T")){
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}

						if(site_type.equals("ARCH")){
					
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(site_type.equals("QUAD")){
					
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else{
					
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

						}

					if(treatment_condition_tab_flag.equals("C")){
					
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
					
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

					rs1=pstmt1.executeQuery();
					i=1;
					j=1;
					classValue = "";
					imageId = "";
					desc = "";
					date = "";
					doneby = "";
					trmt_category_type = "";
					condition_trmt_code_desc = "";
					display_status_identifier = "";
					hide_image_yn = "";
					super_yn = "";
					RD_yn = "";
					tooth_no_display = "";
					tooth_no_display_for_task = "";
					super_tooth_no = "";
					retained_tooth_no = "";
					super_key_num = "";
					surface_code = "";
					String location = "";
				    image_id_new = "";
				    treatment_int_ext = "";
				    treatments_outcome = "";
					//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
					String pontic_dtls = "";
					String image_for_pontic_tooth = "../../eOH/images/drugInfo.gif";
					int bridge_count = 0;
					//End
					
					while(rs1.next()){
						count_records_trmt++;
						if ( i % 2 == 0 ){
							classValue = "QRYEVEN" ;
						}
						else{
							classValue = "QRYODD" ;
						}

						imageId = checkForNull(rs1.getString("IMAGE_ID"));
						desc = checkForNull(rs1.getString("CONDITION_TRMT_DESC"));
						//date = checkForNull(rs1.getString("TREATMENT_CONDITION_DATE"));
						date=checkForNull(com.ehis.util.DateUtils.convertDate(rs1.getString("TREATMENT_CONDITION_DATE"),"DMY","en",locale));

						doneby = checkForNull(rs1.getString("MODIFIED_BY_ID"));
						status = checkForNull(rs1.getString("STATUS"));
						status_desc = checkForNull(rs1.getString("STATUS_DESC"));
						status_desc = "["+status_desc+"]";
						trmt_category_type = checkForNull(rs1.getString("TRMT_CATEGORY_TYPE"));
						location = checkForNull(rs1.getString("LOCATION"));
						condition_trmt_code_desc =  checkForNull(rs1.getString("CONDITION_TRMT_CODE_DESC"));
						condition_trmt_code_desc_for_task=checkForNull(rs1.getString("CONDITION_TRMT_CODE_DESC"));
						hide_image_yn =  checkForNull(rs1.getString("HIDE_IMAGE_YN"));
						super_yn =  checkForNull(rs1.getString("SUPERNUMERARY_YN"));
						RD_yn =  checkForNull(rs1.getString("MIXED_DENT_DECIDUOUS_YN"));
						//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
						remarks = checkForNull(rs1.getString("REMARKS"));
						super_tooth_no = checkForNull(rs1.getString("SUPER_TOOTH_NO"));
						retained_tooth_no = checkForNull(rs1.getString("RETAINED_TOOTH_NO"));
						super_key_num = checkForNull(rs1.getString("SUPER_KEY_NUM"));
						surface_code = checkForNull(rs1.getString("SURFACE_CODE"));
						chart_line_num = checkForNull(rs1.getString("CHART_LINE_NUM"));
						trmt_code = checkForNull(rs1.getString("TRMT_CODE"));
						//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
						pontic_dtls = checkForNull(rs1.getString("PONTIC_TOOTH_DTLS"));
						progress_note_group = checkForNull(rs1.getString("PROGRESS_NOTE_GROUP"));
						treatment_int_ext = checkForNull(rs1.getString("TREATMENT_INT_EXT"));
						treatments_outcome = checkForNull(rs1.getString("TREATMENTS_OUTCOME"));
						tooth_range = checkForNull(rs1.getString("TOOTH_RANGE"));
						
                       
						//End

						if(!trmt_category_type.equals("")){
							image_id_new = checkForNull(rs1.getString("IMAGE_ID_NEW"));
							if(trmt_category_type.equals("ROOTTMT")){
							  imageId="";
							}else{
								imageId=image_id_new;
							}
						}

						if(!surface_code.equals("*A") && trmt_category_type.equals("CROWN")){
							imageId="";
						}
						
						 if (surface_code.equals("*A") && trmt_category_type.equals("CROWN")){//added by parul on 28/02/2010 for CRF-477
							if(permanent_deciduous_flag.equals("P")){
								 if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
												imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;
									}
								 }else  if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
											imageId = image_id_new;
									}
								 }
							}else{
								  if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
											imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
											imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;

									}
								 }else if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
										  imageId = image_id_new;
									}
								 }
									
							}
						}
 
						if(trmt_category_type.equals("TOOTHTM")){
							if(status.equals("") && treatment_int_ext.equals("E")){
							//	imageId = "../../eOH/images/TRMT_Perf.gif";
								imageId = image_id_new;//added by parul on 01/03/2010 for CRF-477
							}else if(!status.equals("85") && !status.equals("60")){
								imageId = "../../eOH/images/TRMT_Planned.gif";
							}
						}						


						if(trmt_category_type.equals("EXTRACT") && !status.equals("85") && !status.equals("60") && treatment_condition_tab_flag == "T"){
							imageId = "../../eOH/images/Extraction-CrownYellow.gif";
						}

						if(treatment_condition_tab_flag.equals("T")){
							if(status.equals("85") || status.equals("60")){
								display_status_identifier = "[RS]"; //ResultEntry(Result completed)
							}
							condition_trmt_code_desc = condition_trmt_code_desc+status_desc;
						}

						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
					
							if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}
							else if(super_yn.equals("Y") && !RD_yn.equals("M")){ //Supernumerarary Case
								/* By Sridevi on 07/08/09 to Display tooth no for deciduous tooth for which SUPRTH is recorded*/
								if(!(tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
									
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}

									//tooth_no_display = display_tooth_no+"s";
									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num;
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
								}
								else{ /* By Sridevi on 07/08/09 to Display tooth no for permanent tooth for which SUPRTH is recorded*/
									//tooth_no_display = display_tooth_no+"s";
									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num;
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
								}
							}
							else if(RD_yn.equals("R") || RD_yn.equals("M")){
								if(retained_tooth_no.equals("") || retained_tooth_no.equals("null") || retained_tooth_no.equals(null)){//Supernumerarary Case added bya parul for super changes on 07/01/2010
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
								}else{
									tooth_no_display=retained_tooth_no;
									tooth_no_display_for_task=retained_tooth_no;

								}

							}
							else{
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");

								}

								if(tooth_no_display.equals("")||tooth_no_display.equals("null") ||tooth_no_display.equals(null) ){//added by parul for permanent tooth ...tooth no was not comning
									tooth_no_display = display_tooth_no;
									tooth_no_display_for_task = display_tooth_no;
								}	
								
								///By Sridevi on 07/08/09 to Display tooth no for Deciduous tooth for conditions other than SUPRTH 
								if((tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									tooth_no_display = display_tooth_no;
									tooth_no_display_for_task = display_tooth_no;

								}
							}/*
								//Commented and added by Sridevi Joshi on 06/11/09 as it was there for Conditions block...was missing here
								//Passed PERMANENT_DECIDUOUS as P, when RD_YN and super_yn are null 
								//pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = 'P'");
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								//pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
								}

								//Commented by Sharon Crasta on 9/22/2009 for IN014657
								//tooth_no_display = display_tooth_no;
								//

								//To Display tooth no for Permanennt tooth(After EXFOLTH--->ERUPTH) for conditions other than SUPRTH 
								if(tooth_no_display.equals("") || tooth_no_display.equals("null") || tooth_no_display.equals(null)){  
									tooth_no_display = display_tooth_no;
									
								}
								

								// By Sridevi on 07/08/09 to Display tooth no for extream tooth for conditions other than SUPRTH 
								if((tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									tooth_no_display = display_tooth_no;
								}
							}*/
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
							if(super_yn.equals("Y") && RD_yn.equals("D")){

								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
					
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
								//tooth_no_display = tooth_no_display+"s";
									tooth_no_display = super_key_num;
									tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}
							/*else if(super_yn.equals("Y")){ //Supernumerarary Case
								tooth_no_display = display_tooth_no+"s";
							}*/
							else if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}
							else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}
							}
							else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
						
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							else{
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
							}
						}
						else{
							if(RD_yn.equals("R")){
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							//else if(super_yn.equals("Y")){ //commented by parul on 08/12/2009 for super changes//Supernumerarary Case added for IN015465 by Sridevi Joshi on 21/10/09
							else if(!super_tooth_no.equals("")){ //Supernumerarary Case added for IN015465 by Sridevi Joshi on 21/10/09
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							else{
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
							
							}
							
						}

						//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
						/*pstmt3 = con.prepareStatement("SELECT COUNT(*)BRIDGE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E'");
						pstmt3.setString(1, patient_id);
						pstmt3.setString(2, chart_num);
						pstmt3.setString(3, tooth_no);
						rs3 = pstmt3.executeQuery();
						while(rs3.next()){
							bridge_count = Integer.parseInt(rs3.getString("BRIDGE_COUNT"));
							
						}*/
						//End
						out.println("<tr>");
						if(!trmt_category_type.equals("BRIDGE")){

								if(treatment_condition_tab_flag.equals("T")){
									
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_no_display_for_task));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_range));
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(Integer.parseInt(status)>=25)
								{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=javascript:openNotes('"+i+"','"+progress_note_group+"','TRMTDONE') style='cursor:pointer;'><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></a></font></td>");
								}
								else
								{ out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></td>");
								}
								}

								if(imageId == null || imageId.equals(null) || imageId.equals("")){
		
								//out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
							}
							else{
								//out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
							}
						
							out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
                             if(treatment_condition_tab_flag.equals("T")){
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=\"javascript:showTasksWindow('"+i+"','"+condition_trmt_code_desc_for_task+"','TRMTDONE')\" style='cursor:pointer;'>"+condition_trmt_code_desc+"</a></font></td>");
							}else{
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
							}
							if(treatment_condition_tab_flag.equals("C") && (!site_type.equals("QUAD")) && (!site_type.equals("ARCH"))){
							 //String remarks_flag="E";
							//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
                                   
								out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
								 
								//out.println("<td style='text-align:center' id='remarks"+j+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+j+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");	
								 out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							
            _bw.write(_wl_block71Bytes, _wl_block71);

								out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
							}
							else if(treatment_condition_tab_flag.equals("T")){//added by parul on 4/16/2009
									 //String remarks_flag="E";

									//out.println("<td style='text-align:center' id='remarks"+j+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+j+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");						                                 							
								   out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							}
						
                             if(site_type.equals("ARCH") || site_type.equals("QUAD")){
								out.println("<td WIDTH='15%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+arch_quad_desc+"</td>");
							}
							else{
									if(treatment_condition_tab_flag.equals("T")){

									out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
								}
							}
			                 if(site_type.equals("ARCH") || site_type.equals("QUAD")){
								 if (treatment_condition_tab_flag.equals("C")){
									 //String remarks_flag="E";

									//out.println("<td style='text-align:center' id='remarks"+j+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+j+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");	
								  out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

									out.println("<td WIDTH='20%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
								 }
							 }

							out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");

							out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");

							out.println("</tr>");
						
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block74Bytes, _wl_block74);

							i++;
							j++;

						}
						else if(trmt_category_type.equals("BRIDGE")){

							pstmt3 = con.prepareStatement("SELECT COUNT(*)BRIDGE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E'");
							pstmt3.setString(1, patient_id);
							pstmt3.setString(2, chart_num);
							pstmt3.setString(3, tooth_no);
							rs3 = pstmt3.executeQuery();
							while(rs3.next()){
								bridge_count = Integer.parseInt(rs3.getString("BRIDGE_COUNT"));
								
							}
							if(treatment_condition_tab_flag.equals("T")){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_no_display_for_task));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooth_range));
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(Integer.parseInt(status)>=25)
							{
							out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=javascript:openNotes('"+i+"','"+progress_note_group+"','TRMTDONE') style='cursor:pointer;'><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></a></font></td>");
							}
							else
							{ out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img border=1 style='border-color:white' id='ATRARER' src='../../eCA/images/flow_text.gif' alt='"+notes_label+"'/></td>");
							}
							}
							if(imageId == null || imageId.equals(null) || imageId.equals("")){
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
							}
							else{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
							}
						
							out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
                            if(treatment_condition_tab_flag.equals("T")){
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=\"javascript:showTasksWindow('"+i+"','"+condition_trmt_code_desc_for_task+"','TRMTDONE')\" style='cursor:pointer;'>"+condition_trmt_code_desc+"</a></font>");
								//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
								if(trmt_category_type.equals("BRIDGE") && bridge_count > 0 ){
									if(!pontic_dtls.equals("") && !pontic_dtls.equals("null") && !pontic_dtls.equals(null)) {
										out.println("<font color='red'><a onMouseOver=\"javascript:showPonticToothTooltip('"+pontic_dtls+"','"+display_tooth_no+"');\" onMouseOut=UnTip(); style='cursor:pointer;'><img src = '"+image_for_pontic_tooth+"' /></a></font></td>");
										
									}
								}//End
						    }
							else{
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"");
								//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
								if(trmt_category_type.equals("BRIDGE") && bridge_count > 0 ){
									if(!pontic_dtls.equals("") && !pontic_dtls.equals("null") && !pontic_dtls.equals(null)) {
										out.println("<font color='red'><a onMouseOver=\"javascript:showPonticToothTooltip('"+pontic_dtls+"','"+display_tooth_no+"');\" onMouseOut=UnTip(); style='cursor:pointer;'><img src = '"+image_for_pontic_tooth+"' /></a></font></td>");
										
									}
								}//End
							}


							if(treatment_condition_tab_flag.equals("T")){
								//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
							    //String remarks_flag="E";
								//out.println("<td style='text-align:center' id='remarks"+j+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+j+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");

							    out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							}
							if(site_type.equals("ARCH") || site_type.equals("QUAD")){
								out.println("<td WIDTH='15%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+arch_quad_desc+"</td>");
							}
							else{
								out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+display_tooth_no+"</td>");
							}

							if(treatment_condition_tab_flag.equals("C")){
								//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
								 							    //String remarks_flag="E";
							//	out.println("<td style='text-align:center' id='remarks"+j+"' WIDTH='25%' class='"+classValue+"' onClick=showRemarks('"+locale+"','"+remarks_title+"','"+j+"','"+remarks_flag+"');><font class='HYPERLINK' style='cursor:pointer';'font-size:2pt'>"+remarks_title+"</font></td>");

								 out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							
								out.println("<td WIDTH='20%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
							} 

							out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");

							out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");

							out.println("</tr>");
							
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block81Bytes, _wl_block81);

							i++;
							j++;

							
						}
					}
				
            _bw.write(_wl_block82Bytes, _wl_block82);

				if(treatment_condition_tab_flag.equals("T")){
			
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);


						if(site_type.equals("ARCH")){
					
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else if(site_type.equals("QUAD")){
					
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else{
					
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

						}					
					
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

					rs4=pstmt4.executeQuery();
					i=1;
					j=1;
					classValue = "";
					imageId = "";
					desc = "";
					date = "";
					doneby = "";
					trmt_category_type = "";
					condition_trmt_code_desc = "";
					display_status_identifier = "";
					hide_image_yn = "";
					super_yn = "";
					RD_yn = "";
					tooth_no_display = "";
					tooth_no_display_for_task = "";
					super_tooth_no = "";
					retained_tooth_no = "";
					super_key_num = "";
					surface_code = "";
					location = "";
				    image_id_new = "";
				    treatment_int_ext = "";
				    treatments_outcome = "";
					//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
					 pontic_dtls = "";
					 image_for_pontic_tooth = "../../eOH/images/drugInfo.gif";
					 bridge_count = 0;
					//End
					
					while(rs4.next()){
						count_records_trmt++;
						if ( i % 2 == 0 ){
							classValue = "QRYEVEN" ;
						}
						else{
							classValue = "QRYODD" ;
						}

						imageId = checkForNull(rs4.getString("IMAGE_ID"));
						desc = checkForNull(rs4.getString("CONDITION_TRMT_DESC"));
						//date = checkForNull(rs1.getString("TREATMENT_CONDITION_DATE"));
						date=checkForNull(com.ehis.util.DateUtils.convertDate(rs4.getString("TREATMENT_CONDITION_DATE"),"DMY","en",locale));

						doneby = checkForNull(rs4.getString("MODIFIED_BY_ID"));
						status = checkForNull(rs4.getString("STATUS"));
						status_desc = checkForNull(rs4.getString("STATUS_DESC"));
						status_desc = "["+status_desc+"]";
						trmt_category_type = checkForNull(rs4.getString("TRMT_CATEGORY_TYPE"));
						location = checkForNull(rs4.getString("LOCATION"));
						condition_trmt_code_desc =  checkForNull(rs4.getString("CONDITION_TRMT_CODE_DESC"));
						condition_trmt_code_desc_for_task=checkForNull(rs4.getString("CONDITION_TRMT_CODE_DESC"));
						hide_image_yn =  checkForNull(rs4.getString("HIDE_IMAGE_YN"));
						super_yn =  checkForNull(rs4.getString("SUPERNUMERARY_YN"));
						RD_yn =  checkForNull(rs4.getString("MIXED_DENT_DECIDUOUS_YN"));
						//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
						remarks = checkForNull(rs4.getString("REMARKS"));
						super_tooth_no = checkForNull(rs4.getString("SUPER_TOOTH_NO"));
						retained_tooth_no = checkForNull(rs4.getString("RETAINED_TOOTH_NO"));
						super_key_num = checkForNull(rs4.getString("SUPER_KEY_NUM"));
						surface_code = checkForNull(rs4.getString("SURFACE_CODE"));
						chart_line_num = checkForNull(rs4.getString("CHART_LINE_NUM"));
						trmt_code = checkForNull(rs4.getString("TRMT_CODE"));
						//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
						pontic_dtls = checkForNull(rs4.getString("PONTIC_TOOTH_DTLS"));
						progress_note_group = checkForNull(rs4.getString("PROGRESS_NOTE_GROUP"));
						treatment_int_ext = checkForNull(rs4.getString("TREATMENT_INT_EXT"));
						treatments_outcome = checkForNull(rs4.getString("TREATMENTS_OUTCOME"));

						//End

						if(!trmt_category_type.equals("")){
							image_id_new = checkForNull(rs4.getString("IMAGE_ID_NEW"));
							if(trmt_category_type.equals("ROOTTMT")){
							  imageId="";
							}else{
								imageId=image_id_new;
							}
						}

						if(!surface_code.equals("*A") && trmt_category_type.equals("CROWN")){
							imageId="";
						}
						
						 if (surface_code.equals("*A") && trmt_category_type.equals("CROWN")){//added by parul on 28/02/2010 for CRF-477
							if(permanent_deciduous_flag.equals("P")){
								 if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
												imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;
									}
								 }else  if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("1"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("16")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
											imageId = image_id_new;
									}
								 }
							}else{
								  if (treatment_int_ext.equals("E")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
											imageId = "../../eOH/images/CrownDown_EF.gif";
										}else{
											imageId = "../../eOH/images/CrownDown_E.gif";
										}
									}else{
											imageId = image_id_new;

									}
								 }else if (treatment_int_ext.equals("I")){
									if ((Integer.parseInt(tooth_no)>=(Integer.parseInt("33"))) && (Integer.parseInt(tooth_no)<=(Integer.parseInt("42")))){
										if(treatments_outcome.equals("F")){
												imageId = "../../eOH/images/CrownDown_F.gif";
											}else{
												imageId = "../../eOH/images/CrownDown.gif";
											}
									 }else{
											imageId = image_id_new;
									}
								 }
									
							}
						}
						
						if(trmt_category_type.equals("TOOTHTM")){
							if(status.equals("") && treatment_int_ext.equals("E")){
							//	imageId = "../../eOH/images/TRMT_Perf.gif";
								imageId = image_id_new;//added by parul on 01/03/2010 for CRF-477
							}else if(!status.equals("85") && !status.equals("60")){
								imageId = "../../eOH/images/TRMT_Planned.gif";
							}
						}

						if(trmt_category_type.equals("EXTRACT") && !status.equals("85") && !status.equals("60") && treatment_condition_tab_flag == "T"){
							imageId = "../../eOH/images/Extraction-CrownYellow.gif";
						}

						if(treatment_condition_tab_flag.equals("T")){
							if(status.equals("85") || status.equals("60")){
								display_status_identifier = "[RS]"; //ResultEntry(Result completed)
							}
							condition_trmt_code_desc = condition_trmt_code_desc;
						}
						
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}
							else if(super_yn.equals("Y") && !RD_yn.equals("M")){ //Supernumerarary Case
								/* By Sridevi on 07/08/09 to Display tooth no for deciduous tooth for which SUPRTH is recorded*/
								if(!(tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
									
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}

									//tooth_no_display = display_tooth_no+"s";
									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num;
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
								}
								else{ /* By Sridevi on 07/08/09 to Display tooth no for permanent tooth for which SUPRTH is recorded*/
									//tooth_no_display = display_tooth_no+"s";
									if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
										//tooth_no_display = display_tooth_no+"s";
										tooth_no_display = super_key_num;
										tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
									}
								}
							}
							else if(RD_yn.equals("R") || RD_yn.equals("M")){
								if(retained_tooth_no.equals("") || retained_tooth_no.equals("null") || retained_tooth_no.equals(null)){//Supernumerarary Case added bya parul for super changes on 07/01/2010
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
								}else{
									tooth_no_display=retained_tooth_no;
									tooth_no_display_for_task=retained_tooth_no;

								}

							}
							else{
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");

								}

								if(tooth_no_display.equals("")||tooth_no_display.equals("null") ||tooth_no_display.equals(null) ){//added by parul for permanent tooth ...tooth no was not comning
									tooth_no_display = display_tooth_no;
									tooth_no_display_for_task = display_tooth_no;

								}	
								
								///By Sridevi on 07/08/09 to Display tooth no for Deciduous tooth for conditions other than SUPRTH 
								if((tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
									tooth_no_display = display_tooth_no;
									tooth_no_display_for_task = display_tooth_no;

								}
							}
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
								
							if(super_yn.equals("Y") && RD_yn.equals("D")){

								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
					
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
								//tooth_no_display = tooth_no_display+"s";
									tooth_no_display = super_key_num;
									tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
								}
							/*else if(super_yn.equals("Y")){ //Supernumerarary Case
								tooth_no_display = display_tooth_no+"s";
							}*/
							else if(!super_tooth_no.equals("")){ //Supernumerarary Case added bya parul for super changes on 09/12/2009
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}
							else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
									pstmt2.setString(1,tooth_numbering_system);
									pstmt2.setString(2,tooth_no);
									pstmt2.setString(3,PD_flag);
									rs2 = pstmt2.executeQuery();
									while(rs2.next()){
										tooth_no_display = rs2.getString("NS_TOOTH_NO");
										tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
									}
							}else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
						
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							else{
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
							}
						}
						else{
							if(RD_yn.equals("R")){
								pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							//else if(super_yn.equals("Y")){ //commented by parul on 08/12/2009 for super changes//Supernumerarary Case added for IN015465 by Sridevi Joshi on 21/10/09
							else if(!super_tooth_no.equals("")){ //Supernumerarary Case added for IN015465 by Sridevi Joshi on 21/10/09
								//tooth_no_display = display_tooth_no+"s";
								tooth_no_display = super_key_num;
								tooth_no_display_for_task = super_key_num+"["+display_tooth_no+"]"; 
							}else if(!retained_tooth_no.equals("") && !retained_tooth_no.equals("null") && !retained_tooth_no.equals(null)){//added by parul for retained changes on 22/12/2009
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
								pstmt2.setString(1,tooth_numbering_system);
								pstmt2.setString(2,tooth_no);
								pstmt2.setString(3,PD_flag);
								rs2 = pstmt2.executeQuery();
								while(rs2.next()){
									tooth_no_display = rs2.getString("NS_TOOTH_NO");
									tooth_no_display_for_task = rs2.getString("NS_TOOTH_NO");
								}
							}
							else{
								tooth_no_display = display_tooth_no;
								tooth_no_display_for_task = display_tooth_no;
							
							}
							
						}
						
						out.println("<tr>");
						if(!trmt_category_type.equals("BRIDGE")){
							
							if(imageId == null || imageId.equals(null) || imageId.equals("")){
								//out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
							}
							else{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
							}
						
							out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
                          
								out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
										
							if((!site_type.equals("QUAD")) && (!site_type.equals("ARCH"))){
							//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to display the remarks field .
                                   
								out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
								 
							
								 out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

							
            _bw.write(_wl_block71Bytes, _wl_block71);

								out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
							}
							else if(treatment_condition_tab_flag.equals("T")){//added by parul on 4/16/2009
									                          							
								   if(site_type.equals("ARCH") || site_type.equals("QUAD")){
									out.println("<td WIDTH='15%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+arch_quad_desc+"</td>");
								}

							}
						
			                 if(site_type.equals("ARCH") || site_type.equals("QUAD")){
								  out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

									out.println("<td WIDTH='20%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
							 }

							out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");

							out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");

							out.println("</tr>");
						
							i++;
							j++;

						}
						else if(trmt_category_type.equals("BRIDGE")){

							//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
							pstmt3 = con.prepareStatement("SELECT COUNT(*)BRIDGE_COUNT FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID= ? AND CHART_NUM = ? AND TOOTH_NO = ? AND TRMT_CATEGORY_TYPE = 'BRIDGE' AND NVL(STATUS,'X') != 'E'");
							pstmt3.setString(1, patient_id);
							pstmt3.setString(2, chart_num);
							pstmt3.setString(3, tooth_no);
							rs3 = pstmt3.executeQuery();
							while(rs3.next()){
								bridge_count = Integer.parseInt(rs3.getString("BRIDGE_COUNT"));
								
							}
							//End
							
							if(imageId == null || imageId.equals(null) || imageId.equals("")){
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2></td>");
							}
							else{
								out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><img src = '"+imageId+"' /></td>");
							}
						
							out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
                        
							out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"");
							//Added A.PONTIC_TOOTH_DTLS by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
							if(trmt_category_type.equals("BRIDGE") && bridge_count > 0 ){
								if(!pontic_dtls.equals("") && !pontic_dtls.equals("null") && !pontic_dtls.equals(null)) {
									out.println("<font color='red'><a onMouseOver=\"javascript:showPonticToothTooltip('"+pontic_dtls+"','"+display_tooth_no+"');\" onMouseOut=UnTip(); style='cursor:pointer;'><img src = '"+image_for_pontic_tooth+"' /></a></font></td>");
									
								}
							}
							
							if(site_type.equals("ARCH") || site_type.equals("QUAD")){
								out.println("<td WIDTH='15%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+arch_quad_desc+"</td>");
							}
							else{
								out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+display_tooth_no+"</td>");
							}

							 out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");

						
							out.println("<td WIDTH='20%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");

							out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");

							out.println("<td WIDTH='25%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");

							out.println("</tr>");
						
							i++;
							j++;

							
						}
					}
				}

			
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(count_records_cond));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count_records_trmt));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(display_tooth_no));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tooth_no));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(treatment_condition_tab_flag));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(site_type));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(title_desc));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(called_from_viewchart_yn));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(super_tooth_ref));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block112Bytes, _wl_block112);

}catch ( Exception e ) {
	System.err.println("Error in Show All Images,:"+request.getQueryString());
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(rs3!=null) rs3.close();
		if(rs4!=null) rs4.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt3!=null) pstmt3.close();
		if(pstmt4!=null) pstmt4.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block113Bytes, _wl_block113);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions/ExtTreatmentsFor.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions/ExtTreatmentsForToothNo.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsFor.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsForToothNo.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsToDo.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ConditionType.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TreatmentCategory.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TreatmentCategory.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Arch.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Quadrant.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothNo.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothNo.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExtTreatments.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TreatmentsDone.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TreatmentCategory.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExtTreatments.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Arch.Label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Quadrant.Label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothNo.Label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExtTreatments.Label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TreatmentCategory.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExtTreatments.Label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Arch.Label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Quadrant.Label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothNo.Label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
}
