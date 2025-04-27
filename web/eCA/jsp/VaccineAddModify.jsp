<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
---------------------------------------------------------------------------------------------------------------------------
04/11/2023     43504               Twinkle Shah    	  04/11/2023                            CA-IMMUNIZATION CODE SETUP-VACCINE
---------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/Vaccine.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con=null;
try
{
	PreparedStatement stmt=null;
    ResultSet rs=null;
	String mode="";
	String sql="";
	//String dis1="";
	String status="";
	String sel="";
	String sel1="";
	//String effective_status1="E";
	String adhoc_yn="N";
	String check_dup_yn="N";
	String adhoc_checked ="unchecked";
	String dup_checked ="unchecked";
	String vaccine_id="";
	String vaccine_long_desc="";
	String vaccine_short_desc="";
	String dup_chk_days="";
	String dup_chk_action="";
	String eff_status="";
	String enabled_checked1="checked";
	




	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	vaccine_id		=(request.getParameter("vaccine_id")==null)?"":request.getParameter("vaccine_id");



	try
		{
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update"))
			{

			//sql ="select * from CA_IM_VACCINE where VACCINE_ID ='"+ vaccine_id+ "'" ;//common-icn-0180
			sql ="select * from CA_IM_VACCINE where VACCINE_ID = ?" ;//common-icn-0180
			stmt=con.prepareStatement(sql);
			stmt.setString(1,vaccine_id);//common-icn-0180
			rs = stmt.executeQuery();
			if(rs.next())
				{
				 vaccine_id		=(rs.getString("VACCINE_ID")==null)?"":rs.getString("VACCINE_ID");
				 vaccine_long_desc		=(rs.getString("LONG_DESC")==null)?"":rs.getString("LONG_DESC");
				
				 vaccine_short_desc		=(rs.getString("SHORT_DESC")==null)?"":rs.getString("SHORT_DESC");
				 
				 adhoc_yn=(rs.getString("ADHOC_YN")== null)? "":rs.getString("ADHOC_YN");

				 check_dup_yn=(rs.getString("CHECK_DUPLICATE_YN")== null)? "":rs.getString("CHECK_DUPLICATE_YN");

				 dup_chk_days		=(rs.getString("DUPL_CHECK_DAYS")==null)?"":rs.getString("DUPL_CHECK_DAYS");
				 
				 
				 dup_chk_action		=(rs.getString("DUPL_CHECK_ACTION")==null)?"":rs.getString("DUPL_CHECK_ACTION");
				 
				 eff_status		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");

				 if(eff_status.equals("E"))
						enabled_checked1="checked";
					else
					{
						enabled_checked1="";
						//dis1="disabled";
					}
	/* start.43504  if(dup_chk_action.equals("W")||dup_chk_action.equals("null")||dup_chk_action.equals(""))
					{
					  sel="selected";
					}
				else
				{
					sel1="selected";
				
				} */
					
				if(dup_chk_action.equals("W"))
				{
					sel="selected";
					}
				else if(dup_chk_action.equals("E"))
				{
					sel1="selected";
				}
				
				//end. 43504
				
               if(adhoc_yn.equals("Y"))
					adhoc_checked="checked";
				else
				{
					adhoc_checked="N";
				
				}

				if(check_dup_yn.equals("Y"))
					dup_checked="checked";
				else
				{
					dup_checked="N";
				
				}
			}

			if(rs!=null) { rs.close(); rs=null; }
			if(stmt!=null) { stmt.close(); stmt=null; }

			}
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	       	e.printStackTrace();//COMMON-ICN-0181
	}
	/* if (dup_chk_action.equals(""))
	{
		sel="selected";
	} 43504 */
%>

<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="vaccine_form" id="vaccine_form" action="../../servlet/eCA.VaccineServlet" method="post" target="messageFrame">
<br><br><br>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>
<tr>
	<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td colspan="2" class='fields' ><input type="text" name="vaccine_id" id="vaccine_id" value="<%=vaccine_id%>" <%=status%>
	size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="vaccine_long_desc" id="vaccine_long_desc" value="<%=vaccine_long_desc%>"   size=40 maxlength=60 onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="vaccine_short_desc" id="vaccine_short_desc" value="<%=vaccine_short_desc%>"   size=40 maxlength=40 onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eCA.CanBeUsedAsAdhoc.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="adhoc_yn" id="adhoc_yn" value="" <%=adhoc_checked%> onclick='OnAdhocChange(this)'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eCA.DuplicateCheckRecquired.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="check_dup_yn" id="check_dup_yn" value="N" <%=dup_checked%> onclick='OnChkReqDaysChange(this)'></td>
</tr>
<tr>
	<td class=label><fmt:message key="eCA.DuplicateCheckDays.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="dup_chk_days" id="dup_chk_days" value="<%=dup_chk_days%>"   size=10 maxlength=5></td>
</tr>
<tr>
		<td class=label ><fmt:message key="eCA.DuplicateCheckAction.label" bundle="${ca_labels}"/></td>
		<td class='fields' colspan="2"><select name='dup_chk_action' id='dup_chk_action'>
			<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
			<option value="E" <%=sel1%>><fmt:message key="Common.Error.label" bundle="${common_labels}"/></option>
			<option value="W" <%=sel%>><fmt:message key="Common.Warn.label" bundle="${common_labels}"/></option>
			
			</select></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked1%>></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=eff_status%>">
<input type=hidden name='adh_yn' id='adh_yn' value=<%=adhoc_yn%>>
<input type=hidden name='chk_yn' id='chk_yn' value=<%=check_dup_yn%>>
<input type=hidden name="vaccine_id_update" id="vaccine_id_update" value="<%=vaccine_id%>">
<input type=hidden name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked1%>">
</form>
</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception in  VaccineAddModify.jsp"+e.toString());//COMMON-ICN-0181
	 e.printStackTrace();//COMMON-ICN-0181
}
finally
{
    
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>




