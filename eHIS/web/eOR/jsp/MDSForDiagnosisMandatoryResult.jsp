<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69021			Ramesh G			?				?				MMS-DM-CRF-0150
24/12/2021		6868			Ramesh G			24/12/2021		Ramesh G 		AAKH-CRF-0125
--------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String queryString=request.getQueryString();
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties properties			= (Properties) session.getValue( "jdbc" );
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"  language="javascript"></script>
<script language='javascript' src='../js/MDSForDiagnosisMandatory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<form name='MDSForDiagnosisMandatoryHdrFrom' id='MDSForDiagnosisMandatoryHdrFrom' method ='post' target='messageFrame' action='../../servlet/eOR.MDSForDiagnosisMandatoryServlet'>
	<BR>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr><td align="center">
	<%
	String minimumData	= request.getParameter("minimumData");
	String termsetId		= request.getParameter("termsetId");
	String bean_id		= "MDSForDiagnosisMandatoryBean";
	String bean_name 	= "eOR.MDSForDiagnosisMandatoryBean";
	MDSForDiagnosisMandatoryBean bean = (MDSForDiagnosisMandatoryBean)getBeanObject(bean_id,bean_name,request);
	ArrayList<String[]> total_Rec = bean.getResultDetails(properties,minimumData,termsetId);
	int length = total_Rec.size();	
	int selected_rec=0;
	//6868 Start.
	String[] primary_diagnosis_arr= new String[1];
	primary_diagnosis_arr = total_Rec.get(0);
	String primary_diagnosis_val1 = primary_diagnosis_arr[0];
	String primaryDiagnosisChecked = "";
	if("Y".equals(primary_diagnosis_val1))
		primaryDiagnosisChecked ="checked";
	
	if("S".equals(minimumData)){
	%>
		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
			<tr>
				<td class='label'  width='24.75%'><fmt:message key="eOR.PrimaryDiagnosisMandatory.label" bundle="${or_labels}"/></td>
				<td class='fields' colspan="4">&nbsp;&nbsp;				

	<%}else if("O".equals(minimumData)){%>
		<table cellpadding='3' cellspacing='0' border='0' width='50%' align='center'>
			<tr>
				<td class='label'  width='24.75%'><fmt:message key="eOR.PrimaryDiagnosisMandatory.label" bundle="${or_labels}"/></td>
				<td class='fields' colspan="4">&nbsp;&nbsp;	
	<%}else if("P".equals(minimumData)){%>
		<table cellpadding='3' cellspacing='0' border='0' width='50%' align='center'>
			<tr>
				<td class='label'  width='24.75%'><fmt:message key="eOR.PrimaryDiagnosisMandatory.label" bundle="${or_labels}"/></td>
				<td class='fields' colspan="4">&nbsp;&nbsp;	
	<%
	}
	%>
					<input type='checkbox' name='primaryDiagnosis' id='primaryDiagnosis' id="primaryDiagnosis" value='<%=primary_diagnosis_val1%>' <%=primaryDiagnosisChecked%>  onclick="setPrimaryDiagnosisValue(this)" />
				</td>
			</tr>
	<%
//6868 End.	
	if("S".equals(minimumData)){
	%>		
		<tr>		
			<td class='COLUMNHEADER' colspan="5" align=right>
				Select All &nbsp;&nbsp; <input type="checkbox" name="totalCheck" id="totalCheck" id="totalCheck" value="" onclick="checkedAll(this)" />
				&nbsp;
			</td>
					
		</tr>
		<tr>		
			<td class='COLUMNHEADER' width='35%'><fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'>&nbsp;</td>
			<td class='COLUMNHEADER' width='10%'>&nbsp;</td>
			<td class='COLUMNHEADER' width='35%'><fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'>&nbsp;</td>			
		</tr>
	<%}else if("O".equals(minimumData)){%>		
		<tr>		
			<td class='COLUMNHEADER' colspan="2" align=right>
				Select All &nbsp;&nbsp; <input type="checkbox" name="totalCheck" id="totalCheck" id="totalCheck" value="" onclick="checkedAll(this)" />
				&nbsp;
			</td>
					
		</tr>
		<tr>		
			<td class='COLUMNHEADER' width='80%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'>&nbsp;</td>						
		</tr>		
	<%}else if("P".equals(minimumData)){%>		
		<tr>		
			<td class='COLUMNHEADER' colspan="2"  align=right>
				Select All &nbsp;&nbsp; <input type="checkbox" name="totalCheck" id="totalCheck" id="totalCheck" value="" onclick="checkedAll(this)" />
				&nbsp;
			</td>
					
		</tr>
		<tr>		
			<td class='COLUMNHEADER' width='80%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'>&nbsp;</td>						
		</tr>
	<%
	}
	if("S".equals(minimumData)){
		for(int start=1;start<length;start++){
			%><tr><%
				String[] row_val= new String[3];
				row_val = total_Rec.get(start);
				String  recCheckbox="";				
				if("Y".equals(row_val[2])){
					selected_rec++;
					recCheckbox="checked";
				}				
								
	%>				
			<td class='gridData' width='35%'><%=row_val[1]%></td>
			<td class='gridData' width='10%'>
				<input type="checkbox" name="CV_<%=start%>" id="CV_<%=start%>" id="CV_<%=start%>" value="<%=row_val[2]%>" <%=recCheckbox%> onclick="setCheckValue(this)" />
				<input type="hidden" name="CI_<%=start%>" id="CI_<%=start%>" id="CI_<%=start%>" value="<%=row_val[0]%>">
			</td>
			<td class='gridData' width='10%'>&nbsp;</td>
			<%
			if((start+1)<length){
				String[] row_val1= new String[3];
				row_val1 = total_Rec.get(start+1);
				String  recCheckbox1="";
				if("Y".equals(row_val1[2])){
					selected_rec++;
					recCheckbox1="checked";
				}
			%>
			<td class='gridData' width='35%'><%=row_val1[1]%></td>
			<td class='gridData' width='10%'>
				<input type="checkbox" name="CV_<%=(start+1)%>" id="CV_<%=(start+1)%>" id="CV_<%=(start+1)%>" value="<%=row_val1[2]%>" <%=recCheckbox1%>  onclick="setCheckValue(this)" />
				<input type="hidden" name="CI_<%=(start+1)%>" id="CI_<%=(start+1)%>" id="CI_<%=(start+1)%>" value="<%=row_val1[0]%>">
			</td>	
			<%
			start++;
			}else{
			%>
			<td class='gridData' width='35%'>&nbsp;</td>
			<td class='gridData' width='10%'>&nbsp;</td>
			<%}%>
		</tr>		

	<%		
		}
	}else if("O".equals(minimumData)||"P".equals(minimumData)){
		for(int start=1;start<length;start++){
			%><tr><%
				String[] row_val= new String[3];
				row_val = total_Rec.get(start);
				String  recCheckbox="";				
				if("Y".equals(row_val[2])){
					selected_rec++;
					recCheckbox="checked";
				}				
			
	%>
			<td class='gridData' width='80%'><%=row_val[1]%></td>
			<td class='gridData' width='20%'>
				<input type="checkbox" name="CV_<%=start%>" id="CV_<%=start%>" id="CV_<%=start%>" value="<%=row_val[2]%>" <%=recCheckbox%> onclick="setCheckValue(this)" />
				<input type="hidden" name="CI_<%=start%>" id="CI_<%=start%>" id="CI_<%=start%>" value="<%=row_val[0]%>">
			</td>
			</tr>
	<%
		}
	}
	%>
	</table>
	</td></tr>
	</table>	
	<input type="hidden" name="totalRec" id="totalRec" id="totalRec" value="<%=length%>"/>
	<input type="hidden" name="minimumData" id="minimumData" id="minimumData" value="<%=minimumData%>"/>
	<input type="hidden" name="termsetId" id="termsetId" id="termsetId" value="<%=termsetId%>"/>
	<input type="hidden" name="selectedRec" id="selectedRec" id="selectedRec" value="<%=selected_rec%>"/>
	<input type="hidden" name="primaryDiagnosisYN" id="primaryDiagnosisYN" id="primaryDiagnosisYN" value="<%=primary_diagnosis_val1%>"/> <!-- 6868 -->
	</form>
	<script>
		if(<%=length%>==<%=selected_rec%>)
			document.forms[0].totalCheck.checked=true;
	</script>
</body>
</html>

