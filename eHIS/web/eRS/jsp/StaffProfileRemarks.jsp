<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name       :	StaffProfileRemarks.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmi
*	Created On		:	26-10-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%String title=request.getParameter("title"); %>
<html>
<head>
<title><%=title%><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../js/StaffProfile.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
Connection Con			= null;
PreparedStatement pstmt = null;
ResultSet rslRst		= null;

String role_type	 = request.getParameter("role_type")==null?"":request.getParameter("role_type");
String staff_id = request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
String trng_code = request.getParameter("trng_code")==null?"":request.getParameter("trng_code");
String lic_code = request.getParameter("lic_code")==null?"":request.getParameter("lic_code");;
String expr_no = request.getParameter("expr_no")==null?"":request.getParameter("expr_no");

String Sql			="";
String remarks		="";
try{
	Con=ConnectionManager.getConnection();
	if(!(trng_code.equalsIgnoreCase(""))){
	
	Sql="SELECT remarks FROM rs_staff_training WHERE role_type= ? AND staff_id= ? AND training_code=?";
	pstmt=Con.prepareStatement(Sql);
	pstmt.setString( 1,role_type.trim());
	pstmt.setString( 2,staff_id.trim());
	pstmt.setString( 3,trng_code.trim());
	rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			remarks=rslRst.getString("remarks");
		}
	if(pstmt != null)
		pstmt.close();
	if(rslRst != null)
		rslRst.close();

	}else if(!(lic_code.equalsIgnoreCase(""))){
		Sql="SELECT remarks FROM rs_staff_licensure WHERE role_type=? AND staff_id=? AND license_code=?";
			pstmt=Con.prepareStatement(Sql);
			pstmt.setString( 1,role_type.trim());
			pstmt.setString( 2,staff_id.trim());
			pstmt.setString( 3,lic_code.trim());
			rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			remarks=rslRst.getString("remarks");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
	}else if(!(expr_no.equalsIgnoreCase(""))){
		Sql="SELECT remarks FROM rs_staff_experience WHERE role_type=? AND staff_id=? AND  serial_no=?";
			pstmt=Con.prepareStatement(Sql);
			pstmt.setString( 1,role_type.trim());
			pstmt.setString( 2,staff_id.trim());
			pstmt.setString( 3,expr_no.trim());
			rslRst = pstmt.executeQuery();

		while(rslRst.next()){
			remarks=rslRst.getString("remarks");
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
	}
	if(remarks == null || remarks.equals("null")) remarks =" "; else remarks = remarks.trim();

%>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_ExplanatoryText>
	<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
	<tr>
		<td >&nbsp;&nbsp;<TEXTAREA NAME="explanatory_text" ROWS="16" COLS="80"      ALIGN='ABSMIDDLE' readonly><%=remarks%></TEXTAREA>
		</td>
		
</tr>
 <tr>	
	<td  align='right' valign='bottom'><input type=button name=ok align='right' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'onclick="window.close()" class="BUTTON" readonly>&nbsp;&nbsp;</td>
</tr> 
</table>
</form>
</body>
</html>
<%}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpShowExplText.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>

