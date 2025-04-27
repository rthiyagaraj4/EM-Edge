<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- TerminologyCodeForCaseTypeHyperLinks.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	22 Jan 2005

--%>
<%@page  import="eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eOR.Common.*" %>
<jsp:useBean id="TermCodeForCaseType" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<script language="JavaScript" src="../../eCP/js/TerminologyCodeForCaseType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		Connection connection = null;
		//Statement stmt = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String case_type_code = request.getParameter("case_type_code");
		String term_set_id = request.getParameter("term_set_id");
		String type = request.getParameter("type");
		String wellness_yn = request.getParameter("wellness_yn");
		String short_desc = request.getParameter("short_desc");
		String search_criteria = request.getParameter("search_criteria");
		String flag = request.getParameter("flag")==null?"":request.getParameter("flag");;
		//out.println(flag);
				
		ArrayList TabList = null;
		String code="";
		String mandatory_yn="";
		String actual_yn="";
		String potential_yn="";
		String select_val="";
	try{
		
		/*if(sessionList.size()>0)
		{
			TabList = (ArrayList)TermCodeForCaseType.getObject(0);
		}else{
			TabList=new ArrayList();
		}*/
		if(flag.equals("true")){
			TermCodeForCaseType.clearAll();
			TabList=new ArrayList();
		}
		//String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_term_code b WHERE a.case_type_code='"+case_type_code+"' and b.term_set_id = '"+term_set_id+"' and b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_term_code b WHERE a.case_type_code=? and b.term_set_id = ? and b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		connection = ConnectionManager.getConnection(request);
		//stmt=connection.createStatement();
		pstmt = connection.prepareStatement( sqlData);
		pstmt.setString(1,case_type_code);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,type);
		pstmt.setString(4,type);
		//rs=stmt.executeQuery(sqlData);
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				 code=rs.getString("term_code");
				 mandatory_yn=rs.getString("mandatory_yn");
				 actual_yn=rs.getString("actual_yn");
				 potential_yn=rs.getString("potential_yn");
				wellness_yn=rs.getString("wellness_yn");
				 select_val="N";
				if(actual_yn.equals("Y")){
					if(potential_yn.equals("Y"))
						select_val="B";
					else
						select_val="A";
				}
				else
					if(potential_yn.equals("Y"))
						select_val="P";
				if(wellness_yn.equals("Y"))
					select_val="W";

				TabList=new ArrayList();
				TabList.add(code);
				TabList.add(mandatory_yn);
				TabList.add(actual_yn);
				TabList.add(potential_yn);
				TabList.add(wellness_yn);
				TabList.add(select_val);

				TermCodeForCaseType.putObject(TabList);
				
			}
		}
	
%>
<body>
<form name="form_hyperlinks" id="form_hyperlinks">
	
<table  border='0' cellspacing='0' cellpadding='0' align='center' width='100%'>
	<tr>
		<td ><label onClick="loadDetail(associated_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','Associated')" style="color:blue;cursor:pointer" id="associated_lbl"><u><font color='maroon'><fmt:message key="eCP.Associated.label" bundle="${cp_labels}"/></font></u></label></td>
		<td><label onClick="loadDetail(A_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','A')" style="color:blue;cursor:pointer" id="A_lbl"><u>A</u></a></td>
		<td><label onClick="loadDetail(B_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','B')" style="color:blue;cursor:pointer" id="B_lbl"><u>B</u></label></td>
		<td><label onClick="loadDetail(C_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','C')" style="color:blue;cursor:pointer" id="C_lbl"><u>C</u></label></td>
		<td><label onClick="loadDetail(D_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','D')" style="color:blue;cursor:pointer" id="D_lbl"><u>D</u></label></td>
		<td><label onClick="loadDetail(E_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','E')" style="color:blue;cursor:pointer" id="E_lbl"><u>E</u></label></td>
		<td><label onClick="loadDetail(F_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','F')" style="color:blue;cursor:pointer" id="F_lbl"><u>F</u></label></td>
		<td><label onClick="loadDetail(G_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','G')" style="color:blue;cursor:pointer" id="G_lbl"><u>G</u></label></td>
		<td><label onClick="loadDetail(H_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','H')" style="color:blue;cursor:pointer" id="H_lbl"><u>H</u></label></td>
		<td><label onClick="loadDetail(I_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','I')" style="color:blue;cursor:pointer" id="I_lbl"><u>I</u></label></td>
		<td><label onClick="loadDetail(J_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','J')" style="color:blue;cursor:pointer" id="J_lbl"><u>J</u></label></td>
		<td><label onClick="loadDetail(K_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','K')" style="color:blue;cursor:pointer" id="K_lbl"><u>K</u></label></td>
		<td><label onClick="loadDetail(L_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','L')" style="color:blue;cursor:pointer" id="L_lbl"><u>L</u></label></td>
		<td><label onClick="loadDetail(M_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','M')" style="color:blue;cursor:pointer" id="M_lbl"><u>M</u></label></td>
		<td><label onClick="loadDetail(N_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','N')" style="color:blue;cursor:pointer" id="N_lbl"><u>N</u></label></td>
		<td><label onClick="loadDetail(O_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','O')" style="color:blue;cursor:pointer" id="O_lbl"><u>O</u></label></td>
		<td><label onClick="loadDetail(P_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','P')" style="color:blue;cursor:pointer" id="P_lbl"><u>P</u></label></td>
		<td><label onClick="loadDetail(Q_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','Q')" style="color:blue;cursor:pointer" id="Q_lbl"><u>Q</u></label></td>
		<td><label onClick="loadDetail(R_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','R')" style="color:blue;cursor:pointer" id="R_lbl"><u>R</u></label></td>
		<td id=S_link><label onClick="loadDetail(S_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','S')" style="color:blue;cursor:pointer" id="S_lbl"><u>S</u></label></td>
		<td><label onClick="loadDetail(T_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','T')" style="color:blue;cursor:pointer" id="T_lbl"><u>T</u></label></td>
		<td><label onClick="loadDetail(U_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','U')" style="color:blue;cursor:pointer" id="U_lbl"><u>U</u></label></td>
		<td><label onClick="loadDetail(V_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','V')" style="color:blue;cursor:pointer" id="V_lbl"><u>V</u></label></td>
		<td><label onClick="loadDetail(W_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','W')" style="color:blue;cursor:pointer" id="W_lbl"><u>W</u></label></td>
		<td><label onClick="loadDetail(X_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','X')" style="color:blue;cursor:pointer" id="X_lbl"><u>X</u></label></td>
		<td><label onClick="loadDetail(Y_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','Y')" style="color:blue;cursor:pointer" id="Y_lbl"><u>Y</u></label></td>
		<td><label onClick="loadDetail(Z_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','Z')" style="color:blue;cursor:pointer" id="Z_lbl"><u>Z</u></label></td>
		<td></td>
		<td><label onClick="loadDetail(other_lbl,'<%=case_type_code%>','<%=term_set_id%>','<%=wellness_yn%>','<%=type%>','<%=short_desc%>','<%=search_criteria%>','*')" style="color:blue;cursor:pointer" id="other_lbl"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></label></td>
	</tr>
</table>
</form>
	<%		
	
		}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			ConnectionManager.returnConnection(connection,request);

		}
	%>
</body>
</html>

