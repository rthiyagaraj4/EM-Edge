<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import=" eSS.*,eSS.Common.*,java.util.*"contentType="text/html;charset=UTF-8"%>    

<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	
	//DispatchListBean bean	=	(DispatchListBean)getBeanObject( "DispatchListBean",  "eSS.DispatchListBean",request ) ; 
	DispatchBean bean1	=	(DispatchBean)getBeanObject( "DispatchBean",  "eSS.DispatchBean",request ) ;
	Hashtable hash					= (Hashtable) XMLobj.parseXMLString(request);
	hash							= (Hashtable) hash.get ("SEARCH");
	
	String index				=	request.getParameter("index");
	//String dispatch_date		=	request.getParameter("dispatch_date");
	String validate				=	request.getParameter("validate");
	String message				=	"";
	String flag					=	"";
	boolean	result				=	false;
	
	
	try{
		
		 if (validate.equals("ADD_TO_LIST")){
			 
			 /*HashMap hmListItems	=	(HashMap)dispatchList.get(Integer.parseInt(index));

					hmListItems.put("DISPATCH_DATE",		dispatch_date);
					bean.setDispatch_date(dispatch_date);
					dispatchList.set(Integer.parseInt(index),hmListItems);
			result	=	true;
			message	=	"Done";*/
			//Added by Sakti against BRU-HIMS-CRF-371					
			 try{	
										
					String doc_no	=	request.getParameter("doc_no");
					String doc_type_code	=	request.getParameter("doc_type_code");
					
				 int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
					
					for(int i=0;i<total_rec;i++){
						String checked_yn = (String)hash.get("checkbox_tray"+i);
						
						if(checked_yn.equals("Y")){
						bean1.setalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i),(String)hash.get("dispatch_date_"+i));
						}
					}
					
										
					bean1.setnewalGroupRecords(doc_type_code+"-"+doc_no);
									
					result = true;
					flag="";
				}catch(Exception e){
						result		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
				}
		}else if(validate.equals("ASSIGN_VALUE")){
			bean1.updateSelectedValues(hash);
						
				result = true;
				flag="";
		
		}else if(validate.equals("REMOVE_KEY")){
						
			String doc_no	=	request.getParameter("doc_no");
			String doc_type_code	=	request.getParameter("doc_type_code");
			
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			
			for(int i=0;i<total_rec;i++){
				String checked_yn = (String)hash.get("checkbox_tray"+i);
				
				if(checked_yn.equals("N")){
				bean1.removenewalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i));
				}
			}
						
				result = true;
				flag="";
			
		}
		
	//putObjectInBean("DispatchListBean",  bean,request);
	putObjectInBean("DispatchBean",  bean1,request);


	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
