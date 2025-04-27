<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	23/06/2002
	Module/Function	:	FM/Generate Pull List
	Function		:	
-->
<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String facility_id="";
	String sys_date="", sysdate="";
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	String fs_locn_code = request.getParameter("fs_locn_code");
	if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
	String appl_user1 = request.getParameter("appl_user");
	if(appl_user1 == null || appl_user1.equals("null"))appl_user1="";
	String customer_id = "";
	String sys_date_old="";
	String customer_id_old="";
	String sysdate_old="";
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		stmt		=	con.createStatement();
	
	   sys_date_old=(String)session.getAttribute("sys_date");
		sysdate_old=(String)session.getAttribute("sysdate");
		customer_id_old=(String)session.getAttribute("customer_id");
		if(sys_date_old == null || sys_date_old.equals("null")) sys_date_old="";
		if(sysdate_old == null || sysdate_old.equals("null")) sysdate_old="";
		if(customer_id_old == null || customer_id_old.equals("null")) customer_id_old="";
		
		
		if(customer_id_old.equals("") || sys_date_old.equals("") || sysdate_old.equals(""))
		{
		String sql_site = "select customer_id from sm_site_param where site_id = 'DS'";

		rs			=	stmt.executeQuery(sql_site);
		if(rs!=null && rs.next()) {
			customer_id = checkForNull(rs.getString("customer_id"));			
		}		
		if(rs != null)		rs.close();
				
		String sys_date_query="Select to_char(sysdate+nvl(NO_DAYS_CHECK_BOOK_INQUIRY,0), 'dd/mm/YYYY'), to_char(sysdate, 'dd/mm/YYYY') from fm_parameter WHERE FACILITY_ID = '"+facility_id+"'";
		rs			=	stmt.executeQuery(sys_date_query);
		if(rs.next())
		{
			sys_date	=	rs.getString(1);
			sysdate		=	rs.getString(2);
		}
		sys_date=DateUtils.convertDate(sys_date,"DMY","en",localeName);
		session.setAttribute("sys_date",sys_date);
		session.setAttribute("sysdate",sysdate);
		session.setAttribute("customer_id",customer_id);
		
		}else{
    sys_date=sys_date_old;
    sysdate=sysdate_old;
    customer_id=customer_id_old;
		}
		
		%> 
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPGeneratePullList.js'></script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad="FocusFirstElement();chng_appt_date(document.forms[0].print_pull_list_type);" onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
	<form name='GenaratePulingListForm' id='GenaratePulingListForm'>
	
	<table cellpadding='3' cellspacing='0' width='100%' border='0' align='center'>
	<!-- <tr><td class=label colspan='5'><td></tr> -->
	<tr>
		<td class='label' width='25%'><fmt:message key="eFM.PullingListType.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'><select name=print_pull_list_type onChange='chng_appt_date(this)'  >
		<option value='M'><fmt:message key="Common.main.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="eFM.Supplementary.label" bundle="${fm_labels}"/></option>
		</select> </td>
		<td class=label width='25%'></td>
		<td class=label width='25%'></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_preferred_date' id='fm_preferred_date' size='10'  maxlength='10' OnBlur='if(validDateObj(this,"DMY","<%=localeName%>")){ valChkDate(sysdate,this,sys_date);}' value='<%=sys_date%>' id="date_to" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fm_preferred_date');" id="calend">	<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=p_gender >
			<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select><input type='hidden' name='to_appt_date_disp' id='to_appt_date_disp' size='10' maxlength='10' value='<%=sys_date%>'  disabled><input type='hidden' name='to_appt_date' id='to_appt_date' value=''></td>
	</tr>
	<tr>
		<td></td>
		<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td></td>
		<td  class='querydata'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_nursing_unit_code' id='fm_nursing_unit_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this);chngnursing_unit(this);if(this.value != ''){search(nursing_unit1,fm_nursing_unit_code,facility_id)};" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' id='nursing_unit1' name='nursing_unit' id='nursing_unit' value='?'  onClick='search(this,fm_nursing_unit_code,facility_id);' ></td>
		<td class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='to_nursing_unit_code' id='to_nursing_unit_code' size='4' maxlength='4' value='' onBlur="changeUpperCase(this);if(this.value != ''){search(nursing_unit1,fm_nursing_unit_code,facility_id)}" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='nursing_unit' id='nursing_unit' value='?' onClick='search(this,to_nursing_unit_code,facility_id);'></td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='fm_pract_id' id='fm_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this);chngnursing_unit(this);if(this.value != ''){search(pract_id1,fm_pract_id,facility_id)};" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='pract_id' id='pract_id1' value='?' onClick='search(this,fm_pract_id,facility_id);'></td> 
		<td class='label'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='text' name='to_pract_id' id='to_pract_id' size='15' maxlength='15' value='' onBlur="changeUpperCase(this);if(this.value != ''){search(pract_id,to_pract_id,facility_id)};" onKeyPress='return CheckForSpecChars(event)' ><input type='button' class='button' name='pract_id' id='pract_id' value='?' onClick='search(this,to_pract_id,facility_id);'></td>
	</tr>
		<tr>
		<td colspan='4' > </td></tr>
		<tr><td colspan='4' class = 'BLANKWHITEROW'> </td></tr>
		<tr>
		<td colspan='4' > </td></tr>
	<tr>
		<td class='label'><fmt:message key="eFM.PrintPullingList.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='gen_report' id='gen_report' value='N' onClick="EnableDisableBox(this,'G')" ></td>
		<td class='label' ><fmt:message key="eFM.PrintTracerCard.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox' name='gen_tracer' id='gen_tracer' value='N' onClick="EnableDisableBox(this,'P')" ></td>
	</tr>
	<%
			if(!customer_id.equals("SRR")) {%>
		<tr>
			<td class='label'><fmt:message key="eFM.PrintTelNoinPullingList.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type='checkbox' name='print_tel_no' id='print_tel_no' value='N' onClick="EnableDisableBox(this,'T')" disabled></td>
			<td class='label'><fmt:message key="eFM.PrintBarCode.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type='checkbox' name='print_bar_code' id='print_bar_code' value='N' onClick="assignvalue(this)" disabled></td>
		</tr>
	<%}
		 %>
	
		
<!-- 	</table>
	<table cellpadding='0' cellspacing='0' width='100%' align='center' border='0'> -->
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=order_by_pull_list onChange='chng_appt_date(this)' disabled >
		<option value='T'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>
		<option value='A'><fmt:message key="Common.BookingTime.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='fields' id='ordID' width='25%'>
				<select name='p_order_term' id='p_order_term' >
					<option value='asc' selected><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
					<option value='desc'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
				</select>
		</td>
		<td class='fields' width='25%'>&nbsp;</td>
		</tr>
		<tr>
		<td  class='label' width='25%'><fmt:message key="eFM.PrintPatientFileRequestSlip.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type='checkbox'   name='print_req_slip' id='print_req_slip' checked  value='Y'></td>
		<td class='fields' width='25%'>&nbsp;</td>
		<td class='fields' width='25%'>&nbsp;</td>
		</tr>
		</table>
		<table cellpadding='0' cellspacing='0' width='90%' align='center' border='0'>
		<tr><td colspan='2'>&nbsp;<td></tr>
		<tr>
		
		<td  class='button' align="right"><input type='button' class='button' name='generate' id='generate' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Generate.label","common_labels")%>' onClick='generateFunc();'></td>
		</tr>
	</table>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='<%=fs_locn_code%>'>
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
	<input type='hidden' name='sysdate' id='sysdate' value='<%=sysdate%>'>
	<input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=appl_user1%>'>
	<input type="hidden" name="print_req_slip1" id="print_req_slip1" value=''>
	</form>
		
</body>
</html>
	
<%
	if(rs != null)		rs.close();		
	if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>

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

