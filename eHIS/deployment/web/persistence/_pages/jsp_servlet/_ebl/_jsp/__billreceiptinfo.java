package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Properties;
import eBL.billreceipt.model.BillReceiptInfoDetails;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.placeorder.model.BLChargePatientServiceDetailsBean;
import eBL.placeorder.response.PlaceNewOrderResponse;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.billreceipt.model.BillReceiptSummaryBean;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.placeorder.bc.PlaceOrderBC;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;
import org.apache.commons.codec.binary.Base64;
import eCA.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __billreceiptinfo extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptInfo.jsp", 1743572586454L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V210129            13523         MOHE-CRF-0060       \t\t  Shikha Seth\n2\t     V210824 \t\t\t22431\t\t  MOHE-SCF-0136\t\t\t\t  Nandhini M\n3\t     V221023\t\t\t\t\tTH-KW-CRF-0020.7\t\tMohanapriya\n4\t\t\t\t\t\tTH-KW-CRF-0143                    Kamatchi S\n5\t\t\t\tV221129\t\t\t\t37915\t\t\tTH-KW-CRF-0084.1\t\t\tMohanapriya\n6\t\t\t\tV221230\t\t\t\t\t\t\tNMC-JD-CRF-0191.1 \t\t\tMohanapriya\n--------------------------------------------------------------------------------------------------------\n-->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<!--meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"-->\n<title>Bill Receipt Info</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\"\thref=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script language=\"javascript\" src=\'../../eBL/js/PkgUtilization.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<script>\nfunction reclacSlmtDeposit(){\n\tvar depChkYn;\n\tvar prePayChkYn;\n\tvar pDoc = parent.BillReceiptExisOrderSummary.document;\n\tif($(\'#depAdjChk\').prop(\'checked\')){\n\t\tdepAdjChk = \'Y\';\n\t}\n\telse{\n\t\tdepAdjChk = \'N\';\n\t}\n\t\n\tif($(\'#prePayChk\').prop(\'checked\')){\n\t\tprePayChk = \'Y\';\n\t}\n\telse{\n\t\tprePayChk = \'N\';\n\t}\n\tvar params = \'calledFrom=recalcDepositSlmt\'+\n\t\t\t\t\'&patientId=\'+$(\'#patient_id\').val()+\n\t\t\t\t\'&episodeType=\'+$(\'#episode_type\').val()+\n\t\t\t\t\'&episodeId=\'+$(\'#episode_id\').val()+\n\t\t\t\t\'&visitId=\'+$(\'#visit_id\').val()+\n\t\t\t\t\'&depChkYn=\'+depAdjChk+\n\t\t\t\t\'&prePayChkYn=\'+prePayChk+\n\t\t\t\t\'&approxPatAmt=\'+$.trim($(pDoc).find(\'#approxPatAmt\').text())+\n\t\t\t\t\'&slmtAmt=\'+$(pDoc).find(\'#slmtAmt\').val()+\n\t\t\t\t\'&deposits=\'+$.trim($(pDoc).find(\'#deposits\').text())+\n\t\t\t\t\'&patAmt=\'+$.trim($(pDoc).find(\'#patAmt\').text())+\n\t\t\t\t\'&depAdjustedYn=\'+$.trim($(pDoc).find(\'#depAdjustedYn\').val())+\n\t\t\t\t\'&preAdjustedYn=\'+$.trim($(pDoc).find(\'#preAdjustedYn\').val())+\n\t\t\t\t\'&refDepAdj=\'+$.trim($(\'#patDepAdj\').text())+\n\t\t\t\t\'&refDepBal=\'+$.trim($(\'#patDepBal\').text())+\n\t\t\t\t\'&refprePayAdj=\'+$.trim($(\'#patPrepayAdj\').text())+\n\t\t\t\t\'&refprePaybal=\'+$.trim($(\'#patPrepayBal\').text())+\n\t\t\t\t\'&prevDepAdjAmt=\'+$(pDoc).find(\'#prevDepAdjAmt\').val()+\n\t\t\t\t\'&prevPreAdjAmt=\'+$(pDoc).find(\'#prevPreAdjAmt\').val();\t\t\t\t\n\t\t\t\t\n\t$.ajax({\n\t\ttype:\"GET\",\n\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\tdata:params,\n\t\tdataType:\"json\",\n\t\tasync:false,\n\t\tsuccess: function(data){\n\t\t\tvar noOfDecimal = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\t\t$(pDoc).find(\'#approxPatAmt\').text($.trim(data.approxPatAmt));\n\t\t\t$(pDoc).find(\'#slmtAmt\').val($.trim(data.slmtAmt));\n\t\t\t$(pDoc).find(\'#docAmt\').val($.trim(data.slmtAmt));\n\t\t\t$(pDoc).find(\'#docAmt1\').val($.trim(data.slmtAmt));\n\t\t\t$(pDoc).find(\'#deposits\').text($.trim(data.deposits));\n\t\t\t$(pDoc).find(\'#depAdjustedYn\').val($.trim(data.depAjustedYn));\n\t\t\t$(pDoc).find(\'#preAdjustedYn\').val($.trim(data.preAjustedYn));\n\t\t\t$(pDoc).find(\'#prevDepAdjAmt\').val($.trim(data.prevDepAdjAmt));\n\t\t\t$(pDoc).find(\'#prevPreAdjAmt\').val($.trim(data.prevPreAdjAmt));\n\t\t\t\n\t\t\tvar refDepAdj=$.trim(data.refDepAdj);\n\t\t\tvar refDepBal=$.trim(data.refDepBal);\n\t\t\tvar refprePayAdj=$.trim(data.refprePayAdj);\n\t\t\tvar refprePaybal=$.trim(data.refprePaybal);\n\t\t\t$(\'#patDepAdj\').text(refDepAdj);\n\t\t\t$(\'#patDepBal\').text(refDepBal);\n\t\t\t$(\'#patPrepayAdj\').text(refprePayAdj);\n\t\t\t$(\'#patPrepayBal\').text(refprePaybal);\t\t\t\n\n\t\t\tif($(\'#patDepAdj\').text() != \'\'){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(\'#patDepAdj\'),17,noOfDecimal);\t\n\t\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patDepAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patDepAdj\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(\'#patDepBal\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(\'#patDepBal\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patDepBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patDepBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(\'#patPrepayAdj\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(\'#patPrepayAdj\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patPrepayAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patPrepayAdj\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(\'#patPrepayBal\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(\'#patPrepayBal\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patPrepayBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patPrepayBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(pDoc).find(\'#approxPatAmt\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(pDoc).find(\'#approxPatAmt\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(pDoc).find(\'#approxPatAmt\').text(\'0\');\n\t\t\t\tputDecimal_Text($(pDoc).find(\'#approxPatAmt\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(pDoc).find(\'#slmtAmt\').val() != \'\'){\n\t\t\t\tputDecimal($(pDoc).find(\'#slmtAmt\').get(0),17,noOfDecimal);\n\t\t\t\tputDecimal($(pDoc).find(\'#docAmt\').get(0),17,noOfDecimal);\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(pDoc).find(\'#slmtAmt\').val(\'0\');\n\t\t\t\tputDecimal($(pDoc).find(\'#slmtAmt\').get(0),17,noOfDecimal);\n\t\t\t\t$(pDoc).find(\'#docAmt\').val(\'0\');\n\t\t\t\tputDecimal($(pDoc).find(\'#docAmt\').get(0),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(pDoc).find(\'#deposits\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(pDoc).find(\'#deposits\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(pDoc).find(\'#deposits\').text(\'0\');\n\t\t\t\tputDecimal_Text($(pDoc).find(\'#deposits\'),17,noOfDecimal);\n\t\t\t}\n\t\t},\n\t\t error: function(data){\n\t\t\t alert(data)\n\t      }\n\t});\n}\n\t$(document).ready(function(){\n\t\t$(\'#trProgress\').hide();\n\t\tvar noOfDecimal = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\tvar billCashBlngServSeparately=$(parent.BillReceiptTab.document).find(\'#billCashBlngServSeparately\').val();\n\t\tif(billCashBlngServSeparately == \'N\'){\n\t\t$(\'#billGenOpt\').attr(\'disabled\',\'disabled\');\n\t\t}else{\n\t\t\t$(\'#billGenOpt\').removeAttr(\'disabled\');\n\t\t}\n\t\t\n\t\t$(\'#billGenType\').attr(\'disabled\',\'disabled\');\n\t\t$(\'#pkgDtls\').click(   function(){\n\t\t\t //alert(\"inside 228\");\n\t\t\tvar dialogHeight= \"95vh\" ;\n\t\t\tvar dialogWidth\t= \"95vw\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\t\n\t\t\tvar params = \"../jsp/BillReceiptpkgUtilization.jsp?patient_id=\"+$(\'#patient_id\').val()+\n\t\t\t\t\t\t\"&noOfDecimal=\"+noOfDecimal+\n\t\t\t\t\t\t\"&episodeType=\"+$(\'#episode_type\').val()+\n\t\t\t\t\t\t\"&visitId=\"+$(\'#visit_id\').val()+\n\t\t\t\t\t\t\"&episodeId=\"+$(\'#episode_id\').val();\n\t\t\t\t\t\t\n\t\t\tvar retVal =  window.showModalDialog(params,null,features);\t\n\t\t});\t\t\n\t\t\n\t\tvar tabDoc = parent.BillReceiptTab.document;\t\t\n\t\t$(tabDoc).find(\'#interfaceYn\').val($(\'#interfaceYn\').val());\n\t\t$(tabDoc).find(\'#futureOrderYn\').val($(\'#futureOrderYn\').val());\n\t\t\n\t\tvar default_disc_bill_ind = $(parent.BillReceiptTab.document).find(\'#default_disc_bill_ind\').val();\t\t\t\t\n\t\t\n\t\tif($(\'#episode_type\').val() == \'I\' && $(\'#displayLastBedDate\').val() == \'Y\'){\n\t\t\t\t$(\'#trLastBedChargeDt\').show();\n\t\t\t\t$(\'#trComputeUptoDt\').show();\n\t\t}\n\t\telse{\n\t\t\t$(\'#trLastBedChargeDt\').hide();\n\t\t\t$(\'#trComputeUptoDt\').hide();\n\t\t}\n\t\t//Added by Nandhini against V210824 \n\t\tif($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\'){\n\t\t\tif($(\'#expDischOrDischLabel\').val() == \'Y\'){\n\t\t\t\t//$(\'#expDisDate\').text(\'Exp Discharge Date\');\n\t\t\t\tvar ExpectedDischargeDate = getLabel(\"eBL.ExpectedDischargeDate.label\",\"bl_labels\");\n\t\t\t\t$(\'#expDisDate\').text(ExpectedDischargeDate);\n\t\t\t}\n\t\t\telse{\n\t\t\t\tvar Discharge = getLabel(\"eBL.Discharge.label\",\"bl_labels\");\n\t\t\t\t//$(\'#expDisDate\').text(\'Discharge Date\');\n\t\t\t\t$(\'#expDisDate\').text(Discharge);\n\t\t\t}\n\t\t\t\n\t\t\tvar Admission = getLabel(\"eBL.Admission.label\",\"bl_labels\");\n\t\t\t//$(\'#admVisitDate\').text(\'Admission Date/Time\');\n\t\t\t$(\'#admVisitDate\').text(Admission);\n\t\t}\n\t\telse{\n\t\t\t//$(\'#expDisDate\').text(\'Checkout Date/Time\');\n\t\t\tvar checkOut = getLabel(\"eBL.checkOut.label\",\"bl_labels\");\n\t\t\t//alert(\"one\");\n\t\t\t$(\'#expDisDate\').text(checkOut);\n\t\t\tvar Visit = getLabel(\"eBL.Visit.label\",\"bl_labels\");\n\t\t\t//$(\'#admVisitDate\').text(\'Visit Date/Time\');\n\t\t\t$(\'#admVisitDate\').text(Visit);\n\t\t}\n\t\t//Added by Nandhini against V210824 ends\n\t\t\n\t\tif($(tabDoc).find(\'#depChk\').val() == \'Y\'){\n\t\t\t$(\'#depAdjChk\').attr(\'checked\',\'checked\');\n\t\t}\n\t\t\n\t\tif($(tabDoc).find(\'#prePayChk\').val() == \'Y\'){\n\t\t\t$(\'#prePayChk\').attr(\'checked\',\'checked\');\n\t\t}\n\t\t\t\t\t\n\t\tif($(\'#futureOrderYn\').val() == \'Y\'){\n\t\t\talert(getMessage(\'BL9859\',\'BL\'));\n\t\t}\n\n\t\tif($(\'#futureOrderYn\').val() == \'N\'){\n\t\t\tparent.BillReceiptTab.document.getElementById(\'futureOrder\').disabled = true;\n\t\t}\n\n\t\tif($(\'#interfaceYn\').val() == \'Y\'){\n\t\t\t/*Added by Gayathri- For MMS- For IP and DC ,interface button should be disabled*/\n\t\t\t\tif( ($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\')){\n\t\t\t\t\tdocument.getElementById(\"interfaceBtn\").disabled = true;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\talert(getMessage(\'BL5202\',\'BL\'));\n\t\t\t\t\tdocument.getElementById(\"interfaceBtn\").disabled = false;\n\t\t\t\t}\n\t\t}\n\n\t\tif($(\'#interfaceYn\').val() == \'N\' || ($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\')){\n\t\t\tparent.BillReceiptTab.document.getElementById(\'interface\').disabled = true;\n\t\t}\n\t\t\n\t\tif($(\'#interfaceYn\').val() == \'N\' || ($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\')){\n\t\t\tdocument.getElementById(\"interfaceBtn\").disabled = true;\n\t\t}\n\n\t\t\n\t\t\n\t\t$(\'#clearBtn\').click(function(){\n\t\t\t//parent.window.close();\n\t\t\tparent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t\t\t\n\t\t\n\t\t});\n\t\t\n\t\t$(\'span\').each(function(){\n\t\t\tif($(this).attr(\'roundToVal\') == \'Y\'){\n\t\t\t\t\n\t\t\t\tif($.trim($(this).text()) != \'\'){\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(this).text(\'0\');\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\t\n\t\tvar unBilled = $.trim($(\'#unBillAmt\').text());\n\t\tvar outStCash = $.trim($(\'#outstCash\').text());\n\t\tvar outStCredit = $.trim($(\'#outstCredit\').text());\n\t\tvar totOutSt = parseFloat(outStCash)+parseFloat(outStCredit);\n\t\t$(tabDoc).find(\'#unBilled\').val(unBilled);\n\t\t$(tabDoc).find(\'#totOutSt\').val(totOutSt);\n\t\t\n\t\tif(outStCash > 0){\n\t\t\t$(\'#outstCash\').css(\'background\',\'red\');\n\t\t\t$(\'#outstCash\').css(\'color\',\'white\');\n\t\t}\n\t\t\n\t\t$(\'#interfaceBtn\').click(function(){\n\t\t\t$(parent.BillReceiptTab.document).find(\'#interface\').click();\n\t\t\t$(parent.BillReceiptTab.document).find(\'#interface\').addClass(\'CASECONDSELECTHORZ\');\n\t\t\t/*var patient_id=$(\'#patient_id\').val();\n\t\t\tvar episode_id=$(\'#episode_id\').val();\n\t\t\tvar visit_id=$(\'#visit_id\').val();\n\t\t\tvar episode_type=$(\'#episode_type\').val();\n\t\t\tvar patient_name=$(\'#patient_name\').val();\n\t\t\t//alert(\"patient_name\"+patient_name);\n\t\t\t//alert(\'epi type \'+episode_type);\n\t\t\t// alert(\'patient_id\'+patient_id+\'episode id \'+episode_id+\'visit id  \'+visit_id);\n\n\t\t\t\t\n\t\t\tvar url=\"../../eBL/jsp/BLBillGenInterfaceMainFrame.jsp?patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&episode_type=\"+episode_type+\"&patient_name=\"+patient_name;\n\t\t\t//alert(\'url \'+url);\n\t\t\t\n\t\t\tvar dialogHeight= \"50\" ;\n\t\t\tvar dialogWidth\t= \"84\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\t\t\t\tvar retVal =window.showModalDialog(url,n";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="ull,features);  */\n\t\t});\n\n\t\t$(\'#depAdjChk\').change(function(){\n\t\t\t/*if($(this).prop(\'checked\')){\n\t\t\t\t$(\'#patDepAdj\').text($.trim($(\'#availPatDep\').text()));\n\t\t\t\t$(\'#patDepBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patDepBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patDepBal\').text($.trim($(\'#availPatDep\').text()));\n\t\t\t\t$(\'#patDepAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patDepAdj\'),17,noOfDecimal);\n\t\t\t}*/\n\t\t\t\n\t\t\t//$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t\treclacSlmtDeposit();\n\t\t});\n\t\t\n\t\t$(\'#prePayChk\').change(function(){\n\t\t\t/*if($(this).prop(\'checked\')){\n\t\t\t\t$(\'#patPrepayAdj\').text($.trim($(\'#availPatPrepay\').text()));\n\t\t\t\t$(\'#patPrepayBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patPrepayBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#patPrepayBal\').text($.trim($(\'#availPatPrepay\').text()));\n\t\t\t\t$(\'#patPrepayAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(\'#patPrepayAdj\'),17,noOfDecimal);\n\t\t\t}*/\n\t\t\t\n\t\t\t//$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t\treclacSlmtDeposit();\n\t\t});\n\t\t\n\t\t$(\'#inPatBillType\').change(function(){\t\t\t\n\t\t\tvar dt1 = $.trim($(\'#lastBedChargeDt\').text());\n\t\t\tvar dt2 = $.trim($(\'#computeUptoDt\').text());\n\t\t\tvar diffInSec = 0;\n\t\t\tif(dt1 != \'\' && dt2 != \'\'){\n\t\t\t\tvar dtObj1 = returnDateObj(dt1);\n\t\t\t\tvar dtObj2 = returnDateObj(dt2);\t\t\t\t\n\t\t\t\tdiffInSec = (dtObj2.getTime() - dtObj1.getTime())/1000;\n\t\t\t}\n\t\t\t\t\t\t\n\t\t\tif($(this).val() == \'I\' \n\t\t\t\t\t&& $(\'#episode_type\').val() == \'I\' \n\t\t\t\t\t&& $.trim($(\'#lastBedChargeDt\').text()) != \'\'\n\t\t\t\t\t&& diffInSec >= 86400){\n\t\t\t\t$(\'#trLastBedChargeDt\').show();\n\t\t\t\t$(\'#trComputeUptoDt\').show();\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#trLastBedChargeDt\').hide();\n\t\t\t\t$(\'#trComputeUptoDt\').hide();\n\t\t\t}\n\t\t\t\n\t\t\tif($(this).val() == \'D\'){\n\t\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#reset\').click();\n\t\t\t\tdisableExistingOrder();\n\t\t\t}\n\t\t\telse{\n\t\t\t\tenableExistingOrder();\n\t\t\t}\n\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t});\n\t\t\n\t\t$(\'#draftBtn\').click(function(){\n\t\t\tvar detailYnVal = \'\';\n\t\t\tif($(\'#detailChk\').prop(\'checked\')){\n\t\t\t\tdetailYnVal = \'Y\';\n\t\t\t}\n\t\t\telse{\n\t\t\t\tdetailYnVal = \'N\';\n\t\t\t}\n\t\t\t\n\t\t\tvar params = \"func_mode=interimChargeValidation\"+\n\t\t\t\t\t\t\"&patientId=\"+$(\'#patient_id\').val()+\n\t\t\t\t\t\t\"&episodeType=\"+$(\'#episode_type\').val()+\n\t\t\t\t\t\t\"&episodeId=\"+$(\'#episode_id\').val()+\n\t\t\t\t\t\t\"&detailRepYn=\"+detailYnVal;\n\t\t\t\t\t\t\n\t\t\t$.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BLCommonReportValidation.jsp\",\n\t\t\t\tdata:params,\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tvar retValArr = $.trim(data).split(\"::##\");\n\t\t\t\t\tif(retValArr.length == 4){\t//Array Length 4-> No Errors Else, Procedure Has throws some Exception\n\t\t\t\t\t\t\n\t\t\t\t\tvar htmlVal = \"<html><body>\";\n\t\t\t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+$(\'#facilityId\').val()+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+$(\'#locale\').val()+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+retValArr[2]+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+retValArr[2]+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+retValArr[1]+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+retValArr[3]+\"\'>\";\n\t\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\t\n\t\t\t\t\t\n\t\t\t\t\thtmlVal += \"</form></body></html>\";\n\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t\t\t\tparent.messageFrame.document.dummy_frm.submit();\t\t\n\t\t\t\t\t//interim_main_report.frames[0].document.forms[0].submit();\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(data)\n\t\t\t      }\n\t\t\t});\n\t\t});\t\t\n\t\t\n\t\tvar infoDoc = parent.BillReceiptInfo.document;\t\t\n\t\tif($(infoDoc).find(\'#depAdjChkYn\').val() == \'Y\'){\t\t\n\t\t\t$(\'#depAdjChk\').prop(\'checked\',true);\n\t\t}else{\t\t\n\t\t\t$(\'#depAdjChk\').prop(\'checked\',false);\n\t\t}\n\t\tif($(infoDoc).find(\'#preAdjChkYn\').val() == \'Y\'){\t\t\n\t\t\t$(\'#prePayChk\').attr(\'checked\',true);\n\t\t}else{\n\t\t\t$(\'#prePayChk\').attr(\'checked\',false);\n\t\t}\n\t\t$(\'#billGenOpt\').change(function(){\n\t\t\tif($(this).val() != \'C\'){\n\t\t\t\t$(\'#billGenType\').val(\'\');\n\t\t\t\t$(\'#billGenType\').attr(\'disabled\',\'disabled\');\n\t\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#billGenType\').val(\'\');\n\t\t\t\t$(\'#billGenType\').removeAttr(\'disabled\');\n\t\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t\t}\n\t\t});\n\n\t\t$(\'#billGenType\').change(function(){\n\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#add_mod\').click();\n\t\t});\n\t\t/*if($(tabDoc).find(\'#dflt_adj_dep_dur_bill_yn\').val() == \'Y\'){\n\t\talert(\"inside here also\");\n\t\t\t$(\'#depAdjChk\').attr(\'checked\',true);\n\t\t}else{\n\t\t\t$(\'#depAdjChk\').attr(\'checked\',false);\n\t\t}\n\t\tif(($(tabDoc).find(\'#dflt_adj_prepay_dur_bill_yn\').val() == \'Y\') || ($(tabDoc).find(\'#adj_pat_prepay_in_enc_pre_yn\').val() == \'Y\')) {\n\t\t\t$(\'#prePayChk\').attr(\'checked\',true);\n\t\t}else{\n\t\t\t$(\'#prePayChk\').attr(\'checked\',false);\n\t\t}\n\t\t*/\n\t\tif($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\'){\n\t\t\t$(\'#inPatBillType\').val($(\'#ipBillType\').val());\n\t\t}\n\t\telse{\n\t\t\t$(\'#inPatBillType\').val(\'\');\n\t\t\t$(\'#inPatBillType\').attr(\'disabled\',true);\n\t\t}\n\t\t/*if($(tabDoc).find(\'#default_disc_bill_ind\').val() == \'D\'){\n\t\t\t//alert(\"in if\"+default_disc_bill_ind);\n\t\t\t$(\'#inPatBillType\').val(\'D\');\n\t\t}else{\n\t\t\t//alert(\"in else\"+default_disc_bill_ind)\n\t\t\t$(\'#inPatBillType\').val(\'U\');\n\t\t}*/\t\t\n\t\tparent.BillReceiptExisOrderSearch.document.location.href = \'BillReceiptExistingOrderSearch.jsp?\'+\'";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9_0 ="\';\n\t});\n\t\n\tasync function generateBill(){\n\n\t\t\tvar exisOrderDoc = parent.BillReceiptExisOrderDetails.document;\n\t\t\tvar summDoc = parent.BillReceiptExisOrderSummary.document;\n\t\t\tvar tabDoc = parent.BillReceiptTab.document;\n\t\t\t//Added by Kamatchi S for for TH-KW-CRF-0143\n\t\t\tif($(\'#siteSpecServiceCode\').val() == true || $(\'#siteSpecServiceCode\').val() == \'true\')\n\t\t\t{\n\t\t\t\tif(($(\'#episode_type\').val() == \'D\' || $(\'#episode_type\').val() == \'I\') && $(\'#inPatBillType\').val() == \'D\' && ($(\'#coderClearanceStatus\').val() == \'N\' || $(\'#coderClearanceStatus\').val() == \"null\")){\n\t\t\t\talert(getMessage(\'BL0954\',\'BLEXT\'));\n\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t} \n\t\t\t\n\t\t\t//V221129 Starts\n\t\t\tvar enableInsClearance=document.getElementById(\"enableInsClearance\").value;\n\t\t\tif(enableInsClearance==\'Y\' && ( $(\'#episode_type\').val() == \'I\' ||  $(\'#episode_type\').val() == \'D\') ){ //O E R I D\n\t\t\t\tvar ind=\'\';\n\t\t\t\t$.ajax({\n\t\t\t\ttype:\"POST\", \n\t\t\t\turl:\"../jsp/BLCommonAjax.jsp?functionMode=settlement_ind\",\n\t\t\t\tdata:\"patientId=\"+$(\'#patient_id\').val()+\n\t\t\t\t\t\t\"&episodeType=\"+$(\'#episode_type\').val()+\n\t\t\t\t\t\t\"&visitId=\"+$(\'#visit_id\').val()+\n\t\t\t\t\t\t\"&episodeId=\"+$(\'#episode_id\').val(),\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tind = $.trim(data);\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(error)\n\t\t\t\t  }\n\t\t\t\t});\n\t\t\t\t\n\t\t\t\tif(ind==\'X\'){\n\t\t\t\t\tif($(\'#inPatBillType\').val() == \'D\'){\n\t\t\t\t\t\tvar status=\'\';\n\t\t\t\t\t\t\n\t\t\t\t\t\t$.ajax({\n\t\t\t\t\t\ttype:\"POST\", \n\t\t\t\t\t\turl:\"../jsp/InsuranceClearanceAjax.jsp?functionMode=insuranceClearanceSts\",\n\t\t\t\t\t\tdata:\"patientId=\"+$(\'#patient_id\').val()+\n\t\t\t\t\t\t\t\t\"&episodeType=\"+$(\'#episode_type\').val()+\n\t\t\t\t\t\t\t\t\"&visitId=\"+$(\'#visit_id\').val()+\n\t\t\t\t\t\t\t\t\"&episodeId=\"+$(\'#episode_id\').val(),\n\t\t\t\t\t\tdataType:\"text\",\n\t\t\t\t\t\tasync:false,\n\t\t\t\t\t\tsuccess: function(data){\n\t\t\t\t\t\t\tstatus = $.trim(data);\n\t\t\t\t\t\t},\n\t\t\t\t\t\t error: function(data){\n\t\t\t\t\t\t\t alert(error)\n\t\t\t\t\t\t  }\n\t\t\t\t\t\t});\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(status==\"N\"){\n\t\t\t\t\t\t\talert(getMessage(\"BL0960\",\"BLEXT\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t//V221129 ends\n\t\t\t//V221023 Starts\n\t\t\tvar enableQueuePKID=document.getElementById(\'enableQueuePKID\').value;\n\t\t\tif(enableQueuePKID==\'Y\' && ( $(\'#episode_type\').val() == \'O\') ){ //O E R I D\n\t\t\t\t\n\t\t\t\tvar servLoc= parent.BillReceiptExisOrderSearch.BLChargePatientEncounterExistingOrder.document.getElementById(\"serviceLocation\").value;\n\t\t\t\tif(servLoc==\'\'){\n\t\t\t\t\talert(getMessage(\'BL0951\',\'BLEXT\'));\n\t\t\t\t\treturn false;\n\t\t\t\t}else if(document.getElementById(\'queue_id\').value==\'\'){\n\t\t\t\t\tvar msg=getMessage(\'BL0953\',\'BLEXT\');\n\t\t\t\t\n\t\t\t\t\tvar dialogHeight= \"6\" ;\n\t\t\t\t\tvar dialogWidth\t= \"20\" ;\n\t\t\t\t\tvar dialogTop = \"225\" ;\n\t\t\t\t\tvar center = \"1\" ;\t   \n\t\t\t\t\tvar status=\"no\";\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\tvar arguments\t= \"\" ;\t\n\t\t\t\t\n\t\t\t\t\tvar params = \"../jsp/AlertYesNo.jsp?message=\"+msg;\n\t\t\t\t\tvar retVal = await window.showModalDialog(params,null,features);  \n\t\t\t\t\tif(retVal == \"0\"){\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'queue_id\').focus();\t\t\t\t\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else{\n\t\t\t\t\t\t validatePKID(document.getElementById(\'queue_id\').value,\'D\');\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t//V221023 Ends\n\t\t\tvar total = $(exisOrderDoc).find(\'#totalGroup\').val();\n\t\t\tvar maxPayer=$(exisOrderDoc).find(\'#maxPayer\').val();\n\t\t\t\n\t\t\t/*\n\t\t\t* Stop Bill generation, if the Episode type is Inpatient or Day Care and the Bill Type\n\t\t\t* is not Chosen\n\t\t\t*/\n\t\t\tif($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\'){\n\t\t\t\tif($(\'#inPatBillType\').val() == \'\'){\n\t\t\t\t\talert(getMessage(\"BL00963\",\"BL\"));\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\t/*\n\t\t\t* If no services exists during bill generation screen stop bill generation\n\t\t\t*/\n\t\t\tif(parseInt(total)<1){\n\t\t\t\talert(getMessage(\'BL9110\',\'BL\'));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tvar infoDoc = parent.BillReceiptInfo.document;\n\t\t\t\n\t\t\t/*\n\t\t\t* While loading the Info Page, if any error found then during bill generation show the error\n\t\t\t* and stop the process\n\t\t\t*/\n\t\t\tif($(infoDoc).find(\'#MessageText\').val() != \'\'){\t\t\t\t\n\t\t\t\talert(getMessage($(infoDoc).find(\'#MessageText\').val(),\'BL\'));\n\t\t\t\treturn false;\t\t\t\t\n\t\t\t}\n\t\t\t\t\t\t\n\t\t\t$(\'#serviceLocation\').val($(exisOrderDoc).find(\'#serviceLocation\').val());\n\t\t\t$(\'#pkgSeqNo\').val($(tabDoc).find(\'#pkgSeqNo\').val());\n\t\t\t$(\'#pkgClosedYn\').val($(tabDoc).find(\'#pkgClosedYn\').val());\t\n\t\t\t$(\'#visitTypeCode\').val($(exisOrderDoc).find(\'#visitTypeCode\').val());\n\t\t\tif($(summDoc).find(\'#splDepChk\').prop(\'checked\')){\n\t\t\t\t$(\'#splDepChk\').val(\'Y\');\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#splDepChk\').val(\'N\');\n\t\t\t}\n\t\t\t$(\'#docAmt\').val($(summDoc).find(\'#docAmt\').val());\n\t\t\t$(\'#docAmt1\').val($(summDoc).find(\'#docAmt1\').val());\n\t\t\t$(\'#slmtAmt\').val($(summDoc).find(\'#slmtAmt\').val());\n\t\t\t$(\'#blngGrpId\').val($(tabDoc).find(\'#blngGrpId\').val());\t\n\t\t\t$(\'#exemptAmt\').val($(summDoc).find(\'#exemptReq\').val());\n\t\t\t$(exisOrderDoc).find(\'#slmtErrorCheck\').val(\'\');\n\t\t\t$(exisOrderDoc).find(\'#slmtError\').val(\'\');\n\t\t\t$(exisOrderDoc).find(\'#slmtWarning\').val(\'\');\n\t\t\t/*if(($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1068\',\'BL\')) ||\n\t\t\t\t($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1072\',\'BL\')) ||\n\t\t\t\t($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9079\',\'BL\')) ||\n\t\t\t\t($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9080\',\'BL\'))){\t*/\t\t\t\t\n\t\t\tvar status = chkSlmtValidationBillGen();\n\t\t\tif(!status){\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t//}\n\t\t\t\n\t\t\tif($(exisOrderDoc).find(\'#errorCheck\').val() == \'Y\' && $.trim($(exisOrderDoc).find(\'#error\').val()) != \'\'){\n\t\t\t\tif(parseFloat($(\'#slmtAmt\').val()) == parseFloat(0)){\n\t\t\t\t\tif(($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1068\',\'BL\')) ||\n\t\t\t\t\t\t($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1072\',\'BL\'))){\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert($(exisOrderDoc).find(\'#error\').val());\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tif(($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1068\',\'BL\')) ||\n\t\t\t\t\t\t($.trim($(exisOrderDoc).find(\'#error\').val()) == getMessage(\'BL1072\',\'BL\'))){\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*if($.trim($(exisOrderDoc).find(\'#slmtError\').val()) != \'\'){\n\t\t\t\t\t\t\talert($(exisOrderDoc).find(\'#slmtError\').val());\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}*/\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert($(exisOrderDoc).find(\'#error\').val());\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\t}\n\t\t\telse if($.trim($(exisOrderDoc).find(\'#warning\').val()) != \'\'){\n\t\t\t\tif(parseFloat($(\'#slmtAmt\').val()) == parseFloat(0)){\n\t\t\t\t\tif(($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9079\',\'BL\')) ||\n\t\t\t\t\t\t\t($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9080\',\'BL\'))){\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert($(exisOrderDoc).find(\'#warning\').val());\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tif(($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9079\',\'BL\')) ||\n\t\t\t\t\t\t\t($.trim($(exisOrderDoc).find(\'#warning\').val()) == getMessage(\'BL9080\',\'BL\'))){\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t/*if($.trim($(exisOrderDoc).find(\'#slmtWarning\').val()) != \'\'){\n\t\t\t\t\t\t\talert($(exisOrderDoc).find(\'#slmtWarning\').val());\t\t\t\t\t\t\t\n\t\t\t\t\t\t}*/\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert($(exisOrderDoc).find(\'#warning\').val());\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\t}\n\n\t\t\tvar capt_addl_id_proof_for_bill_yn=$(parent.BillReceiptTab.document).find(\'#capt_addl_id_proof_for_bill_yn\').val();\n\t\t\tvar addl_id_mand_for_payer_bill_yn=$(parent.BillReceiptTab.document).find(\'#addl_id_mand_for_payer_bill_yn\').val();\n\t\t\tvar dflt_addl_id_type=$(parent.BillReceiptTab.document).find(\'#dflt_addl_id_type\').val();\n\t\t\tvar dflt_addl_id_desc=\" \";\n\t\t\tvar name=\"\";var id=\"\";var code=\"\";var remarks=\"\";\n\t\t\t\n\t\t\tvar param=\"&dflt_addl_id_type=\"+dflt_addl_id_type+\"&addl_id_mand_for_payer_bill_yn=\"+addl_id_mand_for_payer_bill_yn;\n\t\t\n\t\t\n\t\t\tif(capt_addl_id_proof_for_bill_yn==\'Y\' && maxPayer>0 )\n\t\t\t{\t\t\n\t\t\t\tvar dialogHeight= \"150px\" ;\n\t\t\t\tvar dialogWidth\t= \"620px\" ;\n\t\t\t\tvar dialogTop = \"225\" ;\n\t\t\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\t\t\n\t\t\t\tvar retVal = await window.showModalDialog(\"../../eBL/jsp/BillReceiptIdProofValidation.jsp?\"+param,null,features);\n\t\t\t\n\t\t\t\tif(retVal !=null && retVal != undefined){\t\t\t\n\t\t\t\t\tpatientName=retVal[0];\n\t\t\t\t\taltIdNo=retVal[1];\n\t\t\t\t\taltIdType=retVal[2];\n\t\t\t\t\t remarks=retVal[3];\n\t\t\t\t\t\t$(\'#altIdType\').val(altIdType);\n\t\t\t\t\t\t$(\'#patientName\').val(patientName);\n\t\t\t\t\t\t$(\'#altIdNo\').val(altIdNo);\n\t\t\t\t\t\t$(\'#remarks\').val(remarks);\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\treturn false;\n\t\t\t\t}\t\t\n\t\t\t}\n\t\t\tif($(exisOrderDoc).find(\'#pkgCount\').val()>0){\n\t\t\t\tvar pkgSeqNo=$(tabDoc).find(\'#pkgSeqNo\').val();\n\t\t\t\tvar totalCount=$(tabDoc).find(\'#totalCount\').val();\n\t\t\t\tvar packageCode=$(tabDoc).find(\'#packageCode\').val();\n\t\t\t\t\n\t\t\t\t$(\'#pkgSeqNo\').val(pkgSeqNo);\n\t\t\t\t$(\'#totalCount\').val(totalCount);\n\t\t\t\t$(\'#packageCode\').val(packageCode);\t\t\t\t\n\t\t\t}\n\n\t\t\tvar unprocessedparams = \'calledFrom=UnprocessedCheck\'+\n\t\t\t\'&patientId=\'+$(\'#patient_id\').val()+\n\t\t\t\'&facilityId=\'+$(\'#facilityId\').val()+\n\t\t\t\'&episodeType=\'+$(\'#episode_type\').val()+\n\t\t\t\'&episodeId=\'+$(\'#episode_id\').val()+\n\t\t\t\'&visitId=\'+$(\'#visit_id\').val();\n\t\t\tvar continueUnProcessed = true;\n\t\t\t$.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\t\t\tdata:unprocessedparams,\n\t\t\t\tdataType:\"json\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\tif(data.Success == \'Y\'){\n\t\t\t\t\t\tif(data.unprocessed_yn == \'Y\'){\n\t\t\t\t\t\t\t/**Added By Gayathri- For MMS-For Package Patient, \n\t\t\t\t\t\t\t*For IP and DC and the Bill type Interim and Undercharge, The Bill should not get generated if any unprocessed records are present\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\tif( (($(\'#episode_type\').val() == \'O\' || $(\'#episode_type\').val() == \'E\') ||\n\t\t\t\t\t\t\t(($(\'#episode_type\').val() == \'I\' || $(\'#episode_type\').val() == \'D\') && \n\t\t\t\t\t\t\t($(\'#ipBillType\').val() == \'U\' || $(\'#ipBillType\').val() == \'D\'))) &&\n\t\t\t\t\t\t\t($(exisOrderDoc).find(\'#pkgCount\').val()>0 && $(tabDoc).find(\'#pkgClosedYn\').val() != \'Y\'))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\'BL00959\',\'BL\'));\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tcontinueUnProcessed = false;\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse{\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar con1 = confirm(data.unprocessedMessage);\n\t\t\t\t\t\t\t\tcontinueUnProcessed = con1;\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\talert(data.errorText);\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t},\n\n\t\t\t \terror: function(data){\t\t\t\n\t\t\t\t \talert(data)\n\t\t\t  \t}\n\t\t\t});\n\t\t\t\n\t\t\tif(!continueUnProcessed){\t\t\t\t\t\t\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\t$(\'#hdnCntrUserName\').val($.trim($(\'#cntrUserName\').text()));\n\t\t\t$(\'#hdnCntrUserShift\').val($.trim($(\'#cntrUserShift\').text()));\n\t\t\t//$(\'#hdnUnBillAmt\').val($.trim($(\'#unBillAmt\').text()));\n\t\t\t$(\'#hdnUnBillAmt\').val($(exisOrderDoc).find(\'#prevUnBilledAmt\').val());\n\t\t\t\n\t\t\t/";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="*Show Progress*/\n\t\t\t$(\'#tdBtnGenerate\').hide();\n\t\t\t$(\'#trProgress\').show();\n\t\t\t$(\'#tdProgress\').text(\'Generating Bill. . Please Wait. .\');\n\t\t\t/*Show Progress*/\n\n\t\t\t$(\'#frmBillInfo\').attr(\'target\',\'messageFrame1\');\n\t\t\t$(\'#frmBillInfo\').attr(\'method\',\'post\');\n\t\t\t$(\'#frmBillInfo\').submit();\n\n\t}\n</script>\n</head>\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\n\n<body >\n<form name=\'frmBillInfo\' id=\'frmBillInfo\' action=\"../../servlet/eBL.BillReceiptGenerationServlet\" method=\"post\" target=\"messageFrame\">\n<table  style=\"width: 100%;\">\n\t<tr style=\"width: 100%\" id=\'tdBtnGenerate\' name=\'tdBtnGenerate\'>\n\t<td style=\"width: 68%\">\n\t\t<input type=\'button\'  name=\'compute\' id=\'compute\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'class=\'button\' onClick=\"generateBill()\">\n\t\t&nbsp;\n\t\t<input type=\'button\' class=\'button\' name=\'pkgDtls\' id=\'pkgDtls\'  value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t&nbsp;\n\t\t<input type=\'button\'  name=\'interfaceBtn\' id=\'interfaceBtn\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' class=\'button\'>\n\t\t&nbsp;\n\t\t<input type=\'button\'  name=\'clearBtn\' id=\'clearBtn\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\'>\n\t\t&nbsp;\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" &nbsp;<input type=\'checkbox\' name=\'detailChk\' id=\'detailChk\' id=\'detailChk\'>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t&nbsp;\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<input type=\'button\' name=\'draftBtn\' id=\'draftBtn\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' class=\'button\'>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t</td>\n\t<td style=\"width: 32%;\">\n\t</td>\n\t</tr>\n\t<tr  id=\'trProgress\' name=\'trProgress\'>\n\t\t<td  colspan=\'2\'>\n\t\t\t<h3 id=\'tdProgress\' name=\'tdProgress\'>\n\t\t\t</h3>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\"68%\"  valign=\"top\">\n\t\t\t<table style=\"width: 100%\" class=\"grid\">\t\t\t\n\t\t\t<tr style=\"width: 100%\">\n\t\t\t<td style=\"width: 100%; border: 1px solid #666666;\">\n\t\t\t<table style=\"width: 100%\" cellpadding=\'3\' cellspacing=\'1.5\' >\n\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td class=\'LABEL\'colspan=\'2\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'outstCash\' id=\'outstCash\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span></td>\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'outstCredit\' id=\'outstCredit\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span></td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'availPatDep\' id=\'availPatDep\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'patDepAdj\' id=\'patDepAdj\'></span></td>\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'patDepBal\' id=\'patDepBal\'></span></td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'availPatPrepay\' id=\'availPatPrepay\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'patPrepayAdj\' id=\'patPrepayAdj\'></span></td>\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'patPrepayBal\' id=\'patPrepayBal\'></span></td>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\"><Span roundToVal=\'Y\' name=\'unBillAmt\' id=\'unBillAmt\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;<input type=\'checkbox\' name=\'depAdjChk\' id=\'depAdjChk\' id=\'depAdjChk\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\' name=\'depAdjAmt\' id=\'depAdjAmt\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;<input type=\'checkbox\' name=\'prePayChk\' id=\'prePayChk\' id=\'prePayChk\'></td>\n\t\t\t\t\t<td width=\"10%\" class=\'LABEL\' style=\"text-align: right\">\t\t\t\t\t\n\t\t\t\t\t<Span roundToVal=\'Y\' name=\'prePayAmt\' id=\'prePayAmt\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span></td>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t<td width=\"10%\" class=\'fields\'>\n\t\t\t\t\t\t<Select name=\'inPatBillType\' id=\'inPatBillType\' >\n\t\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t\t\t\t<option value=\'I\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t\t\t\t\t\t<option value=\'U\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t</Select>\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td  class=\'LABEL\' width=\"10%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"10%\" class=\'fields\' style=\"text-align: right\">\n\t\t\t\t\t<Select name=\'billGenOpt\' id=\'billGenOpt\'>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\n\t\t\t\t\t\t<option value=\'P\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\n\t\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\n\t\t\t\t\t</Select>\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td class=\'LABEL\' width=\"10%\">\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"10%\" class=\'fields\' style=\"text-align: right\">\n\t\t\t\t\t\t<select name=\'billGenType\' id=\'billGenType\' style=\"width: 150px;\">\n\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\n\t\t</td>\n\t\t<td width=\"32%\" valign=\"top\">\n\t\t\t<table style=\"width: 100%\">\n\t\t\t<tr style=\"width: 100%\">\n\t\t\t<td style=\"width: 100%; border: 1px solid #666666;\" >\n\t\t\t<table style=\"width: 100%; \" cellpadding=\'3\' cellspacing=\'1.5\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'LABEL\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" \n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'3\' class=\'LABEL\' >\n\t\t\t\t\t\t<Span name=\'cntrUserId\' id=\'cntrUserId\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</span>\n\t\t\t\t\t</td>\t\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'LABEL\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t\t\t\t\t</td>\t\n\t\t\t\t\t\n\t\t\t\t\t<td width=\"25%\"  class=\'LABEL\'  >\n\t\t\t\t\t\t<Span name=\'cntrUserName\' id=\'cntrUserName\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t</span><!--V230127-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'LABEL\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td width=\"25%\"  class=\'LABEL\'  >\n\t\t\t\t\t\t<Span name=\'cntrUserShift\' id=\'cntrUserShift\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \n\t\t\t\t\t\t</span> <!--V230127-->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t\n\t\t\t<table style=\"width: 100%\">\n\t\t\t<tr style=\"width: 100%\">\n\t\t\t<td style=\"width: 100%; border: 1px solid #666666;\" >\n\t\t\t<table style=\"width: 100%; \" cellpadding=\'3\' cellspacing=\'1.5\' >\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\' class=\'LABEL\' id=\'admVisitDate\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'  class=\'LABEL\' >\n\t\t\t\t\t\t<span name=\'admDate\' id=\'admDate\' >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\' class=\'LABEL\' id=\'expDisDate\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'   class=\'LABEL\' >\n\t\t\t\t\t\t<span id=\'expDischDt\' name=\'expDischDt\' class=\'fields\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<tr id=\'trLastBedChargeDt\' name=\'trLastBedChargeDt\'>\n\t\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\' class=\'LABEL\'>\n\t\t\t\t\t<Span name=\'lastBedChargeDt\' id=\'lastBedChargeDt\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'trComputeUptoDt\' name=\'trComputeUptoDt\'>\n\t\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\n\t\t\t\t\tCompute Upto\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'  class=\'LABEL\'>\n\t\t\t\t\t<span name=\'computeUptoDt\' id=\'computeUptoDt\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<tr id=\'trLastBedChargeDt\' name=\'trLastBedChargeDt\' style=\"visibility: hidden\">\n\t\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\n\t\t\t\t\tLast Bed Charge Date\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\' class=\'LABEL\'>\n\t\t\t\t\t<Span name=\'lastBedChargeDt\' id=\'lastBedChargeDt\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'trComputeUptoDt\' name=\'trComputeUptoDt\' style=\"visibility: hidden\">\n\t\t\t\t\t<td class=\'LABEL\' colspan=\'2\'>\n\t\t\t\t\tCompute Upto\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'  class=\'LABEL\'>\n\t\t\t\t\t<span name=\'computeUptoDt\' id=\'computeUptoDt\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<tr>\t\t\t\t\t\n\t\t\t\t\t<td colspan=\'2\' class=\'LABEL\' id=\'queuepkid\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan=\'2\'   class=\'fields\' >\n\t\t\t\t\t\t<input type=\"text\" name=\"queue_id\" id=\"queue_id\"   onBlur=\"validatePKID(this,\'O\');\"   onKeyPress=\"\" >\t\n\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t<tr>\t\t\t\t\t\n\t\t<td colspan=\'2\' class=\'LABEL\' id=\'refnum\'>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t</td>\n\t\t<td colspan=\'2\'   class=\'fields\' >\n\t\t\t<input type=\'text\' name=\"orgBillRefNum\" id=\"orgBillRefNum\" readOnly size=\'10\'  value=\'\' onblur=\"if(this.value!=\'\'){ refNumLookup(this.value); }\">\n\t\t\t<input type=\'button\' id=\'Ref_Num\' name=\'Ref_Num\' value=\'?\'  onclick=\'refNumLookup(this.value)\' >\t\t\t\t\t\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t<input type=\'hidden\' name=\'serviceLocation\' id=\'serviceLocation\' value=\'\'>\n\t<input type=\'hidden\' name=\'pkgSeqNo\' id=\'pkgSeqNo\' value=\'\'>\n\t<input type=\'hidden\' name=\'pkgClosedYn\' id=\'pkgClosedYn\' value=\'\'>\n\t<input type=\'hidden\' name=\'visitTypeCode\' id=\'visitTypeCode\' value=\'\'>\n\t<input type=\'hidden\' name=\'splDepChk\' id=\'splDepChk\' value=\'\'>\n\t<input type=\'hidden\' name=\'docAmt\' id=\'docAmt\' value=\'\'>\n\t<input type=\'hidden\' name=\'blngGrpId\' id=\'blngGrpId\' value=\'\'>\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t<input type=\'hidden\' name=\'slmtAmt\' id=\'slmtAmt\' value=\'\'>\n\t<input type=\'hidden\' name=\'exemptAmt\' id=\'exemptAmt\' value=\'\'>\n\t<input type=\'hidden\' name=\'depAdjustedYn\' id=\'depAdjustedYn\' value=\'\'>\n\t<input type=\'hidden\' name=\'preAdjustedYn\' id=\'preAdjustedYn\' value=\'\'>\n\t<input type=\'hidden\' name=\'pkgSeqNo\' id=\'pkgSeqNo\' value=\'\'>\n\t<input type=\'hidden\' name=\'totalCount\' id=\'totalCount\' value=\'\'>\n\t<input type=\'hidden\' name=\'packageCode\' id=\'packageCode\' value=\'\'>\n\n\t<input type=\'hidden\' name=\'MessageText\' id=\'MessageText\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\n\t<input type=\'hidden\' name=\'depAdjChkYn\' id=\'depAdjChkYn\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t<input type=\'hidden\' name=\'preAdjChkYn\' id=\'preAdjChkYn\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t<input type=\'hidden\' name=\'interfaceYn\' id=\'interfaceYn\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t<input type=\'hidden\' name=\'futureOrderYn\' id=\'futureOrderYn\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t<input type=\'hidden\' name=\'ipBillType\' id=\'ipBillType\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t<input type=\'hidden\' name=\'hdnCntrUserName\' id=\'hdnCntrUserName\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnCntrUserShift\' id=\'hdnCntrUserShift\' value=\'\'>\n\t<input type=\'hidden\' name=\'hdnUnBillAmt\' id=\'hdnUnBillAmt\' value=\'\'>\n\t<input type= \'hidden\' name=\'altIdType\' id=\'altIdType\' value=\'\'>\n\t<input type= \'hidden\' name=\'altIdNo\' id=\'altIdNo\' value=\'\'>\n\t<input type= \'hidden\' name=\'patientName\' id=\'patientName\' value=\'\'>\n\t<input type= \'hidden\' name=\'enableQueuePKID\' id=\'enableQueuePKID\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t<input type= \'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n\t<input type= \'hidden\' name=\'exemptType\' id=\'exemptType\' value=\'\'>\n\t<input type= \'hidden\' name=\'assignTo\' id=\'assignTo\' value=\'\'>\n\t<input type=\'hidden\' name=\'displayLastBedDate\' id=\'displayLastBedDate\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t<input type=\'hidden\' name=\'expDischOrDischLabel\' id=\'expDischOrDischLabel\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t<input type=\'hidden\' name=\'encounterFacilityId\' id=\'encounterFacilityId\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<input type=\'hidden\' name=\'siteSpecServiceCode\' id=\'siteSpecServiceCode\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'><!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t<input type=\'hidden\' name=\'coderClearanceStatus\' id=\'coderClearanceStatus\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'><!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t<input type=\'hidden\' name=\'ZatcaYN\' id=\'ZatcaYN\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" ><!-- V221230 -->\n\t<input type=\'hidden\' name=\'enableInsClearance\' id=\'enableInsClearance\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" ><!-- V221129 -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");//added by Nandhini
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			
	String queryString = request.getQueryString();
	Connection conn	= null;//Added by Kamatchi S for TH-KW-CRF-0143
	conn = ConnectionManager.getConnection(request);//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ;
	
	boolean enableInsClear=false;//V221129
	String enableInsClearance="";
	try {
		enableInsClear = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL", "BL_INS_CLEARANCE_APPL");
		System.err.println("enableInsClear--" + enableInsClear);
		if (enableInsClear) {
			enableInsClearance = "Y";
		} else {
			enableInsClearance = "N";
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
		//V221129

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

//V221023 starts
String enableQueuePKID="N";
boolean isEnablePkid=false;   
Connection con = null;	
String ZatcaYN="N";
Boolean Zatca=false;   	
//V221230 
try{
	con = ConnectionManager.getConnection();
	Zatca= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ZATCA");
		if (Zatca) {
			ZatcaYN = "Y";
		}else {
			ZatcaYN = "N";
		}
		System.err.println("ZatcaYN blreceiptinfo "+ZatcaYN);
	} catch(Exception ex) {
		System.err.println("Error in blreceiptinfo.jsp for getting ZatcaYN Connection: "+ex);
		ex.printStackTrace();
	}finally{
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}
//V221230 ends

try{
	con = ConnectionManager.getConnection();
	isEnablePkid = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
		if (isEnablePkid) {
			enableQueuePKID = "Y";
		}else {
			enableQueuePKID = "N";
		}
		System.err.println("enableQueuePKID blreceiptinfo "+enableQueuePKID);
	} catch(Exception ex) {
		System.err.println("Error in blreceiptinfo.jsp for getting isEnablePkid Connection: "+ex);
		ex.printStackTrace();
	}finally{
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}
//V221023 ends


	//String patientId = replaceNull(request.getParameter("patient_id"));//V220512
	String encounterFacilityId = replaceNull(request.getParameter("encounterFacilityId")); //V210129 
	
	//V220512
String patientId	="";
String encounterId	="";

if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounterId	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patientId	= replaceNull(request.getParameter("patient_id"));
	encounterId	= replaceNull(request.getParameter("encounter_id"));
}
//V220512
	String episodeType = replaceNull(request.getParameter("episode_type"));
	String episodeId = replaceNull(request.getParameter("episode_id"));
	String visitId = replaceNull(request.getParameter("visit_id"));
	String facilityId = (String) session.getValue("facility_id");
	String coderClearanceStatus = "";//Added by Kamatchi S for TH-KW-CRF-0143
	coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,patientId,episodeType,episodeId,visitId);//Added by Kamatchi S for TH-KW-CRF-0143
	String locale = (String) session.getValue("LOCALE");
	Properties p = (Properties) session.getValue("jdbc");
	String loginUser = (String) p.getProperty("login_user");
	String clientIpAddress = (String) p.getProperty("client_ip_address");
	//String encounterId = replaceNull(request.getParameter("encounter_id"));//V220512
	String patientName=request.getParameter("patientName");
	String name="",id="",code="",remarks="";

	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLoginUser(loginUser);
	billRequest.setClientIpAddress(clientIpAddress);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	BillReceiptInfoDetails billInfo = billReceiptBC.getHeaderDetails(billRequest);
	LinkedHashMap<String,String> custDtls = billInfo.getCustMap();
	request.setAttribute("custDtls", billInfo.getCustMap());
	System.err.println("getIpBillType() ===>>781 :: "+billInfo.getIpBillType());

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
if("I".equals(episodeType)){ 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
if("I".equals(episodeType)){ 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{ 
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(replaceNull(billInfo.getOutstCash())));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(replaceNull(billInfo.getOutstCredit())));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(replaceNull(billInfo.getPatDepAvail())));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(replaceNull(billInfo.getPrePayAvail())));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(replaceNull(billInfo.getUnBilled())));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(replaceNull(billInfo.getPatDepUnAdj())));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(replaceNull(billInfo.getPrePayUnAdj())));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
for(Iterator iter=custDtls.keySet().iterator(); iter.hasNext();){ 
							String key = (String) iter.next();
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(key));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(custDtls.get(key) ));
            _bw.write(_wl_block48Bytes, _wl_block48);
} 
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(replaceNull(billInfo.getCashCntrId())));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(replaceNull(billInfo.getCashCntrId())));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(replaceNull(billInfo.getCashCntrShiftId())));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(replaceNull(billInfo.getCashCntrShiftId())));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(replaceNull(billInfo.getAdmDate())));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(replaceNull(billInfo.getDischDate())));
            _bw.write(_wl_block60Bytes, _wl_block60);
if("I".equals(episodeType)){ 
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(replaceNull(billInfo.getLastBedChargeDt())));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(replaceNull(billInfo.getComputeUpto())));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
				else if("D".equals(episodeType)){
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(replaceNull(billInfo.getLastBedChargeDt())));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(replaceNull(billInfo.getComputeUpto())));
            _bw.write(_wl_block64Bytes, _wl_block64);
} 
            _bw.write(_wl_block67Bytes, _wl_block67);

			
			System.err.println("episodeType "+episodeType);
			if(enableQueuePKID.equals("Y") && episodeType.equals("O")){
			
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
 } 
            _bw.write(_wl_block70Bytes, _wl_block70);

	//V221230
	System.err.println("episodeType "+episodeType);
	if(ZatcaYN.equals("Y")){
	
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
 } 
	//V221230
	
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(encounterId ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(replaceNull(billInfo.getMessageText())));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(replaceNull(billInfo.getDefDepYn())));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(replaceNull(billInfo.getDefPreYn())));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(replaceNull(billInfo.getInterfaceYn())));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(replaceNull(billInfo.getFutureOrderYn())));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(replaceNull(billInfo.getIpBillType())));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(enableQueuePKID));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(replaceNull(billInfo.getDisplayLastBedDate())));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(replaceNull(billInfo.getExpDischOrDischLabel())));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(encounterFacilityId));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(siteSpecServiceCode));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(coderClearanceStatus));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(ZatcaYN));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(enableInsClearance));
            _bw.write(_wl_block94Bytes, _wl_block94);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GenerateBill.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PACKAGE_DTL.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Interface.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.draft.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OutstandAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Availablepatdeposit.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Adjust.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Balance.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Availablepatprepay.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Adjust.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Balance.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_NEW.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEPOSIT.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PrepayAmount.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.InpatientBillType.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PendingInterimBill.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PendingDischargeBill.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PendingUnderchargeBill.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillGenOption.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BOTH.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_COUNTER.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ExpectedDischargeDate.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.LastBedChargeDate.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.queuePKID.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OrgBillRefNo.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
