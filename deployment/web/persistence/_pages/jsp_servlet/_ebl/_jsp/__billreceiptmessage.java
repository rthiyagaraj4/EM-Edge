package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eBL.BLReportIdMapper;

public final class __billreceiptmessage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptMessage.jsp", 1734681047770L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html; charset=UTF-8\">\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\"JavaScript\">\n$(document).ready(function(){\n\tif($(\'#error_value\').val() == \'1\'){\n\t\tpDoc = parent.parent.frames[3].frames[2].document.forms[0];\n\t\t$(pDoc).find(\'#tdBtnGenerate\').show();\n\t\t$(pDoc).find(\'#trProgress\').hide();\n\t\t$(pDoc).find(\'#tdProgress\').text(\'\');\n\t\t$(pDoc).find(\'#compute\').attr(\'disabled\',\'disabled\');\t\t\n\t\tloadSettlement();\n\t}\n\telse{\n\t\tpDoc = parent.parent.frames[3].frames[2].document.forms[0];\n\t\t$(pDoc).find(\'#tdBtnGenerate\').show();\n\t\t$(pDoc).find(\'#trProgress\').hide();\n\t\t$(pDoc).find(\'#tdProgress\').text(\'\');\n\t}\n\t\n});\n\nfunction loadSettlement()\n{\tvar confirmBox=\'\';\n\tvar exemptWarning=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\tvar exemptConsWarning=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tvar billSlmtAmt=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\tvar billExemptAmt=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\n\tvar Pgmid=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\tvar PgmDate=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\tvar Sessionid=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\n\t\n\tvar slmtAmt=\'\';\n\tvar noOfDecimals= $(parent.parent.parent.frames[3].document.forms[0]).find(\'#noOfDecimal\').val();\n\tif($(\'#billPrintYn\').val() == \'Y\'){\n\t\t\n\t\n\t  \t\n\t\t\tvar sessionId = Sessionid;\n\t\t\tvar pgmDate = PgmDate;\n\t\t\tvar reportId = Pgmid;\n\t\t\tvar pgmId = Pgmid;\n\t\t\tvar mpiId = \'1\';\t\t\t                        \t\t\t\n\n\t\t\tvar sessionIdArr = sessionId.split(\",\");\n\t\t\tvar pgmDateArr = pgmDate.split(\",\");\n\t\t\tvar reportIdArr = reportId.split(\",\");\n\t\t\tvar pgmIdArr = pgmId.split(\",\");\n\t\t\t\n\t\t\tvar printArr = [];\n\t\t\tvar params = \'calledFrom=ASYNCPRINT&\';\n\t\t\tvar sno = 1;\n\t\t\tvar total = 0;\n\t\t\tfor(var i=0; i<sessionIdArr.length;i++){\n\t\t\t\tvar temp = pgmIdArr[i]+\"/\"+sessionIdArr[i]+\"/\"+pgmDateArr[i]+\"/\"+mpiId;\n\t\t\t\tparams = params+\'billPrintVal\'+sno+\'=\'+encodeURIComponent(temp)+\'&\';\n\t\t\t\tparams = params+\'report\'+sno+\'=\'+encodeURIComponent(reportIdArr[i])+\'&\';\n\t\t\t\tsno++;\n\t\t\t\ttotal++;\n\t\t\t}\n\t\t\tparams = params+\'totalReport=\'+total;\n\t\t\t$.ajax({\n\t\t\t\ttype:\"GET\",\n\t\t\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\t\t\tdata:params,\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n                \t$.ajax({\n                \t\turl:\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",\n                \t\tasync:true,\n                \t\ttype:\'post\',\n                \t\tdatatype:\'text\',\n                \t\tsuccess: function(data) {\n                \t\t\t\n                \t\t}\n                \t});\n\t\t\t\t},\n\t\t\t\t error: function(data){\n\t\t\t\t\t alert(data.flag)\n\t\t\t      }\n\t\t\t});\n\t\t\t\n\t}\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\t\n\t\n\t\n\tif(exemptWarning!=\'\'&&exemptConsWarning==\'\')\n\t\t{\n\t\t confirmBox =window.confirm(getMessage(\'BL7184\',\'BL\'));;\n\t\t if(confirmBox){\n\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').val(\"0.00\");\n\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').get(0),17,noOfDecimals);\t\n\t\t slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);\n\t\t\t $(\'#billSlmtAmt\').val(slmtAmt);\n\t\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').val(slmtAmt);\n\t\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').get(0),17,noOfDecimals);\t\n\t\t\t\n\t\t }\n\t\t\n\t}\n\tif(exemptConsWarning!=\'\'&&exemptWarning==\'\' )\n\t{\n\t confirmBox =window.confirm(getMessage(\'BL6470\',\'BL\'));\n\t\n\t if(confirmBox){\n\t\t \n $(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').val(\"0.00\");\n\t\n putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').get(0),17,noOfDecimals);\n\t\n\t\t slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);\n\t\t\n\t\t $(\'#billSlmtAmt\').val(slmtAmt);\n\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').val(slmtAmt);\n\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').get(0),17,noOfDecimals);\t\n\t\t\t\n\t }\n\t\n}\n\t\n\tif(exemptConsWarning!=\'\'&&exemptWarning!=\'\' )\n\t{\n\t confirmBox =window.confirm(getMessage(\'BL7184\',\'BL\'));\n\t\n\t if(confirmBox){\n\t\t \n\t \n\t $(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').val(\"0.00\");\n\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').get(0),17,noOfDecimals);\n\t\n\t\t slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);\n\t\t\n\t\t $(\'#billSlmtAmt\').val(slmtAmt);\n\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').val(slmtAmt);\n\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').get(0),17,noOfDecimals);\t\n\t\t\t\n\t }\n\t else{\n\t\t \n\t\t confirmBox =window.confirm(getMessage(\'BL6470\',\'BL\'));\n\t\t if(confirmBox){\n\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').val(\"0.00\");\n\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#exemptReq\').get(0),17,noOfDecimals);\n\t\t\n\t\t\t slmtAmt=parseFloat(billSlmtAmt)+parseFloat(billExemptAmt);\n\t\t\t\n\t\t\t $(\'#billSlmtAmt\').val(slmtAmt);\n\t\t\t $(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').val(slmtAmt);\n\t\t\t putDecimal_field($(parent.BillReceiptExisOrderSummary.document).find(\'#slmtAmt\').get(0),17,noOfDecimals);\t\n\t\t\t \n\t\t\t\t\n\t\t }\n\t\t\n\t }\n\t\n\n}\n\t\n\n\n\n\t\t\n\t\n\t\n\t//if(parseInt($(\'#billAmt\').val()) > 0 || parseInt($(\'#billAmt\').val()) < 0 ){\n\tif($(\'#invokeSlmt\').val() == \'Y\'){\n\n\t\t/*var BillSlmtRoundingAmt = \'calledFrom=BillSlmtRoundingAmt\'+\t\n\t\t\'&facilityId=\'+$(\'#facilityId\').val()+\n\t\t\'&billDocType=\'+$(\'#billDocType\').val()+\n\t\t\'&patDocNum=\'+$(\'#patDocNum\').val()+\n\t\t\'&billSlmtAmt=\'+ $(parent.BillReceiptExisOrderSummary.document).find(\'#docAmt1\').val();// $(\'#billSlmtAmt\').val();\n\n\t\t$.ajax({\n\t\t\ttype:\"GET\",\n\t\t\turl:\"../jsp/BillReceiptAjax.jsp\",\n\t\t\tdata:BillSlmtRoundingAmt,\n\t\t\tdataType:\"text\",\n\t\t\tasync:false,\n\t\t\tsuccess: function(data){\t\n\t\t\t\t $(\'#billSlmtAmt\').val($.trim(data));\t\t\t \n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t\n\t\t\t  }\n\t\t});*/\n\n\t\tvar totalRows = 1;\n\t\tvar params = \'totalRows=1\'+ \n\t\t\t\t\t\'&patient_id1=\'+$(\'#patientId\').val()+\n\t\t\t\t\t\'&episode_type1=\'+$(\'#episodeType\').val()+\n\t\t\t\t\t\'&episode_id1=\'+$(\'#episodeId\').val()+\n\t\t\t\t\t\'&visit_id1=\'+$(\'#visitId\').val()+\n\t\t\t\t\t\'&billdocType1=\'+$(\'#patDocType\').val()+\n\t\t\t\t\t\'&billdocNum1=\'+$(\'#patDocNum\').val()+\n\t\t\t\t\t\'&billdocDate1=\'+$(\'#billDocDate\').val()+\n\t\t\t\t\t\'&billTotalAmt1=\'+$(\'#billDocAmt\').val()+\n\t\t\t\t\t\'&billtotOutStdAmt1=\'+$(\'#billDocAmt\').val()+\n\t\t\t\t\t\'&excempted_amt1=\'+$(\'#billExemptAmt\').val()+\n\t\t\t\t\t\'&rem_slmt_amt1=\'+$(\'#billSlmtAmt\').val()+\n\t\t\t\t\t\'&bill_print_yn1=Y\';\n\t\t\n\t\t$.ajax({\t\n\t\t\ttype:\"POST\",\n\t\t\turl:\"../jsp/BLBillDetailsPersistance.jsp\",\n\t\t\tdata: params,\t\n\t\t\tsuccess: function(data){\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' == \'Y\'){\n\t\t\t\t\talert(getMessage(\'BL9793\',\'BL\'));\n\t\t\t\t}\n\t\t\t\t//V221122\n\t\t\t\tvar eSignatureFlag = document.forms[0].eSignatureFlag.value;\n\t\t\t\tif(eSignatureFlag==\"Y\"){\n\t\t\t\t\tvar esign=OpenEsign();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tvar ZatcaYN=document.forms[0].ZatcaYN.value;\n\t\t\t\tif(ZatcaYN==\"Y\"){\n\t\t\t\t\tvar Zatca_msg=document.forms[0].Zatca_msg.value;\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\\n\'+Zatca_msg);\n\t\t\t\t}else{\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\n\t\t\t\t}//V221230\t\t\t\t\n\t\t\t\t/* parent.window.returnValue = \'Y:::\'+$(\'#patDocType\').val()+\':::\'+$(\'#patDocNum\').val()+\':::\'+$(\'#billSlmtAmt\').val();\n\t\t\t\tparent.window.close(); */\n\t\t\t\tparent.parent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = \'Y:::\'+$(\'#patDocType\').val()+\':::\'+$(\'#patDocNum\').val()+\':::\'+$(\'#billSlmtAmt\').val();\n\t\t\t\tparent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t\t\t\t\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t if(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' == \'Y\'){\n\t\t\t\t\t\talert(getMessage(\'BL9793\',\'BL\'));\n\t\t\t\t\t}\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\n\t\t     }\n\t\t});\n\t}\n\telse{\n\t\tif(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' == \'Y\'){\n\t\t\talert(getMessage(\'BL9793\',\'BL\'));\n\t\t}\n\t\t\n\t\t//V221122\n\t\tvar eSignatureFlag = document.forms[0].eSignatureFlag.value;\n\t\tif(eSignatureFlag==\"Y\"){\n\t\t\tvar esign=OpenEsign();\n\t\t\n\t\t}\n\t\tvar ZatcaYN=document.forms[0].ZatcaYN.value;\n\t\tif(ZatcaYN==\"Y\"){\n\t\t\tvar Zatca_msg=document.forms[0].Zatca_msg.value;\n\t\t\talert(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\\n\'+Zatca_msg);\n\t\t}else{\n\t\t\talert(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\n\t\t}\n\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' != \'\'){\n\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'BL\'));\n\t\t}\n/* \t\tparent.window.returnValue = \'N\';\n\t\tparent.window.close(); */\n\t\t\n\t\tparent.parent.document.querySelectorAll(\"#dialog-body\")[parent.parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = \'N\';\n\t\tparent.parent.document.querySelectorAll(\"#dialog_tag\")[parent.parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t}\n\t\n}\n\n//V221122\n\nfunction OpenEsign(){\n\tvar patDocType=document.forms[0].patDocType.value;\n\tvar patDocNum=document.forms[0].patDocNum.value;\n\tvar patientId=document.forms[0].patientId.value;\n\tvar episodeType=document.forms[0].episodeType.value;\n\tvar episodeId=document.forms[0].episodeId.value;\n\tvar visitId=document.forms[0].visitId.value;\n\tvar mpi_id=\"\";\n\tvar insBillCount=\"\";\n\t\n\t$.ajax({\n\t\ttype:\"POST\",\n\t\turl:\"../../eBL/jsp/BLCommonAjax.jsp\",\n\t\tdata:\"functionMode=mpiInsData&billdoctypecode=\"+patDocType+\n\t\t\t\t\"&\"+\"billdocnum=\"+patDocNum,\n\t\tdataType:\"text\",\n\t\tasync:false,\n\t\tsuccess: function(data){\n\t\t\tvar retVal = trimString(data).split(\":::\");\n\t\t\tmpi_id=retVal[0];\n\t\t\tinsBillCount=retVal[1];\n\t\t},\n\t\terror: function(data){\n\t\t\t//alert(\"error in mpiInsData :\"+data);\n\t  }\n\t});\n\n\t\n\tif(insBillCount>0){\n\n\t\tvar returnVal=validate_eSignature();\n\n\t\tif(returnVal!=\'\' && returnVal!=\'undefined\' && returnVal!=undefined ){\n\t\t\tvar params=\"docTypeCode=\"+patDocType+\"&docNum=\"+patDocNum+\"&visitId=\"+visitId+\"&episodeType=\"+episodeType+\"&episodeId=\"+episodeId+\"&episodeId=\"+patientId+\"&mpi_id=\"+mpi_id+\"&image=\"+encodeURIComponent(returnVal); \n\t\t\t$.ajax({\n\t\t\t\ttype:\"POST\",\n\t\t\t\turl:\"../../eBL/jsp/BLCommonAjax.jsp\",\n\t\t\t\tdata:\"functionMode=PatientSign&\"+params,\n\t\t\t\tdataType:\"text\",\n\t\t\t\tasync:false,\n\t\t\t\tsuccess: function(data){\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\terror: function(data){\n\t\t\t\t//\talert(\"error in esign :\"+data);\n\t\t\t  }\n\t\t\t});\n\t\t}\n\t}\n\treturn 1;\t\n}\n</script>\n</head>\n\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n<form id=\'messageFrm\'>\n<p align=\"left\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</p>\n<p id=\'ehiserror\'></p>\n<input type=\'hidden\' name=\'billDocType\'  id=\'billDocType\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'receiptDocType\'  id=\'receiptDocType\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'refundDocType\'  id=\'refundDocType\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'blngGrpId\'  id=\'blngGrpId\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'patientId\'  id=\'patientId\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'episodeType\'  id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'episodeId\'  id=\'episodeId\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'visitId\'  id=\'visitId\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'billDocAmt\' id=\'billDocAmt\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'billSlmtAmt\' id=\'billSlmtAmt\'  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'billExemptAmt\' id=\'billExemptAmt\'  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'patDocType\' id=\'patDocType\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'patDocNum\' id=\'patDocNum\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'billDocDate\' id=\'billDocDate\'  value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'billPrintYn\' id=\'billPrintYn\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'invokeSlmt\' id=\'invokeSlmt\'  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'unProcessedYn\' id=\'unProcessedYn\'  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'error_value\' id=\'error_value\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\"hidden\"\tname=\"eSignatureFlag\" id=\"eSignatureFlag\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><!-- V221122 -->\n<input type=\"hidden\"\tname=\"Zatca_msg\" id=\"Zatca_msg\"\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><!-- V221230 -->\n<input type=\"hidden\"\tname=\"zatca_error_code\" \tid=\"zatca_error_code\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><!-- V221230 -->\n<input type=\"hidden\"\tname=\"ZatcaYN\" id=\"ZatcaYN\"\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"><!-- V221230 -->\n</form>\n</BODY>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1	         V221122								TH-KW-CRF-0174  		Mohana Priya K
2				V221230							NMC-JD-CRF-0191.1 			Mohanapriya
*/

            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String error=request.getParameter( "err_num" );
String calledFrom = request.getParameter("calledFrom");
String billDocType = checkForNull(request.getParameter("billDocType"));
String receiptDocType = checkForNull(request.getParameter("receiptDocType"));
String refundDocType = checkForNull(request.getParameter("refundDocType"));
String blngGrpId = checkForNull(request.getParameter("blngGrpId"));
String patientId = checkForNull(request.getParameter("patientId"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String visitId = checkForNull(request.getParameter("visitId"));
String billDocAmt = checkForNull(request.getParameter("billDocAmt"));
String billSlmtAmt = checkForNull(request.getParameter("billSlmtAmt"));
String patDocType = checkForNull(request.getParameter("patDocType"));
String patDocNum = checkForNull(request.getParameter("patDocNum"));
String billGenerated = checkForNull((String) session.getAttribute("billRecBillGenNum"));
String billPrintYn = checkForNull(request.getParameter("billPrintYn"));
String Pgmid = checkForNull(request.getParameter("Pgmid"));
String PgmDate = checkForNull(request.getParameter("PgmDate"));
String Sessionid = checkForNull(request.getParameter("Sessionid"));
String invokeSlmt = checkForNull(request.getParameter("invokeSlmt"));
String billExemptAmt = checkForNull(request.getParameter("billExemptAmt"));
String unProcessedYn = checkForNull(request.getParameter("unProcessedYn"));
String exemptWarning = checkForNull(request.getParameter("exemptWarning"));
String exemptConsWarning = checkForNull(request.getParameter("exemptConsWarning"));
String slmtMsgId = checkForNull(request.getParameter("slmtMsgId"));
String orgBillRefNum = checkForNull(request.getParameter("orgBillRefNum"));//V221230
String facilityId																			=   (String) session.getValue( "facility_id" ) ;

String billDocDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
System.err.println("billGenerated"+billGenerated);
System.err.println("Pgmid"+Pgmid);
System.err.println("PgmDate"+PgmDate);
System.err.println("Sessionid"+Sessionid);
String error_value = "";
//V221230
String ZatcaYN="N";
Boolean Zatca=false;	
String mpiId="";
String zatca_error_code="";//V221230
String Zatca_msg="";//V221230
ResultSet rs=null;
CallableStatement cstmt=null;
CallableStatement cstmt1=null;
try{
	con = ConnectionManager.getConnection();
	Zatca= eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ZATCA");
		if (Zatca) {
			ZatcaYN = "Y";
		}else {
			ZatcaYN = "N";
		}
		System.err.println("ZatcaYN billgen "+ZatcaYN);
	} catch(Exception ex) {
		System.err.println("Error in billgen.jsp for getting ZatcaYN Connection: "+ex);
		ex.printStackTrace();
	}
	
	if(ZatcaYN.equals("Y")){
		try{
			if(!patDocType.equals("") && !patDocNum.equals("")){
				String qry_mpi_id="select MPI_ID from bl_bill_hdr where OPERATING_FACILITY_ID=? and DOC_TYPE_CODE=? and DOC_NUM=?";
				
				pstmt = con.prepareStatement(qry_mpi_id);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patDocType);
				pstmt.setString(3,patDocNum);
				rs = pstmt.executeQuery();
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						mpiId  =  rs.getString(1);	
					
					}
				}
				pstmt.close();
				if(rs!=null) rs.close();
							
				cstmt= con.prepareCall("{ call bl_zatca_qr_request_check(?,?,?)}");
				cstmt.setString( 1,	mpiId );
				System.err.println("BillReceiptMessage.jsp,bl_zatca_qr_request_check mpiId===>"+mpiId);
				System.err.println("BillReceiptMessage.jsp,patDocType patDocNum ===>"+patDocType+"/"+patDocNum);
				System.err.println("BillReceiptMessage.jsp,billDocType ===>"+billDocType);
				System.err.println("BillReceiptMessage.jsp,billGenerated ===>"+billGenerated);
				cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				cstmt.execute();
				zatca_error_code=cstmt.getString(2);
				Zatca_msg=cstmt.getString(3);
				if(zatca_error_code==null) zatca_error_code="";
				if(Zatca_msg==null) Zatca_msg="";
				System.err.println("bl_zatca_qr_request_check zatca_error_code===>"+zatca_error_code);
				System.err.println("bl_zatca_qr_request_check process_msg===>"+Zatca_msg);
				System.err.println("orgBillRefNum ===>"+orgBillRefNum);
				
				cstmt1 = con.prepareCall("call BL_ZATCA_UPDATE_ORG_BILL_NUM(?,?)");//V220517
				cstmt1.setString( 1,	mpiId );
				cstmt1.setString( 2,	orgBillRefNum );
				cstmt1.execute();
				con.commit();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			if(cstmt!=null) cstmt.close();
			if(cstmt1!=null) cstmt1.close();
			if(con!=null) {
				ConnectionManager.returnConnection(con, request);
			}
		}
	}
//V221230 ends

//V221122
// Changes for E-Signature CRF 
String eSignatureFlag = BLReportIdMapper.eSignatureFlag(facilityId);
if(eSignatureFlag == null) eSignatureFlag = "N";
System.err.println("eSignatureFlag billgen->"+eSignatureFlag);		


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(exemptWarning));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(exemptConsWarning));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(billSlmtAmt));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(billExemptAmt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Pgmid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PgmDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Sessionid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(unProcessedYn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(billGenerated));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(billGenerated));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(unProcessedYn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(billGenerated));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(unProcessedYn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(billGenerated));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(billGenerated));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(slmtMsgId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slmtMsgId));
            _bw.write(_wl_block25Bytes, _wl_block25);

	request.setCharacterEncoding("UTF-8");	
	//System.out.println("error->"+error);
	if ( error != null ) {
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(error ));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
	error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		if ( error_value.equals( "1" ) ){
			System.err.println("error_value ->"+error_value);
			System.err.println("calledFrom ->"+calledFrom);
			String beanId = "BillReceiptExistOrderExclusion" ;
			String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
			BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
			exclusionBean.clearAll();

			if("billGeneration".equals(calledFrom)){ 
				session.setAttribute("billRecBillGenNum", null);
				try{
					con = ConnectionManager.getConnection();
					pstmt = con.prepareStatement("Select to_char(sysdate,'dd/mm/yyyy HH24:MI') bill_doc_date from dual");
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						billDocDate = rst.getString("bill_doc_date");
					}
					
				}
				catch(Exception e){
					System.err.println("Exception in getting Bill Doc Date ->"+e);
				}
				finally{
					ConnectionManager.returnConnection(con);
					pstmt = null;
					rst = null;
				}
			}
					
		}
			
	}


            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(billDocType ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(receiptDocType ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(refundDocType ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(blngGrpId ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(episodeType ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episodeId ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(visitId ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(billDocAmt ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(billSlmtAmt ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(billExemptAmt ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patDocType ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patDocNum ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(billDocDate ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(billPrintYn ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(invokeSlmt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(unProcessedYn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(error_value));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(eSignatureFlag));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Zatca_msg));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(zatca_error_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ZatcaYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
