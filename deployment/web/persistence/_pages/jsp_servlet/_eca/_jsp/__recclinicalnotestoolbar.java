package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotestoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesToolbar.jsp", 1742466650541L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart3.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart4.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<!-- Added by Dinesh for temp -->\n<script language=\'javascript\' src=\'../../eCA/js/RTEditor.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<center>\n\t<form name=\'RecClinicalNotesToolbarForm\' id=\'RecClinicalNotesToolbarForm\'>\n\t<div id =\"Temp2\" name =\"Temp2\">\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' height=\'100%\'  id=\'general_toolbar\' name=\'general_toolbar\' id=\'general_toolbar\'style=\'display:inline\'>\t\t\n\t\t<tr>\t\n\t\t<!-- <td><img id=\'digitalNote\' src=\'../../eCA/images/digitaEditor.gif\' onClick=\"return getDigitalNote()\" style=\"display:inline\" title=\'Digital Note Image\' ></td> -->\n\t\t<td class= \'button\'>\n\t\t<!-- IN052940 Start.-->\t\t\n\t\t<!--62372  start-->\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'Previous_Notes\' id=\'Previous_Notes\' id=\'Previous_Notes\' style=\'display:none\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\tonClick=\"openPreviousNotesDtls();\" >\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  \n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'Previous_Notes\' id=\'Previous_Notes\' id=\'Previous_Notes\' style=\'visibility:hidden\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t\t\t<!-- IN052940 End. -->\n\t\t\t\n\t\t\t<!-- 62372  end -->\n\t\t\t\n\t\t\t<!--IN063931 start-->\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'Previous_Section\' id=\'Previous_Section\' id=\'Previous_Section_Id\' style=\'display:none\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\"openPreviousSectionDtls();\">\n\t\t\t<!--IN063931 ends-->\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'canned_text\' id=\'canned_text\'\t\tvalue=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\t\t  onClick=\'return getCannedText();\'\tstyle=\"display:none\" >\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'chief_complaints\' id=\'chief_complaints\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  onClick=\'return getChiefComplaints();\' style=\"display:none\">\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' id=\'req_transcription\' name=\'req_transcription\' id=\'req_transcription\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  onClick=\'return getTransReq();\' style=\"display:none\">\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class = button align=\"right\" width=\"28%\">\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'Prev_Notes\' id=\'Prev_Notes\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\' getPreNotes();\' >&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'link_doc\' id=\'link_doc\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  onClick=\'return callMeOnLinkDocs();\' style=\"display:none\" >&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class = button align=\"right\">\n\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' id=\'fileupload_btn\' name=\'FileUpload\' id=\'FileUpload\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onClick=\'return RecordClinicalNotesFileUpload(this);\' style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">&nbsp;&nbsp;\n\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onClick=\'return RecordClinicalNotes(this);\' >&nbsp;&nbsp;  <!-- Ramesh -->\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'sign\' id=\'sign\'\tvalue=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'\tonClick=\'return RecordClinicalNotes(this);\'\t >\n\t\t\t\t\t<!--IN071264 Starts-->\n\t\t\t\t\t<td class=button><input type=\'BUTTON\' class=\'BUTTON\' id =\'savedraft\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" Draft\' onClick=\'return saveClinicalNotes();\' style=\'display:none\'>\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' id=\'cleardraft\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" Draft\' onClick=\'return clearSavedNoteInSecTemp(this);\' style=\'display:none\'></td>\n\t\t\t\t\t<!--IN071264 Ends-->\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'sign\' id=\'sign\'\tvalue=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'\tonClick=\'return RecordClinicalNotes(this);\'\t style=\'display:none\'>&nbsp;&nbsp;\n\t\t\t\t\t<!--IN071264 Starts-->\n\t\t\t\t\t<td class=button align=\"center\"><input type=\'BUTTON\' class=\'BUTTON\' id =\'savedraft\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t<!--IN071264 Starts-->\n\t\t<td class=button align=\"center\"><input type=\'BUTTON\' class=\'BUTTON\' id =\'savedraft\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" Draft\' onClick=\'return saveClinicalNotes();\' style=\'display:none\'>\n\t\t<input type=\'BUTTON\' class=\'BUTTON\' id=\'cleardraft\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" Draft\' onClick=\'return clearSavedNoteInSecTemp(this);\' style=\'display:none\'></td>\n\t\t\t\t<!--IN071264 Ends-->\n\t\t\t<td class = button align=\"right\">&nbsp;\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'record\' id=\'record\'\t\tvalue=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'\t\t\t\t\tonClick=\'return RecordClinicalNotes(this);\' style=\"display:none\">&nbsp;&nbsp;\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'sign\' id=\'sign\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\'return RecordClinicalNotes(this);\' style=\"display:none\">\n\n\t\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'notesView\' id=\'notesView\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\'return PreviewRecordClinicalNotes(this);\' style=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\n\t\t<td class = button align=\"right\">&nbsp;\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t<!-- <input type=\'BUTTON\' class=\'BUTTON\' name=\'btn_Print\' id=\'btn_Print\'\tvalue=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'\t\t\tonClick=\"showNotes(\'\',\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'Preview\')\" style=\"display:none\"> [IN032683] --> <!-- </td> -->\n\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'btn_Print\' id=\'btn_Print\'\tvalue=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'Preview\')\">\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\n\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'btn_Print\' id=\'btn_Print\' \tvalue=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\t\t\tonClick=\"assignSectionDetails(\'\',\'\',\'\',\'\',\'Preview\')\" >\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<!-- <td class = button> -->\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'btn_Print\' id=\'btn_Print\' \tvalue=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'\t\t\tonClick=\"assignSectionDetails(\'\',\'\',\'\',\'\',\'Preview\')\" >\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<tr align=\'right\' id=\'display_msg\' >\n\t\t\t<!-- <td style=\'display:none;color:red\' id=\'process_msg\' align=\"left\"><b>Under Process, Please wait........</b></td> -->\n\t\t\t<td colspan=\"5\" id=\'display_view\' align=\'right\'  style=\'display:none;color:red\' >&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b></td>\n\t\t<td>&nbsp</td>\n\t\t<td>&nbsp</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<tr align=\'right\' id=\'display_msg\' >\n\t\t\t<!-- <td style=\'display:none;color:red\' id=\'process_msg\' align=\"left\"><b>Under Process, Please wait........</b></td> -->\n\t\t\t<td colspan=\"5\" id=\'display_view\' align=\'right\'  style=\'display;color:red\' >&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t</table>\n\t</div>\n\t</p>\n\n<input type=hidden name=user_id id=user_id value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name =\'oledb_con_string\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n<input type=\'hidden\' name = \"facility_id\"\tvalue =\"\">\n<input type=\'hidden\' name = \"encounter_id\"\tvalue =\"\">\n<input type=\'hidden\' name = \"resp_id\"\t\tvalue =\"\">\n<input type=\'hidden\' name = \"note_type\"\t\tvalue =\"\">\n<input type=\'hidden\' name = \"function_id\"\t\tvalue =\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name = \"contr_mod_accession_num\"\t\tvalue =\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">  <!--  [IN032874] Start->\t\t<!--  Ramesh -->\n<!--IN063931 start-->\n<input type=\'hidden\' name=\"sec_hdg_code\" id=\"sec_hdg_code\" value=\"\">\n<input type=\'hidden\' name=\"child_sec_hdg_code\" id=\"child_sec_hdg_code\" value=\"\">\n<input type=\"hidden\" name=\"myHIXYN\" id=\"myHIXYN\" value=\"N\"/><!--IN067607-->\n<input type=\"hidden\" name=\"myHIXNoteType\" id=\"myHIXNoteType\" value=\"\"/><!--IN067607-->\n<input type=\"hidden\" name=\"noteCopiedYN\" id=\"noteCopiedYN\" value=\"N\"/><!--IN068105-->\n<input type=\"hidden\" name=\"isModifyDescYN\" id=\"isModifyDescYN\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/><!--IN063818-->\n<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/><!--68801-->\n<!--IN063931 ends-->\n</form>\n\t</center>\n\t<!-- <OBJECT ID=\"WebFp\"\nCLASSID=\"CLSID:CA452A7B-737F-434D-904A-AB06E644C25F\"\nCODEBASE=\"PrintFPCom.CAB#version=1,0,0,0\" VIEWASTEXT></OBJECT> -->\n</body>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</html>\n<!--IN071264 Starts-->\n<script  type=\"text/javascript\">\nvar note_type = \"\";\nif(null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && undefined!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm && null!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type && undefined!=parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type)\n\tnote_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;\nif(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' == \"Y\" && (\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'==\'ModifyAddendum\' || \'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'==\'Update\' || \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'==\'ModifySection\' )){\n\t\n\tdocument.getElementById(\"savedraft\").style=\"display\";\n \tdocument.getElementById(\"cleardraft\").style=\"display\";\n\t \n}\nelse if(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' == \"Y\" && note_type!=\'\')\n{\n\tdocument.getElementById(\"savedraft\").style=\"display\";\n \tdocument.getElementById(\"cleardraft\").style=\"display\";\n}\n</script>\n<!--IN071264 Ends-->\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
06/07/2011    101            Dinesh T    Incident No: 28014, Notes Message shouldn't appearing in the modes such as modify, update
10/05/2012	  IN032682	 	Ramesh G	 System does not display the Print Preview Button some times.
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template 
																			if filled up earlier for same patient in template format.
22/01/2018	IN063931		Prakash C		23/01/2018	Ramesh				KDAH-CRF-0431(Copy previous Section)
22/05/2018	IN067607		Raja S			22/05/2018	Ramesh G			ML-MMOH-CRF-1130.2
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
07/08/2018	IN063818		Raja S			07/08/2018	Ramesh G		MMS-DM-CRF-0102 
18/03/2020  IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
19/06/2024	  62372			Twinkle Shah    19/04/2021	    ML-MMOH-CRF-2149.1

28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

String auto_save_yn ="N";//IN071264
String operation_mode		=	"";//IN071264
try
{
	Connection			con		= null; //62372
	PreparedStatement	pstmt	= null; //62372
	ResultSet			rs		= null; //62372
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String oledb_con_string				=	"";
	String license_rights				=	"",		strLinkDocEnDis		=	"";
	String doc_linked_note_yn			=	"",		login_user_id		=	"";
	String function_id					=	"";
	String appl_task_id					=	"";
	String displayNotesView					=	"display:none";
	//IN063818 starts
	boolean isModifyDescSS = false;
	String isModifyDescYN = "N";
	String beanId					= "CAClinicalHistoryBean" ;
	String beanName				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean beanObj	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
	isModifyDescSS = beanObj.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
	if(isModifyDescSS)
		isModifyDescYN ="Y";
	//IN063818 ends
	//62372  starts.
	String hide_copy_pre_rec_clnt_yn="";
	int getAccessRightsViewPractYN=0;
	String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
						String facilityId = (String) session.getValue("facility_id");
getAccessRightsViewPractYN=beanObj.getAccessRightsViewCopyPreviousBtn(ca_practitioner_id, facilityId);
try{
con = ConnectionManager.getConnection(request);
pstmt= con.prepareStatement("SELECT NVL(HIDE_COPY_PRE_REC_CLNT_YN,'N') HIDE_COPY_PRE_REC_CLNT_YN FROM CA_NOTE_PARAM");
rs=pstmt.executeQuery();

if(rs.next())
{
hide_copy_pre_rec_clnt_yn  = rs.getString("HIDE_COPY_PRE_REC_CLNT_YN");	
}
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
if(con != null) ConnectionManager.returnConnection(con);	
}
//62372 end
    String order_id=""; //68801
	oledb_con_string	=	(String) session.getValue("oledb_con_string");
	login_user_id		=	(String) session.getValue("login_user");

	operation_mode		=	(request.getParameter("operation_mode")==null) ? "" : request.getParameter("operation_mode");
	doc_linked_note_yn	=	(request.getParameter("doc_linked_note_yn")==null) ? "" : request.getParameter("doc_linked_note_yn");

	

	function_id			=	(request.getParameter("function_id")==null)?"":request.getParameter("function_id");
	appl_task_id			=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	String contr_mod_accession_num = (request.getParameter("contr_mod_accession_num")==null)?"":request.getParameter("contr_mod_accession_num");  //[IN032874]
	order_id			=	(request.getParameter("order_id")==null)?"":request.getParameter("order_id"); //68801

		
	if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
		license_rights= "FULL";
	else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
		license_rights= "BASIC";
	else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
		license_rights= "MINI";
	//IN071264 Starts
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	//IN071264 Ends

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(hide_copy_pre_rec_clnt_yn.equals("N") || (hide_copy_pre_rec_clnt_yn.equals("Y") && getAccessRightsViewPractYN > 0)){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousNote.label","ca_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		else{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousNote.label","ca_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CopyFromPreviousSection.label","ca_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CannedText.label","ca_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChiefComplaints.label","ca_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReqTranscription.label","ca_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);

			if(!function_id.equals("SIGN_NOTES") && !function_id.equals("REVIEW_NOTES")&& !appl_task_id.equals("PROGRESS_NOTES"))
			{
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PrevNotes.label","ca_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}

			if( operation_mode.equals("ModifyAddendum") )
				strLinkDocEnDis = "style=display:none";
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkDoc.label","ca_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strLinkDocEnDis));
            _bw.write(_wl_block21Bytes, _wl_block21);

			
			String strEnDis = "display:none";

			if(doc_linked_note_yn.equals("Y"))
				strEnDis = "";
			else
				strEnDis = "display:none";
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Upload.label","ca_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strEnDis));
            _bw.write(_wl_block24Bytes, _wl_block24);
			
		
			String strSignButCaption = "";

			if( operation_mode.equals("ModifyAddendum") )
				strSignButCaption = "Sign Addendum";
			else{
			//IN063818 starts
				if(isModifyDescSS)
					strSignButCaption = "  Update  ";		
				else
					strSignButCaption = "  Modify  ";		
			//IN063818 ends
			}

				if(operation_mode.equals(""))
					displayNotesView = "display";

			if( operation_mode.equals("ModifyAddendum") )
			{
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strSignButCaption));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
			else if(operation_mode.equals("ModifySection"))
			{
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strSignButCaption));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
			else
			{
				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(displayNotesView));
            _bw.write(_wl_block39Bytes, _wl_block39);

			}  
            _bw.write(_wl_block40Bytes, _wl_block40);
		if( operation_mode.equals("ModifyAddendum") )
		{
			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block44Bytes, _wl_block44);

		}else if( operation_mode.equals("Update") || operation_mode.equals("ModifySection")){
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);
		}
		else
		{
			
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);

		}
		
            _bw.write(_wl_block49Bytes, _wl_block49);
 
		//101,starts
		if( operation_mode.equals("ModifyAddendum") || operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals(""))
		{
		
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

		}		
		else
		{
		
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

		}//101,ends	
		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(oledb_con_string));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(isModifyDescYN));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block59Bytes, _wl_block59);

}
catch(Exception e)
{
	e.printStackTrace();	
}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(auto_save_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(auto_save_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecordClinicalNotesToolbar.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickForRecAndSign.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClickForRecAndSign.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
