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
*	Created By		:	Sandhya.S
*	Created On		:	24 jan 2005

--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
</head>
<Title><fmt:message key="eCP.LibraryDetails.label" bundle="${cp_labels}"/></Title>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<Form>
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
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmtgoal=null;
	PreparedStatement pstmtIntvn=null;
	PreparedStatement pstmtOutcome=null;
	PreparedStatement pstmt = null;//common-icn-0180
	ResultSet termcoders=null;
	ResultSet goalrs=null;
	ResultSet Intvnrs=null;
	ResultSet Outcomers=null;

	String libraryid=request.getParameter("library_id")==null?"":request.getParameter("library_id");
	String versionno=request.getParameter("versionno")==null?"1":request.getParameter("versionno");
	int version_no=Integer.parseInt(versionno);
	String desc=request.getParameter("short_desc")==null?"":request.getParameter("short_desc");

	String termcodeQuery="";
	String termCode="";
	String termSet="";
	String termdesc="";
	String prevtermSet="";

//	String goalQuery="SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC  FROM CP_LIBRARY_GOAL A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE ORDER BY GOAL_DESC";
	String goalQuery="SELECT A.GOAL_CODE,B.SHORT_DESC GOAL_DESC FROM CP_LIBRARY_GOAL A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?  AND  B.OUTCOME_CODE = A.GOAL_CODE AND B.LANGUAGE_ID = ? ORDER BY GOAL_DESC";
	String goalCode="";

//	String InterventionSql	=	"SELECT B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,A.GROUP_ID FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B WHERE	A.LIBRARY_ID =? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE =? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE ORDER BY INTERVENTION_DESC";
	String InterventionSql	=	"SELECT B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,A.GROUP_ID FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_lang_vw B WHERE	A.LIBRARY_ID =? AND  A.VERSION_NO = ? AND  A.TERM_SET_ID = ? AND  A.TERM_CODE =? AND  A.GOAL_CODE = ? AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND B.LANGUAGE_ID = ? ORDER BY INTERVENTION_DESC";
//	String OutcomeSql		=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID =?   AND  A.TERM_CODE = ?  AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE ORDER BY OUTCOME_DESC";
	String OutcomeSql		=	"SELECT  A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC, GROUP_ID FROM  CP_LIBRARY_OUTCOME A, CP_OUTCOME_LANG_VW B WHERE	A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID =?   AND  A.TERM_CODE = ?  AND  A.GOAL_CODE = ?   AND  B.OUTCOME_CODE = A.OUTCOME_CODE AND B.LANGUAGE_ID = ? ORDER BY OUTCOME_DESC";

	String groupid="";
	String tempString="";

	String intvndesc="";
	String outcomedesc="";
	HashMap Group=null;
	ArrayList GroupDetail=null;

	//int index=1;
	int k=0;

	/*if(!index1.equals(""))
		index=Integer.parseInt(index1);*/
	try{

		conn = ConnectionManager.getConnection(request);
		//stmt = conn.createStatement();//common-icn-0180
		pstmtgoal = conn.prepareStatement(goalQuery);
		pstmtIntvn=conn.prepareStatement(InterventionSql);
		pstmtOutcome=conn.prepareStatement(OutcomeSql);	
	%>
		
	<BR>
	 <table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th width="25%" ><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></th>
		<th><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></th>
		<th nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		
	</tr>
	<tr>
		<td align="left" class='ATCLIB'><%=libraryid%></td>
		<td align="left" class='ATCLIB'><%=versionno%></td>
		<td align="left" class='ATCLIB'><%=desc%></td>
	</tr>
<%
		//termcodeQuery="SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID='"+libraryid+"' AND A.VERSION_NO='"+versionno+"' AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";//common-icn-0180
        termcodeQuery="SELECT A.TERM_SET_ID,A.TERM_CODE,B.SHORT_DESC TERMCODE_DESC FROM CP_LIBRARY_TERM_CODE A,MR_TERM_CODE B WHERE A.LIBRARY_ID=? AND A.VERSION_NO=? AND A.TERM_SET_ID=B.TERM_SET_ID AND A.TERM_CODE=B.TERM_CODE ORDER BY TERMCODE_DESC";//common-icn-0180
        pstmt=conn.prepareStatement(termcodeQuery);//common-icn-0180
        pstmt.setString(1, libraryid);//common-icn-0180
        pstmt.setString(2, versionno);//common-icn-0180
        termcoders = pstmt.executeQuery();//common-icn-0180
       // termcoders = stmt.executeQuery(termcodeQuery);//common-icn-0180
		if(termcoders!=null)
		{
			while(termcoders.next()){
				termCode=termcoders.getString("TERM_CODE");
				termSet=termcoders.getString("TERM_SET_ID");
				termdesc=termcoders.getString("TERMCODE_DESC");
				if(!prevtermSet.equals(termSet)){
	%>
		<tr><td align="left" class='ATCTERMSET' colspan="3">&nbsp;&nbsp;&nbsp;<%=termSet%></td></TR>
	<%
			}
	%>
		<tr><td align="left" class='ATCTERMCODE'colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=termdesc%></td></tr>
	<%
				pstmtgoal.setString(1,libraryid);
				pstmtgoal.setInt(2,version_no);
				pstmtgoal.setString(3,termSet);
				pstmtgoal.setString(4,termCode);
				pstmtgoal.setString(5,locale);
				goalrs=pstmtgoal.executeQuery();
				if(goalrs!=null){
					while(goalrs.next()){
						goalCode=goalrs.getString("GOAL_CODE");
						Group=new HashMap();
	%>
		<TR>
			<TD colspan="3" align="left"  class='ATCGOAL' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=goalrs.getString("GOAL_DESC")%></TD>
		</TR>
	<%			
						pstmtIntvn.setString(1,libraryid);
						pstmtIntvn.setInt(2,version_no);
						pstmtIntvn.setString(3,termSet);
						pstmtIntvn.setString(4,termCode);
						pstmtIntvn.setString(5,goalCode);
						pstmtIntvn.setString(6,locale);
						Intvnrs=pstmtIntvn.executeQuery();
						if(Intvnrs!=null){
							while(Intvnrs.next()){
								groupid=Intvnrs.getString("GROUP_ID");
								if(Group.containsKey(groupid)){
									GroupDetail=(ArrayList)Group.get(groupid);
									GroupDetail.add(Intvnrs.getString("INTERVENTION_CODE"));
									GroupDetail.add(Intvnrs.getString("INTERVENTION_DESC"));
									GroupDetail.add("");
									GroupDetail.add("");

								}else{
									GroupDetail=new ArrayList();
									GroupDetail.add(Intvnrs.getString("INTERVENTION_CODE"));
									GroupDetail.add(Intvnrs.getString("INTERVENTION_DESC"));
									GroupDetail.add("");
									GroupDetail.add("");
									Group.put(groupid,GroupDetail);
								}
							}
						}
						Intvnrs.close();
						groupid="";
						pstmtOutcome.setString(1,libraryid);
						pstmtOutcome.setInt(2,version_no);
						pstmtOutcome.setString(3,termSet);
						pstmtOutcome.setString(4,termCode);
						pstmtOutcome.setString(5,goalCode);
						pstmtOutcome.setString(6,locale);
						Outcomers=pstmtOutcome.executeQuery();
						if(Outcomers!=null){
							while(Outcomers.next()){
								groupid=Outcomers.getString("GROUP_ID");
								if(Group.containsKey(groupid)){
									k=0;
									GroupDetail=(ArrayList)Group.get(groupid);
									for(int i=0;i<GroupDetail.size();i=i+4){
										tempString=(String)GroupDetail.get(i+2);
										if(!tempString.equals(""))
											k=k+4;
										else
											break;
									}
									if(k<GroupDetail.size()){
										GroupDetail.set(k+2,Outcomers.getString("OUTCOME_CODE"));
										GroupDetail.set(k+3,Outcomers.getString("OUTCOME_DESC"));
									}else{
										GroupDetail.add("");
										GroupDetail.add("");
										GroupDetail.add(Outcomers.getString("OUTCOME_CODE"));
										GroupDetail.add(Outcomers.getString("OUTCOME_DESC"));
									}
								}
							}
						}
						Outcomers.close();
						//System.err.println("Group in goal  "+Group);
						Set itr_set			=	Group.keySet();
						Iterator recordItr	=	itr_set.iterator();
						while(recordItr.hasNext()){
							groupid="";
							groupid=(String)recordItr.next();
							GroupDetail=(ArrayList)Group.get(groupid);
							for(int i=0;i<GroupDetail.size();i=i+4){
								intvndesc=(String)GroupDetail.get(i+1);
								outcomedesc=(String)GroupDetail.get(i+3);
								if(!intvndesc.equals("")){
		%>
						<TR><TD colspan="3" align="left"  class='ATCHEAD' style="border: none;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[I] <%=intvndesc%></TD></TR>
		<%
								}
								if(!outcomedesc.equals("")){
		%>
						<TR><TD colspan="3" align="left"  class='ATCHEAD'style="border: none;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[O] <%=outcomedesc%></TD></TR>

		<%
								}

							}
		%>
						<TR><TD colspan="3" align="left"  class='ATCHEAD'style="border: none;" >&nbsp;</TD></TR>
		<%
						}
		
					}
				}
			prevtermSet=termSet;
            goalrs.close();
		}
	}


%>
</table>
	<BR>
<%	
	}catch(Exception e){
		//out.println(e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(termcoders!=null)
			termcoders.close();
		if(goalrs!=null)
			goalrs.close();
		if(Intvnrs!=null)
			Intvnrs.close();
		if(Outcomers!=null)
			Outcomers.close();
		if(pstmtgoal!=null)
			pstmtgoal.close();
		if(pstmtIntvn!=null)
			pstmtIntvn.close();
		if(pstmtOutcome!=null)
			pstmtOutcome.close();
		if(pstmt!=null)//common-icn-0180
			pstmt.close();//common-icn-0180
		if (stmt != null) 
			stmt.close();
		if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

