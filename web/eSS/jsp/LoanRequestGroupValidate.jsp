<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import=" eSS.*,eSS.Common.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%> 

<jsp:useBean id="alLoanRequestGroupList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	LoanRequestGroupListBean bean		=		(LoanRequestGroupListBean)getBeanObject( "LoanRequestGroupListBean", "eSS.LoanRequestGroupListBean", request ) ;
	LoanRequestGroupBean bean1			=		(LoanRequestGroupBean)getBeanObject( "LoanRequestGroupBean", "eSS.LoanRequestGroupBean", request ) ;
	Hashtable hash					= 		(Hashtable) XMLobj.parseXMLString(request);
	hash							= 		(Hashtable) hash.get ("SEARCH");

	String doc_type_code			=		request.getParameter("doc_type_code");
	String validate					=		request.getParameter("validate");
	
	String group_type				=		request.getParameter("group_type");
	String req_group_code			=		request.getParameter("req_group_code");
	String auth_group_code			=		request.getParameter("auth_group_code");
	String auth_group_desc			=		request.getParameter("auth_group_desc");
	String issue_store_code			=		request.getParameter("issue_store_code");
	String request_qty				=		request.getParameter("request_qty"); 
	String description				=		request.getParameter("description"); ;
	String index					=		request.getParameter("index");
	String surg_description			=		request.getParameter("surg_description"); 
	String ot_surg_description		=		request.getParameter("surg_name");
	String search_type				= 		request.getParameter("search_type");

	String message					=		"";
	String flag						=		"";
	boolean	result					=		false;
	
	try{
		if (validate.equals("DOC_TYPE_CODE")){
				out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		else if (validate.equals("CLEAR_LIST")){
			alLoanRequestGroupList.clear();
		}
		else if (validate.equals("GROUP_DESC")){
			try{
				out.println("setGroupDetails(\""+req_group_code.toUpperCase()+"\",\""+bean.getGroupDescription(req_group_code.toUpperCase())+"\");");
				result			=		true;
				message			=		"Done";
			}
			catch(Exception exception){
				flag			=	"INVALID_GROUP_CODE";
				result			=	false;
			}
		}
		else if (validate.equals("POPULATE_AUTH_GROUP_CODE")){
			ArrayList alRecords	=	null;
			ArrayList alParameters	=	new ArrayList(2);
			alParameters.add(req_group_code);
			alParameters.add(req_group_code);
			alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_LIST"),alParameters);
			out.println(  "clearListItems(\"parent.frameLoanRequestGroupDetail.document.formLoanRequestGroupDetail.auth_group_code\");"  );
			if(alRecords==null) return;
			for (int i=0;i<alRecords.size();i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"parent.frameLoanRequestGroupDetail.document.formLoanRequestGroupDetail.auth_group_code\",\""+hmRecord.get("GROUP_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+req_group_code+"\");"  );
			}
		}
		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();
			String stSterilizedQty="";
			if(!issue_store_code.equals("")){
				try{
					String stParameters[]={issue_store_code,auth_group_code};
					HashMap hmResult=bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_SELECT_QTY"),stParameters);
					//Commented by Rabbani #INC no:32068 on 07/12/2012
					/*stSterilizedQty=(String)hmResult.get("STERILIZED_QTY");
					if( Integer.parseInt(hmResult.get("STERILIZED_QTY").toString())<Integer.parseInt(request_qty) ){
						out.println("quantityAlert("+hmResult.get("QTY_ON_HAND").toString()+", "+hmResult.get("STERILIZED_QTY").toString()+","+hmResult.get("UNSTERILIZED_QTY").toString()+");");
					} */ 
					
					//Added by Rabbani #INC no:32068 on 07/12/2012
					stSterilizedQty=(String)hmResult.get("STERILIZED_BLOCKED_QTY");
					if( Integer.parseInt(hmResult.get("STERILIZED_BLOCKED_QTY").toString())<Integer.parseInt(request_qty) ){
						out.println("quantityAlert("+hmResult.get("QTY_ON_HAND").toString()+", "+hmResult.get("STERILIZED_BLOCKED_QTY").toString()+","+hmResult.get("UNSTERILIZED_QTY").toString()+");");
					}
					 
				}
				catch(Exception exception){
					out.println("quantityAlert(0, 0, 0);");
				}
			}

			if(bean.isGroupInArrayList(alLoanRequestGroupList,req_group_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			if(stSterilizedQty==null)stSterilizedQty="0";
			hmListItems.put("group_type",		group_type		);
			hmListItems.put("req_group_code",	req_group_code	);
			hmListItems.put("auth_group_code",	auth_group_code	);
			hmListItems.put("auth_group_desc",	auth_group_desc	);
			hmListItems.put("request_qty",		request_qty		);
			hmListItems.put("available_qty",	stSterilizedQty);
			hmListItems.put("description",		description		);
			//Added By Sakti against KDAH-CRF-0247 
			hmListItems.put("surg_description",		surg_description		); 
			hmListItems.put("ot_surg_description",			ot_surg_description		);
			//Added ends
			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alLoanRequestGroupList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alLoanRequestGroupList.get(Integer.parseInt(index))).get("mode"));
				alLoanRequestGroupList.set(Integer.parseInt(index),hmListItems);
			}

			result	=	true;
			message	=	"Done";
		}
	    else if (validate.equals("CHECK_REQ_STORE")){  //Added by Rabbani for validate Request_by_Store on 17/12/2012
			try{
			         result			=	true;
		   	         String req_by_store			=		request.getParameter("req_by_store");
				     String param[]={req_by_store,req_group_code};
					 HashMap ht=bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_STORE_CHECK"),param);
			         String total = "0";
				     total = bean.checkForNull((String)ht.get("COUNT"));
					 //System.out.println("total" +total);
				 if(total.equals("0")){
				 flag			=	"INVALID_GROUP_FOR_REQ_BY_STORE";
				 result			=	false;
				 }
			}
			catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_GROUP_FOR_REQ_BY_STORE";
				result			=	false;
			}
		}else if (validate.equals("ADD_GROUPS_TO_LIST")){//Added by Sakti against BRU-HIMS-CRF-373
			try{
				bean1.selectedBatches(hash);
				//This is added by Sakti  if in group search window any one group is selected among all pages, need to add that group in list. If not, then below message shown
				ArrayList checkedrecord =  bean1.getAlSelectedTrayDetails();
				if(search_type.equals("search")){
					if(checkedrecord.size()<1){
						result			=	false;
					}else{
						result = true;
					}
				}//Added ends
			}catch(Exception exception){
				exception.printStackTrace();
				flag			=	"INVALID_GROUP_SELECTION";
				result			=	false;
			}
				
		}else if (validate.equals("DTL_DATA_STORE")){
			ArrayList	alRecords	=	new ArrayList();
			HashMap	hmDtlRecord	=	new HashMap();
			int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));
	       
			for(int i=0;i<total_rec;i++){
				hmDtlRecord.put("GROUP_CODE",(String)hash.get("group"+i));
				hmDtlRecord.put("GROUP_DESC",(String)hash.get("desc"+i));
				hmDtlRecord.put("GROUP_TYPE",(String)hash.get("group_type"+i));
				hmDtlRecord.put("AUTH_GROUP_CODE",(String)hash.get("auth_group_"+i));
				hmDtlRecord.put("QTY",(String)hash.get("req_qty_"+i));
				hmDtlRecord.put("AVLBL_STER_QTY",(String)hash.get("avl_ster_qty"+i));
				hmDtlRecord.put("SURGERY_TYPE",(String)hash.get("surgery_type"+i));
				hmDtlRecord.put("SURGERY_NAME",(String)hash.get("surgery_name"+i));
				hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));
				
				bean1.setnewalGroupRecords((String)hash.get("group"+i));

				alRecords.add(hmDtlRecord);
				hmDtlRecord = new HashMap();
				
				bean1.setAlSelectedTrayDetails((String)hash.get("group"+i));
			}

			bean1.setSelectedList(alRecords);
		}else if (validate.equals("DTL_FINAL_DATA_STORE")){
			ArrayList	alRecords	=	new ArrayList();
			HashMap	hmDtlRecord	=	new HashMap();
			//String auth_group_code	= "";
			String auth_group	= "";
			int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));
			
			for(int i=0;i<total_rec;i++){
				auth_group = (String)hash.get("auth_group_"+i);
				hmDtlRecord.put("req_group_code",(String)hash.get("group"+i));
				hmDtlRecord.put("auth_group_code",auth_group);
				hmDtlRecord.put("request_qty",		 (String)hash.get("req_qty_"+i));
				hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));
				
				alRecords.add(hmDtlRecord);
				hmDtlRecord = new HashMap();
			}

			bean1.setDataList(alRecords);
		}else if (validate.equals("CLEAR_DATA")){
			ArrayList checkedrecord =  bean1.getAlSelectedTrayDetails();
			checkedrecord.clear();
		}else if (validate.equals("CHECK_STER_QTY")){
			String group_code = request.getParameter("group_code");
			String req_by_store_code = request.getParameter("req_by_store_code");
			String req_on_store_code = request.getParameter("req_on_store_code");
			 	   index	  = request.getParameter("index");
			String language_id = request.getParameter("language_id");
			//String []parameters = {language_id,req_on_store_code,group_code,group_code,req_by_store_code,group_code,language_id};
			String []parameters = {language_id,group_code,group_code,req_by_store_code,group_code,language_id};
			
			HashMap allMapvalue =(HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_STERILIZED_QTY_SELECT_FOR_LOAN"),parameters);
			String ster_qty = (String)allMapvalue.get("STERILIZED_BLOCKED_QTY");	
			String surg_desc = (String)allMapvalue.get("SHORT_DESC");
			String ot_surg_desc = (String)allMapvalue.get("OT_SURG_DESC");
			out.println("setSterQuantity('"+bean.checkForNull(surg_desc,"&nbsp;")+"','"+bean.checkForNull(ot_surg_desc,"&nbsp;")+"','"+bean.checkForNull(ster_qty,"0")+"','"+index+"');");
		}//Added ends
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	putObjectInBean("LoanRequestGroupListBean",bean,request);
	

%>
