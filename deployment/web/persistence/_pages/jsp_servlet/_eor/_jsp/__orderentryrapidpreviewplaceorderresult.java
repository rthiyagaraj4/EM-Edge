package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryrapidpreviewplaceorderresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryRapidPreviewPlaceOrderResult.jsp", 1742302464000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History\tName\t\t\tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n\n11/08/2011\t  IN00747\t\t Chowminya\t\t\t\t\t\t\t\t\t\t\tIncident No: IN00747 - <Clinical comments mandatory check in Preview  screen>\n08/11/2011\t  IN28273\t\t Dinesh T\t \t\t\t\t\t\t\t\t\t\tAdded the change event to that control\n17/12/2012\t  IN036383\t\tRamesh G\t\t\t\t\t\t\t\t\t\t\tThe  Order released from Preview Screen is not getting placed.\n13/08/2013\t  IN042045\t\tChowminya G\t    \t\t\t\t\t\t\t\t\tSystem should not allow to copy for the drugs for which Verbal Order Applicable is not selected\n15/10/2013\t  IN041155\t\tKarthi L\t\t\t\t\t\t\t\t\t\t\tPreview screen opens and Billing details are displayed\n06/05/2014    IN048942\t\tChowminya      \t\t\t\t\t\t\t\t\t\tPerforming Location and wing code defaulting issue\t\n02/07/2014\t  IN048467 \t\tNijitha S\t\t\t\t\t\t\t\t\t\t\tHSA-CRF-0150\n26/08/2014    IN050607\t\tNijitha S\t\t\t\t\t\t\t\t\t\t\tKDAH-SCF-0255\t\n24/9/2014\t  IN051367\t\tNijitha S\t\t\t\t\t\t\t\t\t\t\tRegression-OP-Transaction â?? Register Visit\t\n04/12/2014\t  IN052765\t\tVijayakumar K\t\t04/12/2014\t\tChowminya\tML-BRU-SCF-1489 [IN:052765]From CA, \n29/04/2015\t  IN055190\t\tVijayakumar K\t29/04/2015\t\tDinesh T\t\t\tKDAH-SCF-0296 [IN:055190] - Wrong order\n09/06/2017\t  IN063816\t\tVijayakumar K\t\t\t\t\t\t\t\t\tGHL-CRF-0445.1 [IN:063816]\t\n03/07/2017\t  IN062607\t\tRaja S\t\t\t03/07/2017\t\tRamesh G\t\t\tML-MMOH-CRF-0727\n19/10/2017\tIN065324\t\tDinesh T\t\t19/10/2017\t\tRamesh G\t\t\tTo display the price in OR screen and the \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbilling status in Manage Specimen screen\n15/12/2017\tIN065942\t\tDinesh T\t\t\t15/12/2017\t\tRamesh G\t\tIn Nuclear medicine  department we required the \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbarcode functionality at the time of \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRegistration of order,required patient \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tId,patient name,age,sex,register date and name \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tof study.\n08/02/2018\tIN066436\t\tRaja S\t\t\t\t08/02/2018\tRamesh G\t\t\tSS-SCF-0777\n06/07/2018\tIN067246\t\tRaja S\t\t\t\t06/07/2018\tRamesh G\t\t\tGHL-CRF-0516\n01/08/2018\t\tIN64543\t\t\tDinesh T\t\t01/08/2018\tRamesh G\t\tML-MMOH-CRF-0776\n09/01/2019  IN066377  \t\tKamalakannan G\t09/01/2019\t\tRamesh G\t\t\tAMS-CRF-0139\n11/02/2019\tIN069657\tDinesh  T\t11/02/2019\tRamesh G\tIN069657\n07/06/2020\tIN072524\tNijitha S     \t\t07/06/2020\t\tRamesh G\t\tML-MMOH-CRF-1229.2\n25/06/2020\tIN073309\tNijitha S     \t\t25/06/2020\t\tRamesh G\t\tML-MMOH-CRF-1229.2/02\n07/06/2020  IN072654\tNijitha S     \t\t07/06/2020\t\tRamesh G\t\tMMS-KH-CRF-0029.4\n-------------------------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n<!--IN055190 starts -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!--IN055190 ends -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/></link>\n\t</link>\n \t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryRapidPreview.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- for Tool Tip-->\n\t<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n<style>\nTD.PATQRED1 \n{\n\tBACKGROUND-COLOR: #FA8072 ;\n\tFONT-SIZE: 9pt ;\n\t/*border-style: dashed;*/\n\tborder-right-width: 0\n\tborder-left-width: 0\n\tborder-right-width: 0\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0 \n}\n</style>\n</head>\n<style TYPE=\"text/css\"></style>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"ClinicalComment();\">\n<form name=\"placeOrderForm\" id=\"placeOrderForm\" >\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" id=\"detailTab\" class=\"grid\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t<!-- To display the old orderables -->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdr_format_id_mandatory_yn";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"hdr_format_id_mandatory_yn";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_care_set_order_category";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"hdr_care_set_order_category";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_order_catalog_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"hdr_order_catalog_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"hdr_format_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"hdr_format_id";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"care_set_order_category";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"care_set_order_category";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><!--For Care Sets & PREVIEW-->\n\t\t\t\t<!--<input type=\"hidden\" name=\"clin_category_comments_reqd_yn\" id=\"clin_category_comments_reqd_yn\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> --> <!-- IN00747 -->\n\t\t\t\t<!--<input type=\"hidden\" name=\"clin_cmts_reqd_yn\" id=\"clin_cmts_reqd_yn\" value=\"N\"> <!-- IN00747 -->\n\t\t\t\t<input type=\"hidden\" name=\"clin_category_comments_reqd_yn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"clin_category_comments_reqd_yn";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"><!--For Category Level Clinical Comments-->\n\t\t\t\t<tr id=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t<td align=\"\" colspan=\"3\" class=\"PATQRED1\" style=\"border-width:0\"><div align=\'left\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:orderFormatForPreviewHeader(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\",";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",\"\")\' title=\'Order Format\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<b><font size=\"2\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></b></div></td>\n\t\t\t\t\t<td align=\"right\"  colspan=\"2\" class=\"PATQRED1\" style=\"border-width:0\" nowrap>\n\t\t\t\t\t\t<font size=\"1\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"clinical_comments";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"clinical_comments";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" value=\"\">\n\t\t\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:DisplayClinicalComments(\"clinical_comments";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\",\"CLINICAL\",\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\",\"N\")\' title=\'Clinical Comments\' nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a> <!-- Modified [IN0747] -->\n\t\t\t\t\t\t</font>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<label  id=\"cl_cmt_mand";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" Title=\"Clinical Comment\"  style=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"><img src=\"../../eCommon/images/mandatory.gif\"></img></label> \n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"left\"   colspan=\"3\" class=\"PATQRED1\" style=\"border-width:0\"><font size=\"1\"><!-- Header Format Items -->&nbsp;\n\t\t\t\t\t</font>\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t\t<td id=\"hdg";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"  align=\"left\" class=\"PATQRED1\" style=\"border-width:0\" nowrap>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n\n\t\t\t\t\t<td id=\"imageId";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  align=\"left\" class=\"PATQRED1\" style=\"border-width:0;\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n  \t\t\t\t\t<td id=\"authorizedId";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" align=\"left\" class=\"PATQRED1\" style=\"border-width:0\">\n\t\t\t\t\t\n\t\t\t\t<label  id=\"auths\"  style=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:CheckMultipleAuth(\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\",\"X\")\' title=\'Authorize\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a></label><label  id=\"auth\"  style=\"display:none\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t</label>\n\t\t\t\t\t<input type=\"hidden\" name=\"auth_reqd";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"auth_reqd";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value=\"X\">\n\t\t\t\t</td>\n\t\t\t\t  <td id=\"imageCosignId";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" class=\"PATQRED1\" style=\"border-width:0\" align=\"left\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t \t\t  <td id=\"cosignId";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" class=\"PATQRED1\" style=\"border-width:0\" align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:CheckMultipleCosign(\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\")\' title=\'Cosign\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n \t\t\t\t<input type=\"hidden\" name=\"cosign_reqd";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"cosign_reqd";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t</td>\n \t\t\t\t<td id=\"imageSpecialId";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n  \t\t\t\t<td  colspan=\"3\"      id=\"specialId";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" class=\"PATQRED1\" style=\"border-width:0\" align=\"left\" nowrap>&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\t\t\t\t\t\n\t\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:CheckMultipleSpecialApproval(\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\")\' title=\'Special Approval\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"special_approval_reqd";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"special_approval_reqd";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"care_set_authorized";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"care_set_authorized";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" value=\"false\">  \n\t\t\t\t\t<input type=\"hidden\" name=\"multiple_cosigned";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"multiple_cosigned";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" value=\"false\">  \n\t\t\t\t\t<input type=\"hidden\" name=\"multiple_special_approved";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"multiple_special_approved";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" value=\"false\"> \n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\"head";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t<th nowrap>&nbsp;</th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</th>\n\t\t\t\t\t<th colspan=\"2\" nowrap>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</th>\n\t\t\t\t\t<th nowrap>&nbsp;</th>\n\t\t\t\t\t<th nowrap ><a class=\"gridLink\" href=\"#\" onClick=\"changeAllStartDateTime()\" title=\"Do u want to change all the Start Date Time, Click here\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</a></th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</th>\n\t\t\t\t\t<th colspan=\"3\" nowrap>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</th><!-- IN066377 -->\n\t\t\t\t\t<th colspan=\"4\" nowrap>&nbsp;</th>\t\t\t\t\t\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<tr id=\"row";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t\t<td id=\"billing";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" class=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" align=\"center\" nowrap><font size=\"1\"><input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"ck";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" value=\"Y\" checked onClick=\"setCheckValue(this,\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\')\"></font>\n\t\t      ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"consent_id_lookup";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"consent_id_lookup";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" title=\'Consent Required\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"consent_chk";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" name=\"consent_form_id";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" name=\"consent_stages";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"consent_form_list";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"consent_form_list";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t\t\t\t\t<Input type=\'hidden\' name=\"total_recs";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"total_recs";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' name=\"consent_stages";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="0\">\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" value=\"Y\" name=\"consent_chk";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="0\" id=\"consent_chk";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="0\">\n\t\t\t\t\t\t\t\t<input type=\'hidden\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="0\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t<Input type=\'hidden\' name=\"multiConsentList";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"multiConsentList";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"h1";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"><input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"h2";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"catalog_code";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"catalog_code";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t<!--<input type=\"hidden\" id =\"start_date_time_id";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"  name=\"start_date_time";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">-->\n\t\t\t\t</td>\n\t\t\t\t<td id=\"billing1";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"  align=\"right\" nowrap onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\",\"placeOrderForm\")\' onMouseOut=\"hideToolTip()\"><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t\t ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\t\n\t\t\t\t\t&nbsp;<img id=\'authorization";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' src=\"../../eOR/images/Authorization.gif\" align=\"center\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\t\t\t\t\t\t&nbsp;<img id=\'authorization";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' src=\"../../eOR/images/Authorization.gif\" align=\"center\"></img>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t&nbsp;\n\t\t\t\t\t<img id=\"cosign";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" src=\"../../eOR/images/Cosign_click.gif\" align=\"center\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t&nbsp;<img id=\"special_approval";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t</font><input type=\"hidden\" name=\"cat_desc";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"cat_desc";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"><input type=\"hidden\" name=\"type_desc";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"type_desc";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" value=\"\"></td>\n\t\t\t\t<td id=\"billing2";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" align=\"right\" nowrap><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t</font>\n\t\t\t\t<input type=\"hidden\" name=\"order_type_code";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"order_type_code";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" value= \"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_type";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" id=\"order_type";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name=\"priority";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" id=\"priority";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"priority_appl";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" id=\"priority_appl";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" align=\"right\" nowrap id=\"priority_id";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"><font size=\"1\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" ";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" onClick=\"javascript:return changePriorityLineLevel(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\')\" ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" title=\"Routine\"><b>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="  title=\"Urgent\"><b>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t <a class=\"gridLink\" href=\"#\" ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="  title=\"Stat\"><b>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t</td>\n\t\t\t\t<td id=\"billing4";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" nowrap><font size=\"1\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changeValue(\'P\',\'quantity";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\',";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =")\" title=\"Quantity\"><b><</b></a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\t\n\t\t\t\t\t<input type=\"text\" style=\"text-align:\'right\'\" name=\"quantity";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" id=\"quantity";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" size=\"2\" maxLength=\"6\" onKeyPress=\"return(ChkNumberInput(this,event,\'2\'))\" onBlur=\"checkValidNumber(\'\',this)\" onchange=\"reviseBillingchrgs(\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\',\'OP_NEW_ORDER\')\" ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =">&nbsp;<!--IN28273-->\n\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changeValue(\'N\',\'quantity";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =")\" title=\"Quantity\"><b>></b></a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" align=\"right\" id=\"frequency_id";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" nowrap><font size=\"1\">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\t\t\t\t<font size=\"1\">\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changeRapidFrequency(\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\')\" title=\"Frequency\"> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t\t\t\t</a></font>\n\t\t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t</td>\n\t\t\t\t<td id=\"billing6";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changeValue(\'P\',\'duration_value";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 =")\" title=\"Duration\"><b><</b></a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"duration_value";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" id=\"duration_value";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" size=\"2\" maxLength=\"3\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onBlur=\'checkMaxValue(this,\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\",escape(\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"),\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\")\'  ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =">\n\t\t\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t\t\t\t\t<input type=\"text\" class=\"NUMBER\" name=\"duration_value";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" size=\"2\" maxLength=\"3\" disabled>\n\t\t\t\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changeValue(\'N\',\'duration_value";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 =")\" title=\"Duration\"> \n\t\t\t\t\t\t<b> > </b></a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t<input type=\"hidden\" class=\"NUMBER\" name=\"duration_def_value";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" id=\"duration_def_value";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"  align=\"right\" id=\"duration_code_id";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" nowrap><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t\t<input type=\"hidden\" name=\"duration_code";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" id=\"duration_code";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 =" value=\"\" ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =" > \n\t\t\t\t\t<input type=\"hidden\" name=\"duration";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" id=\"duration";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" value=\"\">\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" align=\"right\" id=\"schedule";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" nowrap>&nbsp;</font></td>\n\t\t\t\t\t<td id=\"billing12";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" align=\"right\" nowrap> <input type=\"text\" id =\"start_date_time_id";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" onkeyDown=\'chkBackSpace();\'  value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" size=\"14\" maxLength=\"16\" onBlur=\"checkStartDateTim(this,";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =",\'";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\')\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendarValidate(\'start_date_time_id";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\',null,\'hh:mm\',\'\',\'\');\" style=\'cursor:pointer\'> \t\t\t\t\t \n\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\" align=\"right\" id=\"start_date_time_href_id";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\" nowrap>&nbsp;<font size=\"1\"><a href=\"#\" onClick=\"javascript:return changeLineLevelDateTime(\'start_date_time_id";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\')\" title=\"StartDateTime\">";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</a></font>-->\n\t\t\t\t</td>\n\t\t\t\t<td id=\"billing9";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" align=\"left\" nowrap><input type=\"text\" name=\"end_date_time";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" id=\"end_date_time";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" size=\"14\" maxLength=\"16\" value=\"\" readOnly></td>\n\t\t\t\t<td id=\"billing10";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" align=\"right\" nowrap>&nbsp;<font size=\"1\">\n\t\t\t\t&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t\t<!--<select name=\"performing_facility_id";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" onchange=\'clearDepLocn(\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\",this);setPerformingFacility(\"performing_facility_id";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\",this);\'>-->\n\t\t\t\t\t<select name=\"performing_facility_id";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\",this);\'><!-- IN048942 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n \t\t\t\t</select>\n\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t\t<font size=\"1\"><b>";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="&nbsp;:</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n \t\t\t\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</font>/\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\" align=\"right\" id=\"performing_dept_loc_code_id";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" nowrap><font size=\"1\">\n\t\t\t\t<!-- <a href=\"#\" onClick=\"javascript:changePerformingDeptLoc(\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\')\">changed on 7/9/2007 for lb_instal_yn by uma   -->\n\t\t\t\t\t<a class=\"gridLink\" href=\"#\" onClick=\"javascript:changePerformingDeptLoc(\'";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\')\"> \n";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t\t\t\t\t</a></font>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\n\t\t\t\t<!-- IN066377 start -->\n\t\t\t\t";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\n\t\t\t\t<td style=\"border: none;\">\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t<!-- IN066377 end -->\n\t\t\t\t\t<input type=\"hidden\" name=\"performing_dept_loc_code";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\" id=\"performing_dept_loc_code";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\t\t\n\t\t\t\t<input type=\"hidden\" name=\"format_id";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" id=\"format_id";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"><!--Added for IN066436-->\n\t\t\t\t<input type=\"hidden\" name=\"format_id_val";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" id=\"format_id_val";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" align=\"right\" id=\"order";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" nowrap><font size=\"1\"> &nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t<Script>\n\t\t\t\t\t\tdocument.getElementById(\'start_date_time\')";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =".value = \'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\';\n\t\t\t\t\t</Script>\n\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewSecondaryOrders(\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\')\"> <img src=\"../../eOR/images/SecondaryOrder.gif\" border=\"0\"  title=\"Secondary Orders Exists\"></img>&nbsp;</a>\n";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n\t\t\t\t<input type=\"hidden\" name=\"sec_tasks_type";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\" id=\"sec_tasks_type";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\"> <!--Keep the Seconday order catalog_type -->\n\t\t\t\t<input type=\"hidden\" name=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\" id=\"format_id_mandatory_yn";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\"> <!--IN069657-->\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"    align=\"right\" id=\"order1";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" >\n";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\n\t\t\t\t\t\t\t\t <script>alert(\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 =";\");billchecking(\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\");displaycolor(\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\");</script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\n\n\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t var msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\");</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t\t\t\t<!--  <table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\'center\' style=\'border-width:0\'> --> <!--  commented for IN041155 -->\n\t\t\t\t\t<table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\'center\' ";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="style=\'border-width:0;display:inline\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="style=\'border-width:0;display:none\' ";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="><!--  modified for IN041155 -->\n\t\t\t\t\t\t<!--IN072524 Starts-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"fpp_yn";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" id=\"fpp_yn";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"  value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" >\n\t\t\t\t\t\t<td rowspan=\"2\" colspan=\"\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\" style=\'border-width:1;\' nowrap ><font size=\"1\" class=\'label\'>&nbsp;<B>";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 =":</B></font>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<select name=\"fpp_category";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" id=\"fpp_category";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\"  onchange=\"reviseBillingchrgs(\'";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\',\'NEW_ORDER\')\" >\n\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 =">";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="</option><!--IN068314 -->\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\n\t\t\t\t\t\t<!--IN072524 Ends-->\n\t\t\t\t\t\t<tr >\t\n\t\t\t\t\t\t\t<td  colspan=\"\" width=\'30%\' class=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\" style=\'border-width: 1;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 =": </B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'30%\' class=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" style=\'border-width: 1;text-align: right;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 =" </B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'30%\' class=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 =" </B></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'35%\' class=\"";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\" style=\'border-width: 1;text-align: center;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =" </B></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" width=\'35%\' class=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\" style=\'border-width: 0;text-align: right;\'  nowrap><font class=\'fields\' size=\"1\"><span id=\'bill_now_";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\' style=\'visibility:";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\'>";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="<input type=\"checkbox\" name=\'bill_now_check";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\' id=\'bill_now_check";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\' value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 =" onclick=\"changeBillNow(this,\'";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\')\" ></span></font>";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="(";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 =")";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="</td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'actual_";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="</span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'payable_";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</span></font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'included_";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</span></font></td>\n\t\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'approved_";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="</span></font></td> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"bill_now";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\" id=\"bill_now";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n\t\t\t\t\t\t\t   <input type=\"hidden\" name=\"bill_now_check_Df";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" id=\"bill_now_check_Df";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"future_date";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" id=\"future_date";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" >\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"round_off_start_time";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" id=\"round_off_start_time";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" >\n\t\t\t\t\t</table>\n\t\t\t\t<!--\n                 \t<a href=\"javascript:callBilling(\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\',\'NEW_ORDER\')\" title=\'Charge Details\'>";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="</a>\t  -->\n";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\t\tlabdruginterchk(\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\");\t\t\t\n\t\t\t\t\t </script>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\n\t\t\t\t\t\t</td>";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\" id=\"order2";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\" style=\"border-left-width:0;text-align: center;\" nowrap><font size=\"1\">\n";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:callReviseBilling(\'";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\',\'NEW_ORDER\',\'";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\',\'\',\'\')\" title=\'Charge Details\'>";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 =" \n\t\t\t\t<!--\t <a href=\"javascript:callBilling(\'";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\',\'NEW_ORDER\')\" title=\'Charge Details\'>  --> <!-- ";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="  View / Edit --></a>\n\n";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\n</td>";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="<td style=\"background=#FF7DD0;\"></td>";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\n\t\t\t\t</font>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\n\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t var msg=getMessage(\"PRIV_ORDER_AUTH_RIGHTS\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tbillchecking(\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\");\n\t\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\t var msg=getMessage(\"CATALOG_OPERATIONAL_MODULE\",\"OR\");\n\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\");\n\t\t\t\t\t\tdisplaycolor(\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\");\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg=getMessage(\"OR_ORDERING_RULE_CHK\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"temp_frequency_code";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\" id=\"temp_frequency_code";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\"><!-- on Load -->\n\t\t\t\t\t<input type=\"hidden\" name=\"frequency_code";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" id=\"frequency_code";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"frequency_val";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\" id=\"frequency_val";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_yn";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\" id=\"schedule_yn";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\" id=\"schedule_mandatorily_yn";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\" value=\"N\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_nature";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\" id=\"freq_nature";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\" value=\"F\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"repeat_value";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\" id=\"repeat_value";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"order_catalog_nature";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\" id=\"order_catalog_nature";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"quantity_uom";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\" id=\"quantity_uom";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"freq_applicable_yn";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\" id=\"freq_applicable_yn";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"soft_stop_yn";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\" id=\"soft_stop_yn";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"cont_order_yn";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\" id=\"cont_order_yn";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\" id=\"chk_for_dupl_yn";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_status";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\" id=\"chk_for_dupl_status";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\">\n\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\" id=\"chk_for_dupl_ahead_action";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\" id=\"chk_for_dupl_ahead_period";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\" id=\"chk_for_dupl_ahead_unit";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\" id=\"chk_for_dupl_behind_action";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\" id=\"chk_for_dupl_behind_period";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\" id=\"chk_for_dupl_behind_unit";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_reqd_yn";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" id=\"appt_reqd_yn";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" id=\"locn_appt_reqd_yn";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"appt_time";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\" id=\"appt_time";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\" id=\"pat_instrn_age_sex_yn";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"complete_on_order_yn";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\" id=\"complete_on_order_yn";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_yn";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\" id=\"bill_yn";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_applicable_yn";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\" id=\"result_applicable_yn";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="\" id=\"result_auth_reqd_yn";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"chart_result_type";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\" id=\"chart_result_type";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_mod_id";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\" id=\"contr_msr_mod_id";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"contr_msr_panel_id";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="\" id=\"contr_msr_panel_id";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\">\n\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\" id=\"ord_auth_reqd_yn";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\" id=\"ord_cosign_reqd_yn";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="\" id=\"ord_spl_appr_reqd_yn";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" id=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"activity_type";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\" id=\"activity_type";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"check_for_dupl_level";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\" id=\"check_for_dupl_level";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\" id=\"routine_appt_reqd_yn";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\" id=\"stat_appt_reqd_yn";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" id=\"urgent_appt_reqd_yn";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="\" id=\"routine_chk_for_dupl_yn";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="\" id=\"urgent_chk_for_dupl_yn";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" id=\"stat_chk_for_dupl_yn";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"consent_stage";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 ="\" id=\"consent_stage";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\">\n\t\t\t\t\t<!--added on 08/05/07-->\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\" id=\"num_of_consent_req_bo";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"num_of_consent_req_br";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="\" id=\"num_of_consent_req_br";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_interface";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\" id=\"billing_interface";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 ="\" id=\"service_panel";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"service_panel_code";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="\" id=\"service_panel_code";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"numbering";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\" id=\"numbering";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"FinBill";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\" id=\"FinBill";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\" id=\"clin_cmts_reqd_yn";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"authorised_yn";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="\" id=\"authorised_yn";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\" value=\"N\">\n\t\t\t\t";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"splty_code";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\" id=\"splty_code";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"auth_yn";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\" id=\"auth_yn";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"auth_yn";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\n\n\n\n\t\t\t\t\t<!--Ends here 08/05/07-->\n\t\t\t\t\t<input type=\"hidden\" name=\"perfLocnMandFlag";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\" id=\"perfLocnMandFlag";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\"><!--IN066377-->\n\t\t\t\t\t<input type=\"hidden\" name=\"group_order_category";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\" id=\"group_order_category";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="\"> <!-- order_category -->\n\t\t\t\t\t<input type=\"hidden\" name=\"billing_call_yn";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="\" id=\"billing_call_yn";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"specimen_type";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\" id=\"specimen_type";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"nurse_collect";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\" id=\"nurse_collect";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"start_time";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="\" id=\"start_time";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\" value=\"\"> <!-- For Care Sets -->\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\" id=\"order_id";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_preps";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\" id=\"line_preps";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_pat_instrn";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 ="\" id=\"line_pat_instrn";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_dept_instrn";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\" id=\"line_dept_instrn";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\"> <!-- For Copy Order -->\n\t\t\t\t\t<input type=\"hidden\" name=\"line_comments";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" id=\"line_comments";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="\">";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 =" ";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"auto_report_yn";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" id=\"auto_report_yn";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\"> ";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"skip_auth";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\" id=\"skip_auth";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\"><!--IN048467 - HSA-CRF-0150-->\n\t\t\t\t\t<input type=\"hidden\" name=\"barcode_reqd_yn";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 ="\" id=\"barcode_reqd_yn";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="\"><!--IN063816 - GHL-CRF-0445.1 -->\n\t\t\t\t\t<input type=\"hidden\" name=\"prn_regd_ord";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\" id=\"prn_regd_ord";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\"><!--IN065942-->\n\t\t\t\t\t<input type=\"hidden\" name=\"instrn_content_type";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\" id=\"instrn_content_type";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\"><!--IN64543-->\n\t\t\t\t\t<input type=\"hidden\" name=\"non_billing_numbering";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\" id=\"non_billing_numbering";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\"  id =\"non_billing_numbering";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" /><!--IN068314 -->\n  \t\t\t\t</td>\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"enable_email";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="\" id=\"enable_email";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="\n\t<Script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\"));\n\t\twindow.close();\n\t</script>\n";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\n</table>\n\t\t<input type=\"hidden\" name=\"patient_email_id\" id=\"patient_email_id\" value=\"";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 ="\">\n\t\t<input type=\"hidden\" name=\"care_set_count\" id=\"care_set_count\" value=\"0\"><!-- Used for Care Sets-->\n\t\t<input type=\"hidden\" name=\"total_order_cat_count\" id=\"total_order_cat_count\" value=\"";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\"><!-- Used for Rapid Preview(to store the category count)-->\n\t\t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="\">\n\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\">\n\t\t<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\"";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 ="\">\n\t\t\n\t\t<input type=\"hidden\" name=\"amend_total_rows\" id=\"amend_total_rows\" value=\"0\">\n\t\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"\">\n\n\t\t<input type=\"hidden\" name=\"authorized\" id=\"authorized\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"priority_hdr\" id=\"priority_hdr\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_date_time\" id=\"order_date_time\" value=\"\">\n\t\t<input type=\"hidden\" name=\"header_comments\" id=\"header_comments\" value=\"\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\">\n\t\t<input type=\"hidden\" name=\"consented\" id=\"consented\" value=\"\">\n\t\t<input type=\"hidden\" name=\"cosigned\" id=\"cosigned\" value=\"\">\n\t\t<input type=\"hidden\" name=\"special_approved\" id=\"special_approved\" value=\"\">\n\t\t<input type=\"hidden\" name=\"lb_instal_yn\" id=\"lb_instal_yn\" value=\"";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\">\n\t\t<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\">\n\t\t<input type=\"hidden\" name=\"display_auth_count\" id=\"display_auth_count\" value=\"";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\">\n\t\t<input type=\"hidden\" name=\"ordering_practitioner\" id=\"ordering_practitioner\" value=\"";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\">\n\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\">\n\t\t<!-- IN036383 Start -->\n\t\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\">\n\t\t<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\">\n\t\t<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\">\n\t\t<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\">\n\t\t<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\">\n\t\t<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\">\n\t\t<!-- IN036383 End. -->\n\t\t<input type=\"hidden\" name=\"task_code\" id=\"task_code\" value=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\">\n\t\t<input type=\"hidden\" name=\"task_srl_no\" id=\"task_srl_no\" value=\"";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\">\n \t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\">\n\t\t<input type=\"hidden\" name=\"primary_order_type\" id=\"primary_order_type\" value=\"\"> <!-- Used for Primary Order Type OT Ordercategory -->\n\n\t\t<input type=\"hidden\" name=\"ref_facility_id\" id=\"ref_facility_id\" value=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_date_time\" id=\"ref_date_time\" value=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_pract_id\" id=\"ref_sent_pract_id\" value=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"ref_sent_remarks\" id=\"ref_sent_remarks\" value=\"";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\"><!--External Orders-->\n\t\t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\">\n\t\t <!-- Used in OrderEntryCalendar.js to send to OA Appointment Booking-->\n\t\t<input type=\"hidden\" name=\"cosign_reqd_yn\" id=\"cosign_reqd_yn\" value=\"\"> <!-- Will be set at the time of apply, and used to set the Cosign_reqd_yn=\'Y\' when nurse is logging in -->\n\t\t<input type=\"hidden\" name=\"care_set_catalog_code\" id=\"care_set_catalog_code\" value=\"\"><!-- Used for Care Sets-->\n\t\t<input type=\"hidden\" name=\"function_name\" id=\"function_name\" value=\"PREVIEW\"> <!-- For Order Format Line Level -->\n\t\t<input type=\"hidden\" name=\"validated_status\" id=\"validated_status\" value=\"validation_reqd\">\n\t\t<input type=\"hidden\" name=\"new_order_reqd\" id=\"new_order_reqd\" value=\"\"> <!-- For Amend Order , To generate a New Order-->\n\t\t<input type=\"hidden\" name=\"record_from\" id=\"record_from\" value=\"PREVIEW\"> <!-- For Preview Order , To check header mandatory -->\n\t\t<input type=\"hidden\" name=\"email_yn\" id=\"email_yn\" value=\"N\"> <!-- For Email -->\n\t\t<input type=\"hidden\" name=\"appl_user_name\" id=\"appl_user_name\" value=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\"> \n\t\t<input type=\"hidden\" name=\"checkCount\" id=\"checkCount\" value=\"\">\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"\">\n\t\t<input type=\"hidden\" name=\"twicedupchkflg\" id=\"twicedupchkflg\" value=\"";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\"> <!-- IN062607 -->\n\t\t<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\"> <!--IN065942-->\n\t\t<input type=\"hidden\" name=\"orset_ind_flag\" id=\"orset_ind_flag\" value=\"";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\"><!--IN067246-->\n\t\t<input type=\"hidden\" name=\"format_mandatory_count\" id=\"format_mandatory_count\" value=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\"> <!--IN069657-->\n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"ORSET\"><!--IN066377-->\n\t\t<input type=\"hidden\" name=\"bt_order_type_code\" id=\"bt_order_type_code\" value=\"";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="\">\n\t\t<input type=\"hidden\" name=\"interactionDrugsCnt\" id=\"interactionDrugsCnt\"  id =\"interactionDrugsCnt\" value=\"";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\" />\t<!-- IN072654 -->\n\t\t\n";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n \t\t<table id=\'tooltiptable\' cellpadding=3 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n \t\t   \t<tr>\n \t\t \t\t<td width=\'100%\' id=\'t\'></td>\n \t\t\t</tr>\n \t\t</table>\n\t</div>\n\n\t</form>\n\t</body>\n\t<script>\n\t\n\tloadDetails(\"";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );

    private final static java.lang.String  _wl_block557 ="\")//IN072654\n\t\n\tsetTimeout(\'showBillingTable();\',2000);\n\tskipAuthIndicator();//IN048467\n\t</script>\n\t<script>\n\t\tchkCount();\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block557Bytes = _getBytes( _wl_block557 );
	
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

 
	public String getArrayToString(List<String> categorylist)
	{
		StringBuilder sbcategory = new StringBuilder();
		int category_count = 0;
		
		for(String categry:categorylist)
		{
			sbcategory.append("'"+categry+"'");
			if(category_count != categorylist.size() - 1)
			{
				sbcategory.append(",");
			}
			category_count++;
		}
		
		return sbcategory.toString();
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String patient_email_id="";	
	String check="";
	Object patpreps = "IS";
	String patientDischargedYn      = "N";
	boolean is_bt_view_bill_dtls = false;//IN065324
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
	String bean_id1 = "Or_ConsentOrders" ;
	String bean_name1 = "eOR.ConsentOrders";
	ConsentOrders bean1		= (ConsentOrders)getBeanObject( bean_id1, bean_name1, request ) ;
	 bean1.setLanguageId(localeName);
	 String practitioner_id = (String)session.getValue("ca_practitioner_id");
	 /*Added by Uma on 9/29/2009 for PMG-CRF-641*/
	 String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	 String PrivilegeApplicabilityAuthYN = "";
	 /* Ends Here*/
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String entryValue   	= null;
   	String keyItems[]		= null;
	HashMap hashEntry 		= new HashMap();
	String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String practitioner_type = (String)session.getAttribute("practitioner_type");
	String appl_user_name = (String)session.getAttribute("appl_user_name");
   	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	//IN055190  starts
	String order_category_list = "";
	HashMap order_categoryvalues = bean.getOrderCategories(previousValues);
	List<String> or_catrgorylist = new ArrayList<String>(order_categoryvalues.values());
   	
	order_category_list = getArrayToString(or_catrgorylist);
	//IN055190 ends
   	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
	if(order_category.equalsIgnoreCase("PH") || order_category.equalsIgnoreCase("CS"))
		order_catalog_code="'"+order_catalog_code+"'";
	String lb_instal_yn				= "N"; 
 	String rd_instal_yn				= "N"; 
  	lb_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N"); // check whether the lb_module is installed or not, used in EJB
	rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	String session_id				= bean.checkForNull(bean.getSessionId(),""); //  used in EJB
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	//IN036383 Start.
		String deceased_yn = bean.checkForNull(request.getParameter("deceased_yn"),"");
		String medico_legal_yn = bean.checkForNull(request.getParameter("medico_legal_yn"),"");
		String postmortem_status = bean.checkForNull(request.getParameter("postmortem_status"),"");
		String body_part_yn = bean.checkForNull(request.getParameter("body_part_yn"),"");
		String registration_no = bean.checkForNull(request.getParameter("registration_no"),"");
		String callingFrom = bean.checkForNull(request.getParameter("callingFrom"),"");
	//IN036383 End.
	String p_start_date_time		= bean.checkForNull(request.getParameter("p_start_date_time"),"");
  	String p_task_code				= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no			= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String forceStatus=bean.getForceStatus(practitioner_type,order_category);
	String fStatus[]=forceStatus.split(":");
 	String classValue				= "", chk_class_value = "";
	String existing_bean_id			= "", existing_bean_name="";
	String ref_facility_id			= "", ref_date_time		= "";
	String ref_sent_pract_id		= "", ref_sent_remarks	= "";
	String auth_reqd				= "";
	String cosign_reqd				= "";
   	String special_approval_reqd	= "";
	String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
	String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER

	String l_patient_class = bean.getPatientClass();//IN065324

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
	} // End of function-from
	String specialty_code			= "";
	if(!bean.checkForNull(bean.getPatientId(),"").equals(""))
	  specialty_code				 = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");// Facility_id & encounter_id
	String dateString				= bean.getSysDate();
	//IN055190 starts
	//ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),"PREVIEW");
	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category_list,""),bean.checkForNull(order_catalog_code,"''"),"PREVIEW");
	//IN055190 ends
	int i							= 0, display_special_count   = 0, hide_count			   = 0;
	int display_auth_count			= 0, format_mandatory_count = 0;
	int format_count 			= 0,	display_cosign_count   = 0;//age_in_days					= 0,"''" 
	int order_cat_count				= 0;
	String preps_instrn 			= "", frequency_val			= "",	qty_value			   = "";
	String preps_dept_instrn		= "", duration_value		= "",   qty_uom				   = "",qty_uom_shortdesc				   = "";
	String pat_preps_instrn			= "", max_durn_value		= "";
	String chk_for_max_durn_action = "";//sex_yn					= "", 
	String format_id				= "", prompt_msg			= "";
	String format_id_mandatory_yn	= "", comments				= "";
	String order_id					= "", order_line_no			= "";
	String entered_yn				= "N", old_order_category   = "" ,order_category_desc = "",clin_category_comments_reqd_yn="",display_style="";
	String order_type_code			= "", order_types_comb		= "", frequency			  = "";
	String sec_start_date_time		= "";
	java.util.ArrayList arrSeqNo	= null;
	ArrayList Default				= null;
	String[] recordDefault			= null;
//	String[] peformingFacility		= null;
//	String[] deptLocation			= null;
	String[] format					= null;
	String[] records				= null; String[] orderTypeRecords =	null;	
	String[] frequencyRecords		= null;	String[] durationRecords = null;	
	String[] secondaryOrders		= new String[2];String[] deptLocation = null;String depLocation_code="";
	String billing_interface_yn		= bean.getBillingInterfaceYn();
	String billing_call_yn			= "N", facility_name	= "";
	String priority_value			= "N";
	ArrayList PlaceOrderType		= null;
	ArrayList PlaceOrderFrequency	= null;
	ArrayList PlaceOrderDuration	= null;
	ArrayList FormatHdr				= null;
	//ArrayList DeptLocationCode		= null; 
	StringTokenizer stFormatID		= null;
	HashMap copyOrderDetails		= null;
	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	ArrayList performingLocationCode = new ArrayList();
	String [] performingLocation = null;
	HashMap instructionsMap = new HashMap();
	patientDischargedYn = (String)bean.getPatientDischarged();
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); //IN041155
	String fac_selected		= "";// IN048942
	//IN062607 Starts
	Boolean dup_custSpecificFlg = false;
	String dupchk_siteSpecFlag="N";
	String perfLocnMandFlag = "N";//IN066377
	String bt_order_type_code = "";//IN066377
	Connection con = null ;
	PreparedStatement pstmt=null;//IN066377
	ResultSet rs=null;//IN066377
	String fpp_patient_yn = "";//IN072524
	int drugintercnt = 0;//IN072654
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
	//IN062607 Ends
	

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

//function_from = "REPLACE_ADD";
//order_id = "TRIP00000001075";
	if(function_from.equals("REPLACE_ADD") && !order_id.equals("")) 
	{ // If called from 	REPLACE_ADD Orders and order_id is passed, display the old datas
			//AmendPlaceOrderItems		= bean.getAmendPlaceOrdersResult(bean.checkForNull(bean.getOrderId(),""));

            _bw.write(_wl_block15Bytes, _wl_block15);
		
	} // End of old orderables
	// New Orders, Painting
	//IN051367 Starts
	String discharge_date_time = "";
	discharge_date_time = bean.getDischargeDateTime(bean.getPatientId(),bean.getEncounterId() );//IN050607
	String ordering_rule_yn = "";
	
	if(!"".equals(discharge_date_time))
	{
		bean.setDischargeDate(discharge_date_time);//IN050607
		ordering_rule_yn = bean.getOrderingRuleYn(order_category);//IN050607
	}
	//IN051367 Ends
	if(PlaceOrderItems!=null)
	{
		for(i=0; i<PlaceOrderItems.size(); i++)
		{
			String billinginterface="";
			String servicepanel="";
			String servicepanelcode="";
			String finbill="";
			String displaytooltip="";
			String locn_appt_reqd_yn="";
			String displays_style1="visibility:hidden";
			String displays_style2="visibility:hidden";
			String speciality_code[]=new String[3];
			ArrayList speciality=new ArrayList();
			int numbering=0;
			int non_billing_numbering=0;//IN072524
			String comment 			  = "";
			String pat_preps_instrns ="";
			String pat_preps_pat_instrns="";
			String pat_preps_dep_instrns="";			
			records =(String[])PlaceOrderItems.get(i); // String array
			comments = ""; pat_preps_instrn	=""; preps_instrn = "";  preps_dept_instrn = "";
			order_type_code = "";format_id_mandatory_yn = "N";	priority_value= "";frequency ="";
			if ( i% 2 == 0 )
			{
				classValue 			= "BODYCOLORFILLED" ;
				chk_class_value		= "BODYCOLORFILLED" ;
			}
			else
			{
				classValue		 	= "BODYCOLORFILLED" ;
				chk_class_value		= "BODYCOLORFILLED" ;
			}
			if(records[51].equalsIgnoreCase("Y"))
				chk_class_value		= "eORConsent" ;
			// Get the Values to be Defaulted, Putting into the string array to be retrieved later
			if(function_from.equals("COPY_ORDER"))
			{
				copyOrderDetails	 = bean.getCopyOrderIDDetails(); // Get the Order Id and order_line
				if(copyOrderDetails!=null)
				{
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
				Default = bean.getPlaceOrderDefault(records[0]);
			for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
				if(recordDefault!=null)
				{
					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
					if(qty_value.equals("0")) qty_value = "1";
					qty_uom			 =  bean.checkForNull(recordDefault[9],"");
					qty_uom_shortdesc			 =  bean.checkForNull(recordDefault[10],"");
				}
				else
				{
					qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
				}
			}
			// Till Here
			if(!records[3].equals("") && !old_order_category.equals(records[3]))
			{
				display_auth_count  = 0; display_cosign_count = 0; display_special_count=0;
				order_category_desc = bean.checkForNull((String)beanQueryObj.getOrderCategoryDesc(properties, records[3]),""); // Pass the Order Category
				clin_category_comments_reqd_yn = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, records[3]),"N"); // Pass the Order Category
				// Get the Format Id Logic
				order_types_comb		=
					bean.checkForNull(bean.getOrderTypes(previousValues),"");  
				//auth_reqd				= bean.getAccessReqd(records[3],"auth_yn");	// (order_category & auth_yn) Column Name. auth_yn is passed
 				cosign_reqd				= bean.getAccessReqd(records[3],"cosign_yn");	// (order_category & auth_yn) Column Name. auth_yn is passed
				/*if(fStatus[0].equals("Y"))
				auth_reqd="X";
				if(fStatus[1].equals("Y"))
				cosign_reqd="X";*/
				special_approval_reqd	= bean.getAccessReqd(records[3],"ord_spl_appr_reqd_yn");	// Column Name. auth_yn is passed
				// Get the Format Id for the Header
				format_id				= bean.checkForNull(bean.getFormatIdHdr(records[3], order_types_comb,bean.getSex(), bean.getDob()),""); //order_category
				FormatHdr				= beanQueryObj.getFormatID_YN(format_id);
				for(int j=0; j<FormatHdr.size(); j++)
				{
					format				   = (String[]) FormatHdr.get(j);
					format_id_mandatory_yn = bean.checkForNull(format[0], "");		
					format_id			   = bean.checkForNull(format[1], "");
				} 
				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
				{
					out.println("<input type='hidden' name='format_id_yn"+order_cat_count+"' id='format_id_yn"+order_cat_count+"' value='N'>");
				}
				else
				{
					out.println("<input type='hidden' name='format_id_yn"+order_cat_count+"' id='format_id_yn"+order_cat_count+"' value='Y'>");
				}
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(format_id_mandatory_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(clin_category_comments_reqd_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clin_category_comments_reqd_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block31Bytes, _wl_block31);
				
					if(!format_id.equals("")) 
					{
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block35Bytes, _wl_block35);

							if(format_id_mandatory_yn.equals("Y"))
								out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
							else
								out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
					} // End of if !format_id	
					
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_category_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

						if(clin_category_comments_reqd_yn.equalsIgnoreCase("Y"))
						{
							display_style="visibility:visible";
						}
						else
						{
							display_style="visibility:hidden";
						}
						
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block45Bytes, _wl_block45);
		

						if(records[48].equalsIgnoreCase("Y"))
						{
							PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth); 
							
					
							if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
							{
								displays_style1="display:inline";
								displays_style2="display:none";
							}else{
								displays_style1="display:none";
								displays_style2="display:inline";
							}
						}

					/*	if(!auth_reqd.equalsIgnoreCase("X")) 
						{ 
							displays_style1="visibility:visible";
							displays_style2="visibility:hidden";
						} 
						else 
						{
							displays_style1="visibility:hidden";
							displays_style2="visibility:visible";
						}	 */
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
				if(!PrivilegeApplicabilityAuthYN.equalsIgnoreCase("Y") || !cosign_reqd.equalsIgnoreCase("X")||			!special_approval_reqd.equalsIgnoreCase("X")) 
					{
						out.println("&nbsp;"); 
					}
					else
					{ 						out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PressLinkto.label","or_labels")+"</b>"); 
					}
					
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block49Bytes, _wl_block49);
out.println("<img id=\"textimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/Authorization.gif\" align=\"right\" style=\""+displays_style2+"\"> ");
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(displays_style2));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
							out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");
					
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
out.println("<img id=\"textcosignimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/Cosign_click.gif\" align=\"right\"> ");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block60Bytes, _wl_block60);

					 if(!cosign_reqd.equalsIgnoreCase("X")) 
					 {
						out.println("&nbsp;Cosign Reqd");
					} 
					else 
					{
					
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cosign_reqd));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 
				} 
				
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cosign_reqd));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
out.println("<img id=\"textspecialimg"+records[3]+order_cat_count+"\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"right\"> ");
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block68Bytes, _wl_block68);

					if(!special_approval_reqd.equalsIgnoreCase("X")) 
					{
						out.println("&nbsp;Special Approval Reqd");
					} 
					else 
					{
					
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(special_approval_reqd));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
 			
					}	
					
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(special_approval_reqd));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
			
			hide_count = order_cat_count; //use to hide the gifs authorize,cosign
			order_cat_count++; // Increment the order_category count 
		} // End of old_order_category

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(chk_class_value));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
  //added on 08/05/07		  
				if(records[51].equalsIgnoreCase("Y"))
				{
				
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);

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
										
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block106Bytes, _wl_block106);

										total_recs++;
										consentflag = false;
									}
								}
							}						
							
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block111Bytes, _wl_block111);
							
						}
						else
						{
							if(multiConsentDtls[0].equals("F"))
							{	
								if(!(bean.checkForNull(multiConsentDtls[3])).equals(""))
								{
									total_recs = total_recs ++;
								}
								
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);

							}
							
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block111Bytes, _wl_block111);

						}
						
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block120Bytes, _wl_block120);

					}        
				}//ends here
				
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[4]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block132Bytes, _wl_block132);

				  if(!bean.checkForNull(records[62],"").equals("")) 
				{
					out.println("<font size='1' color='RED'><b>[?]</b></font>");  //Explanatory Text is there for this catalog 
				}							speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);	
				if(speciality.size()>0)
				{
					for(int sc=0;sc<speciality.size();sc++)
					{
							speciality_code=(String[])speciality.get(sc);
					}
				}
				if(speciality_code[0].equalsIgnoreCase("Y"))
				{
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y"))// For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);

					}
				}
				else
			   {
					if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y"))// For Authorization Required
					{
						display_auth_count++;
						records[48]="Y";
						
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);

					}
			   }				
				if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y")) // For Cosign Required
				{
				    display_cosign_count++; 
					records[49]="Y";
					//id='cosign"+i+"' 
				
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);

				}
				if(records[50].equalsIgnoreCase("Y")) // For Special Approval
				{
				    display_special_count++;
					
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(records[3]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block140Bytes, _wl_block140);

				}
				
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block146Bytes, _wl_block146);

					PlaceOrderType = bean.getPlaceOrderType(records[0]);
					for(int j=0; j<PlaceOrderType.size(); j++)
					{
						orderTypeRecords = (String[]) PlaceOrderType.get(j);
						if(((String)previousValues.get("h2"+records[0])).equals(orderTypeRecords[0]))
						{
							order_type_code = orderTypeRecords[0];
							out.println(orderTypeRecords[1]);
							break; //come out of the loop;
						}
						else
						{
							order_type_code = orderTypeRecords[0];
							out.println(orderTypeRecords[1]); // otherwise last one
						}
					}
					
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block152Bytes, _wl_block152);

				if ( !((records[52]).equals("3")) && priority_value.equals("")) 
				{ 
					priority_value = "R";
				} 
				else if (priority_value.equals("") && ( ((records[52]).equals("")) || ((records[52]).equals("2"))) )
				{  
					priority_value = "U";
				} 
				else if(priority_value.equals("") && (((records[52]).equals("")) || ((records[52]).equals("3"))) ) 
				{
					priority_value = "S";
				} 
				else priority_value  = "R";
				// If it is called from MO module then it will be of Urgent priority
				if(function_from.equals("MO")) 
				{ 
					priority_value  = "U";
				}
				
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(priority_value));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[52]));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);

					if ( priority_value.equalsIgnoreCase("R")) 
					{ 
					
            _bw.write(_wl_block160Bytes, _wl_block160);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block162Bytes, _wl_block162);
} 
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

					} 
					else if(priority_value.equalsIgnoreCase("U")) 
					{ 
					
            _bw.write(_wl_block160Bytes, _wl_block160);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block162Bytes, _wl_block162);
} 
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

					} 
					else if(priority_value.equalsIgnoreCase("S")) 
					{ 
					
            _bw.write(_wl_block166Bytes, _wl_block166);
 if(!records[3].equals("OT")){ 
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(i));
            _bw.write(_wl_block162Bytes, _wl_block162);
} 
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

					}   
					
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block169Bytes, _wl_block169);

					if(!records[10].equalsIgnoreCase("N")) 
					{	
					
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);

					}
					
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
 if(records[10].equalsIgnoreCase("N")) out.println("READONLY"); 
            _bw.write(_wl_block177Bytes, _wl_block177);
 if (qty_uom.equals("")) 
						{
							out.println(records[68]);
						}
						else
						{			
							out.println(qty_uom_shortdesc);
						}
				
            _bw.write(_wl_block178Bytes, _wl_block178);

					if(!records[10].equalsIgnoreCase("N")) 
					{  
					
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);

					} 
					
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);

					if(patientDischargedYn.equalsIgnoreCase("N"))
					{
					
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block185Bytes, _wl_block185);
		
						PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","",""); // Pass the Order_category and catalog_code
						entered_yn			= "N";
						for(int j=0; j<PlaceOrderFrequency.size(); j++)
						{
							frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
							if(recordDefault!=null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2])) 
							{
								out.println(frequencyRecords[1]);
								entered_yn = "Y";
								frequency = bean.checkForNull(frequencyRecords[0]);
								break; // come out of the loop
							} // End of If
						} // End of For
						if(PlaceOrderFrequency.size()<=0 || entered_yn.equals("N") )						out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
						
            _bw.write(_wl_block186Bytes, _wl_block186);

					}
					
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block188Bytes, _wl_block188);

					if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
					if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
					if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
					if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
					if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
					if(recordDefault!=null && !recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("N")) 
					{ 
					
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block190Bytes, _wl_block190);

					} 
					if(patientDischargedYn.equalsIgnoreCase("N"))
					{
					
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(prompt_msg));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block196Bytes, _wl_block196);
if(recordDefault!=null && recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("Y")) out.println("readOnly");
            _bw.write(_wl_block197Bytes, _wl_block197);

					}
					else
					{
					
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block199Bytes, _wl_block199);

					}
					if(recordDefault!=null && !recordDefault[0].equals("") && patientDischargedYn.equalsIgnoreCase("N")) 
					{ 
					
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block201Bytes, _wl_block201);

					} 
					
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);

					PlaceOrderDuration = bean.getPlaceOrderDuration();					
					for(int j=0; j<PlaceOrderDuration.size(); j++)
					{
						durationRecords = (String[]) PlaceOrderDuration.get(j);
						if(recordDefault!=null && recordDefault[4].equalsIgnoreCase(durationRecords[0])) {
							out.println(durationRecords[1]);
							break; // come out of the loop
						}
					} // End of for
					
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block209Bytes, _wl_block209);
if(PlaceOrderDuration.size()>0) { 
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(durationRecords[0]));
            _bw.write(_wl_block209Bytes, _wl_block209);
} else { 
            _bw.write(_wl_block211Bytes, _wl_block211);
 } 
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(i));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(i));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(i));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(i));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName)));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(i));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(i));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(i));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(i));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block230Bytes, _wl_block230);
//if(records[3]!=null && ((records[3].equals("LB") && lb_instal_yn.equals("Y")) || (records[3].equals("RD") && rd_instal_yn.equals("Y")) || (!records[3].equals("NC")) ) ) {	changed on 7/9/2007 for lb_instal_yn by uma 			
				if((records[3].equals("LB") )|| (records[3].equals("RD")) || (records[3].equals("RX"))||(records[3].equals("TR")) ) 
				{ 
				
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(i));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rd_instal_yn));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(i));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rd_instal_yn));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block236Bytes, _wl_block236);
					
					performingLocationCode = bean.getPerformingLocation(records[3],((String)previousValues.get("h2"+records[0])),records[0]);	
					if(bean.getTempvalue("performing_facility_id"+records[0])==null)
					{
						for(int j=0; j<performingLocationCode.size(); j++)
						{
							performingLocation	= (String[]) performingLocationCode.get(j);
							//IN048942 - for preview screen performing location issue - Start		
							if(j==0)
								fac_selected = performingLocation[0];
							//if(performingLocation[0].equals(records[5])) //let the last one be selected
							if(performingLocation[0].equals(login_facility_id))//IN048942 - for preview screen performing location issue -End
							{
								out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
								fac_selected = performingLocation[0]; //IN048942 - for preview screen performing location issue
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
							//IN048942 - for preview screen performing location issue - Start	
							if(j==0)
								fac_selected = performingLocation[0];	
							//if(performingLocation[0].equals(bean.getTempvalue("performing_facility_id"+records[0]))) //let the last one be selected
							if(performingLocation[0].equals(login_facility_id))//IN048942 - for preview screen performing location issue - End
							{
								out.println("<option value=\""+performingLocation[0]+"\" selected>"+performingLocation[1]+" </option>");
								fac_selected = performingLocation[0]; //IN048942 - for preview screen performing location issue
							}
							else
							{
								out.println("<option value=\""+performingLocation[0]+"\">"+performingLocation[1]+" </option>");
							}
						}
					}
				
            _bw.write(_wl_block237Bytes, _wl_block237);

				}
				else
				{
					
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);
				
						if(login_facility_id.equalsIgnoreCase(records[5]))
							facility_name = PerformingFacilityName;
						else
							facility_name = bean.getPerformingFacilityName(records[5]);
					
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(i));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block152Bytes, _wl_block152);

				}
				
            _bw.write(_wl_block242Bytes, _wl_block242);

				if((records[3].equals("LB") )|| (records[3].equals("RD")) || (records[3].equals("RX"))||(records[3].equals("TR")) ||(records[3].equals("MI"))||(records[3].equals("PC"))) 
				{ 		
				
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[5]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(lb_instal_yn));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rd_instal_yn));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(fac_selected));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(orderTypeRecords[0]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rd_instal_yn));
            _bw.write(_wl_block247Bytes, _wl_block247);
					//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], 					records[0],records[3],lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn by uma
					//IN048942 - Modified Start
					//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(records[5], 					records[0],records[3],orderTypeRecords[0],rd_instal_yn);
					ArrayList DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],records[3],orderTypeRecords[0],rd_instal_yn);
					String def_yn = "N"; 
					//IN048942 - Modified End
						if(DeptLocationCode.size()>0)
						{
							for(int j=0; j<DeptLocationCode.size(); j++)
							{
								deptLocation	= (String[]) DeptLocationCode.get(j);
								if(deptLocation[2] != null && deptLocation[2].equals("Y"))
								{  
									out.println(""+deptLocation[1]+"");
									depLocation_code = deptLocation[0];									
									locn_appt_reqd_yn=beanQueryObj.getApptReqdYN(properties,records[0],depLocation_code);
									def_yn = "Y"; //IN048942
									break;
								}
								//Commentted IN048942
								/*else
								{
									out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
									depLocation_code = "";
									break;
								}*/
							}
							//IN048942 - Added Start
							if("N".equals(def_yn)) 
							{		out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
								depLocation_code = "";
							}
							//IN048942 Added End
						}
						else
						{	out.println("----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						//IN052765 starts
							if(!depLocation_code.equals(""))
								depLocation_code = "";		
						//IN052765 ends
						}
				}   // End of records[3] (order_category) and lb_install
				else
				{
					
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);

				}
				
            _bw.write(_wl_block249Bytes, _wl_block249);

				try
	{
		con				=	ConnectionManager.getConnection(request);
	//IN066377 start
		String sql = "select * from OR_ORDER_PERF_LOCN_MAND where order_category=?";
		pstmt = con.prepareStatement(sql);
		//pstmt.setString(1,order_category);
		pstmt.setString(1,records[3]);
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
            _bw.write(_wl_block250Bytes, _wl_block250);
if(("RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && "Y".equals(rd_instal_yn)){
            _bw.write(_wl_block251Bytes, _wl_block251);
}
            _bw.write(_wl_block178Bytes, _wl_block178);
if((!"RD".equals(order_category)) && ("Y".equals(perfLocnMandFlag)) && !(records[4]).equals(bt_order_type_code)){
            _bw.write(_wl_block251Bytes, _wl_block251);
}
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(depLocation_code));
            _bw.write(_wl_block254Bytes, _wl_block254);

					// Line Level check			
					format_id = bean.checkForNull(records[47],"");
					if(!records[47].trim().equals(""))
					{
						stFormatID 	= new StringTokenizer(records[47],"~");
						while(stFormatID.hasMoreTokens())
						{
							format_id_mandatory_yn  = stFormatID.nextToken();
							format_id 				= stFormatID.nextToken();
						}
						stFormatID	= null;
					}
					
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(i));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(i));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);

				secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass()); //Pass the catalog_code and patient_class			
				if (bean.checkForNull((String)secondaryOrders[0]).equals("Y"))
				{     
					 sec_start_date_time = bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""); // Pass the catalog_code, prioriy (default as "R") and patient_class
					 sec_start_date_time=com.ehis.util.DateUtils.convertDate(sec_start_date_time,"DMYHM","en",localeName);
					
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(i));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(sec_start_date_time));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(i));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block265Bytes, _wl_block265);
				} 
            _bw.write(_wl_block2Bytes, _wl_block2);

				if(!format_id.equals(""))  // check for the Format
				{
					if(format_id_mandatory_yn.equalsIgnoreCase("Y"))
					{  // checking to set the value as 'Y' if values r present in the bean
						format_mandatory_count++;
					}
					else
					{
						//out.println("<script>setOrderFormatLine('"+i+"','Y')</script>");
	 	    			format_count++;
		 	   		} // else of format_id_mandatory_yn
		 	   	}

            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(i));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(secondaryOrders[1]));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(i));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(format_id_mandatory_yn));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(i));
            _bw.write(_wl_block272Bytes, _wl_block272);

				boolean show_bill_dtls = false;//IN065324

				//IN065324, starts
				if(is_bt_view_bill_dtls && "BT".equals(records[43].trim()) && "OP".equals(l_patient_class) || "EM".equals(l_patient_class) || !"BT".equals(records[43].trim()))
				{
					show_bill_dtls = true;
				}
				//IN065324, ends

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billinginterface="interface";
					billing_call_yn		= "Y";
					//IN072524 Starts
					fpp_patient_yn = bean.getFpp_patient_yn();
					if("Y".equals(fpp_patient_yn) && "Y".equals(records[74])){
						BillChargeInfo		= bean_qryobj.getBillChargeDetailsfpp(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId(),records[74],records[75]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					else{
						BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString, localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
					}
					//IN072524 Ends
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
							setBills_dtls.put("preapp_yn"        , billing_details[5]);
							setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							setBills_dtls.put("error_text"		 , billing_details[9]);
							setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							setBills_dtls.put("rate"		 , "");
							setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
							setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
							setBills_dtls.put("fpp_yn"		 , records[74]);//IN073309
							setBills_dtls.put("fpp_category"		 , records[75]);//IN073309
							 //out.println(billing_details[9]);
							servicepanel=bean.checkForNull(billing_details[10],"");
							servicepanelcode=bean.checkForNull(billing_details[11],"");
							orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 

							if(!billing_details[9].equals(""))
							{numbering=1;finbill="Billing";
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(i));
            _bw.write(_wl_block276Bytes, _wl_block276);
 displaytooltip=billing_details[9];
							} 
							if(billing_details[10].equals("")&&billing_details[11].equals(""))
							{
							numbering=1;
							
		
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(i));
            _bw.write(_wl_block279Bytes, _wl_block279);
 displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
							displaytooltip=displaytooltip.replace("{1}",records[0]);
							}}
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
											}//else
											//{
												//	hashEntry.remove(entryValue);
											//}
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

						//}
					//}
				
				
				
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
				
			

            _bw.write(_wl_block280Bytes, _wl_block280);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block281Bytes, _wl_block281);
}else{
            _bw.write(_wl_block282Bytes, _wl_block282);
}
            _bw.write(_wl_block283Bytes, _wl_block283);
if("Y".equals(fpp_patient_yn)){//IN073309 
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(i));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(records[74]));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block288Bytes, _wl_block288);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(i));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(i));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(i));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf("S".equals(records[75])?"selected":""));
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf("M".equals(records[75])?"selected":""));
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf("C".equals(records[75])?"selected":""));
            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);
}//IN073309 
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block298Bytes, _wl_block298);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block300Bytes, _wl_block300);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block300Bytes, _wl_block300);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);

							}
							
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(i));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf((((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"visible":"hidden")));
            _bw.write(_wl_block309Bytes, _wl_block309);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(i));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(i));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf((((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))?"checked":"")));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(i));
            _bw.write(_wl_block314Bytes, _wl_block314);
if(((bean.checkForNull(records[33]).equalsIgnoreCase("Y"))&&(bean.checkForNull((String)bill_dtls.get("Future_order_yn")).equalsIgnoreCase("Y")))){
            _bw.write(_wl_block315Bytes, _wl_block315);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block316Bytes, _wl_block316);
}
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(i));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(i));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block321Bytes, _wl_block321);

							if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
							{
							
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(i));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(i));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block326Bytes, _wl_block326);

							}
							
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(i));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(i));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(i));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(i));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(billing_details[18]));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(i));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(i));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(billing_details[19]));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(i));
            _bw.write(_wl_block336Bytes, _wl_block336);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block337Bytes, _wl_block337);
				} else {billing_call_yn = "N"; 
					       out.println("&nbsp;");}

				//IN072654 Starts
				HashMap<String, String> interactionYN = null;
				String checkUncheck =null;
				
				HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = null;
				if("LB".equals(order_category)){
					
						bean.chkDrugInteractionForLB(records[0],com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName));
					
						interactionYN=bean.getDruginteractionYN();
						interdrugDtls = bean.getDruginteractionDtl();
						if(null!=interdrugDtls)
							drugintercnt =	interdrugDtls.size();
						
						checkUncheck =	interactionYN.get(records[0]);
				
					if("R".equals(checkUncheck)){
					
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block339Bytes, _wl_block339);
}
				}
				//IN072654 ENDS
					
            _bw.write(_wl_block340Bytes, _wl_block340);
if(numbering==0)
					{
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(i));
            _bw.write(_wl_block343Bytes, _wl_block343);

				//if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))//IN065324
				if(billing_interface_yn.equals("Y") && records[38].equals("Y") && show_bill_dtls)//IN065324
				{
					billing_call_yn		= "Y";
					//if(numbering==0)
					//{

            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(i));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")));
            _bw.write(_wl_block346Bytes, _wl_block346);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(i));
            _bw.write(_wl_block348Bytes, _wl_block348);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block349Bytes, _wl_block349);
				} else billing_call_yn = "N"; 
            _bw.write(_wl_block350Bytes, _wl_block350);
}else{
            _bw.write(_wl_block351Bytes, _wl_block351);
}
            _bw.write(_wl_block352Bytes, _wl_block352);

				/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
				if(records[48].equalsIgnoreCase("Y"))
				{
					PrivilegeApplicabilityAuthYN = (String)bean.getAuthorisationRights(records[0],PrivilegeApplicabilityAuth); 
					
			
					if(PrivilegeApplicabilityAuthYN.equalsIgnoreCase("N"))
					{
						numbering=1;		
						non_billing_numbering=1;//IN072524
						billinginterface = "auth_interface";
					
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(i));
            _bw.write(_wl_block356Bytes, _wl_block356);
 		
							displaytooltip=bean.getMessage(localeName,"PRIV_ORDER_AUTH_RIGHTS","OR");
							displaytooltip=displaytooltip.replace("{1}",records[0]);
						//orderEntryRecordBean.setCheckedEntries(key, hashEntry);
					}
				}
				if(records[69].equalsIgnoreCase("N"))
				{
					numbering=1;		
					non_billing_numbering=1;//IN072524
					billinginterface = "operational_interface";
					
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(i));
            _bw.write(_wl_block359Bytes, _wl_block359);
 		
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
						non_billing_numbering=1;//IN072524
						billinginterface="or_ordering_rule_chk";
					
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(i));
            _bw.write(_wl_block361Bytes, _wl_block361);

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
					/*Ends Here*/
				
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(i));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frequency));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(i));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(i));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(i));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frequency_val));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(i));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(i));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(i));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(i));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(i));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(i));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(i));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(i));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(i));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[2]));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(i));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[11]));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(i));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[14]));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(i));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[19]));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(i));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[20]));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(i));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[22]));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(i));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[23]));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(i));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[24]));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(i));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[25]));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(i));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[26]));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(i));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[27]));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(i));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[28]));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(i));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[29]));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(i));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[33]));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(i));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locn_appt_reqd_yn));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(i));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[34]));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(i));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[35]));
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(i));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[37]));
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(i));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[38]));
            _bw.write(_wl_block414Bytes, _wl_block414);
            out.print( String.valueOf(i));
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[39]));
            _bw.write(_wl_block416Bytes, _wl_block416);
            out.print( String.valueOf(i));
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[40]));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(i));
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[41]));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(i));
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[43]));
            _bw.write(_wl_block422Bytes, _wl_block422);
            out.print( String.valueOf(i));
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[44]));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(i));
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[48]));
            _bw.write(_wl_block426Bytes, _wl_block426);
            out.print( String.valueOf(i));
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[49]));
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(i));
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[50]));
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(i));
            _bw.write(_wl_block431Bytes, _wl_block431);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[51]));
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(i));
            _bw.write(_wl_block433Bytes, _wl_block433);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[53]));
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(i));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[54]));
            _bw.write(_wl_block436Bytes, _wl_block436);
            out.print( String.valueOf(i));
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[55]));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(i));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[56]));
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(i));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[57]));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(i));
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[58]));
            _bw.write(_wl_block444Bytes, _wl_block444);
            out.print( String.valueOf(i));
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[59]));
            _bw.write(_wl_block446Bytes, _wl_block446);
            out.print( String.valueOf(i));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[60]));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(i));
            _bw.write(_wl_block449Bytes, _wl_block449);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[61]));
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(i));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[64]));
            _bw.write(_wl_block452Bytes, _wl_block452);
            out.print( String.valueOf(i));
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[65]));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(i));
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(billinginterface));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(i));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(servicepanel));
            _bw.write(_wl_block458Bytes, _wl_block458);
            out.print( String.valueOf(i));
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(servicepanelcode));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(i));
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(numbering));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(i));
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finbill));
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(i));
            _bw.write(_wl_block465Bytes, _wl_block465);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull(records[66],"N")));
            _bw.write(_wl_block466Bytes, _wl_block466);
            out.print( String.valueOf(i));
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(i));
            _bw.write(_wl_block468Bytes, _wl_block468);
if(speciality_code[0].equalsIgnoreCase("Y"))
				{
				
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(i));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code[1]));
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(i));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code[2]));
            _bw.write(_wl_block152Bytes, _wl_block152);

				}
				else
			   {
				
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(i));
            _bw.write(_wl_block470Bytes, _wl_block470);
            out.print( String.valueOf(i));
            _bw.write(_wl_block473Bytes, _wl_block473);
            out.print( String.valueOf(i));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull(records[67],"N")));
            _bw.write(_wl_block152Bytes, _wl_block152);

				}
				
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(i));
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(perfLocnMandFlag));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(i));
            _bw.write(_wl_block477Bytes, _wl_block477);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block478Bytes, _wl_block478);
            out.print( String.valueOf(i));
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(billing_call_yn));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(i));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(i));
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(i));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(i));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(i));
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(i));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(i));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(i));
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(i));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(preps_instrn));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(i));
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_preps_instrn));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(i));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(preps_dept_instrn));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(i));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block120Bytes, _wl_block120);
if(numbering==1){
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(displaytooltip));
            _bw.write(_wl_block254Bytes, _wl_block254);
}else{
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block499Bytes, _wl_block499);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull(records[62],"")));
            _bw.write(_wl_block501Bytes, _wl_block501);
}
            _bw.write(_wl_block502Bytes, _wl_block502);
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(i));
            _bw.write(_wl_block504Bytes, _wl_block504);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.checkForNull(records[63],"")));
            _bw.write(_wl_block505Bytes, _wl_block505);
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(i));
            _bw.write(_wl_block507Bytes, _wl_block507);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[70]));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(i));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[71]));
            _bw.write(_wl_block510Bytes, _wl_block510);
            out.print( String.valueOf(i));
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[72]));
            _bw.write(_wl_block512Bytes, _wl_block512);
            out.print( String.valueOf(i));
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(records[73]));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(i));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(i));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(non_billing_numbering ));
            _bw.write(_wl_block517Bytes, _wl_block517);
	
			if(!records[3].equals("") && !old_order_category.equals(records[3]))

				out.println("<script>setTimeout('hideGifs("+hide_count+",\""+records[3]+"\","+display_auth_count+","+display_cosign_count+","+display_special_count+")',100);</script>"); // hide the gifs 
				
				if(patientDischargedYn.equalsIgnoreCase("N"))
				{
					out.println("<script>setFrequency(document.placeOrderForm.temp_frequency_code"+i+","+i+",'"+records[0]+"','"+bean.getLoginFacilityId()+"','onLoad')</script>");
				}

            _bw.write(_wl_block2Bytes, _wl_block2);
		
			old_order_category = records[3]; // Assign the order_category

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
						pat_preps_pat_instrns=bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
						pat_preps_dep_instrns=bean.checkForNull((String) arrSeqNo.get(2),""); // dep instrns
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
						pat_pat_preps_instrns 		= bean.checkForNull((String)instructionsMap.get(patpreps),"");  // For Patient Preps. Insructions.
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
					
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(i));
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(EnableEmail));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
	} 	
	if(PlaceOrderItems==null || PlaceOrderItems.size()==0){

            _bw.write(_wl_block520Bytes, _wl_block520);
	}

            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(patient_email_id));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(order_cat_count));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block524Bytes, _wl_block524);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(i));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(old_order_category));
            _bw.write(_wl_block527Bytes, _wl_block527);
            out.print( String.valueOf(lb_instal_yn));
            _bw.write(_wl_block528Bytes, _wl_block528);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(display_auth_count));
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(bean.getLoginFacilityId()));
            _bw.write(_wl_block531Bytes, _wl_block531);
            out.print( String.valueOf(bean.getPractitionerId()));
            _bw.write(_wl_block532Bytes, _wl_block532);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf(p_task_code));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf(p_task_srl_no));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(bean.getSex()));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(bean.getDob()));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(ref_facility_id));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(ref_date_time));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(ref_sent_pract_id));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(ref_sent_remarks));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(dupchk_siteSpecFlag));
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(format_mandatory_count));
            _bw.write(_wl_block553Bytes, _wl_block553);
            out.print( String.valueOf(bt_order_type_code));
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(drugintercnt ));
            _bw.write(_wl_block555Bytes, _wl_block555);
	
		// Nullifying the Objects
		previousValues			= null;				// Nullifying the Objects
		PlaceOrderItems			= null;		Default				= null;
		PlaceOrderType			= null;		PlaceOrderFrequency	= null;
		PlaceOrderDuration		= null;		FormatHdr			= null;
		stFormatID				= null;		copyOrderDetails	= null;
		secondaryOrders			= null;

            _bw.write(_wl_block556Bytes, _wl_block556);
            out.print( String.valueOf(display_auth_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(format_mandatory_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(format_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_cosign_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_special_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_start_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drugintercnt));
            _bw.write(_wl_block557Bytes, _wl_block557);

	// set it back persistence
	putObjectInBean(bean_id,bean,request);
	//if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
	//  putObjectInBean(existing_bean_id,external_bean_obj,request);
	//} // End of function-from


            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialApproval.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orderable.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PerformingLocation.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FPPCATEGORY.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Simple.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Medium.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Complex.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillLater.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApptRequired.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
