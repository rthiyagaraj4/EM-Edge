<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>

  		function search1()
		{
		if(parent.frames[0].document.forms[0].resp_group_id.value!="")
			{
				var module_id=document.forms[0].module_id.value;
				var function_name=document.forms[0].function_name.value;
				var resp_group_id=parent.frames[0].document.forms[0].resp_group_id.value;
				
				parent.frames[4].location.href ='../jsp/AddFuncForRespGrp.jsp?module_id='+module_id+'&function_name='+function_name+'&resp_group_id='+resp_group_id+'&headeryn=Y'; 
				parent.frames[5].location.href = '../jsp/AddFuncForRespGrp.jsp?module_id='+module_id+'&function_name='+function_name+'&resp_group_id='+resp_group_id;
			}
		}
		
		function clearframe()
		{
		//	parent.frames[2].location.reload();
			parent.frames[4].location.href='../../eCommon/html/blank.html';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			document.forms[0].function_name.value='';
	        document.forms[0].module_id.value="";
		}

		function clearVal()
		{
		
		parent.frames[4].location.href='../../eCommon/html/blank.html';
		parent.frames[5].location.href='../../eCommon/html/blank.html';
			
		

		}
		</script>
		<%

			Connection con=null;
			Statement stmt_resp = null;
			try{
	        request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			String resp_group_id="";
			String function_name="";
			

		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()';>
	<form name='form3' id='form3'>
		<b><fmt:message key="eSM.AddNewFunctions.label" bundle="${sm_labels}"/></b><BR>
		<table align=center width='100%' border=0 cellspacing=0 cellpadding=0>
			<tr>
				<td class=label width="25%"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name=module_id id=module_id onChange='clearVal()' >
						<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
						<%
						try{
							String sql_resp="Select module_id, module_name  from sm_module where install_yn='Y'order by 2 ";
							String id = "";
							String dat = "";
							String sel = "";
							stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									if(id.equals(resp_group_id))
										sel="selected";
									%>
									<option value='<%=id%>'<%=sel%>><%=dat%></option>
									<%
									sel = "";
								}
							}
							if(rs_resp!=null)rs_resp.close();
							if(stmt_resp!=null)stmt_resp.close();
						}
						catch( Exception e){out.println(e);}
						%>
					</select>
					&nbsp;
				</td>
				<td class=label><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name='function_name' id='function_name' onBlur='makeValidQueryCriteria(this)'value="<%=function_name%>" size=25 maxlength=60></td>
				<td ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='search1()'></td>
				<td ><input type='button' name='Clear' id='Clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearframe()'></td>
		</table>
		</form>
	</body>
</html>
<%

}catch(Exception e){out.println(e);}
finally {
		ConnectionManager.returnConnection(con,request);
}					
%>

