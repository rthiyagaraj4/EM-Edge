<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.PatTaskListRepository,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<style>
		BODY.CONTENT{BGCOLOR:#E2E3F0}
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onfocus="parent.patTaskListResultFrame.loadpage()">
<form name='patTaskCriteriaForm' id='patTaskCriteriaForm' method='post' action='../../eCA/jsp/PatTaskListResult.jsp' target='patTaskListResultFrame'>
<input type='hidden' name='sortOrder' id='sortOrder' value=''>
<input type='hidden' name='sortSelection' id='sortSelection' value=''>

<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" align='center'>
<%
	Connection con			=	null;
	PreparedStatement pstmt	=	null;
	ResultSet rset			=	null; 

	ArrayList retArray=null;
	ArrayList arrayDesc = null;
	ArrayList arrayCode=null;
	ArrayList arrayLocationCodeC = null;
	ArrayList arrayLocationDescC = null;
	Properties property = null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String patient_id = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("episode_id")==null ? "" : request.getParameter("episode_id");
	String patient_class =request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
	//out.println("<script>alert('"+patient_class+"')</script>");
	//String locationCode = request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
	StringBuffer locationCodeClinic = new StringBuffer();
	StringBuffer locationCodeNursing= new StringBuffer();
	String sysdate = "";
	String fromDate = "";
	String homePageCategory=request.getParameter("category")==null ? "" : request.getParameter("category");
	String homePageLocationType=request.getParameter("locationType")==null ? "" : request.getParameter("locationType");
	String homePageLocationCode=request.getParameter("locationCode")==null ? "" : request.getParameter("locationCode");
	
	try
	{
		property = (java.util.Properties) session.getValue( "jdbc" );
		sysdate = patTask.getSysdateTime();
		fromDate = patTask.getSysdateFromTime();

		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM","en",locale);
		sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale);
%>
	<tr>
    	<td class='label'  width = '25%'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
				<select name="viewScope" id="viewScope" >
					<option value="S"><fmt:message key="Common.self.label" bundle="${common_labels}"/></option>
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				</select>
		</td>
		<td class=label  width = '25%'>
			<fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name='priority' id='priority'>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>	
					<option value='R' ><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
					<option value='S' ><fmt:message key="eOR.Stat.label" bundle="${or_labels}"/></option>
					<option value='U' ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				</select>	
			</td>
		</tr>
	
		<tr>
			<td class="label"  width = '25%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'> <INPUT TYPE="text" name="fromDate" id="fromDate" id='fromDate' size='16' maxlength='16' OnBlur='CheckDateTime(this);fromDateChecknew(this,"DMYHM","<%=locale%>");toDateChecknew(this,toDate,"DMYHM","<%=locale%>")' value='<%=fromDate%>'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDate')"><img  src='../../eCommon/images/mandatory.gif' ></img> </td>
			<td class='label'  width = '25%' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><INPUT TYPE="text" name="toDate" id="toDate" id='toDate' size='16' maxlength='16' OnBlur='CheckDateTime(this);toDateChecknew(fromDate,this,"DMYHM","<%=locale%>")' value='<%=sysdate%>'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDate')"><img src='../../eCommon/images/mandatory.gif'></img></td>
		</tr>
		<tr id='trRowId'>
	
		<td class='label' width = '25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name='locationType' id='locationType'  OnChange='validateLocation(this);'>
				<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>	
		</td>
		<td class='label'  width = '25%'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>/<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
				<select name='locationCode' id='locationCode'>
		<%
				if(retArray != null)
				 retArray.clear();
				retArray = patTask.getLocationCode(property,patTask.checkForNull(session.getAttribute("facility_id").toString()));
				
		%>
			<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
			<%
		if(retArray != null)
				{
						
					if(arrayDesc != null)arrayDesc.clear();
					if(arrayCode != null)arrayCode.clear();
					arrayCode = (ArrayList)retArray.get(0);
					arrayDesc = (ArrayList)retArray.get(1);
					 arrayLocationCodeC=(ArrayList)retArray.get(2);
					 arrayLocationDescC=(ArrayList)retArray.get(3);
					
					 int index=0;
					 while(index < arrayCode.size())
					{
						out.println("<option value='"+arrayCode.get(index).toString()+"'>"+arrayDesc .get(index).toString()+"</option>");
						 index++;
						 
					}
				}
			%>
		</select>
		<img src='../../eCommon/images/mandatory.gif' id='imgLocation' style='display:none'></img>
<%
			
			if(retArray != null)
				{

					arrayDesc=null;
					arrayCode=null;
					arrayLocationCodeC=null;
					arrayLocationDescC=null;
					//out.println("code:"+retArray.get(0)+"desc"+retArray.get(1)+"loctncode"+retArray.get(2)+"loctndesc"+retArray.get(3));
				
					arrayCode = (ArrayList)retArray.get(0);
					arrayDesc = (ArrayList)retArray.get(1);
					 arrayLocationCodeC=(ArrayList)retArray.get(2);
					 arrayLocationDescC=(ArrayList)retArray.get(3);



					 int  index=0;
					 while(index < arrayLocationDescC.size())
					{
						 if(locationCodeClinic.toString().equals(""))
						 {
						 locationCodeClinic.append(arrayLocationCodeC.get(index).toString() + "||" +  arrayLocationDescC.get(index).toString());
						 }
						 else
						{
								 locationCodeClinic.append("~" +  arrayLocationCodeC.get(index).toString() + "||" +  arrayLocationDescC.get(index).toString());

						}
						index++;
					}

					index = 0;
					while(index < arrayCode.size())
					{
						if(locationCodeNursing.toString().equals(""))
						{
						 locationCodeNursing.append(arrayCode.get(index).toString() + "||" +  arrayDesc.get(index).toString());
						}
						else
						{
						 locationCodeNursing.append("~"+ arrayCode.get(index).toString() + "||" +  arrayDesc.get(index).toString());	
						}
						index++;
					}

					}
	%>
		</td>
	
	</tr>
	<tr>
	<td class='label' id='labelPatientId' width ='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'> <input type='text' name='PatientId' id='PatientId' value='<%=patient_id%>' size='10' maxlength='20' OnBlur='checkForPatient(this,"Patient")'><input type='button' name='buttonPatient' id='buttonPatient' value='?' class='button' OnClick='getPatientId()'></td>		
	<td class='label' id='labelEncntrId' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>	<input type='text' name='encounterId' id='encounterId' value='<%=encounter_id%>' size='12' maxlength='12'  OnBlur='CheckNum(this);checkForPatient(this,"Encounter")' OnKeyPress='return allowValidNumber(this,event,12,0)'></td> 
	</tr>
	<tr>	
		<td  class='label' width = '25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name='status' id='status'>
				<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>	
				<option value='D'><fmt:message key="Common.Due.label" bundle="${common_labels}"/></option>	
				<option value='O'><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>	
				<option value='E'><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>	
				<option value='C'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
				<option value='F'><fmt:message key="Common.Future.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td  class='label' width ='25%'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name='stage' id='stage' OnChange='resetStage(this)'>
				<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>	
				<%
					if(retArray != null) retArray.clear();
					if(arrayCode != null) arrayCode.clear();
					if(arrayDesc != null) arrayDesc.clear();

					try
					{

						String strCPModuleYN	=	"N";
					
						String strQry = "SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'CP'";

						con = ConnectionManager.getConnection(request);

						pstmt	=	con.prepareStatement(strQry);

						rset	=	pstmt.executeQuery();

						if(rset.next())
							strCPModuleYN	= rset.getString(1);

						if(strCPModuleYN != null && strCPModuleYN.equals("Y") )
						{
							retArray = patTask.getListItemsForStage();
	
							if(retArray != null && retArray.size() != 0)
							{
								arrayCode = (ArrayList)retArray.get(0);
								arrayDesc = (ArrayList)retArray.get(1);
								int index=0;
								
								while(index < arrayCode.size())
								{
									 out.println("<option value='"+arrayCode.get(index).toString()+"'>"+arrayDesc.get(index).toString()+"</option>");
									 index++;
								}
							}
						}
					}
					catch (Exception e)
					{}
					finally
					{
							if (rset	!= null) rset.close();
							if (pstmt	!= null) pstmt.close();
							if (con!=null) ConnectionManager.returnConnection(con,request);
					}

				%>
		</select>
		</td>
		</tr>
		<tr>
			<td class='label'  width ='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
				<select name='dateTime' id='dateTime' OnChange='populateList(this)'>
					<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>	
					<option value='6'><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>	
					<option value='9' selected><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></option>	
					<option value='3'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></option>	
				</select>	
			</td>
			<td class='label' width='25%'>
				<select name='patientDetail' id='patientDetail' OnChange='populateList(this)'>
					<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>	
					<option value='6' selected><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>	
					<option value='3'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></option>	
					<!-- <option value='PERFORMED_DATE'>Date & Time</option>	
					<option value='PATIENT_ID'>Patient Details</option>	
					<option value='TASK_CODE'>Intervention</option>	 -->
				</select>
			</td>
			<td class='fields' width='25%' >
				<select name='taskSelect' id='taskSelect' OnChange='populateList(this)'>
					<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>	
					<option value='3'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></option>
					<!--  <option value='PERFORMED_DATE'>Date & Time</option>	
					<option value='PATIENT_ID'>Patient Details</option>	
					<option value='TASK_CODE'>Intervention</option>	  -->
				</select>	
			</td>
			<!--<td colspan=1>	</td> -->
	</tr>	
	<tr>
	<td class='label' width='25%'>	<fmt:message key="Common.Include.label" bundle="${common_labels}"/>:</td>
	<td class='fields' colspan='2' width='25%' nowrap >
	<fmt:message key="Common.Intervention.label" bundle="${common_labels}"/>
	 <INPUT TYPE="checkbox" name="checkIntervention" id="checkIntervention" checked  OnCLick='updateCheckValue(this)' value='Y'>	
	 &nbsp;<fmt:message key="Common.Orders.label" bundle="${common_labels}"/>

	<INPUT TYPE="checkbox" name="checkResult" id="checkResult" OnCLick='updateCheckValue(this)' checked>
	&nbsp;
	<fmt:message key="eCA.Medications.label" bundle="${ca_labels}"/>
	<INPUT TYPE="checkbox" name="checkAdminMedication" id="checkAdminMedication"  OnCLick='updateCheckValue(this)' checked>	
	&nbsp;
	<fmt:message key="Common.Specimen.label" bundle="${common_labels}"/>
	<INPUT TYPE="checkbox" name="checkSpecimen" id="checkSpecimen"  OnCLick='updateCheckValue(this)' checked>		
	</td>
	<td width='25%'></td></tr>
	<tr><td width='25%'></td><td width='25%'></td><td width='25%'></td>
	<td  nowrap align='right'>
		<INPUT TYPE="button" class='button' name='adhocIntervention' id='adhocIntervention' value='<fmt:message key="Common.adhoc.label" bundle="${common_labels}"/>' OnClick='recordAdhoc()' style='display:none'>
		<INPUT TYPE="button" class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' OnClick='SearchTaskCriteria("criteria")'>
		<INPUT TYPE="button" class='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' OnClick='clearTaskCriteria()'>
	</td>
	</tr>
		<script>
			if('<%=homePageCategory%>' !='')
			{
				document.forms[0].checkIntervention.checked=false;
				document.forms[0].checkAdminMedication.checked=false;
				document.forms[0].checkSpecimen.checked=false;
				document.forms[0].checkResult.checked=false;
				document.forms[0].status.options[1].selected = true;
					if('<%=homePageCategory%>' == 'I')
						document.forms[0].checkIntervention.checked=true;
					else
					if('<%=homePageCategory%>' == 'M')
						document.forms[0].checkAdminMedication.checked=true;
					else
					if('<%=homePageCategory%>' == 'S')
						document.forms[0].checkSpecimen.checked=true;
					else
					if('<%=homePageCategory%>' == 'O')
						document.forms[0].checkResult.checked=true;
			}

					
				
		</script>
<input type='hidden' name='patientFlag' id='patientFlag' value=''>
<input type='hidden' name='flagString1' id='flagString1' value=''>
<input type='hidden' name='selectValueForClinic' id='selectValueForClinic' value='<%=locationCodeClinic.toString()%>'>
<input type='hidden' name='selectValueForNursing' id='selectValueForNursing' value='<%=locationCodeNursing.toString()%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='ca_practitioner_id' id='ca_practitioner_id' value='<%=session.getAttribute("ca_practitioner_id")%>'>
<script>

	if('<%=homePageLocationType%>' !='')
	{
			if('<%=homePageLocationType%>' == 'EM' || '<%=homePageLocationType%>' == 'OP')
					document.forms[0].locationType.value='C'
					else
					document.forms[0].locationType.value='N'

			validateLocation(document.forms[0].locationType);
		if('<%=homePageLocationCode%>' !='')
		document.forms[0].locationCode.value='<%=homePageLocationCode%>';
	}
	else
		document.patTaskCriteriaForm.locationType.options[1].selected=true
	</script>

<script>
if("<%=patient_id%>" != "")
{
		
		trRowId.style.display='none'
		parent.document.getElementById("patTaskListFrameSet").rows='36%,0%,0%,*,0%,5%'
		document.patTaskCriteriaForm.taskSelect.style.display='none'
		document.patTaskCriteriaForm.patientFlag.value='true'
		clearList(document.patTaskCriteriaForm.patientDetail)
		clearList(document.patTaskCriteriaForm.dateTime)
		populateListForDateTime(document.patTaskCriteriaForm.dateTime)	
		document.patTaskCriteriaForm.dateTime.options[1].selected=true;
		document.patTaskCriteriaForm.adhocIntervention.style.display= 'inline'
		setTimeout("populateList(document.forms[0].dateTime);",500);
}
else
{
	
}

</script>
<%
}
catch(Exception ee)
{
	//out.println("Exception from PatTaskListCriteria.jsp :"+ee.toString());//common-icn-0181
	ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	 retArray.clear();
	 arrayDesc.clear();
	 arrayCode.clear();	
	 arrayLocationCodeC.clear();	
	 arrayLocationDescC.clear();	

}
%>
</table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=(String)session.getAttribute("facility_id")%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type='hidden' name='qs' id='qs' value='<%=request.getQueryString()%>'>
</form>
<script>
//document.patTaskCriteriaForm.dateTime.options[1].selected=true;
/*if(document.patTaskCriteriaForm.dateTime.value !='')
{
	populateList(document.patTaskCriteriaForm.dateTime)
}*/

//document.patTaskCriteriaForm.search.disabled=true
//setTimeout("SearchTaskCriteria('criteria');",500);

if('<%=homePageCategory%>' !='')
{
	SearchTaskCriteria("criteria");
}
</script>
</body>
</html>	

