package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __selectnotetypemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SelectNoteTypeMain.jsp", 1709120342000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction callclose()\n{\t\n\tparent.window.close();\n}\nfunction callRecordNotes(){\n\t//alert(\"Enters in callRecordNotes\");\n\tvar formObj =  document.SelectNoteTypeForm;\n\tvar query_flag_yn = formObj.query_flag_yn.value;\n\tvar old_session_user_id=formObj.old_session_user_id.value;\n\tcalled_from = formObj.called_from.value;\n\tvar update_mode = formObj.update_mode.value; // This is being used only for Anaesthesia.\n\tvar secondwindow;\n\tif(formObj.note_type.value==\"\"){\n\t\t//alert(\"Select the Note Type\");\n\t\tformObj.note_type.focus;\n\t}else{\n\t\tif(!parent.window.closed)\n\t\t{\n\t\t\t\tparent.window.close();\n\t\t}\n\n\t\t\n\t\tvar oTAssessment    = getLabel(\"Common.Assessment.label\",\"Common\");\n\t\tvar surgeonNotes    = getLabel(\"eOT.SurgeonNotes.Label\",\"OT\");\n\t\tvar nursingNotes\t= getLabel(\"eOT.NursingNotes.Label\",\"OT\");\n\t\tvar operativeRecords= getLabel(\"eOT.OperativeRecords.Label\",\"OT\");\n\t\tvar holdingAreaNotes= getLabel(\"eOT.HoldingAreaNotes.Label\",\"OT\");\n\t\tvar recoveryNotes   = getLabel(\"eOT.RecoveryNotes.Label\",\"OT\");\n\t\tvar preAnesthesiaDetails    =getLabel(\"eOT.PreAnaesthesiaDetails.Label\",\"OT\");\n\t\tvar intraAnesthesiaDetails= getLabel(\"eOT.IntraAnaesthesiaDetails.Label\",\"OT\");\n\t\tvar postAnesthesiaDetails   =getLabel(\"eOT.PostAnaesthesiaDetails.Label\",\"OT\");\n\t\t\n\t\t\n\t\tvar tab_yn=\"N\";\n\t\tvar title= oTAssessment ;\n\t\tif(called_from==\"SURGEON_NOTES\")\n\t\t\ttitle = surgeonNotes  ;\n\t\tif(called_from==\"NURSING_NOTES\")\n\t\t\ttitle = nursingNotes ;\n\t\tif(called_from==\"OPERATIVE_NOTES\"){\n\t\t\ttab_yn=\"Y\";\n\t\t\ttitle = operativeRecords ;\n\t\t}\n\t\tif(called_from==\"HOLD_NOTES\")\n\t\t\ttitle = holdingAreaNotes ;\n\t\tif(called_from==\"RECOVERY_NOTES\")\n\t\t\ttitle = recoveryNotes  ;\n\t\tif(called_from==\"PRE_ANES\"){\n\t\t\ttab_yn=\"Y\";\n\t\t\ttitle = preAnesthesiaDetails ;\n\t\t}\n\t\tif(called_from==\"INTRA_ANES\"){\n\t\t\ttab_yn=\"Y\";\n\t\t\ttitle = intraAnesthesiaDetails ;\n\t\t}\n\t\tif(called_from==\"POST_ANES\"){\n\t\t\ttab_yn=\"Y\";\n\t\t\ttitle = postAnesthesiaDetails  ;\n\t\t}\n//alert(\"update_mode :\" +update_mode);\n//alert(\"query_flag_yn :\" +query_flag_yn);\n//alert(\"called_from :\" +called_from);\n\n\t\tif((update_mode==\"Y\") && (called_from==\"PRE_ANES\" || called_from==\"INTRA_ANES\" || called_from==\"POST_ANES\" || called_from==\"OPERATIVE_NOTES\"))\n\t\t\ttab_yn=\"N\";\n\t\ttab_yn=\"N\";\n\t\tvar facility_id = formObj.facility_id.value;\n\t\tvar note_type= formObj.note_type.value;\n\t\tvar patient_id = formObj.patient_id.value;\n\t\tvar episode_id = formObj.episode_id.value;\n\t\tvar patient_class = formObj.patient_class.value;\n\t\tvar encounter_id = formObj.encounter_id.value;\n\t\tvar function_id=\"SPCL_NOTE\";\n\t\tvar event_class=\"$PHY$\";\n\t\tvar accession_num=formObj.accession_num.value;\n\t\tvar window_close=\"Y\";\n\t\tvar ot_speciality_code=formObj.speciality_code.value;\n\t\tvar hide_header=\"N\";\n\t\tvar contr_mod_accession_num = formObj.contr_mod_accession_num.value;\n\t\t//alert(\"contr_mod_accession_num====\"+contr_mod_accession_num);\n\t//var contr_mod_accession_num = facility_id+formObj.oper_num.value+ot_speciality_code+formObj.locn_type.value;\n\t//alert(\"Before Url\");\n\tvar url=\"\";\n\t\n\t\tif(query_flag_yn==\"N\"){\n\t\t\t//alert(\"1\");\n\t\t\t //url = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'+\"&title=\"+title+\"&appl_task_id=CLINICAL_NOTES\"+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num;\n\t\t\t url = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'+\"&title=\"+title+\"&appl_task_id=OT_NOTES\"+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num;\n\t\t}else if(query_flag_yn==\"Y\"){\n\t\t\t//alert(\"2\");\n\t\t\t //url = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\"&title=\"+title+\"&appl_task_id=CLINICAL_NOTES\"+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num;\n\t\t\t url = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'+\"&title=\"+title+\"&appl_task_id=OT_NOTES\"+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num;\n\t\t}\n\t\t//alert(\"URL--->138\"+url);\n\t//\talert(\"enter\");\n\t\t/*var xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar xmlStr=\"<root></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t//alert(\"12\");\n\talert(\"url\"+url)\n\t\txmlHttp.open(\"POST\",\"SurgeonNoteselect.jsp?title=\"+title+\"&note_type=\"+note_type+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&function_id=\"+function_id+\"&event_class=\"+event_class+\"&accession_num=\"+accession_num+\"&window_close=\"+window_close+\"&ot_speciality_code=\"+ot_speciality_code+\"&hide_header=\"+hide_header+\"&tab_yn=\"+tab_yn+\"&encounter_id=\"+encounter_id+\"&facility_id=\"+facility_id+\"&contr_mod_accession_num=\"+contr_mod_accession_num,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\t\t\n\t\tvar url_notes=retVal;*/\n\t\t//alert(\"retVal-\"+retVal);\n\t\t\n\tvar dialogHeight = window.screen.availHeight-28 ;\n\tvar dialogWidth  = window.screen.availWidth-10 ;\n\t//var dialogTop    = \"200\";\n\t//var dialogLeft   = \"100\";\n\tvar dialogTop    = \"0\";\n\tvar dialogLeft   = \"0\";\n\t//var features     = \"dialogHeight=\" + dialogHeight + \", dialogWidth=\" + dialogWidth+ \", dialogLeft=\" + dialogLeft+ \", dialogTop=\" +dialogTop+ \", status=no\" ;\n\tvar features = \"Height=\" + dialogHeight + \",Width=\" + dialogWidth+ \", left=\"+dialogLeft+\",top=\"+dialogLeft+\",status=no,resizable=no\";\n\tvar arguments    = \"CAwindow\" ;\n\t//retVal  = window.showModalDialog(url, arguments, features);\n\tsecondwindow  = window.open(url, arguments, features);\n\n//\t\tparent.f_set_user_attribute.location.href=\"../../eOT/jsp/SelectNoteTypeSetUserAttribute.jsp?old_session_user_id=\"+old_session_user_id;\n\n\t}\n}\nfunction trimString(inString) {\n    var outString;\n    var startPos;\n    var endPos;\n    var ch;\n\n    // where do we start?\n    startPos = 0;\n    ch = inString.charAt(startPos);\n    while ((ch == \" \") || (ch == \"\\b\") || (ch == \"\\f\") || (ch == \"\\n\") || (ch == \"\\r\") || (ch == \"\\n\")) {\n        startPos++;\n        ch = inString.charAt(startPos);\n    }\n\n    // where do we end?\n    endPos = inString.length - 1;\n    ch = inString.charAt(endPos);\n    while ((ch == \" \") || (ch == \"\\b\") || (ch == \"\\f\") || (ch == \"\\n\") || (ch == \"\\r\") || (ch == \"\\n\")) {\n        endPos--;\n        ch = inString.charAt(endPos);\n    }\n\n    // get the string\n    outString = inString.substring(startPos, endPos + 1);\n\n    return outString;\n}\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"SelectNoteTypeForm\" id=\"SelectNoteTypeForm\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' align=\'center\'  width=\'100%\' >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<tr>\n\t<td class=\"labels\" width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t\t<select name=\"note_type\" id=\"note_type\">\n\t\t\t<option value=\"\" selected>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t</option>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</select>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td width=\"25%\" class=\"fields\" >\n\t\t<select name=\"note_type\" id=\"note_type\" disabled>\n\t\t<option value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" selected>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</option>\n\t\t</select>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</tr>\n<tr>\n\t<td align=\"right\" class=\"button\" colspan=\"2\">\n\t\t<input type=\"button\" class=\"button\" name=\"OK\" id=\"OK\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onclick=\"callRecordNotes();callclose();\">\n\t\t<input type=\"button\" class=\"button\" name=\"Cancel\" id=\"Cancel\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onclick=\"window.returnValue=\'\';callclose();\">\n\t</td>\n\n</tr>\n</table>\n\t<input type=\'hidden\' name=\'update_mode\' id=\'update_mode\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\'hidden\' name=\'old_session_user_id\' id=\'old_session_user_id\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\t\t\n\t<input type=\'hidden\' name=\"contr_mod_accession_num\" id=\"contr_mod_accession_num\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\t\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\'hidden\' name=\"notes_entered_flag\" id=\"notes_entered_flag\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\t\t\t\t\n\t<input type=\'hidden\' name=\"notes_count\" id=\"notes_count\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\t\t\t\t\n\t<input type=\'hidden\' name=\'query_flag_yn\' id=\'query_flag_yn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\n</form>\n</body>\n</html>\n<script>\n\tvar formObj =  document.SelectNoteTypeForm;\n\tvar notes_entered_flag = formObj.notes_entered_flag.value;\n\tvar notes_count = formObj.notes_count.value;\n\tif(notes_count==1)\n\t\tformObj.note_type.options[1].selected=true;\n\tif(notes_entered_flag==\"true\" || notes_count==1)\n\t\tcallRecordNotes();\n</script>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
 	
	boolean notes_entered_flag	= false;
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");	
	String locale = (String)session.getAttribute("LOCALE"); 
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	int notes_count = 0;
	String query_flag_yn	= request.getParameter("query_flag_yn");
try{
	query_flag_yn=query_flag_yn==null?"N":query_flag_yn;
	query_flag_yn=query_flag_yn.equalsIgnoreCase("null")?"N":query_flag_yn;
	query_flag_yn=query_flag_yn.equals("")?"N":query_flag_yn;
	String old_session_user_id	= (String)session.getValue("login_user");
	String called_from	= request.getParameter("called_from"); //SURGEON_NOTES, NURSING_NOTES, HOLD_NOTES, RECOVERY_NOTES, OPERATIVE_NOTES, PRE_ANES, INTRA_ANES, POST_ANES
	String oper_num	= request.getParameter("accession_num"); //oper_num
	String speciality_code	= request.getParameter("speciality_code");
	String locn_type		= request.getParameter("locn_type");
// Start of ANAESTHESIA arguments
	String anesthesia_srl_no		= request.getParameter("anesthesia_srl_no");
	String anesthesia_accession_num	= request.getParameter("anesthesia_accession_num");
// End of ANAESTHESIA arguments
	String facility_id		= request.getParameter("facility_id");
	String patient_id	= request.getParameter("patient_id");
	String episode_id	= request.getParameter("episode_id");
	String encounter_id	= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("patient_class");
	String contr_mod_accession_num = "";
	if(called_from.equalsIgnoreCase("OPERATIVE_NOTES"))
		locn_type="99";

	if(called_from.equals("PRE_ANES") || called_from.equals("INTRA_ANES") || called_from.equals("POST_ANES")){
		if(called_from.equals("PRE_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"PRE"+anesthesia_accession_num;
		else if(called_from.equals("INTRA_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"INTRA";
		else if(called_from.equals("POST_ANES"))
			contr_mod_accession_num = facility_id+anesthesia_srl_no+"POST";
	}else{
		if(speciality_code.equalsIgnoreCase("all"))
			contr_mod_accession_num = facility_id+oper_num+"*ALL"+speciality_code+locn_type;
		else
			contr_mod_accession_num = facility_id+oper_num+speciality_code+locn_type;
	}
	String accession_num = "";
	String url1 = response.encodeURL("../../eCA/jsp/RecClinicalNotesModal.jsp?");
	String url2 = response.encodeURL("../../eCA/jsp/PhysicanNotesDetails.jsp");

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(url1));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(url1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(url2));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(url2));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String update_mode			= "N";
	String note_type_count		= "";
	String speciality_code_1	= "";
	String sql					= "";
	String note_type_code		= "";
	String note_type_desc		= "";
	connection = ConnectionManager.getConnection(request);	
// exists?
//	sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE";
	
	//sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE AND H.LANGUAGE_ID='"+locale+"' ";
	sql = "SELECT D.NOTE_TYPE, H.NOTE_TYPE_DESC, D.ACCESSION_NUM ACCESSION_NUM FROM CA_ENCNTR_NOTE D, CA_NOTE_TYPE_LANG_VW H WHERE D.CONTR_MOD_ACCESSION_NUM=? AND D.NOTE_TYPE=H.NOTE_TYPE and Event_Status <> '9' AND H.LANGUAGE_ID='"+locale+"' ";//added by Sanjay for Surgeon Notes against IN34391

	pstmt=connection.prepareStatement(sql);
	pstmt.setString(1,contr_mod_accession_num);
	resultset=pstmt.executeQuery();
	while(resultset.next()){
		update_mode="Y";
		notes_entered_flag=true;
		accession_num  = resultset.getString("ACCESSION_NUM");
		note_type_code = resultset.getString("NOTE_TYPE");
		note_type_desc = resultset.getString("NOTE_TYPE_DESC");
	}
	if(notes_entered_flag==false){
		if(called_from.equalsIgnoreCase("OPERATIVE_NOTES")){
			notes_entered_flag=true;
	//		sql = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, 				N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW

			sql = "SELECT P.OPERATIVE_RECORDS_NOTE_TYPE OPERATIVE_RECORDS_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM OT_PARAM P, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=P.OPERATIVE_RECORDS_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				note_type_code = resultset.getString("OPERATIVE_RECORDS_NOTE_TYPE");
				note_type_desc = resultset.getString("NOTE_TYPE_DESC");
			}
		}else if(called_from.equalsIgnoreCase("PRE_ANES") || called_from.equalsIgnoreCase("INTRA_ANES") || called_from.equalsIgnoreCase("POST_ANES")){
			accession_num = "";
			notes_entered_flag=true;
			if(called_from.equalsIgnoreCase("PRE_ANES"))
				sql = "SELECT A.PRE_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.PRE_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			else if(called_from.equalsIgnoreCase("INTRA_ANES"))
				sql = "SELECT A.INTRA_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.INTRA_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 
			if(called_from.equalsIgnoreCase("POST_ANES"))
				sql = "SELECT A.POST_ANES_NOTE_TYPE ANES_NOTE_TYPE, N.NOTE_TYPE_DESC NOTE_TYPE_DESC FROM AT_PARAM A, CA_NOTE_TYPE_LANG_VW N WHERE N.NOTE_TYPE=A.POST_ANES_NOTE_TYPE AND N.LANGUAGE_ID='"+locale+"'"; 

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				note_type_code = resultset.getString("ANES_NOTE_TYPE");
				note_type_desc = resultset.getString("NOTE_TYPE_DESC");
			}
		}else{
			if(speciality_code.equalsIgnoreCase("all"))
				speciality_code_1="*ALL";
			else {
				speciality_code_1 = speciality_code;

				sql="SELECT COUNT(*) NOTE_TYPE_COUNT FROM OT_NOTE_TYPE_FOR_SPECIALTIES WHERE SPECIALTY_CODE=? AND LOCN_TYPE=?";

				if(resultset!=null) resultset.close();
				if(pstmt!=null) pstmt.close();		
				pstmt=connection.prepareStatement(sql);
				pstmt.setString(1,speciality_code_1);
				pstmt.setString(2,locn_type);
				resultset=pstmt.executeQuery();

				while(resultset.next()){
					note_type_count = resultset.getString("NOTE_TYPE_COUNT");
				}
				if(note_type_count.equals("0"))
					speciality_code_1="*ALL";
			}
			sql="SELECT S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE_LANG_VW C WHERE SPECIALTY_CODE=? AND LOCN_TYPE=? AND S.NOTE_TYPE=C.NOTE_TYPE AND NVL(C.EFF_STATUS,'E')='E' AND C.LANGUAGE_ID='"+locale+"'";

			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();		
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,speciality_code_1);
			pstmt.setString(2,locn_type);
			resultset=pstmt.executeQuery();
		}
	}

            _bw.write(_wl_block12Bytes, _wl_block12);

// from query string

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	if(notes_entered_flag==false){
	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

					while(resultset.next()){
						notes_count++;
						note_type_code = resultset.getString("NOTE_TYPE");
						note_type_desc = resultset.getString("NOTE_TYPE_DESC");
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(note_type_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				
            _bw.write(_wl_block20Bytes, _wl_block20);

		}else{
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);

		}
	
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(update_mode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(old_session_user_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(notes_entered_flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(notes_count));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(query_flag_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
	
	}catch(Exception e){
		System.err.println("208: Caught Exception in Select Note Type Form"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		ConnectionManager.returnConnection(connection,request);
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SelectNoteType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
