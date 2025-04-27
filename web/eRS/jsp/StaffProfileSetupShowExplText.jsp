<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	22 Nov 2004.
* --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<head>
<title><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

	String skillCode = request.getParameter("skillCode");
	String Sql			="";
	String expl_txt		="";
	try{
		Con=ConnectionManager.getConnection(request);

		//Sql="SELECT skill_expl_text FROM rs_skill WHERE skill_code = (?)";
		Sql="SELECT skill_expl_text FROM rs_skill_lang_vw WHERE skill_code = (?) and language_id = ?";
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,skillCode);
		pstmt.setString(2,locale);
		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()){
			expl_txt= rslRst.getString( "skill_expl_text");
		}
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		if(expl_txt == null || expl_txt.equals("null")) expl_txt =" "; else expl_txt = expl_txt.trim();

%>

<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_ExplanatoryText>
	<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
	<tr>
		<td >&nbsp;&nbsp;<TEXTAREA NAME="explanatory_text" ROWS="8" COLS="43"      ALIGN='ABSMIDDLE' readonly><%=expl_txt%></TEXTAREA>
		</td>
		
</tr>
 <tr>	
	<td  align='right' valign='bottom'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button name=ok align='right' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'onclick="window.close()" class="BUTTON"></td>
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

