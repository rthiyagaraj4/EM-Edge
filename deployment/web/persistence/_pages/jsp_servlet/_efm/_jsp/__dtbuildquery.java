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

public final class __dtbuildquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTBuildQuery.jsp", 1741319364938L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/15/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Return of File\n-->\n";
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnMRDFile.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar errors = getMessage(\'FILE_RETURN_ALREADY_ENTERED\',\'FM\');\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\'REC_FS_LOCN_NOT_OWNER\',\'FM\') +  \' - \' + \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\t\t\tparent.frames[5].document.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+msg ;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar errors = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no.type != \"hidden\")\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.focus();\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\t\n\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no.type != \"hidden\")\n\t\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.focus();\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tif(parent.frames[1].document.forms[0].p_select_values.value.length == 0)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_select_values.value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_select_values.value = parent.frames[1].document.forms[0].p_select_values.value + \'|\' + \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar p_old_string\t    = parent.frames[1].document.forms[0].p_select_values.value ;\n\t\t\t\t\t\t\tvar p_deselect_file_no  = parent.frames[1].document.forms[0].p_deselect_files.value;\n\t\t\t\t\t\t\tvar p_deselect_file_no;\n\t\t\t\t\t\t\tvar p_select_file_no\t= parent.frames[1].document.forms[0].p_select_files.value +\'|\' + parent.frames[1].document.forms[0].p_select_values.value;\n\t\t\t\t\t\t\tvar p_curr_fstat\t\t= parent.frames[1].document.forms[0].FILE_STAT.value;\n\t\t\t\t\t\t\tvar p_outst_fcy\t\t\t= parent.frames[2].document.forms[0].p_out_fcy.value;\n\t\t\t\t\t\t\tvar p_fs_locn_id\t\t= parent.frames[2].document.forms[0].FS_LOCN_ID.value;\n\t\t\t\t\t\t\tvar p_out_fsloc\t\t\t= parent.frames[2].document.forms[0].p_out_fsloc.value;\n\t\t\t\t\t\t\tvar file_type_appl_yn\t= parent.frames[2].document.forms[0].file_type_appl_yn.value;\n\t\t\t\t\t\t\tvar doc_or_file\t\t\t= parent.frames[2].document.forms[0].doc_or_file.value;\n\t\t\t\t\t\t\tvar added_volumes\t\t= \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\tvar p_fs_location\t\t= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/DTReturnMRDSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\"+p_select_file_no+\"\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'curr_fstat\' id=\'curr_fstat\' type=\'hidden\' value=\"+p_curr_fstat+\"><input name=\'p_outst_fcy\' id=\'p_outst_fcy\' type=\'hidden\' value=\"+p_outst_fcy+\"><input name=\'p_fs_locn_id\' id=\'p_fs_locn_id\' type=\'hidden\' value=\"+p_fs_locn_id+\"><input name=\'p_out_fsloc\' id=\'p_out_fsloc\' type=\'hidden\' value=\"+p_out_fsloc+\"><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\"+file_type_appl_yn+\"><input name=\'doc_or_file\' id=\'doc_or_file\' type=\'hidden\' value=\"+doc_or_file+\"><input name=\'p_fs_location\' id=\'p_fs_location\' type=\'hidden\' value=\"+p_fs_location+\"><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'added_volumes\' id=\'added_volumes\' type=\'hidden\' value=\'\"+escape(added_volumes)+\"\'><input name=\'buttonVal\' id=\'buttonVal\' type=\'hidden\' value=\'\"+buttonVal+\"\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(doc_or_file == \'F\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/FMReturnMRDSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\"+p_select_file_no+\"\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'curr_fstat\' id=\'curr_fstat\' type=\'hidden\' value=\"+p_curr_fstat+\"><input name=\'p_outst_fcy\' id=\'p_outst_fcy\' type=\'hidden\' value=\"+p_outst_fcy+\"><input name=\'p_fs_locn_id\' id=\'p_fs_locn_id\' type=\'hidden\' value=\"+p_fs_locn_id+\"><input name=\'p_out_fsloc\' id=\'p_out_fsloc\' type=\'hidden\' value=\"+p_out_fsloc+\"><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\"+file_type_appl_yn+\"><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'added_volumes\' id=\'added_volumes\' type=\'hidden\' value=\'\"+escape(added_volumes)+\"\'><input name=\'p_fs_location\' id=\'p_fs_location\' type=\'hidden\' value=\"+p_fs_location+\"><input name=\'buttonVal\' id=\'buttonVal\' type=\'hidden\' value=\'\"+buttonVal+\"\'></form></BODY></HTML>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\talert(\'HTMLVal 1 => \'+HTMLVal);\n\t\t\t\t\t\t\tparent.frames[3].document.write(HTMLVal);\n\t\t\t\t\t\t\tparent.frames[3].document.form1.submit();\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;\n\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.value = \'\';\n\t\t\t\t\t\t\t\tif(parent.frames[2].document.forms[0].file_no.type != \"hidden\")\n\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\tparent.frames[5].document.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t\t\t\t\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\t\t\t\t\tif (parent.frames[2].document.forms[0].file_no.type != \"hidden\")\n\t\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.focus();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar errors = getMessage(\'FILE_NOT_EXIST\',\'FM\');\n\t\t\t\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\t\t\t\tif (parent.frames[2].document.forms[0].file_no.type != \"hidden\")\n\t\t\t\t\t\t\t\tparent.frames[2].document.forms[0].file_no.focus();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar p_check_file_status = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\t\tif(parent.frames[1].document.forms[0].p_select_values.value.length==0)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_select_values.value = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_select_values.value = parent.frames[1].document.forms[0].p_select_values.value + \'|\' + \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<script>\n\t\t\t\tvar p_old_string\t\t= parent.frames[1].document.forms[0].p_select_values.value ;\n\t\t\t\tvar p_deselect_file_no\t= parent.frames[1].document.forms[0].p_deselect_files.value;\n\t\t\t\tvar p_deselect_file_no;\n\t\t\t\t\n\t//\t\t\tvar p_select_file_no\t= parent.frames[1].document.forms[0].p_select_files.value +\'|\' + parent.frames[1].document.forms[0].p_select_values.value;\n\t\t\t\t\n\t\t\t\tvar p_curr_fstat\t\t= parent.frames[1].document.forms[0].FILE_STAT.value;\n\t\t\t\tvar p_outst_fcy\t\t\t= parent.frames[2].document.forms[0].p_out_fcy.value;\n\t\t\t\tvar p_fs_locn_id\t\t= parent.frames[2].document.forms[0].FS_LOCN_ID.value;\n\t\t\t\tvar p_out_fsloc\t\t\t= parent.frames[2].document.forms[0].p_out_fsloc.value;\n\t\t\t\tvar file_type_appl_yn\t= parent.frames[2].document.forms[0].file_type_appl_yn.value;\n\t\t\t\tvar doc_or_file\t\t\t= parent.frames[2].document.forms[0].doc_or_file.value;\n\t\t\t\tvar p_fs_location\t\t= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\tif(doc_or_file == \'D\')\n\t\t\t\t{\n\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/DTReturnMRDSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'curr_fstat\' id=\'curr_fstat\' type=\'hidden\' value=\"+p_curr_fstat+\"><input name=\'p_outst_fcy\' id=\'p_outst_fcy\' type=\'hidden\' value=\"+p_outst_fcy+\"><input name=\'p_fs_locn_id\' id=\'p_fs_locn_id\' type=\'hidden\' value=\"+p_fs_locn_id+\"><input name=\'p_out_fsloc\' id=\'p_out_fsloc\' type=\'hidden\' value=\"+p_out_fsloc+\"><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\'\"+file_type_appl_yn+\"\'><input name=\'doc_or_file\' id=\'doc_or_file\' type=\'hidden\' value=\'\"+doc_or_file+\"\'><input name=\'p_fs_location\' id=\'p_fs_location\' type=\'hidden\' value=\"+p_fs_location+\"><input name=\'buttonVal\' id=\'buttonVal\' type=\'hidden\' value=\'\"+buttonVal+\"\'></form></BODY></HTML>\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{ \n\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/FMReturnMRDSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'curr_fstat\' id=\'curr_fstat\' type=\'hidden\' value=\"+p_curr_fstat+\"><input name=\'p_outst_fcy\' id=\'p_outst_fcy\' type=\'hidden\' value=\"+p_outst_fcy+\"><input name=\'p_fs_locn_id\' id=\'p_fs_locn_id\' type=\'hidden\' value=\"+p_fs_locn_id+\"><input name=\'p_out_fsloc\' id=\'p_out_fsloc\' type=\'hidden\' value=\"+p_out_fsloc+\"><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\'\"+file_type_appl_yn+\"\'><input name=\'p_fs_location\' id=\'p_fs_location\' type=\'hidden\' value=\"+p_fs_location+\"><input name=\'buttonVal\' id=\'buttonVal\' type=\'hidden\' value=\'\"+buttonVal+\"\'></form></BODY></HTML>\";\n\t\t\t\t}\n\t\t\t\talert(\'HTMLVal 2 => \'+HTMLVal);\n\t\t\t\tparent.frames[3].document.write(HTMLVal);\n\t\t\t\tparent.frames[3].document.form1.submit();\n\t\t\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	StringBuffer SelectSqlBuffer	= null;
	StringBuffer SelectSqlBuffer1	= null;
	StringBuffer CountSqlBuffer		= null;
	StringBuffer CountSqlBuffer1	= null;
	java.util.Hashtable message;

	try
	{
		stmt = con.createStatement();
		
		String facilityid 		 = (String) session.getValue("facility_id");

		String sql						= "";
		String p_file_status			= "";		
		
		String p_patient_file_no	= request.getParameter("p_patient_file_no");
		String p_pat_file_type		= request.getParameter("p_pat_file_type");
		String volume_no			= request.getParameter("volume_no");
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
		String added_volumes		= request.getParameter("added_volumes");
		String p_search_type		= request.getParameter("p_search_type");	
		String record_value			= request.getParameter("record_value");
		String p_display			= request.getParameter("p_display");
		String p_fs_location		= request.getParameter("p_fs_location");
		String p_out_fcy			= request.getParameter("p_out_fcy");
		String p_out_fsloc			= request.getParameter("p_out_fsloc");
		String p_receiving_fs_locn	= request.getParameter("p_receiving_fs_locn");
		String p_file_stat			= request.getParameter("p_file_stat");
		String buttonVal            = request.getParameter("buttonVal");
		if(buttonVal == null) buttonVal = "";

		//String doc_or_file			= request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");

		p_patient_file_no	= ((p_patient_file_no == null) || (p_patient_file_no.equals("null"))) ? "" : 						p_patient_file_no;
		p_pat_file_type		= ((p_pat_file_type == null) || (p_pat_file_type.equals("null"))) ? "" : 							p_pat_file_type;
		volume_no			= ((volume_no== null) || (volume_no.equals("null"))) ? "" : volume_no;
		file_type_appl_yn	= ((file_type_appl_yn== null) || (file_type_appl_yn.equals("null"))) ? "N" : 						file_type_appl_yn;
		p_file_stat = ((p_file_stat== null) || (p_file_stat.equals("null"))||(p_file_stat.equals("S"))) ? "" : p_file_stat;
		added_volumes		= ((added_volumes==null) || (added_volumes.equals("null")))?"":added_volumes;
		added_volumes		= java.net.URLDecoder.decode(added_volumes);
//out.println("<script language='JavaScript'>alert('"+p_file_stat+"');</script>");
		boolean p_load_frame	 = true;

		int  p_fs_locn_code_cnt	 = 0;
		int p_count				 = 0;

		if(p_display == null) p_display = "";
		if(p_fs_location == null) p_fs_location = "";
		if(record_value == null) record_value = "";

		if(p_search_type.equals("F"))
		{
			SelectSqlBuffer		= new StringBuffer();
			SelectSqlBuffer1	 = new StringBuffer();
			CountSqlBuffer		= new StringBuffer();
			CountSqlBuffer1		= new StringBuffer();

			CountSqlBuffer.append("select count(*) rec_cnt from mr_pat_file_index where facility_id='"+facilityid+"' ");

			if(!p_patient_file_no.equals(""))
				CountSqlBuffer.append(" and file_no = '"+p_patient_file_no+"' ");
			if(!p_pat_file_type.equals(""))
				CountSqlBuffer.append(" and FILE_TYPE_CODE = '"+p_pat_file_type+"' ");
			
			rs = stmt.executeQuery(CountSqlBuffer.toString());
			

			while(rs != null && rs.next())
			{
				p_count	= rs.getInt("rec_cnt");
			} if(rs != null) rs.close();

			if(p_count == 0)
			{
				StringTokenizer token	= new StringTokenizer(record_value,",");
				String tokenValue		= "";

				while(token.hasMoreTokens())
				{
					tokenValue = token.nextToken();
					if(p_patient_file_no.equals(tokenValue))
					{
						p_load_frame = false;
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block9Bytes, _wl_block9);

					}
				}
				StringTokenizer token1	= new StringTokenizer(p_patient_file_no,",");
			//	String tokenValue1		= "";
				while(token1.hasMoreTokens())
				{
					p_patient_file_no = token1.nextToken();
				CountSqlBuffer1.append("select count(*) rec_cnt from fm_curr_locn where facility_id = '"+facilityid+"' ");
			//	if(!p_patient_file_no.equals(""))
			//		CountSqlBuffer1.append(" and file_no = '"+p_patient_file_no+"' ");
				if(!p_pat_file_type.equals(""))
					CountSqlBuffer1.append(" and FILE_TYPE_CODE = '"+p_pat_file_type+"' ");
				if(!volume_no.equals(""))
					CountSqlBuffer1.append(" and volume_no = "+volume_no+" ");
				
				rs = stmt.executeQuery(CountSqlBuffer1.toString());
				
				while(rs.next())
				{
					p_fs_locn_code_cnt = rs.getInt("rec_cnt");
				} if(rs!=null) rs.close();

				if(p_load_frame == true)
				{
					if (p_fs_locn_code_cnt > 0)
					{
						out.println("<script language='JavaScript'>alert('"+p_patient_file_no+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
						SelectSqlBuffer.append("select perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+facilityid+"' and perm_fs_locn_code != curr_fs_locn_code ");
			
						if(!p_patient_file_no.equals(""))
							SelectSqlBuffer.append(" and file_no = '"+p_patient_file_no+"' ") ;
						if (!p_pat_file_type.equals(""))
							SelectSqlBuffer.append(" and file_type_code = '"+p_pat_file_type+"' ");
						if(!volume_no.equals(""))
							SelectSqlBuffer.append(" and volume_no = "+volume_no+" ");
						if(!p_file_stat.equals(""))
							SelectSqlBuffer.append(" and curr_file_status = '"+p_file_stat+"' ");
						
						rs = stmt.executeQuery(SelectSqlBuffer.toString());
						if(rs.next())
						{ 
							p_file_status = rs.getString("curr_file_status");
							
							if(!rs.getString("perm_fs_locn_code").equals(p_receiving_fs_locn))
							{
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
						}
						else
						{
							SelectSqlBuffer1.append("select curr_file_status from fm_curr_locn where facility_id = '"+facilityid+"' ");
								
							if(!p_patient_file_no.equals(""))
								SelectSqlBuffer1.append(" and file_no = '"+p_patient_file_no+"' ");
							if(!p_pat_file_type.equals(""))
								SelectSqlBuffer1.append(" and file_type_code = '"+p_pat_file_type+"' ");
							if(!volume_no.equals(""))
								SelectSqlBuffer1.append(" and volume_no = "+volume_no+" ");
													
							rs = stmt.executeQuery(SelectSqlBuffer1.toString());
							
							if(rs.next())
							{						
								p_file_status = rs.getString("curr_file_status");
								if(p_file_status == null) p_file_status = "1";
							} if(rs!=null) rs.close();
							
							String err_message = "";
							
							if(p_file_status.equals("T"))
							{
								//err_message = "APP-FM0076 File is currently in Transit. Hence cannot proceed";
								//err_message = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_TRANSIT_CANNOT_PROCEED","fm_messages");

								message = MessageManager.getMessage(localeName,"FILE_IN_TRANSIT_CANNOT_PROCEED","FM");
								err_message = (String) message.get("message");


							}
							else if(p_file_status.equals("A"))
							{
								  //err_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";	
								  //err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_ARCHIVE_CANNOT_PROCEED","fm_messages");

								  message = MessageManager.getMessage(localeName,"FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								  err_message = (String) message.get("message");
								  

							}
							else if(p_file_status.equals("I"))
							{
								// err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_IN_MRD","fm_messages");

								 message = MessageManager.getMessage(localeName,"FILE_ALREADY_IN_MRD","FM");
								 err_message = (String) message.get("message");
							}
							else if(p_file_status.equals("O"))
							{
								 //err_message = "APP-FM0078 File not Returned. Hence cannot proceed";
								// err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_NOT_RETURNED","fm_messages");

								message = MessageManager.getMessage(localeName,"FILE_NOT_RETURNED","FM");
								 err_message = (String) message.get("message");
							}
							else
							{
								//err_message = "APP-FM0012 File already in Permanent FS Location. Hence cannot be returned";
								//err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_IN_MRD","fm_messages");
								message = MessageManager.getMessage(localeName,"FILE_ALREADY_IN_MRD","FM");
								 err_message = (String) message.get("message");
								p_patient_file_no = "";
							}
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(err_message));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block15Bytes, _wl_block15);

						} 
						if(rs != null) rs.close(); // for above if condition.

						if(p_file_status.equals("L") || p_file_status.equals("A"))
						{
							String error_message = "";
							if(p_file_status.equals("L"))
							{
								 //error_message = "APP-FM0078 File is Lost. Hence cannot proceed";
								 //error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IS_LOST","fm_messages");
								 message = MessageManager.getMessage(localeName,"FILE_IS_LOST","FM");
								 error_message = (String) message.get("message");
							}
							else if(p_file_status.equals("A"))
							{
								 //error_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";
								// error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_ARCHIVE_CANNOT_PROCEED","fm_messages");
								 message = MessageManager.getMessage(localeName,"FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								 error_message = (String) message.get("message");
							}
							else
							{
								//error_message = "APP-FM0008 File(s) Lost/ in Transit / Archived. File(s) cannot be received at Medical Record Department";
								//error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"RETURN_FILE_STATUS","fm_messages");

								message = MessageManager.getMessage(localeName,"RETURN_FILE_STATUS","FM");
								 error_message = (String) message.get("message");
							}
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
						else
						{
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block20Bytes, _wl_block20);

						}
						
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(added_volumes));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_fs_location));
            _bw.write(_wl_block23Bytes, _wl_block23);

					}
					else
					{
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
				}
			}
			}
			else
			{
				if(!p_patient_file_no.equals(""))
				{
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			}
		}
		else if(p_search_type.equals("LF"))
		{
			sql = "select a.file_no,a.curr_fs_locn_code, a.curr_file_status from fm_curr_locn a where a.curr_facility_id='"+p_out_fcy+"' and a.curr_fs_locn_code = nvl('"+p_out_fsloc+"',a.curr_fs_locn_code) and a.perm_fs_locn_code != a.curr_fs_locn_code" ;
			
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				p_patient_file_no = rs.getString("file_no");
				p_file_status	  = rs.getString("curr_file_status");
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block31Bytes, _wl_block31);

			} if(rs != null) rs.close();
			
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_fs_location));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
		
		if(SelectSqlBuffer != null && SelectSqlBuffer.length() >0)
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		if(SelectSqlBuffer1 != null && SelectSqlBuffer1.length() >0)
		{
			SelectSqlBuffer1.delete(0,SelectSqlBuffer1.length());
		}
		if(CountSqlBuffer != null && CountSqlBuffer.length() >0)
		{
			CountSqlBuffer.delete(0,CountSqlBuffer.length());
		}
		if(CountSqlBuffer1 != null && CountSqlBuffer1.length() >0)
		{
			CountSqlBuffer1.delete(0,CountSqlBuffer1.length());
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	} catch(Exception e) { out.println("Exception ee :"+e.toString()); }
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
