<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	ePH
*	Purpose 		:	
*	Created By		:	Abdul Sukkur
*	Created On		:	28 Oct 2009

--%>
<%@page  import="ePH.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eOR.Common.*" %>
<jsp:useBean id="AdminRouteCategoryRoutes" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%

	 request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<script language="JavaScript" src="../../ePH/js/AdminRouteCategoryRoutes.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		Connection connection = null;		
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String admin_route_categ_code = request.getParameter("admin_route_categ_code");		
		String short_desc = request.getParameter("short_desc");
		String search_criteria = request.getParameter("search_criteria");
		String flag = request.getParameter("flag")==null?"":request.getParameter("flag");;
		
				
		ArrayList TabList = null;
		String code="";
		
	try{
		
		/*if(sessionList.size()>0)
		{
			TabList = (ArrayList)AdminRouteCategoryRoutes.getObject(0);
		}else{
			TabList=new ArrayList();
		}*/
		if(flag.equals("true")){
			AdminRouteCategoryRoutes.clearAll();
			TabList=new ArrayList();
		}		
		String sqlData="SELECT a.route_code, b.route_desc short_desc,'U' db_action FROM ph_admin_route_catg_dtl a, ph_route b WHERE a.admin_route_catg_code = ? and a.route_code = b.route_code ORDER BY 2";
		connection = ConnectionManager.getConnection(request);		
		pstmt = connection.prepareStatement( sqlData);
		pstmt.setString(1,admin_route_categ_code);		
		rs=pstmt.executeQuery();

		if(rs!=null){
			while(rs.next()){
				code=rs.getString("route_code");				
				TabList=new ArrayList();
				TabList.add(code);				
				AdminRouteCategoryRoutes.putObject(TabList);
				
			}
		}
	
%>
<body onKeyDown = "lockKey()"> <!-- /**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185
 * @Desc - added lockKey() in <body> onKeyDown() event.
 */ -->
<form name="form_hyperlinks" id="form_hyperlinks">
	
<table  border='0' cellspacing='0' cellpadding='0' align='center' width='100%'>
	<tr>
		<td ><label onClick="loadDetail(associated_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','Associated')" style="color:blue;cursor:pointer" id="associated_lbl"><u><font color='maroon'><fmt:message key="Common.Associated.label" bundle="${common_labels}"/></font></u></label></td>
		<td><label onClick="loadDetail(A_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','A')" style="color:blue;cursor:pointer" id="A_lbl"><u>A</u></a></td>
		<td><label onClick="loadDetail(B_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','B')" style="color:blue;cursor:pointer" id="B_lbl"><u>B</u></label></td>
		<td><label onClick="loadDetail(C_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','C')" style="color:blue;cursor:pointer" id="C_lbl"><u>C</u></label></td>
		<td><label onClick="loadDetail(D_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','D')" style="color:blue;cursor:pointer" id="D_lbl"><u>D</u></label></td>
		<td><label onClick="loadDetail(E_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','E')" style="color:blue;cursor:pointer" id="E_lbl"><u>E</u></label></td>
		<td><label onClick="loadDetail(F_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','F')" style="color:blue;cursor:pointer" id="F_lbl"><u>F</u></label></td>
		<td><label onClick="loadDetail(G_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','G')" style="color:blue;cursor:pointer" id="G_lbl"><u>G</u></label></td>
		<td><label onClick="loadDetail(H_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','H')" style="color:blue;cursor:pointer" id="H_lbl"><u>H</u></label></td>
		<td><label onClick="loadDetail(I_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','I')" style="color:blue;cursor:pointer" id="I_lbl"><u>I</u></label></td>
		<td><label onClick="loadDetail(J_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','J')" style="color:blue;cursor:pointer" id="J_lbl"><u>J</u></label></td>
		<td><label onClick="loadDetail(K_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','K')" style="color:blue;cursor:pointer" id="K_lbl"><u>K</u></label></td>
		<td><label onClick="loadDetail(L_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','L')" style="color:blue;cursor:pointer" id="L_lbl"><u>L</u></label></td>
		<td><label onClick="loadDetail(M_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','M')" style="color:blue;cursor:pointer" id="M_lbl"><u>M</u></label></td>
		<td><label onClick="loadDetail(N_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','N')" style="color:blue;cursor:pointer" id="N_lbl"><u>N</u></label></td>
		<td><label onClick="loadDetail(O_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','O')" style="color:blue;cursor:pointer" id="O_lbl"><u>O</u></label></td>
		<td><label onClick="loadDetail(P_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','P')" style="color:blue;cursor:pointer" id="P_lbl"><u>P</u></label></td>
		<td><label onClick="loadDetail(Q_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','Q')" style="color:blue;cursor:pointer" id="Q_lbl"><u>Q</u></label></td>
		<td><label onClick="loadDetail(R_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','R')" style="color:blue;cursor:pointer" id="R_lbl"><u>R</u></label></td>
		<td id=S_link><label onClick="loadDetail(S_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','S')" style="color:blue;cursor:pointer" id="S_lbl"><u>S</u></label></td>
		<td><label onClick="loadDetail(T_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','T')" style="color:blue;cursor:pointer" id="T_lbl"><u>T</u></label></td>
		<td><label onClick="loadDetail(U_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','U')" style="color:blue;cursor:pointer" id="U_lbl"><u>U</u></label></td>
		<td><label onClick="loadDetail(V_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','V')" style="color:blue;cursor:pointer" id="V_lbl"><u>V</u></label></td>
		<td><label onClick="loadDetail(W_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','W')" style="color:blue;cursor:pointer" id="W_lbl"><u>W</u></label></td>
		<td><label onClick="loadDetail(X_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','X')" style="color:blue;cursor:pointer" id="X_lbl"><u>X</u></label></td>
		<td><label onClick="loadDetail(Y_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','Y')" style="color:blue;cursor:pointer" id="Y_lbl"><u>Y</u></label></td>
		<td><label onClick="loadDetail(Z_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','Z')" style="color:blue;cursor:pointer" id="Z_lbl"><u>Z</u></label></td>
		<td></td>
		<td><label onClick="loadDetail(other_lbl,'<%=admin_route_categ_code%>','<%=short_desc%>','<%=search_criteria%>','*')" style="color:blue;cursor:pointer" id="other_lbl"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></label></td>
	</tr>
</table>
</form>
	<%		
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			ConnectionManager.returnConnection(connection,request);

		}
	%>
</body>
</html>

