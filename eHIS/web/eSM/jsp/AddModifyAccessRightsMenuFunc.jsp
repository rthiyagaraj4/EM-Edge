<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title> <fmt:message key="eSM.AccessRightsforMenu.label" bundle="${sm_labels}"/></title>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eSM/js/AccessRightsMenuFunc.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function clearframe()
{
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

function searchCode(obj,target)
{

	var retVal 	= 	new String();
	var dialogHeight= "700px" ;
	var dialogWidth	= "400px" ;
	var status 	= "no";
	var arguments	= "" ;
	var menuVal   = document.AccessRightsMenu_form.Menu.value;
	var moduleVal = document.AccessRightsMenu_form.module.value; 
	var sql		=" select function_id,function_name from sm_menu_dtl_vw ";
	var search_code	="function_id";
	var search_desc	="function_name";		
	var tit="Function Name";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}	
</script>
</head>
<%		
	request.setCharacterEncoding("UTF-8");
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	try{
	
	
	con = ConnectionManager.getConnection(request);
	ResultSet rs=null;
	
	StringBuffer sql1=new StringBuffer();
	StringBuffer sql2=new StringBuffer();
	String menuId   = ""; 
	String menuName = ""; 
	String modId	= "";
	String modName  = ""; 
	/*int Medadmin=0;
	String Log_user= (String) session.getValue("login_user");
	String Menu=request.getParameter("Menu");
	if (Menu==null) Menu="";	
	String module=request.getParameter("module");
	if(module==null)module="";
	stmt=con.createStatement();

	String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";
	rs=stmt.executeQuery(sql);
	if (rs !=null)
	{
		while (rs.next())
			{
					Medadmin=Integer.parseInt(rs.getString(1));
			}
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
if (Medadmin !=0)
	{
		sql1.append("select Menu_id,menu_name from sm_menu_hdr where resp_group_id  in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");		
		sql2.append("select  distinct a.module_id , b.module_name ");
		sql2.append(" from sm_func_by_resp_grp  a, sm_module b ");
		sql2.append(" where a.resp_group_id in (select  resp_group_id  from sm_menu_admin where menu_admin_id='"+Log_user+"')");
		sql2.append(" and a.module_id=b.module_id ");
		sql2.append(" order by b.module_name");		

	}
	else
	{*/
	
		sql1.append("select Menu_id,menu_name from sm_menu_hdr order by menu_name");
		sql2.append("select Module_id,module_name from sm_module where install_yn = 'Y' order by module_name");	

	//} 

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='FocusFirstElement()'>
<form name="AccessRightsMenu_form" id="AccessRightsMenu_form">
<br>
<table width='100%' cellpadding='0' cellspacing='0' align='center'>
	<tr>
		<td width='25%' colspan=4>&nbsp;</td>
		<td width='25%' ></td>
		<td width='25%' ></td>
		<td width='25%' ></td>
	</tr>
	<tr>
		<td class= "label" width='25%'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name="Menu" id="Menu" onchange='clearframe()'>
				<option value = "">--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------
				<%
					pstmt=con.prepareStatement(sql1.toString());
					rs = pstmt.executeQuery();
					String sel="";
					if(rs!=null)
					{
						while(rs.next())
						{
							menuId	 = rs.getString("Menu_id");
							menuName = rs.getString("menu_name");
							if(menuId.equals("Menu"))
							sel="selected";
							out.println("<option value='"+menuId+"'"+sel+">"+menuName+"</option>");
						}
					}
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				%>		
			</select><img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><select name="module" id="module" >
			<option value = "">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
			<%
	

				pstmt=con.prepareStatement(sql2.toString());
				rs = pstmt.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						modId	 = rs.getString("module_id");
						modName = rs.getString("module_name");
						out.println("<option value='"+modId+ "' >"+modName);
					}
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			%>		
		</select>
	</td>
	</tr>
	<tr>
		<td width='25%' colspan=4>&nbsp;</td>
		<td width='25%' ></td>
		<td width='25%' ></td>
		<td width='25%' ></td>
	</tr>
	<tr>
	
		<td class='label' width='25%'><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<input type="text" name="functionName" id="functionName"onBlur='makeValidQueryCriteria(this)' size=30 maxlength=30>

		</td>
        <td width='25%' ></td>
		<td class="fields">
			<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='PopVal()' >
			<input type='button' name='Clear' id='Clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearVal()' >
		</td>
	 
	</tr>
</table>
</form>
</body>
<%
	
	if(stmt != null) stmt.close();
}catch(Exception e){out.println(e);}
			finally {
	ConnectionManager.returnConnection(con,request);
}			
%>
</html>

