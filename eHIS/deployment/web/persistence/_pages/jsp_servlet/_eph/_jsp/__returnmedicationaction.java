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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __returnmedicationaction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReturnMedicationAction.jsp", 1740137874255L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n4/1/2021\t\t10576\t\t\tShazana\t\t\t\t\tMMS-DM-CRF-0174.4\n07/09/2021      TFS-12410       Prabha\t\t\tAlpha -PH- Return Medication invalid barcode\n--------------------------------------------------------------------------------------------------------------\n--> \n ";
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

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/ReturnMedication.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<!-- <SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/PhMessages.js\"></SCRIPT> -->\n\t</head>\n<!--<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >-->\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form id=\"FormReturnMedicationAction\" name=\"FormReturnMedicationAction\" id=\"FormReturnMedicationAction\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tparent.retmedicationplineframe.location.href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t</script>\n\t   \n\t\t\t\t\t<TABLE   cellspacing=\"0\" cellpadding=\"0\" border=\"1\" width = \"120%\">     \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t    <td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t    <input type=\"checkbox\" name=\"Selcet_chk\" id=\"Selcet_chk\" value=\'\' onClick=\"SelectAll(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\"></td>\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=15%>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td >\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  width=26%>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'  width=10%>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td >\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td> \n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td > \n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td >\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=8%>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td > \n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=16%>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=5%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> \n\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<TR > \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t\t\t\t\t\t    <td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><input type=\"checkbox\" name=\"check_name";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"check_name";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onClick=\"selectCheck(";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\"></td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\"font-family:verdana;font-size:8pt;\" >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t  <TD class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" style=\"font-family:verdana;font-size:8pt;\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")</label>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" style=\"font-family:verdana;font-size:8pt;\" >\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" style=\"font-family:verdana;font-size:8pt;\" >\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<!--Passed UTF-8 for prac_name,dis_cont_reason regarding incident num:26239 ==By Sandhya===03/FEB/2011  -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<label\tonmouseover=\"changeCursor(this);\" onclick=\"callDiscontinue(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\">\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'></img></label>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t<td>&nbsp;&nbsp;</td> \n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t<TD align=\"\" style=\"background-color:#CC9999\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</TD>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" align=\"\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" style=\"font-family:verdana;font-size:8pt;\" nowrap>\n\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td><!-- changed 16 to 40 for ML-BRU-SCF-1880 -->\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" style=\"font-family:verdana;font-size:10pt;\" >\n\t\t\t\t\t\t\t\t<SELECT name=\"acknow_ledg";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"acknow_ledg";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onChange = \"setFieldValue(";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =",this,";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =");\">\n\t\t\t\t\t\t\t\t <OPTION value=\"\">---";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="----</OPTION>\n\t\t\t\t\t\t\t\t <OPTION value=\"A\" selected>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</OPTION>\n\t\t\t\t\t\t\t\t <OPTION value=\"R\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</OPTION>\n\t\t\t\t\t\t\t\t <OPTION value=\"P\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</OPTION>\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t</SELECT> \n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" style=\"font-family:verdana;font-size:10pt;\" >\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"AcceptedQty";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"AcceptedQty";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" size=\"4\"  maxlength=\"4\" value = \"\" onKeyPress=\"return allowValidNumber(this,event,4,0);\" onBlur = \"getBalance(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =",this,RejectedQty";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =",BalanceQty";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =",";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =",\'A\')\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" size=\"4\"  maxlength=\"4\" value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" onKeyPress=\"return allowValidNumber(this,event,4,0);\" onBlur = \"getBalance(";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =",\'A\')\" disabled></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" style=\"font-family:verdana;font-size:10pt;\" >\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"RejectedQty";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"RejectedQty";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" size=\"4\"  maxlength=\"4\" value = \"0\" onKeyPress=\"return allowValidNumber(this,event,4,0);\" onBlur = \"getBalance(";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =",AcceptedQty";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =",this,BalanceQty";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =",\'R\')\"disabled></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" style=\"font-family:verdana;font-size:10pt;\" >\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"BalanceQty";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"BalanceQty";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" readonly></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" size=\"4\"  maxlength=\"4\" value = \"0\" readonly></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" style=\"font-family:verdana;font-size:8pt;\" >\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t<select name=\"bin_location_code";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"bin_location_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"  >\n\t\t\t\t\t\t\t\t\t<OPTION value=\"\">---";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="----</OPTION>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" selected>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</option>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img name=\"bin_mandatory";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"><font style=\"font-size:9;cursor:pointer\" class=\"HYPERLINK\" class=\"HYPERLINK\" >\n\t\t\t\t\t\t\t\t<label\tonmouseover=\"changeCursor(this);\" name=\"checkremark\" onclick=\"Remarks(\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\');\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</label></font>\n\t\t\t\t\t\t\t\t<img name=\"mandatory";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" Style=\"visibility:hidden\" src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"remarks_desc";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"remarks_desc";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" value=\"\" >\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"returnable";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"returnable";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"  value=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"doc_type";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"doc_type";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"   value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"doc_no";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"doc_no";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"     value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"store_code";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"store_code";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_code";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"item_code";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_qty";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"disp_qty";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"uom_code";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"uom_code";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"><!-- changed from 16 to 40 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"batch_id";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"trade_id";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"expiry_date";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"returned_by";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"returned_by";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"return_reason";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"return_reason";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ret_doc_no";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"ret_doc_no";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ret_doc_line_no";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"ret_doc_line_no";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispno";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"dispno";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srlno";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"srlno";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srlnobatch";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"srlnobatch";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"actualReturn";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" id=\"actualReturn";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sal_doc_srlno";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"sal_doc_srlno";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sal_bin_location_code";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" id=\"sal_bin_location_code";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"return_reason_code";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"return_reason_code";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"> <!-- added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dis_charge_ind";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" id=\"dis_charge_ind";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"><!-- added for skr-scf-0591 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"modified_date";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" id=\"modified_date";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"><!-- added for SKR-SCF-0393 [IN:030939] -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" id=\"order_id";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" id=\"order_line_no";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"barcode_id";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"barcode_id";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"><!--  Added for GHL-CRF-0413.8[IN063028] -->\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"totalRows1\" id=\"totalRows1\" VALUE=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.retmedicationbuttonframe.location.href=\"../../ePH/jsp/ReturnMedicationButton.jsp?countRows=\"+";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =";\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t<script>alert(getMessage(\"PH_ATLEAST_ONE_SELECTED\",\"PH\"));</script> \n\t\t                ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t <script type=\"text/javascript\">\n\t\t\t\t\t\t\t   var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;\n\t\t\t\t\t\t\t\tvar formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;\n\t\t\t\t\t\t\t\tcheckcount=formObjdrug.total_count.value;\n\t\t\t\t\t\t\t\tvar drug=\"\"+\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\';\n\t\t\t\t\t\t\t\t//var drug=\"N02BA011\";\n\t\t\t\t\t\t\t\tfor (var i=1;i<=checkcount;i++ ){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(eval(\"formObjdrug.drug_id\"+i).value == drug)  //Added for IN032747 - end\n\t\t\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t\t\t\t\t   eval(\"formObjdrug.barcode_id\"+i).value=formObj.barCodeId.value;\n\t\t\t\t\t\t\t\t\t       if( eval(\"formObjdrug.check_id\"+i).checked == false){\n\t\t\t\t\t\t\t\t\t    \t   eval(\"formObjdrug.check_id\"+i).checked=true;\n\t\t\t\t\t\t\t\t\t    \t  \n\t\t\t\t\t\t\t\t\t       }\n\t\t\t\t\t\t\t\t\t       formObjdrug.SelectAll.disabled=true; \n\t\t\t\t\t\t\t\t\t       formObj.proceed.disabled=true;//Addded for ICN 63722\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tformObj.barCodeId.value=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tformObj.barCodeId.focus();\n\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t </script>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t<script>alert(getMessage(\"NOT_A_VALID_BARCODE\",\"PH\")); \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;\n\t\t\t\t\t\t\t\tvar formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;\n\t\t\t\t\t\t\t\tcheckcount=formObjdrug.total_count.value;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor (var i=1;i<=checkcount;i++ ){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\teval(\"formObjdrug.check_id\"+i).disabled=false;\n\t\t\t\t\t\t\t\t\t\t formObjdrug.SelectAll.checked=false;\n\t\t\t\t\t\t\t\t\t\t formObjdrug.SelectAll.disabled=false;\n\t\t\t\t\t\t\t\t\t\t  formObj.proceed.disabled=false;//Added for ICN\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tformObj.barCodeId.value=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tformObj.barCodeId.focus();\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\t\n\t\t\t\t      ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t <script type=\"text/javascript\">\n\t\t\t\t\t\t\t   var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;\n\t\t\t\t\t\t\t\tvar formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;\n\t\t\t\t\t\t\t\tcheckcount=formObjdrug.total_count.value;\n\t\t\t\t\t\t\t\tvar drug=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\';\n\t\t\t\t\t\t\t\t//var drug=\"N02BA011\";\n\t\t\t\t\t\t\t\tfor (var i=1;i<=checkcount;i++ ){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif(eval(\"formObjdrug.drug_id\"+i).value == drug)  //Added for IN032747 - end\n\t\t\t\t\t\t\t\t\t{ \n\t\t\t\t\t\t\t\t\t\t   eval(\"formObjdrug.barcode_id\"+i).value=formObj.barCodeId.value;\n\t\t\t\t\t\t\t\t\t       if( eval(\"formObjdrug.check_id\"+i).checked == false){\n\t\t\t\t\t\t\t\t\t    \t   eval(\"formObjdrug.check_id\"+i).checked=true;\n\t\t\t\t\t\t\t\t\t    \t  \n\t\t\t\t\t\t\t\t\t       }\n\t\t\t\t\t\t\t\t\t       formObjdrug.SelectAll.disabled=true;    \n\t\t\t\t\t\t\t\t\t       formObj.proceed.disabled=true;//Added for ICN 63722\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tformObj.barCodeId.value=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tformObj.barCodeId.focus();\n\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t </script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t<script>alert(getMessage(\"NOT_A_VALID_BARCODE\",\"PH\")); \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;\n\t\t\t\t\t\t\t\tvar formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;\n\t\t\t\t\t\t\t\tcheckcount=formObjdrug.total_count.value;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tfor (var i=1;i<=checkcount;i++ ){\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t// eval(\"formObjdrug.check_id\"+i).checked=false;\n\t\t\t\t\t\t\t\t\t\t eval(\"formObjdrug.check_id\"+i).disabled=false;\n\t\t\t\t\t\t\t\t\t\t formObjdrug.SelectAll.checked=false;\n\t\t\t\t\t\t\t\t\t\t formObjdrug.SelectAll.disabled=false;\n\t\t\t\t\t\t\t\t\t\t  formObj.proceed.disabled=false;//Added for ICN 63722\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tformObj.barCodeId.value=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tformObj.barCodeId.focus();\n\t\t\t\t\t\t\t\t</script>\t\n\t\t\t\t      ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;\n\t\t\t\t\t\t\tvar formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;\n\t\t\t\t\t\t\tformObj.barCodeId.value=\"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tformObj.barCodeId.focus();\n\t\t\t\t\t\t\t</script>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t<TABLE width=\"100%\" align=\"left\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\">\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t<Th colspan=14 style=\"background-color:#FFD7D7;color:black;border-color:#FFD7D7\" align=\"left\">";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</Th>\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t   <Td width=\"10%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t   <input type=checkbox name=\"SelectAll\" id=\"SelectAll\" id=\"SelectAll\"  onClick=\"selectAllWithOutWardReturn(this)\"></td >\n\t\t\t\t\t\t\t   <td class=\'COLUMNHEADER\'  width=26%>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=8%>";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td >  \n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</td >\n";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=10%>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td > \n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=6%>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=12%>";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</td >\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=14%>";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="</td > \n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=3%>";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td >       \n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t<TR >\n\t\t\t\t\t\t\t\t\t\t<TD  class=";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" style=\"font-family:verdana;font-size:8pt;\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"Checkbox\"  name=\"check_return_name";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"  id=\"check_return_id";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" value=\"N\"  onClick=\"AssignValueWithOutWardReturn(this,\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" style=\"font-family:verdana;font-size:8pt;\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"font-size:xx-small;font-weight:normal\" >(";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" style=\"font-family:verdana;font-size:8pt;\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispno";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\"  id=\"dispno";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 =">\n\t\t\t\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" style=\"font-family:verdana;font-size:8pt;\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispfacility";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" id=\"dispfacility";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="><!--  CR-091- Added DispFacility for  Grid -->\n\t\t\t\t\t\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\t\t\t\t\t\t\t\t\t\t<TD  class=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" style=\"font-family:verdana;font-size:8pt;\"  align=\"right\" nowrap>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t\t\t\t\t\t<br><b>";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="<b>\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="<!-- changed from 16 to 40 -->\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<TD align=\"right\" >";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t\t\t\t\t\t\t<TD align=\"right\" style=\"background-color:#CC9999\">";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t\t\t\t\t\t<TD  align=\"right\">";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t\t\t\t<select name=\"bin_location_code";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img name=\"bin_mandatory";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\"   src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></TD>\n\t\t\t\t\t\t\t\t\t\t<TD>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=text  maxlength=\'4\' size=\'4\' style=\"text-align:right\" name=\"actualReturn";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"  disabled value=\"1\" >}\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  maxlength=\'4\' size=\'4\' style=\"text-align:right\" name=\"actualReturn";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"  disabled  value=\"\" >\n\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"   id=\"actualReturn";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" onKeyPress=\"return allowValidNumber(this,event,3,0);\"onblur=\"CheckPositiveNumber(this);checkQty(this,";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 =",\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\');StoreCheck(";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =");\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\"  id=\"actualReturn";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =");\"> <!-- Value added for TFS-12410 -->\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\t\t\t\t\t\t<input type=text style=\"width:0px\" name=\"temp";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" id=\"temp";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"returnable";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srlno";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sal_doc_srlno";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"doc_type";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"doc_no";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"store_code";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"item_code";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"uom_code";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\"><!-- changed from 6 to 40 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_qty";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"trade_id";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"><!--  CR-091- Added MultiFacility flag changes.-->\n\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"expiry_date";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sal_bin_location_code";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"> \n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"srlnobatch";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"final_conv_factor";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\" id=\"final_conv_factor";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\" id=\"base_to_disp_uom_equl";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\"><!--added for AAKH-SCF-0195 [IN:054909]   --> \n\t\t\t\t\t\t\t\t\t\t<!--  CR-091- Added MultiFacility flag changes -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encounter_id";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\"> <!-- added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Sal_Facility_id";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" id=\"Sal_Facility_id";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Ord_Facility_id";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" id=\"Ord_Facility_id";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dis_charge_ind";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\"><!-- added for skr-scf-0591 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"barcode";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" id=\"barcode";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"><!-- Added for GHL-SCF-1084 -->\n                                         <input type=\"hidden\" name=\"ret_qty";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" id=\"ret_qty";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t<!--Passed UTF-8 for prac_name,dis_cont_reason regarding incident num:26239 ==By Sandhya===03/FEB/2011  -->\n\t\t\t\t\t\t\t\t\t\t\t<label\tonmouseover=\"changeCursor(this);\" onclick=\"callDiscontinue(\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'></img></label>\n\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t\t\t\t\t\t\t\t\t\t<td>&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t\t\t\t\t</TR>\n\t";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tparent.retmedicationbuttonframe.location.href=\"../../ePH/jsp/ReturnMedicationButton.jsp?countRows=\"+";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =";\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"totalrows\" id=\"totalrows\" VALUE=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"remarks\" id=\"remarks\" VALUE=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n\t\t\t\t\t\t</table>\n\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\n\t\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();</script>\n\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</Th>\n\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t   <td class=\'COLUMNHEADER\'  width=26%>";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t\t\t\t\t\t\t<TR >\n\t\t\t\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\" nowrap>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="<!--changed 6 to 38 for ML-BRU-SCF-1842 -->\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<TD align=\"right\" >";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\"  disabled id=\"actualReturn";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" value=\"0\" >\n";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 =");\">\n";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\"><!-- changed from 6 to 38 for ML-BRU-SCF-1880 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"batch_id";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\"><!-- Added for GHL-SCF-1084 -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.parent.reset();</script>\n\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t\t<INPUT TYPE=\"hidden\" name=\"eff_status\" id=\"eff_status\" VALUE=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"rej_qty\" id=\"rej_qty\" VALUE=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\t<!-- // Added for GHL-SCF-790 [IN:046481] -->\n\t\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patientid\" id=\"patientid\" VALUE=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"drugcodes\" id=\"drugcodes\" VALUE=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"disabledCoun\" id=\"disabledCoun\" VALUE=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\" VALUE=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"disp_cash_coll_stage\" id=\"disp_cash_coll_stage\" VALUE=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"patient_class\" id=\"patient_class\" VALUE=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" VALUE=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"barcodeFlag\" id=\"barcodeFlag\" VALUE=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\"> <!-- Added for GHL-CRF-0413.8[IN063028] -->\n\t\t\t<INPUT TYPE=\"hidden\" name=\"total_count\" id=\"total_count\" VALUE=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\"><!-- Added for GHL-CRF-0413.8[IN063028] -->\n\t\t</form>\n\t<!-- Added for GHL-CRF-0413.8[IN063028]  start-->\n\t";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\n                           <script>\n\t\t\t\t              IncreseQTY(\'";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\');\n\t\t\t                 </script>\n\t\t    ";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 =" <!-- Added for GHL-CRF-0413.8 end [IN063028] -->\n";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
			String bean_name	= "ePH.ReturnMedicationBean";
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			//bean.clear() ;
		try{

			bean.setLanguageId(locale);
			bean.setMode( mode ) ;
			String facility_id					= (String) session.getValue("facility_id");
			//Search Criteria's from Query Criteria page
			String patientid		= request.getParameter( "patientid" );
			String drugcodes		= request.getParameter( "drugcodes" );
			String drugcode			= request.getParameter( "drugcode" );
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String remarks     		= request.getParameter( "remarks" ) ;
			String patcat     		= request.getParameter( "patcat" ) ;
			String barcode	=  CommonBean.checkForNull(request.getParameter( "barcode"));//Added for GHL-CRF-043.8
			boolean valid_barcode=false;//Added for GHL-CRF-0413.8
			String Ward_Date_From   = CommonBean.checkForNull(request.getParameter( "Ward_Date_From" ) );
			String ward_Date_To     = CommonBean.checkForNull(request.getParameter( "ward_Date_To" )) ;
			String eff_status     	= CommonBean.checkForNull(request.getParameter( "eff_status" )) ;
			String From_Location    = CommonBean.checkForNull(request.getParameter( "From_Location" )) ;
			String encounter_id		=  CommonBean.checkForNull(request.getParameter( "encounter_id" ));
			String rej_qty			= CommonBean.checkForNull(request.getParameter( "rej_qty" )) ;	// Added for GHL-SCF-790  [IN:046481]
			String blDocType	=  CommonBean.checkForNull(request.getParameter( "blDocType" )); //Added for MMS-DM-CRF-0039 [IN:055958]
			String blDocNo	=  CommonBean.checkForNull(request.getParameter( "blDocNo" )); //Added for MMS-DM-CRF-0039 [IN:055958]

			StringBuffer issue_qty_dtl   = new StringBuffer(); 
			HashMap IssueUOMAndBaseUOM	 = new HashMap();
			HashMap binLocationDetails	 = new HashMap();
			ArrayList binLocation=new ArrayList();
			ArrayList result=new ArrayList();//Added for GHL-CRF-0413.8 
			ArrayList batchDetails=new ArrayList();//Added for GHL-CRF-0413.8
			int count=1;//Added for GHL-CRF-0413.8 
			String dflt_issue_uom		 = "";
			String base_uom			     = "";
			int base_to_disp_uom_equl    = 0;
			int base_to_def_uom_equl     = 0;
			int base_to_issue_uom_equl   = 0;
			int base_to_to_store_def_uom_equl =0;
			int final_conv_factor        = 0;
			String issue_uom_by			 = bean.getISSUE_UOM_BY ();

			String order_line_staus      = "";
			String Details          = "";
			String dis_cont_reason       = "";
			String DISC_DATE_TIME		 = "";
			String pract_name			 = "";
			String nationalid			 = "" ;
			String healthcard     		 = "" ;
			String drug_code     		 = "" ;
			
			String FormStore			 = CommonBean.checkForNull(request.getParameter( "FormStore" )) ; 

			String StoreCount			 = "" ;
			String to_store_def_issue_uom ="";
			String classvalue="", sal_disp_locn=""; //sal_disp_locn added for KDAH-SCF-0252 [IN:050489]
			int disabledCount			 = 0;
			boolean flag				 = false; //false; // SKR-SCF-0225 IN029331 -have to handle
			String barcodeFlag           = "";// Added for GHL-CRF-0413.8[IN063028]
			
			/* Initialize Function specific start */
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);

			}
			String bl_interface_yn      = "Y";
			//if(patcat !=null && patcat.equals("I"))
				//bl_interface_yn      = bean.checkforbillinginterface("IP");
			//else
				//bl_interface_yn      = bean.checkforbillinginterface("OP");
			//String disp_cash_coll_stage = bean.getDispCashCollStage();Commented for EMR-12.X-Alpha-PHIS-PH-Inc#2558
			//FormStore= CommonBean.checkForNull(bean.getFromStore());
			bean.setFromStore(FormStore);
			//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			String FacilityFlag=bean.getFacility_Flag();
			barcodeFlag = bean.getBarCodeflag((String)session.getValue("facility_id"), displocn); // Added for GHL-CRF-0413.8[IN063028]
			if(FacilityFlag.equals("")){
				FacilityFlag="N";	
			}	//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			if(eff_status.equals("E")){
				Ward_Date_From=com.ehis.util.DateUtils.convertDate(Ward_Date_From,"DMY",locale,"en");
				ward_Date_To=com.ehis.util.DateUtils.convertDate(ward_Date_To,"DMY",locale,"en");
				//parameter "patcat" added in the bellow method(bean.getWardBatchDetails) call for SRR20056-SCF-7414, Incident No. 27456
				ArrayList WardbatchDetails=bean.getWardBatchDetails(patientid,dispno,cutoff,orderid,FormStore,displocn,Ward_Date_From,ward_Date_To,From_Location,drugcode,encounter_id,patcat,rej_qty);// Added rej_qty for GHL-SCF-790 [IN:046481]
				int totalRows1=WardbatchDetails.size()/41; //changed from 37 to 39 for SKR-SCF-0393 [IN:030939] // changed from 39 to 40 for GHL-CRF-0413.8[IN063028] and 40 to 41 for ML-BRU-SCF-1842
				int disabledCount1 =0;
				bean.setStockDocType(patcat);

				if (WardbatchDetails.size()==0){

            _bw.write(_wl_block9Bytes, _wl_block9);

				}
				else{
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno+"&totalRows1="+totalRows1+"&eff_status="+eff_status;

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientUrl));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(barcodeFlag.equals("Y")){ // Added for GHL-CRF-0413.8[IN063028] -Start 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totalRows1));
            _bw.write(_wl_block14Bytes, _wl_block14);
} // Added for GHL-CRF-0413.8[IN063028] -End 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

						int rowCount=0;
						int count1=1;
						for (int i=0;i<WardbatchDetails.size();i+=41){ // Incremented 36 to 37 for AMS-SCF-0190 IN038440 // 38 to 39 for SKR-SCF-0393 [IN:030939] Changed 40 chaged for GHL-CRF-0413.8 and 40 to 41 for ML-BRU-SCF-1842
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}

            _bw.write(_wl_block26Bytes, _wl_block26);
 if(barcodeFlag.equals("Y")){ // Added for GHL-CRF-0413.8[IN063028] - Start 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block31Bytes, _wl_block31);
} // Added for GHL-CRF-0413.8[IN063028] - End 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)WardbatchDetails.get(i+8),"DMY","en",locale)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(WardbatchDetails.get(i)));
            _bw.write(_wl_block1Bytes, _wl_block1);
									
									if(bean.getTradeName_Flag().equals("Y") && WardbatchDetails.get(i+36)!=null && !WardbatchDetails.get(i+36).equals("")){ // if block Added for AMS-SCF-0190 IN038440

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(WardbatchDetails.get(i+36) ));
            _bw.write(_wl_block37Bytes, _wl_block37);

									}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(WardbatchDetails.get(i+7)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(CommonBean.checkForNull((String)WardbatchDetails.get(i+30))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(CommonBean.checkForNull((String)WardbatchDetails.get(i+31))));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(CommonBean.checkForNull((String)WardbatchDetails.get(i+32))));
            _bw.write(_wl_block42Bytes, _wl_block42);
 
								if(CommonBean.checkForNull(((String)WardbatchDetails.get(i+25))).equals("DC")){
									dis_cont_reason=CommonBean.checkForNull((String)WardbatchDetails.get(i+26));
									DISC_DATE_TIME=(String)WardbatchDetails.get(i+27);
									pract_name=CommonBean.checkForNull((String)WardbatchDetails.get(i+28));

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DISC_DATE_TIME));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block45Bytes, _wl_block45);

								}
								else{

            _bw.write(_wl_block46Bytes, _wl_block46);

								}
								// if disp-no is re-issued paint with a legend
								if(bean.checkReissued((String)WardbatchDetails.get(i+10))) {

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
								else {	

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block48Bytes, _wl_block48);
	
								}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,WardbatchDetails.get(i+40).toString())));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(barcodeFlag.equals("Y")){ // if,else condition added for GHL-CRF-0413.8[IN063028] - Start 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block68Bytes, _wl_block68);
} 
								else{ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block71Bytes, _wl_block71);
}  // if,else condition added for GHL-CRF-0413.8[IN063028] - End 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block77Bytes, _wl_block77);
 if(barcodeFlag.equals("Y")){ // if,else condition added for GHL-CRF-0413.8[IN063028] - Start 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block80Bytes, _wl_block80);
} else{ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block81Bytes, _wl_block81);
} //if,else condition added for GHL-CRF-0413.8[IN063028] - End 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block82Bytes, _wl_block82);

									drug_code=(String)WardbatchDetails.get(i+5);
									sal_disp_locn=(String)WardbatchDetails.get(i+4);//added for KDAH-SCF-0252 [IN:050489]
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

									 for(int j=0;j<binLocation.size();j++){
										binLocationDetails=(HashMap)binLocation.get(j);
										if(!sal_disp_locn.equals(displocn)){//FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
											if(binLocationDetails.get("Default_YN").equals("Y")){

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

											}
											else{	

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);
	     
											}
										}
										else{
											if(((String)binLocationDetails.get("bin_location_code")).equals(((String)WardbatchDetails.get(i+6)))){

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

											}
											else{	

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

											}
										}
									}//end for loop

            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(WardbatchDetails.get(i+2)));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(WardbatchDetails.get(i+3)));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(displocn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(WardbatchDetails.get(i+5)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(WardbatchDetails.get(i+40)));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(WardbatchDetails.get(i+7)));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(WardbatchDetails.get(i+9)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+8)));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+31)));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+32)));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+33)));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+34)));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+10)));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+11)));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+13)));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(WardbatchDetails.get(i+17)));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(WardbatchDetails.get(i+12)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+6)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+35)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+18)));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+37)));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+38)));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+19)));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+20)));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(count1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(WardbatchDetails.get(i+39)));
            _bw.write(_wl_block160Bytes, _wl_block160);

							count1++;
						}

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(totalRows1));
            _bw.write(_wl_block162Bytes, _wl_block162);

				}//end else

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(totalRows1-disabledCount1));
            _bw.write(_wl_block164Bytes, _wl_block164);

			}
			//If Condtion Added for GHL-CRF-0413.8 START
			if(eff_status.equals("D")){	
				System.out.println("barcode"+barcode+"drugcodes"+drugcodes);
			//if is added for ghl-crf-0413.8
			if(barcodeFlag.equals("Y")){
					
					if(drugcodes.equals("") && barcode.equals("")){
							
            _bw.write(_wl_block165Bytes, _wl_block165);
	
						}
					 else if(drugcodes.equals("") && !barcode.equals("")){
						ArrayList barcode_details=bean.getNewBarcodeArry();
						//System.err.println("@@@======"+barcode_details.get(0));
						if(barcode_details.contains(barcode)){
							batchDetails=barcode_details;
						bean.setFlag_empty(true);//added for ICN 63764
						}else{
					      
						   batchDetails= bean.getbatchdetailWithCodeFunction(patientid,"' ',",nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,barcode);
						   
						 
						}
						// batchDetails.add(barcode_details.get(0));
						  
						 //System.out.println("result"+batchDetails); 
						 int size=batchDetails.size();
						 
						 if(bean.isFlag_empty()){
							 valid_barcode=true;
							 System.out.println("drug code"+batchDetails.get(15));
							 
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(batchDetails.get(15)));
            _bw.write(_wl_block167Bytes, _wl_block167);

						 }
						 else{
							 
            _bw.write(_wl_block168Bytes, _wl_block168);

						 }

					}
					else if(!drugcodes.equals("") && !barcode.equals("")){
					
					//	batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag);//commented for MMS-DM-CRF-0174.4
						
						batchDetails= bean.getbatchdetailWithCodeFunction(patientid,"' ',",nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,barcode);
						
						
						int size=batchDetails.size();
						 
						 if(bean.isFlag_empty()){
							 valid_barcode=true;
							 System.out.println("drug code"+batchDetails.get(15));
							 
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(batchDetails.get(15)));
            _bw.write(_wl_block170Bytes, _wl_block170);

							  
						 
						 }
						 else{
							 
            _bw.write(_wl_block171Bytes, _wl_block171);

						 }

					
					}
					else{
						
						 batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					
					
            _bw.write(_wl_block172Bytes, _wl_block172);

					 }
					System.out.println(batchDetails.size()+"prathyusha");
					if(batchDetails.size()!=0   ){//  ArrayList batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					bean.setStockDocType(patcat);
					int totalRows=batchDetails.size()/41; //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented 31 to 32. //35 to 36 for SKR-SCF-0591//Changed 36 38 for GHL-SCF-1084 and 40 to 41 for ML-BRU-SCF-1842
					int administred_count =0;
							
			
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

								if((FacilityFlag.equals("Y"))){

            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

								}

            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

							int rowCount=0;
						
							
							for (int i=0;i<batchDetails.size();i+=41){ // srice from 30 to 31 changed for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented i+=32 to i+=33.  //Incremented i+=32 to i+=33.//IN-38440 & AMS-SCF-0190.Incremented i+=33 to i+=34 //38 is changed to 40 for bar code crf ghl-crf-0413.8 and 40 to 41 for ML-BRU-SCF-1842
							//changed 36 to 38  for GHL-SCF-1084
								if ( rowCount++ % 2 == 0 ){
									classvalue = "QRYEVEN" ;
								}
								else{
									classvalue = "QRYODD" ;
								}
								if(!batchDetails.get(i+19).equals("0")){ // above if condition Commented and this one added SKR Live issue
									flag   =	true;   
									/*====================variable uom====================*/                   
									issue_qty_dtl			 =  new StringBuffer(); 
									IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),displocn);

									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
									to_store_def_issue_uom   = 	(String)batchDetails.get(i+28);
									StoreCount="0";
									if(!to_store_def_issue_uom.equals("")){	
										StoreCount="1";
									}

									drug_code=(String)batchDetails.get(i+15);
									Details=(String)batchDetails.get(i+6);
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
									sal_disp_locn = (String)batchDetails.get(i+14); //Added for  KDAH-SCF-0252 [IN:050489]

									base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
									base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);	
									base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);
									base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); //added and commented for AAKH-SCF-0195 [IN:054909] 
									//final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl); // commented for AAKH-SCF-0195 [IN:054909] 
									final_conv_factor        =	bean.lcm( base_to_def_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0195 [IN:054909] 
									if(base_to_disp_uom_equl !=0 &&  base_to_def_uom_equl!=0 && !((String)batchDetails.get(i+21)).equals("")) //added for AAKH-SCF-0129 [IN:050557]
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )");
									if(base_to_disp_uom_equl != base_to_def_uom_equl){ //condition changed from != 0 to this condition
									//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0){
										if(!((String)batchDetails.get(i+21)).equals("")){						  
											if(issue_uom_by.equals("I")){
												base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); 
												if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
													final_conv_factor   =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
												} 
												else{
													//final_conv_factor     =	bean.lcm( final_conv_factor,base_to_issue_uom_equl); //commented for AAKH-SCF-0129 [IN:050557]
													final_conv_factor     =	bean.lcm( base_to_disp_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0129 [IN:050557]
												}
											}	
											//issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )"); //moved above
										}
											
										 if(final_conv_factor>1){ // Added for ML-BRU-SCF-1880 - Start
											 final_conv_factor =final_conv_factor/base_to_disp_uom_equl;
										   } // Added for ML-BRU-SCF-1880 - End
									}
	/*====================variable uom====================*/
	
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(count));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(count));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(count));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i)));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(bean.getTradeName_Flag().equals("Y") && batchDetails.get(i+33)!=null && !batchDetails.get(i+33).equals("")){ // if block Added for AMS-SCF-0190 IN038440

            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(batchDetails.get(i+33) ));
            _bw.write(_wl_block37Bytes, _wl_block37);

										}

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+1)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+23)));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(count));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block199Bytes, _wl_block199);

										if((FacilityFlag.equals("Y"))){

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(batchDetails.get(i+31)));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(count));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+31)));
            _bw.write(_wl_block204Bytes, _wl_block204);

										}

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(batchDetails.get(i+5)));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(issue_uom_by.equals("I")){

            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block208Bytes, _wl_block208);

										}

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,batchDetails.get(i+40).toString())));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(batchDetails.get(i+19)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										// if disp-no is re-issued paint with a legend
										if(bean.checkReissued((String)batchDetails.get(i+3))) {

            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(batchDetails.get(i+7)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										}
										else {	

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(batchDetails.get(i+7)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										}

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block214Bytes, _wl_block214);

										for(int j=0;j<binLocation.size();j++){
											binLocationDetails=(HashMap)binLocation.get(j);
											if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
												if(binLocationDetails.get("Default_YN").equals("Y")){

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
												else{	

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);
	
												}
											}
											else{
												if(((String)binLocationDetails.get("bin_location_code")).equals(((String)batchDetails.get(i+16)))){

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
												else{	

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
											}
										}//end for loop

            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(count));
            _bw.write(_wl_block217Bytes, _wl_block217);
 
										if (batchDetails.get(i+11).equals("N")){
											disabledCount++;

											if(valid_barcode){
												
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count));
            _bw.write(_wl_block219Bytes, _wl_block219);
 }else{
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count));
            _bw.write(_wl_block221Bytes, _wl_block221);
										}

										}
										else{

											if(valid_barcode){
											
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+38)));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count-1));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
}else{
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(batchDetails.get(i+38)));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count-1));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
											}

										}

            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(i));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+19)));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+9)));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+17)));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+12)));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(count));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(batchDetails.get(i+13)));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(count));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(displocn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(count));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(batchDetails.get(i+15)));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+40)));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(count));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+1)));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+5)));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+29)));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(batchDetails.get(i+2)));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(count));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+16)));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+10)));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(count));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(count));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(count));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+30)));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(count));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+32)));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(count));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+34)));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+35)));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(count));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+36)));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(count));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+37)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(count));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+39)));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(count));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+38)));
            _bw.write(_wl_block261Bytes, _wl_block261);

										order_line_staus=(String)batchDetails.get(i+27);
										dis_cont_reason=(String)batchDetails.get(i+26);
										DISC_DATE_TIME=(String)batchDetails.get(i+27);
										DISC_DATE_TIME=com.ehis.util.DateUtils.convertDate(DISC_DATE_TIME,"DMYHM","en",locale);
										pract_name=(String)batchDetails.get(i+28);

										if(((String)batchDetails.get(i+25)).equals("DC")){
	
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DISC_DATE_TIME));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block263Bytes, _wl_block263);

										}
										else{
	
            _bw.write(_wl_block264Bytes, _wl_block264);

										}
	
            _bw.write(_wl_block265Bytes, _wl_block265);

								   count++;
									//document.FormReturnMedicationAction.actualReturn1.focus();
								} 
								else{
								   //count++;
								   administred_count++;
								}
								}//end for loop
	
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(totalRows-disabledCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf( totalRows-administred_count ));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf( remarks ));
            _bw.write(_wl_block269Bytes, _wl_block269);

						if(!flag){
	
            _bw.write(_wl_block270Bytes, _wl_block270);

						}
					
				
            _bw.write(_wl_block271Bytes, _wl_block271);

				}}
				
				else	{
                     batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					bean.setStockDocType(patcat);
					int totalRows=batchDetails.size()/39; //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented 31 to 32. //35 to 36 for SKR-SCF-0591//Changed 36 38 for GHL-SCF-1084 and 38 to 39 for ML-BRU-SCF-1842
					int administred_count =0;
					if (batchDetails.size()==0){
	
            _bw.write(_wl_block272Bytes, _wl_block272);

					}
					else{
	
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

								if((FacilityFlag.equals("Y"))){

            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

								}

            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

							
							int rowCount=0;
						//	int chk_c=1;
							/* if(result.size()!=0)
							{System.out.println("in new for");
							for(int i=0;i<result.size();i++){
								
							}
							} */
							for (int i=0;i<batchDetails.size();i+=39){ // srice from 30 to 31 changed for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented i+=32 to i+=33.  //Incremented i+=32 to i+=33.//IN-38440 & AMS-SCF-0190.Incremented i+=33 to i+=34 and 38 to 39 for ML-BRU-SCF-1842
							//changed 36 to 38  for GHL-SCF-1084
								if ( rowCount++ % 2 == 0 ){
									classvalue = "QRYEVEN" ;
								}
								else{
									classvalue = "QRYODD" ;
								}
								flag   =	true;
								if(!batchDetails.get(i+19).equals("0")){ // above if condition Commented and this one added SKR Live issue
									flag   =	true;   
									/*====================variable uom====================*/                   
									issue_qty_dtl			 =  new StringBuffer(); 
									IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),displocn);

									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
									to_store_def_issue_uom   = 	(String)batchDetails.get(i+28);
									StoreCount="0";
									if(!to_store_def_issue_uom.equals("")){	
										StoreCount="1";
									}

									drug_code=(String)batchDetails.get(i+15);
									Details=(String)batchDetails.get(i+6);
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
									sal_disp_locn = (String)batchDetails.get(i+14); //Added for  KDAH-SCF-0252 [IN:050489]

									base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
									base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);	
									base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);
									base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); //added and commented for AAKH-SCF-0195 [IN:054909] 
									//final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl); // commented for AAKH-SCF-0195 [IN:054909] 
									if(issue_uom_by.equals("I")){ //if condition added for ML-BRU-SCF-1842
										final_conv_factor        =	bean.lcm( base_to_def_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0195 [IN:054909]
									}else{
										final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									}
									if(base_to_disp_uom_equl !=0 &&  base_to_def_uom_equl!=0 && !((String)batchDetails.get(i+21)).equals("")) //added for AAKH-SCF-0129 [IN:050557]
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )");
									if(base_to_disp_uom_equl != base_to_def_uom_equl){ //condition changed from != 0 to this condition
									//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0){
										if(!((String)batchDetails.get(i+21)).equals("")){						  
											if(issue_uom_by.equals("I")){
												base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); 
												if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
													final_conv_factor   =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
												} 
												else{
													//final_conv_factor     =	bean.lcm( final_conv_factor,base_to_issue_uom_equl); //commented for AAKH-SCF-0129 [IN:050557]
													final_conv_factor     =	bean.lcm( base_to_disp_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0129 [IN:050557]
												}
											}	
											//issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )"); //moved above
										}
								   if(final_conv_factor>1){ // Added for ML-BRU-SCF-1880 - Start
										final_conv_factor =final_conv_factor/base_to_disp_uom_equl;
								   } // Added for ML-BRU-SCF-1880 - End
											
									}
	/*====================variable uom====================*/
	
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i)));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(bean.getTradeName_Flag().equals("Y") && batchDetails.get(i+33)!=null && !batchDetails.get(i+33).equals("")){ // if block Added for AMS-SCF-0190 IN038440

            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(batchDetails.get(i+33) ));
            _bw.write(_wl_block37Bytes, _wl_block37);

										}

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+1)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(batchDetails.get(i+23)));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+3)));
            _bw.write(_wl_block199Bytes, _wl_block199);

										if((FacilityFlag.equals("Y"))){

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(batchDetails.get(i+31)));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(count));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(count));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+31)));
            _bw.write(_wl_block204Bytes, _wl_block204);

										}

            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(batchDetails.get(i+5)));
            _bw.write(_wl_block1Bytes, _wl_block1);

										if(issue_uom_by.equals("I")){

            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(issue_qty_dtl.toString()));
            _bw.write(_wl_block208Bytes, _wl_block208);

										}

            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,batchDetails.get(i+38).toString())));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(batchDetails.get(i+19)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										// if disp-no is re-issued paint with a legend
										if(bean.checkReissued((String)batchDetails.get(i+3))) {

            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(batchDetails.get(i+7)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										}
										else {	

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(batchDetails.get(i+7)));
            _bw.write(_wl_block48Bytes, _wl_block48);

										}

            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(count));
            _bw.write(_wl_block214Bytes, _wl_block214);

										for(int j=0;j<binLocation.size();j++){
											binLocationDetails=(HashMap)binLocation.get(j);
											if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
												if(binLocationDetails.get("Default_YN").equals("Y")){

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
												else{	

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);
	
												}
											}
											else{
												if(((String)binLocationDetails.get("bin_location_code")).equals(((String)batchDetails.get(i+16)))){

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
												else{	

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf((String)binLocationDetails.get("bin_location_code")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf((String)binLocationDetails.get("short_desc")));
            _bw.write(_wl_block89Bytes, _wl_block89);

												}
											}
										}//end for loop

            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(count));
            _bw.write(_wl_block217Bytes, _wl_block217);
 
										if (batchDetails.get(i+11).equals("N")){
											disabledCount++;

            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(count));
            _bw.write(_wl_block278Bytes, _wl_block278);

										}
										else{

            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(count));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(count));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(dflt_issue_uom));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(StoreCount));
            _bw.write(_wl_block279Bytes, _wl_block279);

										}

            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(i));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+19)));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+9)));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(batchDetails.get(i+17)));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+12)));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(count));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(batchDetails.get(i+13)));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(count));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(displocn));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(count));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(batchDetails.get(i+15)));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+38)));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(count));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+1)));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+5)));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(batchDetails.get(i+29)));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(batchDetails.get(i+2)));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(count));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+16)));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+10)));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(count));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(final_conv_factor));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(count));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(count));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+30)));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(count));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+32)));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(count));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+34)));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(count));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+35)));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(count));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+36)));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(count));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(batchDetails.get(i+37)));
            _bw.write(_wl_block281Bytes, _wl_block281);

										order_line_staus=(String)batchDetails.get(i+27);
										dis_cont_reason=(String)batchDetails.get(i+26);
										DISC_DATE_TIME=(String)batchDetails.get(i+27);
										DISC_DATE_TIME=com.ehis.util.DateUtils.convertDate(DISC_DATE_TIME,"DMYHM","en",locale);
										pract_name=(String)batchDetails.get(i+28);

										if(((String)batchDetails.get(i+25)).equals("DC")){
	
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(DISC_DATE_TIME));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block263Bytes, _wl_block263);

										}
										else{
	
            _bw.write(_wl_block264Bytes, _wl_block264);

										}
	
            _bw.write(_wl_block265Bytes, _wl_block265);

								   count++;
									//document.FormReturnMedicationAction.actualReturn1.focus();
								} 
								else{
								   //count++;
								   administred_count++;
								}
							}//end for loop
	
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(totalRows-disabledCount));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf( totalRows-administred_count ));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf( remarks ));
            _bw.write(_wl_block269Bytes, _wl_block269);

						if(!flag){
	
            _bw.write(_wl_block282Bytes, _wl_block282);

						} 
					}
					//}//END ELSE
				}
		}//If Condtion Added for GHL-CRF-0413.8 END// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - End //added for icn 63722
				String disp_cash_coll_stage = bean.getDispCashCollStage();//Added for EMR-12.X-Alpha-PHIS-PH-Inc#2558

            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(rej_qty));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf( patientid ));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf( drugcodes ));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf( disabledCount));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(disp_cash_coll_stage));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(patcat));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(displocn));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(barcodeFlag));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(count-1));
            _bw.write(_wl_block297Bytes, _wl_block297);
if(eff_status.equals("D")){
		if(barcodeFlag.equals("Y") && !barcode.equals("") && valid_barcode){ 
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(barcode));
            _bw.write(_wl_block299Bytes, _wl_block299);
}} 
            _bw.write(_wl_block300Bytes, _wl_block300);
	
			
		//} Removed for 63722
			}
		catch(Exception e){
			e.printStackTrace();
		}
		putObjectInBean(bean_id,bean,request); 

            _bw.write(_wl_block301Bytes, _wl_block301);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturningWard.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Return.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReasonforReturn.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discontinued.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedQty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyUOM.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Acknowledge.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AcceptedQty.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RejectedQty.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceQty.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accept.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reject.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PartialAcceptReject.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDrugDetails.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseNo.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseFacility.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDate.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssuedQuantity.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyUOM.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MaxReturnQty.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedQuantity.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedtoBinLocation.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnQuantity.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDrugDetails.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseNo.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseFacility.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedDate.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssuedQuantity.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.QtyUOM.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MaxReturnQty.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedQuantity.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnedtoBinLocation.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReturnQuantity.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }
}
