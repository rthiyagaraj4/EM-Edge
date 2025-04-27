<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="ReviseCarePlan" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="ReviseCarePlanRecordchanges" class="webbeans.eCommon.RecordSet" scope="session"/>

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
		<SCRIPT language='javascript' src='../../eCommon/js/dchk.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<SCRIPT language="javascript" src="../js/ReviseCarePlan.js"></SCRIPT> 
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
</HEAD>

<BODY onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()">
<!-- style="overflow-y:scroll;overflow-x:hidden" -->
<FORM name="formReviseCareplanRecordchanges" id="formReviseCareplanRecordchanges"  action="../../servlet/eCP.ReviseCarePlanServlet" target="messageFrame" method="post">
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
	String md_care_plan_id=request.getParameter("md_care_plan_id");
	int mdcareplanid=Integer.parseInt(md_care_plan_id);
	String care_plan_id=request.getParameter("care_plan_id");
	int careplanid=Integer.parseInt(care_plan_id);
	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String care_mgr_id=request.getParameter("care_mgr_id");
	
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
	java.util.Date date_time	 	= new java.util.Date();
	String dateString 				= dtSystemFormat.format(date_time);
	String dateString1 				= com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale);

	Connection connection		=	null;
	Statement stmt				=	null;
    PreparedStatement pstmt		=	null;
    PreparedStatement pstmt1	=	null;
	ResultSet rs				=	null;

	ArrayList Diagnosis			=	new ArrayList();
	ArrayList Goal				=	null;
	HashMap InterventionOutcome	=	null;
	HashMap IOGroup				=	null;
	ArrayList Intervention		=	null;

	HashMap Intvn				=	new HashMap();
	ArrayList IntvnDtl			=	null;
	ArrayList DurationType		=	new ArrayList();
	ArrayList Frequency			=	null;
	ArrayList Stage				=	new ArrayList();
	ArrayList Position			=	null;

	//String	sqlPosition			=	"SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) ORDER BY 2";
	String	sqlPosition			=	"SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION_lang_vw  AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= ?) AND language_id = ? ORDER BY 2";

//	String sqlFrequency			=	"SELECT A.FREQ_CODE, 'Y' DEFAULT_YN, B.FREQ_DESC,B.INTERVAL_DURN_TYPE FREQ_DURNUNIT  FROM CA_INTERVENTION_FREQ A, AM_FREQUENCY B, CP_PAT_CARE_PLAN_INTVN_DTL C WHERE A.FREQ_CODE = B.FREQ_CODE AND B.FREQ_CODE = C.FREQ_CODE AND A.INTERVENTION_CODE = ? AND A.FREQ_CODE = B.FREQ_CODE  and c.intervention_code= a.intervention_code AND C.MD_CARE_PLAN_ID = "+mdcareplanid+" AND C.CARE_PLAN_ID = "+careplanid+" AND C.STATUS='O' UNION SELECT FREQ_CODE, 'N' DEFAULT_YN, FREQ_DESC, INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM AM_FREQUENCY  WHERE FREQ_CODE IN (SELECT FREQ_CODE FROM CA_INTERVENTION_FREQ WHERE INTERVENTION_CODE = ? ) AND FREQ_CODE NOT IN (SELECT FREQ_CODE FROM CP_PAT_CARE_PLAN_INTVN_DTL WHERE MD_CARE_PLAN_ID = "+mdcareplanid+" AND CARE_PLAN_ID = "+careplanid+" AND INTERVENTION_CODE = ? AND STATUS='O') ORDER BY FREQ_DESC";
	String sqlFrequency			=	"SELECT A.FREQ_CODE, 'Y' DEFAULT_YN, B.FREQ_DESC,B.INTERVAL_DURN_TYPE FREQ_DURNUNIT  FROM CA_INTERVENTION_FREQ A, AM_FREQUENCY_LANG_VW B, CP_PAT_CARE_PLAN_INTVN_DTL C WHERE A.FREQ_CODE = B.FREQ_CODE AND B.FREQ_CODE = C.FREQ_CODE AND A.INTERVENTION_CODE = ? AND A.FREQ_CODE = B.FREQ_CODE  AND c.intervention_code= a.intervention_code AND C.MD_CARE_PLAN_ID = "+mdcareplanid+" AND C.CARE_PLAN_ID = "+careplanid+" AND C.STATUS='O' and B.LANGUAGE_ID = ? UNION SELECT FREQ_CODE, 'N' DEFAULT_YN, FREQ_DESC, INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM AM_FREQUENCY_lang_vw  WHERE FREQ_CODE IN (SELECT FREQ_CODE FROM CA_INTERVENTION_FREQ WHERE INTERVENTION_CODE = ? ) AND FREQ_CODE NOT IN (SELECT FREQ_CODE FROM CP_PAT_CARE_PLAN_INTVN_DTL WHERE MD_CARE_PLAN_ID = "+mdcareplanid+" AND CARE_PLAN_ID = "+careplanid+" AND INTERVENTION_CODE = ? AND STATUS='O') AND LANGUAGE_ID = ? ORDER BY FREQ_DESC";

	//String sqlDurationType		=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE ORDER BY 2";
	String sqlDurationType		=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_LANG_vW WHERE LANGUAGE_ID = '"+locale+"' ORDER BY 2";
	//String sqlStage				=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE WHERE EFF_STATUS='E' ORDER BY 2";
	String sqlStage				=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_LANG_VW WHERE EFF_STATUS='E' AND LANGUAGE_ID = '"+locale+"' ORDER BY 2";
//	String sqlInterventionDtl	=	"SELECT	a.intervention_code, D.SHORT_DESC INTVN_DESC, A.FREQ_CODE,B.FREQ_DESC ,A.DURATION ,A.DURN_TYPE,Decode(A.DURN_TYPE,'D','Day(s)','H','Hour(s)','M','Minute(s)', 'L','Month(s)','W','Week(s)','')FREQ_DURN_UNIT_LEGEND ,TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')END_DATE,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,A.STATUS ,A.STATUS_DATE, A.POSITION_CODE,f.POSITION_DESC ,A.ROLE_TYPE,DECODE(a.priority,'N','Normal','C','Critical','H','High') priority ,A.STAGE_CODE,e.SHORT_DESC stage_Desc FROM		CP_PAT_CARE_PLAN_INTVN_DTL A, AM_FREQUENCY B ,AM_DURATION_TYPE C,  ca_intervention d, CP_STAGE e,AM_POSITION f WHERE  A.MD_CARE_PLAN_ID = ? AND A.CARE_PLAN_ID = ? and D.INTERVENTION_CODE = A.INTERVENTION_CODE AND A.STATUS NOT IN ('9','D') AND A.FREQ_CODE = B.FREQ_CODE(+) AND		A.DURN_type = C.DURN_TYPE (+)  AND a.POSITION_CODE=f.position_code(+)    AND a.stage_code=e.stage_code(+) ORDER BY  A.START_DATE desc";
	String sqlInterventionDtl	=	"SELECT	a.intervention_code, D.SHORT_DESC INTVN_DESC, A.FREQ_CODE,B.FREQ_DESC ,A.DURATION ,A.DURN_TYPE,A.DURN_TYPE FREQ_DURN_UNIT_LEGEND ,TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')END_DATE,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,A.STATUS ,A.STATUS_DATE, A.POSITION_CODE,f.POSITION_DESC ,A.ROLE_TYPE,a.priority priority ,A.STAGE_CODE,e.SHORT_DESC stage_Desc FROM CP_PAT_CARE_PLAN_INTVN_DTL A, AM_FREQUENCY_LANG_VW B ,AM_DURATION_TYPE C,  ca_intervention_LANG_VW d, CP_STAGE_LANG_VW e,AM_POSITION_LANG_VW f WHERE  A.MD_CARE_PLAN_ID = ? AND A.CARE_PLAN_ID = ? AND D.INTERVENTION_CODE = A.INTERVENTION_CODE AND A.STATUS NOT IN ('9','D') AND A.FREQ_CODE = B.FREQ_CODE(+) AND		A.DURN_type = C.DURN_TYPE (+)  AND a.POSITION_CODE=f.position_code(+)    AND a.stage_code=e.stage_code(+) AND B.LANGUAGE_ID(+) = ? AND D.LANGUAGE_ID = ? AND E.LANGUAGE_ID(+) = ? AND F.LANGUAGE_ID(+) = ? ORDER BY  A.START_DATE DESC";
	String diagcurapply_yn="";
	String goalcurapply_yn="";
	String intvncurapply_yn="";
	String grpid="";
	String IntvnCode="";
	String IntvnDesc="";
	String startdate="";
	String enddate="";

	String freq="";
	String freqcode="";
	String tempfreq="";
	String freqstatus="";
	String freqselect="";
	String freq_durnunit="";
	String freq_durnunitload="";
	String freq_default_yn="";
	char ch_durn_unit =	' ';
	String freqoptname = "";


	String stagedesc="";
	String stagecode="";
	String positiondesc="";
	String positioncode="";
	String priority="";
	String prioritycode="";
	String duration="";
	String durationtype="";
	String durationlegend="";
	String color="";
	int index=1;
	int loopindex=0;

	ArrayList sessionList		=	(ArrayList)ReviseCarePlan.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		Diagnosis=(ArrayList)ReviseCarePlan.getObject(0);
	}


	try{
		connection	=	ConnectionManager.getConnection(request);
		stmt		=	connection.createStatement();
		
		//rs			=	stmt.executeQuery(sqlFrequency);
		//while(rs.next()){
		//	Frequency.add(rs.getString("FREQ_CODE"));
		//	Frequency.add(rs.getString("FREQ_DESC"));
		//}
		//rs.close();
		rs			=	stmt.executeQuery(sqlDurationType);
		while(rs.next()){
			DurationType.add(rs.getString("DURN_TYPE"));
			DurationType.add(rs.getString("DURN_DESC"));
		}
		rs.close();
//		stmt.close();

		rs			=	stmt.executeQuery(sqlStage);
		while(rs.next()){
			Stage.add(rs.getString("STAGE_CODE"));
			Stage.add(rs.getString("SHORT_DESC"));
		}
		rs.close();
//		stmt.close();
		
		
		for(int i=0;i<Diagnosis.size();i=i+11){
			diagcurapply_yn=(String)Diagnosis.get(i+8);
			if(diagcurapply_yn.equals("Y")){
				Goal=(ArrayList)Diagnosis.get(i+5);
				for(int j=0;j<Goal.size();j=j+6){
					goalcurapply_yn=(String)Goal.get(j+5);
					if(goalcurapply_yn.equals("Y")){
						InterventionOutcome=(HashMap)Goal.get(j+2);
						Set itr_set			=	InterventionOutcome.keySet();
						Iterator recordItr	=	itr_set.iterator();
						while(recordItr.hasNext())
						{	
							grpid=(String)recordItr.next();
							IOGroup=(HashMap)InterventionOutcome.get(grpid);
							Intervention=(ArrayList)IOGroup.get("I");
							for(int k=0;k<Intervention.size();k=k+6){
								intvncurapply_yn=(String)Intervention.get(k+4);
								//out.println("intvncurapply_yn "+intvncurapply_yn);
								IntvnCode=(String)Intervention.get(k);
								IntvnDesc=(String)Intervention.get(k+1);
								if(intvncurapply_yn.equals("Y")){
									if(!Intvn.containsKey(IntvnCode)){
										IntvnDtl=new ArrayList();
										IntvnDtl.add(IntvnDesc);
										IntvnDtl.add("O");
										IntvnDtl.add("Y");
										IntvnDtl.add("Y");
										IntvnDtl.add(dateString);
										IntvnDtl.add("");
										IntvnDtl.add("0");
										IntvnDtl.add("D");
										IntvnDtl.add(dateString);
										IntvnDtl.add("");
										IntvnDtl.add("N");
										IntvnDtl.add("");
										IntvnDtl.add((String)Intervention.get(k+5));
										IntvnDtl.add("N");

										Intvn.put(IntvnCode,IntvnDtl);

									}
								}
							}
							grpid="";
							IOGroup=null;
							Intervention=null;
						}
					}
				}
			}
		}
		//System.err.println("Intvn"+Intvn);
		
		//rs=stmt.executeQuery(sqlInterventionDtl);
		pstmt = connection.prepareStatement( sqlInterventionDtl);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locale);
		rs=pstmt.executeQuery();
		//System.err.println("rs "+rs);
		if(rs!=null){
			while(rs.next()){
				IntvnCode=rs.getString("intervention_code");
				//System.err.println("IntvnCode in change  "+IntvnCode);
				if(Intvn.containsKey(IntvnCode)){
					IntvnDtl=(ArrayList)Intvn.get(IntvnCode);
					IntvnDtl.add(rs.getString("freq_code"));
					IntvnDtl.add(rs.getString("freq_desc"));
					IntvnDtl.add(rs.getString("DURATION"));
					IntvnDtl.add(rs.getString("durn_type"));
					String freqDurationLegend=rs.getString("freq_durn_unit_legend");
					if(freqDurationLegend.equals("")) freqDurationLegend="";
					if(freqDurationLegend.equals("D")) freqDurationLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","cp_labels");
					if(freqDurationLegend.equals("H")) freqDurationLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
					if(freqDurationLegend.equals("M")) freqDurationLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
					if(freqDurationLegend.equals("L")) freqDurationLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Months.label","cp_labels");
					if(freqDurationLegend.equals("W")) freqDurationLegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Weeks.label","cp_labels");
					
					IntvnDtl.add(freqDurationLegend);
					IntvnDtl.add(rs.getString("start_date"));
					IntvnDtl.add(rs.getString("end_date"));
					IntvnDtl.add(rs.getString("position_code"));
					IntvnDtl.add(rs.getString("position_desc"));
					IntvnDtl.add(rs.getString("stage_code"));
					IntvnDtl.add(rs.getString("stage_desc"));
					String priori1=rs.getString("priority");
					if(priori1.equals("N")) priori1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
					if(priori1.equals("C")) priori1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
					if(priori1.equals("H")) priori1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
					IntvnDtl.add(priori1);
				//	System.err.println("IntvnDtl "+IntvnDtl);
				}
			}
		}
		rs.close();
		pstmt.close();

		//System.err.println("Intvn"+Intvn);
		
		if(Intvn.size()>0){
	
%>
	<TABLE border='1'cellpadding='0' cellspacing='0' align='center' width="150%" > 
		<TH align="center" width="4%"><fmt:message key="Common.revise.label" bundle="${common_labels}"/></TH>
		<TH align="left" WRAP width="15%"><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></TH>
		<TH align="left" width="9%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TH>
		<TH align="left" width="9%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></TH>
		<TH align="left" width="8%"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></TH>
		<TH align="left" width="9%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TH>
		<TH align="left"  width="11%"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></TH>
		<TH align="left" width="6%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></TH>
		<TH align="left" width="9%"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></TH>
<%
			Set itr_set			=	Intvn.keySet();
			Iterator recordItr		=	itr_set.iterator();
			pstmt = connection.prepareStatement( sqlPosition);
			pstmt1= connection.prepareStatement( sqlFrequency);

			while(recordItr.hasNext()){
				loopindex	=	1;
				Position	=	new ArrayList();
				Frequency	=	new ArrayList();
			
				IntvnCode=(String)recordItr.next();
				IntvnDtl=(ArrayList)Intvn.get(IntvnCode);
				IntvnDesc=(String)IntvnDtl.get(0);
				//System.out.println("Intvn"+Intvn);
				if(IntvnDtl.size()>14){
					color="Black";
					
				}else{
					color="#990000";
					IntvnDtl.set(1,"N");
				}
				//sqlPosition	="SELECT POSITION_CODE,POSITION_DESC FROM AM_POSITION WHERE EFF_STATUS='E' AND EXISTS(SELECT 1 FROM CA_INTERVENTION_FOR_POSN WHERE POSITION_CODE=AM_POSITION.POSITION_CODE AND INTERVENTION_CODE= '"+IntvnCode+"') ORDER BY 2";
				//rs			=	stmt.executeQuery(sqlPosition);
				pstmt.setString(1,IntvnCode);
				pstmt.setString(2,locale);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Position.add(rs.getString("POSITION_CODE"));
					Position.add(rs.getString("POSITION_DESC"));
				}
				rs.close();
//				pstmt.close();
				//System.err.println("Intvn "+Position);
				if(Position.size()>0){
					IntvnDtl.set(11,(String)Position.get(0));
				}
				pstmt1.setString(1,IntvnCode);
				pstmt1.setString(3,IntvnCode);
				pstmt1.setString(4,IntvnCode);
				pstmt1.setString(2,locale);
				pstmt1.setString(5,locale);
				rs=pstmt1.executeQuery();
				while(rs.next()){
					Frequency.add(rs.getString("FREQ_CODE"));
					Frequency.add(rs.getString("FREQ_DESC"));
					freq_default_yn=rs.getString("DEFAULT_YN");
					Frequency.add(freq_default_yn);
					freq_durnunit=rs.getString("FREQ_DURNUNIT");
					Frequency.add(freq_durnunit);
					if(freq_default_yn.equals("Y"))
						freq_durnunitload=freq_durnunit;
				}
				rs.close();
//				pstmt1.close();
				//System.err.println("mdcareplanid "+mdcareplanid);
				//System.err.println("careplanid "+careplanid);
				//System.err.println("IntvnCode "+IntvnCode);
				//System.err.println("IntvnDesc "+IntvnDesc);
				//System.err.println("Frequency "+Frequency);
		%>
			<TR>
				 <TD class='GRPEVENS1' align="center"><INPUT TYPE="checkbox"  name="Intvn<%=index%>" id="Intvn<%=index%>" onclick="UpdateIntvnDtl('<%=index%>','<%=IntvnCode%>')" value='N'></TD> 
	<%			if(((String)IntvnDtl.get(1)).equals("O")){
	%>
				<TD class='GRPEVENS1'><font size="1" color="<%=color%>"><%=IntvnDesc%></font></TD>
	<%			}else{
	%>
					<TD class='GRPEVENS1'><font size="1" color="<%=color%>"><B><%=IntvnDesc%></B></font></TD>
	<%			}
	%>
				<TD class='GRPEVENS1' align="center" align="center">
					<input type="text" name="start_date<%=index%>" id="start_date<%=index%>" size='15' maxlength='16' value="<%=dateString1%>" style='font-size:8pt' onblur="RCPCheckStartDate(this,start_date<%=index%>,end_date<%=index%>,duration<%=index%>,durationtype<%=index%>,curdatetime,'<%=index%>','<%=IntvnCode%>')">
					<img src="../../eCommon/images/CommonCalendar.gif" onclick=' showCalendar("start_date<%=index%>",null,"hh:mm",true);return false;'>
				</TD>
				<TD class='GRPEVENS1' align="center">
					<select style='font-size:8pt' name="frequency<%=index%>" id="frequency<%=index%>" onchange="loadDurntypes(this,'<%=index%>','<%=IntvnCode%>');UpdateIntvnDtl('<%=index%>','<%=IntvnCode%>')">
						
	<%
				for(int i=0;i<Frequency.size();i=i+4){
					tempfreq=(String)Frequency.get(i);
					freqstatus=(String)Frequency.get(i+2);
//					System.err.println("tempfreq" +tempfreq);
					if(freqstatus.equals("Y")){
						freqselect="Selected";
						IntvnDtl.set(5,tempfreq);
					}else
						freqselect="";
					freqoptname=IntvnCode+','+(String)Frequency.get(i)+','+(String)Frequency.get(i+3);

	%>
						<option value="<%=freqoptname%>" <%=freqselect%> ><%=(String)Frequency.get(i+1)%></option>
	<%
				}
	%>
					</select>
				</TD>
				<TD class='GRPEVENS1' align="center"><font size="1">
					<input type="text" name="duration<%=index%>" id="duration<%=index%>" class="number" value='1'size='1' maxlength='2' onBlur="RCPCheckNum(this,start_date<%=index%>,durationtype<%=index%>,end_date<%=index%>,'<%=index%>','<%=IntvnCode%>');" style='font-size:8pt' >

					<select style='font-size:8pt' name="durationtype<%=index%>" id="durationtype<%=index%>" onchange="RCPCheckNum(duration<%=index%>,start_date<%=index%>,durationtype<%=index%>,end_date<%=index%>,'<%=index%>','<%=IntvnCode%>');">
	<%
					if(Frequency.size()>0){
						if(freq_durnunitload !=null && freq_durnunitload.equals(""))
							freq_durnunitload=(String)Frequency.get(3);
					}
					if(freq_durnunitload ==null)
						ch_durn_unit=' ';
					else
				   ch_durn_unit=freq_durnunitload.charAt(0);	
				switch(ch_durn_unit){
					case 'M' :
%>
						<option  value="M" ><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
<%			
					case 'H':
%>
						<option  value="H" ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/> </option>
<%
					case 'D':
%>
						<option  value="D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
<%
					case 'W':
%>
					<option  value="W" ><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/></option>
<%
					case 'L':
%>
						<option  value="L" ><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
<%
							break;
					default:
%>
						<option  value="M" ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
						<option value="H" ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						<option value="D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/> </option>
						<option value="W" ><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/> </option>
						<option value="L" ><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
<%
				}
%>
					</select>
				</TD>
				<TD class='GRPEVENS1' align="center">
					<input type="text" name="end_date<%=index%>" id="end_date<%=index%>" size='15' maxlength='16' value="<%=dateString1%>" style='font-size:8pt' readonly>
				</TD>
				<TD class='GRPEVENS1' align="center">
					<select style='font-size:8pt' name="stage<%=index%>" id="stage<%=index%>" onchange="UpdateIntvnDtl('<%=index%>','<%=IntvnCode%>')">
						<option value="">--<fmt:message key="Common.all.label" bundle="${common_labels}"/>--</option>
	<%
				for(int i=0;i<Stage.size();i=i+2){
					
	%>
						<Option value="<%=Stage.get(i)%>"><%=Stage.get(i+1)%></option>
	<%
			}
	%>
					</select>
				</TD>
				<TD class='GRPEVENS1'align="center">
				<select style='font-size:8pt' name="priority<%=index%>" id="priority<%=index%>" onchange="UpdateIntvnDtl('<%=index%>','<%=IntvnCode%>')">
					<option value="N" ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value="H" ><fmt:message key="Common.High.label" bundle="${common_labels}"/></option>
					<option value="C" ><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></option>
				<select>
			</TD>
				<TD class='GRPEVENS1' align="center"><font size="1">
					<select style='font-size:8pt' name="positon<%=index%>" id="positon<%=index%>" onchange="UpdateIntvnDtl('<%=index%>','<%=IntvnCode%>')">
						<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
	<%
				if(Position.size()>0){
					for(int i=0;i<Position.size();i=i+2){
	%>
					<option value="<%=(String)Position.get(i)%>"><%=(String)Position.get(i+1)%></option>
	<%
					}
				}
	%>
					</select>
				</TD>	
			</TR>

		<%
			
				if(IntvnDtl.size()>14){
					for(int i=14;i<IntvnDtl.size();i=i+12){
						startdate=(String)IntvnDtl.get(i+5)==null?"":(String)IntvnDtl.get(i+5);
						freq=(String)IntvnDtl.get(i+1)==null?"":(String)IntvnDtl.get(i+1);
						freqcode=(String)IntvnDtl.get(i)==null?"":(String)IntvnDtl.get(i);
						duration=(String)IntvnDtl.get(i+2)==null?"":(String)IntvnDtl.get(i+2);
						durationlegend=(String)IntvnDtl.get(i+4)==null?"":(String)IntvnDtl.get(i+4);
						durationtype=(String)IntvnDtl.get(i+3)==null?"":(String)IntvnDtl.get(i+3);
						enddate=(String)IntvnDtl.get(i+6)==null?"":(String)IntvnDtl.get(i+6);
						stagedesc=(String)IntvnDtl.get(i+10)==null?"":(String)IntvnDtl.get(i+10);
						stagecode=(String)IntvnDtl.get(i+9)==null?"":(String)IntvnDtl.get(i+9);
						positiondesc=(String)IntvnDtl.get(i+8)==null?"":(String)IntvnDtl.get(i+8);
						positioncode=(String)IntvnDtl.get(i+7)==null?"":(String)IntvnDtl.get(i+7);
						priority=(String)IntvnDtl.get(i+11)==null?"":(String)IntvnDtl.get(i+11);
						if(priority.equals("High"))
							prioritycode="H";
						else if(priority.equals("Critical"))
							prioritycode="C";
						else
							prioritycode="N";
						

		%>
			<TR>
				<!-- <label id="orderLink1" style="cursor:pointer" onClick="identityOperation(orderLink1,'P')">-</label> -->
                <TD class='GRPEVENS1' align="center" >&nbsp;</TD>
				<TD class='GRPEVENS1' align="center" >&nbsp;</TD>
				<TD class='GRPEVENS1' align="center"><font size=1><B><%=com.ehis.util.DateUtils.convertDate(startdate,"DMYHM","en",locale)%></B></font></TD>
				<TD class='GRPEVENS1' align="left"><font size=1><B>&nbsp;&nbsp;<label id="stagelbl" style="cursor:pointer" onclick="setfrequency('<%=freqcode%>',frequency<%=index%>,'<%=IntvnCode%>','<%=index%>')"><%=freq%></label></B></font></TD>
				<TD class='GRPEVENS1' align="center"><font size=1><B><label id="durationlbl" style="cursor:pointer" onclick="setduration('<%=duration%>','<%=durationtype%>',duration<%=index%>,durationtype<%=index%>,'<%=IntvnCode%>','<%=index%>',start_date<%=index%>,end_date<%=index%>)"><%=duration%>&nbsp;<%=durationlegend%></label></B></font></TD>
				<TD class='GRPEVENS1' align="center"><font size=1><B><%=com.ehis.util.DateUtils.convertDate(enddate,"DMYHM","en",locale)%></B></font></TD>
				<TD class='GRPEVENS1' align="left"><font size=1><B>&nbsp;&nbsp;&nbsp;&nbsp;<label id="stagelbl" style="cursor:pointer" onclick="setstage('<%=stagecode%>',stage<%=index%>,'<%=IntvnCode%>','<%=index%>')"><%=stagedesc%></label></B></font></TD>
				<TD class='GRPEVENS1' align="left"><font size=1><B>&nbsp;&nbsp;&nbsp;&nbsp;<label id="stagelbl" style="cursor:pointer" onclick="setpriority('<%=prioritycode%>',priority<%=index%>,'<%=IntvnCode%>','<%=index%>')"><%=priority%></label></B></font></TD>
				<TD class='GRPEVENS1' align="left"><font size=1><B>&nbsp;&nbsp;&nbsp;&nbsp;<label id="stagelbl" style="cursor:pointer" onclick="setposition('<%=positioncode%>',positon<%=index%>,'<%=IntvnCode%>','<%=index%>')"><%=positiondesc%></label></B></font></TD>
			</TR>
		<%
				 startdate="";
				 enddate="";
				 freq="";
				 freqcode="";
				 stagedesc="";
				 stagecode="";
				 positiondesc="";
				 positioncode="";
				 priority="";
				 duration="";
				 durationtype="";
				 durationlegend="";
				 freq_durnunitload="";
				 loopindex++;
					}
				}
				index++;
			}
               pstmt.close();
               pstmt1.close();
		}
	//	out.println("Intvn "+Intvn);
		ReviseCarePlanRecordchanges.clearAll();
		ReviseCarePlanRecordchanges.putObject(Intvn);
%>
	</TABLE>
		<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
		<INPUT TYPE="hidden" name="md_care_plan_id" id="md_care_plan_id" value="<%=md_care_plan_id%>">
		<INPUT TYPE="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<INPUT TYPE="hidden" name="care_mgr_id" id="care_mgr_id" value="<%=care_mgr_id%>">
		<INPUT TYPE="hidden" name="curdatetime" id="curdatetime" value="<%=dateString%>">
		<INPUT TYPE='hidden' name='target_date' id='target_date' value='<%=dateString%>'>
	   <INPUT TYPE='hidden' name='tot_rec' id='tot_rec' value='<%=index%>'>
	   <INPUT TYPE='hidden' name='locale' id='locale' value='<%=locale%>'>
	</FORM>
	<script>

	   CalculateEndDate();
	</script>
	</BODY>
	</HTML>

<%

	}catch(Exception e){
	System.err.println(e.toString());
	e.printStackTrace();
}finally{
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	if (pstmt1 != null) pstmt1.close();
	if (stmt != null) stmt.close();
	ConnectionManager.returnConnection(connection,request);
}

%>

