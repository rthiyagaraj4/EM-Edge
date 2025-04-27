<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

	<script language="JavaScript">
		var expand = "";
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='ECMENUHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}

		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val,count_record_role,count_record_admin)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
		
			if(val == 'CREATE_MENU'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/MenuHeader.jsp?module_id=SM&function_id=MENU_HDR&function_name='+encodeURIComponent(getLabel('eSM.CreateMenu.label','SM'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}
			}

			if(val == 'CONSTRUCT_MENU'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/menuDetail.jsp?module_id=SM&function_id=CONSTRUCT_MENU&function_name='+encodeURIComponent(getLabel('eSM.ConstructMenu.label','SM'))+'&function_type=F&access=YYNNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}

			if(val == 'ACCESS_RIGHTS_FOR_MENU_FUNCTIONS'){
				if(count_record_role>=1 || count_record_admin>=1){
				parent.frames[1].location.href = '../../eSM/jsp/AccessRightsMenuFunc.jsp?module_id=SM&function_id=ACCESS_RIGHTS_MENU_FUNC&function_name='+encodeURIComponent(getLabel('eSM.AccessRightsForMenuFunctions.label','SM'))+'&function_type=F&access=NYNNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}
			}

			if(val == 'RESPONSIBILITY'){
				if(count_record_role>=1 || count_record_admin>=1){			
				parent.frames[1].location.href = '../../eSM/jsp/Responsibility.jsp?module_id=SM&function_id=SM_RESP&function_name='+encodeURIComponent(getLabel('Common.responsibility.label','Common'))+'&function_type=F&access=YYYNN';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}
		
			if(val == 'MENU_RESTRICTION_FOR_RESPONSIBILITY'){
				if(count_record_role>=1 || count_record_admin>=1 ){
				parent.frames[1].location.href = '../../eSM/jsp/AddModifyMenuRstrnForResp.jsp?module_id=SM&function_id=MENU_RSTRN_FOR_RESP&function_name='+encodeURIComponent(getLabel('eSM.MenuRestrictionforResponsibility.label','SM'))+'&function_type=F&access=YYNNY';
				}
				else{
				var error=getMessage('MENU_ADMIN_ACCESS','SM');
				alert(error);
				}

			}
		}
		
		function refreshPage()
		{
			parent.frames[0].location.href='../../eSM/jsp/SM_Menu_Admin_Setup_UM.jsp?expand='+expand
		}
		
		function chkRow( ro,val,exp )
		{
//			var E =expand.charAt(0)
			var A =expand
			if( val == "A"  )
			{
				 if( exp =="E" )
				{
					 A= "C"
				}
				else
				{
					A = "E";
				}
			}
			expand = A ;
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<% 
   request.setCharacterEncoding("UTF-8");
String expand=request.getParameter("expand");
if( expand == null) expand="C";

//if( expand == null) expand="C";
String responsibility_id= (String) session.getAttribute("responsibility_id");
String Log_user= (String)session.getAttribute("login_user");
Connection con=null;
ResultSet rs=null;
Statement stmt=null;
int count_record_role=0;
int count_record_admin=0;
try{
	con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
		String sqlRole ="select count(1) from sm_resp  where ora_role_id='MEDADMIN' and resp_id='"+responsibility_id+"' ";
		rs=stmt.executeQuery(sqlRole);
		if (rs !=null){
			while (rs.next()){
				count_record_role=rs.getInt(1);					
			}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}	


		String sql_admin="select count(1) from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
		stmt = con.createStatement();
		rs=stmt.executeQuery(sql_admin);
			if (rs !=null){
				while (rs.next()){
					count_record_admin=rs.getInt(1);	
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				}

	}
	catch(Exception e){out.println(e);}
	finally { 
    if(stmt !=null) stmt.close();
	if(rs !=null) rs.close();
	ConnectionManager.returnConnection(con,request);
	}

%>
	<body style="background-color:dimgray;" onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="SMMasterMenu_form" id="SMMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='111%' border=0 id='t'>
	<tr onclick = "chkRow(this,'A','<%=expand %>')">
			<% if(expand.equals("E")) { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >-<fmt:message key="eSM.ApplicationSecurity.label" bundle="${sm_labels}"/></a></td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >+<fmt:message key="eSM.ApplicationSecurity.label" bundle="${sm_labels}"/></a></td>
			<% } %>
			
		</tr>
		
		<% if(expand.equals("E")) { %>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("CREATE_MENU",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;<fmt:message key="eSM.CreateMenu.label" bundle="${sm_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("CONSTRUCT_MENU",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;<fmt:message key="eSM.ConstructMenu.label" bundle="${sm_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("ACCESS_RIGHTS_FOR_MENU_FUNCTIONS",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;<fmt:message key="eSM.AccessRightsForMenuFunctions.label" bundle="${sm_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("RESPONSIBILITY",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;<fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
		</tr>	
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onclick='javascript:callJSPs("MENU_RESTRICTION_FOR_RESPONSIBILITY",<%=count_record_role%>,<%=count_record_admin%>)' >&nbsp;&nbsp;<fmt:message key="eSM.MenuRestrictionforResponsibility.label" bundle="${sm_labels}"/>
</td>
		</tr>	
		<% } %>
		<tr >
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>
		</table>

	</body>
	
	</form>
</html>

