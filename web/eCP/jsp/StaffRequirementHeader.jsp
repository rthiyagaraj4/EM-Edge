<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>		
		<script language='javascript' src='../../eCommon/js/messages.js' ></script>
		<script language="javascript" src="../js/CpMessages.js"></script>  
			  <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<script language="JavaScript" src="../../eCP/js/StaffRequirement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>
		function hello(form)
	  {
	
			var a=document.forms[0].workplace_code.value;
		
					removeitems(form.shift_code);
	
			var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eCP/jsp/StaffRequirementIntermediate.jsp'>";
					HTMLVal = HTMLVal +"<input name='workplace_code' id='workplace_code' type='hidden' value= '"+a +"'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";
					parent.parent.messageFrame.document.write(HTMLVal);
					parent.parent.messageFrame.document.forms[0].submit();

	  }



		function removeitems(obj)
			{
				var len=obj.length;
				var i=1;
				while(i<len)
				{
					len=obj.length
					obj.remove(i)
				}
			}


		
		

		</script>

</head>
<%
String dependency_sql="";
Vector dependency_list=new Vector();
Connection conn=null;
Statement dependency_stmt=null;
ResultSet dependency_rs=null;
String facility_id=(String)session.getValue("facility_id");

try
{
	
conn=ConnectionManager.getConnection();

dependency_sql="Select dependency_code,long_desc from cp_dependency where eff_status='E' order by long_desc";
dependency_stmt=conn.createStatement();
dependency_rs=dependency_stmt.executeQuery(dependency_sql);
while(dependency_rs.next())
	{
	
		dependency_list.add(dependency_rs.getString("dependency_code"));
		dependency_list.add(dependency_rs.getString("long_desc"));
	}



}catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
finally
{
	if(dependency_rs!=null) dependency_rs.close();
	if(dependency_stmt!=null) dependency_stmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}%>

<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=form_add_mod>
		<table border='0' cellspacing='0' cellpadding='0' align='center' width='98%'>
			<tr>
				<td align='right' class='label'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>
				<td align="left" colspan="5">&nbsp;&nbsp;
					<select name='dependency_code' id='dependency_code'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%for(int i=0;i<dependency_list.size();i+=2)
						{%>
						<option value='<%=dependency_list.get(i)%>'><%= (String)dependency_list.get(i+1)%> </option>
						<%}%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
				</td>
			</tr>
			 <tr>
				<td  align=right class="label"><fmt:message key="Common.Workplace.label" bundle="${common_labels}"/></td>
				<td align='left' colspan="5"> &nbsp;&nbsp;
					<input type=text name="workplace_desc" id="workplace_desc" value="" size='30' maxlength='30'  onblur='hello(this.form)'  readonly><input class='button' type=button name="workplace_button" id="workplace_button" value="?"  onClick='viewAgeGroup1(workplace_desc,facility_id);hello(this.form)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="workplace_code" id="workplace_code" value="" >	
				</td>
			</tr>
			 <tr>
				<td align='right' class='label'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
				<td align="left">&nbsp;&nbsp;
					<select name='shift_code' id='shift_code' onChange='ChangeType(this.form,this);display(start_time,end_time)'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<input type="hidden" name="start_time1" id="start_time1" value="">
					<input type="hidden" name="end_time1" id="end_time1" value="" >
					</select><img src="../../eCommon/images/mandatory.gif"></img>
				<td align="right" class="label"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
				<td align="left"  id='start_time' class="data"><B></B></td>
				<td align="right" class="label" class="data"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
				<td align="left" id='end_time' class="data"><B></B></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'></td>
			</tr>

		</table>

			<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
			
	</form>
</body>
</html>


