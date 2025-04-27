<!DOCTYPE html>
<!-- AgeGroupForTermCodeHyperLinks.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	07 Feb 2005

--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper " %>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>
<jsp:useBean id="AgeGroupForTermCode" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>
				
		
		 
		<script language="JavaScript" src="../js/AgeGroupForTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		AgeGroupForTermCode.clearAll();

	Connection con = null;
	try{
		String age_group_code = request.getParameter("age_group_code");
		String term_set_id = request.getParameter("term_set_id");
		String type = request.getParameter("type");
		String search_criteria = request.getParameter("search_criteria");
		String term_code_desc = request.getParameter("term_code_desc");
		//Statement stmt = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;		
		ArrayList TabList = null;

		ArrayList sessionList = (ArrayList)AgeGroupForTermCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList = (ArrayList)AgeGroupForTermCode.getObject(0);
		}else{
			TabList=new ArrayList();
		}

		String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,'U' db_action FROM mr_age_grp_for_term_code a, mr_term_code b WHERE a.age_group_code=? and b.term_set_id =? AND b.term_set_id = a.term_set_id and  b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		con= ConnectionManager.getConnection(request);
		//stmt=con.createStatement();
		stmt = con.prepareStatement(sqlData);
		stmt.setString(1,age_group_code);
		stmt.setString(2,term_set_id);
		stmt.setString(3,type);
		stmt.setString(4,type);
		rs=stmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String code=rs.getString("term_code");
				
				TabList.add(code);
			}
						
		}
		AgeGroupForTermCode.putObject(TabList);

%>
<body onKeyDown="lockKey()">
<form name="form_hyperlinks" id="form_hyperlinks">
<table  border='0' cellspacing='0' cellpadding='5' align='center' width='100%'>
	<tr>
		<td><label onClick="loadDetail(associated_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','Associated')" style="color:blue;cursor:pointer" id='associated_lb'><u><font color='maroon'><fmt:message key="Common.Associated.label" bundle="${common_labels}"/></font></u></label></td>
		<td><label onClick="loadDetail(A_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','A')" style="color:blue;cursor:pointer" id='A_lb'><u>A</u></label></td>
		<td><label onClick="loadDetail(B_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','B')" style="color:blue;cursor:pointer" id='B_lb'><u>B</u></label></td>
		<td><label onClick="loadDetail(C_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','C')" style="color:blue;cursor:pointer" id='C_lb'><u>C</u></label></td>
		<td><label onClick="loadDetail(D_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','D')" style="color:blue;cursor:pointer" id='D_lb'><u>D</u></label></td>
		<td><label onClick="loadDetail(E_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','E')" style="color:blue;cursor:pointer" id='E_lb'><u>E</u></label></td>
		<td><label onClick="loadDetail(F_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','F')" style="color:blue;cursor:pointer" id='F_lb'><u>F</u></label></td>
		<td><label onClick="loadDetail(G_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','G')" style="color:blue;cursor:pointer" id='G_lb'><u>G</u></label></td>
		<td><label onClick="loadDetail(H_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','H')" style="color:blue;cursor:pointer" id='H_lb'><u>H</u></label></td>
		<td><label onClick="loadDetail(I_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','I')" style="color:blue;cursor:pointer" id='I_lb'><u>I</u></label></td>
		<td><label onClick="loadDetail(J_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','J')" style="color:blue;cursor:pointer" id='J_lb'><u>J</u></label></td>
		<td><label onClick="loadDetail(K_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','K')" style="color:blue;cursor:pointer" id='K_lb'><u>K</u></label></td>
		<td><label onClick="loadDetail(L_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','L')" style="color:blue;cursor:pointer" id='L_lb'><u>L</u></label></td>
		<td><label onClick="loadDetail(M_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','M')" style="color:blue;cursor:pointer" id='M_lb'><u>M</u></label></td>
		<td><label onClick="loadDetail(N_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','N')" style="color:blue;cursor:pointer" id='N_lb'><u>N</u></label></td>
		<td><label onClick="loadDetail(O_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','O')" style="color:blue;cursor:pointer" id='O_lb'><u>O</u></label></td>
		<td><label onClick="loadDetail(P_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','P')" style="color:blue;cursor:pointer" id='P_lb'><u>P</u></label></td>
		<td><label onClick="loadDetail(Q_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','Q')" style="color:blue;cursor:pointer" id='Q_lb'><u>Q</u></label></td>
		<td><label onClick="loadDetail(R_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','R')" style="color:blue;cursor:pointer" id='R_lb'><u>R</u></label></td>
		<td><label onClick="loadDetail(S_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','S')" style="color:blue;cursor:pointer" id='S_lb'><u>S</u></label></td>
		<td><label onClick="loadDetail(T_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','T')" style="color:blue;cursor:pointer" id='T_lb'><u>T</u></label></td>
		<td><label onClick="loadDetail(U_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','U')" style="color:blue;cursor:pointer" id='U_lb'><u>U</u></label></td>
		<td><label onClick="loadDetail(V_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','V')" style="color:blue;cursor:pointer" id='V_lb'><u>V</u></label></td>
		<td><label onClick="loadDetail(W_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','W')" style="color:blue;cursor:pointer" id='W_lb'><u>W</u></label></td>
		<td><label onClick="loadDetail(X_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','X')" style="color:blue;cursor:pointer" id='X_lb'><u>X</u></label></td>
		<td><label onClick="loadDetail(Y_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','Y')" style="color:blue;cursor:pointer" id='Y_lb'><u>Y</u></label></td>
		<td><label onClick="loadDetail(Z_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','Z')" style="color:blue;cursor:pointer" id='Z_lb'><u>Z</u></label></td>
		<td></td>
		<td><label onClick="loadDetail(Other_lb,'<%=age_group_code%>','<%=term_set_id%>','<%=type%>','<%=term_code_desc%>','<%=search_criteria%>','*')" style="color:blue;cursor:pointer" id='Other_lb'><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></label></td>
	</tr>
</table>
</form>
			<script>
			var frmobj=parent.frames[0].document.forms[0];
					parent.frames[2].location.href='../../eMR/jsp/AgeGroupForTermCodeDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.type.value+'&age_group_code='+frmobj.age_group_code.value+'&term_code_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&alphalink=Associated';

			</script>
	<%				session.setAttribute("AgeGroupForTermCode", AgeGroupForTermCode);
			}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if ( con!=null ) ConnectionManager.returnConnection(con,request);
		}%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

