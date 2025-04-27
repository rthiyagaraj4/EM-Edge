<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import=" eSS.LoanAcknowledgementBean,java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	LoanAcknowledgementBean bean = (LoanAcknowledgementBean)getBeanObject("LoanAcknowledgementBean","eSS.LoanAcknowledgementBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	
	try {
		if(validate.equals("LOAD_DETAIL")){
			bean.clear();
			String trn_type				=	request.getParameter("trn_type");
			String doc_type_code		=	request.getParameter("doc_type_code");
			String doc_no				=	request.getParameter("doc_no");
			String fm_doc_date			=	request.getParameter("fm_doc_date");
			fm_doc_date					=	com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY",locale,"en");   
			String to_doc_date			=	request.getParameter("to_doc_date");
			to_doc_date					=	com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			String action_type			=	request.getParameter("action_type");
			String fm_store_code		=	CommonBean.checkForNull(request.getParameter("fm_store_code"),"%");
			String to_store_code		=	CommonBean.checkForNull(request.getParameter("to_store_code"),"%");
			String group_code			=	CommonBean.checkForNull(request.getParameter("group_code"),"%");
			String doc_ref				=	CommonBean.checkForNull(request.getParameter("doc_ref"),"%");
			
			bean.setDoc_type_code(doc_type_code);
			bean.setFmStore_code(fm_store_code); 
			bean.setToStore(to_store_code);
			bean.setTrn_type(trn_type);
			bean.setAction_type(action_type);			

			bean.loadTFRDtlData(fm_doc_date,to_doc_date,doc_no,group_code,doc_ref);

			
			result = true;
		}else if(validate.equals("LOAD_EXP_DETAIL")){
			result = true;
			String doc_no			=	request.getParameter("doc_no");
			ArrayList alExpRecords	=	new ArrayList();
			HashMap hmRecord		=	new HashMap();
			boolean resultTemp		=	false;
			String seq_no			=	request.getParameter("seq_no");
			String fm_store_code	=	request.getParameter("fm_store_code");
			String to_store_code	=	request.getParameter("to_store_code");
			int size = ((ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no)).size();
			
			if(!(size>0)){
				bean.loadTFRExpData(doc_no,seq_no);
			}
	

		}else if(validate.equals("UPDATE_EXP_DETAIL")){
			String doc_no	=	request.getParameter("doc_no");
			String seq_no	=	request.getParameter("seq_no");
			String req_doc_no	=	request.getParameter("req_doc_no");
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
			ArrayList alResult = (ArrayList)bean.getTFRExpRecords(doc_no+"~"+seq_no);
			
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				String ack_status = (String)htFormValues.get("acknowledge_atatus_"+i);
				
				hmTemp.put("REMARKS",(String)htFormValues.get("remarks_"+i));
				
				hmTemp.put("ACKNOWLEDGE_STATUS",(String)htFormValues.get("acknowledge_atatus_"+i));
				hmTemp.put("REQ_DOC_NO",req_doc_no);
				alExpRecords.add(hmTemp);

			}
			bean.setTFRExpRecords(doc_no+"~"+seq_no,alExpRecords);
			bean.setDoc_no(doc_no);
			bean.setSeq_no(seq_no);

			result = true;
			flag="";
		}else if(validate.equals("TRNTYPE")){
			result = true;
			flag = "";
			String trn_type = request.getParameter("trn_type");
			
			bean.setTrn_type(trn_type);
			out.println("clearListItems('document.getElementById(\"fm_store_code\")'); clearListItems('document.getElementById(\"to_store_code\")');");
			
			ArrayList alStoreList = bean.getStoreArrayList();
			
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.getElementById('fm_store_code')\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); addListItem(\"document.getElementById('to_store_code')\", \"" +listRecord+ "\",\"" +listRecord1+ "\");");
				
				
			}
			out.println("clearListItems('document.getElementById(\"doc_type_code\")'); ");
			ArrayList alDocTypeList = bean.getDocTypeArrayList();
			
			record	=	null;
			for(int i=0; i< alDocTypeList.size(); i++) {
				record	=	(HashMap)alDocTypeList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.getElementById('doc_type_code')\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}

		if(trn_type.equals("RTL")) {
			out.println("parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.action_type.options.length=0; ");
			out.println("addListItem(\"parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.action_type\", \"" +"A"+ "\",\"" +"Acknowledge"+ "\",\"" +"A"+ "\") ; ");
			out.println("document.getElementById('fm_store_img').style.visibility='hidden';");
			out.println("document.getElementById('to_store_img').style.visibility='visible';");
		}else if(trn_type.equals("ISL")) {
			out.println("parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.action_type.options.length=0;");
			out.println("addListItem(\"parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.action_type\", \"" +"A"+ "\",\"" +"Acknowledge"+ "\",\"" +"A"+ "\") ; ");
			out.println("addListItem(\"parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.action_type\", \"" +"C"+ "\",\"" +"Confirm"+ "\") ; ");

			}

		}else if(validate.equals("ACTIONTYPE")){
			result = true;
			flag = "";
			String action_type = request.getParameter("action_type");
			bean.setAction_type(action_type);
			out.println("clearListItems('document.getElementById(\"fm_store_code\")'); clearListItems('document.getElementById(\"to_store_code\")');");
			
			ArrayList alStoreList = bean.getStoreArrayList();
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.getElementById('fm_store_code')\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); addListItem(\"document.getElementById('to_store_code')\", \"" +listRecord+ "\",\"" +listRecord1+ "\");");
				
			}
		}else if(validate!= null && validate.equals("toolBar"))  {
	         String toolBarString = request.getQueryString() ;
			 session.removeValue("queryString") ;
			 session.putValue( "queryString", toolBarString ) ;
	  	}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
		//flag=validate;
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}
%>
<%
	putObjectInBean("LoanAcknowledgementBean",bean,request);
%>
