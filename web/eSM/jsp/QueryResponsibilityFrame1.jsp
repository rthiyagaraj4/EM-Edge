<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		function populate_frame2(obj)
		{
			var resp_id = obj.value;
			parent.frames[1].location.href='../../eSM/jsp/QueryResponsibilityFrame2.jsp?resp_id='+resp_id;
		}
		</script>
		<%
			Connection con=null;
			try{
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='FocusFirstElement()'>
	<form name='form1' id='form1'>
		<table border=0 cellspacing=0 cellpadding=0 align=center width='102%'>
			<tr>
				<td class=label width='40%'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name=resp_id onchange='populate_frame2(this)'>
						<option value=''>-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
						<%
						try{
							
							String id = "";
							String dat = "";
							Statement stmt_user=con.createStatement();
							ResultSet rs_user=stmt_user.executeQuery("Select resp_id, resp_name  from sm_resp where Eff_Status = 'E' order by 1");
							if(rs_user!=null)
							{
								while(rs_user.next())
								{
									id=rs_user.getString(1);
									dat=rs_user.getString(2);
									%>
									<option value='<%=id%>'><%=dat%></option>
									<%}
							}
							if(rs_user!=null) rs_user.close();
							if(stmt_user!=null) stmt_user.close();
							
						}
						catch( Exception e){//out.println(e);
							e.printStackTrace();
						}
						%>
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
		</table>
	</form>
</body>
<%
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
finally { 
			ConnectionManager.returnConnection(con,request);
		}
							
%>
</html>

