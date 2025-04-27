<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rset = null;
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBINFCY" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
%>
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<title></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target,Ar_installed)
	{
			var retVal = 	new String();
			//var dialogHeight= "28" ;
			//var dialogWidth	= "43" ;
			var dialogHeight= "400px" ; ///added by vijayan
			var dialogTop = "10px" ;
			var dialogWidth	= "700px" ;
			
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			//alert(obj.name)
			if(obj.name=="patsergrp")
			{
				tit=getLabel('Common.PatientSeriesGroup.label','common');
				sql="select pat_ser_grp_code, short_desc from mp_pat_ser_grp_lang_vw where language_id=`"+localeName+"`";
				search_code="pat_ser_grp_code";
				search_desc= "short_desc";
			}
			
			if(obj.name=="citizenship")
			{
				tit=getLabel('Common.Citizenship.label','common');
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}
			
			if(obj.name=="patcategory")
			{
				tit=getLabel('Common.category.label','common');
				sql="select pat_cat_code, short_desc from mp_pat_category_lang_vw where language_id=`"+localeName+"`";
				search_code="pat_cat_code";
				search_desc= "short_desc";
			}
			else if(obj.name=="blnggrp")
			{
				tit=getLabel('Common.BillingGroup.label','common');
				sql="select blng_grp_id, short_desc from bl_blng_grp_lang_vw where language_id=`"+localeName+"`";
				search_code="blng_grp_id";
				search_desc= "short_desc";
			}
			else if(obj.name=="custcode" && Ar_installed == "Y")
			{
				tit=getLabel('Common.Customer.label','common');
				sql="select cust_code, short_name from ar_customer_lang_vw where language_id=`"+localeName+"`";
				search_code="cust_code";
				search_desc= "short_name";
			}
			else if(obj.name=="custcode" && Ar_installed == "N")
			{
				tit=getLabel('Common.Customer.label','common');
				sql="select cust_code, short_name from bl_emp_ins_mst_lang_vw where language_id=`"+localeName+"`";
				search_code="cust_code";
				search_desc= "short_name";
			}
			else if(obj.name=="stlmttype")
			{
				tit=getLabel('Common.SettlementType.label','common');
				sql="select slmt_type_code, short_desc from bl_slmt_type_lang_vw where language_id=`"+localeName+"`";
				search_code="slmt_type_code";
				search_desc= "short_desc";
			}
												
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
</head>
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
			

	} catch(Exception e) { out.println(e.toString());}
	finally 
	{
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	}
%>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<form name="repInactivePatList" id="repInactivePatList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><!--BR><BR><BR><BR><BR><BR-->
			<table width='70%' cellPadding="3" cellSpacing="0" align='center'>
			 <tr>
				<td width='30%'>&nbsp;</td>
				<td width='30%'>&nbsp;</td>
				<td width='5%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
			</tr> 
			<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<%
				try
				{
					//Added by Sangeetha for ML-MMOH-CRF-0732 
					Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");

					stmt=con.createStatement();
					String fid;
					String fname;
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";			
		
					rset=stmt.executeQuery(sql1);
%>
			<td class='fields' colspan='3'><select name='facilityid' id='facilityid'>
<%
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+"' >"+fname+"</option>");
					   }
					}
				 %>
				</select>
			</td>
		</tr>
		<tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td><td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
		<!-- <tr><td colspan ='4'>&nbsp;</td></tr>  -->
		<tr>
			<td class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text  name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="center" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_date','dd/mm/y',null)">&nbsp;
			<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type=text  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="center" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_date','dd/mm/y',null)"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
				<!--Modified maxLength by Sangeetha for ML-MMOH-CRF-0732 --> 
				<td class='label'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_from_pat_ser_grp_code" id="p_from_pat_ser_grp_code" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %>><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this,p_from_pat_ser_grp_code,'N')">
				</td><td class='label' >&nbsp;</td>
				<td class='fields'><input type="text" name="p_to_pat_ser_grp_code" id="p_to_pat_ser_grp_code" size="2" <%if(increase_leng_pat_series){%> maxlength="3" <%}else{%> maxlength="2" <% } %>><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick="searchCode(this,p_to_pat_ser_grp_code,'N')">
				</td>
		</tr>
				<tr>
						<td class='label'><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type="text" name="p_from_nat_code" id="p_from_nat_code" size="4" maxlength="4"><input type='button' name='citizenship' id='citizenship' value='?' class='button' onclick="searchCode(this, p_from_nat_code,'N')">
						</td>
						<td class='label' >&nbsp;</td>
						<td class='fields'><input type="text" name="p_to_nat_code" id="p_to_nat_code" size="4" maxlength="4"><input type='button' name='citizenship' id='citizenship' value='?' class='button' onclick="searchCode(this, p_to_nat_code,'N')">
						</td>
				</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type="text" name="p_from_pat_cat_code" id="p_from_pat_cat_code" size="4" maxlength="4"><input type='button' name='patcategory' id='patcategory' value='?' class='button' onclick="searchCode(this, p_from_pat_cat_code,'N')">
						</td>
						<td class='label' >&nbsp;</td>
						<td class='fields'><input type="text" name="p_to_pat_cat_code" id="p_to_pat_cat_code" size="4" maxlength="4"><input type='button' name='patcategory' id='patcategory' value='?' class='button' onclick="searchCode(this, p_to_pat_cat_code,'N')">
						</td>
					</tr>
<%
if (BL_installed.equals("Y"))
{
%>	
	<tr>
			<td  class='label' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_from_blng_grp_id" id="p_from_blng_grp_id" size="2" maxlength="2"><input type='button' name='blnggrp' id='blnggrp' value='?' class='button' onclick="searchCode(this, 
			p_from_blng_grp_id,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_blng_grp_id" id="p_to_blng_grp_id" size="2" maxlength="2"><input type='button' name='blnggrp' id='blnggrp' value='?' class='button' onclick="searchCode(this, 
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
			<td class='label' ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type="text" name="p_from_stlmt_type" id="p_from_stlmt_type" size="2" maxlength="2"><input type='button' name='stlmttype' id='stlmttype' value='?' class='button' onclick="searchCode(this, 
			p_from_stlmt_type,'N')">
			</td>
			<td class='label' >&nbsp;</td>
			<td class='fields'><input type="text" name="p_to_stlmt_type" id="p_to_stlmt_type" size="2" maxlength="2"><input type='button' name='stlmttype' id='stlmttype' value='?' class='button' onclick="searchCode(this, 
				p_to_stlmt_type,'N')">
			</td>
		</tr>
<%
}
%>	

				
				<tr>
						<td class='label'><fmt:message key="Common.PatientStatus.label" bundle="${common_labels}"/></td>
						<td class='fields' colspan ='3'><select name='p_status' id='p_status'>
								<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
								<option value="I"><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/>
								<option value="S"><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/>
								<option value="D"><fmt:message key="Common.deceased.label" bundle="${common_labels}"/>
								<option value="R"><fmt:message key="eMP.Restricted.label" bundle="${mp_labels}"/><!-- Added by Ajay Hatwate for MMS-DM-CRF-0210.1 recommited on 27-10-2023 -->
							</select>
						</td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
						<td class='fields' colspan ='3'><select name='p_group_by' id='p_group_by'>
								<option value="N"><fmt:message key="Common.none.label" bundle="${common_labels}"/>
								<option value="S"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/>
								<option value="Z"><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/>
								<option value="C"><fmt:message key="Common.category.label" bundle="${common_labels}"/>
							</select>
						</td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<td class='fields' colspan ='3'><select name='p_order_by' id='p_order_by'>
								<option value="1"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
								<option value="2"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
								<option value="3"><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/>
							</select>
						</td>
						
					</tr>
		<tr><td colspan ='4'>&nbsp;</td></tr>
		</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"			value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>

</BODY>
</HTML>
<%
}catch(Exception e){out.println(e);}
				finally{
					if (stmt!=null) stmt.close();
					if (rset!=null) rset.close();
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

