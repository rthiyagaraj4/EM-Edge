<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Hema Malini B
*	Created On		:	22 Jan 2005

-->
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
  
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//This file is saved on 18/10/2005.
	String clearAll="";
	ArrayList recordArray=new ArrayList();
	String select_yn="";
		
   try{
	  	/*String practitioner_id=request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	    String practitioner_name=request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
		String pract_type=request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");*/
    	clearAll =request.getParameter("clearAll")==null?"":request.getParameter("clearAll");

		RecordSet CPAccessRights =	null;
		CPAccessRights	=	(webbeans.eCommon.RecordSet) session.getAttribute("CPAccessRights");
		int size=CPAccessRights.getSize();
		if(clearAll.equals("clearAll")){
			 for(int i=0;i<size;i++)
			{
				  recordArray=(ArrayList)CPAccessRights.getObject(i);
				   select_yn="N";
				  recordArray.set(7,select_yn);
				  CPAccessRights.setObject(i,recordArray);
			}
	
		}
		else if(clearAll.equals("notCleared")){
			 out.println("size"+size);

			 for(int i=0;i<size;i++)
			{
				  recordArray=(ArrayList)CPAccessRights.getObject(i);
				   select_yn="Y";
				  recordArray.set(7,select_yn);
				  CPAccessRights.setObject(i,recordArray);
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
	catch(Exception e){
		//out.print(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		}
		
%>

