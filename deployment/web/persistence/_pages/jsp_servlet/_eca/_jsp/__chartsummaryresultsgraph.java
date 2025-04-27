package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eCA.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
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
import eCA.ChartComponentFormulaBean;
import java.text.SimpleDateFormat;
import org.jfree.data.category.DefaultCategoryDataset.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.block.*;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;

public final class __chartsummaryresultsgraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryResultsGraph.jsp", 1709115711590L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onKeyDown=\"lockKey()\">\n\t<form name=\'SplChartForm\' id=\'SplChartForm\'>\n\t\t<table>\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/></center>\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\t\t\n\t\t</table>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
29/01/2019	IN069608	Ramesh G	29/01/2019		Ramesh G		ML-BRU-SCF-1915
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Properties p			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
	String event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
	String histRecType = request.getParameter("histRecType") == null ? "" : request.getParameter("histRecType");
	//IN065341 starts
	String RepDb = request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
	String clob_data = request.getParameter("clob_data") == null ? "" : request.getParameter("clob_data");
	//IN065341 ends
	//IN058139 Start.
	ChartSummaryResultsBean bean = (ChartSummaryResultsBean)getObjectFromBean("chartSummaryResults","eCA.ChartSummaryResultsBean",session);
	bean.getMaxAndMinValues(event_code); 
	String minValue = bean.getMinValue(); 
	String maxValue = bean.getMaxValue(); 
	//IN058139 End.
	org.jfree.data.category.DefaultCategoryDataset defaultcategorydataset = new org.jfree.data.category.DefaultCategoryDataset();

	int chartWidth = 700;
	int chartHeight = 400;

	String keyForMap = "Group";
	String dateForgraph = "";
	String seriesForGraph = "";
	String ValueForgraph = "";
	String datetime		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
	String Values		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Values.label","common_labels");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();
	int indVal = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
	//IN065341 starts	
		//sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc from CR_ENCOUNTER_DETAIL a, CR_CLN_EVT_MST_LANG_VW b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");
		//sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc from CR_ENCOUNTER_DETAIL##REPDB## a, CR_CLN_EVT_MST_LANG_VW##REPDB## b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");//commented for IN069608
		sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc,a.event_date event_dt from CR_ENCOUNTER_DETAIL##REPDB## a, CR_CLN_EVT_MST_LANG_VW##REPDB## b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");//Modified for IN069608
	//IN065341 ends	
		if(!event_group.equals(""))
			sql.append("and a.EVENT_GROUP = ? ");
	//IN065341 starts	
		//sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id = ? ) where RANK_NO < 3 ) order by EVENT_DATE ");
		//sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id = ? ) where RANK_NO < 3 ) order by EVENT_DATE ");//commented for IN069608
		sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id = ? ) where RANK_NO < 3 ) order by event_dt ");//Modified for IN069608
		String result = sql.toString();
		result=result.replaceAll("##CLOB##",clob_data);
		result=result.replaceAll("##REPDB##",RepDb);
		pstmt = con.prepareStatement(result);
		//pstmt = con.prepareStatement(sql.toString());
	//IN065341 ends	
		pstmt.setString(indVal++,locale);
		pstmt.setString(indVal++,histRecType);
		if(!event_group.equals(""))
			pstmt.setString(indVal++,event_group);
		pstmt.setString(indVal++,event_code);
		pstmt.setString(indVal++,patient_id);
		pstmt.setString(indVal++,patient_id);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			dateForgraph = rs.getString("EVENT_DATE") == null ? "" : rs.getString("EVENT_DATE");
			dateForgraph = com.ehis.util.DateUtils.convertDate(dateForgraph,"DMYHM","en",locale);
			ValueForgraph = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");
			seriesForGraph = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			defaultcategorydataset.addValue(Double.parseDouble(ValueForgraph),seriesForGraph,dateForgraph);
		}
		if(rs!= null) rs.close();
        if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	JFreeChart jfreechart = ChartFactory.createLineChart(keyForMap, datetime, Values, defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
	CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
	NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();	
	//IN058139 Start.
	if(!"".equals(minValue)&&!"".equals(maxValue))
		numberaxis.setRange(Integer.parseInt(minValue), Integer.parseInt(maxValue));
	//IN058139 End.
	numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    org.jfree.chart.renderer.category.LineAndShapeRenderer lineandshaperenderer = (org.jfree.chart.renderer.category.LineAndShapeRenderer)categoryplot.getRenderer();

	lineandshaperenderer.setShapesVisible(true);
	lineandshaperenderer.setLinesVisible(true);
	lineandshaperenderer.setDrawOutlines(true);
	lineandshaperenderer.setUseFillPaint(true);
	lineandshaperenderer.setFillPaint(Color.white);
	
	org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
	org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFLiCH");
	

	String graphURL = "";
	String filename = "";

	try
	{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,chartHeight,info,null);
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
	}
	catch(Exception ee)
	{
		
		ee.printStackTrace();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block11Bytes, _wl_block11);
putObjectInBean("chartSummaryResults",bean,session); ////IN058139
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
