<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="ePH.DispenseDetail.label" bundle="${ph_labels}"/></title>
</head>
<!-- <body topmargin="0"> -->
<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
<form name="frmDispMedicationDeliveryDetails" id="frmDispMedicationDeliveryDetails" >
<%

	String bean_id			= "DispMedicationBean" ;
	String bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList result		= bean.getNationalityDetails(); 
	String issue_token_on_regn_yn = bean.getIssueTokenOnRegnYN();
	String patient_id		= request.getParameter("patient_id");
	String sTokenNo			= request.getParameter("token_no") != null?request.getParameter("token_no"):"";
	String collected_by		= "";
	String gender			= "";
	String nationality		= "";
	String date_time		= bean.getTodaysDateTime();
	String token_series_code = "";
	String token_no			= "";
	//String sql_ph_disp_locn_select10=PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT10"); query hard coded for Incident 23725.
	String disp_locn_catg	= bean.getDispLocnCatg();
	String Received_at		="";
	String selected1		="selected";
	String selected2		="";
	String practioner_name	="";
	String order_id			="";
	String sort_records_by="ORDER";
	order_id= bean.getOrderID();
		if(order_id.equals("")){
			sort_records_by	="Patient";
		}else{
			sort_records_by ="Order";
		}
	if(issue_token_on_regn_yn.equals("Y")){
		collected_by  = "";
		ArrayList arr_list = bean.getCollectorDetails(patient_id,sort_records_by);

		if(arr_list.size()>0){
			token_series_code = bean.getTokenSeriesDescription();
			token_no	 = (String)arr_list.get(1);
			collected_by = (String)arr_list.get(2);
			nationality  = (String)arr_list.get(3);
			gender		 = (String)arr_list.get(4);
		}		
	} else {
			ArrayList arr_list	= bean.getPatientDetails();
			int index	 = arr_list.indexOf(patient_id);
			collected_by = (String)arr_list.get(index+1);			
			nationality  = (String)arr_list.get(index+2);
			gender		 = (String)arr_list.get(index+3);
	}
	
	
	String	bean_id_1			=	"DispMedicationAllStages" ;
	String	bean_name_1			=	"ePH.DispMedicationAllStages";
	
	DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request);
	bean_1.setLanguageId(locale);
	String pharmacist_id		= bean_1.getPharmacistID();
	ArrayList collectorDetails  = bean.getDeliveryDetails();	

	if(collectorDetails != null){
		if(collectorDetails.size()>0){
			if(bean.getCollectorDtlsFlag().equals("Y")){
				collected_by = (String)collectorDetails.get(0);
				gender		 = (String)collectorDetails.get(1);
			}

            if(collectorDetails.size()==8)
			{
			  Received_at		= (String)collectorDetails.get(5);
			  practioner_name	= (String)collectorDetails.get(7);			  

			}else
			{
			  Received_at		= (String)collectorDetails.get(6);
			  practioner_name	= (String)collectorDetails.get(8);

			}             

            if(Received_at.equals("P") )
			{
				selected1="selected";
				
			}else if(Received_at.equals("B") )
			{  
				selected1="";
				selected2="selected";
			}
			if(collectorDetails.size()==7){
				ArrayList arr_list = bean.getCollectorDetails(patient_id,sort_records_by);
				if(arr_list.size()>0){
					token_series_code = bean.getTokenSeriesDescription();
					token_no		  = (String)arr_list.get(1);
					
				}
			}
		}
	}
	if(collected_by.length()>29){
							collected_by=collected_by.substring(0,29)+"...";
	}
	String selectUnknown="";
	String selectMale="";
	String selectFemale="";
	if(gender.equals("U")){
		selectUnknown	= "selected";
		selectMale		="";
		selectFemale	="";
	}else if(gender.equals("M")){
		selectUnknown	="";
		selectMale		= "selected";
		selectFemale	="";
	}else if(gender.equals("F")){
		selectUnknown	="";
		selectMale		="";
		selectFemale	="selected";
	}
	if(!sTokenNo.equals("") && !sTokenNo.equals("undefined"))
		token_no = sTokenNo;
%>

<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
<td class='COLUMNHEADER'  colspan="2" align="left">
	<fmt:message key="ePH.ReceiverDetails.label" bundle="${ph_labels}"/>
</td>
<%
	if(issue_token_on_regn_yn.equals("Y") && disp_locn_catg.equals("O")){
%>
<tr>
	<td  class="label"><fmt:message key="ePH.TokenSeriesDescription.label" bundle="${ph_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type="text" name="token_series_code" id="token_series_code" value="<%=token_series_code%>" size="20" disabled>&nbsp;</td>
</tr>
<tr>
<td  class="label"><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type="text" name="token_number" id="token_number" value="<%=token_no%>" size="10" disabled>&nbsp;</td>
</tr>
<%
	}
%>
<tr>
	<td  class="label"><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;&nbsp;<input type="text" value="<%=collected_by%>" size="30" maxlength="30" name="collected_by"><img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;
		<select name="gender" id="gender">
			<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<option value="U" <%=selectUnknown%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<option value="M" <%=selectMale%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F" <%=selectFemale%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		</select>
		<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;
		<select name="nationality" id="nationality">
			<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<%
				for (int i=0;i<result.size();i++){
					if(nationality.equals((String)result.get(i))){
			%>
				<option value="<%=result.get(i)%>" selected><%=result.get(++i)%></option>
			<%
					}else{
			%>
				<option value="<%=result.get(i)%>" ><%=result.get(++i)%></option>
			<%
					}
				}
			%>
		</select>
	</td>
</tr>
<td class='COLUMNHEADER' colspan="2" align="left">	
	<fmt:message key="ePH.DispensingPharmacistDetails.label" bundle="${ph_labels}"/>
</td>
<tr>
	<td  class="label"><fmt:message key="ePH.DispensedBy.label" bundle="${ph_labels}"/></td>
	<td  class='fields'>&nbsp;&nbsp;<input type="text" name="dispensed_by" id="dispensed_by" value="<%=pharmacist_id%>" size="30" disabled>&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;&nbsp;<input type="text" name="date_time" id="date_time" value="<%=com.ehis.util.DateUtils.convertDate(date_time,"DMYHM","en",locale)%>" size="12" readOnly></td>
</tr>
<tr>
	<td  class="label"><fmt:message key="ePH.Receivedat.label" bundle="${ph_labels}"/> </td>
	<td  class='fields'>&nbsp;
		<select name="Received_at" id="Received_at" onchange="parent.makemand(Received_at)">
			<option value="P" <%=selected1%>> <fmt:message key="ePH.CollectedatPharmacy.label" bundle="${ph_labels}"/> </option>
			<option value="B" <%=selected2%> ><fmt:message key="ePH.DeliveredatBedside.label" bundle="${ph_labels}"/></option>
		</select>
	</td>
</tr>
<tr >
		<td  class="label"><fmt:message key="Common.CounterCheckedBy.label" bundle="${common_labels}"/></td>
		<td   class='fields'>&nbsp;&nbsp;<input type="text" name="practioner_name" id="practioner_name" maxlength="40" size="40" value="<%=practioner_name%>" readonly><input type="button" class="button" value="?" name="practioner_search" id="practioner_search" onclick="parent.searchPractionerName(this);">
		<input type="hidden" name="practioner_id" id="practioner_id" value=""> </td>
</tr>
<tr><td    align='right' colspan='2'><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="window.returnValue='OK';storeDispensingDetails('<%=issue_token_on_regn_yn%>')"><input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="window.returnValue='Cancel';parent.window.close()"></td>
</tr>
</table>
<input type="hidden" name="sql_ph_disp_locn_select10" id="sql_ph_disp_locn_select10" value="SELECT PRACTITIONER_ID CODE,PRACTITIONER_NAME  DESCRIPTION FROM AM_PRACTITIONER WHERE PRACT_TYPE ='PH' AND UPPER(PRACTITIONER_ID) LIKE UPPER(?)  AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) ORDER BY 2">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
<input type="hidden" name="Language_id" id="Language_id" value="<%=locale%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>

