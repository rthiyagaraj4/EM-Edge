package jsp_servlet._portal._jsp._result;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.result.viewresult.TestResultCache;
import portalrefimpl.result.viewresult.TestResultCacheManager;
import portalrefimpl.result.viewresult.response.TestResult;
import java.util.List;
import portalrefimpl.PortalHelper;
import portalrefimpl.common.response.ErrorInfo;
import java.util.Date;
import portalrefimpl.result.viewresult.response.TestResultResponse;
import portalrefimpl.result.viewresult.svc.TestResultServiceInvoker;
import portalrefimpl.common.serviceinvoker.ServiceInvoker;
import portalrefimpl.result.viewresult.request.TestResultRequest;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.PortalConstants;

public final class __viewresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/result/ViewResult.jsp", 1669269355937L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<title>::: Patient Portal</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<script>\r\n$(document).ready(function() {\r\n\tloadResult();\r\n});\r\nfunction loadResult(){\r\n\tvar hdnOrderId = document.getElementById(\"hdnOrderId\");\r\n\tvar orderId = \"\";\r\n\tvar escapedOrderId = \"\";\r\n\tif(hdnOrderId){\r\n\t\torderId = hdnOrderId.value;\r\n\t\tescapedOrderId = escape(orderId);\r\n\t}\r\n\tvar hdnOrder = document.getElementById(\"hdnOrder\");\r\n\tvar order = \"\";\r\n\tvar escapedOrder = \"\";\r\n\tif(hdnOrder){\r\n\t\torder = hdnOrder.value;\r\n\t\tescapedOrder = escape(order);\r\n\t}\r\n\tvar hdnOrderDate = document.getElementById(\"hdnOrderDate\");\r\n\tvar orderDate = \"\";\r\n\tvar escapedOrderDate = \"\";\r\n\tif(hdnOrderDate){\r\n\t\torderDate = hdnOrderDate.value;\r\n\t\tescapedOrderDate = escape(orderDate);\r\n\t}\r\n\tvar hdnResultType = document.getElementById(\"hdnResultType\");\r\n\tvar resultType = \"\";\r\n\tvar escapedResultType = \"\";\r\n\tif(hdnResultType){\r\n\t\tresultType = hdnResultType.value;\r\n\t\tescapedResultType = escape(resultType);\r\n\t}\r\n\tvar hdnCounter = document.getElementById(\"hdnCounter\");\r\n\tvar counter = \"\";\r\n\tvar counterInt;\r\n\tif(hdnCounter){\r\n\t\tcounter = hdnCounter.value;\r\n\t\tcounterInt = getIntValue(counter,0);\r\n\t\tcounterInt += 1000;\r\n\t}\r\n\t\r\n\tvar xmlHttp = getHttpObject();\r\n \txmlHttp.onreadystatechange=function(){\r\n \t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\r\n \t\t\tvar responseText = xmlHttp.responseText;\r\n \t\t\t$(\'#resultContainer\').html(responseText);\r\n \t\t\t\r\n \t\t\t//$(\'#testresult\'+counter).css(\'display\',\'block\');\r\n \t\t\t//$(\'#\'+viewResultAnchorId).html(\"Hide&nbsp;Results\");\r\n \t\t}\r\n \t };\r\n \txmlHttp.open(\"POST\", \"./GetTestResult.jsp\", true);\r\n \txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n \tvar parameters = \'orderId=\'+escapedOrderId+\'&order=\'+escapedOrder+\'&resultType=\'+escapedResultType+\'&orderDate=\'+escapedOrderDate+\'&counter=\'+counterInt+\'&popup=Y\';\r\n \txmlHttp.send(parameters);\r\n\t\r\n\t//alert(escapedOrderId+\' || \'+escapedOrder+\' || \'+escapedResultType+\' || \'+escapedOrderDate+\' || \'+counter);\r\n\t/* var divElement = document.getElementById(\"resultContainer\");\r\n\tif(divElement){\r\n\t\tdivElement.load(\'./GetTestResult.jsp?orderId=\'+escapedOrderId+\'&order=\'+escapedOrder+\'&resultType=\'+escapedResultType+\'&orderDate=\'+escapedOrderDate+\'&counter=\'+counter+\'&popup=Y\');\r\n\t} */\r\n\t\r\n\t//$(\'#resultContainer\').html(\'test\');\r\n\t//$(\'#resultContainer\').load(\'./GetTestResult.jsp?orderId=\'+escapedOrderId+\'&order=\'+escapedOrder+\'&resultType=\'+escapedResultType+\'&orderDate=\'+escapedOrderDate+\'&counter=\'+counter+\'&popup=Y\');\r\n}\r\n\r\nfunction getHttpObject(){\r\n\tvar xmlHttp;\r\n\tif (window.XMLHttpRequest) {\r\n\t\txmlHttp = new XMLHttpRequest();\r\n\t} else if (window.ActiveXObject) {\r\n\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n\t}\r\n\treturn xmlHttp;\r\n}\r\n\r\nfunction getIntValue(stringValue,defaultValue){\r\n\t// this function converts the string value to an integer value\r\n\tvar intVal = defaultValue;\r\n\ttry{\r\n\t\tintVal = parseInt(stringValue);\t\r\n\t}catch(e){\r\n\t\tintVal = defaultValue;\r\n\t}\r\n\treturn intVal;\r\n}\r\n\r\n</script>\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"popwrapper\">\r\n\t\r\n<div id=\"popheader\">\r\n<div class=\"row\">\r\n\t\t<div id=\"poptitle\">View Results\r\n        </div>\r\n         \r\n\t\t<div id=\"close\" onclick=\"closeResultPopup(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\')\">x\r\n        </div>\r\n    \r\n</div>\r\n</div>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n<!--  <div style=\"width:99%;height:430px;border: 1px solid #92b82d;background-color:#ffffff;display:table;margin: 2px;\"><!--  id=\"popmsgbox\"> \r\n-->\r\n<div id=\"resulthearder\" style=\"width:99%;border: 1px solid #92b82d;margin: 2px;\">\r\n\t<div class=\"row\">\r\n    \t\r\n        <div id=\"resultcell\">\r\n        \t<span class=\"contentfontbold\">Order No</span><br />\r\n        \t<span class=\"contentfont\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\r\n        </div>\r\n        <div id=\"resultcell\">\r\n\t        <span class=\"contentfontbold\">Result Type</span><br />\r\n    \t   \t<span class=\"contentfont\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\r\n        </div>\r\n        <div id=\"resultcell\">\r\n           <span class=\"contentfontbold\">Order</span><br />\r\n    \t   \t<span class=\"contentfont\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </span>\r\n          \r\n        </div>\r\n        <div id=\"resultcell\">\r\n          \r\n           <span class=\"contentfontbold\">Reported Date & Time</span><br />\r\n    \t   \t<span class=\"contentfont\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\r\n        </div>\r\n        \r\n    </div>\r\n    \r\n\r\n</div>\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n<div>\r\n <span class=\"loginerror\">\r\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n </span>\r\n</div>\r\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\r\n<div id=\"resultContainer\" style=\"overflow: auto;overflow-x : hidden;height:90%;width:99%;margin: 1px;\">\r\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n</div>\r\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\r\n<input type=\"hidden\" id=\"hdnOrderId\" name=\"hdnOrderId\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\r\n<input type=\"hidden\" id=\"hdnOrder\" name=\"hdnOrder\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\r\n<input type=\"hidden\" id=\"hdnResultType\" name=\"hdnResultType\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\r\n<input type=\"hidden\" id=\"hdnOrderDate\" name=\"hdnOrderDate\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\r\n<input type=\"hidden\" id=\"hdnCounter\" name=\"hdnCounter\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\r\n\r\n</div>\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	//patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	}

	String orderId = "";
	orderId = request
			.getParameter(ResultConstants.TESTRESULT_ORDERID_REQUEST_PARAM_KEY);
	if (orderId == null) {
		orderId = "";
	}

	String order = "";
	order = request
			.getParameter(ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY);
	if (order == null) {
		order = "";
	}

	String resultType = "";
	resultType = request
			.getParameter(ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY);
	if (resultType == null) {
		resultType = "";
	}
	
	String orderDate = request
			.getParameter(ResultConstants.TESTRESULT_ORDERDATE_REQUEST_PARAM_KEY);
	if(orderDate == null){
		orderDate = "";
	}
	
	String counterStr = request.getParameter("counter");
	int counterVal = PortalHelper.getIntegerValue(counterStr, 0);
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(counterVal));
            _bw.write(_wl_block3Bytes, _wl_block3);

/* 	TestResultRequest testResultRequest = new TestResultRequest();
	testResultRequest.setPatientId(patientId);
	testResultRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	testResultRequest.setOrder(order);
	testResultRequest.setOrderNumber(orderId);
	testResultRequest.setResultType(resultType);

	TestResultSvcImpl testResultSvcImpl = new TestResultSvcImpl();
	testResultSvcImpl.registerService(testResultRequest);

	ServiceInvoker testResultServiceInvoker = new TestResultServiceInvoker();
	TestResultResponse testResultResponse = (TestResultResponse) testResultServiceInvoker
			.getDataThroughWebService(testResultRequest); */
	
	TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
	TestResultCache testResultCache = cacheMgr.getTestResultsForPatient(patientId, orderId);		
			

	String responseOrder = "";
	String responseOrderId = "";
	String responseResultType = "";
	String responsePublishedDateString = "";
	Date responsePublishDate = null;

	String errorMessage = "";
	// creating a local var just for efficiency sake
	boolean testResultObtained = testResultCache.isSuccessful();
	//ErrorInfo errorInfo = testResultResponse.getErrorInfo();
	//int errorCode = errorInfo.getErrorCode();
	// check if the response has errors - in this case we have to high light the same
	/* if (ErrorInfo.SUCCESS_CODE != errorCode) { */
		
	// this is the common data about order which we can obtain
	// from the request values itself
	responseOrder = order;
	responseOrderId = orderId;
	responseResultType = resultType;
	responsePublishedDateString = orderDate;
	// now check if the test results are obtained
	// if so, get the published date
	if (!testResultObtained) {
		//errorMessage = errorInfo.getErrorMessage();
		// get the error messae
		errorMessage = testResultCache.getErrorMessage();
		
		responsePublishDate = PortalHelper.getDateFromString(
				responsePublishedDateString,
				ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
		if (responsePublishDate != null) {
			responsePublishedDateString = PortalHelper
					.getDateAsString(
							responsePublishDate,
							ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
			if (responsePublishedDateString == null) {
				responsePublishedDateString = "";
			}
		}
	}else{
		// success scenario - get the overall publish
		// date from the test result cache
		
		/* responseOrder = testResultResponse.getOrder();
		responseOrderId = testResultResponse.getOrderNumber();
		responseResultType = testResultResponse.getResultType(); */
		/* responsePublishDate = testResultResponse.getPublishDate(); */
		responsePublishDate = testResultCache.getOverallPublishDate();
		if (responsePublishDate != null) {
			responsePublishedDateString = PortalHelper
					.getDateAsString(
							responsePublishDate,
							ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
			if (responsePublishedDateString == null) {
				responsePublishedDateString = "";
			}
		}
	}
	
	

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(responseOrderId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(responseResultType));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(responseOrder));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(responsePublishedDateString));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if (!testResultObtained) {

            _bw.write(_wl_block9Bytes, _wl_block9);

 	out.println(errorMessage);
 
            _bw.write(_wl_block10Bytes, _wl_block10);

	} else {
		String pageSrc = "./GetTestResult.jsp?orderId="+orderId+"&order="+order+"&resultType="+resultType+"&orderDate="+orderDate+"&counter="+(counterVal+1000)+"&popup=Y";

            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(orderId ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(resultType ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderDate ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(counterVal ));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
