<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
1/06/2012    IN032685		 Menaka V		Manage Care plan>When we Uncheck Active or Pending status we get script error during revise plan.
-----------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="ReviseCarePlan" class="webbeans.eCommon.RecordSet" scope="session"/>
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
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/ReviseCarePlan.js"></SCRIPT>
</HEAD>

<BODY onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()">
<!-- style="overflow-y:scroll;overflow-x:hidden" -->
<FORM name="formReviseCareplanDetail" id="formReviseCareplanDetail" >
<SCRIPT language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String care_plan_id=request.getParameter("care_plan_id");
	int careplanid=Integer.parseInt(care_plan_id);
	String md_care_plan_id=request.getParameter("md_care_plan_id");
	int mdcareplanid=Integer.parseInt(md_care_plan_id);

	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String care_mgr_id=request.getParameter("care_mgr_id");
	//out.println("care_plan_id "+care_plan_id);
	//out.println("md_care_plan_id "+md_care_plan_id);
	
	//1865-c
	//528-m
	Connection connection		=		null;
    PreparedStatement pstmt		=		null;
	ResultSet rs				=		null;

	String diagnosisSql			=		"SELECT 	A.TERM_SET_ID,A.TERM_CODE, A.TERM_SET_ID || ' - ' || B.SHORT_DESC DIAG_DESC,TO_CHAR(A.START_DATE,'dd/mm/yyyy hh24:mi') START_DATE, TO_CHAR(A.TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,	A.STATUS, A.APPL_YN,A.LIBRARY_ID,A.VERSION_NO FROM  CP_PAT_CARE_PLAN_TERM_CODE A, MR_TERM_CODE B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND A.APPL_YN = 'Y' AND B.TERM_SET_ID = A.TERM_SET_ID AND  B.TERM_CODE = A.TERM_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE";
//	String goalSql				=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE, B.SHORT_DESC GOAL_DESC,TO_CHAR(A.GOAL_TARGET_DATE,'dd/mm/yyyy hh24:mi') GOAL_TARGET_DATE,A.APPL_YN,A.STATUS FROM	CP_PAT_CARE_PLAN_GOAL A, CP_OUTCOME B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND B.OUTCOME_CODE = A.GOAL_CODE  ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE";
	String goalSql				=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE, B.SHORT_DESC GOAL_DESC,TO_CHAR(A.GOAL_TARGET_DATE,'dd/mm/yyyy hh24:mi') GOAL_TARGET_DATE,A.APPL_YN,A.STATUS FROM	CP_PAT_CARE_PLAN_GOAL A, CP_OUTCOME_lang_vw B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND B.OUTCOME_CODE = A.GOAL_CODE  AND b.language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE";
//	String interventionSql		=		"SELECT A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE,B.SHORT_DESC INTVN_DESC,B.Intervention_type,A.STATUS, A.APPL_YN FROM CP_PAT_CARE_PLAN_INTVN A, CA_INTERVENTION B WHERE  A.MD_CARE_PLAN_ID =? AND	A.CARE_PLAN_ID = ? AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE";
	String interventionSql		=		"SELECT A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE,B.SHORT_DESC INTVN_DESC,B.Intervention_type,A.STATUS, A.APPL_YN FROM CP_PAT_CARE_PLAN_INTVN A, CA_INTERVENTION_lang_vw B WHERE  A.MD_CARE_PLAN_ID =? AND	A.CARE_PLAN_ID = ? AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE AND b.language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE";
//	String outcomeSql			=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC,TO_CHAR(A.OUTCOME_TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,A.STATUS, A.APPL_YN FROM	CP_PAT_CARE_PLAN_OUTCOME A, CP_OUTCOME B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND	B.OUTCOME_CODE = A.OUTCOME_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE";
	String outcomeSql			=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC,TO_CHAR(A.OUTCOME_TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,A.STATUS, A.APPL_YN FROM	CP_PAT_CARE_PLAN_OUTCOME A, CP_OUTCOME_lang_vw B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND	B.OUTCOME_CODE = A.OUTCOME_CODE AND language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE";

	ArrayList Diagnosis			=		new ArrayList();
	ArrayList Goal				=		null;
	HashMap InterventionOutcome	=		null;
	HashMap IOGroup				=		null;
	ArrayList Intervention		=		null;
	ArrayList Outcome			=		null;

	String termSet="";
	String termCode="";
	String diagDesc="";
	String startdate="";
	String enddate="";
	String temptermSet="";
	String temptermCode="";
	String diagStatus="";
	String diagStatuslegend="";
	String diagappln_yn="";
	String diagenabled="";

	String goalCode="";
	String goalDesc="";
	String goalStatus="";
	String goalStatuslegend="";
	String goalappln_yn="";
	String goalchecked="";
	String goalenabled="";
	String goalenabled1="";

	String grpid1="";
	
	String IntvnCode="";
	String IntvnDesc="";
	String IntvnStatus="";
	String IntvnStatuslegend="";
	String Intvnchecked="";
	String Intvnenabled="";
	String Intvnappln_yn="";

	String outcomeCode="";
	String outcomeDesc="";
	String outcomeStatus="";
	String outcomeStatuslegend="";
	String outcomechecked="";
	String outcomeenabled="";
	String outcomeappln_yn="";
	int index=0;

	try{
		connection	=	ConnectionManager.getConnection(request);
		//stmt		=	connection.createStatement();
		//rs			=	stmt.executeQuery(diagnosisSql);
		pstmt = connection.prepareStatement( diagnosisSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Diagnosis.add(rs.getString("TERM_SET_ID"));
			Diagnosis.add(rs.getString("TERM_CODE"));
			Diagnosis.add(rs.getString("DIAG_DESC"));
			Diagnosis.add(com.ehis.util.DateUtils.convertDate(rs.getString("START_DATE"),"DMYHM","en",locale));
			Diagnosis.add(com.ehis.util.DateUtils.convertDate(rs.getString("TARGET_DATE"),"DMYHM","en",locale));
			Goal=new ArrayList();
			Diagnosis.add(Goal);
			Diagnosis.add(rs.getString("STATUS"));
			Diagnosis.add(rs.getString("APPL_YN"));
			Diagnosis.add(rs.getString("APPL_YN"));
			Diagnosis.add(rs.getString("LIBRARY_ID"));
			Diagnosis.add(rs.getString("VERSION_NO"));
		}
		rs.close();
		pstmt.close();

		//rs=stmt.executeQuery(goalSql);
		pstmt = connection.prepareStatement( goalSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
					Goal.add(rs.getString("GOAL_CODE"));
					Goal.add(rs.getString("GOAL_DESC"));
				//Goal.add(rs.getString("GOAL_TARGET_DATE"));
					InterventionOutcome	=	new HashMap();
					Goal.add(InterventionOutcome);
					Goal.add(rs.getString("STATUS"));
					Goal.add(rs.getString("APPL_YN"));
					Goal.add(rs.getString("APPL_YN"));
				}
			}
		}
		pstmt.close();
		rs.close();
		//rs=stmt.executeQuery(interventionSql);
		pstmt = connection.prepareStatement( interventionSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			goalCode=rs.getString("GOAL_CODE");
			grpid1=rs.getString("GROUP_ID");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
						if(Goal.contains(goalCode)){
							index=Goal.indexOf(goalCode);
							InterventionOutcome=(HashMap)Goal.get(index+2);
							if(InterventionOutcome.containsKey(grpid1)){
								IOGroup=(HashMap)InterventionOutcome.get(grpid1);
								Intervention=(ArrayList)IOGroup.get("I");
								Intervention.add(rs.getString("INTERVENTION_CODE"));
								Intervention.add(rs.getString("INTVN_DESC"));
								Intervention.add(rs.getString("STATUS"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("Intervention_type"));
							}else{
								IOGroup=new HashMap();
								Intervention=new ArrayList();
								Intervention.add(rs.getString("INTERVENTION_CODE"));
								Intervention.add(rs.getString("INTVN_DESC"));
								Intervention.add(rs.getString("STATUS"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("Intervention_type"));
								IOGroup.put("I",Intervention);
								InterventionOutcome.put(grpid1,IOGroup);
							}
						}
					}
				}
			}
			rs.close();
			pstmt.close();
		//rs=stmt.executeQuery(outcomeSql);
		pstmt = connection.prepareStatement( outcomeSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			goalCode=rs.getString("GOAL_CODE");
			grpid1=rs.getString("GROUP_ID");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
					if(Goal.contains(goalCode)){
						index=Goal.indexOf(goalCode);
						InterventionOutcome=(HashMap)Goal.get(index+2);
						if(InterventionOutcome.containsKey(grpid1)){
							IOGroup=(HashMap)InterventionOutcome.get(grpid1);
							if(IOGroup.containsKey("O")){
								Outcome=(ArrayList)IOGroup.get("O");
								Outcome.add(rs.getString("OUTCOME_CODE"));
								Outcome.add(rs.getString("OUTCOME_DESC"));			
								Outcome.add(rs.getString("STATUS"));
								Outcome.add(rs.getString("APPL_YN"));	
								Outcome.add(rs.getString("APPL_YN"));	

							}else{
								Outcome=new ArrayList();
								Outcome.add(rs.getString("OUTCOME_CODE"));
								Outcome.add(rs.getString("OUTCOME_DESC"));			
								Outcome.add(rs.getString("STATUS"));
								Outcome.add(rs.getString("APPL_YN"));	
								Outcome.add(rs.getString("APPL_YN"));
								IOGroup.put("O",Outcome);
							}
						}
					}
				}
			}
		}
		rs.close();
		pstmt.close();
	
%>
	<TABLE border='0' cellpadding=0 cellspacing='0' align='center'  width='100%'> 
<%
	for(int i=0;i<Diagnosis.size();i=i+11){
		termSet=(String)Diagnosis.get(i);
		termCode=(String)Diagnosis.get(i+1);
		diagDesc=(String)Diagnosis.get(i+2);	
		startdate=(String)Diagnosis.get(i+3);
		if(startdate==null || startdate.equals(""))
			startdate="";
		if(enddate==null || enddate.equals(""))
			enddate="";		
		enddate=(String)Diagnosis.get(i+4);
		Goal=(ArrayList)Diagnosis.get(i+5);
		diagStatus=(String)Diagnosis.get(i+6);
		diagappln_yn=(String)Diagnosis.get(i+8);

		if(diagStatus.equals("O") && diagappln_yn.equals("Y"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
		else if(diagStatus.equals("O") && diagappln_yn.equals("N"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		else if(diagStatus.equals("R"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
		else if(diagStatus.equals("D"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
		else if(diagStatus.equals("9"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

		if(!diagStatus.equals("O")){
			diagenabled="Disabled";	
		}
		
%>
	<TR>
		<TD class="ATCTABLE" align="left" width="15%"><B><font size="1"><%=diagStatuslegend%></font></B></TD>
		<%--<TD class="ATCTABLE" align="center" width="3%"><INPUT TYPE="checkbox" checked <%=diagenabled%> NAME="<%=termSet%><%=termCode%>" onclick="updateDiagnosis(this,'<%=termSet%>','<%=termCode%>')"></TD>--%><!-- IN032685 -->
		<TD class="ATCTABLE" align="center" width="3%"><INPUT TYPE="checkbox" checked <%=diagenabled%> NAME="update_diag" onclick="updateDiagnosis(this,'<%=termSet%>','<%=termCode%>')"></TD><!-- IN032685 -->
		<TD class="ATCTABLE" align="left" width="48%" ><B><font size="1"><%=diagDesc%></font></B></TD>
		<TD class="ATCTABLE" align="left" width="18%"><B><font size="1"><%=startdate%></font></B></TD>
		<TD class="ATCTABLE" align="left"><B><font size="1"><%=enddate%></font></B></TD>
	</TR>
	<TR>
		<TD class="ATCTABLE" colspan="2">&nbsp;</TD>
		<TD class="ATCTABLE" colspan="3">&nbsp;</TD>
	</TR>
<%
		for(int j=0;j<Goal.size();j=j+6){
			goalCode=(String)Goal.get(j);
			goalDesc=(String)Goal.get(j+1);
			InterventionOutcome=(HashMap)Goal.get(j+2);
			goalStatus=(String)Goal.get(j+3);
			goalappln_yn=(String)Goal.get(j+4);

			if(goalStatus.equals("O") && goalappln_yn.equals("Y"))
				goalStatuslegend="Pending";
			else if (goalStatus.equals("O") && goalappln_yn.equals("N"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
			else if(goalStatus.equals("P"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PartiallyAchieved.label","cp_labels");
			else if(goalStatus.equals("A"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
			else if(goalStatus.equals("N"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
			else if(goalStatus.equals("D"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
			else if(goalStatus.equals("9"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

			if(diagStatus.equals("O") && diagappln_yn.equals("Y")){
				if(!(goalStatus.equals("O") || goalStatus.equals("P"))){
					goalenabled="Disabled";
					goalenabled1="Disabled";
					if(goalappln_yn.equals("Y"))
						goalchecked="checked";
					else
						goalchecked="";

				}else{
					goalenabled="";
					if(goalappln_yn.equals("Y"))
						goalchecked="checked";
					else{
						goalchecked="";
						goalenabled="";
						goalenabled1="Disabled";
					}

				}

			}
%>
	<TR>
		<TD class="ATCTABLE" align="left"><B><font size="1"><%=goalStatuslegend%></font></B></TD>
		<%--<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled%>  <%=goalchecked%>  NAME="<%=termSet%><%=termCode%><%=goalCode%>" onclick="updateGoal(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>')"></TD>--%><!-- IN032685-->
		<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled%>  <%=goalchecked%>  NAME="diag_code_<%=goalCode%>" onclick="updateGoal(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>')"></TD><!-- IN032685-->
		<TD class="ATCTABLE" colspan="3" align="left"><B><font size="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=goalDesc%></font></B></TD>
	</TR>

<%
			Set itr_set			=	InterventionOutcome.keySet();
			Iterator recordItr		=	itr_set.iterator();
			while(recordItr.hasNext()){
				grpid1="";
				grpid1=(String)recordItr.next();
				IOGroup=(HashMap)InterventionOutcome.get(grpid1);
				Intervention=(ArrayList)IOGroup.get("I");
				if(IOGroup.containsKey("O"))
					Outcome=(ArrayList)IOGroup.get("O");

%>
	<TR>
		<TD class="ATCTABLE" colspan="5">&nbsp;</TD>
	</TR>
<%

				if(goalchecked.equals("checked") && goalenabled.equals("")){
					
%>
	<TR>
		<TD class="ATCTABLE" colspan="2">&nbsp;</TD>
		<%--<TD class="ATCTABLE" colspan="3" id="lbl<%=termSet%><%=termCode%><%=goalCode%><%=grpid1%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label   style="cursor:pointer;color:blue " onclick="ShowAddIntvn('<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>')"><b><fmt:message key="Common.Add.label" bundle="${common_labels}"/></b></label></TD>--%><!--IN032685 -->
		<TD class="ATCTABLE" colspan="3" id="lbl_goal_<%=goalCode%><%=grpid1%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label   style="cursor:pointer;color:blue " onclick="ShowAddIntvn('<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>')"><b><fmt:message key="Common.Add.label" bundle="${common_labels}"/></b></label></TD><!--IN032685 -->
	</TR>
<%
				}else if(goalenabled.equals("")){
%>
	<TR>
		<TD class="ATCTABLE" colspan="2">&nbsp;</TD>
		<%--<TD class="ATCTABLE" colspan="3" id="lbl<%=termSet%><%=termCode%><%=goalCode%><%=grpid1%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label    style="cursor:default;color:black "></label></TD>--%><!-- IN032685 -->
		<TD class="ATCTABLE" colspan="3" id="lbl_goal_<%=goalCode%><%=grpid1%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label    style="cursor:default;color:black "></label></TD><!-- IN032685 -->
	</TR>	
<%

				}
				for(int k=0;k<Intervention.size();k=k+6){
					IntvnCode=(String)Intervention.get(k);
					IntvnDesc=(String)Intervention.get(k+1);
					IntvnStatus=(String)Intervention.get(k+2);
					Intvnappln_yn=(String)Intervention.get(k+3);

					if(IntvnStatus.equals("O") && Intvnappln_yn.equals("Y"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
					else if (IntvnStatus.equals("O") && Intvnappln_yn.equals("N"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					else if(IntvnStatus.equals("P"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartiallyCompleted.label","common_labels");
					else if(IntvnStatus.equals("C"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
					else if(IntvnStatus.equals("D"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
					else if(IntvnStatus.equals("9"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

					if(diagStatus.equals("O") &&(goalStatus.equals("O")||goalStatus.equals("P"))){
						if(!(IntvnStatus.equals("O") || IntvnStatus.equals("P"))){
							Intvnenabled="Disabled";
							if(Intvnappln_yn.equals("Y"))
								Intvnchecked="Checked";
							else
								Intvnchecked="";
						}else{
							Intvnenabled="";
							if(Intvnappln_yn.equals("Y"))
								Intvnchecked="Checked";
							else
								Intvnchecked="";


						}
					}
					
%>
	<TR>
		<TD class="ATCTABLE" align="left"><font size="1"><%=IntvnStatuslegend%></font></TD>
		<%--<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled1%> <%=Intvnenabled%> <%=Intvnchecked%> NAME="<%=termSet%><%=termCode%><%=goalCode%><%=IntvnCode%>" onclick="updateIntvn(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>','<%=IntvnCode%>')"></TD>--%><!-- IN032685 -->
		<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled1%> <%=Intvnenabled%> <%=Intvnchecked%> NAME="intv_code_<%=goalCode%><%=IntvnCode%>" onclick="updateIntvn(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>','<%=IntvnCode%>')"></TD><!-- IN032685 -->
		<TD class="ATCTABLE" colspan="3" align="left"><font size="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<B>I</B>]&nbsp;&nbsp;&nbsp;<%=IntvnDesc%></font></TD>
	</TR>
		
<%
					IntvnDesc="";
					IntvnStatus="";
					IntvnStatuslegend="";
					Intvnchecked="";
					Intvnenabled="";
					Intvnappln_yn="";
				}
				if(Outcome!=null){
					for(int k=0;k<Outcome.size();k=k+5){
						outcomeCode=(String)Outcome.get(k);
						outcomeDesc=(String)Outcome.get(k+1);
						
						outcomeStatus=(String)Outcome.get(k+2);
						outcomeappln_yn=(String)Outcome.get(k+3);

						if(outcomeStatus.equals("O") && outcomeappln_yn.equals("Y"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
						else if(outcomeStatus.equals("O") && outcomeappln_yn.equals("N"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else if(outcomeStatus.equals("P"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PartiallyAchieved.label","cp_labels");
						else if(outcomeStatus.equals("A"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
						else if(outcomeStatus.equals("N"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
						else if(outcomeStatus.equals("D"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
						else if(outcomeStatus.equals("9"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			
						if(diagStatus.equals("O") &&(goalStatus.equals("O")||goalStatus.equals("P"))){
							if(!(outcomeStatus.equals("O") || outcomeStatus.equals("P"))){
								outcomeenabled="Disabled";
								if(outcomeappln_yn.equals("Y"))
									outcomechecked="Checked";
								else
									outcomechecked="";
							}else{
								outcomeenabled="";
								if(outcomeappln_yn.equals("Y"))
									outcomechecked="Checked";
								else
									outcomechecked="";
							}	
						}
%>
	<TR>
		<TD class="ATCTABLE" align="left"><font size="1"><%=outcomeStatuslegend%></font></TD>
		<%--<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled1%> <%=outcomechecked%> <%=outcomeenabled%> NAME="<%=termSet%><%=termCode%><%=goalCode%><%=outcomeCode%>" onclick="updateOutcome(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>','<%=outcomeCode%>')"></TD>--%><!-- IN032685 -->
		<TD class="ATCTABLE" align="center"><INPUT TYPE="checkbox" <%=diagenabled%> <%=goalenabled1%> <%=outcomechecked%> <%=outcomeenabled%> NAME="out_code_<%=goalCode%><%=outcomeCode%>" onclick="updateOutcome(this,'<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=grpid1%>','<%=outcomeCode%>')"></TD><!-- IN032685 -->
		 <TD class="ATCTABLE" colspan="3" align="left"><font size="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<B>O</B>]&nbsp;&nbsp;&nbsp;<%=outcomeDesc%></font></TD>
	</TR>
		
<%
						outcomeDesc="";
						outcomeStatus="";
						outcomeStatuslegend="";
						outcomechecked="";
						outcomeenabled="";
						outcomeappln_yn="";
					}

				}
				IOGroup=null;
				Intervention=null;
				Outcome=null;
			}
%>
	<TR>
		<TD class="ATCTABLE" colspan="2">&nbsp;</TD>
		<TD class="ATCTABLE" colspan="3">&nbsp;</TD>
	</TR>

<%
			goalDesc="";
			goalStatus="";
			goalappln_yn="";
			goalenabled="";
			goalenabled1="";
			goalchecked="";
			goalStatuslegend="";
			InterventionOutcome=null;
						
		}
		diagDesc="";
		startdate="";
		enddate="";
		diagStatus="";
		diagStatuslegend="";
		diagenabled="";
	}
%>
	</TABLE>
		<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
		<INPUT TYPE="hidden" name="md_care_plan_id" id="md_care_plan_id" value="<%=md_care_plan_id%>">
		<INPUT TYPE="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<INPUT TYPE="hidden" name="care_mgr_id" id="care_mgr_id" value="<%=care_mgr_id%>">
	</FORM>
	</BODY>
	</HTML>
<%
	
	ReviseCarePlan.putObject(Diagnosis);
	//out.println("Diagnosis"+Diagnosis);

	}catch(Exception e){
		System.err.println(e.toString());
		e.printStackTrace();
	}finally{
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(connection,request);
	}
%>

