<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page 
contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
request.setCharacterEncoding("UTF-8");	
 String mode = (String)request.getParameter("mode");
 String persFrom=request.getParameter("persFrom")==null?"":request.getParameter("persFrom");
 	 String locale = (String)session.getAttribute("LOCALE");
 if(mode.equals("update")){
	 String sName= request.getParameter("sName");
	 String applUser = (String)session.getAttribute("login_user") ;

	Connection con = ConnectionManager.getConnection() ;
	String sql = "update sm_appl_user set preferred_style = ? where appl_user_id = ?" ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1,sName) ;
	pstmt.setString(2,applUser) ;
	if(pstmt.executeUpdate()!=0) {
			session.setAttribute("PREFERRED_STYLE",sName) ;
	%>
	<SCRIPT>

		//top.location.href=top.location.href;
		if('<%=persFrom%>'=='HomeSummary'){				
			/*
			top.frames[0].location.href=top.frames[0].location.href;			
			top.frames[2].frames[0].location.href=top.frames[2].frames[0].location.href;
			top.frames[2].frames[1].location.href=top.frames[2].frames[1].location.href;
			*/

			top.frames[0].location.reload();			
			top.frames[2].frames[0].location.reload();
			top.frames[2].frames[1].location.reload();
		} else {
			top.location.href=top.location.href
		}
		/*top.header.location.reload();
		top.menucontent.location.href="FloatMenu.jsp";
		top.menucontent.changeSize('515','130');
		top.menucontent.freAccMenuFr.location.href="PersonalizeList.jsp";
		top.menucontent.freAccMenuFr.location.reload();
		top.content.location.href="personoliseTheme.jsp?mode=view";*/
	</SCRIPT>
	<%
	}
	con.commit();
	pstmt.close();
	ConnectionManager.returnConnection(con) ;
 }


// String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/themeSelectionPage/css/style.css'></link>
<script>
function selectThemeFunction(obj){
	var	isBruLang	= "";
	if(document.forms[0].locale.value=="bu"){
		isBruLang	= "_bu";
	}
	if(obj=="1"){
		location.href="personoliseTheme.jsp?mode=update&sName=IeStyle"+isBruLang+".css&persFrom=<%=persFrom%>";
	}else if(obj=="2"){
		location.href="personoliseTheme.jsp?mode=update&sName=IeStyleBlue"+isBruLang+".css&persFrom=<%=persFrom%>";		
	}else if(obj=="3"){
		location.href="personoliseTheme.jsp?mode=update&sName=IeStyleLime"+isBruLang+".css&persFrom=<%=persFrom%>";
	}else if(obj=="4"){
		location.href="personoliseTheme.jsp?mode=update&sName=IeStyleOrange"+isBruLang+".css&persFrom=<%=persFrom%>";
	}else if(obj=="5"){
		location.href="personoliseTheme.jsp?mode=update&sName=IeStyleVoilet"+isBruLang+".css&persFrom=<%=persFrom%>";
	}
}
</script>
</HEAD>

<BODY onKeyDown = 'lockKey()' >
<form name="Personalise_themes" id="Personalise_themes">
<%
	 if(mode.equals("view")) {
	 %>
			<input type='hidden' name="locale" id="locale" value="<%=locale%>" />	
			<table width="100%" height=100%> <tr> <td valign="middle" align="center">
				<TABLE align="center" valign="middle" border=0  cellpadding=0>
				<TR>
					<TD align="center" class=white >	<table >
		<tr>
			<td class="pageTitle" colspan=2>
				Choose a theme:
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td class="themeName">
							Amazon
						</td>
					<tr>
					<tr>
						<td>
							<img src="../../eCommon/themeSelectionPage/images/defaultTheme.jpg">
						</td>
					<tr>
					<tr>
						<td>
							<button type="button" onclick="selectThemeFunction('1')"><fmt:message key="Common.apply.label" bundle="${common_labels}"/></button>
						</td>
					<tr>
				</table>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td class="themeName">
							Classic Blue
						</td>
					<tr>
					<tr>
						<td>
							<img src="../../eCommon/themeSelectionPage/images/blueTheme.jpg">
						</td>
					<tr>
					<tr>
						<td>
							<button type="button" onclick="selectThemeFunction('2')"><fmt:message key="Common.apply.label" bundle="${common_labels}"/></button>
						</td>
					<tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td class="themeName">
							Mystic Green
						</td>
					<tr>
					<tr>
						<td>
							<img src="../../eCommon/themeSelectionPage/images/greenTheme.jpg">
						</td>
					<tr>
					<tr>
						<td>
							<button type="button" onclick="selectThemeFunction('3')"><fmt:message key="Common.apply.label" bundle="${common_labels}"/></button>
						</td>
					<tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td class="themeName">
							Rich Gold
						</td>
					<tr>
					<tr>
						<td>
							<img src="../../eCommon/themeSelectionPage/images/orangeTheme.jpg">
						</td>
					<tr>
					<tr>
						<td>
							<button type="button" onclick="selectThemeFunction('4')"><fmt:message key="Common.apply.label" bundle="${common_labels}"/></button>
						</td>
					<tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td class="themeName">
							Cool Violet
						</td>
					<tr>
					<tr>
						<td>
							<img src="../../eCommon/themeSelectionPage/images/magentaTheme.jpg">
						</td>
					<tr>
					<tr>
						<td>
							<button type="button" onclick="selectThemeFunction('5')"><fmt:message key="Common.apply.label" bundle="${common_labels}"/></button>
						</td>
					<tr>
				</table>
			</td>
		</tr>
	</table> </td> </tr> </table>
		 <%
	 }
%>
</form>
</BODY>
</HTML>

