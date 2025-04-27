<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String val = request.getParameter("remarks");
	val = java.net.URLDecoder.decode(val);
	String facilityid = request.getParameter("facilityid");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
%>
<html>
	<head>
	<style>
		textarea {
		  resize: none;
		}
	</style>
		<%if(val.equals("BookingReferenceLookupResult")){%>
		<title><fmt:message key="eIP.BookingRemarks.label" bundle="${ip_labels}"/></title>
		<%}else if(val.equals("CurrentEncounter")){%>
		<title><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
		<%}else{%>
		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
		<%}%>
	    <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
		<script>
			var val = unescape(window.dialogArguments);			
			function closeWin()
			{
				/*
				window.returnValue = document.forms[0].ta.value;
				window.close();				
				*/
				
				let dialogBody = parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = document.forms[0].ta.value;
    
				const dialogTag = parent.document.getElementById("dialog_tag");    
				dialogTag.close();
			}
		</script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
if(val.equals("ReleaseBedDetail"))
{
			
			String bookrefno = request.getParameter("bookrefno");
			String booking_type = request.getParameter("booking_type");
	    	
			try
			{
				con = ConnectionManager.getConnection(request);
				stmt = con.createStatement();

				String sql="select blocking_remarks from ip_bed_booking_vw  where FACILITY_ID='"+facilityid+"' and BED_BOOKING_REF_NO ='"+bookrefno+"' and BOOKING_TYPE ='"+booking_type+"'";
				rs= stmt.executeQuery(sql);	
				val = "";

				if(rs != null)
				{
					while(rs.next())
					{
						val = rs.getString("blocking_remarks") == null ? "" : rs.getString("blocking_remarks");
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				}
			
			
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}

%>
	
		<table  width='100%' cellspacing=0 cellpadding=0>
			<tr>
				<td align='center'class='label'>
					<form name='f' id='f'>
						<textarea rows='6' cols='40' name='ta' readonly><%=val%></textarea><br>
						<input type='button' name='close' id='close' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeWin()'>
					</form>
				</td>
			</tr>
		</table>
<%}else if(val.equals("BookingReferenceLookupResult"))
{
		String	bookingRefNo = request.getParameter("bookingRefNo");
		String bookingRemarks="";
		String sqlString = "select  diagnosis_remarks from ip_booking_list where bkg_lst_ref_no='"+bookingRefNo+"' and facility_id='"+facilityid+"'";
		try
		{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs= stmt.executeQuery(sqlString);	
		if(rs != null)
		{
			while(rs.next())
			{
						bookingRemarks = rs.getString("diagnosis_remarks") == null ? "" : rs.getString("diagnosis_remarks");
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			}
			
			
				
		}catch (Exception es)
		{
			
			es.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			if(con != null)ConnectionManager.returnConnection(con,request);
		}

%>
		<form name='f' id='f'>
		<table  width='100%' cellspacing=0 cellpadding=0 >
			<tr>
				<td align='center'class='label'><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b>
					<textarea rows='6' cols='40' name='ta' readonly><%=bookingRemarks%></textarea><br>
				</td>
			</tr>
			<tr>
				<td align='right'>
					<input type='button' name='close' id='close' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeWin()' align = 'right'>
				</td>
			</tr>
		</table>
		</form>
<%}else if(val.equals("CurrentEncounter"))
{
		String	encounter_id = checkForNull(request.getParameter("encounter_id"));
		String adminRemarks="";
		String sqlString = "select  admission_remarks from pr_encounter where encounter_id='"+encounter_id+"' and facility_id='"+facilityid+"'";
		try
		{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		rs= stmt.executeQuery(sqlString);	
		if(rs != null)
		{
			while(rs.next())
			{
						adminRemarks = rs.getString("admission_remarks") == null ? "" : rs.getString("admission_remarks");
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			}
			
			
				
		}catch (Exception es)
		{
			es.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			if(con != null)ConnectionManager.returnConnection(con,request);
		}
%><form name='f' id='f'>
		<table  width='100%' cellspacing=0 cellpadding=0 >
			<tr>
				<td align='center'class='label'><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></b>
					<textarea rows='6' cols='40' name='ta' readonly><%=adminRemarks%></textarea><br>
				</td>
			</tr>
			<tr>
				<td align='right'>
					<input type='button' name='close' id='close' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeWin()' align = 'right'>
				</td>
			</tr>
		</table>
		</form>
<%}%>
	</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

