<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script language='javascript' src='../js/TransferType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		


		<%
			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
			Connection con				= null;
			Statement stmt				= null;
			Statement stmt_bl_interface	= null;
			Statement stmt_bl_charge	= null;
			ResultSet rs				= null;
			ResultSet rs_bl_charge		= null;
			String facility_id = (String)session.getValue("facility_id");
			
			StringBuffer sql_charge = new StringBuffer();
			String transfer_type_code	="";
			String long_desc			="";
			String short_desc			="";
			String charge				="";
			String eff_status			="";
			String readOnly				="";
			String other_read_only		="";
			String fn_val				="insert";
			String chk_charge			="";
			String chk_val				="";
			String setup_bl_dtls_in_ip_yn="N";
			String blocking_type="";
			String other_disabled	="";
			
			/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
			String informd_dtls_yn = "";
			String chk_informd_dtls_yn = "";
			boolean isCnrmReqPatOutChngAppl = false;
			/*End*/
try{
		con = ConnectionManager.getConnection(request);
		stmt_bl_interface	=	con.createStatement();
		stmt_bl_charge		=	con.createStatement();
		
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

			try
			{
				StringBuffer sql_bl = new StringBuffer();
				sql_bl.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id='"+facility_id+"' ");
				rs = stmt_bl_interface.executeQuery(sql_bl.toString());
				if(rs!=null )
				{
					while(rs.next())
					 {
							setup_bl_dtls_in_ip_yn=rs.getString("setup_bl_dtls_in_ip_yn");
					 }
				}
				
		if(stmt_bl_interface!=null) stmt_bl_interface.close();
		if(rs !=null) rs.close();

			}catch(Exception e){
				//out.println(e.toString());
				e.printStackTrace();
				}


			transfer_type_code=request.getParameter("transfer_type_code");
			if(transfer_type_code!=null)
			{
				readOnly	="readonly";
				fn_val		="modify";
				StringBuffer sql = new StringBuffer();
				sql.append("select * from ip_transfer_type where transfer_type_code='"+transfer_type_code+"'");
				stmt	=	con.createStatement();
				rs		=	stmt.executeQuery(sql.toString());
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc=rs.getString("long_desc");
						short_desc=rs.getString("short_desc");
						
						informd_dtls_yn=checkForNull(rs.getString("informed_dtls_mand_yn"),"N");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
			
						blocking_type=rs.getString("blocking_type_code");
						if(blocking_type==null)blocking_type="";
						
						if(setup_bl_dtls_in_ip_yn.equals("Y"))
						{
							try{
								
								sql_charge.append("select * from bl_ip_transfer_type where transfer_type_code='"+transfer_type_code+"' ");
								rs_bl_charge = stmt_bl_charge.executeQuery(sql_charge.toString());
								if(rs_bl_charge!=null)
								 {
									while(rs_bl_charge.next())
									{
										charge=rs_bl_charge.getString("charge_yn");
									}
								}
							if(stmt_bl_interface!=null) stmt_bl_interface.close();
							if(rs_bl_charge !=null) rs_bl_charge.close();

						 }catch(Exception e) {
							 //out.println(e);
							 e.printStackTrace();
							 }
						}	 
						eff_status=rs.getString("eff_status");

						if(eff_status.equals("D"))
						{
							other_read_only="readonly";
							other_disabled="disabled";
						}
					}
				}
			}
			else
			{
				transfer_type_code="";
			}
	%>

		<script>
//moved to TransferType.js
		</script>
	</head>

<body onLoad='focusTxt()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='Transfer_Type_Form' id='Transfer_Type_Form' method='post' action='../../servlet/eIP.TransferTypeServlet' target='messageFrame'>

<%if(setup_bl_dtls_in_ip_yn.equals("N")){%>
		<br><br><br>
<%}%>
		<br><br><br><br><br>

			<table cellspacing=0 cellpadding=0 align='center' width='100%'   border='0' >
				<tr>
					<td height='100%' width='100%' align='middle' class='white' width='100%'>
						<table cellspacing=0 cellpadding=0 align='center' width='70%' border='0'>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='transfer_type_code' id='transfer_type_code' size='2' maxlength='2' value='<%=transfer_type_code%>' onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=long_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=short_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>
							<tr>
								<td class='label' align='right'><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></td>
							<td>&nbsp;&nbsp;<select name="blocking_type" id="blocking_type" <%=other_disabled%> >
				<option value="" >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				<%
					stmt = con.createStatement();
					rs = stmt.executeQuery("select blocking_type_code,short_desc from ip_blocking_type where eff_status = 'E' order by short_desc");
					if(rs != null)
					{
						while(rs.next())
						{
							String desc = rs.getString("short_desc")== null ? "" : rs.getString("short_desc");
							String code = rs.getString("blocking_type_code")==null ? "":rs.getString("blocking_type_code");
							String sel = "";
								if (code.equals(blocking_type))
									sel = "selected";
								else
									sel = "";
								
								out.print("<option value='"+code+"'"+sel+">"+desc );

						}
					}
				%>
			</select>
			</td>
				</tr>
						<tr><td colspan='2'>&nbsp</td></tr>	
							
							<!--Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start-->
							<% if(isCnrmReqPatOutChngAppl){ %>
							<tr>
								<td class='label' align='right'><fmt:message key="eIP.InformedDtlsMand.label" bundle="${ip_labels}"/></td>
								<%
									if(informd_dtls_yn.equals("Y"))
										chk_informd_dtls_yn="checked";
									else if(informd_dtls_yn.equals("N"))
										chk_informd_dtls_yn="";
								%>
								<td>&nbsp;<input type='checkbox' name='informd_dtls_yn' id='informd_dtls_yn' value='Y' <%=chk_informd_dtls_yn%> <%=other_disabled%> ></td>
							</tr>
							<tr><td colspan='2'>&nbsp</td></tr>	
							<% } %>
							<!--End-->
							
							<tr>
								<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
								<%
									chk_val="checked";
									if(eff_status.equals("D"))
										chk_val="";
								%>
								<td>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' onclick = "change()"; value='E' <%=chk_val%>></td>
							</tr>
							<!--<tr><td colspan='2'>&nbsp</td></tr>
							<tr><td colspan='2' class='bodycolorfilled' >&nbsp</td></tr>-->

							<th colspan='2' align='left'  id ='bl_field'  style=visibility:hidden; ><fmt:message key="eIP.BillingParameter.label" bundle="${ip_labels}"/></th>
							<tr><td colspan='2'  id ='bl_field1'  style=visibility:hidden; >&nbsp</td></tr>

							<tr  id ='bl_field2'  style='visibility:hidden' >
										<td class='label' align='right'><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></td>
										<%

												if(charge.equals("Y"))
													chk_charge="checked";
										%>
										<td>&nbsp;<input type='checkbox' name='charge' id='charge' value='Y'  <%=chk_charge%> ></td>
							</tr>

							<tr  id ='bl_field3'  style='visibility:hidden'><td colspan='2'>&nbsp</td></tr>
									 <script>
											 <%												
												if(setup_bl_dtls_in_ip_yn.equals("Y"))
												{
													out.println("document.getElementById('bl_field').style.visibility='visible';	");
													out.println("document.getElementById('bl_field1').style.visibility='visible';	");
													out.println("document.getElementById('bl_field2').style.visibility='visible';	");
													out.println("document.getElementById('bl_field3').style.visibility='visible';	");
												}
										%>
							</script>
						</table>
					</td>
				</tr>
			</table>
			<input type='hidden' name='function_name' id='function_name' value='<%=fn_val%>'>
			<input type='hidden' name='hid_block_type' id='hid_block_type' value='<%=blocking_type%>'>
			<input type='hidden' name='hid_block_type_old' id='hid_block_type_old' value='<%=blocking_type%>'>

			<input type="hidden" name="setup_bl_dtls_in_ip_yn" id="setup_bl_dtls_in_ip_yn" value="<%=setup_bl_dtls_in_ip_yn%>">
		</form>
	</body>
</html>
<%
		if (rs != null) rs.close();
		if (rs_bl_charge != null)		rs_bl_charge.close();
		if (stmt != null)				stmt.close();
		if (stmt_bl_interface != null)	stmt_bl_interface.close();
		if (stmt_bl_charge != null)		stmt_bl_charge.close();
	}
	catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

		%>
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

