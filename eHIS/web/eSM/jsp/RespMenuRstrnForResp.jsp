

<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<script>
		
		function CallRemove()
		{
			var resp_id=document.forms[0].resp_id.value;
			parent.frames[1].document.location.href='../jsp/RemoveMenuRstrnForResp.jsp?resp_id='+resp_id;
			parent.frames[2].document.location.href ='../jsp/QueryMenuRstrnForResp.jsp?resp_id='+resp_id;
			parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
		}
		function populate_menu_name(obj)
		{
			if(obj.value !='')
			{
			var resp_id = obj.value;
			var htmlText = "";
			htmlText+="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head>";
			htmlText+="<body class='message' onKeyDown = 'lockKey()'>";
			htmlText+="<form name='dummyform' id='dummyform' method='post' action='../jsp/GetMenuForResp.jsp'>";
			htmlText+="<input type=hidden name='menu_id' id='menu_id' value='"+document.forms[0].menu_id.value+"'>";
			htmlText+="<input type=hidden name='resp_id' id='resp_id' value='"+resp_id+"'>";
			htmlText+="</form>";
			htmlText+="</body>";
			htmlText+="</html>";
			parent.parent.messageFrame.document.write(htmlText);
			parent.parent.messageFrame.document.forms[0].submit();
			CallRemove();
			}
			else
			{
			document.getElementById('menu_name').innerText="";
			document.getElementById('menudisp').innerText="";
			parent.frames[1].document.location.href ='../../eCommon/html/blank.html';
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
			parent.frames[3].document.location.href ='../../eCommon/html/blank.html';
			}
		}
		</script>
		<%
			Connection con=null;
			//Statement stmt=null;
			Statement stmt_resp=null;
			try{
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			String resp_id=request.getParameter("resp_id");
			if (resp_id==null) resp_id="";
			String menu_id=request.getParameter("menu_id");
			if (menu_id==null) menu_id="";
			String menu_name=request.getParameter("menu_name");
			if (menu_name==null) menu_name="";
			String sql_resp="";
		/*	String Log_user= (String) session.getValue("login_user");
			ResultSet rset=null ;
			int Medadmin=0;
			stmt=con.createStatement();
			String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	

			rset=stmt.executeQuery(sql);
			if (rset !=null)
			{
				while (rset.next())
				{
					Medadmin=Integer.parseInt(rset.getString(1));
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();

		if (Medadmin >0   ) 
		{
			sql_resp="Select resp_id, resp_name,menu_id  from sm_resp where eff_status='E' and resp_group_id in ( select  resp_group_id from sm_menu_admin where menu_admin_id='"+Log_user+"') order by 2 ";
		}
		else 
		{*/
			sql_resp="Select resp_id, resp_name,menu_id  from sm_resp where eff_status='E' order by 2 ";
		//}

		%>
	</head>
	<body  onKeyDown = 'lockKey()';  onload='FocusFirstElement()'>
	<form name='form1' id='form1'>
		<table border=0 cellspacing=0 cellpadding=0 align=center width='102%'>
			<tr>
				<td class="label"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name='resp_id' id='resp_id' onchange='populate_menu_name(this)'>
						<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						<%
						try{
							
							String id = "";
							String dat = "";
							//String dat1 = "";
							String sel = "";
							stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
								
									if(id.equals(resp_id))
										sel="selected";
									out.println("<option value='"+id+"'"+sel+">"+dat+"</option>");
									sel = "";
								}
							}
							if(rs_resp!=null)rs_resp.close();
							if(stmt_resp!=null)stmt_resp.close();
						}
						catch( Exception e){out.println(e);}
						%>
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				</tr>
				<tr><td colspan='2'>&nbsp;</td></tr>
				<tr>
				<td class=label  id='menudisp' >&nbsp;&nbsp;</td>
				<td id='menu_name' nowrap  class='queryData' ><%=menu_name%></td>
			</tr>
						</tr>
		</table>
		<input type=hidden name='menu_id' id='menu_id' value='<%=menu_id%>'>
		</form>
	</body>
<%
			if(stmt_resp!=null) stmt_resp.close();
			//if(stmt!=null) stmt.close();
			
}catch(Exception e){out.println(e);}
	finally {
		ConnectionManager.returnConnection(con,request);
}
		
%>
</html>

