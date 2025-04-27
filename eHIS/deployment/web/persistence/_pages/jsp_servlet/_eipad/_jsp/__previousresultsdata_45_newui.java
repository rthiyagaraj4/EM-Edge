package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.pendingresults.PreviousResultEventDescriptor;
import eIPAD.IPADConstants;
import eIPAD.pendingresults.PreviousResults;
import eIPAD.pendingresults.PreviousResultsResponse;
import eIPAD.pendingresults.PrevResultDateContainer;
import java.util.List;
import eIPAD.pendingresults.PrevResultCountResponse;
import eCommon.Common.CommonBean;
import eIPAD.pendingresults.PreviousResultsRequest;
import eIPAD.pendingresults.PendingResults;

public final class __previousresultsdata_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PreviousResultsData-newUI.jsp", 1738426157462L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n    ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Previous results</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  -->\n<!--  <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script> -->\n<!--    -->\n\n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n\n<link rel=\"stylesheet\" href=\"../css/iPadPreviousResults.css\"/>\n<script>\n/* $(document).ready(function() {\n\t\n\t\n\t$(\"[data-scrolldef = \'first\']\").bind(\"swipeleft\", function() {\n\tmoveRecordsRight();\n\t});\n \t $(\"[data-scrolldef = \'middle\']\").bind(\"swipeleft\", function() {\n\tmoveRecordsRight();\n\t});\n\t $(\"[data-scrolldef = \'middle\']\").bind(\"swiperight\", function() {\n\tmoveRecordsLeft();\n\t});\n\t$(\"[data-scrolldef = \'last\']\").bind(\"swiperight\", function() {\n\tmoveRecordsLeft();\n\t});\n\t\n});\n\nfunction moveRecordsRight(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\t//alert(currentSectionNum);\n\tcurrentSectionNum = currentSectionNum + 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t//$.mobile.changePage(\"#section2\",\"slide\" , false,false);\n\t$.mobile.changePage(sectionName,\"slide\" , false,false);\n\t\n\thdnCurrentSection.value = currentSectionNum;\n}\n\nfunction moveRecordsLeft(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\tcurrentSectionNum = currentSectionNum - 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t$.mobile.changePage(sectionName,\"slide\" , true,false);\n\thdnCurrentSection.value = currentSectionNum;\n} */\n\n/* function changeOrientation(orient,height)\n{\n\t//\talert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t     document.getElementById(\"datadiv\").style.height = \"auto\";\n\t     //document.getElementById(\"txtnotes\").style.height = height;\n\t   }\n     else\n\t   {\n\t   document.getElementById(\"datadiv\").style.height = \"auto\";\n\t  // document.getElementById(\"txtnotes\").style.height = height;\n\t   }\n\n} */\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n</script>\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<form name = \"previousResultData\" id=\"previousResultData\">\n\t\t<div class=\"drRowContainerTheme\" style=\"width:100%; height:63px;\">\n\t\t\t<table style=\"height:100%\" cellpadding = \"0\" cellspacing = \"0\" border=0>\n\t\t\t\t<tr style = \"height:15%;width:100%\" >\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\n\n\t\t  \t\t\t<td align=\"center\" style=\"width: 100px;\">\n\t\t  \t\t\t<div class=\"drColumnContainerTheme\">\n\t\t\t        \t <div class = \"drColumnDateText\">\n\t\t\t        \t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</div>\n\t\t\t        \t <div class=\"drColumnResultNum\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t</div>\n     \t  \t\t  \t\t<div class=\"drColumnResultText\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"drColumnNormalcyInd\">\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n      \t\t\t\t\t\t<div></div>\n      \t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n      \t\t\t\t\t\t<div class=\"prNormalcyAbnormalTheme\"></div>\n      \t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n      \t\t\t\t\t\t<div class=\"prNormalcyCriticalTheme\"></div>\n      \t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n      \t\t\t\t\t\t<div class=\"prNormalcyNormalTheme\"></div>\n      \t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\n\t\t\t\t\t    \t\t \n\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</tr>\t\t\t\t\t\t  \n\t\t\t</table>\n\t  \t</div>\n\n\t  \n<!-- \t </section>\t -->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t \t\t\t\n\t \n\t <input type=\"hidden\" id=\"hdnRequestParam\" name=\"hdnRequestParam\" id=\"hdnRequestParam\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t  <input type=\"hidden\" id=\"hdnResultCount\" name=\"hdnResultCount\" id=\"hdnResultCount\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/> \n<!-- \t  <input type=\"hidden\" id=\"hdnPresentCounter\" name=\"hdnPresentCounter\" id=\"hdnPresentCounter\" value=\"3\"/> -->\n<!-- \t  <input type=\"hidden\" id=\"hdnTotalBuckets\" name=\"hdnTotalBuckets\" id=\"hdnTotalBuckets\" value=\"\"/> -->\n<!-- \t  <input type=\"hidden\" id=\"hdnCurrentSection\" name=\"hdnCurrentSection\" id=\"hdnCurrentSection\" value=\"1\"/> -->\n</form> \n\t \t\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
request.setCharacterEncoding("UTF-8"); 
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
	
	int rowsForUI = 0;
	if(eventDescriptor != null){
		String eventCategory = eventDescriptor.getEventCategory();
		if(eventCategory != null && !eventCategory.trim().equals("")){
			rowsForUI++;	
		}
		String desc = eventDescriptor.getDescription();
		if(desc != null && !desc.trim().equals("")){
			rowsForUI++;
		}
		String eventGrpDesc = eventDescriptor.getEventGroupDescription();
		if(eventGrpDesc != null && !eventGrpDesc.trim().equals("")){
			rowsForUI++;
		}
		String resultDesc = eventDescriptor.getResultDescriptor();
		if(resultDesc != null && !resultDesc.trim().equals("")){
			rowsForUI++;
		}
	}
	
	
	List<PreviousResults> prevResultsList = previousResultsResponse.getPreviousResultsList();
	int colCounter = 1;
	if(!prevResultsList.isEmpty()){
		totalResults = prevResultsList.size();
	}
	PreviousResults prevResults = null;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
	
				for(int count=0;count<=totalResults;count++){
					try{
						prevResults = prevResultsList.get(count);	
					}catch(Exception ex){
						// nothing much can be done
					}
            _bw.write(_wl_block5Bytes, _wl_block5);

			        	 if(prevResults != null){
			        		out.println(prevResults.getEventDummyDate());	 
			        	 }
			        	  
            _bw.write(_wl_block6Bytes, _wl_block6);

						if(prevResults != null){
							out.println(prevResults.getResultNum());	
						}
						
            _bw.write(_wl_block7Bytes, _wl_block7);

						if(prevResults != null){
							out.println(prevResults.getResultStr());	
						}
						
            _bw.write(_wl_block8Bytes, _wl_block8);
	
							String normalcyInd = "";
							normalcyInd=prevResults.getNormIndicator();
      						if(normalcyInd==null||normalcyInd.equals("")||normalcyInd.equals("Z")||normalcyInd.equals("S"))
      						{
      						
            _bw.write(_wl_block9Bytes, _wl_block9);

      						}
      						else if(normalcyInd.equals("A"))
      						{
            _bw.write(_wl_block10Bytes, _wl_block10);

      						}
      						else if(normalcyInd.equals("C"))
      						{
            _bw.write(_wl_block11Bytes, _wl_block11);

      						}
      						else if(normalcyInd.equals("N"))
      						{
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
 }
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totalResults ));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
