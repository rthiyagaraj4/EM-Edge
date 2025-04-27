<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../js/bookingType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
			Connection con						= null;
			Statement stmt						= null;
			PreparedStatement pstmt				= null;
			ResultSet rs						= null;
			Statement stmt_bl					= null;
			ResultSet rset_bl					= null;
			Statement stmt_bl_yn				= null;
			ResultSet rset_bl_yn				= null;

		try{
			
			con									= ConnectionManager.getConnection(request);
					
			//String facility_id					= (String)session.getValue("facility_id");			
			
			String booking_type_code			= "";
			String long_desc					= "";
			String short_desc					= "";
			String patient_class				= "";
			String eff_status					= "E";
			String readOnly						= "";
			String other_read_only				= "";
			String bkg_type_ind					= "";
			String fn_val						= "insert";
			String setup_bl_dtls_in_ip_yn		= "N";

			String bkg_type_ind_code[]			= {"","I","E","N"};
			String bkg_type_ind_val[]			= {"--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.IntraHospitalBooking.label","ip_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExternalHospitalBooking.label","ip_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels")};

			stmt_bl								= con.createStatement();
			stmt_bl_yn							= con.createStatement();

			try{
			booking_type_code					= checkForNull(request.getParameter("booking_type_code"));

			if(booking_type_code != null && !booking_type_code.equals("") )
			{
				readOnly						= "readOnly";
				fn_val							= "modify";
				
				StringBuffer sql				= new StringBuffer();
				sql.append("select * from ip_booking_type where booking_type_code=?");
				
				pstmt 							= 	con.prepareStatement(sql.toString());
				pstmt.setString(1, booking_type_code);
				rs 								= 	pstmt.executeQuery();
				
				
/* 				stmt							=	con.createStatement();
				rs								=	stmt.executeQuery(sql.toString()); */
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc				= checkForNull(rs.getString("long_desc"));
							if(long_desc == null) long_desc ="";
						short_desc				= checkForNull(rs.getString("short_desc"));
							if(short_desc == null) short_desc ="";
						
						eff_status				= checkForNull(rs.getString("eff_status"));

						bkg_type_ind			= checkForNull(rs.getString("booking_type_ind"));

						if(eff_status.equals("D"))
							other_read_only		= "readonly";
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			else
			{
				booking_type_code				= "";
			}
		}catch(Exception e){
			//out.print("Exception in addModifyBookingType :"+e);
			e.printStackTrace();}
		%>
	</head>

<body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name='Booking_Type_Form' id='Booking_Type_Form' method='post' action='../../servlet/eIP.BookingTypeServlet' target='messageFrame'>
		<br><br><br>
		<br><br><br>
			<table cellspacing=0 cellpadding=0 align='center' width='100%'  border='0'>
				<tr>
					<td height='100%' width='70%' align='middle' class='white'>
						<table cellspacing=0 cellpadding=0 align='center' width='75%' border='0'>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='booking_type_code' id='booking_type_code' size='3' maxlength='3' value='<%=booking_type_code%>' onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecCharsCode(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=50 maxlength=50 value="<%=long_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=30 maxlength=30 value="<%=short_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<%
											if(eff_status.equals("D") && fn_val.equals("modify"))
											{
												String bkg_type_ind_desc="";
												for(int i=0;i<bkg_type_ind_val.length;i++)
												{
													if(bkg_type_ind_code[i].equals(bkg_type_ind))
													{
														bkg_type_ind_desc=bkg_type_ind_val[i];
														break;
													}
												}											out.print("<input type='text' name='bkgn_type_ind1' id='bkgn_type_ind1' value=\""+bkg_type_ind_desc+"\" readonly>");
												out.print("<input type='hidden' name='bkgn_type_ind' id='bkgn_type_ind' value='"+bkg_type_ind+"'>");
											}
											else 
											{
												out.print("<select name='bkgn_type_ind' id='bkgn_type_ind' >");
												String sel="";
												for(int i=0;i<bkg_type_ind_val.length;i++)
												{
													if(bkg_type_ind_code[i].equals(bkg_type_ind))
														sel="selected";
													out.print("<option value='"+bkg_type_ind_code[i]+"' "+sel+">"+bkg_type_ind_val[i]+"</option>");
													sel="";
												}
											out.print("</select>");
											}
								%><img src='../../eCommon/images/mandatory.gif'align='center'></img</td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
								<%String chk_val="checked";
									if(eff_status.equals("D") || eff_status=="" || eff_status.equals(""))
										chk_val="";
								%>
								<td>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' onClick='check(this);' <%=chk_val%>></td>
							</tr>
							<tr><td colspan='2'>&nbsp</td></tr>
						</table>
					</td>
				</tr>
			</table>
	
			<input type='hidden' name='function_name' id='function_name' value='<%=fn_val%>'>
			<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
			<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value='<%=setup_bl_dtls_in_ip_yn%>'>

		</form>
	</body>
<%
		if (rs != null) rs.close();
		if (rset_bl != null) rset_bl.close();
		if (rset_bl_yn != null) rset_bl_yn.close();

		if (stmt != null) stmt.close();
		if (stmt_bl != null) stmt_bl.close();
		if (stmt_bl_yn != null) stmt_bl_yn.close();	

}catch(Exception e) {
	//out.println("Error"+e);
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}	
%>	
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

