<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	04 Oct 2004
-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%
	String p_mode="";
	String p_staff_type="";
	String p_role_type="";
	String p_pract_type="";
	String p_other_staff_type="";
	String p_staff_id="";
	String p_staff_name="";
	String p_age="";
	String p_position_code="";
	String p_position_desc="";
	String p_skill_code="";
	String sql1="";
	String sql2="";
	String sql3="";
	String sql4="";
	String sql5="";
	String sql6="";
	String selected="";
	String disabled="";

	Vector prim_specialty = new Vector();
	Vector facility_list=new Vector();
	Vector license_list= new Vector();
	Vector training_list= new Vector();
	Vector pract_list=new Vector();
	Vector other_staff_list=new Vector();

	Connection conn = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 =null;
	PreparedStatement pstmt3 =null;
	PreparedStatement pstmt4 =null;
	PreparedStatement pstmt5 = null;
	PreparedStatement pstmt6 = null;

	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;

	p_mode=request.getParameter("p_mode")==null ? "":request.getParameter("p_mode");
	p_staff_type=request.getParameter("p_staff_type")== null ? "":request.getParameter("p_staff_type");
	p_role_type=request.getParameter("p_role_type")==null ? "":request.getParameter("p_role_type");
	p_pract_type=request.getParameter("p_pract_type")==null ? "":request.getParameter("p_pract_type");
	p_age=request.getParameter("p_age")==null ? "":request.getParameter("p_age");
	p_other_staff_type=request.getParameter("p_other_staff_type")==null ? "":request.getParameter("p_other_staff_type");
	p_staff_id=request.getParameter("p_staff_id")== null ? "":request.getParameter("p_staff_id");
	p_staff_name=request.getParameter("p_staff_name")== null ? "":request.getParameter("p_staff_name");
	p_position_code=request.getParameter("p_position_code")==null ? "":request.getParameter("p_position_code");
	p_position_desc=request.getParameter("p_position_desc")==null ? "":request.getParameter("p_position_desc");
	p_skill_code=request.getParameter("p_skill_code")==null ? "":request.getParameter("p_skill_code");


	if(p_mode.equals("call"))
	{
		if(p_role_type.equalsIgnoreCase("P"))
				p_pract_type=p_staff_type;
		else
			p_other_staff_type=p_staff_type;
	}
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js' ></script>		
<!-- <script language='javascript' src='../../eCommon/js/messages.js' ></script> -->
<script language='javascript' src='../../eRS/js/SearchStaff.js'></script>
<!-- <script language='javascript'src='../../eRS/js/RSMessages.js' ></script> -->
<script language="JavaScript" src="../../eCommon/jsCommonLookup.js"></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function ChangeType(form,target,sStyle)
{
	 var role_type=target.value;
	 var p_other_staff_type=parent.f_query_select.document.form_SearchStaff.p_other_staff_type;
	 var p_pract_type=parent.f_query_select.document.form_SearchStaff.p_pract_type;
	 var p_primary_speciality_code=parent.f_query_select.document.form_SearchStaff.p_primary_speciality_code;
	 var p_position_code=parent.f_query_select.document.form_SearchStaff.p_position_code;
	 var position_code=parent.f_query_select.document.form_SearchStaff.position_code;

	if(role_type=="role_type")
	document.forms[0].role_type.value='';
					
	if(role_type=="P")
		  {
				var HTMLVal = "<HTML><HEAD></HEAD><BODY CLASS='MESSAGE'>";
				HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eRS/jsp/SearchStaffFetchStaffType.jsp'>";
				HTMLVal = HTMLVal +"</form></BODY></HTML>";

				p_other_staff_type.disabled=true;
				p_other_staff_type.value="";
				p_other_staff_type.text="-----Select-----";
				p_pract_type.disabled=false;
				p_primary_speciality_code.disabled=false;
				p_position_code.value="";
				position_code="";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.forms[0].submit();
		  }
          else
		  {
				var HTMLVal = "<HTML><HEAD></HEAD><BODY CLASS='MESSAGE'>";
				HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eRS/jsp/SearchStaffFetchOtherStaffType.jsp'>";
				HTMLVal = HTMLVal +"</form></BODY></HTML>";
				p_pract_type.disabled=true;
				p_primary_speciality_code.disabled=true;
				p_other_staff_type.disabled=false;
				p_pract_type.value="";
				p_pract_type.text="----Select----";
				p_primary_speciality_code.value="";
				p_primary_speciality_code.text="---Select---";
				p_position_code.value="";
				position_code="";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.forms[0].submit();
		  }
		  // parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>

		}
		
	</script>
</head>	
<%
try
{
	conn = ConnectionManager.getConnection();

	//sql5="select pract_type,desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
	sql5="select pract_type,desc_userdef from am_pract_type_lang_vw where eff_status = 'E' and language_id = ? order by desc_userdef";

		pstmt5=conn.prepareStatement(sql5);
		pstmt5.setString(1,locale);
		rs4=pstmt5.executeQuery();
		while(rs4.next())
		{	
			pract_list.add(rs4.getString("pract_type"));
			pract_list.add(rs4.getString("desc_userdef"));
		}
		if(pstmt5 != null)
			pstmt5.close();
		if(rs4 != null)
			rs4.close();
		//sql6="select other_staff_type,short_desc from am_other_staff_type where eff_status = 'E' order by short_desc";
		sql6="select other_staff_type,short_desc from am_other_staff_type_lang_vw where eff_status = 'E' and language_id = ? order by short_desc";
		pstmt6=conn.prepareStatement(sql6);
		pstmt6.setString(1,locale);
		rs5=pstmt6.executeQuery();
		while(rs5.next())
			{
				other_staff_list.add(rs5.getString("other_staff_type"));
				other_staff_list.add(rs5.getString("short_desc"));
			}
		if(pstmt6 != null)
			pstmt6.close();
		if(rs5 != null)
			rs5.close();
	
	//sql1="Select speciality_code, short_desc from am_speciality where eff_status = 'E' order by short_desc";
	sql1="Select speciality_code, short_desc from am_speciality_lang_vw where eff_status = 'E' and language_id = ? order by short_desc";
	
	pstmt1=conn.prepareStatement(sql1);
	pstmt1.setString(1,locale);
	rs=pstmt1.executeQuery();
	while (rs.next())
	{
		prim_specialty.add(rs.getString("speciality_code"));
		prim_specialty.add(rs.getString("short_desc"));
		
	}
		if(pstmt1 != null)
			pstmt1.close();
		if(rs != null)
			rs.close();
	
	//sql2="Select facility_id, facility_name from sm_facility_param where status = 'E' order by facility_name";
	sql2="Select facility_id, facility_name from sm_facility_param_lang_vw where status = 'E' and language_id = ? order by facility_name";
	pstmt2=conn.prepareStatement(sql2);
	pstmt2.setString(1,locale);
	rs1=pstmt2.executeQuery();
	 while(rs1.next())
	 {
		facility_list.add(rs1.getString("facility_id"));
		facility_list.add(rs1.getString("facility_name"));
	 }
		if(pstmt2 != null)
			pstmt2.close();
		if(rs1 != null)
			rs1.close();

	//sql3="Select license_code, license_desc from rs_licensure where eff_status = 'E' order by license_desc";
	sql3="Select license_code, license_desc from rs_licensure_lang_vw where eff_status = 'E' and language_id = ? order by license_desc";
	pstmt3=conn.prepareStatement(sql3);
	pstmt3.setString(1,locale);
	rs2=pstmt3.executeQuery();
		while(rs2.next())
		{
			license_list.add(rs2.getString("license_code"));
			license_list.add(rs2.getString("license_desc"));
		}
		if(pstmt3 != null)
			pstmt3.close();
		if(rs2 != null)
			rs2.close();

	//sql4="Select training_code, training_desc from rs_training where eff_status = 'E' order by training_desc";
	sql4="Select training_code, training_desc from rs_training_lang_vw where eff_status = 'E' and language_id = ? order by training_desc";
	pstmt4=conn.prepareStatement(sql4);
	pstmt4.setString(1,locale);
	rs3=pstmt4.executeQuery();
		while(rs3.next())
		{
			training_list.add(rs3.getString("training_code"));
			training_list.add(rs3.getString("training_desc"));
		}
		if(pstmt4 != null)
			pstmt4.close();
		if(rs3 != null)
			rs3.close();
}catch(Exception e)
	{
		e.printStackTrace();
		throw e ;
	}
 finally 
 {
    		rs.close();
			rs1.close();
			rs2.close();
			rs3.close();
			rs4.close();
			rs5.close();
			pstmt1.close();	
			pstmt2.close();
			pstmt3.close();
			pstmt4.close();
			pstmt5.close();
			pstmt6.close();
			ConnectionManager.returnConnection(conn,request);
	}

%>
	<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=form_SearchStaff >
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td class="label" width="8%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
				
					<td >
					 &nbsp;&nbsp;<select name='p_role_type' id='p_role_type' onChange='ChangeType(this.form,this);'>
						<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<% if(p_role_type.equals("P"))
						selected="selected";
					else
						selected = "";
				%>
						<option value='P' <%=selected%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<% if(p_role_type.equals("O"))
						selected="selected";
					else
						selected = "";
				%>
						<option value='O' <%=selected%>><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
				</td>	

			<td  class="label" width="19%"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
			<td>&nbsp;
		<%	if(p_mode.equals("call")){
					if(p_role_type.equalsIgnoreCase("O"))
						disabled="disabled";
					else
						disabled="";
		%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="p_pract_type" id="p_pract_type" <%=disabled%>>
					<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				for(int i=0;i<pract_list.size();i+=2){
					if(p_pract_type.equals(pract_list.get(i)))
						selected="selected";
					else
						selected="";
				%>
			<option value='<%=pract_list.get(i)%>' <%=selected%>><%= (String)pract_list.get(i+1)%> </option>
				<%
				}
				%>
				</select>
				</td>

				<td class="label" width="17%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/></td>
				<td>&nbsp;

			<%	if(p_role_type.equalsIgnoreCase("P"))
						disabled="disabled";
					else
						disabled="";
				%>
				<select name="p_other_staff_type" id="p_other_staff_type" <%=disabled%>>
					<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				for(int i=0;i<other_staff_list.size();i+=2){
					if(p_other_staff_type.equals(other_staff_list.get(i)))
						selected="selected";
					else
						selected="";
				%>
			<option value='<%=other_staff_list.get(i)%>' <%=selected%>><%= (String)other_staff_list.get(i+1)%> </option>
				<%
				}
				%>
				</select>
				</td>
				<%}
				else{
					%>
					<select name="p_pract_type" id="p_pract_type">
						<option value="" selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				</td>	
				<td class="label" width="17%"><fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/></td></td>
				<td>&nbsp;
					<select name="p_other_staff_type" id="p_other_staff_type">
							<option value="" selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				</td>
				<%}%>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td class="label" width="19%"><fmt:message key="eRS.PrimarySpecialty.label" bundle="${rs_labels}"/></td>
				<%if((p_mode.equals("call")) || p_mode!=("call"))
				{%>
				<td>&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="p_primary_speciality_code" id="p_primary_speciality_code">
						<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<%
						for(int i=0;i<prim_specialty.size();i+=2)
							{
							%>
							<option value='<%=prim_specialty.get(i)%>' ><%= (String)prim_specialty.get(i+1)%> </option>
							<%
							}
							%>
					<select>
								<%}%>
								</td>
				<td></td>
				<td></td>
			</tr>
			</table>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td class="label" width="15%"><fmt:message key="eRS.StaffID.label" bundle="${rs_labels}"/></td>
				<%if(p_mode.equals("call"))
				{%>
					<td>&nbsp;&nbsp;
				<input type="text" name="p_staff_id" id="p_staff_id"  size="15" maxlength="15"  onKeyPress="return CheckForSpecChars(event)" value=<%=p_staff_id%> >
					</td>
				<%}
				else
				{%>
				<td>&nbsp;
				<input type="text" name="p_staff_id" id="p_staff_id"  size="15" maxlength="15"  onKeyPress="return CheckForSpecChars(event)" >
					</td>
				<%}%>
				<td class="label" width="30%"><fmt:message key="eRS.StaffName.label"bundle="${rs_labels}"/> </td>
				<%if(p_mode.equals("call"))
				{%>
					<td width="30%"><input type="text" name="p_staff_name" id="p_staff_name" size="31" maxlength="30" value='<%=p_staff_name%>'></td>
				<%}
				else
				{%>
				<td width="30%">&nbsp;&nbsp;<input type="text" name="p_staff_name" id="p_staff_name" size="31" maxlength="30"></td>
					<%}%>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="label" width="5%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<%if(p_mode.equals("call"))
				{%>
					<td width="13%">&nbsp;
					<select name="p_gender" id="p_gender">
					<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U' ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
							</select>
						</td>
					<%}
				else
				{%>
				<td width="13%">&nbsp;
					<select name="p_gender" id="p_gender">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
						</td>
				<%}%>
				<td class="label" width="5%"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
				<%if(p_mode.equals("call"))
				{%>
						<td width="13%">&nbsp;
				<input type="text" name="p_age" id="p_age" size="1" maxlength="2" onkeypress="return allowPositiveNumber();" value=<%=p_age%>><font color="navy">&nbsp;<fmt:message key="Common.Years.label" bundle="${common_labels}"/></font>
						<%}
					else
					{%>
				<td width="13%">&nbsp;
				<input type="text" name="p_age" id="p_age" size="1" maxlength="2" onkeypress="return allowPositiveNumber();"><font color="navy">&nbsp;<fmt:message key="Common.Years.label" bundle="${common_labels}"/></font>
					<%}%>
				<td class="label" width="20%"><fmt:message key="eRS.EmplStatus.label" bundle="${rs_labels}"/></td>
					<%if(p_mode.equals("call"))
				{%>
					<td >&nbsp;
					<select name="p_empl_status" id="p_empl_status">
					<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<option value='A'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="eRS.FullTime.label" bundle="${rs_labels}"/> </option>
						<option value='P'><fmt:message key="eRS.PartTime.label" bundle="${rs_labels}"/></option >
						<option value='V'><fmt:message key="eRS.Visitor.label" bundle="${rs_labels}"/></option>
							</select>
						</td>
					<%}
					else
					{%>
				<td>&nbsp;
					<select name="p_empl_status" id="p_empl_status">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="A"><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></option>
						<option value="F"><fmt:message key="eRS.FullTime.label" bundle="${rs_labels}"/></option>
						<option value="P"><fmt:message key="eRS.PartTime.label" bundle="${rs_labels}"/></option>
						<option value="V"><fmt:message key="eRS.Visitor.label" bundle="${rs_labels}"/></option>
					</select>
				</td>
						<%}%>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td class="label" width="5%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<%if((p_mode.equals("call")) || p_mode!=("call"))
				{%>
				<td>&nbsp;
					<select name="p_facility_id" id="p_facility_id">
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						<%
						for(int i=0;i<facility_list.size();i+=2)
						{
						%>
						<option value='<%=facility_list.get(i)%>'><%= (String)facility_list.get(i+1)%> </option>
						<%
						}
						%>
					</select>
						<%}%>
				</td>
				<td class="label" width="5%"><fmt:message key="eRS.Experience.label" bundle="${rs_labels}"/> </td>
				<td  width="13%">&nbsp;
				<input type="text" name="p_ex1" id="p_ex1" size="1" maxlength="2" onkeypress="return allowPositiveNumber();">
					<select name="p_ex2" id="p_ex2">
						<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						<option value="M"><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
						<option value="Y"><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class="label" width="5%"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
				<%if(p_mode.equals("call"))
				{%>
				<td width="18%">&nbsp;
					<input type=text name="p_position_code" id="p_position_code" size=17 maxlength=20 value='<%=p_position_desc%>' onblur='viewPosition("T", p_position_code)'><input type=button class=button value='?' name='position_lookup' id='position_lookup' onclick='viewPosition("B", p_position_code)'>
					<input type=hidden name="position_code" id="position_code" value="<%=p_position_code%>"></td>
				<%}
					else
					{%>
						<td width="18%">&nbsp;
					<input type=text name="p_position_code" id="p_position_code" size=17 maxlength=20 value='' onblur='viewPosition("T", p_position_code)'><input type=button class=button value='?' name='position_lookup' id='position_lookup' onclick='viewPosition("B",p_position_code)'>
					<input type=hidden name="position_code" id="position_code" value=""></td>
					<%}%>
			</tr>
			<tr>
				<td class="label" width="5%"><fmt:message key="eRS.Skill.label" bundle="${rs_labels}"/></td>
				<%if(p_mode.equals("call"))
				{%>
				<td class="label" width="13%">&nbsp;
					<input type=text name="p_skill_code" id="p_skill_code" size=14 maxlength=20 value='<%=p_skill_code%>' onblur='viewSkill("T", p_skill_code);' ><input type=button class=button value='?' name='skill_lookup' id='skill_lookup' onclick='viewSkill("B", p_skill_code);'>
					<input type=hidden name="skill_code" id="skill_code" value=""></td>
				<%}else
				{
				%>
					<td class="label" width="13%">&nbsp;
					<input type=text name="p_skill_code" id="p_skill_code" size=14 maxlength=20 value='' onblur='viewSkill("T", p_skill_code);'><input type=button class=button value='?' name='skill_lookup' id='skill_lookup' onclick='viewSkill("B",p_skill_code);'>
					<input type=hidden name="skill_code" id="skill_code" value=""></td>
					<%}%>
				<td class="label" width="5%"><fmt:message key="eRS.License.label" bundle="${rs_labels}"/></td>
				<%if((p_mode.equals("call")) || p_mode!=("call"))
				{%>
				<td>&nbsp;
					<select name="p_license_code" id="p_license_code">
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
						for(int i=0;i<license_list.size();i+=2)
						{
						%>
						<option value='<%=license_list.get(i)%>'><%= (String)license_list.get(i+1)%> </option>
						<%
						}
						%>
					</select></td>
					<%}%>
				<td class="label" width="5%"><fmt:message key="eRS.Training.label" bundle="${rs_labels}"/></td>
				<%if((p_mode.equals("call")) || p_mode!=("call"))
				{%>
				<td>&nbsp;
					<select name="p_training_code" id="p_training_code">
						<option value=''>-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------ </option>
						<%
						for(int i=0;i<training_list.size();i+=2)
						{
						%>
						<option value='<%=training_list.get(i)%>'><%= (String)training_list.get(i+1)%> </option>
						<%
						}
						%>
					</select></td>
							<%}%>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>	
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='view_staff' onclick='viewStaff()'>
				</td>
			</tr>
			<input type='hidden' name='p_mode' id='p_mode' value=<%=p_mode%>>
			<input type='hidden' name='function_id' id='function_id' value=''>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			</form>
		<input type='hidden' name='p_role_type' id='p_role_type' value='<%=p_role_type%>'>
		
</body>
</html>

