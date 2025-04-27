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
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmreturnmrdselectedfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReturnMRDSelectedFiles.jsp", 1737466627651L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head> \n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnMRDFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\'>\n<FORM name = \'fm_select_form\' action=\'../../servlet/eFM.FMReceiveFileAtMRDServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>parent.frames[2].document.getElementById(\"hdr_tab\").style.visibility=\'Visible\';</script>\n\t<TABLE border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\'  id=\"srch_result\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<TR><td class=\'columnheader\' colspan =\'7\' ><b><h5><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td></TR>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<TR id=\'file_trans\'><td class=\'columnheader\' colspan = \'7\' ><b><h5><font size=1>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td></TR>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n     \t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td width=\"30%\"  class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t<A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">&nbsp;+&nbsp;</A><font size=1><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b>\n\t\t\t<br><input type=hidden name=file_no";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<input type=hidden name=patient_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t</td>\n\t\t\t<td width=\"12%\" align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ><font size=1>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font><input type=\"Hidden\" name=\"file_type_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"file_type_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><input type=\"Hidden\" name=\"volume_no";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"volume_no";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></td>\t\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">&nbsp;+&nbsp;</A><font size=1><input type=hidden name=file_no";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></td>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<a href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\",\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",\"IR\")\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp; ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</a></font></td>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<td width=17%  class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" ><font size=1>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \n\t\t\t<br>&nbsp;&nbsp;(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =")  / ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n              <br>&nbsp;&nbsp;(";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =")   \n\t\t\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</font></td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td width=\"15%\" align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t</font></td>\n\t\t\t\n\n\n\t\t\t<td width=8% align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" ><font size=1>\n\t\t\t<a href=\"javascript:GetRemarks(";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =")\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</a>\n\t\t\t<input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" value=\"\">\n\t\t\t</font></td>\t\n\t\t\t<td width=\"10%\" align=\'center\' style=\'background-color:";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'><font size=1>\n\t\t\t<input type=checkbox name=\"req_select";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"req_select";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" value=\'Y\'>\n\t\t\t<input type=hidden name=\"cur_facility_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"cur_facility_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\n\t\t\t</font></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</b><!-- //rs.getString(\"file_no\") -->\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<br><input type=hidden name=file_no";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<!--  //rs.getString(\"file_no\")\n\t\t\t//rs.getString(\"patient_line\").substring(0,rs.getString(\"patient_line\").length()-6) -->\n\t\t\t<input type=hidden name=patient_id";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<!-- //rs.getString(\"file_no\")\n\t\t\t// rs.getString(\"patient_line\").substring(0,rs.getString(\"patient_line\").length()-6) -->\n\t\t\t<input type=hidden name=patient_id";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\t<!-- //rs.getString(\"curr_fs_locn_short_desc\") -->\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</font></td>\n\t\t\t<td width=8% align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\"\">\n\t\t\t\n\t\t\t</font></td>\t\n\t\t\t<td width=\"10%\" align=\'center\' style=\'background-color:";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<input type=hidden name=\"txtComm";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"txtComm";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t</font></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t<script>\n\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled\t= false;\n\t\tparent.frames[1].document.forms[0].FILE_STAT.disabled\t\t= false;\n\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\tparent.frames[2].document.forms[0].file_no.readOnly = false;\n\t\tparent.frames[2].document.forms[0].p_out_fcy.disabled\t\t= false;\n\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled\t\t= false;\n\t\tparent.frames[2].document.forms[0].p_out_fsloc.disabled\t\t= false;\n\t\tparent.frames[2].document.forms[0].Add.disabled\t\t\t\t= false;\n        if (parent.frames[1].document.forms[0].FILE_STAT.value !=\'\'){\n\t\t  if(\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" == \"N\" ){\n\t\t\tparent.frames[2].document.forms[0].show_files.disabled\t\t= false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\tparent.frames[2].document.forms[0].show_files.disabled\t\t= true;\n\t\t}\n\t\tparent.frames[2].document.forms[0].Clear.disabled\t\t\t= false; \n\t\t\n\t</script>\n</TABLE>\n<script>\n\tfor(i=0;i<7;i++) {\n\t\tif ((document.getElementById(\"srch_result\").rows[i+1] != null) && (document.getElementById(\"srch_result\").rows[i+1].cells[i] != null)) {\n\t\tparent.frames[2].document.getElementById(\"hdr_tab\").rows[0].cells[i].width = document.getElementById(\"srch_result\").rows[i+1].cells[i].width; \n\t\t}\n\t}\n\n\t    \n\t   var p_counter = \'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\';\n\t  var rec_count   =\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\';\n\t var curr_fstat   =\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\';\n\t  var P_cnt   =\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\';\n      var buttonVal=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\';\n\t  var isModifyLongShortDescAppl = \'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'; //Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417\n\t//\tif (parseInt(p_counter) == 0 || (parseInt(rec_count)==0 && curr_fstat!=\"\")) {\n\t\t\tif ((parseInt(rec_count)==0 && buttonVal==\"A\") || (parseInt(p_counter)==0 && buttonVal==\"S\")   ) {\n\t\t\t// Modified by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417 \n\t\t\tif(isModifyLongShortDescAppl == \'true\')\n\t\t\t{\n\t\t\t\talert(getMessage(\'FILE_ALREADY_IN_MRD\',\'FM\'));\n\t\t\t}else\n\t\t\t{\n\t\t\t\talert(getMessage(\'NO_FILES_TO_RETURN\',\'FM\'));\n\t\t\t}\n\t\t\t parent.frames[2].document.forms[0].flag.value=\"\";\n\t\t\tparent.frames[2].document.forms[0].un_defcny.value=\"\";\n\t\t\tparent.frames[2].document.forms[0].patientid.value=\"\";\n\t\t\t parent.frames[2].document.forms[0].fileno.value=\"\";\n\t\t parent.frames[2].document.forms[0].volno.value=\"\";\n\t\t\t\n\t\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled\t= false;\n\t\t\tparent.frames[1].document.forms[0].FILE_STAT.disabled\t\t= false;\n\t\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\tparent.frames[2].document.forms[0].file_no.readOnly = false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fcy.disabled\t\t= false;\n\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled\t\t= false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fsloc.disabled\t\t= false;\n\t\t\tparent.frames[2].document.forms[0].Add.disabled\t\t\t\t= false;\n\t\t\tif (parent.frames[1].document.forms[0].FILE_STAT.value !=\'\'){\n\t\t\tif(\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" == \"N\" ){\n\t\t\tparent.frames[2].document.forms[0].show_files.disabled\t= false;\n\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[2].document.forms[0].show_files.disabled\t= true;\n\t\t\t}\n\t\t\tparent.frames[2].document.forms[0].Clear.disabled\t\t\t= false; \n\n\t\t\tparent.frames[2].document.forms[0].patient_id.value = \'\';\n\t\t\tparent.frames[2].document.forms[0].patient_id.focus() ;\n\t\t\tif(p_counter==0){\n\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'Hidden\';\n\t\t\t}\n\t\t\tif(parent.frames[2].document.forms[0].file_no)\n\t\t\tparent.frames[2].document.forms[0].file_no.value=\'\';\n\t\t\tparent.frames[2].document.forms[0].remove_volume.value = \"ALL\";\n\t\t\tparent.frames[1].document.forms[0].p_select_values.value = \"\";\n\t\t\tif(p_counter==0){\n\t\t\tparent.frames[3].location.href = \"../../eCommon/html/blank.html\";\n\t\t\t}\n\t}\n\telse\n\t{ \n\t\t/*Below field namesare being sent dynamically to \"FMFileSearchComponentValues.jsp\"  in \"FMReceiveFileMRDSearch.jsp\"*/\n\t\t parent.frames[2].document.forms[0].patient_id.value = \'\';\n\t\t parent.frames[2].document.forms[0].patient_id.focus();\n\t\t \n\t\t \n\t\t if (parent.frames[2].document.forms[0].file_type)\n\t\t parent.frames[2].document.forms[0].file_type.value = \'\';\n\t\t if (parent.frames[2].document.forms[0].volume_n)\n\t\t parent.frames[2].document.forms[0].volume_no.value =\'\';\n\t}\n\n\tparent.frames[1].document.forms[0].p_deselect_values.value\t= \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n\tparent.frames[1].document.forms[0].p_select_values.value\t= \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\n\tparent.frames[1].document.forms[0].p_total_records.value\t= \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\tparent.frames[1].document.forms[0].p_outst_facility.value\t= \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\tvar p_in_files\t\t= parent.frames[1].document.forms[0].p_select_values.value;\n\tvar p_not_files\t= parent.frames[1].document.forms[0].p_deselect_values.value;\n\tparent.frames[2].document.forms[0].p_total_select.value = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t//parent.frames[2].document.forms[0].patient_id.value\t\t= \"\";\n\t//parent.frames[2].populateDynamicValues(parent.frames[2].document.forms[0].patient_id.value);\n\t\tparent.frames[2].document.getElementById(\"patient_id\").onblur();\n\n\tif(\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" == \"Y\" && \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" == \"T\")\n\t{\n\t\tif(document.getElementById(\"file_trans\"))\n\t\tdocument.getElementById(\"file_trans\").style.display= \"none\";\n\t}\n</script>\n\t<input type=\'hidden\' name=\'p_select_values\' id=\'p_select_values\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<input type=\'hidden\' name=\'p_total_select\' id=\'p_total_select\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n</HTML>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

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

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	PreparedStatement pstmt2	= null;
	ResultSet rs2			= null;
	
	StringBuffer SelectSqlBuffer	= null;

	String p_select_values			= "";
	String p_concat_string			= "";
	String p_files_not_in			= "";
	String return_date_time			= "";
	String patientno_volume="";
	String pat_id1="";
	String vol_no="";
	String buttonVal ="";           
	String curr_fac_id="";
	String curfista="";
	String outfacid="";
	String patientid="";
	String filenum="";
	String facid="";
	String duration_type="";
	String return_criteria="";
	String no_of_dh_to_return_op="0";
	String discharge_date_time="";
	int p_count = 0;
	int count_tokens=0;
    int rec_count=0;
    int P_cnt=0;
   int parameter_hours=0;

   boolean isModifyLongShortDescAppl = false;//Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417

try
{	
	
	SelectSqlBuffer = new StringBuffer();
	String facilityid 			= (String) session.getValue("facility_id");
	String curr_fs_locn_identity = "";
	String PatFile_string		= "";
	String p_stored_val			= request.getParameter("p_select_files");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String added_volumes		= request.getParameter("added_volumes");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String curr_fstat			= request.getParameter("curr_fstat");
	String p_outst_fcy			= request.getParameter("p_outst_fcy");
	String p_fs_locn_id			= request.getParameter("p_fs_locn_id");
	String p_out_fsloc			= request.getParameter("p_out_fsloc");
	String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	String p_stored_val1		= request.getParameter("p_stored_val");
	String file_num    = request.getParameter("p_patient_file_no");
	String volume_no1= request.getParameter("volume_no");
	String patient_id=request.getParameter("patient_id");
	String p_receiving_fs_locn=request.getParameter("p_receiving_fs_locn");
   String curr_file_status="";
	buttonVal					= request.getParameter("buttonVal");

	isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"FM","RECEIVE_FILE_MRD_MSG"); //Added by Kamatchi S on 12/09/2019 for ML-MMOH-CRF-1417
			
	if(buttonVal == null) buttonVal = "";

	if(patient_id==null) patient_id="";
	if(volume_no1==null) volume_no1="";
	if(file_num==null) file_num="";
   if(p_receiving_fs_locn==null) p_receiving_fs_locn="";
	String p_fs_location = request.getParameter("p_fs_location")==null?"":request.getParameter("p_fs_location");
	
	String accept_out_intransit_yn	= (String) session.getValue("accept_out_intransit_yn");

	if(accept_out_intransit_yn==null)
		accept_out_intransit_yn="N";

//	if(accept_out_intransit_yn.equals("Y"))
	//{
   pstmt	= con.prepareStatement("select curr_facility_id,curr_file_status from  fm_curr_locn where facility_id = '"+facilityid+"' and patient_id='"+patient_id+"' and file_no='"+file_num+"' and volume_no='"+volume_no1+"' ");
	rs		= pstmt.executeQuery();
 while(rs != null && rs.next()){
  curr_fac_id =rs.getString("curr_facility_id");
 curr_file_status=rs.getString("curr_file_status");
 }
//  }

	if(rs!=null)	rs.close();
  if(pstmt!=null) pstmt.close();
  
    
	
	
	
	if(curr_fac_id == null) curr_fac_id = "";
	if(file_type_appl_yn == null) file_type_appl_yn = "N";
	if(p_not_in_files == null) p_not_in_files = "";
    if(p_stored_val1 == null) p_stored_val1 = "";
	if(p_include_in_select == null) p_include_in_select = "";
	if(added_volumes == null) added_volumes="";
	if(curr_fstat == null || curr_fstat.equals("null")) curr_fstat = "";
    
	if(buttonVal.equals("A"))
	{
	if(!p_outst_fcy.equals("") && curr_fstat.equals("T")){
   
   if(!facilityid.equals(p_outst_fcy) && curr_fstat.equals("T"))
	{
       curr_fstat="E";
	}

	if(facilityid.equals(p_outst_fcy) && curr_fstat.equals("T") && curr_file_status.equals("E"))
	{
       curr_fstat="E";
	}
    
 }else if(curr_fstat.equals("T") && curr_file_status.equals("E") ){
curr_fstat=curr_file_status;
   }
	}
	
	 pstmt	= con.prepareStatement("select count(*) cnt from  fm_curr_locn where facility_id = '"+facilityid+"' and patient_id='"+patient_id+"' and file_no='"+file_num+"' and volume_no='"+volume_no1+"' and curr_file_status!='I' and  curr_file_status=nvl('"+curr_fstat+"',curr_file_status) and curr_fs_locn_code=nvl('"+p_fs_location+"',curr_fs_locn_code) and curr_facility_id=nvl('"+p_outst_fcy+"',curr_facility_id) ");
	
	  rs		= pstmt.executeQuery();
	while(rs != null && rs.next()) {
		rec_count =rs.getInt("cnt");
	}
	
	
	
	added_volumes = java.net.URLDecoder.decode(added_volumes);

	StringTokenizer token = new StringTokenizer(p_stored_val,"|");

	while(token.hasMoreTokens()) {
		if(p_count ==0) {
			p_concat_string     = "'" + token.nextToken() +"'";
		}
		else {
			p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
		}
		p_count++;
	}

	if(p_concat_string.length() == 0) p_concat_string = "''";
	
	p_count = 0;

	if (!p_not_in_files.equals("")) {
		StringTokenizer token1 = new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens()) {
			getTokenValue = token1.nextToken();

			if(p_count == 0) {
				p_files_not_in     = "'" + getTokenValue +"'";
			}
			else {
				p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
			}
			p_count++;
		}
	}
	
	SelectSqlBuffer.append("SELECT" );
	SelectSqlBuffer.append("  a.file_no " );
	SelectSqlBuffer.append("  ,a.facility_id " );
	SelectSqlBuffer.append("  ,a.patient_id " );
	SelectSqlBuffer.append("  ,get_patient_line(a.patient_id,'"+localeName+"')patient_line " );
	SelectSqlBuffer.append("  ,a.curr_file_status curr_file_status1 " );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_code " );
	SelectSqlBuffer.append("  ,fm_Get_desc.Fm_storage_locn(a.CURR_FACILITY_ID,a.curr_fs_locn_code,'"+localeName+"',2) curr_fs_locn_short_desc " );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_identity curr_fs_locn_identity " );
	SelectSqlBuffer.append("  ,nvl(TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') ,'&nbsp;')return_date_time " );
	SelectSqlBuffer.append("  ,DECODE(a.curr_file_status,'I',1,'O',1,'L',3,'T',2,'A',4,'E',2,'R',1)order_by_status " );
	SelectSqlBuffer.append("  ,( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_facility_id<> a.facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    '('|| (SM_GET_DESC.SM_FACILITY_PARAM(a.CURR_FACILITY_ID,'"+localeName+"','1'))||')' " );
	SelectSqlBuffer.append("  ELSE '&nbsp;' " );
	SelectSqlBuffer.append("  END )curr_facility_name,a.CURR_FACILITY_ID " );
	SelectSqlBuffer.append("  ,ltrim(rtrim(a.req_remarks))req_remarks " );
	SelectSqlBuffer.append("  ,ltrim(rtrim(a.remarks))remarks " );
	SelectSqlBuffer.append("  ,MR_GET_DESC.MR_FILE_TYPE(a.FACILITY_ID, a.FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc " );
	SelectSqlBuffer.append("  ,a.file_type_code " );
	SelectSqlBuffer.append("  ,a.volume_no " );
	SelectSqlBuffer.append("  ,b.return_criteria " );
	SelectSqlBuffer.append("  ,b.no_of_dh_to_return_op " );
	SelectSqlBuffer.append("  ,b.duration_type " );
	SelectSqlBuffer.append("FROM" );
	SelectSqlBuffer.append("  fm_curr_locn a, fm_storage_locn b " );
   SelectSqlBuffer.append(" WHERE  a.perm_fs_locn_code = '"+p_receiving_fs_locn+"' " );
	
	SelectSqlBuffer.append(" AND a.facility_id='"+facilityid+"' " );
	

	if(!p_stored_val1.equals(""))
	{
	
	StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val1,"/");  
	    count_tokens=pat_volumeno.countTokens();
	 
	   SelectSqlBuffer.append( "AND ( ");
	  while(pat_volumeno.hasMoreTokens())
	  {
	    P_cnt++;
	    patientno_volume    =pat_volumeno.nextToken() ;
		StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
		 int cnt=fileno1.countTokens();
		while(fileno1.hasMoreTokens())
		{
			patientid=fileno1.nextToken();	
			pat_id1 =fileno1.nextToken();	
						
			if(cnt==5)
			{
			curfista=fileno1.nextToken();	
			outfacid=fileno1.nextToken();
			if(curfista.equals("curfista"))
				{
                  curfista="";
				}
			 if(outfacid.equals("p_out_fcy"))
				{
                  outfacid="";
				}
			
			}
			
			
			vol_no	=fileno1.nextToken();
			int indxx=PatFile_string.indexOf(pat_id1 +"-"+vol_no+"-"+facilityid,0);
			if(indxx<0){
	            PatFile_string =  pat_id1 +"-"+vol_no+"-"+facilityid+","+PatFile_string ;
			}
		}

	    SelectSqlBuffer.append( " ( a.file_no ='"+pat_id1+"' ");
       SelectSqlBuffer.append("  AND a.patient_id ='"+patientid+"' ");
	  
	  if(!outfacid.equals(""))
		  SelectSqlBuffer.append("  AND a.curr_facility_id =nvl( '"+outfacid+"',a.curr_facility_id) ");
	 outfacid="";	 
	
	if(!curr_fstat.equals("S"))
	{
	
			
			if(curfista.equals("T"))
			{
			SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS IN('T','E') ");
			curfista="";
			}else{
			SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS=nvl('"+curfista+"',a.CURR_FILE_STATUS) ");
		   curfista="";
		
		}
	   SelectSqlBuffer.append("AND a.CURR_FILE_STATUS!='I'");
		}
		 
		 if (!vol_no.equals(""))
		 {
				if(count_tokens >P_cnt)
				{
					SelectSqlBuffer.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
				
				}
				else
				{
					SelectSqlBuffer.append(" AND a.volume_no ='"+vol_no +"' ))");	
				}
			}
		}	
	
	  }

	if(buttonVal.equals("S"))
	{
		
		 if(curr_fstat.equals("T")){
        SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS IN ('T','E')");
		 }else if(!curr_fstat.equals("")){
		SelectSqlBuffer.append(" AND a.CURR_FILE_STATUS='"+curr_fstat+"' ");
		
		// SelectSqlBuffer.append(" WHERE a.CURR_FILE_STATUS=nvl('"+curr_fstat+"',a.CURR_FILE_STATUS)");
		 }
		// SelectSqlBuffer.append(" AND a. perm_fs_locn_code = '"+p_receiving_fs_locn+"' " );
	 	 if(!p_outst_fcy.equals("")){
		SelectSqlBuffer.append("  AND a.curr_facility_id = '"+p_outst_fcy+"' ");
		}	
	    	
	   } 
	
 SelectSqlBuffer.append(" AND a.curr_facility_id = b.facility_id " );
	SelectSqlBuffer.append(" AND a.curr_fs_locn_code = b.fs_locn_code " );
	
	if(!p_fs_locn_id.equals(""))
	{
	SelectSqlBuffer.append("  AND a.curr_fs_locn_identity = decode('"+p_fs_locn_id+"','',a.curr_fs_locn_identity,'"+p_fs_locn_id+"') " );
	}
	if(!p_out_fsloc.equals(""))
	{
	SelectSqlBuffer.append("  AND a.curr_fs_locn_code =decode('"+p_out_fsloc+"','',a.curr_fs_locn_code,'"+p_out_fsloc+"') " );
	}
	SelectSqlBuffer.append("  AND a.doc_folder_id IS" );
	SelectSqlBuffer.append("  null " );
	SelectSqlBuffer.append("ORDER BY" );
	SelectSqlBuffer.append("  a.return_date_time  desc" );
	SelectSqlBuffer.append("  ,a.curr_fs_locn_code " );
	SelectSqlBuffer.append("  ,a.file_no" );

   //pstmt	= con.prepareStatement(SelectSqlBuffer.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt	= con.prepareStatement(SelectSqlBuffer.toString());
		
		rs		= pstmt.executeQuery();
		
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String classValue					= "";
	String bgcolor						= "";
	String p_allow_select				= "";
	String p_checked					= "";
	String file_type_desc				= "";
	String file_type_code				= "";
	String volume_no					= "";
	String p_first_curr_fs_locn_code	= "";
     String cur_facility_id=""; 
	int i					= 0;
	int p_rec_cnt			= 0;
	int p_return_cnt		= 0;
	int p_not_return_cnt	= 0;
	int counter				= 0;
 
 if(buttonVal.equals("S")){ // handle show all part


	while(rs != null && rs.next()) {
		if(i % 2 == 0) classValue = "QRYEVEN" ;
		  else classValue = "QRYODD" ;

	cur_facility_id=rs.getString("CURR_FACILITY_ID");
	if(rs.getString("curr_file_status1").equals("A")) {
		bgcolor			= "gold";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T")) {
		/*bgcolor			= "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";*/
		if(accept_out_intransit_yn.equals("N"))
		{
		bgcolor			= "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";
		}
		else
		{
		bgcolor			= "darkseagreen";
		p_allow_select	= "";
		p_checked		= "checked";
		}
		
	}
	else if (rs.getString("curr_file_status1").equals("L")) {
		bgcolor			= "mediumvioletred";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("I")) {
		bgcolor			= "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O")) {
		if(accept_out_intransit_yn.equals("N"))
		{
		bgcolor			= "sandybrown";
		p_allow_select	= "disabled";
		p_checked		= "";
		}
		else
		{
		bgcolor			= "sandybrown";
		p_allow_select	= "";
		p_checked		= "checked";
		}
	}
	else if (rs.getString("curr_file_status1").equals("E")) {
		if(accept_out_intransit_yn.equals("N"))
		{
        bgcolor			= "cyan";
		p_allow_select	="disabled";
		p_checked		= "";
		}else{
		bgcolor			= "cyan";
		p_allow_select	= "";
		p_checked		= "checked";
		}
	}
	else if (rs.getString("curr_file_status1").equals("R")) {
		bgcolor			= "#C0C0C0";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else {
		bgcolor			= "";
		p_allow_select	= "";
		p_checked		= "";
	}
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O")) {
		if(p_return_cnt == 0) {
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
		p_return_cnt++;
	}
	if(rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T")) {

		if(p_not_return_cnt == 0) {
			if(p_return_cnt > 0) {
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			else {
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}
		p_not_return_cnt++;
	
	
	}

curr_fs_locn_identity=rs.getString("curr_fs_locn_identity");
if(!curr_fs_locn_identity.equals("")){
	switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		   counter++ ;
        if(counter % 2 == 0) classValue = "QRYODD" ;
        else classValue = "QRYEVEN" ;

		String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		StringTokenizer st = new StringTokenizer(tempstr, ",");

		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();

		//String patient_id	= st.nextToken();

		String pat_id		= rs.getString("patient_id");
		file_type_desc		= rs.getString("file_type_desc");
		file_type_code		= rs.getString("file_type_code");
		volume_no			= rs.getString("volume_no");
        filenum              = rs.getString("file_no");
		facid              = rs.getString("facility_id");
		p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		 return_criteria =rs.getString("return_criteria");
      no_of_dh_to_return_op=rs.getString("no_of_dh_to_return_op");
      duration_type=rs.getString("duration_type");
		
	/*	pstmt1	= con.prepareStatement("select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+p_first_curr_fs_locn_code+"' and facility_id='"+facid+"'");
	  rs1		= pstmt1.executeQuery();
   while(rs1 != null && rs1.next()){
    return_criteria =rs1.getString("return_criteria");
    no_of_dh_to_return_op=rs1.getString("no_of_dh_to_return_op");
    duration_type=rs1.getString("duration_type");
    }
     if(rs1!=null)	rs1.close();
     if(pstmt1!=null) pstmt1.close(); */
		
	   if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
		
		if ((file_type_desc == null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc = file_type_desc + " / ";
		if (file_type_code == null) file_type_desc = "";
		if (volume_no == null) volume_no = "";
		if (filenum == null) filenum = "";
		if (facid == null) facid = "";
		
		        if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
					
				
		
		
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(file_type_appl_yn.equals("N")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( pat_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }
			else if (file_type_appl_yn.equals("Y")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( pat_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(file_type_desc));
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
}

			String p_iss_remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
		//	p_iss_remarks=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");
			if(p_iss_remarks.equals("")) {
				out.println("&nbsp;</font></td>");
			} 
			else {
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
String curr_fac=rs.getString("curr_facility_name");
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( rs.getString("curr_fs_locn_short_desc") ));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!curr_fac.equals("&nbsp;")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( curr_fs_locn_identity));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(curr_fac));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( curr_fs_locn_identity));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

				return_date_time=rs.getString("return_date_time");

				if(!return_date_time.equals("&nbsp;"))
				{
		return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
				}
		
		 if(return_criteria.equals("D"))
			{
		 pstmt2	= con.prepareStatement("SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+facid+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+filenum+"' AND facility_id ='"+facid+"' AND sent_date_time IS NOT null)");
	      
		   rs2		= pstmt2.executeQuery();
         while(rs2 != null && rs2.next()){
        discharge_date_time =rs2.getString("discharge_date_time");
           }
       if(rs2!=null)	rs2.close();
       if(pstmt2!=null) pstmt2.close();
	       if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
			
			if(return_date_time.equals("&nbsp;") || return_date_time!=null)
				{
				 return_date_time=discharge_date_time;
				}
			
			 if(parameter_hours<=0)
							{
             return_date_time="";
							}
			if(return_date_time.equals(""))  return_date_time="&nbsp;";
			}
				
			
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_checked));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(p_allow_select));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cur_facility_id));
            _bw.write(_wl_block62Bytes, _wl_block62);

		if(p_select_values=="") {
			p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
		}
		else {
			p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
		}
		i++;
		p_rec_cnt++;

		//p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
	} //endwhile



}else{ // to handle the add part
		
	
	  ArrayList arr_list_out=new ArrayList();
	HashMap h_map=new HashMap();
	String collection_key="";
		
		   while(rs != null && rs.next()) {
			 
			 filenum              = rs.getString("file_no");
		     facid              = rs.getString("facility_id");
		     p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		   String returndate  =rs.getString("RETURN_DATE_TIME");
		   return_criteria =rs.getString("return_criteria");
           no_of_dh_to_return_op=rs.getString("no_of_dh_to_return_op");
          duration_type=rs.getString("duration_type");
	
	/*	pstmt1	= con.prepareStatement("select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+p_first_curr_fs_locn_code+"' and facility_id='"+facid+"'");
	  rs1		= pstmt1.executeQuery();
   while(rs1 != null && rs1.next()){
    return_criteria =rs1.getString("return_criteria");
    no_of_dh_to_return_op=rs1.getString("no_of_dh_to_return_op");
    duration_type=rs1.getString("duration_type");
    }
     if(rs1!=null)	rs1.close();
     if(pstmt1!=null) pstmt1.close(); */
		
	         if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
				
		if (filenum == null) filenum = "";
		if (facid == null) facid = "";
		
		        if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
		 if(return_criteria.equals("D"))
			{
		 pstmt2	= con.prepareStatement("SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+facid+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+filenum+"' AND facility_id ='"+facid+"' AND sent_date_time IS NOT null)");
	      
		   rs2		= pstmt2.executeQuery();
         while(rs2 != null && rs2.next()){
        discharge_date_time =rs2.getString("discharge_date_time");
           }
       if(rs2!=null)	rs2.close();
       if(pstmt2!=null) pstmt2.close();
		

          if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
			
			if(returndate.equals("&nbsp;") || returndate!=null)
				{
				 returndate=discharge_date_time;
				}
			   if(parameter_hours<=0)
							{
						returndate="";
						}
			
			
			if(returndate.equals(""))  returndate="&nbsp;";
			}
	
	
	
	
	//ArrayList arr_list_out=new ArrayList();
	//HashMap h_map=new HashMap();
	//String collection_key="";
	//while(rs != null && rs.next()) {  // building the collection;

      ArrayList arr_list_in=new ArrayList();

		arr_list_in.add(checkForNull(rs.getString("FILE_NO")));
		arr_list_in.add(checkForNull(rs.getString("FACILITY_ID")));
		arr_list_in.add(checkForNull(rs.getString("PATIENT_ID")));
		arr_list_in.add(checkForNull(rs.getString("PATIENT_LINE")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FILE_STATUS1")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_CODE")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_SHORT_DESC")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FS_LOCN_IDENTITY")));
		if(return_criteria.equals("D")){
		arr_list_in.add(returndate);
		}else{
         arr_list_in.add(checkForNull(rs.getString("RETURN_DATE_TIME")));
		}
		arr_list_in.add(checkForNull(rs.getString("ORDER_BY_STATUS")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FACILITY_NAME")));
		arr_list_in.add(checkForNull(rs.getString("CURR_FACILITY_ID")));
		arr_list_in.add(checkForNull(rs.getString("REQ_REMARKS")));
		arr_list_in.add(checkForNull(rs.getString("REMARKS")));
		arr_list_in.add(checkForNull(rs.getString("FILE_TYPE_DESC")));
		arr_list_in.add(checkForNull(rs.getString("FILE_TYPE_CODE")));
		arr_list_in.add(checkForNull(rs.getString("VOLUME_NO")));
		collection_key=arr_list_in.get(0)+"-"+arr_list_in.get(16)+"-"+arr_list_in.get(1);
		h_map.put(collection_key,arr_list_in);
	
		arr_list_in=null;
	}
	
	StringTokenizer str_token=new StringTokenizer(PatFile_string,",");
		String key_val="";
	while(str_token.hasMoreTokens()){
		key_val=str_token.nextToken();
			arr_list_out=(ArrayList) h_map.get(key_val);
			if(arr_list_out!=null && arr_list_out.size()>0){
			
			if(i % 2 == 0) classValue = "QRYEVEN" ;
				  else classValue = "QRYODD" ;			
	
			//cur_facility_id=rs.getString("curr_faclility_id");
			cur_facility_id=(String)arr_list_out.get(11);
           	String arr_cur_file_status=(String) arr_list_out.get(4);
			//if(rs.getString("curr_file_status1").equals("A")) {
			if(arr_cur_file_status.equals("A")) {
				bgcolor			= "gold";
				p_allow_select	= "disabled";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("T")) {
			else if (arr_cur_file_status.equals("T")) {
				/*bgcolor			= "darkseagreen";
				p_allow_select	= "disabled";
				p_checked		= "";*/
				if(accept_out_intransit_yn.equals("N"))
				{
					bgcolor			= "darkseagreen";
					p_allow_select	= "disabled";
					p_checked		= "";
				}
				else
				{
					bgcolor			= "darkseagreen";
					p_allow_select	= "";
					p_checked		= "checked";
				}
			
			}
			//else if (rs.getString("curr_file_status1").equals("L")) {
			else if (arr_cur_file_status.equals("L")) {
				bgcolor			= "mediumvioletred";
				p_allow_select	= "disabled";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("I")) {
			else if (arr_cur_file_status.equals("I")) {
				bgcolor			= "E0FFFF";
				p_allow_select	= "";
				p_checked		= "";
			}
			//else if (rs.getString("curr_file_status1").equals("O")) {
			else if (arr_cur_file_status.equals("O")) {
				if(accept_out_intransit_yn.equals("N"))
				{
				bgcolor			= "sandybrown";
				p_allow_select	= "disabled";
				p_checked		= "";
				}
				else
				{
				bgcolor			= "sandybrown";
				p_allow_select	= "";
				p_checked		= "checked";
				}
			}
			//else if (rs.getString("curr_file_status1").equals("E")) {
			else if (arr_cur_file_status.equals("E")) {
				if(accept_out_intransit_yn.equals("N"))
				{
				bgcolor			= "cyan";
				p_allow_select	= "disabled";
				p_checked		= "";
				}else{
              bgcolor			= "cyan";
				p_allow_select	= "";
				p_checked		= "checked";


				}
			
			}
			//else if (rs.getString("curr_file_status1").equals("R")) {
			else if (arr_cur_file_status.equals("R")) {
				bgcolor			= "#C0C0C0";
				p_allow_select	= "";
				p_checked		= "checked";
			}
			else {
				bgcolor			= "";
				p_allow_select	= "";
				p_checked		= "";
			}
	//if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O")) {
	/*if (arr_cur_file_status.equals("I") || arr_cur_file_status.equals("O")) {
		if(p_return_cnt == 0) {
	<TR><td class='columnheader' colspan ='7' ><b><h5><font size=1><fmt:message key="eFM.FilestobeReturned.label" bundle="${fm_labels}"/></font></td></TR> -->
			
		/*}
		p_return_cnt++;
	}*/
	//if(rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T")) {
	/*if(arr_cur_file_status.equals("L") ||arr_cur_file_status.equals("A") || arr_cur_file_status.equals("T")) {

		if(p_not_return_cnt == 0) {
			if(p_return_cnt > 0) {
				
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				
			}
			else {
				
				<TR id='file_trans'><td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.FilescannotbeReturned.label" bundle="${fm_labels}"/></font></td></TR>
				
			}
		}
		p_not_return_cnt++;
	
	
	}*/

//curr_fs_locn_identity=rs.getString("curr_fs_locn_identity");
curr_fs_locn_identity=(String)arr_list_out.get(7);
if(!curr_fs_locn_identity.equals("")){
	switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
}
        counter++ ;
        if(counter % 2 == 0) classValue = "QRYODD" ;
        else classValue = "QRYEVEN" ;

		//String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		String tempstr = (String)arr_list_out.get(3);
		tempstr=tempstr.substring(0,tempstr.length()-6);
		StringTokenizer st = new StringTokenizer(tempstr, ",");

		st.nextToken();
		st.nextToken();
		st.nextToken();
		st.nextToken();

		//String patient_id	= st.nextToken();

		//String pat_id		= rs.getString("patient_id");
		//file_type_desc		= rs.getString("file_type_desc");
		//file_type_code		= rs.getString("file_type_code");
		//volume_no			= rs.getString("volume_no");

		String pat_id		= (String)arr_list_out.get(2);
		file_type_desc		= (String)arr_list_out.get(14);
		file_type_code		= (String)arr_list_out.get(15);
		volume_no			= (String)arr_list_out.get(16);

		if ((file_type_desc == null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc = file_type_desc + " / ";
		if (file_type_code == null) file_type_desc = "";
		if (volume_no == null) volume_no = "";
		
		
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(file_type_appl_yn.equals("N")) 
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( pat_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arr_list_out.get(0)  ));
            _bw.write(_wl_block64Bytes, _wl_block64);
String tmp1=(String)arr_list_out.get(3);
			tmp1=tmp1.substring(0,tmp1.length()-6);
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)arr_list_out.get(0)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tmp1 ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }
			else if (file_type_appl_yn.equals("Y")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block67Bytes, _wl_block67);
String tmp2=(String)arr_list_out.get(3);
			tmp2=tmp2.substring(0,tmp2.length()-6);
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( pat_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String) arr_list_out.get(0) ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tmp2 ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(file_type_desc));
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
}

			//String p_iss_remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
			String p_iss_remarks = (String)arr_list_out.get(13)==null?"":(String)arr_list_out.get(13);
		//	p_iss_remarks=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");
			if(p_iss_remarks.equals("")) {
				out.println("&nbsp;</font></td>");
			} 
				
			else {
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
//String curr_fac=rs.getString("curr_facility_name");
				String curr_fac=(String)arr_list_out.get(10);
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( arr_list_out.get(6) ));
            _bw.write(_wl_block70Bytes, _wl_block70);
if(!curr_fac.equals("&nbsp;")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( curr_fs_locn_identity));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(curr_fac));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( curr_fs_locn_identity));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

				//return_date_time=rs.getString("return_date_time");
				return_date_time=(String)arr_list_out.get(8);

				if(!return_date_time.equals("&nbsp;"))
				{
					return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
				}
			
			
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_checked));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(p_allow_select));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cur_facility_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block75Bytes, _wl_block75);

		if(p_select_values=="") {
			//p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
			p_select_values = (String)arr_list_out.get(0)+'`'+(String)arr_list_out.get(1);
		}
		else {
			//p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
			p_select_values = p_select_values + '|' + (String)arr_list_out.get(0)+'`'+(String)arr_list_out.get(1);
		}
		i++;
		p_rec_cnt++;
		//p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
		p_first_curr_fs_locn_code = (String)arr_list_out.get(5);


		}  // checking arraluist empty /size
	}// looping logic

		h_map=null;
		arr_list_out=null;


} // condition for add part

	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}

	
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(accept_out_intransit_yn));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(curr_fstat));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(P_cnt));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(buttonVal));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(isModifyLongShortDescAppl));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(accept_out_intransit_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(p_not_in_files));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(p_stored_val));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(cur_facility_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(accept_out_intransit_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(curr_fstat));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(p_select_values));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block93Bytes, _wl_block93);

if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){
	out.println("Exception in ReturnMRDSelectedFiles.jsp :"+e);
	}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FilestobeReturned.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FilescannotbeReturned.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FilescannotbeReturned.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
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
}
