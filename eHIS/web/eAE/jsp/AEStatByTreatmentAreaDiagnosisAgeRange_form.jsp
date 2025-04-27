<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AESTADAR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
	String p_language_id						= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	Statement stmt = null;	
	ResultSet rset			= null ;
    PreparedStatement pstmt = null;
	
	
%>

<html>

<HEAD>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/CommonCalendar.js" ></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' ></script>
<script src="../../eAE/js/AEStatByTreatmentAreaDiagAgeRange.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()' onMouseDown="CodeArrest()" >
<form name="AEStatByTreatmentAreaDiagnosisAgeRange_form" id="AEStatByTreatmentAreaDiagnosisAgeRange_form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
try{
	    String term_set_id   = "";
		String term_set_desc = "";
		String sql="";
		String diag_code="";
		String diag_desc="";
		String range_id="";
		String long_desc="";

		con=ConnectionManager.getConnection(request); 
		stmt = con.createStatement(); 
		
		rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD10','2','ICD9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
		
		if ((rset != null) && (rset.next()))
		{
			diag_code = rset.getString("DIAG_CODE_SCHEME");
			diag_desc = rset.getString("SCHEME_DESC");
		}		
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		 String five_level_triage_appl_yn	= "N";
		 String AcessSql   = "SELECT five_level_triage_appl_yn FROM AE_PARAM WHERE OPERATING_FACILITY_ID=? ";
		  pstmt=con.prepareStatement(AcessSql);
		  pstmt.setString(1,p_facility_id);
		  rset=pstmt.executeQuery();
		  while(rset!=null && rset.next()) {
			  five_level_triage_appl_yn	=  (rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
		  }
		  if(rset!=null)  rset.close();
		  if(pstmt!=null)  pstmt.close();
	%>

<table align='center' width='70%' border='0'>
<tr>
<th align='left' colspan='4'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</tr>
		<tr>
			<td class="label" width='30%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td width='25%'><input type="text" name="p_locn_code" id="p_locn_code" size="4" maxlength="4"><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this,p_locn_code);;'></td>
			<td width='25%'>&nbsp;</td>
			<td width='20%'>&nbsp;</td>			
		</tr>
		<tr>
			<td  class='label' width="30%"><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
			<td width="25%">
			<select name='p_priority_zone' id='p_priority_zone' >
			<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<%
					sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' ";
					
					if(!five_level_triage_appl_yn.equals("Y")){
						sql	= sql + "  and priority_zone not in ('B','W') ";
					}
					sql= sql + " order by PRIORITY_ZONE_ORDER asc";	
					pstmt   = con.prepareStatement(sql.toString());
			        pstmt.setString(1,locale) ;
			        rset    = pstmt.executeQuery();
				   while(rset!=null && rset.next()){
				      out.println("<option value='"+rset.getString(1)+"'>");	     
			          out.println(rset.getString(2));
			          out.println("</option>"); 
				       }

			  if(pstmt!=null) pstmt.close();
			  if(rset!=null)rset.close();
							%>
			</select></td>
			<td width="25%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
		</tr>
		<tr>
			<td class="label" width="30%"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			<td width="25%"><input type="text" name="p_tmt_area_code" id="p_tmt_area_code" size="4" maxlength="4" onBlur='if(this.value != "") nursCode(fromtreat,this)'><input type='button' name='fromtreat' id='fromtreat' value='?' class='button' onclick='nursCode(this, p_tmt_area_code)'>	</td>
			<td width="25%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
		</tr>
		<tr>
				<td class=label width="30%"><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></td>
				<td class='fields' width="25%">
				<select name="p_term_set_id" id="p_term_set_id" onchange='cleardiagcode()'><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<% 
					 stmt = con.createStatement();
					 sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'  and EFF_STATUS='E'  order by term_set_desc ";
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
					}
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();					
					%>
				  </select>
				  </td>
				<td width="45%" class='label' nowrap><fmt:message key="Common.AgeRange.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <select name="p_age_range" id="p_age_range" ><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<% 
					 stmt = con.createStatement();
					 sql = "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2";
					rset = stmt.executeQuery(sql);
					if( rset != null )
					{
						while( rset.next())
						{
	        				range_id = rset.getString("range_id") ;
	        				long_desc=rset.getString("long_desc");							
				%>				
					<option value='<%= range_id %>'><%= long_desc %></option>

				<%	}
					}					
					%>
					</select><img src='../../eCommon/images/mandatory.gif' ></img>
					</td>
	  </tr>
		<tr>
			<td  class='label' width="30%" >&nbsp;</td>
			<td  width="25%" class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="25%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td width="20%">&nbsp;</td>
		</tr>
		<tr>
			<td class=label width="30%"><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
			<td class='fields' width="25%"><input type='text' name='p_fm_term_code' id='p_fm_term_code' value="" size='20' maxlength='20' ><input type='button' class='button' value='?' name='fm_diag_button' id='fm_diag_button' onClick="call_Diagnosis(p_fm_term_code,this);">
			</td>
			<td class='fields' width="25%"><input type='text' name='p_to_term_code' id='p_to_term_code' value="" size='20' maxlength='20'><input type='button' class='button' value='?' name='to_diag_button' id='to_diag_button' onClick="call_Diagnosis(p_to_term_code,this);">
			</td>
			<td width="20%">&nbsp;</td>
	  </tr>
		<tr>
			<td  class='label' width="30%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td width="25%"><input type=text id='periodfrom' name='p_fm_date1' id='p_fm_date1' size="10" maxlength="10" onBlur='if(this.value != "")doDate(this);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('periodfrom');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img></td>
			<td width="25%"><input type=text id='periodto' name='p_to_date1' id='p_to_date1' size="10" maxlength="10" onBlur='if(this.value != "")doDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('periodto');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img></td>			
			<td width="20%">&nbsp;</td>
		</tr>
		<tr>
		<td class='label' width='30%' nowrap><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
		<td width="25%"><input type='checkbox' name='p_group_by' id='p_group_by' value='N' onClick='groupbytreat(this);'></td>
		<td width="25%">&nbsp;</td>
		<td width="20%">&nbsp;</td>
		</tr>


 </table>
 <!--Below hidden field Added for this SCF SRR20056-9516 -->
<input type="hidden" name="p_fm_date" id="p_fm_date" value="">
<input type="hidden" name="p_to_date" id="p_to_date" value="">
<!--End SRR20056-9516 -->
 <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>">
<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>">
<input type="hidden" name="p_language_id" id="p_language_id"		value="<%= p_language_id %>">

 </form>
 <% }
	catch(Exception e)
	{ e.printStackTrace();}
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
 </html>

