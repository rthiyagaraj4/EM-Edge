package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blreprintreceiptprocess extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintReceiptProcess.jsp", 1738013900480L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<script language=\'javascript\' src=\'../js/BLReprintReportReceipt.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/json2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<script>\n\t\t\n\t\t$(document).ready(function(event){\n\t\t\t$(\"input[type=\'text\']\").keydown(function(e){\n\t\t\tif (e.which === 8 && !$(e.target).is(\"input[type=\'text\']:not([readonly])\")) {\n\t\t\t\t\te.preventDefault();\n\t\t\t    }\n\t\t\t});\n\t\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t\t$(\'#trProgress\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#trProgress\').hide();\n\t\t\t}\n\t\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#nextSpan\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#nextSpan\').hide();\n\t\t\t}\t\t\t\n\t\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#previousSpan\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#previousSpan\').hide();\n\t\t\t}\n\t\t\t\n\t\t\t$(\'[id^=void_number]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t$(\'[id^=recept_Refund_ind]\').each(function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t$(\'#nextSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tdocument.location.href = \"BLReprintReceiptProcess.jsp?from_receipt_doc_type_code=\"+$(\'#hdnreceiptDocFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_doc_type_code=\"+$(\'#hdnreceiptDocTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_receipt_number=\"+$(\'#hdnreceiptNoFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_number=\"+$(\'#hdnreceiptNoTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_receipt_date=\"+$(\'#hdnreceiptDateFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_date=\"+$(\'#hdnreceiptDateTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episode_type=\"+$(\'#hdnEpisodeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&visit_id=\"+$(\'#hdnvisit_id\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&patientId=\"+$(\'#hdnPatientId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episodeId=\"+$(\'#hdnEpisodeId\').val()+\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\"&recpt_type_code=\"+$(\'#hdnrecpt_type_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&receipt_nature_code=\"+$(\'#hdnreceipt_nature_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&custCode=\"+$(\'#hdnCustCode\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&custGrpCode=\"+$(\'#hdnCustGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&downtimereceipt_number_code=\"+$(\'#hdndowntimereceipt_number_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&downtimereceipt_number=\"+$(\'#hdndowntimereceipt_number\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&HcareApplnnumber_code=\"+$(\'#hdnHcareApplnnumber_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&depositeType=\"+$(\'#hdndepositeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_doc_type=\"+$(\'#hdnbill_doc_type\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_doc_no=\"+$(\'#hdnbill_doc_no\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith;\n\t\t\t\t\t\t\t\t\t\t});\n\t\t\t$(\'#previousSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\tdocument.location.href = \"BLReprintReceiptProcess.jsp?from_receipt_doc_type_code=\"+$(\'#hdnreceiptDocFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_doc_type_code=\"+$(\'#hdnreceiptDocTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_receipt_number=\"+$(\'#hdnreceiptNoFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_number=\"+$(\'#hdnreceiptNoTo\').val()+\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\"&from_receipt_date=\"+$(\'#hdnreceiptDateFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_receipt_date=\"+$(\'#hdnreceiptDateTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episode_type=\"+$(\'#hdnEpisodeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&visit_id=\"+$(\'#hdnvisit_id\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&patientId=\"+$(\'#hdnPatientId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episodeId=\"+$(\'#hdnEpisodeId\').val()+ \n\t\t\t\t\t\t\t\t\t\t\"&custCode=\"+$(\'#hdnCustCode\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&custGrpCode=\"+$(\'#hdnCustGrpCode\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&recpt_type_code=\"+$(\'#hdnrecpt_type_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&receipt_nature_code=\"+$(\'#hdnreceipt_nature_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&downtimereceipt_number_code=\"+$(\'#hdndowntimereceipt_number_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&downtimereceipt_number=\"+$(\'#hdndowntimereceipt_number\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&HcareApplnnumber_code=\"+$(\'#hdnHcareApplnnumber_code\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&depositeType=\"+$(\'#hdndepositeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_doc_type=\"+$(\'#hdnbill_doc_type\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_doc_no=\"+$(\'#hdnbill_doc_no\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith;\n\t\t\t\t\t\t\t\t\t\t});\n\t\t\t$(\'#selectAll\').click(function(){\t\t\t\t\t\n\t\t\t\tvar indx = $(\'#tbl tr\').length;\n\t\t\t\tvar trlast = $(parent.frames[2].document).find(\'#tblSelectedReport tr:last\');\n\t\t\t\tvar lastindx =  $(trlast).attr(\'indexval\');\t\t\t\n\t\t\t\tvar selectedFrameDoc = parent.selectedFrame.document;\n\t\t\t\t//var indx2 = $(selectedFrameDoc).find(\'#indexTrack\').val();\n\t\t\t\tvar indx1= $(\'#tblSelectedReport tr\').length;\n\t\t\t\tvar receiptCount = $(selectedFrameDoc).find(\'#receiptCount\').val();\n\t\t\t\t//alert(\"receiptCount=\"+receiptCount+\"-lastindx=\"+lastindx+\"-indx=\"+indx);\n\t\t\t\t\n\t\t\t\tif (lastindx == \'undefined\' || lastindx == undefined) {lastindx= 0;  receiptCount = 0;}\t\t\t\t\n\t\t\t\tvar limitexc =  parseInt(lastindx)-parseInt(receiptCount);\n\t\t\t\t\n\t\t\t\tif((parseInt(receiptCount)+ parseInt(indx-3)) > 50 ){\n\t\t\t\t\talert(\"Limit Exceeded, Can\'t proceed\");\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\t//alert(indx+\"--\"+limitexc+\"-\"+receiptCount);\n\t\t\t\tif((50-limitexc)<=50){\n\t\t\t\t\tfor (all = 1; all < (indx-2); all++) {\t\n\t\t\t\t\t\tvar receiptCount1 = $(selectedFrameDoc).find(\'#receiptCount\').val();\n\t\t\t\t\t\tif (receiptCount1 <50 && (50-limitexc)<=50 ) {\t\n\t\t\t\t\t\t\tlimitexc++;\n\t\t\t\t\t\t\tmoveData(all,true);\t\n\t\t\t\t\t     }else { alert(\"Already 50 rows selected, Can\'t proceed \"); return;}\n\t\t\t\t\t}\t\t\t\n\t\t\t\t}else {\n\t\t\t\t\talert(\"Already 50 rows selected, Can\'t proceed\");\n\t\t\t\t\t\n\t\t\t\t\tdataArray.pop(uniqueReceiptId);\n\t\t\t\t\t\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t});\n\t\t});\n\t\t</script>\n<style>\ndiv.tableContainer {\n\twidth: 100%;\t\t/* table width will be 99% of this*/\n\theight: 160px; \t/* must be greater than tbody*/\n\toverflow: auto;\n\tmargin: 0 auto;\n}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\n\t\tTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\t/*PADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px*/\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\n\nSPAN.LABEL1\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  /*TEXT-ALIGN: LEFT;*/\n  TEXT-ALIGN: RIGHT;\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\n\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\n\t</style>\n\t</HEAD> \n\t<script>\n\t\tfunction selected(i)\n\t\t{\t\t\t\t\n\t\t\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\t\t\n\t\t\tif(selected_row.checked==false)\n\t\t\t{\t\n\t\t\tselected_row.checked=false;\n\t\t\tdocument.resultForm.checked_row.value=\"\";\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\t\t\n\t\t\t\tvar total_records=document.forms[0].total_records.value;\t\t\t\t\t\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{ \n\t\t\t\t\tvar temp=eval(\"document.resultForm.selected_row\"+j);\t\t\t\t\t\n\t\t\t\t\ttemp.checked=false;\n\t\t        }\n\t\t\tselected_row.checked=true;\t\t\t\t\n\t\t\tdocument.forms[0].checked_row.value=i;\n\t\t\t}\n\t\t\tif(selected_row.checked)\n\t\t\t{\n\t\t\t  selected_row.value=\"1\";\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tselected_row.value=\"1\";\t\n\t\t\t}\n\t\t}\t\n\t\t\n\t\tfunction no_record_check()\n\t\t{\t\t\t\n\t\t\t//alert(\"no records check\");\n\t\t//\tparent.dummy_frame.location.href=\'../../eCommon/html/blank.html\';\n \t\t\tvar total_records=document.forms[0].total_records.value;\n\t\t\tif(total_records==0)\n\t\t\t{\n\t\t\t\tsetTimeout(function(){ alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\")); }, 100);\n\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=&err_value=\";\n\t\t\t\t$(\"#tableContainer\").html(\"\");\n\t\t\t\t\n\t\t\t}\n\t\t\tparent.search_hdr.document.forms[0].total_records.value=total_records;\n\t\t\n\t\t}\n\t\tfunction assign_value()\n\t\t{\n\t\t\tparent.search_hdr.document.forms[0].group_by.value = document.forms[0].group_by.value;\n\t\t}\n\n\t</script>\n\t<body onLoad=\"no_record_check();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\">\n\t<form name=\'resultForm\' id=\'resultForm\' > \n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<div id=\"tableContainer\">\n\t\t\t<table border=\'\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t\t<thead>\n\t\t\t<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t\n\t\t\t\t\t<td colspan=\'12\'  align=\'right\' bordor=0 >\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer; cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'previousSpan\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer; cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'nextSpan\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr style=\"position: sticky;z-index: 1;top: 0;\">\n<!-- \t\t\t\t\tENM-2558 - MMS-QH-CRF-0163 Karthik Added isForALL attribute to skip alert in Select All Case \t-->\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\' ><div id=\'selectAll\'><span style=\"color: blue; font-size: 12px; cursor:pointer \" >(+)</span>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></td>\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t</tr>\n\t            </thead>\n\t\t\t    <tbody>\n\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\n\t<tr id=row";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onclick=\'highlightRow(";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\'>\n\t\t\n\t<td id=\'row";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="_col0\' class=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\"5%\" nowrap style=\'cursor:pointer\' >\n\t<div  id=\'doc_typ_chk";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' name=\'doc_typ_chk";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' index=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onclick=\"moveData(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",false)\"> <div style=\"color: blue; font-size: 12px;\">+</div> </div>\n\t</td>\n\t<td id=\'row";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_col1\' class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\"7%\" nowrap>  \n\t<span class=\"LABEL\" id=\'doc_typ_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' name=\'doc_typ_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span>\n\t</td>\n\t<td id=\'row";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="_col2\' class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\"11%\" class=\"fields\" style=\'cursor:pointer\' onclick=\"tooltip(this,";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");\"\tonmouseover=\"hideToolTip();\">\n\t<span class=\"LABEL\" name=\'doc_num";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'doc_num";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span>&nbsp;\n\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t</td>\n\t<td id=\'row";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="_col3\' class=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" width=\"10%\" nowrap class=\"fields\">\n\t<span class=\"LABEL\" name=\'doc_date";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'doc_date";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</span> \n\t</td>\n\t<td id=\'row";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="_col4\' width=\"10%\" nowrap class=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n\t<span class=\'LABEL\' name=\'recpt_nature_code";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'recpt_nature_code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</span>\n\t</td>\t\n\t<td id=\'row";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="_col5\' width=\"10%\" nowrap class=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >\n\t<span class=\'LABEL\' name=\'recpt_type_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'recpt_type_code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="_col6\' width=\"7%\" nowrap class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" >\n\t<span  class=\'LABEL1\' name=\'doc_amt";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'doc_amt";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="_col7\' width=\"7%\" nowrap class=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n\t<span class=\"LABEL\" name=\'patient_id";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'patient_id";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</span>\n\t<td id=\'row";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="_col8\' width=\"7%\" nowrap class=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">\n\t<span class=\'LABEL\' readonly name=\'episode_type";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'episode_type";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="_col9\' width=\"10%\" nowrap class=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" >\n\t<span class=\'LABEL\' name=\'episode_id";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'episode_id";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="_col9\' width=\"10%\"  nowrap class=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >\n\t<span class=\'LABEL\' name=\'visit_id";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'visit_id";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</span>\n\t<span name=\'void_number";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'  type =\'hidden\' id=\'void_number";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</span>\n\t<span name=\'recept_Refund_ind";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'  type =\'hidden\' id=\'recept_Refund_ind";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</span>\n\t\t\n\t</td>\n\t</tr> \n\t\n ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t</tbody>\n\t</table>\n\t</div>\n\t \n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\t\n\t\t<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\t\t\n\t\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' id=\'rowClicked\' value = \'\'>\t\t\n\t\t<input type=\'hidden\' name=\'docType\' id=\'docType\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'documentNumber\' id=\'documentNumber\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'documentDate\' id=\'documentDate\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'amt_doc\' id=\'amt_doc\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'Rcptnatcode\' id=\'Rcptnatcode\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'Rcpttypecode\' id=\'Rcpttypecode\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value = \'\'>\n\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<!-- \t<script>parent.dummy_frame.location.href=\'../../eCommon/html/blank.html\';</script>\t  -->\n\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' id=\'prevClicked\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t<!-- Hidden Vars for Next / Prev Refresh -->\n\t<input type=\'hidden\' name=\'hdnEpisodeType\' id=\'hdnEpisodeType\' id=\'hdnEpisodeType\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t<input type=\'hidden\' name=\'hdnPatientId\' id=\'hdnPatientId\' id=\'hdnPatientId\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t<input type=\'hidden\' name=\'hdnEpisodeId\' id=\'hdnEpisodeId\' id=\'hdnEpisodeId\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptDocFrom\' id=\'hdnreceiptDocFrom\' id=\'hdnreceiptDocFrom\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptDocTo\' id=\'hdnreceiptDocTo\' id=\'hdnreceiptDocTo\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptNoFrom\' id=\'hdnreceiptNoFrom\' id=\'hdnreceiptNoFrom\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptNoTo\' id=\'hdnreceiptNoTo\' id=\'hdnreceiptNoTo\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptDateFrom\' id=\'hdnreceiptDateFrom\' id=\'hdnreceiptDateFrom\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t<input type=\'hidden\' name=\'hdnreceiptDateTo\' id=\'hdnreceiptDateTo\' id=\'hdnreceiptDateTo\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<input type=\'hidden\' name=\'hdnvisit_id\' id=\'hdnvisit_id\' id=\'hdnvisit_id\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t<input type=\'hidden\' name=\'login_user\' id=\'login_user\' id=\'login_user\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t<input type=\"hidden\" name=\'hdnCustCode\' id=\'hdnCustCode\' id=\'hdnCustCode\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<input type=\"hidden\" name=\'hdnCustGrpCode\' id=\'hdnCustGrpCode\' id=\'hdnCustGrpCode\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<input type=\"hidden\" name=\'hdnrecpt_type_code\' id=\'hdnrecpt_type_code\' id=\'hdnrecpt_type_code\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\'hdnreceipt_nature_code\' id=\'hdnreceipt_nature_code\' id=\'hdnreceipt_nature_code\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name=\'hdndowntimereceipt_number_code\' id=\'hdndowntimereceipt_number_code\' id=\'hdndowntimereceipt_number_code\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name=\'hdndowntimereceipt_number\' id=\'hdndowntimereceipt_number\' id=\'hdndowntimereceipt_number\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name=\'hdnHcareApplnnumber_code\' id=\'hdnHcareApplnnumber_code\' id=\'hdnHcareApplnnumber_code\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name=\'hdndepositeType\' id=\'hdndepositeType\' id=\'hdndepositeType\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" name=\'hdnbill_doc_no\' id=\'hdnbill_doc_no\' id=\'hdnbill_doc_no\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\"hidden\" name=\'hdnbill_doc_type\' id=\'hdnbill_doc_type\' id=\'hdnbill_doc_type\' value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\n\t <tr>\n\t </tr>\n\t</form >\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:12%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t<tr>\n\t<td width=\'100%\' id=\'t\'></td>\n\t</tr>\n\t</table>\n    </div>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t</body>\n\t</TBODY>\t\n\t</div>\n</HTML>\n\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );
	
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

public String billingFormatConverter(Connection con, String amount) {
	PreparedStatement pstmt_dec = null;
	ResultSet rs_dec = null;
	int noofdecimal = 2;

	try {		
		pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		rs_dec = pstmt_dec.executeQuery();
		if (rs_dec.next() && rs_dec != null)
			noofdecimal = rs_dec.getInt(1);
		if (rs_dec != null)
			rs_dec.close();
		if (pstmt_dec != null)
			pstmt_dec.close();			
		if (amount == null || "".equals(amount)) {
			amount = "0.00";
		} else {
			CurrencyFormat cf = new CurrencyFormat();
			amount = cf.formatCurrency(amount, noofdecimal);
		}
	} catch (Exception e) {
		System.out.println("Exception Getting Number of Decimals. " + e.toString());
	}
	return amount;
} 


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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

System.out.println("in jsp");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;	
	ResultSet rs2 =null;
	ResultSet rs3 =null;
	String strRecptNatureCodedesc="";
	String strRecptTypeCodedesc="";
	String locale="";	
	String classval="";
	int total_records=0;	
	String p_facility_id="";
	String ReceiptNaturedesc="";
	String p_doc_type_code="";
	String From_doc_type_no="";
	String To_doc_type_no="";
	String p_from_receipt_doc_type_code="";
	String p_to_receipt_doc_type_code="";
	String p_from_receipt_number="";	
	String p_to_receipt_number=""; 
	String p_from_receipt_date="";
	String p_to_receipt_date="";
	String p_episode_type="";	
	String p_visit_id ="";
	String strRowId="";
	String strDocTypCode="";
	String strDocNum="";	
	String strDocDate="";
	String strPatientId="";
	String strDocAmt="";
	String strRecptTypeCode="";
	String strRecptNatureCode="";
	String strEpisodeType="";
	String strEpisodeId="";
	String strVisitId="";
	String patientId="";
	String episodeId = "";
	String visit_id = "";
	String custCode ="";
	String custGrpCode = "";
	String recpt_type_code = "";
	String receipt_nature_code = "";
	String downtimereceipt_number_code  = "";
	String to_Receipt_date ="";
	String from_Receipt_date = "";
	String downtimereceipt_number = "";
	String HcareApplnnumber_code  = "";
	String depositeType="";
	String bill_doc_type = "";
	String void_number = "";
	 String recept_Refund_ind = "";
	String bill_doc_no = "";
	String nextYn = "N";
	String prevYn = "N";
	String traversal = "N";
	String fromRcrd = "";
	String toRcrd = "";
	int constCount = 50;
	int startIndex = 0;
	int startRcrd = 0;
	int endRcrd = 0;
	int totalRecord=0;
	System.out.println("in jsp 1");
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	boolean searched = (request.getParameter("searched") == null) ?false:true;	

	try
	{	
		HttpSession httpSession = request.getSession(false);				
		con	=	ConnectionManager.getConnection(request);		
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_from_receipt_doc_type_code=request.getParameter("from_receipt_doc_type_code");
		if(p_from_receipt_doc_type_code==null || p_from_receipt_doc_type_code.equals("")) p_from_receipt_doc_type_code="";		
		p_to_receipt_doc_type_code=request.getParameter("to_receipt_doc_type_code");
		if(p_to_receipt_doc_type_code==null || p_to_receipt_doc_type_code.equals("")) p_to_receipt_doc_type_code="";
		p_from_receipt_number=request.getParameter("from_receipt_number");
		if(p_from_receipt_number==null || p_from_receipt_number.equals("")) p_from_receipt_number="";
		p_to_receipt_number=request.getParameter("to_receipt_number");
		if(p_to_receipt_number==null || p_to_receipt_number.equals("")) p_to_receipt_number="";
		p_from_receipt_date=request.getParameter("from_receipt_date");
		if(p_from_receipt_date==null || p_from_receipt_date.equals("")) p_from_receipt_date="";
		p_to_receipt_date=request.getParameter("to_receipt_date");
		if(p_to_receipt_date==null || p_to_receipt_date.equals("")) p_to_receipt_date="";
		p_episode_type=request.getParameter("episode_type");
		if(p_episode_type==null) p_episode_type="";		
  		patientId = checkForNull(request.getParameter("patientId"));
		episodeId = checkForNull(request.getParameter("episodeId"));	    
		visit_id = checkForNull(request.getParameter("visit_id"));
		custCode = checkForNull(request.getParameter("custCode"));
		custGrpCode = checkForNull(request.getParameter("custGrpCode"));
		recpt_type_code = checkForNull(request.getParameter("recpt_type_code"));
		receipt_nature_code = checkForNull(request.getParameter("receipt_nature_code"));
		downtimereceipt_number_code = checkForNull(request.getParameter("downtimereceipt_number_code"));
		downtimereceipt_number = checkForNull(request.getParameter("downtimereceipt_number"));
		HcareApplnnumber_code = checkForNull(request.getParameter("HcareApplnnumber_code"));
		depositeType = checkForNull(request.getParameter("depositeType"));
		bill_doc_no = checkForNull(request.getParameter("bill_doc_no"));
		bill_doc_type = checkForNull(request.getParameter("bill_doc_type"));
		Statement stmt = con.createStatement();
		if(rs1!=null)   rs1.close();
		if(stmt!=null) stmt.close();
	}		
	catch(Exception eX)
	{	
		System.out.println("Error= "+eX);			
	}

            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
		try
		{
								
			String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_number, TO_CHAR(doc_date,'DD-MM-YYYY') doc_date, doc_amt, patient_id, recpt_nature_code, recpt_type_code, episode_type, episode_id,visit_id, print_flag,BL_VOID_NUMBER_YN(doc_number,doc_type_code,operating_facility_id) void_number,RECPT_REFUND_IND "+
				  	"FROM bl_receipt_refund_hdr "+
				 	"WHERE "+
				  	"doc_type_code BETWEEN NVL ('"+p_from_receipt_number+"', '!!!!!!' ) AND NVL ('"+p_to_receipt_number+"', '~~~~~~') "+
				  	"AND DOC_NUMBER BETWEEN NVL ('"+p_from_receipt_doc_type_code+"', 0) AND NVL ('"+p_to_receipt_doc_type_code+"', 99999999)"+ 
				   	"AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+
				   	"AND NVL ( TO_DATE ('"+p_to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))"+ 
				   "AND NVL (cancelled_ind, 'N') <> 'Y'  ";
			String queryCount = 
					"SELECT count(*) total "+
							"FROM bl_receipt_refund_hdr "+
							 "WHERE "+
							  "doc_type_code BETWEEN NVL ('"+p_from_receipt_number+"', '!!!!!!' ) AND NVL ('"+p_to_receipt_number+"', '~~~~~~') "+
							  " AND DOC_NUMBER BETWEEN NVL ('"+p_from_receipt_doc_type_code+"', 0) AND NVL ('"+p_to_receipt_doc_type_code+"', 99999999)"+ 
							   "AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+
							   "AND NVL ( TO_DATE ('"+p_to_receipt_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy'))"+ 
							   "AND NVL (cancelled_ind, 'N') <> 'Y'  ";
					
			String whereClause = "";
			
					if(!"".equals(patientId)){
						whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
					}					
					if(!"".equals(episodeId)){
						whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
					}
					if(!"".equals(p_episode_type)){
						whereClause = whereClause + " AND episode_type = '"+p_episode_type+"' ";
					}										
					if(!"".equals(custCode) ){
						whereClause = whereClause +  "AND CUSTOMER_CODE = (DECODE('"+custCode+"','**',CUSTOMER_CODE,'"+custCode+"')) ";													
					}			
					if(!"".equals(custGrpCode) ) {
						whereClause = whereClause + " AND CUSTOMER_GROUP_CODE = (DECODE('"+custGrpCode+"','**',CUSTOMER_GROUP_CODE,'"+custGrpCode+"'))";
					}										
					if(!"".equals(recpt_type_code))  {
						whereClause = whereClause + " AND RECPT_TYPE_CODE  = '"+recpt_type_code+"' ";
					}
					if(!"".equals(receipt_nature_code)) {
						
						whereClause = whereClause + " AND  RECPT_NATURE_CODE  = '"+receipt_nature_code+"' ";
					}
					if(!"".equals(downtimereceipt_number)){
						whereClause = whereClause + "AND DOWNTIME_DOC_NUMBER = '"+downtimereceipt_number+"'";
					}
					if(!"".equals(downtimereceipt_number_code)) {
						whereClause = whereClause + " AND DOWNTIME_DOC_TYPE_CODE = '"+downtimereceipt_number_code+"'";
					}				
					if(!"".equals(visit_id)) {
						whereClause = whereClause + " AND VISIT_ID = '"+visit_id+"' ";
					}
					if(!"**".equals(depositeType)) {
						whereClause = whereClause +" AND IP_ADM_TRF_DEP_IND = '"+depositeType+"' ";
					}
				if(!"".equals(bill_doc_no)) {
					whereClause = whereClause +" AND (doc_number  IN (select DOC_NUMBER  from bl_bills_for_cons_receipt where bill_doc_num ='"+bill_doc_no+"'  and bill_doc_type_code ='"+bill_doc_type+"')  OR bill_doc_number ='"+bill_doc_no+"')";
				}
				if(!"".equals(bill_doc_type)) {
					whereClause = whereClause + " AND  (doc_type_code in ( select doc_type_code  from bl_bills_for_cons_receipt  where bill_doc_num ='"+bill_doc_no+"' and bill_doc_type_code ='"+bill_doc_type+"') OR bill_doc_type_code ='"+bill_doc_type+"')";
				}
					
			 String orderBy=" order by doc_type_code,doc_number ";
			 query_refresh  = "Select * from ("+query_refresh + whereClause +") where rnum between "+startRcrd +" and "+endRcrd + orderBy ; 
			
			 queryCount  = queryCount + whereClause;
			 System.out.println("query_refresh :" +query_refresh);
			 System.out.println("queryCount :" +queryCount);
			pstmt = con.prepareStatement(queryCount);
			
			rs1 = pstmt.executeQuery();

			if(rs1 != null && rs1.next()){ 
				totalRecord = rs1.getInt("total");
			}
			if(startRcrd>1){
				prevYn = "Y";
				traversal = "Y";
			}
			System.out.println("total = "+totalRecord);
			if((startRcrd+constCount) < totalRecord){
				nextYn = "Y";
				traversal = "Y";
			}	
		
			pstmt = null;
			rs1 = null;
			
			System.out.println("Inside Reprint Process Sql Query : "+query_refresh);
			
			pstmt = con.prepareStatement(query_refresh);
			rs1= pstmt.executeQuery();
			
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
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
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
				int i=1;

				if(rs1 != null){
					
					while(rs1.next()){
						classval = "label";
						strDocTypCode=  checkForNull(rs1.getString("doc_type_code"));
						strDocNum=checkForNull(rs1.getString("doc_number"));
						strDocDate=checkForNull(rs1.getString("doc_date"));
						strDocAmt=checkForNull(rs1.getString("doc_amt"));
						strPatientId=checkForNull(rs1.getString("patient_id"));
						strRecptNatureCode=checkForNull(rs1.getString("recpt_nature_code"));
						
						 String query = "select  distinct long_desc from bl_receipt_nature_lang_vw where recpt_nature_code = '"+strRecptNatureCode+"' AND upper(LANGUAGE_ID) = upper('"+locale+"')";
						
						 pstmt = con.prepareStatement(query);
						rs2  = pstmt.executeQuery();
						if(rs2 != null){							
							while(rs2.next()){
						 strRecptNatureCodedesc = rs2.getString(1);
							}
						}
						strRecptTypeCode=checkForNull(rs1.getString("recpt_type_code"));

						 String query1 = "select  distinct long_desc from bl_receipt_type_lang_vw where RECEIPT_TYPE_CODE = '"+strRecptTypeCode+"' AND  upper(LANGUAGE_ID) = upper('"+locale+"')";
						 pstmt = con.prepareStatement(query1);
						 rs3= pstmt.executeQuery();
						 if(rs3 != null){							
								while(rs3.next()){
							 strRecptTypeCodedesc = rs3.getString(1);
								}
							}
						strEpisodeType=checkForNull(rs1.getString("episode_type"));
						if(strEpisodeType.equals("R")) {
							strEpisodeId = "";
						}else {							
							strEpisodeId=checkForNull(rs1.getString("episode_id"));
						}
						if(strEpisodeType.equals("I") || strEpisodeType.equals("D") || strEpisodeType.equals("R")) {
							strVisitId = "";
						}else{
						strVisitId=checkForNull(rs1.getString("visit_id"));
						}
						void_number=checkForNull(rs1.getString("void_number"));
						recept_Refund_ind=checkForNull(rs1.getString("RECPT_REFUND_IND"));
					

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strDocTypCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strDocNum));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strDocDate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strRecptNatureCodedesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strRecptTypeCodedesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(billingFormatConverter(con,strDocAmt)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(void_number));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recept_Refund_ind));
            _bw.write(_wl_block73Bytes, _wl_block73);

					i++;
					total_records++; 
			}//while
			}//If

            _bw.write(_wl_block74Bytes, _wl_block74);
				
		}
		catch(Exception eX)
		{		
			System.out.println("Error1= "+eX);			
		}
		finally
		{
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block76Bytes, _wl_block76);
			
				if(total_records>0){
					System.out.println("total_records/classval"+total_records+"/"+classval);
					out.println("<script>");
				out.println("highlightRow(1,'"+classval+"')");
				out.println("</script>");
				}
			
		 
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(p_episode_type ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(p_from_receipt_doc_type_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(p_to_receipt_doc_type_code ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(p_from_receipt_number));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(p_to_receipt_number ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(p_from_receipt_date ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(p_to_receipt_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(p_visit_id ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf((String)session.getAttribute("login_user")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(custCode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(custGrpCode));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(recpt_type_code));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(receipt_nature_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(downtimereceipt_number_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(downtimereceipt_number_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(HcareApplnnumber_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(depositeType));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(bill_doc_no));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(bill_doc_type));
            _bw.write(_wl_block105Bytes, _wl_block105);
System.out.println("************************************set form is about to be called **********************************"+searched);
            _bw.write(_wl_block1Bytes, _wl_block1);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLReprintReceiptProcess.jsp",searched));
            _bw.write(_wl_block1Bytes, _wl_block1);
System.out.println("************************************set form is about to be called **********************************"+searched);
            _bw.write(_wl_block106Bytes, _wl_block106);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocumentNumber.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocumentDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReceiptNatureCode.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReceiptTypeCode.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DocAmt.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.episodeId.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
}
