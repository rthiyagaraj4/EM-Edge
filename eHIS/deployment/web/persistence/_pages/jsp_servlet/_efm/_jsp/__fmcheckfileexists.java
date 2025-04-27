package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmcheckfileexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCheckFileExists.jsp", 1733461796188L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--\n\n\tCreated On\t: 6/15/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request of File\n\t\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRequestFile.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\t\t\t\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar opt=parent.document.frames[0].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.document.frames[0].document.forms[0].volume_no.add(opt);\n\t\t\t\t\t\t\n\t\t\t</script>\n\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!--below line added this CRF PMG2013-MMS-CRF-0005 [IN:045278] -->\n\t\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'==1){\n\t\t\t\tparent.document.frames[0].document.forms[0].count_volumeno.value = 1; // Modified for MMS-QH-CRF-0148\n\t\t\t\tparent.document.frames[0].document.forms[0].volume_no.selectedIndex = 1;\t\t\t\t\n                 if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!=\"\" && parent.document.frames[0].document.forms[0].volume_no.value!=\"\" && parent.document.frames[0].document.forms[0].narration_code.value!=\"\"){\n\t\t\t\t  parent.document.frames[0].document.forms[0].ok_button.disabled = false;\n\t\t\t\t }\n                 if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!=\"\" && parent.document.frames[0].document.forms[0].volume_no.value!=\"\" && parent.document.frames[0].document.forms[0].narration_code.value!=\"\"){\n\t\t\t\t  parent.document.frames[0].document.forms[0].ok_button.disabled = false;\n\t\t\t\t } \t\t\t\t \n\t\t\t\t}else{\n\t\t\t\tparent.document.frames[0].document.forms[0].volume_no.selectedIndex = 0;\n\t\t\t\t}\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'==1){ \n\t\t//\t\tparent.document.frames[0].document.forms[0].count_reason.value = 1; // Modified for MMS-QH-CRF-0148\n\t\t\t     if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!=\"\" &&       parent.document.frames[0].document.forms[0].volume_no.value!=\"\"){ \n                  parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 1;    \t\t\t\t\n\t\t\t\t }             \t\t\t\t\n                  if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!=\"\" && parent.document.frames[0].document.forms[0].volume_no.value!=\"\" && parent.document.frames[0].document.forms[0].narration_code.value!=\"\"){ \n                  parent.document.frames[0].document.forms[0].ok_button.disabled = false;\t\t\t\t \n\t\t\t\t }\n                 if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!=\"\" &&       parent.document.frames[0].document.forms[0].volume_no.value!=\"\" ){ \n\t\t\t\t  parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 1; \n\t\t\t\t \n\t\t\t\t }if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!=\"\" && parent.document.frames[0].document.forms[0].volume_no.value!=\"\" && parent.document.frames[0].document.forms[0].narration_code.value!=\"\"){\t  \n\t\t\t\t  parent.document.frames[0].document.forms[0].ok_button.disabled = false;\n\t\t\t\t }\n                 if((parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value==\"\" &&       parent.document.frames[0].document.forms[0].volume_no.value==\"\") || (parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value==\"\"&& parent.document.frames[0].document.forms[0].volume_no.value==\"\")){\n\t\t\t\t parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 0;\n\t\t\t\t }\t\t\t\t \n\t\t\t\t}else{\n\t\t\t\tparent.document.frames[0].document.forms[0].narration_code.selectedIndex = 0;\n\t\t\t\t} \n\t\t\t\t\n\t\t\t\t</script>\n   <!--End PMG2013-MMS-CRF-0005 [IN:045278]\t-->\n\t   <script>\n\t\t\tparent.document.frames[0].document.forms[0].file_no1.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t//Added for MMS-QH-CRF-0148 -- TO submit the request if it has only single record \n\t\t\tif (parent.document.frames[0].document.forms[0].sitespecific_autofilereq.value == \"true\")\n\t\t\t{\n\t\t\tif(parent.document.frames[0].document.forms[0].count_reason.value == 1 && parent.document.frames[0].document.forms[0].count_filetype.value == 1)\n\t\t\t\t{\n\t\t\t\t\tif (parent.document.frames[0].document.forms[0].volume_no && parent.document.frames[0].document.forms[0].volume_no.length == 2)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.document.frames[0].document.getElementById(\"ok_button\").click();\n\t\t\t\t\t}\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\t\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar errors = getMessage(\'FILE_ALREADY_ENTERED\',\'FM\');\n\t\t\t\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parseInt(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\') > 0 )\n\t\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\t\tvar doc_or_file = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\t\t\t\t\t\tvar volume_no = \"\'\"+\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"+\"\'\"\n\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].invalid_volumes.value=volume_no;\n\n\t\t\t\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tvar temp_counter = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\t\t\t\t\tif(temp_counter < 2)\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\'DOC_ALREADY_REQUESTED\',\'FM\')+\"\\n\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\");\n\t\t\t\t\t\t\t\t\t\t/*var err_msg=getMessage(\'DOC_ALREADY_REQUESTED\',\'FM\')+ \"<br>\";\n\t\t\t\t\t\t\t\t\t\terr_msg=err_msg + \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\t\t\t\talert(err_msg);*/\n\t\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\'FILE_ALREADY_REQUESTED\',\'FM\')+\"\\n\"+\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\n\t\t\t\t\t\t\t\t\t\t/*var err_msg1=getMessage(\'FILE_ALREADY_REQUESTED\',\'FM\');\n\t\t\t\t\t\t\t\t\t\terr_msg1=err_msg1 + \'<br>\' ;//+ \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\t\t\t\t\t\terr_msg1=err_msg1 + \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\t\t\t\talert(err_msg1);*/\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.value=\"\";\n\t\t\t\t\t\t\t\t\t//\tparent.frames[3].document.getElementById(\"patientid1\").onblur();\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.getElementById(\"p_patient_id\").onblur();\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].doc_folder_id.value=\"\";\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].doc_folder_desc.value=\"\";\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' == \'Y\')\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[3].getDocTypeVolumeNo();\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse if(doc_or_file == \'F\')\n\t\t\t\t\t\t\t\t\t{   \n\t\t\t\t\t\t\t\t\t\tparent.frames[3].populateDynamicValues(\"\");\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t<!-- End of Checking -->\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parseInt(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\') == 0 )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif (parent.frames[3].document.forms[0].p_select_values.value.length==0)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_select_values.value = \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_select_values.value = parent.frames[3].document.forms[0].p_select_values.value + \'|\' + \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parseInt(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\') == 0 )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tvar p_old_string = parent.frames[3].document.forms[0].p_select_values.value ;\n\t\t\t\t\t\t\t\t\tvar p_deselect_file_no = parent.frames[3].document.forms[0].p_deselect_files.value;\n\t\t\t\t\t\t\t\t\tvar volume_no = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\t\t\t\tvar file_type = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\t\t\tvar added_volume = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t\t\t\t\tvar file_type_appl_yn = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n                                   \tvar p_select_file_no = \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_select_files.value +\'|\' + \n\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_select_values.value+\'`\'+volume_no;\n\t\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].logged_fcy.value==\'L\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].enter_fcy.disabled=true;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tvar doc_or_file = \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar conc_remarks=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'dummy_form";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'dummy_form";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' method=\'post\' action=\'../../eFM/jsp/DTRequestSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\"+p_select_file_no+\"\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'volume_no\' id=\'volume_no\' type=\'hidden\' value=\"+volume_no+\"><input name=\'file_type\' id=\'file_type\' type=\'hidden\' value=\"+file_type+\"><input name=\'added_volumes\' id=\'added_volumes\' type=\'hidden\' value=\"+escape(added_volume)+\"><input name=\'p_enter_fcy\' id=\'p_enter_fcy\' type=\'hidden\' value=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'conc_remarks\' id=\'conc_remarks\' type=\'hidden\' value=\"+conc_remarks+\"><input name=\'p_req_fs_locn\' id=\'p_req_fs_locn\' type=\'hidden\' value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\"+file_type_appl_yn+\"></form></BODY></HTML>\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'dummy_form\' id=\'dummy_form\' method=\'post\' action=\'../../eFM/jsp/FMRequestSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\"+p_select_file_no+\"\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'volume_no\' id=\'volume_no\' type=\'hidden\' value=\"+volume_no+\"><input name=\'file_type\' id=\'file_type\' type=\'hidden\' value=\"+file_type+\"><input name=\'added_volumes\' id=\'added_volumes\' type=\'hidden\' value=\"+escape(added_volume)+\"><input name=\'p_enter_fcy\' id=\'p_enter_fcy\' type=\'hidden\' value=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\"+file_type_appl_yn+\"><input name=\'fileno_name\' id=\'fileno_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><input name=\'filetype_name\' id=\'filetype_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'><input name=\'file_no_function\' id=\'file_no_function\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><input name=\'file_type_function\' id=\'file_type_function\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><input name=\'frame_name\' id=\'frame_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><input name=\'form_name\' id=\'form_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><input name=\'volumeno_name\' id=\'volumeno_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif(parent.frames[4].document.body)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[4].document.write(HTMLVal);\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tif(parent.frames[4].document.dummy_form";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =")\n\t\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\tparent.frames[4].document.dummy_form";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =".submit();\t\t\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tparent.frames[4].document.dummy_form.submit();\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].FS_LOCN_ID.disabled=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_location.disabled=true;\n\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_file_no.value=\'\';\n\t\t\t\t\t\t\t\t\tif (parent.frames[3].document.forms[0].p_file_no.type != \'hidden\')\n\t\t\t\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_file_no.focus();\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar errors = getMessage(\'REQUEST_EQUALS_CURRENT\',\'FM\');\n\t\t\t\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\t\t\n\t\t\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\n\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\tvar errors = getMessage(\'PATIENT_NOT_EXIST\',\'FM\');\t\t\t\n\t\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\tparent.frames[3].document.forms[0].p_file_no.select();\n\t\t\t\t\t\tif(parent.frames[3].document.forms[0].p_file_no.type != \'hidden\')\n\t\t\t\t\t\t\tparent.frames[3].document.forms[0].p_file_no.focus();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[3].document.forms[0].flag.value=\'\';\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar doc_or_file = \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\';\n\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\tvar errors = getMessage(\'DOC_NOT_EXIST\',\'FM\');\t\n\t\t\t\t\telse\n\t\t\t\t\t\tvar errors = getMessage(\'PATIENT_NOT_EXIST\',\'FM\');\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

	
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	PreparedStatement preStatement	= null;
    ResultSet	resultSet			= null;
	ResultSet rs			= null;
	ResultSet rs1			= null;
	
	int file_volume_count=0; // Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
	
	try
	{
		
		request.setCharacterEncoding("UTF-8");
		stmt = con.createStatement();
		String p_patient_file_no	= "";
		String file_no="";
		p_patient_file_no	= request.getParameter("p_patient_file_no");
		//String p_patient_id	= checkForNull(request.getParameter("p_patient_id"));
	
		String file_type	= request.getParameter("file_type");
		String volume_no	= request.getParameter("volume_no");
		String added_volume	= request.getParameter("added_volume");
		
		//Added for this CRF PMG2013-MMS-CRF-0005 [IN:045278]
		int reasonfor_browing=0;
		String count_reason= checkForNull(request.getParameter("count_reason")); 
		if(!count_reason.equals(""))reasonfor_browing= Integer.parseInt(count_reason);
		
		

		String fileno_name			= checkForNull(request.getParameter("fileno_name"));
		String filetype_name		= checkForNull(request.getParameter("filetype_name"));
		String file_no_function		= checkForNull(request.getParameter("file_no_function"));
		String file_type_function	= checkForNull(request.getParameter("file_type_function"));
		String frame_name			= checkForNull(request.getParameter("frame_name"));
		String form_name			= checkForNull(request.getParameter("form_name"));
		String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
        String patient_id	= checkForNull(request.getParameter("patient_id"));
		String file_type_code= checkForNull(request.getParameter("file_type_code"));
		String flag_status =checkForNull(request.getParameter("flag_status"));
		file_type	= ((file_type == null) || (file_type.equals("null"))) ? "" : file_type;
		volume_no	= ((volume_no == null) || (volume_no.equals("null"))) ? "" : volume_no;
		
		StringBuffer sqlBuffer		=	new StringBuffer();

		String facilityid 		 = (String) session.getValue("facility_id");

		String p_old_string		 = request.getParameter("p_old_string");
		String p_enter_fcy		 = request.getParameter("p_enter_fcy");
		String p_req_fs_locn	 = request.getParameter("p_req_fs_locn");
		String conc_remarks	   ="";	
		if(!flag_status.equals("AUTO_REQ"))
		 {
		conc_remarks= checkForNull(request.getParameter("conc_remarks")).trim();
		  }
		
		String added_values		 = request.getParameter("added_values");
		String file_type_appl_yn = request.getParameter("file_type_appl_yn");
       String file_type_appl_yn1   = request.getParameter("file_type_appl_yn1");
	   String perm_fs_locn_code =request.getParameter("perm_fs_locn_code");
	   String sqlString="";
		String volumeno="";
		
		if (perm_fs_locn_code==null) perm_fs_locn_code = "";
		if (file_type_appl_yn==null) file_type_appl_yn = "N";
		if (file_type_appl_yn1==null) file_type_appl_yn1 ="N";
		if (added_values==null) added_values = "";
		if (added_volume==null) added_volume = "";
		if (p_old_string==null) p_old_string = "";
		if (p_enter_fcy==null) p_enter_fcy = "";
		if (p_req_fs_locn==null) p_req_fs_locn = "";
		if (conc_remarks==null) conc_remarks = "";
			
		// code commnet for 19717

		//added_volume = java.net.URLDecoder.decode(added_volume);	
     	
		//conc_remarks= java.net.URLDecoder.decode(conc_remarks,"UTF-8");	
      
		if(conc_remarks !=null || !conc_remarks.equals("null") || !conc_remarks.equals(""))
		{
		session.setAttribute("conc_remarks",conc_remarks);
			}
		
		String p_new_string		= "";		
		String p_error_message	= "";
		String p_sent_date_time	= "";
		String added_date_time	= "";
		String added_date_time1	= "";
		java.util.Hashtable message;
	
	if(flag_status.equals("AUTO_REQ"))
		{

	if(file_type_appl_yn1.equals("Y"))
			{
	  sqlString = "SELECT DISTINCT volume_no,file_no  FROM fm_curr_locn WHERE facility_id = ?  AND patient_id = ? and file_type_code=?  order by volume_no desc ";
	       preStatement	=	 con.prepareStatement(sqlString);
			preStatement.setString(1, facilityid );
			preStatement.setString(2, patient_id);
			preStatement.setString(3, file_type_code);
					}
			
		if(file_type_appl_yn1.equals("N"))
			{
            sqlString = "SELECT DISTINCT volume_no,file_no  FROM fm_curr_locn WHERE facility_id = ?  AND patient_id = ? and perm_fs_locn_code=?  order by volume_no desc ";
	       preStatement	=	 con.prepareStatement(sqlString);
			preStatement.setString(1, facilityid );
			preStatement.setString(2, patient_id);
			preStatement.setString(3, perm_fs_locn_code);

			}
			resultSet		=	preStatement.executeQuery();
				
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
				
				file_volume_count++; //Added  this CRF PMG2013-MMS-CRF-0005 [IN:045278]
				
				volumeno=resultSet.getString("volume_no");
				file_no  =resultSet.getString("file_no");
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
			} 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(file_volume_count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(reasonfor_browing));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
 }	
		
if(!flag_status.equals("AUTO_REQ"))
		{	
int p_fs_locn_code_cnt	 = 0,p_file_no_found=0;
		int p_count				 = 0;

		boolean p_load_frame	 = true;
		boolean p_fs_locn_equal   = false;

		String doc_or_file = request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");
		String doctype_appl_yn = request.getParameter("doctype_appl_yn")==null?"Y":request.getParameter("doctype_appl_yn");
		String p_separate_file_no = p_patient_file_no;	
		StringTokenizer token1=new StringTokenizer(p_separate_file_no,",");

		int counter = 0;
		while(token1.hasMoreTokens())
		{
			counter ++;
			p_patient_file_no = "";
			p_patient_file_no = token1.nextToken();

			if(p_req_fs_locn==null)p_req_fs_locn="";
			if(p_enter_fcy.equals("null") || p_enter_fcy.equals("")) p_enter_fcy=facilityid ;

			sqlBuffer.append("select count(*) rec_cnt from fm_curr_locn where facility_id='"+p_enter_fcy+"' ");

			if(!p_patient_file_no.equals(""))
				sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
			if(!file_type.equals(""))
				sqlBuffer.append(" and file_type_code ='"+file_type+"' ");
	//		if(!p_patient_id.equals(""))
	//			sqlBuffer.append(" and patient_id ='"+p_patient_id+"' ");

			if(!doc_or_file.equals("D"))
			{
				if (!volume_no.equals(""))
					sqlBuffer.append(" and volume_no = '"+volume_no+"' ");
			}
			rs = stmt.executeQuery(sqlBuffer.toString());
		
			while (rs.next())
			{
				p_count = rs.getInt("rec_cnt");
				
			}			
			if(rs!=null)	rs.close();

			if(p_count > 0)
			{
				
				String chekString = "";
				p_new_string = p_patient_file_no;

				chekString = p_patient_file_no+"$$"+volume_no ;
				if(!added_values.equals(""))
				{
					StringTokenizer token = new StringTokenizer(added_values,"|");
					String chkValue = "";
					while(token.hasMoreTokens())
					{
						chkValue = token.nextToken();
						if (chekString.equals(chkValue))
						{
							p_load_frame = false;
							
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
					}
				}
				if((sqlBuffer != null) && (sqlBuffer.length() > 0))
				{
					sqlBuffer.delete(0,sqlBuffer.length());
				}
				if(p_enter_fcy.equals(facilityid))
				{
					sqlBuffer.append("select count(*) rec_cnt from mr_pat_file_index where facility_id='"+facilityid+"' and fs_locn_code is not null");
					if (!p_patient_file_no.equals(""))
						sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
					if (!file_type.equals(""))
						sqlBuffer.append(" and file_type_code ='"+file_type+"' ");
				}
				else
				{
					sqlBuffer.append("select count(*) rec_cnt from fm_curr_locn where facility_id='"+p_enter_fcy+"' ");
					if (!p_patient_file_no.equals(""))
						sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
					if (!file_type.equals(""))
						sqlBuffer.append(" and file_type_code = '"+file_type+"' ");
					if (!volume_no.equals(""))
						sqlBuffer.append(" and VOLUME_NO = "+volume_no+" ");
				}

				rs = stmt.executeQuery(sqlBuffer.toString());
				
				while (rs.next())
				{
					p_fs_locn_code_cnt = rs.getInt("rec_cnt");
				}
				if(rs!=null)	rs.close();
				if((sqlBuffer != null) && (sqlBuffer.length() > 0))
				{
					sqlBuffer.delete(0,sqlBuffer.length());
				}
				if(p_load_frame==true)
				{
					if (p_fs_locn_code_cnt > 0)
					{
						sqlBuffer.append("select fs_locn_code from mr_pat_file_index where facility_id='"+p_enter_fcy+"' ");
						if (!p_patient_file_no.equals(""))
							sqlBuffer.append(" and file_no='"+p_patient_file_no+"'");
						if (!file_type.equals(""))
							sqlBuffer.append(" and file_type_code ='"+file_type+"'");
					
						rs = stmt.executeQuery(sqlBuffer.toString());
						rs.next();
						if(rs.getString("fs_locn_code").equals(p_req_fs_locn) && 							p_enter_fcy.equals(facilityid))
						{
							p_fs_locn_equal	= true;
						}
						if(rs!=null)	rs.close();
						if((sqlBuffer != null) && (sqlBuffer.length() > 0))
						{
						sqlBuffer.delete(0,sqlBuffer.length());
						}
						if (!p_fs_locn_equal)
						{
	/* Adding for checking for the file whether already requested or in transit 08012003 */

							sqlBuffer.append("SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID='"+p_enter_fcy+"' AND DEST_FACILITY_ID='"+p_enter_fcy+"' AND DEST_FS_LOCN_CODE='"+p_req_fs_locn+"' ");
							if (!p_patient_file_no.equals(""))
								sqlBuffer.append(" AND A.FILE_NO='"+p_patient_file_no+"' ");
							if (!file_type.equals(""))
								sqlBuffer.append(" AND A.FILE_TYPE_CODE='"+file_type+"' ");
							if(!doc_or_file.equals("D"))
							{
								if (!volume_no.equals(""))
									sqlBuffer.append(" AND A.volume_no="+volume_no+" ");
							}				
							rs1 = stmt.executeQuery(sqlBuffer.toString());
					
							if((sqlBuffer != null) && (sqlBuffer.length() > 0))
							{
								sqlBuffer.delete(0,sqlBuffer.length());
							}
							while (rs1.next())
							{
								p_file_no_found++;			
								p_sent_date_time = rs1.getString(1);
							}
							
						if(p_sent_date_time != null)
							{
								p_sent_date_time=DateUtils.convertDate(p_sent_date_time,"DMYHMA","en",localeName);
							}
							else
								p_sent_date_time="";
							if (p_file_no_found ==0)	
							{
								//sqlBuffer.append("SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+p_req_fs_locn+"' AND A.REQ_FACILITY_ID='"+p_enter_fcy+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N'");
								sqlBuffer.append("SELECT" );
								sqlBuffer.append("  fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.REQ_FS_LOCN_CODE,'"+localeName+"',2) ||' (' ||sm_Get_desc.SM_FACILITY_PARAM(a.REQ_FACILITY_ID,'"+localeName+"',1) ||')'" );
								sqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM')" );
								sqlBuffer.append("  , sm_Get_desc.SM_APPL_USER(A.REQ_USER_ID,'"+localeName+"',1) " );
								sqlBuffer.append("FROM" );
								sqlBuffer.append("  FM_REQ_HDR A" );
								sqlBuffer.append("  , FM_REQ_DTL B " );
								sqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
								sqlBuffer.append("  AND A.REQ_FS_LOCN_CODE = '"+p_req_fs_locn+"' " );
							//	sqlBuffer.append("  AND A.REQ_FACILITY_ID = '"+p_enter_fcy+"' " );
								sqlBuffer.append("  AND B.ISS_YN = 'N' " );
								sqlBuffer.append("  AND B.CANCEL_YN = 'N'" );
								if (!p_patient_file_no.equals(""))
									sqlBuffer.append(" AND B.FILE_NO='"+p_patient_file_no+"' ");
								if (!file_type.equals(""))
									sqlBuffer.append(" AND B.FILE_TYPE_CODE='"+file_type+"' ");
								if(!doc_or_file.equals("D"))
								{
									if (!volume_no.equals(""))
										sqlBuffer.append(" AND B.volume_no="+volume_no+" ");
								}
							
														
								rs = stmt.executeQuery(sqlBuffer.toString());
								while (rs.next())
								{
									p_file_no_found++;
									if(doc_or_file.equals("D"))
									{
										p_error_message =" by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
									}
									else
									{
										if(file_type_appl_yn.equals("N"))
									{
										//p_error_message =" File no " + p_patient_file_no + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
										message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
										p_error_message = (String) message.get("message");
										//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");
										p_error_message=p_error_message.replace("$",p_patient_file_no);
										p_error_message=p_error_message.replace("#",rs.getString(1));
									added_date_time=rs.getString(2);
									if(added_date_time != null)
									{
										added_date_time=DateUtils.convertDate(added_date_time,"DMYHMA","en",localeName);
									}
									else
										added_date_time="";	p_error_message=p_error_message.replace("~",added_date_time);
										p_error_message=p_error_message.replace("%",rs.getString(3));
									}
									else
										{
										//p_error_message =" Selected File already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
										//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"SEL_FILE_REQUESTED","fm_messages");

										message = MessageManager.getMessage(localeName,"SEL_FILE_REQUESTED","FM");
										p_error_message = (String) message.get("message");

										p_error_message=p_error_message.replace("$",rs.getString(1));

										added_date_time1=rs.getString(2);
										if(added_date_time1 != null)
										{
											added_date_time1=DateUtils.convertDate(added_date_time1,"DMYHMA","en",localeName);
										}
										else
											added_date_time="";
										p_error_message=p_error_message.replace("#",added_date_time1);
										p_error_message=p_error_message.replace("~",rs.getString(3));
									}
									}
								}
							}
							else
							{					
								if(!doc_or_file.equals("D"))
								{
									if(file_type_appl_yn.equals("N"))
									{
									//p_error_message =" File no " + p_patient_file_no + " is already issued on " + p_sent_date_time ;
									//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

									message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
										p_error_message = (String) message.get("message");

									p_error_message=p_error_message.replace("$",p_patient_file_no);
									p_error_message=p_error_message.replace("#",p_sent_date_time);

									}else
									{
									//p_error_message =" Selected File is already issued on " + p_sent_date_time ;

									//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"SEL_FILE_ISSUED","fm_messages");
									message = MessageManager.getMessage(localeName,"SEL_FILE_ISSUED","FM");
									p_error_message = (String) message.get("message");

								p_error_message=p_error_message.replace("#",p_sent_date_time);
									}
								}
							}
							
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(doctype_appl_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_new_string));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_new_string));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(added_volume));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(p_enter_fcy));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_req_fs_locn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_enter_fcy));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_req_fs_locn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
						}
						else
						{
							
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
					}
					else
					{
						
            _bw.write(_wl_block51Bytes, _wl_block51);
		
					}
				}
			}
			else
			{
				if(!p_patient_file_no.equals("null"))
				{
					
            _bw.write(_wl_block52Bytes, _wl_block52);

				}
			}
			
            _bw.write(_wl_block53Bytes, _wl_block53);

		}
			if(p_count==0)
				{
					
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
	}
		
		if (rs!=null) rs.close();
		if (rs1!=null) rs1.close();
		if (stmt!=null) stmt.close();
	     if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block56Bytes, _wl_block56);
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
