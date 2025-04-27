package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryplaceordercaresetresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryPlaceOrderCareSetResults.jsp", 1740042342000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description \n-------------------------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n31/05/2013    IN040092\t\tKarthi L      When we Place \"Order Set\" Billing details are displayed.\n13/08/2013\t  IN042045\t\tChowminya G\t    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected\n02/07/2014\t  IN048467 \t\tNijitha S\t\t\t\t\t\t\t\t\t\tHSA-CRF-0150\n09/05/2016\t  IN058388-\t\tRaja S\t\t\tSystem displays ?Reqd/opt? in place order screen incorrect. It should be display according to \t\n\t\t\t  IN058669\t\t\t\t\t\tsetup.(ML-BRU-SCF-1659,SKR-SCF-1121)\n15/02/2017\t  IN063561\t\tRaja S\t\t\tOR->Place Order ->Order Set ->Error in Placing Order Set from Place order Screen_UT\n27/03/2017\tIN063686\t\tVijayakumar K\t\t\t\t\t\t\t\t\t PMG2017-GHL-CRF-0001 [IN:063686]\n03/07/2017\t  IN062607\t\tRaja S\t\t\t03/07/2017\t\tRamesh G\t\t\tML-MMOH-CRF-0727\n19/10/2017\tIN065324\t\tDinesh T\t\tTo display the price in OR screen and the billing status in Manage Specimen screen\n15/12/2017\tIN065942\t\tDinesh T\t\t\t15/12/2017\t\tRamesh G\t\tIn Nuclear medicine  department we required the \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbarcode functionality at the time of \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRegistration of order,required patient \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tId,patient name,age,sex,register date and name \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tof study.\n-------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\t\tRev.Date\t\tRev.Name\t\t\tDescription\n-------------------------------------------------------------------------------------------------------\n06/07/2018\tIN067246\t\tRaja S\t\t\t06/07/2018\t\tRamesh G\t\t\tGHL-CRF-0516\n17/07/2018\tIN064543\t\tKamalakannan\t17/07/2018\t\tRamesh G\t\t\tML-MMOH-CRF-0776\t\n01/08/2018\tIN64543\t\t\tDinesh T\t\t01/08/2018\t\tRamesh G\t\t\tML-MMOH-CRF-0776\n13/11/2018  IN069001\t\tsivabagyam\t\t13/11/2018  \tRamesh G \t\t\tGHL-SCF-1391\n09/01/2019  IN066377  \t\tKamalakannan G\t09/01/2019\t\tRamesh G\t\t\tAMS-CRF-0139\n21/04/2019\tIN070295\t\tRamesh G\t\t21/04/2019\t\tRamesh G\t\t\tML-BRU-SCF-1939\n05/02/2020\tIN068314\tNijitha S\t05/02/2020\tRamesh G\tML-MMOH-CRF-1229\n09/03/2020\t  IN072669\t\tNijitha S\t09/03/2020\t\tRamesh G\n25/03/2020\tIN072744\t\tNijitha S\t25/03/2020\t\t\tRamesh G\t\t\tML-MMOH-CRF-1229\n07/06/2020\tIN072524\t\tNijitha S     \t07/06/2020\t\tRamesh G\t\tML-MMOH-CRF-1229.2\n29/10/2020\tIN073712\t\tNijitha S     \t29/10/2020\t\tRamesh G\t\tML-MMOH-CRF-1229.3\n07/04/2023\t42107\t\t\tRamesh G   \t\t\t\t\t\t\t\t\t\tGHL-SCF-1702\n-------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="<!--IN062607-->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t</link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryRapidPreview.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- for Tool Tip-->\n\n<script>\n\t\t// Violation, but to make the alignment size same as the top frame...\n\t\tfunction alignWidth() \n\t\t{\n\t\t\tparent.legendsFrame.document.getElementById(\"titleTab\").width=document.getElementById(\"detailTab\").rows(1).offsetWidth;\n\t\t\tif(document.getElementById(\"detailTab\").rows(1)!=null) \n\t\t\t{\n\t\t\t\tfor(i=0;i<document.getElementById(\"detailTab\").rows(1).cells.length;i++) \n\t\t\t\t{   // Depending upon the first row\n\t\t\t\t\tvar wid=document.getElementById(\"detailTab\").rows(1).cells(i).offsetWidth;\n\t\t\t\t\tif(parent.legendsFrame.document.getElementById(\"titleTab\").rows(0).cells(i))\n\t\t\t\t\t\tparent.legendsFrame.document.getElementById(\"titleTab\").rows(0).cells(i).width=wid;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfunction alignPreviewWidth() \n\t\t{\n\t\t\tif(document.getElementById(\"detailTab\").rows(1)!=null) \n\t\t\t{\n\t\t\t\tfor(i=0;i<document.getElementById(\"detailTab\").rows(1).cells.length;i++)\n\t\t\t\t{   // Depending upon the first row\n\t\t\t\t\tvar wid=document.getElementById(\"detailTab\").rows(1).cells(i).offsetWidth;\n\t\t\t\t\tif(document.getElementById(\"titleTab\").rows(0).cells(i))\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"titleTab\").rows(0).cells(i).width=wid;\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfunction moveFrame()\n\t\t{\n\t\t\tvar temp=document.body.scrollLeft;\n\t\t\tscrollValue=temp;\n\t\t\tif(parent.legendsFrame)\n\t\t\t{\n\t\t\t\tif(parent.legendsFrame.location.href.indexOf(\".jsp\") != -1)\n\t\t\t\t{\n\t\t\t\t\tparent.legendsFrame.document.body.scrollLeft=temp;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n\n<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n</head>\n<style TYPE=\"text/css\"> </style>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"ClinicalComment();\" onScroll=\"moveFrame()\">\n<form name=\"placeOrderForm\" id=\"placeOrderForm\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<table border=\"1\" cellpadding=0 cellspacing=0  width=\"100%\" id=\"titleTab\">\n\t\t<tr>\n\t\t\t<td class=\' columnheader\' width=\"0%\">&nbsp;</td>\n\t\t\t<td class=\' columnheader\' width=\"0%\" ><a class=\"gridLink\" href=\"#\" onClick=\"changeAllStartDateTime()\" title=\"Do you want to change the Start Date Time, Click here\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></td>\n\t\t\t<td class=\' columnheader\' width=\"0%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n\t\t\t<td class=\' columnheader\' width=\"0%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td class=\' columnheader\' width=\"0%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n  \t\t\t<td class=\' columnheader\' width=\"0%\">&nbsp;</td>\n\t\t\t<td class=\' columnheader\' width=\"0%\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<!--<th width=\"\">End Date</th> -->\n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"detailTab\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t\t<script>alert(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\");</script>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t//parent.criteriaDetailFrame.document.getElementById(\"recordApply\").disabled=true;\n\t\t\t\t\t\tparent.criteriaDetailFrame.document.getElementById(\"record\").disabled=true;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t</td><tr><td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></td><td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></td><td colspan=\"7\" class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><!-- <table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'right\' style=\'border-width:0\' class=\"grid\"> --> <!--  commentedfor IN035929[IN040092] --><!--IN072524-->\n\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'right\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="style=\'border-width:0;display:inline\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="style=\'border-width:0;display:none\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" class=\"grid\"> <!--  condition added for IN035929[IN040092] -->\n\n\t\t\t\t\t\t<tr >\t\n\t\t\t\t\t\t<!--IN072524 Starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"fpp_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"fpp_yn";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\t\t\t\t\t\t<td rowspan=\"2\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" style=\'border-width:0;\' nowrap ><font size=\"1\" class=\'label\'>&nbsp;<B>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =":</B></font>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<select name=\"fpp_category";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"fpp_category";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  onchange=\"reviseBillingchrgs(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'ORDER_SET\')\" >\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<!--IN072524 Ends-->\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'15%\' class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'15%\' class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</B></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</B></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'actual_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'payable_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</span></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'included_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</span></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'approved_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</span></font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t<!--added against ML-ML-MMOH-CRF-1229.3-->\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\'ordersetlevel\' style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'\',\'ORDER_SET\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',\'\',\'\')\" title=\'Charge Details\'> ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" <!--View / Edit--></a><!-- IN073712 -->\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table></td></tr>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"CAHIGHERLEVELCOLOR\">\n\t\t\t\t<input type=\"hidden\" name=\"hdr_format_id_mandatory_yn";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"hdr_format_id_mandatory_yn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_care_set_order_category";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"hdr_care_set_order_category";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_order_catalog_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"hdr_order_catalog_code";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_format_id";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"hdr_format_id";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:orderFormatForCareSetsHeader(\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\",\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\",";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =",\"\")\' title=\'Order Format\'>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"5\" align=\"left\" class=\"CAHIGHERLEVELCOLOR\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t<!-- Modified by Uma on 3/11/2010 for IN019871 -->\n\t\t\t \t<td id=\"hdg";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" class=\"CAHIGHERLEVELCOLOR\" nowrap>\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="<label  id=\"press_link\"  style=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</label><label  id=\"press_links\"  style=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"><font color=\"#FFFFCC\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</font></label><label id=\"authorizedId";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" align=\"left\" class=\"CAHIGHERLEVELCOLOR\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="<label  id=\"auths\"  style=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"><a class=\'gridLink\' href=\'javascript:CareSetCheckAuthorization(\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\")\'><font color=\"#FFFFCC\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</font></a></label><label  id=\"auth\"  style=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</label><input type=\"hidden\" name=\"auth_reqd";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"auth_reqd";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"></label>\n\t\t\t\t</td>\n\t\t\t\t<!-- Ends Here -->\n\t\t<td id=\"imageId";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td> \n\t\t<td align=\"left\" class=\"CAHIGHERLEVELCOLOR\">&nbsp;</td>  \t\t\t\t\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t<tr>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t<input type=\"hidden\" name=\"enable_email";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"enable_email";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t\n\t\t\t\t<td style=\"width:2\"  id=\"billing";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" class=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"><input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" id=\"ck";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" onClick=\"setCheckValue(this,\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="><input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"h1";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"><input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"h2";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"></td>\n\t\t\t\t<td width=\"\" id=\"billing1";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><input type=\"hidden\" name=\"catalog_code";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"catalog_code";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"><input type=\"text\" id=\"start_date_time_id";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" name=\"start_date_time";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" onkeyDown=\'chkBackSpace();\'  value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" size=\"14\" maxLength=\"16\"  onBlur=\" checkStartDateTim(this,";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =",\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\')\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendarValidate(\'start_date_time_id";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\',null,\'hh:mm\',\'\',\'\');\" style=\'cursor:pointer\'><input type=\"hidden\" name=\"start_time";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"start_time";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" size=\"14\" maxLength=\"16\"></td>\n\t\t\t\t<td width=\"\"  id=\"billing2";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\",\"placeOrderForm\")\' onMouseOut=\"hideToolTip()\"><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\t\t\t\t\t&nbsp;<img id=\'authorization";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' src=\"../../eOR/images/Authorization.gif\" align=\"center\"></img>\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' src=\"../../eOR/images/Authorization.gif\" \talign=\"center\"></img>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t</font><input type=\"hidden\" name=\"cat_desc";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id=\"cat_desc";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"><input type=\"hidden\" name=\"type_desc";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"type_desc";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" value=\"\"></td>\n\t\t\t\t<td width=\"\" id=\"billing3";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" align=\"right\">\n\t\t\t\t\t<select name=\"order_type_code";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" id=\"order_type_code";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" disabled>\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"order_type";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"order_type";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" value=\"\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t<td width=\"\" id=\"billing4";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t\t\t\t<select name=\"priority";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"priority";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" onChange=\"setOrderPriority(\'priority\',\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\',";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =")\"><!--IN048467-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t   <option value=R>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t   <option value=U>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t   <option value=S>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n   \t\t\t \t\t</select>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t<!-- 42107 Start.  -->\n\t\t\t\t\t\t<!-- input type=\"hidden\" name=\"priority<//%=count%>\" value=\"<//%=priority_value%>\"> -->\n\t\t\t\t\t\t<!-- input type=\"hidden\" name=\"priority_appl<//%=count%>\" value=\"<//%=records[52]%>\"> -->\n\t\t\t\t\t<!-- 42107 End. -->\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t<!--  42107 Start. -->\n\t\t\t\t<input type=\"hidden\" name=\"priority";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"priority_appl";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" id=\"priority_appl";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t\t<!-- 42107 End.  -->\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" align=\"right\" nowrap id=\"priority_id";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" ><font size=\"1\">\n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t<a class=\"gridLink\" href=\"#\" ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =" onClick=\"javascript:return changePriorityLineLevel(\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" title=\"Routine\"><b>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</b>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t  <a class=\"gridLink\" href=\"#\" ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="  title=\"Urgent\"><b>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t <a class=\"gridLink\" href=\"#\" ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="  title=\"Stat\"><b>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\n\t\t\t\t<td width=\"\" id=\"billing5";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"><input type=\"text\" style=\"text-align:\'right\'\" name=\"quantity";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" id=\"quantity";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" size=\"2\" maxLength=\"6\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" onBlur=\"checkValidNumber(\'\',this);calculateDosage(";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =");reviseBillingchrgs(\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\',\'NEW_ORDER\')\" ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =">\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"\" id=\"billing6";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t<select name=\"frequency_code";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" id=\"frequency_code";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" onChange=\"setFrequency(this,";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\',\'onChange\')\">\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="---</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t</select>\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" disabled>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="---</option>\n\t\t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"frequency_val";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" id=\"frequency_val";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_yn";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" id=\"schedule_yn";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" id=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_nature";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" id=\"freq_nature";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" value=\"F\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"repeat_value";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\" id=\"repeat_value";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" value=\"\" >\n\t\t\t\t</td>\n\t\t\t\t<td width=\"\" id=\"billing7";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"duration_value";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" id=\"duration_value";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" size=\"2\" maxLength=\"3\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onBlur=\'checkMaxValue(this,\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\",escape(\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"),\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\")\'  ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =">\n\t\t\t\t\t<input type=\"hidden\" class=\"NUMBER\" name=\"duration_def_value";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" id=\"duration_def_value";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" >\n\t\t\t\t</td>\n\t\t\t\t<td width=\"\" id=\"billing9";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t\t\t\t<select name=\"duration_code";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" id=\"duration_code";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" DISABLED>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="---</option>\n";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\n\t\t\t\t\t\t<option value=\"D\" selected>";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</option>\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t</select>\n\t\t\t\t\t<input type=\"hidden\" name=\"duration";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" id=\"duration";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t<tr>\n\t\t\t\t<input type=\"hidden\" name=\"format_id_val";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" id=\"format_id_val";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" id=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" >\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\" id=\"orderformat";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" rowspan=\'2\'><font size=\"1\"> &nbsp;<!--IN068314-->\n\t\t\n\n\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"consent_id_lookup";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" id=\"consent_id_lookup";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" title=\'Consent Required\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\')\">\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" id=\"consent_chk";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" name=\"consent_form_id";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" name=\"consent_stages";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"consent_form_list";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" id=\"consent_form_list";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"total_recs";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" id=\"total_recs";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' name=\"consent_stages";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="0\">\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="0\" id=\"consent_chk";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="0\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="0\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"multiConsentList";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" id=\"multiConsentList";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n                <Script>\n\t\t\t\t\t(document.getElementById(\"start_date_time";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\")).value = \'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\';\n                </Script>\n\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewSecondaryOrders(\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\')\"> <img src=\'../../eOR/images/SecondaryOrder.gif\' border=\'0\'  title=\'Secondary Orders Exists\'></img>&nbsp;</a>\n\t\t\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t<input type=\"hidden\" name=\"sec_tasks_type";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" id=\"sec_tasks_type";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" id=\"billing10";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" align=\"left\"  rowspan=\'2\'><font size=\"1\">";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</font><input type=\"text\" name=\"end_date_time";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" id=\"end_date_time";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" size=\"8\" maxLength=\"16\" value=\"\" readOnly></td>\n";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" id=\"billing11";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" rowspan=\'2\' align=\"left\" colspan=\'2\' nowrap><label  id=\"schedule";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" Title=\"Schedule\">&nbsp;</label><!-- </td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\" align=\"left\"> --><font size=\"1\">&nbsp;";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t<font size=\"1\"><b>";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</b></font><br>\n";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\t\t\t\t\t\n\t \t\t\t\t<select name=\"performing_facility_id";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" onchange=\'clearDepLocn(\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\",this);setPerformingFacility(\"performing_facility_id";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\",this);\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\n \t\t\t\t</select></font>/\n\t\t\t\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="&nbsp;:</b><br>\n\t\t\t\t\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n \t\t\t\t\t";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="</font>/\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\n\t\t\t\t<select name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" id=\"performing_dept_loc_code";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\" onchange=\' getApptReqdYN(\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\",this,\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\");\'>\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\n\t\t\t\t</select>\n";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="  \n\t\t\t\t\t<select name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" >\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\" value=\"\">\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\n\t\t\t\t\n\t\t\t\t</font>\n\t\t\t\t\n\t\t\t\t<!-- IN066377 start -->\n\t\t\t\t";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"perfLocnMandFlag";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\" id=\"perfLocnMandFlag";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\"><!--IN066377-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\t\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="<!-- IN066377 end -->\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"4\" id=\"billing12";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\" rowspan=\'2\' class=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\" align=\"left\" style=\"text-align:left\" style=\'border-right-width: 0;\' >\n\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\n\t\t\t\t\t\t\t\t <script>alert(\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\");billchecking(\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\");displaycolor(\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\");</script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t var msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\");\n\t\t\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\");\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n\t\t\t\t<!--\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\' align=\'left\' style=\'border-width:0\' class=\"grid\"> --> <!--  commented for IN035929[IN040092] -->\n\t\t\t\t <table cellpadding=0 cellspacing=0 border=1 width=\'100%\' align=\'left\' ";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="  class=\"grid\"> \n\t\t\t\t <!--  modified for IN035929[IN040092] -->\n\t\t\t\t\t\n\t\t\t\t\t\t<tr >\t\n\t\t\t\t\t\t<!--IN068314 Starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\" ><!-- IN072744 -->\n\t\t\t\t\t\t\t<td rowspan=\"2\" colspan=\"\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\',\'NEW_ORDER\')\" ><!-- IN072744 -->\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 =" \n\t\t\t\t\t\t\t<td width=\'50%\' rowspan=\"2\" class=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\" style=\'border-width:0;\'>&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t\t\t\t<!--IN068314 Ends-->\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'10%\' class=\"";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" style=\'border-width: 0;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 =":</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\" style=\'border-width: 0;text-align: right;\'  nowrap><font class=\'fields\' size=\"1\"><span id=\'bill_now_";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\' style=\'visibility:";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="<input type=\"checkbox\" name=\'bill_now_check";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\' id=\'bill_now_check";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\'value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\" ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 =" onclick=\"changeBillNow(this,\'";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\')\" ></span></font>";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="(";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 =")";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bill_now";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" id=\"bill_now";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"bill_now_check_Df";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" id=\"bill_now_check_Df";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"future_date";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" id=\"future_date";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"round_off_start_time";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" id=\"round_off_start_time";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" >\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\n\t\t\t\t<td id =\"order";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\" rowspan=\'2\' align=\"left\" ";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 =">&nbsp;<font size=\"1\"> <!--  added for IN035929[IN040092] --><!--IN068314-->\n";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\t\t\t\t<!-- <a href=\"javascript:callBilling(\'";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\',\'NEW_ORDER\')\" title=\'Charge Details\'>";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="</a> -->\n\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\',\'NEW_ORDER\',\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 =" <!--View / Edit--></a>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =" \n\t\t\t\t\t</font>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t\t\t\t<td id =\"order";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\" style=\"background=#FF7DD0;\" rowspan=\'2\'></td><!--IN068314-->";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t var msg=getMessage(\"PRIV_ORDER_AUTH_RIGHTS\",\"OR\");\n\t\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\");\n\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\");\n\t\t\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\");//IN072744\n\t\t\t\t\t\t\t\tdisableFPPCategoryOrderset(\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\");//IN068314//IN072744\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t var msg=getMessage(\"CATALOG_OPERATIONAL_MODULE\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\");\n\t\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\");//IN072744\n\t\t\t\t\t\t\tdisableFPPCategoryOrderset(\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\")//IN068314//IN072744\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\tlabdruginterchk(\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\");\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t </script>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tsetDrugInteraction(\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"order_catalog_nature";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\" id=\"order_catalog_nature";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"quantity_uom";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\" id=\"quantity_uom";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_applicable_yn";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\" id=\"freq_applicable_yn";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"soft_stop_yn";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\" id=\"soft_stop_yn";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"cont_order_yn";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\" id=\"cont_order_yn";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\" id=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_status";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\" id=\"chk_for_dupl_status";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\" id=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\" id=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\" id=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\" id=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\" id=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\" id=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_reqd_yn";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" id=\"appt_reqd_yn";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\" id=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_time";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\" id=\"appt_time";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\" id=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"complete_on_order_yn";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\" id=\"complete_on_order_yn";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\n\t\t\t\t\t<!-- <input type=\"hidden\" name=\"bill_yn";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\" id=\"bill_yn";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\"> -->\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_yn";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_applicable_yn";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\" id=\"result_applicable_yn";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" id=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chart_result_type";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" id=\"chart_result_type";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_mod_id";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\" id=\"contr_msr_mod_id";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_panel_id";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\" id=\"contr_msr_panel_id";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\" id=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\" id=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\" id=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\" id=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"activity_type";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" id=\"activity_type";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"check_for_dupl_level";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\" id=\"check_for_dupl_level";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\" id=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\" id=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\" id=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\" id=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" id=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" id=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"consent_stage";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\" id=\"consent_stage";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<!--added on 08/05/07 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" id=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_br";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\" id=\"num_of_consent_req_br";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_interface";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" id=\"billing_interface";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" id=\"service_panel";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel_code";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\" id=\"service_panel_code";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"numbering";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" id=\"numbering";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"FinBill";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" id=\"FinBill";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\" id=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"authorised_yn";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\" id=\"authorised_yn";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\" value=\"N\">\n\t\t\t\t";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"splty_code";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\" id=\"splty_code";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"auth_yn";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\" id=\"auth_yn";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\" value=\"\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"auth_yn";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\n\n\t\t\t\t\t\n\t\t\t\t\t<!-- ends here-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"group_order_category";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\" id=\"group_order_category";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_call_yn";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\" id=\"billing_call_yn";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"specimen_type";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\" id=\"specimen_type";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"nurse_collect";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\" id=\"nurse_collect";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\" value=\"N\">\n\t\t\t\t\t<input type=\"hidden\" name=\"care_set_authorized";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\" id=\"care_set_authorized";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\" value=\"false\">\n\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\" id=\"order_id";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" value=\"\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\" value=\"\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_preps";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\" id=\"line_preps";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\" value=\"\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_pat_instrn";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\" id=\"line_pat_instrn";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\" value=\"\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_dept_instrn";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\" id=\"line_dept_instrn";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\" value=\"\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_comments";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\" id=\"line_comments";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\" value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"auto_report_yn";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\" id=\"auto_report_yn";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\"> ";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"skip_auth";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\" id=\"skip_auth";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\"><!--IN048467 - HSA-CRF-0150-->\t\n\t\t\t\t\t<input type=\"hidden\" name=\"prn_regd_ord";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\" id=\"prn_regd_ord";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\"><!--IN065942-->\n\t\t\t\t\t<input type=\"hidden\" name=\"instrn_content_type";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\" id=\"instrn_content_type";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" value=\'";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\'><!--IN065942-->\n\t\t\t\t\t<input type=\"hidden\" name=\"non_billing_numbering";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\" id=\"non_billing_numbering";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\"  id =\"non_billing_numbering";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\" /><!--IN068314 -->\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\n\t\t\t<table>\n\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\" align=\"left\">&nbsp;</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" align=\"left\" >&nbsp;</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\" align=\"left\" colspan=\"2\"><font size=\"1\" color=\"blue\">";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="<b>";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="</b> ";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 =" <b>";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="</font>\n\t\t\t\t\t<input type=\"hidden\" name=\"form_code";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\" id=\"form_code";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"strength_value";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\" id=\"strength_value";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\">\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" align=\"left\" ><font size=\"1\">";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="</font> &nbsp;\n\t\t\t\t\t<select name=\"route_code";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\" id=\"route_code";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\">\n\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" align=\"left\"><font size=\"1\">";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="</font> &nbsp;\n\t\t\t\t\t<select name=\"dosage_by";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" id=\"dosage_by";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\" onChange=\"changeDosage(this, ";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 =")\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\n \t\t\t\t\t</select>\n\t\t\t\t</td>\n \t\t\t\t<td id=\"dosage_id";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\" align=\"left\">&nbsp;";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\n \t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\" align=\"left\"><input type=\"text\" name=\"dosage";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\" id=\"dosage";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\" size=\"4\" maxLength=\"6\" value=\"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" onBlur=\"calculatePHQuantity(";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 =")\"> </td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\" align=\"left\">\n\t\t\t\t\t<select name=\"uom";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\" id=\"uom";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\t\t\t\t\t\t\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<input type=\"hidden\" name=\"dosage_type";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\" id=\"dosage_type";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"strength_uom_desc";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\" id=\"strength_uom_desc";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"stock_uom";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\" id=\"stock_uom";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"strength_per_pres_uom";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\" id=\"strength_per_pres_uom";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"strength_per_value_pres_uom";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\" id=\"strength_per_value_pres_uom";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fract_dose_round_up_yn";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\" id=\"fract_dose_round_up_yn";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"content_in_pres_base_uom";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\" id=\"content_in_pres_base_uom";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"prn_doses_pres_prd_fill";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\" id=\"prn_doses_pres_prd_fill";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"pres_base_uom";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\" id=\"pres_base_uom";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\">\n\t\t\t\t<!--<input type=\"hidden\" name=\"instrn_content_type";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\">--><!--IN064543-->\n\t\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"9\" class=\"ORQRYEVENBORDER\">&nbsp;</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t/*Addded by Uma on 3/24/2010 for IN019999*/\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);\n\t\t\t\t\t\t\n\t\t\t\t\t\t//if(parent.criteriaDetailFrame.document.getElementById(\"recordApply\")){\n\t\t\t\t\t\t\tif(parent.criteriaDetailFrame.document.getElementById(\"record\")){\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.criteriaDetailFrame.document.getElementById(\"record\").disabled=true;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.criteriaDetailFrame.document.getElementById(\"recordPreview\"))\n\t\t\t\t\t\t\tparent.criteriaDetailFrame.document.getElementById(\"recordPreview\").disabled=true;\n\t\t\t\t\t\tif(top.content==null)\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t/*Ends Here by Uma for IN019999*/\n\t\t\t\t\t</script> \n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n</table>\n\t\t<input type=\"hidden\" name=\"patient_email_id\" id=\"patient_email_id\" value=\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\">\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );

    private final static java.lang.String  _wl_block558 ="\">\n\t\t<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\"";
    private final static byte[]  _wl_block558Bytes = _getBytes( _wl_block558 );

    private final static java.lang.String  _wl_block559 ="\"><!--used for New orders-->\n\t\t<input type=\"hidden\" name=\"amend_total_rows\" id=\"amend_total_rows\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"\">\n\n\t\t<input type=\"hidden\" name=\"authorized\" id=\"authorized\" value=\"\"><!--used for New orders-->\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"priority_hdr\" id=\"priority_hdr\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_date_time\" id=\"order_date_time\" value=\"\">\n\t\t<input type=\"hidden\" name=\"header_comments\" id=\"header_comments\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"\">\n\t\t<input type=\"hidden\" name=\"total_size\" id=\"total_size\" value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"consented\" id=\"consented\" value=\"\">\n\t\t<input type=\"hidden\" name=\"cosigned\" id=\"cosigned\" value=\"\">\n\t\t<input type=\"hidden\" name=\"special_approved\" id=\"special_approved\" value=\"\">\n\t\t<input type=\"hidden\" name=\"lb_instal_yn\" id=\"lb_instal_yn\" value=\"";
    private final static byte[]  _wl_block559Bytes = _getBytes( _wl_block559 );

    private final static java.lang.String  _wl_block560 ="\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block560Bytes = _getBytes( _wl_block560 );

    private final static java.lang.String  _wl_block561 ="\">\n\t\t<input type=\"hidden\" name=\"ordering_practitioner\" id=\"ordering_practitioner\" value=\"";
    private final static byte[]  _wl_block561Bytes = _getBytes( _wl_block561 );

    private final static java.lang.String  _wl_block562 ="\">\n\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block562Bytes = _getBytes( _wl_block562 );

    private final static java.lang.String  _wl_block563 ="\">\n\t\t<!-- IN036387 Start -->\n\t\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block563Bytes = _getBytes( _wl_block563 );

    private final static java.lang.String  _wl_block564 ="\">\n\t\t<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block564Bytes = _getBytes( _wl_block564 );

    private final static java.lang.String  _wl_block565 ="\">\n\t\t<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block565Bytes = _getBytes( _wl_block565 );

    private final static java.lang.String  _wl_block566 ="\">\n\t\t<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block566Bytes = _getBytes( _wl_block566 );

    private final static java.lang.String  _wl_block567 ="\">\n\t\t<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block567Bytes = _getBytes( _wl_block567 );

    private final static java.lang.String  _wl_block568 ="\">\n\t\t<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block568Bytes = _getBytes( _wl_block568 );

    private final static java.lang.String  _wl_block569 ="\">\n\t\t<!-- IN036387 End. -->\n\t\t<input type=\"hidden\" name=\"p_task_code\" id=\"p_task_code\" value=\"";
    private final static byte[]  _wl_block569Bytes = _getBytes( _wl_block569 );

    private final static java.lang.String  _wl_block570 ="\">\n\t\t<input type=\"hidden\" name=\"p_task_srl_no\" id=\"p_task_srl_no\" value=\"";
    private final static byte[]  _wl_block570Bytes = _getBytes( _wl_block570 );

    private final static java.lang.String  _wl_block571 ="\">\n\t\t<input type=\"hidden\" name=\"primary_order_type\" id=\"primary_order_type\" value=\"\"> <!-- Used for Primary Order Type OT Ordercategory -->\n\t\t<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\"\">\n\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block571Bytes = _getBytes( _wl_block571 );

    private final static java.lang.String  _wl_block572 ="\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block572Bytes = _getBytes( _wl_block572 );

    private final static java.lang.String  _wl_block573 ="\">\n\t\t<input type=\"hidden\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block573Bytes = _getBytes( _wl_block573 );

    private final static java.lang.String  _wl_block574 ="\">\n\t\t<input type=\"hidden\" name=\"care_set_catalog_code\" id=\"care_set_catalog_code\" value=\"";
    private final static byte[]  _wl_block574Bytes = _getBytes( _wl_block574 );

    private final static java.lang.String  _wl_block575 ="\">\n\t\t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block575Bytes = _getBytes( _wl_block575 );

    private final static java.lang.String  _wl_block576 ="\">\n\t\t\t <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->\n\t\t<input type=\"hidden\" name=\"cosign_reqd_yn\" id=\"cosign_reqd_yn\" value=\"\"> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn=\'Y\' when nurse is logging in -->\n\t\t";
    private final static byte[]  _wl_block576Bytes = _getBytes( _wl_block576 );

    private final static java.lang.String  _wl_block577 ="\n\t\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"PREVIEW\"> <!-- For Order Format Line Level -->\n\t\t\t<input type=\"hidden\" name=\"record_from\" id=\"record_from\" value=\"PREVIEW\">\n\t\t";
    private final static byte[]  _wl_block577Bytes = _getBytes( _wl_block577 );

    private final static java.lang.String  _wl_block578 ="\n\t\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"ORDER_SET\"> <!-- For Order Format Line Level -->\n\t\t\t<input type=\"hidden\" name=\"record_from\" id=\"record_from\" value=\"ORDER_SET\">\n\t\t";
    private final static byte[]  _wl_block578Bytes = _getBytes( _wl_block578 );

    private final static java.lang.String  _wl_block579 ="\n\t";
    private final static byte[]  _wl_block579Bytes = _getBytes( _wl_block579 );

    private final static java.lang.String  _wl_block580 ="\t\n\t\t<input type=\"hidden\" name=\"validated_status\" id=\"validated_status\" value=\"validation_reqd\">\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block580Bytes = _getBytes( _wl_block580 );

    private final static java.lang.String  _wl_block581 ="\">\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block581Bytes = _getBytes( _wl_block581 );

    private final static java.lang.String  _wl_block582 ="\">\n\t\t<input type=\"hidden\" name=\"email_yn\" id=\"email_yn\" value=\"N\"><!-- For Email -->\n\t\t<input type=\"hidden\" name=\"appl_user_name\" id=\"appl_user_name\" value=\"";
    private final static byte[]  _wl_block582Bytes = _getBytes( _wl_block582 );

    private final static java.lang.String  _wl_block583 ="\"> \n\t\t <!-- For Order Set Billing Added by Uma 2/6/2009 -->\n\t\t<input type=\"hidden\" name=\"order_set_bill_yn\" id=\"order_set_bill_yn\" value=\"";
    private final static byte[]  _wl_block583Bytes = _getBytes( _wl_block583 );

    private final static java.lang.String  _wl_block584 ="\">\n\t\t<input type=\"hidden\" name=\"charge_yn\" id=\"charge_yn\" value=\"";
    private final static byte[]  _wl_block584Bytes = _getBytes( _wl_block584 );

    private final static java.lang.String  _wl_block585 ="\">\n\t\t<input type=\"hidden\" name=\"care_set_catalog_desc\" id=\"care_set_catalog_desc\" value=\"";
    private final static byte[]  _wl_block585Bytes = _getBytes( _wl_block585 );

    private final static java.lang.String  _wl_block586 ="\">\n\t\t<input type=\"hidden\" name=\"checkCount\" id=\"checkCount\" value=\"\">\n\t\t<!-- Added by Uma on 3/13/2010 for IN019490 -->\n\t\t<input type=\"hidden\" name=\"ref_facility_id\" id=\"ref_facility_id\" value=\"";
    private final static byte[]  _wl_block586Bytes = _getBytes( _wl_block586 );

    private final static java.lang.String  _wl_block587 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_date_time\" id=\"ref_date_time\" value=\"";
    private final static byte[]  _wl_block587Bytes = _getBytes( _wl_block587 );

    private final static java.lang.String  _wl_block588 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_pract_id\" id=\"ref_sent_pract_id\" value=\"";
    private final static byte[]  _wl_block588Bytes = _getBytes( _wl_block588 );

    private final static java.lang.String  _wl_block589 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_remarks\" id=\"ref_sent_remarks\" value=\"";
    private final static byte[]  _wl_block589Bytes = _getBytes( _wl_block589 );

    private final static java.lang.String  _wl_block590 ="\"><!--External Orders-->\n\t\t<!-- Ends Here by Uma on 3/13/2010 for IN019490 -->\n\t\t<input type=\"hidden\" name=\"show_bill_info_yn\" id=\"show_bill_info_yn\" value=\"";
    private final static byte[]  _wl_block590Bytes = _getBytes( _wl_block590 );

    private final static java.lang.String  _wl_block591 ="\"> <!-- added for IN035929[IN040092] -->\n\t\t<input type=\"hidden\" name=\"twicedupchkflg\" id=\"twicedupchkflg\" value=\"";
    private final static byte[]  _wl_block591Bytes = _getBytes( _wl_block591 );

    private final static java.lang.String  _wl_block592 ="\"> <!-- IN062607 -->\n\t\t<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block592Bytes = _getBytes( _wl_block592 );

    private final static java.lang.String  _wl_block593 ="\"><!--IN065942-->\n\t\t<input type=\"hidden\" name=\"orset_ind_flag\" id=\"orset_ind_flag\" value=\"";
    private final static byte[]  _wl_block593Bytes = _getBytes( _wl_block593 );

    private final static java.lang.String  _wl_block594 ="\"><!--IN067246-->\n\t\t<input type=\"hidden\" name=\"called_function\" id=\"called_function\" value=\"";
    private final static byte[]  _wl_block594Bytes = _getBytes( _wl_block594 );

    private final static java.lang.String  _wl_block595 ="\"><!--IN067246-->\n\t\t\n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"ORSET\"><!--IN066377-->  \n\t\t<input type=\"hidden\" name=\"bt_order_type_code\" id=\"bt_order_type_code\" value=\"";
    private final static byte[]  _wl_block595Bytes = _getBytes( _wl_block595 );

    private final static java.lang.String  _wl_block596 ="\"><!--IN066377-->\n\t\t<input type=\"hidden\" name=\"interactionDrugsCnt\" id=\"interactionDrugsCnt\"  id =\"interactionDrugsCnt\" value=\"";
    private final static byte[]  _wl_block596Bytes = _getBytes( _wl_block596 );

    private final static java.lang.String  _wl_block597 ="\" />\t<!-- IN071260 -->\n";
    private final static byte[]  _wl_block597Bytes = _getBytes( _wl_block597 );

    private final static java.lang.String  _wl_block598 ="\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n \t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n \t\t   \t<tr>\n \t\t \t\t<td width=\'100%\' id=\'t\'></td>\n \t\t\t</tr>\n \t\t</table>\n\t</div>\n</body>\n\t<script>\n\tskipAuthIndicator();//IN048467\n\tif(parent.legendsFrame)\n\t{\n\t\tif(parent.legendsFrame.document.getElementById(\"titleTab\")!=null) {\n\t\t\talignWidth();\n\t\t}\n\t}\n\telse\n\t{\n\t\talignPreviewWidth();\n\t}\n\t<!-- added for IN035929[IN040092] -->\n\tvar show_bill_info_yn = document.placeOrderForm.show_bill_info_yn.value; \n\tif(show_bill_info_yn==\'Y\') {\n\t\tshowBillingTable();\n\t}\t\n\t<!-- END for IN035929[IN040092] -->\n\t\n\t</script>\n\t<script>\n\t\tchkCount();\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block598Bytes = _getBytes( _wl_block598 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

try
{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String called_from="OH";
	String called_from="";
	String order_id					= "", order_line_no			= "";
	ExternalOrdersBean external_bean_obj= null;

	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String patient_email_id="";
	String existing_bean_id 		= "";
	String existing_bean_name="";
	String check="";
	String priority_value="";
	/*Added by Uma on 3/13/2010 for IN019490*/
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String patientDischargedYn      = "N";
	String instrn_content_type		= "T";//IN064543
	int drugintercnt = 0;//IN071260
	/*Ends Here*/

	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean	= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
   	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	//orderEntryRecordBean.setLanguageId(localeName);
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();	
	
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); //added for IN035929[IN040092]
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";

	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	 bean1.setLanguageId(localeName);
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String key						= (bean.getPatientId()+bean.getEncounterId());
	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	  // Unique key to keep the Value in the Bean
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
	String passed_from = request.getParameter("passed_from")==null?"":request.getParameter("passed_from");
	String time_frame = request.getParameter("time_frame")==null?"":request.getParameter("time_frame");
	String order_category="";
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
	String called_function = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	patientDischargedYn = (String)bean.getPatientDischarged();
	if(passed_from.equalsIgnoreCase("Rapid Preview"))
	{
		order_category			= request.getParameter("p_order_category")==null?"": request.getParameter("p_order_category");
	}
	else
	{
  		order_category			= request.getParameter("order_category")==null?"": request.getParameter("order_category");
	}
	
	String auth_reqd				= "X";
   	String lb_instal_yn				= bean.checkForNull(request.getParameter("lb_instal_yn"),"N");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN036387 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN036387 End.
	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String session_id				= bean.checkForNull(request.getParameter("session_id"),"");
	//order_category="CS";

	String l_patient_class = bean.getPatientClass();//IN065324

	if(function_from.equalsIgnoreCase("EXTERNAL_ORDER"))
	{
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";
		//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj		= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		/*Added by Uma on 3/13/2010 for IN019490*/
		ref_facility_id				= bean.checkForNull(external_bean_obj.getFacilityId(),"");
		ref_date_time				= bean.checkForNull(external_bean_obj.getReferral_date(),"");
		ref_sent_pract_id			= bean.checkForNull(external_bean_obj.getPractitionerId(),"");
		ref_sent_remarks			= bean.checkForNull(external_bean_obj.getRemarks(),"");
		/*Ends Here for IN019490*/
		//external_bean_obj.setLanguageId(localeName);
		// Bean instance is needed, if it is coming from the external orders, to default the order_category and the order_type_code
		called_from		= bean.checkForNull(external_bean_obj.getCalledFrom());
		if(called_from.equalsIgnoreCase("OH"))
	{
			called_from="OH";
	}else
	{
		called_from="";
	}
}
	
   	String order_catalog_code 		= bean.checkForNull(bean.getOrderCatalogCode(previousValues,order_category,practitioner_type),"");//IN042045
	String order_type_catalog 		= "";
	String order_type_catalog_sort = "";//IN058388-IN058669
	String specialty_code			= "";
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	//bean.getOrderTypeCatalog(previousValues);
	String classValue				= "", chk_class_value = "";
	//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
	//java.util.Date date_time	 	= new java.util.Date();
	//String dateString 			 	= dtSystemFormat.format(date_time);
	String dateString 				= bean.getSysDate();
	ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
	ArrayList PlaceOrderSetItems 	= null;
	ArrayList PlaceOrderItems 		= null;
	ArrayList drugclass				= null;
	ArrayList arrDrugDtls			= null;
	String order_types_comb			= "";  // Get the order_type for the individual category -- to get format id
	int count						= 0;
	int display_auth_count			= 0, format_mandatory_count = 0;
	int format_count 				= 0;//age_in_days					= 0;
	String frequency_val			= "",  qty_value = "";//preps_instrn 			= "",
	String duration_value			= "",  qty_uom	 = "",qty_uom_shortdesc="";//preps_dept_instrn		= "",
	String max_durn_value			= "";//pat_preps_instrn			= "",
	String chk_for_max_durn_action = "";//sex_yn					= "",
	String format_id				= "", prompt_msg			= "";
	String format_id_mandatory_yn	= "N", facility_name		= "";
	String order_set_order_catalog	= "";
	String sec_start_date_time		= "";
	String drug_class				= "";
	String performing_dept_loc_code = "", performing_dept_loc_desc = "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;  String[] frequencyRecords = null;
	String[] care_set_count 		= null;  //String[] durationRecords  = null;
	String[] care_set_group			= null;  String[] deptLocation	   = null;
	String[] deptLocation1			= null;  String[] orderTypeRecords = null;
	String[] reqd_or_opt_ind		= null; // To store the value required/optional/deselected
	String[] rel_start_date_time	= null; // To store the start_date_time
	String[] start_time				= null; // To store the hours(So that it can be used when the header is changed )
	String[] records				= null;
	String[] records1				= null;
	String[] secondaryOrders		= null;
	ArrayList performingLocationCode =new ArrayList();
	String performingLocation[] =null;
	//IN062607 Starts
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	boolean l_show_order_set_bill_dtls = false;//IN065324
	String perfLocnMandFlag = "";//IN066377
	String bt_order_type_code = "";//IN066377
	int non_billing_numbering =0;//IN068314
	try
	{
		con				=	ConnectionManager.getConnection(request);
		dup_custSpecificFlg = CommonBean.isSiteSpecific(con, "OR","TWICE_DUPLICATE_ALERT");
		if(dup_custSpecificFlg)
			dupchk_siteSpecFlag ="Y";
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);

	}
	
	ArrayList PlaceOrderType		= null; ArrayList PlaceOrderFrequency = null;
	String rd_install_yn			= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N";
	String checkedField				= "";
	String disableField				= "";
	String check_box_value			= "N";
	int t							= 0;
	StringTokenizer stFormat		= null;

	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	HashMap instructionsMap = new HashMap();
	Object patprepsinstrns      = "IS";
	if(passed_from.equalsIgnoreCase("Rapid Preview"))
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
		/* For Order Set Billing Added by Uma 2/6/2009*/
		String billing_order_set_details[] = bean.getOrderSetBillDetails(order_catalog_code);
		String order_set_bill_yn = bean.checkForNull(billing_order_set_details[1],"N");
		String care_set_catalog_desc = bean.checkForNull(billing_order_set_details[0],"");
		String charge_yn = bean.checkForNull(billing_order_set_details[2],"");
		String order_set_fpp_yn = bean.checkForNull(billing_order_set_details[3],"");//IN072524
		String order_set_fpp_category=bean.checkForNull(billing_order_set_details[4],"");//IN072524
		if(charge_yn.equalsIgnoreCase("N"))
		{
			order_set_bill_yn = "N";
		}
		/* ends*/


		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block19Bytes, _wl_block19);


		//IN065324, starts
		if(is_bt_view_bill_dtls && "BT".equals(order_category) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(order_category))
		{
			l_show_order_set_bill_dtls = true;
		}
		//IN065324, ends

		//if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !order_category.equals("BT"))//IN065324
		if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && l_show_order_set_bill_dtls)//IN065324
		{
			int numbering=0;
			//String displaytooltip="";
			//IN072524 Starts
			if("Y".equals(order_set_fpp_yn)){
				BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),order_set_fpp_yn,order_set_fpp_category) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			}else{
				BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
			}
			//IN072524 Ends
			if(BillChargeInfo==null) 
				BillChargeInfo= new ArrayList();
			billing_details = null;
			for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
			{
				billing_details 	= (String[])BillChargeInfo.get(m);
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
				setBills_dtls.put("rate"		 , "");
				setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
				setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
				setBills_dtls.put("fpp_yn"		 , order_set_fpp_yn);//IN072524
				setBills_dtls.put("fpp_category"		 , order_set_fpp_category);//IN072524
				//servicepanel=bean.checkForNull(billing_details[10],"");
				//servicepanelcode=bean.checkForNull(billing_details[11],"");
				orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code, setBills_dtls); 
				 if(!billing_details[9].equals(""))
				{
					numbering=1;
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
				}
				if(billing_details[10].equals("")||billing_details[11].equals(""))
				{
							numbering=1;
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
					}
				}
				if(numbering==1 && order_set_bill_yn.equalsIgnoreCase("Y") && charge_yn.equalsIgnoreCase("Y"))
				{	
				
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
				bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code);
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

							if("Y".equals(order_set_fpp_yn))
							{	
							
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_set_fpp_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf("S".equals(order_set_fpp_category)?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf("M".equals(order_set_fpp_category)?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("C".equals(order_set_fpp_category)?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block57Bytes, _wl_block57);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block62Bytes, _wl_block62);

							}
							
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

		}


		// New Orders, Painting	 of the Care Sets
		if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
		{
			for(t=0; t<PlaceOrdercareSetCount.size(); t++)
			{
				String billinginterface="";
				String servicepanel="";
				String servicepanelcode="";
				String finbill="";
				String displaytooltip="";
				String speciality_code[]=new String[3];
				ArrayList speciality=new ArrayList();
				String displays_style1="visibility:hidden";
				String displays_style2="visibility:hidden";
				String displays_style3="visibility:hidden";
				String displays_style4="visibility:hidden";
				String comment 			  = "";
				String pat_preps_instrns ="";
				String pat_preps_pat_instrns="";
				String pat_preps_dep_instrns="";
				String def_duration = "";
				
			    int numbering=0;
				format_id_mandatory_yn = "N";
				care_set_count = (String[])PlaceOrdercareSetCount.get(t);		// To get the order_category, category description and count
				String forceStatus=bean.getForceStatus(practitioner_type,care_set_count[1]);
				String fStatus[]=forceStatus.split(":");
				// Get the auth Reqd Yn
				//auth_reqd = bean.getAccessReqd(care_set_count[1],"auth_yn");	// Column Name. auth_yn is passed
				//if(fStatus[0].equals("Y"))
				//auth_reqd="X";
	
				// Pass the order_category and the order_types for the order_category to get the format_id
				order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");  // Order Types Combination for the order_category
				// Get the Format Id for the Header
				format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
 
				if(!format_id.trim().equals("") )
				{
					stFormat = new StringTokenizer(format_id,"~");
					while(stFormat.hasMoreTokens())
 					{
 						format_id_mandatory_yn	 	= stFormat.nextToken();
 						format_id 	 	 			= stFormat.nextToken();
 					}
					stFormat = null;
 				}
 				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
 					out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='N'>");
 				else
 					out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='Y'>");
					// Second Query where u will get all the order_type_code and order_catalog_code
		
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(t));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(t));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(format_id_mandatory_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(t));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(t));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(care_set_count[1]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(t));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(t));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(t));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(t));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
		 
				if(!format_id.equals("")) {

            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(care_set_count[1]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(t));
            _bw.write(_wl_block81Bytes, _wl_block81);
					if(format_id_mandatory_yn.equals("Y"))
						out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
					else
						out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
 						//out.println("<input type='hidden' name='format_id_yn"+t+"' id='format_id_yn"+t+"' value='"+format_id_mandatory_yn+"'>");
				}

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(care_set_count[2]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(t));
            _bw.write(_wl_block84Bytes, _wl_block84);
if(!auth_reqd.equalsIgnoreCase("X")){displays_style3="visibility:visible";displays_style4="visibility:hidden";}else{displays_style4="visibility:visible";displays_style3="visibility:hidden";}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(displays_style3));
            _bw.write(_wl_block86Bytes, _wl_block86);
	out.println("&nbsp;");
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(displays_style4));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(t));
            _bw.write(_wl_block90Bytes, _wl_block90);
if(!auth_reqd.equalsIgnoreCase("X")){	displays_style1="visibility:visible";displays_style2="visibility:hidden";}else{displays_style1="visibility:hidden";displays_style2="visibility:visible";}	
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(displays_style2));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(auth_reqd));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(displays_style1));
            _bw.write(_wl_block86Bytes, _wl_block86);
out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(auth_reqd));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(t));
            _bw.write(_wl_block90Bytes, _wl_block90);
out.println("<img id=\"textimg"+count+"\" src=\"../../eOR/images/Authorization.gif\" align=\"left\">");
            _bw.write(_wl_block98Bytes, _wl_block98);

		int total_recs = 0;	//IN071260
				//IN063686 starts
				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
				//IN063686 ends
				//System.err.println("PlaceOrderSetItems==========="+PlaceOrderSetItems);
				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
				rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
				start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time

				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
				{
					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
					order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
				    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					order_type_catalog_sort = order_type_catalog_sort+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"',"+ (k+1) + ",";//IN058388-IN058669
				    reqd_or_opt_ind[k]		= care_set_group[5];
				    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
				    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
				}
				if(order_set_order_catalog.length() > 0)
					order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
				if(order_type_catalog.length() > 0)
					order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
				if(order_type_catalog_sort.length() > 0) //IN058388-IN058669
					order_type_catalog_sort = order_type_catalog_sort.substring(0, order_type_catalog_sort.length()-1);//IN058388-IN058669
				//IN063561 starts
				if(order_type_catalog_sort.length() == 0)
					order_type_catalog_sort = "'',''";
				//IN063561 ends


				//PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview //commented for IN058388-IN058669
				PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"",order_type_catalog_sort); // Last parameter to identify normalOE or from preview  //IN058388-IN058669(last parameter to order the catalog)
				// New Orders, Painting	 of the Care Sets

				//System.err.println("PlaceOrderItems=============="+PlaceOrderItems);

				if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
				{
					for(int i=0; i<PlaceOrderItems.size(); i++)
					{	
						String locn_appt_reqd_yn="";
						records		= (String[])PlaceOrderItems.get(i);
						records1	= (String[])PlaceOrderItems.get(i);
						instrn_content_type = records[73];//IN064543
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
						//if(fStatus[0].equals("Y"))
						//records[48]="Y";
						if(fStatus[1].equals("Y"))
						records[49]="Y";
						if(records[51].equalsIgnoreCase("Y"))
							chk_class_value = "eORConsent" ;

						// Get the Values to be Defaulted, Putting into the string array to be retrieved later		

						Default = bean.getPlaceOrderSetDefault(records[0],order_catalog_code);
						for(int j=0;j<Default.size();j++)
						{
							recordDefault	 = ((String[])Default.get(j));					
							if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
							if(recordDefault!=null){
								qty_value	 = 	bean.checkForNull(recordDefault[8],"1");
								if(qty_value.equals("0")) qty_value = "1";
								qty_uom		 =  bean.checkForNull(recordDefault[9],"");
								qty_uom_shortdesc =  bean.checkForNull(recordDefault[10],"");
							}else{
								qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
							}
						}
						// Till Here

            _bw.write(_wl_block99Bytes, _wl_block99);

				checkedField= "";disableField="";check_box_value="N";
				if(reqd_or_opt_ind[i].equalsIgnoreCase("R"))
				{
					check_box_value = "Y";
					checkedField 	= "CHECKED";
					disableField	= "DISABLED";
				}
				else if(reqd_or_opt_ind[i].equalsIgnoreCase("O"))
				{
					check_box_value = "Y";
					checkedField 	= "CHECKED";
					disableField	= "";
				}
				else if(reqd_or_opt_ind[i].equalsIgnoreCase("D"))
				{
					check_box_value = "N";
					checkedField 	= "";
					disableField	= "";
				}
				String EnableEmail="N";		
				String data[] = null;
				//String data[] = bean.getEmailDataDetails((String)bean.getLoginFacilityId());Commented Email part as told by Rajan
				if(data!=null && data.length>0)
				{
					patient_email_id=bean.checkForNull(data[1],"");
				}				
				arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+records[0],records[0]);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
				  		pat_preps_pat_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
				  		pat_preps_dep_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(2),""); // dep instrns
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
						pat_pat_preps_instrns 		= bean.checkForNull(bean.getPrepsInstructions(records[0],age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
					{
						//pat_pat_preps_instrns 		= bean.checkForNull(bean.getPreps(records[0],"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 			= bean.getPreps(records[0]);  // For Patient Preps. Insructions.					
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(patprepsinstrns),"");  // For Patient Preps. Insructions.
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
					
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(EnableEmail));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(chk_class_value));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(check_box_value));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(checkedField));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(disableField));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[4]));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(count));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(count));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(rel_start_date_time[i],"DMYHM","en",localeName)));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(count));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(count));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(count));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(start_time[i]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block2Bytes, _wl_block2);

			speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);
			if(speciality.size()>0)
			{
				for(int sc=0;sc<speciality.size();sc++)
				{
						speciality_code=(String[])speciality.get(sc);
				}
			}
			if(speciality_code[0].equalsIgnoreCase("Y"))
			{
				if(records[48].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")||speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required	 validateDateWithTime(this)
				{
					records[48]="Y";
				    display_auth_count++;

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(count));
            _bw.write(_wl_block128Bytes, _wl_block128);
			}	
			}
			else
			{
					if(records[48].equalsIgnoreCase("Y")||fStatus[0].equalsIgnoreCase("Y")) // For Authorization Required	 validateDateWithTime(this)
					{
						records[48]="Y";
						display_auth_count++;

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(count));
            _bw.write(_wl_block129Bytes, _wl_block129);
				}	
				}
				

            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(count));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(count));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(count));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(count));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(count));
            _bw.write(_wl_block137Bytes, _wl_block137);
				    PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(records[4].equals(orderTypeRecords[0]))
							out.println("<option value=\""+orderTypeRecords[0]+"\" selected> "+orderTypeRecords[1]+" </option>");
						else
							out.println("<option value=\""+orderTypeRecords[0]+"\"> "+orderTypeRecords[1]+" </option>");
					}

            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(count));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(count));
            _bw.write(_wl_block140Bytes, _wl_block140);
if(!passed_from.equalsIgnoreCase("Rapid Preview"))
				{
					
				
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(count));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(count));
            _bw.write(_wl_block146Bytes, _wl_block146);
if ( !((records[52]).equals("3"))) {
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}
					  if (((records[52]).equals("")) || ((records[52]).equals("2")) ) {
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}
					if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
}
            _bw.write(_wl_block151Bytes, _wl_block151);
}else{
            _bw.write(_wl_block152Bytes, _wl_block152);

				if ( !((records[52]).equals("3")) && priority_value.equals("")) { 
					priority_value = "R";
				} else if (priority_value.equals("") && ( ((records[52]).equals("")) || ((records[52]).equals("2"))) ) {  
					priority_value = "U";
				} else if(priority_value.equals("") && (((records[52]).equals("")) || ((records[52]).equals("3"))) ) {
					priority_value = "S";
				} else priority_value  = "R";
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(count));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(priority_value));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(count));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[52]));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(i));
            _bw.write(_wl_block158Bytes, _wl_block158);
				if ( priority_value.equalsIgnoreCase("R")) { 
            _bw.write(_wl_block159Bytes, _wl_block159);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block107Bytes, _wl_block107);
} 
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
				} else if(priority_value.equalsIgnoreCase("U")) { 
            _bw.write(_wl_block163Bytes, _wl_block163);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
} 
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
				} else if(priority_value.equalsIgnoreCase("S")) { 
            _bw.write(_wl_block165Bytes, _wl_block165);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
} 
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);
				}   
            _bw.write(_wl_block167Bytes, _wl_block167);
}
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(count));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(count));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(count));
            _bw.write(_wl_block173Bytes, _wl_block173);
 if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); 
            _bw.write(_wl_block174Bytes, _wl_block174);
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
					
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block176Bytes, _wl_block176);

				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
				
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(count));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(count));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(count));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

					PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","",care_set_count[1],records[4],recordDefault[0]); //Pass the order_category and catalog_code
					
						for(int j=0; j<PlaceOrderFrequency.size(); j++)
						{							
							frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
							if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
							{
								out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
								frequency_val = frequencyRecords[2];
							}
							else
							{
								if(recordDefault != null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2]))
								{
									out.println("<option value=\""+frequencyRecords[0]+"\" SELECTED> "+frequencyRecords[1]+" </option>");
									frequency_val = recordDefault[0];
								}
								else
								{
									out.println("<option value=\""+frequencyRecords[0]+"\"> "+frequencyRecords[1]+" </option>");
									frequency_val = "";
								}
							}	
						}
					
            _bw.write(_wl_block182Bytes, _wl_block182);
 					//if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
				}
				else
				{
				
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(count));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(count));
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

				}
				
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(count));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(frequency_val));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(count));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(count));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(count));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(count));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(count));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(count));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(count));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(count));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block196Bytes, _wl_block196);

					if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
					{
						duration_value = "90";
					}
					else
					{
						if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
						if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
						if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
						if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					}

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(count));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(prompt_msg));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(count));
            _bw.write(_wl_block202Bytes, _wl_block202);
if(recordDefault!=null && recordDefault[0].equals("")) out.println("readOnly");
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(count));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(count));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(count));
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

					if(care_set_count[1].equals("PH") && records[4].equals("MS")&& recordDefault[0].equals(""))
					{
						def_duration = "D";

            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

					}
					else
					{
						def_duration = "";
					}

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(count));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(def_duration));
            _bw.write(_wl_block214Bytes, _wl_block214);

			format_id = bean.checkForNull(records[47],"");
			format_id_mandatory_yn = "N";
			if(!records[47].trim().equals(""))
			{
	     		StringTokenizer stFormatID 	= new StringTokenizer(records[47],"~");
	     		while(stFormatID.hasMoreTokens())
	     		{
	     			format_id_mandatory_yn  = stFormatID.nextToken();
	     			format_id 				= stFormatID.nextToken();
	     		}
				stFormatID	= null;
	 		}

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(count));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(count));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(format_id_mandatory_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(count));
            _bw.write(_wl_block221Bytes, _wl_block221);
	  //added for multiconsent
			      if(records[51].equalsIgnoreCase("Y"))
				{
				
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(count));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(count));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block226Bytes, _wl_block226);
	
		
					ArrayList multiConsentList = new ArrayList();
					String[] multiConsentValues = null;
					String[] multiConsentDtls = null;
					boolean consentflag = false;
					multiConsentDtls		= bean1.MultiListDtls(records[0],practitioner_id);
					multiConsentList		= bean1.MultiListConsentsdtl(records[0],order_id,order_line_no, practitioner_id);
					if(multiConsentList==null || multiConsentList.size()==0)
					{
						multiConsentList		= bean1.MultiListConsents(records[0],order_id,order_line_no,practitioner_id);
					}
		
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
										
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(count));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(count));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(count));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(count));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block232Bytes, _wl_block232);

										total_recs++;
										consentflag = false;
									}		
								}
							}							
							
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(count));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(count));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block237Bytes, _wl_block237);

						}
						else
						{
							if(multiConsentDtls[0].equals("F"))
							{	
								if(!bean.checkForNull(multiConsentDtls[3]).equals(""))
								{
									total_recs = total_recs++;
								}
								
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(count));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(count));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(count));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(count));
            _bw.write(_wl_block243Bytes, _wl_block243);

							}
							
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(count));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(count));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block237Bytes, _wl_block237);

						}
						
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(count));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block246Bytes, _wl_block246);

					}
				}		
				
				secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class
				if (bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
				    sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties,records[0],"R",bean.getPatientClass()),""); // Pass the catalog_code,priority default as "R" and patient_class
					sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);


            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(count));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(sec_start_date_time));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block250Bytes, _wl_block250);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

				if(!format_id.equals(""))  // check for the Format
				{
			//		arrSeqNo = (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(records[0], records[0]+"_"+count);
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean

            _bw.write(_wl_block251Bytes, _wl_block251);
            _bw.write(_wl_block2Bytes, _wl_block2);
			/*			if(arrSeqNo!=null && arrSeqNo.size()>0) // if it is not from the bean
						{
							out.println("<script>setOrderFormatLine('"+count+"','Y')</script>");
						}
						else
						{
			 	    		out.println("<script>setOrderFormatLine('"+count+"','N')</script>");
						}
			*/
						format_mandatory_count++;
					}
					else
					{

            _bw.write(_wl_block251Bytes, _wl_block251);
            _bw.write(_wl_block2Bytes, _wl_block2);
		 	//    		out.println("<script>setOrderFormatLine('"+count+"','Y')</script>");
		 	    		format_count++;
		 	   		} // else of format_id_mandatory_yn
			   	}

            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(count));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(secondaryOrders[1]));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(count));
            _bw.write(_wl_block256Bytes, _wl_block256);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(count));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(count));
            _bw.write(_wl_block259Bytes, _wl_block259);

				if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
				{
					out.println("<script>calculateEndDateTime('"+rel_start_date_time[i]+"','D','90',"+count+",'');</script>");
				}

            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(count));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(count));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block264Bytes, _wl_block264);
	
					//if( (care_set_count[1].equals("LB") && lb_instal_yn.equals("Y")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || !care_set_count[1].equals("NC")  ) { changed on 7/9/2007 for lb_instal_yn by uma
					if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) {
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
				} 
				
				//if( (care_set_count[1].equals("LB") && lb_instal_yn.equals("Y")) || (care_set_count[1].equals("RD") && rd_install_yn.equals("Y")) || (!care_set_count[1].equals("NC") && !care_set_count[1].equals("PH")) ) {changed on 7/9/2007 for lb_instal_yn by uma
				if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) 
				{
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(count));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(count));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(care_set_count[1]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(rd_install_yn));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block271Bytes, _wl_block271);
					
						performingLocationCode = bean.getPerformingLocation(care_set_count[1],orderTypeRecords[0],records[0]);
						if(bean.getTempvalue("performing_facility_id"+records[0])==null)
						{
							for(int j=0; j<performingLocationCode.size(); j++)
							{
								performingLocation	= (String[]) performingLocationCode.get(j);	
								if(performingLocation[0].equals(records[5])) //let the last one be selected 
								{
									out.println("<option value=\""+performingLocation[0]+"\" selected> "+performingLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+performingLocation[0]+"\" > "+performingLocation[1]+" </option>");
								}
							}
						}
						else
						{
							for(int j=0; j<performingLocationCode.size(); j++)
							{
								performingLocation	= (String[]) performingLocationCode.get(j);			
								if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
								{
									out.println("<option value=\""+performingLocation[0]+"\" selected> "+performingLocation[1]+" </option>");
								}
								else
								{
									out.println("<option value=\""+performingLocation[0]+"\" > "+performingLocation[1]+" </option>");
								}
							}
						}				
				
            _bw.write(_wl_block272Bytes, _wl_block272);

				}
				else
				{
					
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);
				
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
					
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(count));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block176Bytes, _wl_block176);

				}
				if((care_set_count[1].equals("LB") )|| (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX"))||(care_set_count[1].equals("TR")) ||(care_set_count[1].equals("MI"))||(care_set_count[1].equals("PC"))) 
				{ 		
				
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(count));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(count));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(count));
            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

						//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],lb_instal_yn,rd_install_yn);changed on 7/9/2007 for lb_instal_yn by uma 
						ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],orderTypeRecords[0],rd_install_yn);
					
						for(int j=0; j<DeptLocationCode.size(); j++)
						{
							deptLocation	= (String[]) DeptLocationCode.get(j);
							if(deptLocation[2] != null && deptLocation[2].equals("Y"))  // default_yn
							{
								out.println("<option value=\""+deptLocation[0]+"\" SELECTED> "+deptLocation[1]+" </option>");
								locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],deptLocation[0]);
								
							}
							else 
							{
								out.println("<option value=\""+deptLocation[0]+"\"> "+deptLocation[1]+" </option>");
							}

						}
 						if(DeptLocationCode!=null) {
							DeptLocationCode.clear();
							DeptLocationCode	= null;
						}

            _bw.write(_wl_block281Bytes, _wl_block281);
				} else if(care_set_count[1].equals("PH")){
						
						drugclass						= beanQueryObj.getDrugDetails(properties, records1[0]);
   						for(int k=0; k<drugclass.size(); k++)  // Only one record
						{
							records1					= (String[]) drugclass.get(k);
							drug_class					= records1[13] ;
						}
						facility_name = bean.getPerformingFacilityName(records[5]);	  
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(count));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(count));
            _bw.write(_wl_block284Bytes, _wl_block284);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

						ArrayList DeptLocCode1 = bean.getPerformDeptLocation1(records[5], records[0],records[52],records[4],drug_class);
						for(int j=0; j<DeptLocCode1.size(); j++)
						{
							deptLocation1	= (String[]) DeptLocCode1.get(j);
				 			// Should be handled in PH, since not handled, done here
							if(deptLocation1[0]!=null && deptLocation1[0].indexOf("|")!=-1){
								performing_dept_loc_code = deptLocation1[0].substring(0,deptLocation1[0].indexOf("|"));
							}
							else
								performing_dept_loc_code = deptLocation1[0];
							if(deptLocation1[1]!=null &&  deptLocation1[1].indexOf("|")!= -1){
								performing_dept_loc_desc = deptLocation1[1].substring(0,deptLocation1[1].indexOf("|"));
							}
							else
								performing_dept_loc_desc = deptLocation1[1];
							// Till here

							out.println("<option value=\""+performing_dept_loc_code+"\" SELECTED> "+performing_dept_loc_desc+" </option>");
						}
						if(DeptLocCode1!=null) {
							DeptLocCode1.clear();
							DeptLocCode1	= null;
						}
				}else { 
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(count));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(count));
            _bw.write(_wl_block286Bytes, _wl_block286);
				}


				
            _bw.write(_wl_block287Bytes, _wl_block287);
	//IN066377 start
						try
						{
							con				=	ConnectionManager.getConnection(request);
							String sql = "select * from or_order_perf_locn_mand where order_category=?";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,care_set_count[1]);
							rs = pstmt.executeQuery();
							if(rs.next()){
								perfLocnMandFlag = bean.checkForNull(rs.getString(l_patient_class),"N");
								//IN070295 Start.
								
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(count));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(perfLocnMandFlag));
            _bw.write(_wl_block290Bytes, _wl_block290);

								//IN070295 End.
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
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						finally
						{
							if(con!=null) 
								ConnectionManager.returnConnection(con,request);
						}
						//IN066377 end
					
            _bw.write(_wl_block291Bytes, _wl_block291);

					//for RADIOLOGY
					 if(("RD".equals(care_set_count[1])) && ("Y".equals(rd_install_yn))){ 
							if("Y".equals(perfLocnMandFlag)){
            _bw.write(_wl_block292Bytes, _wl_block292);
}
						}						
						//EXCEPT RADIOLOGY
						String cat_type_code = records[4];	
						if((!"RD".equals(care_set_count[1])) && ("Y".equals(perfLocnMandFlag)) && !(cat_type_code.equals(bt_order_type_code))){
            _bw.write(_wl_block293Bytes, _wl_block293);
}
						
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(count));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block296Bytes, _wl_block296);
				
				
				boolean show_bill_dtls = false;//IN065324
				
				//IN065324, starts
				if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && ("OP".equals(l_patient_class) || "EM".equals(l_patient_class)) || !"BT".equals(records[43].trim()))
				{
					show_bill_dtls = true;
				}
				//IN065324, ends
				

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN68314 Starts
					//BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],rel_start_date_time[i], localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					if("Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],records[75]) ;
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],rel_start_date_time[i], localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN68314 Ends
					if(BillChargeInfo!=null)
					{
						
						for( int k=0 ; k< BillChargeInfo.size() ; k++ ) {
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
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);//IN068314
							setBills_dtls.put("fpp_category"		 , records[75]);//IN068314
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");	orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							 if(!billing_details[9].equals(""))
							{numbering=1;finbill="Billing";
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(count));
            _bw.write(_wl_block300Bytes, _wl_block300);
 displaytooltip=billing_details[9];
						  	} 
							if(billing_details[10].equals("")||billing_details[11].equals(""))
							{
								numbering=1;
							
								
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(count));
            _bw.write(_wl_block303Bytes, _wl_block303);
 
								displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							}
						}
					}
					if(numbering==1 && (order_set_bill_yn.equalsIgnoreCase("N"))&&(charge_yn.equalsIgnoreCase("Y")))
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
				

						
						//}
					//}
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
							

            _bw.write(_wl_block304Bytes, _wl_block304);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block305Bytes, _wl_block305);

							if("Y".equals(records[74]))
							{	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(records[74]));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf("S".equals(records[75])?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf("M".equals(records[75])?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("C".equals(records[75])?"selected":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{ 
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block309Bytes, _wl_block309);
} 
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

							}
							
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(count));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf((((bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"N").equalsIgnoreCase("Y"))&&((bean.checkForNull(records[33],"N").equalsIgnoreCase("Y"))))?"visible":"hidden")));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(count));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(count));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf((((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(count));
            _bw.write(_wl_block321Bytes, _wl_block321);
if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){
            _bw.write(_wl_block322Bytes, _wl_block322);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block323Bytes, _wl_block323);
}
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block57Bytes, _wl_block57);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block57Bytes, _wl_block57);

							}
							
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(count));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(count));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(count));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(billing_details[18]));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(count));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(billing_details[19]));
            _bw.write(_wl_block333Bytes, _wl_block333);
				} else{ billing_call_yn = "N";
						out.println("&nbsp;");
				}


            _bw.write(_wl_block334Bytes, _wl_block334);
if(numbering==0)
					{
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block336Bytes, _wl_block336);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block337Bytes, _wl_block337);

				
				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT")&& order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && order_set_bill_yn.equals("N")&&charge_yn.equalsIgnoreCase("Y") && show_bill_dtls)//IN065324
				{
					//billing_call_yn		= "Y";
					//if(numbering==0)
					//{

            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(count));
            _bw.write(_wl_block339Bytes, _wl_block339);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(count));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block342Bytes, _wl_block342);

					} 
					else 
						billing_call_yn = "N"; 
					
            _bw.write(_wl_block343Bytes, _wl_block343);

					}
					else
					{
					
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(count));
            _bw.write(_wl_block345Bytes, _wl_block345);

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
						
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(count));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(count));
            _bw.write(_wl_block350Bytes, _wl_block350);
 		
								displaytooltip=bean.getMessage(localeName,"PRIV_ORDER_AUTH_RIGHTS","OR");
								displaytooltip=displaytooltip.replace("{1}",records[0]);
							//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
						}
					}
					if(records[69].equalsIgnoreCase("N"))
					{
						numbering=1;		
						non_billing_numbering=1;//IN068314
						billinginterface = "operational_interface";
						
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(count));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(count));
            _bw.write(_wl_block355Bytes, _wl_block355);
 		
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
					/*Ends Here*/
					//ININ071260 Starts
					HashMap<String, String> interactionYN = null;
					String checkUncheck =null;
					HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
					if("LB".equals(care_set_count[1])){
							System.out.println("order_catalog_code===>"+order_catalog_code+"---"+records[0]);
							bean.chkDrugInteractionForLB(records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
							interactionYN=bean.getDruginteractionYN();
							interdrugDtls = bean.getDruginteractionDtl();
							if(null!=interdrugDtls)
								drugintercnt =	interdrugDtls.size();
							checkUncheck =	interactionYN.get(records[0]);
						if("R".equals(checkUncheck)){
						
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block357Bytes, _wl_block357);
}
						
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(drugintercnt));
            _bw.write(_wl_block359Bytes, _wl_block359);
 }//IN071260 ENDS	
            _bw.write(_wl_block360Bytes, _wl_block360);

					if(bean.checkForNull(records[66],"N").equalsIgnoreCase("N"))
					{
						records[66] = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, care_set_count[1]),"N");
					}
					if(charge_yn.equalsIgnoreCase("N"))
					{
						if(billing_call_yn.equals("Y"))
							billing_call_yn = "N";
					}
					
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(count));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[2]));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(count));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[11]));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(count));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[14]));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(count));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(count));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[20]));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(count));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[22]));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(count));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[23]));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(count));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[24]));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(count));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[25]));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(count));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[26]));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(count));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[27]));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(count));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[28]));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(count));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[29]));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(count));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[33]));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(count));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(locn_appt_reqd_yn));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(count));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[34]));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(count));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[35]));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(count));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[37]));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(count));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[38]));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(count));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(billing_call_yn));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(count));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[39]));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(count));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[40]));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(count));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[41]));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(count));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[43]));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(count));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[44]));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(count));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[48]));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(count));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[49]));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(count));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[50]));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(count));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[51]));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(count));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[53]));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(count));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[54]));
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(count));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[55]));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(count));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[56]));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(count));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[57]));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(count));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[58]));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(count));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[59]));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(count));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[60]));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(count));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[61]));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(count));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[64]));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(count));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[65]));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(count));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(billinginterface));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(count));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(servicepanel));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(count));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(servicepanelcode));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(count));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(numbering));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(count));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(finbill));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(count));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull(records[66],"N")));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(count));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(count));
            _bw.write(_wl_block454Bytes, _wl_block454);
if(speciality_code[0].equalsIgnoreCase("Y"))
					{
				
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(count));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(speciality_code[1]));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(count));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(speciality_code[2]));
            _bw.write(_wl_block176Bytes, _wl_block176);

					}else
					{
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(count));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(count));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(count));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull(records[67],"N")));
            _bw.write(_wl_block176Bytes, _wl_block176);
}
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(count));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(care_set_count[1]));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(count));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(billing_call_yn));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(count));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(count));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(count));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(count));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(count));
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(count));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(count));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(count));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(count));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(count));
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(count));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(count));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(count));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(count));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(count));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(count));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(count));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(count));
            _bw.write(_wl_block482Bytes, _wl_block482);
if(numbering==1){
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(displaytooltip));
            _bw.write(_wl_block485Bytes, _wl_block485);
}else{
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull(records[62],"")));
            _bw.write(_wl_block487Bytes, _wl_block487);
}
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(count));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.checkForNull(records[63],"")));
            _bw.write(_wl_block490Bytes, _wl_block490);
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(count));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[70]));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(count));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[72]));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(count));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(count));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(bean.checkForNull(records[73],"T")));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(count));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(count));
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(non_billing_numbering ));
            _bw.write(_wl_block501Bytes, _wl_block501);
			// If it is only Pharmacy Category
			if(records[3].equals("PH")) { 
				// Pharmacy Order Set Related
				
				String form_code				= "", form_desc					= "";
				String route_code				= ""; //route_desc				= "";
				String strength_value			= "", dosage_type				= "";
				//String ori_dosage_type			= "";
				String pres_base_uom				= "";
				String dosage_legend			= "", dosage_option				= "";
				String strength_uom_desc		= "", strength_per_pres_uom		= "";
				String strength_per_value_pres_uom="", fract_dose_round_up_yn	= "";
				String content_in_pres_base_uom	= "", prn_doses_pres_prd_fill	= "";
				String dosage					= "", stock_uom					= "";//,drug_class="" ;
				String[] dosageRecords			= null; String[] routeDetails	= null;
				String[] uomDetails				= null;
				String[] ph_records				= null;
				ArrayList RouteCode				= null; ArrayList UOMDtls		= null;
				// Till here
				arrDrugDtls						= beanQueryObj.getDrugDetails(properties, records[0]);
				for(int j=0; j<arrDrugDtls.size(); j++)  // Only one record
				{
						ph_records						= (String[]) arrDrugDtls.get(j);
						form_code					= ph_records[2] ; 
						form_desc					= ph_records[3] ; 
						route_code					= ph_records[4] ;
						//route_desc					= records[5] ; 
						strength_value				= ph_records[6] ; 
						strength_uom_desc			= ph_records[7] ; 
						pres_base_uom				= ph_records[8] ; 
					//	drug_class					=records[13] ;


						strength_per_pres_uom		= ph_records[14] ;
						strength_per_value_pres_uom = ph_records[15] ;
						fract_dose_round_up_yn		= ph_records[18] ;
						content_in_pres_base_uom	= ph_records[19] ;
						prn_doses_pres_prd_fill		= ph_records[20] ;
						stock_uom					= ph_records[21] ;
						// To get the dosage_type and build the legend and the list item
						dosageRecords				= beanQueryObj.getDosage(strength_value,records[11]); //records[11] = calc_dosg_by_freq_durn_yn
						dosage_type					= dosageRecords[0];
						//ori_dosage_type				= dosageRecords[1];
						dosage_legend				= dosageRecords[2];
						dosage_option				= dosageRecords[3];
						dosage						= dosageRecords[4];
 				} // End of for j 
				arrDrugDtls			= null;

            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block505Bytes, _wl_block505);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block507Bytes, _wl_block507);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(count));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(count));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block514Bytes, _wl_block514);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(count));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(count));
            _bw.write(_wl_block517Bytes, _wl_block517);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
						RouteCode = beanQueryObj.getRouteDetails(properties, form_code);
						for(int j=0; j<RouteCode.size(); j++)
						{
							routeDetails	= (String[]) RouteCode.get(j);
							if(route_code.equals(routeDetails[0]))
								out.println("<option value=\""+routeDetails[0]+"\" SELECTED> "+routeDetails[1]+" </option>");
							else 
								out.println("<option value=\""+routeDetails[0]+"\"> "+routeDetails[1]+" </option>");
						}

            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block519Bytes, _wl_block519);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(count));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(count));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(count));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(dosage_option));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(count));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(dosage_legend));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(count));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(count));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(count));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(count));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(count));
            _bw.write(_wl_block517Bytes, _wl_block517);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);
						if(dosage_type.equals("S")){
							out.println("<option value=\""+strength_uom_desc+"\" SELECTED> "+strength_uom_desc+" </option>");
						}else  {
							UOMDtls = beanQueryObj.getUOMDetails(properties, form_code);
							for(int j=0; j<UOMDtls.size(); j++)
							{
								uomDetails	= (String[]) UOMDtls.get(j);

								if(pres_base_uom.equals(uomDetails[0]))
								{
									out.println("<option value=\""+uomDetails[0]+"\" SELECTED> "+uomDetails[1]+" </option>");
								}
								else{ 
									out.println("<option value=\""+uomDetails[0]+"\"> "+uomDetails[1]+" </option>");
								}
							}
						}

            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(count));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(dosage_type));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(count));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strength_uom_desc));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(count));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(stock_uom));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(count));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strength_per_pres_uom));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(count));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strength_per_value_pres_uom));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(count));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(fract_dose_round_up_yn));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(count));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(content_in_pres_base_uom));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(count));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(prn_doses_pres_prd_fill));
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(count));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(pres_base_uom));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(count));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(instrn_content_type));
            _bw.write(_wl_block553Bytes, _wl_block553);
			} // End of records[3] 

            _bw.write(_wl_block554Bytes, _wl_block554);
						if(display_auth_count == 0 )	// To Hide the Authorization if no items have any authorization
							out.println("<script>setTimeout('hideCareSetAuthorization("+t+")',150);</script>");
							
						if(care_set_count[1].equals("PH") && records[4].equals("MS"))
						{
							if(!recordDefault[0].equals(""))
								out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+count+","+count+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
						}
						else
							out.println("<script>setFrequency(document.placeOrderForm.frequency_code"+count+","+count+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
						count++;
					}
				}
				else
				{
				
            _bw.write(_wl_block555Bytes, _wl_block555);

				}
				
            _bw.write(_wl_block2Bytes, _wl_block2);

				// Any Fields needed Format (mandatory) in the line level, legend has to be displayed in the button frame
				out.println("<script>setTimeout('setFormatLegends("+format_mandatory_count+","+format_count+")',200);</script>");
				order_set_order_catalog = ""; // Remove the values
				order_type_catalog			 = ""; // Remove the values
				order_type_catalog_sort		 = ""; // Remove the values //IN058388-IN058669
				out.println("<input type='hidden' name='care_set_order_category"+t+"' id='care_set_order_category"+t+"' value='"+care_set_count[1]+"'>");
				display_auth_count = 0;
				
			} // End of For PlaceOrderSetItems
			out.println("<input type='hidden' name='care_set_count' id='care_set_count' value='"+t+"'>");
	
				
		}	// End of if PlaceOrderSetItems (Outer Loop)

            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(patient_email_id));
            _bw.write(_wl_block557Bytes, _wl_block557);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block558Bytes, _wl_block558);
            out.print( String.valueOf(count));
            _bw.write(_wl_block559Bytes, _wl_block559);
            out.print( String.valueOf(lb_instal_yn));
            _bw.write(_wl_block560Bytes, _wl_block560);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block561Bytes, _wl_block561);
            out.print( String.valueOf(bean.getPractitionerId()));
            _bw.write(_wl_block562Bytes, _wl_block562);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block563Bytes, _wl_block563);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block564Bytes, _wl_block564);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block565Bytes, _wl_block565);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block566Bytes, _wl_block566);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block567Bytes, _wl_block567);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block568Bytes, _wl_block568);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block569Bytes, _wl_block569);
            out.print( String.valueOf(p_task_code));
            _bw.write(_wl_block570Bytes, _wl_block570);
            out.print( String.valueOf(p_task_srl_no));
            _bw.write(_wl_block571Bytes, _wl_block571);
            out.print( String.valueOf(bean.getSex()));
            _bw.write(_wl_block572Bytes, _wl_block572);
            out.print( String.valueOf(bean.getDob()));
            _bw.write(_wl_block573Bytes, _wl_block573);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block574Bytes, _wl_block574);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block575Bytes, _wl_block575);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block576Bytes, _wl_block576);
if(passed_from.equalsIgnoreCase("Rapid Preview"))
		{
		
            _bw.write(_wl_block577Bytes, _wl_block577);

		}
		else
		{
		
            _bw.write(_wl_block578Bytes, _wl_block578);

		}
		
            _bw.write(_wl_block579Bytes, _wl_block579);
	
	
	
            _bw.write(_wl_block580Bytes, _wl_block580);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block581Bytes, _wl_block581);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block582Bytes, _wl_block582);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block583Bytes, _wl_block583);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block584Bytes, _wl_block584);
            out.print( String.valueOf(charge_yn));
            _bw.write(_wl_block585Bytes, _wl_block585);
            out.print( String.valueOf(care_set_catalog_desc));
            _bw.write(_wl_block586Bytes, _wl_block586);
            out.print( String.valueOf(ref_facility_id));
            _bw.write(_wl_block587Bytes, _wl_block587);
            out.print( String.valueOf(ref_date_time));
            _bw.write(_wl_block588Bytes, _wl_block588);
            out.print( String.valueOf(ref_sent_pract_id));
            _bw.write(_wl_block589Bytes, _wl_block589);
            out.print( String.valueOf(ref_sent_remarks));
            _bw.write(_wl_block590Bytes, _wl_block590);
            out.print( String.valueOf(show_bill_info_yn));
            _bw.write(_wl_block591Bytes, _wl_block591);
            out.print( String.valueOf(dupchk_siteSpecFlag));
            _bw.write(_wl_block592Bytes, _wl_block592);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block593Bytes, _wl_block593);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block594Bytes, _wl_block594);
            out.print( String.valueOf(called_function));
            _bw.write(_wl_block595Bytes, _wl_block595);
            out.print( String.valueOf(bt_order_type_code));
            _bw.write(_wl_block596Bytes, _wl_block596);
            out.print( String.valueOf(drugintercnt ));
            _bw.write(_wl_block597Bytes, _wl_block597);
		
		// Nullifying the Objects
		previousValues			= null;		// Nullifying the Objects
		PlaceOrdercareSetCount	= null;  PlaceOrderSetItems 	= null;
		PlaceOrderItems 		= null;  drugclass				= null;
		Default					= null;	 PlaceOrderType			= null; 
		PlaceOrderFrequency		= null;	
		stFormat				= null;	 secondaryOrders		= null;
		


		// set it back persistence
		putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	e.printStackTrace();
}


            _bw.write(_wl_block598Bytes, _wl_block598);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orderable.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.PressLinkto.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Day(s).label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillLater.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApptRequired.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Form.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DosageBy.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
