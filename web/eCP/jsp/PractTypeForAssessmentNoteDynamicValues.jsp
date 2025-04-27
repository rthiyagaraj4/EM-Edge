
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	PractTypeForAssessmentNoteDyanamicValues.jsp
*	Purpose 			:	to Store the selected practitioner type into the RecordSet
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/
%>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%
//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale=(String)session.getAttribute("LOCALE");
	Connection con = null;
	PreparedStatement pstmt_practType=null;
	ResultSet rs_practType=null;
	String clearAll="";
	String assess_note_id="";
	try{
		assess_note_id=request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");
		clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");

		RecordSet	PractTypeForAssessmentNote	=	null;
		PractTypeForAssessmentNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractTypeForAssessmentNote");

		if(clearAll.equals("clearAll")){
			PractTypeForAssessmentNote.clearAll();
		}
		else if(clearAll.equals("notCleared")){
			con = ConnectionManager.getConnection(request);
//			String sql_practType="select  pract_type, desc_userdef pract_type_desc,'I' db_action from am_pract_type where pract_type not in(select pract_type from cp_assess_note_pract_type where assess_note_id = ?) union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from cp_assess_note_pract_type a, am_pract_type b where a.assess_note_id = ? and b.pract_type = a. pract_type order by 2";
			String sql_practType="select  pract_type, desc_userdef pract_type_desc,'I' db_action from am_pract_type_lang_vw where pract_type not in(select pract_type from cp_assess_note_pract_type where assess_note_id = ?) and language_id=? union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from cp_assess_note_pract_type a, am_pract_type_lang_vw b where a.assess_note_id = ? and b.pract_type = a. pract_type and language_id=? order by 2";

			pstmt_practType=con.prepareStatement(sql_practType);
			pstmt_practType.setString(1,assess_note_id);
			pstmt_practType.setString(2,locale);
			pstmt_practType.setString(3,assess_note_id);
			pstmt_practType.setString(4,locale);
			rs_practType=pstmt_practType.executeQuery();
			while(rs_practType.next()){
				if(!(PractTypeForAssessmentNote.containsObject(rs_practType.getString(1))))
					PractTypeForAssessmentNote.putObject(rs_practType.getString(1));
			}
		}
%>

<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name=Dynamic_form>
		<input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%
	}
	catch(Exception e){out.print(e);}
		finally{

		if(rs_practType!=null)
			  rs_practType.close();
		if(pstmt_practType!=null)
			  pstmt_practType.close();
		ConnectionManager.returnConnection(con,request);

	  }
%>

