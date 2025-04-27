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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessecroutine extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSecRoutine.jsp", 1738144232628L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html><head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<!-- <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>  -->\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n<script language=\'javascript\'>\nvar frame = \"\";\nif(top.document.getElementById(\"dialog-body\"))\n{\n\tframe = top.document.getElementById(\"dialog-body\").contentWindow;\n}\nelse\n\tframe = top;\nfunction getMessageFrame()\n{\n\tif(top.content!=null && !top.document.getElementById(\'dialog-body\'))\n\t\t\t \n\t\treturn top.content.messageFrame;\n\telse\n\t\treturn frame.messageframe;\t\n}\nvar messageFrameReference = getMessageFrame();\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t//alert(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\n\t\t\t\t\t\n\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].sel_note_type.value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].transcription_yn.value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].doc_linked_note_yn.value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value\t\t= \t\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.perf_pract_name_ql.value ;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = false;\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.disabled=false;\n\t\t\t\t\t\t\t\n\t\t\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performing_phy_name.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.perf_pract_name_ql.value ;\n\t\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = false;\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].performed_by_phy_name.disabled = false;\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].search_btn.disabled = true;\t\n\t\t\t\t\n\t\t\t\t\t//alert(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.value\t\t= \t\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value = \t\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.disabled=true;\n\t\t\t\t\t\t\n\t\t\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performing_phy_name.value = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t//alert(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\t\t\t\t\n\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_group.value = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_group.disabled = true;\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\tvar msg = getMessage(\'DIS_ADV_NOT_EXISTS\',\'CA\');\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.focus();\n\t\t\t\t\t\t\tmessageFrameReference.location.href = \'../../eCA/jsp/CAError.jsp?err_num=\'+msg;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\tvar msg = getMessage(\'DECEASED_ONLY\',\'CA\');\n\t\t\t\t\t\t//var msg = \"APP-CA00120 This Note is applicable only for deceased patients.\";\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.focus();\n\t\t\t\t\t\tmessageFrameReference.location.href = \'../../eCA/jsp/CAError.jsp?err_num=\'+msg;\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\talert(getMessage(\"MAX_NOTES_LIMIT\",\"CA\"));\n\t\t\t\t\t\t\t\t//alert(\"APP-CA00101 Allowed number of records per encounter reached the limit...You cannot create a new note ...\");\n\t\t\t\t\t\t\t\tvar query_string = frame.content.workAreaFrame.RecClinicalNotesTabsFrame.document.RecClinicalNotesTabForm.query_string.value;\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.location.href = \'../../eCA/jsp/RecClinicalNotesMain.jsp?\'+query_string;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t=\"\";\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t/*alert(\'1223....\'+frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_name_ql.value);\n\t\t\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_name_ql.value;*/\n\n\t\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;\n\t\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;\n\n\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= \"\";\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value\t\t\t\t\t= \"\";\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t=\"\";\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t \tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;\n\t\t\t\t\t\t\t\t \tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value\t\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value;\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.value\t\t\t\t\t= frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.defa_speciality_code.value;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_class.value\t\t\t\t\t\t= \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_facl_spec_yn.value\t\t\t= \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\t\t\t\t\t\t\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.privilege_type.value\t\t\t\t\t= \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\t\t\t\t\t\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_type_caption.value\t\t\t= \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type_security_level.value\t= \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_caption.value\t\t\t= \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_perf_by_caption.value\t\t= \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_caption.value\t\t\t= \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_status_caption.value\t\t= \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_auth_by_caption.value\t\t= \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById(\"td_note_type\").innerText\t\t\t= \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById(\"td_event_date_time\").innerText= \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById(\"td_performed_by_id\").innerText= \'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.getElementById(\"td_event_title_desc\").innerText= \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.enable_cannedtext.value\t\t\t= \'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\';\n\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.doc_linked_note_yn.value\t\t\t= \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time.value;\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value\t\t\t\t= \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time.value\t\t\t\t\t= \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t// new \n\n\t\t\t\t\t\tvar event_title_desc =\"\" ;\n\t\t\t\t\t\tvar note_status =\"\";\n\t\t\t\t\t\tvar performed_by_pract =\"\";\n\t\t\t\t\t\tvar performed_date =\"\";\n\t\t\t\t\t\tvar attending_practitioner =\"\";\n\t\t\t\t\t\tvar speciality_name =\"\";\n\t\t\t\t\t\tvar Sex =\"\";\n\t\t\t\t\t\tvar visit_adm_date =\"\";\n\t\t\t\t\t\tvar med_service =\"\";\n\t\t\t\t\t\tvar accession_num =\"\";\n\t\t\t\t\t\tvar location_code =\"\";\n\n\t\t\t\t\t\tevent_title_desc = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_desc.value ;\n\t\t\t\t\t\tperformed_by_pract = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value ;\n\t\t\t\t\t\tperformed_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value ;\n\t\t\t\t\t\tattending_practitioner = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.attending_practitioner.value ;\n\t\t\t\t\t\tservice_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value ;\n\t\t\t\t\t\tspeciality_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_name.value ;\n\t\t\t\t\t\tSex = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value ;\n\t\t\t\t\t\tvisit_adm_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date.value ;\n\t\t\t\t\t\tdischarge_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.discharge_date.value ;\n\t\t\t\t\t\tmed_service = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value ;\n\t\t\t\t\t\taccession_num = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value ;\n\t\t\t\t\t\tlocation_code = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.location_code.value ;\t\t\t\t\t\t\n\n\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&facility_id=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&encounter_id=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&patient_id=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&patient_class=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&event_title_desc=\'+event_title_desc+\'&note_status=\'+note_status+\'&performed_by_pract=\'+performed_by_pract+\'&performed_date=\'+performed_date+\'&attending_practitioner=\'+attending_practitioner+\'&speciality_name=\'+speciality_name+\'&Sex=\'+Sex+\'&visit_adm_date=\'+visit_adm_date+\'&med_service=\'+med_service+\'&accession_num=\'+accession_num+\'&discharge_date=\'+discharge_date+\'&location_code=\'+location_code;\n\n\t\t\t\t\t\t// new \n\t\t\t\t//\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&doc_linked_note_yn=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\';\n\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" == \"Y\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif (frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0])\n\t\t\t\t\t\t{\t\t\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,true);\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t}else{\t\t\t\t\t\n\t\t\t\t\t\tif (frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0])\n\t\t\t\t\t\t{\t\t\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,false);\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&event_title_desc=\'+event_title_desc+\'&note_status=\'+note_status+\'&performed_by_pract=\'+performed_by_pract+\'&performed_date=\'+performed_date+\'&attending_practitioner=\'+attending_practitioner+\'&speciality_name=\'+speciality_name+\'&Sex=\'+Sex+\'&visit_adm_date=\'+visit_adm_date+\'&med_service=\'+med_service+\'&accession_num=\'+accession_num+\'&discharge_date=\'+discharge_date+\'&location_code=\'+location_code; // commented for IN046648\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&event_title_desc=\'+event_title_desc+\'&note_status=\'+note_status+\'&performed_by_pract=\'+performed_by_pract+\'&performed_date=\'+performed_date+\'&attending_practitioner=\'+attending_practitioner+\'&speciality_name=\'+encodeURIComponent(speciality_name,\"UTF-8\")+\'&Sex=\'+Sex+\'&visit_adm_date=\'+visit_adm_date+\'&med_service=\'+med_service+\'&accession_num=\'+accession_num+\'&discharge_date=\'+discharge_date+\'&location_code=\'+location_code; // modified for IN046648\n\t\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.frameSetIdSection.cols=\"100%,0%,0%\";\n\n\t\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUpload.jsp?note_type=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&appl_task_id=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\';\n\t\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\';\n\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="&called_from=NOTES_HEADER\';\n\n\t\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?note_type=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&called_from=NOTES_HEADER\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar event_title_desc =\"\" ;\n\t\t\t\t\t\tvar note_status =\"\";\n\t\t\t\t\t\tvar performed_by_pract =\"\";\n\t\t\t\t\t\tvar performed_date =\"\";\n\t\t\t\t\t\tvar attending_practitioner =\"\";\n\t\t\t\t\t\tvar speciality_name =\"\";\n\t\t\t\t\t\tvar Sex =\"\";\n\t\t\t\t\t\tvar visit_adm_date =\"\";\n\t\t\t\t\t\tvar med_service =\"\";\n\t\t\t\t\t\tvar accession_num =\"\";\n\t\t\t\t\t\tvar location_code =\"\";\n\n\t\t\t\t\t\tevent_title_desc = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_title_desc.value ;\n\t\t\t\t\t\tperformed_by_pract = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_phy_name.value ;\n\t\t\t\t\t\tperformed_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.value ;\n\t\t\t\t\t\tattending_practitioner = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.attending_practitioner.value ;\n\t\t\t\t\t\tservice_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_name.value ;\n\t\t\t\t\t\tspeciality_name = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_name.value ;\n\t\t\t\t\t\tSex = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value ;\n\t\t\t\t\t\tvisit_adm_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date.value ;\n\t\t\t\t\t\tdischarge_date = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.discharge_date.value ;\n\t\t\t\t\t\t\n\t\t\t\t\t\tmed_service = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp.value ;\n\t\t\t\t\t\t\n\t\t\t\t\t\taccession_num = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value ;\n\t\t\t\t\t\tlocation_code = frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.location_code.value ;\n\t\t\t\t\t\n\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\t\t\tif (\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" == \"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,true);\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].fileupload_btn,false);\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="&event_title_desc=\'+event_title_desc+\'&note_status=\'+note_status+\'&performed_by_pract=\'+performed_by_pract+\'&performed_date=\'+performed_date+\'&attending_practitioner=\'+attending_practitioner+\'&speciality_name=\'+speciality_name+\'&Sex=\'+Sex+\'&visit_adm_date=\'+visit_adm_date+\'&med_service=\'+med_service+\'&accession_num=\'+accession_num+\'&discharge_date=\'+discharge_date+\'&location_code=\'+location_code; // commented for IN046648\n\t\t\t\t\t\tframe.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSection.jsp?note_type=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&event_title_desc=\'+event_title_desc+\'&note_status=\'+note_status+\'&performed_by_pract=\'+performed_by_pract+\'&performed_date=\'+performed_date+\'&attending_practitioner=\'+attending_practitioner+\'&speciality_name=\'+encodeURIComponent(speciality_name,\"UTF-8\")+\'&Sex=\'+Sex+\'&visit_adm_date=\'+visit_adm_date+\'&med_service=\'+med_service+\'&accession_num=\'+accession_num+\'&discharge_date=\'+discharge_date+\'&location_code=\'+location_code; // modified for IN046648\n\t\t\t\t\t\t//frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href = \'../../eCA/jsp/RecClinicalNotesToolbar.jsp?note_type=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\';\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" == \"Y\")\n\t\t\t\t{\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].req_transcription,true);\n\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].req_transcription,false);\n\t\t\t\t}\n\t\t\t\t<!-- IN052940 Start.  -->\t\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" != \"\" && \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"==\"Y\")\n\t\t\t\t{\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,true);\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Notes,false);\n\t\t\t\t}\n\t\t\t\t<!-- IN052940 End.  -->\t\n\t\t\t\t<!-- IN063931 starts  -->\t\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"==\"Y\")\n\t\t\t\t{\t\t\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,true);\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tsetToolBarButtons(frame.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.forms[0].Previous_Section,false);\n\t\t\t\t}\n\t\t\t\t<!-- IN063931 starts  -->\t\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</head><body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'MESSAGE\'></body></html>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
?           	100			?	         	?				?			created

07/02/2014	IN046648		Karthi 		07/02/2014		Ramesh			Specialty name is not displayed completely if the specialty name contains any special characters	
03/07/2015	IN052940		Ramesh G									In Clinical note there should be an option to auto fetch/Copy data from same template 
																		if filled up earlier for same patient in template format.
24/01/2018	IN063931		Prakash C	25/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)																						
------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session); //IN063931

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con			=	null;

	PreparedStatement	pstmt		=	null;
	PreparedStatement   pstmtcnt	=	null;
	
	ResultSet			rs			= null;
	ResultSet			rscnt		= null;

	String		query_section_details	=	"",	note_type					=	"";
	String		resp_id					=	"",	encounter_id				=	"";	
	String		patient_id				=	"",	clinician_id				=	"";
	String		clinician_name			=	"",	facility_id					=	"";
	String		event_class				=	"",	serv_facl_spec_yn			=	"";
	String		privilege_type			=	"",	note_type_desc				=	"";
	String		event_type_caption		=	"",	note_type_security_level	=	"";
	String		event_date_caption		=	"",	event_perf_by_caption		=	"";
	String		event_title_caption		=	"",	event_title_desc			=	"";
	String		event_auth_by_caption	=	"",	event_status_caption		=	"";
	String		service_code			=	"";
	String		login_user_id			=	"",	query_canned_text			=	"";
	String		sys_date_time			=	"", med_splty_grp_code			=	"";
	String		note_group_id			=	"",	no_of_rec_per_enc			=	"";
	String		role_based_access_yn	=	"",	pre_cond_for_rec 			=	"";
	String		patient_class			=	"", appl_task_id				=	"";
	String		doc_linked_note_yn		=	"";
	String		def_service_code		=	"";
	String		location_code		=	"";
	String		ql_flag		=	"";
	String		medanc_serv_ql		=	"";
	String		performed_by_ql		=	"";
	String		dflt_transcription_yn		=	"";
	String 		ca_disp_copy_prev_notes_yn = "";  //IN052940
	String 		ca_disp_copy_prev_section_yn = "N";  //IN063931
	

	boolean	enable_cannedtext			=	false,	error_flag				=	false;
	boolean	search_screen_activated		=	false;

	int sec_count = 0;

	try
	{
		con					=	ConnectionManager.getConnection(request);

		facility_id			=	(String)		session.getValue("facility_id");
		login_user_id		=	(String)		session.getValue("login_user");
		resp_id				=	(String)		session.getValue("responsibility_id");
		clinician_id		=	(String)		session.getValue("ca_practitioner_id");
		clinician_name		=	checkForNull((String)		session.getValue("practitioner_name"));
		clinician_name		=	clinician_name.replace('\'',' ');
		note_type			=	checkForNull( request.getParameter("note_type") );
		patient_id			=	checkForNull( request.getParameter("patient_id") );
		encounter_id		=	checkForNull( request.getParameter("encounter_id") );
		patient_class		=	checkForNull( request.getParameter("patient_class") );
		appl_task_id		=	checkForNull( request.getParameter("appl_task_id") );
		def_service_code	=	checkForNull( request.getParameter("defa_speciality_code") );
		location_code	=	checkForNull( request.getParameter("location_code") );
		medanc_serv_ql	=	checkForNull( request.getParameter("medanc_serv_ql") );
		performed_by_ql	=	checkForNull( request.getParameter("performed_by_ql") );
		ql_flag	=	checkForNull( request.getParameter("ql_flag") );
		

		try
		{
			String countQuerySec = "select count(*) count  from ca_note_section  where note_type = ? ";
			pstmtcnt = con.prepareStatement(countQuerySec);
			pstmtcnt.setString(1,note_type);

			rscnt = pstmtcnt.executeQuery();
			
			while(rscnt.next())
			{
				sec_count = rscnt.getInt("count");
			}
			
		}
		catch (Exception eee)
		{
			eee.printStackTrace() ;			
		}
		finally
		{
			if (rscnt != null) rscnt.close();
			if (pstmtcnt != null) pstmtcnt.close();
		}

		
		try
		{
			//query_section_details = " select event_class, serv_facl_spec_yn, privilege_type, note_type_desc, event_type_caption, note_type_security_level, event_date_caption, event_perf_by_caption, event_title_caption, event_auth_by_caption, event_status_caption, note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,DOC_LINKED_NOTE_YN from ca_note_type_for_resp_view where resp_id = ? and note_type = ? ";
			// IN052940 Start.
			//query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn from 	CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";
			//query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn, /*ca_disp_copy_prev_notes_yn(A.note_type)*/ (select  (select copy_prev_notes_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_notes_yn from CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";//commented by prakash IN063931
			//IN052940  End.
			query_section_details = "select b.event_class, b.serv_facl_spec_yn, A.privilege_type, b.note_type_desc, b.event_type_caption, b.security_level, b.event_date_caption, b.event_perf_by_caption, b.event_title_caption, b.event_auth_by_caption, b.event_status_caption, b.note_group_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time,b.DOC_LINKED_NOTE_YN,(select a.TRANSCRIPTION_YN from CA_NOTE_GROUP a where a.NOTE_GROUP =b.NOTE_GROUP_ID ) dflt_transcription_yn, (select  (select copy_prev_notes_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_notes_yn,(select  (select copy_prev_section_yn  from ca_appl_task where appl_task_id = (select appl_task_id from ca_note_group where note_group=a.note_group_id)) from ca_note_type a where note_type=b.note_type) ca_disp_copy_prev_section_yn from CA_NOTE_TYPE_FOR_RESP a,CA_NOTE_TYPE_lang_vw b ,SM_RESP C where C.resp_id = ? and A.note_type = ? and b.language_id = ? and	c.RESP_ID=A.RESP_ID	and	b.NOTE_TYPE=A.NOTE_TYPE	and	b.EFF_STATUS='E'";// IN063931
			pstmt		=	con.prepareStatement(query_section_details);
			
			pstmt.setString(1, resp_id);
			pstmt.setString(2, note_type);
			pstmt.setString(3, locale);
			rs	=	pstmt.executeQuery();

			if(rs.next())
			{
				event_class					=	checkForNull( rs.getString("event_class") );
				serv_facl_spec_yn			=	checkForNull( rs.getString("serv_facl_spec_yn") );
				privilege_type				=	checkForNull( rs.getString("privilege_type") );
				note_type_desc				=	checkForNull( rs.getString("note_type_desc") );
				event_type_caption			=	checkForNull( rs.getString("event_type_caption") );
				note_type_security_level	=	checkForNull( rs.getString("security_level") );
				event_date_caption			=	checkForNull( rs.getString("event_date_caption") );
				event_perf_by_caption		=	checkForNull( rs.getString("event_perf_by_caption") );
				event_title_caption			=	checkForNull( rs.getString("event_title_caption") );
				event_title_desc			=	checkForNull( rs.getString("event_title_caption") );
				event_auth_by_caption		=	checkForNull( rs.getString("event_auth_by_caption") );
				event_status_caption		=	checkForNull( rs.getString("event_status_caption") );
				note_group_id				=	checkForNull( rs.getString("note_group_id") );
				sys_date_time				=	checkForNull( rs.getString("sys_date_time") );
				doc_linked_note_yn			=	checkForNull( rs.getString("DOC_LINKED_NOTE_YN") );
				dflt_transcription_yn		=	checkForNull( rs.getString("dflt_transcription_yn") );
				ca_disp_copy_prev_notes_yn  =	checkForNull( rs.getString("ca_disp_copy_prev_notes_yn") ); //IN052940
				ca_disp_copy_prev_section_yn  =	checkForNull( rs.getString("ca_disp_copy_prev_section_yn") ); //IN063931
				sectionBean.setCopyPrevSectionYN(ca_disp_copy_prev_section_yn);//IN063931
				//sys_date_time				=	com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHM","en",locale);
				sys_date_time				=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dflt_transcription_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);

					
				if(privilege_type.equals("1"))
				{
					if(ql_flag.equals("Y"))
						{
							
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(performed_by_ql));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						else
						{
					
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
				} // end of if(privilege_type.equals("1"))
				else
				{
					
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clinician_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinician_name));
            _bw.write(_wl_block20Bytes, _wl_block20);

					

				
				} // end of else
				
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(note_group_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

				String query_note_group_props = "select NO_OF_REC_PER_ENC,ROLE_BASED_ACCESS_YN,PRE_COND_FOR_REC from ca_note_group where NOTE_GROUP=?";

				pstmt = con.prepareStatement(query_note_group_props);
				pstmt.setString(1, note_group_id);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					no_of_rec_per_enc		= checkForNull(rs.getString("NO_OF_REC_PER_ENC")); 
					role_based_access_yn	= checkForNull(rs.getString("ROLE_BASED_ACCESS_YN")); 
					role_based_access_yn=role_based_access_yn;
					pre_cond_for_rec			= checkForNull(rs.getString("PRE_COND_FOR_REC")); 
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
				if(pre_cond_for_rec.equals("D"))
				{
					if(patient_class.equals("IP") || patient_class.equals("DC"))
					{
						String query_ip_dis_advice =	 "select 1 from ip_discharge_advice where facility_id =? and  encounter_id=? and DIS_ADV_STATUS in ('0','1')";
						pstmt = con.prepareStatement(query_ip_dis_advice);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, encounter_id);
						rs = pstmt.executeQuery();						
						if(!rs.next())
						{
							error_flag = true;
							
            _bw.write(_wl_block24Bytes, _wl_block24);
}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}
				}
				else if(pre_cond_for_rec.equals("E"))
				{
					
					String install_yn = "";
					String query_install_yn = "SELECT  INSTALL_YN     FROM SM_MODULE  WHERE MODULE_ID='AE'";
					pstmt = con.prepareStatement(query_install_yn);
					rs = pstmt.executeQuery();
					if(rs.next())
						install_yn = checkForNull(rs.getString("INSTALL_YN"));						
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					String query_chk_deceased = "";
					if(install_yn.equals("Y"))
						query_chk_deceased = "SELECT 1 FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID=?";
					else
						query_chk_deceased = "select DECEASED_YN from mp_patient where patient_id=? and DECEASED_YN='Y'";

					pstmt = con.prepareStatement(query_chk_deceased);
					pstmt.setString(1, patient_id);
					rs = pstmt.executeQuery();
					
					if(!rs.next())
					{
						error_flag = true;
						
            _bw.write(_wl_block25Bytes, _wl_block25);
}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}

				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(!error_flag)
				{
					if(!no_of_rec_per_enc.equals(""))
					{
						try
						{
							String query = "select count(*) from ca_encntr_note where encounter_id = ? and facility_id=? and note_type = ? and event_status in ('1','2','3','4','5') ";
							pstmt = con.prepareStatement(query);
							pstmt.setString(1, encounter_id);
							pstmt.setString(2, facility_id);
							pstmt.setString(3, note_type);
							rs = pstmt.executeQuery();
							rs.next();
							if(rs.getInt(1) >=  Integer.parseInt(no_of_rec_per_enc))
							{
								search_screen_activated = true;
								
            _bw.write(_wl_block26Bytes, _wl_block26);
}
			
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();							
						}
						catch(Exception e)
						{
							e.printStackTrace();
							//out.println("Exception at Point 4.12-->" + e.getMessage());//COMMON-ICN-0181
						}
					}
					if(!search_screen_activated)
					{
						query_section_details = " SELECT service_code med_splty_grp_code FROM pr_encounter WHERE encounter_id = ? and facility_id= ? ";
						pstmt		=	con.prepareStatement(query_section_details);
						pstmt.setString	(	1,	encounter_id	);
						pstmt.setString	(	2,	facility_id	);
						rs	=	pstmt.executeQuery();
						if(rs.next())
						{
							med_splty_grp_code	=	rs.getString("med_splty_grp_code");
							if(med_splty_grp_code==null) med_splty_grp_code = "";
						}

						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						query_canned_text = "Select 1 from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ?  and rownum=1 ";
						pstmt		=	con.prepareStatement(query_canned_text);
						pstmt.setString(1,med_splty_grp_code);
						pstmt.setString(2,med_splty_grp_code);
						pstmt.setString(3,login_user_id);
						pstmt.setString(4,login_user_id);
						pstmt.setString(5,note_type);
						pstmt.setString(6,note_type);
						rs			=	pstmt.executeQuery();
						
						if(rs.next())
							enable_cannedtext = true;

						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();


						if(serv_facl_spec_yn.equals("Y") )
						{
							query_section_details = "select ca_note_type_by_serv.service_code from ca_note_type_by_serv, AM_FACILITY_SERVICE_VW where ca_note_type_by_serv.facility_id=AM_FACILITY_SERVICE_VW.operating_facility_id and ca_note_type_by_serv.note_type = ?  and ca_note_type_by_serv.service_code=AM_FACILITY_SERVICE_VW.SERVICE_CODE AND ca_note_type_by_serv.SERVICE_CODE = ?";

							pstmt		=	con.prepareStatement(query_section_details);
							
							pstmt.setString(1, note_type);
							pstmt.setString(2, def_service_code);
							rs	=	pstmt.executeQuery();

							if(rs.next())
								 service_code = rs.getString(1);

							if(service_code == null) service_code ="";

							if(!service_code.equals(""))
							{
								if(ql_flag.equals("Y"))
								{
								if(!service_code.equals(medanc_serv_ql)&&!medanc_serv_ql.equals(""))
									{
								
            _bw.write(_wl_block27Bytes, _wl_block27);


									}
									else
									{
								
            _bw.write(_wl_block28Bytes, _wl_block28);

									}
									
								}
								else
								{
								
            _bw.write(_wl_block29Bytes, _wl_block29);

								}
								

							}
							else
							{
								
            _bw.write(_wl_block30Bytes, _wl_block30);

							}
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();

						}
						else
						{
						
							if(ql_flag.equals("Y"))
							{

								if(!def_service_code.equals(medanc_serv_ql)&&!medanc_serv_ql.equals(""))
								{

							
            _bw.write(_wl_block31Bytes, _wl_block31);
	

								}
								else
								{
							
            _bw.write(_wl_block32Bytes, _wl_block32);

								}

							}
							else
							{	
							
							
            _bw.write(_wl_block33Bytes, _wl_block33);

							}
								
						}


						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(event_type_caption.equals(""))		event_type_caption		=	"Note Type";
						if(event_date_caption.equals(""))		event_date_caption		=	"Date/Time";
						if(event_perf_by_caption.equals(""))	event_perf_by_caption	=	"Performed By";
						if(event_title_caption.equals(""))		event_title_caption		=	"Note Title";
						if(event_status_caption.equals(""))		event_status_caption	=	"Note Status";
						if(event_auth_by_caption.equals(""))	event_auth_by_caption	=	"Authorized By";
						
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(serv_facl_spec_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(privilege_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(event_type_caption));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(note_type_security_level));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(event_date_caption));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(event_perf_by_caption));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(event_title_caption));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(event_status_caption));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(event_auth_by_caption));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(event_type_caption));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(event_date_caption));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(event_perf_by_caption));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(event_title_caption));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(enable_cannedtext));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);

						if(ql_flag.equals("Y"))//sys_date_time
						{
						
            _bw.write(_wl_block51Bytes, _wl_block51);

						}
						else
						{			
						
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block54Bytes, _wl_block54);
	}
						//defaulting the service if the note is connected to only one service
								
						
						if(sec_count > 0 && doc_linked_note_yn.equals("Y"))
						{
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);

						}
						else if(doc_linked_note_yn.equals("Y") && sec_count == 0 )
						{
						
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block72Bytes, _wl_block72);

						}
						else
						{
							
						
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
					
						}
							// included by arul on 8th march 2003 --- end
					}//end of if(!search_screen_activated)
				}// end of if(!error_flag)
				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dflt_transcription_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(ca_disp_copy_prev_notes_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(ca_disp_copy_prev_section_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);

			} // end of if(rs.next())
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		} // end of try
		catch(Exception e)
		{
			//out.println("Exception@4 : "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}	
	}
	catch(Exception e)
	{
		//out.println("Exception@5:"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

            _bw.write(_wl_block84Bytes, _wl_block84);

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
