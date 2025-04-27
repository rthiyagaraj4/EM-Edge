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
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*"%>

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
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formBuildLibraryGoalDetails" id="formBuildLibraryGoalDetails">
<%

String alphalink			=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet				=		request.getParameter("termSet");
String termCode				=		request.getParameter("termCode");
String termDesc				=		request.getParameter("termDesc");
String libraryid			=		request.getParameter("libraryid");
String versionno			=		request.getParameter("versionno");
String tableName			=		request.getParameter("tableName");
String from					=		request.getParameter("from") ;
String to					=		request.getParameter("to") ;
alphalink					=		alphalink.trim();

Connection connection		=		null;
Statement stmt				=		null;
ResultSet rs				=		null;
Statement stmt1	 			=		null;
ResultSet rs1				=		null;
PreparedStatement pstmt     =       null;//common-icn-0180
PreparedStatement pstmt1     =       null;//common-icn-0180
PreparedStatement pstmt2     =       null;//common-icn-0180

int maxRecord				=		0;
int start					=		0 ;
int end						=		0 ;
int i						=		1;

String classValue			=		"";
String  sqlData				=		"";
String readonly				=		"";
String disabled				=		"";
String db_action			=		"";
String goalDesc				=		"";
String goalCode				=		"";
String checkedAttribute		=		"";
String targetPeriod			=		"";
String targetPeriodType		=		"";
String targetSelectStatus	=		"";
//String maxGrpID				=		"";
String practitionerType1	=		"";
String temppractitionerType	=		"";
String practitionerTypeSelect=		"";
String tempTermSet			=		"";
String tempTermCode			=		"";
String Status				=		"";
String temptargetType		=		"";
//String sqlData1				=		"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw where language_id='"+locale+"' ORDER BY 2";//common-icn-0180
String sqlData1				=		"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw where language_id=? ORDER BY 2";//common-icn-0180


//String sqlData2				=		"SELECT PRACT_TYPE,DESC_USERDEF FROM AM_PRACT_TYPE_lang_vw WHERE EFF_STATUS = 'E' and  language_id='"+locale+"' ORDER BY DESC_USERDEF";
String sqlData2				=		"SELECT PRACT_TYPE,DESC_USERDEF FROM AM_PRACT_TYPE_lang_vw WHERE EFF_STATUS = 'E' and  language_id=? ORDER BY DESC_USERDEF";

ArrayList targetType		=		new ArrayList();
ArrayList practitionerType	=		new ArrayList();
ArrayList TermCodeList		=		null;
ArrayList Goal				=		null;
ArrayList sessionList		=		(ArrayList)BuildLibrary.getRecordSetHandle();

if(sessionList.size()>0)
{
	TermCodeList=(ArrayList)BuildLibrary.getObject(0);
}

 if (from == null){ start = 0 ; }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 10 ; }      else {  end = Integer.parseInt( to ) ; }

if(alphalink.equals("Associated")){
	//sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT ORDER BY GOAL_DESC";
	//sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180
	sqlData		=	"SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION  FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ?  AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ? AND  B.OUTCOME_CODE = A.GOAL_CODE   AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180

}
else
{
	//sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,	TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = '"+libraryid+"' AND  VERSION_NO = '"+versionno+"' AND  TERM_SET_ID = '"+termSet+"'AND  TERM_CODE = '"+termCode+"') UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME B, AM_DURATION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT  AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) ORDER BY GOAL_DESC";
	//sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,  TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = '"+libraryid+"' AND  VERSION_NO = '"+versionno+"' AND  TERM_SET_ID = '"+termSet+"'AND  TERM_CODE = '"+termCode+"') AND LANGUAGE_ID = '"+locale+"' UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND B.LANGUAGE_ID = '"+locale+"' AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180
	sqlData		=	"SELECT  OUTCOME_CODE GOAL_CODE,SHORT_DESC GOAL_DESC, TO_NUMBER('') GOAL_TARGET_DURN,  TO_CHAR('') GOAL_TARGET_DURN_UNIT, 'I' DB_ACTION FROM  CP_OUTCOME_LANG_VW WHERE	(('"+alphalink+"' IS NOT NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND  OUTCOME_TYPE = 'G' AND  EFF_STATUS = 'E' AND  OUTCOME_CODE NOT IN (SELECT GOAL_CODE FROM CP_LIBRARY_GOAL WHERE LIBRARY_ID = ? AND  VERSION_NO = ? AND  TERM_SET_ID = ? AND  TERM_CODE = ?) AND LANGUAGE_ID = ? UNION ALL SELECT 	A.GOAL_CODE,B.SHORT_DESC GOAL_DESC,A.GOAL_TARGET_DURN,A.GOAL_TARGET_DURN_UNIT, 'U' DB_ACTION FROM	CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B, AM_DURATION_TYPE_LANG_VW C WHERE	A.LIBRARY_ID = ? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE = ? AND  B.OUTCOME_CODE = A.GOAL_CODE AND  C.DURN_TYPE = A.GOAL_TARGET_DURN_UNIT AND  (('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%')) OR ('"+alphalink+"' IS NULL AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z')) AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = C.LANGUAGE_ID ORDER BY GOAL_DESC";//common-icn-0180

}
try{
	connection	=	ConnectionManager.getConnection(request);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt      =    connection.prepareStatement(sqlData1);//common-icn-0180
	pstmt.setString(1, locale);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlData1);//common-icn-0180
	rs1			=	pstmt.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			targetType.add(rs1.getString("DURN_TYPE"));
			targetType.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();
	pstmt1      =    connection.prepareStatement(sqlData2);//common-icn-0180
	pstmt1.setString(1, locale);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlData2);
	rs1			=	pstmt1.executeQuery();
	if(rs1!=null){
		while(rs1.next()){
			practitionerType.add(rs1.getString("PRACT_TYPE"));
			practitionerType.add(rs1.getString("DESC_USERDEF"));

		}
	}
	rs1.close();
	//common-icn-0180 starts
	int pstmtcount = 1;
	//stmt	=	connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	pstmt2      =    connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	if(alphalink.equals("Associated")){
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);

	}
	else{
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);
		pstmt2.setString(pstmtcount++, libraryid);
		pstmt2.setString(pstmtcount++, versionno);
		pstmt2.setString(pstmtcount++, termSet);
		pstmt2.setString(pstmtcount++, termCode);
		pstmt2.setString(pstmtcount++, locale);
	}
	
	//rs		=	stmt.executeQuery(sqlData);
	rs		=	pstmt2.executeQuery();
	//common-icn-0180 ends
	if(rs!=null){
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		if(maxRecord>0){
				
%>
	<TABLE border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
		<TR>
		<TD width="80%" class="white">&nbsp;</TD>
		<TD width="20%" class="white">&nbsp;</TD>
		<TD align="right">
<%
		if ( !(start <= 1) )
		{
	%>
		<label onClick='Goalnavigation(document.formBuildLibraryGoalDetails,"previous")'  style='cursor:pointer;color:blue'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
<%
		}
		if ( !( (start+10) >= maxRecord ) )
		{
		%>
		<label onClick='Goalnavigation(document.formBuildLibraryGoalDetails,"next")'  style='cursor:pointer;color:blue'><fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
		<%
		}
	%>
	</TD></TR></TABLE>

<TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='100%' >
	<TH ><fmt:message key="eCP.GoalDescription.label" bundle="${cp_labels}"/></TH>
	<TH width="20%"><fmt:message key="eCP.TargetPeriod.label" bundle="${cp_labels}"/></TH>
	<TH width="20%"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></TH>
	<TH width="20%">&nbsp;</TH>
	<TH width="10%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </TH>
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

			goalCode	=	rs.getString("GOAL_CODE");
			goalDesc	=	rs.getString("GOAL_DESC");

			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet=(String)TermCodeList.get(j);
				if(termSet.equals(tempTermSet)){
					 tempTermCode=(String)TermCodeList.get(j+1);
					if(tempTermCode.equals(termCode)){
						Goal=(ArrayList)TermCodeList.get(j+2);
						if(Goal.size()>0){
								if(Goal.contains(goalCode)){
									int k				=	Goal.indexOf(goalCode);
									Status				=	(String)Goal.get(k+4);
									db_action			=	(String)Goal.get(k+5);;
									targetPeriod		=	(String)Goal.get(k+1);
									practitionerType1	=	(String)Goal.get(k+8);
									//out.println("practitionerType1"+practitionerType1);
									if(targetPeriod.equals("0"))
										targetPeriod	=	"";
									targetPeriodType=(String)Goal.get(k+2);
									//maxGrpID			=	(String)Goal.get(k+6);
									if(Status.equals("Y")){
										checkedAttribute =	"checked";
									}
								}
							}
						}
					}
				}

				if(db_action.equals("U")){
					if(alphalink.equals("Associated")){
						readonly="";
						disabled="";
		
					}else
					{
						readonly="readonly";
						disabled="disabled";
					}
				}
							
	%>
	<TR>
		<TD class="<%=classValue%>" align="left" ><%=goalDesc%>
		<INPUT TYPE="hidden" name="goalDesc<%=i%>" id="goalDesc<%=i%>" VALUE="<%=goalDesc%>">
			<!-- <INPUT type="hidden" name="goalDesc<%=i%>" id="goalDesc<%=i%>"  value="<%=goalDesc%>"> -->
		</TD>
		<TD class="<%=classValue%>" align="left">
				<INPUT type="text" class="number" <%=readonly%> name="targetPeriod<%=i%>" value="<%=targetPeriod%>" onKeyPress='return(ChkNumberInput(this,event,0))' onblur="updateGoalList('<%=i%>');" maxlength="5" size="5">
				<SELECT name="targetPeriodType<%=i%>" id="targetPeriodType<%=i%>" <%=disabled%> onchange="updateGoalList('<%=i%>')">
	<%for(int j=0;j<targetType.size();j=j+2){
					temptargetType=(String)targetType.get(j);
					if(temptargetType.equals(targetPeriodType))
						targetSelectStatus="selected";
					else
						targetSelectStatus="";
	%>
					<OPTION <%=targetSelectStatus%> value="<%=targetType.get(j)%>"><%=targetType.get(j+1)%></OPTION>
	<%}%>
				</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="center">
			<SELECT name="practitionerType<%=i%>" id="practitionerType<%=i%>" <%=disabled%> onchange="updateGoalList('<%=i%>')">
				<OPTION >&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
		<%for(int k=0;k<practitionerType.size();k=k+2){
			temppractitionerType=(String)practitionerType.get(k);
			//System.err.println("temppractitionerType  "+temppractitionerType);

			if(temppractitionerType.equals(practitionerType1))
				practitionerTypeSelect="selected";
			else
				practitionerTypeSelect="";
		%>
			<OPTION <%=practitionerTypeSelect%> value="<%=temppractitionerType%>"><%=practitionerType.get(k+1)%></OPTION>
		<%
		}%>
			</SELECT>
		</TD>
		<TD class="<%=classValue%>" align="center"> <label onclick="updateGoalList('<%=i%>');showInterventiondialog('<%=libraryid%>', '<%=versionno%>','<%=termSet%>','<%=termCode%>','<%=goalCode%>','<%=tableName%>');"
	style='cursor:pointer;color:Blue;font:11'><fmt:message key="eCP.InterventionsOutcomes.label" bundle="${cp_labels}"/></label> </TD>
		<TD class="<%=classValue%>" align="center"><INPUT type="checkbox" name="select<%=i%>" id="select<%=i%>" <%=disabled%>   value="<%=goalCode%>"onclick="updateGoalList('<%=i%>')" <%=checkedAttribute%>></TD>
	</TR>
<%
	i++;
		checkedAttribute	=	"";
		targetPeriod		=	"";
		targetPeriodType	=	"";
		practitionerType1	=	"";
		//maxGrpID			=	"";
		db_action			=	"";
		readonly			=	"";
		disabled			=	"";
}
%>
</TABLE>
<INPUT type="hidden" name="start" id="start"     value="<%=start%>">
<INPUT type="hidden" name="end" id="end"       value="<%=end%>">
<INPUT type="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<INPUT type="hidden" name="termSet" id="termSet"   value="<%=termSet%>">
<INPUT type="hidden" name="termCode" id="termCode"  value="<%=termCode%>">
<INPUT type="hidden" name="termDesc" id="termDesc"  value="<%=termDesc%>">
<INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
<INPUT type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<INPUT type="hidden" name="tableName" id="tableName" value="<%=tableName%>">

<%	
		}else{
%>
	<SCRIPT></SCRIPT>
<%
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
	//common-icn-0180 starts
	if(pstmt!=null)
		pstmt.close();
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt2!=null)
		pstmt2.close();
	//common-icn-0180 ends
	ConnectionManager.returnConnection(connection,request);

}
%>
</BODY>
</FORM>
</HTML>


