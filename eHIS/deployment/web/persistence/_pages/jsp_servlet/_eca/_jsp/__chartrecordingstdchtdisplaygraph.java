package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
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
import org.jfree.chart.renderer.*;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import javax.swing.JPanel;
import org.jfree.chart.title.LegendTitle;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingstdchtdisplaygraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingStdChtDisplayGraph.jsp", 1738756933954L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\tRev.Name\tDescription\n--------------------------------------------------------------------------------------------------------------------------------\n24/07/2020  \tIN073071\tsivabagyam M \t24/07/2020\t\tRamesh G\t\tCA-COMMON-VIEW GRAPH\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n--------------------------------------------------------------------------------------------------------------------------------\n*/\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<body onUnload=\'callOnExit()\' onKeyDown=\"lockKey()\">\n\t\t<form name=\'ComparisionForm\' id=\'ComparisionForm\'>\n\t\t\t<table>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/></center>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<input type=\'hidden\' name=\'filename\' id=\'filename\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t</form>\n\t</body>\n\t<script>\n\t\t//parent.parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;\n\t\tparent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	org.jfree.data.xy.XYSeriesCollection xyseriescollection = new org.jfree.data.xy.XYSeriesCollection();
	org.jfree.chart.labels.StandardXYToolTipGenerator standardxytooltipgenerator = new org.jfree.chart.labels.StandardXYToolTipGenerator();
	org.jfree.chart.renderer.xy.XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);

	org.jfree.data.xy.XYSeries xyseriesPatRecDtl = new org.jfree.data.xy.XYSeries("", false, true);

	String graphDesc = "";
	String xAxisElementType = request.getParameter("xAxisElementType") == null ? "" : request.getParameter("xAxisElementType");
	String yAxisElementType = request.getParameter("yAxisElementType") == null ? "" : request.getParameter("yAxisElementType");
	String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String chartID = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
	String allDatesForGraph = request.getParameter("allDatesForGraph") == null ?"" : request.getParameter("allDatesForGraph");
	StringTokenizer strTokDates = new StringTokenizer(allDatesForGraph,"$$");
	String allDatesForGrf = "";
		
	String legendYAxis	= "";
	String legendXAxis	= "";
	String XAxisUOM		= "";
	String YAxisUOM		= "";
	String XAxisResult	= "";
	String YAxisResult	= "";
	String XAxisdesc	= "";
	String YAxisdesc	= "";
	String sql			= "";
	//ArrayList list		= new ArrayList();

	if(sentFrom.equals("userInput"))
	{
		xAxisElementType = request.getParameter("xAxisVal") == null ? "" : request.getParameter("xAxisVal");
		yAxisElementType = request.getParameter("yAxisVal") == null ? "" : request.getParameter("yAxisVal");
	}

	int count = 0;
	int chartWidth = 10;

	sql = "select a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_NUM, AM_GET_DESC.AM_DISCR_MSR(b.DISCR_MSR_ID,?,'2') short_desc from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b,  AM_DISCR_MSR I where a.CHART_ID = ? and a.patient_id = ? and a.TEST_OBSERV_DT_TM = to_date(?,'DD/MM/YYYY HH24:MI') and nvl(ERROR_YN,'N') != 'Y' and b.CHART_ID  =a.CHART_ID   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID  AND I.DISCR_MSR_ID=a.DISCR_MSR_ID and b.DISCR_MSR_ID = ? order by B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";

	Connection con = null;
	PreparedStatement psForXAxisPatDtl = null;
	PreparedStatement psForYAxisPatDtl = null;
	ResultSet resForXAxisPatDtl = null;
	ResultSet resForYAxisPatDtl = null;

	try
	{
		con = ConnectionManager.getConnection(request);
		psForXAxisPatDtl = con.prepareStatement(sql.toString());
		psForYAxisPatDtl = con.prepareStatement(sql.toString());

		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			allDatesForGrf = com.ehis.util.DateUtils.convertDate(allDatesForGrf,"DMYHM", locale,"en");

			psForXAxisPatDtl.setString(1,locale);
			psForXAxisPatDtl.setString(2,chartID);
			psForXAxisPatDtl.setString(3,patientID);
			psForXAxisPatDtl.setString(4,allDatesForGrf);
			psForXAxisPatDtl.setString(5,xAxisElementType);
			resForXAxisPatDtl = psForXAxisPatDtl.executeQuery();

			psForYAxisPatDtl.setString(1,locale);
			psForYAxisPatDtl.setString(2,chartID);
			psForYAxisPatDtl.setString(3,patientID);
			psForYAxisPatDtl.setString(4,allDatesForGrf);
			psForYAxisPatDtl.setString(5,yAxisElementType);
			resForYAxisPatDtl = psForYAxisPatDtl.executeQuery();

			if(resForXAxisPatDtl.next() && resForYAxisPatDtl.next())
			{

				XAxisUOM = resForXAxisPatDtl.getString(1) == null ? "" : resForXAxisPatDtl.getString(1);
				XAxisResult = resForXAxisPatDtl.getString(2) == null ? "" : resForXAxisPatDtl.getString(2);
				XAxisdesc = resForXAxisPatDtl.getString(3) == null ? "" : resForXAxisPatDtl.getString(3);

				YAxisUOM = resForYAxisPatDtl.getString(1) == null ? "" : resForYAxisPatDtl.getString(1);
				YAxisResult = resForYAxisPatDtl.getString(2) == null? "" : resForYAxisPatDtl.getString(2);
				YAxisdesc = resForYAxisPatDtl.getString(3) == null ? "" : resForYAxisPatDtl.getString(3);
				
				if(!XAxisResult.equals("") && !YAxisResult.equals(""))
				{
					xyseriesPatRecDtl.setKey("("+XAxisdesc+","+YAxisdesc+")");
					//xyseriesPatRecDtl.fireSeriesChanged();
					xyseriesPatRecDtl.add(Double.parseDouble(XAxisResult),Double.parseDouble(YAxisResult));
					count++;
				}
				graphDesc = XAxisdesc+"  (Vs)  "+YAxisdesc;

				if(!XAxisUOM.equals(""))
					legendXAxis = XAxisdesc+" (" + XAxisUOM + ")";
				else
					legendXAxis = XAxisdesc;
				if(!YAxisUOM.equals(""))
					legendYAxis = YAxisdesc+" (" + YAxisUOM + ")";
				else
					legendYAxis = YAxisdesc;
			}
			if(resForXAxisPatDtl != null) resForXAxisPatDtl.close();
			if(resForYAxisPatDtl != null) resForYAxisPatDtl.close();
		}
	

		xyseriescollection.addSeries(xyseriesPatRecDtl);
			
		xyseriescollection.setAutoWidth(true);
				
		if(count != 0)
		{
			chartWidth = 800;
		}
		else
		{
			out.println("<script>alert(getMessage('NO_DATA_AVAILABLE','CA'));</script>");
			out.println("<script>parent.parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;</script>");
			out.println("<script>document.location.href='../../eCommon/html/blank.html';</script>");
		}

		
		if(psForXAxisPatDtl != null) psForXAxisPatDtl.close();
		if(psForYAxisPatDtl != null) psForYAxisPatDtl.close();
	
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

	org.jfree.chart.JFreeChart jfreechart = org.jfree.chart.ChartFactory.createXYLineChart(graphDesc, legendXAxis, legendYAxis, xyseriescollection, org.jfree.chart.plot.PlotOrientation.VERTICAL, false,true,false);

	org.jfree.chart.plot.XYPlot xyplot = jfreechart.getXYPlot();
	xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();	
	xylineandshaperenderer.setToolTipGenerator(standardxytooltipgenerator);
	org.jfree.chart.ChartPanel chartpanel = new org.jfree.chart.ChartPanel(jfreechart,false,false,false,true,true);
    chartpanel.setPreferredSize(new Dimension(360, 1500));
    chartpanel.setDisplayToolTips(true);
    chartpanel.setDomainZoomable(true);
	
	xylineandshaperenderer.setSeriesShapesVisible(0,true);
	
	org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
	org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFStdCH");
	
	String graphURL = "";
	String filename = "";
	boolean create = false;

	try
	{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,650,info,null);
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
	}
	catch(Exception ee)
	{
		//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181		
	}	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block12Bytes, _wl_block12);

		//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);//IN073071

		java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);//IN073071

		if(file.exists())
		{
			out.println("<script>alert('file already exists');</script>");
		}
		else
			create = file.createNewFile();
		if(create)
		{
			org.jfree.chart.ChartUtilities.saveChartAsPNG(file,jfreechart,chartWidth,600,info);
		}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComparisionGraph.label", java.lang.String .class,"key"));
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
