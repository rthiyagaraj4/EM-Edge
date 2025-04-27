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
import java.text.*;
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blreprintprocess extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintProcess.jsp", 1737916703506L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n---------------------------------------------------------------------------------------------\n1            V210104             11948          NMC-JD-SCF-0127-TF          Mohana Priya K\n2            V210129             13523          MOHE-CRF-0060       \t\tShikha Seth\n3            V210624             17147     \t\tPMG2021-COMN-CRF-0077\t\tMuthkumarN\n4\t         V221107\t\t\t\t\t\t\t\tTH-KW-CRF-0174  \t\tMohana Priya K\n-->\n";
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

    private final static java.lang.String  _wl_block9_0 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<script language=\'javascript\' src=\'../../eBL/js/BLReprintReport.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<script>\n\t\t$(document).ready(function(event){\n\t\t\t$(\"input[type=\'text\']\").keydown(function(e){\n\t\t\t\tif (e.which === 8 && !$(e.target).is(\"input[type=\'text\']:not([readonly])\")) {\n\t\t\t\t\te.preventDefault();\n\t\t\t    }\n\t\t\t});\n\t\t\t\n\t\t\tif($(\'#traverse\').val() == \'Y\'){\n\t\t\t\t$(\'#trProgress\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#trProgress\').hide();\n\t\t\t}\n\t\t\t\n\t\t\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#nextSpan\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#nextSpan\').hide();\n\t\t\t}\n\t\t\t\t\n\t\t\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t\t\t$(\'#previousSpan\').show();\n\t\t\t}else{\n\t\t\t\t$(\'#previousSpan\').hide();\n\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t$(\'#nextSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\t\t\tdocument.location.href = \"BLReprintProcess.jsp?from_bill_number_code=\"+$(\'#hdnBillDocFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_number_code=\"+$(\'#hdnBillDocTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_bill_number=\"+$(\'#hdnBillNoFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_number=\"+$(\'#hdnBillNoTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_bill_date=\"+$(\'#hdnBillDateFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_date=\"+$(\'#hdnBillDateTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episode_type=\"+$(\'#hdnEpisodeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_type=\"+$(\'#hdnBillType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&patientId=\"+$(\'#hdnPatientId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episodeId=\"+$(\'#hdnEpisodeId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&visitId=\"+$(\'#hdnVisitId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&outStdOnly=\"+$(\'#hdnOutStd\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&cust_code=\"+$(\'#hdncustCode\').val()+ \t\n\t\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\t\t\t\t\t\t\t\"&payer_group=\"+$(\'#payer_group\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&payer_type=\"+$(\'#payer_type\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&zerobill=\"+$(\'#zerobill\').val();\n\t\t\t});\n\t\t\t$(\'#previousSpan\').click(function(){\n\t\t\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\t\t\tdocument.location.href = \"BLReprintProcess.jsp?from_bill_number_code=\"+$(\'#hdnBillDocFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_number_code=\"+$(\'#hdnBillDocTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_bill_number=\"+$(\'#hdnBillNoFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_number=\"+$(\'#hdnBillNoTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&from_bill_date=\"+$(\'#hdnBillDateFrom\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&to_bill_date=\"+$(\'#hdnBillDateTo\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episode_type=\"+$(\'#hdnEpisodeType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&bill_type=\"+$(\'#hdnBillType\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&patientId=\"+$(\'#hdnPatientId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&episodeId=\"+$(\'#hdnEpisodeId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&visitId=\"+$(\'#hdnVisitId\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&outStdOnly=\"+$(\'#hdnOutStd\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&cust_code=\"+$(\'#hdncustCode\').val()+ \t\n\t\t\t\t\t\t\t\t\t\t\"&fromRcrd=\"+startFrom+\n\t\t\t\t\t\t\t\t\t\t\"&toRcrd=\"+endWith+\n\t\t\t\t\t\t\t\t\t\t\"&payer_group=\"+$(\'#payer_group\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&payer_type=\"+$(\'#payer_type\').val()+\n\t\t\t\t\t\t\t\t\t\t\"&zerobill=\"+$(\'#zerobill\').val();\n\n\t\t\t});\n\t\t\t//ENM-2558 - MMS-QH-CRF-0163 Karthik added for Select All Case\n\t\n\t\t\t$(\'#selectAll\').click(function(){\n\t\t\t\t\n\t\t\tvar patId=$(\'#hdnPatientId\').val();\n\t\t\tvar site_id = $(\'#site_id\').val();\n\t\t\t//var demo_version =  $(\'#demo_version\').val();//Commented against V210622\n\t\t\tvar index = $(\'#tbl tr\').length;\n\t\t\t\n\t\t\tvar selectedFrameDoc = parent.selectedFrame.document;\n\t\t\tvar index2 = $(selectedFrameDoc).find(\'#indexTrack\').val();\n\t\t\tvar trlast = $(parent.selectedFrame.document).find(\'#tblSelectedReport tr:last\');\n\t\t\tvar lastIndex =  $(selectedFrameDoc).find(\'#indexTrack\').val(); \n\t\t\tvar index1= $(\'#tblSelectedReport tr\').length;\n\t\t\tvar site3TierAlmoFeatureYN=$(\'#site3TierAlmoFeatureYN\').val();//V210104\n\n\t\t\tif (lastIndex == \'undefined\' || lastIndex == undefined) {lastIndex= 0;}\n\t\t\tvar limitexc = (parseInt(index2)+(parseInt(index)-2));\n\t\t\tvar chkBill=\'\';\n\t\t\tchkBill=parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.checked;\n\t\t\t\n\t\t\tif(chkBill == true){\n\t\t\t\t\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").show();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").hide();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").hide();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#report_type\").hide();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#payer_type\").hide();\n\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").hide();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").show();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").show();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#report_type\").show();\n\t\t\t\t$(parent.buttonFrame.document).find(\"#payer_type\").show();\n\t\t\t}\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t//if((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\')&& demo_version == \'Y\'){ //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1\n\t\t\tif((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\')){//removed demo_version against V210603\n\t\t\tif(parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.checked==true)\n\t\t\t{\n\t\t\t\t\n\t\t\tif(patId == \"\"){ return;}\n\t\t\t}\n\t\t\tif(lastIndex>=50) \n\t\t\t{\n\t\t\t\talert(\"Already 50 rows got selected Can\'t proceed\");\n\t\t\t\t//if((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\') && demo_version == \'Y\') //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1\n\t\t\t\tif((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\'))\n\t\t\t\t{//removed demo_version against V210603\t\t\t\t\t\n\t\t\t\t\tif(chkBill == true)\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=rem_slmt_amt]\').each(function(){\n\t\t\t\t\t\t\t$(this).prop(\'disabled\',false);\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=bill_print_yn]\').each(function(){\n\t\t\t\t\t\t\t$(this).prop(\'disabled\',false);\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").show();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").hide();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").hide();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#report_type\").hide();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#payer_type\").hide();\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=rem_slmt_amt]\').each(function(){\n\t\t\t\t\t\t\t$(this).prop(\'disabled\',true);\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=bill_print_yn]\').each(function(){\n\t\t\t\t\t\t\t$(this).prop(\'disabled\',true);\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").hide();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").show();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").show();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#report_type\").show();\n\t\t\t\t\t\t$(parent.buttonFrame.document).find(\"#payer_type\").show();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tresetFlag();\n\t\t\t\treturn false;\t\t\t\n\t\t\t} \t\t\t \n\t\t\t}\t\t\t\t \n\t\t\tfor (all = 1; all < (index-1); all++) {\t\t\t\t\t\t\t\n\t\t\t\t\tmoveData(all,true,false,1);\t\t\t\n\t\t\t}\n\t\t\t\t\t\t\t\t\t\n\t\t\t//if((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\') && demo_version == \'Y\'){ //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1\n\t\t\tif((site_id == \'ALMO\' || site3TierAlmoFeatureYN == \'Y\')){ //removed demo_version against V210603\n\t\t\t\tif(chkBill == true){\n\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=rem_slmt_amt]\').each(function(){\n\t\t\t\t\t\t$(this).prop(\'disabled\',false);\n\t\t\t\t\t});\n\t\t\t\t\t\n\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=bill_print_yn]\').each(function(){\n\t\t\t\t\t\t$(this).prop(\'disabled\',false);\n\t\t\t\t\t});\n\t\t\t\t\t\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").show();\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").hide();\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").hide();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=rem_slmt_amt]\').each(function(){\n\t\t\t\t\t\t$(this).prop(\'disabled\',true);\n\t\t\t\t\t});\n\t\t\t\t\t\n\t\t\t\t\t$(selectedFrameDoc).find(\'[id^=bill_print_yn]\').each(function(){\n\t\t\t\t\t\t$(this).prop(\'disabled\',true);\n\t\t\t\t\t});\n\t\t\t\t\t\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnSettlement\").hide();\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnCancel\").show();\n\t\t\t\t\t$(parent.buttonFrame.document).find(\"#btnReprint\").show();\n\t\t\t\t}\n\t\t\t}\n\t\t\tresetFlag();\t\t\n\t});\n});\n</script>\n<style>\ndiv.tableContainer {\n\twidth: 100%;\t\t/* table width will be 99% of this*/\n\theight: 160px; \t/* must be greater than tbody*/\n\toverflow: auto;\n\tmargin: 0 auto;\n}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\n\t\tTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\t/* PADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px */\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  /* PADDING-LEFT:7px;\n  PADDING-RIGHT:7px */\n}\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\t/* PADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px */\n\t\t}\n\t\n\n\t\t</style>\n\t</HEAD> \n\n\t<script>\n\t\tfunction selected(i)\n\t\t{\t\t\t\t\n\t\t\tvar selected_row=eval(document.forms[0].selected_row+i);\t\t\n\t\t\tif(selected_row.checked==false)\n\t\t\t{\t\n\t\t\tselected_row.checked=false;\n\t\t\tdocument.resultForm.checked_row.value=\"\";\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\t\t\n\t\t\t\tvar total_records=document.forms[0].total_records.value;\t\t\t\t\t\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t\t{ \n\t\t\t\t\tvar te";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="mp=eval(document.resultForm.selected_row+j);\t\t\t\t\t\n\t\t\t\t\ttemp.checked=false;\n\t\t        }\n\t\t\tselected_row.checked=true;\t\t\t\t\n\t\t\tdocument.forms[0].checked_row.value=i;\n\t\t\t}\n\t\t\tif(selected_row.checked)\n\t\t\t{\n\t\t\t  selected_row.value=\"1\";\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tselected_row.value=\"1\";\t\n\t\t\t}\n\t\t}\t\n\t\t\n\t\tfunction no_record_check()\n\t\t{\t\t\t\n\t\t\t//alert(\"no records check\");\n\t\t\t//parent.dummy_frame.location.href=\'../../eCommon/html/blank.html\';\n \t\t\tvar total_records=document.forms[0].total_records.value;\n\t\t\tif(total_records==0)\n\t\t\t{\n\t\t\t\tsetTimeout(function(){ alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\")); }, 100);\n\t\t\t\t$(\"#tableContainer\").html(\"\");\n\t\t\t\t//parent.frames[1].document.forms[0].submit_but.disabled=true;\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=&err_value=\";\n\n\t\t\t}\n\t\t\tparent.search_hdr.document.forms[0].total_records.value=total_records;\n\t\t\t\n\t\t}\n\n\t\tfunction assign_value()\n\t\t{\n\t\t\tparent.search_hdr.document.forms[0].group_by.value = document.forms[0].group_by.value;\n\t\t}\n\n\t</script>\n\t<body onLoad=\"no_record_check();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\">\n\t<form name=\'resultForm\' id=\'resultForm\'> \n\t\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<div id=\"tableContainer\">\n\t\t\t<table border=\'\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' >\t\n\t\t\t<thead>\n\t\t\t<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td colspan=\'13\' nowrap=\"nowrap\">\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td colspan=\'11\' nowrap=\"nowrap\">\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t\t\t<td colspan=\'1\' nowrap=\"nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'previousSpan\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'1\' nowrap=\"nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer;cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'nextSpan\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t<tr style=\"position: sticky;z-index: 1;top: 0;\">\n<!-- \t\t\t\t\tENM-2558 - MMS-QH-CRF-0163 Karthik Added isForALL attribute to skip alert in Select All Case \t-->\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'><div id=\'selectAll\'><span style=\"color: blue; font-size: 12px;cursor:pointer \">(+)</span>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\' style=\"white-space: nowrap\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\' style=\"white-space: nowrap\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\t\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\'style=\"white-space: nowrap\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'11%\'style=\"white-space: nowrap\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\t\n<!-- \t\t\t\tKarthik Commented to Remove Billing class code -->\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\' style=\"white-space: nowrap\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t<!--added against MOHE-CRF-0039--> \t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td> <!--added against MOHE-CRF-0039-->\t\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\n\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t<tbody>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\n\t\t\t\t<tr id=row";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onclick=\'highlightRow(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\")\'>\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="_col0\' class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\"5%\" style=\'cursor:pointer; white-space: nowrap\' >\n\t\t\t\t<!-- ENM-2558 - MMS-QH-CRF-0163 Karthik changed Selection option from \'checkbox\' to \'Button\' and added isForALL attribute to skip alert in Select All Case -->\n\t\t\t\t\t\t<div  id=\'doc_typ_chk";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'doc_typ_chk";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' index=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onclick=\"moveData(";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =",false,true,0)\"> <div style=\"color: blue; font-size: 12px;\">+</div> </div>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="_col1\' class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" width=\"7%\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" id=\'doc_typ_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' name=\'doc_typ_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</span>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="_col2\' class=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" width=\"11%\" class=\"fields\" style=\'cursor:pointer; white-space: nowrap\' onclick=\"tooltip(this,";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =");\"\tonmouseover=\"hideToolTip();\">\n\t\t\t\t\t\t<span class=\"LABEL\" name=\'doc_num";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'doc_num";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</span>&nbsp;\n\t\t\t\t\t\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="_col3\' class=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" width=\"12%\" class=\"fields\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" name=\'doc_date";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'doc_date";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</span> \n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="_col4\' class=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" width=\"11%\" class=\"fields\"style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" name=\'bill_tot_amt";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'bill_tot_amt";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</span> \n\t\t\t\t\t</td>\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_col13\' class=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" width=\"11%\" class=\"fields\"style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" name=\'bill_paid_amt";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'bill_paid_amt";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="_col14\' class=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" width=\"11%\" class=\"fields\"style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' name=\'bill_outstd_amt";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'bill_outstd_amt";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</span> \n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="_col5\' width=\"7%\" class=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\"LABEL\" name=\'patient_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'patient_id";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</span>\n\t\t\t\t\t</td>\t\t\t\n\t\t<!-- Karthik Commented to Remove Billing class code and make it hidden -->\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t<!-- \t\t\t\t\t</td> -->\n\t\t\t\t\t<input type=\'hidden\' name=\'bill_nat_code";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'  id=\'bill_nat_code";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'strOperatingFacilityId";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'  id=\'strOperatingFacilityId";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'mpi_id";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'  id=\'mpi_id";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'><!--V221107-->\n\t\t\t\t\t<input type=\"hidden\"\tname=\"setlmt_ind";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"  id=\'setlmt_ind";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'\tvalue=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><!-- V221117 -->\n\t\t\t\t\t<input type=\"hidden\"\tname=\"insBillAmt";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"  id=\'insBillAmt";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"><!-- V221117 -->";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="_col7\' class=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" width=\"7%\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' id=\'bill_grp_id";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' name=\'bill_grp_id";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="_col8\' class=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" width=\"8%\" class=\"fields\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' name=\'payer_code";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'payer_code";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</span>\n\t\t\t\t\t</td>\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="_col9\' width=\"6%\" class=";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' readonly name=\'episode_type";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'episode_type";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="_col10\' width=\"6%\" class=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' name=\'episode_id";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' id=\'episode_id";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</span>\n\t\t\t\t\t</td>\t\t\n\t\t\n\t\t\t\t\t<td id=\'row";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="_col11\' class=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" width=\"6%\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' readonly name=\'visit_id";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'visit_id";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</span> \n\t\t\t\t\t</td>  \n\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="_col12\' class=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" width=\"8%\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' readonly name=\'excempted_amt";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'excempted_amt";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" width=\"8%\" style=\"white-space: nowrap\">\n\t\t\t\t\t\t<span class=\'LABEL\' readonly name=\'drug_penalty";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'drug_penalty";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t</tr> \n ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t</tbody>\n\t\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\t\n\t\t<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\t\t\n\t\t<input type=\'hidden\' name=\'rowClicked\' id=\'rowClicked\' id=\'rowClicked\' value = \'\'>\t\t\n\t\t<input type=\'hidden\' name=\'docType\' id=\'docType\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'documentNumber\' id=\'documentNumber\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'documentDate\' id=\'documentDate\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'billedAmount\' id=\'billedAmount\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'billingClassCode\' id=\'billingClassCode\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'billingGroup\' id=\'billingGroup\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'payerCode\' id=\'payerCode\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'visitId\' id=\'visitId\' value = \'\'>\n\t\t<input type=\'hidden\' name=\'excempted_amt\' id=\'excempted_amt\' value = \'\'>\t\n\t\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n<!-- \t\t<script>parent.dummy_frame.location.href=\'../../eCommon/html/blank.html\';</script>\t -->\n\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\'  value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\'  value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'constCount\'  id=\'constCount\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type=\'hidden\' name=\'prevClicked\'  id=\'prevClicked\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnNextSpan\'  id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t<input type=\'hidden\' name=\'prevSpan\'  id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\'hidden\' name=\'traverse\'  id=\'traverse\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\n\t<!-- Hidden Vars for Next / Prev Refresh -->\n\t<input type=\'hidden\' name=\'hdnEpisodeType\'  id=\'hdnEpisodeType\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t<input type=\'hidden\' name=\'hdnPatientId\'  id=\'hdnPatientId\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t<input type=\'hidden\' name=\'hdnEpisodeId\'  id=\'hdnEpisodeId\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillNoFrom\'  id=\'hdnBillNoFrom\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillDateFrom\'  id=\'hdnBillDateFrom\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillDocFrom\'  id=\'hdnBillDocFrom\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillNoTo\'  id=\'hdnBillNoTo\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillDateTo\'  id=\'hdnBillDateTo\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillDocTo\'  id=\'hdnBillDocTo\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t\n\t<input type=\'hidden\' name=\'hdnVisitId\'  id=\'hdnVisitId\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\t<input type=\'hidden\' name=\'hdnBillType\'  id=\'hdnBillType\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t<input type=\'hidden\' name=\'hdnDtlBillPrint\'  id=\'hdnDtlBillPrint\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnOutStd\'  id=\'hdnOutStd\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t<input type=\'hidden\' name=\'hdncustCode\'  id=\'hdncustCode\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t<input type=\'hidden\' name=\'site_id\'  id=\'site_id\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t<!-- <input type=\'hidden\' name=\'demo_version\' id=\'demo_version\' id=\'demo_version\' value=\'\'> //removed demo_version against V210603-->\n\t<input type=\'hidden\' name=\'excempted_amt\'  id=\'excempted_amt\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t<input type=\'hidden\' name=\'payer_group\'  id=\'payer_group\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t<input type=\'hidden\' name=\'payer_type\'  id=\'payer_type\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t<input type=\'hidden\' name=\'zerobill\'  id=\'zerobill\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t<input type=\'hidden\' name=\'noofdecimal\'   value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t<input type=\'hidden\' name=\'site3TierAlmoFeatureYN\'  id=\'site3TierAlmoFeatureYN\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t<input type=\'hidden\' name=\'eSignYN\' id=\'eSignYN\'  value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'><!--V221107-->\n\t\n\t\n<!-- \tAdded by Karthik to include login user in Param 17  -->\n\t<input type=\'hidden\' name=\'login_user\' id=\'login_user\'  value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t\n\t<!-- Hidden Vars for Next / Prev Refresh -->\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"  value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t</form >\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\"position: absolute; width: 12%; visibility: visible; left: 451px; top: 40px; background-color: #808080 !important; z-index: 1000;\">\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t<!-- </td> -->\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t</body>\n\t</TBODY>\t\n\t</div>\n</HTML>\n\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );
	
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
	//Karthik added here
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Connection con1 = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;
	Statement stmt2				= null;
	ResultSet rs2 = null;
	
	ResultSet rscurr=null;
	String locale="";	

	String classval="";
	int total_records=0;
	
	String p_facility_id="";
	String p_from_bill_number_code="";
	String p_to_bill_number_code="";
	String p_from_bill_number="";	
	String p_to_bill_number=""; 
	String p_from_bill_date="";
	String p_to_bill_date="";
	String p_payer_code="";	
	String p_episode_type="";	
	String p_bill_type="";
	String p_outstd_only = "";
	String p_cust_code = "";
	
	String strRowId="";
	String strDocTypCode="";
	String strDocNum="";	
	String strDocDate="";
	String strBillTotAmt="";
	String strPatientId="";
	String strBillNatCode="";
	String strBillingGroupId="";
	String strCustCode="";
	String strepisodeTyp="";
	String strepisodeId="";
	String strVisitId="";
	String strBillPrintFlag="";
	String patientId="";
	String episodeId = "";
	String visitId = "";
	String billPaidAmt = "";
	String totOutAmt = "";
	String site_id="";
	String excemptedAmt="";
	String drugPenalty="";
	int noofdecimal=2;
	int doc_amt=0;
	//For Traversal
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
	String amt="";
	String amt1="";

	String mpi_id="";//V221107
	String setlmt_ind = "";//V221107
	String insBillAmt=""; //V221107
	String eSignYN ="";
	String payer_group="";
	String payer_type="";
	//String demo_version="";//Commented against V210622
	String zerobill="";
	String strOperatingFacilityId=""; //V210129
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	Connection con2 = null;		
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	try {
		con2	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BLReprintProcess.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}finally{
			if(con2!=null) {
				ConnectionManager.returnConnection(con2, request);
			}
		}
		
	
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
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

	//For Traversal
	
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{	
		HttpSession httpSession = request.getSession(false);		
		
		con	=	ConnectionManager.getConnection(request);
			
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		eSignYN = BLReportIdMapper.eSignatureFlag(p_facility_id); //V221107
		if(eSignYN == null) eSignYN = "N";
		System.err.println("eSignYN "+eSignYN);
		
		p_from_bill_number_code=request.getParameter("from_bill_number_code");
		if(p_from_bill_number_code==null || p_from_bill_number_code.equals("")) p_from_bill_number_code="";		
		p_to_bill_number_code=request.getParameter("to_bill_number_code");
		if(p_to_bill_number_code==null || p_to_bill_number_code.equals("")) p_to_bill_number_code="";
		p_from_bill_number=request.getParameter("from_bill_number");
		if(p_from_bill_number==null || p_from_bill_number.equals("")) p_from_bill_number="";
		p_to_bill_number=request.getParameter("to_bill_number");
		if(p_to_bill_number==null || p_to_bill_number.equals("")) p_to_bill_number="";
		p_from_bill_date=request.getParameter("from_bill_date");
		if(p_from_bill_date==null || p_from_bill_date.equals("")) p_from_bill_date="";
		p_to_bill_date=request.getParameter("to_bill_date");
		if(p_to_bill_date==null || p_to_bill_date.equals("")) p_to_bill_date="";
		p_payer_code=request.getParameter("payer_code");
		if(p_payer_code==null || p_payer_code.equals("")) p_payer_code="";		
		p_episode_type=request.getParameter("episode_type");
		if(p_episode_type==null) p_episode_type="";
		p_bill_type=request.getParameter("bill_type");
		if(p_bill_type==null) p_bill_type="";
		payer_group=request.getParameter("payer_group");
		if(payer_group==null) payer_group="";
		
		payer_type=request.getParameter("payer_type");
		if(payer_type==null) payer_type="";
		
		zerobill=request.getParameter("zerobill");
		if(zerobill==null) zerobill="";
		
		
		p_cust_code=request.getParameter("cust_code");
		if(p_cust_code==null) p_cust_code="";


		patientId = checkForNull(request.getParameter("patientId"));
		episodeId = checkForNull(request.getParameter("episodeId"));
		visitId = checkForNull(request.getParameter("visitId"));
		p_outstd_only = checkForNull(request.getParameter("outStdOnly"));

		
		System.out.println("p_payer_code/p_episode_type/p_bill_type>>>>>>>>>>>" +p_payer_code+"/"+p_episode_type+"/"+p_bill_type);
		
		String site_id_sql = "select customer_id from sm_site_param ";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(site_id_sql);	

			if(rs.next())
			{
			   site_id  =  rs.getString(1);	
			}

		if(rs!=null)   rs.close();
		if(stmt!=null) stmt.close();		
	}
	catch(Exception eX)
	{	
		//out.println("Error= "+eX);
		eX.printStackTrace();			
	}

	/* Commented against V210622
	try{ 
		con1	=	ConnectionManager.getConnection(request);	
		//String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";

		String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = '"+p_facility_id+"' ";//MOHE-SCF-0016

		Statement stmt2 = con1.createStatement();
		ResultSet rs2 = stmt2.executeQuery(demo_identifier_sql);	

		if(rs2.next())
		{
			demo_version  =  rs2.getString(1);	
			System.err.println("BLReprint Process demo_identifier" +demo_version);
		}

			if(rs2!=null)   rs2.close();
			if(stmt2!=null) stmt2.close();	
		}
		catch(Exception eX)
		{	
			out.println("Error 1= "+eX);			
		}
		finally
		{
			if(con1!=null) 
			{
			ConnectionManager.returnConnection(con1, request);
			}
		}*/
	
	try
	{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}		
		}
		catch(Exception e)
		{    e.printStackTrace();
			System.out.println("3="+e.toString());
		}
	finally
	{
		if (rscurr != null)   rscurr.close();
		if (pstmt != null) pstmt.close();		
	}


            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

		try
		{		
			/*String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_num, to_char(doc_date,'dd/mm/yyyy hh24:mi') doc_date, bill_tot_amt, patient_id,bill_nature_code,"+
					 " blng_grp_id, cust_code, episode_type, episode_id,visit_id, bill_print_flag,bill_paid_amt,bill_tot_outst_amt,operating_facility_id "+ //V210129 
					 " FROM bl_bill_hdr "+
					 " WHERE "+
					 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
					 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
					 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
					 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
					 " AND NVL (bill_status, '$') <> 'C' "+
					 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
  					" and (('"+payer_type+"' ='C'  "+
  					" and cust_code is null)  "+
 					" or ('"+payer_type+"' ='R'  "+
 				  " and cust_code is not null) "+
 				  "  or ('"+payer_type+"' ='B' )) "+
 				 " and (('"+zerobill+"' = 'I') "+
 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) "; */ //Commented V221107

			String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_num, to_char(doc_date,'dd/mm/yyyy hh24:mi') doc_date, bill_tot_amt, patient_id,bill_nature_code,"+
					 "a.blng_grp_id blng_grp_id, a.cust_code, episode_type, episode_id,visit_id, bill_print_flag,bill_paid_amt,bill_tot_outst_amt,operating_facility_id,MPI_ID,bill_amt,b.settlement_ind setlmt_ind"+ //V210129 
					 " FROM bl_bill_hdr a,bl_blng_grp b"+
					 " WHERE "+
					 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
					 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
					 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
					 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
					 " AND NVL (bill_status, '$') <> 'C' "+
					 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
  					" and (('"+payer_type+"' ='C'  "+
  					" and a.cust_code is null)  "+
 					" or ('"+payer_type+"' ='R'  "+
 				  " and a.cust_code is not null) "+
 				  "  or ('"+payer_type+"' ='B' )) "+
 				 " and (('"+zerobill+"' = 'I') "+
 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) and a.blng_grp_id =b.blng_grp_id  "; //V221107 174 changes

			
					 String queryCount = 
					"SELECT count(*) total "+
							 " FROM bl_bill_hdr "+
							 " WHERE "+
							 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
							 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
							 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
							 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
							 " AND NVL (bill_status, '$') <> 'C' "+
							 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
			  					" and (('"+payer_type+"' ='C'  "+
			  					" and cust_code is null)  "+
			 					" or ('"+payer_type+"' ='R'  "+
			 				  " and cust_code is not null) "+
			 				  "  or ('"+payer_type+"' ='B' )) "+
			 				 " and (('"+zerobill+"' = 'I') "+
			 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) ";
		
							 
							 String whereClause = "";
					if(!"".equals(patientId)){
						whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
					}
					
					if(!"".equals(episodeId)){
						whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
					}
					
					if(!"".equals(visitId)){
						whereClause = whereClause + " AND VISIT_ID = '"+visitId+"' ";
					}
					
					if(!"**".equals(p_episode_type)){
						whereClause = whereClause + " AND episode_type = '"+p_episode_type+"' ";
					}
					
					if(! ("**".equals(p_bill_type) || "E".equals(p_bill_type) )){
						whereClause = whereClause +  " AND bill_trx_type_code = '"+p_bill_type+"' ";
						whereClause = whereClause +  " AND episode_id is not null ";
					}
					
					if("E".equals(p_bill_type)){
						whereClause = whereClause + 	" AND episode_type ='R' ";
					} 
					
						
				if(! ("".equals(p_cust_code)) ){
						//whereClause = whereClause +  " AND CUST_CODE = '"+p_cust_code+"' ";
						whereClause = whereClause +  " AND CUST_CODE = (DECODE('"+p_cust_code+"','**',cust_code,'"+p_cust_code+"')) ";
					}

					if("Y".equals(p_outstd_only)){
						whereClause = whereClause +  " AND bill_tot_outst_amt <> 0 ";
					}		 
				/*	 " AND bill_trx_type_code = 'D' "+
					 " AND "+
					 " ((cust_code = '"+p_payer_code+"' OR (cust_code IS NULL AND rev_cust_code = '"+p_payer_code+"'))) ";*/			
			
			String orderBy=" order by doc_type_code,doc_num ";
			query_refresh  = "Select * from ("+query_refresh + whereClause +") where rnum between "+startRcrd +" and "+endRcrd + orderBy ;
					 
			queryCount  = queryCount + whereClause;
			pstmt = con.prepareStatement(queryCount);
			rs1 = pstmt.executeQuery();
			if(rs1 != null && rs1.next()){
				totalRecord = rs1.getInt("total");
			}
			if(startRcrd>1){
				prevYn = "Y";
				traversal = "Y";
			}
			
			if((startRcrd+constCount) <= totalRecord){
				nextYn = "Y";
				traversal = "Y";
			}	

			/*HashMap sqlMap = new HashMap();

			sqlMap.put("sqlData",query_refresh);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			
		//	displayFields.add("ROW_ID");	
			displayFields.add("DOC_TYPE_CODE");	
			displayFields.add("DOC_NUM");	
			displayFields.add("DOC_DATE");	
			displayFields.add("BILL_TOT_AMT");	
			displayFields.add("PATIENT_ID");	
			displayFields.add("BILL_NATURE_CODE");	
			displayFields.add("BLNG_GRP_ID");	
			displayFields.add("CUST_CODE");	
			displayFields.add("EPISODE_TYPE");	
			displayFields.add("EPISODE_ID");
			displayFields.add("VISIT_ID");	
			displayFields.add("BILL_PRINT_FLAG");					
			displayFields.add("BILL_PAID_AMT");	
			displayFields.add("BILL_TOT_OUTST_AMT");	
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("result==>"+result);*/
		
			pstmt = null;
			rs1 = null;
			
			pstmt = con.prepareStatement(query_refresh);
			rs1= pstmt.executeQuery();

            _bw.write(_wl_block10Bytes, _wl_block10);
 //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) { //removed demo_version against V210603
		
            _bw.write(_wl_block11Bytes, _wl_block11);
}
			else{
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

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
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
 
			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) { //removed demo_version against V210603
		
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
            _bw.write(_wl_block32Bytes, _wl_block32);
				int i=1;	
	if(rs1 != null){
		while(rs1.next()){
			classval = "label";
			DecimalFormat df = new DecimalFormat("0.00");
			strDocTypCode=  checkForNull(rs1.getString("doc_type_code"));
			strDocNum=checkForNull(rs1.getString("doc_num"));
			strDocDate=checkForNull(rs1.getString("doc_date"));
			
			strBillTotAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_tot_amt")));
			
			
			strPatientId=checkForNull(rs1.getString("patient_id"));
			System.err.println("strPatientId:"+strPatientId);
			strBillNatCode=checkForNull(rs1.getString("bill_nature_code"));
			System.err.println("strBillNatCode:"+strBillNatCode);
			strBillingGroupId=checkForNull(rs1.getString("blng_grp_id"));
			strCustCode=checkForNull(rs1.getString("cust_code"));
			strepisodeTyp=checkForNull(rs1.getString("episode_type"));
			strepisodeId=checkForNull(rs1.getString("episode_id"));
			strVisitId=checkForNull(rs1.getString("visit_id"));
			strBillPrintFlag=checkForNull(rs1.getString("bill_print_flag"));
			billPaidAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_paid_amt")));
			totOutAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_tot_outst_amt")));
			strOperatingFacilityId=checkForNull(rs1.getString("operating_facility_id")); //V210129
			System.err.println("strOperatingFacilityId:"+strOperatingFacilityId);
			mpi_id=checkForNull(rs1.getString("MPI_ID")); //V221107 
			System.err.println("mpi_id BLreprintprocess:"+mpi_id);
			setlmt_ind=checkForNull(rs1.getString("setlmt_ind"));//V221107
			System.err.println("setlmt_ind:"+setlmt_ind);
			insBillAmt=checkForNull(rs1.getString("bill_amt"));//V221107
			System.err.println("insBillAmt:"+insBillAmt);
			
			if(strBillTotAmt.equals(totOutAmt)) billPaidAmt=billingFormatConverter(con,"0");
			
			
				
			String getExcemptedAmountQry="select doc_amt from bl_bill_adj_dtl   where ADJ_DOC_TYPE_CODE =? and ADJ_DOC_NUM =?  and ADJUST_EXEMPT_IND = 'E'   AND (DOC_TYPE_CODE,DOC_NUM) in (select DOC_TYPE_CODE,DOC_NUM from bl_bill_adj_hdr where nvl(finalized_yn,'N') = 'N' AND nvl(STATUS,'N') <> 'C' and nvl(cancelled_yn,'N')='N' )"; 	
			
			excemptedAmt= BLHelper.getDescriptionViaSQL(con,getExcemptedAmountQry,strDocTypCode,strDocNum);
			excemptedAmt=billingFormatConverter(con,excemptedAmt);
			
			if(Double.parseDouble(excemptedAmt)>0){
			Double finalOutStandingAmt= Double.parseDouble(totOutAmt) - Double.parseDouble(excemptedAmt);
			totOutAmt=billingFormatConverter(con,finalOutStandingAmt.toString());
			
			}
			
			String multiSlmtBeanId = "BLMultiBillSettlementBean";
			String multiSlmtBeanName = "eBL.BLMultiBillSettlementBean";
			BLMultiBillSettlementBean multiSlmtBean=(BLMultiBillSettlementBean) getBeanObject(multiSlmtBeanId, multiSlmtBeanName, request);
			Double penaltyCharge=multiSlmtBean.getDrugPenaltyChargesSingleBill(con, p_facility_id, strDocTypCode, strDocNum);
			drugPenalty=billingFormatConverter(con,penaltyCharge.toString());
		

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strDocTypCode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strDocNum));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strDocDate));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBillTotAmt));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(billPaidAmt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(totOutAmt));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            _bw.write(_wl_block73Bytes, _wl_block73);
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strBillNatCode));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(strOperatingFacilityId));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mpi_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(setlmt_ind));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(insBillAmt));
            _bw.write(_wl_block86Bytes, _wl_block86);

					System.err.println("setlmt_ind :"+setlmt_ind);
					
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBillingGroupId));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(strepisodeTyp));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strepisodeId));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block106Bytes, _wl_block106);
 //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){ 
		if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){//removed demo_version against V210603
			
		
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(excemptedAmt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drugPenalty));
            _bw.write(_wl_block112Bytes, _wl_block112);
} 
            _bw.write(_wl_block113Bytes, _wl_block113);

					i++;
					total_records++; 
					
 				}//while
			}//If

            _bw.write(_wl_block114Bytes, _wl_block114);
				
		}
		catch(Exception eX)
		{		
			//out.println("Error= "+eX);
			eX.printStackTrace();			
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

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block116Bytes, _wl_block116);
			
	if(total_records>0){
		System.out.println("total_records/classval"+total_records+"/"+classval);
		out.println("<script>");
		out.println("highlightRow(1,'"+classval+"')");
		out.println("</script>");
	}			
 
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(p_episode_type ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(p_from_bill_number));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(p_from_bill_date ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(p_from_bill_number_code ));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(p_to_bill_number ));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(p_to_bill_date));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(p_to_bill_number_code ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(p_bill_type ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(p_outstd_only ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(p_cust_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(site_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(excemptedAmt));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(payer_group));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(payer_type));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(zerobill));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(site3TierAlmoFeatureYN ));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(eSignYN ));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf((String)session.getAttribute("login_user")));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block146Bytes, _wl_block146);
System.out.println("************************************set form is about to be called **********************************"+searched);
            _bw.write(_wl_block147Bytes, _wl_block147);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLReprintProcess.jsp",searched));
            _bw.write(_wl_block147Bytes, _wl_block147);
System.out.println("************************************set form is about to be called **********************************"+searched);
            _bw.write(_wl_block148Bytes, _wl_block148);
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillPaidAmt.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillOutStdAmt.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_CODE.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Exempted_Amount.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DrugPenalty.label", java.lang.String .class,"key"));
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
