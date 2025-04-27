<!DOCTYPE html>
<!--GradeAddModify.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Janet George
*	Created On		:	13 Jan 2005-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");



%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Grade.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
String mode	= request.getParameter("mode");
 Connection conn = ConnectionManager.getConnection(request);
  PreparedStatement pstmt=null;
  ResultSet rs=null;


%>
<BR>
<br><br>
<form name=form_add_mod  method='POST' action='../../servlet/eRS.GradeServlet'
target='messageFrame'>	
<%
	if(mode.equalsIgnoreCase("1")){
%>
	<table cellpadding=0 cellspacing=0 border=0 width="98%" align='right'>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
		<td class='label'  width='30%'>
		<fmt:message key="eRS.GradeCode.label" bundle="${rs_labels}"/></td>
			<td width='60%' >&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value='' name='grade_code' id='grade_code' onkeypress="return CheckForSpecChars(event);" onBlur=ChangeUpperCase(this);>
			<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td class='label' width='30%' ><fmt:message key="eRS.GradeDescription.label" bundle="${rs_labels}"/></td>
			<td width='70%'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value='' name='grade_desc' id='grade_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td  width='30%' class="label">
			<fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;<textarea name="grade_expl_text"  rows='5' cols='40' onblur='checkForMax(this);'></textarea></td>
		
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
<tr>
			<td class='label' width='30%'><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<td width='70%' >&nbsp;&nbsp;&nbsp;<select name='grade_level' id='grade_level' >
			<% 
				for(int iIndexValue =1 ; iIndexValue<100; iIndexValue++)
					out.println("<option value = "+iIndexValue+">"+iIndexValue+"</option>");
			%>
	</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
<tr>
			<td class='label' width='30%'><fmt:message key="eRS.ConsiderForScheduling.label" bundle="${rs_labels}"/></td>
			<td width='70%'>&nbsp;&nbsp;<input type='checkbox' checked value='Y' name='allow_scheduling_yn' id='allow_scheduling_yn' onclick='schedule_enable(this);'></td>
	</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
	<td class='label' width='30%'><fmt:message key="eRS.FTWorkHours.label" bundle="${rs_labels}"/></td>
	<td width='60%' >&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='3' value='' name='ft_work_hours' id='ft_work_hours' onkeypress="return CheckForSpecChars(event), numberCheck();">
			<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td class='label' width='30%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%'>&nbsp;&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
	</tr>
	</table> 
		
	<%	} else{
	try
	{
	String grade_code=request.getParameter("grade_code")==null ? "":request.getParameter("grade_code");
	String query="select grade_desc,grade_level,allow_scheduling_yn,grade_expl_text,ft_work_hours,eff_status from rs_grade_lang_vw where grade_code=? and language_id = ?";
	String grade_desc="";
	String grade_level="";
	String allow_scheduling_yn="";
	String grade_expl_text="";
	String ft_work_hours=""; 
	String eff_status="";
	String disabled="";
	String readonly="";
	String checked="";
	

	pstmt=conn.prepareStatement(query);
    pstmt.setString(1,grade_code);
    pstmt.setString(2,locale);
    rs=pstmt.executeQuery();
	if(rs!=null)
	{
      while(rs.next())
	  {
	 grade_desc  = rs.getString("grade_desc")==null ? "":rs.getString("grade_desc");
	 grade_level  = rs.getString("grade_level")==null ? "":rs.getString("grade_level");
	 allow_scheduling_yn = rs.getString("allow_scheduling_yn")==null?"N":rs.getString("allow_scheduling_yn");
	 grade_expl_text = rs.getString("grade_expl_text")==null?"":rs.getString("grade_expl_text");
	 ft_work_hours = rs.getString("ft_work_hours")==null ? "":rs.getString("ft_work_hours");
	 eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	  }
	}
%>
<table cellpadding=0 cellspacing=0 border=0 width="98%" align='right'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' ><fmt:message key="eRS.GradeCode.label" bundle="${rs_labels}"/></td>
			<td width='70%' >&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value="<%=grade_code%>" readonly name='grade_code' onkeypress="return CheckForSpecChars(event);" onBlur=ChangeUpperCase(this); >
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>

	<%if(eff_status.equals("E")){
			disabled="";
			readonly="";
			checked="checked";
		}else{
			disabled="disabled";
			readonly="readOnly";
			checked="";
		}
	%>
		<tr>
			<td class='label' width='30%' ><fmt:message key="eRS.GradeDescription.label" bundle="${rs_labels}"/></td>
			<td width='70%' >&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=grade_desc%>" name='grade_desc' <%=readonly%>><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>

	<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td  width='30%'  class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;<textarea name="grade_expl_text"  rows='5'cols='40' onblur='checkForMax(this);' <%=readonly%>><%=grade_expl_text%></textarea></td>
		</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
			<td class='label' width='30%' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<td width='70%'>&nbsp;&nbsp;&nbsp;<select name='grade_level' id='grade_level' onChange='Grade_level(this);' <%=disabled%>>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<% 
				for(int iIndexValue =1 ; iIndexValue<100; iIndexValue++){
				if(iIndexValue==Integer.parseInt(grade_level)){%>
					<option value='<%=grade_level%>' selected %><%=grade_level%></option>
			<%}else{%>
					<option value ='<%=iIndexValue%>'><%=iIndexValue%></option>
			<%}}%>
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
<tr>
			<td class='label' width='30%' ><fmt:message key="eRS.ConsiderForScheduling.label" bundle="${rs_labels}"/></td>
				<%if(allow_scheduling_yn.equals("Y"))
			{%>
			<td width='70%' >&nbsp;&nbsp;&nbsp;<input type='checkbox' checked value="<%=allow_scheduling_yn%>" name='allow_scheduling_yn' onclick='schedule_enable(this);' <%=disabled%>></td>
			<%}
			else{
				%>
				<td width='70%'>&nbsp;&nbsp;&nbsp;<input type='checkbox'  value="<%=allow_scheduling_yn%>" name='allow_scheduling_yn' onclick='schedule_enable(this);' <%=disabled%>></td>
					<%}%>
	</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
	<td class='label' width='30%' ><fmt:message key="eRS.FTWorkHours.label" bundle="${rs_labels}"/></td>
	<td width='60%' >&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='3' name='ft_work_hours' id='ft_work_hours' onkeypress="return CheckForSpecChars(event);" value="<%=ft_work_hours%>" <%=readonly%>>
			<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="20%" class="label">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" <%=checked%> value="<%=eff_status%>" onclick='onenable(this);'></td>
			</tr>
      	</table>
<input type='hidden' name='hgrade_level' id='hgrade_level' value="<%=grade_level%>">	
<input type='hidden' name='hallow_scheduling_yn' id='hallow_scheduling_yn' value="<%=allow_scheduling_yn%>">	
<%} catch(Exception e)
  {
	out.println(e.toString());
	e.printStackTrace();
  }
  finally
  {
    if (pstmt != null) pstmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(conn,request);

  }
}
%>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>	
</form>
</body>
</html>	

