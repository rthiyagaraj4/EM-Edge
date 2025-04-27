package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Enumeration;
import java.io.*;
import eXH.*;

public final class __blspectrawebpayments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/BLSpectraWebPayments.jsp", 1742454990238L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<HTML>\t\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \r\n \r\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<HEAD>\r\n\t<meta charset=\"utf-8\">\r\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"utf-8\">\r\n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n\t<title> Spectra Payment </title>\r\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" type=\"text/css\"/>\r\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\r\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\r\n\t<script language=\"javascript\" src=\"../../eXH/js/spectra-ws.js\"></script>\r\n\t\r\n\t<script type=\"text/javascript\">\r\n\t\t/*function HealthIdCallBack(hids) {\r\n\t\r\n\t\t    var returnStr = \"\";\r\n\t\r\n\t\t    $(hids).each(function(idx, obj) {\r\n\t\t        $(\'.cnt-healthidcallback\').append(\'<p>ID: \' + obj + \'</p>\');\r\n\t\t        returnStr = obj;\r\n\t\t    });\r\n\t\r\n\t\t    parent.window.returnValue = returnStr;\r\n\t\t    TimeOutFn(\"Success\");\r\n\t\r\n\t\t};*/\r\n\t\r\n\t\tfunction ConnectionCallBack(response) {\r\n\t\t\t\r\n\t\t\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\r\n\t\t    \talert(\"Connection Callback Response... \"+JSON.stringify(response));\r\n\t\t\t}\r\n\t\t    \r\n\t\t    if (response.IsConnected == \"True\") {\r\n\t\t        $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>\'+response.Status+\'</p></h5>\');\r\n\t\t    } else {\r\n\t\t        $(\'.cnt-statuscallback\').append(\'<p class=\\\'text-danger\\\'></p>Connection Status: \' + response.Status + \'</p>\');\r\n\t\t    }\r\n\t\r\n\t\t};\r\n\t\r\n\t\tfunction OnTerminalActionCallback(response) {\r\n\t\t\t\r\n\t\t\tresponse = JSON.parse(response);\r\n\t\r\n\t\t    $(\'.cnt-terminalactioncallback\').append(\'<p class=\\\'text-danger\\\'></p>\' + response.OptionalMessage + \'</p>\');\r\n\t\t}\r\n\t\r\n\t\tfunction PaymentResultCallback(pmtObj) {\r\n\t\r\n\t\t\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\r\n\t\t\t\talert(\"Document Mode in Payment Page : \"+document.documentMode);\r\n\t\t    \talert(\"Inside Payment Result Callback - Payment Object - \" + JSON.stringify(pmtObj));\r\n\t\t\t}\r\n\t\r\n\t\t    var jsonResult = JSON.parse(pmtObj.JsonResult);\t      \r\n\t\t    \r\n\t\r\n\t\t    var waitime = document.getElementById(\"waittime\").value.trim();\r\n\t\r\n\t\t    waitime = Number(waitime) * 1000;\r\n\t\r\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Message received successfully...</p></h5>\');\r\n\t\r\n\t\t    //$(\'.cnt-notifypmtcallback\').append(\'<p>PatientId: \' + $(\"#slmtpatientId\").val().trim() + \'</p>\');\r\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>Response: \' + jsonResult.TransactionResponseEnglish + \'</p>\');\r\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>Reference Number: \' + jsonResult.ECRReferenceNumber + \'</p>\');\r\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>RRN: \' + jsonResult.RetrievalReferenceNumber + \'</p>\');\r\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>Approval Code: \' + jsonResult.TransactionAuthCode + \'</p>\');\r\n\t\r\n\t\t    var returnStr = \"\";\r\n\t\t    var resultFlag = \"\";\r\n\t\r\n\t\t    var d = new Date();\r\n\t\t    var datestring = \"\";\r\n\t\r\n\t\t    var processStatus = \"F\";\r\n\t\t    var processRemarks = \"Internal Error\";\r\n\t\t    var ErrorMessage = \"\";\r\n\t\t    var payerName = \"\";\r\n\t\t    var saleDraftNo = \"\";\r\n\t\t    var rrn = \"\";\r\n\t\t    var approvalCode = \"\";\r\n\t\t    var cardType = \"\";\r\n\t\t    var cardNumber = \"\";\r\n\t\t    var cardExpDate = \"\";\r\n\t\t    var batchNumber = \"\";\r\n\t\t    var txnDate = \"\";\r\n\t\t    var txnTime = \"\";\r\n\t\t    var cardIssuedBank = \"\";\r\n\t\t    var trackingID = \"\";\r\n\t\t    var terminalID = \"\";\r\n\t\r\n\t\t    if (pmtObj.EventName == \"TERMINAL_RESPONSE\") {\r\n\t\t        if (jsonResult.TransactionResponseEnglish == \"APPROVED\") {\r\n\t\t            resultFlag = \"Success\";\r\n\t\t            processStatus = \"S\";\r\n\t\r\n\t\t            processRemarks = jsonResult.TransactionResponseEnglish;\r\n\t\t            saleDraftNo = jsonResult.ECRReferenceNumber;\r\n\t\t            rrn = jsonResult.RetrievalReferenceNumber;\r\n\t\t            approvalCode = jsonResult.TransactionAuthCode;\r\n\t\t            cardType = jsonResult.CardScheme;\r\n\t\t            cardNumber = jsonResult.PrimaryAccountNumber;\r\n\t\t            batchNumber = jsonResult.TransactionSTAN;\r\n\t\r\n\t\t            txnDate = (\'0\' + d.getDate()).slice(-2) + \'/\' +\r\n\t\t                (\'0\' + (d.getMonth() + 1)).slice(-2) + \'/\' +\r\n\t\t                d.getFullYear();\r\n\t\t            txnTime = (\'0\' + d.getHours()).slice(-2) + \"\" + (\'0\' + d.getMinutes()).slice(-2) + \"\" + (\'0\' + d.getSeconds()).slice(-2);\r\n\t\r\n\t\t            terminalID = jsonResult.CardAcceptorTerminalId;\r\n\t\r\n\t\t        } else {\r\n\t\t            resultFlag = \"Failed\";\r\n\t\t            processStatus = \"E\";\r\n\t\t            processRemarks = jsonResult.TransactionResponseEnglish;\r\n\t\r\n\t\t        }\r\n\t\t    }\r\n\t\t    //response =approvedPurchaseResultCode+\"$|#\"+approvedPurchaseResult+\" \"+responseDescription+\"$|#$|#\"\r\n\t\t    //+ \"$|#\"+merchantID+\"$|#\"+rrn+\"$|#\"+authResponse+\"$|#\"+cardType+\"$|#\"\r\n\t\t    //+ cardNumber+\"$|#$|#\"+traceNumber+\"$|#\"+dateTime1+\"$|#$|#\"\r\n\t\t    //+ \"$|#$|#$|#\"+terminalID\r\n\t\t    returnStr = processStatus + \"$|#\" + processRemarks + \"$|#\" + ErrorMessage + \"$|#\" + payerName + \"$|#\" + saleDraftNo + \"$|#\" + rrn + \"$|#\" + approvalCode + \"$|#\" + cardType + \"$|#\" + cardNumber + \"$|#\" + cardExpDate + \"$|#\" + batchNumber + \"$|#\" + txnDate + \"$|#\" + txnTime + \"$|#$|#\" + cardIssuedBank + \"$|#\" + trackingID + \"$|#\" + terminalID;\r\n\t\r\n\t\t    parent.window.returnValue = returnStr;\r\n\t\t    TimeOutFn(resultFlag);\r\n\t\t};\r\n\t\r\n\t\tvar x;\r\n\t\tfunction TimeOutFn(status) {\r\n\t\r\n\t\t    var waitime = document.getElementById(\"waittime\").value.trim();\r\n\t\t    \r\n\t\t    if (status == \"Success\") {\r\n\t\t\t\tclearInterval(x);\r\n\t\t\t\twaitime = 5;\r\n\t\t    }\r\n\t\r\n\t\t    waitime = Number(waitime) * 1000;\r\n\t\r\n\t\t    var countDownDate = new Date().getTime() + waitime * 1000;\r\n\t\r\n\t\t    countDownDate = countDownDate + waitime;\r\n\t\r\n\t\t    // Update the count down every 1 second\r\n\t\t    x = setInterval(function() {\r\n\t\r\n\t\t        // Get today\'s date and time\r\n\t\t        var now = new Date().getTime();\r\n\t\r\n\t\t        // Find the distance between now and the count down date\r\n\t\t        var distance = countDownDate - now;\r\n\t\r\n\t\t        // Time calculations for days, hours, minutes and seconds\r\n\t\t        var days = Math.floor(distance / (1000 * 60 * 60 * 24));\r\n\t\t        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));\r\n\t\t        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\r\n\t\t        var seconds = Math.floor((distance % (1000 * 60)) / 1000);\r\n\t\t        var statusMessage = \"\";\r\n\t\t        if (status == \"Success\") {\r\n\t\t            statusMessage = \"transaction is successful\";\r\n\t\t        } else {\r\n\t\t            statusMessage = \"transaction is in progress\";\r\n\t\t        }\r\n\t\t\t\t\r\n\t\t        // Output the result in an element with id=\"demo\"\r\n\t\t        document.getElementById(\"demo\").innerHTML = \"Kindly wait... \" + statusMessage + \" and this window will close in \" + seconds + \"s \";\r\n\t\r\n\t\t        // If the count down is over, write some text \r\n\t\t        if (distance < 0) {\r\n\t\t            clearInterval(x);\r\n\t\t            document.getElementById(\"demo\").innerHTML = \"EXPIRED\";\r\n\t\t            parent.window.close();\r\n\t\t        }\r\n\t\t    }, 1000);\r\n\t\r\n\t\t};\r\n\r\n\t\r\n\t\tfunction ErrorCallback(error) {\r\n\t\r\n\t\t    var isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\t\r\n\t\t    \talert(\"Inside Error Callback \" + error);\r\n\t\t\t}\r\n\t\r\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:red\"><p>\'+error+\'</p></h5>\');\r\n\t\r\n\t\t    var slmtidno = \"\"; //document.getElementById(\"slmtidno\").value.trim();\r\n\t\r\n\t\t    var returnStr = \"\";\r\n\t\t    var resultFlag = \"\";\r\n\t\r\n\t\t    var datestring = \"\";\r\n\t\r\n\t\t    resultFlag = \"ERROR\";\r\n\t\t    datestring = \"\";\r\n\t\t    returnStr = \"E$|#Error. \" + error + \"$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#\";\r\n\t\t    parent.window.returnValue = returnStr;\r\n\t\t    TimeOutFn(resultFlag);\r\n\t\t};\r\n\t\r\n\t\tfunction RequestPaymentAckCallback(obj) {\r\n\t\t    \r\n\t\t    var isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\r\n\t\t    \talert(\"Inside Payment AckCallback \" + JSON.stringify(obj));\r\n\t\t\t}\r\n\r\n\t\t\tvar jsonResult = JSON.parse(obj.JsonResult);\r\n\t\t\t\r\n\t\t\tif(!document.getElementById(\"ackRes\")){\r\n\t\t\t\t$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p id=\"ackRes\">Payment Acknowledgement Received By the Server...</p></h5>\');\r\n\t\t\t}\r\n\t\t\t\r\n\t\t    $(\'.cnt-custinfoackcallback\').append(\'<p>\' + jsonResult.Status + \'</p>\');\r\n\t\t};\r\n\t\r\n\t\tfunction getCOMConnect() {\t\r\n\t\t\t\r\n\t\t\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\r\n\t\t    \talert(\"Before Connecting COM PORT... \"+document.documentMode);\r\n\t\t\t}\r\n\t\t    \r\n\t\t    SpectraClient.sendRequest({\r\n\t\t        Event: \"CONNECTION\",\r\n\t\t        Operation: \"CONNECT\",\r\n\t\t        connectionMode: \"COM\",\r\n\t\t        comName: $(\"#comPort\").val().trim(),\r\n\t\t        braudRate: $(\"#braudRate\").val().trim(),\r\n\t\t        dataBits: \"8\",\r\n\t\t        parity: \"none\",\r\n\t\t    });\r\n\t\t    \r\n\t\t\t//SpectraClient.sendRequest(jsonData);\r\n\t\t}\r\n\t\r\n\t\tfunction sendPaymentRequest() {\r\n\t\t\t\r\n\t\t\r\n\t\t\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\r\n\t\t\t\r\n\t\t\tif(isDebugYN==\"true\"){\r\n\t\t    \talert(\"Sending Payment Request...\");\r\n\t\t\t}\r\n\t\r\n\t\t    //$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>WebSocket Connected</p></h5>\');\r\n\t\r\n\t\t    //Generating 16 random number ecr reference\r\n\t\t    document.getElementById(\"ecrnumber\").value = (Math.random() + \' \').substring(2, 10) + (Math.random() + \' \').substring(2, 10);\r\n\t\r\n\t\t    var slmtidno = \"\";\r\n\t\r\n\t\t    //SpectraClient.RequestPayment(jsonData);\r\n\t\t\tSpectraClient.sendRequest({\r\n\t\t        Event: \"TRANSACTION\",\r\n\t\t        Operation: \"PURCHASE\",\r\n\t\t        Amount: $(\"#slmtbillamount\").val().trim(),\r\n\t\t        PrintSettings: $(\"#printSettings\").val().trim(),\r\n\t\t        AppId: \"11\",\r\n\t\t        ECRNumber: $(\"#ecrnumber\").val().trim()\r\n\t\t    });\r\n\t\r\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Payment request successfully made</p></h5>\');\r\n\t\r\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:blue\"><p>Kindly swipe/insert the card in the card reader machine </p></h5>\');\r\n\t\r\n\t\t    var returnStr = \"\";\r\n\t\t    var resultFlag = \"\";\r\n\t\r\n\t\t    var datestring = \"\";\r\n\t\r\n\t\t    resultFlag = \"ERROR\";\r\n\t\t    datestring = \"\";\r\n\t\t    returnStr = \"E$!^Error. \" + resultFlag + \"$!^Transaction Failed$!^ERROR$!^\" + slmtidno + \"$!^\" + datestring;\r\n\t\t    parent.window.returnValue = returnStr;\r\n\t\t    TimeOutFn(resultFlag);\r\n\t\r\n\t\t}\r\n\t</script>\r\n\t<style>\r\n\t\ttd {\r\n\t\t\tvertical-align: top;\r\n\t\t}\r\n\t\t.call-back{\r\n\t\t\tfont-weight: bold;\r\n\t\t}\r\n\t</style>\r\n</HEAD>\r\n<body>\r\n\t<form>\r\n\t    <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\r\n\t        <tr>\r\n\t            <td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Payment Details</p>\r\n\t            </td>\r\n\t\t    <!--<td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Health Id Callback</p>\r\n\t            </td>\r\n\t            <td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Connection Callback</p>\r\n\t            </td>-->\r\n\t            <td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Terminal Action Callback</p>\r\n\t            </td>\r\n\t            <td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Request Payment Ack Callback</p>\r\n\t            </td>\r\n\t            <td width=\"25%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Payment Result Callback</p>\r\n\t            </td>\r\n\t\t    <!--<td width=\"20%\" class=\"fields\">\r\n\t                <p class=\"call-back\">Error Callback</p>\r\n\t            </td>-->\r\n\t        </tr>\r\n\t        <tr>\r\n\t            <td width=\"20%\" class=\"label\">\r\n\t                <p>Patient ID : ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t                </p>\r\n\t                <p>Payable Amount : ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t                </p>\r\n\t            </td>\r\n\t            <!--<td width=\"20%\" class=\"label\">\r\n\t                <p class=\'cnt-healthidcallback text-success\'></p>\r\n\t            </td>\r\n\t            <td width=\"20%\" class=\"label\">\r\n\t                <p class=\'cnt-connectioncallback\'></p>\r\n\t            </td>-->\r\n\t            <td width=\"20%\" class=\"label\">\r\n\t                <p class=\'cnt-terminalactioncallback\'></p>\r\n\t            </td>\r\n\t            <td width=\"20%\" class=\"label\">\r\n\t                <p class=\'cnt-custinfoackcallback text-success\'></p>\r\n\t            </td>\r\n\t            <td width=\"25%\" class=\"label\">\r\n\t                <p class=\'cnt-notifypmtcallback text-success\'></p>\r\n\t            </td>\r\n\t            <!--<td width=\"15%\" class=\"label\">\r\n\t                <p class=\'cnt-errorcallback text-danger\'></p>\r\n\t            </td>-->\r\n\t        </tr>\r\n\t    </table>\r\n\t    <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\r\n\t        <tr>\r\n\t            <td>\r\n\t                <p class=\"cnt-statuscallback text-success\">Transaction Status</p>\r\n\t            </td>\r\n\t        </tr>\r\n\t        <tr>\r\n\t            <td>\r\n\t                <p id=\"demo\">Kindly wait... transaction in progress and this window will close automatically...</p>\r\n\t            </td>\r\n\t        </tr>\r\n\t    </table> \r\n\t    <input type=hidden id=\'slmtpatientId\' name=\'slmtpatientId\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> \r\n\t    <input type=hidden id=\'slmtbillamount\' name=\'slmtbillamount\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> \r\n\t    <input type=hidden id=\'requesttype\' name=\'requesttype\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> \r\n\t    <input type=hidden id=\'waittime\' name=\'waittime\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> \r\n\t    <input type=hidden id=\'websocketurl\' name=\'websocketurl\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> \r\n\t    <input type=hidden id=\'isDebugYN\' name=\'isDebugYN\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"> \r\n\t    <input type=hidden id=\'comPort\' name=\'comPort\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"> \r\n\t    <input type=hidden id=\'braudRate\' name=\'braudRate\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> \r\n\t    <input type=hidden id=\'printSettings\' name=\'printSettings\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"> \r\n\t    <input type=hidden id=\'ecrnumber\' name=\'ecrnumber\' value=\"\">\r\n\t</form>\r\n</body>\r\n</HTML>\r\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");   
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)
	       ||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session
			.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);	

 
            _bw.write(_wl_block3Bytes, _wl_block3);

	 String strloggeduser = "";
	 String strslmtpatientId = request.getParameter("Patient_id") == null ? "" : request.getParameter("Patient_id");
	 String strslmtbillamount = request.getParameter("Amount") == null ? "" : request.getParameter("Amount");
	 String strrequesttype = request.getParameter("Request_type") == null ? "" : request.getParameter("Request_type");
	 String strwaitime = request.getParameter("WaitTime") == null ? "5" : request.getParameter("WaitTime");
	 String strwebsocketurl = request.getParameter("Ws_url") == null ? "ws://localhost:5000/messages" : request.getParameter("Ws_url");
	 String strcomPort = request.getParameter("Machine_port") == null ? "COM3" : request.getParameter("Machine_port");
	 String strboudRate = request.getParameter("BoudRate") == null ? "38400" : request.getParameter("BoudRate");
	 String strprintSettings = request.getParameter("Print_settings") == null ? "0" : request.getParameter("Print_settings");
	
	 boolean isDebugYN = false;
	
	 try {
	     isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
	
	     if (isDebugYN) {
	         System.err.println("***Inside BLSpectraWebPayments - Patient Id... " + strslmtpatientId + " *** Settlement Bill Amount... " + strslmtbillamount + " *** Request Type... " + strrequesttype + " *** Wait Time... " + strwaitime + " *** Websocket url... " + strwebsocketurl + " *** COM Port... " + strcomPort + " *** Boudrate... " + strboudRate);
		 }
	
	 } catch (Exception e) {
	     out.println("Exception while fetching Debug YN :" + e);
	 }
 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strrequesttype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strwaitime));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strwebsocketurl));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strcomPort));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strboudRate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strprintSettings));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
