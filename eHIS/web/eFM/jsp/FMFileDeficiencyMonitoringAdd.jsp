<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

<%
		Connection conn			= ConnectionManager.getConnection(request);
		java.sql.Statement stmt	= null;
		ResultSet rs			= null;

		String facility_id = (String) session.getValue("facility_id");

		String patient_class		= "";
		String dflt_practitioner	= "", dflt_practitioner_name = "";
		String sql = "";
		String sys_date = "";
		String p_pract_name		= "";	  
		String Found = request.getParameter("Found");	
		String Oper_mode = "";
		String Rec_num = "";		
		String compStat = "";
		String p_in_type="";
        //String sys_date_query=""; checkstyle changes - 35865
        String rept_dttime = "";         
    
%>
<html>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMFileDeficiencyMonitoring.js' ></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script> 
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script>		
		function CheckDateTime(Obj)
		{
			var datefield = Obj;
			if(doDateTimeChk(Obj) == false) 
			{
				//alert("APP-SM0011 - Invalid Date Time Format");
				alert(getMessage("INVALID_DATE_TIME","SM"));
				//datefield.select();
				datefield.value="";
				datefield.focus();
				return false;
			}
			else 
			{
				return true;
			}
		}
	</script>
</head>
<%
	String EncounterId		= request.getParameter("EncounterId");
	String FileNo			= request.getParameter("FileNo");
	String file_type_code	= request.getParameter("file_type_code");
	String volume_no		= request.getParameter("volume_no");
	String PatientId		= request.getParameter("PatientId");
	String Admndate			= request.getParameter("Admndate");
	String Discdate			= request.getParameter("Discdate");
	String Carelocn			= request.getParameter("Carelocn");
	String PractId			= request.getParameter("practitioner");
	String RepDate			= request.getParameter("defi_reported_date");
	String DefStatus		= request.getParameter("defi_status");
	String ResDate			= request.getParameter("defi_resolved_date");
		String DefcRemarks		= request.getParameter("defi_remarks");
	String DefcCode			= request.getParameter("defi_code");
	String chkcount			= request.getParameter("chkcount");
	
	        
	file_type_code			= (file_type_code == null) ? "" : file_type_code;
	volume_no				= (volume_no == null) ? "" : volume_no;

	if(ResDate ==null)			ResDate = "";
	if(DefcRemarks == null)	DefcRemarks = "";

	if(DefStatus == null)		DefStatus = "O";
	if (RepDate==null) RepDate="";
	if(chkcount == null) chkcount="0";
	
	if(DefcCode == null)
	{
		Oper_mode = "Add";
		p_in_type = "I";
	}
	else
	{
		Oper_mode = request.getParameter("Oper_mode");
		Rec_num = request.getParameter("Rec_num");
	    if(Rec_num.equals("0")) Found="0";
		compStat = request.getParameter("compStat");
	}

	
	String openSelect	= "";
	String cancelSelect	= "";
	String closeSelect	= "";
   
	
	if(DefStatus!=null &&  DefStatus.equals("O")) openSelect = "Checked";
	else if(DefStatus!=null && DefStatus.equals("C")) closeSelect = "Checked";
	else if(DefStatus!=null && DefStatus.equals("X")) cancelSelect = "Checked";
	{
	%>
<body OnMouseDown="CodeArrest();" onLoad="document.forms[0].res_date.style.visibility='hidden'" onKeyDown = 'lockKey();'>
	<form name='FileDeficiencyMonitoring_add' id='FileDeficiencyMonitoring_add' method='post' target='messageFrame' action='../../eFM/jsp/FileDeficiencyMonitoringBean.jsp'>
	<table id='tb1' border="0" cellpadding="3" cellspacing="0" width='100%' align="center">
	<td colspan='4' class='columnheader'><fmt:message key="eFM.RecordChangeDeficiencydetail.label" bundle="${fm_labels}"/></td>
	<%
	try
	{
		
	DefcRemarks=java.net.URLDecoder.decode(DefcRemarks);
	stmt = conn.createStatement();		
		
		
		/* Merged the SQL statements with below statement for PE - 20/05/2010

		sys_date_query = "select to_char(sysdate-0.001388,'dd/mm/yyyy hh24:mi')from dual";
		rs = stmt.executeQuery(sys_date_query);
		while(rs != null && rs.next())
		{
			rept_dttime = rs.getString(1);
		}
		if(rs!=null) rs.close(); 
		
		
		rept_dttime= DateUtils.convertDate(rept_dttime,"DMYHM","en",localeName);
		
		sql = "SELECT to_char(sysdate-0.001388,'dd/mm/yyyy hh24:mi') rept_dttime, Am_Get_desc.Am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) Practitioner_Name FROM Am_prAct_For_Facility WHERE Facility_Id = '"+facility_id+"' AND Practitioner_Id = '"+PractId+"' ";


		rs = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			p_pract_name	= rs.getString("practitioner_name");
			rept_dttime = rs.getString("rept_dttime");
		}
		if(rs!=null) rs.close();*/
		
		sql = "SELECT to_char(sysdate-0.001388,'dd/mm/yyyy hh24:mi') rept_dttime, (select Am_Get_desc.Am_practitioner(PRACTITIONER_ID,'"+localeName+"',1) Practitioner_Name FROM Am_prAct_For_Facility WHERE Facility_Id = '"+facility_id+"' AND Practitioner_Id = '"+PractId+"') p_pract_name, Attend_Practitioner_Id, Am_Get_desc.Am_practitioner(Attend_Practitioner_Id,'"+localeName+"',1) Practitioner_Name, Patient_Class FROM pr_Encounter WHERE Facility_Id = '"+facility_id+"' AND encounter_id='"+EncounterId+"' AND patient_id='"+PatientId+"' ";


		rs = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			dflt_practitioner			 = rs.getString("attend_practitioner_id");
			patient_class				 = rs.getString("patient_class");
			dflt_practitioner_name		 = rs.getString("practitioner_name");
			p_pract_name				 = rs.getString("p_pract_name");
			rept_dttime					 = rs.getString("rept_dttime");
		}
		if(rs!=null)	rs.close();
		
		if(dflt_practitioner_name == null || dflt_practitioner_name.equals("null"))
			dflt_practitioner_name="";

		if(p_pract_name==null || p_pract_name.equals(""))
		{
				PractId = dflt_practitioner;
				p_pract_name = dflt_practitioner_name;
		}

		rept_dttime= DateUtils.convertDate(rept_dttime,"DMYHM","en",localeName);

		if(rs!=null)	rs.close();	 	
					
		
		 sql = "SELECT  DEFICIENCY_CODE , SHORT_DESC  ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  FROM     FM_DEFICIENCY_LANG_VW WHERE EFF_STATUS = 'E'  AND  LANGUAGE_ID='"+localeName+"' ORDER BY 2";
	
		
		rs = stmt.executeQuery(sql);
		
		%>
		<tr>
			<td class='label' width='25%'><fmt:message key="eFM.DeficiencyType.label" bundle="${fm_labels}"/></td>
			<td  width='25%' class='fields'>
			<select name='deficiency' id='deficiency'>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option> 
			<%
			 while(rs != null && rs.next())
			 {
				String ID	= rs.getString(1);
				String desc	= rs.getString(2);
				sys_date = rs.getString(3);

				if(ID!=null && ID.equals(DefcCode))
					out.println("<option value='"+ID+"' selected>"+desc+"</option>");
				else
					out.println("<option value='"+ID+"'>"+desc+"</option>");
			}
			if(RepDate.equals("")) RepDate = rept_dttime;
			%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' width='25%'><fmt:message key="eFM.ResponsiblePractitioner.label" bundle="${fm_labels}"/></td>
			<td width='25%' class='fields'><input type=text size=30 maxlength=30 name=physician1 id=physician1  value='<%=p_pract_name%>' onChange=" if(this.value != '' ){searchCode(this,'<%=facility_id%>','<%=localeName%>') ;}" ><input type="hidden" size=40 maxlength=30 name="physician" id="physician" value='<%=PractId%>' ><input type=button name="searchcode" id="searchcode" value='?' class=button onClick="searchCode(physician1,'<%=facility_id%>','<%=localeName%>')"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
       </tr>
		<tr>
			<td class='label'><fmt:message key="eFM.DateTimeReported.label" bundle="${fm_labels}"/></td>
			<td class='fields'>
			<input type='text' name='date_reported'id='repdttime' maxlength='16' size='17' value='<%=RepDate%>' ><img name='prefdt' src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('repdttime',null,'hh:mm');"></img><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' ><fmt:message key="eFM.DeficiencyStatus.label" bundle="${fm_labels}"/></td>
			<td class='fields'>
			<%
				if(chkcount.equals("1") && Oper_mode.equals("ScreenModify"))
				{ %>

				<input type='radio' name='defy_status' id='defy_status' value='O' checked onClick = 'RadioOptions(this.value)' disabled><fmt:message key="Common.open.label" bundle="${common_labels}"/>
				<input type='radio' name='defy_status' id='defy_status' value='X'  onClick = 'RadioOptions(this.value)' disabled><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
				<input type='radio' name='defy_status' id='defy_status' value='C'  onClick= 'RadioOptions(this.value)' disabled><fmt:message key="Common.close.label" bundle="${common_labels}"/>
			<%	}
				else
			{
			if (p_in_type.equals("I")) { %>
				<input type='radio' name='defy_status' id='defy_status' value='O' <%=openSelect%> onClick = 'RadioOptions(this.value)'><fmt:message key="Common.open.label" bundle="${common_labels}"/>
				<input type='radio' name='defy_status' id='defy_status' value='X' <%=cancelSelect%> onClick = 'RadioOptions(this.value)' disabled><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
				<input type='radio' name='defy_status' id='defy_status' value='C' <%=closeSelect%> onClick= 'RadioOptions(this.value)' disabled><fmt:message key="Common.close.label" bundle="${common_labels}"/>
			<% } else { %>
					<input type='radio' name='defy_status' id='defy_status' value='O' <%=openSelect%> onClick = 'RadioOptions(this.value)' disabled><fmt:message key="Common.open.label" bundle="${common_labels}"/>
					<input type='radio' name='defy_status' id='defy_status' value='X' <%=cancelSelect%> onClick = 'RadioOptions(this.value)'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
					<input type='radio' name='defy_status' id='defy_status' value='C' <%=closeSelect%> onClick= 'RadioOptions(this.value)'><fmt:message key="Common.close.label" bundle="${common_labels}"/>
			<% }
			}%>
			</td>
		</tr>
		<tr>
			<td class='label' nowrap><fmt:message key="eFM.DateTimeResolvedCancelled.label" bundle="${fm_labels}"/></td>
			<td class='fields' colspan='3'>
			<input type='text' name='date_resolved' id='date_resolved' maxlength='16' size='17' value='<%=ResDate%>' onBlur="CheckDateResolved(this,'<%=sys_date%>');" disabled><img id='res_date' src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='3'>
			<input type='text' name='remarks' id='remarks' maxlength='60' size='60' onkeypress="checkMaxLimit(this,60)" onBlur="makeValidString(this);" value="<%=DefcRemarks%>">
			</td>
		</tr>
		<tr>
			<td colspan='4' class='button'><input type='button' class='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="CheckDateReported(date_reported,'<%=sys_date%>','<%=Discdate%>');"><input type='button' class='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='ClearRecs();'>
		</td></tr>	
		<%
	}catch(Exception e){out.println("Exception e :"+e);e.printStackTrace();}
	finally
	{
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
	<input type='hidden' name='PatientId' id='PatientId' value='<%=PatientId%>'>
	<input type='hidden' name='operation_mode' id='operation_mode' value='<%=Oper_mode%>'>
	<input type='hidden' name='fac_id' id='fac_id' value='<%=facility_id%>'>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=EncounterId%>'>
	<input type='hidden' name='file_no' id='file_no' value='<%=FileNo%>'>
	<input type='hidden' name='file_type' id='file_type' value='<%=file_type_code%>'>
	<input type='hidden' name='volume_no' id='volume_no' value='<%=volume_no%>'>
	<input type='hidden' name='admission_date' id='admission_date' value='<%=Admndate%>'>
	<input type='hidden' name='discharge_date' id='discharge_date' value='<%=Discdate%>'>
	<input type='hidden' name='care_locn_code' id='care_locn_code' value='<%=Carelocn%>'>
	<input type='hidden' name='defi_completed_status' id='defi_completed_status' value=''>
	<input type='hidden' name='defi_code' id='defi_code' value=''>
	<input type='hidden' name='defi_desc' id='defi_desc' value=''>
	<input type='hidden' name='practitioner' id='practitioner' value=''>
	<input type='hidden' name='practitioner_name' id='practitioner_name' value=''>
	<input type='hidden' name='defi_reported_date' id='defi_reported_date' value='<%=sys_date%>'>
	<input type='hidden' name='defi_status' id='defi_status' value='<%=DefStatus%>'>
	<input type='hidden' name='defi_resolved_date' id='defi_resolved_date' value=''>
	<input type='hidden' name='defi_remarks' id='defi_remarks' value=''>
	<input type='hidden' name='header_exist' id='header_exist' value='<%=Found%>'>
	<input type='hidden' name='record_num' id='record_num' value='<%=Rec_num%>'>
	<input type='hidden' name='dflt_practitioner' id='dflt_practitioner' value="<%=dflt_practitioner%>">
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
	<input type='hidden' name='dflt_practitioner_name' id='dflt_practitioner_name' value="<%=dflt_practitioner_name%>">
	<input type='hidden' name='sys_date' id='sys_date' value="<%=sys_date%>">
</form>
</body>
<script>
function AddRecs()
{
	var Obj = parent.frames[4].document.forms[0]

	if(Obj.defy_status(0).checked == true)
		Obj.defi_status.value = "O";
	else if(Obj.defy_status(1).checked == true)
		Obj.defi_status.value = "X";
	else if(Obj.defy_status(2).checked == true)
		Obj.defi_status.value = "C";

	if(Obj.defi_status.value == "O")
		Obj.defi_completed_status.value = "O";
	else if(Obj.defi_status.value == "X")
		Obj.defi_completed_status.value = "X";
	else
		Obj.defi_completed_status.value = "C";

	Obj.defi_code.value = Obj.deficiency.options[Obj.deficiency.selectedIndex].value;
	Obj.defi_desc.value = Obj.deficiency.options[Obj.deficiency.selectedIndex].text;
	Obj.practitioner.value =Obj.physician.value; 
	Obj.practitioner_name.value = Obj.physician1.value;

	Obj.defi_reported_date.value = Obj.date_reported.value;
	Obj.defi_resolved_date.value = Obj.date_resolved.value;

	var test = Obj.defi_resolved_date.value;
	if(test.charCodeAt(0)==160)
	{
		test="";
		Obj.defi_resolved_date.value = test;
	}
	Obj.defi_remarks.value = Obj.remarks.value;

	var fields = new Array ( Obj.deficiency, Obj.physician1, Obj.date_reported );
	var names = new Array ( getLabel("eFM.DeficiencyType.label","FM"), getLabel("eFM.ResponsiblePractitioner.label","FM") , getLabel("eFM.DateReported.label","FM") );

	if(parent.frames[4].checkFields( fields, names, parent.messageFrame)) 
	{
		if(Obj.defi_status.value == "C" && Obj.date_resolved.value == "")
		{
			//var errors = "APP-000001 Date Resolved cannot be blank..."
			var errors=getMessage("CAN_NOT_BE_BLANK","common");
			errors=errors.replace('$',getLabel("eFM.DateTimeResolved Cancelled.label","FM"));
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors; 
			parent.frames[4].document.forms[0].date_resolved.focus();
		}
		else
		{		
			parent.frames[4].document.forms[0].submit();
			}
	}
}
if("<%=Oper_mode%>" != "Add")
{
	parent.frames[4].document.forms[0].deficiency.disabled = true;
	parent.frames[4].document.forms[0].date_reported.disabled = true;
	parent.frames[4].document.forms[0].prefdt.disabled = true;
	parent.frames[4].document.forms[0].searchcode.disabled=true;
	
	


	if("<%=compStat%>" == "Complete")
	{
		parent.frames[4].document.forms[0].physician.disabled = true;
		parent.frames[4].document.forms[0].physician1.disabled = true;
		parent.frames[4].document.forms[0].searchcode.disabled=true;
		parent.frames[4].document.forms[0].defy_status(0).disabled = true;
		parent.frames[4].document.forms[0].defy_status(1).disabled = true;
		parent.frames[4].document.forms[0].date_resolved.disabled = true;
		parent.frames[4].document.forms[0].remarks.disabled = true;
		parent.frames[4].document.forms[0].add.disabled = true;
	}
}
</script>
<%
}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

