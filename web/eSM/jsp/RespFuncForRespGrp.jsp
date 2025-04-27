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
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		function populate_frame(obj)
		{
			if(obj.value!=='')
			{
			var resp_group_id = obj.value;
			parent.frames[1].location.href = '../jsp/RemoveFuncForRespGrp.jsp?resp_group_id'+resp_group_id+'&headeryn=Y'		
			parent.frames[2].location.href = '../jsp/RemoveFuncForRespGrp.jsp?resp_group_id='+resp_group_id;
			parent.frames[3].location.href='../../eSM/jsp/QueryFuncForRespGrp.jsp';
			parent.frames[4].location.href='../../eCommon/html/blank.html';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
			}
			else
			{
			parent.frames[1].location.href = '../../eCommon/html/blank.html';	
			parent.frames[2].location.href ='../../eCommon/html/blank.html';
			parent.frames[3].location.href='../../eSM/jsp/QueryFuncForRespGrp.jsp';
			parent.frames[4].location.href='../../eCommon/html/blank.html';
			parent.frames[5].location.href='../../eCommon/html/blank.html';
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
			}
		}
		</script>
		<%
			request.setCharacterEncoding("UTF-8");
			Connection con=null;
			Statement stmt_resp = null;
			try{
			con = ConnectionManager.getConnection(request);
			String resp_group_id="";
		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='FocusFirstElement()'>
	<form name='form1' id='form1'>
		<table align=center width='102%' border=0 cellspacing=0 cellpadding=0>
			<tr>
				<td class=label width='25%'><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></td>
				<td class='fields' width='25%'>
					<select name='resp_group_id' id='resp_group_id' onchange='populate_frame(this)'>
						<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
						<%
						try{
							String sql_resp="Select resp_group_id, resp_group_name  from sm_resp_grp where eff_status='E' order by 2";
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
					</select><img src='../../eCommon/images/mandatory.gif'></img><td width='25%'></td><td width='25%'></td>
				</td>
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

