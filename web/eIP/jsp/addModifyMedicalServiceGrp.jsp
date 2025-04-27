<!DOCTYPE html>
 <!--
	Developed by 	:	Chitra 
	Created on 		:	21/06/2001
	Module			:	IP
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	Statement stmt			= null;
	ResultSet statusRset	= null;
	Statement statusStmt	= null;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
 <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	
	<script src='../js/MedicalServiceGrp.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	

	<script>
	</script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='FocusFirstElement()'>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String fnval				= "insert";
	//String sel					= "";
	String chk					= "checked";
	String chk1					= "";
	String rd					= "";
	String dis					= "";
	String rdall				= "";
	//String disall				= "";
	String medsergrpcode		= "";
	String longdesc				= "";
	String shortdesc			= "";
	String effstatus			= "";
	String maxnoofdlybooking	= "";
	String maxnoodmthlybooking	= "";
	String generatenumyn		= "";
	//String prefixrequiredyn		= "";	
	String nextseqno			= "";
	String maxseqno				= "";
	//String dayCareDesc			= "";
	//String dayCareCode			= "";
	String patientClassCode		= "";

	String next;
	String max;
	String maxd;
	String maxm;

	int count = 0;
	String code		= request.getParameter("med_ser_grp_code");
	String facid	= request.getParameter("facility_id");

try{
	 con = ConnectionManager.getConnection(request);
	if(code == null) 		
		code = "";
	else
	{
			fnval = "modify";
			rd	  = "readonly";
			dis	  = "disabled";

/// Added by Sridhar on 12 JUNE 2004
/// It will fetch the count of medical service code from IP_MED_SER_GRP_NURS_UT_TYPE to the code entered in Medical service Group...
/// If Count is greater than zero.. the medical service grp cannat be disabled...

		StringBuffer statusSql = new StringBuffer();
		statusSql.append(" select count(*) from IP_MED_SER_GRP_NURS_UT_TYPE a, IP_MEDICAL_SERVICE_GROUP b where a.MED_SER_GRP_CODE = '"+code+"' and a.facility_id='"+facid+"' and b.EFF_STATUS = 'E'  and a.facility_id = b.facility_id and a.MED_SER_GRP_CODE = b.MED_SER_GRP_CODE");

		statusStmt = con.createStatement();
		statusRset = statusStmt.executeQuery( statusSql.toString() );

		if(statusRset != null)
		{
			while( statusRset.next() )
			{
				count = statusRset.getInt(1);
			}
		}

	if(statusRset !=null) statusRset.close(); 
	if(statusStmt != null) statusStmt.close();


			pstmt=con.prepareStatement("select * from ip_medical_service_group where med_ser_grp_code=? and facility_id =?");
			pstmt.setString(1,code);
			pstmt.setString(2,facid);

			rset=pstmt.executeQuery();
			rset.next();
			medsergrpcode		= rset.getString("med_ser_grp_code");
			longdesc			= rset.getString("long_desc");
			shortdesc			= rset.getString("short_desc");
			maxd				= rset.getString("max_no_of_dly_booking");
			if(maxd ==null) maxd="0";
			maxm				= rset.getString("max_no_of_mthly_booking");
			if(maxm ==null) maxm="0";
			generatenumyn		= rset.getString("generate_num_yn");
			next				= rset.getString("next_seq_no");
			if(next ==null) next="0";
			max					= rset.getString("max_seq_no");
			if(max ==null) max="0";
			effstatus			= rset.getString("eff_status");
			
			patientClassCode	= rset.getString("APPL_PATIENT_CLASS");
			if(patientClassCode	== null) patientClassCode = "";
			

			if(rset !=null) rset.close(); 
			if(pstmt != null) pstmt.close();

			if(maxd.equals("0"))
				maxnoofdlybooking = "";
			else
				maxnoofdlybooking = maxd;


			if(maxm.equals("0"))
				maxnoodmthlybooking = "";
			else
				maxnoodmthlybooking = maxm;


			if(next.equals("0"))
				nextseqno = "";
			else
				nextseqno = next;


			if(max.equals("0"))
				maxseqno = "";
			else
				maxseqno = max;

			if(generatenumyn.equals("Y")) 		
				chk1 = "checked";

			if(effstatus.equals("D"))
			{
				chk		= "";
				//disall	= "disabled";
				rdall	= "readonly";
			}
	}
%>

<form name='MedicalServiceGrp_form' id='MedicalServiceGrp_form'  method="post" action="../../servlet/eIP.MedicalServiceGrpServlet" target="messageFrame">
<br><br><br><br><br> 
<table cellspacing=0 cellpadding = 0 align='center' width='90%' border='0'>
<input type="hidden" name="hddfnval" id="hddfnval" value="<%=fnval%>">
<input type="hidden" name="hddcount" id="hddcount" value="<%=count%>">	
		<tr><td class='label' colspan=4>&nbsp;</td></tr>

	<tr>
		<td class='label' align='right' width='25%' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" name="med_ser_grp_code" id="med_ser_grp_code" size='2' maxlength='2' value="<%=medsergrpcode%>"  <%=rd%> onBlur="javascript:ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' colspan=2>&nbsp;</td>
	</tr>

		<tr><td class='label' colspan=4>&nbsp;</td></tr>

	<tr>
		<td class='label' align='right' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap><input type="text" name="long_desc" id="long_desc" size='30' maxlength='30' value="<%=longdesc%>" <%=rdall%> onBlur="makeValidString(this)"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td nowrap class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap><input type="text" name="short_desc" id="short_desc" size='15' maxlength='15' value="<%=shortdesc%>" <%=rdall%> onBlur="makeValidString(this)"><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>

		<tr><td class='label' colspan=4>&nbsp;</td></tr>

	<tr>
		<td class='label' nowrap align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap><input type="checkbox" name="eff_status" id="eff_status" onclick="chkMedStatus();" value='E' <%=chk%>></td>
		<td class='label' colspan=2 >&nbsp;</td>
	</tr>

	<tr><td class='label' colspan=4>&nbsp;</td></tr>
</table>
<br>

<table cellspacing=0 cellpadding=0 align='center' width='90%' border='0'>
	<th align='left'  colspan='6'><fmt:message key="eIP.BookingRelatedSetup.label" bundle="${ip_labels}"/></th>

	<tr><td class='label' colspan=6>&nbsp;</td></tr>

	<tr colspan="6">
		<td class='label' nowrap align='right' width='25%'><fmt:message key="eIP.MaxDailyBooking.label" bundle="${ip_labels}"/></td>
		<td class='fields' nowrap width='33%'><input type="text" name="max_no_of_dly_booking" id="max_no_of_dly_booking" size='6' maxlength='6' value="<%=maxnoofdlybooking%>" <%=rdall%> onKeyPress='return(ChkNumberInput1(event))' onBlur="checkNum(this,'N');"></td>
		<td nowrap class='label' align='right' width='23%'><fmt:message key="eIP.MaxMonthlyBooking.label" bundle="${ip_labels}"/></td>
		<td class='fields' nowrap width='28%'><input type="text" name="max_no_of_mthly_booking" id="max_no_of_mthly_booking" size='6' maxlength='6' value="<%=maxnoodmthlybooking%>" <%=rdall%> onKeyPress='return(ChkNumberInput1(event))' onBlur="checkNum(this,'M');">
		</td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
	</tr>

	<tr><td class='label' colspan=6>&nbsp;</td></tr>

	<tr>
		<td class='label' nowrap  align='right' width="26%"><fmt:message key="eIP.GenerateBookingNumber.label" bundle="${ip_labels}"/></td>
		<td class='fields' nowrap><input type="checkbox" name="generate_num_yn" id="generate_num_yn" value='Y'  <%=chk1%> <%=dis%> onClick="javascript:enableDisable(this)"></td>
		<input type="hidden" name="prefix_required_yn" id="prefix_required_yn" value='Y'>
		 <td class='label' colspan="4">&nbsp;</td> 
	</tr>

	<tr><td class='label' colspan="6">&nbsp;</td></tr>

	<tr>
		<td nowrap class='label' align='right'><fmt:message key="eIP.NextNo.label" bundle="${ip_labels}"/></td>
		<td nowrap class='fields'><input type="text" size='10' maxlength='10' name="next_seq_no" id="next_seq_no"  readonly value="<%=nextseqno%>" <%=rd%> onKeyPress='return(ChkNumberInput1(event))' onblur="javascript:checkNum(this,'N')"><img align='center' src='../../eCommon/images/mandatory.gif' style="visibility:Hidden" id="nextno" ></img></td>
		<td nowrap class='label' align='right'><fmt:message key="eIP.MaxNo.label" bundle="${ip_labels}"/></td>
		<td class='fields' nowrap><input type="text" size='10' maxlength='10' name="max_seq_no" id="max_seq_no"  readonly value="<%=maxseqno%>"  <%=rd%> onKeyPress='return(ChkNumberInput1(event))' onblur="javascript:checkNum(this,'M')"><img align='center' src='../../eCommon/images/mandatory.gif' style="visibility:Hidden" id="maxno"></img></td>
		<td class='label' colspan="2">&nbsp;</td>
	</tr>

	<tr><td class='label' colspan="6">&nbsp;</td></tr>
	</table>
	<input type="hidden" name="function_name" id="function_name" value="<%=fnval%>">
</form>

	<%
		if(pstmt != null)	pstmt.close();
		if(rset	!= null)    rset.close();
		if(stmt != null)    stmt.close();

	}catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 %>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

