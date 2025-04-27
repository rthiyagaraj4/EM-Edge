<!DOCTYPE html>
<%--
/**	
  *	Purpose				:	Displays the Search Criteria for MR Patient by Diagnosis.
  * Added by			:	Sen 
  * Date				:   14/05/2004
  */
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%

	 String	facilityId 	= (String) session.getValue( "facility_id" ) ;
%>
<html>
<head>
<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'     href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMR/js/QueryDiagnosis.js'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <%	
	request.setCharacterEncoding("UTF-8");
 try{
     Connection con 					= null;
	 Statement stmt						= null;
	 ResultSet rset					    = null;
	 String diag_code			= "";
	 String diag_desc			= "";

try{
	 con =  ConnectionManager.getConnection(request);
	 stmt	= con.createStatement();
	 rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD 10','2','ICD 9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
	if ((rset != null) && (rset.next())){
		diag_code = rset.getString("DIAG_CODE_SCHEME");
		diag_desc = rset.getString("SCHEME_DESC");
	}
	if(rset!=null)  rset.close();
	if(stmt!=null)  stmt.close();
	 stmt	= con.createStatement();
	 StringBuffer tm_set_list=new StringBuffer();
	 String defiine_lvel="";
	 rset=stmt.executeQuery("SELECT TERM_SET_ID,TERM_SET_DESC,DEFN_LEVELS FROM MR_TERM_SET WHERE EFF_STATUS='E' AND DIAG_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC");
	 while(rset.next()){
			tm_set_list.append("<option value='"+rset.getString("TERM_SET_ID")+"'>"+rset.getString("TERM_SET_DESC")+"</option>");
			defiine_lvel=defiine_lvel+"<input type='hidden' name='"+rset.getString("TERM_SET_ID")+"_dfn_level' id='"+rset.getString("TERM_SET_ID")+"_dfn_level' value='"+rset.getString("DEFN_LEVELS")+"' />";
	 }
	if(rset!=null)  rset.close();
	if(stmt!=null)  stmt.close();


	 %>
	 <!-- 
		This page was modified 
		For:IN025311 On:11/30/2010 
		Reason:Diagnosis Type  is not applicable for 10.x i.e drop down list  removed and UI was changed.
	 -->
<body  onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form name='MRPatientsDiagnosisForm' id='MRPatientsDiagnosisForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
		<tr>
			<td width="20%" class='label' nowrap><fmt:message key="Common.DiagnosisCodingScheme.label" bundle="${common_labels}"/></td>
			<td width="20%" class='fields' nowrap >
					<select name='mr_diagnosis_set' id='mr_diagnosis_set' onchange="clearDiagCode()">
							<option  value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> 
							<%=tm_set_list.toString()%>
					</select>
							<%=defiine_lvel%>
					<img src='../../eCommon/images/mandatory.gif'></img>
					<td width="20%" class ='label' nowrap></td>
					<td width="20%" class='fields' ></td>
			</td>
			</tr>
		<tr>
			<td class='label' nowrap><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type='text' name='mr_diagnosis_code' id='mr_diagnosis_code' disabled size=11 maxlength=5 onKeyPress="return CheckForSpecChars(event);"><input type='button' class='button' name='mr_diagnosis_select' id='mr_diagnosis_select' onclick="callDiagnosis();" value='?'></input><img src='../../eCommon/images/mandatory.gif'></img></td>
			<td width="20%" class ='label' nowrap><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></td>
			<td width="20%" class='fields' ><input type='text' size=52 maxlength=52 name='mr_diagnosis_desc' id='mr_diagnosis_desc' readOnly></input><input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>"></input><input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>"></input></td>
		</tr>
		<tr>
				<td class=label  nowrap><fmt:message key="eMR.OnsetDateFrom.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input id='onsetdatefrom'type=text name='onset_date_from' id='onset_date_from' onblur="validDateObj(this,'DMY','en');CompareOnsetFromToDat(this,onset_date_to);" size=10 maxlength=10><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].onset_date_from.select();return showCalendar('onsetdatefrom')" /></td>
				<td class='label'><fmt:message key="eMR.OnsetDateTo.label" bundle="${mr_labels}"/></td>
				<td class='fields'><input id='onsetdateto' type=text name='onset_date_to' id='onset_date_to' onblur="validDateObj(this,'DMY','en');CompareOnsetFromToDat(onset_date_from,this);" size=10 maxlength=10><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].onset_date_to.select();return showCalendar('onsetdateto')"/></td>
			<tr>
			<td class='LABEL'  nowrap><fmt:message key="eMR.DisplayActiveOnly.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='checkbox' name='mr_display_active' id='mr_display_active'></input></td>
			<td width="20%" class ='label'></td>
			<td width="20%" class='fields' ></td>
		</tr>
		<tr>
			<td class='LABEL' nowrap >&nbsp;</td>
			<td class='LABEL' nowrap >&nbsp;</td>
			<td class='LABEL' nowrap >&nbsp;</td>
			<td class='button'  nowrap><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search' onClick='callSearch();'><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="parent.clear()"></td>
		</tr>
	</table>
	<input type='hidden' name='ae_unknown_location_desc' id='ae_unknown_location_desc'>
</form>
</body>

	<% } catch(Exception e){/* out.println("sub : "+e); */ e.printStackTrace();}
   finally
    {
	   try
		{
    	if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		}
		catch(Exception e){}
		ConnectionManager.returnConnection(con,request);
    }
%>
<input type=hidden name='facilityId' id='facilityId' value='<%=facilityId%>'>
	
</html>
<%}
catch(Exception e1)
{
	//out.println("main "+e1);
	e1.printStackTrace();
}
%>

