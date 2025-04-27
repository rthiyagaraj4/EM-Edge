<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	async function showDateDetails()
	{
		var retVal			= new String();
		var center			= "3" ;
		var dialogTop		= "0vh";
		var dialogHeight	= "39vh";
		var dialogWidth		= "40vw";
		var status			= "no";
		var arguments	= "" ;
		var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

		retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&PrepareDate="+document.getElementById("prepareDate").value+"&applCompletionDate="+document.getElementById("applCompletionDate").value+"&RequestDate="+document.getElementById("RequestDate").value+"&ReceivedDate="+document.getElementById("ReceivedDate").value+"&DeliveredDate="+document.getElementById("DeliveredDate").value,arguments,features);
		/*
		 for icn:6879
		document.forms[0].RequestDate.value insted of this
		document.getElementById("RequestDate").value
		i have modified insted of forms[0] to all
		*/
	}

	async function showChargeDetails()
	{
		var retVal			= new String();
		var center			= "3" ;
		var dialogTop		= "0vh";
		var dialogHeight	= "39vh";
		var dialogWidth		= "40vw";
		var status			= "no";
		var arguments	= "" ;
		var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

		retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&charges_appl_yn="+document.getElementById("hdd_charges_appl_yn").value+"&addl_charges_yn="+document.getElementById("hdd_addl_charges_yn").value+"&receipt_no="+document.getElementById("hdd_receipt_no").value+"&addl_receipt_no="+document.getElementById("hdd_addl_receipt_no").value+"&amount="+document.getElementById("hdd_amount").value+"&addl_amount="+document.getElementById("hdd_addl_amount").value+"&receipt_date="+document.getElementById("hdd_receipt_date").value+"&addl_receipt_date="+document.getElementById("hdd_addl_receipt_date").value,arguments,features);
		/*
		 icn:6879
		document.forms[0].hdd_addl_charges_yn.value insted of this
		document.getElementById("hdd_addl_charges_yn").value
		*/
	}
	</script>
</head>
 
<body onKeyDown='lockKey()'>
<form name='MedBoardReqDetails' id='MedBoardReqDetails'>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String locale = (String) session.getValue("LOCALE");
	StringBuffer sql = new StringBuffer();
	String request_id = "";
	String patient_id = "";
	String request_date = "";
	String med_board_type = "";
	String requesting_pract_name = "";
	String report_type_code = "";
	String patient_name = "";
	String gender = "";
	String age = "";

	String reqDate				= "";
	String appl_completion_date	= "";
	String RecdDate				= "";
	String prepareDate			= "";
	String delivered_date		= "";
	String amount				= "";
	String receipt_no			= "";
	String receipt_date			= "";
	String addl_amount			= "";
	String addl_receipt_no		= "";
	String addl_receipt_date	= "";
	String charges_appl_yn		= "";
	String addl_charges_yn		= "";

	request_id = request.getParameter("request_id")==null?"":request.getParameter("request_id");
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	try
	{
		con = ConnectionManager.getConnection(request);
		sql.append(" select a.patient_id, to_char(a.request_date,'dd/mm/yyyy hh24:mi') request_date, (select short_desc from mr_medical_board_type where med_board_type_code = a.med_board_type_code) short_desc, a.requesting_pract_name, a.report_type_code, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))patient_name, a.gender, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)age, addl_amount, addl_charges_yn, to_char(addl_receipt_date,'dd/mm/yyyy hh24:mi') addl_receipt_date, addl_receipt_no, to_char(appl_completion_date,'dd/mm/yyyy hh24:mi') appl_completion_date, amount, to_char(receipt_date,'dd/mm/yyyy hh24:mi') receipt_date, receipt_no, charges_appl_yn,  to_char(received_date,'dd/mm/yyyy hh24:mi')received_date, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, to_char(delivered_date,'dd/mm/yyyy hh24:mi') delivered_date from MR_REPORT_REQUEST_HDR_VW a where a.request_id = ? ");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,request_id);
		rs=stmt.executeQuery();

		while(rs.next())
		{
			patient_id				= checkForNull(rs.getString("patient_id"));

			request_date			= checkForNull(rs.getString("request_date"));
			if(!(request_date==null || request_date.equals("")))
					request_date	= DateUtils.convertDate(request_date,"DMYHM","en",locale);

			med_board_type			= checkForNull(rs.getString("SHORT_DESC"));
			requesting_pract_name	= checkForNull(rs.getString("requesting_pract_name"));
			report_type_code		= checkForNull(rs.getString("report_type_code"));
			patient_name			= checkForNull(rs.getString("patient_name"));
			gender					= checkForNull(rs.getString("gender"));
			age						= checkForNull(rs.getString("age"));
			amount					= checkForNull(rs.getString("AMOUNT"));
			receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));
			receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
			addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
			addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));
			addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
			charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"));
			addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"));
			reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
			appl_completion_date	= checkForNull(rs.getString("APPL_COMPLETION_DATE"));
			RecdDate				= checkForNull(rs.getString("RECEIVED_DATE")); 
			prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
			delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
		}
	
	if(rs!=null)  rs.close();
	if(stmt!=null)   stmt.close();
	%>
	<table border=0 cellspacing=0 cellpadding=3 width='100%' style='margin-top: -45px' >	
		<!--<tr>
		<%--	if(!patient_name.equals("") || !patient_id.equals(""))			
		{	--%>
			<td class='PATIENTLINECOLOROTHLANG'  ><%=patient_name%>,<%=age%>,<%=gender%></td>
			<td class='PATIENTLINECOLOROTHLANG'  ><%=patient_id%></td>
	<%--	}
		else
		{	--%>
			<td class='PATIENTLINECOLOROTHLANG' >&nbsp;</td>
			<td class='PATIENTLINECOLOROTHLANG' >&nbsp;</td>
	<%--	}	--%>
		</tr>-->
		<tr>
			<td><jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="Patient_ID" value="<%=patient_id%>" /></jsp:include></td>
		</tr>
		<tr>
			<table border=0 cellspacing=0 cellpadding=3 width='100%'>
				<tr align="left">
					<th class="columnheader" colspan='4'><fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
					<td class='DEFAULTBLANKROW2PT' colspan=4 height=5>&nbsp;</td></tr> 
				<tr>
					<td class='label'  width='25%'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
					<td class='querydata'  width='20%'><%=request_id%></td>
					<td class='label'  width='30%'><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
					<td class='querydata'  width='25%'><%=request_date%></td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class='querydata'  ><%=report_type_code%></td>
					<td class='label'  ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
					<td class='querydata'  ><%=requesting_pract_name%></td>
				</tr>
				<tr>
					<td class='label'   ><fmt:message key="eMR.TypeofMedicalBoard.label" bundle="${mr_labels}"/></td>
					<td class='querydata'  ><%=med_board_type%></td>
					<td class='label'  >&nbsp;</td>
					<td class="fields"><input type="button" name="Dates" id="Dates" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")%>" class='button' onclick="showDateDetails();" ><input type="button" name="Charges" id="Charges" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")%>" class='button' onclick="showChargeDetails();" ></td>
				</tr> 
				<tr>
					<td class='DEFAULTBLANKROW2PT' colspan=4 height=5>&nbsp;</td></tr> 
				<tr>
			</table>
		</tr>
	</table>
<input type="hidden" name="prepareDate" id="prepareDate" value="<%=prepareDate%>" >
<input type="hidden" name="applCompletionDate" id="applCompletionDate" value="<%=appl_completion_date%>" >
<input type="hidden" name="RequestDate" id="RequestDate" value="<%=reqDate%>" >
<input type="hidden" name="ReceivedDate" id="ReceivedDate" value="<%=RecdDate%>" >
<input type="hidden" name="DeliveredDate" id="DeliveredDate" value="<%=delivered_date%>" >

<input type="hidden" name="hdd_charges_appl_yn" id="hdd_charges_appl_yn" value="<%=charges_appl_yn%>" >
<input type="hidden" name="hdd_addl_charges_yn" id="hdd_addl_charges_yn" value="<%=addl_charges_yn%>" >
<input type="hidden" name="hdd_receipt_no" id="hdd_receipt_no" value="<%=receipt_no%>" >
<input type="hidden" name="hdd_addl_receipt_no" id="hdd_addl_receipt_no" value="<%=addl_receipt_no%>" >
<input type="hidden" name="hdd_amount" id="hdd_amount" value="<%=amount%>" >
<input type="hidden" name="hdd_addl_amount" id="hdd_addl_amount" value="<%=addl_amount%>" >
<input type="hidden" name="hdd_receipt_date" id="hdd_receipt_date" value="<%=receipt_date%>" >
<input type="hidden" name="hdd_addl_receipt_date" id="hdd_addl_receipt_date" value="<%=addl_receipt_date%>" >


</body>
</form>

<%
	}
	catch(Exception e)
	{
			//out.println("Exception @ MedBoardRequestFrames "+e.toString());
			e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


