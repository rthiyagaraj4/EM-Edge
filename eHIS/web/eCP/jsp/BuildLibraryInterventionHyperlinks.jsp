<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	10 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.text.*, eOR.Common.* ,java.net.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
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
String termSet			=	request.getParameter("termSet");
String termCode			=	request.getParameter("termCode");
String goalCode			=	request.getParameter("goalCode");
String libraryid		=	request.getParameter("libraryid");
String versionno		=	request.getParameter("versionno");
String firstTime		=	request.getParameter("firstTime")==null ? "":request.getParameter("firstTime");
String maxGrpID			=	request.getParameter("maxGrpID");
String GroupID			=	request.getParameter("GroupID");

try{%>
<BODY>
<FORM name="formLibraryInterventionHyperlinks" id="formLibraryInterventionHyperlinks">
	<TABLE  border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
	<TR><TD class="label" colspan="30"><B><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></B></TD>
	</TR>
	<TR><TD class="label" colspan="30">&nbsp;</TD>
	</TR>
	<TR>
	<%if(!(firstTime.equals("Y"))){%>
			<TD><label onClick="loadInterventionDetail(associated_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','Associated')" style="color:blue;cursor:pointer" id="associated_lbl"><u><fmt:message key="eCP.Associated.label" bundle="${cp_labels}"/></u></a></TD>
		<%}else{%>
			<TD><label id="associated_lbl"></label></TD>
		<%}%>
		<TD><label onClick="loadInterventionDetail(A_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','A')" style="color:blue;cursor:pointer" id="A_lbl"><u>A</u></a></TD>
		<TD><label onClick="loadInterventionDetail(B_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','B')" style="color:blue;cursor:pointer" id="B_lbl"><u>B</u></a></TD>
		<TD><label onClick="loadInterventionDetail(C_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','C')" style="color:blue;cursor:pointer" id="C_lbl"><u>C</u></a></TD>
		<TD><label onClick="loadInterventionDetail(D_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','D')" style="color:blue;cursor:pointer" id="D_lbl"><u>D</u></a></TD>
		<TD><label onClick="loadInterventionDetail(E_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','E')" style="color:blue;cursor:pointer" id="E_lbl"><u>E</u></a></TD>
		<TD><label onClick="loadInterventionDetail(F_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','F')" style="color:blue;cursor:pointer" id="F_lbl"><u>F</u></a></TD>
		<TD><label onClick="loadInterventionDetail(G_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','G')" style="color:blue;cursor:pointer" id="G_lbl"><u>G</u></a></TD>
		<TD><label onClick="loadInterventionDetail(H_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','H')" style="color:blue;cursor:pointer" id="H_lbl"><u>H</u></a></TD>
		<TD><label onClick="loadInterventionDetail(I_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','I')" style="color:blue;cursor:pointer" id="I_lbl"><u>I</u></a></TD>
		<TD><label onClick="loadInterventionDetail(J_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','J')" style="color:blue;cursor:pointer" id="J_lbl"><u>J</u></a></TD>
		<TD><label onClick="loadInterventionDetail(K_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','K')" style="color:blue;cursor:pointer" id="K_lbl"><u>K</u></a></TD>
		<TD><label onClick="loadInterventionDetail(L_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','L')" style="color:blue;cursor:pointer" id="L_lbl"><u>L</u></a></TD>
		<TD><label onClick="loadInterventionDetail(M_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','M')" style="color:blue;cursor:pointer" id="M_lbl"><u>M</u></a></TD>
		<TD><label onClick="loadInterventionDetail(N_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','N')" style="color:blue;cursor:pointer" id="N_lbl"><u>N</u></a></TD>
		<TD><label onClick="loadInterventionDetail(O_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','O')" style="color:blue;cursor:pointer" id="O_lbl"><u>O</u></a></TD>
		<TD><label onClick="loadInterventionDetail(P_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','P')" style="color:blue;cursor:pointer" id="P_lbl"><u>P</u></a></TD>
		<TD><label onClick="loadInterventionDetail(Q_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','Q')" style="color:blue;cursor:pointer" id="Q_lbl"><u>Q</u></a></TD>
		<TD><label onClick="loadInterventionDetail(R_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','R')" style="color:blue;cursor:pointer" id="R_lbl"><u>R</u></a></TD>
		<TD><label onClick="loadInterventionDetail(S_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','S')" style="color:blue;cursor:pointer" id="S_lbl"><u>S</u></a></TD>
		<TD><label onClick="loadInterventionDetail(T_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','T')" style="color:blue;cursor:pointer" id="T_lbl"><u>T</u></a></TD>
		<TD><label onClick="loadInterventionDetail(U_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','U')" style="color:blue;cursor:pointer" id="U_lbl"><u>U</u></a></TD>
		<TD><label onClick="loadInterventionDetail(V_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','V')" style="color:blue;cursor:pointer" id="V_lbl"><u>V</u></a></TD>
		<TD><label onClick="loadInterventionDetail(W_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','W')" style="color:blue;cursor:pointer" id="W_lbl"><u>W</u></a></TD>
		<TD><label onClick="loadInterventionDetail(X_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','X')" style="color:blue;cursor:pointer" id="X_lbl"><u>X</u></a></TD>
		<TD><label onClick="loadInterventionDetail(Y_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','Y')" style="color:blue;cursor:pointer" id="Y_lbl"><u>Y</u></a></TD>
		<TD><label onClick="loadInterventionDetail(Z_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','Z')" style="color:blue;cursor:pointer" id="Z_lbl"><u>Z</u></a></TD>
		<TD></TD>
		<TD><label onClick="loadInterventionDetail(Others_lbl,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=libraryid%>','<%=versionno%>','<%=maxGrpID%>','<%=GroupID%>','')" style="color:blue;cursor:pointer" id="Others_lbl"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></a></TD>
	</TR>
</TABLE>
</FORM>
		<%}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}%>
</BODY>
</HTML>

