package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import javax.swing.JPanel;
import eCA.ChartComponentFormulaBean;
import java.text.SimpleDateFormat;
import org.jfree.data.category.DefaultCategoryDataset.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.block.*;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public final class __chartrecordingmultiaxisgraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingMultiAxisGraph.jsp", 1742378994193L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onKeyDown=\"lockKey()\">\n\t<form name=\'MultiAxisForm\' id=\'MultiAxisForm\'>\n\t\t<table>\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></center>\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\t\t\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'filename\' id=\'filename\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input type=\'hidden\' name=\'noOfGroups\' id=\'noOfGroups\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t</form>\n</body>\n<script>\nif(parent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0] != null)\n\tparent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0].graph.disabled = false;\n\t//alert(parent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0].name);\n\t//alert(parent.parent.frames[0].name);\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
17/02/2016	IN059226		Raja S											CRF-CA-INT-CRF-BRU-CIS-005-US002/01
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = null; //(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String group = request.getParameter("group") == null ? "0" : request.getParameter("group");
	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");
	String minValue = "";//IN058139
	String maxValue = "";//IN058139
	int chartWidth = 800;
	int chartHeight = 400;

	if(noOfGroups.equals("1"))
	{
		chartWidth = 975;
		chartHeight = 650;
	}
	else if(noOfGroups.equals("2"))
	{
		chartWidth = 800;
		chartHeight = 330;
	}
	else if(noOfGroups.equals("3"))
	{
		chartWidth = 785;
		chartHeight = 250;
	}
	else if(noOfGroups.equals("4"))
	{
		chartWidth = 785;
		chartHeight = 225;
	}

	
	StandardCategoryToolTipGenerator tootltipGenerator = new StandardCategoryToolTipGenerator();

	String keyForMap = "Group "+group;
	String dateForgraph = "";
	String ValueForgraph = "";
	String datetime		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");

	ArrayList groupList = new ArrayList();
	ArrayList tempArrayList = new ArrayList();

	int sizeOfList = 0;
	int tempInt = 0;

	String datesForGrf = "";
	String valuesForGrf = "";
	String allDetailsForGraphs = "";
	String discrMsrDesc = "";
	String datesAndValues = "";
	String legendString = "";
	//String discrUOM = "";
	String tdDatesAndValues = "";
	String graphURL = "";
	String filename = "";
	String discrMsrID = ""; //IN058139
	StringTokenizer strTok = null;
	StringTokenizer detailsForGrf = null;
	StringTokenizer strTokenDatesAndValues = null;
	StringTokenizer strTkTdDatesAndValues = null;

	boolean create = false;

	try
	{
		groupList = (ArrayList) chartingBean.returnLists(keyForMap);
		sizeOfList = groupList.size();
		CategoryAxis xAxis = new CategoryAxis(datetime);
		CategoryPlot plot = new CategoryPlot();
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setDomainAxis(xAxis);

		for(int i=0; i< sizeOfList; i++)
		{
			strTok = new StringTokenizer((String) groupList.get(i),"~");
			discrMsrDesc = strTok.nextToken();
			datesAndValues = strTok.nextToken();
			legendString = strTok.nextToken();
			legendString = java.net.URLDecoder.decode(legendString);
			discrMsrID		=	 strTok.nextToken(); //IN058139
			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");

			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					if(tempInt % 2 == 0)
					{
						dateForgraph = strTkTdDatesAndValues.nextToken();
					}
					else
					{
						ValueForgraph = strTkTdDatesAndValues.nextToken();
						if(!ValueForgraph.equals(" "))
						{
							tempArrayList.add(dateForgraph+"`"+ValueForgraph);
						}
					}
					tempInt++;
				}
			}
			org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
			for(int j=0;j<tempArrayList.size();j++)
			{
				allDetailsForGraphs = (String) tempArrayList.get(j);
				detailsForGrf = new StringTokenizer(allDetailsForGraphs,"`");
				datesForGrf = (String) detailsForGrf.nextToken();
				valuesForGrf = (String) detailsForGrf.nextToken();

				dataset.addValue(Double.parseDouble(valuesForGrf),legendString,datesForGrf);

			}
			tempArrayList.clear();
			//IN058139 Start.			
			//IN059226 Starts			
			String retVal = chartingBean.getMinMaxValues(discrMsrID);
			String[]retArr = retVal.split("\\|");
			minValue = retArr[0].trim();
			maxValue = retArr[1].trim();
			//IN059226 Ends
			//IN058139 End.
				org.jfree.chart.axis.NumberAxis yAxis = new org.jfree.chart.axis.NumberAxis(legendString);
				//IN058139 Start.
				if(!"".equals(minValue)&&!"".equals(maxValue))
					yAxis.setRange(Integer.parseInt(minValue), Integer.parseInt(maxValue));
				//IN058139 End.
				plot.setRangeAxis(i, yAxis);
				plot.setRangeAxisLocation(i, org.jfree.chart.axis.AxisLocation.BOTTOM_OR_LEFT);

				plot.setDataset(i, dataset);
				plot.mapDatasetToRangeAxis(i, i);

				org.jfree.chart.renderer.category.LineAndShapeRenderer lineandshaperenderer = new org.jfree.chart.renderer.category.LineAndShapeRenderer();
				lineandshaperenderer.setShapesVisible(true);
				lineandshaperenderer.setLinesVisible(true);
				lineandshaperenderer.setDrawOutlines(true);
				lineandshaperenderer.setUseFillPaint(true);
				lineandshaperenderer.setFillPaint(Color.white);
				lineandshaperenderer.setToolTipGenerator(tootltipGenerator); 
				plot.setRenderer(i, lineandshaperenderer);
	
				yAxis.setLabelPaint(plot.getRenderer(i).getSeriesPaint(i));
				yAxis.setTickLabelPaint(plot.getRenderer(i).getSeriesPaint(i));
				plot.getRenderer(i).setSeriesPaint(0, plot.getRenderer(i).getSeriesPaint(i));
			
		}
		
		org.jfree.chart.JFreeChart chart = new org.jfree.chart.JFreeChart(keyForMap, plot);

		org.jfree.chart.ChartPanel chartpanel = new org.jfree.chart.ChartPanel(chart,false,false,false,true,true);
		chartpanel.setPreferredSize(new Dimension(360, 1500));
		chartpanel.setDisplayToolTips(true);
		

		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFMulCH");

		try
		{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,chartWidth,chartHeight,info,null);
			java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);
			if(file.exists())
			{
				out.println("<script>alert('file already exists');</script>");
			}
			else
				create = file.createNewFile();
			if(create)
			{
				org.jfree.chart.ChartUtilities.saveChartAsPNG(file,chart,chartWidth,chartHeight,info);
			}
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
		}	
		catch(Exception ee)
		{
			
			ee.printStackTrace();
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpecialGraph.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
