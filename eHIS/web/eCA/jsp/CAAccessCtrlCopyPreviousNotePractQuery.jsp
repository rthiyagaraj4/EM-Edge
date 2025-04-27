<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
19/06/2024	  62372			Twinkle Shah		19/04/2021		Ramesh Goli	ML-MMOH-CRF-2149.1
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con			= null;
String facility_id="";
String facility_name="";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityId = (String)session.getValue( "facility_id" );
String user_id=(String) session.getValue("login_user");	
int count=0;
String dis="disabled";
PreparedStatement pstmt=null;
ResultSet rs=null;
String facility=request.getParameter("facility_id")==null ||  request.getParameter("facility_id").equals("") ?facilityId:request.getParameter("facility_id");
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/CAAccessCtrlCopyPreviousNotePract.js'></script>
<script>
	
	 function enable_txt(obj){
		if(obj.value!='00')		        
		  document.forms[0].search_txt.disabled=false;		 		
		else
		{
			document.forms[0].search_txt.disabled=true;
			document.forms[0].search_txt.value="";
		}
	}
	
 	function call(){
		var error=getMessage("WELCOME","common");
		alert(error);
	}	
</script>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
		<form name='CAAccessRightsForViewRestrictPatForm' id='CAAccessRightsForViewRestrictPatForm' method='post' target='messageFrame'>
		<%try{ 
			con= ConnectionManager.getConnection(request);
		%>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='85%'>
				<tr>
					<td colspan='1' width="20%"></td>
					<td colspan='1' width="30%"></td>
					<td colspan='1' width="15%"></td>
					<td colspan='1' width="20%"></td>
				</tr>
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
		    <tr>
			<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td><td class='fields' align='left' >&nbsp;&nbsp;<select id="facility_id" name="facility_id" id="facility_id" onchange='chgFacility()'>
				<%
			    //String sql="select facility_id,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"', 1) facility_name,DECODE(FACILITY_ID,?,'Y','N') facility_YN  from sm_facility_for_user where appl_user_id=?"; //65302
				String sql="Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id = ? and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)"; //65302
	
				String select="";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, user_id);
					//pstmt.setString(2, facilityId); // 65302
					rs=pstmt.executeQuery();
					if(rs!=null)
		    		{
					while(rs.next()){
						facility_id=rs.getString("facility_id");
						facility_name = rs.getString("facility_name");
						count++;
						if(facility_id.equals(facility))
							select="selected";
						else
							select="";
						
						if(count==1)
						{
							out.println("<option value='"+facility_id+"' "+select+">"+facility_name+"</option>");
						}
						else
						{
							out.println("<option value='"+facility_id+"' "+select+" >"+facility_name+"</option>");
						}		
					%>
					<%}
					%>
				</select>
				</td>
				<%} %>
				<input type="hidden" name="facility_id" id="facility_id"  id="facility_id" value='<%=facility%>'/>
		</tr>
		<tr>
			<td colspan="9" >&nbsp;</td>
		</tr>
    			<tr>
    				<td class='label'>Copy Previous Note</td>
    				<td  align='left' class='fields' >&nbsp;
    				<input type="text" name="patientStatus" id="patientStatus" size=12 id="patientStatus" value="Allow" disabled>
				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  colspan=2 class='fields' >&nbsp;
						<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
							<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
							<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
						</SELECT>&nbsp;&nbsp;
						<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=15 maxlength=15 value="">
					</td>	
    				<td nowrap align='right'>&nbsp;<input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='searchClick()'></td>
   				</tr>
			</table>	
</form>
<%}catch(Exception e){
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>

</body>
</html>

