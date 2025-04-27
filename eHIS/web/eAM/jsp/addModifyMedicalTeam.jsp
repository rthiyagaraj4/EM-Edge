<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eAM/js/MedicalTeam.js'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>


<script>

 function focusTxt()
	 {
	 	facilityteam_form.teamid.focus();
	 }
	 
	function ObjChkYN(Obj)
	{
	if(Obj.checked == true)
		Obj.value='Y';
	else
		Obj.value='N';
	
	}
</script>	 

</head>
<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<br><br><br><br>
 <%

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt1 = null;
   ResultSet rs	= null;
   PreparedStatement pstmt=null;
   
   Statement splstmt =null;
   ResultSet splrs	= null;
   ResultSet rset1 = null;
String globaluser="";
String sys_date_val="";

String locale = (String)session.getAttribute("LOCALE");


java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
globaluser = (String)p.getProperty("login_user");

   ResultSet rset=null;
   String facility_id ="";
   String facilityId = (String)session.getValue("facility_id");

facility_id=request.getParameter("facility_id");
if(facility_id == null) facility_id="";
else
facilityId=facility_id;
   String longdesc="";
   String shortdesc="";
   
   String chk1 = "CHECKED";
   String speciality_code="";

   String effstatus="E";
   String codeTextAttribute="";
   String otherTextAttribute="";
   
   String eventFunctionForCase="";
  
   String teamid = "";
   String EFF_DATE_FROM = "";
   String EFF_DATE_TO = "";
   boolean newteam=false;
   String sql="";
   String appl_for_op_yn="",appl_for_ip_yn="",appl_for_mr_yn=""; // added by mujafar for ML-MMOH-CRF-0716
   String specialty_query_code="";
   String op_checked_yn = "",mr_checked_yn=""; // added by mujafar for ML-MMOH-CRF-0716
   String ip_checked_yn = "";
   String EFF_DATE_FROM_DISP="";
	String EFF_DATE_TO_DISP="";

  teamid=request.getParameter("teamid");
		if(teamid == null) teamid = "";

String facility_desc = request.getParameter("facility_desc");
	if(facility_desc == null) facility_desc="";
	Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	
try{
	
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	
	
	String sys_date="select to_char(sysdate,'dd/mm/yyyy') from dual ";
	rset = stmt.executeQuery(sys_date);
	if(rset !=null && rset.next())
	{
		sys_date_val=rset.getString(1);

	}
	if(rset !=null) rset.close();
	String splqry="Select  Speciality_Code,Short_Desc from AM_SPECIALITY where Eff_Status = 'E' order by Short_Desc ";
	splstmt=conn.createStatement();		

	if(teamid.equals(""))
	 {
		teamid="";
		longdesc="";
		shortdesc="";
		codeTextAttribute="";
		otherTextAttribute="";

		newteam=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	 }
	 else
	 {
	 	

     	   try{

		sql =  "select to_char(EFF_DATE_FROM,'dd/mm/yyyy')EFF_DATE_FROM,to_char(EFF_DATE_TO,'dd/mm/yyyy')EFF_DATE_TO,TEAM_ID,LONG_DESC,SHORT_DESC,SERVICE_CODE,EFF_STATUS,speciality_code,appl_for_op_yn,appl_for_ip_yn,appl_for_mr_yn   from am_medical_team where facility_id =? and team_id=?"; // modified by mujafar for ML-MMOH-CRF-0716
		
		
		pstmt1   = conn.prepareStatement(sql);
		pstmt1.setString	(	1,	facility_id		);
		pstmt1.setString	(	2,	teamid		);

		rset		 = pstmt1.executeQuery();
				
			if(rset.next())
			{
				EFF_DATE_FROM =rset.getString("EFF_DATE_FROM");
				EFF_DATE_TO = rset.getString("EFF_DATE_TO");
				if(EFF_DATE_TO==null) EFF_DATE_TO ="";
				if(EFF_DATE_FROM==null) EFF_DATE_FROM ="";

				 EFF_DATE_FROM_DISP=DateUtils.convertDate(EFF_DATE_FROM,"DMY","en",locale);
				 EFF_DATE_TO_DISP=DateUtils.convertDate(EFF_DATE_TO,"DMY","en",locale);

				teamid		= rset.getString("TEAM_ID");
				longdesc	= rset.getString("long_desc");
				shortdesc	= rset.getString("short_desc");
				effstatus	= rset.getString("eff_status");
				speciality_code=rset.getString("speciality_code");
				if(speciality_code == null) speciality_code="";
				appl_for_op_yn=rset.getString("appl_for_op_yn");
				appl_for_ip_yn=rset.getString("appl_for_ip_yn");
				appl_for_mr_yn = rset.getString("appl_for_mr_yn"); // added by mujafar for ML-MMOH-CRF-0716
				if(appl_for_op_yn.equals("Y"))	op_checked_yn="Checked"; 
				else op_checked_yn = "Unchecked";
				if(appl_for_ip_yn.equals("Y"))	ip_checked_yn="Checked"; 
				else ip_checked_yn = "Unchecked"; 
				if(appl_for_mr_yn.equals("Y"))	mr_checked_yn="Checked";  // added by mujafar for ML-MMOH-CRF-0716
				else mr_checked_yn = "Unchecked";
			}
			if(effstatus.equals("D"))
			   {
				chk1 = "";
				otherTextAttribute="READONLY";
			   }
			   else
				   otherTextAttribute="";
	
	     }
		 catch(Exception e){e.printStackTrace();}
		codeTextAttribute="READONLY";
		newteam=false;
		eventFunctionForCase="";
	}
%>
<form name='facilityteam_form' id='facilityteam_form' action='../../servlet/eAM.MedicalTeamServlet' method='post' target='messageFrame'>
<div>

<table border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>

</tr>
		<tr>
		<td class='label'>&nbsp;</td>
		     <td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		     <td class='fields' align='left'>
		     <% if(newteam) { %>
		     &nbsp;&nbsp;<select name='facility_id' id='facility_id' >
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>

			<%
				String dat="",id="",en="";
				pstmt=conn.prepareStatement("Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id =? and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)");
				pstmt.setString	(	1,	globaluser		);
				rset1=pstmt.executeQuery();
				if(rset1!=null)
				{
				   while(rset1.next())
				   {
				   dat=rset1.getString("Facility_Name");
				   id=rset1.getString("Facility_Id");
				   if(id.equals(facilityId))
					en="selected";
				    else
					en="";

				 out.println("<option value='"+id+ "' "+en+">"+dat);

				   }
				}
				out.print("</select>");
			} else {
			%>
			&nbsp;&nbsp;<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>"><input type='text' readOnly name='35' name='facility_desc' id='facility_desc' value="<%=facility_desc%>" size="70">
			<% } %>
			<img src='../../eCommon/images/mandatory.gif'></td>
			 <td colspan='2'>&nbsp;</td>
			 </tr>
			<tr>
			<td colspan='5'>&nbsp;</td>
</tr>			 
<tr>
		<td class='label'>&nbsp;</td>
		<td  class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/> </td>
		<td class='fields'>&nbsp;
		<input type='text' name='teamid' id='teamid' value="<%=teamid%>" size='6' maxlength='6' <%=codeTextAttribute%> <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event)">
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>

</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>

</tr>

<tr>
		 <td class='label'>&nbsp;</td>
		<td    class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;
		<input type='text' onBlur="makeValidString(this)" name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
		<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

		<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td    class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;
			<input type='text' onBlur="makeValidString(this)" name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> >
			<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td  class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;
			<%
			if(effstatus.equals("D"))
			{ %>
			<input type='hidden' name='specialty' id='specialty' value='<%=speciality_code%>'><select disabled name='specialty1' id='specialty1'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- 
			<% } else {%>
			<select name='specialty' id='specialty'><option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
			<% }%>
			<% splrs = splstmt.executeQuery(splqry); 
			while(splrs.next())
			{
			specialty_query_code= splrs.getString(1);
			if(specialty_query_code.equals(speciality_code))
				out.println("<option selected value='"+splrs.getString(1)+"'>"+splrs.getString(2)+"</option>");
			else
				out.println("<option  value='"+splrs.getString(1)+"'>"+splrs.getString(2)+"</option>");
			}
			%>
			</select>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>

<tr>
			<td class="label"></td>
			<td align='left' class='label'><fmt:message key="eAM.ApplicableForOutpatients.label" bundle="${am_labels}"/></td>
			<td class="fields">
			<% if(newteam) { %>
			&nbsp;<input type="checkbox" name="appl_for_op_yn" id="appl_for_op_yn" value='N' onClick='ObjChkYN(this)'>
			<% } else { %>
			&nbsp;<input type="checkbox" name="appl_for_op_yn1" id="appl_for_op_yn1" value='<%=appl_for_op_yn%>' <%=op_checked_yn%> onClick='ObjChkYN(this)' disabled><input type='hidden' name='appl_for_op_yn' id='appl_for_op_yn' value='<%=appl_for_op_yn%>'>
			<% } %>&nbsp;&nbsp;
			
			<fmt:message key="eAM.ApplicableForInpatients.label" bundle="${am_labels}"/>
			
			<% if(newteam) { %>
			<input type="checkbox" name="appl_for_ip_yn" id="appl_for_ip_yn" value='N' onClick='ObjChkYN(this)'>
			<% } else { %>
			<input type="checkbox" name="appl_for_ip_yn1" id="appl_for_ip_yn1"  value='<%=appl_for_ip_yn%>' <%=ip_checked_yn%> onClick='ObjChkYN(this)' disabled><input type='hidden' name='appl_for_ip_yn' id='appl_for_ip_yn' value='<%=appl_for_ip_yn%>'>
			<% } %>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			
			
			
			
			
			</td><td>&nbsp;</td><td>&nbsp;</td>
</tr>

			<%
			if(isMedicalTeamApplicable)
			{ // added by mujafar for ML-MMOH-CRF-0716
			%>
			<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
			</tr>
			
			<tr>
			<td class="label"></td>
			<td align='left' class='label'><fmt:message key="eAM.ApplicableForMedicalReport.label" bundle="${am_labels}"/></td>
			<td class="fields">
			<%if(newteam) 
			{
			%>
			&nbsp;<input type="checkbox" name="appl_for_mr_yn" id="appl_for_mr_yn" value='N' onClick='ObjChkYN(this)'>
			<% } else { %>
			&nbsp;<input type="checkbox" name="appl_for_medical_report_yn1" id="appl_for_medical_report_yn1" value='<%=appl_for_mr_yn%>' <%=mr_checked_yn%> onClick='ObjChkYN(this)' disabled><input type='hidden' name='appl_for_mr_yn' id='appl_for_mr_yn' value='<%=appl_for_mr_yn%>'>
			<%
			}
			%>
			</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			<%
			
			}
			%>




<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr><td>&nbsp;</td>	<%if(effstatus.equals("E"))
			{ 
%>
					<td class='label'  nowrap><fmt:message key="eAM.ApplicablePeriodFrom.label" bundle="${am_labels}"/></td><td class='fields' colspan='2' nowrap>&nbsp;&nbsp;<input type='text' maxlength='10' size='10' name='from_date' id='from_date'  value="<%=EFF_DATE_FROM_DISP%>" onBlur="DateCompare_from('from',this,sys_date_val);"><input type='hidden' name='greg_from_date_hd' id='greg_from_date_hd' value="<%=EFF_DATE_FROM%>"><img  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].from_date.focus();return showCalendar('from_date');" tabindex=-1><input type='hidden' name='greg_from_date' id='greg_from_date' value=''> - <input type='text' value="<%=EFF_DATE_TO_DISP%>" maxlength='10' size='10' name='to_date' id='to_date' onBlur="DateCompare_from('To',this,sys_date_val);DateCompare3(from_date,this);"><input type='hidden' name='greg_to_date_hd' id='greg_to_date_hd' value="<%=EFF_DATE_TO%>"><img  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].to_date.focus();return showCalendar('to_date');" tabindex=-1><input type='hidden' name='greg_to_date' id='greg_to_date' value=''></td>
<%
			}
			else 
			{
%>
					<td class='label' align=right nowrap><fmt:message key="eAM.ApplicablePeriodFrom.label" bundle="${am_labels}"/></td><td class='fields' colspan='2' nowrap>&nbsp;&nbsp;<input type='text' maxlength='10' size='10' name='from_date' id='from_date'  value="<%=EFF_DATE_FROM%>" readonly> - <input type='text' value="<%=EFF_DATE_TO%>" maxlength='10' size='10' name='to_date' id='to_date' readonly>&nbsp;</td>
<%			
			}
%>
						<td>&nbsp;</td></tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value='E' <%=chk1%>>
			<td>&nbsp;</td><td>&nbsp;</td>
</tr>
<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td><td class='label'>&nbsp;</td>
</tr>
<tr>
			<td colspan='4' class='bodycolorfilled' >&nbsp;</td>
</tr>
	<input type="hidden" name="sys_date_val" id="sys_date_val" value="<%=sys_date_val%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</table>
<%	if(newteam)
	{
%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>

<%  }
  	else
	{
%>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	}

}
catch(Exception e) 
{
e.printStackTrace();
}
finally
	{
	try
	{
	if(rset!=null)    	rset.close();
	if(rs!=null)    	rs.close();	
	if(splrs!=null)     splrs.close();
	if(rset1!=null)     rset1.close();
	if(pstmt!=null)		pstmt.close();
	if(pstmt1!=null)		pstmt1.close();
   	if(stmt!=null)  	stmt.close();
	if(splstmt!=null)   splstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	ConnectionManager.returnConnection(conn,request);
}	
%>
</form>
</body>
</html>

