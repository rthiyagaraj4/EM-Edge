<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
28/03/2014	    IN047838		Chowminya											AAKH-CRF-0010.1/01 - Chart cannot be recorded	
11/05/2015		IN054842		Vijayakumar K		11/05/2015		Dinesh T		ML-BRU-SCF-1586 [IN:054842
12/06/2020		IN073152		Durga Natarajan		12/06/2020		Ramesh G  		SKR-SCF-1332         		        		             		          		        		                 
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");

String chart_id = request.getParameter("Chart_Id") == null ? "" :  request.getParameter("Chart_Id");
String dateDefault = request.getParameter("p_start_date_time") == null ? "" :  request.getParameter("p_start_date_time");
if(!dateDefault.equals(""))
{	
	StringTokenizer dateToken = null;
	StringTokenizer secondsToken = null;

	dateToken = new StringTokenizer(dateDefault," ");
	String actualDate = dateToken.nextToken();
	String tempDate = dateToken.nextToken();
	secondsToken = new StringTokenizer(tempDate,":");
	String dateHrMin = actualDate + " " +secondsToken.nextToken() + ":" + secondsToken.nextToken();

	dateDefault = dateHrMin;
}


String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
if(encounter_id.equals("")) encounter_id = "0";
String fac_id = (String) session.getAttribute("facility_id");
String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String qs = request.getQueryString();
String cols = "";
String title = "";

if(function_from.equals("SECONDARY_TRIAGE"))
{
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels");
}
else
{
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels") ;
}
%>
<script>
		function getMessageFrame()
		{
			if("<%=function_from%>" !="CP")
			{
			if(top.content!=null){
				return top.content.messageFrame;
			}else{
				return parent.ChartRecordingIntermediateFrame;
			}
			}
			else
			{			
				return parent.ChartRecordingIntermediateFrame;
			}
		}
		var messageFrameReference = getMessageFrame();
		function removeObjectsFromSession()
		{
			
			//IN047838 included AE condition
				if("<%=function_from%>" != "CP" && "<%=function_from%>" != "SECONDARY_TRIAGE" && "<%=function_from%>" != "AE")
			top.content.messageFrame.location.href="../../eCA/jsp/ChartRecordingRemoveObjects.jsp?"+"<%=request.getQueryString()%>";
			else
				{
				var dialogFrame = top.document.getElementById('dialog-body') ? top.document.querySelectorAll('#dialog-body')[ top.document.querySelectorAll('#dialog-body').length - 1].contentWindow : parent ;
				dialogFrame.ChartRecordingIntermediateFrame.location.href="../../eCA/jsp/ChartRecordingRemoveObjects.jsp?"+"<%=request.getQueryString()%>";
				}
		}
</script>
<head>
<title>
<%=title%>
</title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement getLocnPstmt = null;
	ResultSet res = null;
	ResultSet resLocn = null;
	String result = "";

	String sql ="select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi')";

	String sqlChartId = "select a.CHART_ID from ca_chart a where a.eff_status='E' and  EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id) AND  A.CHART_ID IN (select CHART_ID from ca_chart_applicablity where  PATIENT_CLASS=? and  LOCN_CODE=? ";

	String ageGroupCriteria = " and EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX) ";
	
	//IN054842 starts
	String visit_adm_date_time_sql = "SELECT TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM PR_ENCOUNTER WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ?";
	//String visit_adm_date_time = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");//IN073152 commented
	String visit_adm_date_time ="";//IN073152
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//IN054842 ends
	if(function_from.equals("SECONDARY_TRIAGE"))
	{
		try
		{
			con = ConnectionManager.getConnection(request);

			ps = con.prepareStatement(sqlChartId+ageGroupCriteria+" )  AND ROWNUM=1 ");
			
			if (location_code.equals(""))
			{
				String getLocnSql ="Select ASSIGN_CARE_LOCN_CODE from pr_encounter where facility_id=? and encounter_id=? ";
				getLocnPstmt = con.prepareStatement(getLocnSql);
				getLocnPstmt.setString(1,fac_id);
				getLocnPstmt.setString(2,encounter_id);
				resLocn = getLocnPstmt.executeQuery();
				while(resLocn.next())
				{
					location_code = resLocn.getString("ASSIGN_CARE_LOCN_CODE");
				}
				
				if(resLocn != null) resLocn.close();
				if(getLocnPstmt != null) getLocnPstmt.close();
			}
			ps.setString(1,patient_class);
			ps.setString(2,location_code);
			ps.setString(3,patient_id);

			res = ps.executeQuery();
			
			if(res.next())
			{
				chart_id = res.getString(1);
			}
			else 
			{
				if(res != null) res.close();
				if(ps != null) ps.close();
				ps = con.prepareStatement(sqlChartId+" and AGE_GROUP_CODE='*ALL')  AND ROWNUM=1 ");
				ps.setString(1,patient_class);
				ps.setString(2,location_code);


				res = ps.executeQuery();
				if(res.next())
				{
					//out.println("<script>alert('222"+chart_id+"');</script>");
					chart_id = res.getString(1);
				}
				else
				{
					out.println("<script>alert(getMessage('NO_CHART_FOR_CLINIC','CA'));window.close();</script>");
				}
			}
			if(res != null) res.close();
			if(ps != null) ps.close();

			ps = con.prepareStatement(sql);
			ps.setString(1,encounter_id);
			ps.setString(2,fac_id);
			ps.setString(3,chart_id);
			ps.setString(4,dateDefault);
			

			res = ps.executeQuery();
			if(res.next())
			{
				result = res.getString(1);
				
			}
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
		}
		catch(Exception e)
		{
			out.println("Exception in ChartRecording.jsp "+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con, request);
		}
	}
	//IN054842 starts
	String queryString = request.getQueryString();
	
	if("".equals(visit_adm_date_time))
	{
		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement(visit_adm_date_time_sql);
			ps.setString(1,fac_id);
			ps.setString(2,encounter_id);
			res = ps.executeQuery();
			if(res.next())
			{
				visit_adm_date_time = res.getString(1);
				
			}
			if(res != null) res.close();
			if(ps != null) ps.close();
			
			queryString +=  "&visit_adm_date1="+com.ehis.util.DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);//IN073152
		}		
		catch(Exception evstdt)
		{
			//out.println("Exception in ChartRecording.jsp "+evstdt.toString());//common-icn-0181
		        evstdt.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con, request);
		}
	}
	
	//IN054842 ends
%>
<%
	if(!function_from.equals("SECONDARY_TRIAGE"))
	{		
			String tempRows = "12%,*%,7%,4%,0%,0%";
			//IN047838 included AE condition
			if(function_from.equals("CP") || function_from.equals("AE"))			
				tempRows = "33%,*%,7%,4%,0%,0%,0%,5%";

%>
	<frameset rows='<%=tempRows%>' id ='chartRecordingFrameSet' frameborder=0 onUnload='removeObjectsFromSession()' >
		<!-- IN054842 starts -->
		<!--<frame name="ChartRecordingCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingCriteria.jsp?<% //=request.getQueryString()%>&Chart_Id=<%=chart_id%>"></frame>-->
		<frame name="ChartRecordingCriteriaFrame" id="ChartRecordingCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingCriteria.jsp?<%=queryString%>&Chart_Id=<%=chart_id%>"></frame>
		<!-- IN054842 ends -->
		<frameset cols='40%,60%' frameborder=0 id='AEID'>
			<frame name="ChartRecordingDetailFrame" id="ChartRecordingDetailFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
			<frame name="ChartRecordingListFrame" id="ChartRecordingListFrame" frameborder="0" scrolling="auto"  src="../../eCommon/html/blank.html"></frame>		
		</frameset>
		<frameset cols='40%,60%' frameborder=0 id='colBarID'>
			<frame name="ChartRecordingToolBarFrame" id="ChartRecordingToolBarFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
			<frame name="ChartRecordingControlsFrame" id="ChartRecordingControlsFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
		</frameset>
		<frame name="ChartRecordingColorFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="layout:fixed"></frame>
		
		<frame name="ChartRecordingIntermediateFrame" id="ChartRecordingIntermediateFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
		<frame name="ChartRecordingAddToGrpFrame" id="ChartRecordingAddToGrpFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
<%
		//IN047838 included AE condition
		if(function_from.equals("CP") || function_from.equals("AE"))
		{
%>
			<frame name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/error.jsp"></frame>
<%
		}
%>

	</frameset>

<%
	}
	else if(function_from.equals("SECONDARY_TRIAGE"))
	{
		
		if(result.equals(""))
		{
			cols = "100%,0%";
		}
		else
		{
			cols = "50%,50%";
		}
%>
	<frameset rows='*,5%,7%,0%,10%' id ='chartRecordingFrameSet' frameborder=0 onUnload='removeObjectsFromSession()' >
		<frameset cols='<%=cols%>' id='AEID'>
			<frame name="ChartRecordingDetailFrame" id="ChartRecordingDetailFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></frame>
			<frame name="ChartRecordingListFrame" id="ChartRecordingListFrame" frameborder="0" scrolling="auto"  src="../../eCommon/html/blank.html"></frame>
		</frameset>		
		<frame name="ChartRecordingToolBarFrame" id="ChartRecordingToolBarFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame>
		<frame name="ChartRecordingColorFrame" id="ChartRecordingColorFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="layout:fixed"></frame>
		<frame name="ChartRecordingIntermediateFrame" id="ChartRecordingIntermediateFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingIntermediate.jsp?qs=<%=java.net.URLEncoder.encode(qs)%>&chartId=<%=chart_id%>&function_from=<%=function_from%>&dateDefault=<%=dateDefault%>&result=<%=result%>&encounter_id=<%=encounter_id%>"></frame>
		<frame name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/error.jsp"></frame>
	</frameset>
<%
	}
%>
