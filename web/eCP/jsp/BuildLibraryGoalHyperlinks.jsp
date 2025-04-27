<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	10 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		//This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<%
String termSet		=	request.getParameter("termSet");
String termCode		=	request.getParameter("termCode");
String termDesc		=	request.getParameter("termDesc");
String libraryid	=	request.getParameter("libraryid");
String versionno	=	request.getParameter("versionno");
String tableName	=	request.getParameter("tableName");
try{%>

<BODY>
<FORM name="formLibraryGoalHyperlinks" id="formLibraryGoalHyperlinks">
	<TABLE  border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
	<TR>
	<TR>
		<!-- <TD><a href='../../eCP/Jsp/BuildLibraryGoalDetails.jsp?alphalink=Associated&termSet=<%=termSet%>&termCode=<%=termCode%>&termDesc=<%=termDesc%>&libraryid=<%=libraryid%>&versionno=<%=versionno%>&tableName=<%=tableName%>' target="f_Goal_detail"><u>Associated</u></a></TD> -->
		<TD><label onClick="loadGoalDetail(associated_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','Associated')" style="color:blue;cursor:pointer" id="associated_lbl"><u><font color=maroon><fmt:message key="eCP.Associated.label" bundle="${cp_labels}"/></font></u></a></TD>
		<TD><label onClick="loadGoalDetail(A_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','A')" style="color:blue;cursor:pointer" id="A_lbl"><u>A</u></a></TD>
		<TD><label onClick="loadGoalDetail(B_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','B')" style="color:blue;cursor:pointer" id="B_lbl"><u>B</u></a></TD>
		<TD><label onClick="loadGoalDetail(C_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','C')" style="color:blue;cursor:pointer" id="C_lbl"><u>C</u></a></TD>
		<TD><label onClick="loadGoalDetail(D_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','D')" style="color:blue;cursor:pointer" id="D_lbl"><u>D</u></a></TD>
		<TD><label onClick="loadGoalDetail(E_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','E')" style="color:blue;cursor:pointer" id="E_lbl"><u>E</u></a></TD>
		<TD><label onClick="loadGoalDetail(F_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','F')" style="color:blue;cursor:pointer" id="F_lbl"><u>F</u></a></TD>
		<TD><label onClick="loadGoalDetail(G_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','G')" style="color:blue;cursor:pointer" id="G_lbl"><u>G</u></a></TD>
		<TD><label onClick="loadGoalDetail(H_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','H')" style="color:blue;cursor:pointer" id="H_lbl"><u>H</u></a></TD>
		<TD><label onClick="loadGoalDetail(I_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','I')" style="color:blue;cursor:pointer" id="I_lbl"><u>I</u></a></TD>
		<TD><label onClick="loadGoalDetail(J_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','J')" style="color:blue;cursor:pointer" id="J_lbl"><u>J</u></a></TD>
		<TD><label onClick="loadGoalDetail(K_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','K')" style="color:blue;cursor:pointer" id="K_lbl"><u>K</u></a></TD>
		<TD><label onClick="loadGoalDetail(L_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','L')" style="color:blue;cursor:pointer" id="L_lbl"><u>L</u></a></TD>
		<TD><label onClick="loadGoalDetail(M_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','M')" style="color:blue;cursor:pointer" id="M_lbl"><u>M</u></a></TD>
		<TD><label onClick="loadGoalDetail(N_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','N')" style="color:blue;cursor:pointer" id="N_lbl"><u>N</u></a></TD>
		<TD><label onClick="loadGoalDetail(O_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','O')" style="color:blue;cursor:pointer" id="O_lbl"><u>O</u></a></TD>
		<TD><label onClick="loadGoalDetail(P_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','P')" style="color:blue;cursor:pointer" id="P_lbl"><u>P</u></a></TD>
		<TD><label onClick="loadGoalDetail(Q_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','Q')" style="color:blue;cursor:pointer" id="Q_lbl"><u>Q</u></a></TD>
		<TD><label onClick="loadGoalDetail(R_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','R')" style="color:blue;cursor:pointer" id="R_lbl"><u>R</u></a></TD>
		<TD><label onClick="loadGoalDetail(S_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','S')" style="color:blue;cursor:pointer" id="S_lbl"><u>S</u></a></TD>
		<TD><label onClick="loadGoalDetail(T_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','T')" style="color:blue;cursor:pointer" id="T_lbl"><u>T</u></a></TD>
		<TD><label onClick="loadGoalDetail(U_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','U')" style="color:blue;cursor:pointer" id="U_lbl"><u>U</u></a></TD>
		<TD><label onClick="loadGoalDetail(V_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','V')" style="color:blue;cursor:pointer" id="V_lbl"><u>V</u></a></TD>
		<TD><label onClick="loadGoalDetail(W_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','W')" style="color:blue;cursor:pointer" id="W_lbl"><u>W</u></a></TD>
		<TD><label onClick="loadGoalDetail(X_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','X')" style="color:blue;cursor:pointer" id="X_lbl"><u>X</u></a></TD>
		<TD><label onClick="loadGoalDetail(Y_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','Y')" style="color:blue;cursor:pointer" id="Y_lbl"><u>Y</u></a></TD>
		<TD><label onClick="loadGoalDetail(Z_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','Z')" style="color:blue;cursor:pointer" id="Z_lbl"><u>Z</u></a></TD>
		<TD></TD>
		<TD><label onClick="loadGoalDetail(Others_lbl,'<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>','')" style="color:blue;cursor:pointer" id="Others_lbl"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></a></TD>
	</TR>
</TABLE>
</FORM>
		<%}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}%>
</BODY>
</HTML>

