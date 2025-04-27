package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dobatchdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/DOBatchDetails.jsp", 1709121588138L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/PoCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePO/js/DeliveryOrder.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\t\tfunction_id\t\t\t\t=\t\t \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n\t\t</script>\n\t\n\t</head>\n<body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\"formDOBatchDetails\" id=\"formDOBatchDetails\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=center scrolling=yes>\n\t<tr>\n\t\t\t<td class=\"label\" colspan=4><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b>&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  &nbsp;&nbsp;  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td>\n\t\t\t<td class=\"label\" colspan=5><b>Total Delivered Quantity : </b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" &nbsp;&nbsp; ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t\t<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><tr>\n\t\t<tr>\n\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<!--<th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th> Commented by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 -->\n\t\t\t<th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th><!-- Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356  -->\n\t\t\t<th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\n\t\t</tr>\n\t\t<tr></tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<td  align=\'left\'>&nbsp;\n\t\t\t\t\t\t<select name=\"facility_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"facility_id_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onchange=\"loadStore(this,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td  align=\'left\'>&nbsp;\n\t\t\t\t\t\t<select name=\"facility_id_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<td  align=\'left\'>&nbsp;\n\t\t\t\t\t<select name=\"req_store_code_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"req_store_code_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onchange=\"loadUOM(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" onblur = \"checkDelvUOM(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\"  name=\"delivery_qty_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"delivery_qty_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" class=\'NUMBER\' size=\"10\" maxlength=\"8\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);\" > \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<td  align=\"center\"><label id=\'uom_label_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' class=\"label\" >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label>\n\t\t\t\t<input type=\"hidden\"  name=\"delivery_uom_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"delivery_uom_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" class=\'NUMBER\' size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<!--bean.checkForNull(def_uom_desc) Modified by suresh.r on 04-06-2014 against ML-BRU-SCF-1356--></label>\n\t\t\t\t<input type=\"hidden\"  name=\"delivery_uom_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\"  name=\"free_qty_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"free_qty_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\"  name=\"sample_qty_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"sample_qty_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\"  name=\"expiry_date_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"expiry_date_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="  onBlur=\"CheckMaxYearForExpiryDate(this,\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');getBatchIDFromExpiryDate(expiry_date_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =",";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =");\"> &nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\"  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" ></img>\n\t\t\t\t\n\t\t\t</td>\n\t\t\t<td  align=\"right\"><!--modified by B.Badmavathi against ML-BRU-SCF-1616 -->\n\t\t\t\t<input type=\"text\"  name=\"batch_id_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"batch_id_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"  class=UPPER  size=\"20\" maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onKeyPress=\"return  CheckForSpecialChars1(event);\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="  onBlur=\"\"> \n\t\t\t</td>\n\t\t\t<td  align=\"right\">\n\t\t\t\t<select class=\"STSMALL\" name=\"trade_id_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"trade_id_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t</select>\t\n\t\t\t</td>\n\t\t\t\n\t\t\t<input type=\"hidden\" \tname=\"dist_conv_fact_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"dist_conv_fact_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"\tvalue=\"1\">\n\t\t\t<input type=\"hidden\" name=\"delivery_price_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"delivery_price_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" class=\'NUMBER\' size=\"12\" maxlength=\"12\"  value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"\">\n\t\t\t<input type=hidden name=\"shelf_life_exp_date_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"shelf_life_exp_date_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">  <!-- Added for #Inc no:40591 on 07-JUN-2013 -->\n\t\t\t\n\t\t</tr>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\t\t\t\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\" name=\"delivery_qty_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);\"> \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="<!--bean.checkForNull(def_uom_desc) Modified by suresh.r on 04-06-2014 against ML-BRU-SCF-1356--> </label>\n\t\t\t\t<input type=\"hidden\"  name=\"delivery_uom_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\" name=\"free_qty_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t<td  align=\"right\">\n\t\t\t\t<input type=\"text\" name=\"sample_qty_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =");\" > &nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="></img>\n\t\t\t\t\n\t\t\t</td>\n\t\t\t<td  align=\"right\"><!--modified by B.Badmavathi against ML-BRU-SCF-1616 -->\n\t\t\t\t<input type=\"text\"  name=\"batch_id_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"  class=UPPER size=\"20\" maxlength=\"20\"  value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"   ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" onKeyPress=\"return  CheckForSpecialChars1(event);\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t<td  align=\"right\">\n\t\t\t\t<select class=\"STSMALL\" name=\"trade_id_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"> <!-- Added for #Inc no:40591 on 07-JUN-2013 -->\n\t\t</tr>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\n\t\t ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\t\t\n\t\t\t<td  align=\"center\"><label id=\'uom_label_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" onKeyPress=\"\" onBlur=\"\"> \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =");\"> &nbsp;\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarLocal(\'expiry_date_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"  ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t</select>\t\n\t\t\t</td>\n\t\t\t\n\t\t\t\t<input type=\"hidden\" \tname=\"dist_conv_fact_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"\tvalue=\"1\">\n\t\t\t\t<input type=\"hidden\" name=\"delivery_price_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" onKeyPress=\"return isValidNumber(this,event,7,3);isValidInteger();\" onBlur=\"\">\n\t\t\t\t<input type=hidden name=\"shelf_life_exp_date_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t<tr>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td></td> \n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td align=\"right\">\n\t\t\t\t<input type=\"button\" align=\"right\" class=\"button\" name=\"Ok\" id=\"Ok\" value=\"  Ok  \"  onClick=\"exitBatchDetails();\" ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">\n\t\t\t\t\n\t\t\t</td>\n\t\t\t\t\t\n\t\t</tr>\n\t</table>\n\t<input type=\"hidden\" \tname=\"sys_date\" id=\"sys_date\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" \tname=\"finalize_yn\" id=\"finalize_yn\"\t\t\tvalue=\"No\">\n\t<input type=\"hidden\" \tname=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" \tname=\"function_id\" id=\"function_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" \tname=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" \tname=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" \tname=\"totalRecords\" id=\"totalRecords\"        \tvalue=\"5\">\n\t<input type=\"hidden\" \tname=\"item_code\" id=\"item_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" \tname=\"po_no\" id=\"po_no\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\"hidden\" \tname=\"delv_date\" id=\"delv_date\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<input type=\"hidden\" \tname=\"tot_qty\" id=\"tot_qty\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t<input type=\"hidden\" \tname=\"do_free_qty\" id=\"do_free_qty\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<input type=\"hidden\" \tname=\"do_sample_qty\" id=\"do_sample_qty\"\t\tvalue=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t<input type=\"hidden\" \tname=\"do_delivery_price\" id=\"do_delivery_price\"\tvalue=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t<input type=\"hidden\" \tname=\"delivery_qty\" id=\"delivery_qty\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\" \tname=\"free_qty\" id=\"free_qty\"\t\t\t\tvalue=\"\">\n\t<input type=\"hidden\" \tname=\"sample_qty\" id=\"sample_qty\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\" \tname=\"po_srl_no\" id=\"po_srl_no\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\"hidden\" \tname=\"request_no\" id=\"request_no\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\"hidden\" \tname=\"req_facility_id\" id=\"req_facility_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\"hidden\" \tname=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\"hidden\" \tname=\"batch_id_applicable_yn\" id=\"batch_id_applicable_yn\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\"hidden\" \tname=\"delivery_uom_desc\" id=\"delivery_uom_desc\" \tvalue=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\"hidden\" name=\"shelfLifeDate\" id=\"shelfLifeDate\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" >\n\t\n\t\n\t\n\t\n\t\n\t\n</form>\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );
	
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
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( request.getParameter("function_id") ));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String delivery_qty						=				request.getParameter("order_qty");
	String tot_qty							=				request.getParameter("order_qty");	
	String item_desc						=				request.getParameter("item_desc");
	String item_code						=				request.getParameter("item_code");
	String delivery_uom_desc				=				request.getParameter("temp_uom");
	String delivery_uom_code				=				request.getParameter("temp_uom_code");
	String free_qty							=				request.getParameter("free_qty");
	String do_free_qty						=				request.getParameter("free_qty");
	String sample_qty						=				request.getParameter("sample_qty");
	String do_sample_qty					=				request.getParameter("sample_qty");
	String delivery_price					=				request.getParameter("delivery_price");
	String do_delivery_price				=				request.getParameter("delivery_price");
	String function_id						=				request.getParameter("function_id");
	String facility_id = "";
	String store_code = "";
	String delv_uom = "";
	String delv_uom_desc = "";
	String batch_id = "";
	String expiry_date = "";
	String trade_id = "";
	String item_disabled = "";
	DeliveryOrderBean bean					=				(DeliveryOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date							=				bean.getSystemDate();
	String po_no							=				bean.checkForNull(request.getParameter("po_no"));
	String delv_date							=				bean.checkForNull(request.getParameter("delv_date"));
	String request_no							=				bean.checkForNull(request.getParameter("request_no"));
	String po_srl_no							=				bean.checkForNull(request.getParameter("po_srl_no"));
	String str_cd							=				bean.checkForNull(request.getParameter("store_code"));
	
	String mode_modify = bean.checkForNull(request.getParameter("mode_modify"));
	String req_facility_id = bean.checkForNull(request.getParameter("facility_id"));
	
//	int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	int max_rows = 5;
	String item_code1 = "";
	ArrayList hmExpRecords		= new ArrayList();

		System.out.println("item_code in Batch details = "+item_code);
		System.out.println("getBatchRecords in dBatch details = "+bean.getBatchRecords());
		
		if(po_no!=""){
			item_code1 = item_code+po_no+delv_date+request_no;
			System.out.println("item_code1 in Batch details = "+item_code1);
		}else{
			item_code1 = item_code;
		}
	ArrayList alDelvRecords		= new ArrayList();	
	if(bean.getBatchRecords(item_code1) != null && bean.getBatchRecords(item_code1).size()>0){
		hmExpRecords = (ArrayList)bean.getBatchRecords(item_code1);
		System.out.println("hmExpRecords = "+hmExpRecords);
		max_rows  = hmExpRecords.size();		
	}
	else{
		
		alDelvRecords = bean.getBatchDetailsData(bean.getDoc_no(),item_code,po_no,delv_date,request_no);
		if(alDelvRecords.size() > 0)
			max_rows  =  alDelvRecords.size();
					
	}

	int y=0;
	
	HashMap hmRecord = bean.getUomDesc(delivery_uom_code);
			if(hmRecord.size()>0){
				delivery_uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
	
	HashMap hmItemRecord		=	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ITEM_SELECT_FOR_DO"),item_code);
	System.out.println("hmItemRecord = "+hmItemRecord);
	String  batch_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("BATCH_ID_APPLICABLE_YN"),"N");
	String	trade_id_applicable_yn	=bean.checkForNull((String)hmItemRecord.get("TRADE_ID_APPLICABLE_YN"),"N");
	String	expiry_yn				=bean.checkForNull((String)hmItemRecord.get("EXPIRY_YN"),"N");	
	String disable_batch_id="";
	String disable_expiry_date="";
	String expiry_date1="";
	String default_batch_id="";
	String default_trade_id="";
	String default_trade_id_new ="";
	
	String fsDisabled = "";
	if((req_facility_id.equals("*A") || req_facility_id.equals("ALL") || req_facility_id.equals("")  ) && (str_cd.equals("*A") || str_cd.equals("ALL") || str_cd.equals("")) ){
		fsDisabled = "";
	}else{
		fsDisabled = "disabled";
	}
	
	
	ArrayList alRecord = new ArrayList();
	alRecord.add(str_cd);
	alRecord.add(item_code);
						
	String def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord).get("DEF_ISSUE_UOM");
	System.out.println("def_uom in do batch dtl = "+def_uom);
	String def_uom_desc = "";					 						 
	 if(def_uom != null && def_uom != ""){
		 def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
	}	
	

	System.out.println("mode in do batch details = "+mode);
	
	String shelf_life	=	bean.checkForNull((String)bean.fetchRecord("select SHELF_LIFE from MM_ITEM_LANG_VW where ITEM_CODE = ? and LANGUAGE_ID= ?",new String[]{item_code,locale}).get("SHELF_LIFE"),"N");
	String shelf_life_no = "";
	String shelf_life_time = "";
	if(shelf_life != null && shelf_life.length() > 0){
		 shelf_life_time = shelf_life.substring(shelf_life.length() - 1);
		 shelf_life_no = shelf_life.substring(0,shelf_life.length() - 1);
	}
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String shelfLifeDate	       = "";
	int s_life = 0 ;
	if(!shelf_life_no.equals(""))
		s_life = Integer.parseInt(shelf_life_no);
	if(shelf_life_time.equals("D")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"d");
	}else if(shelf_life_time.equals("M")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"M");
	}else if(shelf_life_time.equals("Y")){
		shelfLifeDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,s_life,"Y");
	}
	System.out.println("shelfLifeDate = "+shelfLifeDate);
		

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(delivery_qty));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(delivery_uom_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
			
			int ct=0;
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				
				if(bean.getBatchRecords(item_code1) != null){
					HashMap hm = (HashMap)hmExpRecords.get(cnt);
					facility_id = bean.checkForNull((String)hm.get("FACILITY_CODE"));
					store_code = bean.checkForNull((String)hm.get("STORE_CODE"));
					delivery_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
					free_qty = bean.checkForNull((String)hm.get("FREE_QTY"));
					sample_qty = bean.checkForNull((String)hm.get("SAMPLE_QTY"));
					delv_uom =  bean.checkForNull((String)hm.get("DELV_UOM"));
					delivery_price = bean.checkForNull((String)hm.get("DELV_PRICE"));
					batch_id = bean.checkForNull((String)hm.get("BATCH_ID"));
					expiry_date = bean.checkForNull((String)hm.get("EXPIRY_DATE"));
					trade_id = bean.checkForNull((String)hm.get("TRADE_ID"));
				}
				
				
				if(alDelvRecords != null && alDelvRecords.size() > 0 ){
					
				//if(ct < max_rows){
				//	for(int i=0;i<alDelvRecords.size();i++){
						HashMap hm = (HashMap)alDelvRecords.get(cnt);
					System.out.println("hm = "+hm);
					facility_id = bean.checkForNull((String)hm.get("FACILITY_CODE"));
					store_code = bean.checkForNull((String)hm.get("STORE_CODE"));
					delivery_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
					free_qty = bean.checkForNull((String)hm.get("FREE_QTY"));
					sample_qty = bean.checkForNull((String)hm.get("SAMPLE_QTY"));
					delv_uom =  bean.checkForNull((String)hm.get("DELV_UOM"));
					delivery_price = bean.checkForNull((String)hm.get("DELV_PRICE"));
					batch_id = bean.checkForNull((String)hm.get("BATCH_ID"));
					expiry_date = bean.checkForNull((String)hm.get("EXPIRY_DATE"));
					trade_id = bean.checkForNull((String)hm.get("TRADE_ID"));
					
					
					if(max_rows==5 && cnt!=0 && facility_id == ""){
						facility_id = "";
						store_code = "";
						delivery_qty="";
						free_qty = "";
						sample_qty = "";
						delv_uom = "";
						delivery_price = "";
						batch_id = "";	
						expiry_date = "";
						trade_id = "";
					
					}
					
					
					
					
				

				//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end	



				
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,(String)hm.get("TRADE_ID"));
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull((String)hm.get("TRADE_ID"),default_trade_id));
				}	
					
			//	delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	 
			
				ArrayList alRecord1 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				System.out.println("str_cd if = "+str_cd);
				alRecord1.add(str_cd);
				alRecord1.add(item_code);
			}else{
				System.out.println("store_code else = "+store_code);
				alRecord1.add(store_code);
				alRecord1.add(item_code);
			}	
			System.out.println("alRecord1 = "+alRecord1);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord1).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 1 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}
			
				
		
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(facility_id != null && facility_id != "") {
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getFacilityList(facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getFacilityList(req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(store_code != null && store_code != "" ) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getRequestByStoreList(store_code,facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getRequestByStoreList(str_cd,req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(delivery_qty)));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(delv_uom_desc != null && delv_uom_desc != "") {
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delv_uom_desc)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(delv_uom)));
            _bw.write(_wl_block46Bytes, _wl_block46);
} else {
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delivery_uom_desc)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(def_uom)));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(free_qty)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(sample_qty)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(expiry_date)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean.checkForNull(batch_id)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(default_trade_id_new));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull(delivery_price)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(ct));
            _bw.write(_wl_block74Bytes, _wl_block74);

			ct++; 
			//		}
			//	}				
				} else {
				
					
								
					if(max_rows==5 && cnt!=0 && facility_id == ""){
						facility_id = "";
						store_code = "";
						delivery_qty="";
						free_qty = "";
						sample_qty = "";
						delv_uom = "";
						delivery_price = "";
						batch_id = "";
						expiry_date = "";
						trade_id = "";
					
					}
					
					
					
					
					
					
					//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end
					
					
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,trade_id);
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull(trade_id,default_trade_id));
				}	
				// delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	
				
			 
				 ArrayList alRecord2 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				alRecord2.add(str_cd);
				alRecord2.add(item_code);
			}else{
				alRecord2.add(store_code);
				alRecord2.add(item_code);
			}	
			
			System.out.println("alRecord2 = "+alRecord2);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord2).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 2 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}	
				 
				
		
            _bw.write(_wl_block75Bytes, _wl_block75);
 if(facility_id != null && facility_id != "") {
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getFacilityList(facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getFacilityList(req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(store_code != null && store_code != "") {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getRequestByStoreList(store_code,facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getRequestByStoreList(str_cd,req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(delivery_qty)));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(delv_uom_desc != null && delv_uom_desc != "") {
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delv_uom_desc)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(delv_uom)));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delivery_uom_desc) ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(def_uom)));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(free_qty)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(sample_qty)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(expiry_date)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean.checkForNull(batch_id)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(default_trade_id_new));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull(delivery_price)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block86Bytes, _wl_block86);

								
				}
					
				y =  cnt;
				
				
            _bw.write(_wl_block87Bytes, _wl_block87);
		
			}
			
				y++;
				for ( int j=y ; j<5; j++ ) {
					System.out.println("y = "+y);
					if(j!=0 ){
					facility_id = "";
					store_code = "";		
					delivery_qty = "";
					free_qty = "";
					sample_qty = "";
					delv_uom = "";
					delivery_price = "";
					batch_id = "";
					expiry_date = "";
					trade_id = "";
					
					}
					
					
					//added on 11/03/2013
				
				if(expiry_yn.equals("N")) {
					expiry_date = sys_date;
					disable_expiry_date="disabled";
				}		
				if(trade_id_applicable_yn.equals("N")) {
					default_trade_id = (String)bean.getMm_parameter().get("DFLT_TRADE_ID");	
				}
				if(batch_id_applicable_yn.equals("N")) {
					disable_batch_id="disabled";
					batch_id = (String)bean.getMm_parameter().get("DFLT_BATCH_ID");	
				}
				else if(batch_id_applicable_yn.equals("E")) {
					if(expiry_yn.equals("Y")) {
						if (!expiry_date.equals("")) {
							batch_id = bean.getBatchIDFromExpiryDate(expiry_date);
						}
					}
					disable_batch_id="disabled";			
				}
				//end
					
					
					
				if(trade_id_applicable_yn.equals("Y")) {
					default_trade_id_new = bean.getTrade_id_List(item_code,trade_id);
				}else if(trade_id_applicable_yn.equals("N")) {
					default_trade_id_new = bean.getTrade_id_Default_List(bean.checkForNull(trade_id,default_trade_id));
				}	

			//	delv_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),delv_uom).get("SHORT_DESC");	
			
			ArrayList alRecord3 = new ArrayList();
			if(str_cd != null && !str_cd.equals("")){
				alRecord3.add(str_cd);
				alRecord3.add(item_code);
			}else{
				alRecord3.add(store_code);
				alRecord3.add(item_code);
			}	
			
			System.out.println("alRecord3 = "+alRecord3);
			def_uom = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_ITEM_STORE_UOM"),alRecord3).get("DEF_ISSUE_UOM");
			System.out.println("def_uom in do batch dtl 3 = "+def_uom);
						 						 
			if(def_uom != null && def_uom != ""){
				def_uom_desc = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),def_uom).get("SHORT_DESC");
			}
			
		System.out.println("str_cd = "+str_cd);
		System.out.println("req_facility_id = "+req_facility_id);		
		
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(facility_id != null && facility_id != "") {
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getFacilityList(facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getFacilityList(req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(store_code != null && store_code != "") {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getRequestByStoreList(store_code,facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
} else {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fsDisabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getRequestByStoreList(str_cd,req_facility_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(delivery_qty)));
            _bw.write(_wl_block77Bytes, _wl_block77);
if(delv_uom_desc != null && delv_uom_desc != "") {
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delv_uom_desc)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(delv_uom)));
            _bw.write(_wl_block89Bytes, _wl_block89);
}else{
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.checkForNull(delivery_uom_desc)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(def_uom)));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(free_qty)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(sample_qty)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.checkForNull(expiry_date)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(j));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_expiry_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(j));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean.checkForNull(batch_id)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disable_batch_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(j));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(default_trade_id_new));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(j));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(j));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(j));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(j));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean.checkForNull(delivery_price)));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(j));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(j));
            _bw.write(_wl_block86Bytes, _wl_block86);

				}
				
		
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(item_disabled));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bean_name ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(po_no));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(delv_date));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(tot_qty));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(do_free_qty));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(do_sample_qty));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(do_delivery_price));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(po_srl_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(request_no));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(req_facility_id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(batch_id_applicable_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(delivery_uom_code));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(shelfLifeDate));
            _bw.write(_wl_block116Bytes, _wl_block116);

	putObjectInBean(bean_id,bean,request);
		

            _bw.write(_wl_block117Bytes, _wl_block117);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.MultiBatchDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Item.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Facility.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.Store.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.DeliveryQty.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.StockUOM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.DoUOM.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.FreeQty.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.SampleQty.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.ExpiryDate.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.BatchId.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePO.TradeName.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${po_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
