<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eCommon.Common.*,java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--

 function scrollTitle()
{
	   var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById("LibraryDetailTitle").style.position = 'static';
					document.getElementById("LibraryDetailTitle").style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById("LibraryDetailTitle").style.position = 'relative';
				document.getElementById("LibraryDetailTitle").style.posTop  = scrollXY;
	 }
}
//-->

</SCRIPT>	
</head>

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

<form name="generate_lib_details" id="generate_lib_details"  method ='post' target='messageFrame' action='../../servlet/eCP.GCPGeneratePlanServlet'>
<div id='LibraryDetailTitle' style='postion:relative'>	
<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center'>
	<tr>
		<th align=''> <fmt:message key="eCP.LibraryDetails.label" bundle="${cp_labels}"/> </th>
	</tr>
</table>
</div>
<%
  
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;


String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");	
//out.println("<script>alert('patient_id:::"+patient_id+",encounter_id:::"+encounter_id+"')</script>");	
String casetype_code = request.getParameter("casetype_code") == null ? "" : request.getParameter("casetype_code");
//out.println("<script>alert('casetype_code:::"+casetype_code+"--')</script>");	
String lib_short_desc = request.getParameter("lib_short_desc") == null ? "" : request.getParameter("lib_short_desc");
String library_code = request.getParameter("library_code") == null ? "" : request.getParameter("library_code");
String version_no = request.getParameter("version_no") == null ? "" : request.getParameter("version_no");

//	out.println("<script>alert('library_code:::"+library_code+",version_no:::"+version_no+"')</script>");
String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
mode = "insert";
//	out.println("<script>alert('mode:::"+mode+"--')</script>");
String sql = "";
String classValue="";
String termset="",termset1="";
String termcode="",termcode1="";
String outcomecode="",outcomecode1="";
int i=0,j=0,k=0,x=0;
try
{    
	
	con = ConnectionManager.getConnection(request);
	sql = "SELECT a.LIBRARY_ID,a.VERSION_NO ,a.TERM_SET_ID ,b.Term_Set_Desc Term_Set_Description ,a.TERM_CODE ,c.Short_desc Term_Code_Description ,c.Short_desc Term_Code_Description,a.OUTCOME_CODE ,F.Short_desc Outcome_Description,a.INTERVENTION_CODE ,a.INTERVENTION_TYPE ,a.SEQ_NO  ,a.REL_START_PERIOD,a.REL_START_PERIOD_UNIT,a.FREQ_CODE ,a.FREQ_DURN,a.FREQ_DURN_UNIT ,a.DEPENDENCY_LEVEL ,a.ALT_INTERVENTION_CODE ,a.STAGE_CODE ,a.ACCURACY_INDICATOR,Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))  Start_Date_Time,to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') End_Date_Time ,'<font color=black><b>' || D.Short_Desc ||'</b></font>' || '  Frequency : ' || E.Freq_Desc || ' For '  || a.Freq_Durn || ' ' || g.durn_desc || ' Start Date : ' || Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))   ||  ' End Date :' || to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + 			       (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI')     Build_Diagonis_Intervention,to_char(decode(OUTCOME_TARGET_DURN_UNIT,'D',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),      			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+OUTCOME_TARGET_DURN,'H',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'), To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN/24),'M',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H  where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN/1440),'W',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'), 'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN*7), 'L', (select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'), 'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'), 'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'), 'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),  'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'), To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  +  (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H  where a.term_set_id = h.term_set_id  and   a.term_code   = h.term_code  and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN*30)),'dd/mm/yyyy hh24:mi') OutCome_Target_Date,Decode(a.FREQ_DURN_UNIT,'D','Days','H','Hours','M','Minutes','L','Months','W','Weeks','') Freq_legend,D.Short_Desc Intervention_Desc FROM	CP_INTERVENTION_FOR_OUTCOME A,MR_TERM_SET B,MR_TERM_CODE C,	CA_INTERVENTION D,AM_FREQUENCY E,CP_OUTCOME F,AM_DURATION_TYPE G, CP_OUTCOME_FOR_TERM_CODE H WHERE a.LIBRARY_ID = ? AND a.VERSION_NO = ? and   a.term_set_id = b.term_Set_id and   a.term_set_id = c.term_set_id and   a.term_code   = c.term_code and   a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO and   a.outcome_code = H.outcome_code and   a.intervention_code = d.intervention_Code and   a.intervention_type = 'I' and   a.freq_code = e.freq_Code (+) and   a.freq_durn_Unit = g.durn_type (+) and   a.outcome_Code = f.outcome_code  Order by a.TERM_SET_ID,a.TERM_CODE,a.outcome_code,a.SEQ_NO  ";
	ps = con.prepareStatement(sql);
	ps.setString(1,library_code.trim());
	ps.setString(2,version_no.trim());
	rs = ps.executeQuery();
%>
<table border='1' cellspacing='0' cellpadding='0' width='100%' height='' align='center'>
<tr>	
<%
	while(rs.next())
	{
		termset =rs.getString(3);
		
		if(!termset.equals(termset1)){
		%><td colspan='2' height='1%' align='left' class='label'><font size="1"><b><%=lib_short_desc%></b></font></td>
			</tr><tr><td colspan='2' height='1%' align='left' class='label'>&nbsp;&nbsp;<font size="1"><b><%out.println(rs.getString(4));%></b></font></td>
	
	<input type ='hidden' name='termset_id<%=x%>' id='termset_id<%=x%>' value='<%=rs.getString(3)%>'>
	<input type ='hidden' name='termset_id' id='termset_id' value='<%=rs.getString(3)%>'>
	<input type ='hidden' name='termset_desc<%=x%>' id='termset_desc<%=x%>' value='<%=rs.getString(4)%>'>
				
	<%		termset1=termset;			
		x++;	}	termcode =rs.getString(5);
		
			if(!termcode.equals(termcode1)){
				
				%></tr><tr><td colspan='2' height='.5%' align='left' class='label'>&nbsp;&nbsp;<input type="checkbox" name='chk_termcode<%=j%>' id='chk_termcode<%=j%>' checked onClick="chkValid(<%=i%>,<%=j%>)" value='<%=rs.getString(5)%>'><font size="1"><b>&nbsp;&nbsp;<%out.println(rs.getString(6));%></b></font></td>
		<input type ='hidden' name='termcode_id<%=j%>' id='termcode_id<%=j%>' value='<%=rs.getString(5)%>'> 		
		<input type ='hidden' name='termcode_desc<%=j%>' id='termcode_desc<%=j%>' value='<%=rs.getString(6)%>'>
		<input type ='hidden' name='chk_libdetails<%=j%>' id='chk_libdetails<%=j%>' value='<%=k%>'>
		<%	termcode1=termcode;
			k=0;
			//out.println("<script>alert('chk_libdetails"+j+"----k=="+k+"')</script>");			
			}
			outcomecode =rs.getString(5);
			
			if(!outcomecode.equals(outcomecode1)){
			
					%></tr><tr><td colspan='2' height='1%' align='left' class='CAGROUPHEADING'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font size="1"><%out.println(rs.getString(9));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCP.OutcomeTargetDate.label" bundle="${cp_labels}"/>
&nbsp;(&nbsp;<%out.println(rs.getString(25));%>&nbsp;)</font></b></td>
			<input type ='hidden' name='outcomecode_id<%=j%>' id='outcomecode_id<%=j%>' value='<%=rs.getString(8)%>'>	
			<input type ='hidden' name='care_plan_start_date' id='care_plan_start_date' value='<%=rs.getString(22)%>'>
			<input type ='hidden' name='care_plan_end_date' id='care_plan_end_date' value='<%=rs.getString(23)%>'>
			<input type ='hidden' name='target_date' id='target_date' value='<%=rs.getString(25)%>'>
			<input type ='hidden' name='outcomecode_desc<%=j%>' id='outcomecode_desc<%=j%>' value='<%=rs.getString(9)%>'>
			
			<%	outcomecode1=outcomecode;			
			j++;	}
		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
	
	//out.println("<script>alert('chk_libdetails"+k+j+"')</script>");
	%>
		<tr>
		
	<td height='1%' class='<%=classValue%>' align='right'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name='chk_libdetails<%=k%><%=j%>' id='chk_libdetails<%=k%><%=j%>' checked onClick='chkValidate(<%=k%>,<%=j%>)' value='<%=rs.getString(10)%>' ></td>
	<td height='1%'  class='<%=classValue%>'> &nbsp;<font size="1"><%out.println(rs.getString(24));%>	</font> 			
	</td>
	</tr>
<input type ='hidden' name='intervention_code<%=k%><%=j%>' id='intervention_code<%=k%><%=j%>' value='<%=rs.getString(10)%>'>
<input type ='hidden' name='intervention_type<%=k%><%=j%>' id='intervention_type<%=k%><%=j%>' value='<%=rs.getString(11)%>'>
<input type ='hidden' name='freq_code<%=k%><%=j%>' id='freq_code<%=k%><%=j%>' value='<%=rs.getString(15)%>'>
<input type ='hidden' name='duration<%=k%><%=j%>' id='duration<%=k%><%=j%>' value='<%=rs.getString(16)%>'>
<input type ='hidden' name='durn_type<%=k%><%=j%>' id='durn_type<%=k%><%=j%>' value='<%=rs.getString(17)%>'>
<input type ='hidden' name='start_date<%=k%><%=j%>' id='start_date<%=k%><%=j%>' value='<%=rs.getString(22)%>'>
<input type ='hidden' name='end_date<%=k%><%=j%>' id='end_date<%=k%><%=j%>' value='<%=rs.getString(23)%>'>
<%
	i++;k++;	
}	//out.println("<script>alert('chk_libdetails"+j+"----k=="+k+"')</script>");k=0;

	if(rs != null) rs.close();
	if(ps != null) ps.close();
%>			
</table>
<input type ='hidden' name='chk_libdetails<%=j%>' id='chk_libdetails<%=j%>' value='<%=k%>'>
<input type ='hidden' name='mode' id='mode' value='<%=mode%>'>	
<input type ='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type ='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type ='hidden' name='casetype_code' id='casetype_code' value='<%=casetype_code%>'>
<input type ='hidden' name='lib_short_desc' id='lib_short_desc' value='<%=lib_short_desc%>'>
<input type ='hidden' name='library_code' id='library_code' value='<%=library_code%>'>
<input type ='hidden' name='version_no' id='version_no' value='<%=version_no%>'>
<input type ='hidden' name='query_str' id='query_str' value='<%=request.getQueryString()%>'>


<input type ='hidden' name='libdetailvalue' id='libdetailvalue' value=''>
<input type ='hidden' name='intervention_code' id='intervention_code' value=''>
<input type ='hidden' name='sql' id='sql' value=''>	
<input type ='hidden' name='x' id='x' value='<%=x%>'>	
<input type ='hidden' name='j' id='j' value='<%=j%>'>	
<input type ='hidden' name='i' id='i' value='<%=i%>'>	
</form>
<%
}
catch(Exception ee)
{
	out.println("Exception in Library Details Module "+ee.toString());
}
finally
{
	try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
}

%>

</body>
</html>

