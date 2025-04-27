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

public final class __blpayskypayments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/BLPaySkyPayments.jsp", 1709122304726L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<HEAD>\n\t<meta charset=\"utf-8\">\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\t<title> PaySky Payment </title>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" type=\"text/css\"/>\n\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\"javascript\" src=\"../../eXH/js/ps-uha-1.2.js\"></script>\n\t<script Language=\"JavaScript\">\t\t\t\t\n\n\t\tfunction HealthIdCallBack(hids) {\n\t\t\t\n\t\t\tvar returnStr = \"\";\n\t\t\t\n\t\t\t$(hids).each(function (idx, obj) {\n\t\t\t\t$(\'.cnt-healthidcallback\').append(\'<p>ID: \' + obj + \'</p>\');\t\t\t\t\n\t\t\t\treturnStr = obj;\t\t\t\t\n\t\t\t});\t\t\n\t\t\t\n\t\t\tparent.window.returnValue = returnStr;\n\t\t\tTimeOutFn(\"SUCCESS\");\t\t\t\n\t\t\t \n         };\n\n        function PaymentResultCallback(pmtObj) {        \t\n        \t\n        \tvar waitime = document.getElementById(\"waittime\").value.trim();\n        \t\n        \twaitime = Number(waitime) * 1000;\n\n\t\t\t$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Message received successfully...</p></h5>\');\n\n\t\t\t$(\'.cnt-notifypmtcallback\').append(\'<p>PatientId: \' + pmtObj.PatientId + \'</p>\');\n            $(\'.cnt-notifypmtcallback\').append(\'<p>ProcessingReference: \' + pmtObj.ProcessingReference + \'</p>\');\n            $(\'.cnt-notifypmtcallback\').append(\'<p>TransactionId: \' + pmtObj.TransactionId + \'</p>\');\n            $(\'.cnt-notifypmtcallback\').append(\'<p>Result Code: \' + pmtObj.Result + \'</p>\');\n\t\t\t\n\t\t\tvar returnStr = \"\";\n\t\t\tvar resultFlag = \"\";\n\n\t\t\tvar d = new Date();\n\t\t\tvar datestring = \"\";\n\t\t\t\n\t\t\tvar isDebugYN = document.getElementById(\"isDebugYN\").value.trim();\n\t\t\tif (isDebugYN == \"true\")\n\t\t\t\talert(\"Inside Payment Result Callback - \"+pmtObj.Result);\n\n\t\t\tif (pmtObj.Result == 1)\n\t\t\t{\n\t\t\t\tresultFlag = \"SUCCESS\";\n\t\t\t\t//Commented by Sethu for MOHE-SCF-0179 on 21/04/2022\n\t\t\t\t//datestring = d.getDate()  + \"-\" + (d.getMonth()+1) + \"-\" + d.getFullYear() + \" \" +d.getHours() + \":\" + d.getMinutes();\n\t\t\t\tdatestring = d.getDate()  + \"-\" + (d.getMonth()+1) + \"-\" + d.getFullYear();\n\t\t\t\treturnStr = resultFlag+\"$!^\"+resultFlag+\"$!^$!^\"+pmtObj.ProcessingReference+\"$!^\"+pmtObj.TransactionId+\"$!^\"+datestring;\n\t\t\t\tparent.window.returnValue = returnStr;\n\t\t\t\tTimeOutFn(resultFlag);\t\t\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\t\tresultFlag = \"FAILED\";\n\t\t\t\tdatestring = \"\";\n\t\t\t\treturnStr = resultFlag+\"$!^\"+resultFlag+\"$!^Transaction Failed$!^\"+\"\"+\"$!^\"+pmtObj.TransactionId+\"$!^\"+datestring;\n\t\t\t\tparent.window.returnValue = returnStr;\n\t\t\t\tTimeOutFn(resultFlag);\t\t\t\n\t\t\t}\t\t\t\n         };\n         \n         function TimeOutFn(status) {\n         \t\n         \tvar waitime = document.getElementById(\"waittime\").value.trim();\n         \tvar isDebugYN = document.getElementById(\"isDebugYN\").value.trim();\n\t\t\tif (isDebugYN == \"true\"){\n\t\t\t\talert(\"Inside Time out Function \"+waitime);\n\t\t\t}\n\n\t\t\t//waitime = 10;\n         \t\n         \twaitime = Number(waitime) * 1000;\t\n         \t\n         \tvar countDownDate = new Date().getTime();\n\n\t\t\tcountDownDate = countDownDate +  waitime;\n\n\t\t\t// Update the count down every 1 second\n\t\t\tvar x = setInterval(function() {\n\t\t\t\n\t\t\t// Get today\'s date and time\n\t\t\tvar now = new Date().getTime();\n\t\t\t  \n\t\t\t// Find the distance between now and the count down date\n\t\t\tvar distance = countDownDate - now;\n\t\t\t  \n\t\t\t// Time calculations for days, hours, minutes and seconds\n\t\t\tvar days = Math.floor(distance / (1000 * 60 * 60 * 24));\n\t\t\tvar hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));\n\t\t\tvar minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\n\t\t\tvar seconds = Math.floor((distance % (1000 * 60)) / 1000);\n\t\t\tvar statusMessage = \"\";\n\t\t\tif (status == \"SUCCESS\")\n\t\t\t{\n\t\t\t\tstatusMessage = \"transaction is successful\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tstatusMessage = \"transaction is in progress\";\n\t\t\t}\n\t\t\t// Output the result in an element with id=\"demo\"\n\t\t\tdocument.getElementById(\"demo\").innerHTML = \"Kindly wait... \"+statusMessage+\" and this window will close in \"+seconds + \"s \";\n\t\t\t  \n\t\t\t// If the count down is over, write some text \n\t\t\tif (distance < 0) {\n\t\t\t  \tclearInterval(x);\n\t\t\t  \tdocument.getElementById(\"demo\").innerHTML = \"EXPIRED\";\t\t\t  \t\n\t\t\t \tparent.window.close();\n\t\t\t}\n\t\t\t}, 1000); \t\t\t\n \t\t\t\n         };\n\n         function ErrorCallback(error) {\n        \t\n        \tvar isDebugYN = document.getElementById(\"isDebugYN\").value.trim();\n        \tif (isDebugYN == \"true\"){\n \t\t\t\talert(\"Inside Error Callback \"+error);\n\t\t\t}\n        \t \n\t\t\t$(\'.cnt-errorcallback\').append(\'<p>\' + error + \'</p>\');\n\t\t\t\n\t\t\tvar slmtidno = document.getElementById(\"slmtidno\").value.trim();\n\t\t\t\n\t\t\tvar returnStr = \"\";\n\t\t\tvar resultFlag = \"\";\n\n\t\t\tvar datestring = \"\";\n\t\t\t \n\t\t\tresultFlag = \"ERROR\";\n\t\t\tdatestring = \"\";\n\t\t\treturnStr = resultFlag+\"$!^\"+resultFlag+\"$!^Transaction Failed$!^\"+error+\"$!^\"+slmtidno+\"$!^\"+datestring;\n\t\t\tparent.window.returnValue = returnStr;\n\t\t\tTimeOutFn(resultFlag);\n         };\n\n         function RequestPaymentAckCallback(obj) {\n        \t var isDebugYN = document.getElementById(\"isDebugYN\").value.trim();\n         \t if (isDebugYN == \"true\"){\n  \t\t\t\talert(\"Inside Payment AckCallback \"+obj.Response);\n\t\t\t }\n\n\t\t\t $(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Payment Acknowledgement Received By the Server...</p></h5>\');\n\n\t\t\t $(\'.cnt-custinfoackcallback\').append(\'<p>Payment Acknowledgement Received By the Server</p>\');\n\t\t\t $(\'.cnt-custinfoackcallback\').append(\'<p>Response Code: \' + obj.Response + \'</p>\');\n\t\t\t $(\'.cnt-custinfoackcallback\').append(\'<p>PatientId: \' + obj.PatientId + \'</p>\');\n\t\t\t $(\'.cnt-custinfoackcallback\').append(\'<p>TransactionId: \' + obj.TransactionId + \'</p>\');\n         };\n         \n\t\t function sendPaymentRequest() {\n\t\t\t \n\t\t\t$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>WebSocket Connected</p></h5>\');\n\t\t\t\n\t\t\tvar slmtidno = document.getElementById(\"slmtidno\").value.trim();\n\t\t\tvar slmtpatientid = document.getElementById(\"slmtpatientId\").value.trim();\n\t\t\tvar slmtbillamount = document.getElementById(\"slmtbillamount\").value.trim();\n\n\t\t\tvar paymentData = {\"PatientId\":$(\"#slmtpatientId\").val(), \"TransactionId\":$(\"#slmtidno\").val(), \"Amount\":$(\"#slmtbillamount\").val()};\t\t\n\t\t\t\n\t\t\tvar jsonData = JSON.stringify(paymentData);\n\n\t\t\t PsUhaClient.RequestPayment(\n\t\t\t {\n\t\t\t\t PatientId: $(\"#slmtpatientId\").val().trim(),\n\t\t\t\t TransactionId: $(\"#slmtidno\").val().trim(),\n\t\t\t\t Amount: Number($(\"#slmtbillamount\").val().trim())\n\t\t\t});\n\n\t\t\t$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:green\"><p>Payment request successfully made</p></h5>\');\n\t\t\t\n\t\t\t$(\'.cnt-statuscallback\').append(\'<h5 style=\"color:blue\"><p>Kindly swipe/insert the card in the card reader machine </p></h5>\');\n\t\t\t\n\t\t\tvar returnStr = \"\";\n\t\t\tvar resultFlag = \"\";\n\n\t\t\tvar datestring = \"\";\n\n\t\t\tresultFlag = \"ERROR\";\n\t\t\tdatestring = \"\";\n\t\t\treturnStr = resultFlag+\"$!^\"+resultFlag+\"$!^Transaction Failed$!^\"+\"ERROR\"+\"$!^\"+slmtidno+\"$!^\"+datestring;\n\t\t\tparent.window.returnValue = returnStr;\n\t\t\tTimeOutFn(resultFlag);\n\n        }\n\t\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<body>\n\n\t<form>\n\t\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\n\t\t\t<tr>\t\t\t\t\n\t\t\t\t<td width=\"20%\" class=\"fields\">\n\t\t\t\t\t<p class=\"call-back\">Payment Details</p>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"20%\" class=\"fields\">\n\t\t\t\t\t<p class=\"call-back\">Receive HealthID Callback</p>\n\t\t\t   \t</td>\n\t\t\t\t<td width=\"20%\" class=\"fields\">\n\t\t\t\t\t<p class=\"call-back\">Request Payment Ack Callback</p>\n\t\t\t   \t</td>\n\t\t\t   \t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t<p class=\"call-back\">Payment Result Callback</p>\n\t\t\t   \t</td>\n\t\t\t   \t<td width=\"15%\" class=\"fields\">\n\t\t\t\t\t<p class=\"call-back\">Error Callback</p>\n\t\t\t   \t</td>\n\t\t\t</tr>\n\t\t\t<tr>\t\t\t\t\n\t\t\t\t<td width=\"20%\" class=\"label\">\n\t\t\t\t\t<p>Patient ID : ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" <p>\n\t\t\t\t\t<p>Payable Amount : ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <p>\n\t\t\t\t\t<p>Transaction ID : ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" <p>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"20%\" class=\"label\">\n\t\t\t\t\t<p class=\'cnt-healthidcallback text-success\'></p>\n\t\t\t    </td>\n\t\t\t\t<td width=\"20%\" class=\"label\">\n\t\t\t\t\t<p class=\'cnt-custinfoackcallback text-success\'></p>\n\t\t\t    </td>\n\t\t\t    <td width=\"25%\" class=\"label\">\n\t\t\t\t\t<p class=\'cnt-notifypmtcallback text-success\'></p>\n\t\t\t    </td>\n\t\t\t    <td width=\"15%\" class=\"label\">\n\t\t\t\t\t<p class=\'cnt-errorcallback text-danger\'></p>\n\t\t\t    </td>\n\t\t\t</tr>\n\t\t</table>\t\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td><p class=\"cnt-statuscallback text-success\">Transaction Status</p></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td><p id=\"demo\">Kindly wait... transaction in progress and this window will close automatically...</p></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<input type=hidden id=\'slmtidno\' name=\'slmtidno\' id=\'slmtidno\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type=hidden id=\'slmtpatientId\' name=\'slmtpatientId\' id=\'slmtpatientId\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=hidden id=\'slmtbillamount\' name=\'slmtbillamount\' id=\'slmtbillamount\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<input type=hidden id=\'requesttype\' name=\'requesttype\' id=\'requesttype\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\t\n\t\t<input type=hidden id=\'waittime\' name=\'waittime\' id=\'waittime\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\t\n\t\t\n\t\t<input type=hidden id=\'websockurl\' name=\'websockurl\' id=\'websockurl\' value=\"\">\n\t\t<input type=hidden id=\'isDebugYN\' name=\'isDebugYN\' id=\'isDebugYN\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);	

 
            _bw.write(_wl_block3Bytes, _wl_block3);

		String      strloggeduser = "";
		String		strslmtidno = request.getParameter("saledraftno") == null ? "":request.getParameter("saledraftno");	
		String		strslmtpatientId = request.getParameter("patientid") == null ? "":request.getParameter("patientid");	
		String		strslmtbillamount = request.getParameter("amount") == null ? "":request.getParameter("amount");		
		String		strrequesttype = request.getParameter("requesttype") == null ? "":request.getParameter("requesttype");	
		String		strwaitime = request.getParameter("waitime") == null ? "5":request.getParameter("waitime");
		
		boolean isDebugYN = false;
		
		try
		{
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			if(isDebugYN)
				System.err.println("***Inside BLPaySkyPayments - Settlement ID No... "+strslmtidno+" ***Patient Id... "+strslmtpatientId+" *** Settlement Bill Amount... "+strslmtbillamount+" *** Request Type... "+strrequesttype+" *** Wait Time... "+strwaitime);

		}		
		catch(Exception e)
		{
			out.println("Exception while fetching Debug YN :"+e);
		}
		

	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strslmtpatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strslmtbillamount));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strrequesttype));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strwaitime));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
