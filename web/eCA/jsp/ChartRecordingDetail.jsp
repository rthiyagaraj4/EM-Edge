<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
30/05/2013  IN00000  Chowminya G    R(remarks) Chart recording in AE after data recorded to be removed - script error										
29/10/2018	IN068742		Sharanraj	 Ramesh			TBMC-SCF-0006								
---------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="generateChart" class="eCA.GenerateChartLayoutBean" scope="page"/>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");
		String module_id = request.getParameter("module_id") == null ? "" :  request.getParameter("module_id");
		String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");
		//modifyYN="N";

		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

		String errorAuth = request.getParameter("errorAuth") == null ? "" :  request.getParameter("errorAuth");
		String Sex = request.getParameter("Sex") == null ? "" :  request.getParameter("Sex");
		String facility_id = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");

		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;

		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		if(encounter_id.equals("")) encounter_id = "0";

		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" : request.getParameter("contr_mod_accession_num");
		
		String highStr = "",lowStr="",abnStr="",cricStr="",cricHighStr="",cricLowStr="";
		String sysTime = "";
		String count = "";

		abnStr=abnStr;
		cricStr=cricStr;
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script>
		function getMessageFrame()
		{
			if(top.content!=null){
				return top.content.messageFrame;
			}else{
				return parent.parent.messageFrame;
			}
		}
		var messageFrameReference = getMessageFrame();
		function removeObjectsFromSession(){
		//	messageFrameReference.location.href="../../eCA/jsp/ChartRecordingRemoveObjects.jsp";
		}
	</script>
	<style>
	TH {
        FONT-FAMILY: VERDANA ;
			FONT-SIZE: 7PT ;
		   	COLOR:WHITE;
			BACKGROUND-COLOR: #808080 ;

   }
A:active{
		color:white;
	}
	A:visited{
		color:white;
	}
	A:link {
		COLOR:white;
	}
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()' onload='initListVals()' onunload="removeObjectsFromSession()">	
	<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<form name ="ChartLayoutDetailForm" action="../../servlet/eCA.ChartRecordingServlet" method=post target="messageFrame" >

	<table  width='100%' class='grid' id='titleTable'>
	   <tr  id='divTitleTable' border='0'  height='0%'>
		<td class='columnheader'  height='0%' border='0' colspan='5'></th>
	</tr>   
	<tr border='0' id='divTitleTable1'>
		<td class='COLUMNHEADERCENTER' border='0'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
<%
	if(modifyYN.equals("Y"))
	{
%>
		<td class='COLUMNHEADERCENTER'   border='0'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'  border='0' title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")%>'>Rem</td> <!--IN00000 moved tag into if condition -->
<%
	}
%>
		
		<td class='COLUMNHEADERCENTER'  border='0'><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
		<%
			if(!function_from.equals("SECONDARY_TRIAGE"))
			{
		%>
		<td class='COLUMNHEADERCENTER'  border='0'>&nbsp;
		<!--<a href="javascript:;" onClick='openWinForGrouping()'><img src='../../eCA/images/graph.gif' border='0'></img></a> -->
		</td>
		<%
			}
		%>
	</tr>	
	<%
		generateChart.setChartId("");
		StringBuffer displayString = generateChart.getChartLayout(request,locale);
		count = generateChart.getIndex();
		int numdec=generateChart.getdecimal();//IN068742
		if(!(displayString.toString()).equals("")){
			out.println(displayString.toString());			
		}else{
			if(function_from.equals("SECONDARY_TRIAGE"))
			{
				/* out.println("<script>alert('no section');</script>"); */
				out.println("<script>parent.parent.document.getElementById('dialog_tag').close()</script>");
			}
			else
			{
			//out.println("<script>parent.ChartRecordingToolBarFrame.document.F.record.disabled = true;</script>");
	%>
			<script>
				parent.ChartRecordingDetailFrame.location.href='../../eCommon/html/blank.html';
				parent.ChartRecordingToolBarFrame.location.href='../../eCommon/html/blank.html';
			</script>
	<%	
			}
		}
	%>	
	</table>
	<%
	{
        if(function_from.equals("") || (function_from.equals("CP") && module_id.equals("OR")))
        {
			try
			{
				sysTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			}
			catch(Exception e)
			{
				out.println("Exception in ChartRecordingDetail.jsp --- "+e.toString());
			}
        }
		else if(function_from.equals("SECONDARY_TRIAGE"))
		{
            sysTime = checkForNull(request.getParameter("defaultDate"));
			//sysTime = com.ehis.util.DateUtils.convertDate(sysTime,"DMYHM","en",locale);
			
		}
        else
        {
            sysTime = checkForNull(request.getParameter("p_start_date_time"));
			
			if (sysTime.equals(""))
			{
					sysTime	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			}
			/*else 
			{
				sysTime = com.ehis.util.DateUtils.convertDate(sysTime,"DMYHM","en",locale);
			} */
        }

	    try
        {
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select HIGH_STR,LOW_STR,CRIT_HIGH_STR,CRIT_LOW_STR from cr_clin_event_param");		
        rs = pstmt.executeQuery();
        while(rs.next())
        {
            highStr =checkForNull( rs.getString("HIGH_STR"));

            lowStr =checkForNull( rs.getString("LOW_STR"));

            cricHighStr =checkForNull( rs.getString("CRIT_HIGH_STR"));

            cricLowStr =checkForNull( rs.getString("CRIT_LOW_STR"));
        }
        if(rs != null)rs.close();
        if(pstmt != null)pstmt.close();
        }
        catch(Exception ee)
        {
			//out.println("Exception in ChartRecordingDetail.jsp"+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
        }


		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}
	}
	%>
	<input type=hidden name="count" id="count" value="<%=count%>">
	<input type=hidden name="sysTime" id="sysTime" value="<%=sysTime%>">
	<input type=hidden name="sysdate" id="sysdate" value="<%=request.getParameter("sysdate")%>">
	<input type=hidden name="highStr" id="highStr" value="<%=highStr%>">
	<input type=hidden name="lowStr" id="lowStr" value="<%=lowStr%>">
	<input type=hidden name="cricHighStr" id="cricHighStr" value="<%=cricHighStr%>">
	<input type=hidden name="cricLowStr" id="cricLowStr" value="<%=cricLowStr%>">
	<input type=hidden name="patient_id" id="patient_id" value="<%=request.getParameter("patient_id")%>">
	<input type=hidden name="episode_id" id="episode_id" value="<%=request.getParameter("episode_id")%>">
	<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type=hidden name="patient_class" id="patient_class" value="<%=request.getParameter("patient_class")%>">
	<input type=hidden name="chart_id" id="chart_id" value="<%=request.getParameter("chartId")%>">
	<input type=hidden name="Sex" id="Sex" value="<%=request.getParameter("Sex")%>">
	<input type=hidden name="Dob" id="Dob" value="<%=request.getParameter("Dob")%>">
	<input type=hidden name="summaryYN" id="summaryYN" value='<%=request.getParameter("summaryYN")%>'>
	<input type=hidden name="detailYN" id="detailYN" value='<%=request.getParameter("detailYN")%>'>
	<input type=hidden name="summaryText" id="summaryText" value=''>
	<input type=hidden name="locale" id="locale" value='<%=locale%>'>
	<input type=hidden name="taskCode" id="taskCode" value='<%=request.getParameter("taskCode")%>'>
	<input type=hidden name="taskSrlNo" id="taskSrlNo" value='<%=request.getParameter("task_srl_no")%>'>
	<input type=hidden name="DEFINE_MODIFIABLE_AT_TRN_YN" id="DEFINE_MODIFIABLE_AT_TRN_YN" value='<%=request.getParameter("DEFINE_MODIFIABLE_AT_TRN_YN")%>'>
	<input type=hidden name="rec_time" id="rec_time" value="">
	<input type=hidden name="selected_events_no" id="selected_events_no" value="">
	<input type=hidden name="selected_events_desc" id="selected_events_desc" value="">
	<input type=hidden name="selected_events_uom" id="selected_events_uom" value="">
	<input type=hidden name="no_of_selections" id="no_of_selections" value="">
	<input type=hidden name="dummyVariable" id="dummyVariable" value="">
	<input type=hidden name="selected_growth_event" id="selected_growth_event" value="">
	<input type=hidden name="function_from" id="function_from" value="<%=function_from%>">
	<input type=hidden name="detDate" id="detDate" value="<%=sysTime%>">
	<input type=hidden name="qs" id="qs" value="<%=request.getQueryString()%>">
	<input type=hidden name="noOfChkdBoxes" id="noOfChkdBoxes" value='0'>
	<input type=hidden name="grpCount" id="grpCount" value='1'> 
	<input type=hidden name="grpDetails" id="grpDetails" value=''>
	<input type=hidden name="sentFromGraph" id="sentFromGraph" value=''>
	<input type=hidden name="flagGraph" id="flagGraph" value='N'>
	<input type=hidden name="errorAuth" id="errorAuth" value='<%=errorAuth%>'>

	<input type=hidden name="splChartType" id="splChartType" value=''>
	<input type=hidden name="Sex" id="Sex" value='<%=Sex%>'>
	<input type=hidden name="facility_id" id="facility_id" value='<%=facility_id%>'>
	<input type=hidden name="noOfGroups" id="noOfGroups" value=''>
	<input type=hidden name='contr_mod_accession_num' id='contr_mod_accession_num' value='<%=contr_mod_accession_num%>'>
	<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
	<input type=hidden name="modifyYN" id="modifyYN" value='<%=modifyYN%>'>
	<input type=hidden name="numdecimal" id="numdecimal" value='<%=numdec%>'> <!-- IN068742 -->

	</form>
	<div id='extraTD' style='position:absolute; height:5%; width:30%; visibility:hidden;'></div>
</body>
<script>alignUnitsAndDataforDetail();</script>
<script>
	 if(parent.ChartRecordingCriteriaFrame != null)
	 {
		 if('<%=modifyYN%>' == 'Y')
			parent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value=document.forms[0].sysTime.value;
		document.ChartLayoutDetailForm.splChartType.value = parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.splChartType.value
	 }

</script>
<%
if(!function_from.equals("SECONDARY_TRIAGE"))
{
%>
	<script>
		var qs = "<%=request.getQueryString()%>&modifyYN=<%=modifyYN%>";
		parent.ChartRecordingListFrame.location.href = '../../eCA/jsp/ChartRecordingListPopulation.jsp?'+qs;
	</script>
<%
}
else
{
	%>
		<script>
			displayListForAE();
		</script>
	<%
}
%>
</html>

<%!
private String checkForNull(String strParam)
{
		String str ="";
		if(strParam!=null && strParam.length() >0)
		str = strParam;
		return str;
}
%>

