package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryplaceorderresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryPlaceOrderResult.jsp", 1742302044000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="<!--IN062607-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t</link>\n \t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrMessages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- for Tool Tip-->\n\t<script>\n\t\t// Violation, but to make the alignment size same as the top frame...\n\t\tfunction alignWidth(order_set_bill_yn) \n\t\t{\n\t\t\t//var last=eval(document.getElementById(\'detailTab\').rows.length-2);\n\t\t\tvar row=0;\n\t\t\tif(order_set_bill_yn==\"Y\")\n\t\t\t{\n\t\t\t\trow=1;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\trow=0;\n\t\t\t}\n\t\t\tparent.legendsFrame.document.getElementById(\'titleTab\').width =\tdocument.getElementById(\'detailTab\').offsetWidth+\'px\';\n\t\t\tif(document.getElementById(\'detailTab\')!=null&&document.getElementById(\'detailTab\').rows[row]!=null) \n\t\t\t{\n\t\t\t\t\tfor( i=0;i<document.getElementById(\'detailTab\').rows[row].cells.length;i++) \n\t\t\t\t\t{   // Depending upon the first row\n\t\t\t\t\t\t//for(i=0;i<document.getElementById(\'detailTab\').rows(last).cells.length;i++) {\n\t\t\t\t\t\t//var wid=document.getElementById(\'detailTab\').rows(last).cells(i).offsetWidth;\n\t\t\t\t\t\tvar wid=document.getElementById(\'detailTab\').rows[row].cells[i].offsetWidth+\'px\';\t\t\t\t\t\t\n\t\t\t\t\t\tvar wid1= parent.legendsFrame.document.getElementById(\'titleTab\').rows[0].cells[i].offsetWidth+\'px\';\n\t\t\t\t\t\t//\tif(eval(wid1) < eval(wid)){\n\t\t\t\t\t\tif(parent.legendsFrame.document.getElementById(\'titleTab\').rows[0].cells[i])\n\t\t\t\t\t\t\tparent.legendsFrame.document.getElementById(\'titleTab\').rows[0].cells[i].style.width=wid;\n\t\t\t\t\t\t\n\n\t\t\t\t\t//\t} else {\n\t\t\t\t\t//\t\tdocument.getElementById(\'detailTab\').rows(last).cells(i).width = wid1;\n\t\t\t\t\t//\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}    \n\t\t\t}\t\n\n\t\t\tfunction moveFrame()\n\t\t\t{\n\t\t\t\tvar temp=document.body.scrollLeft;\n\t\t\t\tscrollValue=temp;\n\n\t\t\t\tif(parent.legendsFrame.location.href.indexOf(\".jsp\") != -1)\n\t\t\t\t{\n\t\t\t\t\tparent.legendsFrame.document.body.scrollLeft=temp;\n\t\t\t\t}\n\t\t\t}\t\t\n</script>\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n</head>\n<style TYPE=\"text/css\"></style>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"ClinicalComment();\" onscroll=\'moveFrame()\'>\n<form name=\"placeOrderForm\" id=\"placeOrderForm\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" id=\"detailTab\" class=\"grid\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t<script>alert(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<script>\n\t\t\t\t\tvar msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\n\t\t\t\t\talert(msg);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<script>\n\t\t\t\t\tparent.criteriaDetailFrame.document.getElementById(\'recordApply\').disabled=true;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></td><td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td><td colspan=\"6\" class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'right\' style=\'border-width:0\' class=\"grid\">\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<!--10503 Starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"fpp_yn";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"fpp_yn";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t\t\t\t\t\t<td rowspan=\"2\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\'border-width:0;\' nowrap ><font size=\"1\" class=\'label\'>&nbsp;<B>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =":</B></font>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<select name=\"fpp_category";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"fpp_category";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  disabled onchange=\"reviseBillingchrgs(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'ORDER_SET_AMEND\')\" >\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t<!--10503 Ends-->\n\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</B></font></td>\n\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</B></font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'actual_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</span></font></td>\n\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'payable_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</span></font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'included_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'approved_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</span></font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<td colspan=\"\" id=\'ordersetlevel\'  class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><!-- //10503  -->\n\t\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'1\',\'ORDER_SET_AMEND\',\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" title=\'Charge Details\'> ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" <!--View / Edit--></a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table></td></tr>\n\t\t<input type=\"hidden\" name=\"bill_dateString\" id=\"bill_dateString\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\" name=\"order_set_catalog_code\" id=\"order_set_catalog_code\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"order_qty\" id=\"order_qty\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\" name=\"order_set_orderid\" id=\"order_set_orderid\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><!-- //10503  -->\n\t\t<input type=\"hidden\" name=\"order_set_orderlineno\" id=\"order_set_orderlineno\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><!-- //10503  -->\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"2%\"  class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"><input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"ck";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"Y\" checked onClick=\"setCheckValue(this)\" DISABLED><input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"h1";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"><input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"h2";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"></td>\n\t\t\t\t\n\t\t\t\t<!--28198 Modified Starts-->\n\t\t\t\t<td width=\"12%\" class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t<!--28806 Modified by Menaka-->\n\t\t\t\t\t<input type=\"text\" name=\"amend_start_date_time";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"amend_start_date_time";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"\t  value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'\n\t\t\t\t\tsize=\"14\" maxLength=\"16\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t\t\t\t\tonBlur=\"checkAmendStartDateTime(this,";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =",\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\',\'amend_start_date_time";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\',\'\',\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\');\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" onClick=\"return showCalendarValidate(\'amend_start_date_time";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',null,\'hh:mm\',\'amend_start_date_time";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\');\" style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="><input type=\"hidden\" name=\"old_amend_start_date_time";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"old_amend_start_date_time";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t<!--28198 Modified Ends-->\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"amend_catalog_code";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"amend_catalog_code";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t\t<td width=\"18%\" class=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\",\"placeOrderForm\")\' onMouseOut=\"hideToolTip()\"><font size=\"1\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<input type=\"hidden\" name=\"amend_cat_desc";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"amend_cat_desc";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\"12%\" class=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t\t\t\t<input type=\"text\" name=\"amend_order_type_desc";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"amend_order_type_desc";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" size=\"14\" maxLength=\"15\" READONLY> \n\t\t\t\t\t<input type=\"hidden\" name=\"amend_order_type";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"amend_order_type";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\"6%\" class=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_priority";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"amend_priority";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\"5%\" class=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"><input type=\"text\" style=\"text-align:\'right\'\" name=\"amend_quantity";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"amend_quantity";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" size=\"2\" maxLength=\"6\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\"  onBlur=\"checkValidNumber(\'amend_quantity";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\',this);reviseBillingchrgs(\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\',\'AMEND_ORDER\')\" ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =">&nbsp;";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<td width=\"17%\" class=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t<select name=\"amend_frequency_code";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"amend_frequency_code";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" onChange=\"setAmendFrequency(this,";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\',\'onChange\')\" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =">\n\t\t\t\t\t<option value=\"\" ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =">---";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_frequency_val";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"amend_frequency_val";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"old_amend_frequency_val";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"old_amend_frequency_val";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_schedule_yn";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"amend_schedule_yn";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" value=\"Y\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_schedule_mandatorily_yn";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"amend_schedule_mandatorily_yn";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" value=\"Y\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" value=\"N\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_schedule_mandatorily_yn";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" value=\"N\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" disabled>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="---</option>\n\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_schedule_yn";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_schedule_mandatorily_yn";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_frequency_val";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"old_amend_frequency_val";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" value=\"\" >\n\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"4%\" class=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"amend_duration_value";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"amend_duration_value";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" size=\"2\" maxLength=\"3\" ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" onBlur=\'callamend_duration_value(\"amend_duration_value";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\",this)\'>\n\t\t\t\t\t<input type=\"hidden\" nowrap name=\"amend_end_date_time";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"amend_end_date_time";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" size=\"13\" maxLength=\"16\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\"11%\" class=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\t\t\t\t<select name=\"amend_duration_code";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"amend_duration_code";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"  DISABLED>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_duration";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" id=\"amend_duration";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t<input type=\"hidden\" name=\"amend_format_id";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" id=\"amend_format_id";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"><!--IN066436-->\n\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" ><font size=\"1\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_format_id_val";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"amend_format_id_val";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_format_id_yn";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\" id=\"amend_format_id_yn";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" value=\"Y\">\n    ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t<input class=\"button\" type=\"button\" name=\"amend_consent_id_lookup";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" id=\"amend_consent_id_lookup";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"  title=\'Consent Required\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\')\"> <!-- IN041421 -->\n\t\t\t\t<!-- <IMG id=\'amend_consent_id_lookup";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' style=\'cursor:pointer\' SRC=\"../images/consentJ.JPG\" WIDTH=\"25\" HEIGHT=\"16\" BORDER=0 ALT=\"Consent Required\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\')\"> -->   \n\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"Y\" name=\"amend_consent_chk";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" id=\"amend_consent_chk";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" name=\"amend_consent_form_id";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" name=\"amend_consent_stages";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"amend_consent_form_list";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" id=\"amend_consent_form_list";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"amend_total_recs";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" id=\"amend_total_recs";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' name=\"amend_consent_stages";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="0\">\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\'Y\' name=\"amend_consent_chk";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="0\" id=\"amend_consent_chk";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="0\">\n\t\t\t\t\t\t\t\t<!-- <input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="0\">\t -->\n\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="0\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"amend_consent_form_list";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"amend_total_recs";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t<Input type=\'hidden\' name=\"amend_MultiConsentList";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" id=\"amend_MultiConsentList";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t\t\t ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n                <Script>\n\t\t\t\tif(document.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 =")\n\t                document.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =".value = \'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\';\n                </Script>\n                 <a class=\"gridLink\" href=\"javascript:viewSecondaryOrders(\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\')\"> <img src=\'../../eOR/images/SecondaryOrder.gif\' border=\'0\'  title=\'Secondary Orders Exists\'></img>&nbsp;</a>\n            ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t<input type=\"hidden\" name=\"amend_sec_tasks_type";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" id=\"amend_sec_tasks_type";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"> <!--Keep the Seconday order catalog_type -->\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\"><label class=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"  id=\"amend_schedule";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" Title=\"Schedule\">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t\t\t<a class=\'gridLink\' href=javascript:AmendDisplaySchedule(\"AmendSchedule";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\",\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\")  title=\'Schedule Frequency\'><font size=\'1\'>";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</font></a>\n\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t</label>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" align=\"left\" colspan=\'2\' nowrap><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="<b>";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</b><!-- IN31901 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =" </font>/ <select name=\"amend_perform_loc_code";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" id=\"amend_perform_loc_code";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" onchange=\'setPerforming(\"amend_perform_loc_code";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\",this)\'>\n\t\t\t\t\t\t<option value=\"\"  ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="---</option>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 =" </select>\n\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\t<!-- IN069674 start -->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\t\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="<!-- IN069674 end -->\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_performing_dept_loc_code";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" id=\"amend_performing_dept_loc_code";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_performing_facility_id";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\" id=\"amend_performing_facility_id";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t\t\t\t\t<!--<input type=\"hidden\" name=\"amend_line_comments";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" id=\"amend_line_comments";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">--> <!--IN64543-->\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_rep_group_ref";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" id=\"amend_rep_group_ref";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_trn_group_ref";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" id=\"amend_trn_group_ref";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"4\" class=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" align=\"left\" style=\"border-right-width:0\"><font size=\"1\">\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\");\n\t\t\t\t\t\t\t\t </script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\n\t\t\t\t\t\t\t\t <script> \n\t\t\t\t\t\t\t\t\t var msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\");\n\t\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\' align=\'center\' ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="style=\'border-width:0;display:inline\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="style=\'border-width:0;display:none\' ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 =">\n\t\t\t\t\t<!--\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\' align=\'center\' style=\'border-width:0;display:inline\'> -->\n\t\t\t\t\t\t<tr >\t\n\t\t\t\t\t\t\t<!--IN068314 Starts-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"fpp_yn";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" >\n\t\t\t\t\t\t\t<td rowspan=\"2\" colspan=\"\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"  onchange=\"reviseBillingchrgs(\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\',\'AMEND_ORDER\')\" ><!-- 10503 -->\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =">";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</option><!--IN068314-->\n\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</option><!--IN068314-->\n\t\t\t\t\t\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</option><!--IN068314-->\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\t\t\t<td width=\'50%\' rowspan=\"2\" class=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\" style=\'border-width:0;\'>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t\t\t\t<!--IN068314 Ends-->\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'30%\' class=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =":</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'15%\' class=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'15%\' class=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</B></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</B></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'fields\' size=\"1\"><span id=\'amend_bill_now_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'style=\'visibility:";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="<input type=\"checkbox\" name=\'amend_bill_now_check";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\' id=\'amend_bill_now_check";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\"  onclick=\"amendChangeBillNow(this,\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\')\"\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="></span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'amend_actual_";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'amend_payable_";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="</span></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'amend_included_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</span></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'amend_approved_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_bill_now";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\" id=\"amend_bill_now";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n\t\t\t\t\t\t\t <input type=\"hidden\" name=\"amend_bill_now_check_Df";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" id=\"amend_bill_now_check_Df";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_future_date";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" id=\"amend_future_date";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_actual_value";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\" id=\"amend_actual_value";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_actual_old_value";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" id=\"amend_actual_old_value";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"amend_round_off_start_time";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" id=\"amend_round_off_start_time";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" >\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\t\tlabdruginterchk(\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\");\t\t\t\n\t\t\t\t\t </script>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\" id=\"order";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 =" style=\"border-left-width:0;text-align:center;display:inline\" ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 =" ><font size=\"1\"> <!--  modified for IN039607 -->\n\t\t\t\t\n";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\n\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:callReviseBilling(\'";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\',\'AMEND_ORDER\',\'";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 =" <!--View / Edit--></a>\n\t\t\n";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"9\" id=\"order";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\"  class=\"OR_QRYEVENBORDER\">&nbsp;</td><!--IN068314-->\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\t\t\t\t</font></td>\n\t\t\t</tr>\n\t\t<!--\t<tr>\n\t\t\t\t<td colspan=\"9\" id=\"order";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\"  class=\"OR_QRYEVENBORDER\">&nbsp;</td> \n\t\t\t</tr>--> <!--IN068314--> <!--Commented for 10503--><!-- 15910 Regression-OR-Amend Order-->\n";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t  <!--<input type=\"hidden\" name=\"amend_line_preps";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\" id=\"amend_line_preps";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\">\n\t\t\t  <input type=\"hidden\" name=\'amend_line_pat_instrn";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\' id=\'amend_line_pat_instrn";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\">--><!--IN64543--%>\n";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t<!--<input type=\"hidden\" name=\"amend_line_dept_instrn";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" id=\"amend_line_dept_instrn";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">--><!--IN64543-->\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_id";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" id=\"amend_order_id";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_line_num";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" id=\"amend_order_line_num";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_category";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" id=\"amend_order_category";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" id=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_ord_auth_reqd_yn";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" id=\"amend_ord_auth_reqd_yn";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_ord_cosign_reqd_yn";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" id=\"amend_ord_cosign_reqd_yn";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_old_quantity";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\" id=\"amend_old_quantity";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_ord_consent_reqd_yn";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" id=\"amend_ord_consent_reqd_yn";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_specimen_type";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" id=\"amend_specimen_type";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_nurse_collect";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\" id=\"amend_nurse_collect";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\" id=\"amend_pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_contr_msr_mod_id";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" id=\"amend_contr_msr_mod_id";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_contr_msr_panel_id";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" id=\"amend_contr_msr_panel_id";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_catalog_nature";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" id=\"amend_order_catalog_nature";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_billing_call_yn";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\" id=\"amend_billing_call_yn";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_quantity_uom";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\" id=\"amend_quantity_uom";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_yn";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\" id=\"amend_chk_for_dupl_yn";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_status";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" id=\"amend_chk_for_dupl_status";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_activity_type";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" id=\"amend_activity_type";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_check_for_dupl_level";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\" id=\"amend_check_for_dupl_level";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\" id=\"amend_chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\" id=\"amend_chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\" id=\"amend_chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_behind_action";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\" id=\"amend_chk_for_dupl_behind_action";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_behind_period";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\" id=\"amend_chk_for_dupl_behind_period";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\" id=\"amend_chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_result_applicable_yn";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\" id=\"amend_result_applicable_yn";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_bill_yn";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" id=\"amend_bill_yn";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_appt_reqd_yn";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" id=\"amend_appt_reqd_yn";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"amend_routine_appt_reqd_yn";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" id=\"amend_routine_appt_reqd_yn";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_stat_appt_reqd_yn";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\" id=\"amend_stat_appt_reqd_yn";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_urgent_appt_reqd_yn";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" id=\"amend_urgent_appt_reqd_yn";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_result_auth_reqd_yn";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\" id=\"amend_result_auth_reqd_yn";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_cont_order_yn";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\" id=\"amend_cont_order_yn";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_complete_on_order_yn";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\" id=\"amend_complete_on_order_yn";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\" id=\"amend_ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_chart_result_type";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\" id=\"amend_chart_result_type";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" id=\"amend_routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\" id=\"amend_urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\" id=\"amend_stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_consent_stage";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\" id=\"amend_consent_stage";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\">\n\t\t\t\t<!--added on 08/05/07-->\n\t\t\t    <input type=\"hidden\" name=\"amend_num_of_consent_req_bo";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\" id=\"amend_num_of_consent_req_bo";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_num_of_consent_req_br";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\" id=\"amend_num_of_consent_req_br";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_set_id";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" id=\"amend_order_set_id";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_future_order_YN";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\" id=\"amend_future_order_YN";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_order_set_line_num";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\" id=\"amend_order_set_line_num";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_clin_cmts_reqd_yn";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\" id=\"amend_clin_cmts_reqd_yn";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\">\n                 <!--added on 08/05/07 ends here-->\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"amend_freq_nature";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" id=\"amend_freq_nature";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\" value=\"F\" >\n\t\t\t\t<input type=\"hidden\" name=\"amend_authorised_yn";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" id=\"amend_authorised_yn";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\" value=\"N\" >\n\t\t\t\t<input type=\"hidden\" name=\"amend_freq_applicable_yn";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\" id=\"amend_freq_applicable_yn";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"amend_barcode_reqd_yn";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\" id=\"amend_barcode_reqd_yn";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\"><!--IN063816 - GHL-CRF-0445.1 -->\n\t\t\t\t";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_splty_code";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\" id=\"amend_splty_code";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_auth_yn";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\" id=\"amend_auth_yn";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\" >\n\t\t\t\t";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_auth_yn";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\" >\n\t\t\t   ";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\n\t\t\t\t<input type=\"hidden\" name=\"amend_explanatory_text";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" id=\"amend_explanatory_text";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\"> ";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\n\t\t\t\t<input type=\"hidden\" name=\"amend_auto_report_yn";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\" id=\"amend_auto_report_yn";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\n\t\t\t\t<input type=\"hidden\" name=\"amend_instrn_content_type";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\" id=\"amend_instrn_content_type";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\'><!--IN64543-->\n\t\t\t\t<script>amenddate(";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\',\'onLoad\',\'";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\');</script>\n\t\t\t\t<script>\n\t\t\t\t\tif((document.getElementById(\"amend_frequency_code";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\").value)!=\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tsetAmendFrequency(document.getElementById(\"amend_frequency_code";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\"),";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\',\'onload\');\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"amend_enable_email";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\" id=\"amend_enable_email";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\n\t\t\t<input type=\"hidden\" name=\"amend_order_set_bill_yn\" id=\"amend_order_set_bill_yn\" value=\"";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t<input type=\"hidden\" name=\"amend_order_charge_yn\" id=\"amend_order_charge_yn\" value=\"";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"2%\"  id=\"billing";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\" class=\"";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" align=\"center\"><input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\" value=\"Y\" checked onClick=\"setCheckValue(this,\'";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\')\">\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n\t\t\t\t<td width=\"12%\" id=\"billing1";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\"><input type=\"text\" id =\"start_date_time";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\"  name=\"start_date_time";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" onkeydown=\'chkBackSpace();\' value=\'";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\' size=\"12\" maxLength=\"16\" \t\t\tOnBlur=\"checkStartDateTim(this,";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\',\'start_date_time";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\');\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendarValidate(\'start_date_time";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\',null,\'hh:mm\',\'start_date_time\',\'";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\');\" style=\'cursor:pointer\'></td> <!-- Added for IN029076 -->\n\t\t\t\t<!--<td width=\"12%\" id=\"billing1";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\"><input type=\"text\" id =\"start_date_time_id";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\' size=\"14\" maxLength=\"16\" \t\t\tOnBlur=\"checkStartDateTim(this,";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\');\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendarValidate(\'start_date_time_id";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\');\" style=\'cursor:pointer\'></td> -->     <!--Commented for  IN029076 --> \n\t\t\t\t<input type=\"hidden\" name=\"catalog_code";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\" id=\"catalog_code";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\">\n\t\t\t\t<td  width=\"29%\" id=\"billing2";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\" algin=\"center\" class=\"";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\",\"placeOrderForm\")\' onMouseOut=\"hideToolTip()\"><font size=\"1\">\n\t\t\t\t<input type=\"hidden\" name=\"auth_reqd";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" id=\"auth_reqd";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\" value=\"\">\n\t\t\t\t";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 =" &nbsp;  \n ";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\t\t<img id=\'authorization";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\' src=\"../../eOR/images/Authorization.gif\" align=\"center\"></img>\n\t";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\t\t\t\t<img id=\'authorization";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\t\t\t\t\t<img id=\'cosign\"+i+\"\' src=\"../../eOR/images/Cosign_click.gif\" align=\"center\"></img>\n\t";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\t\t\t\t\t<img id=\'special_approval\"+i+\"\' src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\"></img>\n";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\n\n\t\t\t\t</font><input type=\"hidden\" name=\"cat_desc";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\" id=\"cat_desc";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\"><input type=\"hidden\" name=\"type_desc";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\" id=\"type_desc";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\" value=\"\"></td>\n\t\t\t\t<td width=\"14%\" id=\"billing3";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\" align=\"center\">\n\t\t\t\t\t<select name=\"order_type_code";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\" id=\"order_type_code";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" DISABLED>\n";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="---</option>-->\n";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"order_type";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\" id=\"order_type";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\" value=\"\">\n\t\t\t\t</td>\n \t\t\t\t<td width=\"4%\" id=\"billing4";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\">\n\t\t\t\t\t<select name=\"priority";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\" id=\"priority";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\" onChange=\"setOrderPriority(\'priority\',\'";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\',";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 =")\" ";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 =" ><!--IN048467-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\n\t\t\t\t\t      <option value=R ";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\n\t\t\t\t\t   <option value=U ";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\n\t\t\t\t\t   <option value=S ";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\n\t   \t\t \t\t</select>\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t<td width=\"5%\" id=\"billing5";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\"><input type=\"text\" style=\"text-align:\'right\'\" name=\"quantity";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\" id=\"quantity";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\' size=\"2\" maxLength=\"6\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" onBlur=\"checkValidNumber(\'quantity";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\',\'NEW_ORDER\')\" ";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 =">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="</td>\n\t\t\t\t<td width=\"17%\" id=\"billing6";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\n\t\t\t\t\t<select name=\"frequency_code";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\" id=\"frequency_code";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" onChange=\"setFrequency(this,";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\',\'onChange\'); setFrequencyCode(\'frequency_code";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\',this);\" >\n\t\t\t\t\t\t<option value=\"\" ";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="---</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\n\t\t\t\t\t\t<select name=\"frequency_code";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\" disabled>\n\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="---</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"frequency_val";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\" id=\"frequency_val";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_yn";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\" id=\"schedule_yn";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\" id=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_nature";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" id=\"freq_nature";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\" value=\"F\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"repeat_value";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" id=\"repeat_value";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" value=\"\" >\n\t\t\t\t</td>\n\t\t\t\t<td width=\"4%\" id=\"billing7";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\">\n";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\n\t\t\t\t\t<input type=\"text\"  class=\"NUMBER\" name=\"duration_value";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\" id=\"duration_value";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" size=\"2\" maxLength=\"3\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onBlur=\'checkMaxValue(this,\"";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\",escape(\"";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\"),\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\");setcheckMaxValue(\"duration_value";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\",this);\'  ";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 =">\n\t\t\t\t\t<input type=\"hidden\" class=\"NUMBER\" name=\"duration_def_value";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" id=\"duration_def_value";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td width=\"11%\" id=\"billing9";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\">\n\t\t\t\t\t<select name=\"duration_code";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" id=\"duration_code";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" DISABLED>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="---</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"duration";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\" id=\"duration";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" value=\"\">\n\t\t\t\t</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\t\t\t<TR>\n\t\t\t\t<input type=\"hidden\" name=\"format_id_val";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\" id=\"format_id_val";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"format_id";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\" id=\"format_id";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\"><!--Added for IN066436-->\n\t\t\t\t<input type=\"hidden\" name=\"format_id_yn";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\" id=\"format_id_yn";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\" value=\"Y\">\n\t\t\t\t<input type=\"hidden\" name=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\" id=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\" >\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\" id=\"orderformat";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\" ><font size=\"1\"> &nbsp;<!--IN068314-->\n\n          ";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\n\t\t\t\t <input class=\"button\" type=\"button\" name=\"consent_id_lookup";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\" id=\"consent_id_lookup";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\" title=\'Consent Required\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\')\">  <!-- IN041421 --> \n\t\t\t\t<!--<IMG id=\'consent_id_lookup";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\')\">-->\n\t\t ";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\" id=\"consent_chk";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\" name=\"consent_form_id";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\" name=\"consent_stages";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n\t\t\t\t\t<Input type=\'hidden\' name=\"consent_form_list";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\" id=\"consent_form_list";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\">\n\t\t\t\t\t<Input type=\'hidden\' name=\"total_recs";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\" id=\"total_recs";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\">\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" value=\'";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\' name=\"consent_stages";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="0\">\t\t\n\t\t\t\t\t\t<input type=\"hidden\" value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="0\" id=\"consent_chk";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="0\">\n\t\t\t\t\t\t<!--<input type=\'hidden\' value=\"<//%=multiConsentDtls[3]%>\" name=\"consent_form_id<//%=i%>0\">-->\n\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\"><!--IN030298-->\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\n\t\t\t\t<Input type=\'hidden\' name=\"multiConsentList";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\" id=\"multiConsentList";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\">\n\t\t\t";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="              <Script> \n\t\t\t\t\tif(document.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 =")\n\t\t\t\t\t\tdocument.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\';\n                //alert(\'\'+document.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 =".value);\n                </Script>\n\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewSecondaryOrders(\'";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\')\"> <img src=\'../../eOR/images/SecondaryOrder.gif\' border=\'0\'  title=\'Secondary Orders Exists\'></img>&nbsp;</a>\n\t\t\t\t";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\t\t\t \n";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\n\t\t\t\t<input type=\"hidden\" name=\"sec_tasks_type";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\" id=\"sec_tasks_type";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\" id=\"billing10";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\" nowrap ><font size=\"1\">";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="</font><input type=\"text\" name=\"end_date_time";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\" id=\"end_date_time";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\" size=\"8\" maxLength=\"16\" value=\"\" readOnly></td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\" id=\"billing11";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\" colspan=\'2\' nowrap><label class=\"";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\" id=\"schedule";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\" Title=\"Schedule\">&nbsp;</label>&nbsp;<!-- </td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\" >&nbsp; -->\n";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\n\t\t<font size=\"1\"><b>";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="&nbsp;:</b>\n\t\t<select name=\"performing_facility_id";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\" onchange=\'clearDepLocn(\"";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\",this);setPerformingFacility(\"performing_facility_id";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\",this);\'>\n\t\t\t";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\n \t\t\t\t</select></font>/\n\t\t\t\t";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\n\t\t\t\t\t<font size=\"1\"><b>";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="&nbsp;:</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\n \t\t\t\t\t";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="</font>/\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );

    private final static java.lang.String  _wl_block599 ="\n\t\t\t\t\t<select name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block599Bytes = _getBytes( _wl_block599 );

    private final static java.lang.String  _wl_block600 ="\" id=\"performing_dept_loc_code";
    private final static byte[]  _wl_block600Bytes = _getBytes( _wl_block600 );

    private final static java.lang.String  _wl_block601 ="\" onchange=\'getApptReqdYN(\"";
    private final static byte[]  _wl_block601Bytes = _getBytes( _wl_block601 );

    private final static java.lang.String  _wl_block602 ="\",this,\"";
    private final static byte[]  _wl_block602Bytes = _getBytes( _wl_block602 );

    private final static java.lang.String  _wl_block603 ="\");setPerforming(\"performing_dept_loc_code";
    private final static byte[]  _wl_block603Bytes = _getBytes( _wl_block603 );

    private final static java.lang.String  _wl_block604 ="\",this)\'>\n\t\t\t\t\t\t<option value=\"\" ";
    private final static byte[]  _wl_block604Bytes = _getBytes( _wl_block604 );

    private final static java.lang.String  _wl_block605 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block605Bytes = _getBytes( _wl_block605 );

    private final static java.lang.String  _wl_block606 ="\" value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block606Bytes = _getBytes( _wl_block606 );

    private final static java.lang.String  _wl_block607 ="\t\n\t\t\t\t\t<!-- IN066377 start -->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block607Bytes = _getBytes( _wl_block607 );

    private final static java.lang.String  _wl_block608 ="\n\t\t\t\t\t<!-- IN066377 end -->\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"4\" id=\"billing12";
    private final static byte[]  _wl_block608Bytes = _getBytes( _wl_block608 );

    private final static java.lang.String  _wl_block609 ="\" align=\"left\" style=\"border-right-width:0\">\n\t\t\t\t";
    private final static byte[]  _wl_block609Bytes = _getBytes( _wl_block609 );

    private final static java.lang.String  _wl_block610 ="\n\n\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t alert(\"";
    private final static byte[]  _wl_block610Bytes = _getBytes( _wl_block610 );

    private final static java.lang.String  _wl_block611 ="\");billchecking(\"";
    private final static byte[]  _wl_block611Bytes = _getBytes( _wl_block611 );

    private final static java.lang.String  _wl_block612 ="\");\n\t\t\t\t\t\t\t\t\t displaycolor(\"";
    private final static byte[]  _wl_block612Bytes = _getBytes( _wl_block612 );

    private final static java.lang.String  _wl_block613 ="\");</script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block613Bytes = _getBytes( _wl_block613 );

    private final static java.lang.String  _wl_block614 ="\n\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t var msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block614Bytes = _getBytes( _wl_block614 );

    private final static java.lang.String  _wl_block615 ="\");\n\t\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block615Bytes = _getBytes( _wl_block615 );

    private final static java.lang.String  _wl_block616 ="\");displaycolor(\"";
    private final static byte[]  _wl_block616Bytes = _getBytes( _wl_block616 );

    private final static java.lang.String  _wl_block617 ="\");\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block617Bytes = _getBytes( _wl_block617 );

    private final static java.lang.String  _wl_block618 =" style=\'border-width:0;display:inline\' ";
    private final static byte[]  _wl_block618Bytes = _getBytes( _wl_block618 );

    private final static java.lang.String  _wl_block619 ="> <!--  modified for IN039607 -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr  >\t\n\t\t\t\t\t\t\t<!--IN068314 Starts-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block619Bytes = _getBytes( _wl_block619 );

    private final static java.lang.String  _wl_block620 ="\',\'NEW_ORDER\')\" >\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block620Bytes = _getBytes( _wl_block620 );

    private final static java.lang.String  _wl_block621 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block621Bytes = _getBytes( _wl_block621 );

    private final static java.lang.String  _wl_block622 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block622Bytes = _getBytes( _wl_block622 );

    private final static java.lang.String  _wl_block623 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block623Bytes = _getBytes( _wl_block623 );

    private final static java.lang.String  _wl_block624 ="\n\t\t\t\t\t\t\t<!--IN068314 Ends-->\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'10%\'  class=\"";
    private final static byte[]  _wl_block624Bytes = _getBytes( _wl_block624 );

    private final static java.lang.String  _wl_block625 ="\" style=\'border-width: 0;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block625Bytes = _getBytes( _wl_block625 );

    private final static java.lang.String  _wl_block626 =":</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'20%\'  class=\"";
    private final static byte[]  _wl_block626Bytes = _getBytes( _wl_block626 );

    private final static java.lang.String  _wl_block627 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\"  width=\'20%\' class=\"";
    private final static byte[]  _wl_block627Bytes = _getBytes( _wl_block627 );

    private final static java.lang.String  _wl_block628 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\'  class=\"";
    private final static byte[]  _wl_block628Bytes = _getBytes( _wl_block628 );

    private final static java.lang.String  _wl_block629 ="</B></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\'  class=\"";
    private final static byte[]  _wl_block629Bytes = _getBytes( _wl_block629 );

    private final static java.lang.String  _wl_block630 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block630Bytes = _getBytes( _wl_block630 );

    private final static java.lang.String  _wl_block631 ="\"  style=\'border-width: 0;text-align: right;\'  nowrap><font class=\'fields\' size=\"1\"><span id=\'bill_now_";
    private final static byte[]  _wl_block631Bytes = _getBytes( _wl_block631 );

    private final static java.lang.String  _wl_block632 ="\' style=\'visibility:";
    private final static byte[]  _wl_block632Bytes = _getBytes( _wl_block632 );

    private final static java.lang.String  _wl_block633 ="<input type=\"checkbox\" name=\'bill_now_check";
    private final static byte[]  _wl_block633Bytes = _getBytes( _wl_block633 );

    private final static java.lang.String  _wl_block634 ="\' id=\'bill_now_check";
    private final static byte[]  _wl_block634Bytes = _getBytes( _wl_block634 );

    private final static java.lang.String  _wl_block635 ="\" onclick=\"changeBillNow(this,\'";
    private final static byte[]  _wl_block635Bytes = _getBytes( _wl_block635 );

    private final static java.lang.String  _wl_block636 ="\')\" ";
    private final static byte[]  _wl_block636Bytes = _getBytes( _wl_block636 );

    private final static java.lang.String  _wl_block637 ="></span></font>";
    private final static byte[]  _wl_block637Bytes = _getBytes( _wl_block637 );

    private final static java.lang.String  _wl_block638 ="(";
    private final static byte[]  _wl_block638Bytes = _getBytes( _wl_block638 );

    private final static java.lang.String  _wl_block639 =")";
    private final static byte[]  _wl_block639Bytes = _getBytes( _wl_block639 );

    private final static java.lang.String  _wl_block640 ="</td>\n\t\t\t\t\t\t\t<td colspan=\"\"  class=\"";
    private final static byte[]  _wl_block640Bytes = _getBytes( _wl_block640 );

    private final static java.lang.String  _wl_block641 ="</span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\"  class=\"";
    private final static byte[]  _wl_block641Bytes = _getBytes( _wl_block641 );

    private final static java.lang.String  _wl_block642 ="</span></font></td> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block642Bytes = _getBytes( _wl_block642 );

    private final static java.lang.String  _wl_block643 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t <input type=\"hidden\" name=\"bill_now";
    private final static byte[]  _wl_block643Bytes = _getBytes( _wl_block643 );

    private final static java.lang.String  _wl_block644 ="\" id=\"bill_now";
    private final static byte[]  _wl_block644Bytes = _getBytes( _wl_block644 );

    private final static java.lang.String  _wl_block645 ="\">\n\t\t\t\t\t\t\t <input type=\"hidden\" name=\"bill_now_check_Df";
    private final static byte[]  _wl_block645Bytes = _getBytes( _wl_block645 );

    private final static java.lang.String  _wl_block646 ="\" id=\"bill_now_check_Df";
    private final static byte[]  _wl_block646Bytes = _getBytes( _wl_block646 );

    private final static java.lang.String  _wl_block647 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"future_date";
    private final static byte[]  _wl_block647Bytes = _getBytes( _wl_block647 );

    private final static java.lang.String  _wl_block648 ="\" id=\"future_date";
    private final static byte[]  _wl_block648Bytes = _getBytes( _wl_block648 );

    private final static java.lang.String  _wl_block649 ="\" >\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"round_off_start_time";
    private final static byte[]  _wl_block649Bytes = _getBytes( _wl_block649 );

    private final static java.lang.String  _wl_block650 ="\" id=\"round_off_start_time";
    private final static byte[]  _wl_block650Bytes = _getBytes( _wl_block650 );

    private final static java.lang.String  _wl_block651 ="\" >\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block651Bytes = _getBytes( _wl_block651 );

    private final static java.lang.String  _wl_block652 ="\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block652Bytes = _getBytes( _wl_block652 );

    private final static java.lang.String  _wl_block653 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block653Bytes = _getBytes( _wl_block653 );

    private final static java.lang.String  _wl_block654 =" style=\"border-left-width:0;text-align: center;display:inline\" ";
    private final static byte[]  _wl_block654Bytes = _getBytes( _wl_block654 );

    private final static java.lang.String  _wl_block655 ="><font size=\"1\"> <!--  added for IN039607 -->\n\t\t\t\t";
    private final static byte[]  _wl_block655Bytes = _getBytes( _wl_block655 );

    private final static java.lang.String  _wl_block656 ="\n\t\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'";
    private final static byte[]  _wl_block656Bytes = _getBytes( _wl_block656 );

    private final static java.lang.String  _wl_block657 ="\',\'NEW_ORDER\',\'";
    private final static byte[]  _wl_block657Bytes = _getBytes( _wl_block657 );

    private final static java.lang.String  _wl_block658 ="\',\'\',\'\')\" title=\'Charge Details\'> ";
    private final static byte[]  _wl_block658Bytes = _getBytes( _wl_block658 );

    private final static java.lang.String  _wl_block659 ="</font></td> <!--View / Edit Added for IN068314\t -->\n\t\t\t\t\t<!--\t <a href=\"javascript:callBilling(\'";
    private final static byte[]  _wl_block659Bytes = _getBytes( _wl_block659 );

    private final static java.lang.String  _wl_block660 ="\',\'NEW_ORDER\')\" title=\'Charge Details\'>  --> <!-- ";
    private final static byte[]  _wl_block660Bytes = _getBytes( _wl_block660 );

    private final static java.lang.String  _wl_block661 ="  View / Edit --></a>\n";
    private final static byte[]  _wl_block661Bytes = _getBytes( _wl_block661 );

    private final static java.lang.String  _wl_block662 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block662Bytes = _getBytes( _wl_block662 );

    private final static java.lang.String  _wl_block663 ="<td class=\"";
    private final static byte[]  _wl_block663Bytes = _getBytes( _wl_block663 );

    private final static java.lang.String  _wl_block664 ="\" style=\"border-left-width:0;text-align: center;display:inline\" id=\"order";
    private final static byte[]  _wl_block664Bytes = _getBytes( _wl_block664 );

    private final static java.lang.String  _wl_block665 ="\" style=\"background:#FF7DD0\">&nbsp;</td>";
    private final static byte[]  _wl_block665Bytes = _getBytes( _wl_block665 );

    private final static java.lang.String  _wl_block666 ="\n\t\t\t\t";
    private final static byte[]  _wl_block666Bytes = _getBytes( _wl_block666 );

    private final static java.lang.String  _wl_block667 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t var msg=getMessage(\"PRIV_ORDER_AUTH_RIGHTS\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block667Bytes = _getBytes( _wl_block667 );

    private final static java.lang.String  _wl_block668 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block668Bytes = _getBytes( _wl_block668 );

    private final static java.lang.String  _wl_block669 ="\");\n\t\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block669Bytes = _getBytes( _wl_block669 );

    private final static java.lang.String  _wl_block670 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block670Bytes = _getBytes( _wl_block670 );

    private final static java.lang.String  _wl_block671 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\t var msg=getMessage(\"CATALOG_OPERATIONAL_MODULE\",\"OR\");\n\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block671Bytes = _getBytes( _wl_block671 );

    private final static java.lang.String  _wl_block672 ="\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block672Bytes = _getBytes( _wl_block672 );

    private final static java.lang.String  _wl_block673 ="\");\n\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block673Bytes = _getBytes( _wl_block673 );

    private final static java.lang.String  _wl_block674 ="\");\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block674Bytes = _getBytes( _wl_block674 );

    private final static java.lang.String  _wl_block675 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg=getMessage(\"OR_ORDERING_RULE_CHK\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block675Bytes = _getBytes( _wl_block675 );

    private final static java.lang.String  _wl_block676 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block676Bytes = _getBytes( _wl_block676 );

    private final static java.lang.String  _wl_block677 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"order_catalog_code";
    private final static byte[]  _wl_block677Bytes = _getBytes( _wl_block677 );

    private final static java.lang.String  _wl_block678 ="\" id=\"order_catalog_code";
    private final static byte[]  _wl_block678Bytes = _getBytes( _wl_block678 );

    private final static java.lang.String  _wl_block679 ="\"><!-- IN041644 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"enable_email";
    private final static byte[]  _wl_block679Bytes = _getBytes( _wl_block679 );

    private final static java.lang.String  _wl_block680 ="\" id=\"enable_email";
    private final static byte[]  _wl_block680Bytes = _getBytes( _wl_block680 );

    private final static java.lang.String  _wl_block681 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"order_catalog_nature";
    private final static byte[]  _wl_block681Bytes = _getBytes( _wl_block681 );

    private final static java.lang.String  _wl_block682 ="\" id=\"order_catalog_nature";
    private final static byte[]  _wl_block682Bytes = _getBytes( _wl_block682 );

    private final static java.lang.String  _wl_block683 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"quantity_uom";
    private final static byte[]  _wl_block683Bytes = _getBytes( _wl_block683 );

    private final static java.lang.String  _wl_block684 ="\" id=\"quantity_uom";
    private final static byte[]  _wl_block684Bytes = _getBytes( _wl_block684 );

    private final static java.lang.String  _wl_block685 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_applicable_yn";
    private final static byte[]  _wl_block685Bytes = _getBytes( _wl_block685 );

    private final static java.lang.String  _wl_block686 ="\" id=\"freq_applicable_yn";
    private final static byte[]  _wl_block686Bytes = _getBytes( _wl_block686 );

    private final static java.lang.String  _wl_block687 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"soft_stop_yn";
    private final static byte[]  _wl_block687Bytes = _getBytes( _wl_block687 );

    private final static java.lang.String  _wl_block688 ="\" id=\"soft_stop_yn";
    private final static byte[]  _wl_block688Bytes = _getBytes( _wl_block688 );

    private final static java.lang.String  _wl_block689 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"cont_order_yn";
    private final static byte[]  _wl_block689Bytes = _getBytes( _wl_block689 );

    private final static java.lang.String  _wl_block690 ="\" id=\"cont_order_yn";
    private final static byte[]  _wl_block690Bytes = _getBytes( _wl_block690 );

    private final static java.lang.String  _wl_block691 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block691Bytes = _getBytes( _wl_block691 );

    private final static java.lang.String  _wl_block692 ="\" id=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block692Bytes = _getBytes( _wl_block692 );

    private final static java.lang.String  _wl_block693 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_status";
    private final static byte[]  _wl_block693Bytes = _getBytes( _wl_block693 );

    private final static java.lang.String  _wl_block694 ="\" id=\"chk_for_dupl_status";
    private final static byte[]  _wl_block694Bytes = _getBytes( _wl_block694 );

    private final static java.lang.String  _wl_block695 ="\">\n\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block695Bytes = _getBytes( _wl_block695 );

    private final static java.lang.String  _wl_block696 ="\" id=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block696Bytes = _getBytes( _wl_block696 );

    private final static java.lang.String  _wl_block697 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block697Bytes = _getBytes( _wl_block697 );

    private final static java.lang.String  _wl_block698 ="\" id=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block698Bytes = _getBytes( _wl_block698 );

    private final static java.lang.String  _wl_block699 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block699Bytes = _getBytes( _wl_block699 );

    private final static java.lang.String  _wl_block700 ="\" id=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block700Bytes = _getBytes( _wl_block700 );

    private final static java.lang.String  _wl_block701 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block701Bytes = _getBytes( _wl_block701 );

    private final static java.lang.String  _wl_block702 ="\" id=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block702Bytes = _getBytes( _wl_block702 );

    private final static java.lang.String  _wl_block703 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block703Bytes = _getBytes( _wl_block703 );

    private final static java.lang.String  _wl_block704 ="\" id=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block704Bytes = _getBytes( _wl_block704 );

    private final static java.lang.String  _wl_block705 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block705Bytes = _getBytes( _wl_block705 );

    private final static java.lang.String  _wl_block706 ="\" id=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block706Bytes = _getBytes( _wl_block706 );

    private final static java.lang.String  _wl_block707 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_reqd_yn";
    private final static byte[]  _wl_block707Bytes = _getBytes( _wl_block707 );

    private final static java.lang.String  _wl_block708 ="\" id=\"appt_reqd_yn";
    private final static byte[]  _wl_block708Bytes = _getBytes( _wl_block708 );

    private final static java.lang.String  _wl_block709 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block709Bytes = _getBytes( _wl_block709 );

    private final static java.lang.String  _wl_block710 ="\" id=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block710Bytes = _getBytes( _wl_block710 );

    private final static java.lang.String  _wl_block711 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_time";
    private final static byte[]  _wl_block711Bytes = _getBytes( _wl_block711 );

    private final static java.lang.String  _wl_block712 ="\" id=\"appt_time";
    private final static byte[]  _wl_block712Bytes = _getBytes( _wl_block712 );

    private final static java.lang.String  _wl_block713 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block713Bytes = _getBytes( _wl_block713 );

    private final static java.lang.String  _wl_block714 ="\" id=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block714Bytes = _getBytes( _wl_block714 );

    private final static java.lang.String  _wl_block715 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"complete_on_order_yn";
    private final static byte[]  _wl_block715Bytes = _getBytes( _wl_block715 );

    private final static java.lang.String  _wl_block716 ="\" id=\"complete_on_order_yn";
    private final static byte[]  _wl_block716Bytes = _getBytes( _wl_block716 );

    private final static java.lang.String  _wl_block717 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_yn";
    private final static byte[]  _wl_block717Bytes = _getBytes( _wl_block717 );

    private final static java.lang.String  _wl_block718 ="\" id=\"bill_yn";
    private final static byte[]  _wl_block718Bytes = _getBytes( _wl_block718 );

    private final static java.lang.String  _wl_block719 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_applicable_yn";
    private final static byte[]  _wl_block719Bytes = _getBytes( _wl_block719 );

    private final static java.lang.String  _wl_block720 ="\" id=\"result_applicable_yn";
    private final static byte[]  _wl_block720Bytes = _getBytes( _wl_block720 );

    private final static java.lang.String  _wl_block721 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block721Bytes = _getBytes( _wl_block721 );

    private final static java.lang.String  _wl_block722 ="\" id=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block722Bytes = _getBytes( _wl_block722 );

    private final static java.lang.String  _wl_block723 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chart_result_type";
    private final static byte[]  _wl_block723Bytes = _getBytes( _wl_block723 );

    private final static java.lang.String  _wl_block724 ="\" id=\"chart_result_type";
    private final static byte[]  _wl_block724Bytes = _getBytes( _wl_block724 );

    private final static java.lang.String  _wl_block725 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_mod_id";
    private final static byte[]  _wl_block725Bytes = _getBytes( _wl_block725 );

    private final static java.lang.String  _wl_block726 ="\" id=\"contr_msr_mod_id";
    private final static byte[]  _wl_block726Bytes = _getBytes( _wl_block726 );

    private final static java.lang.String  _wl_block727 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_panel_id";
    private final static byte[]  _wl_block727Bytes = _getBytes( _wl_block727 );

    private final static java.lang.String  _wl_block728 ="\" id=\"contr_msr_panel_id";
    private final static byte[]  _wl_block728Bytes = _getBytes( _wl_block728 );

    private final static java.lang.String  _wl_block729 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block729Bytes = _getBytes( _wl_block729 );

    private final static java.lang.String  _wl_block730 ="\" id=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block730Bytes = _getBytes( _wl_block730 );

    private final static java.lang.String  _wl_block731 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block731Bytes = _getBytes( _wl_block731 );

    private final static java.lang.String  _wl_block732 ="\" id=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block732Bytes = _getBytes( _wl_block732 );

    private final static java.lang.String  _wl_block733 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block733Bytes = _getBytes( _wl_block733 );

    private final static java.lang.String  _wl_block734 ="\" id=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block734Bytes = _getBytes( _wl_block734 );

    private final static java.lang.String  _wl_block735 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block735Bytes = _getBytes( _wl_block735 );

    private final static java.lang.String  _wl_block736 ="\" id=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block736Bytes = _getBytes( _wl_block736 );

    private final static java.lang.String  _wl_block737 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"activity_type";
    private final static byte[]  _wl_block737Bytes = _getBytes( _wl_block737 );

    private final static java.lang.String  _wl_block738 ="\" id=\"activity_type";
    private final static byte[]  _wl_block738Bytes = _getBytes( _wl_block738 );

    private final static java.lang.String  _wl_block739 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"check_for_dupl_level";
    private final static byte[]  _wl_block739Bytes = _getBytes( _wl_block739 );

    private final static java.lang.String  _wl_block740 ="\" id=\"check_for_dupl_level";
    private final static byte[]  _wl_block740Bytes = _getBytes( _wl_block740 );

    private final static java.lang.String  _wl_block741 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"group_order_category";
    private final static byte[]  _wl_block741Bytes = _getBytes( _wl_block741 );

    private final static java.lang.String  _wl_block742 ="\" id=\"group_order_category";
    private final static byte[]  _wl_block742Bytes = _getBytes( _wl_block742 );

    private final static java.lang.String  _wl_block743 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_call_yn";
    private final static byte[]  _wl_block743Bytes = _getBytes( _wl_block743 );

    private final static java.lang.String  _wl_block744 ="\" id=\"billing_call_yn";
    private final static byte[]  _wl_block744Bytes = _getBytes( _wl_block744 );

    private final static java.lang.String  _wl_block745 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"specimen_type";
    private final static byte[]  _wl_block745Bytes = _getBytes( _wl_block745 );

    private final static java.lang.String  _wl_block746 ="\" id=\"specimen_type";
    private final static byte[]  _wl_block746Bytes = _getBytes( _wl_block746 );

    private final static java.lang.String  _wl_block747 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"nurse_collect";
    private final static byte[]  _wl_block747Bytes = _getBytes( _wl_block747 );

    private final static java.lang.String  _wl_block748 ="\" id=\"nurse_collect";
    private final static byte[]  _wl_block748Bytes = _getBytes( _wl_block748 );

    private final static java.lang.String  _wl_block749 ="\" value=\"N\">\n\t\t\t\t\t<input type=\"hidden\" name=\"start_time";
    private final static byte[]  _wl_block749Bytes = _getBytes( _wl_block749 );

    private final static java.lang.String  _wl_block750 ="\" id=\"start_time";
    private final static byte[]  _wl_block750Bytes = _getBytes( _wl_block750 );

    private final static java.lang.String  _wl_block751 ="\" value=\"\"> <!-- For Care Sets -->\n\t\t\t\t\t<input type=\"hidden\" name=\"care_set_order_category";
    private final static byte[]  _wl_block751Bytes = _getBytes( _wl_block751 );

    private final static java.lang.String  _wl_block752 ="\" id=\"care_set_order_category";
    private final static byte[]  _wl_block752Bytes = _getBytes( _wl_block752 );

    private final static java.lang.String  _wl_block753 ="\" value=\"\"><!--For Care Sets-->\n\t\t\t\t\t<input type=\"hidden\" name=\"care_set_authorized";
    private final static byte[]  _wl_block753Bytes = _getBytes( _wl_block753 );

    private final static java.lang.String  _wl_block754 ="\" id=\"care_set_authorized";
    private final static byte[]  _wl_block754Bytes = _getBytes( _wl_block754 );

    private final static java.lang.String  _wl_block755 ="\" value=\"false\"> <!--For Care Sets-->\n\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block755Bytes = _getBytes( _wl_block755 );

    private final static java.lang.String  _wl_block756 ="\" id=\"order_id";
    private final static byte[]  _wl_block756Bytes = _getBytes( _wl_block756 );

    private final static java.lang.String  _wl_block757 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block757Bytes = _getBytes( _wl_block757 );

    private final static java.lang.String  _wl_block758 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block758Bytes = _getBytes( _wl_block758 );

    private final static java.lang.String  _wl_block759 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<!--<input type=\"hidden\" name=\"line_preps";
    private final static byte[]  _wl_block759Bytes = _getBytes( _wl_block759 );

    private final static java.lang.String  _wl_block760 ="\" id=\"line_preps";
    private final static byte[]  _wl_block760Bytes = _getBytes( _wl_block760 );

    private final static java.lang.String  _wl_block761 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_pat_instrn";
    private final static byte[]  _wl_block761Bytes = _getBytes( _wl_block761 );

    private final static java.lang.String  _wl_block762 ="\" id=\"line_pat_instrn";
    private final static byte[]  _wl_block762Bytes = _getBytes( _wl_block762 );

    private final static java.lang.String  _wl_block763 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_dept_instrn";
    private final static byte[]  _wl_block763Bytes = _getBytes( _wl_block763 );

    private final static java.lang.String  _wl_block764 ="\" id=\"line_dept_instrn";
    private final static byte[]  _wl_block764Bytes = _getBytes( _wl_block764 );

    private final static java.lang.String  _wl_block765 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_comments";
    private final static byte[]  _wl_block765Bytes = _getBytes( _wl_block765 );

    private final static java.lang.String  _wl_block766 ="\" id=\"line_comments";
    private final static byte[]  _wl_block766Bytes = _getBytes( _wl_block766 );

    private final static java.lang.String  _wl_block767 ="\">";
    private final static byte[]  _wl_block767Bytes = _getBytes( _wl_block767 );

    private final static java.lang.String  _wl_block768 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block768Bytes = _getBytes( _wl_block768 );

    private final static java.lang.String  _wl_block769 ="\" id=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block769Bytes = _getBytes( _wl_block769 );

    private final static java.lang.String  _wl_block770 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block770Bytes = _getBytes( _wl_block770 );

    private final static java.lang.String  _wl_block771 ="\" id=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block771Bytes = _getBytes( _wl_block771 );

    private final static java.lang.String  _wl_block772 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block772Bytes = _getBytes( _wl_block772 );

    private final static java.lang.String  _wl_block773 ="\" id=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block773Bytes = _getBytes( _wl_block773 );

    private final static java.lang.String  _wl_block774 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block774Bytes = _getBytes( _wl_block774 );

    private final static java.lang.String  _wl_block775 ="\" id=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block775Bytes = _getBytes( _wl_block775 );

    private final static java.lang.String  _wl_block776 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block776Bytes = _getBytes( _wl_block776 );

    private final static java.lang.String  _wl_block777 ="\" id=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block777Bytes = _getBytes( _wl_block777 );

    private final static java.lang.String  _wl_block778 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block778Bytes = _getBytes( _wl_block778 );

    private final static java.lang.String  _wl_block779 ="\" id=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block779Bytes = _getBytes( _wl_block779 );

    private final static java.lang.String  _wl_block780 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"consent_stage";
    private final static byte[]  _wl_block780Bytes = _getBytes( _wl_block780 );

    private final static java.lang.String  _wl_block781 ="\" id=\"consent_stage";
    private final static byte[]  _wl_block781Bytes = _getBytes( _wl_block781 );

    private final static java.lang.String  _wl_block782 ="\">\n\t\t\t\t\t<!-- added on 08/05/07 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block782Bytes = _getBytes( _wl_block782 );

    private final static java.lang.String  _wl_block783 ="\" id=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block783Bytes = _getBytes( _wl_block783 );

    private final static java.lang.String  _wl_block784 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_br";
    private final static byte[]  _wl_block784Bytes = _getBytes( _wl_block784 );

    private final static java.lang.String  _wl_block785 ="\" id=\"num_of_consent_req_br";
    private final static byte[]  _wl_block785Bytes = _getBytes( _wl_block785 );

    private final static java.lang.String  _wl_block786 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_interface";
    private final static byte[]  _wl_block786Bytes = _getBytes( _wl_block786 );

    private final static java.lang.String  _wl_block787 ="\" id=\"billing_interface";
    private final static byte[]  _wl_block787Bytes = _getBytes( _wl_block787 );

    private final static java.lang.String  _wl_block788 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel";
    private final static byte[]  _wl_block788Bytes = _getBytes( _wl_block788 );

    private final static java.lang.String  _wl_block789 ="\" id=\"service_panel";
    private final static byte[]  _wl_block789Bytes = _getBytes( _wl_block789 );

    private final static java.lang.String  _wl_block790 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel_code";
    private final static byte[]  _wl_block790Bytes = _getBytes( _wl_block790 );

    private final static java.lang.String  _wl_block791 ="\" id=\"service_panel_code";
    private final static byte[]  _wl_block791Bytes = _getBytes( _wl_block791 );

    private final static java.lang.String  _wl_block792 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"numbering";
    private final static byte[]  _wl_block792Bytes = _getBytes( _wl_block792 );

    private final static java.lang.String  _wl_block793 ="\" id=\"numbering";
    private final static byte[]  _wl_block793Bytes = _getBytes( _wl_block793 );

    private final static java.lang.String  _wl_block794 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"FinBill";
    private final static byte[]  _wl_block794Bytes = _getBytes( _wl_block794 );

    private final static java.lang.String  _wl_block795 ="\" id=\"FinBill";
    private final static byte[]  _wl_block795Bytes = _getBytes( _wl_block795 );

    private final static java.lang.String  _wl_block796 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block796Bytes = _getBytes( _wl_block796 );

    private final static java.lang.String  _wl_block797 ="\" id=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block797Bytes = _getBytes( _wl_block797 );

    private final static java.lang.String  _wl_block798 ="\">\n\t\t\t\t<!-- \t<input type=\"hidden\" name=\"can_authorise_yn";
    private final static byte[]  _wl_block798Bytes = _getBytes( _wl_block798 );

    private final static java.lang.String  _wl_block799 ="\" id=\"can_authorise_yn";
    private final static byte[]  _wl_block799Bytes = _getBytes( _wl_block799 );

    private final static java.lang.String  _wl_block800 ="\"> -->\n\t\t\t\t\t<input type=\"hidden\" name=\"authorised_yn";
    private final static byte[]  _wl_block800Bytes = _getBytes( _wl_block800 );

    private final static java.lang.String  _wl_block801 ="\" id=\"authorised_yn";
    private final static byte[]  _wl_block801Bytes = _getBytes( _wl_block801 );

    private final static java.lang.String  _wl_block802 ="\" value=\"N\">\n\t\t\t\t\t<input type=\"hidden\" name=\"skip_auth";
    private final static byte[]  _wl_block802Bytes = _getBytes( _wl_block802 );

    private final static java.lang.String  _wl_block803 ="\" id=\"skip_auth";
    private final static byte[]  _wl_block803Bytes = _getBytes( _wl_block803 );

    private final static java.lang.String  _wl_block804 ="\"><!--IN048467 - HSA-CRF-0150-->\n\t\t\t\t\t<input type=\"hidden\" name=\"barcode_reqd_yn";
    private final static byte[]  _wl_block804Bytes = _getBytes( _wl_block804 );

    private final static java.lang.String  _wl_block805 ="\" id=\"barcode_reqd_yn";
    private final static byte[]  _wl_block805Bytes = _getBytes( _wl_block805 );

    private final static java.lang.String  _wl_block806 ="\"><!--IN063816 - GHL-CRF-0445.1 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"prn_regd_ord";
    private final static byte[]  _wl_block806Bytes = _getBytes( _wl_block806 );

    private final static java.lang.String  _wl_block807 ="\" id=\"prn_regd_ord";
    private final static byte[]  _wl_block807Bytes = _getBytes( _wl_block807 );

    private final static java.lang.String  _wl_block808 ="\"><!--IN065942-->\n\t\t\t\t\t<input type=\"hidden\" name=\"instrn_content_type";
    private final static byte[]  _wl_block808Bytes = _getBytes( _wl_block808 );

    private final static java.lang.String  _wl_block809 ="\" id=\"instrn_content_type";
    private final static byte[]  _wl_block809Bytes = _getBytes( _wl_block809 );

    private final static java.lang.String  _wl_block810 ="\'><!--IN065942--><!--IN64543-->\n\t\t\t\t\t<input type=\"hidden\" name=\"non_billing_numbering";
    private final static byte[]  _wl_block810Bytes = _getBytes( _wl_block810 );

    private final static java.lang.String  _wl_block811 ="\" id=\"non_billing_numbering";
    private final static byte[]  _wl_block811Bytes = _getBytes( _wl_block811 );

    private final static java.lang.String  _wl_block812 ="\"  id =\"non_billing_numbering";
    private final static byte[]  _wl_block812Bytes = _getBytes( _wl_block812 );

    private final static java.lang.String  _wl_block813 ="\" /><!--IN068314 -->\n\t\t\t\t";
    private final static byte[]  _wl_block813Bytes = _getBytes( _wl_block813 );

    private final static java.lang.String  _wl_block814 ="\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"splty_code";
    private final static byte[]  _wl_block814Bytes = _getBytes( _wl_block814 );

    private final static java.lang.String  _wl_block815 ="\" id=\"splty_code";
    private final static byte[]  _wl_block815Bytes = _getBytes( _wl_block815 );

    private final static java.lang.String  _wl_block816 ="\">\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"auth_yn";
    private final static byte[]  _wl_block816Bytes = _getBytes( _wl_block816 );

    private final static java.lang.String  _wl_block817 ="\" id=\"auth_yn";
    private final static byte[]  _wl_block817Bytes = _getBytes( _wl_block817 );

    private final static java.lang.String  _wl_block818 ="\" value=\"\">\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"auth_yn";
    private final static byte[]  _wl_block818Bytes = _getBytes( _wl_block818 );

    private final static java.lang.String  _wl_block819 ="\n\t\t\t\t\t<!-- ends here-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block819Bytes = _getBytes( _wl_block819 );

    private final static java.lang.String  _wl_block820 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block820Bytes = _getBytes( _wl_block820 );

    private final static java.lang.String  _wl_block821 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block821Bytes = _getBytes( _wl_block821 );

    private final static java.lang.String  _wl_block822 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block822Bytes = _getBytes( _wl_block822 );

    private final static java.lang.String  _wl_block823 ="<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block823Bytes = _getBytes( _wl_block823 );

    private final static java.lang.String  _wl_block824 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block824Bytes = _getBytes( _wl_block824 );

    private final static java.lang.String  _wl_block825 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"auto_report_yn";
    private final static byte[]  _wl_block825Bytes = _getBytes( _wl_block825 );

    private final static java.lang.String  _wl_block826 ="\" id=\"auto_report_yn";
    private final static byte[]  _wl_block826Bytes = _getBytes( _wl_block826 );

    private final static java.lang.String  _wl_block827 =" \t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block827Bytes = _getBytes( _wl_block827 );

    private final static java.lang.String  _wl_block828 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"9\" class=\"OR_QRYEVENBORDER\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block828Bytes = _getBytes( _wl_block828 );

    private final static java.lang.String  _wl_block829 ="\n\t</table>\n\t\t<input type=\"hidden\" name=\"patient_email_id\" id=\"patient_email_id\" value=\"";
    private final static byte[]  _wl_block829Bytes = _getBytes( _wl_block829 );

    private final static java.lang.String  _wl_block830 ="\">\n\t\t<input type=\"hidden\" name=\"care_set_count\" id=\"care_set_count\" value=\"0\"><!-- Used for Care Sets-->\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\'";
    private final static byte[]  _wl_block830Bytes = _getBytes( _wl_block830 );

    private final static java.lang.String  _wl_block831 ="\'>\n\t\t<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\"";
    private final static byte[]  _wl_block831Bytes = _getBytes( _wl_block831 );

    private final static java.lang.String  _wl_block832 ="\">\n\t\t<input type=\"hidden\" name=\"amend_total_rows\" id=\"amend_total_rows\" value=\"";
    private final static byte[]  _wl_block832Bytes = _getBytes( _wl_block832 );

    private final static java.lang.String  _wl_block833 ="\">\n\t\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"\">\n\t\t<input type=\"hidden\" name=\"authorized\" id=\"authorized\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"priority_hdr\" id=\"priority_hdr\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_date_time\" id=\"order_date_time\" value=\"\">\n\t\t<input type=\"hidden\" name=\"header_comments\" id=\"header_comments\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"\">\n\t\t<input type=\"hidden\" name=\"consented\" id=\"consented\" value=\"\">\n\t\t<input type=\"hidden\" name=\"cosigned\" id=\"cosigned\" value=\"\">\n\t\t<input type=\"hidden\" name=\"special_approved\" id=\"special_approved\" value=\"\">\n\t\t<input type=\"hidden\" name=\"lb_instal_yn\" id=\"lb_instal_yn\" value=\"";
    private final static byte[]  _wl_block833Bytes = _getBytes( _wl_block833 );

    private final static java.lang.String  _wl_block834 ="\">\n\t\t<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block834Bytes = _getBytes( _wl_block834 );

    private final static java.lang.String  _wl_block835 ="\">\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block835Bytes = _getBytes( _wl_block835 );

    private final static java.lang.String  _wl_block836 ="\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block836Bytes = _getBytes( _wl_block836 );

    private final static java.lang.String  _wl_block837 ="\">\n\t\t<input type=\"hidden\" name=\"display_auth_count\" id=\"display_auth_count\" value=\"";
    private final static byte[]  _wl_block837Bytes = _getBytes( _wl_block837 );

    private final static java.lang.String  _wl_block838 ="\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block838Bytes = _getBytes( _wl_block838 );

    private final static java.lang.String  _wl_block839 ="\">\n\t\t<input type=\"hidden\" name=\"ordering_practitioner\" id=\"ordering_practitioner\" value=\"";
    private final static byte[]  _wl_block839Bytes = _getBytes( _wl_block839 );

    private final static java.lang.String  _wl_block840 ="\">\n\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block840Bytes = _getBytes( _wl_block840 );

    private final static java.lang.String  _wl_block841 ="\">\n\t\t<!-- IN030279 Start -->\n\t\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block841Bytes = _getBytes( _wl_block841 );

    private final static java.lang.String  _wl_block842 ="\">\n\t\t<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block842Bytes = _getBytes( _wl_block842 );

    private final static java.lang.String  _wl_block843 ="\">\n\t\t<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block843Bytes = _getBytes( _wl_block843 );

    private final static java.lang.String  _wl_block844 ="\">\n\t\t<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block844Bytes = _getBytes( _wl_block844 );

    private final static java.lang.String  _wl_block845 ="\">\n\t\t<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block845Bytes = _getBytes( _wl_block845 );

    private final static java.lang.String  _wl_block846 ="\">\n\t\t<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block846Bytes = _getBytes( _wl_block846 );

    private final static java.lang.String  _wl_block847 ="\">\n\t\t<!-- IN030279 End. -->\n\t\t<input type=\"hidden\" name=\"p_task_code\" id=\"p_task_code\" value=\"";
    private final static byte[]  _wl_block847Bytes = _getBytes( _wl_block847 );

    private final static java.lang.String  _wl_block848 ="\">\n\t\t<input type=\"hidden\" name=\"p_task_srl_no\" id=\"p_task_srl_no\" value=\"";
    private final static byte[]  _wl_block848Bytes = _getBytes( _wl_block848 );

    private final static java.lang.String  _wl_block849 ="\">\n\t\t<input type=\"hidden\" name=\"ref_facility_id\" id=\"ref_facility_id\" value=\"";
    private final static byte[]  _wl_block849Bytes = _getBytes( _wl_block849 );

    private final static java.lang.String  _wl_block850 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_date_time\" id=\"ref_date_time\" value=\"";
    private final static byte[]  _wl_block850Bytes = _getBytes( _wl_block850 );

    private final static java.lang.String  _wl_block851 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_pract_id\" id=\"ref_sent_pract_id\" value=\"";
    private final static byte[]  _wl_block851Bytes = _getBytes( _wl_block851 );

    private final static java.lang.String  _wl_block852 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_remarks\" id=\"ref_sent_remarks\" value=\"";
    private final static byte[]  _wl_block852Bytes = _getBytes( _wl_block852 );

    private final static java.lang.String  _wl_block853 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block853Bytes = _getBytes( _wl_block853 );

    private final static java.lang.String  _wl_block854 ="\"><!--Query String-->\n\t\t<input type=\"hidden\" name=\"perfLocnMandFlag\" id=\"perfLocnMandFlag\" value=\"";
    private final static byte[]  _wl_block854Bytes = _getBytes( _wl_block854 );

    private final static java.lang.String  _wl_block855 ="\"><!--IN066377-->\n\t\t<input type=\"hidden\" name=\"bt_order_type_code\" id=\"bt_order_type_code\" value=\"";
    private final static byte[]  _wl_block855Bytes = _getBytes( _wl_block855 );

    private final static java.lang.String  _wl_block856 ="\">\n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"ORCAT\"><!--IN066377-->\n\t\t";
    private final static byte[]  _wl_block856Bytes = _getBytes( _wl_block856 );

    private final static java.lang.String  _wl_block857 ="\n\t\t\t<input type=\"hidden\" name=\"care_set_catalog_code\" id=\"care_set_catalog_code\" value=\"";
    private final static byte[]  _wl_block857Bytes = _getBytes( _wl_block857 );

    private final static java.lang.String  _wl_block858 ="\"><!-- Used for Care Sets-->\n\t\t\t<input type=\"hidden\" name=\"care_set_catalog_desc\" id=\"care_set_catalog_desc\" value=\"";
    private final static byte[]  _wl_block858Bytes = _getBytes( _wl_block858 );

    private final static java.lang.String  _wl_block859 ="\"><!-- Used for Care Sets-->\n\t\t";
    private final static byte[]  _wl_block859Bytes = _getBytes( _wl_block859 );

    private final static java.lang.String  _wl_block860 ="\n\t\t\t<input type=\"hidden\" name=\"care_set_catalog_code\" id=\"care_set_catalog_code\" value=\"\"><!-- Used for Care Sets-->\n\t\t\t<input type=\"hidden\" name=\"care_set_catalog_desc\" id=\"care_set_catalog_desc\" value=\"\"><!-- Used for Care Sets-->\n\t\t";
    private final static byte[]  _wl_block860Bytes = _getBytes( _wl_block860 );

    private final static java.lang.String  _wl_block861 ="\n\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"NEW_ORDER\"> <!-- For Order Format Line Level -->\n    \t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block861Bytes = _getBytes( _wl_block861 );

    private final static java.lang.String  _wl_block862 ="\">\n\t\t\t <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->\n\t\t<input type=\"hidden\" name=\"cosign_reqd_yn\" id=\"cosign_reqd_yn\" value=\"\"> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn=\'Y\' when nurse is logging in -->\n\t\t<input type=\"hidden\" name=\"primary_order_type\" id=\"primary_order_type\" value=\"\"> <!-- Used for Primary Order Type OT Ordercategory -->\n\t\t<input type=\"hidden\" name=\"validated_status\" id=\"validated_status\" value=\"validation_reqd\">\n\t\t<input type=\"hidden\" name=\"new_order_reqd\" id=\"new_order_reqd\" value=\"\"> \n\t\t<input type=\"hidden\" name=\"email_yn\" id=\"email_yn\" value=\"N\"> <!-- For Email -->\n\t\t<input type=\"hidden\" name=\"appl_user_name\" id=\"appl_user_name\" value=\"";
    private final static byte[]  _wl_block862Bytes = _getBytes( _wl_block862 );

    private final static java.lang.String  _wl_block863 ="\"> \n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block863Bytes = _getBytes( _wl_block863 );

    private final static java.lang.String  _wl_block864 ="\">\n\t\t<input type=\"hidden\" name=\"order_set_bill_yn\" id=\"order_set_bill_yn\" value=\"";
    private final static byte[]  _wl_block864Bytes = _getBytes( _wl_block864 );

    private final static java.lang.String  _wl_block865 ="\">\n\t\t<input type=\"hidden\" name=\"checkCount\" id=\"checkCount\" value=\"\">\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block865Bytes = _getBytes( _wl_block865 );

    private final static java.lang.String  _wl_block866 ="\">\n\t\t<input type=\"hidden\" name=\"twicedupchkflg\" id=\"twicedupchkflg\" value=\"";
    private final static byte[]  _wl_block866Bytes = _getBytes( _wl_block866 );

    private final static java.lang.String  _wl_block867 ="\"> <!-- IN062607 -->\n\t\t<input type=\"hidden\" name=\"show_bill_info_yn\" id=\"show_bill_info_yn\" value=\"";
    private final static byte[]  _wl_block867Bytes = _getBytes( _wl_block867 );

    private final static java.lang.String  _wl_block868 ="\"> <!-- added for IN039607 -->\n\n\t\t<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block868Bytes = _getBytes( _wl_block868 );

    private final static java.lang.String  _wl_block869 ="\"><!--IN065942-->\n\t\t<input type=\"hidden\" name=\"interactionDrugsCnt\" id=\"interactionDrugsCnt\"  id =\"interactionDrugsCnt\" value=\"";
    private final static byte[]  _wl_block869Bytes = _getBytes( _wl_block869 );

    private final static java.lang.String  _wl_block870 ="\" />\t<!-- IN071260 -->\n\n\t\t<!-- For Amend Order , To generate a New Order-->\n";
    private final static byte[]  _wl_block870Bytes = _getBytes( _wl_block870 );

    private final static java.lang.String  _wl_block871 ="\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n \t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n \t\t   \t<tr>\n \t\t \t\t<td width=\'100%\' id=\'t\'></td>\n \t\t\t</tr>\n \t\t</table>\n\t</div>\n\t</body>\n\t<script>\n\t\n\tloadDetails(\"";
    private final static byte[]  _wl_block871Bytes = _getBytes( _wl_block871 );

    private final static java.lang.String  _wl_block872 ="\")\n\tskipAuthIndicator();//IN048467\n\t</script>\n\t \n\t<script>\n\t\tif(parent.legendsFrame.document.getElementById(\'titleTab\')!=null) {\n\t\t\talignWidth(\'";
    private final static byte[]  _wl_block872Bytes = _getBytes( _wl_block872 );

    private final static java.lang.String  _wl_block873 ="\');\n\t\t}\n\t\t <!-- added for IN039607 -->\n\t\tvar show_bill_info_yn = document.placeOrderForm.show_bill_info_yn.value;\n\t\tif(show_bill_info_yn==\'Y\') {\n\t\t\tshowBillingTable();\n\t\t}\t\n\t\t<!-- added for IN039607 -->\n\t</script>\n\t<script>\n\t\tchkCount();\n\t</script>\n\t</html>\n";
    private final static byte[]  _wl_block873Bytes = _getBytes( _wl_block873 );
	
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

/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
10/08/2011    28198         Menaka      	Incident No: 28198 - <System not allows amending start date of 
												Radiology Order When Schedule Applicable= Unchecking.> 
23/09/2011	  28806			Menaka			Incident No: 28806 - <Radiology order-> setup schedule 
												applicable=Checked , it can?t change start date by click on ?Start date? header and can?t click on ?calendar icon? but user can change start date by typing new date and time on that field.>		 
06/09/2011    IN31901       NijithaS    	Incident No: IN31901 - Bru-HIMS-CRF-263		                                         		 
14/09/2012    IN035095		vijayakumark 	default performing location  should be login facility
25/09/2012	  IN030279		Ramesh G		Bru-HIMS-CRF-160 								 
03/04/2013    IN035929 		Karthi L		    When user Place in OR/CA, user should not see Service charges. 							 
08/05/2013    IN039607 		Karthi L		    Charges are not posted in Billing Module if ?Display Billing Information? is Unchecked in OR Parameter for Facility .
07/06/2013    IN040531		Nijitha S		    ALPHA- OR- Getting Script Error while "Amend" the Placed Orders.
22/07/2013    IN041421      Chowminya G         Special characters -record consent "Internal Server Error"	
13/08/2013	  IN042045		Chowminya G	    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
23/09/2013    IN043099		Nijitha 		CRF-OT-Bru-Hims-CRF-004.2/03-Booking Priority field is not displayed when Surgery type is amended
06/01/2014	  IN044014		Chowminya		System is not defaulting the Department if users selecting the performing location
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
24/02/2014	  IN046975		Chowminya	25/02/2014		Ramesh G			System display 1st order quantity as 2 units but display total charge as 1 unit
01/03/2014	  IN047469		Chowminya   05/03/2014		Ramesh G			Amend Orders splitting issue and performing location in multifacility scenario issue
14/03/2014    IN041644		Nijitha S		 								Prescription - Authorization of Drugs â?? Based on Rules.
18/03/2014	  IN047739		Chowminya										Perform location code wrong in Amend
02/07/2014	  IN048467 		Nijitha S										HSA-CRF-0150
03/07/2014    IN049984		Chowminya										performing loc setup for catalog done but it is not appear during transaction	
26/08/2014    IN050607		Nijitha S										KDAH-SCF-0255	
16/06/2016	  IN029076      Raja S											Start Date becomes blank after refreshing the order screen
09/06/2017	  IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]	
03/07/2017	  IN062607		Raja S		03/07/2017		Ramesh G			ML-MMOH-CRF-0727
19/10/2017	  IN065324		Dinesh T										To display the price in OR screen and the billing status in Manage Specimen screen
15/12/2017	  IN065942		Dinesh T	15/12/2017		Ramesh G			In Nuclear medicine  department we required the barcode functionality at the time of 
08/02/2018	  IN066436		Raja S		08/02/2018		Ramesh G			SS-SCF-0777
17/07/2018	IN064543	Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776																			name of study.
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
24/08/2018	IN68475			Dinesh T		24/08/2018	Ramesh G			Amend an order which has comments in the order format window. 
																			The preview window is not showing the already recorded comments 
																			in the preview window which is invoked on press of Preview button on the right corner of the bottom of the screen
09/01/2019  	IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
06/02/2019	IN069674 		Kamalakannan G		06/02/2019		Ramesh G.		AMS-CRF-0139/03 
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
17/02/2020	IN071260	Nijitha S	17/02/2020	Ramesh G	MMS-KH-CRF-0029.3
17/03/2020	IN072683	Nijitha S	17/03/2020	Ramesh G	MMS-KH-CRF-0029.3
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
22/12/2020	10503		Nijitha S	22/12/2020	Ramesh G	ML-MMOH-CRF1229.4
15/03/2021  15911		Durga Natarajan		15/03/2021		RAMESH G		ALPHA-CA-Text Block Label Name 
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
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
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String temptype="";
	String check="";
	String patient_email_id="";
	Object prepins				= "IS";
	String order_types_comb = "";
	ArrayList OrderFormatTypes = new ArrayList();
	int count = 0;
	ArrayList arrSeqNo1			= new ArrayList();
	String ind_catalog_code	= "", ind_row_value			= "";
	String[] order_type_records = null;
	int row_value=0;
	String order_type_code = "";
	String field_mnemonic	= "";
	int seq_num				= 0 , new_seq_num = 0;
	int old_seq_num			= 0;
	String old_field_mnemonic="";
	Hashtable template			= null;
	boolean exists			= false;
	String field_type		= "";
	String field_values		= "";
	String dflt_value		= "";
	String fac_selected		= "";//IN044014

	/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	int numbering = 0;
	int non_billing_numbering=0;//IN068314		
	String billinginterface="";
	String displaytooltip="";
	/* Ends Here*/
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	beanQueryObj.setLanguageId(localeName);

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";

	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	   bean1.setLanguageId(localeName);
	 String practitioner_id = (String)session.getValue("ca_practitioner_id");
/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
	 String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	
	String data[] = null;
	//String data[]=bean.getEmailDataDetails((String)bean.getLoginFacilityId());Commented Email part as told by Rajan
	if(data!=null && data.length>0)
	{
		patient_email_id=bean.checkForNull(data[1],"");
	}	
	/* Initialize Function specific end */
	String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
   	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
   	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
	String forceStatus				= bean.getForceStatus(practitioner_type,order_category);
	String fStatus[]=forceStatus.split(":");
	String lb_instal_yn				= bean.checkForNull(request.getParameter("lb_instal_yn"),"N");
	String rd_instal_yn				= "N";
	//IN069657, starts
	/*if(order_category.equals("RD"))
  	rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
  	*/
	rd_instal_yn =  bean.getRDInstallYN();
	//IN069657, ends
	String session_id				= bean.checkForNull(request.getParameter("session_id"),"");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN030279 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN030279 End.
	//IN062607 Starts

	String l_patient_class = bean.checkForNull(request.getParameter("patient_class"),"");//IN065324
	String perfLocnMandFlag = "N";//IN066377
	String bt_order_type_code = "";//IN066377
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	//IN072654 Starts
	HashMap<String,String> tempMap = new HashMap<String,String>();
	HashMap<String, ArrayList<OrderDrugInteractionVO>> dtlsTemp = new HashMap<String, ArrayList<OrderDrugInteractionVO>>();
	bean.setDruginteractionYN(tempMap);
	bean.setDruginteractionDtl(dtlsTemp);
	//IN072654 Ends
	try
	{
		con				=	ConnectionManager.getConnection(request);
		dup_custSpecificFlg = CommonBean.isSiteSpecific(con, "OR","TWICE_DUPLICATE_ALERT");
		if(dup_custSpecificFlg)
			dupchk_siteSpecFlag ="Y";
	//IN066377 start
		String sql = "select * from OR_ORDER_PERF_LOCN_MAND where order_category=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,order_category);
		rs = pstmt.executeQuery();
		if(rs.next()){
			perfLocnMandFlag = bean.checkForNull(rs.getString(l_patient_class),"N");
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();
		String btOrderTypeQuery = "SELECT DISTINCT order_type_code FROM or_order_catalog WHERE order_category = 'LB' AND order_type_code IN ( SELECT order_type_code FROM rl_section_code WHERE section_code IN ( SELECT bt_section_code FROM rl_param))";
		pstmt = con.prepareStatement(btOrderTypeQuery);
		rs = pstmt.executeQuery();
		if(rs.next()){
			bt_order_type_code = rs.getString("order_type_code")==null ?"":rs.getString("order_type_code");
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();
	//IN066377 end
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	}
	//IN062607 Ends
	
	String p_start_date_time		= bean.checkForNull(request.getParameter("p_start_date_time"),"");
	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String called_from			= bean.checkForNull(request.getParameter("called_from"),"");
 	String classValue				= "", chk_class_value = "";
	String existing_bean_id			= "", existing_bean_name="";
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String ammend_start_date_time	= "";
	HashMap instructionsMap = new HashMap();
	
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	if(function_from.equals("EXTERNAL_ORDER")) 
	{ // Get the Bean Instance of External Orders
		existing_bean_id 			= "Or_ExternalOrders";
		existing_bean_name			= "eOR.ExternalOrdersBean";
		//external_bean_obj			= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj			= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		ref_facility_id				= bean.checkForNull(external_bean_obj.getFacilityId(),"");
		ref_date_time				= bean.checkForNull(external_bean_obj.getReferral_date(),"");
		ref_sent_pract_id			= bean.checkForNull(external_bean_obj.getPractitionerId(),"");
		ref_sent_remarks			= bean.checkForNull(external_bean_obj.getRemarks(),"");
		// Get the External Order Reference Values, to be inserted into the or_order table
            _bw.write(_wl_block10Bytes, _wl_block10);

	} // End of function-from
	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
	//java.util.Date date_time	 	= new java.util.Date();
	//String dateString 			= dtSystemFormat.format(date_time);

	String dateString				= bean.getSysDate();
	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
	ArrayList AmendPlaceOrderItems	= null;
	ArrayList AmendSchedule			= null;
	ArrayList AmendPlaceOrderFrequency= null;
	//ArrayList AmendPlaceOrderDuration= null;
	ArrayList AmendSpecimenNurse	 = null;
	if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
		AmendPlaceOrderItems		= bean.getAmendPlaceOrdersResult(bean.checkForNull(bean.getOrderId(),""));
	String specialty_code			= "";
	String auth_reqd				= "";
	//auth_reqd						= (String)bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	int i							= 0, amend_count		= 0, display_special_count   = 0;
	int display_auth_count			= 0, amend_format_count = 0, format_mandatory_count = 0;
	int drugintercnt = 0;//IN068314
	int format_count 		= 0, display_cosign_count   = 0;//age_in_days					= 0, 
	String preps_instrn 			= "", frequency_val		= "", qty_value				= "";
	String preps_dept_instrn		= "", duration_value	= "", qty_uom				= "",qty_uom_shortdesc				   = "";;
	String pat_preps_instrn			= "", max_durn_value	= "";
	String chk_for_max_durn_action = "";//sex_yn					= "",
	String format_id				= "", prompt_msg		= "";
	String format_id_mandatory_yn	= "", comments			= "";
	String amend_specimen_type		= "", amend_nurse_collect_yn = "N", amend_start_disabled = "";
	String amend_appt_reqd_yn		= "N",amend_routine_appt_reqd_yn="N";
	String amend_stat_appt_reqd_yn	= "N",amend_urgent_appt_reqd_yn ="N";
  	String order_id					= "", order_line_no			= "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;
	String[] amendRecords 			= null;
	//String[] peformingFacility		= null; 
	String[] AmendfrequencyRecords = null;

	String[] records				= null; //String[] amendDurationRecords  = null;
	String[] orderTypeRecords		= null; String[] frequencyRecords	   = null;
	//String[] durationRecords		= null; 
	String[] deptLocation		   = null;
	String[] performingLocation		   = null;
	String[] secondaryOrders		= new String[2];
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N", facility_name	= "";
	String sec_start_date_time		= "";
	String amend_billing_call_yn	= "N";
	ArrayList DeptLocationCode 		= null;
	ArrayList performingLocationCode= null;
	ArrayList PlaceOrderType		= null;
	ArrayList PlaceOrderFrequency	= null;
	StringTokenizer stFormatID		= null;
	HashMap copyOrderDetails		= null;

	HashMap bill_set_dtls				= null;
	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	HashMap ordersetBills_dtls			= null;
	String[] billing_details 		= null;
	String[] order_billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	String patientDischargedYn      = "N";
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); // added for IN035929

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block13Bytes, _wl_block13);

	String order_set_bill_yn = "N";
	String[] OrderSetValues = new String[9];
	String bill_orderId = "";
	String bill_order_line_num = "";
	String bill_dateString = "";
	String bill_order_catalog_code = "";
	String order_qty = "";
	String bill_order_category = "";
	String bill_order_set_desc = "";
	String charge_yn = "";
	String fpp_yn_set = "";//10503
	String fpp_category_set = "";//10503
	patientDischargedYn = (String)bean.getPatientDischarged();
	if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
	{
		bill_orderId=bean_qryobj.getOrderSetId(bean.checkForNull(bean.getOrderId(),""));
		if(bill_orderId==null) bill_orderId="";
		if(!bill_orderId.equals(""))
		{
			OrderSetValues=bean_qryobj.getOrderSetDetails(bill_orderId);
			bill_order_line_num=bean.checkForNull(OrderSetValues[1],"");
			bill_dateString=bean.checkForNull(OrderSetValues[2],"");
			bill_order_catalog_code=OrderSetValues[3];
			order_qty=bean.checkForNull(OrderSetValues[4],"");
			order_set_bill_yn=bean.checkForNull(OrderSetValues[5],"");
			bill_order_category=bean.checkForNull(OrderSetValues[6],"");
			bill_order_set_desc=bean.checkForNull(OrderSetValues[7],"");
			charge_yn=bean.checkForNull(OrderSetValues[8],"");
			fpp_yn_set=bean.checkForNull(OrderSetValues[9],"");//10503
			fpp_category_set=bean.checkForNull(OrderSetValues[10],"");//10503
			//if(charge_yn.equalsIgnoreCase("N"))
			//{
				//order_set_bill_yn = "N";
			//}
		}
	}
	
	boolean show_order_set_bt_bill_dtls = false;//IN065324

	//IN065324, starts
	if(is_bt_view_bill_dtls && "BT".equals(bill_order_category) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)))
	{
		show_order_set_bt_bill_dtls = true;
	}
	else if("Y".equals(fpp_yn_set)){//10503 Starts
		show_order_set_bt_bill_dtls = true;
	}//10503 Ends
	else
	{
		show_order_set_bt_bill_dtls = false;
	}
	//IN065324, ends
	
	//if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !bill_order_category.equals("BT"))//IN065324
	if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && show_order_set_bt_bill_dtls)//IN065324
	{
		numbering = 0;
		//10503 Starts
		//BillChargeInfo		= bean_qryobj.getBillChargeDetails(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		if("Y".equals(fpp_yn_set))
		{
			BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),fpp_yn_set,fpp_category_set) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			
		}
		else{
			BillChargeInfo		= bean_qryobj.getBillChargeDetails(order_qty,bill_order_catalog_code,bill_dateString,localeName, bill_orderId,bill_order_line_num,bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		//10503 Ends
		if(BillChargeInfo==null) 
			BillChargeInfo= new ArrayList();
		order_billing_details = null;
		for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
		{
			order_billing_details 	= (String[])BillChargeInfo.get(m);
			ordersetBills_dtls		= new HashMap();
			ordersetBills_dtls.put("charged_yn"       , order_billing_details[1]);
			ordersetBills_dtls.put("total_payable"    , order_billing_details[2]);
			ordersetBills_dtls.put("patient_payable"  , order_billing_details[3]);
			ordersetBills_dtls.put("quantity"         ,order_qty);
			ordersetBills_dtls.put("incl_excl_action" , order_billing_details[4]);
			ordersetBills_dtls.put("incl_excl_action_orginal" , order_billing_details[16]);
			ordersetBills_dtls.put("preapp_yn"        , order_billing_details[5]);
			ordersetBills_dtls.put("patient_paid_amt" , order_billing_details[6]);
			ordersetBills_dtls.put("bl_panel_str"     , order_billing_details[0]);
			ordersetBills_dtls.put("serv_panel_ind"   , order_billing_details[10]);
			ordersetBills_dtls.put("serv_panel_code"  , order_billing_details[11]);
			ordersetBills_dtls.put("p_episode_type"	 , order_billing_details[13]);
			ordersetBills_dtls.put("p_episode_id"	 , order_billing_details[14]);
			ordersetBills_dtls.put("p_visit_id"		 , order_billing_details[15]);
			ordersetBills_dtls.put("Future_order_yn"		 , order_billing_details[17]);
			ordersetBills_dtls.put("rate"		 , "");
			ordersetBills_dtls.put("excl_incl_ind_for_screen"		 , order_billing_details[4]);
			ordersetBills_dtls.put("mod_physician_id"		 , order_billing_details[20]);
			ordersetBills_dtls.put("fpp_yn"		 , fpp_yn_set);//10503
			ordersetBills_dtls.put("fpp_category"		 , fpp_category_set);//10503
			//servicepanel=bean.checkForNull(billing_details[10],"");
			//servicepanelcode=bean.checkForNull(billing_details[11],"");
			orderEntryBillBean.setOrderBillDtls(bill_orderId+OrderSetValues[1],ordersetBills_dtls); 
			 if(!order_billing_details[9].equals(""))
			{
				numbering=1;
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_billing_details[9]));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
			}
			if(order_billing_details[10].equals("")||order_billing_details[11].equals(""))
			{
						numbering=1;
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
 
				}
			}
			if(numbering==1&& order_set_bill_yn.equalsIgnoreCase("Y"))
			{	
			
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			bill_set_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bill_orderId+OrderSetValues[1]);
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);

							if("Y".equals(fpp_yn_set))
							{	
							
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fpp_yn_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf("S".equals(fpp_category_set)?"selected":""));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf("M".equals(fpp_category_set)?"selected":""));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf("C".equals(fpp_category_set)?"selected":""));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

						if(bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block48Bytes, _wl_block48);

						if(bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_set_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_set_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block53Bytes, _wl_block53);

						}
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_set_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull(bill_orderId,"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_order_line_num,"")));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bill_dateString));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.checkForNull(bill_orderId,"")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean.checkForNull((String)bill_order_line_num,"")));
            _bw.write(_wl_block63Bytes, _wl_block63);

	}

	// Amend/Review Order Painting Here
	if(AmendPlaceOrderItems!=null)
	{
		for(amend_count=0; amend_count<AmendPlaceOrderItems.size(); amend_count++)
		{	
			//String comment 			 =  "";
			//String pat_preps_pat_instrns="";
			//String pat_preps_dep_instrns="";
			//String pat_preps_instrns="";  
			amendRecords			= (String[])AmendPlaceOrderItems.get(amend_count);
			
			classValue="gridData";
			chk_class_value="gridData";
			String amend_speciality_code[]=new String[3];
			ArrayList amend_speciality=new ArrayList();
			amend_speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),amendRecords[2],bean.getEncounterId(),bean.getLoginFacilityId(),amendRecords[4],specialty_code,auth_reqd);
			if(amend_speciality.size()>0)
			{
				for(int as=0;as<amend_speciality.size();as++)
				{
						amend_speciality_code=(String[])amend_speciality.get(as);
				}
			}
			if(amend_speciality_code[0].equalsIgnoreCase("Y"))
			{
				if(amendRecords[7].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")||amend_speciality_code[0].equalsIgnoreCase("Y"))
					amendRecords[7]="Y";
			}
			else
			{
				if(amendRecords[7].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y"))
					amendRecords[7]="Y";
			}
			
			if(fStatus[1].equalsIgnoreCase("Y"))
			amendRecords[9]=fStatus[1];

			if(amendRecords[22].equalsIgnoreCase("Y")) // consent_reqd_yn
				chk_class_value = "eORConsent" ;

			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			Default = bean.getPlaceOrderDefault(amendRecords[2]);
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
			}		
			// Till Here
			amend_start_disabled		= "";
			amend_appt_reqd_yn			= amendRecords[48];	amend_routine_appt_reqd_yn	= amendRecords[56];
			amend_stat_appt_reqd_yn		= amendRecords[57];	amend_urgent_appt_reqd_yn	= amendRecords[58];
			if(amend_appt_reqd_yn.equals("Y")) 
			{	// If appt_reqd_yn is "Y"
				if(!amendRecords[54].equals("") && !amendRecords[55].equals("")) 
				{ // if already appt has been booked, 
					amend_start_disabled	= "DISABLED";
					amend_appt_reqd_yn		= "N"; amend_routine_appt_reqd_yn="N";
					amend_stat_appt_reqd_yn	= "N"; amend_urgent_appt_reqd_yn ="N";
 				} else 
				{
					amend_start_disabled = "";
				}
			}
			ammend_start_date_time = amendRecords[10];

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(chk_class_value));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[4]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[3]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bean.getTempvalue("amend_start_date_time"+amendRecords[2])==null?com.ehis.util.DateUtils.convertDate
					(amendRecords[10],"DMYHM","en",localeName):bean.getTempvalue("amend_start_date_time"+amendRecords[2])));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(amend_start_disabled));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_category.equals("RD")?(amend_appt_reqd_yn.equalsIgnoreCase("Y")?"readonly":""):"" ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amend_appt_reqd_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(amend_start_disabled));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( order_category.equals("RD")?(amend_appt_reqd_yn.equalsIgnoreCase("Y")?"disabled":""):"" ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(amendRecords[10],"DMYHM","en",localeName)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(amendRecords[24]));
            _bw.write(_wl_block1Bytes, _wl_block1);

				if(!bean.checkForNull(amendRecords[64],"").equals("")) {
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		

            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[24]));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[26]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[3]));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
 if(amendRecords[6].equalsIgnoreCase("R")) out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+""); else if(amendRecords[6].equalsIgnoreCase("U")) out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+""); else out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+""); 
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[6]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("amend_quantity"+amendRecords[2])==null?amendRecords[18]:bean.getTempvalue("amend_quantity"+amendRecords[2])));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
if(amendRecords[34].equalsIgnoreCase("N")) out.println("READONLY");
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(amendRecords[73]));
            _bw.write(_wl_block112Bytes, _wl_block112);
	//IN046975 - Added to set the quantity value to the tempvalue for the correct charge calculation while navigating between place order n additional search tab
				if(!amendRecords[18].equals(bean.getTempvalue("amend_quantity"+amendRecords[2])) && bean.getTempvalue("amend_quantity"+amendRecords[2]) != null)
					amendRecords[18] = bean.getTempvalue("amend_quantity"+amendRecords[2]);
				//IN046975	
				
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block114Bytes, _wl_block114);

				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf( order_category.equals("RD")?"disabled":"" ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bean.getTempvalue("amend_frequency_code"+amendRecords[2])==null?"":bean.getTempvalue("amend_frequency_code"+amendRecords[2]).equals("")?"selected":""));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

						AmendPlaceOrderFrequency = bean.getPlaceOrderFrequency(amendRecords[2],"","","","",""); // Pass Order_category and Catalog_code

					if(bean.getTempvalue("amend_frequency_code"+amendRecords[2])!=null)
						for(int j=0; j<AmendPlaceOrderFrequency.size(); j++)
						{
							
							AmendfrequencyRecords = (String[]) AmendPlaceOrderFrequency.get(j);
							if(amendRecords[13].equalsIgnoreCase(AmendfrequencyRecords[2])  ||  bean.getTempvalue("amend_frequency_code"+amendRecords[2]).equals(AmendfrequencyRecords[0]))
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\" SELECTED> "+AmendfrequencyRecords[1]+" </option>");
							else
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\"> "+AmendfrequencyRecords[1]+" </option>");
						}
						else
							for(int j=0; j<AmendPlaceOrderFrequency.size(); j++)
						{
							
							AmendfrequencyRecords = (String[]) AmendPlaceOrderFrequency.get(j);
							if(amendRecords[13].equalsIgnoreCase(AmendfrequencyRecords[2]))
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\" SELECTED> "+AmendfrequencyRecords[1]+" </option>");
							else
								out.println("<option value=\""+AmendfrequencyRecords[0]+"\"> "+AmendfrequencyRecords[1]+" </option>");
						}
					
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[13]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[13]));
            _bw.write(_wl_block126Bytes, _wl_block126);

					if(AmendSchedule!=null && AmendSchedule.size() > 0)
					{
					
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block131Bytes, _wl_block131);

					}
					else
					{
						
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block133Bytes, _wl_block133);

					}
				}
				else
				{
				
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block139Bytes, _wl_block139);

				}
				
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("amend_duration_value"+amendRecords[2])==null?amendRecords[14]:bean.getTempvalue("amend_duration_value"+amendRecords[2])));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf( order_category.equals("RD")?"readonly":"" ));
            _bw.write(_wl_block144Bytes, _wl_block144);
if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[17]));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

						/*AmendPlaceOrderDuration = bean.getPlaceOrderDuration();
						for(int j=0; j<AmendPlaceOrderDuration.size(); j++)
						{
							amendDurationRecords = (String[]) AmendPlaceOrderDuration.get(j);
							if(amendRecords[15].equalsIgnoreCase(amendDurationRecords[0]))
								out.println("<option value=\""+amendDurationRecords[0]+"\" SELECTED> "+amendDurationRecords[1]+" </option>");
							else
								out.println("<option value=\""+amendDurationRecords[0]+"\"> "+amendDurationRecords[1]+" </option>");
						}*/
					
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[15]));
            _bw.write(_wl_block154Bytes, _wl_block154);

		amend_format_count = bean.getFormatAmendCount(bean.getOrderId(),amendRecords[1]);
		//if(amend_format_count==0)//Commented for IN043099
		//{//Commented for IN043099
			format_id = bean.checkForNull(amendRecords[29],"");
			if(!amendRecords[29].trim().equals(""))
			{
     			stFormatID 	= new StringTokenizer(amendRecords[29],"~");
     			while(stFormatID.hasMoreTokens())
     			{
     				format_id_mandatory_yn  = stFormatID.nextToken();
     				format_id 				= stFormatID.nextToken();
     			}
				stFormatID	= null; //Nullifying the objects
 			}
 		//}//Commented for IN043099
		//IN066436 starts
		String format_id_line = bean.checkForNull(amendRecords[29],"");
		if(!amendRecords[29].trim().equals(""))
		{
			stFormatID 	= new StringTokenizer(amendRecords[29],"~");
			while(stFormatID.hasMoreTokens())
			{
				format_id_mandatory_yn  = stFormatID.nextToken();
				format_id_line			= stFormatID.nextToken();
			}
			stFormatID	= null; //Nullifying the objects
		}
		//IN066436 ends

            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(format_id_line));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block162Bytes, _wl_block162);
    //  This added For MultipleConsent
	          if(amendRecords[22].equalsIgnoreCase("Y"))
			 {
			 
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(URLEncoder.encode(amendRecords[24],"UTF-8")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[1]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[24]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[1]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
	
	 			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
			 	ArrayList amendMultiConsentList = new ArrayList();
				String[] amendMultiConsentValues = null;
				String[] amendMultiConsentDtls = null;
				String consent_req_bef_order = "0"; 
				String consent_req_bef_regn = "0";
				String amendMultiConsentLine[] = new String[4];
				amendMultiConsentLine=bean1.MultiListConsentsLine(bean.checkForNull(bean.getOrderId(),""),amendRecords[1]);
				consent_req_bef_order = (String) amendMultiConsentLine[2];
				consent_req_bef_regn = (String)amendMultiConsentLine[3];
				amendMultiConsentDtls		= bean1.MultiListDtls(amendRecords[2],practitioner_id);
				amendMultiConsentList		= bean1.MultiListConsentsdtl(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1], practitioner_id);
				if(amendMultiConsentList==null || amendMultiConsentList.size()==0)
				{
					amendMultiConsentList		= bean1.MultiListConsents(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1],practitioner_id);
				}
				int amend_total_recs = 0;				
				if(amendMultiConsentDtls != null)
				{	
					if(amendMultiConsentList.size() > 0 && amendMultiConsentDtls.length > 0 && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn)) > 1 ) ))
					{		
						for(int m=0;m<amendMultiConsentList.size();m++)
						{
							amendMultiConsentValues = (String[])amendMultiConsentList.get(m);
							if(amendMultiConsentValues[6].equals("F"))
							{
								
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(amend_count));
            out.print( String.valueOf(m));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(amend_count));
            out.print( String.valueOf(m));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(amendMultiConsentValues[1]));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(amend_count));
            out.print( String.valueOf(m));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(amendMultiConsentValues[3]));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(amend_count));
            out.print( String.valueOf(m));
            _bw.write(_wl_block174Bytes, _wl_block174);

							}
							amend_total_recs++;
						}						
						
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendMultiConsentValues[6]));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_total_recs));
            _bw.write(_wl_block102Bytes, _wl_block102);

					}
					else
					{
						if(amendMultiConsentList.size()==1)
						{
							amendMultiConsentValues = (String[])amendMultiConsentList.get(0);
							if(amendMultiConsentValues[6].equals("F"))
							{
								if(!(bean.checkForNull(amendMultiConsentValues[1])).equals(""))
								{
									amend_total_recs = amend_total_recs++;
								}
							//if(amendMultiConsentDtls[0].equals("F"))
							//{
							
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(amendMultiConsentDtls[4].equals("Release")?"A":(amendMultiConsentDtls[4].equals("Registration")?"R":"")));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(amendMultiConsentDtls[3]));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(amendMultiConsentValues[1]));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block185Bytes, _wl_block185);

						}
					}
						
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendMultiConsentDtls[0]));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_total_recs));
            _bw.write(_wl_block188Bytes, _wl_block188);

					//}
				}
			}
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/    
   /*upto here	MultipleConsent	*/	
				
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_total_recs));
            _bw.write(_wl_block191Bytes, _wl_block191);

			}
			 secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, amendRecords[2], bean.getPatientClass()); //Pass the catalog_code and patient_class
			// secondayOrders will have to 2 values , count and the sec_order_catalog_type
			if (bean.checkForNull((String)secondaryOrders[0]).equals("Y"))
			{
				sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, amendRecords[2],amendRecords[6],bean.getPatientClass()),"");
				sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);	
			
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(sec_start_date_time));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block196Bytes, _wl_block196);

			}
			
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(secondaryOrders[1]));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block202Bytes, _wl_block202);

				// If Schedule Frequency is there, retrieve the values and store it in the bean
				bean.setAmendScheduleFrequency(amendRecords[0],amendRecords[1],amendRecords[2],amend_count);
				AmendSchedule = bean.getScheduleFrequencyStr("AmendSchedule"+amendRecords[2],String.valueOf(amend_count));
				if(AmendSchedule!=null && AmendSchedule.size() > 0)
				{
				
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);

				}
				
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block208Bytes, _wl_block208);
		
//if( (order_category.equals("LB") && lb_instal_yn.equals("Y")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC")) )	changed on 7/9/2007 for lb_instal_yn by uma 
						if((order_category.equals("LB")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC") || (order_category.equals("OT")) )) { 
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);
 
							if(login_facility_id.equalsIgnoreCase(amendRecords[27]))
								facility_name =PerformingFacilityName;
							else
								facility_name =bean.getPerformingFacilityName(amendRecords[27]);
						
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf( order_category.equals("RD")?"disabled":"" ));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(bean.getTempvalue("amend_perform_loc_code"+amendRecords[2])==null?"":bean.getTempvalue("amend_perform_loc_code"+amendRecords[2]).equals("")?"selected":""));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

						//DeptLocationCode = bean.getPerformingDeptLocation(amendRecords[27], amendRecords[30],order_category,lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma
						DeptLocationCode = bean.getPerformingDeptLocation(amendRecords[27], amendRecords[2],order_category,amendRecords[3],rd_instal_yn);
						if(bean.getTempvalue("amend_perform_loc_code"+amendRecords[2])==null)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if(amendRecords[31].equalsIgnoreCase(deptLocation[0]) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) )
								if(amendRecords[31].equalsIgnoreCase(deptLocation[0])) //IN047739
								{
									out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
								}
							}
						}
						else
						{	
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								if( (order_category.equals("RD") && rd_instal_yn.equals("Y"))  || bean.getTempvalue("amend_perform_loc_code"+amendRecords[2]).equals(deptLocation[0]))
								{
									out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
								}
							}
						}
			
            _bw.write(_wl_block218Bytes, _wl_block218);
 } 
            _bw.write(_wl_block219Bytes, _wl_block219);

					//for RADIOLOGY
					if(("RD".equals(order_category)) && ("Y".equals(rd_instal_yn))){ 
						if("Y".equals(perfLocnMandFlag)){
            _bw.write(_wl_block220Bytes, _wl_block220);
}
					}
					//EXCEPT RADIOLOGY
					if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && !(amendRecords[3]).equals(bt_order_type_code)){
            _bw.write(_wl_block221Bytes, _wl_block221);
}
					
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[31]));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[27]));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[16]));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[76]));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[77]));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block233Bytes, _wl_block233);
				
				//IN065324, starts
				boolean show_bill_dtls = false;

				if("Y".equals(amendRecords[33].trim()))
				{
					if(is_bt_view_bill_dtls && "BT".equals(amendRecords[59].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(amendRecords[59].trim()))
					{
						show_bill_dtls = true;
					}
					else
					{
						show_bill_dtls = false;
					}
				}
				//IN065324, ends
				String category_fpp_amend =  bean.getTempvalue("fpp_category"+amendRecords[2])==null?amendRecords[81]:bean.getTempvalue("fpp_category"+amendRecords[2]);//IN068314
				//if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && 					!amendRecords[59].equals("BT"))// && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")) )//IN065324
				if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && show_bill_dtls)// && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")) )//IN065324
				{
					amend_billing_call_yn		= "Y";
					//IN068314 Starts
					//BillChargeInfo		= bean_qryobj.getBillChargeDetails(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					if("Y".equals(amendRecords[80])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),amendRecords[80],category_fpp_amend) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(amendRecords[18],amendRecords[2],amendRecords[10], localeName, amendRecords[0],amendRecords[1],bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN068314 Ends
					
					if(BillChargeInfo!=null)
					{						
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
						{
							billing_details 	= (String[])BillChargeInfo.get(k);
							setBills_dtls		= new HashMap();
		
							setBills_dtls.put("charged_yn"       , billing_details[1]);
							setBills_dtls.put("total_payable"    , billing_details[2]);
							setBills_dtls.put("patient_payable"  , billing_details[3]);
							setBills_dtls.put("quantity"         , qty_value);
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("incl_excl_action" , billing_details[4]);
							setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , amendRecords[80]);
							setBills_dtls.put("fpp_category"		 , amendRecords[81]);
							orderEntryBillBean.setOrderBillDtls(amendRecords[0]+amendRecords[1], setBills_dtls); 
							 if(!billing_details[9].equals(""))
							{
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block235Bytes, _wl_block235);
 
						  	} 
							if(billing_details[10].equals("")&&billing_details[11].equals(""))
							{
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block237Bytes, _wl_block237);
 
							} 
						}
					}
			
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(amendRecords[0]+amendRecords[1]);
				
            _bw.write(_wl_block238Bytes, _wl_block238);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block239Bytes, _wl_block239);
}else{
            _bw.write(_wl_block240Bytes, _wl_block240);
}
            _bw.write(_wl_block241Bytes, _wl_block241);

							if("Y".equals(amendRecords[80]))
							{	
								
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(amendRecords[80]));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf("S".equals(category_fpp_amend)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf("M".equals(category_fpp_amend)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf("C".equals(category_fpp_amend)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
}else{ 
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block251Bytes, _wl_block251);
} 
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

							}
							
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(bean.getTempvalue("amend_bill_now_"+amendRecords[2])==null?"hidden":bean.getTempvalue("amend_bill_now_"+amendRecords[2]).equals("visible")?"visible":"hidden"));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(bean.getTempvalue("amend_bill_now_check"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("amend_bill_now_check"+amendRecords[2])));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block265Bytes, _wl_block265);
//out.println("519"+bean.getTempvalue("bill_now_check"+amendRecords[2]+"chk"));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(bean.getTempvalue("amend_bill_now_check"+amendRecords[2]+"chk")==null?"":bean.getTempvalue("amend_bill_now_check"+amendRecords[2]+"chk").equals("Checked")?"checked":""));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block270Bytes, _wl_block270);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block270Bytes, _wl_block270);

							}
							
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("amend_bill_now"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""): bean.getTempvalue("amend_bill_now"+amendRecords[2])));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("amend_bill_now_check_Df"+amendRecords[2])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("amend_bill_now_check_Df"+amendRecords[2])));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[18]));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[2]));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[2]));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[19]));
            _bw.write(_wl_block287Bytes, _wl_block287);
				}else{
					amend_billing_call_yn		= "N";
					out.println("&nbsp;");
				}
			
			
				//IN072654 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
					    boolean amendOverremarks = bean.chkDrugInteractionForLBAmend(amendRecords[2],bean.checkForNull(bean.getOrderId(),""),amendRecords[1]);
					    if(!amendOverremarks)
						bean.chkDrugInteractionForLB(amendRecords[2],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
					
						interactionYN=bean.getDruginteractionYN();
						interdrugDtls = bean.getDruginteractionDtl(); 
						if(null!=interdrugDtls)
							drugintercnt =	interdrugDtls.size();
						
						checkUncheck =	interactionYN.get(amendRecords[2]);
				
					if("R".equals(checkUncheck)){
					
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block289Bytes, _wl_block289);
}
				}//IN072654 Ends
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block214Bytes, _wl_block214);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block292Bytes, _wl_block292);
}else{
            _bw.write(_wl_block240Bytes, _wl_block240);
}
            _bw.write(_wl_block293Bytes, _wl_block293);
  	           
			//if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && !amendRecords[59].equals("BT") && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )//IN065324
			if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && show_bill_dtls && (amendRecords[19].equals("DO") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )//IN065324
		//	if ( billing_interface_yn.equals("Y") && amendRecords[33].equals("Y") && !amendRecords[59].equals("BT") && (amendRecords[19].equals("DO") && show_bill_info_yn.equals("Y") || amendRecords[19].equals("CO")||amendRecords[19].equals("CR")) )// condition added for IN035929  - commented for IN039607
			{ 
					amend_billing_call_yn		= "Y";

            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(i));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[1]));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);
				}else{
				//10503 Starts	
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block298Bytes, _wl_block298);
//10503 Ends
					amend_billing_call_yn		= "N";}
				

            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block300Bytes, _wl_block300);

			comments			= bean.getAmendComments(amendRecords[0],amendRecords[1]);//IN68475
			preps_instrn			= bean.getAmendPreps(amendRecords[0],amendRecords[1]);
			preps_dept_instrn		= bean.getAmendDepts(amendRecords[0],amendRecords[1]); // amend_Order_id & amend_order_line_num 
			pat_preps_instrn 		= bean.checkForNull(bean.getAmendPatientInstrn(amendRecords[0],amendRecords[1]),"");  // For Patient Preps. Insructions
			//IN68475 starts		
			ArrayList arrSeqNo2		= new ArrayList();
			arrSeqNo2.add(0, comments);	//Comments
			arrSeqNo2.add(1, preps_instrn);	//Preps
			arrSeqNo2.add(2, preps_dept_instrn);	//Dept
			arrSeqNo2.add(3, pat_preps_instrn); //Patient
			orderEntryRecordBean.setOrderFormats("Comments"+amendRecords[2], amendRecords[2], arrSeqNo2);
			//IN68475 ends

            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(preps_instrn));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(pat_preps_instrn));
            _bw.write(_wl_block305Bytes, _wl_block305);
			 
                if(bean.checkForNull(amendRecords[4],"").equalsIgnoreCase("LB")) // If it is an Lab then only
                {
                	AmendSpecimenNurse = bean.getSpecimenNurseValue(amendRecords[0]);
					for(int j=0; j<AmendSpecimenNurse.size(); j++)
					{
						String[] record 		= (String[])AmendSpecimenNurse.get(j);
					    amend_specimen_type		= record[0];
                	    amend_nurse_collect_yn  = record[1];
					}
					AmendSpecimenNurse			 = null;
                }
                else
                {	amend_specimen_type 		= "";
                	amend_nurse_collect_yn		= "N";
                }

				//Added by Uma on 5/3/2011 
				order_types_comb	= "'"+bean.checkForNull(bean.getAmendOrderType(),"")+"'";
				OrderFormatTypes		= bean.getOrderTypeFormatID(order_category,order_types_comb);

  				if(OrderFormatTypes!=null && OrderFormatTypes.size() != 0 )
				{
					orderEntryRecordBean.setOrderFormats("ORDER_TYPE"+order_category, "0",OrderFormatTypes);
				}

				String header_format_id	= "";//IN066436
				for(count=0;count<OrderFormatTypes.size();count++)
				{
					header_format_id = "";//IN066436
					ind_catalog_code			= "";					
					order_type_records		= (String[])OrderFormatTypes.get(count);
					//format_id				= order_type_records[0];//commented for IN066436
					header_format_id				= order_type_records[0];//Added for IN066436
					order_type_code			= order_type_records[1];
					
					if(order_type_code!=null && order_type_code.equals("ALL"))
						order_type_code		= "";
						//order_type_short_desc	= order_type_records[2];
					
					ind_catalog_code	= order_type_code+amendRecords[59]; // For other Header Orders
					ind_row_value				= (ind_catalog_code+"_"+row_value);
				
					arrSeqNo1					= (ArrayList)	orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);	

					ArrayList OrderFormat=new ArrayList();	

					if(arrSeqNo1==null || arrSeqNo1.size()==0) // If it is already there in the bean
					{

						arrSeqNo1			=	new ArrayList();
						//OrderFormat 	= bean.getOrderFormat(format_id,order_category,bean.checkForNull(bean.getOrderId(),""),"HEADER",bean.checkForNull(amendRecords[1],""),bean.checkForNull(amendRecords[6],""),bean.checkForNull(bean.getSex(),""),bean.checkForNull(bean.getDob(),""),login_facility_id,bean.checkForNull(amendRecords[2],""),order_type_code,bean.checkForNull(bean.getPatientId(),""));//Commented for IN066436
						OrderFormat 	= bean.getOrderFormat(header_format_id,order_category,bean.checkForNull(bean.getOrderId(),""),"HEADER",bean.checkForNull(amendRecords[1],""),bean.checkForNull(amendRecords[6],""),bean.checkForNull(bean.getSex(),""),bean.checkForNull(bean.getDob(),""),login_facility_id,bean.checkForNull(amendRecords[2],""),order_type_code,bean.checkForNull(bean.getPatientId(),""));//Modified for IN066436
					

						for(int k=0; k<OrderFormat.size(); k++)
						{
							records			= (String[])OrderFormat.get(k);
							seq_num 		= (Integer.parseInt(bean.checkForNull(records[1],"0"))); // seq_num will start with 0

							if(old_seq_num!=0 && seq_num==old_seq_num ) 
							{	//used for Amend Orders
								new_seq_num--;		// reduce the new_seq_num
								arrSeqNo1.remove( String.valueOf(new_seq_num));		//remove the arraylist
								field_mnemonic	 = old_field_mnemonic;
							}
							else 
								field_mnemonic	 = bean.checkForNull(records[0],"0");

							//template		= beanQueryObj.buildHashTable(properties, new_seq_num, bean.getPatientId(), bean.checkForNull(bean.getOrderId(),""), format_id, order_type_code, "" , field_mnemonic,  records);//commented for IN066436
							template		= beanQueryObj.buildHashTable(properties, new_seq_num, bean.getPatientId(), bean.checkForNull(bean.getOrderId(),""), header_format_id, order_type_code, "" , field_mnemonic,  records);//Modified for IN066436
							//amend_order_id will be the order_id and order_type_short_desc will be null
							field_type	= (String) template.get("field_type");
							field_values	= (String) template.get("field_values");
							dflt_value	= (String) template.get("dflt_value");
							
							if(field_type.equalsIgnoreCase("D"))
							{
								if(field_values!=null)
								{
									if(!(field_values.equals("")))
									{
										field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMY","en",localeName);	
									}
								}
								if(!(dflt_value.equals("")))
								{
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMY","en",localeName);	
								}
								
							}
							if(field_type.equalsIgnoreCase("E"))
							{
								if(field_values!=null)
								{
									if(!(field_values.equals("")))
									{
										field_values = com.ehis.util.DateUtils.convertDate(field_values,"DMYHM","en",localeName);	
									}
								}
								if(!(dflt_value.equals("")))
								{
									dflt_value = com.ehis.util.DateUtils.convertDate(dflt_value,"DMYHM","en",localeName);	
								}
								
							}
							template.put("field_values"	,field_values);
							template.put("dflt_value"	,dflt_value);
							orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
							arrSeqNo1.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
							new_seq_num++;
							exists = true;
						}
						OrderFormat = null; // nullifying the object after use			
					}
				}
			
				if(exists)
		    	{				    		
					//orderEntryRecordBean.setOrderFormats(ind_catalog_code,ind_row_value,arrSeqNo1);//Commented for IN043099
				}
				ind_catalog_code			= "";
				//Added by Uma on 5/3/2011 			
				

            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(preps_dept_instrn));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(bean.getOrderId(),"")));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[1]));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[4]));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[8]));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[7]));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[9]));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[18]));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[22]));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_specimen_type));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_nurse_collect_yn));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[28]));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[59]));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[30]));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[32]));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_billing_call_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[35]));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[36]));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[37]));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[38]));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[39]));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[40]));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[41]));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[42]));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[43]));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[44]));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[45]));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[46]));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[47]));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_appt_reqd_yn));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_routine_appt_reqd_yn));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_stat_appt_reqd_yn));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_urgent_appt_reqd_yn));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[49]));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[50]));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[51]));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[52]));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[53]));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[60]));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[61]));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[62]));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[63]));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[66]));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[67]));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[68]));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[71]));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[69]));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(amendRecords[70],"N")));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[75]));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amendRecords[78]));
            _bw.write(_wl_block410Bytes, _wl_block410);

				if(amend_speciality_code[0].equalsIgnoreCase("Y"))
				{
				
				
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_speciality_code[1]));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(amend_speciality_code[2]));
            _bw.write(_wl_block415Bytes, _wl_block415);

				}
				else
				{
				
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(amendRecords[72],"N")));
            _bw.write(_wl_block417Bytes, _wl_block417);

				}	
			   
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(amendRecords[64],"")));
            _bw.write(_wl_block420Bytes, _wl_block420);
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(amendRecords[65],"")));
            _bw.write(_wl_block420Bytes, _wl_block420);
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean.checkForNull(amendRecords[79],"T")));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(amendRecords[2]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block430Bytes, _wl_block430);

				String EnableEmail="N";
				
				/*arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+amendRecords[2],amendRecords[2]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); //preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
			  			pat_preps_instrns     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
				 }*/
				if(bean.checkForNull(amendRecords[16],"").equals("")&&preps_instrn.equals("")&&pat_preps_instrn.equals("")&&preps_dept_instrn.equals(""))
				{
					String sex_yn="";
					int age_in_days=0;
					String pat_pat_preps_instrns="";
					
					if(bean.checkForNull(amendRecords[28],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						if(null!=records && null!=records[0])//IN040531
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(amendRecords[2],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(amendRecords[2]);  // For Patient Preps. Insructions.				
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(prepins),"");  // For Patient Preps. Insructions.
					}
					if((!pat_pat_preps_instrns.equals("")&&pat_pat_preps_instrns.length()>0))
					{
						EnableEmail="Y";
					}
				}
				else
				{
					EnableEmail="Y";
				}
					
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(EnableEmail));
            _bw.write(_wl_block102Bytes, _wl_block102);

											
			}  // End for Amend

			dateString=	ammend_start_date_time;
			
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(charge_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
} // End of if amend
	// New Orders, Painting
	String discharge_date_time = bean.getDischargeDateTime(bean.getPatientId(),bean.getEncounterId() );//IN050607
	bean.setDischargeDate(discharge_date_time);//IN050607
	String ordering_rule_yn = bean.getOrderingRuleYn(order_category);//IN050607

	if(PlaceOrderItems!=null)
	{
		for(i=0; i<PlaceOrderItems.size(); i++)
		{
			billinginterface="";
			String servicepanel="";
			String servicepanelcode="";
			String finbill="";
			displaytooltip="";
			String locn_appt_reqd_yn="";
			String speciality_code[]=new String[3];
			ArrayList speciality=new ArrayList();
			String comment 			  = "";
			String pat_preps_instrns ="";
			String pat_preps_pat_instrns="";
			String pat_preps_dep_instrns="";

			numbering=0;
			records =(String[])PlaceOrderItems.get(i); // String array
			comments = ""; pat_preps_instrn	=""; preps_instrn = "";  preps_dept_instrn = "";

			/*if ( i% 2 == 0 )
			{
				classValue 			= "QRYEVEN" ;
				chk_class_value		= "QRYEVEN" ;
			}
			else
			{
				classValue		 	= "QRYODD" ;
				chk_class_value		= "QRYODD" ;
			}*/
			classValue="gridData";
			chk_class_value="gridData";
			if(records[51].equalsIgnoreCase("Y"))
				chk_class_value = "eORConsent" ;
			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			if(function_from.equals("COPY_ORDER"))
			{
				copyOrderDetails	 = bean.getCopyOrderIDDetails(); // Get the Order Id and order_line
				if(copyOrderDetails!=null){
					order_id		 = bean.checkForNull((String)copyOrderDetails.get("order_id"+records[0]),""); // Get the order_id from the HashMap passing the catalog_code
					order_line_no	 = bean.checkForNull((String)copyOrderDetails.get("order_line_no"+records[0]),""); // Get the order_line_no from the HashMap passing the catalog_code
				}
				// Get the Default values
				/*Added by Uma on 4/1/2010 for IN020457*/
				if((order_id.equals("")&&order_line_no.equals("")))
				{
					Default = bean.getPlaceOrderDefault(records[0]);
				}
				else
				{
					Default	= bean.getCopyPlaceOrderDefault(order_id, order_line_no);
				}
				/*Ends Here by Uma on 4/1/2010 for IN020457*/
				// Get the Preps, Patient Instruction and Dept Instruction
				if(!(order_id.equals("") && order_line_no.equals("")))
				{
					pat_preps_instrn 		= bean.checkForNull(bean.getAmendPatientInstrn(order_id,order_line_no),"");  // For Patient Preps. Insructions
					preps_instrn			= bean.checkForNull(bean.getAmendPreps(order_id,order_line_no),"");
					preps_dept_instrn		= bean.checkForNull(bean.getAmendDepts(order_id,order_line_no),"");
				}
			}
			else // For other Orders
			{
				Default = bean.getPlaceOrderDefault(records[0]);
			}
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
 				if(recordDefault!=null){
					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
					if(qty_value.equals("0")) qty_value = "1";
						qty_uom			 =  bean.checkForNull(recordDefault[9],"");
						qty_uom_shortdesc=  bean.checkForNull(recordDefault[10],"");
				}else{
					qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
				}
			}
			// Till Here
			String temp_Start_Date = (bean.getTempvalue("start_date_time"+records[0]))==null?"":(bean.getTempvalue("start_date_time"+records[0]));   //Added for IN029076

            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(chk_class_value));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[4]));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(i));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(i));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(temp_Start_Date==""?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName):temp_Start_Date));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(i));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(i));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(i));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf((bean.getTempvalue("start_date_time"+records[0]))==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName):bean.getTempvalue("start_date_time"+records[0])));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(i));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(i));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(i));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(i));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(i));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block459Bytes, _wl_block459);

				if(!bean.checkForNull(records[62],"").equals("")) 
				{
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}		
			
			   speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
			  
				if(speciality.size()>0)
				{
					for(int sc=0;sc<speciality.size();sc++)
					{
							speciality_code=(String[])speciality.get(sc);
					}
				}
				if(speciality_code[0].equalsIgnoreCase("Y"))
				{
				
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						
	
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(i));
            _bw.write(_wl_block461Bytes, _wl_block461);
			   }        
				}
				else
				{
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y"))
					{
						display_auth_count++;
						records[48]="Y";
	
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(i));
            _bw.write(_wl_block461Bytes, _wl_block461);
		
					}
				}
				
				if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y")) // For Cosign Required
				{
						display_cosign_count++;
						records[49]="Y";
	
            _bw.write(_wl_block463Bytes, _wl_block463);
			}
				if(records[50].equalsIgnoreCase("Y")) // For Special Approval
				{
				    display_special_count++;

            _bw.write(_wl_block464Bytes, _wl_block464);
				} 
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(i));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(i));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(i));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(i));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(i));
            _bw.write(_wl_block472Bytes, _wl_block472);
/*					out.println( bean.getPlaceOrderType(records[0], ((String)previousValues.get("h2"+records[0])) ) );*/

            _bw.write(_wl_block473Bytes, _wl_block473);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block474Bytes, _wl_block474);
					PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(((String)previousValues.get("h2"+records[0])).equals(orderTypeRecords[0]))
							out.println("<option value=\""+orderTypeRecords[0]+"\" selected> "+orderTypeRecords[1]+" </option>");
						else
							out.println("<option value=\""+orderTypeRecords[0]+"\"> "+orderTypeRecords[1]+" </option>");
						 temptype=orderTypeRecords[0];
						orderTypeRecords = null;
					}
					PlaceOrderType = null; // Nullifying the Objects	

            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(i));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(i));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(i));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(i));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(i));
            _bw.write(_wl_block482Bytes, _wl_block482);
if(records[3].equals("OT")) out.println("DISABLED");
            _bw.write(_wl_block483Bytes, _wl_block483);
if ( !((records[52]).equals("3"))) {
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("R")?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
 }
					  if (((records[52]).equals("")) || ((records[52]).equals("2"))) {
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("U")?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
}
					if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(bean.getTempvalue("priority"+records[0])==null?"":bean.getTempvalue("priority"+records[0]).equals("S")?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
}
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(i));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0])));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block492Bytes, _wl_block492);
 if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); 
            _bw.write(_wl_block493Bytes, _wl_block493);

					if (qty_uom.equals("")) 
					{	
					//out.println(records[11]);modified by Ambiga.M on 1/19/2010 for 18146
						out.println(records[68]);
					}					
				    else
					{
						//out.println(qty_uom);
				        	out.println(qty_uom_shortdesc);
					}
					//IN046975 - Added to set the quantity value to the tempvalue for the correct charge calculation while navigating between place order n additional search tab
					if(!qty_value.equals(bean.getTempvalue("quantity"+records[0])) && bean.getTempvalue("quantity"+records[0]) != null)
						qty_value = bean.getTempvalue("quantity"+records[0]);
					//IN046975		
				
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block114Bytes, _wl_block114);

				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(i));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(i));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(bean.getTempvalue("frequency_code"+records[0])==null?"":bean.getTempvalue("frequency_code"+records[0]).equals("")?"selected":""));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block500Bytes, _wl_block500);

							PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","",""); // Pass the order_category and catalog_code
							if(bean.getTempvalue("frequency_code"+records[0])!=null)
							for(int j=0; j<PlaceOrderFrequency.size(); j++)
							{
								frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
								
 								if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0])))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
								}
							}
							else
							for(int j=0; j<PlaceOrderFrequency.size(); j++)
							{
								frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
 								if(recordDefault!=null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2]))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
								}
							}
						
            _bw.write(_wl_block501Bytes, _wl_block501);
				
					if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
					}
					else
					{
					
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(i));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(i));
            _bw.write(_wl_block503Bytes, _wl_block503);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block504Bytes, _wl_block504);

					}
					
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(i));
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(frequency_val));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(i));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(i));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(i));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(i));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(i));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(i));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(i));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(i));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block516Bytes, _wl_block516);
 					if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
					if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
					if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
					if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";

            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(i));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("duration_value"+records[0])==null?duration_value:bean.getTempvalue("duration_value"+records[0])));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(prompt_msg));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block523Bytes, _wl_block523);
if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(i));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(i));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(i));
            _bw.write(_wl_block529Bytes, _wl_block529);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(i));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(i));
            _bw.write(_wl_block532Bytes, _wl_block532);

							
		format_id = bean.checkForNull(records[47],"");
		if(!records[47].trim().equals(""))
		{
     		stFormatID 	= new StringTokenizer(records[47],"~");
     		while(stFormatID.hasMoreTokens())
     		{
     			format_id_mandatory_yn  = stFormatID.nextToken();
     			format_id 				= stFormatID.nextToken();
     		}
			stFormatID = null;// Nullifying the objects
 		}

            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(i));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(i));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(i));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(i));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(i));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(format_id_mandatory_yn));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(i));
            _bw.write(_wl_block543Bytes, _wl_block543);

		  
		  if(records[51].equalsIgnoreCase("Y"))
		 {
		 
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(i));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(i));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(URLEncoder.encode(records[1],"UTF-8")));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(i));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block549Bytes, _wl_block549);
	
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
			 	ArrayList multiConsentList = new ArrayList();
				String[] multiConsentValues = null;
				String[] multiConsentDtls = null;
				boolean consentflag=false;
				multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
				multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
				if(multiConsentList==null || multiConsentList.size()==0)
				{
					multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
				}
				int total_recs = 0;				
				if(multiConsentDtls != null)
				{	
					int num_of_consent_req_bo=0;
					int num_of_consent_req_br=0;
					int num_consent_bo=0;
					int num_consent_br=0;
					if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) ))
					{		
						for(int m=0;m<multiConsentList.size();m++)
						{
							multiConsentValues = (String[])multiConsentList.get(m);
							num_of_consent_req_bo=Integer.parseInt(multiConsentValues[7]);
							num_of_consent_req_br=Integer.parseInt(multiConsentValues[8]);
							if(multiConsentValues[6].equals("F"))
							{
								if(multiConsentValues[3].equals("A"))
								{
									if(num_of_consent_req_bo!=num_consent_bo)
									{
										num_consent_bo++;
										consentflag = true;
									}
								}
								else if(multiConsentValues[3].equals("R"))
								{
									if(num_of_consent_req_br!=num_consent_br)
									{
										num_consent_br++;
										consentflag = true;
									}
								}
								if(consentflag)
								{
								
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block555Bytes, _wl_block555);

										total_recs++;
										consentflag = false;
								}
							}
						}						
					
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(i));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(i));
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block560Bytes, _wl_block560);

				}
				else
				{
					if(multiConsentDtls[0].equals("F"))
					{	
						if(!(bean.checkForNull(multiConsentDtls[3])).equals(""))
						{
							total_recs = total_recs++;
						}
					
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(i));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(i));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(i));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(i));
            _bw.write(_wl_block566Bytes, _wl_block566);

					}
					
            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(i));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(i));
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block102Bytes, _wl_block102);

				}
				
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(i));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block569Bytes, _wl_block569);

			}
			/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
		 }
	
			secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class
			// secondayOrders will have to 2 values , count and the sec_order_catalog_type
			if (bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
				  sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""); //pass the catalog_code, prioriy as R, and the patient_class
               sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);



            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(i));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(sec_start_date_time));
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(i));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block574Bytes, _wl_block574);
}
            _bw.write(_wl_block1Bytes, _wl_block1);

				if(!format_id.equals(""))  // check for the Format
				{
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean
  						format_mandatory_count++;
					}
					else
					{

            _bw.write(_wl_block575Bytes, _wl_block575);
		   			format_count++;
		 	   		} // else of format_id_mandatory_yn
		 	   	}

            _bw.write(_wl_block576Bytes, _wl_block576);
            out.print( String.valueOf(i));
            _bw.write(_wl_block577Bytes, _wl_block577);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(secondaryOrders[1]));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block578Bytes, _wl_block578);
            out.print( String.valueOf(i));
            _bw.write(_wl_block579Bytes, _wl_block579);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(i));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(i));
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(i));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(i));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block587Bytes, _wl_block587);
				
	//if((order_category.equals("LB") && lb_instal_yn.equals("Y")) || (order_category.equals("RD") && rd_instal_yn.equals("Y")) || (!order_category.equals("NC")) ) { changed on 7/9/2007 for lb_instal_yn by uma 
	if((order_category.equals("LB") )|| (order_category.equals("RD")) || (order_category.equals("RX"))||(order_category.equals("TR")) ) 
	{ 
		
		
            _bw.write(_wl_block588Bytes, _wl_block588);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(i));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(i));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(temptype));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(rd_instal_yn));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block593Bytes, _wl_block593);
					
				performingLocationCode = bean.getPerformingLocation(order_category,((String)previousValues.get("h2"+records[0])),records[0]);	
				if(bean.getTempvalue("performing_facility_id"+records[0])==null)
				{
					for(int j=0; j<performingLocationCode.size(); j++)
					{
						performingLocation	= (String[]) performingLocationCode.get(j);
						//if condition added to handle 1 facility which is not login facility //IN047469		
						if(j==0)
							fac_selected = performingLocation[0];
						/* IN035095 starts */
						//if(performingLocation[0].equals(records[5])) //let the last one be selected
						if(performingLocation[0].equals(login_facility_id))
						/* IN035095 ends */
						{
							out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
							fac_selected = performingLocation[0]; //IN044014 to get the selected fac
						}
						else
						{
							out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
						}
					}
				}
				else
				{
					for(int j=0; j<performingLocationCode.size(); j++)
					{
						performingLocation	= (String[]) performingLocationCode.get(j);	
						//if condition added to handle 1 facility which is not login facility //IN047469		
						if(j==0)
							fac_selected = performingLocation[0];	
						/* IN035095 starts */
						//if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
						if(performingLocation[0].equals(login_facility_id))
						/* IN035095 ends */
						{
							out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
							fac_selected = performingLocation[0]; //IN044014 to get the selected fac
						}
						else
						{
							out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
						}
					}
				}
				
            _bw.write(_wl_block594Bytes, _wl_block594);

				}
				else
				{
					
            _bw.write(_wl_block595Bytes, _wl_block595);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block596Bytes, _wl_block596);
		
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
						fac_selected = 	records[5];//IN049984
					
            _bw.write(_wl_block597Bytes, _wl_block597);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block598Bytes, _wl_block598);
            out.print( String.valueOf(i));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block114Bytes, _wl_block114);

				}
				if((order_category.equals("LB") )|| (order_category.equals("RD")) || (order_category.equals("RX"))||(order_category.equals("TR")) ||(order_category.equals("MI"))||(order_category.equals("PC")) || (order_category.equals("OT")))//IN31901 
				{ 		
				
            _bw.write(_wl_block599Bytes, _wl_block599);
            out.print( String.valueOf(i));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(i));
            _bw.write(_wl_block601Bytes, _wl_block601);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block602Bytes, _wl_block602);
            out.print( String.valueOf(i));
            _bw.write(_wl_block603Bytes, _wl_block603);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block604Bytes, _wl_block604);
            out.print( String.valueOf(bean.getTempvalue("performing_dept_loc_code"+records[0])==null?"":bean.getTempvalue("performing_dept_loc_code"+records[0]).equals("")?"selected":""));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block500Bytes, _wl_block500);
					
						//DeptLocationCode = bean.getPerformingDeptLocation(records[5],records[0],order_category,lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma 
						//DeptLocationCode = bean.getPerformingDeptLocation(records[5],records[0],order_category,temptype,rd_instal_yn);		
						DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],order_category,temptype,rd_instal_yn); //IN044014 pass the selected facility as location	
						if(bean.getTempvalue("performing_dept_loc_code"+records[0])==null)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if((order_category.equals("RD") && rd_instal_yn.equals("Y") && 
								
								if(deptLocation[2]!=null && deptLocation[2].equals("Y")) //let the last one be selected
								{
									out.println("<option value=\""+deptLocation[0]+"\" selected> "+deptLocation[1]+" </option>");
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								}
								else
								{
									out.println("<option value=\""+deptLocation[0]+"\" > "+deptLocation[1]+" </option>");
								}
							}
						}
						else
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								//if((order_category.equals("RD") && rd_instal_yn.equals("Y") && 
								if(deptLocation[2]!=null  && bean.getTempvalue("performing_dept_loc_code"+records[0]).equals(deptLocation[0])) //let the last one be selected
								{
									out.println("<option value=\""+deptLocation[0]+"\" selected> "+deptLocation[1]+" </option>");
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								
								}
								else 
								{
									out.println("<option value=\""+deptLocation[0]+"\" > "+deptLocation[1]+" </option>");
								}
							}
						}
					
            _bw.write(_wl_block501Bytes, _wl_block501);
			
					}
					else 
					{ 
					
            _bw.write(_wl_block605Bytes, _wl_block605);
            out.print( String.valueOf(i));
            _bw.write(_wl_block600Bytes, _wl_block600);
            out.print( String.valueOf(i));
            _bw.write(_wl_block606Bytes, _wl_block606);

					}
					
            _bw.write(_wl_block607Bytes, _wl_block607);

					//for RADIOLOGY
					if(("RD".equals(order_category)) && ("Y".equals(rd_instal_yn))){ 
						if("Y".equals(perfLocnMandFlag)){
            _bw.write(_wl_block220Bytes, _wl_block220);
}
					}
					//EXCEPT RADIOLOGY
					String cat_type_code = records[4];	
					if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag))  && !(cat_type_code.equals(bt_order_type_code))){
            _bw.write(_wl_block221Bytes, _wl_block221);
}	
            _bw.write(_wl_block608Bytes, _wl_block608);
            out.print( String.valueOf(i));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block609Bytes, _wl_block609);

				//IN065324, starts
				boolean show_bill_dtls = false;
				
				if("Y".equals(records[38].trim()))
				{
					if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(records[43].trim()))
					{
						show_bill_dtls = true;
					}
				}
				//IN065324, ends					
			String category =  bean.getTempvalue("fpp_category"+records[0])==null?records[75]:bean.getTempvalue("fpp_category"+records[0]);//IN068314
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN068314 Starts
					if("Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],category) ; //IN068314
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN068314 Ends
					if(BillChargeInfo!=null)
					{
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
						{
							billing_details 	= (String[])BillChargeInfo.get(k);
							setBills_dtls		= new HashMap();
		
							setBills_dtls.put("charged_yn"       , billing_details[1]);
							setBills_dtls.put("total_payable"    , billing_details[2]);
							setBills_dtls.put("patient_payable"  , billing_details[3]);
							setBills_dtls.put("quantity"         , qty_value);
							setBills_dtls.put("incl_excl_action" , billing_details[4]);
							setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("rate"		 ,"");
							setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);
							setBills_dtls.put("fpp_category"		 , records[75]);
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");

							orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							if(!billing_details[9].equals(""))
							{
								numbering=1;finbill="Billing";
								
            _bw.write(_wl_block610Bytes, _wl_block610);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block611Bytes, _wl_block611);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block612Bytes, _wl_block612);
            out.print( String.valueOf(i));
            _bw.write(_wl_block613Bytes, _wl_block613);
 displaytooltip=billing_details[9];
							} 
							if(billing_details[10].equals("")&&billing_details[11].equals(""))
							{
								numbering=1;							
							
            _bw.write(_wl_block614Bytes, _wl_block614);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block615Bytes, _wl_block615);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block616Bytes, _wl_block616);
            out.print( String.valueOf(i));
            _bw.write(_wl_block617Bytes, _wl_block617);
 		
								displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							}
							//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						}
					}
					/*if(numbering==1)
					{
						Set setValues			= null;
						Iterator iterator 		= null;
						if(previousValues!=null)		// Get the Previous Values from the Bean
						{
								setValues 			= previousValues.keySet();
								iterator 				= setValues.iterator();
								String chk_value="";
								//String check="";
								//String order_category	= "";
								String order_type		= "";
								for(int z=0;z<previousValues.size();z++)
								{
									entryValue 	 = ((String)iterator.next()) ;
									chk_value= (String)previousValues.get(entryValue);
									keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
									//hashEntry.put(entryValue,"Y");
									if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
									{
										if(!chk_value.equals("N"))
										{
											check=records[0];
											if((entryValue.substring(2)).equals(check))
											{
													hashEntry.put(entryValue,"N");
																											
											}
											else
											{
												hashEntry.put(entryValue,"Y");
											}
										}
									}
									else // If it is hidden Field
									{
										if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
										{
											order_category = (String)previousValues.get("h1"+keyItems[1]) ;
											hashEntry.put("h1"+keyItems[1],order_category) ;
										}
										else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
										{
											order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
											hashEntry.put("h2"+keyItems[1],order_type) ;
										}
									}
								}
						}
						orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						previousValues=(HashMap)orderEntryRecordBean.getCheckedEntries(key);
					}*/
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
					//if(show_bill_info_yn.equals("Y")) {	// commented for IN039607
			
            _bw.write(_wl_block238Bytes, _wl_block238);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block618Bytes, _wl_block618);
}else{
            _bw.write(_wl_block240Bytes, _wl_block240);
}
            _bw.write(_wl_block619Bytes, _wl_block619);

							
							if("Y".equals(records[74]))
							{	
								
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(records[74]));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block620Bytes, _wl_block620);
            out.print( String.valueOf("S".equals(category)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block621Bytes, _wl_block621);
            out.print( String.valueOf("M".equals(category)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block622Bytes, _wl_block622);
            out.print( String.valueOf("C".equals(category)?"selected":""));
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block623Bytes, _wl_block623);
}else{ 
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block251Bytes, _wl_block251);
} 
            _bw.write(_wl_block624Bytes, _wl_block624);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block625Bytes, _wl_block625);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block626Bytes, _wl_block626);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block627Bytes, _wl_block627);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block628Bytes, _wl_block628);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block629Bytes, _wl_block629);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

							}
							
            _bw.write(_wl_block630Bytes, _wl_block630);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block631Bytes, _wl_block631);
            out.print( String.valueOf(i));
            _bw.write(_wl_block632Bytes, _wl_block632);
            out.print( String.valueOf(bean.getTempvalue("bill_now_"+records[0])==null?(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden"):bean.getTempvalue("bill_now_"+records[0]).equals("visible")?"visible":(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden")));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block633Bytes, _wl_block633);
            out.print( String.valueOf(i));
            _bw.write(_wl_block634Bytes, _wl_block634);
            out.print( String.valueOf(i));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(bean.getTempvalue("bill_now_check"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check"+records[0])));
            _bw.write(_wl_block635Bytes, _wl_block635);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block636Bytes, _wl_block636);
            out.print( String.valueOf(bean.getTempvalue("bill_now_check"+records[0]+"chk")==null?(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":""):bean.getTempvalue("bill_now_check"+records[0]+"chk").equals("Checked")?"checked":(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")));
            _bw.write(_wl_block637Bytes, _wl_block637);
if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){
            _bw.write(_wl_block638Bytes, _wl_block638);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block639Bytes, _wl_block639);
}
            _bw.write(_wl_block640Bytes, _wl_block640);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block641Bytes, _wl_block641);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block270Bytes, _wl_block270);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("excl_incl_ind_for_screen"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block642Bytes, _wl_block642);

								}
								
            _bw.write(_wl_block643Bytes, _wl_block643);
            out.print( String.valueOf(i));
            _bw.write(_wl_block644Bytes, _wl_block644);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("bill_now"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""): bean.getTempvalue("bill_now"+records[0])));
            _bw.write(_wl_block645Bytes, _wl_block645);
            out.print( String.valueOf(i));
            _bw.write(_wl_block646Bytes, _wl_block646);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getTempvalue("bill_now_check_Df"+records[0])==null?bean.checkForNull((String)bill_dtls.get("Future_order_yn"),""):bean.getTempvalue("bill_now_check_Df"+records[0])));
            _bw.write(_wl_block647Bytes, _wl_block647);
            out.print( String.valueOf(i));
            _bw.write(_wl_block648Bytes, _wl_block648);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[18]));
            _bw.write(_wl_block649Bytes, _wl_block649);
            out.print( String.valueOf(i));
            _bw.write(_wl_block650Bytes, _wl_block650);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(billing_details[19]));
            _bw.write(_wl_block651Bytes, _wl_block651);
				
					}
				//} 	// commented for IN039607
					else
					{ 
								//hashEntry.put(entryValue,"Y");								
						billing_call_yn = "N";
						out.println("&nbsp;");
					}				
				//IN071260 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				ArrayList<OrderDrugInteractionVO> drugs  = null;//IN072683
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
						bean.chkDrugInteractionForLB(records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
					
						interactionYN=bean.getDruginteractionYN();
						interdrugDtls = bean.getDruginteractionDtl();
						if(null!=interdrugDtls){
							drugs = interdrugDtls.get(records[0]);//IN072683
							if(null!=drugs && drugs.size() > 0 )//IN072683
								drugintercnt =	drugs.size();
						}
						
						checkUncheck =	interactionYN.get(records[0]);
				
					if("R".equals(checkUncheck)){
					
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block289Bytes, _wl_block289);
}
				}
				//IN071260 ENDS
				//orderEntryRecordBean.setCheckedEntries(key, hashEntry);

            _bw.write(_wl_block652Bytes, _wl_block652);

				if(numbering==0)
				{
				
            _bw.write(_wl_block653Bytes, _wl_block653);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(i));
            _bw.write(_wl_block214Bytes, _wl_block214);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block654Bytes, _wl_block654);
}else{
            _bw.write(_wl_block240Bytes, _wl_block240);
}
            _bw.write(_wl_block655Bytes, _wl_block655);

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
			//	if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && show_bill_info_yn.equals("Y")) // condition added for IN035929 // commented for IN039607
			//if(billing_interface_yn.equals("Y") && records[38].equals("Y"))//IN065324
			if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{	
						billing_call_yn		= "Y";
					//if(!billing_details[10].equals("")&&!billing_details[11].equals(""))
					//{
						//if(numbering==0)
					//{

            _bw.write(_wl_block656Bytes, _wl_block656);
            out.print( String.valueOf(i));
            _bw.write(_wl_block657Bytes, _wl_block657);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block658Bytes, _wl_block658);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block659Bytes, _wl_block659);
            out.print( String.valueOf(i));
            _bw.write(_wl_block660Bytes, _wl_block660);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block661Bytes, _wl_block661);
				} else billing_call_yn = "N"; 
            _bw.write(_wl_block662Bytes, _wl_block662);
}else{
            _bw.write(_wl_block663Bytes, _wl_block663);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block664Bytes, _wl_block664);
            out.print( String.valueOf(i));
            _bw.write(_wl_block665Bytes, _wl_block665);
}
            _bw.write(_wl_block666Bytes, _wl_block666);

				String EnableEmail="N";
				
				arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+records[0],records[0]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); //preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
			  			pat_preps_instrns     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
				 }
				if(comment.equals("")&&pat_preps_instrns.equals("")&&pat_preps_pat_instrns.equals("")&&pat_preps_dep_instrns.equals(""))
				{
					String sex_yn="";
					int age_in_days=0;
					String pat_pat_preps_instrns="";
					
					if(bean.checkForNull(records[35],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						if(null!=records && null!=records[0])//IN040531
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(records[0],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(records[0]);  // For Patient Preps. Insructions.
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(prepins),"");  // For Patient Preps. Insructions.
					}
					if((!pat_pat_preps_instrns.equals("")&&pat_pat_preps_instrns.length()>0))
					{
						EnableEmail="Y";
					}
				}
				else
				{
					EnableEmail="Y";
				}
				/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
				if(records[48].equalsIgnoreCase("Y"))
				{
					String PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth);
					if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
					{
						numbering=1;		
						non_billing_numbering=1;//IN068314
						billinginterface = "auth_interface";
					
            _bw.write(_wl_block667Bytes, _wl_block667);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(i));
            _bw.write(_wl_block670Bytes, _wl_block670);
 		
							displaytooltip=bean.getMessage(localeName,"PRIV_ORDER_AUTH_RIGHTS","OR");
							displaytooltip=displaytooltip.replace("{1}",records[0]);
						//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
					}
				}
				if(records[69].equalsIgnoreCase("N"))
				{
					numbering=1;		
					billinginterface = "operational_interface";
					non_billing_numbering=1;//IN068314
					
            _bw.write(_wl_block671Bytes, _wl_block671);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block672Bytes, _wl_block672);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block673Bytes, _wl_block673);
            out.print( String.valueOf(i));
            _bw.write(_wl_block674Bytes, _wl_block674);
 		
						displaytooltip=bean.getMessage(localeName,"CATALOG_OPERATIONAL_MODULE","OR");
						displaytooltip=displaytooltip.replace("{1}",records[0]);
				}

				if(numbering==1)
				{
					Set setValues			= null;
					Iterator iterator 		= null;
					if(previousValues!=null)		// Get the Previous Values from the Bean
					{
						setValues 			= previousValues.keySet();
						iterator 				= setValues.iterator();
						String chk_value="";
						//String check="";
						//String order_category	= "";
						String order_type		= "";
						for(int z=0;z<previousValues.size();z++)
						{
							entryValue 	 = ((String)iterator.next()) ;
							chk_value= (String)previousValues.get(entryValue);
							keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
							//hashEntry.put(entryValue,"Y");
						
							if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
							{
								if(!chk_value.equals("N"))
								{
									check=records[0];
									if((entryValue.substring(2)).equals(check))
									{
										hashEntry.put(entryValue,"N");																									
									}
									else
									{
										hashEntry.put(entryValue,"Y");
									}
								}
							}
							else // If it is hidden Field
							{
								if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
								{
									order_category = (String)previousValues.get("h1"+keyItems[1]) ;
									hashEntry.put("h1"+keyItems[1],order_category) ;
								}
								else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
								{
									order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
									hashEntry.put("h2"+keyItems[1],order_type) ;
								}
							}
						}
					}
					orderEntryRecordBean.setCheckedEntries(key, hashEntry);
					previousValues=(HashMap)orderEntryRecordBean.getCheckedEntries(key);
				  }
					//IN050607 Starts
				  	if ("N".equals(ordering_rule_yn)) {
						numbering = 1;
						billinginterface="or_ordering_rule_chk";
						non_billing_numbering=1;//IN068314
						
            _bw.write(_wl_block675Bytes, _wl_block675);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block668Bytes, _wl_block668);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block669Bytes, _wl_block669);
            out.print( String.valueOf(i));
            _bw.write(_wl_block676Bytes, _wl_block676);

						displaytooltip = bean.getMessage(localeName,
											"OR_ORDERING_RULE_CHK", "OR");
						displaytooltip = displaytooltip.replace("{1}",
											records[0]);
					}
					if (numbering == 1) {
						Set setValues = null;
						Iterator iterator = null;
						if (previousValues != null) // Get the Previous Values from the Bean
						{
							setValues = previousValues.keySet();
							iterator = setValues.iterator();
							String chk_value = "";
							String order_type = "";
							for (int z = 0; z < previousValues.size(); z++) {
								entryValue = ((String) iterator.next());
								chk_value = (String) previousValues
										.get(entryValue);
								keyItems = orderEntryRecordBean
										.getKey(entryValue); // Method Called from Bean to split the chk/h1 and get the value
							

								if (keyItems[0].equals("ck")) // If it is a check Box, then put the entry into a hashmap with the value as "Y"
								{
									if (!chk_value.equals("N")) {
										check = records[0];
										if ((entryValue.substring(2))
												.equals(check)) {
											hashEntry.put(entryValue, "N");
										} else {
											hashEntry.put(entryValue, "Y");
										}
									}
								} else // If it is hidden Field
								{
									if (keyItems[0].equals("h1")) // If it is a hidden (h1--denotes order_category)
									{
										order_category = (String) previousValues
												.get("h1" + keyItems[1]);
										hashEntry.put("h1" + keyItems[1],
												order_category);
									} else if (keyItems[0].equals("h2")) // If it is a hidden (h2--denotes order_type_code)
									{
										order_type = (String) previousValues
												.get("h2" + keyItems[1]);
										hashEntry.put("h2" + keyItems[1],
												order_type);
									}
								}
							}
						}
						orderEntryRecordBean.setCheckedEntries(key,
								hashEntry);
						previousValues = (HashMap) orderEntryRecordBean
								.getCheckedEntries(key);
					}
					//IN050607 Ends
					//}
					/*Ends Here*/
					
            _bw.write(_wl_block677Bytes, _wl_block677);
            out.print( String.valueOf(i));
            _bw.write(_wl_block678Bytes, _wl_block678);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block679Bytes, _wl_block679);
            out.print( String.valueOf(i));
            _bw.write(_wl_block680Bytes, _wl_block680);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(EnableEmail));
            _bw.write(_wl_block681Bytes, _wl_block681);
            out.print( String.valueOf(i));
            _bw.write(_wl_block682Bytes, _wl_block682);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[2]));
            _bw.write(_wl_block683Bytes, _wl_block683);
            out.print( String.valueOf(i));
            _bw.write(_wl_block684Bytes, _wl_block684);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[11]));
            _bw.write(_wl_block685Bytes, _wl_block685);
            out.print( String.valueOf(i));
            _bw.write(_wl_block686Bytes, _wl_block686);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[14]));
            _bw.write(_wl_block687Bytes, _wl_block687);
            out.print( String.valueOf(i));
            _bw.write(_wl_block688Bytes, _wl_block688);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block689Bytes, _wl_block689);
            out.print( String.valueOf(i));
            _bw.write(_wl_block690Bytes, _wl_block690);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[20]));
            _bw.write(_wl_block691Bytes, _wl_block691);
            out.print( String.valueOf(i));
            _bw.write(_wl_block692Bytes, _wl_block692);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[22]));
            _bw.write(_wl_block693Bytes, _wl_block693);
            out.print( String.valueOf(i));
            _bw.write(_wl_block694Bytes, _wl_block694);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[23]));
            _bw.write(_wl_block695Bytes, _wl_block695);
            out.print( String.valueOf(i));
            _bw.write(_wl_block696Bytes, _wl_block696);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[24]));
            _bw.write(_wl_block697Bytes, _wl_block697);
            out.print( String.valueOf(i));
            _bw.write(_wl_block698Bytes, _wl_block698);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[25]));
            _bw.write(_wl_block699Bytes, _wl_block699);
            out.print( String.valueOf(i));
            _bw.write(_wl_block700Bytes, _wl_block700);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[26]));
            _bw.write(_wl_block701Bytes, _wl_block701);
            out.print( String.valueOf(i));
            _bw.write(_wl_block702Bytes, _wl_block702);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[27]));
            _bw.write(_wl_block703Bytes, _wl_block703);
            out.print( String.valueOf(i));
            _bw.write(_wl_block704Bytes, _wl_block704);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[28]));
            _bw.write(_wl_block705Bytes, _wl_block705);
            out.print( String.valueOf(i));
            _bw.write(_wl_block706Bytes, _wl_block706);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[29]));
            _bw.write(_wl_block707Bytes, _wl_block707);
            out.print( String.valueOf(i));
            _bw.write(_wl_block708Bytes, _wl_block708);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[33]));
            _bw.write(_wl_block709Bytes, _wl_block709);
            out.print( String.valueOf(i));
            _bw.write(_wl_block710Bytes, _wl_block710);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locn_appt_reqd_yn));
            _bw.write(_wl_block711Bytes, _wl_block711);
            out.print( String.valueOf(i));
            _bw.write(_wl_block712Bytes, _wl_block712);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[34]));
            _bw.write(_wl_block713Bytes, _wl_block713);
            out.print( String.valueOf(i));
            _bw.write(_wl_block714Bytes, _wl_block714);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[35]));
            _bw.write(_wl_block715Bytes, _wl_block715);
            out.print( String.valueOf(i));
            _bw.write(_wl_block716Bytes, _wl_block716);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[37]));
            _bw.write(_wl_block717Bytes, _wl_block717);
            out.print( String.valueOf(i));
            _bw.write(_wl_block718Bytes, _wl_block718);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[38]));
            _bw.write(_wl_block719Bytes, _wl_block719);
            out.print( String.valueOf(i));
            _bw.write(_wl_block720Bytes, _wl_block720);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[39]));
            _bw.write(_wl_block721Bytes, _wl_block721);
            out.print( String.valueOf(i));
            _bw.write(_wl_block722Bytes, _wl_block722);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[40]));
            _bw.write(_wl_block723Bytes, _wl_block723);
            out.print( String.valueOf(i));
            _bw.write(_wl_block724Bytes, _wl_block724);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[41]));
            _bw.write(_wl_block725Bytes, _wl_block725);
            out.print( String.valueOf(i));
            _bw.write(_wl_block726Bytes, _wl_block726);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[43]));
            _bw.write(_wl_block727Bytes, _wl_block727);
            out.print( String.valueOf(i));
            _bw.write(_wl_block728Bytes, _wl_block728);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[44]));
            _bw.write(_wl_block729Bytes, _wl_block729);
            out.print( String.valueOf(i));
            _bw.write(_wl_block730Bytes, _wl_block730);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[48]));
            _bw.write(_wl_block731Bytes, _wl_block731);
            out.print( String.valueOf(i));
            _bw.write(_wl_block732Bytes, _wl_block732);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[49]));
            _bw.write(_wl_block733Bytes, _wl_block733);
            out.print( String.valueOf(i));
            _bw.write(_wl_block734Bytes, _wl_block734);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[50]));
            _bw.write(_wl_block735Bytes, _wl_block735);
            out.print( String.valueOf(i));
            _bw.write(_wl_block736Bytes, _wl_block736);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[51]));
            _bw.write(_wl_block737Bytes, _wl_block737);
            out.print( String.valueOf(i));
            _bw.write(_wl_block738Bytes, _wl_block738);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[53]));
            _bw.write(_wl_block739Bytes, _wl_block739);
            out.print( String.valueOf(i));
            _bw.write(_wl_block740Bytes, _wl_block740);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[54]));
            _bw.write(_wl_block741Bytes, _wl_block741);
            out.print( String.valueOf(i));
            _bw.write(_wl_block742Bytes, _wl_block742);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block743Bytes, _wl_block743);
            out.print( String.valueOf(i));
            _bw.write(_wl_block744Bytes, _wl_block744);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(billing_call_yn));
            _bw.write(_wl_block745Bytes, _wl_block745);
            out.print( String.valueOf(i));
            _bw.write(_wl_block746Bytes, _wl_block746);
            out.print( String.valueOf(i));
            _bw.write(_wl_block747Bytes, _wl_block747);
            out.print( String.valueOf(i));
            _bw.write(_wl_block748Bytes, _wl_block748);
            out.print( String.valueOf(i));
            _bw.write(_wl_block749Bytes, _wl_block749);
            out.print( String.valueOf(i));
            _bw.write(_wl_block750Bytes, _wl_block750);
            out.print( String.valueOf(i));
            _bw.write(_wl_block751Bytes, _wl_block751);
            out.print( String.valueOf(i));
            _bw.write(_wl_block752Bytes, _wl_block752);
            out.print( String.valueOf(i));
            _bw.write(_wl_block753Bytes, _wl_block753);
            out.print( String.valueOf(i));
            _bw.write(_wl_block754Bytes, _wl_block754);
            out.print( String.valueOf(i));
            _bw.write(_wl_block755Bytes, _wl_block755);
            out.print( String.valueOf(i));
            _bw.write(_wl_block756Bytes, _wl_block756);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block757Bytes, _wl_block757);
            out.print( String.valueOf(i));
            _bw.write(_wl_block758Bytes, _wl_block758);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block759Bytes, _wl_block759);
            out.print( String.valueOf(i));
            _bw.write(_wl_block760Bytes, _wl_block760);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(preps_instrn));
            _bw.write(_wl_block761Bytes, _wl_block761);
            out.print( String.valueOf(i));
            _bw.write(_wl_block762Bytes, _wl_block762);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(pat_preps_instrn));
            _bw.write(_wl_block763Bytes, _wl_block763);
            out.print( String.valueOf(i));
            _bw.write(_wl_block764Bytes, _wl_block764);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(preps_dept_instrn));
            _bw.write(_wl_block765Bytes, _wl_block765);
            out.print( String.valueOf(i));
            _bw.write(_wl_block766Bytes, _wl_block766);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block767Bytes, _wl_block767);
            _bw.write(_wl_block768Bytes, _wl_block768);
            out.print( String.valueOf(i));
            _bw.write(_wl_block769Bytes, _wl_block769);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[55]));
            _bw.write(_wl_block770Bytes, _wl_block770);
            out.print( String.valueOf(i));
            _bw.write(_wl_block771Bytes, _wl_block771);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[56]));
            _bw.write(_wl_block772Bytes, _wl_block772);
            out.print( String.valueOf(i));
            _bw.write(_wl_block773Bytes, _wl_block773);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[57]));
            _bw.write(_wl_block774Bytes, _wl_block774);
            out.print( String.valueOf(i));
            _bw.write(_wl_block775Bytes, _wl_block775);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[58]));
            _bw.write(_wl_block776Bytes, _wl_block776);
            out.print( String.valueOf(i));
            _bw.write(_wl_block777Bytes, _wl_block777);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[59]));
            _bw.write(_wl_block778Bytes, _wl_block778);
            out.print( String.valueOf(i));
            _bw.write(_wl_block779Bytes, _wl_block779);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[60]));
            _bw.write(_wl_block780Bytes, _wl_block780);
            out.print( String.valueOf(i));
            _bw.write(_wl_block781Bytes, _wl_block781);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[61]));
            _bw.write(_wl_block782Bytes, _wl_block782);
            out.print( String.valueOf(i));
            _bw.write(_wl_block783Bytes, _wl_block783);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[64]));
            _bw.write(_wl_block784Bytes, _wl_block784);
            out.print( String.valueOf(i));
            _bw.write(_wl_block785Bytes, _wl_block785);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[65]));
            _bw.write(_wl_block786Bytes, _wl_block786);
            out.print( String.valueOf(i));
            _bw.write(_wl_block787Bytes, _wl_block787);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(billinginterface));
            _bw.write(_wl_block788Bytes, _wl_block788);
            out.print( String.valueOf(i));
            _bw.write(_wl_block789Bytes, _wl_block789);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(servicepanel));
            _bw.write(_wl_block790Bytes, _wl_block790);
            out.print( String.valueOf(i));
            _bw.write(_wl_block791Bytes, _wl_block791);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(servicepanelcode));
            _bw.write(_wl_block792Bytes, _wl_block792);
            out.print( String.valueOf(i));
            _bw.write(_wl_block793Bytes, _wl_block793);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(numbering));
            _bw.write(_wl_block794Bytes, _wl_block794);
            out.print( String.valueOf(i));
            _bw.write(_wl_block795Bytes, _wl_block795);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(finbill));
            _bw.write(_wl_block796Bytes, _wl_block796);
            out.print( String.valueOf(i));
            _bw.write(_wl_block797Bytes, _wl_block797);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(records[66],"N")));
            _bw.write(_wl_block798Bytes, _wl_block798);
            out.print( String.valueOf(i));
            _bw.write(_wl_block799Bytes, _wl_block799);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(records[67],"N")));
            _bw.write(_wl_block800Bytes, _wl_block800);
            out.print( String.valueOf(i));
            _bw.write(_wl_block801Bytes, _wl_block801);
            out.print( String.valueOf(i));
            _bw.write(_wl_block802Bytes, _wl_block802);
            out.print( String.valueOf(i));
            _bw.write(_wl_block803Bytes, _wl_block803);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[70]));
            _bw.write(_wl_block804Bytes, _wl_block804);
            out.print( String.valueOf(i));
            _bw.write(_wl_block805Bytes, _wl_block805);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[71]));
            _bw.write(_wl_block806Bytes, _wl_block806);
            out.print( String.valueOf(i));
            _bw.write(_wl_block807Bytes, _wl_block807);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[72]));
            _bw.write(_wl_block808Bytes, _wl_block808);
            out.print( String.valueOf(i));
            _bw.write(_wl_block809Bytes, _wl_block809);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bean.checkForNull(records[73],"T")));
            _bw.write(_wl_block810Bytes, _wl_block810);
            out.print( String.valueOf(i));
            _bw.write(_wl_block811Bytes, _wl_block811);
            out.print( String.valueOf(i));
            _bw.write(_wl_block812Bytes, _wl_block812);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(non_billing_numbering ));
            _bw.write(_wl_block813Bytes, _wl_block813);
							
					if(speciality_code[0].equalsIgnoreCase("Y"))
					{
					
            _bw.write(_wl_block814Bytes, _wl_block814);
            out.print( String.valueOf(i));
            _bw.write(_wl_block815Bytes, _wl_block815);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(speciality_code[1]));
            _bw.write(_wl_block816Bytes, _wl_block816);
            out.print( String.valueOf(i));
            _bw.write(_wl_block817Bytes, _wl_block817);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(speciality_code[2]));
            _bw.write(_wl_block102Bytes, _wl_block102);

					}
					else
				   {
					
            _bw.write(_wl_block814Bytes, _wl_block814);
            out.print( String.valueOf(i));
            _bw.write(_wl_block815Bytes, _wl_block815);
            out.print( String.valueOf(i));
            _bw.write(_wl_block818Bytes, _wl_block818);
            out.print( String.valueOf(i));
            _bw.write(_wl_block817Bytes, _wl_block817);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(records[67],"N")));
            _bw.write(_wl_block102Bytes, _wl_block102);

					}
					
            _bw.write(_wl_block819Bytes, _wl_block819);
if(numbering==1){
            _bw.write(_wl_block820Bytes, _wl_block820);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block821Bytes, _wl_block821);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(displaytooltip));
            _bw.write(_wl_block822Bytes, _wl_block822);
}else{
            _bw.write(_wl_block823Bytes, _wl_block823);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block821Bytes, _wl_block821);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(records[62],"")));
            _bw.write(_wl_block822Bytes, _wl_block822);
}
            _bw.write(_wl_block824Bytes, _wl_block824);
            _bw.write(_wl_block825Bytes, _wl_block825);
            out.print( String.valueOf(i));
            _bw.write(_wl_block826Bytes, _wl_block826);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.checkForNull(records[63],"")));
            _bw.write(_wl_block420Bytes, _wl_block420);
            _bw.write(_wl_block827Bytes, _wl_block827);
		
						out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+i+","+i+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
					
            _bw.write(_wl_block828Bytes, _wl_block828);
	
				}
			} 
		
            _bw.write(_wl_block829Bytes, _wl_block829);
            out.print( String.valueOf(bean.checkForNull(patient_email_id,"")));
            _bw.write(_wl_block830Bytes, _wl_block830);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block831Bytes, _wl_block831);
            out.print( String.valueOf(i));
            _bw.write(_wl_block832Bytes, _wl_block832);
            out.print( String.valueOf(amend_count));
            _bw.write(_wl_block833Bytes, _wl_block833);
            out.print( String.valueOf(lb_instal_yn));
            _bw.write(_wl_block834Bytes, _wl_block834);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block835Bytes, _wl_block835);
            out.print( String.valueOf(bean.getSex()));
            _bw.write(_wl_block836Bytes, _wl_block836);
            out.print( String.valueOf(bean.getDob()));
            _bw.write(_wl_block837Bytes, _wl_block837);
            out.print( String.valueOf(display_auth_count));
            _bw.write(_wl_block838Bytes, _wl_block838);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block839Bytes, _wl_block839);
            out.print( String.valueOf(bean.getPractitionerId()));
            _bw.write(_wl_block840Bytes, _wl_block840);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block841Bytes, _wl_block841);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block842Bytes, _wl_block842);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block843Bytes, _wl_block843);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block844Bytes, _wl_block844);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block845Bytes, _wl_block845);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block846Bytes, _wl_block846);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block847Bytes, _wl_block847);
            out.print( String.valueOf(p_task_code));
            _bw.write(_wl_block848Bytes, _wl_block848);
            out.print( String.valueOf(p_task_srl_no));
            _bw.write(_wl_block849Bytes, _wl_block849);
            out.print( String.valueOf(ref_facility_id));
            _bw.write(_wl_block850Bytes, _wl_block850);
            out.print( String.valueOf(ref_date_time));
            _bw.write(_wl_block851Bytes, _wl_block851);
            out.print( String.valueOf(ref_sent_pract_id));
            _bw.write(_wl_block852Bytes, _wl_block852);
            out.print( String.valueOf(ref_sent_remarks));
            _bw.write(_wl_block853Bytes, _wl_block853);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block854Bytes, _wl_block854);
            out.print( String.valueOf(perfLocnMandFlag));
            _bw.write(_wl_block855Bytes, _wl_block855);
            out.print( String.valueOf(bt_order_type_code));
            _bw.write(_wl_block856Bytes, _wl_block856);

		if(order_set_bill_yn.equals("Y"))
		{
		
            _bw.write(_wl_block857Bytes, _wl_block857);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block858Bytes, _wl_block858);
            out.print( String.valueOf(bill_order_set_desc));
            _bw.write(_wl_block859Bytes, _wl_block859);

		}
		else
		{
		
            _bw.write(_wl_block860Bytes, _wl_block860);

		}
		
            _bw.write(_wl_block861Bytes, _wl_block861);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block862Bytes, _wl_block862);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block863Bytes, _wl_block863);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block864Bytes, _wl_block864);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block865Bytes, _wl_block865);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block866Bytes, _wl_block866);
            out.print( String.valueOf(dupchk_siteSpecFlag));
            _bw.write(_wl_block867Bytes, _wl_block867);
            out.print( String.valueOf(show_bill_info_yn));
            _bw.write(_wl_block868Bytes, _wl_block868);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block869Bytes, _wl_block869);
            out.print( String.valueOf(drugintercnt ));
            _bw.write(_wl_block870Bytes, _wl_block870);

		//Nullifying the objects
		PlaceOrderItems				= null;  		//Nullifying the objects
		AmendPlaceOrderItems		= null;		AmendSchedule				= null;
		AmendPlaceOrderFrequency	= null;		
		//AmendPlaceOrderDuration		= null;
		previousValues				= null;		Default						= null;
		DeptLocationCode 			= null;		performingLocationCode		= null;
		PlaceOrderType				= null;		PlaceOrderFrequency			= null;
		stFormatID					= null;
		copyOrderDetails			= null;		secondaryOrders				= null;

            _bw.write(_wl_block871Bytes, _wl_block871);
            out.print( String.valueOf(display_auth_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(format_mandatory_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(format_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(display_cosign_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(display_special_count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(p_start_date_time));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(drugintercnt));
            _bw.write(_wl_block872Bytes, _wl_block872);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block873Bytes, _wl_block873);

	// set it back persistence
	putObjectInBean(bean_id,bean,request);
	/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***start***/
	putObjectInBean(bean_id1,bean1,request);
	/******** SRR20056-SCF-2009  Id:  3736 ****04/06/2008***end***/
//	if(function_from.equals("EXTERNAL_ORDER")) {
//		putObjectInBean(existing_bean_id,external_bean_obj,request);
 //	}
}catch(Exception e){
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PlaceOrder.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Schd.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillLater.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillLater.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApptRequired.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
