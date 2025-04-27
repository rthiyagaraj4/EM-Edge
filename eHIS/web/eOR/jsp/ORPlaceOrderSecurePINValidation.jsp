
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?           created
23/01/2012    IN030563    Ramesh G   The Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? 
									 Prompt once for all categories. 						 
									 But the Pin No. is prompted each time we Place a Category and also when we record the category.

25/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.	 							  
-----------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% request.setCharacterEncoding("UTF-8"); 

	try 
	{
		String bean_id 			= request.getParameter( "bean_id" ) ;
		String bean_name 		= request.getParameter( "bean_name" ) ;
		String func_mode	= request.getParameter("func_mode");
		String order_category = request.getParameter("order_category");
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
			
		OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;	
//[IN030563] Start		
		/*if(func_mode!= null && func_mode.equals("validateUserPIN"))
		{
			String usr_id		= request.getParameter( "usr_id" ) ;
			String pass_wd		= request.getParameter( "pass_wd" ) ;
			String valid_user	= bean.validateUserPIN(usr_id,pass_wd);
			out.println(valid_user);
		}
		else if(func_mode!= null && func_mode.equals("validatePIN"))
		{
			String usr_id1		= request.getParameter( "usr_id" ) ;
			String usr_name = request.getParameter( "usr_name" ) ;
			
			String pass_wd		= request.getParameter( "pass_wd" ) ;
			String valid_user	= bean.validatePIN(usr_id1,pass_wd,usr_name);
			out.println(valid_user);
		}
		else if(func_mode!= null && func_mode.equals("SecurePIN"))
		{
			
			String secure_pin_yn = bean.securePINyn(order_category);
			out.println(secure_pin_yn);
		}
		else if(func_mode!= null && func_mode.equals("clearBean"))
		{
			bean.clear();
		}*/
		
		
		String retVal="";
		String usr_id		= request.getParameter( "usr_id" ) ;	
		String usr_name = request.getParameter( "usr_name" ) ;		
		String pass_wd		= request.getParameter( "pass_wd" ) ;	

		if(func_mode!= null && func_mode.equals("validateUserPIN"))
			retVal		= bean.validateUserPIN(usr_id,pass_wd);
		else if(func_mode!= null && func_mode.equals("validatePIN"))
			retVal		= bean.validatePIN(usr_id,pass_wd,usr_name);
		else if(func_mode!= null && func_mode.equals("SecurePIN"))
			retVal		= bean.securePINyn(order_category);
		else if(func_mode!= null && func_mode.equals("clearBean"))
			bean.clear();		
		
		//if("Y".equals(retVal))								//[IN030566]
				//session.setAttribute("TEMP_PASS",pass_wd);	//[IN030566]	
		out.println(retVal);									
//[IN030563] Ends
	}
	catch (Exception e) 
	{
	//	out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}
%>
