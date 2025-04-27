package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
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
import eBL.billreceipt.model.BLBillGenInterfaceInBean;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.Common.BlRepository;

public final class __blbillgeninterfacesearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillGenInterfaceSearchResult.jsp", 1742746641919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n    <!--  By Vijay  -->\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLBillGenInterfaceJs.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<script language=\'javascript\' src=\'../js/BLDepositReceipt.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/json2.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<style>\ndiv.tableContainer {\n\twidth: 100%;\t\t/* table width will be 99% of this*/\n\theight: 160px; \t/* must be greater than tbody*/\n\toverflow: auto;\n\tmargin: 0 auto;\n}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\n\t\tTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\n\nSPAN.LABEL1\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  /*TEXT-ALIGN: LEFT;*/\n  TEXT-ALIGN: RIGHT;\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\n\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\n\t\t\n\t\t.ordered{\n\t\twidth: 12.5px;\n\t\theight: 03px;\n\t\tbackground: #5A0000;\n\t}\n\t.registered{\n\t\twidth: 12.5px;\n\t\theight: 03px;\t\n\t\tbackground: #000080;\n\t}\n\t.completed{\n\t\twidth: 12.5px;\n\t\theight: 03px;\n\t\tbackground: #FFFF00;\n\t}\n\t.resulted{\n\t\twidth: 12.5px;\n\t\theight: 03px;\n\t\tbackground: #00FF00;\n\t}\n\t\t\n\t\n\t</style>\n<script>\n\n$(document).ready(function(){\n\t\t\n\t\tparent.dummy_frame.location.href=  \'../../eCommon/html/blank.html\';\n\t\t\n\tvar site_id=$(\'#site_id\').val();\n\t\n/*\tif(site_id==\'ALMO\')\n\t\t{\n\t\t$(\'#hdr\').text(\'Not Charged\');\t\t\n\t\t}\n\telse\n\t\t{\n\t\t$(\'#hdr\').text(\'Future Order\');\n\t\t}\n*/\n\n\t\n\t\tvar indx=$(\'#bilgeninterface tr:last \' ).attr(\'data-id\');\n\t\t//alert(indx);\n\t/*\tif(indx==0 || indx==undefined)\n\t\t\t{\n\t\t\t//alert(\'1\');\n\t\t\t$(\'#detailshdr\').hide();\n\t\t\t$(\'#colorstatus\').hide();\n\t\t\t}\n\t\t\n\t\t\n\t\t*/\n\t\n\t\n\t\n\t\t$(\'td[id^=row_billInterface]\').each(function(){\n\t\t\t$(this).hide();\n\t\t});\n\n\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t$(\'#trProgress\').show();\n\t\t}else{\n\t\t\t$(\'#trProgress\').hide();\n\t\t}\n\t\t\n\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t\n\t\t\t$(\'#nextSpan\').show();\n\t\t}else{\n\t\t\t\n\t\t\t$(\'#nextSpan\').hide();\n\t\t}\n\t\t\n\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t$(\'#previousSpan\').show();\n\t\t}else{\n\t\t\t$(\'#previousSpan\').hide();\n\t\t} \n\t\t\n\t\t$(\'#nextSpan\').click(function(){\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\tdocument.location.href = \"BLBillGenInterfaceSearchResult.jsp?facility_name=\"+$(\'#hdnfacility_name\').val()+\n\t\t\t\"&records=\"+$(\'#hdnrecords\').val()+\n\t\t\t\"&modules=\"+$(\'#hdnmodules\').val()+\n\t\t\t\"&prmodule=\"+$(\'#hdnprmodule\').val()+\n\t\t\t\"&service_location_code=\"+$(\'#hdnserviceLocationCode\').val()+\n\t\t\t\"&service_location_desc=\"+$(\'#hdnserviceLocationdesc\').val()+\n\t\t\t\"&patient=\"+$(\'#hdnpatient\').val()+\n\t\t\t\"&patient_no=\"+$(\'#hdnpatient_no\').val()+\n\t\t\t\"&encounter_from_date=\"+$(\'#hdnencounter_from_date\').val()+\n\t\t\t\"&encounter_to_date=\"+$(\'#hdnencounter_to_date\').val()+\n\t\t\t\"&episode_type=\"+$(\'#hdnepisode_type\').val()+\t\t\t\t\t\t\t\t\t\t\n\t\t\t\"&encounter=\"+$(\'#hdnencounter\').val()+\n\t\t\t\"&episode_id=\"+$(\'#hdnepisode_id\').val()+\n\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\"&total=\"+$(\'#total\').val();\n\t\t});\n\t\n\t\t$(\'#previousSpan\').click(function(){\n\t\t\t\n\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\n\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\n\t\t\tdocument.location.href = \"BLBillGenInterfaceSearchResult.jsp?facility_name=\"+$(\'#hdnfacility_name\').val()+\n\t\t\t\"&records=\"+$(\'#hdnrecords\').val()+\n\t\t\t\"&modules=\"+$(\'#hdnmodules\').val()+\n\t\t\t\"&prmodule=\"+$(\'#hdnprmodule\').val()+\n\t\t\t\"&service_location_code=\"+$(\'#hdnserviceLocationCode\').val()+\n\t\t\t\"&service_location_desc=\"+$(\'#hdnserviceLocationdesc\').val()+\n\t\t\t\"&patient=\"+$(\'#hdnpatient\').val()+\n\t\t\t\"&patient_no=\"+$(\'#hdnpatient_no\').val()+\n\t\t\t\"&encounter_from_date=\"+$(\'#hdnencounter_from_date\').val()+\n\t\t\t\"&encounter_to_date=\"+$(\'#hdnencounter_to_date\').val()+\n\t\t\t\"&episode_type=\"+$(\'#hdnepisode_type\').val()+\t\t\t\t\t\t\t\t\t\t\n\t\t\t\"&encounter=\"+$(\'#hdnencounter\').val()+\n\t\t\t\"&episode_id=\"+$(\'#hdnepisode_id\').val()+\n\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\"&total=\"+$(\'#total\').val();\n\t\t});\n\t\t\n\t\t\t\n});\n\n\n\n\n\tfunction selected(i)\n\t\t{\t\t\t\t\n\t\t\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\t\t\n\t\t\tif(selected_row.checked==false)\n\t\t\t{\t\n\t\t\tselected_row.checked=false;\n\t\t\tdocument.blinterfacesearchresult.checked_row.value=\"\";\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\t\t\n\t\t\t\tvar total_records=document.forms[0].total_records.value;\t\t\t\t\t\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{ \n\t\t\t\t\tvar temp=eval(\"document.blinterfacesearchresult.selected_row\"+j);\t\t\t\t\t\n\t\t\t\t\ttemp.checked=false;\n\t\t        }\n\t\t\tselected_row.checked=true;\t\t\t\t\n\t\t\tdocument.forms[0].checked_row.value=i;\n\t\t\t}\n\t\t\tif(selected_row.checked)\n\t\t\t{\n\t\t\t  selected_row.value=\"1\";\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tselected_row.value=\"1\";\t\n\t\t\t}\n\t\t}\t\n\t\t\n\n\n</script>\n\n\n\n</head>\n<body onLoad=\'populate_btm_frame(1);\'> \n<fieldset>\n<Form name=\'blinterfacesearchresult\' id=\'blinterfacesearchresult\'  id=\'blinterfacesearchresult\'>\n  \n\t<div id=\"tableContainer\">\n\t\n\t\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table id=\'bilgeninterface\' border=\'\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\n\t\t\t<thead>\t\n\t\t\t\t\t\n<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\n\t\t\t<td colspan=\'12\' nowrap=\"nowrap\">\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t\t\t<td colspan=\'1\' nowrap=\"nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t\t\t<span id=\'previousSpan\'>Previous</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'1\' nowrap=\"nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;\">\n\t\t\t\t\t\t\t<span id=\'nextSpan\'>Next</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t \n\t\t\t\n\t\t\t\n\t\t<tr>\n\t\t  <td  class=\'COLUMNHEADER\' width=\'10%\' align=\"center\">Process All<input type=\'checkbox\' id=\'select_all\' name=\'select_all\' id=\'select_all\' onclick=\"fnSelectAll()\"></td>\n\t\t\t\t  <td class=\'COLUMNHEADER\'  width=\'05%\' id=\'colorstatus\' align=\"center\">Current Stage</td>\t\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align=\"center\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\' align=\"center\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align=\"center\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'07%\' align=\"center\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'06%\' align=\"center\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'06%\' id=\'row_billInterfaceH1\' align=\"center\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'06%\' id=\'row_billInterfaceH2\' align=\"center\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' id=\'row_billInterfaceH7\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' id=\'row_billInterfaceH3\' align=\"center\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'05%\' id=\'row_billInterfaceH4\' align=\"center\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align=\"center\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'13%\' align=\"center\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'13%\' id=\'row_billInterfaceH5\' align=\"center\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'  id=\'row_billInterfaceH6\' name=\'detailshdr\' align=\"center\"> </td>\n\t\t\t\t<td class=\'COLUMNHEADER\'  width=\'05%\' id=\'colorstatus\' align=\"center\">Charging Stage</td>\t\n\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\n</thead>\n\t            \n\t            <tbody>\n\t                  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t           \n\t           \n\t           \n\t          \t<tr id=\'row_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' data-id=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  >\n\t           \n\t     \t           \n\t           \n\t\t\t\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="_col19\' class=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" width=\"10%\" >  \n\t\t\t\t<span ><input type=\'checkbox\' id=\'selectindividual_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' name=\'selectindividual_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onclick=\'fnSelectindividual()\' > </span>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t  <td nowrap id=\'row_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="_col1\' class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\"05%\" >\n\t\t\t\t<span class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'spanColor";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  name=\'spanColor";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  > </span>\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\"10%\" >  \n\t\t\t\t<a href class=\"LABEL\" id=\'module_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' name=\'module_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' style=\'cursor:pointer\' onClick=\'populate_btm_frame(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"),highlightRow(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\")\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>\n\t\t\t\t</td>\n\t\t\n\t    \t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="_col2\' class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'clinic_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' name=\'clinic_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </span>\n\t\t\t\t</td>\n\t\t        \n\t            <td nowrap id=\'row_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="_col3\' class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'physicianid_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' name=\'physicianid_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" </span>\n\t\t\t\t</td>\n\t\t        \n\t\t        <td nowrap id=\'row_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="_col4\' class=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'blngservcode_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' name=\'blngservcode_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'> ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</span>\n\t\t\t\t</td>\n\t\t        \n\t\t        <td nowrap id=\'row_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="_col5\' class=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'description_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' name=\'description_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" </span>\n\t\t\t\t</td>\n\t\t        \n\t\t        <td nowrap    id=\'row_billInterfaceC1";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' class=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'primarykey_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' name=\'primarykey_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</span>\n\t\t\t\t</td>\n\t\t        \n\t\t        <td nowrap  id=\'row_billInterfaceC2";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'line_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' name=\'line_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_billInterfaceC7";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" \'  class=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'mod_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' name=\'mod_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" </span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t        <td nowrap  id=\'row_billInterfaceC3";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'secondarykey_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' name=\'secondarykey_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" </span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap  id=\'row_billInterfaceC4";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'  class=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'lin_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' name=\'lin_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" </span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="_col11\' class=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'servitemcode_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' name=\'servitemcode_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="_col12\' class=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'desc_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' name=\'desc_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="_col13\' class=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'interfaceddate_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' name=\'interfaceddate_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" \n\t\t\t\t</span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap   id=\'row_billInterfaceC5";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" width=\"10%\" >  \n\t\t\t\t<span ><input type=\'checkbox\' id=\'charged_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' name=\'charged";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'> </span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="_col15\' class=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" width=\"10%\" style=\'text-align:right\' >  \n\t\t\t\t<span class=\"LABEL1\"  style=\'text-align:right\' id=\'grossamt_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' name=\'grossamt_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="_col16\' class=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" width=\"10%\" style=\'text-align:right\'  >  \n\t\t\t\t<span class=\"LABEL1\"  style=\'text-align:right\' id=\'discount_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' name=\'discount_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' > ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="_col17\' class=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" width=\"10%\"  style=\'text-align:right\'>  \n\t\t\t\t<span class=\"LABEL1\" style=\'text-align:right\' id=\'netamt_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' name=\'netamt_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap   id=\'row_billInterfaceC6";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 =" width=\"10%\" >  \n\t\t\t\t<span ><input type=\'submit\' id=\'details_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' name=\'details_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' value=\'Details\' size=\'3\' > </span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td nowrap id=\'row_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" width=\"10%\" >  \n\t\t\t\t<span class=\"LABEL\" id=\'chargingStage_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' name=\'chargingStage_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</span>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t<input type=\'hidden\' name=\'futureYn\' id=\'futureYn\' id=\'futureYn\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\t\t\t\n\t<input type=\'hidden\' name=\'hdnfacility_name\' id=\'hdnfacility_name\' id=\'hdnfacility_name\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t<input type=\'hidden\' name=\'hdnrecords\' id=\'hdnrecords\' id=\'hdnrecords\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t<input type=\'hidden\' name=\'hdnmodules\' id=\'hdnmodules\' id=\'hdnmodules\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t<input type=\'hidden\' name=\'hdnprmodule\' id=\'hdnprmodule\' id=\'hdnprmodule\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'hdnserviceLocationCode\' id=\'hdnserviceLocationCode\' id=\'hdnserviceLocationCode\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\'hdnserviceLocationDesc\' id=\'hdnserviceLocationDesc\' id=\'hdnserviceLocationDesc\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'hdnpatient\' id=\'hdnpatient\' id=\'hdnpatient\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'hdnpatient_no\' id=\'hdnpatient_no\' id=\'hdnpatient_no\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type=\'hidden\' name=\'hdnencounter_from_date\' id=\'hdnencounter_from_date\' id=\'hdnencounter_from_date\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t<input type=\'hidden\' name=\'hdnencounter_to_date\' id=\'hdnencounter_to_date\' id=\'hdnencounter_to_date\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\'hidden\' name=\'hdnepisode_type\' id=\'hdnepisode_type\' id=\'hdnepisode_type\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t<input type=\'hidden\' name=\'hdnencounter\' id=\'hdnencounter\' id=\'hdnencounter\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t<input type=\"hidden\" name=\"hdnepisode_id\" id=\"hdnepisode_id\" id=\"hdnepisode_id\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t<input type=\'hidden\' name=\'spanColor\' id=\'spanColor\' value = \'\'>\n\t<input type=\'hidden\' name=\'selectindividual\' id=\'selectindividual\' value = \'\'>\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value = \'\'>\n\t<input type=\'hidden\' name=\'clinic\' id=\'clinic\' value = \'\'>\n\t<input type=\'hidden\' name=\'physicianid\' id=\'physicianid\' value = \'\'>\n\t<input type=\'hidden\' name=\'blngservcode\' id=\'blngservcode\' value = \'\'>\n\t<input type=\'hidden\' name=\'description\' id=\'description\' value = \'\'>\n\t<input type=\'hidden\' name=\'primarykey\' id=\'primarykey\' value = \'\'>\n\t<input type=\'hidden\' name=\'line\' id=\'line\' value = \'\'>\n\t<input type=\'hidden\' name=\'mod\' id=\'mod\' value = \'\'>\n\t<input type=\'hidden\' name=\'secondarykey\' id=\'secondarykey\' value = \'\'>\n\t<input type=\'hidden\' name=\'lin\' id=\'lin\' value = \'\'>\t\n\t<input type=\'hidden\' name=\'servitemcode\' id=\'servitemcode\' value = \'\'>\n\t<input type=\'hidden\' name=\'desc\' id=\'desc\' value = \'\'>\n\t<input type=\'hidden\' name=\'interfaceddate\' id=\'interfaceddate\' value = \'\'>\n\t<input type=\'hidden\' name=\'charged\' id=\'charged\' value = \'\'>\n\t<input type=\'hidden\' name=\'grossamt\' id=\'grossamt\' value = \'\'>\n\t<input type=\'hidden\' name=\'discount\' id=\'discount\' value = \'\'>\n\t<input type=\'hidden\' name=\'netamt\' id=\'netamt\' value = \'\'>\n\t<input type=\'hidden\' name=\'details\' id=\'details\' value = \'\'>\t\t\t\n\t\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' id=\'prevClicked\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\t\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t<input type=\'hidden\' name=\'epiId_";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\' id=\'epiId_";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t<input type=\'hidden\' name=\'visId_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' id=\'visId_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t<input type=\'hidden\' name=\'patId_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' id=\'patId_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t<input type=\'hidden\' name=\'patName_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' id=\'patName_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t<input type=\'hidden\' name=\'chargestate_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' id=\'chargestate_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t<input type=\'hidden\' name=\'total\' id=\'total\' id=\'total\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' id=\'rowClicked\' value=\'\'>\n\t<input type=\'hidden\' name=\'count\' id=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t            </tr>\n\t            ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t           \n\t            \n\t            \n\t            \n\t            </tbody>\n\t            </table>\n\t            </div>\n\t            </Form>\n\t            </fieldset>\n\t            </body>\n\t            </html>\n\n\t\t\n\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );
	
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





private String qtyDecimal(String input)
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
 

try
{
Connection con=null;
 ResultSet rs=null;
 
 String classval="label";
PreparedStatement pstmt=null;
try{
	
	HttpSession httpSession = request.getSession(false);				
	con	=	ConnectionManager.getConnection(request);		
	 
}catch(Exception e)
{
	System.out.println("Exception in e"+e);
	e.printStackTrace();
	
}

            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
int constCount = 50;
String nextYn = "N";
String prevYn = "N";
String traversal = "N";
String fromRcrd = "";
String toRcrd = "";
int startIndex = 0;
int startRcrd = 0;
int endRcrd = 0;
int totalRecord=0;
int total=0;
//int rowIndx=1;
SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	System.out.println("in jsp 1");
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	System.out.println("in jsp 2"+fromRcrd);
	System.out.println("in jsp 3"+toRcrd);
	if(fromRcrd == null || "".equals(fromRcrd)){
		System.out.println("in jsp 111111111"+fromRcrd);
		startRcrd = 1;
	}
	else{
		System.out.println("in jsp 211111111"+fromRcrd);
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	System.out.println("in jsp 2"+fromRcrd);
	System.out.println("in jsp 3"+toRcrd);
		


            _bw.write(_wl_block3Bytes, _wl_block3);

String facilityId=(String) session.getValue("facility_id");
String locale	= (String)session.getAttribute("LOCALE");	
String episodeId=request.getParameter("episode_id");
String visitId=request.getParameter("visit_id");
String records=request.getParameter("records");
String modules=request.getParameter("modules");
String prModule=request.getParameter("prmodule");
String pRModule=request.getParameter("pr_module");
String prKeyMain=request.getParameter("prkeymain");
String episodeType=request.getParameter("episode_type");
String patient=request.getParameter("patient");
String patientNo=request.getParameter("patient_no");
String encounter=request.getParameter("encounter");
String serviceLocationCode=request.getParameter("service_location_code");
String serviceLocationDesc=request.getParameter("service_location_desc");
String encounterFromDate=request.getParameter("encounter_from_date");
String encounterToDate=request.getParameter("encounter_to_date");
String moduleId=request.getParameter("module_id");
String siteId=request.getParameter("site_id");
String futureYn = request.getParameter("futureYn");
	
 // total = Integer.parseInt(total);
//System.out.println(" totalRecords"+ total);


if(startRcrd>1){
	System.out.println("sguu"+startRcrd);
	prevYn = "Y";
	traversal = "Y";
}

if((startRcrd+constCount) < totalRecord){
	System.out.println("suguuuuu"+startRcrd+constCount);
	nextYn = "Y";
	traversal = "Y";
}	


try{







}catch(Exception e)
{
	System.err.println("Exception in BLBillGenInterfaceInBean "+ e);
	e.printStackTrace();
}



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
				
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
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 
	                  BLBillGenInterfaceInBean inBean=new BLBillGenInterfaceInBean();

	                  inBean.setFacilityId(facilityId);
	                  inBean.setLanguageId(locale);
	                  inBean.setFromDate(encounterFromDate);
	                  inBean.setToDate(encounterToDate);
	                  inBean.setEpisodeType(episodeType);
	                  inBean.setPatientId(patientNo);
	                  inBean.setEpisodeId(episodeId);
	                  inBean.setVisitId(visitId);
	                  inBean.setEncounter(encounter);
	                  inBean.setModules(modules);
	                  inBean.setServiceLocation(serviceLocationDesc);
	                  inBean.setPrMain(prKeyMain);
	                  inBean.setModuleId(moduleId);
	                  inBean.setServiceLocationCode(serviceLocationCode);
	                  inBean.setFutureYn(futureYn); 
	              //   inBean.setTotalRecordCount(total);
	                   
	               	    System.out.println(" facility id bean get "+ inBean.getFacilityId());
		                System.out.println("language id "+inBean.getLanguageId()); 
		                System.out.println("from date "+inBean.getFromDate()); 
		                System.out.println("todate "+inBean.getToDate()); 
		                System.out.println("epi type "+inBean.getEpisodeType()); 
		                System.out.println("pat id "+inBean.getPatientId()); 
		                System.out.println("epi id "+inBean.getEpisodeId()); 
		                System.out.println("visit id "+inBean.getVisitId()); 
		                System.out.println("encounter "+inBean.getEncounter()); 
		                System.out.println(" modules "+inBean.getModules()); 
		                System.out.println("serv location "+inBean.getServiceLocation()); 
		                System.out.println("pr main "+inBean.getPrMain()); 
		                System.out.println("module id "+inBean.getModuleId()); 
		                System.out.println("serv location code "+inBean.getServiceLocationCode());  
		               System.out.println("serv location code==============================="+  inBean.getTotalRecordCount());  
		               
		            	inBean.setStartFrom(startRcrd);
		            	inBean.setEndWith(endRcrd);
		                
		            
	                  BillReceiptBC receiptBC = new BillReceiptBC();
	             
	                  List<BLBillGenInterfaceBean> ipList=receiptBC.getBillGenInterfaceRecords(inBean);
	                  int rowIndx=1;
	                  int size=ipList.size();
	                  String spanClass="";
	                  String pKeyLength="";
	                  String sKeyLength="";
	                  String currentStage="";
	                   System.out.println("size =" +size);
	                  for(Iterator iterator= ipList.iterator(); iterator.hasNext();)
	                  {
						  
	                	BLBillGenInterfaceBean bean =(BLBillGenInterfaceBean) iterator.next();
						spanClass=bean.getColor();
						pKeyLength=bean.getPrimaryKeyModuleId();
						sKeyLength=bean.getSecondaryKeyModuleId();
						currentStage=bean.getChargingState();
						
						System.out.println("span Class before if = "+ currentStage);
						//System.out.println("episode id/ visit id / patient id "+bean.getEpisodeId() +"/" + bean.getVisitId() +"/" +bean.getPatientId());
						
						if("".equals(spanClass) || spanClass==null || spanClass=="null" )
						{
							//System.out.println("if "+spanClass);
							spanClass="";
						}
						
						else if(spanClass.equals("ORD"))
	           			{
							//System.out.println("ord");
	           				spanClass="ordered";
	           			}
						else if(spanClass.equals("PAT"))
	           			{
							System.out.println("PAT");
	           				spanClass="";
	           			}
	           			else if(spanClass.equals("REG"))
	           			{
	           				//System.out.println("reg");
	           				spanClass="registered";
	           			}
	           			else if(spanClass.equals("CMP"))
	           			{
	           				//System.out.println("reg");
	           				spanClass="completed";
	           			}
	           			else 
	           			{
	           				//System.out.println("res");
	           				spanClass="resulted";
	           			}
						
						
						if("".equals(currentStage) || currentStage==null || currentStage=="null" )
						{
							//System.out.println("if "+spanClass);
							currentStage="";
						}
						
						else if(currentStage.equals("ORD"))
	           			{
							//System.out.println("ord");
	           				currentStage="On Order";
	           			}
						else if(currentStage.equals("RES"))
	           			{
							System.out.println("RES");
							currentStage="On Result";
	           			}
	           			else if(currentStage.equals("REG"))
	           			{
	           				//System.out.println("reg");
	           				currentStage="On Registration";
	           			}
	           			else if(currentStage.equals("CMP"))
	           			{
	           				//System.out.println("reg");
	           				currentStage="On Completion";
	           			}
	           			else 
	           			{
	           				//System.out.println("res");
	           				currentStage="";
	           			}
						
						
						
						
						
	           				
						
	           
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(spanClass ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getPrimaryKeyModuleId() ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( bean.getClinic()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getPhysicianId()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getBlngServCode()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getBlngServiceDesciption()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( bean.getPrimaryKeyMain()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( bean.getPrimaryKeyLine()));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getSecondaryKeyModuleId()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( bean.getSecondaryKeyMain()));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( bean.getSecondaryKeyLine()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( bean.getServiceItemCode()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( bean.getServiceItemDescription()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(date.format(bean.getInterfacedDate())));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( qtyDecimal(bean.getGrossAmt())));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( qtyDecimal(bean.getDiscount())));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( qtyDecimal(bean.getNetAmt())));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(currentStage));
            _bw.write(_wl_block110Bytes, _wl_block110);
	System.out.println("stage"+bean.getChargingState());
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(futureYn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(records ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(modules ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(prModule));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(serviceLocationCode ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(serviceLocationDesc ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(patientNo ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(encounterFromDate ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(encounterToDate));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(encounter ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.getEpisodeId() ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.getVisitId() ));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.getPatientId() ));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.getPatientName() ));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(rowIndx ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bean.getChargingState() ));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bean.getTotalRecordCount() ));
            _bw.write(_wl_block143Bytes, _wl_block143);
System.out.println("total"+bean.getTotalRecordCount());
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(rowIndx));
            _bw.write(_wl_block145Bytes, _wl_block145);

	            rowIndx++;

	            System.out.println(" rowIndx  value after increament "+rowIndx);
	                  }
	            
	                  
	                  
}catch(Exception ex)
{
	System.err.println("Exception in main "+ex);
	ex.printStackTrace();
}
	            
            _bw.write(_wl_block146Bytes, _wl_block146);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PhysicianId.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNG_SERV_CODE.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PrimaryKey.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Line.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SecondaryKey.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Line.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceItemcode.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.InterfacedDate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Charged.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GROSS_AMT.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_CHARGE.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
