package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.geom.*;
import java.text.*;
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
import org.jfree.data.time.*;
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

public final class __viewchartrecordinggraphpopulation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartRecordingGraphPopulation.jsp", 1709116431807L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=\"javascript\" src=\"../../eCA/js/ViewChartRecording.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<body>\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\'ViewChartGraphForm\' id=\'ViewChartGraphForm\'>\n\t\t<table border=\"0\" cellpadding=\"0\"  cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr style=\"height:10px;\"><td valign=\"middle\" colspan=\"2\">\n\t\t\t\t<table border=\"0\" bgcolor=\'white\' cellpadding=\"0\"  cellspacing=\"0\" width=\"100%\">\n\t\t\t\t\t<tr><td width=\"80%\">&nbsp;</td><td style=\"padding-right:5px;\" align=\"right\" width=\"10%\" id=\"pGNavegator\">&nbsp;</td><td style=\"padding-left:5px;\" align=\"left\" width=\"10%\" id=\"nGNavegator\">&nbsp;</td></tr>\n\t\t\t\t</table>\n\t\t\t</td></tr>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr style=\'padding-bottom:5px;\'>\n\t\t\t\t\t\t\t<td width=\'98%\'>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<center><img  src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" border=0 usemap=\"#";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></center>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'2%\' valign=\"top\"><A HREF=\"javascript:openZoom(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\">Zoom</A>&nbsp;&nbsp;<A HREF=\"javascript:printGraph(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\">Print</A></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\t\t\n\t\t\t\t\t<!--<TR>\n\t\t\t\t\t\t<TD   width=\'100%\'><font size=\"1\">\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</font></TD>\n\t\t\t\t\t</TR> -->\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\n\t\t\t\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"tDisplayDays\" id=\"tDisplayDays\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t<input type=\"hidden\" name=\"tTotalRows\" id=\"tTotalRows\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n\t\t<input type=hidden name=\'chart_id\' id=\'chart_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=hidden name=\'toDateForExt\' id=\'toDateForExt\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=hidden name=\'fromDateForExt\' id=\'fromDateForExt\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t</form>\n\t<script>\nvar disDays=parseInt(document.ViewChartGraphForm.tDisplayDays.value);\nvar totDays=parseInt(document.ViewChartGraphForm.tTotalRows.value);\nif(totDays>disDays){\n\tdocument.getElementById(\"nGNavegator\").innerHTML=\"<A href=\\\"javascript:clickNextforGraph();\\\">Next</A>\";\n}else{\n\tdocument.getElementById(\"nGNavegator\").innerHTML=\"&nbsp;\";\n}\nif(disDays>5){\n\tdocument.getElementById(\"pGNavegator\").innerHTML=\"<A href=\\\"javascript:clickPreviousforGraph();\\\">Previous</A>\";\n}else{\n\tdocument.getElementById(\"pGNavegator\").innerHTML=\"&nbsp;\";\n}\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
29/03/2012		IN032043		Ramesh G		CA>Chart View>Zoom>graph cannot be viewed or printed.
29/03/2012		IN032065		Ramesh G		The Components whose format is defined as Graph in Define graph Components is not displayed in Chart View.
12/06/2020		IN073152		Durga Natarajan			Graph view function cannot display graph 
---------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String chartId = (String)request.getParameter("Chart_Id");
	String fromDate = (String)request.getParameter("FromDate");
	String toDate = (String)request.getParameter("ToDate");
	//String encounterId = (String)request.getParameter("EncounterID");
	String encounterId = request.getParameter("EncounterID")==null?"0":(String)request.getParameter("EncounterID");
	String facilityId = (String)request.getParameter("FacilityID");
	String patientId = (String)request.getParameter("PatientID");
	String fromDate1 =	com.ehis.util.DateUtils.convertDate(fromDate,"DMY", locale,"en");
	String toDate1	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY", locale,"en");

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs= null;
			ResultSet rs1= null;
			ArrayList dateArray = new ArrayList();
			ArrayList hoursArray = new ArrayList();
			int displayDays=0;
			int totDates=0;


			
			try{
				int nIndex =1;//common-icn-0180
				con = ConnectionManager.getConnection(request);	
				StringBuffer datequery = new StringBuffer();
				
				datequery.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
				//datequery.append("WHERE b.chart_id = '"+chartId+"' ");//common-icn-0180
				datequery.append("WHERE b.chart_id = ? ");//common-icn-0180
				datequery.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  "); 
				datequery.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I')  ");
				datequery.append("AND a.discr_msr_id = d.discr_msr_id  ");
				datequery.append("AND b.discr_msr_id = d.discr_msr_id  ");
				datequery.append("AND d.FORMAT_TYPE = 'G'  ");
				//datequery.append("AND a.facility_id = '"+facilityId+"'  ");//common-icn-0180
				//datequery.append("AND a.patient_id = '"+patientId+"'  ");//common-icn-0180
				datequery.append("AND a.facility_id = ?  ");//common-icn-0180
				datequery.append("AND a.patient_id = ?  ");//common-icn-0180
				//datequery.append("AND b.encounter_id = '"+encounterId+"'  ");  
				if(!"0".equals(encounterId)){
					//datequery.append("AND b.encounter_id = '"+encounterId+"'  ");  //common-icn-0180
					datequery.append("AND b.encounter_id = ?  "); //common-icn-0180 
				}
				datequery.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+fromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+toDate1+" 23:59', 'dd/mm/yyyy hh24:mi') ");                                                          
				datequery.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
				pstmt = con.prepareStatement(datequery.toString());
				//common-icn-0180 starts
				pstmt.setString(nIndex++,chartId);
				pstmt.setString(nIndex++,facilityId);
				pstmt.setString(nIndex++,patientId);
				if(!"0".equals(encounterId)){
				pstmt.setString(nIndex++,encounterId);
				}
				//common-icn-0180 ends
				rs = pstmt.executeQuery();
				while(rs.next()){
					dateArray.add(rs.getString(1));
				}
				if(dateArray.size()>0){

					List<String> rangeDates = new ArrayList<String>();
					String str_date ="27/08/2010";
					String end_date ="02/09/2010";

					DateFormat formatter ; 
					
					formatter = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date  startDate = (java.util.Date)formatter.parse(fromDate1); 
					java.util.Date  endDate = (java.util.Date)formatter.parse(toDate1);
					long interval = 24*1000 * 60 * 60; // 1 hour in millis
					long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
					long curTime = startDate.getTime();
					while (curTime <= endTime) {
						rangeDates.add(formatter.format(new java.util.Date(curTime)));
						curTime += interval;
					}
					
					
					totDates=rangeDates.size();
					displayDays = (String)request.getParameter("Display_Days")==null?0:Integer.parseInt((String)request.getParameter("Display_Days"));
					
					int dDate = displayDays;
					String dStartDate="";
					String dEndDate ="";
					int noOfDays = ((rangeDates.size())-displayDays)>5?(displayDays+5):(rangeDates.size());
					for(;displayDays<noOfDays;displayDays++){						
						String hValue=(String)rangeDates.get(displayDays);
						if(dDate==displayDays){
							dStartDate=hValue;
						}
						if(displayDays==(noOfDays-1)){
							dEndDate=hValue;
						}	
					}					
				
					eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
					HashMap graphData = new HashMap();
					//graphData = (HashMap) bean.getChartData(patientId,facilityId,encounterId,fromDate,toDate,chartId,"G");					
					graphData = (HashMap) bean.getChartData(patientId,facilityId,encounterId,dStartDate+" 0:00",dEndDate+" 23:59",chartId,"G");	
					Set resSet = graphData.keySet();
					
					Iterator iterator = graphData.keySet().iterator();
					StringBuffer charCompIds= new StringBuffer();
					int charCompCount=0;
					while(iterator. hasNext()){ 
						charCompIds.append("'"+iterator.next()+"'");
						charCompCount++;
						if(charCompCount!=(resSet.size())){
							charCompIds.append(",");
						}
					}
				
					
					StringBuffer query = new StringBuffer();
					query.append("Select CVCC.DISCR_MSR_ID,ADM.SHORT_DESC,CVCC.X_AXIS_SCALE,CVCC.Y_AXIS_SCALE,CVCC.MIN_Y_AXIS,CVCC.MAX_Y_AXIS FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE CVCC.DISCR_MSR_ID =ADM.DISCR_MSR_ID AND CVCC.CHART_ID='");
					query.append(chartId);
					query.append("' AND CVCC.FORMAT_TYPE='G' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");

					//query.append("' AND CVCC.DISCR_MSR_ID IN (");
					//query.append(charCompIds.toString());
					//query.append(") ORDER BY CVCC.DISP_ORD_SEQ_NUM");
					
					pstmt = con.prepareStatement(query.toString());
					rs = pstmt.executeQuery();
					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");		
					DateFormat fyear = new SimpleDateFormat("yyyy");
					DateFormat fmonth = new SimpleDateFormat("MM");
					DateFormat fdate = new SimpleDateFormat("dd");
					DateFormat fHour = new SimpleDateFormat("HH");
					DateFormat fmin = new SimpleDateFormat("mm");
					while(rs.next()){
						int chartWidth = 1000;
						int chartHeight = 160;
						final TimeSeries series1 = new TimeSeries("Date/Time", Minute.class);
						
						
						
						String disMsr_id	= (String)rs.getString(1);
						String disMsr_name	= (String)rs.getString(2);
						String xScal		= (String)rs.getString(3);
						String yScal		= (String)rs.getString(4);
						String yMin			= (String)rs.getString(5);
						String yMax			= (String)rs.getString(6);
						
						ArrayList mainArray = new ArrayList();
						
						
						
						
						//System.out.println(disMsr_id+"<---------------------->"+mainArray.size());
						//5 is a no of Days each page
					//	int noOfDays = (mainArray.size())>5 ? 5 :(mainArray.size());
					    if(graphData.size()>0){
							
							if(graphData.get(disMsr_id)!=null){
								mainArray =(ArrayList)graphData.get(disMsr_id);
							}
							int totRetReco = mainArray.size();
							
							String[] str=new String[totRetReco];
							for(int i=0;i<totRetReco;i++){  
								HashMap fMap = new HashMap();
								fMap = (HashMap)mainArray.get(i);
								
								Iterator fiterator = fMap.keySet().iterator();						
								if(fiterator. hasNext())
									str[i] = (String)fiterator.next();		//Day
								ArrayList subArray = new ArrayList();
								subArray = (ArrayList) fMap.get(str[i]);
								
								for(int j=0;j<subArray.size();j++){
									HashMap sMap = (HashMap)subArray.get(j);
									Iterator siterator = sMap.keySet().iterator();
									String recordDate="";
									String rvalue = "";
									if(siterator. hasNext())
										recordDate= (String)siterator.next();		
									rvalue =(String) sMap.get(recordDate);
									
									java.util.Date dt=df.parse(recordDate);
									series1.add(new Minute(Integer.parseInt(fmin.format(dt)),Integer.parseInt(fHour.format(dt)),Integer.parseInt(fdate.format(dt)),Integer.parseInt(fmonth.format(dt)),Integer.parseInt(fyear.format(dt))),Double.parseDouble(rvalue));
								}
								
							}
						
						}

						
						final TimeSeriesCollection dataset1 = new TimeSeriesCollection();
						dataset1.addSeries(series1);
						
						XYLineAndShapeRenderer shapeRender=new XYLineAndShapeRenderer();
						shapeRender.setShapesFilled(true);
						shapeRender.setSeriesShape(0, new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));
						shapeRender.setLinesVisible(true);
						shapeRender.setDrawOutlines(false);
						shapeRender.setToolTipGenerator(
								new StandardXYToolTipGenerator(
										"({1}, {2})",
									new SimpleDateFormat("HH:mm"), new DecimalFormat("###.##")
								)
							);
			
						JFreeChart chart = null;
						JFreeChart chart1 = null;

						// make a common vertical axis for all the sub-plots
						final NumberAxis valueAxis = new NumberAxis("Values");
						valueAxis.setAutoRangeIncludesZero(false);  // override default
						valueAxis.setRange(Double.parseDouble(yMin), Double.parseDouble(yMax));
			
						TickUnits units = new TickUnits();
						units.add(new NumberTickUnit(Double.parseDouble(yScal)));
						valueAxis.setStandardTickUnits(units);

						// make a horizontally combined plot
						final CombinedRangeXYPlot parent = new CombinedRangeXYPlot(valueAxis);
			
			
			
						// Common
						DateFormat chartFormatter = new SimpleDateFormat("dd MMM HH:mm");
			
						
				

						// add subplot 1...
						final XYPlot subplot1 = new XYPlot(dataset1, new DateAxis(""), null,shapeRender);
						subplot1.setDomainCrosshairVisible(true);
						subplot1.setRangeCrosshairVisible(true);
						
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
						
						/*for(int k=0;k<str.length;k++){
							//System.out.println(k+"str---------------------->"+str[k]);
							java.util.Date dt1=df1.parse(str[k]);
							
							final Hour hour1 = new Hour(0, new Day(Integer.parseInt(fdate.format(dt1)), Integer.parseInt(fmonth.format(dt1)), Integer.parseInt(fyear.format(dt1))));		
							double millis1 = hour1.getFirstMillisecond();        
							final Marker originalEnd1 = new ValueMarker(millis1);
							originalEnd1.setPaint(Color.darkGray);
							originalEnd1.setStroke(new BasicStroke(1.0f));
							originalEnd1.setLabelAnchor(RectangleAnchor.TOP_LEFT);
							originalEnd1.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
							
							subplot1.addDomainMarker(originalEnd1);
						}*/

						final DateAxis axis = new DateAxis() {
							@SuppressWarnings("unchecked")
							@Override
							protected List refreshTicksHorizontal(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) {
							   List ticks = super.refreshTicksHorizontal(g2, dataArea, edge);
							   List ret = new ArrayList();
							   for (Tick tick : (List<Tick>)ticks) {
								  if (tick instanceof DateTick) {
									 DateTick dateTick = (DateTick)tick;
									 ret.add(new DateTick(dateTick.getDate(), dateTick.getText(), dateTick.getTextAnchor(), dateTick.getRotationAnchor(), Math.PI / -5.0));
								  } else {
									 ret.add(tick);
								  }
							   }
							   return ret;
							}
							protected double findMaximumTickLabelHeight(java.util.List ticks, java.awt.Graphics2D g2, java.awt.geom.Rectangle2D drawArea, boolean vertical) {                  
							   return super.findMaximumTickLabelHeight(ticks, g2, drawArea, vertical) * Math.sin(Math.PI / 5.0);
							}                                                     
						 };
						 axis.setVerticalTickLabels(true); 
						 axis.setDateFormatOverride(chartFormatter);
						 
						 axis.setDateFormatOverride(chartFormatter);
						 DateTickUnit unit1 = new DateTickUnit(DateTickUnit.HOUR,Integer.parseInt(xScal	));
						 axis.setTickUnit(unit1);
									
						java.util.Date dtStart=df1.parse(dStartDate);
						java.util.Date dtEnd=df1.parse(dEndDate);
						
						final Hour minhour1 = new Hour(0, new Day(Integer.parseInt(fdate.format(dtStart)), Integer.parseInt(fmonth.format(dtStart)), Integer.parseInt(fyear.format(dtStart))));		
						double minmillis1 = minhour1.getFirstMillisecond(); 
						final Hour maxhour1 = new Hour(24, new Day(Integer.parseInt(fdate.format(dtEnd)), Integer.parseInt(fmonth.format(dtEnd)), Integer.parseInt(fyear.format(dtEnd))));		
						double maxmillis1 = maxhour1.getFirstMillisecond(); 
						axis.setRange(minmillis1, maxmillis1);
		   
						subplot1.setDomainAxis(0, axis);
		   
					String narmallow ="0";
					String narmalHigh = "0";
		   
					StringBuffer query1 = new StringBuffer();
					query1.append("SELECT NUM_REF_LOW,NUM_REF_HIGH FROM AM_DISCR_MSR_REF_RNG_NUM WHERE  DISCR_MSR_ID IN ('");
					query1.append(disMsr_id);
					query1.append("')");
					
					pstmt = con.prepareStatement(query1.toString());
					rs1 = pstmt.executeQuery();
					if(rs1.next()){
						narmallow = rs1.getString(1)==null?"0":(String)rs1.getString(1);
						narmalHigh = rs1.getString(2)==null?"0":(String)rs1.getString(2);
					}
					
					if(!"0".equals(narmallow) && !"0".equals(narmalHigh)){
						final IntervalMarker bol=new IntervalMarker(Double.parseDouble(narmallow),Double.parseDouble(narmalHigh));				
						bol.setPaint(new Color(50, 205, 50));		   
							subplot1.addRangeMarker(bol, Layer.BACKGROUND);	
					}	
						
			
						parent.add(subplot1, 1);
			

						chart = new JFreeChart(disMsr_name, JFreeChart.DEFAULT_TITLE_FONT, parent, true);

			

						org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
						
						String graphURL = "";
						String graphPrintURL="";
						String filename = "";
						String filename1 = "";
						boolean create = false;

						try
						{
							filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,chartWidth,chartHeight,info,null);
							//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);//Commented for IN073152
							java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);//IN073152
							System.out.println("ViewChartRecordingGraphPopulation.jsp---file---->"+config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);
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

							filename1 = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,1000,350,info,null);
						//	java.io.File file1 = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename1);//Commented for IN073152
							java.io.File file1 = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename1);//IN073152
							System.out.println("ViewChartRecordingGraphPopulation.jsp---file1---->"+config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename1);
							if(file1.exists())
							{
								out.println("<script>alert('file already exists');</script>");
							}
							else
								create = file1.createNewFile();
							if(create)
							{
								org.jfree.chart.ChartUtilities.saveChartAsPNG(file1,chart,1000,350,info);
							}
							org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename1,info,false);
							graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
							graphPrintURL=request.getContextPath()+"/eCA/MediPainter/images/"+filename1;
						}
						catch(Exception ee)
						{
							//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
							ee.printStackTrace();
						}	
						
						
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(graphURL));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(filename));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(disMsr_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(filename1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(graphPrintURL));
            _bw.write(_wl_block12Bytes, _wl_block12);

						
						
					}
				}//else{
				
            _bw.write(_wl_block13Bytes, _wl_block13);

				//}
			}catch(Exception e){
				//out.println(e.toString());//COMMON-ICN-0181
				 e.printStackTrace();//COMMON-ICN-0181
			}finally{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displayDays ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totDates ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
