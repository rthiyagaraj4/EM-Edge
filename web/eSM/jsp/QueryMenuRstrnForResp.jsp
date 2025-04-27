
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
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
		function Changeme(obj)
		{
			
			
			var menu_id="";
			if(obj.value=="F")
			{
				document.forms[0].menu_id.value=parent.frames[0].document.forms[0].menu_id;
				document.forms[0].submenu_id.disabled=false;
				parent.frames[3].location.href='../../eCommon/html/blank.html';
			
			}
			else
			if(obj.value=="M")
			{
				document.forms[0].submenu_id.disabled=true;
				document.forms[0].submenu_id.value="";
				parent.frames[3].location.href='../../eCommon/html/blank.html';
			}
			else // newly added.Thursday, February 04, 2010  18724  Venkat S.
			if(obj.value=="R")
			{
				document.forms[0].submenu_id.disabled=false;
				document.forms[0].menu_id.value=parent.frames[0].document.forms[0].menu_id;
				parent.frames[3].location.href='../../eCommon/html/blank.html';
			}

		}

		function search()
		{
			var resp_id=parent.frames[0].document.forms[0].resp_id.value;
			var menu_id=parent.frames[0].document.forms[0].menu_id.value;
			var option_type=parent.frames[2].document.forms[0].option_type.value;
			var submenu_id=parent.frames[2].document.forms[0].submenu_id.value;
			var menu_name=document.forms[0].name.value;
			parent.frames[3].location.href = '../jsp/AddMenuRstrnForResp.jsp?resp_id='+resp_id+'&menu_id='+menu_id+'&option_type='+option_type+'&submenu_id='+submenu_id+'&name='+menu_name;
		
		}
		</script>
		<%
		request.setCharacterEncoding("UTF-8");
			Connection con=null;
			Statement stmt = null;
			try{
			con = ConnectionManager.getConnection(request);
			ResultSet rs =null;
			stmt	=	con.createStatement();
     		String resp_id=request.getParameter("resp_id");
			String menu_id="";
			String sql_m=" Select menu_id from sm_resp_vw where resp_id='"+resp_id+"'";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_m);
			if(rs!=null)
			{
				while(rs.next())
				{
					menu_id=rs.getString(1);
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();


		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()';>
	<form name='form3' id='form3'>
		<b><fmt:message key="eSM.ExcludeRemoveSubmenuFunction.label" bundle="${sm_labels}"/></b>
		<table align=center width='100%' border=0 cellspacing=0 cellpadding=0>
			<tr>
				<td class=label width='15%'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td >
 					<select name=option_type onchange='Changeme(this)'>
 						<option value=F><fmt:message key="Common.Function.label" bundle="${common_labels}"/></option>
						<option value=M><fmt:message key="eSM.Submenu.label" bundle="${sm_labels}"/></option>
			<option value=R><fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
					</select>&nbsp;
				</td>
				<td class=label><fmt:message key="eSM.Submenu.label" bundle="${sm_labels}"/>&nbsp;&nbsp;</td>
				<td >
					<select name=submenu_id style='width: 200px'>
					<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					<%
					try{
						String sql_s= "Select a.submenu_id, b.menu_name  from sm_menu_dtl a, sm_menu_hdr b  where  (a.menu_id = '"+menu_id+"' or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.subMENU_ID not in ( Select subMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and MENU_ID='"+menu_id+"' and EXCL_RESTRICT_IND='E') order by b.menu_name";
						String id="";
						String dat="";
						String sel="";
						stmt=con.createStatement();
						rs=stmt.executeQuery(sql_s.toString());
						if(rs!=null) 
						{
							while(rs.next())
							{
								id=rs.getString(1);
								dat=rs.getString(2);
								out.println("<option value='"+id+"' "+sel+">"+dat+"</option>");
							}
						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
					}
				catch( Exception e)
					{
						out.println(e);
						e.printStackTrace();
					}
				%>
				</select>&nbsp;
			</td> 
			<td class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='fields'><input type=text name=name onBlur='makeValidQueryCriteria(this)'value='' size=20 maxlength=60></td>
			<td class='fields'><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name=Search onclick='search()'></td>
		</table>
				<input type=hidden name=menu_id value='<%=menu_id%>'>
		</form>
	</body>
<%
	if(stmt!=null) stmt.close();
	}catch(Exception e){
		out.println(e);
		e.printStackTrace();
		}

finally {
		ConnectionManager.returnConnection(con,request);
		}			
%>
</html>

