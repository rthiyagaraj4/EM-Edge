
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
		//[IN030566] Start
		String mode 		= request.getParameter( "mode" ) ;		
		if("Get".equals(mode)){
			String keyObj 		= request.getParameter( "keyObj" ) ;
			String patient_id	= request.getParameter( "patient_id" ) ;
			String keyVal="false";
			if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
				HashMap mHash = new HashMap();
				HashMap cHash = new HashMap();
				mHash = (HashMap) session.getAttribute("TEMP_PASS");
				if(mHash.containsKey(patient_id)){
					cHash	= (HashMap) mHash.get(patient_id);
					if(cHash.containsKey(keyObj)){
						keyVal = (String)cHash.get(keyObj);
					}
				}
			}
			out.println(keyVal);
			
		}else if("Set".equals(mode)){
			String keyObj 		= request.getParameter( "keyObj" ) ;
			String patient_id	= request.getParameter( "patient_id" ) ;
			String keyValue 		= request.getParameter( "keyValue" ) ;	
			String outPutVal		= "false";
			try{
				HashMap mHash = new HashMap();
				HashMap cHash = new HashMap();
				if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
					mHash = (HashMap) session.getAttribute("TEMP_PASS");
					if(mHash.containsKey(patient_id)){
						cHash	= (HashMap) mHash.get(patient_id);
						cHash.put(keyObj,keyValue);
						mHash.put(patient_id, cHash);
						session.setAttribute("TEMP_PASS",mHash);
					}else{
						cHash.put(keyObj,keyValue);
						mHash.put(patient_id, cHash);
						session.setAttribute("TEMP_PASS",mHash);
					}
				}else{		
					cHash.put(keyObj,keyValue);
					mHash.put(patient_id, cHash);
					session.setAttribute("TEMP_PASS",mHash);
				}
				outPutVal="true";
			}catch(Exception e){
				//out.println("false") ;
				e.printStackTrace();
			}
			out.println(outPutVal) ;
		}else if("getLoginPraName".equals(mode)){
			String bean_id 			= request.getParameter( "bean_id" ) ;
			String bean_name 		= request.getParameter( "bean_name" ) ;
			String usr_id			="";
			String logingPrac_name			="";			
			usr_id			= (String)session.getValue("login_user");
			OrderEntryBean bean    	= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
			logingPrac_name	= bean.getLoginUserName(usr_id);
			String value=usr_id+"^"+logingPrac_name;
			out.println(value);
		
		}
		
		/*
		//[IN030563] Starts
		String temp_pass	= ((session.getAttribute("TEMP_PASS")!=null)||(session.getAttribute("TEMP_PASS")!=""))?(String)session.getAttribute("TEMP_PASS"):"";			
		if(!temp_pass.equals("") && temp_pass!=null){
			out.println(temp_pass);
		}else{
			out.println("");
		}
		//[IN030566] Ends
		*/
		//[IN030566] Ends
	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;
		out.println("false") ;
		e.printStackTrace();
	}
%>
