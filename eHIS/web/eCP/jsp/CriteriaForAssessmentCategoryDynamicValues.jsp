
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
  
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String clearAll="";
	ArrayList recordArray=new ArrayList();
	String select_yn="";
	 	clearAll =request.getParameter("clearAll")==null?"":request.getParameter("clearAll");
		RecordSet CriteriaForAssessmentCategory =	null;
		CriteriaForAssessmentCategory	=	(webbeans.eCommon.RecordSet) session.getAttribute("CriteriaForAssessmentCategory");
		if(clearAll.equals("clearAll"))
		{
		 int size=CriteriaForAssessmentCategory.getSize();
			for(int i=0;i<size;i++)
			{
				recordArray=(ArrayList)CriteriaForAssessmentCategory.getObject(i);
				select_yn="N";
				recordArray.set(6,select_yn);
				CriteriaForAssessmentCategory.setObject(i,recordArray);
			}
	
		}
	  else if(clearAll.equals("notCleared"))
		{
		  int size=CriteriaForAssessmentCategory.getSize();
          for(int i=0;i<size;i++)
			{
				 recordArray=(ArrayList)CriteriaForAssessmentCategory.getObject(i);
				 select_yn="Y";
				 recordArray.set(6,select_yn);
				 CriteriaForAssessmentCategory.setObject(i,recordArray);
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




