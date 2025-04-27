<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
12/17/2013	 IN040032	 Nijitha S		PMG20089-CRF-0890.2
-----------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/ChartApplicability.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='defaultValue()'>
	<form name="chartApplicabilityaddmodifyForm" id="chartApplicabilityaddmodifyForm"  method ='post' target='messageFrame' action='../../servlet/eCA.ChartApplicabilityServlet'>
	<BR><BR>


<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	String chartId = "";
	String readOnly = "readOnly";
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	String sql = "";
	try
	{     //  String patientClassDesc = "";
			String patientClassCode = "";
			String specialtyDesc = "";
			String specialtyCode = "";
			String practTypeDesc = "";
			String practTypeCode = "";
			//String locationTypeDesc = "";
			String locationTypeCode = "";
			String locationDesc = "";
			String locationCode = "";
			String ageGrpDesc = "";
			String ageGrpCode = "";
			String chartDesc = "";
			String dispSeqNo="";//IN040032
		if(mode.equals("modify"))
		{	
			//patientClassDesc =  request.getParameter("patientClassDesc") == null ? "" : request.getParameter("patientClassDesc");
			patientClassCode =  request.getParameter("patientClassCode") == null ? "" : request.getParameter("patientClassCode");
			specialtyDesc =  request.getParameter("specialtyDesc") == null ? "" : request.getParameter("specialtyDesc");

			specialtyCode =  request.getParameter("specialtyCode") == null ? "" : request.getParameter("specialtyCode");
			practTypeDesc =  request.getParameter("practTypeDesc") == null ? "" : request.getParameter("practTypeDesc");
			practTypeCode =  request.getParameter("practTypeCode") == null ? "" : request.getParameter("practTypeCode");
			//locationTypeDesc =  request.getParameter("locationTypeDesc") == null ? "" : request.getParameter("locationTypeDesc");
			locationTypeCode =  request.getParameter("locationTypeCode") == null ? "" : request.getParameter("locationTypeCode");
			locationDesc =  request.getParameter("locationDesc") == null ? "" : request.getParameter("locationDesc");
			locationCode =  request.getParameter("locationCode") == null ? "" : request.getParameter("locationCode");
			chartId =  request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			chartDesc = request.getParameter("chartDesc") == null ? "" : request.getParameter("chartDesc");
			ageGrpDesc = request.getParameter("ageGrpDesc") == null ? "" : request.getParameter("ageGrpDesc");
			ageGrpCode = request.getParameter("ageGrpCode") == null ? "" : request.getParameter("ageGrpCode");
			dispSeqNo = request.getParameter("dispSeqNo") == null ? "" : request.getParameter("dispSeqNo");//IN040032
		}
		con = ConnectionManager.getConnection(request);
		sql = "select SHORT_DESC,patient_class from AM_PATIENT_CLASS order by 1";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
%>
<br><br><br><br><br><br><br>
<table border='0' cellspacing='0' cellpadding='3' width='60%' align='center'>
		
		<tr>
			<td class ='label' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
				<select name ="patientClass" id ="patientClass" <%if(mode.equals("modify"))out.println("disabled");%>>
				<option value="*A" <%if (patientClassCode.equals("*A")) {out.println("selected");}%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
		while(rs.next())
		{
		
				if (patientClassCode.trim().equals(rs.getString(2).trim()))
				{
					out.println("<option value='"+rs.getString(2)+"' selected>"+rs.getString(1)+"</option>");		
				}
				else
				{
					out.println("<option value='"+rs.getString(2)+"'>"+rs.getString(1)+"</option>");		
				}
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
%>			</select>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eCA.SpecialityDesc.label" bundle="${ca_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='specialtyDesc' id='specialtyDesc' size='20' maxlength='20' OnBlur='getFunctionCode(this)' value='<%=specialtyDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>><input type ='Button' name='buttonSpecialty' id='buttonSpecialty' value='?' class='button' OnCLick = 'getSpecialty()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>
		<tr>
			<td  class='label' ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<input type ='text' name='practTypeDesc' id='practTypeDesc' size='20' maxlength='20' OnBlur='getFunctionCode(this)' value='<%=practTypeDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>><input type ='Button' class='button' name='buttonPractType' id='buttonPractType' value='?' Onclick = 'getPractType()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select name='locationType' id='locationType' OnChange='assignLocationType(this)' <%if(mode.equals("modify"))out.println("disabled");%>>
					<option value='*'  <%if (locationTypeCode.equals("*")) {out.println("selected");}%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='C' <%if (locationTypeCode.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value='N' <%if (locationTypeCode.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				</select>	
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='locationDesc' id='locationDesc' size='20' maxlength='20'  OnBlur='getFunctionCode(this)' value='<%=locationDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>><input type ='Button' class='button' name='buttonLocation' id='buttonLocation' value='?' OnClick = 'getLocation()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='ageGrpDesc' id='ageGrpDesc' size='20' maxlength='20'  OnBlur='getFunctionCode(this)' value='<%=ageGrpDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>><input type ='Button' class='button' name='buttonAgeGrp' id='buttonAgeGrp' value='?' Onclick='getageGroup()' <%if(mode.equals("modify"))out.println("disabled");%>>		
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='chartDesc' id='chartDesc' size='20' maxlength='20'  OnBlur='getFunctionCode(this)' value='<%=chartDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>><input type ='Button' class='button' name='buttonChart' id='buttonChart' value='?' onClick ='getChart()' <%if(mode.equals("modify"))out.println("disabled");%>><img src='../../eCommon/images/mandatory.gif'></img>	
			</td>
		</tr>
		<!-- IN040032 Starts-->
		<tr>
			<td class='label' ><fmt:message key="eCA.DispSeqNo.label" bundle="${ca_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='dispSeqNo' id='dispSeqNo' size='20' maxlength='2' onkeypress='return (allowValidNumber(this,event,2,0))' onblur='CheckPositiveNo(this)' value='<%=dispSeqNo%>'>
			</td>
		</tr>
		<!-- IN040032 Ends -->
			</table>
	<%
	%>	
	<input type ='hidden' name='chartCode' id='chartCode' value='<%=chartId%>'>
	<input type ='hidden' name='oldChartCode' id='oldChartCode' value='<%=chartId%>'>
	<input type ='hidden' name='locationCode' id='locationCode' value='<%=locationCode%>'>		
	<input type ='hidden' name='specialtyCode' id='specialtyCode' value='<%=specialtyCode%>'>		
	<input type ='hidden' name='practTypeCode' id='practTypeCode' value='<%=practTypeCode%>'>		
	<input type ='hidden' name='ageGrpCode' id='ageGrpCode' value='<%=ageGrpCode%>'>		
	<input type ='hidden' name='locationTypeCode' id='locationTypeCode' value='<%=locationTypeCode%>'>
	<input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
	<input type ='hidden' name='oldDispSeqNo' id='oldDispSeqNo' value='<%=dispSeqNo%>'>	<!--IN040032-->
	</form>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in ChartAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) ConnectionManager.returnConnection(con);
			}
		catch(Exception e){out.println(e);}
	}

%>
	</body>
</html>

