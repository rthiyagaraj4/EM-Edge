
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try{
	
	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );	

	/* Mandatory checks start */
	
	//String mode					=	(String)hash.get("mode");
	//String function_id			=	(String)hash.get("function_id"); 
	String bean_id_P			=	(String)hash.get("bean_id_caller"); 
	String bean_name_P			=	(String)hash.get("bean_name_caller");  
	String callFrom			=	(String)hash.get("callFrom");  

	boolean flag				=   false ;
	
	
	//Object beanCaller = mh.getBeanObject(bean_id_P,request,bean_name_P);
	Object beanCaller =  getBeanObject( bean_id_P,bean_name_P,request) ;
	SceduleFreqeuncyInterface bc= (SceduleFreqeuncyInterface)beanCaller ;
	
	try
	{
	if(callFrom.equals("SCHEDULE_DATES")){
		 String strDates = (String)hash.get("schedule_dates");  		
		 String repeat = (String)hash.get("repeat");  
		 String[] strDates1 = strDates.split("`~") ;
		 String[] strDates2 = null ;
		 ArrayList datesList = new ArrayList();
		 ArrayList dayList = new ArrayList();
		 HashMap schdMap = new HashMap();
		 String dateStr = "";
		 if(strDates1 != null && strDates1.length > 0)
		{
			for(int i=0;i<strDates1.length;i++)
			{
				dateStr = strDates1[i];
				if(!dateStr.equals(""))
				{
					strDates2 = dateStr.split(" ");
					datesList.add(strDates2[0]);
					dayList.add(strDates2[1]);
				}
			}
		}
		 
		  
		 schdMap.put("DATES",datesList);
		 schdMap.put("DAYS",dayList);
		 
		 HashMap hashMap= bc.getScheduleDates();
		 hashMap.put(Integer.parseInt(repeat),schdMap);
		 
		 bc.setScheduleDates(hashMap);
	}else if(callFrom.equals("FORM_SUBMIT")){
		
		flag			      = bc.setScheduleFrequencyStr(hash);
		}
	}catch(Exception e){
	e.printStackTrace();
	%>
	<script>alert("Exception thrown ...Chk in scheduleFreqencySubmit.jsp"+"<%=e.getMessage()%>");</script>

	<%}out.println("syncStatus(" + flag + ")");%>

<%
	putObjectInBean(bean_id_P,beanCaller,request);
}catch(Exception e){
	//out.println("Exp in scheduleFreqencySubmit.jsp"+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
%>
