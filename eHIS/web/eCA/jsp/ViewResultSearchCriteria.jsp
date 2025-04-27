<!DOCTYPE html>
 <!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
15/11/2013 IN035717			vijayakumark	Alpha-OR- View Results Records not displayed in Practitioner s Desktop
---------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.sql.*,java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<!--<script language='javascript' src="../js/OrCommon.js"></script>-->
	<script language="JavaScript" src="../../eCA/js/ViewResult.js"></script>
	<!--<script language="JavaScript" src="../js/OrCommonFunction.js"></script>-->
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%String ca_normalcy_ind = request.getParameter("ca_normalcy_ind");
if (ca_normalcy_ind == null) ca_normalcy_ind = "";
if (ca_normalcy_ind.equals("X")) ca_normalcy_ind = "C";
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";
	Properties properties=(Properties)session.getValue("jdbc");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	//String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");//IN035717 
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String hist_rec_type = "";
	String long_desc = "";

	/* Initialize Function specific start */
	ReviewResults bean = (ReviewResults)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String patient_id = bean.checkForNull(request.getParameter("patient_id"),"");
	String patient_class = bean.checkForNull(request.getParameter("patient_class"),"");
	String encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
	String disbl="";

	if(encounter_id.equals(""))
	{
		disbl="disabled";
	}
	else
	{
		disbl="";
	}
	
	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();

	ArrayList EventClass	= new ArrayList();
	
	String curr_week_date="";
	String last_week_date="";
	/*Thai date validations start 14/02/2007*/
	ArrayList sysdate=new ArrayList();
	sysdate=(ArrayList)bean.getSysDateTime(properties);
	for(int j=0;j<sysdate.size();j++){

		last_week_date=(String)sysdate.get(0);
		curr_week_date=(String)sysdate.get(1);
	}
		
	if(last_week_date.equals("null") || last_week_date.equals(" ")) last_week_date="";
	if(curr_week_date.equals("null") || curr_week_date.equals(" ")) curr_week_date="";
	if(!localeName.equals("en")){
	last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMY","en",localeName);
	curr_week_date=com.ehis.util.DateUtils.convertDate(curr_week_date,"DMY","en",localeName);
	}
	
/*Thai date validations start 14/02/2007*/
/* Initialize Function specific end */
//
//<form name='review_result_search' id='review_result_search' target='messageFrame' >
String  temp_curr_week_date=curr_week_date;
String temp_last_week_date=last_week_date;
%>

<form name='review_result_search' id='review_result_search' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

<tr>
		<!--<td  class='label' id='id_locn'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='patientId' id='patientId' value='<%=patient_id%>' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength="<%=patient_id_length%>" ><input class='button' type=button name=search value='?'  class=button tabIndex="3" onClick="callPatientSearch()">
		</td>-->
		<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/> </td>
		<td class=fields><input type="text" size="10" maxlength="10" value="<%=curr_week_date%>" name="period_from" id="period_from" onKeyPress="return OrAllowDateFormat();" onBlur="chckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type="text" name="period_to" id="period_to" value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'review_result_search');" onKeyPress="return OrAllowDateFormat();" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_to');" style='cursor:pointer'></img><img src="../../eCommon/images/mandatory.gif" align=center></img>
		</td>

		<td class=label><fmt:message key="eOR.NormalcyIndicator.label" bundle="${or_labels}"/></td>
		<td class=fields><SELECT name="normalcy_ind" id="normalcy_ind">
				<option value='' <%=(ca_normalcy_ind.equals("Z")) ? "selected" : ""%>> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value='N' <%=(ca_normalcy_ind.equals("N")) ? "selected" : ""%>><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
				<option value='A' <%=(ca_normalcy_ind.equals("A")) ? "selected" : ""%>><fmt:message key="Common.Abnormal.label" bundle="${common_labels}"/></option>
				<option value='C' <%=(ca_normalcy_ind.equals("C")) ? "selected" : ""%>><fmt:message key="Common.CriticallyAbnormal.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		</tr>
		
		<tr>
		<td class=label><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="result_type" id="result_type" onChange="populateEventClass(this);">
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<!--

			<option value='BLTF'><fmt:message key="eOR.BloodTransfusion.label" bundle="${or_labels}"/></option>
			<option value='LBIN'><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/></option>
			<option value='RDIN'><fmt:message key="Common.Radiology.label" bundle="${common_labels}"/></option>
			<option value='TRET'><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></option>
			<option value='PTCR'><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></option>
			
			-->
		<%
		try
		{
			con =  ConnectionManager.getConnection(request);
		
			stmt = con.prepareStatement(" select HIST_REC_TYPE,long_desc from or_order_category_lang_vw where PREFERRED_VIEW_RESULT_YN='Y' and language_id=? ORDER BY 2 ");

			stmt.setString(1,localeName);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				hist_rec_type = rs.getString("HIST_REC_TYPE") == null ? "" : rs.getString("HIST_REC_TYPE");
				
				long_desc = rs.getString("long_desc") == null ? "" : rs.getString("long_desc");
			%>
			<option value='<%=hist_rec_type%>'><%=long_desc%></option>

			<%

					
			}
			

			if (rs != null) rs.close();
			if (stmt != null) stmt.close();


		}//try
		catch ( Exception e )	
		{			
			e.printStackTrace() ;
			//throw e ;
		} 
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}


		%>

			</SELECT>
		</td>
		<!--<td class=label><fmt:message key="Common.Period.label" bundle="${common_labels}"/> </td>
		<td class=fields><input type="text" size="10" maxlength="10" value="<%=curr_week_date%>" name="period_from" onKeyPress="return OrAllowDateFormat();" onBlur="chckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_from');" style='cursor:pointer'></img><font size="4">-</font><input type="text" name="period_to" id="period_to" value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'review_result_search');" onKeyPress="return OrAllowDateFormat();" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('period_to');" style='cursor:pointer'></img><img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>-->
		<td class=label><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="status_crit" id="status_crit">
				<!--<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>-->
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='P'><fmt:message key="eCA.PendingReview.label" bundle="${ca_labels}"/></option>
				<option value='R'><fmt:message key="eCA.Reviewed.label" bundle="${ca_labels}"/></option>
			</SELECT> <!-- Normalcy Indicator --></td>





	<!--<td class=label><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="priority" id="priority">
				<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT> </td> -->
	</tr>

		<tr>
		
		<td class="label"><fmt:message key="Common.EventClass.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="event_class" id="event_class">
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	<!--	<%
			EventClass = bean.getEventClass("");    //Pass the rec_type as null when loading
			for(int k=0; k<EventClass.size(); k++)
			{
				String[] records = (String[])EventClass.get(k);
		%>
					<option value=<%=records[0]%>><%=records[1]%></option>
		<%	} // End of for
		%>-->
		</SELECT><!-- Order By -->
		</td>
		
		<td class=label><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="priority" id="priority">
				<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value='R'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</SELECT> </td>
			</tr>
			<tr>
			<!--<td class='label' >&nbsp;</td><td class='label'>&nbsp;</td>-->

		<!--<td class=label><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="result_type" id="result_type" onChange="populateEventClass(this);">
			<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='BLTF'><fmt:message key="eOR.BloodTransfusion.label" bundle="${or_labels}"/></option>
			<option value='LBIN'><fmt:message key="Common.Laboratory.label" bundle="${common_labels}"/></option>
			<option value='RDIN'><fmt:message key="Common.Radiology.label" bundle="${common_labels}"/></option>
			<option value='TRET'><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></option>
			<option value='PTCR'><fmt:message key="Common.PatientCare.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>-->
		<td class='label' ><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/></td><td class='fields' ><input type='checkbox' name='curr_enc' id='curr_enc' <%=disbl%> ></td>
		
		<td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class=fields><Select name='group_by' id='group_by'>
		<Option value='P'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></Option>
		<Option value='E'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></Option>
		</Select></td>
		
		</tr>
				
		<tr>
		<!--<td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class=fields><Select name='group_by' id='group_by'>
		<Option value='P'><fmt:message key="eOR.PatientEvent.label" bundle="${or_labels}"/></Option>
		<Option value='E'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></Option>
		</Select></td>-->
	<td class='label' colspan='2' ></td>
	<td></td>
	<td class='button' align="right"><input type=button name='search_btn' id='search_btn' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td></tr>
	
	<!--<td class=label><fmt:message key="Common.EventClass.label" bundle="${common_labels}"/></td>
		<td class=fields><SELECT name="event_class" id="event_class">
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%
			EventClass = bean.getEventClass("");    //Pass the rec_type as null when loading
			for(int k=0; k<EventClass.size(); k++)
			{
				String[] records = (String[])EventClass.get(k);
		%>
					<option value=<%=records[0]%>><%=records[1]%></option>
		<%	} // End of for
		%>
		</SELECT>
		</td>
		<td class='button'><input type=button name='search' id='search' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateValues()'><input type=button name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearValues()'></td>
		</tr>-->

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patient_id%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class.trim()%>'>
<input type='hidden' name='ca_normalcy_ind' id='ca_normalcy_ind' value='<%=ca_normalcy_ind%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="temp_curr_week_date" id="temp_curr_week_date" value="<%=temp_curr_week_date %>">
<input type="hidden" name="temp_last_week_date" id="temp_last_week_date" value="<%=temp_last_week_date %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id %>">
<input type="hidden" name="relationship_id" id="relationship_id" value="<%=relationship_id%>">
<!--<input type="hidden" name="option_id" id="option_id" value="<%//=option_id%>">--><!-- IN035717 -->
<%if ((!ca_normalcy_ind.equals("")) || (!patient_id.equals("")) || (!patient_class.equals(""))) {%>
<Script>populateValues();</Script>
<%}%>
</form>


<%
putObjectInBean(bean_id,bean,request);
%>

</body>
<script>//document.review_result_search.submit();
populateValues();</script>
</html>

