<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alAckDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%	try{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	SSAcknowledgementBean bean = (SSAcknowledgementBean)getBeanObject("SSAcknowledgementBean","eSS.SSAcknowledgementBean",request);  
	AckDiscrepancyListBean ackDiscrepancyListBean = (AckDiscrepancyListBean)getBeanObject( "AckDiscrepancyListBean", "eSS.AckDiscrepancyListBean", request ) ;  //Added for TH-KW-CRF-0026
	
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");

	String group_code				=	request.getParameter("group_code");//Adding start for TH-KW-CRF-0026
	String tray_no					=	request.getParameter("tray_no");
	String item_code				=	request.getParameter("item_code");
	String item_desc				=	request.getParameter("item_desc");
	String write_off_reason_code	=	request.getParameter("write_off_reason_code");
	String write_off_reason_desc	=	request.getParameter("write_off_reason_desc");
	String discrepancy_qty			=	request.getParameter("discrepancy_qty"); 

	String remarks					=	request.getParameter("remarks"); ;
	String index					=	request.getParameter("index");//Adding end for TH-KW-CRF-0026
//System.err.println("@@ index=="+index+"remarks=="+remarks+"discrepancy_qty=="+discrepancy_qty+"write_off_reason_desc=="+write_off_reason_desc+"write_off_reason_code=="+write_off_reason_code+"item_desc=="+item_desc+"item_code==="+item_code+"tray_no=="+tray_no+"group_code=="+group_code);
//	System.err.println("session==After==="+(ArrayList)session.getAttribute("alAckDiscrepancyList"));
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
//	System.out.println("request.getQueryString()"+request.getQueryString());
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
			 group_code			=	CommonBean.checkForNull(request.getParameter("group_code"),"%");
			String doc_ref				=	CommonBean.checkForNull(request.getParameter("doc_ref"),"%");
			
			bean.setDoc_type_code(doc_type_code);
			bean.setFmStore_code(fm_store_code); 
			bean.setToStore(to_store_code);
			bean.setTrn_type(trn_type);
			bean.setAction_type(action_type);
			bean.setSession(session) ;//Added for TH-KW-CRF-0026
			bean.loadTFRDtlData(fm_doc_date,to_doc_date,doc_no,group_code,doc_ref);

			//System.out.println("getTFRDtlRecords"+bean.getTFRDtlRecords());
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
			System.out.println("size in validate"+size);
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
			System.out.println("alResult size"+alResult.size());
			System.out.println("alResult"+alResult);

			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				String ack_status = (String)htFormValues.get("acknowledge_atatus_"+i);
				System.out.println("ack_status"+ack_status);
				//if(!(ack_status.equals("P"))) {// Comented against BRU-HIMS-CRF-376				

				hmTemp.put("REMARKS",(String)htFormValues.get("remarks_"+i));
				
				hmTemp.put("ACKNOWLEDGE_STATUS",(String)htFormValues.get("acknowledge_atatus_"+i));
				hmTemp.put("REQ_DOC_NO",req_doc_no);
				alExpRecords.add(hmTemp);
				System.out.println("alExpRecords in validate"+alExpRecords);
				//}
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
			System.out.println("trn_type"+trn_type);
			bean.setTrn_type(trn_type);
			out.println("clearListItems('document.formAcknowledgeHeader.fm_store_code'); clearListItems('document.formAcknowledgeHeader.to_store_code');");
			
			ArrayList alStoreList = bean.getStoreArrayList();
			System.out.println("alStoreList"+alStoreList);
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.fm_store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); addListItem(\"document.formAcknowledgeHeader.to_store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\");");
				
				
			}
			out.println("clearListItems('document.formAcknowledgeHeader.doc_type_code'); ");
			ArrayList alDocTypeList = bean.getDocTypeArrayList();
			//System.out.println("alDocTypeList"+alDocTypeList);
			record	=	null;
			for(int i=0; i< alDocTypeList.size(); i++) {
				record	=	(HashMap)alDocTypeList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.doc_type_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}

		if(trn_type.equals("RTG")) {
			out.println("document.formAcknowledgeHeader.action_type.options.length=0 ;");
			out.println("addListItem(\"document.formAcknowledgeHeader.action_type\", \"" +"A"+ "\",\"" +"Acknowledge"+ "\",\"" +"A"+ "\") ; ");
			//Added by Sakti Return Confirm CRF TD-PMG2014-CRF-0008
			out.println("addListItem(\"document.formAcknowledgeHeader.action_type\", \"" +"C"+ "\",\"" +"Confirm"+ "\") ; ");
			//Added ends
out.println("parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.document.formAcknowledgeHeader.querySelector('#fm_store_img).style.visibility='hidden' ;");
out.println("parent.AcknowledgeHeaderframe.document.formAcknowledgeHeader.document.formAcknowledgeHeader.querySelector('#to_store_img).style.visibility='visible' ;");
		}else if(trn_type.equals("ISS")) {
			out.println("document.formAcknowledgeHeader.action_type.options.length=0 ;");
			out.println("addListItem(\"document.formAcknowledgeHeader.action_type\", \"" +"A"+ "\",\"" +"Acknowledge"+ "\",\"" +"A"+ "\") ; ");
			out.println("addListItem(\"document.formAcknowledgeHeader.action_type\", \"" +"C"+ "\",\"" +"Confirm"+ "\") ; ");

			}

		}else if(validate.equals("ACTIONTYPE")){
			result = true;
			flag = "";
			String action_type = request.getParameter("action_type");
			bean.setAction_type(action_type);
			out.println("clearListItems('document.formAcknowledgeHeader.fm_store_code'); clearListItems('document.formAcknowledgeHeader.to_store_code');");
			
			ArrayList alStoreList = bean.getStoreArrayList();
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formAcknowledgeHeader.fm_store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); addListItem(\"document.formAcknowledgeHeader.to_store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\");");
				
			}
		}else if(validate!= null && validate.equals("toolBar"))  {
	         String toolBarString = request.getQueryString() ;
			 session.removeValue("queryString") ;
			 session.putValue( "queryString", toolBarString ) ;
	  	}else if (validate.equals("ADD_TO_DISCREPANCY_LIST")){//Adding start for TH-KW-CRF-0026
			HashMap hmListItems	=	new HashMap();
			System.err.println("Inside ADD_TO_DISCREPANCY_LIST@@==");

			double dPackingCost	= bean.getItemUnitCost(item_code);

			if (dPackingCost<0){
				throw new Exception("NOT_A_CSSD_ITEM");
			}
			if (remarks.length()>200){
				throw new Exception("REMARKS_EXCEEDS_LIMIT");
			}
			if(index.equals("-1")){
			if(item_code.equals(ackDiscrepancyListBean.getItem_code()))
			{
					
				throw new Exception("RECORD_ALREADY_EXISTS");

			}
			}
			if (!ackDiscrepancyListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", discrepancy_qty )){
				throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
			}

			
		

			if(alAckDiscrepancyList.size()>0){
				int des_qty=0;
				for(int i=0;i<alAckDiscrepancyList.size();i++){
						
				if(((String)(((HashMap)alAckDiscrepancyList.get(i)).get("group_code"))).equals(group_code) && 
					((String)(((HashMap)alAckDiscrepancyList.get(i)).get("tray_no"))).equals(tray_no)   &&  
					((String)(((HashMap)alAckDiscrepancyList.get(i)).get("item_code"))).equals(item_code)){	
						des_qty=Integer.parseInt(discrepancy_qty)+des_qty+Integer.parseInt((String)(((HashMap)alAckDiscrepancyList.get(i)).get("discrepancy_qty")));

					}
			    }
				/*if (!ackDiscrepancyListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", ""+des_qty )){//Commented for ICN-38140
					throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
				}*/
			}

			if(ackDiscrepancyListBean.isItemAndDiscrepancyInArrayList(alAckDiscrepancyList,item_code,write_off_reason_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("group_code",			group_code				);
			hmListItems.put("tray_no",				tray_no					);
			hmListItems.put("item_code",			item_code				);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_cost",		""+(Long.parseLong(discrepancy_qty)*dPackingCost)		);
			hmListItems.put("remarks",				remarks					);

			if(index.equals("-1")){
				hmListItems.put("mode",ackDiscrepancyListBean.getCommonRepositoryValue("MODE_INSERT"));
				hmListItems.put("markedAsDelete",		"N"						);
				alAckDiscrepancyList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alAckDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
				hmListItems.put("markedAsDelete",((HashMap)alAckDiscrepancyList.get(Integer.parseInt(index))).get("markedAsDelete"));
				alAckDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			}
			System.err.println("alAckDiscrepancyList@@==="+alAckDiscrepancyList);
			result	=	true;
			message	=	"Done";
		}
		else if (validate.equals("PRESERVE_DISCREPANCY")){
			for(int i=0;i<alAckDiscrepancyList.size();i++){
				String stMarkedForDeletion=(String)htFormValues.get("checkbox"+i);
				if(stMarkedForDeletion==null) continue;
				HashMap hmListItems	=	(HashMap) alAckDiscrepancyList.get(i);
				hmListItems.put("markedAsDelete",stMarkedForDeletion);
			}
			result	=	true;
			message	=	"DonePRESERVE_DISCREPANCY";
		}else if(validate!= null && validate.equals("setGroup"))  {
	         ackDiscrepancyListBean.setGroup_code(group_code);
			 ackDiscrepancyListBean.setTray_no(tray_no);
	  	}//Adding end for TH-KW-CRF-0026
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
	putObjectInBean("SSAcknowledgementBean",bean,request);
	putObjectInBean("AckDiscrepancyListBean",ackDiscrepancyListBean,request);
%>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
