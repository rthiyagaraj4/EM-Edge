<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLDischClear.js"></script>
<script language="javascript" src="../../eBL/js/BLDischClearCancel.js"></script>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;

		try{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params is: "+params);
			
			String facility_id = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			
			con=ConnectionManager.getConnection(request);
			
			String fac_Id="";
			String fac_name="";
			String disabled="";

%>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
<form name="bldiscClearance" id="bldiscClearance">
<TABLE border='0' cellpadding='3' cellspacing='0'>

		<tr>
			<td width='2%' class='label'><fmt:message key="eBL.Facility.label" bundle="${bl_labels}" /></td>			
			<td width='2%' class='fields'>
				<select name='facilityID' id='facilityID' id='facilityID' <%=disabled %> >
			<%
				try
				{
					String sqlFacility = "select facility_id, facility_name from sm_facility_param_lang_vw where status = 'E' and language_id = ? and facility_id = ?";
					pstmt = con.prepareStatement(sqlFacility);
					pstmt.setString(1,locale);
					pstmt.setString(2,facility_id);
					rst = pstmt.executeQuery();

					if(rst != null){
						while(rst.next()){ 
							fac_Id=rst.getString("facility_id");
							fac_name=rst.getString("facility_name");
							
			%>
					<option value='<%=fac_Id %>' <%=fac_Id.equals(facility_id) ? "selected" : ""%>><%=fac_name %></option>
			<%
						}
					}
				}catch(Exception e){
						System.err.println("facility list="+e.toString());
					}
				
			%>
				</select><img src='../../eCommon/images/mandatory.gif'>
			</td>	

			<td width='2%' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}" /></td>
			<td width='2%' class='fields'>
				<input type='text' name='nursing_unit_desc' id='nursing_unit_desc' id='nursing_unit_desc' size="12" maxlength="20" value='' onblur='if(this.value!=""){ getNursingUnit(1,nursing_unit_desc,nursing_unit_code) } else{ clearCode(nursing_unit_code); } '>
				<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' id='nursing_unit_code' value=''>
				<input type='button' class='button' name="nursing_unit_btn" id="nursing_unit_btn" value='?' onClick="getNursingUnit(1,nursing_unit_desc,nursing_unit_code);" tabindex='2'>				
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type="text" name="patient_id" id="patient_id" id="patient_id" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this );} " value=''>
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();"  tabindex='2' />	
			</td>
			
			<td class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type="text" name="episode_id" id="episode_id" id="episode_id"  maxlength="30"  onBlur="if(this.value!=''){ callEpisodeDialog(episode_id); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="episode_idbut" id="episode_idbut" value='?' onClick="callEpisodeDialog(episode_id)"  tabindex='2' /> 
			</td>
		</tr>
		<tr>	
			<td class="label" ><fmt:message key="eBL.DischClearFromDate.label" bundle="${bl_labels}"/></td>
			<td class='fields'>
				<input type='text' name='Effective_from' id='Effective_from' maxlength="10"  size='10' value='' onblur='effFromDateValidation(this, Effective_from, Effective_to);'>
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
			</td>
			
			<td class="label" ><fmt:message key="eBL.DischClearToDate.label" bundle="${bl_labels}"/></td>
			<td class='fields'>
				<input type='text' name='Effective_to' id='Effective_to' maxlength="10"  size='10' value='' onblur='effToDateValidation(this, Effective_from, Effective_to);'>
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">
			</td>
		</tr>
		<tr>	
			<td class="label" ><fmt:message key="Common.Options.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select id="option_type" name="option_type" id="option_type" >
				<option value="B"><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>
				<option value="Y"><fmt:message key="eBL.WithDischargeBill.label" bundle="${bl_labels}"/></option>
				<option value="N"><fmt:message key="eBL.WithoutDischargeBill.label" bundle="${bl_labels}"/></option>
				</select>	
			</td>	
			
			<td class='fields'>
				<input type='button' name="search_button" id="search_button" id="search_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" class='button' onclick='cancel_disch_clearance_reultset()' >
			</td>			
		</tr>
		
</TABLE>

<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">	
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>

</form>
<%	
		}catch(Exception e){
			out.println("Exception in BLDischClearGenerateResult.jsp: "+e);
			System.err.println("Exception in BLDischClearGenerateResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}
%>
</body>	
	
</HTML>

