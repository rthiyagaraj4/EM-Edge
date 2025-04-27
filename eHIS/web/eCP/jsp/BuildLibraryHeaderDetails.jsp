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
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*" contentType="text/html; charset=UTF-8"%>
<%@ page import ="eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap,java.util.Date, com.ehis.eslp.* ,java.net.*,java.text.*,eCommon.XSSRequestWrapper"%>
<jsp:useBean id="BuildLibraryTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>

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
 String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	    <SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()">
	<FORM name="formHeaderDetails" id="formHeaderDetails">
<%
System.err.println("inside detail");
	BuildLibraryTermCode.clearAll();
	HashMap TermCodeData		=     new HashMap();
    BuildLibrary.clearAll();
	ArrayList TermCode			=     new ArrayList();
	
	String library_id				=	request.getParameter("library_id");
	String version_no				=	request.getParameter("versionon");
	int versionno					=	Integer.parseInt(version_no);

	String termSet					=	"";
	String termCode					=	"";
	String goalCode					=	"";
	String value					=	"";
	String Desc						=	"";
	String diagnosis				=	"";
	String procedure				=	"";
	String tableName				=	"";
	String goalSql					=	"";
	String InterventionSql			=	"";
	String OutcomeSql				=	"";
	String goalMaxgrp				=	"";

	ArrayList Goal					=	null;
	HashMap InterventionOutcome		=	null;
	ArrayList Intervention			=	null;
	ArrayList Outcome				=	null;
	ArrayList TermCodeList			=	null;
	
	Connection connection			=	null;
	Statement stmt					=	null;
	PreparedStatement pstmt			=	null;
	ResultSet rs					=	null;
	String Descsql					=	"";
	String sqlData					=	"SELECT SHORT_DESC,DECODE(STATUS,'D','DRAFT')STATUS FROM CP_LIBRARY_lang_vw WHERE language_id='"+locale+"' and LIBRARY_ID='"+library_id+"'AND VERSION_NO='"+version_no+"'";
	
	
	try{

		connection		=	ConnectionManager.getConnection(request);
		stmt			=	connection.createStatement();
		//Descsql	=	"SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC,B.DIAGNOSIS_YN,B.PROCEDURE_YN FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID='"+library_id+"' AND A.VERSION_NO='"+versionno+"' AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";
		Descsql	=	"SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC,B.DIAGNOSIS_YN,B.PROCEDURE_YN FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID=? AND A.VERSION_NO=? AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";
		pstmt = connection.prepareStatement( Descsql);
		pstmt.setString(1,library_id);
		pstmt.setInt(2,versionno);
		rs=pstmt.executeQuery();
		//rs=stmt.executeQuery(Descsql);
		
		if(rs!=null){
			while(rs.next()){
				termSet		=	(String)rs.getString("TERM_SET_ID");
				termCode	=	(String)rs.getString("TERM_CODE");
				Desc		=	(String)rs.getString("TERMCODE_DESC");
				diagnosis	=	(String)rs.getString("DIAGNOSIS_YN");
				procedure	=	(String)rs.getString("PROCEDURE_YN");
				if(!TermCodeData.containsKey(termSet)){
					TermCodeList=new ArrayList();
					TermCodeList.add(termCode);
					TermCodeList.add(Desc);
					TermCodeList.add("Y");
					TermCodeList.add("U");
					TermCodeData.put(termSet,TermCodeList);
				}else{
					TermCodeList=(ArrayList)TermCodeData.get(termSet);
					TermCodeList.add(termCode);
					TermCodeList.add(Desc);
					TermCodeList.add("Y");
					TermCodeList.add("U");
				}

				
				 if(diagnosis.equals("Y"))
					tableName="MR_D_"+termSet+"_VW";
				 else if(procedure.equals("Y"))
					tableName="MR_P_"+termSet+"_VW";

				TermCode.add(termSet);
				TermCode.add(termCode);
				Goal=new ArrayList();
				TermCode.add(Goal);
				TermCode.add("Y");
				TermCode.add("U");
				TermCode.add(Desc);
				TermCode.add(tableName);

			}
		}
		
		pstmt.close();
		rs.close();

		//goalSql		=	"SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?  AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
		goalSql		=	"SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?  AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY GOAL_DESC";

		pstmt = connection.prepareStatement( goalSql);
		
		for(int i=0;i<TermCode.size();i=i+7)
		{
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			//goalSql		=	"SELECT A.GOAL_CODE,B.LONG_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT,A.PRACT_TYPE, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+library_id+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
			

			pstmt.setString(1,library_id);
			pstmt.setInt(2,versionno);
			pstmt.setString(3,termSet);
			pstmt.setString(4,termCode);
			pstmt.setString(5,locale);
			rs=pstmt.executeQuery();
			//rs			=	stmt.executeQuery(goalSql);
			if(rs!=null){
				while(rs.next()){
					InterventionOutcome	=	new HashMap();
					Intervention		=	new ArrayList();
					Outcome				=	new ArrayList();
					InterventionOutcome.put("I",Intervention);
					InterventionOutcome.put("O",Outcome);
					Goal.add(rs.getString("GOAL_CODE"));
					Goal.add(rs.getString("GOAL_TARGET_DURN"));
					Goal.add(rs.getString("GOAL_TARGET_DURN_UNIT"));
					Goal.add(InterventionOutcome);
					Goal.add("Y");
					Goal.add("U");
					Goal.add(value);
					Goal.add(rs.getString("GOAL_DESC"));		
					Goal.add(rs.getString("PRACT_TYPE"));
				}
			}
    		rs.close();
		}
		pstmt.close();



		//InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
		InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE, B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";

    	pstmt = connection.prepareStatement( InterventionSql);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode			=	(String)Goal.get(j);
					InterventionOutcome =	(HashMap)Goal.get(j+3);
					Intervention		=	(ArrayList)InterventionOutcome.get("I");
					//InterventionSql		=	"SELECT B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = '"+library_id+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  A.GOAL_CODE = '"+goalCode+"' AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
	
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					pstmt.setString(6,locale);

					rs=pstmt.executeQuery();
					//rs					=	stmt.executeQuery(InterventionSql);
					if(rs!=null){
						while(rs.next()){
							Intervention.add(rs.getString("INTERVENTION_CODE"));
							Intervention.add(rs.getString("GROUP_ID"));
							Intervention.add(rs.getString("ALT_INTERVENTION_CODE"));
							Intervention.add(rs.getString("REL_START_PERIOD"));
							Intervention.add(rs.getString("REL_START_PERIOD_UNIT"));
							Intervention.add(rs.getString("FREQ_CODE"));
							Intervention.add(rs.getString("FREQ_DURN"));
							Intervention.add(rs.getString("FREQ_DURN_UNIT"));
							Intervention.add(rs.getString("DEPENDENCY_LEVEL"));
							Intervention.add(rs.getString("STAGE_CODE"));
							Intervention.add("Y");
							Intervention.add("U");
							Intervention.add(rs.getString("INTERVENTION_DESC"));						
							
						}
					}
    				rs.close();
				}

			}

		}
		pstmt.close();



		//OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
		OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";

		pstmt = connection.prepareStatement( OutcomeSql);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode			=	(String)Goal.get(j);
					InterventionOutcome =	(HashMap)Goal.get(j+3);
					Outcome				=	(ArrayList)InterventionOutcome.get("O");
					//OutcomeSql			=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = '"+library_id+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
					//rs					=	stmt.executeQuery(OutcomeSql);
				
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					pstmt.setString(6,locale);
					rs=pstmt.executeQuery();
					if(rs!=null){
						while(rs.next()){
							Outcome.add(rs.getString("OUTCOME_CODE"));
							Outcome.add(rs.getString("GROUP_ID"));
							Outcome.add(rs.getString("APPL_NATURE"));
							Outcome.add(rs.getString("OUTCOME_TARGET_DURN"));
							Outcome.add(rs.getString("OUTCOME_TARGET_DURN_UNIT"));
							Outcome.add("Y");
							Outcome.add("U");
							Outcome.add(rs.getString("OUTCOME_DESC"));						
						}
					}
			 		rs.close();
				}
			}

		}
		pstmt.close();


		goalMaxgrp	=	"SELECT MAX(GROUP_ID) MAX_COUNT FROM CP_LIBRARY_INTERVENTION WHERE LIBRARY_ID=? AND VERSION_NO=? AND TERM_SET_ID=? AND TERM_CODE=? AND GOAL_CODE=?";

		pstmt = connection.prepareStatement( goalMaxgrp);

		for(int i=0;i<TermCode.size();i=i+7){
			termSet		=	(String)TermCode.get(i);
			termCode	=	(String)TermCode.get(i+1);
			Goal		=	(ArrayList)TermCode.get(i+2);
			if(Goal.size()>0){
				for(int j=0;j<Goal.size();j=j+9){
					goalCode	=	(String)Goal.get(j);
					//goalMaxgrp	=	"SELECT MAX(GROUP_ID) MAX_COUNT FROM CP_LIBRARY_INTERVENTION WHERE LIBRARY_ID='"+library_id+"' AND VERSION_NO='"+versionno+"' AND TERM_SET_ID='"+termSet+"' AND TERM_CODE='"+termCode+"' AND GOAL_CODE='"+goalCode+"'";
					//rs			=	stmt.executeQuery(goalMaxgrp);
				
					pstmt.setString(1,library_id);
					pstmt.setInt(2,versionno);
					pstmt.setString(3,termSet);
					pstmt.setString(4,termCode);
					pstmt.setString(5,goalCode);
					rs=pstmt.executeQuery();
					if(rs.next()){
						Goal.set(j+6,rs.getString("MAX_COUNT"));
					}
				   rs.close();
				}
			}
			
		}
		pstmt.close();

		BuildLibrary.putObject(TermCode);
		BuildLibraryTermCode.putObject(TermCodeData);
		rs	=	null;
		rs	=	stmt.executeQuery(sqlData);
		
		if(rs!=null){
			rs.next();	

%>
		<TABLE border='0' cellpadding='0' cellspacing='0' align='left'  width='102%' >
			<TR>
				<TD class="label"  width="20%"><fmt:message key="eCP.LibraryDescription.label" bundle="${cp_labels}"/></TD>
				<TD align="left"  class="label"><B>&nbsp;<%=rs.getString("short_desc")%></B></TD>
			</TR>
			<TR>
				<TD class="label" ><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></TD>
				<TD align="left" class="label"><B>&nbsp;<%=version_no%></B></TD>
			</TR>
			<TR>
				<TD class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
				<TD align="left" class="label"><B>&nbsp;<%=rs.getString("status")%></B></TD>
			</TR>
			<TR>
				<TD colspan="2">&nbsp;</TD>
			</TR>
			<TR>
				<TD align="Left" colspan="5"><B>
						<label onClick="showTermCodeLookup('<%=library_id%>','<%=version_no%>')"  style='cursor:pointer;color:Blue'><fmt:message key="eCP.AssociateTermCode.label" bundle="${cp_labels}"/></label></B>
				</TD>
			</TR>
	<input type="hidden" name="libraryid" id="libraryid" value="<%=library_id%>">
	<input type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
			
<%		}
	}catch(Exception e){
		System.err.println("BuildLibraryHeaderDetails "+ e.toString());
		e.printStackTrace();
	}finally{
		try
		{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(pstmt!=null)
			pstmt.close();
		ConnectionManager.returnConnection(connection,request);
		}
		catch(Exception exp)
		{
		//	out.println(exp.toString());//COMMON-ICN-0181
		        exp.printStackTrace();//COMMON-ICN-0181
		}

	}
%>
	</FORM>
	<SCRIPT>loadDetail('<%=library_id%>','<%=versionno%>')</SCRIPT>
	
</BODY>
</HTML>

