<!DOCTYPE html>
<!-- Last Mpdified Date/Time : 11/17/2005 10:19 AM -->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../js/repPatListDistrict_SRR.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	java.sql.Statement stmt = null;
	ResultSet rset=null;
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPLARE" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	String locale				  = (String)session.getValue("LOCALE");
%>

<%
	String Ar_installed = "";
	String BL_installed = (String)session.getValue("mp_bl_oper_yn");
	try 
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'AR' ");
		rs = pstmt.executeQuery();
	
		if(rs.next())
			Ar_installed = rs.getString("INSTALL_YN");		
			
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	} catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
%>
<script>
function setDate(Object){ 

       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
	<form name="repPatListDistrict" id="repPatListDistrict" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->
		<table cellspacing='0' cellpadding='3' width='70%'>
			<tr>
				<td width='30%'>&nbsp;</td>
				<td width='30%'>&nbsp;</td>
				<td width='5%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='P_facilityid' id='P_facilityid'>
				<%try
				{
					stmt=con.createStatement();
					String fid;
					String fname;
					String sql1="SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2";
					rset=stmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}
					if (rset!=null) rset.close(); 
					if (stmt!=null) stmt.close();
				}catch(Exception e){/* out.println(e); */ e.printStackTrace();}
				finally 
				{
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td><td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
				<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id="regn_date_from" name="p_from_regn_date" id="p_from_regn_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('regn_date_from');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id="regn_date_to" name="p_to_regn_date" id="p_to_regn_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('regn_date_to');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td class='label' ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_series_from" id="p_series_from" size="2" maxlength="2"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
				p_series_from,'N')">
				</td>
				<td class='label'></td>
				<td class='fields'><input type="text" name="p_series_to" id="p_series_to" size="2" maxlength="2"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
					p_series_to,'N')">
				</td>
			</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_category_code" id="p_from_category_code" size="2" maxlength="4"><input type='button' name='patcat' id='patcat' value='?' class='button' onclick="searchCode(this, 
			p_from_category_code,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_category_code" id="p_to_category_code" size="2" maxlength="4"><input type='button' name='patcat' id='patcat' value='?' class='button' onclick="searchCode(this, 
				p_to_category_code,'N')">
			</td>
		</tr>
		<tr>
				<td class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>

				<td class='fields'><input type="text" name="p_from_birth_date" id="p_from_birth_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_birth_date');">
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="p_to_birth_date" id="p_to_birth_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_birth_date');">
				</td>
			</tr>
			<tr>
				<!-- <td class="label"><fmt:message key="Common.State.label" bundle="${common_labels}"/> </td> -->
				<td class="label"><fmt:message key="eMP.Province.label" bundle="${mp_labels}"/> </td>
				<td class='fields'><input type="text" name="p_from_res_area_code" id="p_from_res_area_code" size="6" maxlength="6"><input type='button' name='district' id='district' value='?' class='button' onclick="searchCode(this, p_from_res_area_code,'N')"></td>

				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="p_to_res_area_code" id="p_to_res_area_code" size="6" maxlength="6"><input type='button' name='district' id='district' value='?' class='button' onclick="searchCode(this, p_to_res_area_code,'N')"></td>
			</tr>
<%
if (BL_installed.equals("Y"))
{
%>	
		<tr>
			<td class='label' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type="text" name="p_from_blng_grp_id" id="p_from_blng_grp_id" size="2" maxlength="4"><input type='button' name='blnggrp' id='blnggrp' value='?' class='button' onclick="searchCode(this, 
			p_from_blng_grp_id,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_blng_grp_id" id="p_to_blng_grp_id" size="2" maxlength="4"><input type='button' name='blnggrp' id='blnggrp' value='?' class='button' onclick="searchCode(this, 
				p_to_blng_grp_id,'N')">
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_cust_code" id="p_from_cust_code" size="8" maxlength="8"><input type='button' name='custcode' id='custcode' value='?' class='button' onclick="searchCode(this, 
			p_from_cust_code,'<%=Ar_installed%>')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_cust_code" id="p_to_cust_code" size="8" maxlength="8"><input type='button' name='custcode' id='custcode' value='?' class='button' onclick="searchCode(this, 
				p_to_cust_code,'<%=Ar_installed%>')">
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_stlmt_type" id="p_from_stlmt_type" size="2" maxlength="2"><input type='button' name='stlmttype' id='stlmttype' value='?' class='button' onclick="searchCode(this, 
			p_from_stlmt_type,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_stlmt_type" id="p_to_stlmt_type" size="2" maxlength="2"><input type='button' name='stlmttype' id='stlmttype' value='?' class='button' onclick="searchCode(this,	p_to_stlmt_type,'N')">
			</td>
		</tr>
		<%
		}		
		%>
		<tr>
		<td class="label" ><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_address' id='p_address'>
					<option value="RES"> <fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></option>
					<option value="MAI"> <fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/> </option>
					</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
		<td class="label" ><fmt:message key="Common.citizen.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_race' id='p_race'>
					<option value=""> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="Y"> <fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value="N"> <fmt:message key="Common.no.label" bundle="${common_labels}"/> </option>
					</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>


		  <!-- Commented on 11/17/2005 -->
		<!-- <tr>
			<td class="label" > Report Type </td>
			<td > 
					&nbsp;<select name='P_Report_Type' id='P_Report_Type' onchange="change_report(this)">
					<option value='S' selected>Standard</option>
					<option value='C' >Reduced</option>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr> -->
		<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
		</tr>
		</table>
		<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
		<input type="hidden" name="locale" id="locale"		value="<%=locale%>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>

</center>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

