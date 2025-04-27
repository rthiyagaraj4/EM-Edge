<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page   import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%> 

<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 
<%
	
	ReceiptBean bean				=	(ReceiptBean)getBeanObject( "receiptBean","eSS.ReceiptBean", request  ) ;  
	Hashtable hash					= (Hashtable) XMLobj.parseXMLString(request);
	hash							= (Hashtable) hash.get ("SEARCH");
	
	String index					=	request.getParameter("index");
	String dispatch_date			=	request.getParameter("dispatch_date");
	String validate					=	request.getParameter("validate");
 	String records_to_modify 		=	request.getParameter("records_to_modify");
 	String doc_no					=	request.getParameter("doc_no");
 	String doc_type_code			=	request.getParameter("doc_type_code");
 	String facility_id				=	request.getParameter("facility_id");
	
	
	String message				=	"";
	String flag					=	"";
	boolean	result				=	false;
	String checked_yn			=	"";

	

	try{
		
		 if (validate.equals("ADD_TO_LIST")) {
			//comented by sakti against BRU-HIMS-CRF-372
			/* int i=0;
			
	for	(i	=0;	i<alDispatchRecords.size();i++){
			HashMap hmListItems	=	(HashMap)alDispatchRecords.get(i);
			System.out.println("hmListItems"+hmListItems.size());

					hmListItems.put("RECEIPT_DATE",		dispatch_date);
					//dispatchList.set(i,hmListItems);
					alDispatchRecords.set(i,hmListItems);
//				}
			result	=	true;
			message	=	"Done";
	}
	bean.setRecords_to_modify(records_to_modify);
	System.out.println("getRecords_to_modify"+bean.getRecords_to_modify());*/
	//Added by sakti against BRU-HIMS-CRF-372
			 try{	
					/*String do_no	=	request.getParameter("do_no");
					String tray_no	=	request.getParameter("tray_no");
					 dispatch_date =	request.getParameter("dispatch_date");
					 doc_type_code	=	request.getParameter("doc_type_code");
					String group_code	=	request.getParameter("group_code");*/
					
					int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
					//System.out.println("total_rec"+total_rec);
					for(int i=0;i<total_rec;i++){
						 checked_yn = (String)hash.get("checkbox_tray"+i);
						
						if(checked_yn.equals("Y")){
						bean.setalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i),(String)hash.get("receipt_date"+i));
						}
					}
					
										
					bean.setnewalGroupRecords(doc_type_code+"-"+doc_no);
														
					result = true;
					flag="Done";
				}catch(Exception e){
						result		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
				}
	
	
	
		}else if (validate.equals("REMOVE_KEY")) {
			
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			//System.out.println("total_rec"+total_rec);
			for(int i=0;i<total_rec;i++){
				 checked_yn = (String)hash.get("checkbox_tray"+i);
				//System.out.println("checked_yn"+checked_yn);
				if(checked_yn.equals("N")){
				bean.removenewalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i));
				}
			}
			
		
		}else if(validate.equals("ASSIGN_VALUE")){
			bean.updateSelectedValues(hash);
			
			result = true;
			flag="";
	
	}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		////System.err.println(alPackingDiscrepancyList);
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

putObjectInBean("receiptBean",bean,request);

%>
 
