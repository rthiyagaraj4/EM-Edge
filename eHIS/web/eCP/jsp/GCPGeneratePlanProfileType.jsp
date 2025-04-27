<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Jerome
*	Created On		:	19/01/2005
* --%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--

 function scrollTitle()
{
	   var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById("CasetypeTitle").style.position = 'static';
					document.getElementById("CasetypeTitle").style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById("CasetypeTitle").style.position = 'relative';
				document.getElementById("CasetypeTitle").style.posTop  = scrollXY;
	 }
}
//-->

</SCRIPT>
</head>
<%@page import="java.sql.*, java.io.*,java.util.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='' onscroll='scrollTitle()'>
<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="generate_case_type" id="generate_case_type"  method ='post' target='' action=''>
<div id='CasetypeTitle' style='postion:relative'>	
<table border='1' cellspacing='0' cellpadding='0' width='100%' align='center'>
	<tr>
		<th width='34%' colspan='2' align='left' class='PLANSUBHEAD'><font size="1"><fmt:message key="eCP.EligibleCaseTypeforCarePlan.label" bundle="${cp_labels}"/></font></th>
		<th width='1%' class='PLANSUBHEAD'><font size="1"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font></th>
	</tr>
</table>
</div>
<%	//String p_called_from_ca		= (String)request.getParameter("p_called_from_ca ");
String patient_id			= (String)request.getParameter("patient_id");
//String encounter_id			= (String)request.getParameter("episode_id");
String patient_class			= (String)request.getParameter("patient_class");
  
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;


//String mode			 = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
String sql			 = "" ;
String classValue	 = "" ;
String validDiagCode = "" ;
String case_code	 = "" ;
String case_code1	 = "" ;
int i=0,k=0;
try
{   
	con = ConnectionManager.getConnection(request);
//	sql = "SELECT  DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE,B.MANDATORY_YN FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND  EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE  =A.TERM_CODE AND B.TERM_CODE IS NOT NULL AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O') ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC ";
	sql = "SELECT  DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE,B.MANDATORY_YN FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE_LANG_VW C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND  EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE  =A.TERM_CODE AND B.TERM_CODE IS NOT NULL AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O') AND C.LANGUAGE_ID = ? ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC";
	ps = con.prepareStatement(sql);
	ps.setString(1, patient_id );
	ps.setString(2, locale);
	rs = ps.executeQuery();

	while(rs.next())
	{	
		if ( i % 2 == 0 )
			classValue = "GRPPROFILEEVEN" ;
		else
			classValue = "GRPPROFILEEVEN" ;

		case_code = rs.getString(1);

		if(!case_code1.equals(case_code)){
			if(i!=0 && !validDiagCode.equals("")){
	%>			<input type ='hidden' name='validDiagCode<%=i%>' id='validDiagCode<%=i%>' value='<%=validDiagCode%>'>
				<%validDiagCode="";
			}
	%><table border='0' cellspacing='0' cellpadding='0' width='100%'  align='center'>
		<tr>
			<td height='1' width='2%' class='<%=classValue%>' onClick='showRelatedDiagnosis(<%=i%>)' id='CaseCode_tree<%=i%>' align='center'><font size="1" color='#6633FF'><B>+</B></font></td> 
			<td height='1' class='<%=classValue%>'><font size="1" color="">	<%=rs.getString(2)%></font></td>	
				<input type ='hidden' name='casetype_code<%=i%>' id='casetype_code<%=i%>' value='<%=rs.getString(1)%>'>		
				<input type ='hidden' name='casetype_desc<%=i%>' id='casetype_desc<%=i%>' value='<%=rs.getString(2)%>'>					
			<td height='1' width='4%' class='<%=classValue%>' align='center'><input type="checkbox" name='chk_casetype<%=i%>' id='chk_casetype<%=i%>' onClick='callDiable1("<%=i%>")'></td>
		</tr>
	</table>
	<table border='0' cellspacing='0' cellpadding='0' width='100%'  align='center' id='termcd_desc<%=i%>' style='display:none'>
<%	case_code1 = case_code;
	i++;	}
%>
	<tr >
		<td height='1' width='5%' class='<%=classValue%>' align='center'>&nbsp;</td>
		<td height='1' class='<%=classValue%>' colspan=''><font size="1" color='navy'><B><%=rs.getString(4)%></B></font></td>
	</tr>
<%	validDiagCode =validDiagCode + rs.getString(5)+"*"+rs.getString(6)+"*"+rs.getString(7)+"|";
	k++;
	
}

%>			

</table>
	<input type ='hidden' name='validDiagCode<%=i%>' id='validDiagCode<%=i%>' value='<%=validDiagCode%>'>
	<input type ='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type ='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
	<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
	<input type ='hidden' name='i' id='i' value='<%=i%>'>

</form>

<%	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	if(con != null) ConnectionManager.returnConnection(con);
}
catch(Exception ee)
{
	out.println("Exception in Profile Case Type "+ee.toString());
}
finally
{
	try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
}

%>

</body>
</html>

