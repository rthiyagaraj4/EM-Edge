<!DOCTYPE html>
<%--
Filename			: addModifyRepDiagnosisStatisticsForOP.jsp
Added On		: 29-07-2009
Created By		:S.Sathish
--%>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name			= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String p_locale		= (String)session.getValue("LOCALE");
%>
<html>
<HEAD>
<script>
</script>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/FieldFormatMethods.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src="../../eOP/js/RepDiagnosisStatisticsForOP.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name="repDiagnosisStatisticsForOP_form" id="repDiagnosisStatisticsForOP_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br>
<%
    String p_module_id      = "OP" ;
    //String p_report_id      = "OPBDYCST" ;
    String p_report_id      = "OPDIAGST" ;
    Connection con  =  null;
    Statement stmt = null;
	ResultSet rset =null;
	String ID="";
    String dat="";
    //String en="";
	String sql1="";
	String diag_code="";
	String diag_desc="";
	StringBuffer StrVal =new StringBuffer();
	try{
		con=ConnectionManager.getConnection(request); 
		stmt = con.createStatement(); 
		sql1 = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+p_locale+"' order by 2" ;
		rset = stmt.executeQuery(sql1);
		StrVal.setLength(0);

		if(rset != null)
		{
				while(rset.next())
				{
					StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
				}
		}
	 	if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();

		stmt = con.createStatement(); 
		rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD10','2','ICD9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
		
		if ((rset != null) && (rset.next()))
		{
			diag_code = rset.getString("DIAG_CODE_SCHEME");
			diag_desc = rset.getString("SCHEME_DESC");
		}		
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();

%>

<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' width='100%' align ="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>
  <tr>
				<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>				
				 <td class='fields' colspan='2'><select name='p_all_facility_id' id='p_all_facility_id' >
					<%
					 stmt=con.createStatement();					
                     rset=stmt.executeQuery("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+localeName+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");
                    
					if(rset!=null)
					{
						while(rset.next())
						{
							dat=rset.getString("FACILITY_NAME");
							ID=rset.getString("FACILITY_ID");						
								if(ID.equals("All"))
									out.println("<option value='"+ID+"' selected>"+dat+"</option>");
								else
									out.println("<option value='"+ID+"'>"+dat+"</option>");
						}%>
					</select>
				<%}%>
				</td>					 
   </tr> 
   <tr>
				<td >&nbsp;</td>
				<td class="querydata" style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class="querydata" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>				
				<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text id='p_fm_date'  name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
				<td class='fields'><input type=text id='p_to_date'  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
				</td>
	</tr> 
	<tr>
				<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_splty_code" id="p_fm_splty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_splty_code)'>
				</td>
				<td class='fields'><input type="text" name="p_to_splty_code" id="p_to_splty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_splty_code)'>
				</td>
	 </tr>
	 <tr>
				<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
				</td>
				<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
				</td>
	 </tr>
	 <tr>
				<td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>

				<td class='fields'><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'>
				</td>
				<td class='fields'>	<input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
				</td>
     </tr>
	 <tr>
                <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                <td class='fields'><select name="p_fm_pract_type" id="p_fm_pract_type">
					<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
					<%=StrVal.toString()%>
					</select>
				</td>					
                <td class='fields'><select name="p_to_pract_type" id="p_to_pract_type">
					<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
					<%=StrVal.toString()%>
					</select>
				</td>
     </tr>
	 <tr>
				<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
				
				<td class='fields'><input type="text" name="p_fm_prct_code" id="p_fm_prct_code" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this,p_fm_prct_code)'>
				</td>	
				<td class='fields'>	<input type="text" name="p_to_prct_code" id="p_to_prct_code" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this,p_to_prct_code)'>
				</td>
	 </tr>
	 <%if(rset != null) rset.close();%>
	 <tr>
				<td class=label><fmt:message key="eOH.DiagnosisScheme.Label" bundle="${oh_labels}"/></td>
				<td class='fields'>
				<select name="p_term_set_id" id="p_term_set_id" onchange = "enable_code()"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<%
					 
					String term_set_id   = "";
					String term_set_desc = "";
					String sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";

					rset = stmt.executeQuery(sql);
					if( rset != null )
					{
						while( rset.next())
						{
	        				term_set_id = rset.getString("term_set_id") ;
	        				term_set_desc=rset.getString("term_set_desc");
				%>				
					<option value='<%= term_set_id %>'><%= term_set_desc %></option>

				<%	}
					}%>
				  </select>
				  </td>
	  </tr>
	  <tr>
			<td class=label ><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>

			<td class='fields'><input type='text' name='p_fm_term_code' id='p_fm_term_code' value="" size='20' maxlength='20' disabled><input type='button' class='button' value='?' name='fm_diag_button' id='fm_diag_button' onClick="call_Diagnosis(p_fm_term_code,this);" disabled><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id = 'fm_i_diag_code'></img>
			</td>
			<td class='fields'><input type='text' name='p_to_term_code' id='p_to_term_code' value="" size='20' maxlength='20' disabled><input type='button' class='button' value='?' name='to_diag_button' id='to_diag_button' onClick="call_Diagnosis(p_to_term_code,this);" disabled><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id = 'to_i_diag_code'></img>
			</td>
	  </tr>
	  </table>

	 
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type="hidden" name="p_locale" id="p_locale"			value="<%= p_locale %>">
<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>">
<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>">


</form>
<% }
	catch(Exception e)
	{ out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 if( con !=null ) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</center>
</html>

