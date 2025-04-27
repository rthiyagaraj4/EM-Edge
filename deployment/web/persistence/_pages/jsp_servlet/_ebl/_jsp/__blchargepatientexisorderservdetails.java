package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import eBL.placeorder.model.BLChargePatientServiceDetailsBean;
import eBL.placeorder.response.PlaceNewOrderResponse;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.bc.PlaceOrderBC;
import webbeans.op.CurrencyFormat;
import org.apache.commons.codec.binary.Base64;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blchargepatientexisorderservdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientExisOrderServDetails.jsp", 1742749940340L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BLChargePatient.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/json2.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\n$(document).ready(function(){\n\t\n\tif($(\'#traverse\').val() == \'Y\'){\n\t\t$(\'#trProgress\').show();\n\t}else{\n\t\t$(\'#trProgress\').hide();\n\t}\n\t\n\tif($(\'#hdnNextSpan\').val() == \'Y\'){\n\t\t$(\'#nextSpan\').show();\n\t}else{\n\t\t$(\'#nextSpan\').hide();\n\t}\n\t\n\tif($(\'#prevSpan\').val() == \'Y\'){\n\t\t$(\'#previousSpan\').show();\n\t}else{\n\t\t$(\'#previousSpan\').hide();\n\t}\n\t\n\t$(\'#nextSpan\').click(function(){\n\t\tvar lastIndex = $(\'#panel_categories_header_table tr:last\').attr(\'data-id\');\n\t\tvar totSelected = 0;\n\t\tfor(i=0;i<=lastIndex;i++){\n\t\t\tif($(\'#chk_blng_serv\'+i).prop(\"checked\")){\n\t\t\t\ttotSelected = parseInt(totSelected) + 1; \n\t\t\t}\n\t\t}\n\t\tif(totSelected > 0){\n\t\t\tvar con = confirm(\'Do you want to continue. Selections will be lost?\');\n\t\t\tif(!con){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\tvar endWith = parseInt($(\'#toRcrd\').val())+parseInt($(\'#constCount\').val());\n\t\tloadNextPrev(startFrom,endWith);\n\t});\n\t\n\t$(\'#previousSpan\').click(function(){\n\t\tvar lastIndex = $(\'#panel_categories_header_table tr:last\').attr(\'data-id\');\n\t\tvar totSelected = 0;\n\t\tfor(i=0;i<=lastIndex;i++){\n\t\t\tif($(\'#chk_blng_serv\'+i).prop(\"checked\")){\n\t\t\t\ttotSelected = parseInt(totSelected) + 1; \n\t\t\t}\n\t\t}\n\t\tif(totSelected > 0){\n\t\t\tvar con = confirm(\'Do you want to continue. Selections will be lost?\');\n\t\t\tif(!con){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\tvar startFrom = parseInt($(\'#fromRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\tvar endWith = parseInt($(\'#toRcrd\').val())-parseInt($(\'#constCount\').val());\n\t\tloadNextPrev(startFrom,endWith);\n\t});\n\t\n\t$(\'td[id^=serv_grp_desc]\').each(function(){\n\t\tvar grpDesc = $(this).text();\n\t\tif(grpDesc.length>100){\n\t\t\t$(this).text(grpDesc.substring(0,40) + \" (...) \");\n\t\t\t$(this).attr(\'title\',grpDesc);\n\t\t}\n\t});\n\t\n\t$(\'td[id^=serv_line_desc]\').each(function(){\n\t\tvar grpDesc = $(this).text();\n\t\tif(grpDesc.length>100){\n\t\t\t$(this).text(grpDesc.substring(0,40) + \" (...) \");\n\t\t\t$(this).attr(\'title\',grpDesc);\n\t\t}\n\t});\n\t\n\t$(\'[id^=adhoc_disc]\').each(function(){\n\t\t$(this).hide();\n\t});\n\t\n\tvar chargeLogicYn = \'\';\n\tvar noOfDecimals = \'\';\n\tif($(\'#hdnReSize\').val() == \'UP\' || $(\'#hdnReSize\').val() == \'UC\'){\n\t\tchargeLogicYn = $(parent.BillReceiptTab.document).find(\'#chargeLogicYN\').val();\n\t\tnoOfDecimals = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t}\n\telse{\n\t\tchargeLogicYn = $(parent.BLChargePatientEncounterTabPage.document).find(\'#chargeLogicYN\').val();\n\t\tnoOfDecimals = $(parent.BLChargePatientEncounterTab.document).find(\'#noOfDecimals\').val();\n\t}\n\t\n\t$(\'[id^=labelTrDoc_]\').each(function(){\n\t\tvar indx = $(this).attr(\'data-id\');\n\t\tif(chargeLogicYn == \'Y\'){\n\t\t\t$(this).text($(\'#primKeyMain\'+indx).val());\n\t\t}\n\t\telse{\n\t\t\t$(this).text($(\'#trxDocRef\'+indx).val());\n\t\t}\n\t})\n\t\n\t\n\tif($(\'#hdnType\').val() == \'D\'){\n\t\tvar pVal = $(\'#processed\').val();\n\t\tif(pVal == \'P\'){\n\t\t\t$(\'#spanCancel\').show();\n\t\t\t$(\'#spanProcess\').hide();\t\n\t\t\t$(\'#spanConfirm\').show();\n\t\t}\n\t\telse if(pVal == \'UP\'){\n\t\t\tif($(\'#hdnReSize\').val() == \'UP\'){\n\t\t\t\t$(\'#spanCancel\').hide();\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#spanCancel\').show();\n\t\t\t}\t\t\t\n\t\t\t$(\'#spanProcess\').show();\t\n\t\t\t$(\'#spanConfirm\').hide();\n\t\t}\n\t\telse if(pVal == \'UC\'){\n\t\t\t$(\'#spanCancel\').show();\n\t\t\t$(\'#spanProcess\').hide();\t\n\t\t\t$(\'#spanConfirm\').show();\n\t\t}\n\t}\n\t\n\t/*Newlu Added for Bill Generation*/\n\tif($(\'#hdnReSize\').val() == \'UC\'){\n\t\t$(\'#selAllChk\').hide();\n\t\t$(\'[id^=chk_blng_serv]\').each(function(){\n\t\t\t$(this).hide();\n\t\t});\n\t\t$(\'#selectAllSpan\').text(\'\');\n\t}\n\t//alert(\"noOfDecimals \"+noOfDecimals);\n\t$(\'[id^=gross_amt]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n\t$(\'[id^=disc_amt]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n\t$(\'[id^=adhoc_disc_amt]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n\t$(\'[id^=net_amt]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n\t\n\t$(\'[id^=txtRate]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n\t\n\t\n\t$(\'[id^=spTotalAmt]\').each(function(){\n\t\tif($.trim($(this).text() != \'\')){\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\t$(this).text(\'0\');\n\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t}\n\t});\n});\nasync function captureRemarks(indx){\n//alert(\"inside 1 247\");\n\tvar dialogHeight= \"30vh\" ;\n    var dialogWidth      = \"30vw\" ;\n    var dialogTop = \"200\" ;\n    var center = \"1\" ;                                                                                              \n    var status=\"no\";\n    var features  = \"overflow:auto; scrollbars:no; dialogHeight:\"+dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n    var arguments = \"\" ;    \n\tvar remarks = $(\'#remarks\'+indx).val();\n    var retVal = await window.showModalDialog(\"../../eBL/jsp/BLCaptureRemarks.jsp?remarks=\"+encodeURIComponent(remarks),arguments,features);   \n    if(retVal != undefined){\n    \t$(\'#remarks\'+indx).val(retVal);\n    }\n\n}\nfunction loadNextPrev(startFrom,endWith){\n\tdocument.location.href = \'BLChargePatientExisOrderServDetails.jsp?serviceCode=\'+$(\'#serviceCode\').val()+\t\n\t\'&serviceClass=\'+$(\'#serviceClass\').val()+\n\t\'&billingService=\'+$(\'#billingService\').val()+\n\t\'&item=\'+$(\'#item\').val()+\n\t\'&entServGroup=\'+$(\'#entServGroup\').val()+\n\t\'&entGrpLine=\'+$(\'#entGrpLine\').val()+\n\t\'&fromDate=\'+$(\'#fromDate\').val()+\n\t\'&toDate=\'+$(\'#toDate\').val()+\n\t\'&billedYN=\'+$(\'#billedYN\').val()+\n\t\'&direct_indirectchgs=\'+$(\'#direct_indirectchgs\').val()+\n\t\'&episodeType=\'+$(\'#episodeType\').val()+\n\t\'&patientId=\'+$(\'#patientId\').val()+\n\t\'&episodeId=\'+$(\'#episodeId\').val()+\n\t\'&visitId=\'+$(\'#visitId\').val()+\n\t\n\t\'&locale=\'+$(\'#locale\').val()+\n\t\'&groupLineService=\'+$(\'#hdnType\').val()+\n\t\'&processed=\'+$(\'#processed\').val()+\n\t\'&reSize=\'+$(\'#hdnReSize\').val()+\n\t\'&underChrgOnly=\'+$(\'#underChrgOnly\').val()+\n\t\'&fromRcrd=\'+startFrom+\n\t\'&toRcrd=\'+endWith;\n}\n\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n\t{\n\t\tif (headTop < 0)\n\t\t{\n\t\t\tsaveHeadPos();\n\t\t\t\n\t\t}\n\t\tif (headTop>0)\n\t\t{\n\t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\t\ttheTop = document.documentElement.scrollTop;\n\t\t\telse if (document.body)\n\t\t\t\ttheTop = document.body.scrollTop;\n\n\t\t\tif (theTop>headTop)\n\t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\t\telse\n\t\t\t\tFloatHead1.style.top = \'0px\';\n\t\t}\n\t}\n\n\tfunction saveHeadPos()\n\t{\n\t\tparTable = document.getElementById(\"divHeadSep\");\n\t\tif (parTable != null)\n\t\t{\n\t\t\theadTop = parTable.offsetTop + 3;\n\t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\t\tFloatHead1.style.position = \"relative\";\n\t\t}\n\t}\n\t\n\tfunction lockKey()\n\t  {\n\t\t \t \n\t\tif(event.keyCode == 93)\n\t\t\talert(\"Welcome to eHIS\");\n\t  }\n\n\t  function lockbackSpace()\n\t  {\n\t\t// alert(document.order_type_form.mode.value);\n\t\t   var mode = document.mode.value;\n      // alert(window.event.keyCode);\n\t\t if(mode==\'modify\' && window.event.keyCode==8)\n\t\t  {\n           //return false;\n\t\t  }\n\t  }\n\t \n\t\n\t\n</script>\n</head>\n<style>\n\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 160px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t\t\n\n\t\tTD.YELLOW \n\t\t{\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\tTD.greyedData\n\t\t{\n\t\t\tBACKGROUND-COLOR: #A3A3A3 ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tcolor : #FFFFFF;\n\t\t}\n\t\t</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onScroll=\"processScroll();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\" >\n\t<form id=\"bLChargePatientServicePriceDetails\" name=\"bLChargePatientServicePriceDetails\" id=\"bLChargePatientServicePriceDetails\">\t\n\n\n\t\n\t\t\n\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\n loadTraverseFrame(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\n\t\t\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\");\t\n</script>\n\n\t<table cellpadding=3 cellspacing=0  width=\'60%\' id=\"panel_categories_header_table\" name=\"panel_categories_header_table\" id=\"panel_categories_header_table\" border=\"1\"  >\t \n\t<div id=\"tableContainer\">\n\t\t<thead style=\"position: sticky;z-index: 1;top: 0;\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr style=\"background-color: white; border: none;\" id=\'trProgress\'>\n\t\t\t<td colspan=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t\t\t<td >\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer; cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'previousSpan\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\t\n\t\t\t\t\t\t<span class=\"LABEL\" style=\"font-weight: normal; color: blue; cursor: pointer; cursor:pointer \">\n\t\t\t\t\t\t\t<span id=\'nextSpan\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<TR >\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'5%\'\talign=\"left\"\t><span id=\'selectAllSpan\' namew=\'selectAllSpan\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t<input type=\'checkbox\' name=\'selAllChk\' id=\'selAllChk\'  onclick=\'fnSelectAll();\'></th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'11%\'\talign=\"left\"\t>Trx-Doc-Ref-No</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Line No</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'11%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'17%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>UOM</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'7%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\t\t\t\t\t\t\t\t\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Pract / Staff Ind</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Doctor</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Doctor Name</th>\n\t\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'20%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'36%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'11%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'11%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\t\t\t<th id=\'adhoc_disc_label\' class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'11%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Remarks</th>\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'8%\'\talign=\"left\"\t>Entered By</th>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<TR >\t\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'13%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th>\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'19%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</th>\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'13%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\t\t\t\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'9%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n\t\t\t<th class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'9%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</th>\n\t\t\t<th id=\'adhoc_disc_label\' class=\'columnheader\' nowrap=\"nowrap\"\twidth=\'9%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</thead>\n\n\t\n\t<TBODY>\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\n\t\t\t<tr id=\'resultTr_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' data-id=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<td class=\"fields\"  width=\'5%\' nowrap=\"nowrap\"  >\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'checkbox\' id=\"chk_blng_serv";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"chk_blng_serv";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" onclick=\"calculateTotal(";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =");\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td  class=\"fields\"  width=\'11%\' nowrap=\"nowrap\"  >\n\t\t\t\t\t\t\t<span id=\'labelTrDoc_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'trxDocRef";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'trxDocRef";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\tvalue=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t <td class=\"fields\" style=\"text-align: right;\" width=\'7%\' nowrap=\"nowrap\"  id=\"linenum";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"\t\t\tname=\"linenum";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<td class=\"fields\"  width=\'11%\' nowrap=\"nowrap\"  id=\"serv_grp_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"\t\tname=\"serv_grp_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"\t>\n\t\t\t\t\t \t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \t\t\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t<td class=\"gridDataBlue\"  width=\'11%\' nowrap=\"nowrap\"  id=\"serv_grp_code";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"\tclass=\'gridDataBlue\' style=\'cursor:pointer\' onclick=\"tooltip(this,";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =",\'service\');\"\tonmouseover=\"hideToolTip();\"\tname=\"serv_grp_code";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" \t\t\n\t\t\t\t\t \t\t\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' id=\'imgArrow";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'trxDocRefLineNum";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'trxDocRefLineNum";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'trxDocRefSeqNum";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'trxDocRefSeqNum";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'primKeyLineNo";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'primKeyLineNo";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'primKeyMain";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'primKeyMain";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'primKeyModId";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'primKeyModId";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'confirmedYn";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'confirmedYn";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'servedPanelQty";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'servedPanelQty";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'servQty";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'servQty";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'physicianId";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'physicianId";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'physicianName";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'physicianName";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'uomCode";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'uomCode";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'practStaffInd";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' id=\'practStaffInd";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'inclExclInd";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'inclExclInd";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'reason";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' id=\'reason";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'remarks";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'remarks";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'dailyProcessInd";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'dailyProcessInd";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'bedType";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'bedType";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'tokenSeriesCode";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' id=\'tokenSeriesCode";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'tokenSeriesNo";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' id=\'tokenSeriesNo";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'dispLocn";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' id=\'dispLocn";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'secKeyMain";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' id=\'secKeyMain";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'secKeyLineNo";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'secKeyLineNo";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'> \t\t\t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'servOrPanel";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'servOrPanel";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'baseRate";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' id=\'baseRate";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'rateIndicator";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'rateIndicator";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t\t\t\t \t<input type=\'hidden\' name=\'itemCode";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' id=\'itemCode";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'module_id";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'module_id";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'errorCode";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' id=\'errorCode";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\t\t\t\t\t \t\n\t\t\t\t\t \t<input type=\'hidden\' name=\'warningMess";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' id=\'warningMess";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\t\t\t </td>\t\n\t\t\t\t\t <td class=\"fields\"  width=\'17%\' nowrap=\"nowrap\"  id=\"serv_grp_desc";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"\t\t\tname=\"serv_grp_desc";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="&nbsp;</td>\n\t\t\t\t\t <td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\"  id=\"chargeDateTime";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"\t\t\tname=\"chargeDateTime";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\t\t\t&nbsp;</td>\n\t\t\t\t\t <td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t <td class=\"fields\"  width=\'5%\' nowrap=\"nowrap\"  name=\'panelCode";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\'panelCode";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'> ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="&nbsp;</td>\n\t\t\t\t\t <td class=\"fields\"  width=\'5%\' nowrap=\"nowrap\"  name=\'panelDesc";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' id=\'panelDesc";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="&nbsp;</td>\n\n\t\t\t\t\t<td class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t <td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t \t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t </td>\n\t\t\t\t\t\n\t\t\t\t\t <td class=\"fields\"  style=\'text-align:right\' width=\'8%\' nowrap=\"nowrap\"  id=\"txtRate";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"\tname=\"txtRate";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="&nbsp;</td>\n\t\t\t\t\t <td class=\"fields\"  width=\'7%\' nowrap=\"nowrap\"  id=\"txtQty";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"\t\t\tname=\"ss\">\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="&nbsp;</td>\n\t\t\t\t\t  <td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t  \t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t\t </td>\n\t\t\t\t\t  <td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t  \t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t </td>\n\t\t\t\t\t   <td class=\"fields\"  width=\'8%\'  nowrap=\"nowrap\">\n\t\t\t\t\t  \t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t </td>\n\t\t\t\t\t \n\t\t\t\t\t\n\t\t\t\t\t \n\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"gridDataBlue\"  width=\'20%\' nowrap=\"nowrap\"  id=\"serv_grp_code";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =",\'entGroup\');\"\tonmouseover=\"hideToolTip();\"\tname=\"serv_grp_code";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\t\t \t\t\t\n\t\t\t\t\t </td>\t\n\t\t\t\t\t <td class=\"fields\"  width=\'36%\' nowrap=\"nowrap\"  id=\"serv_grp_desc";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\t\t\t \n\t\t\t\t\t \n\t\t\t\t\t<td class=\"fields\" \tstyle=\'text-align:right\' width=\'11%\' nowrap=\"nowrap\" id=\"gross_amt";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"\t\t\tname=\"gross_amt";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'11%\' nowrap=\"nowrap\" id=\"disc_amt";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"\t\t\tname=\"disc_amt";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'11%\' nowrap=\"nowrap\" id=\"adhoc_disc_amt";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"\t\t\tname=\"adhoc_disc_amt";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'11%\' nowrap=\"nowrap\" id=\"net_amt";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"\t\t\tname=\"net_amt";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="&nbsp; </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t  \t<span style=\"color: blue;\" onclick=\"javascript:showRemarks(\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\')\">Remarks</span>\n\t\t\t\t\t </td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t<td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t  \t<span style=\"color: blue;\" onclick=\"javascript:captureRemarks(\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t \n\t\t\t\t\t <td class=\"fields\"  width=\'8%\' nowrap=\"nowrap\">\n\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t </td>\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t<td class=\"gridDataBlue\"  width=\'13%\' nowrap=\"nowrap\"  id=\"serv_grp_code";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =",\'entLine\');\"\tonmouseover=\"hideToolTip();\"\tname=\"serv_grp_code";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\t\t \t\t\t\n\t\t\t\t\t </td>\t\t\t\t \n\t\t\t\t\t<td class=\"fields\"  width=\'19%\' nowrap=\"nowrap\"  id=\"serv_grp_desc";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"fields\"  width=\'13%\' nowrap=\"nowrap\"  id=\"serv_line_code";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"\t\t\tname=\"serv_line_code";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"fields\"  width=\'29%\' nowrap=\"nowrap\"  id=\"serv_line_desc";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"\t\t\tname=\"serv_line_desc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="&nbsp;</td> \n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'9%\' nowrap=\"nowrap\" id=\"gross_amt";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'9%\' nowrap=\"nowrap\" id=\"disc_amt";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'9%\' nowrap=\"nowrap\" id=\"adhoc_disc_amt";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="&nbsp; </td>\n\t\t\t\t\t<td class=\"fields\"  style=\'text-align:right\' width=\'9%\' nowrap=\"nowrap\" id=\"net_amt";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\t\t\t152.00058&nbsp; </td>\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t \n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\n\t</table>\n\t\n\t\n\t\n\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' id=\'prevClicked\' value=\"\" />\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" >\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" >\n\t\n\t<!--  To Hide Progress Bar -->\n\t<script>\n\tfnHideProgress(\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\',\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\');\n\t</script>\n\t<!-- To Hide Progress Bar -->\t\n\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t<br/>\n\t\t<span id=\'spanCancel\'style=\"padding-right: 10px;\"><input type=\'button\' class=\'button\' id=\'cancelAll\' name=\'cancelAll\' id=\'cancelAll\' value=\'Cancel\' onclick=\'processBulk(\"cancelAll\");\'></span>\n\t\t<span id=\'spanProcess\'style=\"padding-right: 10px;\"><input type=\'button\' class=\'button\' id=\'processAll\' name=\'processAll\' id=\'processAll\' value=\'Process\' onclick=\'processBulk(\"processAll\");\'></span>\n\t\t<span id=\'spanConfirm\'style=\"padding-right: 10px;\"><input type=\'button\' class=\'button\' id=\'confirmAll\' name=\'confirmAll\' id=\'confirmAll\' value=\'Confirm\' onclick=\'processBulk(\"confirmAll\");\'></span>\n\t\t<span style=\"padding-right: 30px;padding-left: 10px;\">Total (NET)</span>\n\t\t<span id=\'spTotalAmt\'></span>\n\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t<!-- Hidden Fields for Next and Previous -->\n\t<input type=\'hidden\' name=\'hdnType\' id=\'hdnType\' id=\'hdnType\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n\t<input type=\'hidden\' name=\'processed\' id=\'processed\' id=\'processed\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t<input type=\'hidden\' name=\'hdnReSize\' id=\'hdnReSize\' id=\'hdnReSize\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'>\n\t<input type=\'hidden\' name=\'underChrgOnly\' id=\'underChrgOnly\' id=\'underChrgOnly\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n\t\n\t<input type=\'hidden\' name=\'serviceCode\' id=\'serviceCode\' id=\'serviceCode\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\n\t<input type=\'hidden\' name=\'serviceClass\' id=\'serviceClass\' id=\'serviceClass\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n\t<input type=\'hidden\' name=\'billingService\' id=\'billingService\' id=\'billingService\' value=\'";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t<input type=\'hidden\' name=\'item\' id=\'item\' id=\'item\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n\t<input type=\'hidden\' name=\'entServGroup\' id=\'entServGroup\' id=\'entServGroup\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n\t<input type=\'hidden\' name=\'entGrpLine\' id=\'entGrpLine\' id=\'entGrpLine\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' id=\'fromDate\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n\t<input type=\'hidden\' name=\'toDate\' id=\'toDate\' id=\'toDate\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t<input type=\'hidden\' name=\'billedYN\' id=\'billedYN\' id=\'billedYN\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\t<input type=\'hidden\' name=\'direct_indirectchgs\' id=\'direct_indirectchgs\' id=\'direct_indirectchgs\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n\t<input type=\'hidden\' name=\'episodeId\' id=\'episodeId\' id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n\t<input type=\'hidden\' name=\'visitId\' id=\'visitId\' id=\'visitId\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'>\n\t<!-- Hidden Fields for Next and Previous -->\n\t<input type=\'hidden\' name=\'hdnNextSpan\' id=\'hdnNextSpan\' id=\'hdnNextSpan\' value=\'";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'>\n\t<input type=\'hidden\' name=\'prevSpan\' id=\'prevSpan\' id=\'prevSpan\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\'>\n\t<input type=\'hidden\' name=\'traverse\' id=\'traverse\' id=\'traverse\' value=\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t<input type=\'hidden\' name=\'fromRcrd\' id=\'fromRcrd\' id=\'fromRcrd\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'>\n\t<input type=\'hidden\' name=\'toRcrd\' id=\'toRcrd\' id=\'toRcrd\' value=\'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t<input type=\'hidden\' name=\'constCount\' id=\'constCount\' id=\'constCount\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'>\n</form>\t\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t\n\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:8%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t<!-- </td> -->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\n</body>\n</TBODY>\t\n\t</div>\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n</html>\n\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );
	
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


	private String replaceNull(String input){
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

	
	private String checkForNull(String inputString)
	{
		if (inputString == null) return "";
		if(inputString.equals("null")) return "";
		
		return  inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

System.out.println("=======================came========================");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode																			=	new String();
//String locale																				=	"";

String loggedInUser																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
String service_ind																			=	"";
String price_code																			=	"";
String service_description																	=	"";
String price_ind																			=	"";
String price_description																	=	"";
String billing_class																		=	"";
String Effective_from																			=	"";
String Effective_to																			=	"";
String charge_type																			=	"";
String disc_applicability																	=	"";
String Desc																					=	"";
StringBuffer sql																			=	null;
ArrayList<String[]>		serviceDataList														=	null;
LinkedHashMap			recordServiceDetailsDataMap											=	null;
String disable																				=	"READONLY";

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

//Added By Rajesh V


String service_code																			=	"";
String service_class																			=	"";
String billing_service																			=	"";
String item																			=	"";
String ent_servGroup																			=	"";
String ent_GrpLine																			=	"";
String from_date																			=	"";
String to_date																			=	"";
String billedYN ="";
String direct_indirectchgs="";
String groupLineService="";
String episodeType="";
String patientId="";
String episodeId="";
String visitId="";
String locale="";
String reSize = "";
String processed= "";
String underChrgOnly="";
String loginUser = (String) session.getAttribute("login_user");

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

try  
{
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	System.out.println("searched >>>>>>>>>>>>>>>>>>" +searched);	
	
	sStyle 																				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																				= 	(String)session.getAttribute("LOCALE");
	service_code																		=	checkForNull(request.getParameter("serviceCode"));
	service_class																		=	checkForNull(request.getParameter("serviceClass"));
	billing_service																		=	checkForNull(request.getParameter("billingService"));
	item																				=	checkForNull(request.getParameter("item"));
	ent_servGroup																		=	checkForNull(request.getParameter("entServGroup"));
	ent_GrpLine																			=	checkForNull(request.getParameter("entGrpLine"));
	from_date																			=	checkForNull(request.getParameter("fromDate"));
	to_date																				=	checkForNull(request.getParameter("toDate"));
	billedYN																			=	checkForNull(request.getParameter("billedYN"));
	direct_indirectchgs																	=	checkForNull(request.getParameter("direct_indirectchgs"));
	groupLineService																	=	checkForNull(request.getParameter("groupLineService"));
	episodeType																			=	checkForNull(request.getParameter("episodeType"));
	//patientId																			=	checkForNull(request.getParameter("patientId"));
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes()));
	}else{
		patientId	= checkForNull(request.getParameter("patientId"));
	}
	//V230131 vulnerablity 
	System.out.println("485 patient,BLChargePatientExisOrderServDetails.jsp "+patientId);
	episodeId																			=	checkForNull(request.getParameter("episodeId"));
	visitId																				=	checkForNull(request.getParameter("visitId"));
	locale																				=	checkForNull(request.getParameter("locale"));
	reSize 																				=   checkForNull(request.getParameter("reSize"));
	processed 																			=   checkForNull(request.getParameter("processed"));
	underChrgOnly																		=   checkForNull(request.getParameter("underChrgOnly"));

	PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
	PlaceNewOrderResponse responseBean = null;
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	requestBean.setFacilityId(facilityId);
	requestBean.setServGroupCode(service_code);
	requestBean.setServClass(service_class);
	requestBean.setServCode(billing_service);
	requestBean.setItemCode(item);
	requestBean.setEntServGroup(ent_servGroup);
	requestBean.setEntGrpLine(ent_GrpLine);
	requestBean.setFromDate(from_date);
	requestBean.setToDate(to_date);
	requestBean.setBilled_unbilled(billedYN);
	requestBean.setDirect_indirectchgs(direct_indirectchgs);
	requestBean.setGroupLineService(groupLineService);
	requestBean.setEpisodeType(episodeType);
	requestBean.setPatientId(patientId);
	requestBean.setEpisodeId(episodeId);
	requestBean.setVisitId(visitId);
	requestBean.setLocale(locale);
	requestBean.setProcessed(processed);
	requestBean.setUnderChrgOnly(underChrgOnly);
	requestBean.setLoginUser(loginUser);
	
	
	System.out.println("locale/facilityId/service_code/service_class/billing_service/item/ent_servGroup/ent_GrpLine/from_date/to_date/billedYN/direct_indirectchgs/groupLineService/episodeType/patientId/visitId >>>>>>>>>"+locale+"/"+facilityId+"/"+service_code+"/"+service_class+"/"+billing_service+"/"+item+"/"+ent_servGroup+"/"+ent_GrpLine+"/"+from_date+"/"+to_date+"/"+billedYN+"/"+direct_indirectchgs+"/"+groupLineService+"/"+episodeType+"/"+patientId+"/"+visitId);

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

	requestBean.setStartFrom(startRcrd);
	requestBean.setEndWith(endRcrd);
	sql																						=	new StringBuffer();
	//System.out.println("<<<<<<serviceIndicator IN AdditionalServicePriceDetails.jsp::::>> "+service_ind);
	
	
	//recordServiceDetailsDataMap																=   new LinkedHashMap();
	bean_id																					= 	"BLChargePatientServiceDetailsBean" ;
	bean_name																				= 	"eBL.BLChargePatientServiceDetailsBean";
	BLChargePatientServiceDetailsBean bLChargePatientServiceDetailsBean						= 	null;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));

	responseBean																=	placeOrderBC.getServiceDetailsData(requestBean);		
	recordServiceDetailsDataMap = responseBean.getExistingServiceDetails();		
	totalRecord = responseBean.getTotalRecordCount();
	System.err.println("totalRecord->"+totalRecord);
	

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(!(startRcrd<=1)){
					prevYn = "Y";
					traversal = "Y";
				}
		
				if ( !( (startRcrd+constCount) > totalRecord ) ){
					nextYn = "Y";
					traversal = "Y";
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(service_code ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(service_class ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(billing_service ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(item ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ent_servGroup ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ent_GrpLine ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(from_date ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(to_date ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(billedYN ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(direct_indirectchgs ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(groupLineService ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(underChrgOnly));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block12Bytes, _wl_block12);
String colspan = "";
		if("G".equals(groupLineService)){
			colspan = "3";
		}
		else if("L".equals(groupLineService)){
			colspan = "5";
		}
		else{
			colspan = "18";
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if("G".equals(groupLineService) || "D".equals(groupLineService)){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
if("D".equals(groupLineService)){ 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
} else{ 
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
if("D".equals(groupLineService)){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if("L".equals(groupLineService)){ 
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
} 
            _bw.write(_wl_block41Bytes, _wl_block41);

	
		//System.out.println("<<<<<<<<<IN AdditionalServicePriceDetails.jsp recordPriceDetailsDataMap::::::::>>>>>>"+recordPriceDetailsDataMap);
		System.out.println("<<<<<<<<<IN BLChargePatientServicePriceDetails.jsp recordServiceDetailsDataMap:size:::::::>>>>>>"+recordServiceDetailsDataMap.size()); 

		Iterator iterator= recordServiceDetailsDataMap.keySet().iterator();

		String serviceIndKey = "";
		String serviceIndValue = "";
		String priceIndKey = "";
		String priceIndValue = "";
		String formattedDate = "";
		int sNo = 0;
		while(iterator.hasNext())
		{
			
			int index =    (Integer)iterator.next();
			sNo	  =		index+1;

			//System.out.println("<<<<<<<<<<<<IN getScreenServiceCriteria index>>>>>>>"+index);
			bLChargePatientServiceDetailsBean = (BLChargePatientServiceDetailsBean) recordServiceDetailsDataMap.get(index);
			if(!"UC".equals(reSize)){
				bLChargePatientServiceDetailsBean.setRemarks("");
			}

			if(bLChargePatientServiceDetailsBean.getChargeDateTime() !=null && !"".equals(bLChargePatientServiceDetailsBean.getChargeDateTime())){
				formattedDate = sdf.format(bLChargePatientServiceDetailsBean.getChargeDateTime());
			}
			else{
				formattedDate = "";
			}
	
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block44Bytes, _wl_block44);
if("G".equals(groupLineService)  || "D".equals(groupLineService)){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
if("D".equals(groupLineService)){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(index));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(index));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getTrxDocRef()) ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getTrxDocRef()) ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(index));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getSecKeyLineNo() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
if(("UC".equals(reSize)) || ("UP".equals(reSize))){ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBlngServCode()					!=null ? 	bLChargePatientServiceDetailsBean.getBlngServCode()		: 	"" ));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
						else{ 
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(index));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBlngServCode()					!=null ? 	bLChargePatientServiceDetailsBean.getBlngServCode()		: 	"" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
} 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getTrxDocRefLineNum() ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(index));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getTrxDocRefSeqNum() ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(index));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPrimKeyLineNum() ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(index));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPrimKeyMain() ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(index));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(replaceNull(bLChargePatientServiceDetailsBean.getPrimKeyModId()) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(index));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getConfirmedYn() ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServedpanelQty() ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(index));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServQty() ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(index));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPhysicianId() ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(index));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPhysicianName() ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(index));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getUomCode() ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(index));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPractStaffInd() ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(index));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getInclExclInd() ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(index));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getReason() ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(index));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getRemarks() ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(index));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getDailyProcessInd() ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(index));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBedTypeCode() ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(index));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getTokenSeriesCode() ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(index));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getTokenSeriesNo() ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(index));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getDispLocn() ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(index));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getSecKeyMain() ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(index));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getSecKeyLineNo() ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(index));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServOrPanel() ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(index));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBaseRate() ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(index));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getRateIndicator() ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(index));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getItemCode() ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(index));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getModuleId() ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(index));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(replaceNull(bLChargePatientServiceDetailsBean.getErrorCode()) ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(index));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(index));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(replaceNull(bLChargePatientServiceDetailsBean.getWarningMessage()) ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(index));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBlngServDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getBlngServDesc()		: 	"" ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(index));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(index));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(formattedDate ));
            _bw.write(_wl_block131Bytes, _wl_block131);
if("S".equals(bLChargePatientServiceDetailsBean.getServOrPanel())){ 
							out.print("Service");
						}
						else{
							out.print("Panel");
						}
						
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(index));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(index));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPanelCode()!=null ?bLChargePatientServiceDetailsBean.getPanelCode()		: 	"" ));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(index));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(index));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getPanelDesc()!=null ?bLChargePatientServiceDetailsBean.getPanelDesc()		: 	"" ));
            _bw.write(_wl_block137Bytes, _wl_block137);
if("R".equals(bLChargePatientServiceDetailsBean.getRateIndicator())){ 
							out.print("Rate");
						}
						else{
							out.print("Charge");
						}
						
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getUomCode()) ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(index));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getBaseRate()				!=null ? 	bLChargePatientServiceDetailsBean.getBaseRate()		: 	"" ));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(index));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServQty()!=null ? qtydecimal(""+bLChargePatientServiceDetailsBean.getServQty()	)	: 	"" ));
            _bw.write(_wl_block143Bytes, _wl_block143);
 if("P".equalsIgnoreCase(bLChargePatientServiceDetailsBean.getPractStaffInd())){ 
					  		out.print("Practitioner");
					  	}
					  	else if("O".equalsIgnoreCase(bLChargePatientServiceDetailsBean.getPractStaffInd())){
					  		out.print("Other Staff");
					  	}
					  	
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getPhysicianId()) ));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getPhysicianName()) ));
            _bw.write(_wl_block146Bytes, _wl_block146);
}else{ 
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(index));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServGrpCode()					!=null ? 	bLChargePatientServiceDetailsBean.getServGrpCode()		: 	"" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(index));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServGrpDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getServGrpDesc()		: 	"" ));
            _bw.write(_wl_block150Bytes, _wl_block150);
} 
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(index));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getGrossAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getGrossAmt()		: 	"" ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getDiscAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getDiscAmt()		: 	"" ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getAdhocDiscount()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getAdhocDiscount()		: 	"" ));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getNetAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getNetAmt()		: 	"" ));
            _bw.write(_wl_block159Bytes, _wl_block159);
if("D".equals(groupLineService )){ 
            _bw.write(_wl_block160Bytes, _wl_block160);
if("UC".equals(reSize)){ 
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(index));
            _bw.write(_wl_block162Bytes, _wl_block162);
}
					 	else{ 
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(index));
            _bw.write(_wl_block162Bytes, _wl_block162);
}
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(checkForNull(bLChargePatientServiceDetailsBean.getaddedBy()) ));
            _bw.write(_wl_block165Bytes, _wl_block165);
} 
            _bw.write(_wl_block166Bytes, _wl_block166);
} else if("L".equals(groupLineService)) { 
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(index));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(index ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(index));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServGrpCode()					!=null ? 	bLChargePatientServiceDetailsBean.getServGrpCode()		: 	"" ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(index));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getServGrpDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getServGrpDesc()		: 	"" ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(index));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getLineCode()				!=null ? 	bLChargePatientServiceDetailsBean.getLineCode()		: 	"" ));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(index));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getLineDesc()				!=null ? 	bLChargePatientServiceDetailsBean.getLineDesc()		: 	"" ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(index));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getGrossAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getGrossAmt()		: 	"" ));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(index));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getDiscAmt()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getDiscAmt()		: 	"" ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(index));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(index));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(bLChargePatientServiceDetailsBean.getAdhocDiscount()	 			!=null 	? 	bLChargePatientServiceDetailsBean.getAdhocDiscount()		: 	"" ));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(index));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(index));
            _bw.write(_wl_block178Bytes, _wl_block178);
} 
            _bw.write(_wl_block179Bytes, _wl_block179);

			startIndex++;
		}	
		
		if(sNo==0){
            _bw.write(_wl_block180Bytes, _wl_block180);
}
	
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(groupLineService));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(reSize));
            _bw.write(_wl_block185Bytes, _wl_block185);
if("D".equals(groupLineService) && !"UC".equals(reSize)){ 
            _bw.write(_wl_block186Bytes, _wl_block186);
} 
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(groupLineService));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(processed));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(reSize ));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(underChrgOnly));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(service_class));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(billing_service));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(item));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ent_servGroup));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(ent_GrpLine));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(billedYN));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(direct_indirectchgs));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(nextYn ));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(prevYn ));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(traversal));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(startRcrd ));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(endRcrd ));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(constCount ));
            _bw.write(_wl_block212Bytes, _wl_block212);

	}
	catch(Exception e)
	{
		System.out.println("<<<<<<<Exception in BLChargePatientExisOrderServDetails.jsp::"+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block213Bytes, _wl_block213);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceHeading.label", java.lang.String .class,"key"));
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
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLING_SERVICE_PANEL.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PANEL_CODE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PanelDescription.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BL_RATE_CHARGE_TYPE.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE.label", java.lang.String .class,"key"));
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
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.QTY.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EntGrpCode.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceAmount.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DISC_AMT.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AdhocDisc.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_CHARGE.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EntGrpCode.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EntLineCode.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Description.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceAmount.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_DISC_AMT.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AdhocDisc.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NET_CHARGE.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
