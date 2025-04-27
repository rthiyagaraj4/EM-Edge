package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __phviewfilllistall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PHViewFillListAll.jsp", 1709121161085L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\t<HEAD>\n\t\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IPFillAll.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</HEAD>\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </title>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<!-- <script>alert(\"User is not a Pharmacist!!!\");window.location.href =\n\'../../eCommon/jsp/dmenu.jsp\'</script> -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<!-- <script>alert(\"This facility cannot be accessed from this workstation!!!\");window.location.href =\n\'../../eCommon/jsp/dmenu.jsp\'</script> -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<FORM name=\"formPHViewFillList\" id=\"formPHViewFillList\"  TARGET=\"messageFrame\" >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<TABLE  ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\" width=\"100%\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"checkbox\" name=\"select_all\" id=\"select_all\" onclick=\"checkAll(this);\" value=\"Y\" checked></td>\n\t\t\t\t\t</tr>\n\t\t\t\t<table>\n\t\t\t\t<TABLE  ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\" width=\"100%\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<th COLSPAN=\"10\" align=\"left\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<th height=\"1\" COLSPAN=\"10\" align=\"left\"></th>\n\t\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" width = \"27%\">\n\t\t\t\t\t\t<font size=\"1\" style=\"cursor:pointer;color:blue\" title=\"Drug Profile\" onclick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\"> <label id=\'pat_id\' style=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp</label>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</TD><!--added <label id=\'pat_id\' for MMS-DM-CRF-0011 [IN:055302] -->\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"left\" width = \"10%\"><font size=\"1\" style=\"font-weight:bold\" title=\"View Order\" nowrap>&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\">&nbsp;</TD>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"left\" width = \"22%\"><font size=\"1\" style=\"cursor:pointer;color:blue\" title=\"View Order\"onClick=\"callMenuFunctions(\'View\',\'Pharmacy\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<label id=\'dose_dtl\' style=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' ><br>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</label></TD><!--added <label id=\'dose_dtl\' for MMS-DM-CRF-0011 [IN:055302] -->\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" width=\"3%\" ALIGN=\"right\"><font size=\"1\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</TD>\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" width=\"4%\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" nowrap>\n\t\t\t\t\t\t<font size=\"1\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;</TD>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" >&nbsp;</TD>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" align=\"left\" nowrap style=\"cursor:pointer\">&nbsp;<img src=\'../../ePH/images/altenate.jpg\' height=\'15\' width=\'15\' align=\'top\' onclick=\"altDrugSearch(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">\n\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"drug_code_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ord_drug_code_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"ord_drug_code_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"end_date_time_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"end_date_time_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"left\" width = \"18%\"  ><font size=\"1\" color=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\t\t\t<label id=\"disp_drug_id_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"disp_drug_name_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label>\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;<a href=\"javascript:openAltDrugRemarks(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'LINK\');\" id=\"alt_drug_remarks";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" style=\"display:none\" title=\"Alternate Drug Remarks\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a><img  style=\"display:none\"  id=\"alt_remarks_image_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" src=\"../../eCommon/images/mandatory.gif\"></img></label>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"center\" nowrap><font size=\"1\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" nowrap><font size=\"1\" style=\"\" title=\"Batch Details\" onclick=\"showBatchDetails(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" ><label id=\"disp_qty_id_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" name=\"disp_qty_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</label>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"stock_yn";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"stock_yn";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\'N\'>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" nowrap><font size=\"1\"  style=\"cursor:pointer;color:blue\" title=\"Batch Details\" onclick=\"showBatchDetails(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\'Y\'>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t&nbsp;<label id=\"disp_qty_uom_id_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" name=\"disp_qty_uom_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</label>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_batch_dtl_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"disp_batch_dtl_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_uom_id_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"disp_uom_id_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t checktwo(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\',";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =");\n\t\t\t\t\t\t\t\t </script>  \n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"checkbox\" name=\"ip_fill_chk_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"ip_fill_chk_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" onclick=\"checkOne(this,\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\')\"></TD>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="      \n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"checkbox\" name=\"ip_fill_inculde_report_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"ip_fill_inculde_report_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"Y\"  checked style =\"visibility:hidden\"></TD>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"checkbox\" name=\"ip_fill_inculde_report_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" value=\"N\" style =\"visibility:hidden\" ></TD>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"order_id_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"order_line_num_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"   value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_choice_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"drug_choice_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"patient_id";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"check_box_checked_yn_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"check_box_checked_yn_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"   value=\"Y\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"iv_prep_yn_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"iv_prep_yn_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\t checktwo(";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =",";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =");\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t<th height=\"1\" COLSPAN=\"10\" align=\"left\"></th>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\twindow.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\tVALUE=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\"\tVALUE=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"total_drugs\" id=\"total_drugs\"\tVALUE=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"store_code\" id=\"store_code\"\tVALUE=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"unalloc_record_cnt\" id=\"unalloc_record_cnt\"\tVALUE=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Proc_Type\" id=\"Proc_Type\"\tVALUE=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"userAuthPINYN\" id=\"userAuthPINYN\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">  <!-- Added for RUT-CRF-0035 [IN029926] -->\n\t\t\t<INPUT TYPE=\"hidden\" name=\"alt_drug_remarks_ind\" id=\"alt_drug_remarks_ind\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t<script>\n\t\t\t\t//checkAll(document.formPHViewFillList.select_all)\t\n\t\t\t</script>\n\t\t\t</FORM>\n\t\t\t <FORM name=\"formPHGenerateFillList\" id=\"formPHGenerateFillList\"  TARGET=\"messageFrame\" >\n\t\t\t<br>\n\t\t\t<br>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\"\t\tVALUE=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"function_id\" id=\"function_id\" VALUE=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" VALUE=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"nursing_unit_query\" id=\"nursing_unit_query\" VALUE=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Nursing_Unit_From_Code\" id=\"Nursing_Unit_From_Code\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Nursing_Unit_To_Code\" id=\"Nursing_Unit_To_Code\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Default_Fill_Period\" id=\"Default_Fill_Period\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Schedule_Start_Time_Routine\" id=\"Schedule_Start_Time_Routine\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Exclude_Hrs\" id=\"Exclude_Hrs\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Disp_Locn\" id=\"Disp_Locn\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cDate\" id=\"cDate\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cMonth\" id=\"cMonth\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cYear\" id=\"cYear\" >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cHours\" id=\"cHours\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cMinutes\" id=\"cMinutes\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"currHours\" id=\"currHours\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"currMinutes\" id=\"currMinutes\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"Fill_Period_Unit\" id=\"Fill_Period_Unit\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"cut_off_limit_for_new_ord\" id=\"cut_off_limit_for_new_ord\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"routinefillalreadyinvoked\" id=\"routinefillalreadyinvoked\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"incstarttime\" id=\"incstarttime\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"incendtime\" id=\"incendtime\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"fill_int_start_date_time\" id=\"fill_int_start_date_time\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> \n\n\t\t</FORM> \n\t\t<!--<script>disableAll(true)</script>-->\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);


	String disp_locn_code			 = request.getParameter("disp_locn_code");
	String OrderingFacility_code	 = request.getParameter("OrderingFacility_code");
	String compound_drug_ind		 = request.getParameter("compound_drug_ind");
	String nursing_unit_or_locn		 = request.getParameter("nursing_unit_or_locn");
	String Nursing_Unit_From		 = request.getParameter("Nursing_Unit_From");
	String Nursing_Unit_To			 = request.getParameter("Nursing_Unit_To");
	String Proc_Type				 = request.getParameter("Proc_Type");
//	if(Proc_Type.equals("R")){Proc_Type = "Routine";}else if(Proc_Type.equals("I")){Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
	int Ip_Fill_Prd_Ahead_inDays     = Integer.parseInt(Ip_Fill_Prd_Ahead)/24;
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");
	String order_by_for_list		 = request.getParameter("order_by_for_list");
	String Building_Code			 = request.getParameter("Building_Code_from");
	String Building_Code_to			 = request.getParameter("Building_Code_to");
	String Floor_Code				 = request.getParameter("Floor_Code");
	if(Building_Code ==  null){Building_Code = "";}
	if(Floor_Code ==  null){Floor_Code = "";}
	String intermittent				 = "N";

	String iv_drug_ind				 = request.getParameter("iv_drug_ind");	
	String ip_excl_intermittent_fill = request.getParameter("ip_excl_intermittent_fill");
	String ip_prn_drugs              = request.getParameter("ip_prn_drugs");
	String ip_medical_items          = request.getParameter("ip_medical_items");
	String ip_fill_prd_unit			 = request.getParameter("ip_fill_prd_unit");
	String ip_fill_excl_prd_behind   = request.getParameter("ip_fill_excl_prd_behind");
	String cut_off_limit_for_new_ord = request.getParameter("cut_off_limit_for_new_ord");
	ArrayList un_alloc_records       = new ArrayList();
	int unalloc_record_cnt           =0;
	
	ArrayList seq_num_list=null;
	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
	HashMap fill_list_dtl = new HashMap();
	
	fill_list_dtl.put("iv_drug_ind",iv_drug_ind);
	fill_list_dtl.put("compound_drug_ind",compound_drug_ind);
	fill_list_dtl.put("ip_excl_intermittent_fill",ip_excl_intermittent_fill);
	fill_list_dtl.put("nursing_unit_or_locn",nursing_unit_or_locn);
	fill_list_dtl.put("Nursing_Unit_From_Code",Nursing_Unit_From);
	fill_list_dtl.put("Nursing_Unit_To_Code",Nursing_Unit_To);
	fill_list_dtl.put("Building_Code",Building_Code);
	fill_list_dtl.put("Building_Code_to",Building_Code_to);
	fill_list_dtl.put("Floor_Code",Floor_Code);
	fill_list_dtl.put("Proc_Type",Proc_Type);
	fill_list_dtl.put("schedule_start",schedule_start);
	fill_list_dtl.put("Ip_Fill_Prd_Ahead",Ip_Fill_Prd_Ahead_inDays+"");
	fill_list_dtl.put("Fill_Period_Unit",ip_fill_prd_unit);
	fill_list_dtl.put("ip_fill_excl_prd_behind",ip_fill_excl_prd_behind);	
	fill_list_dtl.put("order_by_for_list",order_by_for_list);
	fill_list_dtl.put("disp_locn_code",disp_locn_code);
	fill_list_dtl.put("fill_int_start_date_time",fill_int_start_date_time);
	fill_list_dtl.put("fill_int_end_date_time",fill_int_end_date_time);
	fill_list_dtl.put("cut_off_limit_for_new_ord",cut_off_limit_for_new_ord);
	fill_list_dtl.put("ip_prn_drugs",ip_prn_drugs);
	fill_list_dtl.put("ip_medical_items",ip_medical_items);
	fill_list_dtl.put("locale",locale);
	String bean_id = "IpFillAllBean" ;
	String bean_name = "ePH.IpFillAllBean";
	/* Initialize Function specific start */
	IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
//	bean.clear() ;
//	bean.setMode( mode ) ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
    String alt_drug_remarks_ind = bean.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
	String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
	String display_dosage_details = bean.getDisplayDosageDetails(); //added for MMS-DM-CRF-0011 [IN:055302] -start
	String disp_pat_dosage_style = "display:none";
	if(display_dosage_details.equals("Y"))
		disp_pat_dosage_style = "display:inline"; //added for MMS-DM-CRF-0011 [IN:055302] -end

	bean.setFillListDtl(fill_list_dtl);
	String userAuthPINYN=bean.getUserAuthPINYN(OrderingFacility_code,disp_locn_code); // Added for RUT-CRF-0035 [IN029926] 
			userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 

	if(!locale.equals("en")){
		fill_int_start_date_time = com.ehis.util.DateUtils.convertDate(fill_int_start_date_time,"DMYHM",locale,"en");
		fill_int_end_date_time   = com.ehis.util.DateUtils.convertDate(fill_int_end_date_time,"DMYHM",locale,"en");
	}

	ArrayList ip_fill_list = (ArrayList)bean.getIpFillList(fill_int_start_date_time,fill_int_end_date_time,Proc_Type,intermittent,disp_locn_code,nursing_unit_or_locn,compound_drug_ind,Building_Code,Building_Code_to,Floor_Code,Nursing_Unit_From,Nursing_Unit_To,order_by_for_list,locale,OrderingFacility_code,ip_fill_excl_prd_behind,ip_excl_intermittent_fill,ip_prn_drugs,ip_medical_items);

	HashMap ip_fill_order		= new HashMap();
	String logged_fcy = bean.getLoggedInFacility();
	String prvs_nursing_unit_code = "";
	String prves_order_id = "";
	String nursing_unit_code = "";
	String nursing_unit_desc = "";
	StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
	ArrayList legends=new ArrayList();
//	StringTokenizer disp_qty_btch = new StringTokenizer("S");
	String disp_qty		= "";
	String disp_qty_uom	= "";
	String disp_btch = "";
	String disp_drug_code = "";
	String disp_drug_desc = "";
	String drug_choice	  = "";
	String patient_id	  = "";
	String patient_details= "";
	String drug_color	  = "";
	String order_id		  = "";
	String order_line_num = "";
	String iv_prep_yn	  = "";
	String chk_dsbl		  = "";
	String ord_drug_code  = "";
	String ord_drug_name  = "";
	String ord_drug_qty	  = "";
	String ord_drug_uom   = "";
	String total_drugs	  = "";
	String ip_fill_chk_value = "N";
	String ip_fill_chked	 = "checked";
	String line_flag  	  = "N";
	String sex  	  = "";
	String date_of_birth  	  = "";
	String patient_Name  	  = "";
	String gender  	  = "";
	String chk_dsb1 = "disabled";
	String pre_Order_type_legend = "";
	String prev_patient_id = "";
	String disp_alt_symbol = "";
	String disp_multi_strength_yn = bean.getDispAlternate();

	String IV_with_Additives_lg="",IV_Intermittent_lg="",IV_without_Additives_lg="",Order_type_legend="";
	legends=bean.getIVLegends();
	IV_with_Additives_lg=(String)legends.get(0);
	IV_Intermittent_lg=(String)legends.get(1);
	IV_without_Additives_lg=(String)legends.get(2);
	int iv_drug_count  =0;
	String prev_iv_prep_yn  ="";
	String dosage_details = "", patient_id_disp=""; //added for MMS-DM-CRF-0011 [IN:055302]

	//intialising un allocated drug list
	bean.setUnAllocDrugList(un_alloc_records);

	/* Checking if user is a Pharmacist */
	//int continueop=bean.validatePharmacist();
	//if (continueop==0){

            _bw.write(_wl_block10Bytes, _wl_block10);

	//}
	/* To get the dispense location based on the work station no */
//	ArrayList dispLocn=bean.getDispenseLocation();
	//if (dispLocn.size()==0){

            _bw.write(_wl_block11Bytes, _wl_block11);

	//}

            _bw.write(_wl_block12Bytes, _wl_block12);
 
			if(ip_fill_list != null && ip_fill_list.size()>0){

            _bw.write(_wl_block13Bytes, _wl_block13);
		
					seq_num_list=new ArrayList();
											
					total_drugs	  = ip_fill_list.size()+"";
					for(int i = 0; i<ip_fill_list.size();i++){
						ip_fill_order = (HashMap)ip_fill_list.get(i);
						if(!patient_id.equals((String)ip_fill_order.get("PATIENT_ID"))){
							patient_id		= (String)ip_fill_order.get("PATIENT_ID");
							patient_id_disp = patient_id;
							patient_details	= (String)ip_fill_order.get("Patient_Details");	
							patient_details=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+":"+patient_details;
							sex	= (String)ip_fill_order.get("sex");
							if(!display_dosage_details.equals("Y")){//if condition alone added for MMS-DM-CRF-0011 [IN:055302]
								if(sex.equals("M")){
									gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
									gender=gender+",";
								}
								else if(sex.equals("F")){
									gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									gender=gender+",";
								}
								else if(sex.equals("Unknown")){
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
									gender=gender+",";
								}
							}
							date_of_birth	= (String)ip_fill_order.get("date_of_birth");
							date_of_birth   = date_of_birth+",";
							patient_Name	= (String)ip_fill_order.get("patient_Name");	
							line_flag       = "Y";
							seq_num_list.add(patient_id);
						}
						else{
							patient_details	= "";
							patient_id_disp ="";
							line_flag       = "N";
							date_of_birth   = "";
							gender   = "";
							patient_Name   = "";
							
						}					 
						//seq_num_list.add(patient_id);
						//seq_num_map.put("patient_id_"+i,seq_num_list);
						iv_prep_yn		  = (String)ip_fill_order.get("iv_prep_yn"); 
						order_id		  = (String)ip_fill_order.get("ORDER_ID"); 
						order_line_num	  = (String)ip_fill_order.get("ORDER_LINE_NUM"); 
						ord_drug_code	  = (String)ip_fill_order.get("Drug_Code"); 	
						ord_drug_name	  =	(String)ip_fill_order.get("Drug_Name");
						ord_drug_qty	  =	(String)ip_fill_order.get("ORDER_QTY");
						ord_drug_uom	  =	(String)ip_fill_order.get("ORDER_UOM");
						nursing_unit_code = (String)ip_fill_order.get("SOURCE_CODE"); 
						nursing_unit_desc = (String)ip_fill_order.get("NURSING_UNIT_DESC"); 
						disp_alt_symbol = (String)ip_fill_order.get("disp_alt_symbol"); 
						if(ip_fill_order.get("DOSAGE_DETAILS")!=null && display_dosage_details.equals("Y")) //added for MMS-DM-CRF-0011 [IN:055302]
							dosage_details = (String)ip_fill_order.get("DOSAGE_DETAILS");

					   if(iv_prep_yn.equals(""))
							Order_type_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NormalRx.label","ph_labels");
					   else if(iv_prep_yn.equals("1"))
							Order_type_legend=IV_with_Additives_lg;
						else if(iv_prep_yn.equals("3"))
							Order_type_legend=IV_Intermittent_lg;
						else if(iv_prep_yn.equals("5"))
							Order_type_legend=IV_without_Additives_lg;
						else if(iv_prep_yn.equals("9"))
							Order_type_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");
						
						disp_qty_dtl = new StringTokenizer((String)ip_fill_order.get("Disp_qty"),"|");
						int count=disp_qty_dtl.countTokens();

						disp_qty		  ="";
						disp_qty_uom	  ="";
						disp_drug_code  ="";
						disp_drug_desc  ="";
						drug_choice     ="N";
						disp_btch		  =" ^ ^ ^ ^";

						if(count==5){
							while(disp_qty_dtl.hasMoreTokens()){
								disp_qty		= disp_qty_dtl.nextToken();
								disp_qty_uom	= disp_qty_dtl.nextToken();
								drug_choice		= disp_qty_dtl.nextToken();
								disp_drug_code  = disp_qty_dtl.nextToken();
								disp_drug_desc  = disp_qty_dtl.nextToken();
								if ( disp_drug_desc == null || disp_drug_desc.equals(" ") ){
								  disp_drug_desc= ord_drug_name;
								  ord_drug_code=ord_drug_code;
								  //drug_choice="#990033";
								  drug_color = "#990033";
								 // ip_fill_chked	 = "checked";
								  if(disp_qty.equals("0")) {
									  ip_fill_chked	 = "";
									  ip_fill_chk_value = "N";
								  }
								  else {
									  ip_fill_chked	 = "checked";
									  ip_fill_chk_value = "Y";
								  }
								  chk_dsbl = "";
								}
								drug_choice ="N";
								disp_btch		=" ^ ^ ^ ^";
							}
						}
						else if(count==6) {
							while(disp_qty_dtl.hasMoreTokens()){
							disp_qty		= disp_qty_dtl.nextToken();
							disp_qty_uom	= disp_qty_dtl.nextToken();
							drug_choice		= disp_qty_dtl.nextToken();
							disp_drug_code  = disp_qty_dtl.nextToken();
							disp_drug_desc  = disp_qty_dtl.nextToken();
							disp_btch		= disp_qty_dtl.nextToken();
							if ( (disp_drug_desc == null || disp_drug_desc.equals(" ")&&(!drug_choice.equals("C"))) ){
							  disp_drug_desc= ord_drug_name;
							  ord_drug_code=ord_drug_code;
							  //drug_choice="#990033";
							  drug_color = "#990033";
							  if(disp_qty.equals("0")){
								  ip_fill_chked	 = "";
								  ip_fill_chk_value = "N";
							  }
							  else{
								  ip_fill_chked	 = "checked";
								  ip_fill_chk_value = "Y";
							   }
							  chk_dsbl = "";
							 }
						   }//end while
						}//end else
						//System.err.println("drug_choice--->"+drug_choice);
						if(drug_choice.equals("S")){
							drug_color = "";			
							chk_dsbl = "enabled";
							//out.println("drug_choice--inside->"+drug_choice);
							//ip_fill_chked	 = "checked";
							if(disp_qty.equals("0")){
								ip_fill_chked	 = "";
								ip_fill_chk_value="N";
								chk_dsbl = "disabled";
							}
							else{
								ip_fill_chked	 = "checked";
								ip_fill_chk_value = "Y";
							}
						}
						else if(drug_choice.equals("A")){
							drug_color = "#CC6600";			
							chk_dsbl = "";
							//ip_fill_chked	 = "checked";
							if(disp_qty.equals("0")){
								ip_fill_chked	 = "";
								ip_fill_chk_value = "N"; 
							}
							else{
								ip_fill_chked	 = "checked";
								ip_fill_chk_value = "Y"; 
							}
						}
						else if(drug_choice.equals("M")){
							drug_color = "#CC00CC";
							chk_dsbl = "disabled";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("N")){
							drug_color = "";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoStock.label","ph_labels")+"'>";
							chk_dsbl = "disabled";
							/*if(disp_qty.equals("0")){
							  chk_dsbl = "disabled";
							 }else{
							  chk_dsbl = "";
							  } */
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("C")){
							drug_color = "red";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ITEMSTORECOMBINOTFOUND.label","ph_labels")+"'>";
							chk_dsbl = "disabled";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("U")){
							chk_dsbl = "disabled";
							drug_color = "";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ItemUOMDEFNOTFound.label","ph_labels")+"'>";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						/*if(disp_qty.equals("0")){
							drug_color = "";
							chk_dsbl = "";
							ip_fill_chk_value = "N";
							//ip_fill_chked	 = "checked";
							ip_fill_chked	 = "";
						} */
						if(!prvs_nursing_unit_code.equals(nursing_unit_code)){
							prvs_nursing_unit_code = nursing_unit_code;

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
						if(!line_flag.equals("N")){

            _bw.write(_wl_block16Bytes, _wl_block16);

						}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disp_pat_dosage_style));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id_disp));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block22Bytes, _wl_block22);

						if(!pre_Order_type_legend.equals(Order_type_legend) || !prev_patient_id.equals(patient_id)){

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block24Bytes, _wl_block24);

							pre_Order_type_legend = Order_type_legend;
							prev_patient_id=patient_id;
						}
						else{

            _bw.write(_wl_block25Bytes, _wl_block25);

						}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_drug_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disp_pat_dosage_style));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dosage_details));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ord_drug_qty));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.getUomDisplay(logged_fcy,ord_drug_uom)));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
						//if(drug_choice.equals("N")||drug_choice.equals("C")){
							if(!disp_multi_strength_yn.equals("Y") && disp_alt_symbol.equals("N")){//|| changed to && for IN0071324

            _bw.write(_wl_block34Bytes, _wl_block34);

						}
						else if(disp_alt_symbol.equals("Y")){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ord_drug_qty));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fill_int_start_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fill_int_end_date_time));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Proc_Type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nursing_unit_or_locn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Nursing_Unit_From));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Nursing_Unit_To));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Building_Code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Building_Code_to));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Floor_Code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_fill_excl_prd_behind));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(compound_drug_ind));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_medical_items));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_excl_intermittent_fill));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_prn_drugs));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block37Bytes, _wl_block37);

						}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fill_int_end_date_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disp_drug_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( order_line_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((String)ip_fill_order.get("Tot_Disp_Qty")));
            _bw.write(_wl_block24Bytes, _wl_block24);

						if(drug_choice.equals("M") || drug_choice.equals("N") || drug_choice.equals("C")){

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disp_qty));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);

						}
						else{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bean.getUomDisplay(logged_fcy,disp_qty_uom)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disp_qty));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);

						}

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getUomDisplay(logged_fcy,disp_qty_uom)));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disp_btch));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disp_qty_uom));
            _bw.write(_wl_block70Bytes, _wl_block70);

						if(!prves_order_id.equals(order_id)){   
							if(prev_iv_prep_yn.equals("1")||prev_iv_prep_yn.equals("3")||prev_iv_prep_yn.equals("4")||prev_iv_prep_yn.equals("9")){

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(iv_drug_count));
            _bw.write(_wl_block73Bytes, _wl_block73);

							}	
							iv_drug_count =0;

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ip_fill_chk_value));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chk_dsbl));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ip_fill_chked));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
 
							prves_order_id = order_id; prev_iv_prep_yn =iv_prep_yn;
						}
						else{
							iv_drug_count =iv_drug_count+1;

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ip_fill_chk_value));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chk_dsb1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(ip_fill_chked));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);

						}
						if(drug_choice.equals("N")){
							un_alloc_records.add(Proc_Type);
							un_alloc_records.add(nursing_unit_code);
							un_alloc_records.add(patient_id);
							un_alloc_records.add(ord_drug_code);
							un_alloc_records.add(disp_qty);
							un_alloc_records.add(disp_qty_uom);
							un_alloc_records.add(order_id); //Added for SRR20056-SCF-7499
							un_alloc_records.add(order_line_num); //Added for SRR20056-SCF-7499
							unalloc_record_cnt++;

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);

						}
						else{

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);

						}

            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(drug_choice));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);

					}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(total_drugs));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(iv_drug_count));
            _bw.write(_wl_block101Bytes, _wl_block101);

					bean.setUnAllocDrugList(un_alloc_records);
					bean.setPatientList(seq_num_list);

            _bw.write(_wl_block102Bytes, _wl_block102);

			}
			else{

            _bw.write(_wl_block103Bytes, _wl_block103);

			}

            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( total_drugs ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(unalloc_record_cnt));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Proc_Type));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(userAuthPINYN));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(alt_drug_remarks_ind));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( bean.getFunctionId() ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf( logged_fcy ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_NURSINGUNIT_LOOKUP" ) ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(fill_int_start_date_time));
            _bw.write(_wl_block117Bytes, _wl_block117);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block118Bytes, _wl_block118);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FillList.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
