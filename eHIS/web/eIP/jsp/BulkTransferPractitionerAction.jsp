<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eIP/js/BulkTransferPractitioner.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
String locale					= (String)session.getAttribute("LOCALE");
String facility_id				= checkForNull((String)session.getValue("facility_id"));
String encounter_id				= "";
String frpractdesc				= "";
//String frpractitionerid			= "";
String splcode					= "";
String frnursingunitcode		= "";
//String frnursingunitdesc		= "";
Connection con					= null;
StringBuffer sqlSb				= new StringBuffer();
String Enc_Service				= "";
String frspecialitydesc			= "";
String frspecialitycode					= "";
String Bed_Speciality			= "";
String frbedno					= "";

try	
{
	con				= ConnectionManager.getConnection(request);	
	Statement stmt	= null;
	ResultSet rs	= null;
	if(rs != null)
	{
		 frpractdesc			    = checkForNull(rs.getString("practitioner_name"));
   		 splcode					= checkForNull(rs.getString("specialty_short_desc"));
		 frnursingunitcode			= checkForNull(rs.getString("nursing_unit_code"));
		 encounter_id				= checkForNull(rs.getString("ENCOUNTER_ID"));
		 frspecialitydesc			= checkForNull(rs.getString("specialty_short_desc"));
		 frspecialitycode			= checkForNull(rs.getString("specialty_code"));
		 frbedno					= checkForNull(rs.getString("bed_no"));

	}
			/*if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();*/

			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());

/* commented the below query as it is not used - 11/05/2010

			sqlSb.append("Select service_code from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+encounter_id+"' ");
			
			stmt	= con.createStatement();
			rs		= stmt.executeQuery(sqlSb.toString());
			if(rs!=null)
			{
				if(rs.next())
				{
					Enc_Service = checkForNull(rs.getString("service_code"));
				}	
				
			}
			if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();
*/

			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());

			sqlSb.append(" Select specialty_code from ip_nursing_unit_bed ");
			sqlSb.append(" where facility_id = '"+facility_id+"' and nursing_unit_code = '"+frnursingunitcode+"' and bed_no = '"+frbedno+"' ");

			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSb.toString());
			if(rs!=null)
			{
				if(rs.next())
				{
					Bed_Speciality = checkForNull(rs.getString("specialty_code"));
				}	
			}
			if (rs != null)   rs.close();
			if (stmt != null)   stmt.close();

%>	
	<body onKeyDown='lockKey()'>
	<form name='BulkTransfer_ToPractitioner_Form' id='BulkTransfer_ToPractitioner_Form' action='BookingReferenceLookupResult.jsp' target='result' >
		<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
			<tr>
				<td class="columnheader"><fmt:message key="Common.TransferTo.label"bundle="${common_labels}"/></td>
			</tr>
		</table>
		
		<table cellspacing=0 cellpadding=0 align='center'  width='100%' border='0' cellpadding=0 cellspacing=0>
			<tr>
				<td class="label" width="15%"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/></td>
				<td width="25%" class="fields">
					<select name="transfer_type" id="transfer_type">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<%
							stmt = con.createStatement();
							rs = stmt.executeQuery(" select transfer_type_code,short_desc from ip_transfer_type_lang_vw where language_id= '"+locale+"' and eff_status = 'E' order by short_desc ");
							while(rs.next())
							{
								String desc = rs.getString("short_desc");
								String code = rs.getString("transfer_type_code");

								out.print("<option value=\""+code+"\" >"+desc );
							}
							
					%>
						</select><img  src="../../eCommon/images/mandatory.gif">
					</td>
					
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>

						<!--<td  class="label" width="15%"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
						<td class="fields" width="35%"><select name="service" id="service">
							<%
								if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
								String sel = "";
								String serv_code = "";
								String serv_desc = "";
								
								sqlSb.append(" select service_code ,am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc ");  
								sqlSb.append(" from IP_NURS_UNIT_FOR_SERVICE where facility_id ='"+facility_id+"'and nursing_unit_code = '"+frnursingunitcode+"' ");
								sqlSb.append(" union select service_code, am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc ");
								sqlSb.append(" from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+frnursingunitcode+"' order by 2 ");

								stmt = con.createStatement();
								rs = stmt.executeQuery(sqlSb.toString());

								if(rs!=null )
								{
									while(rs.next()){
									serv_code  = rs.getString("service_code");
									serv_desc = rs.getString("service_short_desc");

									if (serv_code.equals(Enc_Service))
									sel = "selected";
									else
									sel = "";
									out.println("<option value='"+serv_code+"' "+sel+">"+serv_desc+"");
								}
								if (rs != null)   rs.close();
								if (stmt != null)   stmt.close();
								}

							%>
							</select>
						</td>-->


					<!--<td class="label" width="15%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td nowrap width="35%"><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15">
						<input type='text' name='practid_desc' id='practid_desc' value="" size='15' maxlength='15'width='15'  onblur="BeforGetPractitioner(document.forms[0].practid,practid_desc, '<%=facility_id%>');"><!-- onFocus="checkForValues();" >--><!--<input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onclick="checkPractTxtVal(practid,practid_desc,'<%=facility_id%>');"><!--(document.forms[0].practid,pract_desc, '<%=facility_id%>');" > <!--onFocus="checkForValues();"--><!--<img  src="../../eCommon/images/mandatory.gif">
						<input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"> -->
					
				</tr>
				<tr>
						<!-- 
						<td class="label" width="20%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%"><%=frspecialitydesc%>
				<input type="hidden" name="fr_speciality_code" id="fr_speciality_code" value="<%=frspecialitycode%>">
			</td>
			<td class="label" width="15%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" nowrap width="35%"><input type=text name='Splcode_desc' id='Splcode_desc' <%if(!Bed_Speciality.equals("")){%> readOnly <%}%> maxlength='15' size='15' width="15%" value="<%=frspecialitydesc%>" onblur="BeforeGetSpecialty(Splcode_desc, '<%=facility_id%>');"><input type=hidden name='Splcode' id='Splcode' width="15" value="<%=frspecialitycode%>"><input type=button name='Splcode_lookup' id='Splcode_lookup' <%if(!Bed_Speciality.equals("")){%> disabled <%}%> value='?' class=button onClick="checkSpecTxtVal(Splcode_desc,'<%=facility_id%>');"><img src='../../eCommon/images/mandatory.gif'></img><input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=frspecialitycode%>"></td>
						-->
						<td class="label" width="15%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<td nowrap width="35%"><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15">
						<input type='text' name='practid_desc' id='practid_desc' value="" size='15' maxlength='15'width='15'  onblur="BeforGetPractitioner(document.forms[0].practid,practid_desc, '<%=facility_id%>');"><!-- onFocus="checkForValues();" >--><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onclick="checkPractTxtVal(practid,practid_desc,'<%=facility_id%>');"><!--(document.forms[0].practid,pract_desc, '<%=facility_id%>');" > <!--onFocus="checkForValues();"--><img  src="../../eCommon/images/mandatory.gif">
						<input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"> 
						</td>

						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
				</tr>
				<tr>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
				</tr>
					<!--<tr>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='label'>&nbsp;</td>
						<td class='fields' ><input type='button' class='button' name='transfer' id='transfer' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")%>' onclick='Transfer()'><input type="button" class="button" name= "close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();"></td>
					</tr>-->
				</table>
				<input type='hidden' name='locale' id='locale' value="<%=locale%>">
				<input type='hidden' name='splcode' id='splcode' value="<%=splcode%>">
				</form> 
	</body>
				<%
				

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
				
		
	}catch(Exception e)
	{
		out.println("Exception:"+e.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
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

