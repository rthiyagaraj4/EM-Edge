<!DOCTYPE html>
<!-- Last Mpdified Date/Time : 11/17/2005 10:20 AM -->
<%@ page import ="java.sql.*,webbeans.eCommon.*, eCommon.Common.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src="../../eMP/js/repPatListPatNo.js" language="javascript"></script>
<script src='../../eCommon/js/DateUtils.js'  language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	java.sql.Statement stmt = null;
	ResultSet rs=null;
	ResultSet rset=null;
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPTNUM" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
%>

<%
	int Patient_Id_Length=0	;
	String Ar_installed = "";
	String BL_installed = (String)session.getValue("mp_bl_oper_yn");

	try 
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("Select PATIENT_ID_LENGTH from mp_param");
		rs = pstmt.executeQuery();
	
		if(rs.next())
			Patient_Id_Length = rs.getInt("Patient_Id_Length");

		  if (rs != null)   rs.close();
		  if (pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'AR' ");
		rs = pstmt.executeQuery();
	
		if(rs.next())
			Ar_installed = rs.getString("INSTALL_YN");

	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	
	} catch(Exception e) { out.println(e.toString());}
%>
<BR>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
	<!-- <form name="repPatListPatNo" id="repPatListPatNo" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">-->
	<form name="repPatListPatNo" id="repPatListPatNo" action="../../eCommon/html/blank.html" target="messageFrame">
		<table cellpadding='3' cellspacing='0' width='70%' border='0'>
		<tr>
			<td width='30%'>&nbsp;</td>
			<td width='30%'>&nbsp;</td>
			<td width='5%'>&nbsp;</td>
			<td width='35%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='P_facilityid' id='P_facilityid'>
				<%
					try
					{

					//Added by Sangeetha for ML-MMOH-CRF-0732 
					Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");

					 stmt=con.createStatement();
					String fid;
					String fname;
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2";
							
					rset=stmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+"'>"+fname+"</option>");
					   }
  						if(stmt!=null) stmt.close();
						if(rset!=null) rset.close();

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
			<td >&nbsp;</td>
			<td class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
		<!-- <tr><td colspan ='4'>&nbsp;</td></tr> -->
			<tr>
				<td class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id="regn_date_from" name="p_from_regn_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)">
				<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="showCalendar('regn_date_from')"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label" > </td>
				<td class='fields'><input type="text" id="regn_date_to" name="p_to_regn_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)">
				<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="showCalendar('regn_date_to')"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
		<tr>
			<!--Modified maxLength by Sangeetha for ML-MMOH-CRF-0732 --> 
			<td class='label' ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_series_from" id="p_series_from" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %> onblur="if (this.value!='')searchCode(document.getElementById('patsergrpid'), 
			document.forms[0].p_series_from,'N')"><input type='button' id='patsergrpid' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
			p_series_from,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_series_to" id="p_series_to" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %> onblur="if (this.value!='')searchCode(document.getElementById('patsergrpid'), 
			document.forms[0].p_series_to,'N')"><input type='button'  name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this, 
				p_series_to,'N')">
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_category_code" id="p_from_category_code" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById('patcatid'), 
			p_from_category_code,'N')"><input type='button' id='patcatid' name='patcat' id='patcat' value='?' class='button' onclick="searchCode(this, 
			p_from_category_code,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_category_code" id="p_to_category_code" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById('patcatid'), 
			p_to_category_code,'N')"><input type='button' name='patcat' id='patcat' value='?' class='button' onclick="searchCode(this, 
				p_to_category_code,'N')">
			</td>
		</tr>
			<tr>
				<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_from_patient_id" id="p_from_patient_id" size="20" maxlength=<%=Patient_Id_Length%> onBlur="ChangeUpperCase(this);">
				</td>

				<td class="label" >&nbsp;</td>
				<td class='fields'><input type="text" name="p_to_patient_id" id="p_to_patient_id" size="20" maxlength=<%=Patient_Id_Length%>  onBlur="ChangeUpperCase(this);">
				</td> 
			</tr>
		<tr>
				<td class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> </td>
				<td class='fields'><input type="text" id="birth_date_from" name="p_from_birth_date" id="p_from_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('birth_date_from');">
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id="birth_date_to" name="p_to_birth_date" id="p_to_birth_date" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('birth_date_to');">
				</td>
			</tr>

<%
if (BL_installed.equals("Y"))
{
%>
		<tr>
			<td class='label' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type="text" name="p_from_blng_grp_id" id="p_from_blng_grp_id" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById('blnggrpid'), 
			p_from_blng_grp_id,'N')"><input type='button' name='blnggrp' id='blnggrp' id='blnggrpid' value='?' class='button' onclick="searchCode(this, 
			p_from_blng_grp_id,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_blng_grp_id" id="p_to_blng_grp_id" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById('blnggrpid'), 
			p_to_blng_grp_id,'N')"><input type='button' name='blnggrp' id='blnggrp' value='?' class='button' onclick="searchCode(this, 
				p_to_blng_grp_id,'N')">
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_cust_code" id="p_from_cust_code" size="8" maxlength="8" onblur="if (this.value!='')searchCode(document.getElementById('custcodeid'), 
			p_from_cust_code,'<%=Ar_installed%>')"><input type='button' name='custcode' id='custcode' id='custcodeid' value='?' class='button' onclick="searchCode(this, 
			p_from_cust_code,'<%=Ar_installed%>')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_cust_code" id="p_to_cust_code" size="8" maxlength="8" onblur="if (this.value!='')searchCode(document.getElementById('custcodeid'), 
			p_to_cust_code,'<%=Ar_installed%>')"><input type='button' name='custcode' id='custcode' value='?' class='button' onclick="searchCode(this, 
				p_to_cust_code,'<%=Ar_installed%>')">
			</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type="text" name="p_from_stlmt_type" id="p_from_stlmt_type" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById("stlmttypeid"), 
			p_from_stlmt_type,'N')"><input type='button' name='stlmttype' id='stlmttype' id='stlmttypeid' value='?' class='button' onclick="searchCode(this, 
			p_from_stlmt_type,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_stlmt_type" id="p_to_stlmt_type" size="2" maxlength="2" onblur="if (this.value!='')searchCode(document.getElementById("stlmttypeid"), 
			p_to_stlmt_type,'N')"><input type='button' name='stlmttype' id='stlmttype' value='?' class='button' onclick="searchCode(this, 
				p_to_stlmt_type,'N')">
			</td>
		</tr>
<%
		}		
%>

  <!-- Commented on 11/17/2005 -->

<!-- <tr>
<td align="right" class="label"  > Report Type </td>
<td >&nbsp;
<select name='P_Report_Type' id='P_Report_Type' onchange="change_report(this)">
<option value='S' selected>Standard</option>
<option value='C' >Reduced</option>
</select>
</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
			</tr> -->
<tr><td colspan ='4'>&nbsp;</td></tr>
</table>

		<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>

</center>
<%
}catch(Exception e){out.println(e);}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
%>

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

