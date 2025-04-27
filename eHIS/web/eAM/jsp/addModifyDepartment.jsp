<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>

  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAM/js/Department.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>

  <body onLoad="FocusFirstElement()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String deptcode="",longdesc="",shortdesc="",effstatus="",codeTextAttribute="",otherTextAttribute="",checkBoxAttribute="",eventFunctionForCase="",sql="",prefix_facl_id_for_int_yn="",facilityID = "",acc_entity_id = "",acc_entity_desc="";
	
	boolean newDepartment=false;
	
	%>
	<%
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		facilityID = (String) session.getValue("facility_id");
		deptcode=request.getParameter("dept_code");
		if(deptcode==null)
		{
			deptcode="";
			longdesc="";
			shortdesc="";
			effstatus="E";
			codeTextAttribute="";
			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
			newDepartment=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}
		else
		{
		 	   		
				
				sql = "select acc_entity_id, dept_code,long_desc,short_desc,eff_status from am_dept where dept_code=? ";
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	deptcode);

				rset		 = pstmt.executeQuery();
				if(rset !=null && rset.next())
			{
				deptcode=rset.getString("dept_code");
				longdesc=rset.getString("long_desc");
				shortdesc=rset.getString("short_desc");
				acc_entity_id = rset.getString("acc_entity_id");
				if (acc_entity_id==null) acc_entity_id = "";
					effstatus=rset.getString("eff_status");
			}
				if(effstatus.equals("D")){
					otherTextAttribute="READONLY";
					checkBoxAttribute="";
				}
				else
				{
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}
				if (rset!=null) rset.close();
				if (pstmt!=null) pstmt.close();
				
				pstmt = null;
				sql = "select accounting_name_short from sm_acc_entity_param where acc_entity_id=? ";
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	acc_entity_id);

				rset		 = pstmt.executeQuery();
				if (rset.next())
				{
					acc_entity_desc = rset.getString(1);
					if (acc_entity_desc==null) acc_entity_desc = "";
				}

			 
		codeTextAttribute="READONLY";
		newDepartment=false;
		eventFunctionForCase="";
	}

		%>
		<form name='Department_form' id='Department_form' action='../../servlet/eAM.DepartmentServlet' method='post' target='messageFrame'>
		<div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
		<tr class="label">
			<td width='10%' class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td width='10%' class="label">&nbsp;</td>
		</tr>
		<tr>
			<td class="label">&nbsp;</td>
			<td  class='label'><fmt:message key="Common.AccountingEntity.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<% if (newDepartment) {%>
<!-- 			<select name='acc_entity' id='acc_entity' onChange="document.forms[0].dept_code.value='';" onBlur='parent.getPrefixFacility()'> -->
			<select name='acc_entity' id='acc_entity' onChange="" onBlur='parent.getPrefixFacility()'>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
				int cnt=0;
			if(rset !=null) rset.close();
				rset=stmt.executeQuery("Select prefix_facl_id_for_int_yn, dept_code_length,  accounting_name_short,acc_entity_id from SM_ACC_ENTITY_PARAM order by 1");
				while(rset.next())
				{
					String short_name = rset.getString("accounting_name_short");
					String ID = rset.getString("acc_entity_id");
					int dept_code_length = rset.getInt("dept_code_length");
					prefix_facl_id_for_int_yn = rset.getString("prefix_facl_id_for_int_yn");
					out.println("<option value=\""+ID+ "\" selected>"+short_name+"</option>");		out.println("<script>parent.prefix_facility_yn[i]='"+prefix_facl_id_for_int_yn+"'; parent.dept_code_length[i]="+dept_code_length+"; i++; </script>") ;
					cnt++;
				}
				if (cnt>1)
				{
					out.println("<script>document.forms[0].acc_entity.value='';</script>");
				}					
			%></select>
			<%}
			else
			{%>
			<input type='text' readOnly name='acc_entity_desc' id='acc_entity_desc' size=30 value="<%=acc_entity_desc%>">
			<input type = 'hidden' name='acc_entity' id='acc_entity' value="<%=acc_entity_id%>">
			<%}%><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class="label">&nbsp;</td>
			</tr>
			<tr class="label">
				<td colspan='4' class="label">&nbsp;</td>
			</tr>
			<tr>
				<td class="label">&nbsp;</td>
				<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class="fields">
				<input type='text' name='dept_code' id='dept_code' value="<%=deptcode%>" onKeyPress="return CheckForSpecChars(event)"  size='10' maxlength='10' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td class="label">&nbsp;</td>
			</tr>
			<tr class="label">
				<td colspan='4' class="label">&nbsp;</td>
			</tr>
			<tr>
				<td class="label">&nbsp;</td>
				<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class="fields">
				<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur="makeValidString(this)" value="<%=longdesc%>" <%=otherTextAttribute%> >
				<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td class="label">&nbsp;</td>
			</tr>
			<tr class="label">
				<td colspan='4' class="label">&nbsp;</td>
			</tr>
			<tr>
				<td class="label">&nbsp;</td>
				<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td class="fields">
				<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" onBlur="makeValidString(this)" <%=otherTextAttribute%> >
				<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td class="label">&nbsp;</td>
			</tr>
			<tr class="label">
				<td colspan='4' class="label">&nbsp;</td>
			</tr>
			<tr>
				 <td class="label">&nbsp;</td>
				 <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				 <td class='fields'>
				 <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
				 <td class="label">&nbsp;</td>
			</tr>
			<tr class="label">
					<td colspan='4' class="label">&nbsp;</td>
			</tr>
		</table>
		</div>
		<%  if(newDepartment){%>

		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		

		<%}else{%>

		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		

		<%
			}
		%><input type='hidden' name='facilityID' id='facilityID' value='<%=facilityID%>'><%
	}				
	catch(Exception e)
	{}
	finally
	{
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}

	%>
	</form>
</body>
</html>

