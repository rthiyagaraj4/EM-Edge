<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*,eSS.Common.*,java.util.*"%>  
<jsp:useBean id="alAlternateGroupList" scope="session" class="java.util.ArrayList"/>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String bean_id="alternateGroupListBean";
	String bean_name= "eSS.AlternateGroupListBean";
	AlternateGroupListBean bean = (AlternateGroupListBean)getBeanObject(bean_id , bean_name, request ) ;  
	String function					=	bean.checkForNull(request.getParameter("function"));
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	String bean_id1					=		"AlternateGroupBean" ;
	String bean_name1				=		"eSS.AlternateGroupBean";
	AlternateGroupBean bean1 = (AlternateGroupBean)getBeanObject(bean_id1 , bean_name1, request ) ;  
try{
if(function.equals("ALTERNATIVEGROUPCODE")){

	
	ArrayList		alternateGroupDetails = new ArrayList(bean1.getalternateGroupDetails());
	
String alternative_group_code1= (String)request.getParameter("alternative_group_code")==null?"":(String)request.getParameter("alternative_group_code");	


String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
String temp_alternative_group_code="";
int count=0;
if(!alternative_group_code1.equals("")){

		while((alternateGroupDetails != null) && (count < alternateGroupDetails.size())){
			temp_alternative_group_code = (String)alternateGroupDetails.get(count);
			System.out.println("temp_alternative_group_code"+temp_alternative_group_code);
			if(alternative_group_code1.equals(temp_alternative_group_code)){
			System.out.println("selected_yn"+selected_yn);
			System.out.println(" alternateGroupDetails.set(count+4;"+ alternateGroupDetails.get(4));


				if(selected_yn.equals("Y"))
					 alternateGroupDetails.set(count+4, "Y");
				else
					 alternateGroupDetails.set(count+4, "N");
			}
			count+=5;

		}
	}
	result=true;
	message="";
		bean1.setalternateGroupDetails(alternateGroupDetails);
}	
	
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		putObjectInBean(bean_id1,bean1,request);

	}
%>
