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
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,java.net.*,java.text.*,eOR.Common.*"%>

<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<%
		//This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		 String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT> 
</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formBuildLibraryInterventionDetails" id="formBuildLibraryInterventionDetails" style="overflow-y:scroll;overflow-x:hidden">
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

<%
String alphalink				=	request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet					=	request.getParameter("termSet");
String termCode					=	request.getParameter("termCode");
String goalCode					=	request.getParameter("goalCode");
String libraryid				=	request.getParameter("libraryid");
String versionno				=	request.getParameter("versionno");
String maxGrpID					=	request.getParameter("maxGrpID");
String GroupID1					=	request.getParameter("GroupID");
int GroupID						=	Integer.parseInt(GroupID1);

if(!GroupID1.equals("0")){
	maxGrpID=GroupID1;
}
//out.println("maxGrpID"+maxGrpID);
//out.println("GroupID1"+GroupID1);
alphalink						=	alphalink.trim();
Connection connection			=	null;
PreparedStatement pstmt			=	null;
PreparedStatement pstmt1			=	null;//common-icn-0180
PreparedStatement pstmt2			=	null;//common-icn-0180
PreparedStatement pstmt3			=	null;//common-icn-0180
Statement stmt					=	null;
ResultSet rs					=	null;
Statement stmt1					=	null;
ResultSet rs1					=	null;
String from						=	request.getParameter("from") ;
String to						=	request.getParameter("to") ;
String classValue				=	"";
String  sqlData					=	"";
String interventionTypeDesc		=	"";
String interventionCode			=	"";
String interventionDesc			=	"";
String Alt						=	"";
String relativeStart			=	"";
String relativeStartType		=	"";
String tempRelativeStartType	=	"";
String relativeStartSelect		=	"";
String frequency				=	"";
String tempfreq					=	"";
String tempFrequency			=	"";
String frequencySelect			=	"";
String freqdurnunit				=	"";
String freqdurnunitload			=	"";
String freq_default_yn			=	"";
char ch_durn_unit				=	' ';
String freqoptname				=	"";
String Duration					=	"";
String DurationType				=	"";
//String tempDurationType			=	"";
String MDurationSelect			=	"";
String HDurationSelect			=	"";
String WDurationSelect			=	"";
String LDurationSelect			=	"";
String DDurationSelect			=	"";

String dependency				=	"";
String dependencySelect			=	"";
String stage					=	"";
String tempStage				=	"";
String stageSelect				=	"";
String status					=	"";
String checkAttribute			=	"";
String GrpID					=	"";
String disabled					=	"";
String readonly					=	"";
int GrpID1						=	0;
//String sqlFrequency				=	"SELECT FREQ_CODE,FREQ_DESC FROM AM_FREQUENCY WHERE EFF_STATUS='E' ORDER BY 2";
//String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY                     B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE ";
//String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY_LANG_VW B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE AND B.LANGUAGE_ID = '"+locale+"'";//common-icn-0180
String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY_LANG_VW B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE AND B.LANGUAGE_ID = ?";//common-icn-0180


//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";
//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";//common-icn-0180
String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id= ?";//common-icn-0180


//String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id='"+locale+"' and EFF_STATUS='E' ORDER BY 2";
//String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id='"+locale+"' and EFF_STATUS='E' ORDER BY 2";//common-icn-0180
String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id= ? and EFF_STATUS='E' ORDER BY 2";//common-icn-0180


//ArrayList frequencyList			=	new ArrayList();
ArrayList IntvnfreqList			=	null;
ArrayList DurationList			=	new ArrayList();
ArrayList StageList				=	new ArrayList();
ArrayList TermCodeList			=	null;
ArrayList Goal					=	null;
HashMap	interventionOutcome		=	null;
ArrayList Intervention			=	null;

String tempTermSet				=	"";
String tempTermCode				=	"";

int maxRecord					=	0;
int dep							=	0;
int start						=	0 ;
int end							=	0 ;
int i							=	1;
 if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 5 ; }   else {  end = Integer.parseInt( to ) ; }

 ArrayList sessionList				=		(ArrayList)BuildLibrary.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		TermCodeList=(ArrayList)BuildLibrary.getObject(0);
	}
	
if(alphalink.equals("Associated") && !GroupID1.equals("0")){	
//	sqlData="SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  A.GOAL_CODE = '"+goalCode+"' AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
	sqlData		=	"SELECT INTERVENTION_CODE,SHORT_DESC INTERVENTION_DESC FROM CA_INTERVENTION_LANG_VW WHERE INTERVENTION_CODE IN (";
	boolean first_time=true;
	for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet		=	(String)TermCodeList.get(j);
				 tempTermCode		=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal				=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Intervention			=	(ArrayList)interventionOutcome.get("I");
						 if(Intervention.size()>0){
							 for(int k=0;k<Intervention.size();k=k+13){
								 if(!first_time)
									 sqlData =sqlData+",";
								 if(first_time){
									 sqlData =sqlData+"'"+(String)Intervention.get(k)+"'";
									 first_time=false;
								 }
								 else{
									sqlData =sqlData+"'"+(String)Intervention.get(k)+"'";
								 }

							 }
						 }
					}
				}
		}
		//sqlData=sqlData+") AND LANGUAGE_ID = '"+locale+"' ORDER BY INTERVENTION_DESC";//common-icn-0180
		sqlData=sqlData+") AND LANGUAGE_ID = ? ORDER BY INTERVENTION_DESC";//common-icn-0180
	}
else if(!GroupID1.equals("0") || !alphalink.equals("Associated"))
{	
	//sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC, 	TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION                     A, CA_INTERVENTION_TYPE                     B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"'  AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"'  AND GOAL_CODE = '"+goalCode+"')   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE                                                                                                                                         UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION                      B, CA_INTERVENTION_TYPE                    C WHERE	 A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE   AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE   AND  (	('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))    		OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	))ORDER BY INTERVENTION_DESC";
	  //sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC,     TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"'  AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"'  AND GOAL_CODE = '"+goalCode+"')   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE AND A.LANGUAGE_ID ='"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE    AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE    AND  (	('"+alphalink+"' IS NOT NULL  AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))        OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	)) AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";//common-icn-0180
	  sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC,     TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = ? AND VERSION_NO = ?  AND TERM_SET_ID = ? AND TERM_CODE = ?  AND GOAL_CODE = ?)   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE AND A.LANGUAGE_ID = ? AND B.LANGUAGE_ID = A.LANGUAGE_ID UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE    AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE    AND  (	('"+alphalink+"' IS NOT NULL  AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))        OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	)) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";//common-icn-0180

}
try{
	connection	=	ConnectionManager.getConnection(request);
	pstmt		= connection.prepareStatement( sqlIntvnFrequency);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt1      = connection.prepareStatement(sqlDurationType);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlFrequency);
	//if(rs1!=null){
	//	while(rs1.next()){
	//		frequencyList.add(rs1.getString("FREQ_CODE"));
	//		frequencyList.add(rs1.getString("FREQ_DESC"));

	//	}
	//}
	//rs1.close();
	pstmt1.setString(1, locale);//common-icn-0180
	//rs1=stmt1.executeQuery(sqlDurationType);//common-icn-0180
	rs1=pstmt1.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			DurationList.add(rs1.getString("DURN_TYPE"));
			DurationList.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();
	pstmt2      = connection.prepareStatement(sqlStage);//common-icn-0180
	pstmt2.setString(1, locale);//common-icn-0180
	//rs1=stmt1.executeQuery(sqlStage);//common-icn-0180
	rs1=pstmt2.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			StageList.add(rs1.getString("STAGE_CODE"));
			StageList.add(rs1.getString("SHORT_DESC"));

		}
	}
	rs1.close();
	//common-icn-0180 starts
	//stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	int pstmtcount =1;//common-icn-0180
	//pstmt3      = connection.prepareStatement(sqlData);//common-icn-0180
	
	if(!sqlData.equals("")){
	pstmt3      = connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	//common-icn-0180 starts
	if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	pstmt3.setString(pstmtcount++, locale);//common-icn-0180
	}
	else if(!GroupID1.equals("0") || !alphalink.equals("Associated")){
		pstmt3.setString(pstmtcount++, libraryid);
		pstmt3.setString(pstmtcount++, versionno);
		pstmt3.setString(pstmtcount++, termSet);
		pstmt3.setString(pstmtcount++, termCode);
		pstmt3.setString(pstmtcount++, goalCode);
		pstmt3.setString(pstmtcount++, locale);
		pstmt3.setString(pstmtcount++, libraryid);
		pstmt3.setString(pstmtcount++, versionno);
		pstmt3.setString(pstmtcount++, termSet);
		pstmt3.setString(pstmtcount++, termCode);
		pstmt3.setString(pstmtcount++, goalCode);
		pstmt3.setString(pstmtcount++, locale);
	}
	if(!sqlData.equals("")){
	//rs=stmt.executeQuery(sqlData);//common-icn-0180
	rs=pstmt3.executeQuery();
	//common-icn-0180 ends
	if(rs!=null){
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();	
		if(maxRecord>0){
				
%>
	<TABLE border="0" cellpadding="0" cellspacing="0" width="125%" align="center">
		<TR>
		<TD width="70%" class="white">&nbsp;</TD>		
		<TD width="11%"align="right">
<%
		if (!(start<=1))
		{
%>			
			<label onClick='Interventionnavigation(document.formBuildLibraryInterventionDetails,"previous")'  style='cursor:pointer;color:blue'> <fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
<%
		}
		
		if ( !( (start+5) >= maxRecord ) )
		{
%>
			<label onClick='Interventionnavigation(document.formBuildLibraryInterventionDetails,"next")'  style='cursor:pointer;color:blue'> <fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
<%
		}
%>
	</TD><TD width="19%" class="white">&nbsp;</TD></TR></TABLE>

<TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='130%' >
	<!-- <TH >Intervention Type</TH> -->
	<TH ><fmt:message key="eCP.InterventionDescription.label" bundle="${cp_labels}"/></TH>
	<TH width="5%"><fmt:message key="eCP.Alt.label" bundle="${cp_labels}"/></TH>
	<TH width="13%"><fmt:message key="eCP.RelativeStart.label" bundle="${cp_labels}"/></TH>
	<TH width="16%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></TH>
	<TH width="13%"><fmt:message key="Common.duration.label" bundle="${common_labels}"/></TH>
	<TH width="5%"><fmt:message key="eCP.Dep.label" bundle="${cp_labels}"/></TH>
	<TH width="15%"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></TH>
	<TH width="3%" >&nbsp;</TH>
		<%
	
if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}
while(rs.next() && i<=end){	
			IntvnfreqList=new ArrayList();
			if((i%2) == 1)
				classValue = "QRYEVEN";
			else
				classValue ="QRYODD";
			
			interventionCode	=	rs.getString("INTERVENTION_CODE")==null?"":rs.getString("INTERVENTION_CODE");
			interventionDesc	=	rs.getString("INTERVENTION_DESC")==null?"":rs.getString("INTERVENTION_DESC");

			
//			rs1.close();
			//System.err.println("interventionDesc "+interventionDesc+" IntvnfreqList "+IntvnfreqList);
			//System.err.println("freqdurnunitload  "+freqdurnunitload);
			
			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Intervention			=	(ArrayList)interventionOutcome.get("I");
						 //System.err.println("Intervention  "+Intervention);
						  if(Intervention.size()>0){
							 if(Intervention.contains(interventionCode)){
								int index1			=	Intervention.indexOf(interventionCode);
								GrpID				=	(String)Intervention.get(index1+1);
								if(!GrpID.equals(""))
									GrpID1				=	Integer.parseInt(GrpID);
								//System.err.println("INTERVENTION_CODE  "+interventionCode);
								//System.err.println("sqlDATA  "+GrpID1);
								Alt					=	(String)Intervention.get(index1+2);
								relativeStart		=	(String)Intervention.get(index1+3);
								relativeStartType	=	(String)Intervention.get(index1+4);
								frequency			=	(String)Intervention.get(index1+5)==null?"":(String)Intervention.get(index1+5);
								Duration			=	(String)Intervention.get(index1+6);
								DurationType		=	(String)Intervention.get(index1+7);
								//freqdurnunitload	=	(String)Intervention.get(index1+7);
								dependency			=	(String)Intervention.get(index1+8);
								dep					=	Integer.parseInt(dependency);
								stage				=	(String)Intervention.get(index1+9);
								status				=	(String)Intervention.get(index1+10);

								if(Alt==null)
									Alt="";

								if(relativeStart.equals("0"))
									relativeStart="";
								
								if(Duration.equals("0"))
									Duration="";
								
								if(status.equals("Y"))
									checkAttribute="checked";
								else
									checkAttribute="";
							 }
						 }
					}
				}
			}
					
			pstmt.setString(1,interventionCode);
			pstmt.setString(2,locale);//common-icn-0180
			rs1=pstmt.executeQuery();
			if(rs1!=null){
				while(rs1.next()){
					tempfreq=rs1.getString("FREQ_CODE");
					IntvnfreqList.add(tempfreq);
					IntvnfreqList.add(rs1.getString("FREQ_DESC"));
					freq_default_yn=rs1.getString("DEFAULT_YN");
					IntvnfreqList.add(freq_default_yn);					
					freqdurnunit=rs1.getString("FREQ_DURNUNIT")==null?"":rs1.getString("FREQ_DURNUNIT");				
					IntvnfreqList.add(freqdurnunit);					
					if(freqdurnunitload.equals(""))
						freqdurnunitload=freqdurnunit;					
					if(!freqdurnunitload.equals("") && freq_default_yn.equals("Y"))
							freqdurnunitload=freqdurnunit;
					if(tempfreq.equals(frequency)){
							freqdurnunitload=freqdurnunit;
					}

				}

			}			
			rs1.close();
			if(!alphalink.equals("Associated")){
				if(GroupID>0 && GroupID==GrpID1){
					disabled	=	"Disabled";
					readonly	=	"readonly";
				}
				else{
					disabled	=	"";
					readonly	=	"";
				
				}
			}
			
			if(IntvnfreqList.size() > 0){
				//System.err.println("*********************************************************************");
				//System.err.println("condition in intvn "+(GrpID.equals("") ||(GroupID>0 && GroupID==GrpID1)));
			//	System.err.println("GrpID in intvn "+GrpID);

			if(GrpID.equals("") ||(GroupID>0 && GroupID==GrpID1)){
			
	%>
	<TR>
		<!-- <TD class="<%=classValue%>"><%=interventionTypeDesc%></TD> -->
		<TD class="<%=classValue%>"><%=interventionDesc%>
			<INPUT type="hidden" name="interventionDesc<%=i%>" id="interventionDesc<%=i%>" value="<%=interventionDesc%>">
		</TD>
		<TD class="<%=classValue%>" align="center"><INPUT type="text" <%=readonly%> maxlength="4" size="1"  value="<%=Alt%>" name="Alt<%=i%>" onblur="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')"></TD>
		<TD class="<%=classValue%>" align="center"><INPUT type="text"  <%=readonly%> maxlength="5" size="1" value="<%=relativeStart%>" name="relativeStart<%=i%>" onKeyPress='return(ChkNumberInput(this,event,0))' onblur="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
			<SELECT name="relativeStartType<%=i%>" id="relativeStartType<%=i%>" <%=disabled%> onchange="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
			<%for(int k=0;k<DurationList.size();k=k+2){
					tempRelativeStartType=(String)DurationList.get(k);
					if(relativeStartType.equals(tempRelativeStartType))
						relativeStartSelect="selected";
					else
						relativeStartSelect="";

			%>
					<OPTION <%=relativeStartSelect%> value="<%=DurationList.get(k)%>"><%=DurationList.get(k+1)%></OPTION>
			<%}%>
			</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="left">
				<SELECT name="frequency<%=i%>" id="frequency<%=i%>" <%=disabled%> onchange="loadDurntypes(this,'<%=i%>');updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
				<%			
						//System.err.println("interventionCode "+interventionCode+" frequency "+frequency);

						for(int k=0;k<IntvnfreqList.size();k=k+4){
							tempFrequency=(String)IntvnfreqList.get(k);
							tempfreq=(String)IntvnfreqList.get(k+2);
							freqdurnunit=(String)IntvnfreqList.get(k+3);
							if(frequency.equals("")||frequency==null){
								//System.err.println("E fre");
								if(tempfreq.equals("Y"))
									frequencySelect="selected";
								else
									frequencySelect="";
							}else{
								//System.err.println("fre");
								//System.err.println("tempFrequency "+tempFrequency);
								//System.err.println("frequency "+frequency);
								if(tempFrequency.equals(frequency))
									frequencySelect="selected";
								else
									frequencySelect="";
								
							}
							freqoptname=interventionCode+','+IntvnfreqList.get(k)+','+freqdurnunit;

				%>
					<!-- <INPUT TYPE="hidden" name="" id="" value=""> -->
					<OPTION <%=frequencySelect%> value="<%=freqoptname%>"><%=IntvnfreqList.get(k+1)%></OPTION>
				<%}%>
			</SELECT>
		</TD>
		<TD class="<%=classValue%>"  align="center">
			<INPUT type="text" name="Duration<%=i%>" id="Duration<%=i%>" <%=readonly%> maxlength="5" size="1" value="<%=Duration%>" onKeyPress='return(ChkNumberInput(this,event,0))' onblur="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
			<SELECT name="DurationType<%=i%>" id="DurationType<%=i%>" <%=disabled%> onchange="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
			<%/*for(int k=0;k<DurationList.size();k=k+2){
					tempDurationType=(String)DurationList.get(k);
					if(tempDurationType.equals(DurationType))
						DurationSelect="selected";
					else
						DurationSelect="";*/
			%>
					<!-- <OPTION value=""></OPTION> -->
			<%//}
			ch_durn_unit=freqdurnunitload.charAt(0);
			if(DurationType.equals("M"))
				MDurationSelect="selected";
			else if(DurationType.equals("H"))
				HDurationSelect="selected";
			else if(DurationType.equals("D"))
				DDurationSelect="selected";
			else if(DurationType.equals("W"))
				WDurationSelect="selected";
			else if(DurationType.equals("L"))
				LDurationSelect="selected";	
			//System.err.println("ch_durn_unit "+ch_durn_unit);
				switch(ch_durn_unit){
					case 'M' :
%>
						<option <%=MDurationSelect%> value="M" ><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
<%			
					case 'H':
%>
						<option <%=HDurationSelect%> value="H" ><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
<%
					case 'D':
%>
						<option <%=DDurationSelect%> value="D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
	<%
					case 'W':
%>
					<option <%=WDurationSelect%> value="W" ><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/></option>
<%
					case 'L':
%>
						<option <%=LDurationSelect%> value="L" ><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
<%
							break;
					default:
%>
						<option  value="M" ><fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></option>
						<option value="H" >><fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/></option>
						<option value="D" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option value="W" ><fmt:message key="eCP.Weeks.label" bundle="${cp_labels}"/></option>
						<option value="L" ><fmt:message key="eCP.Months.label" bundle="${cp_labels}"/></option>
			<%
							}
			%>
			</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="center">
			<SELECT name="Dependency<%=i%>" id="Dependency<%=i%>" <%=disabled%> onchange="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
			<%for(int j=1;j<=9;j++){
				if(dep==j)
					dependencySelect="selected";
				else
					dependencySelect="";
			%>
				<OPTION <%=dependencySelect%> value="<%=j%>"><%=j%></OPTION>
			<%}%>
		</SELECT></TD>
		<TD class="<%=classValue%>" align="center">
				<SELECT name="stage<%=i%>" id="stage<%=i%>" <%=disabled%> onchange="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')">
					<%for(int k=0;k<StageList.size();k=k+2){
						tempStage=(String)StageList.get(k);
							if(tempStage.equals(stage))
								stageSelect="selected";
							else
								stageSelect="";
					%>
						<OPTION <%=stageSelect%> value="<%=StageList.get(k)%>"><%=StageList.get(k+1)%></OPTION>
					<%}%>
				</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="center" ><INPUT type="checkBox" <%=disabled%> <%=checkAttribute%> value="<%=interventionCode%>" name="select<%=i%>" onclick="updateInterventionList('<%=i%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=maxGrpID%>')"></TD>
	</TR>
<%
	}
}

	i++;
		disabled			=	"";
		GrpID				=	"";
		GrpID1				=	0;
		Alt					=	"";
		checkAttribute		=	"";
		relativeStart		=	"";
		relativeStartType	=	"";
		frequency			=	"";
		Duration			=	"";
		DurationType		=	"";
		dependency			=	"";
		stage				=	"";
		status				=	"";
		dep					=	0;
		IntvnfreqList		=	null;
		interventionCode	=	"";
		freqdurnunitload	=	"";
		ch_durn_unit		=	' ';
		MDurationSelect			=	"";
		HDurationSelect			=	"";
		WDurationSelect			=	"";
		LDurationSelect			=	"";
		DDurationSelect			=	"";

//System.err.println("AGain");
}
%>
</TABLE>
<INPUT type="hidden" name="start" id="start"     value="<%=start%>">
<INPUT type="hidden" name="end" id="end"       value="<%=end%>">
<INPUT type="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<INPUT type="hidden" name="termSet" id="termSet"   value="<%=termSet%>">
<INPUT type="hidden" name="termCode" id="termCode"  value="<%=termCode%>">
<INPUT type="hidden" name="goalCode" id="goalCode"  value="<%=goalCode%>">
<INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
<INPUT type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<INPUT type="hidden" name="maxGrpID" id="maxGrpID"  value="<%=maxGrpID%>">
<INPUT type="hidden" name="GroupID" id="GroupID"   value="<%=GroupID%>">
<%	
		}else{
%>
	<!-- <SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));</SCRIPT> -->
<%
}
	}
}
}
catch(Exception e){
	System.err.println(e.toString());
		e.printStackTrace();
}finally{
	try
	{
	if(rs!=null)
		rs.close();
	if(rs1!=null)
		rs1.close();
	if(stmt!=null)
		stmt.close();
	if(stmt1!=null)
		stmt1.close();
	if(pstmt!=null)
		pstmt.close();
	//common-icn-0180 starts
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt2!=null)
		pstmt2.close();
	if(pstmt3!=null)
		pstmt3.close();
	//common-icn-0180 ends
	ConnectionManager.returnConnection(connection,request);
	}
	catch(Exception e)
	{
		//out.println(e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

}
%>
</FORM>
</BODY>
</HTML>


