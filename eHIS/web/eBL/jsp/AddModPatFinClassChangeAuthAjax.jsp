<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.text.*,eBL.*" contentType="text/html;charset=UTF-8" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 <%@page import="org.json.simple.JSONObject"%>	
<%!

public String appendDelimiter(String patientId, String AuthYN, String delimiter){
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp patientId :: "+patientId+" AuthYN :: "+AuthYN+" delimiter :: "+delimiter);
	
	if(patientId==null){
		return patientId;
	}
	else{
		return patientId+delimiter+AuthYN;
	}
}

%>
<%

try{
	JSONObject obj=new JSONObject();
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp");
	
	String classTypChangeAuthYN=request.getParameter("classTypChangeAuthYN");
// 	String refreshAuth=request.getParameter("refreshAuth");
// 	String tabsSwapped=request.getParameter("tabsSwapped");
	String patientId=request.getParameter("patientId");
	String called_from=request.getParameter("called_from");
	String delimiter="::";
	String classTypChangeAuthYnPatId="";
	String prevPatId=request.getParameter("prevPatId");
	
	if(("authUser").equals(called_from)){
		
		System.err.println("authUser classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		classTypChangeAuthYnPatId=appendDelimiter(patientId,classTypChangeAuthYN,delimiter);		
		System.err.println("classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		session.setAttribute("classTypChangeAuthYnPatId",classTypChangeAuthYnPatId);		
		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYnPatId");		
		System.err.println("classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		
	}
	else if(("onLoad").equals(called_from)){	

		System.err.println("onload removing classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYN");	
		System.err.println("removing classTypChangeAuthYN value from session :: "+classTypChangeAuthYnPatId);
		if(classTypChangeAuthYnPatId != null ){
			String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			prevPatId=classTypChangeTokens[0];
			classTypChangeAuthYN=classTypChangeTokens[1];
			if(prevPatId != null){
				if(!(patientId.equals(prevPatId))){
					session.removeAttribute("classTypChangeAuthYnPatId");	
				}
			}
		}
		System.err.println("AddModPatFinClassChangeAuthAjax.jsp onload prevPatId "+prevPatId+"patientId "+patientId+"classTypChangeAuthYN " + classTypChangeAuthYN);
	
		
	}
// 	else if(("getSessionVal").equals(called_from)){
// 		System.err.println("getting session value: classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
// 		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYnPatId");	
// 		System.err.println("getting session value: classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
// 	}
	
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp prevPatId "+prevPatId+"patientId "+patientId+"classTypChangeAuthYN " + classTypChangeAuthYN);
	out.println("SUCCESS");

	obj.put("classTypChangeAuthYnPatId",classTypChangeAuthYnPatId);
	System.err.println("classTypChangeAuthYnPatId==="+classTypChangeAuthYnPatId);
	out.println(classTypChangeAuthYnPatId);   

}
catch(Exception e){	
	e.printStackTrace();
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp : " + e);
}


%>

 
