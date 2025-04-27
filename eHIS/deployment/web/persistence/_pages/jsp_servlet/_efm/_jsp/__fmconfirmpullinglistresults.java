package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmconfirmpullinglistresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMConfirmPullingListResults.jsp", 1742884542481L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t10/06/2002\n\tModule\t\t\t:\tFM - Register File Not Pulled\n\tFunction\t\t:\tThis function is used for Search Result.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMConfirmPullingList.js\'></script>\n\n</head>\n<body  onLoad=\'dispRecord(); loadCurrPage();\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'FMConfirmPullingListForm\' id=\'FMConfirmPullingListForm\' action=\'FMConfirmPullingListResults.jsp\' method=\'post\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- \t\t\t\t<table width=\'95%\'>\n\t\t\t\t<tr>\n\t\t\t\t<td  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'  >\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<td width=\'40%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td width=\'8%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td width=\'10%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td width=\'8%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td width=\'13%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="?</td>\n\t\t\t<td width=\'10%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\n\t\t\t\t\t<td width=\'10%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td width=\'10%\' class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</td><!--Added by Thamizh selvi on 17th Jan 2018 against ML-MMOH-CRF-0933-->\n\t\t\t<td width=\'10%\' nowrap class=\'columnheader\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="?<input type=checkbox name=select_all id=select_all value=\'\' onClick=\"SelectAll(from,end)\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="></td>\n\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n        <tr>\n            <td  width=\"100%\" height=\"20\" colspan=8 class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></td>\n        </tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' nowrap width=40%>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<font size=\'1\'><b>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\n\t\t\t\t</font></b> / ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<font size=\'1\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font><input type=hidden name=p_file_no";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" value=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="><input type=hidden name=p_appt_ref_no";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="><input type=hidden name=p_patient_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="><input type=hidden name=p_volume_no";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=\'center\' width=7%><font size=\'1\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="/";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' align=\'center\' width=10%><font size=\'1\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' align=\'center\' width=13%><font size=\'1\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</font></td>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' align=\'center\' width=10%><font size=\'1\'>&nbsp;</font></td>\n\t\t\t\t<input type=hidden name=p_remarks";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' align=\'center\' width=10%><font size=\'1\'><a href=\'javascript:GetRemarks(";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\")\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" </a></font></td>\n\t\t\t\t<input type=hidden name=p_remarks";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<input type=\'hidden\' name=\'rem_recnum_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' value=\'\'>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' width=10%><font size=\'1\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' width=\'10%\'><font size=\'1\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td><!--Added by Thamizh selvi on 17th Jan 2018 agains ML-MMOH-CRF-0933-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" align=center width=12% style=background-color:";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="><input type=\'checkbox\' name=\'pull_yn";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'  value=\'Y\'  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onClick=\"UnselectPullAll(this)\" onTest=\'CBValue(this,\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\");\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" ></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<tr>\n            <td colspan = \'8\'><font size=\'1\'>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</font>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<script>\t\t\t\n\n\t\t\t\tparent.frames[0].document.forms[0].fs_locn_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].appt_date.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].p_gender.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_clinic_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_pract_id.disabled=false;\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].confirm_yn.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pull_type.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].subBotton.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pract_id.disabled=false;\t\t\t\t\n\n\t\t\t\t</script>\t\t\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<script>\n\t\t\t\tvar msg1=getMessage(\"FM_NO_RECORDS_FOUND\",\"FM\");\t\n\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+ msg1+\"&err_value=0\";\n                 parent.frames[0].document.forms[0].flag.value=\"true\";\n\t\t\t\t\tparent.frames[0].document.forms[0].fs_locn_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].appt_date.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].p_gender.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_clinic_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_pract_id.disabled=false;\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].confirm_yn.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pull_type.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].subBotton.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pract_id.disabled=false;\t\t\t\t\n\n\t\t\t\t</script>\t\t\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<script>\n\t\t\t\tvar msg1=getMessage(\'FILE_IS_LOST\',\'FM\');\t\n\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+ msg1+\"&err_value=0\";\n            //     parent.frames[0].document.forms[0].flag.value=\"true\";\n\t\t\t\t\tparent.frames[0].document.forms[0].fs_locn_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].appt_date.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].p_gender.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_clinic_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].fm_pract_id.disabled=false;\t\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].confirm_yn.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pull_type.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].subBotton.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pract_id.disabled=false;\t\t\t\t\n\n\t\t\t\t</script>\t\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n<script>\n</script>\n\n</table>\n\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n<input type=\'hidden\' name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<input type=\'hidden\' name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<input type=\'hidden\' name=\'fs_locn_code\' id=\'fs_locn_code\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'fm_clinic_code\' id=\'fm_clinic_code\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'fm_pract_id\' id=\'fm_pract_id\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'to_pract_id\' id=\'to_pract_id\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'confirm_yn\' id=\'confirm_yn\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'p_counter\' id=\'p_counter\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'modify\'>\n<input type=\'hidden\' name=\'p_concat_string\' id=\'p_concat_string\' value=\'\'>\n<input type=\'hidden\' name=\'p_gender\' id=\'p_gender\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'check\' id=\'check\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\n<input type=\'hidden\' name=\'print_pulled_list\' id=\'print_pulled_list\' value=\'\'>\n<input type=\'hidden\' name=\'print_tracer_card\' id=\'print_tracer_card\' value=\'\'>\n<input type=\'hidden\' name=\'print_req_slip\' id=\'print_req_slip\' value=\'\'>\n<input type=\'hidden\' name=\'p_fs_locn_code\' id=\'p_fs_locn_code\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\'hidden\' name=\'where_cond\' id=\'where_cond\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\'hidden\' name=\'pull_type\' id=\'pull_type\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'print_bar_code\' id=\'print_bar_code\'  value=\"Y\" /> <!--Added by Dharma on Dec 23rd 2014 against HSA-SCF-0088.1 [IN:052889] -->\n\n</form>\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script LANGUAGE=\"JavaScript\">\nparent.frames[1].clearpatid();\n//parent.frames[1].document.forms[0].patient_id.value=\'\';\n//parent.frames[1].document.getElementById(\'patientid1\').onblur();\n</SCRIPT>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

	int row_count=0;
	int total_count=0;

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet pullinglistrefno= null;synchronized(session){
                pullinglistrefno=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistrefno",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistrefno==null){
                    pullinglistrefno=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistrefno",pullinglistrefno,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistremarks= null;synchronized(session){
                pullinglistremarks=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistremarks",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistremarks==null){
                    pullinglistremarks=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistremarks",pullinglistremarks,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistFileNo= null;synchronized(session){
                pullinglistFileNo=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistFileNo",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistFileNo==null){
                    pullinglistFileNo=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistFileNo",pullinglistFileNo,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet pullinglistpatientId= null;synchronized(session){
                pullinglistpatientId=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistpatientId",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistpatientId==null){
                    pullinglistpatientId=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistpatientId",pullinglistpatientId,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet pullinglistVolumeNo= null;synchronized(session){
                pullinglistVolumeNo=(webbeans.eCommon.RecordSet)pageContext.getAttribute("pullinglistVolumeNo",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(pullinglistVolumeNo==null){
                    pullinglistVolumeNo=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("pullinglistVolumeNo",pullinglistVolumeNo,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con			=	null;
	java.sql.Statement stmt			=	null;
	PreparedStatement pstmt =	null;	
	PreparedStatement pstmt1 =	null;	
	java.sql.Statement stmt_other	=	null;	
	ResultSet rs			=	null;
	ResultSet rs1			=	null;
	ResultSet rs_other_appt	=	null;
	ResultSet rset3			=	null;	
	
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
//	String addedById	= p.getProperty( "login_user" ) ;
	String other_appt= "",appt_date="",confirm_all_check="";
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		
		stmt_other	=	con.createStatement();
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		String alt_id2_type ="";
		String file_type_appl_yn ="";
		//String auto_yn="";
		boolean dis_oth_flag = false;
	
		String facility_id=(String)session.getValue("facility_id");
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i1=1;
         int reccnt=0;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 60 ; }   else {  end = Integer.parseInt( to ) ; }       
            
        String  req_start   =   "", req_end     =   "",confirm_all_dis="";
		        
	    String flagSelect		= request.getParameter("flagSelect");
		appt_date				=request.getParameter("appt_date");
		String p_gender			= request.getParameter("gender");
		String p_fm_clinic_code	= request.getParameter("fm_clinic_code");
		String p_fm_pract_id	= request.getParameter("fm_pract_id");
		String pull_type		= request.getParameter("pull_type");
		String p_to_pract_id	= request.getParameter("to_pract_id");
		String p_fs_locn_code	= request.getParameter("fs_locn_code");		
		String confirm_yn		= request.getParameter("confirm_yn");
		String check			= request.getParameter("check");
		String added_file_vol	= request.getParameter("added_file_vol"); 
		//New variable 'temp' added for SRR20056-SCF-7380.1 [IN:028088] by Venkatesh S on 09.08.2011
		String temp	= request.getParameter("temp");		
		String where_cond="";
		String patient_id1=request.getParameter("patient_id");
		String filenum=request.getParameter("filenum");
		String volume_no1=request.getParameter("volume_no");
		String  str1="";
		 String flag="false";		  
		String curr_filestatus="";
		boolean chkStatus = true;
		int OTHER_APPTS=0;
		if(appt_date==null)	
		{
			//appt_date=DateUtils.convertDate(appt_date,"DMY",localeName,"en");
			appt_date="";
		}
		
		
		if(patient_id1==null)			patient_id1="";
		if(filenum==null)			filenum="";
		if(volume_no1==null)			volume_no1="";
		if(p_gender==null)			p_gender="";
		if(pull_type==null)			pull_type="";
		if(check==null)				check="";
		if(p_fm_clinic_code==null)	p_fm_clinic_code=""; //it will show all clinics
		if(p_fm_pract_id==null)		p_fm_pract_id="";
		if(p_to_pract_id==null)		p_to_pract_id="";
		if(p_fs_locn_code==null)	p_fs_locn_code="";
		if(added_file_vol==null)	added_file_vol="";
		  
	   if(!filenum.equals("")){ 
		  str1="select curr_file_status from fm_curr_locn where patient_id='"+patient_id1+"' and curr_fs_locn_code='"+p_fs_locn_code+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";		
		  pstmt	= con.prepareStatement(str1);
		  rs		= pstmt.executeQuery();
		  if(rs != null){			  
			if(rs.next()){				
			 curr_filestatus=rs.getString("curr_file_status");
			}else{			  
			  chkStatus = false;			 
		    }
		  }	
	   }	
	   
	   if(rs!=null)	rs.close();
       if(pstmt != null) pstmt.close();
		
	
		where_cond = "where  a.facility_id=? and a.appt_date = to_date(?,'dd/mm/yyyy') and a.facility_id=b.facility_id and a.file_no=b.file_no and a.volume_no=b.volume_no";
		if(!p_fm_clinic_code.equals("")){
		  where_cond=where_cond+" and a.clinic_code = nvl(?,'!') ";
		}		
		where_cond=where_cond+" and (a.practitioner_id is null or a.practitioner_id between nvl(?,'!') and nvl(?,'~')) and ( ? is null or ? is null or a.practitioner_id is not null)and  f.gender=decode(?,'A', f.gender,?) and a.facility_id=d.facility_id AND a.src_fs_locn_code=d.src_fs_locn_code AND a.dest_fs_locn_code = d.dest_fs_locn_code and d.clinic_code = a.clinic_code and a.appt_date=d.appt_date and a.facility_id=f.facility_id(+) and a.appt_ref_no=f.appt_ref_no(+) and a.auto_track_yn = 'N' and a.pull_list_type=decode(?,'A',a.pull_list_type,?)";
         if (confirm_yn.equals("C")){ 
		   where_cond=where_cond+"AND f.appt_date = (select max(appt_date) from oa_appt_del_tr where FACILITY_ID = f.facility_id and APPT_REF_NO = f.appt_ref_no)";
		}
		 
		 String ret_status = "and fm_return_appt_status(?,?,?,?,?,a.appt_ref_no,a.patient_id)";
		
				
		if (confirm_yn.equals("C"))
			where_cond =  where_cond + ret_status + " ='C'";
		else if (confirm_yn.equals("T"))
		where_cond =  where_cond + ret_status + " ='T'";				
		else if (confirm_yn.equals("S"))
			where_cond = where_cond + ret_status + " ='S'";	
		else if (confirm_yn.equals("F"))
			where_cond = where_cond +" and (curr_facility_id != ? or b.perm_fs_locn_code != b.curr_fs_locn_code and b.curr_file_status!='T' )";
		else if (confirm_yn.equals("N")){
		    where_cond = where_cond + ret_status + " not in ('C','T','S') and A.CONFIRM_YN ='"+confirm_yn+"' and (curr_facility_id = ? or b.perm_fs_locn_code = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A')";	 
		}
		else if (confirm_yn.equals("Y")){
			where_cond = where_cond + ret_status + " not in ('C','T','S') and A.CONFIRM_YN ='Y' and (curr_facility_id =? or b.perm_fs_locn_code = b.curr_fs_locn_code) and b.curr_file_status NOT in('O','R','T','E','A')";	 
		}
			
				
			confirm_all_check="";
			confirm_all_dis="disabled";
		if(confirm_yn.equals("Y")||confirm_yn.equals("N")){
			confirm_all_dis="";
			if (flagSelect!=null)	
			check="Y";
		}
        if(check.equals("Y"))
			confirm_all_check="checked";
		 else
			confirm_all_check="";
			//String param_val ="select alt_id2_type,file_type_appl_yn from mp_param";
			String param_val ="select mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+localeName+"','1') alt_id2_type,file_type_appl_yn from mp_param";
			pstmt		=	con.prepareStatement(param_val);
			rset3 = pstmt.executeQuery();
			rset3.next();
			alt_id2_type = rset3.getString(1);
			file_type_appl_yn = rset3.getString(2);
			if(alt_id2_type == null || alt_id2_type.equals("null"))alt_id2_type="";			
			if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))file_type_appl_yn ="";

			if(rset3 != null) rset3.close();
			if(pstmt != null) pstmt.close();
			
		if(flagSelect !=null)
		{
		 if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
			{
			pullinglistrefno.clearAll();
			pullinglistremarks.clearAll();
			pullinglistFileNo.clearAll();
			pullinglistpatientId.clearAll();
			pullinglistVolumeNo.clearAll();
		 	confirm_all_check="checked";
			StringBuffer rePopulate = null;
			StringBuffer rePopulate1 = null;
			rePopulate				 = new StringBuffer();
			rePopulate1				 = new StringBuffer();
			//rePopulate.append("select patient_id,file_no,volume_no,appt_ref_no, remarks from fm_pulling_list where facility_id = ? and appt_date= to_date(?,'dd/mm/yyyy') and clinic_code =nvl(?,'!')  and (practitioner_id is null or practitioner_id between nvl(?,'!') and nvl(?,'~')) and (? is null or ? is null or practitioner_id is not null)and src_fs_locn_code=? and confirm_yn = ? and pull_list_type = decode(?,'A',pull_list_type,?)");
			rePopulate.append("SELECT a.patient_id, a.file_no, a.volume_no, appt_ref_no, a.remarks FROM fm_pulling_list a,fm_curr_locn b WHERE a.facility_id = ? AND appt_date = TO_DATE (?,'dd/mm/yyyy') ");
			if(!p_fm_clinic_code.equals("")){
				rePopulate.append("and a.clinic_code =nvl(?,'!') ");
			}
			rePopulate.append(" AND (   a.practitioner_id IS NULL OR a.practitioner_id BETWEEN NVL(?,'!') AND NVL (?,'~')) and (? is null or ? is null or a.practitioner_id is not null) and a.src_fs_locn_code=? and a.confirm_yn = ? and a.pull_list_type = decode(?,'A',a.pull_list_type,?)");		
		
			if (!p_gender.equals("A"))
			rePopulate.append(" and a.patient_id in (select patient_id from mp_patient where sex = decode(?,'A',sex,?)) ");
		rePopulate1=rePopulate;
	/*	if(!patient_id1.equals("") && !filenum.equals("") && !volume_no1.equals("") )
				{
		rePopulate1.append(" and patient_id ='"+patient_id1+"'  and file_no='"+filenum+"' and volume_no='"+volume_no1+"' ");
				} */
			
			if(!added_file_vol.equals(""))
			{  //New condition added for SRR20056-SCF-7380.1 [IN:028088] by Venkatesh S on 09.08.2011
				if(!added_file_vol.equals(temp)){					
					rePopulate1.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+temp+")  ");
				}else{ 
					rePopulate.append(" and (a.FILE_NO,a.VOLUME_NO,a.patient_id) IN ("+added_file_vol+")  ");
			    }
			}
	
			rePopulate1.append(" and a.patient_id=b.patient_id and b.curr_file_status = 'I'"); //included for the SCF - SKR-SCF-0498 32707 
			
			pstmt		=	con.prepareStatement(rePopulate.toString());
  			pstmt1		=	con.prepareStatement(rePopulate1.toString());
			int pstcnt = 0;
			int pstcnt2 = 0;
			
			pstmt.setString(++pstcnt,facility_id);
			pstmt.setString(++pstcnt,appt_date);
			pstmt1.setString(++pstcnt2,facility_id);
			pstmt1.setString(++pstcnt2,appt_date);
			if(!p_fm_clinic_code.equals(""))
			{
			pstmt.setString(++pstcnt,p_fm_clinic_code);
			pstmt1.setString(++pstcnt2,p_fm_clinic_code);
			}
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fm_pract_id);
			pstmt.setString(++pstcnt,p_to_pract_id);
			pstmt.setString(++pstcnt,p_fs_locn_code);
			pstmt.setString(++pstcnt,confirm_yn);
			pstmt.setString(++pstcnt,pull_type);
			pstmt.setString(++pstcnt,pull_type);
			
			pstmt1.setString(++pstcnt2,p_fm_pract_id);
			pstmt1.setString(++pstcnt2,p_to_pract_id);
			pstmt1.setString(++pstcnt2,p_fm_pract_id);
			pstmt1.setString(++pstcnt2,p_to_pract_id);
			pstmt1.setString(++pstcnt2,p_fs_locn_code);
			pstmt1.setString(++pstcnt2,confirm_yn);
			pstmt1.setString(++pstcnt2,pull_type);
			pstmt1.setString(++pstcnt2,pull_type);
			if (!p_gender.equals("A"))
				{
				pstmt.setString(++pstcnt,p_gender);
				pstmt.setString(++pstcnt,p_gender);
				
				pstmt1.setString(++pstcnt2,p_gender);
				pstmt1.setString(++pstcnt2,p_gender);
				}
			rset3 = pstmt.executeQuery();
			
			if(!patient_id1.equals("")){
				rs1=pstmt1.executeQuery();
				if(rs1 !=null){
				 while(rs1.next()){
				   reccnt++;
				 }
				}				
 
			if((reccnt==0 && !patient_id1.equals("")) || chkStatus == false ){
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.getElementById('patientid1').onblur();parent.frames[0].document.forms[0].patient_id.focus();</script>"); //this line modified for this incident [IN:044324]
				 flag="true"	;
			   }
			}			
			
			String remarks1 ="";
					
			if(rset3 !=null){
			  while(rset3.next()){
				pullinglistrefno.putObject(rset3.getString("appt_ref_no"));
				pullinglistFileNo.putObject(rset3.getString("file_no"));	pullinglistVolumeNo.putObject(rset3.getString("volume_no"));pullinglistpatientId.putObject(rset3.getString("patient_id"));
				remarks1 = rset3.getString("remarks");
				if(remarks1 == null) remarks1="";
				  pullinglistremarks.putObject(remarks1);
			  }
			}
			if(pstmt !=null) pstmt.close();
			}
	     }
		req_start       =   (request.getParameter("start")==null)   ?   "1" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
        if(from != null && to != null)
        {
                int j=0;
                for( i1=(Integer.parseInt(req_start)); i1<=(Integer.parseInt(req_end)); i1++)
                {
					if(request.getParameter("pull_yn"+(i1)) != null)
                    {
                        String checkedApptRefNo = request.getParameter("p_appt_ref_no"+(i1));
                        String checkedRemarks=request.getParameter("p_remarks"+(i1));
                        String checkedFileNo=request.getParameter("p_file_no"+(i1));
						String checkedVolumeNo=request.getParameter("p_volume_no"+(i1));
                        String checkedPatientID=request.getParameter("p_patient_id"+(i1));
                      //  String Appt_Time=request.getParameter("p_remarks"+(i1));
                        if(checkedRemarks == null) checkedRemarks="";
                        if(!(pullinglistrefno.containsObject(checkedApptRefNo))) { 
                            pullinglistrefno.putObject(checkedApptRefNo);
                            pullinglistremarks.putObject(checkedRemarks);
                            pullinglistFileNo.putObject(checkedFileNo);
							pullinglistVolumeNo.putObject(checkedVolumeNo);
                            pullinglistpatientId.putObject(checkedPatientID);
                            }
                        j++;
                    }
                }       
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
        }
        i1 = 1 ;
        int recordCount = 0;
        recordCount =	pullinglistrefno.getSize();

		int fm_disp=0, to_disp=0;
		
		String file_no="", patient_id="",tblrow_id="",classValue="";
	//	String pull_yn="N",file_pull_yn="N",file_pulled_color="";
		String pat_details="",	clinic_desc="", clinic_code="", fs_locn_code="",curr_file_status="",pull_yn_prop="";
		String fs_locn_desc="", practitioner_name="", practitioner_id="", result_query="";
		String curr_fs_locn_code="", curr_facility_id="",curr_file_status1="",curr_fs_locn_short_desc="";
		String pull_list_type="",appt_status="",file_creation_date="",remarks="";
		String appt_status_color="",alt_id2_no="",sex="",appt_ref_no="",file_pulled_yn="";
		String file_type_code="";
		String file_type_desc="";
		String volume_no = "";
	//	String login_id		=	(String)session.getValue("login_user");
		String mode			=	request.getParameter("mode") ;
		String appl_user_id		= request.getParameter("appl_user_id");
		String p_dflt_remarks	= "",mr_pat_fs_locn_code="" ,appt_time="";
		String p_group_by_clause = "",appt_status_checked="";
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
		String start_time		 = (request.getParameter("start_time")==null || request.getParameter("start_time")=="")?"":request.getParameter("start_time");
		String end_time			 = (request.getParameter("end_time")==null || request.getParameter("end_time")=="")?"":request.getParameter("end_time");
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		
		
		if(mode == null || mode.equals("null")) mode="";
		if(appl_user_id == null || appl_user_id.equals("null")) mode="";
		if (p_fm_clinic_code==null) p_fm_clinic_code="";
		if (p_fm_pract_id==null) p_fm_pract_id="";
		if (p_to_pract_id==null) p_to_pract_id="";
		if ( to == null )
	  		end = 60 ;
		else
			end = Integer.parseInt( to ) ;

	//	String client_ip_address=addedById;
		//result_query = "select long_desc from fm_parameter a,fm_narration b where a.facility_id='"+facility_id+"' and a.dflt_narr_code_for_auto_track = b.narration_code";
		result_query = "SELECT Long_desc FROM fm_Parameter a,  fm_narration_lang_vw b WHERE a.Facility_Id = '"+facility_id+"'  AND LANGUAGE_ID='"+localeName+"'  AND a.dflt_narr_Code_For_Auto_Track = b.Narration_Code";

		rs = stmt.executeQuery(result_query);
		result_query="";
       
		while (rs.next())
		{
			p_dflt_remarks = rs.getString("long_desc");
		}
		if(rs != null) rs.close();
		if(mode.equals(""))
		{
		//result_query="select to_char(f.appt_time,'hh24:mi') appt_time,a.file_no,a.FILE_TYPE_CODE,a.FILE_TYPE_DESC,a.VOLUME_NO, a.patient_id, to_char(b.added_date,'dd/mm/rrrr') file_creation_date, a.clinic_desc, a.clinic_code, a.src_fs_locn_code, a.DEST_FS_LOCN_DESC src_fs_locn_desc, nvl(a.practitioner_name,'Not Identified') practitioner_name	 , a.practitioner_id, f.patient_name pat_details/*get_patient_line(a.patient_id) pat_details*/ , decode(b.curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived', 'O', 'Outside', 'R', 'Returned' ) curr_file_status,curr_file_status curr_file_status1,b.curr_fs_locn_code,b.curr_facility_id,g.short_desc || '<br>&nbsp;&nbsp;&nbsp;' || '(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') || ')' curr_fs_locn_short_desc, a.pull_list_type,a.remarks,f.alt_id2_no,decode(f.gender,'M','Male','F','Female','Unknown')sex,a.appt_ref_no,a.pulled_file_status file_pulled_yn,(case when a.appt_date=to_date(?,'dd/mm/yyyy') then 'Y' else 'N' end)appt_status_checked,b.perm_fs_locn_code mr_pat_fs_locn_code from fm_pulling_list_vw a,fm_curr_locn b,fm_pulling_list_ctl d,op_clinic e,oa_appt f,fm_storage_locn g  ";			
		result_query = "SELECT"
					  +"  TO_CHAR(f.appt_Time,'hh24:mi') appt_Time"
					  +"  , a.File_No"
					  +"  , a.FILE_TYPE_CODE"
					  +"  , mr_get_desc.MR_FILE_TYPE('"+facility_id+"',a.FILE_TYPE_CODE,'"+localeName+"',2) FILE_TYPE_DESC"
					  +"  , a.VOLUME_NO"
					  +"  , a.Patient_Id"
					  +"  , TO_CHAR(b.Added_Date,'dd/mm/rrrr') File_Creation_Date"
					  +"  , op_Get_desc.OP_CLINIC('"+facility_id+"',a.Clinic_Code,'"+localeName+"',1) clinic_desc"
					  +"  , a.Clinic_Code"
					  +"  , a.src_fs_Locn_Code"
					  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.src_fs_Locn_Code,'"+localeName+"',2) src_fs_Locn_desc"
					  +"  , Nvl((AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+localeName+"','1')),'Not Identified') Practitioner_Name"
					  +"  , a.Practitioner_Id"
					  +"  , decode('"+localeName+"', 'en', f.patient_name, nvl(f.patient_name_loc_lang, f.patient_name)) Pat_Details"
					  +"  , b.Curr_File_Status Curr_File_Status"
					  +"  , B.Curr_File_Status Curr_File_Status1"
					  +"  , b.Curr_fs_Locn_Code"
					  +"  , b.Curr_Facility_Id"
					  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',b.curr_fs_locn_code,'"+localeName+"',2) ||'&nbsp;' ||'(' || decode(b.curr_fs_locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit','X','External') ||')' Curr_fs_Locn_Short_desc"
					  +"  , a.Pull_List_Type"
					  +"  , a.Remarks"
					  +"  , f.alt_Id2_No"
					  +"  , f.Gender Sex"
					  +"  , a.appt_ref_No"
					  +"  , a.CONFIRM_YN File_Pulled_yn"
					  +"  , ("
					  +"  CASE "
					  +"  WHEN a.appt_Date = TO_DATE(sysdate,'dd/mm/yyyy') "
					  +"  THEN"
					  +"    'Y' "
					  +"  ELSE 'N' "
					  +"  END) appt_Status_Checked"
					  +"  , b.Perm_fs_Locn_Code mr_Pat_fs_Locn_Code  "
					 +"  ,  (SELECT COUNT (1) FROM fm_pulling_list B  WHERE B.facility_id =     A.FACILITY_ID AND TRUNC(B.appt_date) = TRUNC(A.APPT_DATE) 	 AND    B.patient_id = a.patient_id) OTHER_APPTS "
					
					  +"FROM"
					  +"  fm_PullIng_List a"
					  +"  , fm_Curr_Locn b"
					  +"  , fm_PullIng_List_ctl d";

		//Modified above result_query by Thamizh selvi on 17th Jan 2018 against ML-MMOH-CRF-0933 
		if ( confirm_yn.equals("C") || confirm_yn.equals("S") )
			result_query =  result_query + " , OA_APPT_DEL_TR f ";		
		else 
			result_query =  result_query + " , oa_appt f ";					  
			
		result_query = result_query + where_cond;
		if(!added_file_vol.equals(""))
				result_query=result_query+" and (b.FILE_NO,b.VOLUME_NO,a.patient_id) IN ("+added_file_vol+")  ";
		
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
		if(!start_time.equals("") && !end_time.equals("")){
			String start_time_number	= start_time.replace(":", "");
			String end_time_number		= end_time.replace(":", "");
			result_query	= result_query + "and to_number(to_char(a.appt_time,'hh24mi'))  between "+start_time_number+" and "+end_time_number+"";
		}
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		
		result_query =result_query +  " order by a.clinic_code,a.practitioner_id,sex, b.terminal_digit, b.TERMINAL_DIGIT_GRP1, b.TERMINAL_DIGIT_GRP2, b.TERMINAL_DIGIT_GRP3, a.file_no, appt_time";


		try{
			pstmt		=	con.prepareStatement(result_query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			/*pstmt.setString(1,appt_date);
            pstmt.setString(2,facility_id);
            pstmt.setString(3,appt_date);
            pstmt.setString(4,p_fm_clinic_code);
            pstmt.setString(5,p_fm_pract_id);
            pstmt.setString(6,p_to_pract_id);
            pstmt.setString(7,p_fm_pract_id);
            pstmt.setString(8,p_to_pract_id);
			pstmt.setString(9,p_gender);
            pstmt.setString(10,p_gender);
            pstmt.setString(11,pull_type);
            pstmt.setString(12,pull_type);
			out.println("confirm_yn"+confirm_yn);
			if (confirm_yn.equals("F"))
			{
            pstmt.setString(13,facility_id);
			}
            else
			{
			pstmt.setString(13,facility_id);
            pstmt.setString(14,p_fs_locn_code);
            pstmt.setString(15,appt_date);
			pstmt.setString(16,p_fm_clinic_code);
			pstmt.setString(17,p_fm_clinic_code);
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(18,facility_id);
			}*/
          /*  pstmt.setString(1,facility_id);
            pstmt.setString(2,appt_date);
            pstmt.setString(3,p_fm_clinic_code);
            pstmt.setString(4,p_fm_pract_id);
            pstmt.setString(5,p_to_pract_id);
            pstmt.setString(6,p_fm_pract_id);
            pstmt.setString(7,p_to_pract_id);
			pstmt.setString(8,p_gender);
            pstmt.setString(9,p_gender);
            pstmt.setString(10,pull_type);
            pstmt.setString(11,pull_type);
			if (confirm_yn.equals("F"))
			{
            pstmt.setString(12,facility_id);
			}
            else
			{
			pstmt.setString(12,facility_id);
            pstmt.setString(13,p_fs_locn_code);
            pstmt.setString(14,appt_date);
			pstmt.setString(15,p_fm_clinic_code);
			pstmt.setString(16,p_fm_clinic_code);
			if (confirm_yn.equals("Y")||confirm_yn.equals("N"))
            pstmt.setString(17,facility_id);
			}*/


				
			int pstcnt1 = 0;

			pstmt.setString(++pstcnt1,facility_id);
            pstmt.setString(++pstcnt1,appt_date);
			if(!p_fm_clinic_code.equals(""))
			{
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
			}
            pstmt.setString(++pstcnt1,p_fm_pract_id);
            pstmt.setString(++pstcnt1,p_to_pract_id);
            pstmt.setString(++pstcnt1,p_fm_pract_id);
            pstmt.setString(++pstcnt1,p_to_pract_id);
			pstmt.setString(++pstcnt1,p_gender);
            pstmt.setString(++pstcnt1,p_gender);
            pstmt.setString(++pstcnt1,pull_type);
            pstmt.setString(++pstcnt1,pull_type);
			if (confirm_yn.equals("F"))
			{
				pstmt.setString(++pstcnt1,facility_id);
			}
            else
			{
				pstmt.setString(++pstcnt1,facility_id);
				pstmt.setString(++pstcnt1,p_fs_locn_code);
				pstmt.setString(++pstcnt1,appt_date);
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
				pstmt.setString(++pstcnt1,p_fm_clinic_code);
				if (confirm_yn.equals("Y")||confirm_yn.equals("N")){
					pstmt.setString(++pstcnt1,facility_id);
				}
			}
			
			rs=pstmt.executeQuery();
			rs.beforeFirst();
			rs.last();
			maxRecord = rs.getRow();
			rs.beforeFirst();



		if(maxRecord == 0 && !curr_filestatus.equals("L") && flag.equals("false"))
  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[0].document.forms[0].flag.value='true'; parent.frames[0].document.forms[0].patient_id.value='';parent.frames[0].document.getElementById('patientid1').onblur();parent.frames[0].document.forms[0].patient_id.focus();</script>"); //this line modified for this incident [IN:044324]
	
		}catch(Exception e){out.println(e);
		e.printStackTrace();}


			int p_counter = 1,i = 1;
			String p_next_group_by_clause = "";
			
            _bw.write(_wl_block9Bytes, _wl_block9);

					if ( !(start <= 1)) {
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					if ( !((start+10) > maxRecord )){
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
				
            _bw.write(_wl_block14Bytes, _wl_block14);

			if(maxRecord != 0)	
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

				if(file_type_appl_yn.equals("Y"))
				{
				
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					}else{
					
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

					}
					
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alt_id2_type));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(confirm_all_check));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(confirm_all_dis));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
		 
            _bw.write(_wl_block1Bytes, _wl_block1);

	if(rs !=null)
	{
		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
		  }
		}		
		while(rs.next()&&i<=end )
				{					
					file_no				=	rs.getString("file_no");
					file_type_code		=	rs.getString("FILE_TYPE_CODE");
					file_type_desc		=	rs.getString("FILE_TYPE_DESC");
					volume_no			=	rs.getString("VOLUME_NO");
					patient_id			=	rs.getString("patient_id");
					clinic_desc			=	rs.getString("clinic_desc");
					clinic_code			=	rs.getString("clinic_code");
					fs_locn_code		=	rs.getString("src_fs_locn_code");
					fs_locn_desc		=	rs.getString("src_fs_locn_desc");
					practitioner_name	=	rs.getString("practitioner_name");
					practitioner_id		=	rs.getString("practitioner_id");
					curr_file_status	=	rs.getString("curr_file_status");
					curr_file_status1	=	rs.getString("curr_file_status1");
					pat_details			=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length());
					curr_fs_locn_code	=	rs.getString("curr_fs_locn_code");
					curr_facility_id	=	rs.getString("curr_facility_id");
					curr_fs_locn_short_desc = rs.getString("curr_fs_locn_short_desc");
					pull_list_type		=	rs.getString("pull_list_type");
					file_creation_date	=	rs.getString("file_creation_date");
					remarks				=	rs.getString("remarks");
					alt_id2_no			=	rs.getString("alt_id2_no");
					sex					=	rs.getString("sex");
					appt_ref_no			=	rs.getString("appt_ref_no");
					file_pulled_yn		=	rs.getString("file_pulled_yn");					
					appt_status_checked	=   rs.getString("appt_status_checked");
					mr_pat_fs_locn_code	=	rs.getString("mr_pat_fs_locn_code");
					appt_time			=	rs.getString("appt_time");
                   OTHER_APPTS  =	rs.getInt("OTHER_APPTS");
			   // String   appt_Date  =appt_time			=	rs.getString("appt_Date");
			  					
					if(file_no == null || file_no.equals("null"))file_no="";
					if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
					if(file_type_desc == null || file_type_desc.equals("null"))file_type_desc="";
					if(volume_no == null || volume_no.equals("null"))volume_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(clinic_desc == null || clinic_desc.equals("null"))clinic_desc="";				if(clinic_code == null || clinic_code.equals("null"))clinic_code="";
					if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
					if(fs_locn_desc == null || fs_locn_desc.equals("null"))fs_locn_desc="";
					if(practitioner_name == null || practitioner_name.equals("null"))practitioner_name="";
					if(practitioner_id == null || practitioner_id.equals("null"))practitioner_id="";
					if(pat_details == null || pat_details.equals("null"))pat_details="";
					if(curr_file_status == null || curr_file_status.equals("null"))curr_file_status="";
					if(curr_file_status1 == null || curr_file_status1.equals("null"))curr_file_status1="";
					if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null"))curr_fs_locn_code="";
					if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";
					if(curr_fs_locn_short_desc == null || curr_fs_locn_short_desc.equals("null"))curr_fs_locn_short_desc="";
					if(pull_list_type == null || pull_list_type.equals("null"))pull_list_type="";
					if(file_creation_date!=null)	
					{
						file_creation_date=DateUtils.convertDate(file_creation_date,"DMY","en",localeName);
					}
					else
						file_creation_date="";

					if(remarks == null || remarks.equals("null"))remarks=p_dflt_remarks;
					if(alt_id2_no == null || alt_id2_no.equals("null"))alt_id2_no="";
					if(sex == null || sex.equals("null"))sex="";
					if(appt_ref_no == null || appt_ref_no.equals("null"))appt_ref_no="";
					if(file_pulled_yn == null || file_pulled_yn.equals("null"))file_pulled_yn="";
					if(appt_status_checked == null || appt_status_checked.equals("null"))appt_status_checked="";
					if(mr_pat_fs_locn_code == null || mr_pat_fs_locn_code.equals("null"))mr_pat_fs_locn_code="";
					if(appt_time == null || appt_time.equals("null"))appt_time="";
					
					if(!sex.equals(""))
					{
						switch(sex.charAt(0))
						{
							case 'M' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); break;

							case 'F' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); break;

							default : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							
					
						}
					}
					
					if (confirm_yn.equals("Y")||confirm_yn.equals("N") && (OTHER_APPTS>1))
					{
					//String sql_other_appt ="select b.short_desc  clinic,nvl(c.practitioner_name,'Not Identified')practitioner_name,to_char(a.appt_time,'hh24:mi') appt_time,sign(TO_DATE(TO_CHAR(a.appt_time, 'hh24:mi'), 'hh24:mi')-to_date('"+appt_time+"','hh24:mi')) diff from fm_pulling_list a, op_clinic b, am_practitioner c where a.facility_id     = b.facility_id and a.clinic_code = b.clinic_code and a.practitioner_id = c.practitioner_id(+) and a.facility_id='"+facility_id+"' and trunc(appt_date)= to_date('"+appt_date+"','dd/mm/yyyy') and a.patient_id = '"+patient_id+"' and a.appt_ref_no != '"+appt_ref_no+"' order by appt_time";
					
					String sql_other_appt = "SELECT"
								  +"  OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+localeName+"','1') Clinic"
								  +"  , Nvl((AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+localeName+"','1')),'Not Identified') Practitioner_Name"
								  +"  , TO_CHAR(a.appt_Time,'hh24:mi') appt_Time"
								  +"  , Sign(TO_DATE(TO_CHAR(a.appt_Time,'hh24:mi'),'hh24:mi') - TO_DATE('"+appt_time+"','hh24:mi')) dIff "
								  +"FROM"
								  +"  fm_PullIng_List a "
								  +"WHERE a.facility_id='"+facility_id+"' "
								  +"  AND trunc(A.appt_date)= TO_DATE('"+appt_date+"','dd/mm/yyyy') "
								  +"  AND a.patient_id = '"+patient_id+"' "
								  +"  AND a.appt_ref_no != '"+appt_ref_no+"' "
								  +"ORDER BY"
								  +"  appt_time";
		  
					rs_other_appt = stmt_other.executeQuery(sql_other_appt);
					other_appt = "";
					dis_oth_flag=false;
					pull_yn_prop="";
					while(rs_other_appt!=null&&rs_other_appt.next())
					{
                    String oth_clinic     = rs_other_appt.getString(1);
					if(oth_clinic == null || oth_clinic.equals("null"))oth_clinic="";
					String oth_pract_name = rs_other_appt.getString(2);
					if(oth_pract_name == null || oth_pract_name.equals("null"))oth_pract_name="";
					String oth_appt_time  = rs_other_appt.getString(3);
					if(oth_appt_time == null || oth_appt_time.equals("null"))oth_appt_time="";
					int  diff  = rs_other_appt.getInt(4);					
					
					if ((diff<0) && (!dis_oth_flag))
						dis_oth_flag = true;
					other_appt = other_appt + "&nbsp;&nbsp;&nbsp;&nbsp;"+oth_clinic+" / "+oth_pract_name +" - "+oth_appt_time;
					other_appt = other_appt +  "<br>";
					}						
					
					
					if(rs_other_appt != null) rs_other_appt.close();
					} else {						
						//Added the below code for SRR20056-SCF-6482 [IN:025931] by Suresh M on 18.01.2001 
						other_appt = "";
						dis_oth_flag=false;
					}
		     classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		   String remarks_bean ="";		   
			if(pullinglistrefno.containsObject(appt_ref_no)) 
					{                   
					file_pulled_yn = "CHECKED";
					}
			else
			file_pulled_yn="";
			int recordIndex = pullinglistrefno.indexOfObject(appt_ref_no);
			if(recordIndex!=-1)
			{
			if(file_pulled_yn.equals("CHECKED")) 
				{ 
				pullinglistrefno.removeObject(recordIndex);
				pullinglistFileNo.removeObject(recordIndex);
				pullinglistVolumeNo.removeObject(recordIndex);
				pullinglistpatientId.removeObject(recordIndex);
			    remarks_bean=(String)pullinglistremarks.getObject(recordIndex);
				if (remarks_bean=="")remarks_bean=remarks;
				if (!remarks_bean.equals(remarks))
				remarks = remarks_bean;
				pullinglistremarks.removeObject(recordIndex);                            
				}
			}
		    appt_status="";			
			if (dis_oth_flag) {
			pull_yn_prop="disabled";
			file_pulled_yn="";
			}
			else
			{
				pull_yn_prop="";
				file_pulled_yn="CHECKED";
			}			
			
	  	if (confirm_yn.equals("C"))
		{
			pull_yn_prop="disabled";
			appt_status_color="#FF0066";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("S"))
		{
			pull_yn_prop="disabled";
			appt_status_color="FF9999";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("T"))
		{
			pull_yn_prop="disabled";
			appt_status_color="#FF66FF";
			file_pulled_yn="";
		}
		else if (confirm_yn.equals("Y"))
		{
		    appt_status_color = "SkyBlue";
		}
        else
		{
			appt_status_color = "";
		}
		if (facility_id.equals(curr_facility_id) && mr_pat_fs_locn_code.equals(curr_fs_locn_code) && !curr_file_status1.equals("T"))
		{

		}
		else
		{
		 if (confirm_yn.equals("F"))          
			{
			file_pulled_yn="";
			pull_yn_prop="disabled";
			appt_status_color="lightgreen";
			appt_status="X";					
			}
		}


			tblrow_id	=	"tblrow_id"+i;
			p_next_group_by_clause = clinic_desc + " / " + practitioner_name + " / " + sex;
		if (p_counter==0)
		{
			p_group_by_clause	= clinic_desc + " / " + practitioner_name + " / " + sex;

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_group_by_clause));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
        else if (!p_group_by_clause.equals(p_next_group_by_clause))
            {

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_next_group_by_clause));
            _bw.write(_wl_block30Bytes, _wl_block30);

            }
			p_group_by_clause = p_next_group_by_clause ;
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);

			if(file_type_appl_yn.equals("N") ){
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((file_no.equals(""))?"&nbsp;":file_no)));
            _bw.write(_wl_block35Bytes, _wl_block35);

			}
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((patient_id.equals(""))?"&nbsp;":patient_id)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(((pat_details.equals(""))?"&nbsp;":pat_details)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i% id=p_file_no<%=i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i% id=p_appt_ref_no<%=i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i% id=p_patient_id<%=i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i% id=p_volume_no<%=i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);

			if(file_type_appl_yn.equals("Y") && !file_type_code.equals("")){
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(((file_type_code.equals(""))?"&nbsp;":file_type_desc)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(((volume_no.equals(""))?"&nbsp;":volume_no)));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}else{
				
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(((volume_no.equals(""))?"&nbsp;":volume_no)));
            _bw.write(_wl_block47Bytes, _wl_block47);

			}
			
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((appt_time.equals(""))?"&nbsp;":appt_time)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(((file_creation_date.equals(""))?"&nbsp;":file_creation_date)));
            _bw.write(_wl_block51Bytes, _wl_block51);

			if (confirm_yn.equals("C") || confirm_yn.equals("S") || appt_status.equals("X") || confirm_yn.equals("T")||dis_oth_flag)
			{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i% id=p_remarks<%=i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);

			}
			else if (appt_status.equals("W") && appt_status_checked.equals("Y"))
			{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(remarks)));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i% id=p_remarks<%=i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);
	
			}
			else if (appt_status.equals("W") && appt_status_checked.equals("N"))
			{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i% id=p_remarks<%=i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);
	
			}
			else
			{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(java.net.URLEncoder.encode(remarks)));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i% id=p_remarks<%=i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);
	
			}
		
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(((alt_id2_no.equals(""))?"&nbsp;":alt_id2_no)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(((curr_fs_locn_short_desc.equals(""))?"&nbsp;":curr_fs_locn_short_desc)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(appt_status_color));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(file_pulled_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pull_yn_prop));
            _bw.write(_wl_block70Bytes, _wl_block70);

				
           if (!other_appt.equals(""))
			{
			
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(other_appt));
            _bw.write(_wl_block72Bytes, _wl_block72);

			}
			p_counter++;
					i++;
				}
				total_count = p_counter;

            _bw.write(_wl_block73Bytes, _wl_block73);

			}
			if(rs != null) rs.close();
			if (p_counter==0 && !curr_filestatus.equals("L"))
			{
				//String	msg1="APP-FM0061 No records found";				
			
            _bw.write(_wl_block74Bytes, _wl_block74);

			}
if (curr_filestatus.equals("L"))
			{
				//String	msg1="APP-FM0061 No records found";				
			
            _bw.write(_wl_block75Bytes, _wl_block75);
	
			}
	}


            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(start));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(end));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(start));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(end));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(appl_user_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(p_gender));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(p_fm_clinic_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(p_fm_pract_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(p_to_pract_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(confirm_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(total_count));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(p_gender));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(check));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(p_fs_locn_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(appl_user_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(java.net.URLEncoder.encode(where_cond)));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(pull_type));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block99Bytes, _wl_block99);

if(rset3 != null) rset3.close();
if(rs1 != null) rs1.close();
if(stmt != null) stmt.close();
if(pstmt1 != null) pstmt1.close();
if(pstmt != null) pstmt.close();
if(stmt_other != null) stmt_other.close();
if(rs_other_appt != null) rs_other_appt.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
	session.setAttribute("pullinglistrefno", pullinglistrefno);
	session.setAttribute("pullinglistremarks", pullinglistremarks);
	session.setAttribute("pullinglistFileNo", pullinglistFileNo);
	session.setAttribute("pullinglistVolumeNo", pullinglistVolumeNo);
	session.setAttribute("pullinglistpatientId", pullinglistpatientId);
}

            _bw.write(_wl_block100Bytes, _wl_block100);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileTypeVolumeNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filecreated.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueRemarks.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EnterRemarks.label", java.lang.String .class,"key"));
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
}
