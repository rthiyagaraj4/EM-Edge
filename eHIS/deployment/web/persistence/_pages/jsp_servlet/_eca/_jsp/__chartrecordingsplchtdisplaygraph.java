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
import java.awt.*;
import java.io.*;
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

public final class __chartrecordingsplchtdisplaygraph extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingSplChtDisplayGraph.jsp", 1709115679543L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onUnload=\'callOnExit()\' onKeyDown=\"lockKey()\">\n\t\t<form name=\'GrowthChartForm\' id=\'GrowthChartForm\'>\n\t\t\t<table>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/></center>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<input type=\'hidden\' name=\'filename\' id=\'filename\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t</form>\n\t</body>\n\t<script>\n\t\tparent.parent.viewsFrame.splChtCustomViewFrame.document.forms[0].graph.disabled = false;\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");

	
            _bw.write(_wl_block2Bytes, _wl_block2);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement psX = null;
	PreparedStatement psForXAxis = null;
	PreparedStatement psForXAxisPatDtl = null;
	PreparedStatement psPatRecDtl = null;
	ResultSet res = null;
	ResultSet res2 = null;
	ResultSet res1 = null;
	ResultSet resX = null;
	ResultSet resForXAxis = null;
	ResultSet resForXAxisPatDtl = null;
	ResultSet resPatRecDtl = null;
	ArrayList prefArray=new  ArrayList();

	String splChartType = request.getParameter("splChartType") == null ? "GR" : request.getParameter("splChartType");	
	String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String chartID = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
	String Sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
	String splChtGrp = request.getParameter("splChtGrp") == null ? "" : request.getParameter("splChtGrp");
	String yAxisElementType = request.getParameter("yAxisElementType") == null ? "LN" : request.getParameter("yAxisElementType");	
		try
	{
		con = ConnectionManager.getConnection(request);
		// Block 1 Start:[This block using for get the percentails details in ASC order like P1,P3,P5,P11.....]
		try
		{
			String sqlStr="SELECT PREF_DESC  FROM CA_SPL_CHART_REF_DTL ORDER BY ABS(SUBSTR(PREF_DESC, 2))"; 
			ps1 = con.prepareStatement(sqlStr);	
			res1 = ps1.executeQuery();
			int i=0;
			while(res1.next())
			{
				String str= res1.getString("PREF_DESC")== null ? "" :res1.getString("PREF_DESC");
				prefArray.add(i,str);
				i++;
			}

			if(res1 != null) res1.close();
				if(ps1 != null) ps1.close();
		}catch(Exception e)
		{
		//	out.println("Exception in try of ChartRecordingSplChtDisplayGraph.jsp for Header Name"+e.toString());//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}
		//Block 1 End.
	
		org.jfree.data.xy.XYSeriesCollection xyseriescollection = new org.jfree.data.xy.XYSeriesCollection();
		org.jfree.chart.labels.StandardXYToolTipGenerator standardxytooltipgenerator = new org.jfree.chart.labels.StandardXYToolTipGenerator();
		org.jfree.chart.renderer.xy.XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
		
		org.jfree.data.xy.XYSeries xyseries=null;
		org.jfree.data.xy.XYSeries xyseries1=null;
		org.jfree.data.xy.XYSeries xyseries2=null;
		org.jfree.data.xy.XYSeries xyseries3=null;
		org.jfree.data.xy.XYSeries xyseries4=null;
		org.jfree.data.xy.XYSeries xyseries5=null;
		org.jfree.data.xy.XYSeries xyseries6=null;
		org.jfree.data.xy.XYSeries xyseries7=null;
		org.jfree.data.xy.XYSeries xyseries8=null;
		org.jfree.data.xy.XYSeries xyseries9=null;
		org.jfree.data.xy.XYSeries xyseries10=null;
		org.jfree.data.xy.XYSeries xyseries11=null;


		if(!((String)prefArray.get(0)).equals("P"))
			xyseries = new org.jfree.data.xy.XYSeries((String)prefArray.get(0), true, true);	
		if(!((String)prefArray.get(1)).equals("P"))
			xyseries1 = new org.jfree.data.xy.XYSeries((String)prefArray.get(1), true, true);	
		if(!((String)prefArray.get(2)).equals("P"))
			xyseries2 = new org.jfree.data.xy.XYSeries((String)prefArray.get(2), true, true);	
		if(!((String)prefArray.get(3)).equals("P"))
			xyseries3 = new org.jfree.data.xy.XYSeries((String)prefArray.get(3), true, true);	
		if(!((String)prefArray.get(4)).equals("P"))
			xyseries4 = new org.jfree.data.xy.XYSeries((String)prefArray.get(4), true, true);	
		if(!((String)prefArray.get(5)).equals("P"))
			xyseries5 = new org.jfree.data.xy.XYSeries((String)prefArray.get(5), true, true);	
		if(!((String)prefArray.get(6)).equals("P"))
			xyseries6 = new org.jfree.data.xy.XYSeries((String)prefArray.get(6), true, true);	
		if(!((String)prefArray.get(7)).equals("P"))
			xyseries7 = new org.jfree.data.xy.XYSeries((String)prefArray.get(7), true, true);	
		if(!((String)prefArray.get(8)).equals("P"))
			xyseries8 = new org.jfree.data.xy.XYSeries((String)prefArray.get(8), true, true);	
		if(!((String)prefArray.get(9)).equals("P"))
			xyseries9 = new org.jfree.data.xy.XYSeries((String)prefArray.get(9), true, true);		
		if(!((String)prefArray.get(10)).equals("P"))
			xyseries10 = new org.jfree.data.xy.XYSeries((String)prefArray.get(10), true, true);	
		if(!((String)prefArray.get(11)).equals("P"))
			xyseries11 = new org.jfree.data.xy.XYSeries((String)prefArray.get(11), true, true);
		
		String strPRDetails = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PRDetails.label","ca_labels");
		org.jfree.data.xy.XYSeries xyseriesPatRecDtl = new org.jfree.data.xy.XYSeries(strPRDetails, true, true);			//Patient Recorded data series

		String graphDesc = request.getParameter("graphDesc") == null ? "" : request.getParameter("graphDesc");
		String yAxisDesc = request.getParameter("yAxisDesc") == null ? "" : request.getParameter("yAxisDesc");
		String xAxisDesc = request.getParameter("xAxisDesc") == null ? "" : request.getParameter("xAxisDesc");
		if(graphDesc.equals("")) graphDesc = xAxisDesc + " Vs " + yAxisDesc;
		String xAxisElementType = request.getParameter("xAxisElementType") == null ? "" : request.getParameter("xAxisElementType");	
		
		String elementUOM = "";
		String elementUOMX = "";
		String elementDesc = "";
		String elementDescX = "";
		String legendYAxis = "";
		String legendXAxis = "";
		
		if(sentFrom.equals("userInput")){
			xAxisElementType = request.getParameter("xAxisVal") == null ? "" : request.getParameter("xAxisVal");
			yAxisElementType = request.getParameter("yAxisVal") == null ? "" : request.getParameter("yAxisVal");
		}
		
		float keyVal = 0.0f;
		float keyValForPatRecDtl = 0.0f;
		float transValue = 0.0f;

		float valP1 = 0.0f;
		float valP2 = 0.0f;
		float valP3 = 0.0f;
		float valP4 = 0.0f;
		float valP5 = 0.0f;
		float valP6 = 0.0f;
		float valP7 = 0.0f;
		float valP8 = 0.0f;
		float valP9 = 0.0f;
		float valP10 = 0.0f;
		float valP11 = 0.0f;
		float valP12 = 0.0f;		

		int count = 0;
		int countForPatRecDetails = 0;
		int displayCount = 0;
		int chartWidth = 10;

		StringBuffer sqlRefValue = new StringBuffer("SELECT key_value, pref1, pref2, pref3, pref4, pref5, pref6, pref7, pref8,pref9, pref10, pref11, pref12 FROM ca_spl_chart_ref_value WHERE spl_chart_type = ?  and (pref1 IS NOT NULL OR pref2 IS NOT NULL OR pref3 IS NOT NULL OR pref4 IS NOT NULL OR pref5 IS NOT NULL OR pref6 IS NOT NULL OR pref7 IS NOT NULL OR pref8 IS NOT NULL OR pref9 IS NOT NULL OR pref10 IS NOT NULL OR pref11 IS NOT NULL OR pref12 IS NOT NULL) AND element_type = ? AND x_element_type = ?");
		sqlRefValue.append(" AND gender = nvl((select gender from ca_spl_chart_ref_value WHERE spl_chart_type = ? AND gender = ? AND element_type = ? AND x_element_type = ? and (pref1 IS NOT NULL OR pref2 IS NOT NULL OR pref3 IS NOT NULL OR pref4 IS NOT NULL OR pref5 IS NOT NULL OR pref6 IS NOT NULL OR pref7 IS NOT NULL OR pref8 IS NOT NULL OR pref9 IS NOT NULL OR pref10 IS NOT NULL OR pref11 IS NOT NULL OR pref12 IS NOT NULL) and rownum=1 ");
		if(!splChtGrp.equals("")) 
			sqlRefValue.append(" AND spl_chart_type_grp_id = ? ");			
		sqlRefValue.append("),'*')");	
		if(!splChtGrp.equals("")) 
			sqlRefValue.append(" AND spl_chart_type_grp_id = ? ");

		String sqlElementDescUOM = "select ELEMENT_TYPE_DESC,DECODE(ELEMENT_UOM,'KM','Kg\\m2',ELEMENT_UOM) ELEMENT_UOM from CA_SPL_CHART_ELTY_LANG_VW where ELEMENT_TYPE = ? and language_id = ? ";

		StringBuffer sqlPatRecDtlwithAge = new StringBuffer("select KEY_VALUE, ELEMENT_TYPE, TRNS_VALUE from CA_SPL_CHART_PAT_REC_DTL where patient_id = ? and chart_id = ? AND ELEMENT_TYPE=?");
		if(!splChtGrp.equals("")) 
			sqlPatRecDtlwithAge.append(" and SPL_CHART_TYPE_GRP_ID = ?");
			
		StringBuffer sqlPatRecDtlWithOutAge = new StringBuffer("SELECT A.TRNS_VALUE KEY_VALUE,B.TRNS_VALUE TRNS_VALUE FROM CA_SPL_CHART_PAT_REC_DTL A,CA_SPL_CHART_PAT_REC_DTL B WHERE A.PATIENT_ID=B.PATIENT_ID AND  A.CHART_ID=B.CHART_ID AND A.KEY_VALUE=B.KEY_VALUE AND A.PATIENT_ID=? AND A.CHART_ID=? AND A.ELEMENT_TYPE=? AND B.ELEMENT_TYPE=?");
		if(!splChtGrp.equals("")) 
			sqlPatRecDtlWithOutAge.append(" AND A. SPL_CHART_TYPE_GRP_ID = ?");

		String sqlAge = "select distinct Decode(VALUE_UNIT,'M','Months','D','Days','W','Weeks','Y','Years') unit_val from CA_SPL_CHART_KEY_VALUE where SPL_CHART_TYPE_GRP_ID = ? and X_ELEMENT_TYPE='*K'";
		
		try
		{			
			if(!xAxisElementType.equals("*K"))
			{
				psX = con.prepareStatement(sqlElementDescUOM);
				psX.setString(1,xAxisElementType);
				psX.setString(2,locale);
				resX = psX.executeQuery();

				while(resX.next())
				{
					elementUOMX = resX.getString("ELEMENT_UOM");
					elementDescX = resX.getString("ELEMENT_TYPE_DESC");
				}

				legendXAxis = elementDescX +" (" + elementUOMX + ")";
			}
			else
			{
				ps = con.prepareStatement(sqlAge);
				ps.setString(1,splChtGrp);
				res = ps.executeQuery();
				
				if(res.next())
					legendXAxis = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels") + "(" + res.getString(1) + ")";

				if(res != null) res.close();
				if(ps != null) ps.close();				
			}			
		//Block 2 Start: This block getting Y-Axis values for Patient RecData.	
			if(xAxisElementType.equals("*K"))
			{
				psPatRecDtl = con.prepareStatement(sqlPatRecDtlwithAge.toString());
				psPatRecDtl.setString(1,patientID);
				psPatRecDtl.setString(2,chartID);
				psPatRecDtl.setString(3,yAxisElementType);
				if(!splChtGrp.equals("")) 
					psPatRecDtl.setString(4,splChtGrp);
				resPatRecDtl = psPatRecDtl.executeQuery();
			}else{
				psPatRecDtl = con.prepareStatement(sqlPatRecDtlWithOutAge.toString());
				psPatRecDtl.setString(1,patientID);
				psPatRecDtl.setString(2,chartID);
				psPatRecDtl.setString(3,xAxisElementType);
				psPatRecDtl.setString(4,yAxisElementType);
				if(!splChtGrp.equals("")) 
					psPatRecDtl.setString(5,splChtGrp);
				resPatRecDtl = psPatRecDtl.executeQuery();			
			}
		//Block 2 End.

		
		
		//Block 3 Start : This block genarating Y-Axis legend label.
			ps = con.prepareStatement(sqlElementDescUOM);
			ps.setString(1,yAxisElementType);
			ps.setString(2,locale);
			res = ps.executeQuery();

			while(res.next())
			{
				elementUOM = res.getString("ELEMENT_UOM");
				elementDesc = res.getString("ELEMENT_TYPE_DESC");
			}

			if(res2 != null) res2.close();
			if(res != null) res.close();
			if(ps != null) ps.close();

			legendYAxis = elementDesc +" (" + elementUOM + ")";
		//Block 3 End.
		
		//Block 4 Start : This block getting Y-Axis reference vlaues.
			System.out.println("ChartRecordingSplChtDisplayGraph.jsp.284-sqlRefValue.toString()->"+sqlRefValue.toString());
			ps = con.prepareStatement(sqlRefValue.toString());
			psForXAxis = con.prepareStatement(sqlRefValue.toString());
			ps.setString(1,splChartType);
			ps.setString(2,yAxisElementType);
			ps.setString(3,xAxisElementType);			
			ps.setString(4,splChartType);
			ps.setString(5,Sex);
			ps.setString(6,yAxisElementType);
			ps.setString(7,xAxisElementType);			
			if(!splChtGrp.equals(""))
			{
				ps.setString(8,splChtGrp);	
				ps.setString(9,splChtGrp);	
			}			
			res2 = ps.executeQuery();
		//Block 4 End.		
		
			while(res2 != null && res2.next())
			{			
				keyVal = res2.getFloat("KEY_VALUE");
				valP1 = res2.getFloat("PREF1");						
				valP2 = res2.getFloat("PREF2");
				valP3 = res2.getFloat("PREF3");
				valP4 = res2.getFloat("PREF4");
				valP5 = res2.getFloat("PREF5");
				valP6 = res2.getFloat("PREF6");
				valP7 = res2.getFloat("PREF7");
				valP8 = res2.getFloat("PREF8");
				valP9 = res2.getFloat("PREF9");
				valP10 = res2.getFloat("PREF10");
				valP11 = res2.getFloat("PREF11");
				valP12 = res2.getFloat("PREF12");
				
				if(!((String)prefArray.get(0)).equals("P"))				
					xyseries.add(keyVal, valP1);
				if(!((String)prefArray.get(1)).equals("P"))	
					xyseries1.add(keyVal, valP2);
				if(!((String)prefArray.get(2)).equals("P"))
					xyseries2.add(keyVal, valP3);
				if(!((String)prefArray.get(3)).equals("P"))
					xyseries3.add(keyVal, valP4);
				if(!((String)prefArray.get(4)).equals("P"))
					xyseries4.add(keyVal, valP5);
				if(!((String)prefArray.get(5)).equals("P"))
					xyseries5.add(keyVal, valP6);
				if(!((String)prefArray.get(6)).equals("P"))
					xyseries6.add(keyVal, valP7);
				if(!((String)prefArray.get(7)).equals("P"))
					xyseries7.add(keyVal, valP8);
				if(!((String)prefArray.get(8)).equals("P"))
					xyseries8.add(keyVal, valP9);
				if(!((String)prefArray.get(9)).equals("P"))
					xyseries9.add(keyVal, valP10);
				if(!((String)prefArray.get(10)).equals("P"))
					xyseries10.add(keyVal, valP11);
				if(!((String)prefArray.get(11)).equals("P"))
					xyseries11.add(keyVal, valP12);
				
				count++;
			}

			while(resPatRecDtl.next())
			{
				keyValForPatRecDtl = resPatRecDtl.getFloat("KEY_VALUE");
				transValue = resPatRecDtl.getFloat("TRNS_VALUE");
				xyseriesPatRecDtl.add(keyValForPatRecDtl,transValue);
				
				countForPatRecDetails++;
			}

			
				if(count != 0)
				{
					if(!((String)prefArray.get(0)).equals("P"))
						xyseriescollection.addSeries(xyseries);
					if(!((String)prefArray.get(1)).equals("P"))
						xyseriescollection.addSeries(xyseries1);
					if(!((String)prefArray.get(2)).equals("P"))
						xyseriescollection.addSeries(xyseries2);
					if(!((String)prefArray.get(3)).equals("P"))
						xyseriescollection.addSeries(xyseries3);
					if(!((String)prefArray.get(4)).equals("P"))
						xyseriescollection.addSeries(xyseries4);
					if(!((String)prefArray.get(5)).equals("P"))
						xyseriescollection.addSeries(xyseries5);
					if(!((String)prefArray.get(6)).equals("P"))
						xyseriescollection.addSeries(xyseries6);
					if(!((String)prefArray.get(7)).equals("P"))
						xyseriescollection.addSeries(xyseries7);
					if(!((String)prefArray.get(8)).equals("P"))
						xyseriescollection.addSeries(xyseries8);
					if(!((String)prefArray.get(9)).equals("P"))
						xyseriescollection.addSeries(xyseries9);
					if(!((String)prefArray.get(10)).equals("P"))
						xyseriescollection.addSeries(xyseries10);
					if(!((String)prefArray.get(11)).equals("P"))
						xyseriescollection.addSeries(xyseries11);
				}
				xyseriescollection.addSeries(xyseriesPatRecDtl);
			
			xyseriescollection.setAutoWidth(true);
		
			if(count != 0 || countForPatRecDetails != 0)
			{
				if(count != 0)
					displayCount = count;
				else
					displayCount = countForPatRecDetails;

				chartWidth = (400*displayCount) / 15;

				if(chartWidth < 250) chartWidth = 500;

			}
			else
			{
				out.println("<script>alert(getMessage('NO_DATA_AVAILABLE','CA'));</script>");
				out.println("<script>parent.parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;</script>");
				out.println("<script>document.location.href='../../eCommon/html/blank.html';</script>");
			}

			if(res != null) res.close();
			if(res2 != null) res2.close();
			if(resX != null) resX.close();
			if(resForXAxis != null) resForXAxis.close();
			if(resForXAxisPatDtl != null) resForXAxisPatDtl.close();
			if(resPatRecDtl != null) resPatRecDtl.close();
			if(ps != null) ps.close();
			if(psX != null) psX.close();
			if(psForXAxis != null) psForXAxis.close();
			if(psForXAxisPatDtl != null) psForXAxisPatDtl.close();
			if(psPatRecDtl != null) psPatRecDtl.close();
		}
		catch(Exception excep)
		{
			//out.println("Exception in try main of ChartRecordingSplChtDisplayGraph.jsp --"+excep.toString());//COMMON-ICN-0181
			excep.printStackTrace();
		}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}

		org.jfree.chart.JFreeChart jfreechart = org.jfree.chart.ChartFactory.createXYLineChart(graphDesc, legendXAxis, legendYAxis, xyseriescollection, org.jfree.chart.plot.PlotOrientation.VERTICAL, true,true,false);

		org.jfree.chart.plot.XYPlot xyplot = jfreechart.getXYPlot();
		xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();	
		xylineandshaperenderer.setToolTipGenerator(standardxytooltipgenerator);
		org.jfree.chart.ChartPanel chartpanel = new org.jfree.chart.ChartPanel(jfreechart,false,false,false,true,true);
		chartpanel.setPreferredSize(new Dimension(360, 1500));
		chartpanel.setDisplayToolTips(true);
		chartpanel.setDomainZoomable(true);
		if(count != 0)
		{
			xylineandshaperenderer.setSeriesShapesVisible((xyseriescollection.getSeriesCount()-1),true);
		}
		else
		{
			xylineandshaperenderer.setSeriesShapesVisible(0,true);
		}

		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFGrCH");
		
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

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block11Bytes, _wl_block11);

		java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);
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

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	catch(Exception connleakage)
	{
		
		connleakage.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
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
