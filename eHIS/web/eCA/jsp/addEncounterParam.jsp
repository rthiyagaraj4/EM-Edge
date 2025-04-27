<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
01/04/2015	IN048704			Karthi L							 			Bed Side Referral 
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
		<title><fmt:message key="eCA.AddEncounterparameter.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../js/EncounterParameter.js'			language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onLoad="Focusing('days_bkwd_visit')">
<form name="encounter_param_form" id="encounter_param_form" action='../../servlet/eCA.EncounterParamServlet' method="post" target="messageFrame">
<%		  
try
{
	    conlCon = ConnectionManager.getConnection(request);
		StringBuffer sblQry = new StringBuffer();
		String license_rights = "";
		int days_backward_visits = 0;
		int days_backward_discharges = 0;
		int rec_exists = 0;
		String establish_reln_req_yn = "", menuTab = "";
		String reln_checked="";
		String reln_yn_val="";
		String assign_confirm_referral_yn = "";// IN048704
		String assign_checked = ""; // IN048704
		String remarks_checked="";//0605
		String remarks_relationships_yn ="";//0605

		if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
			license_rights= "FULL";
		else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
			license_rights= "BASIC";
		else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
			license_rights= "MINI";
		
		if(sblQry.length() > 0) sblQry.delete(0,sblQry.length());
		
		//sblQry.append("SELECT days_backward_visits,  days_backward_discharges, "); // commented for IN048704
		//sblQry.append("establish_reln_req_yn,TAB_MENU_YN FROM ca_encntr_param "); // commented for IN048704
		sblQry.append("SELECT days_backward_visits, days_backward_discharges, establish_reln_req_yn,tab_menu_yn, assgn_conf_ref_yn assign_confirm_yn, remarks_relationships_yn FROM ca_encntr_param "); // added by LK
		pstmt = conlCon.prepareStatement( sblQry.toString());
		rslRst = pstmt.executeQuery();
		if(rslRst.next())
		{
			rec_exists = 1;
			do
			{
				days_backward_visits =  rslRst.getInt("days_backward_visits");
				days_backward_discharges =  rslRst.getInt("days_backward_discharges");
				establish_reln_req_yn =  rslRst.getString("establish_reln_req_yn");
				menuTab =  rslRst.getString("TAB_MENU_YN");
				assign_confirm_referral_yn = rslRst.getString("assign_confirm_yn")== null?"":rslRst.getString("assign_confirm_yn");// IN048704
				remarks_relationships_yn = rslRst.getString("remarks_relationships_yn")== null?"":rslRst.getString("remarks_relationships_yn");//0605
			}
			while(rslRst.next());
			out.println("<input type='hidden' name='mode' id='mode' value='update'>");
		}
		else
		{
			out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
		}
		if(establish_reln_req_yn.equals("Y"))
		{
				reln_checked = "checked";
				reln_yn_val = "Y";
		}
		else
		{
			reln_checked = "";
			reln_yn_val="N";
		}
		// Start - IN048704
		if(assign_confirm_referral_yn.equalsIgnoreCase("Y")){
			assign_checked = "checked";
		}
		else {
			assign_checked = "";
		}
		// End - IN048704
		
		//start-0605
		if(remarks_relationships_yn.equalsIgnoreCase("Y")){
			remarks_checked = "checked";
		}
		else {
			remarks_checked = "";
		}
		//End-0605
%>
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
	<table cellpadding='3' cellspacing='0' border='0' width='60%' align='center'>
	<tr>
		  <td width="25%"  class="label"><fmt:message key="eCA.BackwardVisits.label" bundle="${ca_labels}"/></td>
		  <td width="50%"  colspan="2" class='fields'>
			<input type="text" name="days_bkwd_visit" id="days_bkwd_visit" size="4" maxlength="3" onblur="return checkForMinus(this)" onKeyPress="return allowValidNumber(this, event,3,0)" <% if(days_backward_visits != 0){ %>value = <%= days_backward_visits %> <% }%> ><fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
	<tr>
		  <td width="25%"  class="label"><fmt:message key="eCA.BackwardDischarge.label" bundle="${ca_labels}"/></td>
		  <td width="50%"  colspan="2" class='fields'>
			<input type="text" name="days_bkwd_dischg" id="days_bkwd_dischg" size="4" maxlength="3"  onblur="return checkForMinus(this)" onKeyPress="return allowValidNumber(this, event,3,0)" <% if(days_backward_discharges != 0){ out.println(" value = "+days_backward_discharges); }%> ><fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
<%if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
  {
%>
	<tr>
		  <td width="25%" class="label"><fmt:message key="eCA.EstablishRelationship.label" bundle="${ca_labels}"/></td>
		  <td width="50%" colspan="2" class='fields'><input type="checkbox" name="reln_reqd_yn" id="reln_reqd_yn" <% if(establish_reln_req_yn.equals("Y")) {out.println ("checked");} if(rec_exists ==1){/*out.println("disabled");*/}%> value="" onclick='assignVal(this);'>
		  </td>
	</tr>
	<input type="hidden" name="establish_reln_req_yn" id="establish_reln_req_yn" value="<%=establish_reln_req_yn%>">
	<!--  Start - IN048704 -->
	<tr>
		  <td width="25%" class="label"><fmt:message key="eCA.assignandconfirm.label" bundle="${ca_labels}"/></td> 
		  <td width="50%" colspan="2" class='fields'><input type="checkbox" name="assign_confirm_referral_yn" id="assign_confirm_referral_yn" value="<%=assign_confirm_referral_yn%>" onclick='assignConfirm(this);'<%=assign_checked%>>
		  </td>
	</tr>
	   <!--  start - 0605 -->
	<tr>
		  <td width="25%" class="label"><fmt:message key="eCA.RemarksMandatoryRelationships.label" bundle="${ca_labels}"/></td> 
		  <td width="50%" colspan="2" class='fields'><input type="checkbox" name="remarks_relationships_yn" id="remarks_relationships_yn" value="<%=remarks_relationships_yn%>" onclick='remarksConfirm(this);'<%=remarks_checked%>>
		  </td>
	</tr>
	              <!--  End - 0605 -->

	<!--  End - IN048704 -->
<%}
else
{%>
	<tr style='visibility:hidden'>
		  <td width="25%"  class="label"><fmt:message key="eCA.EstablishRelationship.label" bundle="${ca_labels}"/></td>
		  <td width="50%" colspan="2" class='fields'><input type="checkbox" name="reln_reqd_yn" id="reln_reqd_yn" value="<%=reln_yn_val%>" onclick='assignVal(this);'<%=reln_checked%>>
		  </td>
	</tr>

<%}%>
</table>
<input type="hidden" name="establish_reln_req_yn" id="establish_reln_req_yn" value="<%=establish_reln_req_yn%>">
</form>
</body>
</html>
<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addEncounterParam.jsp : "+e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

}
%>

