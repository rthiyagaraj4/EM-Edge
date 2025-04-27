<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
01/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*, java.io.*, eCA.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
		<script language="JavaScript" src ="../../eCA/js/EncSummApplicability.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='defaultValue()'>
	<form name="encSummApplicabilityForm" id="encSummApplicabilityForm">
	<BR><BR>
<%	  
	
	String patientClassCode = "", patientClassDesc = "";
	String specialtyCode = "", specialtyDesc = "";	
	String practTypeCode = "", practTypeDesc = "";
	String practitionerId = "", practitionerName = "";
	String ageGrpCode = "", ageGrpDesc = "";
	String summCode = "", summDesc = "";
	int ntypeListSize = 0;
	
	String readOnly = "readOnly";
	String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 	
	
	List<PatientClassBean> oPatientClassList = null;
	PatientClassBean sPatientClassBean = null;
	
	String sPatientClass = "";
	
	try
	{     //  String patientClassDesc = "";
	
		if(mode=="insert" || mode.equals("insert") || mode == null) 
		{
			mode="insert";
			
			oPatientClassList = new ArrayList<PatientClassBean>();
			sPatientClassBean = new PatientClassBean();
			
			sPatientClassBean.setRequest(request);
			oPatientClassList = summGrpDetails.getPatientClass(sPatientClassBean);		
			
			ntypeListSize = oPatientClassList.size();
			
			if (ntypeListSize>0)
			{
				for (int i=0;i<ntypeListSize;i++)
				{
					sPatientClassBean = oPatientClassList.get(i);
					sPatientClass = sPatientClass + "<Option value="+sPatientClassBean.getsPatientClass()+">" +sPatientClassBean.getsShortDesc()+ "</option>";
				}
			}
		}
		
		ntypeListSize = 0;
			
		if(mode.equals("modify"))
		{	
			patientClassCode = request.getParameter("patientClassCode") == null ? "" : request.getParameter("patientClassCode");
			patientClassDesc = request.getParameter("patientClassDesc") == null ? "" : request.getParameter("patientClassDesc");			
					
			sPatientClass = "<Option value="+patientClassCode+">" +patientClassDesc+ "</option>";
			
			specialtyDesc =  request.getParameter("specialtyDesc") == null ? "" : request.getParameter("specialtyDesc");
			specialtyCode =  request.getParameter("specialtyCode") == null ? "" : request.getParameter("specialtyCode");
			
			practTypeCode =  request.getParameter("practTypeCode") == null ? "" : request.getParameter("practTypeCode");
			practTypeDesc =  request.getParameter("practTypeDesc") == null ? "" : request.getParameter("practTypeDesc");
			
			practitionerId =  request.getParameter("practitionerId") == null ? "" : request.getParameter("practitionerId");
			practitionerName =  request.getParameter("practitionerName") == null ? "" : request.getParameter("practitionerName");
			
			ageGrpDesc = request.getParameter("ageGrpDesc") == null ? "" : request.getParameter("ageGrpDesc");
			ageGrpCode = request.getParameter("ageGrpCode") == null ? "" : request.getParameter("ageGrpCode");
			
			summCode =  request.getParameter("encSummCode") == null ? "" : request.getParameter("encSummCode");
			summDesc = request.getParameter("encSummDesc") == null ? "" : request.getParameter("encSummDesc");
		}		
%>
	<br><br>
	<table cellspacing='0' cellpadding='3' width='50%' align='left' border='1' RULES=NONE FRAME=BOX>
		
		<tr>
			<td class ='label' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
				<select name ="patientClass" <%if(mode.equals("modify"))out.println("disabled");%>>
				<%
					if (mode=="insert")
					{
				%>
				<option value="*A" <%if (patientClassCode.equals("*A")) {out.println("selected");}%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<%=sPatientClass%>				
				<%
					}
					else
					{
				%>
					<%=sPatientClass%>
				<%
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eCA.SpecialityDesc.label" bundle="${ca_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='specialtyDesc' id='specialtyDesc' size='20' maxlength='20' OnBlur='getFunctionCode(this)' value='<%=specialtyDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>>
				<input type ='Button' name='buttonSpecialty' id='buttonSpecialty' value='?' class='button' OnCLick = 'getSpecialty()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>	
		<tr>
			<td  class='label' ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<input type ='text' name='practTypeDesc' id='practTypeDesc' size='20' maxlength='20' OnBlur='getFunctionCode(this)' value='<%=practTypeDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>>
				<input type ='Button' class='button' name='buttonPractType' id='buttonPractType' value='?' Onclick = 'getPractType()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>	
		<tr>
			<td  class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<input type ='text' name='practitionerName' id='practitionerName' size='20' maxlength='20' OnBlur='getFunctionCode(this)' value='<%=practitionerName%>' <%if(mode.equals("modify"))out.println(readOnly);%>>
				<input type ='Button' class='button' name='buttonPractID' id='buttonPractID' value='?' Onclick = 'getPractitionerName()' <%if(mode.equals("modify"))out.println("disabled");%>>
			</td>
		</tr>	
		<tr>
			<td class='label' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='ageGrpDesc' id='ageGrpDesc' size='20' maxlength='20'  OnBlur='getFunctionCode(this)' value='<%=ageGrpDesc%>' <%if(mode.equals("modify"))out.println(readOnly);%>>
				<input type ='Button' class='button' name='buttonAgeGrp' id='buttonAgeGrp' value='?' Onclick='getAgeGroup()' <%if(mode.equals("modify"))out.println("disabled");%>>		
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type ='text' name='summDesc' id='summDesc' size='20' maxlength='20'  OnBlur='getFunctionCode(this)' value='<%=summDesc%>'>
				<input type ='Button' class='button' name='buttonChart' id='buttonChart' value='?' onClick ='getSummary()' >
				<img src='../../eCommon/images/mandatory.gif'></img>	
			</td>
		</tr>
	</table>
	<%
	%>	
	<input type ='hidden' name='summCode' id='summCode' value='<%=summCode%>'>
	<input type ='hidden' name='specialtyCode' id='specialtyCode' value='<%=specialtyCode%>'>	
	<input type ='hidden' name='practTypeCode' id='practTypeCode' value='<%=practTypeCode%>'>	
	<input type ='hidden' name='practitionerId' id='practitionerId' value='<%=practitionerId%>'>		
	<input type ='hidden' name='ageGrpCode' id='ageGrpCode' value='<%=ageGrpCode%>'>		
	<input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
	<input type ='hidden' name='oldSummCode' id='oldSummCode' value='<%=summCode%>'>
	</form>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in EncSummApplicability : "+ee.toString());//COMMON-ICN-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
%>
	</body>
</html>

