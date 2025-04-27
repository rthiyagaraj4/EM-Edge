
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*,com.ehis.persist.*" %>

<%
	request.setCharacterEncoding("UTF-8");	

	String messageId = request.getParameter("msgId");
	String moduleId = request.getParameter("moduleId");
	
	boolean paramAvailable=false;

	try{ 
		String params[] =new String[10] ;
		
		for(int i=0;i<=10;i++){
			if(request.getParameter((""+i)) !=null){
				paramAvailable=true;
				params[i] = request.getParameter(""+i);
			}
		}

		String returnText = SpringCacheBean.getMessage(pageContext,messageId,moduleId); 

		if(paramAvailable){
			
			for(int i=0;i<params.length; i++) {
				if(params[i] !=null){
					String messageKey = params[i];
					if(messageKey !=null){
						if(messageKey.indexOf(".") != -1) {
							//int msgLen = messageKey.length();
							String val  = SpringCacheBean.getLabel(pageContext,messageKey,moduleId) ;
							if(!val.equals(""))	params[i] = val ;
						}
					}
				}
			}	
			returnText = MessageFormat.format( returnText, params );		
		}
		out.println(returnText);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
