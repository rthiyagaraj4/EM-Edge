package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.IPADConstants;
import java.util.List;
import eIPAD.pendingresults.PrevResultCountResponse;
import eCommon.Common.CommonBean;
import eIPAD.pendingresults.PreviousResultsRequest;
import eIPAD.pendingresults.PendingResults;
import eIPAD.pendingresults.*;

public final class __previousresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PreviousResults.jsp", 1709118030537L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n<script src=\"../jquery-1.5.2.min.js\"></script> \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n<link rel=\"stylesheet\" href=\"../css/iPadPreviousResults.css\"/>\n<script>\nfunction closePreviousResults(){\n\tvar hdnParamComp = document.getElementById(\"hdnRequestParam\");\n\tvar paramVal;\n\tif(hdnParamComp){\n\t\tparamVal = hdnParamComp.value;\n\t}\n\t//window.location = \"IpadBasePage.jsp?\"+paramVal;\n\twindow.parent.openMainWindow(paramVal);\n}\n\nfunction moveRecordsRight(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\t//alert(currentSectionNum);\n\tcurrentSectionNum = currentSectionNum + 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t//$.mobile.changePage(\"#section2\",\"slide\" , false,false);\n\t$.mobile.changePage(sectionName,\"slide\" , false,false);\n\t\n\thdnCurrentSection.value = currentSectionNum;\n}\n\nfunction moveRecordsLeft(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\tcurrentSectionNum = currentSectionNum - 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t$.mobile.changePage(sectionName,\"slide\" , false,false);\n\thdnCurrentSection.value = currentSectionNum;\n}\n\nfunction changeOrientation(orient)\n{\n\t//\talert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t     //document.getElementById(\"dvmain\").style.height = \"auto\";\n\t    // $(\"#dvmain\").css(\'min-height\',\'381px\');\n\t\t $(\"#maindiv\").css(\'min-height\',\'481px\');\n\t\t    \n\t\t    var dvheight = $(\"#maindiv\").height() + \"px\";\n\t\t\t//document.getElementById(\"notesContentFrame\").style.height = $(\"#dvNotesMenu\").height() ;\n\t\t\t//alert(document.getElementById(\"notesContentFrame\").style.height);\n\t\t\t//alert($(\"#dvNotesMenu\").height());\n\t\t    $(\"#prevResultFrame\").css(\'height\', dvheight);\n\t\t    document.getElementById(\"prevResultFrame\").contentWindow.changeOrientation(orient,dvheight);\n\t    \n\t   }\n     else\n\t   {\n\t   //  document.getElementById(\"dvmain\").style.height = \"auto\";\n\t    // $(\"#dvmain\").css(\'min-height\',\'765px\');\n    \t $(\"#maindiv\").css(\'min-height\',\'760px\');\n    \t var dvheight = $(\"#dvNotesMenu\").height() + \"px\";\n    \t $(\"#prevResultFrame\").css(\'height\', dvheight);\n    \t document.getElementById(\"prevResultFrame\").contentWindow.changeOrientation(orient,dvheight);\n\t   }\n \n}\n\n\n</script>\n</head>\n<body>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<form name = \"previousResult\">\n\t  \n <div data-role = \"page\" style=\"background:#ffffff\">\n\t  \n\t  <div  data-role =\"none\" class =\"dvApp\">\n\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t    <td style = \"width:80%\">\n\t\t\t         <span class = \"spanTextBigHeader\"> Pending Results Review >> </span>\n\t\t\t         <span class=\"spanTextMediumHeader\" >Previous results</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:10%\" align = \"right\" valign = \"center\">\n\t\t\t        <img src = \"../images/Close.png\" class=\"imgLogoutt\" onclick=\"closePreviousResults()\"></img>\n\t\t\t    </td>\n\t\t\t \n\t\t\t    \n\t\t\t  </tr>\n\t\t    </table>\t  \n\t  </div>\n\t  \n\t  <div id=\"maindiv\" class=\"dvevent\">\n\t  \t<table style=\"width:100%;height:100%;\" cellpadding = \"0\" cellspacing = \"0\" border=0>\n\t  \t\t<tr style=\"border-bottom: 2 px solid #cccccc\">\n\t  \t\t\t<td style=\"width:100%;height:100%;border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc\">\n\t  \t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t \t\t<tr style = \"height:100%;width:100%\" class=\"dvApp\">\n\t\t\t\t \t\t <td width=\"5%\">&nbsp;</td>\n\t\t\t\t   \t\t\n\t\t\t\t          <td style = \"width:65%\" align=\"left\">\n\t\t\t\t        \t <span class = \"spanTextSmallHeader\">Event</span>\n\t\t\t\t         </td>\n\t\t\t\t       \n\t\t\t\t    \t</tr>\n\t  \t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t  \t\t\t\t\t<td style=\"width:5%\">&nbsp;</td>\n\t\t  \t\t\t\t\t<td style = \"height:100%;width:100%\">\n\t\t  \t\t\t\t\t<table style=\"width:100%\" border=0>\n\t\t  \t\t\t\t\t\t<tr>\n\t\t  \t\t\t\t\t\t\t<td style=\"width:100%\" align=\"left\">\n\t\t  \t\t\t\t\t\t\t\t<span class=\"spanTextSmallBold\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t  \t\t\t\t\t\t\t</td>\n\t\t  \t\t\t\t\t\t</tr>\n\t\t  \t\t\t\t\t\t<tr>\n\t\t  \t\t\t\t\t\t\t<td style=\"width:100%\" align=\"left\">\n\t\t  \t\t\t\t\t\t\t\t<span class=\"spanTextSmallNormal\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n\t\t  \t\t\t\t\t\t\t</td>\n\t\t  \t\t\t\t\t\t</tr>\n\t\t  \t\t\t\t\t\t<tr>\n\t\t  \t\t\t\t\t\t\t<td style=\"width:100%\" align=\"left\">\n\t\t  \t\t\t\t\t\t\t\t<span class=\"spanTextSmallNormal\">\n\t\t  \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t  \t\t\t\t\t\t\t\t</span>\n\t\t  \t\t\t\t\t\t\t</td>\n\t\t  \t\t\t\t\t\t</tr>\n\t\t  \t\t\t\t\t</table>\n\t\t  \t\t\t\t\t</td>\n\t\t  \t\t\t\t\t<td></td>\n\t\t  \t\t\t\t  </tr>\n\t\t  \t\t\t\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t  \t\t\t\t  \n\t\t  \t\t\t\t  \n\t\t  \t\t\t\t</table>\n\t  \t\t\t\t</td>\n\t\t  \t\t\t\t\n\t \t\t</tr>\n\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t \t\t<tr style=\"height:60px;background:#e6e6e6\">\n\t \t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t \t\t<tr style=\"height:60px;\">\n\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t \t\t<td style=\"border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc\">&nbsp;</td>\n\t \t\t</tr>\n\t \t\t\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t \t\t\n\t \t\t\n\t  \t</table>\n\t  </div>\n\t  \n\t   <div id=\"prevResultData\" class=\"prevResultData\" style=\"position:relative;\">\n\t  \t<iframe id=\"prevResultFrame\" name=\"prevResultFrame\" class=\"prevResultFrame\" frameborder=\"0\" src=\"\" width=\"100%\"  scrolling =\"no\" style = \"display:block\">\n\t  \t</iframe>\n\t  </div>\n\t  \t  \n\t</div>\n\t\n\t<input type=\"hidden\" id=\"hdnRequestParam\" name=\"hdnRequestParam\" id=\"hdnRequestParam\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t  <input type=\"hidden\" id=\"hdnPresentCounter\" name=\"hdnPresentCounter\" id=\"hdnPresentCounter\" value=\"4\"/>\n\t  <input type=\"hidden\" id=\"hdnCurrentSection\" name=\"hdnCurrentSection\" id=\"hdnCurrentSection\" value=\"1\"/>\n\t\n</form>\n\n<script>\n\twindow.onload = initializeFunction;\n\t\n\tfunction initializeFunction(){\n\t\twindow.parent.hideLoading();\n\t\tvar requestParamComp = document.getElementById(\"hdnRequestParam\");\n\t\tvar requestParam;\n\t\tif(requestParamComp){\n\t\t\trequestParam = requestParamComp.value;\n\t\t}\n\t\tvar prevResultFrame = document.getElementById(\"prevResultFrame\");\n\t\tif(prevResultFrame){\n\t\t\tprevResultFrame.src = \"PreviousResultsData.jsp?\"+requestParam;\n\t\t}\n\t\t\n\t\tvar dvheight = $(\"#maindiv\").height() + \"px\";\n\t\t$(\"#prevResultFrame\").css(\'height\', dvheight);\n\t\t\n\t}\n</script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String param = request.getQueryString();
	int rowIndex = 1;
	int totalResults = 0;
	
	//Here comes the logic of getting the previous results and showing
	// them in a tabular format
	PendingResults pendingResultsBean = new PendingResults();
	PreviousResultsRequest prevResultsRequest = new PreviousResultsRequest();
	prevResultsRequest.setRequest(request);
	prevResultsRequest.setSession(session);
	prevResultsRequest.setLocale(IPADConstants.LOCALE);
	//String rowCounter = request.getParameter("hdnRowCounter");

	String patient_Id = request.getParameter("hdnPatientid");
	patient_Id = CommonBean.checkForNull(patient_Id);
	prevResultsRequest.setPatientId(patient_Id);

	String histRecType = request.getParameter("hdnHistRectType");
	histRecType = CommonBean.checkForNull(histRecType);
	prevResultsRequest.setHistRectType(histRecType);

	String eventClass = request.getParameter("hdnEventClass");
	eventClass = CommonBean.checkForNull(eventClass);
	prevResultsRequest.setEventClass(eventClass);

	String eventCode = request.getParameter("hdnEventCode");
	eventCode = CommonBean.checkForNull(eventCode);
	prevResultsRequest.setEventCode(eventCode);

	String eventGroup = request.getParameter("hdnEventGroup");
	eventGroup = CommonBean.checkForNull(eventGroup);
	prevResultsRequest.setEventGroup(eventGroup);

	String normalcyIndicator = request
			.getParameter("hdnNormalcyIndicator");
	normalcyIndicator = CommonBean.checkForNull(normalcyIndicator);
	if(normalcyIndicator.trim().equals("")){
		normalcyIndicator = "N";
	}
	prevResultsRequest.setNormalcyIndicator(normalcyIndicator);
	
	prevResultsRequest.setMaskDates(true);
// get the list of previous result dates by executing
// the method in the pending results bean
	PrevResultCountResponse prevResultCountResponse = pendingResultsBean
			.getPreviousResultsCount(prevResultsRequest);
	
	List<PrevResultDateContainer> prevResultDateContainerList = prevResultCountResponse.getPrevResultDateContainerList();
	// calculate the earliest date and latest date from the list of previous dates
	// the list already contains the dates in ascending order of date
	// hence the earliest date is in the first index and latest date is the last in the list
	PrevResultDateContainer earliestDate = prevResultDateContainerList.get(0);
	PrevResultDateContainer latestDate = prevResultDateContainerList.get(prevResultDateContainerList.size()-1);
	
	String fromDate = "";
	if(earliestDate != null){
		fromDate = earliestDate.getDateString();
	}
	
	String toDate = "";
	if(latestDate != null){
		toDate = latestDate.getDateString();
	}
	// now unmask the dates in the request
	prevResultsRequest.setMaskDates(false);
	// set the dates
	prevResultsRequest.setFromDate(fromDate);
	prevResultsRequest.setToDate(toDate);

	// now execute to get the previous results
	PreviousResultsResponse previousResultsResponse = 
		pendingResultsBean.getPreviousResults(prevResultsRequest, prevResultCountResponse);
	
	PreviousResultEventDescriptor eventDescriptor =  
			previousResultsResponse.getEventDescriptor();
	

            _bw.write(_wl_block3Bytes, _wl_block3);

		  				// just a safe check
		  				if(eventDescriptor != null){
		  				
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(eventDescriptor.getEventCategory() ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eventDescriptor.getDescription() ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eventDescriptor.getEventGroupDescription() ));
            _bw.write(_wl_block6Bytes, _wl_block6);

		  								String resultDesc = eventDescriptor.getResultDescriptor();
		  								if(resultDesc != null && !resultDesc.trim().equals("")){
		  									out.println(resultDesc);
		  								}
            _bw.write(_wl_block7Bytes, _wl_block7);
 } 
            _bw.write(_wl_block8Bytes, _wl_block8);

	 			for(int count=0;count<5;count++){
	 				if((count % 2) == 0){
	 		
            _bw.write(_wl_block9Bytes, _wl_block9);

	 				}else{
	 		
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	 			}
	 		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
