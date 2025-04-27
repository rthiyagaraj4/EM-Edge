<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eSM/js/FreqAccessFunc.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	Connection conn=null;
			try{
			request.setCharacterEncoding("UTF-8");
			conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;
	
	Statement stmt = conn.createStatement();
	PreparedStatement pstmt = null;
	
	String responsibility_id= (String) session.getValue("responsibility_id");
	
	String submenu_id="";
	
	String menu_id=request.getParameter("menu_id");
	menu_id=menu_id.trim();
	StringBuffer sql_s=new StringBuffer();
	
	sql_s.append(" Select a.submenu_id, b.menu_name ");
    sql_s.append(" from sm_menu_dtl a, sm_menu_hdr b ");
	//sql_s.append(" where  (a.menu_id = '"+menu_id+"' or  ");
    sql_s.append(" where  (a.menu_id = ? or  ");
	//sql_s.append(" a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) ");
	sql_s.append(" a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ?) ) ");
	sql_s.append("  and a.submenu_id = b.menu_id  and a.submenu_id is not null  ");
	sql_s.append(" and a.MENU_ID not in ( ");
	sql_s.append(" Select MENU_ID from SM_MENU_RSTRN_RESP_VW ");
	//sql_s.append(" where RESP_ID='"+responsibility_id+"' and ");
	sql_s.append(" where RESP_ID=? and ");
	//sql_s.append(" MENU_ID='"+menu_id+"' )  ");
	sql_s.append(" MENU_ID=? )  ");
	sql_s.append(" order by b.menu_name  ");
										
try
{
%>
<script>
function callFunction()
{
	var submenu=document.forms[0].Menu.value;
	var Function_name=document.forms[0].Function_name.value;
	var menu_id=document.forms[0].menu_id.value;
	parent.frames[2].location.href='../../eSM/jsp/FreqAccessFunctionList.jsp?menu_id='+menu_id+'&submenu_id='+submenu+'&Function_name='+Function_name;
}
function clearme()
{
	document.forms[0].Function_name.value='';
	document.forms[0].Menu.value="";
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}
</script>
<body onMouseDown="CodeArrest()"
onKeyDown = 'lockKey()'>
<form name='search_func' id='search_func'   >
<table border="0" align='center' width="102%" cellspacing='0' cellpadding='0'>
<th align='left' colspan='5'><fmt:message key="Common.AvailableFunctions.label" bundle="${common_labels}"/></th>
<tr>
	 <td class=label><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
     <td ><input type='text' name='Function_name' id='Function_name' size='20' maxlength='30' value='' >&nbsp;</td>
 	 <td class="label" width='10%'><fmt:message key="Common.SubMenu.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	 <td >
		<Select name="Menu" id="Menu">
			<Option value="">&nbsp;------------- ------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------- ---------------&nbsp;
			<%
			try {
					//rs=stmt.executeQuery(sql_s.toString());
					pstmt   = conn.prepareStatement(sql_s.toString());
					pstmt.setString	(	1,	menu_id		);
					pstmt.setString	(	2,	menu_id		);
					pstmt.setString	(	3,	responsibility_id		);
					pstmt.setString	(	4,	menu_id		);
					rs		 = pstmt.executeQuery();
					if(rs!=null) 
					{
						while(rs.next()) 
						{
							submenu_id=rs.getString("submenu_id")==null ? "" : rs.getString("submenu_id");
							String menu_name=rs.getString("menu_name")==null ? "" : rs.getString("menu_name");
							out.println("<Option value='" + submenu_id + "'>" + menu_name);
						}
					}
					}catch(Exception e) {}
					%>
				</Select></td>
		<td  width='20%'><input class='button'  type='button' name='Search' id='Search' onClick='callFunction();'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' >  <input type='button' class='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearme()' ></td>
	</tr>
	</table> 
			<input type=hidden name=menu_id id=menu_id value='<%=menu_id%>'>
<%
}
catch ( Exception e ){ out.println("Exception "+e);}
finally{
	if ( stmt != null ) stmt.close() ;
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	}
	}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>

