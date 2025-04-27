<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
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
		
		
		<script language='javascript' src='../js/AdmissionType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>

		</script>

		<%
			Connection con = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			Statement stmt_bl =null;
			ResultSet rset_bl =null;
			Statement stmt_bl_yn =null;
			ResultSet rset_bl_yn =null;

		try{
			
			con =ConnectionManager.getConnection(request);
					
			String facility_id = (String)session.getValue("facility_id");			
			String dat							= "";
			String ID							= "";
			String selected_bl					= "";
			String blng_workup					= "Disabled";
			String blng_consumable				= "Disabled";
			String blng_rounding				= "Disabled";
			String rounding_fee_yn				= "";
			String consumable_fee_yn			= "";
			String adm_wkup_fee_yn				= "";
			String rdng_blng_serv_code			= "";
			String cons_blng_serv_code			= "";
			String wkup_blng_serv_code			= "";
			String admission_type_code			= "";
			String long_desc					= "";
			String short_desc					= "";
			String patient_class				= "";
			String eff_status					= "E";
			String readOnly						= "";
			String other_read_only				= "";
			String adm_type_ind					= "";
			String fn_val						= "insert";
			String wakeup_check					= "";
			String consumable_check				= "";
			String round_check					= "";
			String setup_bl_dtls_in_ip_yn		= "N";

			String adm_type_ind_code[] = {"","A","U","M","N","O","D"};
			String adm_type_ind_val[] = {"--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Accident.label","ip_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LabourAndDelivery.label","ip_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Observation.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")};

			stmt_bl=con.createStatement();
			stmt_bl_yn=con.createStatement();

			try
			{
				StringBuffer sql_bl = new StringBuffer();
				sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id=? ");
				
				pstmt = con.prepareStatement(sql_bl.toString());
				pstmt.setString(1, facility_id);
				rset_bl_yn = pstmt.executeQuery();
				//rset_bl_yn = stmt_bl_yn.executeQuery(sql_bl.toString());
				if(rset_bl_yn!=null )
				{
					while(rset_bl_yn.next())
					 {
						setup_bl_dtls_in_ip_yn=rset_bl_yn.getString("setup_bl_dtls_in_ip_yn");							
					 }
				if (rset_bl_yn != null) rset_bl_yn.close();
				if(pstmt != null) pstmt.close();
				}
			}catch(Exception e){
			//out.print("Exception here1 :"+e);
			e.printStackTrace();
			}

			try{
			admission_type_code=request.getParameter("admission_type_code");
			if(admission_type_code!=null)
			{
				readOnly="readOnly";
				fn_val="modify";
				
				StringBuffer sql = new StringBuffer();
				sql.append("select * from ip_admission_type where admission_type_code=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, admission_type_code);
				rs = pstmt.executeQuery();
				//stmt =	con.createStatement();
				//rs	 =	stmt.executeQuery(sql.toString());
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc=rs.getString("long_desc");
							if(long_desc == null) long_desc ="";
						short_desc=rs.getString("short_desc");
							if(short_desc == null) short_desc ="";
						patient_class=rs.getString("patient_class");
							if(patient_class == null) patient_class ="";
						eff_status=rs.getString("eff_status");

						adm_type_ind=rs.getString("adm_type_ind");

						if(setup_bl_dtls_in_ip_yn.equals("Y"))
						{
							rounding_fee_yn         =rs.getString("rounding_fee_yn");
								if(rounding_fee_yn==null || rounding_fee_yn.equals("null"))
							rounding_fee_yn="N";
	
							if(rounding_fee_yn.equals("Y"))
							{
								round_check="checked";
								blng_rounding="";
								rdng_blng_serv_code     =rs.getString("rdng_blng_serv_code");
							}

							consumable_fee_yn       =rs.getString("consumable_fee_yn");
							if(consumable_fee_yn==null || consumable_fee_yn.equals("null"))
							consumable_fee_yn="N";
							if(consumable_fee_yn.equals("Y"))
							{
								consumable_check="checked";
								blng_consumable="";
								cons_blng_serv_code     =rs.getString("cons_blng_serv_code");
							}

							adm_wkup_fee_yn         =rs.getString("adm_wkup_fee_yn");
								if(adm_wkup_fee_yn==null || adm_wkup_fee_yn.equals("null"))
							adm_wkup_fee_yn="N";
							
							if(adm_wkup_fee_yn.equals("Y"))
							{
								wakeup_check="checked";
								blng_workup="";
								wkup_blng_serv_code     =rs.getString("wkup_blng_serv_code");
							}
						}//e.o.BL check

						if(eff_status.equals("D"))
							other_read_only="readonly";
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(pstmt != null) pstmt.close();
				}
			}
			else
			{
				admission_type_code="";
			}
		}catch(Exception e){
			//out.print("Exception in modify :"+e);
			e.printStackTrace();	
		}
		%>
	</head>

<body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name='Admission_Type_Form' id='Admission_Type_Form' method='post' action='../../servlet/eIP.AdmissionTypeServlet' target='messageFrame'>
		<br><br><br>
<% if(setup_bl_dtls_in_ip_yn.equals("N")) {%>
			<br><br><br>
<%}%>
			<br><br><br>

			<table cellspacing=0 cellpadding=0 align='center' width='100%'  border='0'>
				<tr>
					<td height='100%' width='70%' align='middle' class='white'>
						<table cellspacing=0 cellpadding=0 align='center' width='75%' border='0'>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='admission_type_code' id='admission_type_code' size='2' maxlength='2' value='<%=admission_type_code%>' onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=long_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=short_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<%
											if(eff_status.equals("D") && fn_val.equals("modify"))
											{
												String adm_type_ind_desc="";
												for(int i=0;i<adm_type_ind_val.length;i++)
												{
													if(adm_type_ind_code[i].equals(adm_type_ind))
													{
														adm_type_ind_desc=adm_type_ind_val[i];
														break;
													}
												}											out.print("<input type='text' name='admn_type_ind1' id='admn_type_ind1' value=\""+adm_type_ind_desc+"\" readonly>");
												out.print("<input type='hidden' name='admn_type_ind' id='admn_type_ind' value='"+adm_type_ind+"'>");
											}
											else 
											{
												out.print("<select name='admn_type_ind' id='admn_type_ind' onChange='CheckIndicator(this)'>");
												String sel="";
												for(int i=0;i<adm_type_ind_val.length;i++)
												{
													if(adm_type_ind_code[i].equals(adm_type_ind))
														sel="selected";
													out.print("<option value='"+adm_type_ind_code[i]+"' "+sel+">"+adm_type_ind_val[i]+"</option>");
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
			<br>
<%
	if(setup_bl_dtls_in_ip_yn.equals("Y"))
	{
%>			<table cellspacing=0 cellpadding=0 align='center' width='75%'  border='0' id ='bl_field'  style=visibility:hidden;>
			<th align='left' colspan='4' ><fmt:message key="eIP.BillingParameter.label" bundle="${ip_labels}"/></th>
			<tr>
			<td colspan='4'>&nbsp</td>
			</tr>
			<tr>
			<td class='label' align='right' ><fmt:message key="eIP.RoundingFee.label" bundle="${ip_labels}"/></td>
			<td class='label' align='left'>&nbsp;&nbsp;<input type='checkbox' name='rounding_fee' id='rounding_fee' value='Y' <%=round_check%> onclick="fun_round(this)" ></td>
			<td  align='right' class='label'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  align='left' class='label' >&nbsp;&nbsp;<select name="billingservcode_rounding" id="billingservcode_rounding" <%=blng_rounding%>><option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
		<%

				rset_bl=stmt_bl.executeQuery("select blng_serv_code, short_desc from bl_blng_serv  where status is null order by short_desc");
				if(rset_bl!=null)
				{
					 while(rset_bl.next())
					 {
						dat=rset_bl.getString("short_desc");
						ID=rset_bl.getString("blng_serv_code");
						if(ID.equals(rdng_blng_serv_code))
    					selected_bl = "selected";
	        			else
			    		selected_bl = "";
						out.println("<option value='"+ID+"'" +selected_bl+">"+dat+"</option>");
					}
					out.println("</select>");
				}
		
		%>
			</td>
			</tr>
			<tr>
			<td colspan='4'>&nbsp</td></tr>
			<tr>
			<td class='label' align='right' ><fmt:message key="eIP.ConsumableFee.label" bundle="${ip_labels}"/></td>
			<td class='label' align='left'>&nbsp;&nbsp;<input type='checkbox' name='consumable_fee' id='consumable_fee' value='Y' <%=consumable_check%> onclick="fun_consumable(this)"></td>
			<td  align='right' class='label'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  align='left' class='label' >&nbsp;&nbsp;<select name="billingservcode_consumable" id="billingservcode_consumable" <%=blng_consumable%> ><option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
		<%

				rset_bl=stmt_bl.executeQuery("select blng_serv_code, short_desc from bl_blng_serv  where status is null order by short_desc");
				if(rset_bl!=null)
				{
					 while(rset_bl.next())
					 {
						dat=rset_bl.getString("short_desc");
						ID=rset_bl.getString("blng_serv_code");
						if(ID.equals(cons_blng_serv_code))
    					selected_bl = "selected";
	        			else
			    		selected_bl = "";
						out.println("<option value='"+ID+"'" +selected_bl+">"+dat+"</option>");
					}
					out.println("</select>");
				}
		%>
			</td>
			</tr>
			<tr>
			<td colspan='4'>&nbsp</td></tr>
			<tr>
			<td class='label' align='right' ><fmt:message key="eIP.AdmissionWorkupChargeFee.label" bundle="${ip_labels}"/></td>
			<td class='label' align='left'>&nbsp;&nbsp;<input type='checkbox' name='work_up' id='work_up' value='Y' <%=wakeup_check%> onclick="fun_workup(this)"></td>
			<td  align='right' class='label'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td  align='left' class='label' >&nbsp;&nbsp;<select name="billingservcode_workup" id="billingservcode_workup" <%=blng_workup%> ><option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
		<%
				rset_bl=stmt_bl.executeQuery("select blng_serv_code, short_desc from bl_blng_serv  where status is null order by short_desc");
				if(rset_bl!=null)
				{
					 while(rset_bl.next())
					 {
						dat=rset_bl.getString("short_desc");
						ID=rset_bl.getString("blng_serv_code");
						if(ID.equals(wkup_blng_serv_code))
    					selected_bl = "selected";
	        			else
			    		selected_bl = "";
						out.println("<option value='"+ID+"'" +selected_bl+">"+dat+"</option>");
					}
					out.println("</select>");
				}
		%>
			</td>
			</tr>
			<tr>
			<td colspan='4'>&nbsp</td></tr>
			 <script>
		<%
				 			if(setup_bl_dtls_in_ip_yn.equals("Y"))
				 			{
				 					out.println("document.getElementById('bl_field').style.visibility='visible';	");
							}
		%>
				</script>
			</table>
<%	}//e.of.chk for BL
%>		
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
	//out.println("Erro"+e);
	e.printStackTrace();	
}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}	
%>	
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

