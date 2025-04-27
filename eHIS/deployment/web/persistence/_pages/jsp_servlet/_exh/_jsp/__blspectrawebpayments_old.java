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

public final class __blspectrawebpayments_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/BLSpectraWebPayments_old.jsp", 1742455195697L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<HTML>\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n \n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<HEAD>\n\t<meta charset=\"utf-8\">\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\t<title> Spectra Payment </title>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" type=\"text/css\"/>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\"javascript\" src=\"../../eXH/js/spectra-ws.js\"></script>\n\t<script type=\"text/javascript\">\n\t\tfunction HealthIdCallBack(hids) {\n\t\n\t\t    var returnStr = \"\";\n\t\n\t\t    $(hids).each(function(idx, obj) {\n\t\t        $(\'.cnt-healthidcallback\').append(\'<p>ID: \' + obj + \'</p>\');\n\t\t        returnStr = obj;\n\t\t    });\n\t\n\t\t    parent.window.returnValue = returnStr;\n\t\t    TimeOutFn(\"Success\");\n\t\n\t\t};\n\t\n\t\tfunction ConnectionCallBack(response) {\n\t\t    response = JSON.stringify(JSON.parse(response));\n\t\t    if (response.IsConnected == \"True\") {\n\t\t        $(\'.cnt-connectioncallback\').append(\'<p class=\\\'text-success\\\'></p>Connection Status: \' + response.Status + \'</p>\');\n\t\t    } else {\n\t\t        $(\'.cnt-connectioncallback\').append(\'<p class=\\\'text-danger\\\'></p>Connection Status: \' + response.Status + \'</p>\');\n\t\t    }\n\t\n\t\t};\n\t\n\t\tfunction OnTerminalActionCallback(response) {\n\t\t    response = JSON.stringify(JSON.parse(response));\n\t\n\t\t    $(\'.cnt-terminalactioncallback\').append(\'<p class=\\\'text-danger\\\'></p>Terminal Action: \' + response.OptionalMessage + \'</p>\');\n\t\t}\n\t\n\t\tfunction PaymentResultCallback(pmtObj) {\n\t\n\t\t\tif(";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="){\t\n\t\t\t\talert(\"Document Mode in Payment Page : \"+document.documentMode);\n\t\t\t}\n\t\n\t\t    pmtObj = JSON.stringify(JSON.parse(pmtObj));\n\t\t    var jsonResult = pmtObj.JsonResult;\n\t\n\t\t      \n\t\t    if(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="){\t\n\t\t    \talert(\"Inside Payment Result Callback - JSON Result - \" + jsonResult);\n\t\t\t}\n\t\n\t\t    var waitime = document.getElementById(\"waittime\").value.trim();\n\t\n\t\t    waitime = Number(waitime) * 1000;\n\t\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Message received successfully...</p></h5>\');\n\t\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>PatientId: \' + $(\"#slmtpatientId\").val().trim() + \'</p>\');\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>ProcessingReference: \' + jsonResult.TransactionResponseEnglish + \'</p>\');\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>TransactionId: \' + jsonResult.ECRReferenceNumber + \'</p>\');\n\t\t    $(\'.cnt-notifypmtcallback\').append(\'<p>Result Code: \' + jsonResult.TransactionAuthCode + \'</p>\');\n\t\n\t\t    var returnStr = \"\";\n\t\t    var resultFlag = \"\";\n\t\n\t\t    var d = new Date();\n\t\t    var datestring = \"\";\n\t\n\t\t    var processStatus = \"F\";\n\t\t    var processRemarks = \"Internal Error\";\n\t\t    var ErrorMessage = \"\";\n\t\t    var payerName = \"\";\n\t\t    var saleDraftNo = \"\";\n\t\t    var rrn = \"\";\n\t\t    var approvalCode = \"\";\n\t\t    var cardType = \"\";\n\t\t    var cardNumber = \"\";\n\t\t    var cardExpDate = \"\";\n\t\t    var batchNumber = \"\";\n\t\t    var txnDate = \"\";\n\t\t    var txnTime = \"\";\n\t\t    var cardIssuedBank = \"\";\n\t\t    var trackingID = \"\";\n\t\t    var terminalID = \"\";\n\t\n\t\t    if (pmtObj.EventName == \"TERMINAL_RESPONSE\") {\n\t\t        if (jsonResult.TransactionResponseEnglish == \"APPROVED\") {\n\t\t            resultFlag = \"Success\";\n\t\t            processStatus = \"S\";\n\t\n\t\t            processRemarks = jsonResult.TransactionResponseEnglish;\n\t\t            saleDraftNo = jsonResult.ECRReferenceNumber;\n\t\t            rrn = jsonResult.RetrievalReferenceNumber;\n\t\t            approvalCode = jsonResult.TransactionAuthCode;\n\t\t            cardType = jsonResult.CardScheme;\n\t\t            cardNumber = jsonResult.PrimaryAccountNumber;\n\t\t            batchNumber = jsonResult.CardAcceptorIdCode;\n\t\n\t\t            txnDate = (\'0\' + d.getDate()).slice(-2) + \'/\' +\n\t\t                (\'0\' + (d.getMonth() + 1)).slice(-2) + \'/\' +\n\t\t                d.getFullYear();\n\t\t            txnTime = (\'0\' + d.getHours()).slice(-2) + \"\" + (\'0\' + d.getMinutes()).slice(-2) + \"\" + (\'0\' + d.getSeconds()).slice(-2);\n\t\n\t\t            terminalID = jsonResult.CardAcceptorTerminalId;\n\t\n\t\t        } else {\n\t\t            resultFlag = \"Failed\";\n\t\t            processStatus = \"F\";\n\t\t            processRemarks = jsonResult.TransactionResponseEnglish;\n\t\n\t\t        }\n\t\t    }\n\t\t    //response =approvedPurchaseResultCode+\"$|#\"+approvedPurchaseResult+\" \"+responseDescription+\"$|#$|#\"\n\t\t    //+ \"$|#\"+merchantID+\"$|#\"+rrn+\"$|#\"+authResponse+\"$|#\"+cardType+\"$|#\"\n\t\t    //+ cardNumber+\"$|#$|#\"+traceNumber+\"$|#\"+dateTime1+\"$|#$|#\"\n\t\t    //+ \"$|#$|#$|#\"+terminalID\n\t\t    returnStr = processStatus + \"$|#\" + processRemarks + \"$|#\" + ErrorMessage + \"$|#\" + payerName + \"$|#\" + saleDraftNo + \"$|#\" + rrn + \"$|#\" + approvalCode + \"$|#\" + cardType + \"$|#\" + cardNumber + \"$|#\" + cardExpDate + \"$|#\" + batchNumber + \"$|#\" + txnDate + \"$|#\" + txnTime + \"$|#$|#\" + cardIssuedBank + \"$|#\" + trackingID + \"$|#\" + terminalID;\n\t\n\t\t    parent.window.returnValue = returnStr;\n\t\t    TimeOutFn(resultFlag);\n\t\t};\n\t\n\t\tfunction TimeOutFn(status) {\n\t\n\t\t    var waitime = document.getElementById(\"waittime\").value.trim();\n\t\t    \n\t\t    if(";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="){\t\n\t\t    \talert(\"Inside Time out Function \" + waitime);\n\t\t\t}\n\t\t    //waitime = 10;\n\t\n\t\t    waitime = Number(waitime) * 1000;\n\t\n\t\t    var countDownDate = new Date().getTime();\n\t\n\t\t    countDownDate = countDownDate + waitime;\n\t\n\t\t    // Update the count down every 1 second\n\t\t    var x = setInterval(function() {\n\t\n\t\t        // Get today\'s date and time\n\t\t        var now = new Date().getTime();\n\t\n\t\t        // Find the distance between now and the count down date\n\t\t        var distance = countDownDate - now;\n\t\n\t\t        // Time calculations for days, hours, minutes and seconds\n\t\t        var days = Math.floor(distance / (1000 * 60 * 60 * 24));\n\t\t        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));\n\t\t        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\n\t\t        var seconds = Math.floor((distance % (1000 * 60)) / 1000);\n\t\t        var statusMessage = \"\";\n\t\t        if (status == \"Success\") {\n\t\t            statusMessage = \"transaction is successful\";\n\t\t        } else {\n\t\t            statusMessage = \"transaction is in progress\";\n\t\t        }\n\t\t        // Output the result in an element with id=\"demo\"\n\t\t        document.getElementById(\"demo\").innerHTML = \"Kindly wait... \" + statusMessage + \" and this window will close in \" + seconds + \"s \";\n\t\n\t\t        // If the count down is over, write some text \n\t\t        if (distance < 0) {\n\t\t            clearInterval(x);\n\t\t            document.getElementById(\"demo\").innerHTML = \"EXPIRED\";\n\t\t            parent.window.close();\n\t\t        }\n\t\t    }, 1000);\n\t\n\t\t};\n\t\n\t\tfunction ErrorCallback(error) {\n\t\n\t\t    if(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="){\t\n\t\t    \talert(\"Inside Error Callback \" + error);\n\t\t\t}\n\t\n\t\t    $(\'.cnt-errorcallback\').append(\'<p>\' + error + \'</p>\');\n\t\n\t\t    var slmtidno = \"\"; //document.getElementById(\"slmtidno\").value.trim();\n\t\n\t\t    var returnStr = \"\";\n\t\t    var resultFlag = \"\";\n\t\n\t\t    var datestring = \"\";\n\t\n\t\t    resultFlag = \"ERROR\";\n\t\t    datestring = \"\";\n\t\t    returnStr = \"F$|#\" + resultFlag + \"$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#$|#\";\n\t\t    parent.window.returnValue = returnStr;\n\t\t    TimeOutFn(resultFlag);\n\t\t};\n\t\n\t\tfunction RequestPaymentAckCallback(obj) {\n\t\t    \n\t\t    if(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="){\t\n\t\t    \talert(\"Inside Payment AckCallback \" + JSON.stringify(obj));\n\t\t\t}\n\t\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Payment Acknowledgement Received By the Server...</p></h5>\');\n\t\n\t\t    $(\'.cnt-custinfoackcallback\').append(\'<p>Payment Acknowledgement Received By the Server</p>\');\n\t\t    $(\'.cnt-custinfoackcallback\').append(\'<p>Response Code: \' + obj.JsonResult + \'</p>\');\n\t\t    /*\n\t\t    $(\'.cnt-custinfoackcallback\').append(\'<p>PatientId: \' + obj.PatientId + \'</p>\');\n\t\t    $(\'.cnt-custinfoackcallback\').append(\'<p>TransactionId: \' + obj.TransactionId + \'</p>\');\n\t\t    */\n\t\t};\n\t\n\t\tfunction getCOMConnect() {\t\t\t\n\t\t    \n\t\t    SpectraClient.sendRequest({\n\t\t        Event: \"CONNECTION\",\n\t\t        Operation: \"CONNECT\",\n\t\t        connectionMode: \"COM\",\n\t\t        comName: $(\"#comPort\").val().trim(),\n\t\t        braudRate: $(\"#braudRate\").val().trim(),\n\t\t        dataBits: \"8\",\n\t\t        parity: \"none\",\n\t\t    });\n\t\t    \n\t\t\t//SpectraClient.sendRequest(jsonData);\n\t\t}\n\t\n\t\tfunction sendPaymentRequest() {\n\t\n\t\t\tif(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="){\t\n\t\t    \talert(\"Sending Payment Request...\");\n\t\t\t}\n\t\n\t\t    //$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>WebSocket Connected</p></h5>\');\n\t\n\t\t    //Generating 16 random number ecr reference\n\t\t    document.getElementById(\"ecrnumber\").value = (Math.random() + \' \').substring(2, 10) + (Math.random() + \' \').substring(2, 10);\n\t\n\t\t    var slmtidno = \"\";\n\t\n\t\t    //SpectraClient.RequestPayment(jsonData);\n\t\t\tSpectraClient.sendRequest({\n\t\t        Event: \"TRANSACTION\",\n\t\t        Operation: \"PURCHASE\",\n\t\t        Amount: $(\"#slmtbillamount\").val().trim(),\n\t\t        PrintSettings: $(\"#printSettings\").val().trim(),\n\t\t        AppId: \"11\",\n\t\t        ECRNumber: $(\"#ecrnumber\").val().trim()\n\t\t    });\n\t\n\t\t    if(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="){\t\n\t\t    \talert(\"request_jsonData::\" + jsonData);\n\t\t\t}\n\t\n\t\t    SpectraClient.RequestPayment(jsonData);\n\t\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Payment request successfully made</p></h5>\');\n\t\n\t\t    $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:blue\"><p>Kindly swipe/insert the card in the card reader machine </p></h5>\');\n\t\n\t\t    var returnStr = \"\";\n\t\t    var resultFlag = \"\";\n\t\n\t\t    var datestring = \"\";\n\t\n\t\t    resultFlag = \"ERROR\";\n\t\t    datestring = \"\";\n\t\t    returnStr = resultFlag + \"$!^\" + resultFlag + \"$!^Transaction Failed$!^\" + \"ERROR\" + \"$!^\" + slmtidno + \"$!^\" + datestring;\n\t\t    parent.window.returnValue = returnStr;\n\t\t    TimeOutFn(resultFlag);\n\t\n\t\t}\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<body>\n\t<form>\n\t    <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t        <tr>\n\t            <td width=\"20%\" class=\"fields\">\n\t                <p class=\"call-back\">Payment Details</p>\n\t            </td>\n\t            <td width=\"20%\" class=\"fields\">\n\t                <p class=\"call-back\">Receive HealthID Callback</p>\n\t            </td>\n\t            <td width=\"20%\" class=\"fields\">\n\t                <p class=\"call-back\">Request Payment Ack Callback</p>\n\t            </td>\n\t            <td width=\"25%\" class=\"fields\">\n\t                <p class=\"call-back\">Payment Result Callback</p>\n\t            </td>\n\t            <td width=\"15%\" class=\"fields\">\n\t                <p class=\"call-back\">Error Callback</p>\n\t            </td>\n\t        </tr>\n\t        <tr>\n\t            <td width=\"20%\" class=\"label\">\n\t                <p>Patient ID : ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t                </p>\n\t                <p>Payable Amount : ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t                </p>\n\t            </td>\n\t            <td width=\"20%\" class=\"label\">\n\t                <p class=\'cnt-healthidcallback text-success\'></p>\n\t            </td>\n\t            <td width=\"20%\" class=\"label\">\n\t                <p class=\'cnt-connectioncallback\'></p>\n\t            </td>\n\t            <td width=\"20%\" class=\"label\">\n\t                <p class=\'cnt-terminalactioncallback\'></p>\n\t            </td>\n\t            <td width=\"20%\" class=\"label\">\n\t                <p class=\'cnt-custinfoackcallback text-success\'></p>\n\t            </td>\n\t            <td width=\"25%\" class=\"label\">\n\t                <p class=\'cnt-notifypmtcallback text-success\'></p>\n\t            </td>\n\t            <td width=\"15%\" class=\"label\">\n\t                <p class=\'cnt-errorcallback text-danger\'></p>\n\t            </td>\n\t        </tr>\n\t    </table>\n\t    <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\t        <tr>\n\t            <td>\n\t                <p class=\"cnt-statuscallback text-success\">Transaction Status</p>\n\t            </td>\n\t        </tr>\n\t        <tr>\n\t            <td>\n\t                <p id=\"demo\">Kindly wait... transaction in progress and this window will close automatically...</p>\n\t            </td>\n\t        </tr>\n\t    </table> \n\t    <input type=hidden id=\'slmtpatientId\' name=\'slmtpatientId\' id=\'slmtpatientId\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> \n\t    <input type=hidden id=\'slmtbillamount\' name=\'slmtbillamount\' id=\'slmtbillamount\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"> \n\t    <input type=hidden id=\'requesttype\' name=\'requesttype\' id=\'requesttype\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"> \n\t    <input type=hidden id=\'waittime\' name=\'waittime\' id=\'waittime\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t    <input type=hidden id=\'websocketurl\' name=\'websocketurl\' id=\'websocketurl\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> \n\t    <input type=hidden id=\'isDebugYN\' name=\'isDebugYN\' id=\'isDebugYN\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> \n\t    <input type=hidden id=\'comPort\' name=\'comPort\' id=\'comPort\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"> \n\t    <input type=hidden id=\'braudRate\' name=\'braudRate\' id=\'braudRate\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> \n\t    <input type=hidden id=\'printSettings\' name=\'printSettings\' id=\'printSettings\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> \n\t    <input type=hidden id=\'ecrnumber\' name=\'ecrnumber\' id=\'ecrnumber\' value=\"\">\n\t</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
	
	     if (isDebugYN)
	         System.err.println("***Inside BLSpectraWebPayments - Patient Id... " + strslmtpatientId + " *** Settlement Bill Amount... " + strslmtbillamount + " *** Request Type... " + strrequesttype + " *** Wait Time... " + strwaitime + " *** Websocket url... " + strwebsocketurl + " *** COM Port... " + strcomPort + " *** Boudrate... " + strboudRate);
	
	 } catch (Exception e) {
	     out.println("Exception while fetching Debug YN :" + e);
	 }
 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strrequesttype));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strwaitime));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strwebsocketurl));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strcomPort));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strboudRate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strprintSettings));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
