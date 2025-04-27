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
*	Created On		:	10 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.*,eOR.Common.*" contentType="text/html; charset=UTF-8"%>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formBuildLibraryOutcomeDetails" id="formBuildLibraryOutcomeDetails" >
<%
String alphalink				=	request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet					=	request.getParameter("termSet");
String termCode					=	request.getParameter("termCode");
String goalCode					=	request.getParameter("goalCode");
String libraryid				=	request.getParameter("libraryid");
String versionno				=	request.getParameter("versionno");
String tableName				=	request.getParameter("tableName");
String maxGrpID					=	request.getParameter("maxGrpID");
String GroupID1					=	request.getParameter("GroupID");
int GroupID						=	Integer.parseInt(GroupID1);
//out.println("GroupID  "+GroupID);
//out.println("maxGrpID  "+maxGrpID);

String GrpID					=	"";
alphalink						=	alphalink.trim();
Connection connection			=	null;
Statement stmt					=	null;
PreparedStatement pstmt			=	null;
ResultSet rs					=	null;
Statement stmt1					=	null;
ResultSet rs1					=	null;
String from						=	request.getParameter("from") ;
String to						=	request.getParameter("to") ;
String classValue				=	"";
String  sqlData					=	"";
String outcomeCode				=	"";
String outcomeDesc				=	"";
//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";//common-icn-0180
String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id= ?";//common-icn-0180
String sqlNature				=	"SELECT NATURE_APPL_YN FROM MR_TERM_SET WHERE  TERM_SET_ID=?";
String sqlNaturetype			=	"";
String Status					=	"";
String potential				=	"";
String wellness					=	"";
String  actual					=	"";
String disabled					=	"";
String readonly					=	"";
String targetPeriod				=	"";
String targetPeriodType			=	"";
String targetPeriodTypeSelect	=	"";
String tempTargetPeriodType		=	"";
String NatureValue				=	"";
String tempNature				=	"";
String NatureSelect				=	"";
String chkStatus				=	"";
String chkAttribute				=	"";
String tempTermSet				=	"";
String tempTermCode				=	"";
String curGroupID				=	"";

ArrayList Nature				=	new ArrayList();
ArrayList DurationList			=	new ArrayList();
ArrayList TermCodeList			=	null;
ArrayList Goal					=	null;
HashMap	interventionOutcome		=	null;
ArrayList Outcome				=	null;
int GrpID1						=	0;
int maxRecord					=	0;
int start						=	0 ;
int end							=	0 ;
int i							=	1;
if(!GroupID1.equals("0")){
	maxGrpID=GroupID1;
}
//out.println("maxGrpID"+maxGrpID);
//out.println("GroupID1"+GroupID1);

 if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 5 ; }   else {  end = Integer.parseInt( to ) ; }

 ArrayList sessionList				=		(ArrayList)BuildLibrary.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		TermCodeList=(ArrayList)BuildLibrary.getObject(0);
	}

	
if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	//sqlData="SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,	OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
	sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC FROM CP_OUTCOME_LANG_VW WHERE OUTCOME_CODE IN (";
	boolean first_time=true;
	for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Outcome				=	(ArrayList)interventionOutcome.get("O");
						 if(Outcome.size()>0){
							 for(int k=0;k<Outcome.size();k=k+8){
								 curGroupID=(String)Outcome.get(k+1);
								 if(GroupID1.equals(curGroupID)){
									// System.err.println("inside if");
									 if(!first_time)
										 sqlData =sqlData+",";
									 if(first_time){
										 sqlData =sqlData+"'"+(String)Outcome.get(k)+"'";
										 first_time=false;
									 }
									 else{
										sqlData =sqlData+"'"+(String)Outcome.get(k)+"'";
									 }
								 }

							 }
						 }
					}
				}
	}
	//sqlData=sqlData+") AND LANGUAGE_ID = '"+locale+"' AND OUTCOME_TYPE='O' ORDER BY OUTCOME_DESC";
	sqlData=sqlData+") AND LANGUAGE_ID = ? AND OUTCOME_TYPE='O' ORDER BY OUTCOME_DESC";
				
						
	}
else if(!GroupID1.equals("0")|| !alphalink.equals("Associated"))
{
	//sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME                     WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"' AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"' AND GOAL_CODE = '"+goalCode+"')                                                            UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME                     B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"' AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' ))                                                               ORDER BY OUTCOME_DESC";
	  //sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"' AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"' AND GOAL_CODE = '"+goalCode+"') AND OUTCOME_TYPE='O' AND LANGUAGE_ID = '"+locale+"' UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"' AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' )) AND B.LANGUAGE_ID = '"+locale+"' ORDER BY OUTCOME_DESC";//common-icn-0180
	  sqlData="SELECT  OUTCOME_CODE,SHORT_DESC OUTCOME_DESC, TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) OUTCOME_TARGET_DURN, TO_CHAR(NULL) OUTCOME_TARGET_DURN_UNIT, TO_CHAR(NULL) APPL_NATURE, 'I' DB_ACTION  FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT OUTCOME_CODE FROM CP_LIBRARY_OUTCOME WHERE LIBRARY_ID = ? AND VERSION_NO = ? AND TERM_SET_ID = ? AND TERM_CODE = ? AND GOAL_CODE = ?) AND OUTCOME_TYPE='O' AND LANGUAGE_ID = ? UNION ALL SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID,OUTCOME_TARGET_DURN,OUTCOME_TARGET_DURN_UNIT,APPL_NATURE,'U' DB_ACTION  FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ? AND  B.OUTCOME_CODE = A.OUTCOME_CODE   AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z' )) AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";//common-icn-0180

}

try{
	connection	=	ConnectionManager.getConnection(request);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt = connection.prepareStatement(sqlDurationType);//common-icn-0180
	pstmt.setString(1,locale);//common-icn-0180
	rs1			=	pstmt.executeQuery();//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlDurationType);//common-icn-0180

	if(rs1!=null){
		while(rs1.next()){
			DurationList.add(rs1.getString("DURN_TYPE"));
			DurationList.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();

		//rs1=stmt1.executeQuery(sqlNature);
					pstmt = connection.prepareStatement( sqlNature);
					pstmt.setString(1,termSet);
					rs1=pstmt.executeQuery();

			if(rs1!=null && rs1.next()){
			Status	=	rs1.getString("NATURE_APPL_YN");
			//out.println("tableName "+tableName);
			}
			rs1.close();
			if(Status.equals("Y"))
			{
				//sqlNaturetype	=	"SELECT  term_set_id,term_code,ACTUAL_YN,POTENTIAL_YN,WELLNESS_YN FROM "+tableName+" where  term_set_id='"+termSet+"' and term_code='"+termCode+"'";//common-icn-0180
				sqlNaturetype	=	"SELECT  term_set_id,term_code,ACTUAL_YN,POTENTIAL_YN,WELLNESS_YN FROM "+tableName+" where  term_set_id=? and term_code=?";//common-icn-0180
				
				
				pstmt = connection.prepareStatement(sqlNaturetype);//common-icn-0180
				pstmt.setString(1,termSet);//common-icn-0180
				pstmt.setString(2,termCode);//common-icn-0180
				rs1				=	pstmt.executeQuery();//common-icn-0180
				//rs1				=	stmt1.executeQuery(sqlNaturetype);//common-icn-0180
				if(rs1 !=null && rs1.next()){					
					potential	=	rs1.getString("POTENTIAL_YN");
					wellness	=	rs1.getString("WELLNESS_YN");
					actual		=	rs1.getString("ACTUAL_YN");
					System.err.println("potential "+potential+"wellness "+wellness+"actual "+actual);
					if(potential.equals("Y")){
						Nature.add("P");
						Nature.add("Potiental");
					}
					if(actual.equals("Y")){
						Nature.add("A");
						Nature.add("Actual");
					}
					if(actual.equals("Y") && potential.equals("Y")){
						Nature.add("B");
						Nature.add("Both");
					}
					if(wellness.equals("Y")){
						//Nature.clear();
						Nature.add("W");
						Nature.add("Wellness");
					}
				}
			}
			//System.err.println("Nature  "+Nature);
	
	//stmt	=	connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	int pstmtcount=1;//common-icn-0180
	if(!sqlData.equals("")){
	pstmt=connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	//common-icn-0180 starts
	if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	pstmt.setString(pstmtcount++, locale);
	}
	else if(!GroupID1.equals("0")|| !alphalink.equals("Associated")){
		pstmt.setString(pstmtcount++, libraryid);	
		pstmt.setString(pstmtcount++, versionno);	
		pstmt.setString(pstmtcount++, termSet);	
		pstmt.setString(pstmtcount++, termCode);
		pstmt.setString(pstmtcount++, goalCode);
		pstmt.setString(pstmtcount++, locale);
		pstmt.setString(pstmtcount++, libraryid);	
		pstmt.setString(pstmtcount++, versionno);	
		pstmt.setString(pstmtcount++, termSet);	
		pstmt.setString(pstmtcount++, termCode);
		pstmt.setString(pstmtcount++, goalCode);
		pstmt.setString(pstmtcount++, locale);
	}
	//common-icn-0180 ends
	//System.err.println("sqlData "+sqlData);
	if(!sqlData.equals("")){
	//rs		=	stmt.executeQuery(sqlData);//common-icn-0180
	rs		=	pstmt.executeQuery();//common-icn-0180
	if(rs!=null){
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		if(maxRecord>0){
				
%>
	<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<TR>
		<TD width="55%" class="white">&nbsp;</TD>
		<TD width="10%" class="white">&nbsp;</TD>
		<TD align="right">
<%
		if ( !(start <= 1) )
		{
%>
		<label onClick='Outcomenavigation(document.formBuildLibraryOutcomeDetails,"previous")'  style='cursor:pointer;color:blue'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
<%
		}
		if ( !( (start+5) >= maxRecord ) )
		{
	%>
		<label onClick='Outcomenavigation(document.formBuildLibraryOutcomeDetails,"next")'  style='cursor:pointer;color:blue'><fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
	<%
		}
	%>
	</TD></TR></TABLE>

<TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='100%' >
	<TH width="47%"><fmt:message key="eCP.OutcomeDescription.label" bundle="${cp_labels}"/></TH>
	<TH ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></TH>
	<TH width="20%" ><fmt:message key="eCP.TargetPeriod.label" bundle="${cp_labels}"/></TH>
	<TH width="4%" >&nbsp;</TH>
	<%
	
if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}

while(rs.next() && i<=end){
		if((i%2) == 1)
				classValue = "QRYEVEN";
			else
				classValue ="QRYODD";

			outcomeCode	=	rs.getString("OUTCOME_CODE");
			outcomeDesc	=	rs.getString("OUTCOME_DESC");


			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Outcome				=	(ArrayList)interventionOutcome.get("O");
						 if(Outcome.size()>0){
							 if(Outcome.contains(outcomeCode)){
								int index1			=	Outcome.indexOf(outcomeCode);
								NatureValue			=	(String)Outcome.get(index1+2);
								targetPeriod		=	(String)Outcome.get(index1+3);
								targetPeriodType	=	(String)Outcome.get(index1+4);
								chkStatus			=	(String)Outcome.get(index1+5);
								GrpID				=	(String)Outcome.get(index1+1);
								if(!GrpID.equals(""))
									GrpID1				=	Integer.parseInt(GrpID);

								if(targetPeriod==null)
									targetPeriod="";

								if(chkStatus.equals("Y"))
									chkAttribute="checked";
								else
									chkAttribute="";
							 }
						 }
					}
				}
			}

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
		
//			System.err.println("condition in outcome "+(GrpID.equals("")|| (GroupID>0 && GroupID==GrpID1)));
//			System.err.println("GrpID "+GrpID);
		if(GrpID.equals("")|| (GroupID>0 && GroupID==GrpID1)){	

	%>
	<TR>
		<TD class="<%=classValue%>"><%=outcomeDesc%>
			<INPUT type="hidden" name="outcomeDesc<%=i%>" id="outcomeDesc<%=i%>" value="<%=outcomeDesc%>">
		</TD>
		<TD class="<%=classValue%>" align="center">
			<SELECT name="Nature<%=i%>" id="Nature<%=i%>" <%=disabled%> onchange="updateOutcomeList('<%=i%>')">
	<%		if(Status.equals("Y"))
			{
				if(Nature.size()>0)
				{
					for(int k=0;k<Nature.size();k=k+2)
					{
						tempNature=(String)Nature.get(k);
						if(NatureValue.equals(tempNature))
							NatureSelect="Selected";
						else
							NatureSelect="";
			%>
					<OPTION <%=NatureSelect%> value="<%=Nature.get(k)%>"><%=Nature.get(k+1)%></OPTION>
			<%		}
				}
			}
			else
			{
	%>
				<OPTION  value="X">X</OPTION>
	<%
			}
	%>
			</SELECT></TD>
		<TD class="<%=classValue%>" align="center"><INPUT type="text"  <%=readonly%> maxlength="5" value="<%=targetPeriod%>" size="1" name="targetPeriod<%=i%>" onKeyPress='return(ChkNumberInput(this,event,0))'  onblur="updateOutcomeList('<%=i%>')">
			<SELECT name="targetPeriodType<%=i%>" id="targetPeriodType<%=i%>" <%=disabled%> onchange="updateOutcomeList('<%=i%>')">
			<%for(int k=0;k<DurationList.size();k=k+2){
					tempTargetPeriodType=(String)DurationList.get(k);
					if(targetPeriodType.equals(tempTargetPeriodType))
						targetPeriodTypeSelect="Selected";
					else
						targetPeriodTypeSelect="";

			%>
					<OPTION <%=targetPeriodTypeSelect%> value="<%=DurationList.get(k)%>"><%=DurationList.get(k+1)%></OPTION>
			<%}%>
			</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="center" >
				<INPUT type="checkBox" name="select<%=i%>" id="select<%=i%>" <%=disabled%> <%=chkAttribute%>  value="<%=outcomeCode%>" onclick="updateOutcomeList('<%=i%>')">
		</TD>
	</TR>
<%
		}
	i++;
			disabled			=	"";
			GrpID				=	"";
			NatureValue			=	"";
			targetPeriod		=	"";
			targetPeriodType	=	"";
			chkAttribute		=	"";
			chkStatus			=	"";
			GrpID1				=	0;

}
%>
</TABLE>
	<BR>
<DIV align='right'>
<TABLE  cellpadding='0' cellspacing='0' >
	<TR>
		<%if(GroupID==0){%>
		<TD >
			<INPUT type='button' name='close' id='close' value='Create New Group' onClick='ChkNewGrp("new1")' class='button'>
		</TD> 
		<TD >
			&nbsp;<INPUT type='button' name='close' id='close' value='Close' onClick='ChkNewGrp("close");' class='button'>
		</TD>
		<%}else{
			//out.println("inside else");
	%>
			 <TD >
			<INPUT type='button' name='close' id='close' value='Create New Group' onClick="ChkNewGrp('new');LoadPages('0','0');" class='button'> 
		</TD>  
		 <TD >
			&nbsp;<INPUT type='button' name='close' id='close' value='Close' onClick='ChkNewGrp("new");closeW()' class='button'>
		</TD> 
		<%}%>
	</TR>
</TABLE>
	
<INPUT type="hidden" name="start" id="start"     value="<%=start%>">
<INPUT type="hidden" name="end" id="end"       value="<%=end%>">
<INPUT type="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<INPUT type="hidden" name="termSet" id="termSet"   value="<%=termSet%>">
<INPUT type="hidden" name="termCode" id="termCode"  value="<%=termCode%>">
<INPUT type="hidden" name="goalCode" id="goalCode"  value="<%=goalCode%>">
<INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
<INPUT type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<INPUT type="hidden" name="tableName" id="tableName" value="<%=tableName%>">          
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
	ConnectionManager.returnConnection(connection,request);

}

%>

</BODY>
</FORM>
</HTML>


