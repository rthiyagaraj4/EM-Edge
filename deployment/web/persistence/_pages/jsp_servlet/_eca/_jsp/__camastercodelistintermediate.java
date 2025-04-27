package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __camastercodelistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMasterCodeListIntermediate.jsp", 1732262154940L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\"></script>\n\t\t\n\t\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<script src=\'../../eCA/js/repResetRunList.js\' language=\'javascript\'></script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\tasync function toOpenShowModal(){\n\t var chkVal = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tif (chkVal==\"Fr_Practitioner\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",getLabel(\'Common.practitioner.label\',\'common\'),parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value = arr[0];\t\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"To_Practitioner\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",getLabel(\'Common.practitioner.label\',\'common\'),parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\tif (chkVal==\"From_code\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repNoteType.p_fr_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_fr_note_type.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_fr_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"To_code\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repNoteType.p_to_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_to_note_type1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_to_note_type.value = arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_to_note_type1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteType.p_to_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\nif (chkVal==\"From_Resp\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"Responsibility\",parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value= arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\nelse if (chkVal==\"To_resp\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"Responsibility\",parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value = arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\n\t}\n\ttoOpenShowModal();\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\nif (chkVal==\"From_NoteTypeService\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value= arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\nelse if (chkVal==\"To_NoteTypeService\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value = arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\n\t}\n\ttoOpenShowModal();\n\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\nif (chkVal==\"From_codesection\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",getLabel(\"Common.Section.label\",\"Common\"),parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value= arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\nelse if (chkVal==\"To_codesection\")\n{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\",getLabel(\"Common.Section.label\",\"Common\"),parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value = arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value = \"\";\n\t\t\t\t\tparent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value = \"\";\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n}\n\t}\n\ttoOpenShowModal();\n\t</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\tif (chkVal==\"From_SecNoteType\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"To_SecNoteType\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",getLabel(\"Common.NoteType.label\",\"Common\"),parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\tif (chkVal==\"From_subSection\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\",getLabel(\"Common.Section.label\",\"Common\"),parent.f_query_add_mod.document.repSubSection.p_fr_header_code1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repSubSection.p_fr_header_code.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repSubSection.p_fr_header_code.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"To_subSection\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\",getLabel(\"Common.Section.label\",\"Common\"),parent.f_query_add_mod.document.repSubSection.p_to_header_code1);\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\tif(retArray != null && retArray !=\"\")\t\n\t\t{\n\t\tparent.f_query_add_mod.document.repSubSection.p_to_header_code1.value = arr[1];\n\t\tparent.f_query_add_mod.document.repSubSection.p_to_header_code.value= arr[0];\t\n\t\tparent.messageFrame.location.href =\'../../eCommon/jsp/MstCodeError.jsp\';\t\n\t\t}\n\t\telse\n\t\t{\n\t\tparent.f_query_add_mod.document.repSubSection.p_to_header_code1.value = \'\';\n\t\tparent.f_query_add_mod.document.repSubSection.p_to_header_code.value= \'\';\t\t\n\t\tparent.messageFrame.location.href =\'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\tif (chkVal==\"From_TextBlockCode\")\n\t{\n\t\tretArray = await callFunctionTextBlock(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\",\"Text Block\",parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1)\t\t\t\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\t\n\t\tif((retArray[0] != null && retArray[0] !=\"\" ))\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value = arr[0];\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value= \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"To_TextBlockCode\")\n\t{\n\t\tretArray = await callFunctionTextBlock(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"Text Block\",parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\n\t\t\t\tif(retArray[0] != null && retArray[0] !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value= arr[0];\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value= \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\tif (chkVal==\"PractUnsignednote\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",getLabel(\'Common.practitioner.label\',\'COMMON\'),parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value = arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"NoteTypeUnsignednote\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",\"Note Type\",parent.f_query_add_mod.document.repUnsignedNote.p_note_type1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value= arr[1];\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_note_type.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.repUnsignedNote.p_note_type.value= \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\tif (chkVal==\"fmpractnotetypelist\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",getLabel(\'Common.practitioner.label\',\'COMMON\'),parent.f_query_rep.document.practNoteTypeReports.fm_pract1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_pract1.value = arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_pract.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_pract1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_pract.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"topractnotetypelist\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",\"Note Type\",parent.f_query_rep.document.practNoteTypeReports.to_pract1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_pract1.value= arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_pract.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_pract1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_pract.value = \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"fmnotetypelist\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\",\"Note Type\",parent.f_query_rep.document.practNoteTypeReports.fm_noteType1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value= arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_noteType.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.fm_noteType.value= \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"tonotetypelist\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\",\"Note Type\",parent.f_query_rep.document.practNoteTypeReports.to_noteType1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_noteType1.value= arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_noteType.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_noteType1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practNoteTypeReports.to_noteType.value= \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\tif (chkVal==\"fmpractLoctypeRep\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\",getLabel(\'Common.practitioner.label\',\'COMMON\'),parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value = arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value = arr[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"topractLoctypeRep\")\n\t{\n\t\tretArray = await callFunction(\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",getLabel(\'Common.practitioner.label\',\'COMMON\'),parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1)\n\t\tvar str =unescape(retArray);\n\t\tvar arr = str.split(\",\");\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value= arr[1];\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value= arr[0];\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value = \'\';\n\t\t\t\t\tparent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value= \'\';\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t}\n\ttoOpenShowModal();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String selFunVal="";
	String Page="";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String p_facility_id="";
	String sql = "";
	int count =0;
	Page = request.getParameter("PageName")==null ? "" : request.getParameter("PageName");
	try
	{		
	con = ConnectionManager.getConnection(request);	
	if(Page.equals("repLocnForPract")){
	
			
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("practitioner_id") == null ? "" : request.getParameter("practitioner_id");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");			
			//sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and  upper(practitioner_name) like upper(?) order by 2";//common-icn-0180
			sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id =? and  upper(practitioner_name) like upper(?) order by 2";//common-icn-0180

			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,p_facility_id);//common-icn-0180
			ps.setString(2,description);//common-icn-0180
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("Fr_Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value='"+rs.getString(1)+"' ");

					}
				}
				else if (selFunVal.equals("To_Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value='"+rs.getString(2)+"' ");						
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value='"+rs.getString(1)+"' ");

					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and  upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2  ";
				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block12Bytes, _wl_block12);

		 }	
	}
	//...............Location for Practitioner-ends 

	//.............repNoteType-start
	else if(Page.equals("repNoteType"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select note_type code, note_type_desc description from ca_note_type where  upper(note_type_desc) like upper(?) order by 2";				
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_code"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteType.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_code"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteType.p_to_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteType.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2 ";				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block15Bytes, _wl_block15);

		 }		
	}
	//.............repNoteType-start


	//.............repNoteTypeForResp-start
	else if(Page.equals("repNoteTypeForResp"))
	{		
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql=" Select resp_id code,resp_name description from sm_resp where upper(resp_name) like upper(?) order by 2 ";
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_Resp"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_resp"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql=" Select resp_id code,resp_name description from sm_resp where upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by 2 ";
				

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block18Bytes, _wl_block18);

		 }	
	}
	//.............repNoteTypeForResp--end
	
	//.............NoteTypeByService-start
	else if(Page.equals("repNoteTypeByService"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' order by 2 ";
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_NoteTypeService"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_NoteTypeService"))
				{
					while(rs.next())
					{	
					 out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value='"+rs.getString(2)+"' ");
					 out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' order by 2 ";
				

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block21Bytes, _wl_block21);

		 }		
	}
	//.............NoteTypeByService--end

//.................repSection---start
	else if(Page.equals("repSection"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_desc) like upper(?)";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}				
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_codesection"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_codesection"))
				{
					while(rs.next())
					{	
					 out.println("parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value='"+rs.getString(2)+"' ");
					 out.println("parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)";		
				

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block24Bytes, _wl_block24);

		 }		
	}
	//.............reportSection--end


	//.............repSectionForNoteType-start
	else if(Page.equals("repSectionForNoteType"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?) order by 2";			
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_SecNoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_SecNoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block27Bytes, _wl_block27);

		 }	
	
	}
	//.............repSectionForNoteType-end

	//.............repSubSection-start
	else if(Page.equals("repsubSection"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_desc) like upper(?) ";		
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_subSection"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value='"+rs.getString(2)+"'");
   	                    out.println("parent.f_query_add_mod.document.repSubSection.p_fr_header_code.value='"+rs.getString(1)+"'");
					}					
				}				
				else if (selFunVal.equals("To_subSection"))
				{
					while(rs.next())
					{
						out.println("parent.f_query_add_mod.document.repSubSection.p_to_header_code1.value='"+rs.getString(2)+"'");
   	                    out.println("parent.f_query_add_mod.document.repSubSection.p_to_header_code.value='"+rs.getString(1)+"'");
					}
					
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) ";				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block30Bytes, _wl_block30);

		 }	
	
	}
	//.............repSubSection-end


	//.............repTextBlock-start
	else if(Page.equals("repTextBlock"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) order by 2";	
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("From_TextBlockCode"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value='"+rs.getString(1)+"'");	out.println("parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value='"+rs.getString(1)+"'");
						
					}
				}
				else if (selFunVal.equals("To_TextBlockCode"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value='"+rs.getString(1)+"' ");
						out.println("parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) and upper(text_blk) like upper(?) order by 2";				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block33Bytes, _wl_block33);

		 }	
	
	}
	//.............repTextBlock-end


	//.............RepUnsignedNote-start
	else if(Page.equals("repUnsignedNote"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			
			if(selFunVal.equals("PractUnsignednote"))
				{			
					//sql=" select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"'  and upper(practitioner_name) like upper(?) order by 2 ";	//common-icn-0180				
					sql=" select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id =?  and upper(practitioner_name) like upper(?) order by 2 ";//common-icn-0180						
					
				}
				else if(selFunVal.equals("NoteTypeUnsignednote"))
				{					
					sql=" select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?) order by 2 ";					
				}
			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180	 starts
			if(selFunVal.equals("PractUnsignednote")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			if(selFunVal.equals("NoteTypeUnsignednote")){
			ps.setString(1,description);
			}
			//common-icn-0180 end
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("PractUnsignednote"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("NoteTypeUnsignednote"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("PractUnsignednote"))
				{					
					sql=" select distinct b.practitioner_id code, b.practitioner_name description  from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"'  and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2 ";	
				}
				else if(selFunVal.equals("NoteTypeUnsignednote"))
				{
					sql=" select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2 ";
				}		
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block36Bytes, _wl_block36);

		 }		
	}
	//.............RepUnsignedNote-end

//.............ReportspractNoteTypeList-start
	else if(Page.equals("ReportspractNoteTypeList"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");			
			if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist"))
			{
					//sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_name) like upper(?)";//common-icn-0180				
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id=? and upper(b.practitioner_name) like upper(?)";	//common-icn-0180				

			}
			else if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist"))
			{					
					sql ="select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?)";
			}
			
			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180 starts
			if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist")){
			ps.setString(1,description);
			}
			//common-icn-0180 end
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("fmpractnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_pract1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_pract.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("topractnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_pract1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_pract.value='"+rs.getString(1)+"' ");
					}
				}
				
				else if (selFunVal.equals("fmnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_noteType.value='"+rs.getString(1)+"' ");
					}
				}				
				else if (selFunVal.equals("tonotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_noteType1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_noteType.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist"))
				{								
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";
				}
				else if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist"))
				{
					sql ="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?)";
				}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block41Bytes, _wl_block41);

		 }		
	}
	//.............ReportspractNoteTypeList-end

	//.............RepPractLocationList-start
	else if(Page.equals("ReportPractLocationType"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			
			if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep"))
			{			
				//sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_name) like upper(?)"; //common-icn-0180									
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id=? and upper(b.practitioner_name) like upper(?)"; //common-icn-0180								
				
			}			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180 starts
			if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			//common-icn-0180 ends
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("fmpractLoctypeRep"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("topractLoctypeRep"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep"))
				{					
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";	
				}
				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block44Bytes, _wl_block44);

		 }
		}
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Report-PractLocationList "+ee.toString());//common-icn-0181
		  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
	
	//.............RepPractLocationList-end


            _bw.write(_wl_block45Bytes, _wl_block45);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
