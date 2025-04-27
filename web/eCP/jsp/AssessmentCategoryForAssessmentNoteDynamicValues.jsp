<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String clearAll="";
 //This file is saved on 18/10/2005.
try
{
String assess_note_id=request.getParameter("assess_note_id");
	ArrayList recordArray=new ArrayList();
	String select_yn="";

if(assess_note_id == null) assess_note_id="";

 clearAll = request.getParameter("clearAll");

if(clearAll == null) clearAll="";
RecordSet	CatgForAssessment =	null;
CatgForAssessment	=	(webbeans.eCommon.RecordSet)session.getAttribute("CatgForAssessment");

if(clearAll.equals("clearAll"))
		{
		 int size=CatgForAssessment.getSize();
			for(int i=0;i<size;i++)
			{
				recordArray=(ArrayList)CatgForAssessment.getObject(i);
				select_yn="N";
				recordArray.set(2,select_yn);
				CatgForAssessment.setObject(i,recordArray);
			}
	
		}
	  else if(clearAll.equals("notCleared"))
		{
  		  int size=CatgForAssessment.getSize();
          for(int i=0;i<size;i++)
			{
				 recordArray=(ArrayList)CatgForAssessment.getObject(i);
				 select_yn="Y";
				 recordArray.set(2,select_yn);
				 CatgForAssessment.setObject(i,recordArray);
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
<%}
catch(Exception e){
	//out.print(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
%>

