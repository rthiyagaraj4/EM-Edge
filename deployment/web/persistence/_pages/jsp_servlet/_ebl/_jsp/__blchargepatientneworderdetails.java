package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import eBL.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blchargepatientneworderdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientNewOrderDetails.jsp", 1738010364711L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<title>Details</title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\"\thref=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../js/BLChargeEncounterNewOrder.js\'></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BLChargePatient.js\"></script>\n<script language=\'javascript\' src=\'../js/json2.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\n<script language=\'javascript\'>\n\t$(document).ready(function(){\n\t\t$(\'td[id^=rcrdAdhiocDisc]\').each(function(){\n\t\t\t$(this).hide();\t\t\n\t\t});\n\t\tfindTotal();\t\n\t\t\n\t\t$(\'td[id^=rcrdAdhocDiscPP]\').each(function(){\n\t\t\t$(this).hide();\t\t\n\t\t});\n\t\t\n\t\t$(\'td[id^=rcrdAdhocDiscAR]\').each(function(){\n\t\t\t$(this).hide();\t\t\n\t\t});\n\t\t\n\t\t\nvar noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find(\'#noOfDecimals\').val();\n\t\t\n\t\t//alert(\"noOfDecimals \"+noOfDecimals);\n\t\t\n\t\t$(\'[id^=rate_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n\t\t$(\'[id^=grossAmt_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t$(\'[id^=qty_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n\n\t\t$(\'[id^=total_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n\n\t\t$(\'[id^=patPayable_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n$(\'[id^=patPaid_] \').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n\t\t\n\t\t\n$(\'[id^=addlCharges_] \').each(function(){\n\t\t\t\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t\n\t});\n\t\t\n$(\'[id^=servDisc_] \').each(function(){\n\tif($(this).val() != \'\'){\n\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t}\n\telse{\n\t\t$(this).val(\'0\');\n\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t}\n\n});\n\n\t\t\n\t\t$(\'[id^=net_amount]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text_WOR($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text_WOR($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=pat_payable_amount]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text_WOR($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text_WOR($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t\n\t\t\n\n\t\t\n\t});\t\n\t\nasync function captureRemarks(indx){\n\n\t\tvar dialogHeight= \"23vh\" ;\n\t    var dialogWidth      = \"26vw\" ;\n\t    var dialogTop = \"200\" ;\n\t    var center = \"1\" ;                                                                                              \n\t    var status=\"no\";\n\t    var features  = \"overflow:auto; scrollbars:no; dialogHeight:\"+dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t    var arguments = \"\" ;                 \n\t\tvar remarks = $(\'#remarksDtl_\'+indx).val();\n\t\n        var retVal =await window.showModalDialog(\"../../eBL/jsp/BLCaptureRemarks.jsp?remarks=\"+encodeURIComponent(remarks),arguments,features);   \n        if(retVal != undefined){\n        \t$(\'#remarksDtl_\'+indx).val(retVal);\n        }\n\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\t\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\t\n\n\tTD.greyedData\n\t\t{\n\t\t\tBACKGROUND-COLOR: #A3A3A3 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tcolor : #FFFFFF;\n\t\t}\t\n\t\t\n\t\t.label\n\t\t{\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tFONT-FAMILY : verdana;\n\t\t\tcolor : #000000;\n\t\t}\n\t\t.contextMenu\n{\n\tborder-left:1px;\n\tborder-right:1px;\n\tborder-top:1px;\n\tborder-bottom:1px;\n\tborder-color:#9C9C9C;\n\tborder-style:solid;\n\tmargin:0;\n\tbackground-color: #E7E7E7;\n\tborder-collapse: collapse;\n\tpadding-left:20px;\n\tpadding-right:20px;\n}\n.contextMenuItem\n{\n\theight:22px;\t\t\t\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\t\t\t\n\tvertical-align:middle;\n\tpadding-left:20px;\n\tpadding-right:20px;\n}\n.selectedcontextMenuItem\n{\n\tbackground-color: #D1D1D1;\t\t\t\t\t\t\t\t\n\theight:22px;\t\t\t\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\t\t\t\n\tvertical-align:middle;\n\tpadding-left:20px;\n\tpadding-right:20px;\n}\n\t\t</style>\n</head>\n</head>\n<body>\n\t<form name=\'newOrderDtlFrm\' id=\'newOrderDtlFrm\' method=\"post\" action=\"../../servlet/eBL.BLChargePatientNewOrderServlet\">\n\t\t<table width=\'150%\' align=\"center\" class=\'grid\' border=\'1\'  cellpadding=\'3\'  cellspacing=0 id=\'serviceDtls\'>\n\t\t<div id=\"tableContainer\">\n\t\t<thead style=\"position: sticky;z-index: 1;top: 0;\">\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tS No\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;\n\t\t\t\t\t<a id=\"resizeLink\" href=\'javascript:detailsResizeFrames()\' style=\"visibility: visible;\"><img id=\"resizeBtn\" alt=\"\" src=\"../../eOT/images/ShowLess.gif\" style=\"visibility: visible;\"> </a>\n\t\t\t\t\t<a id=\"resetLink\" href=\'javascript:resultResetFrames()\' style=\"visibility: hidden;\"><img id=\"resetBtn\" alt=\"\" src=\"../../eOT/images/ShowMore.gif\" style=\"visibility: hidden;\"></a>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' colspan=\'3\' id=\'rcrdAdhiocDiscS1\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' id=\'rcrdAdhocDiscARL\'>\n\t\t\t\t\tAction Reason\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tUOM\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPract Staff\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t Doctor Name&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap=\"nowrap\"  class=\'COLUMNHEADER\'>\n\t\t\t\t\tPract/Staff Type\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' id=\'rcrdAdhocDiscPPL\'>\n\t\t\t\t\tPatient Paid\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tRemarks\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPre-Approval\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t<!-- <tr>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tAmount\n\t\t\t\t</td>\t\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPercentage\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' id=\'rcrdAdhiocDiscSA1\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' id=\'rcrdAdhiocDiscSB1\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\' id=\'rcrdAdhiocDiscSC1\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td nowrap=\"nowrap\" class=\'COLUMNHEADER\'>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr> -->\n\t\t</thead>\n\t\t<tbody>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<tr id=\'tr_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' data-id=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t<td id=\'tdSno_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t\t<td id=\'td_serv_code_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' style=\'cursor:pointer\' onclick=\"newOrderTooltip(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");\" onmouseover=\"hideToolTip();\" nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<input type=\'hidden\' id=\'servCode_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' name=\'servCode_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\t\t\n\t\t\t\t\t<input type=\'hidden\' id=\'deleteFlag_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' name=\'deleteFlag_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'\'>\t\t\n\t\t\t\t\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<input type=\'hidden\' id=\'servDesc_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' name=\'servDesc_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\n\t\t\t\t\t<input type=\'text\' data-id=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\'dateTime_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'dateTime_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' size=\'15\' maxlength=\'19\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onblur=\'isValidDateTime(this);chkDupl(servCode_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =",this,";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =");\'/>\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'endDate_ctrl";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\"return showCalendar(\'dateTime_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'dd/mm/yyyy\',\'hh:mm:ss\');\" />\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<input type=\'hidden\' id=\'servOrPanel_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' name=\'servOrPanel_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t<input type=\'hidden\' id=\'rateInd_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' name=\'rateInd_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' align=\'right\' name=\'rate_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'rate_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' sistyle=\'text-align:right\'ly size=\"10\" readonly value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' id=\'qty_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' name=\'qty_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' size=\"5\"   onkeypress=\"\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" onblur= \' checkZero(this); checkNegativeQtyPriv(\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\");putdecimal(this);  updateNetAmount(\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\");  \'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'qtyhidden_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'qtyhidden_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' name=\'grossAmt_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'grossAmt_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' id=\'qty_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' size=\"3\" maxlength=\"3\" readonly value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' name=\'grossAmt_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' sistyle=\'text-align:right\'ly size=\"10\"  value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" onblur=\'putdecimal(this);updateNetAmountForCharge(\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\");\'>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' name=\'servDisc_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'servDisc_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhiocDiscDD";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t\t\t\t<input type=\'text\' name=\'servDiscPerc_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'servDiscPerc_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' size=\"10\" readonly value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhiocDiscDA";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t\t\t\t<select name=\'adhocRate_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'adhocRate_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' onchange=\"changeDiscInd(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\">\n\t\t\t\t\t\t<option value=\'\'  >--";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="--</option>\n\t\t\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</option>\n\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</option>\n\t\t\t\t\t</select>\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhiocDiscDB";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t\t\t<input type=\'text\' name=\'adhocDisc_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'adhocDisc_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' size=\"3\"  value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" onBlur=\"if(this.value!=\'\'){ findPatPayable(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',this);}\">\n\t\t\t\t\t<input type=\'hidden\' name=\'adhocAmount_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'adhocAmount_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhiocDiscDC";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t\t\t\t\t<input type=\'text\' name=\'adhocReason_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'adhocReason_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' size=\"10\" onblur=\"callCommonValidation(2,adhocReasonName_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =",adhocReason_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =")\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >&nbsp;\n\t\t\t\t\t<input type=\'hidden\' name=\'adhocReasonName_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'adhocReasonName_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' value=\'\'>\n\t\t\t\t\t<input type=\'button\'  id=\'adhocReason_but_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' value=\'?\' onclick=\'callCommonValidation(2,adhocReasonName_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =")\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t<Select id=\'policyIncl_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' name=\'policyIncl_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t\t\t<option value=\'I\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">Included</option>\n\t\t\t\t\t\t<option value=\'E\' ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =">Excluded</option>\n\t\t\t\t\t</Select>\n\t\t\t\t\t<input type=\'hidden\' id=\'originalIncl_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' name=\'originalIncl_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t\t\t\t<input type=\'hidden\' id=\'override_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' name=\'override_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhocDiscAR";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' name=\'addlCharges_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'addlCharges_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' sistyle=\'text-align:right\'ly size=\"10\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" onblur=\"if(this.value != \'\'){ callCommonValidation(2,addlCharges_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =",reasCode";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="); } else{ clearCode(reasCode";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="); }\">\n\t\t\t\t\t<input type=\'hidden\' id=\'reasCode";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' name=\'reasCode";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' value=\"\">\n\t\t\t\t\t<input type=\'button\'  id=\'reasBut_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' value=\'?\' onclick=\"callCommonValidation(2,addlCharges_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =");\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t<input type=\'hidden\' id=\'policyIncl_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t\t\t\t\t<input type=\'hidden\' id=\'reasCode";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' value=\"\">\n\t\t\t\t\t<input type=\'button\' disabled id=\'reasBut_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' value=\'?\' onclick=\"callCommonValidation(2,reasCode";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =",addlCharges_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =")\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' id=\'uom_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' name=\'uom_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' size=\"3\" readonly value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" >\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<select name=\'practStaffInd_";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' id=\'practStaffInd_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' onchange=\"pracstaffchange(\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\');\">\n\t\t\t\t\t\t<option value=\'P\' ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =" >Practitioner</option>\n\t\t\t\t\t\t<option value=\'O\' ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =">Other Staff</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'drName_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'drName_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' size=\"10\" onblur=\"if(this.value != \'\'){ doctorCodeValidation(1,docNam";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =",drName_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =",practStaffInd_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =",";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =",1); } else{clearCode(docNam";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="); clearCode(practStaffType";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =");}\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'docNam";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'docNam";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' onblur=\"if(this.value != \'\'){ doctorCodeValidation(1,docNam";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =",2); } else{clearCode(drName_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =");}\"value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\t\t\t\t\t\n\t\t\t\t\t<input type=\'button\'  id=\'drName_but_";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' value=\'?\' onclick=\"doctorCodeValidation(1,docNam";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 =",2)\">\n\t\t\t\t\t<input type=\'hidden\' id=\'hdnDoctor";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' name=\'hdnDoctor";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\"   class=\'fields\'>\n\t\t\t\t\t<input name=\'practStaffType";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' id=\'practStaffType";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'  value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' readonly></td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' id=\'total_";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' name=\'total_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' style=\'text-align:right\' size=\"10\" readonly value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' id=\'patPayable_";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' name=\'patPayable_";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' style=\'text-align:right\' size=\"10\" readonly  value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t\t<input type=\'hidden\' id=\'hdnTotal_";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t\t\t\t<input type=\'hidden\' id=\'hdnPatPayable_";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\' id=\'rcrdAdhocDiscPP";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t\t\t<input type=\'text\' style=\'text-align:right\' id=\'patPaid_";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' name=\'patPaid_";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' style=\'text-align:right\' size=\"3\" readonly value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" >\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<span style=\"color: blue;\" onclick=\"javascript:captureRemarks(\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\')\">Remarks</span>\n\t\t\t\t\t<input type=\'hidden\' name=\'remarksDtl_";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' id=\'remarksDtl_";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' nowrap=\"nowrap\" class=\'fields\'>\n\t\t\t\t\t<input type=\'checkbox\' name=\'preAppReq_";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' id=\'preAppReq_";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =" onclick=\"return false;\">\n\t\t\t\t\t<input type=\'hidden\' name=\'panelStr_";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' id=\'panelStr_";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'editPanel_";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'editPanel_";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'10\' align=\"right\">\n\t\t\t\t\t<input type=\'button\' value=\'Record\' onclick=\'recordDetails();\'>\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\'5\' class=\'label\'>\n\t\t\t\t\tTOTAL AMOUNT (NET)\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td style=\'text-align:right\' nowrap=\"nowrap\">\n\t\t\t\t\t<span id=\'net_amount\'>\n\t\t\t\t\t</span>\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td style=\'text-align:right\' nowrap=\"nowrap\">\n\t\t\t\t\n\t\t\t\t\t<span id=\'pat_payable_amount\'></span></td>\n\t\t\t</tr>\n\t\t\t\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' id=\'rowCount\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n      \t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'>\n      \t\n\t</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:8%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t<!-- </td> -->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n</TBODY>\t\n\t\n\t</div>\n</html>\n\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );
	
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

private String qtydecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
BLChargePatientNewOrderBean chargeBean = null;
String beanId = "BLChargePatientNewOrderBean";
String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date dt = new Date();
String today = "";//sdf.format(dt);
String setServDiscount="0";
String setPatNetChargeAmt="";
String setNetChargeAmount="";

ArrayList<BLChargePatientNewOrderBean> serviceList = null;
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
try{
	chargeBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
	serviceList = chargeBean.getServicesList();
	if(serviceList == null){
		serviceList = new ArrayList<BLChargePatientNewOrderBean>();
	}
	
	con = ConnectionManager.getConnection();
	pstmt = con.prepareStatement("Select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') today from dual");
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		today = rst.getString("today");
	}
}
catch(Exception e){
	System.err.println("Exception in BLChargePatientNewOrderDetails.jsp ->"+e);
}
finally{
	pstmt = null;
	rst = null;
	ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			int indx = 0;
			for(BLChargePatientNewOrderBean bean : serviceList){
				indx++;
				if(!("R".equals(bean.getRateIndicator()))){
					
					setPatNetChargeAmt=checkForNull(bean.getBaseChargeAmt());
					setNetChargeAmount=checkForNull(bean.getBaseChargeAmt());
					setServDiscount	= "0";
					
				}else{
					setPatNetChargeAmt=checkForNull(bean.getPatNetChargeAmt());
					setNetChargeAmount=checkForNull(bean.getNetChargeAmount());
					setServDiscount=checkForNull(bean.getServDiscount());
				}
				
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.getBlngServCode() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.getBlngServCode()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean.getBlngServDesc() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.getBlngServDesc()));
            _bw.write(_wl_block36Bytes, _wl_block36);
if("".equals(checkForNull(bean.getDateTime()))){ 
					bean.setDateTime(today);
				}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkForNull(bean.getDateTime()) ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block45Bytes, _wl_block45);

					if("S".equals(bean.getServOrPanel())){ 
						out.print("Service");
					}
					else{
						out.print("Panel");
					}
					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.getServOrPanel()));
            _bw.write(_wl_block48Bytes, _wl_block48);
if("R".equals(bean.getRateIndicator())){ 
						out.print("Rate");
					}
					else{
						out.print("Charge");
					}
					
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.getRateIndicator()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( checkForNull(bean.getRate()) ));
            _bw.write(_wl_block54Bytes, _wl_block54);
if("R".equals(bean.getRateIndicator())){ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(qtydecimal(checkForNull(bean.getQuantity())) ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(qtydecimal(checkForNull(bean.getQuantity())) ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkForNull(bean.getBaseChargeAmt()) ));
            _bw.write(_wl_block64Bytes, _wl_block64);
} else{ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(qtydecimal(checkForNull(bean.getQuantity())) ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(checkForNull(bean.getBaseChargeAmt()) ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block70Bytes, _wl_block70);
} 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(setServDiscount ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(checkForNull(bean.getServDiscPerc()) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf("A".equals(bean.getAdhocRate())?"selected":"" ));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf("P".equals(bean.getAdhocRate())?"selected":"" ));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(checkForNull(bean.getAdhocPerc()) ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getAdhocAmount()) ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(bean.getAdhocReason() ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block103Bytes, _wl_block103);
if("Y".equals(bean.getOverrideInd())){ 
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf("I".equals(bean.getPolicyIncl())?"selected":"" ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf("E".equals(bean.getPolicyIncl())?"selected":"" ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getOrgIncl()) ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getOverrideInd()) ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(checkForNull(bean.getAddlCharges()) ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
				else{
					
					if(!("L".equals(bean.getServOrPanel()))){
						if("I".equals(bean.getPolicyIncl())){
							out.print("Included");   
						}
						else{
							out.print("Excluded");
						}
				}
				 
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getPolicyIncl()) ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getOverrideInd()) ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkForNull(bean.getAddlCharges()) ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block129Bytes, _wl_block129);
} 
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(checkForNull(bean.getUomCode()) ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf("P".equals(bean.getPractStaffInd())?"selected":"" ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf("O".equals(bean.getPractStaffInd())?"selected":"" ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(checkForNull(bean.getDrName()) ));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(checkForNull(bean.getPhysicianName()) ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(checkForNull(bean.getDrName()) ));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(checkForNull(bean.getPractStaffType()) ));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(setNetChargeAmount ));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(setPatNetChargeAmt ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getNetChargeAmount()) ));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(bean.getPatNetChargeAmt()) ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(checkForNull(bean.getPatPaidAmt()) ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(checkForNull(bean.getRemarks())));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf("Y".equals(bean.getPreAppYn())?"checked":"" ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(checkForNull(bean.getPanelString())));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf( indx));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(checkForNull(bean.getEditPanel())));
            _bw.write(_wl_block181Bytes, _wl_block181);
}
			
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(facility_id ));
            _bw.write(_wl_block185Bytes, _wl_block185);
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
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceCode.label", java.lang.String .class,"key"));
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
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceDescription.label", java.lang.String .class,"key"));
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
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLING_SERVICE_PANEL.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BL_RATE_CHARGE_TYPE.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE.label", java.lang.String .class,"key"));
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
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.QTY.label", java.lang.String .class,"key"));
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
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLING_SERVICE_DISC.label", java.lang.String .class,"key"));
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
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.REC_ADHOC_DISC.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PERC_AMOUNT_INDICATOR.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PERC_AMOUNT.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
}
