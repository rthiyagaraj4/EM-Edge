<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/TermCodeLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<%

String terminologySet=request.getParameter("termset");
String type=request.getParameter("type");
String classificationLevel=request.getParameter("classificationLevel");
String termcode								=		request.getParameter("termcode")==null ? "":request.getParameter("termcode");
String termdesc								=		request.getParameter("termdesc")==null ? "":request.getParameter("termdesc");
String searchcriteria			=		request.getParameter("searchcriteria")==null ? "":request.getParameter("searchcriteria");
String libraryid								=		request.getParameter("libraryid");
String versionno								=		request.getParameter("versionno");

try{%>

<BODY>
<FORM name="formTermcodeLookupHyperlinks" id="formTermcodeLookupHyperlinks"  onUnLoad="closeW()">
	<label id="associated_lbl"></label>
<TABLE  border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
	<TR>
		<TD>&nbsp;&nbsp;</TD>
		<TD><label onClick="loadDetail(A_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','A')" style="color:blue;cursor:pointer" id="A_lbl"><u>A</u></a></TD>
		<TD><label onClick="loadDetail(B_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','B')" style="color:blue;cursor:pointer" id="B_lbl"><u>B</u></a></TD>
		<TD><label onClick="loadDetail(C_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','C')" style="color:blue;cursor:pointer" id="C_lbl"><u>C</u></a></TD>
		<TD><label onClick="loadDetail(D_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','D')" style="color:blue;cursor:pointer" id="D_lbl"><u>D</u></a></TD>
		<TD><label onClick="loadDetail(E_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','E')" style="color:blue;cursor:pointer" id="E_lbl"><u>E</u></a></TD>
		<TD><label onClick="loadDetail(F_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','F')" style="color:blue;cursor:pointer" id="F_lbl"><u>F</u></a></TD>
		<TD><label onClick="loadDetail(G_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','G')" style="color:blue;cursor:pointer" id="G_lbl"><u>G</u></a></TD>
		<TD><label onClick="loadDetail(H_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','H')" style="color:blue;cursor:pointer" id="H_lbl"><u>H</u></a></TD>
		<TD><label onClick="loadDetail(I_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','I')" style="color:blue;cursor:pointer" id="I_lbl"><u>I</u></a></TD>
		<TD><label onClick="loadDetail(J_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','J')" style="color:blue;cursor:pointer" id="J_lbl"><u>J</u></a></TD>
		<TD><label onClick="loadDetail(K_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','K')" style="color:blue;cursor:pointer" id="K_lbl"><u>K</u></a></TD>
		<TD><label onClick="loadDetail(L_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','L')" style="color:blue;cursor:pointer" id="L_lbl"><u>L</u></a></TD>
		<TD><label onClick="loadDetail(M_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','M')" style="color:blue;cursor:pointer" id="M_lbl"><u>M</u></a></TD>
		<TD><label onClick="loadDetail(N_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','N')" style="color:blue;cursor:pointer" id="N_lbl"><u>N</u></a></TD>
		<TD><label onClick="loadDetail(O_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','O')" style="color:blue;cursor:pointer" id="O_lbl"><u>O</u></a></TD>
		<TD><label onClick="loadDetail(P_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','P')" style="color:blue;cursor:pointer" id="P_lbl"><u>P</u></a></TD>
		<TD><label onClick="loadDetail(Q_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','Q')" style="color:blue;cursor:pointer" id="Q_lbl"><u>Q</u></a></TD>
		<TD><label onClick="loadDetail(R_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','R')" style="color:blue;cursor:pointer" id="R_lbl"><u>R</u></a></TD>
		<TD><label onClick="loadDetail(S_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','S')" style="color:blue;cursor:pointer" id="S_lbl"><u>S</u></a></TD>
		<TD><label onClick="loadDetail(T_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','T')" style="color:blue;cursor:pointer" id="T_lbl"><u>T</u></a></TD>
		<TD><label onClick="loadDetail(U_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','U')" style="color:blue;cursor:pointer" id="U_lbl"><u>U</u></a></TD>
		<TD><label onClick="loadDetail(V_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','V')" style="color:blue;cursor:pointer" id="V_lbl"><u>V</u></a></TD>
		<TD><label onClick="loadDetail(W_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','W')" style="color:blue;cursor:pointer" id="W_lbl"><u>W</u></a></TD>
		<TD><label onClick="loadDetail(X_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','X')" style="color:blue;cursor:pointer" id="X_lbl"><u>X</u></a></TD>
		<TD><label onClick="loadDetail(Y_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','Y')" style="color:blue;cursor:pointer" id="Y_lbl"><u>Y</u></a></TD>
		<TD><label onClick="loadDetail(Z_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','Z')" style="color:blue;cursor:pointer" id="Z_lbl"><u>Z</u></a></TD>
		<TD></TD>
		<TD><label onClick="loadDetail(OTHERS_lbl,'<%=terminologySet%>','<%=type%>','<%=classificationLevel%>','<%=libraryid%>','<%=versionno%>','<%=termcode%>','<%=termdesc%>','<%=searchcriteria%>','*')" style="color:blue;cursor:pointer" id="OTHERS_lbl"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></a></TD>
	</TR>
</TABLE>
</FORM>
		<%}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}%>
</BODY>
</HTML>

