package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheeteventsgraphparams extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetEventsGraphParams.jsp", 1709115884965L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n<script language=\'JavaScript\'\nsrc=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\tvar arrValues = new Array();\n\tvar valuesToGraph = new Array();\n\tvar datesToGraph = new Array();\n\tvar eventsToGraph = new Array();\n\tvar totalColsToGraph = new Array();\n\tvar unitsToGraph = new Array();\n\tfunction getMessageFrame()\n\t{\n\t\tif(top.content!=null){\n\t\t\treturn top.content.messageFrame;\n\t\t}else{\n\t\t\treturn parent.parent.parent.messageFrame;\n\t\t}\n\t}\n\tvar messageFrameReference = getMessageFrame();\n\n</script>\n</HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t\teventsToGraph[eventsToGraph.length] = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\ttotalColsToGraph[totalColsToGraph.length] = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tunitsToGraph[unitsToGraph.length] = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tvaluesToGraph[valuesToGraph.length] = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tdatesToGraph[datesToGraph.length] = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<script>\n\t\tvar totalCols =parseInt(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\") -  parseInt(totalColsToGraph);\n\t\tarrValues[0] = valuesToGraph;\n\t\t//alert(\"arrValues[0] :\"+arrValues[0])\n\t\tarrValues[1] = datesToGraph;\n\t\t//arrValues[2] = totalColsToGraph;\n\t\t//arrValues[2] = totalCols;\n\t\tarrValues[2] = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\tarrValues[3] = eventsToGraph;\n\t\tarrValues[4] = unitsToGraph;\n\t\tarrValues[5] = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\n\t\talert(\"arrValues[0] :\"+arrValues[0]);\n\t\talert(\"arrValues[1] :\"+arrValues[1]);\n\t\talert(\"arrValues[2] :\"+arrValues[2]);\n\t\talert(\"arrValues[3] :\"+arrValues[3]);\n\t\talert(\"arrValues[4] :\"+arrValues[4]);\n\t\talert(\"arrValues[5] :\"+arrValues[5]);\n\n\t\tvar dialogHeight= \"35\" ;//\"29\"\n\t\tvar dialogWidth\t= \"50\" ;//\"42\"\n\t\tvar dialogTop\t= \"10\";\n\t\tvar dialogLeft\t= \"40\";//\"85\"\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\t\tvar url = \"../jsp/FlowSheetMultipleGraphFrame.jsp\";\n\t\t//var url = \"../jsp/ChartRecordingGraphFrame.jsp\";\n\t\tif(top.content != null){\n\t\t\tmessageFrameReference.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}else{\n\t\t\tmessageFrameReference.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}\n\t\tretVal = window.showModalDialog(url,arrValues,features);\n\t</script>\n\t</BODY>\n\t</HTML>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	ArrayList arrayIndex = null;
	ArrayList arrayIndexValues = null;
	ArrayList tempArrayIndexValues = null;
	ArrayList tempArrayGraphIndex = null;
	try
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String totalCols = request.getParameter("totCols") == null ? "0" : request.getParameter("totCols");
		int totCols = Integer.parseInt(totalCols);
		//String eventKeys = request.getParameter("eventKeys");
		String resultUOM = request.getParameter("resultUOM");
		for(int u=0;u<resultUOM.length();u++)
		{
			resultUOM = resultUOM.replace('#',' ');
		}
		if(resultUOM.equals("^")) resultUOM = resultUOM + " ";//when none of the events have units
		String eventDesc = request.getParameter("eventDesc");
		for(int v=0;v<eventDesc.length();v++)
		{
			eventDesc = eventDesc.replace('?',' ');
		}
	


		String dateNumvals = request.getParameter("dateNumvals");
		String hiddenColumns = request.getParameter("hiddenColumns");

		//String prevEventDate = "";
		StringTokenizer strtEventKeys = new StringTokenizer(eventDesc,"^");
		StringTokenizer strtUOM = new StringTokenizer(resultUOM,"^");
		StringTokenizer strTokDateNums = new StringTokenizer(dateNumvals,"^%^");

		StringTokenizer strTokHiddenCols = new StringTokenizer(hiddenColumns,"!!");
		StringTokenizer strTokTDVals = null;
		StringTokenizer strTokDatesNums = null;
		int numberOfGraphs = strtEventKeys.countTokens();
		arrayIndex = new ArrayList();
		arrayIndexValues = new ArrayList();
		tempArrayIndexValues = new ArrayList();
		StringBuffer datesToGraph = new StringBuffer();
		StringBuffer valuesToGraph = new StringBuffer();
		String eventsToGraph ="";
		String graphRowValues ="";
		String graphTDValues ="";
		String graphDates ="";
		String graphResNumbers ="";
		int totalColsToGraph=0;
		String unitToGraph="";
		int j=0;
		int in = 0;
		int tempIntGraf = 0;
		int intForDateIndex = 0;

		strtEventKeys = new StringTokenizer(eventDesc,"^");
		strtUOM = new StringTokenizer(resultUOM,"^");
		while(strTokDateNums.hasMoreTokens())
		{	
			valuesToGraph.setLength(0);
			eventsToGraph = strtEventKeys.nextToken();
			unitToGraph = strtUOM.nextToken();
			graphRowValues = strTokDateNums.nextToken();
			strTokTDVals = new StringTokenizer(graphRowValues,">");
			j = 0;
			arrayIndexValues = new ArrayList();
			while(strTokTDVals.hasMoreTokens())
			{	
				intForDateIndex = 0;
				graphTDValues = strTokTDVals.nextToken();
				strTokDatesNums = new StringTokenizer(graphTDValues,"~");
				in = 0;
				while(strTokDatesNums.hasMoreTokens())
				{
					if(in % 2 == 0)
					{
						graphDates = strTokDatesNums.nextToken();
						if(!graphDates.equals(" "))
						{
							if(!(arrayIndex.contains(graphDates)))
							{
								arrayIndex.add(graphDates);
							}
						}
					}
					else
					{
						graphResNumbers = strTokDatesNums.nextToken();
						if(!(graphResNumbers.equals(" ")))
						{
							arrayIndexValues.add(graphDates+"`"+graphResNumbers);
							tempIntGraf++;
						}
					}
					in++;
				}
			}
			tempArrayIndexValues.add(arrayIndexValues);

		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(eventsToGraph));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(totalColsToGraph));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(unitToGraph));
            _bw.write(_wl_block10Bytes, _wl_block10);

				}

			tempArrayGraphIndex = new ArrayList();
			ArrayList newTempArrayList = new ArrayList();
			String tempHiddenCols = "";
			int i = 0;

			while(strTokHiddenCols.hasMoreTokens())
			{
				tempHiddenCols = (strTokHiddenCols.nextToken()).trim();
				//if(!(tempHiddenCols.equals("+")))
				{
					tempArrayGraphIndex.add(i,tempHiddenCols);
					i++;
				}
			}

			String tempArrayValue = "";
			int arrayIndexNum = 0;

			for(int r=0;r<tempArrayGraphIndex.size();r++)
			{
				tempArrayValue = (String)tempArrayGraphIndex.get(r);
				if(arrayIndex.contains(tempArrayValue))
				{	
					newTempArrayList.add(arrayIndexNum,tempArrayValue);
					arrayIndexNum++;
				}
			}

			ArrayList tempList = new ArrayList();
			String tempString = "";
			String tempStringDates = "";
			String tempStringDatesForGraf = "";
			String tempStringValuesForGraf = "";
			StringTokenizer tempTokenizer = null;

			for(int t=0;t<newTempArrayList.size();t++)
			{
				datesToGraph.append((String) newTempArrayList.get(t)+"`");
			}

			for(int t=0;t<numberOfGraphs;t++)
			{
				valuesToGraph.setLength(0);
				tempList = (ArrayList) tempArrayIndexValues.get(t);
				for(int y=0;y<tempList.size();y++)
				{
					tempString = (String) tempList.get(y);
					tempTokenizer = new StringTokenizer(tempString,"`");
					tempStringDatesForGraf = tempTokenizer.nextToken();
					
					for(int x=0;x<newTempArrayList.size();x++)
					{
						tempStringDates = (String) newTempArrayList.get(x);
						if(tempStringDates.equals(tempStringDatesForGraf))
						{
							tempStringValuesForGraf = tempTokenizer.nextToken();
							valuesToGraph.append(tempStringValuesForGraf+"~"+(x+1)+"`");
							break;
						}
					}				
				}
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(valuesToGraph.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);


			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(datesToGraph.toString()));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}

		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totCols));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(newTempArrayList.size()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(numberOfGraphs));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
	catch(Exception e)
	{
		out.println("Exception :"+e);
		e.printStackTrace();
	//out.println("<script>alert('Exception : "+e.toString();+"')</script>");	
	}
	finally
	{
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
}
