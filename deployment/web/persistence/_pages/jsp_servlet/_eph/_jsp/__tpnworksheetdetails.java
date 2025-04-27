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
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __tpnworksheetdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNWorkSheetDetails.jsp", 1709121536686L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML> \n<HEAD> \n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n<!-- \t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/messages.js\"></SCRIPT> -->\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhCommon.js\"></SCRIPT>\n\t<!-- <SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhMessages.js\"></SCRIPT> -->\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/TPNWorkSheet.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY>\n<FORM name=\"formTPNWorkSheetDetails\" id=\"formTPNWorkSheetDetails\">\n\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" ALIGN=\"center\" BORDER=\"0\">\n<!-- \t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ALIGN=\"center\" BORDER=\"0\"> -->\n\t<TR>\n\t\t<TD WIDTH=\"30%\" align=\"left\" CLASS=\"label\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </b>&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"TEXT\" size=\"1\" maxlength=\"2\" name=\"overage_volume\" id=\"overage_volume\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onblur=\"calOvrgeOrdQty(this);\">&nbsp;&nbsp;<label ID=\'overage_uom\' width=\"20%\" align=\'left\' STYLE=\"font-size:9;font-weight:bold;\" > </TD>\n\t\t<TD WIDTH=\"1%\" colspan=\"1\" STYLE=\"background-color:white\" ></TD>\n\t\t<TD WIDTH=\"49%\"></TD>\n\t\t<TD WIDTH=\"1%\" STYLE=\"background-color:white\" ></TD>\n\t</TR>\n\t<TR height=2>\n\t\t<TD ALIGN=\"left\" WIDTH=\"40%\">\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\">\n\t\t\t<td class= \"COLUMNHEADER\" COLSPAN=\"4\" ALIGN=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</Td>\n\t\t\t<TR>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"left\" WIDTH=\"2%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Td>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"center\" WIDTH=\"17%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</Td>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"left\" WIDTH=\"30%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <br>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Td>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"center\" WIDTH=\"14%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</Td>\n\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t</TD>\n\t\t<TD ALIGN=\"left\" WIDTH=\"1%\" colspan=\"1\" STYLE=\"background-color:white\">&nbsp;</TD>\n\t\t<TD ALIGN=\"left\" WIDTH=\"60%\">\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\">\n\t\t\t ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t       <td class= \"COLUMNHEADER\" COLSPAN=\"6\" ALIGN=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</Td>\n\t\t\t ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t   <td class= \"COLUMNHEADER\" COLSPAN=\"4\" ALIGN=\"left\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<TR>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"right\" WIDTH=\"40%\" nowrap >&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</Td>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"center\" WIDTH=\"14%\" nowrap>&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;</Td>\n\t\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"left\" WIDTH=\"14%\" nowrap>&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" &nbsp;</Td>\n                ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t  <td class= \"COLUMNHEADER\" width=\"11%\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t          <td class= \"COLUMNHEADER\" width=\"11%\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t</TD>\n\t\t<TD ALIGN=\"left\" WIDTH=\"2%\" STYLE=\"background-color:white\">&nbsp;</TD>\n\t</TR>\n\t<!-- </TABLE> -->\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t<TR>\n\t\t<TD ALIGN=\"left\" WIDTH=\"40%\">\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\">\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t<td class= \"COLUMNHEADER\" ALIGN=\"left\" COLSPAN=\"6\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</Td>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\t\t\t<TR>\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CONST_GROUP_CODE_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"CONST_GROUP_CODE_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CONST_GENERIC_CODE_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"CONST_GENERIC_CODE_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"CONST_REMARKS_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"CONST_REMARKS_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"OVERRIDE_REASON_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"OVERRIDE_REASON_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<TD WRAP ALIGN=\"left\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" WIDTH=\"5%\" onclick=\"showOvrRsn(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" onMouseOVer=\"showToolTip(this,\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\"><b>i</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t<Label STYLE=\"font-size:9;cursor:pointer;color:blue\" onclick=\"showPrecipitaionInfo(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\">\n\t\t\t\t\t\t\t<b>&nbsp; <img src=\"../../ePH/images/information.gif\" align=\"center\"></img></b>\n\t\t\t\t\t\t\t</Label>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<b>\t&nbsp;</b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<b>\t&nbsp;</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t</TD>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<TD WRAP ALIGN=\"left\" CLASS=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" WIDTH=\"5%\"><LABEL ID=\"remarks_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" STYLE=\"font-size:9\">&nbsp;</LABEL> \n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t<b>\t&nbsp;&nbsp;</b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<b>\t&nbsp;&nbsp;</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<TD WRAP ALIGN=\"left\" CLASS=\"label\" WIDTH=\"21%\"><LABEL ID=\"CONST_GENERIC_NAME_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" STYLE=\"font-size:9;cursor:pointer;color:blue\" onclick=\"showRemarks(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\')\" >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</LABEL></TD>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" STYLE=\"font-size:9\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\t\t\t\t\n\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"18%\">\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\t\t\t\n\t\t\t\t\t<INPUT TYPE=\"text\" ALIGN=\"right\" CLASS=\"number\" name=\"ORDER_QTY_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"ORDER_QTY_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" READONLY SIZE=\"3\">&nbsp;<LABEL ID=\"ALLOC_QTY_UOM_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</LABEL>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<INPUT style=\"visibility:hidden\" TYPE=\"text\" ALIGN=\"right\" CLASS=\"number\" name=\"ORDER_QTY_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" READONLY SIZE=\"3\"><label STYLE=\"font-size:9;visibility:visible\"></label>&nbsp;<LABEL ID=\"ALLOC_QTY_UOM_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" STYLE=\"font-size:9;visibility:visible\"></LABEL>\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<INPUT TYPE=\'HIDDEN\' NAME =\"ALLOC_QTY_UM_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"VARIANCE_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"VARIANCE_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t</TD>\n\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"21%\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\t\t\t\t\n\t\t\t\t\t<INPUT TYPE=\"text\" ALIGN=\"left\" CLASS=\"number\" name=\"OVERAGE_ORDER_QTY_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"OVERAGE_ORDER_QTY_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" READONLY SIZE=\"3\">&nbsp;&nbsp;<LABEL ID=\"item_limits_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t<INPUT style=\"visibility:hidden\" TYPE=\"text\" ALIGN=\"left\" CLASS=\"number\" name=\"OVERAGE_ORDER_QTY_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" VALUE=\"0\" READONLY SIZE=\"3\"><label STYLE=\"font-size:9;visibility:visible\"></label>&nbsp;&nbsp;&nbsp;<LABEL ID=\"item_limits_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" STYLE=\"font-size:9;visibility:hidden\"></LABEL>\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t<INPUT TYPE=\'HIDDEN\' NAME =\"ALLOC_QTY_UM1_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"><INPUT TYPE=\"hidden\" name=\"VARIANCE1_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"VARIANCE1_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t\t</TD>\n\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"18%\">\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\t\t\t\n\t\t\t\t\t<INPUT TYPE=\"text\" ALIGN=\"right\" CLASS=\"number\" name=\"ALLOC_QTY_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"ALLOC_QTY_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" READONLY SIZE=\"3\" >&nbsp;&nbsp;<LABEL ID=\"ALLOC_QTY_UOM";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<INPUT style=\"visibility:hidden\" TYPE=\"text\" ALIGN=\"right\" CLASS=\"number\" name=\"ALLOC_QTY_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" READONLY SIZE=\"3\">&nbsp;&nbsp;<LABEL ID=\"ALLOC_QTY_UOM";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" STYLE=\"font-size:9;visibility:hidden\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<INPUT TYPE=\'HIDDEN\' NAME =\"ALLOC_QTY_UM";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"></TD>\n\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t</TD>\n\t\t<TD ALIGN=\"left\" WIDTH=\"1%\" STYLE=\"background-color:white\">&nbsp;</TD>\n\t\t<TD ALIGN=\"right\" WIDTH=\"59%\">\n\n\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\">\n\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\n\t\t\t<td class= \"COLUMNHEADER\"  ALIGN=\"left\" COLSPAN=\"6\">&nbsp;</td>\n\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="          \n\n\t\t\t<TR>\n\t\t\t\t\n\n\t   <TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"40%\" nowrap>\n\t\t\t<SELECT name=\"ITEM_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"ITEM_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" onchange=\"assignval(this,\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\',\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\');if(document.formTPNWorkSheetDetails.CONST_GROUP_CODE_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =".value==\'EL\')populateIssueQty(this,\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\');GetBillingDetails(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\',\'Y\');\">\n\t\t\t<OPTION VALUE=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------------  ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="  -------------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</OPTION>\n\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\n\t\t\t\t</SELECT><input style=\"visibility:";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" type=\"button\" class=\"button\" name=\"dflt_item_search_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" value=\"?\" onclick=\"assignval(\'\',\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =".value==\'EL\')populateIssueQty(\'\',\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\');\">\n\t\t\t\t<label class=\"label\" id=\"osmolar_value_lb_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" name=\"Osmo_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</label><INPUT TYPE=\"hidden\" name=\"osmolar_value_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"osmolar_value_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" >\n\t\t\t</TD>\n\n\t\t\t\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"14%\" STYLE=\"font-weight:bold;\" nowrap><label class=\"label\" id=\"BATCH_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" name=\"BATCH_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</label></TD>\n\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"14%\" STYLE=\"font-weight:bold;\" nowrap><label class=\"label\" id=\"EXPIRY_DATE_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" name=\"EXPIRY_DATE_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</label></TD>\n\t\t\t\t\n\t\t\t\t<TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"14%\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"AVAIL_QTY_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"AVAIL_QTY_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" VALUE=\"\" ><INPUT TYPE=\"text\" ALIGN=\"right\" CLASS=\"number\" name=\"ISSUE_QTY_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"ISSUE_QTY_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" SIZE=\"6\" MAXLENGTH=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" onKeyPress=\"return allowValidNumber(this,event,4,";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =")\" onBlur=\"if(validateNumbers(this,4,\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\')){checkForTPNItemSelect(this,\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\');checkIsNotZero(this, \'Issue Quantity\', \'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =".value==\'EL\'){checkPrecipitation(this,\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\');};}\" value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>&nbsp;<LABEL ID=\"QTY_UOM";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" STYLE=\"font-size:9;font-weight:bold;\">";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</LABEL>\n\t\t\t\t\t<input type=\"hidden\"  name=\"issued_stock_uom_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"issued_stock_uom_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t<input type=\"hidden\"  name=\"order_uom";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" id=\"order_uom";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\"  name=\"ISSUE_QTY1_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"ISSUE_QTY1_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=\"\">\n\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"Eqvl_value_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"Eqvl_value_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\t\t<input type=\"hidden\"  name=\"concentration_percent_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"concentration_percent_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t<input type=\"hidden\"  name=\"LastDerivedValue";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"LastDerivedValue";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\t\n\t\t\t\t\t<input type=\"hidden\"  name=\"manufacture_var_percentage";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"manufacture_var_percentage";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\'trade_id_";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' id=\'trade_id_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'bin_locn_code_";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' id=\'bin_locn_code_";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n                    <input type=\"hidden\" name=\'item_concentration_percent_";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' id=\'item_concentration_percent_";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' value=\"\"><!-- added for ML-MMOH-CRF-1201 -->\n                    <input type=\"hidden\" name=\'item_volume_";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' id=\'item_volume_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' value=\"\"><!-- added for ML-MMOH-CRF-1201 -->\n\t\t\t\t</TD>\n\n               ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t      <TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"11%\" STYLE=\"font-weight:bold;\" id=\'td_gross_charge_amount_str_";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</TD>\n\t\t\t      <TD ALIGN=\"left\" CLASS=\"label\" WIDTH=\"11%\" STYLE=\"font-weight:bold;\" id=\'td_groos_pat_payable_str_";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</TD>\n\t\t\t\t  \n\t              <input type=\"hidden\"  name=\"gross_charge_amount_";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" id=\"gross_charge_amount_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t\t\t\t  <input type=\"hidden\"  name=\"groos_pat_payable_";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" id=\"groos_pat_payable_";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"   value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\n\n              ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\n\n\n\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t</TD>\n\t</TR>\n\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\n\t</TABLE>\n\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"locn_code\" id=\"locn_code\" VALUE=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"order_id\" id=\"order_id\" VALUE=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"row_count\" id=\"row_count\" VALUE=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"item_count\" id=\"item_count\" VALUE=\"\">\n\t<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t<!-- <INPUT TYPE=\"hidden\" name=\"Eqvl_value\" id=\"Eqvl_value\" VALUE=\"\"> -->\n\t<INPUT TYPE=\"hidden\" name=\"ordered_volume\" id=\"ordered_volume\" VALUE=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t<INPUT type=\"hidden\" name=\'presc_base_unit\' id=\'presc_base_unit\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t<INPUT type=\"hidden\" name=\'decimal_format_string\' id=\'decimal_format_string\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n\t<INPUT type=\"hidden\" name=\'dischargeIND\' id=\'dischargeIND\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n    <INPUT type=\"hidden\" name=\'tpn_change_mmoh\' id=\'tpn_change_mmoh\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'><!-- Added for ML-MMOH-CRF-1201 -->\n   </FORM>\n\t\t<SCRIPT>\n\t   \n\n\t\t\n\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\n\t\t\t//parent.messageFrame.document.formTPNWorkSheetButtons.fluid_volume.value = \'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\';\n\t\t\t//parent.messageFrame.document.getElementById(\"fluid_uom\").innerText = \'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\';\n\t\t\t//params=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' + \"&tpn_qty=\"+\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'+\"&tpn_uom=\"+\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\';\n\n\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t//calOvrgeOrdQty(parent.commontoolbarFrame.document.formTPNWorkSheetHeader.overage_volume);\n\t\t   // calOvrgeOrdQty(parent.f_query_add_mod.document.formTPNWorkSheetDetails.overage_volume);\n\n\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\tdocument.formTPNWorkSheetDetails.overage_volume.readOnly = true;\n\t\t\t//parent.messageFrame.document.formTPNWorkSheetButtons.osmolarity_volume.value = \'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\';\n\t\t\t//parent.messageFrame.document.formTPNWorkSheetButtons.osmolarity_volume_per_ltr.value = \'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\';\n\t\t\t//params=params + \"&ws_osmo_value=\"+\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'+\"&ws_osmo_value_lt=\"+\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\';\n\t\t\tparent.messageFrame.location.href=\"../../ePH/jsp/TPNWorkSheetButtons.jsp?\"+\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'+\"&tot_groos_pat_payable_str=\"+\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'+\"&tot_gross_charge_amount_str=\"+\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'+ \"&ws_osmo_value=\"+\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'+ \"&tpn_qty=\"+\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n            parent.messageFrame.location.href=\"../../ePH/jsp/TPNWorkSheetButtons.jsp?\"+\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\n\t\t</SCRIPT>\n\t\t\t\t\n";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//Adding start for ML-MMOH-CRF-1201
	   Connection con			= null;  
        con				= ConnectionManager.getConnection(request);
        boolean tpn_change_mmoh = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPLICABILITY_SETTINGS");
//Adding end for ML-MMOH-CRF-1201
	try{
    String params = request.getQueryString() ;

	int iMaxLength = 9;
	int iNoOfDecimals = 4;

	String order_id		= request.getParameter("order_id");
	if(order_id == null) {order_id = "";}
	String tpn_non_std_regimen_code = request.getParameter("tpn_non_std_regimen_code");
	if(tpn_non_std_regimen_code ==  null){tpn_non_std_regimen_code = "";}
	String patient_id	= request.getParameter("patient_id");
//	String locn_code	= request.getParameter("locn_code");
	String curr_group	= "";
	String curr_group_code	= "";
	String prev_group		= "";
	String presc_base_unit	=   "";
	String overage_vol	= "";
	String readOnly		= "";
    String dischargeIND = request.getParameter("dischargeIND");
	String bean_id		  = "TPNWorkSheetBean";
	String bean_name	  = "ePH.TPNWorkSheetBean";
	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);

	String bean_id_1	  = "DispMedicationBean" ;
	String bean_name_1	  = "ePH.DispMedicationBean";
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject(bean_id_1,bean_name_1,request);

	String bean_id_2	  = "DispMedicationAllStages" ;
	String bean_name_2	  = "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_2 = (DispMedicationAllStages)getBeanObject(bean_id_2,bean_name_2,request);



    overage_vol	= 	bean_2.getOverageVol();

	if(overage_vol == null || overage_vol.equals("")){ 
		overage_vol = ""; 	
		bean.setOverageVolume(order_id);
		overage_vol	= 	bean.getOverageVolume();
	}

	if(overage_vol == null || !overage_vol.equals("")){
		if(overage_vol == null) {overage_vol = "";}
		readOnly  = "readOnly"; 
	}else{
		overage_vol = bean_2.getDfltOvrgVol(tpn_non_std_regimen_code);
		if(overage_vol == null) {overage_vol = "";}
	}


	String tpn_qty  = "1";
	String tpn_uom  = "";
	ArrayList  tpn_vals = null;
	String ordered_volume = "";
	ordered_volume = bean.getOrderVolume(order_id);
	if(ordered_volume == null){ordered_volume = "";}

	if(bean_1.getTPNWorksheetID(order_id) != null){
		tpn_vals = bean_1.getTPNQtyUom(order_id);

		if((tpn_vals != null) && (tpn_vals.size() >0) ){
			tpn_qty=(String)tpn_vals.get(0);
			tpn_uom=(String)tpn_vals.get(1);
		}
	}

	String locn_code	= bean_1.getDispLocnCode();
	presc_base_unit		= bean.getPrescBaseUnit();
    ArrayList prevWSVls= new ArrayList();
	prevWSVls=bean_1.getPrevWorkSheetDetails();
	if(prevWSVls != null){
		tpn_qty=bean_2.getTPNQty();
		if(tpn_qty.equals("")){tpn_qty = "1";}
		tpn_uom=bean_2.getTPNQtyUOM();
	}

	ArrayList tpn_wrk_sht_details= new ArrayList();
	tpn_wrk_sht_details=bean.getTPNWrkSheetDetails(order_id);
	Hashtable rec = new Hashtable();
	bean.clear();
	ArrayList initalDetails = bean.getInitalDetails(order_id,patient_id,tpn_non_std_regimen_code);
	bean.getConstPrecepInfo();

	int j=0;
	
	String ALLOC_QTY_UOM		=	"";
	String ITEM					=	"";
	String ALLOC_QTY			=	"";
	String BATCH				=	"";
	String EXPIRY_DATE			=	"";
	String ISSUE_QTY			=	"";
	String QTY_UOM				=	"";
	String trade_id				=	"";
	String manufacture_var_percentage="";
	String LastDerivedValue		=	"0";
	String bin_locn_code		=	"";
	String concentration_percent=	"";
	String const_generic_code	=   "";
	String stock_uom			=	"";
	String equvl_value			=   "";
	String beyond_dsg_rsn		=	"";
	String const_remarks		=	"";
	String not_to_be_ordered	=	"";
	String dflt_lkp_vsblty		=   "hidden";
	String osmolar_value		=	"";
	String osmolar_value_lt		=   "";
	float  ws_osmo_value		=   0;
	String ws_osmo_value_lt		=   "";
	int   pres_qty_range		=  0;
	float min_qty				=  0;
	float max_qty				=  0;
	StringBuffer range_buffer = new StringBuffer();
	String billing_interface_yn     =   bean_2.checkforbillinginterface();
	String width					=  "120%";
	if(billing_interface_yn.equals("Y")){
			width						=  "150%";
	}
	String decimalFormatString			=  "";	
	float gross_charge_amount           =  0;
	float groos_pat_payable             =  0;
	String gross_charge_amount_str		=  "";
	String groos_pat_payable_str		=  "";
	String tot_gross_charge_amount_str	=  "";
	String tot_groos_pat_payable_str	=  "";	
	float tot_gross_charge_amt			=	0;
	float tot_pat_payable_amt			=	0;
	ArrayList constPrecepInfo			= new ArrayList();
	ArrayList itemvalues			= new ArrayList();//Added for ML-MMOH-CRF-1201
	String item_concentration_percent=	"";//Added for ML-MMOH-CRF-1201
	String item_volume ="";//Added for ML-MMOH-CRF-1201

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(width));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(width));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(overage_vol));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(billing_interface_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
if(billing_interface_yn.equals("Y")){
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

//ArrayList CONST_GENERIC_CODE = new ArrayList();
StringBuffer batch_str				= new StringBuffer();
StringBuffer gross_charge_display_str  = new StringBuffer();
StringBuffer pat_charge_display_str    = new StringBuffer();

	for (int i=0; i<initalDetails.size(); i+=11, j++) {

	  /*cal = Math.round(((100/Float.parseFloat((String)initalDetails.get(i+7)))* Integer.parseInt((String)initalDetails.get(i+4))))+"";*/
    // if(!CONST_GENERIC_CODE.get(0).equals(initalDetails.get(i+2)))
		//CONST_GENERIC_CODE.add(initalDetails.get(i+2)+"$");
		ALLOC_QTY_UOM="";
		ITEM="";
		ALLOC_QTY="";
		BATCH="";
		EXPIRY_DATE="";
		ISSUE_QTY="";
//		LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
		trade_id="";
		bin_locn_code="";
		QTY_UOM="";
		concentration_percent="";
		manufacture_var_percentage="";
		osmolar_value="";
		osmolar_value_lt = "";
		const_remarks="";
		beyond_dsg_rsn="";
		item_concentration_percent="";//Added for ML-MMOH-CRF-1201
		item_volume ="";//Added for ML-MMOH-CRF-1201

		curr_group		= (String)initalDetails.get(i);
		curr_group_code	= (String)initalDetails.get(i+1);
		const_generic_code = (String)initalDetails.get(i+2);
		if(prevWSVls!=null && prevWSVls.size()>0){
		if (prevWSVls.size()>0){
			rec=(Hashtable)prevWSVls.get(j);
			ALLOC_QTY_UOM=(String)rec.get("ALLOC_QTY_UOM"+j);
			ITEM=(String)rec.get("ITEM_"+j);
			ALLOC_QTY=(String)rec.get("ALLOC_QTY_"+j);
			BATCH=(String)rec.get("BATCH_"+j);
			EXPIRY_DATE=(String)rec.get("EXPIRY_DATE_"+j);
			ISSUE_QTY=(String)rec.get("ISSUE_QTY_"+j);
			LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
			manufacture_var_percentage=(String)rec.get("manufacture_var_percentage"+j);
			trade_id=(String)rec.get("trade_id_"+j);
			bin_locn_code=(String)rec.get("bin_locn_code_"+j);
			concentration_percent=((String)rec.get("concentration_percent_"+j)).equals("")?"0":(String)rec.get("concentration_percent_"+j);
			QTY_UOM=(String)rec.get("QTY_UOM"+j);
			//ALLOC_QTY_UOM=(String)rec.get("ALLOC_QTY_UOM"+j);
			osmolar_value=(String)rec.get("osmolar_value_"+j);

			if(!osmolar_value.equals("") && !ITEM.equals("")){
				osmolar_value_lt = bean.roundTwoDigits((Float.parseFloat(osmolar_value) * Float.parseFloat(ISSUE_QTY) / 1000)+"");
			}
			if(!osmolar_value.equals("")){
					ws_osmo_value = ws_osmo_value + Float.parseFloat(String.valueOf(osmolar_value_lt)); 
			}
         if(!ISSUE_QTY.equals("")&&billing_interface_yn.equals("Y")){
            batch_str				  = new StringBuffer();
			//gross_charge_display_str  = new StringBuffer();
			//pat_charge_display_str    = new StringBuffer();

			batch_str.append(trade_id).append(";").append(BATCH).append(";").append(EXPIRY_DATE).append(";").append(bin_locn_code).append(";").append(ISSUE_QTY+"").append(";");
           double issued_qty                      =   Double.parseDouble(ISSUE_QTY);
           HashMap  chareg_det  = (HashMap)bean_2.callItemChargeDtls(patient_id,bean_1.getEncounterID(),bean_2.getEncounterPatientClass(bean_1.getEncounterID() , patient_id ), ITEM,issued_qty,batch_str.toString(), bean_1.getTodaysDate(),locn_code,"","",order_id,"1",bean_1.getDispStage(),dischargeIND); // patient_id for getEncounterPatientClass added for [IN:035667] 

            String err_msg   =(String)chareg_det.get("error_msg");

			decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			 if(err_msg.equals("")){
					

					if(!chareg_det.get("grosschargeamt").equals("null")){
						 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
					}
					if(!chareg_det.get("patnetamt").equals("null")){
						groos_pat_payable  = Float.parseFloat((String)chareg_det.get("patnetamt"));
					}

					 gross_charge_amount_str  = dfTest.format(gross_charge_amount);
					 groos_pat_payable_str    = dfTest.format(groos_pat_payable);

					gross_charge_display_str.append("<label style='font-size:10;color:black' id='groos_pat_payable_str_").append(j).append("'>").append( gross_charge_amount_str).append("</label>");

					pat_charge_display_str.append("<label style='font-size:10;color:black' id='gross_charge_amount_str_").append(j).append("'>").append(groos_pat_payable_str).append("</label>");	
			 }

				 if(!gross_charge_amount_str.equals("") && !groos_pat_payable_str.equals("")){
			 	     tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat(gross_charge_amount_str);
					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat(groos_pat_payable_str);

					 tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
					 tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
				 }

        }

		}
		}else if(tpn_wrk_sht_details!=null && tpn_wrk_sht_details.size() > 0){
			for(int tws=0; tws<tpn_wrk_sht_details.size(); tws+=15){
				osmolar_value = "";
				osmolar_value_lt = "";
				pres_qty_range = 0;
				range_buffer = new StringBuffer();
				if(const_generic_code.equals((String)tpn_wrk_sht_details.get(tws))){
					ALLOC_QTY_UOM=(String)tpn_wrk_sht_details.get(tws+1);
					ITEM=(String)tpn_wrk_sht_details.get(tws+2);
					ALLOC_QTY=(String)tpn_wrk_sht_details.get(tws+3);
					BATCH=(String)tpn_wrk_sht_details.get(tws+4);
					EXPIRY_DATE=(String)tpn_wrk_sht_details.get(tws+5);
					ISSUE_QTY=(String)tpn_wrk_sht_details.get(tws+6);
//					LastDerivedValue=((String)rec.get("LastDerivedValue"+j)).equals("")?"0":(String)rec.get("LastDerivedValue"+j);
					trade_id=(String)tpn_wrk_sht_details.get(tws+7);
					bin_locn_code=(String)tpn_wrk_sht_details.get(tws+8);
					stock_uom=(String)tpn_wrk_sht_details.get(tws+9);
					QTY_UOM=(String)tpn_wrk_sht_details.get(tws+10);
					equvl_value=(String)tpn_wrk_sht_details.get(tws+11);
					concentration_percent=(String)tpn_wrk_sht_details.get(tws+12);
					manufacture_var_percentage=(String)tpn_wrk_sht_details.get(tws+13);



         if(!ISSUE_QTY.equals("")&&billing_interface_yn.equals("Y")){
            batch_str				  = new StringBuffer();
			//gross_charge_display_str  = new StringBuffer();
			//pat_charge_display_str    = new StringBuffer();

			batch_str.append(trade_id).append(";").append(BATCH).append(";").append(EXPIRY_DATE).append(";").append(bin_locn_code).append(";").append(ISSUE_QTY+"").append(";");
           double issued_qty                      =   Double.parseDouble(ISSUE_QTY);
           HashMap  chareg_det  = (HashMap)bean_2.callItemChargeDtls(patient_id,bean_1.getEncounterID(),bean_2.getEncounterPatientClass(bean_1.getEncounterID(),patient_id ),ITEM, issued_qty, batch_str.toString(), bean_1.getTodaysDate(),locn_code,"","",order_id,"1",bean_1.getDispStage(),dischargeIND); // patient_id for getEncounterPatientClass added for [IN:035667] 

            String err_msg   =(String)chareg_det.get("error_msg");

			decimalFormatString         = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			 if(err_msg.equals("")){
					

					if(!chareg_det.get("grosschargeamt").equals("null")){
						 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
					}
					if(!chareg_det.get("patnetamt").equals("null")){
						groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
					}

					 gross_charge_amount_str  = dfTest.format(gross_charge_amount);
					 groos_pat_payable_str    = dfTest.format(groos_pat_payable);

					gross_charge_display_str.append("<label style='font-size:10;color:black' id='groos_pat_payable_str_").append(j).append("'>").append(gross_charge_amount_str).append("</label>");

					pat_charge_display_str.append("<label style='font-size:10;color:black' id='gross_charge_amount_str_").append(j).append("'>").append(groos_pat_payable_str).append("</label>");	
			 }
			  if(!gross_charge_amount_str.equals("") && !groos_pat_payable_str.equals("")){
			 	     tot_gross_charge_amt = tot_gross_charge_amt + Float.parseFloat(gross_charge_amount_str);
					 tot_pat_payable_amt  = tot_pat_payable_amt  + Float.parseFloat(groos_pat_payable_str);

					 tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amt);
					 tot_groos_pat_payable_str	 = dfTest.format(tot_pat_payable_amt);
			  }




        }


if((!((String)initalDetails.get(i+1)).equals("EL")) && !ALLOC_QTY.equals("")){
					pres_qty_range = new Float(Math.ceil((Float.parseFloat(String.valueOf(manufacture_var_percentage))/100)* Float.parseFloat(String.valueOf(ALLOC_QTY)))).intValue();
					min_qty =  Float.parseFloat(String.valueOf(ALLOC_QTY)) - pres_qty_range;
					max_qty =  Float.parseFloat(String.valueOf(ALLOC_QTY)) + pres_qty_range;
					range_buffer.append("( ");
					range_buffer.append(min_qty);
					range_buffer.append(" ~ ");
					range_buffer.append(max_qty);
					range_buffer.append(" )");
}
					osmolar_value=(String)tpn_wrk_sht_details.get(tws+14);
					if(!osmolar_value.equals("") && !ITEM.equals("")){
						osmolar_value_lt = bean.roundTwoDigits((Float.parseFloat(osmolar_value) * Float.parseFloat(ISSUE_QTY) / 1000)+"");
					}
					if(!osmolar_value.equals("")){
						ws_osmo_value = ws_osmo_value + Float.parseFloat(String.valueOf(osmolar_value_lt)); 
					}
					break;
				}
			}
		
		}else{
			dflt_lkp_vsblty = "hidden";
			if(!((String)initalDetails.get(i+7)).equals("")){
				ITEM = (String)initalDetails.get(i+7);
				dflt_lkp_vsblty = "visible";
			}else{
				ITEM = "";
				dflt_lkp_vsblty = "hidden";
			}
		}

	


            _bw.write(_wl_block33Bytes, _wl_block33);

		if (!curr_group.equals(prev_group)) {

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( curr_group ));
            _bw.write(_wl_block35Bytes, _wl_block35);

		
		}
			const_remarks	  = (String)initalDetails.get(i+8);
			beyond_dsg_rsn	  = (String)initalDetails.get(i+9);
			not_to_be_ordered = (String)initalDetails.get(i+10);
			  //Adding start for ML-MMOH-CRF-1201
			  if(!ITEM.equals("")){
            itemvalues = bean.getItemValues(curr_group_code,ITEM);
			//System.err.println("itemvalues.size()===="+itemvalues.size());
			if(itemvalues.size()>0){
			for(int k=0;k<itemvalues.size();k+=2){
              item_concentration_percent =(String)itemvalues.get(k)==null?"":(String)itemvalues.get(k);
			  item_volume =(String)itemvalues.get(k+1)==null?"":(String)itemvalues.get(k+1);
			   }
			   }
			  }
		//	System.err.println("item_concentration_percent=-=="+item_concentration_percent+"item_volume==="+item_volume);
			//Adding end for ML-MMOH-CRF-1201
			String ordered_class = "label";
			if(not_to_be_ordered.equals("Y")){ordered_class = "AMENDEDDRUGS";}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+1) ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+2) ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+8) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+9) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
if(beyond_dsg_rsn != null && !beyond_dsg_rsn.equals("")){
					ordered_class = "DOSELIMIT";
					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ordered_class));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(beyond_dsg_rsn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(beyond_dsg_rsn));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(curr_group_code.equals("EL")){
						constPrecepInfo = (ArrayList)bean.getConstPreciptInfo((String)initalDetails.get(i+2));
			
						if(constPrecepInfo != null){
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( initalDetails.get(i+2) ));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block52Bytes, _wl_block52);
}
					 }else{
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(ordered_class));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(curr_group_code.equals("EL")){
						constPrecepInfo = (ArrayList)bean.getConstPreciptInfo((String)initalDetails.get(i+2));

						if(constPrecepInfo != null){
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( initalDetails.get(i+2) ));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block58Bytes, _wl_block58);
}
					 }else{
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
if(const_remarks != null && !const_remarks.equals("")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(const_remarks));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(const_remarks));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( initalDetails.get(i+3) ));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( initalDetails.get(i+3) ));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid") ){
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+4) ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( initalDetails.get(i+5) ));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+4) ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(initalDetails.get(i+5)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+6) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid") ){
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+4) ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(range_buffer.toString()));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(initalDetails.get(i+5)));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( initalDetails.get(i+6) ));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(!not_to_be_ordered.equals("Y") && !curr_group.equals("Fluid")){
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ALLOC_QTY));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ALLOC_QTY_UOM));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ALLOC_QTY));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(ALLOC_QTY_UOM));
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ALLOC_QTY_UOM));
            _bw.write(_wl_block95Bytes, _wl_block95);

		if (!curr_group.equals(prev_group)) {

            _bw.write(_wl_block96Bytes, _wl_block96);

			prev_group = curr_group;
		}

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
	String item = "";
					String desc	= "";
					System.err.println("@2@@@==="+(String)initalDetails.get(i+2)+"order_id==="+order_id+"locn_code==="+locn_code);
					ArrayList item_list	= bean.getItemList((String)initalDetails.get(i+2), order_id, locn_code,tpn_change_mmoh,patient_id);//tpn_change_mmoh,patient_id added for ML-MMOH-CRF-1201

					String selected="";
					if(item_list != null){
							 for(int t=0;t<item_list.size();t+=2){
								 item=(String)item_list.get(t);
								 desc=(String)item_list.get(t+1);
								 if (item.equals(ITEM)){
									 selected="selected";
								 }else{
									selected="";
								 }

				
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( item ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf( desc ));
            _bw.write(_wl_block109Bytes, _wl_block109);

					}}
				
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(dflt_lkp_vsblty));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(j));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(osmolar_value_lt));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(osmolar_value));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(BATCH));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(EXPIRY_DATE));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(iMaxLength));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(iNoOfDecimals));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(j));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(ISSUE_QTY));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(QTY_UOM));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(j));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(j));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(j));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(j));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(j));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(j));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(j));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(equvl_value));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(j));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(j));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(concentration_percent));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(j));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(j));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(LastDerivedValue));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(j));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(j));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(manufacture_var_percentage));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(j));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(j));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(trade_id));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(j));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(j));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(bin_locn_code));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(j));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(j));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(j));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(j));
            _bw.write(_wl_block160Bytes, _wl_block160);
if(billing_interface_yn.equals("Y")){
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(gross_charge_display_str.toString()));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(j));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(pat_charge_display_str.toString()));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(j));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(j));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(gross_charge_amount_str));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(j));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(j));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(groos_pat_payable_str));
            _bw.write(_wl_block169Bytes, _wl_block169);

				  gross_charge_display_str  = new StringBuffer();
			      pat_charge_display_str    = new StringBuffer();
				  
			  }
            _bw.write(_wl_block170Bytes, _wl_block170);
	
}

            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(ordered_volume));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(presc_base_unit));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(decimalFormatString));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(dischargeIND));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(tpn_change_mmoh));
            _bw.write(_wl_block182Bytes, _wl_block182);
if((tpn_vals != null) && (tpn_vals.size() >0) ){
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(tpn_qty));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tpn_uom));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(params));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tpn_qty));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(tpn_uom));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
            _bw.write(_wl_block189Bytes, _wl_block189);
if((tpn_wrk_sht_details != null && tpn_wrk_sht_details.size() > 0) || (prevWSVls!=null && prevWSVls.size()>0)){
				ws_osmo_value_lt = bean.roundTwoDigits(((ws_osmo_value*1000) /Float.parseFloat(tpn_qty))+"");
			
			
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(ws_osmo_value));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(ws_osmo_value_lt));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(ws_osmo_value));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(ws_osmo_value_lt));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(params));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ws_osmo_value));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(ws_osmo_value_lt));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(tpn_qty));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(tpn_uom));
            _bw.write(_wl_block188Bytes, _wl_block188);
}else{
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(params));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(tot_groos_pat_payable_str));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(tot_gross_charge_amount_str));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
            _bw.write(_wl_block200Bytes, _wl_block200);
	
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_1,bean_1,request);

		}catch(Exception e){
	         e.printStackTrace();
        } finally{ // Adding start for ML-MMOH-CRF-1201
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}// Adding end for ML-MMOH-CRF-1201

            _bw.write(_wl_block201Bytes, _wl_block201);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverageVolume.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DisplaySection.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Constituents.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Actual.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Overrage.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AvRecQty.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculationSection.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CalculationSection.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Osmolarity.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueQuantity.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeAmount.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PayableAmount.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
