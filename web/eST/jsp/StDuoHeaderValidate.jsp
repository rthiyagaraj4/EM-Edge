
<%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	StDuoHeaderBean bean			=		(StDuoHeaderBean)getBeanObject( "stDuoHeaderBean","eST.Common.StDuoHeaderBean",request ) ;  
	String doc_type_code			=		request.getParameter("doc_type_code");
	String validate					=		request.getParameter("validate");
	String doc_no					=		request.getParameter("doc_no");
	String from_store_code			=		request.getParameter("from_store_code");
	String to_store_code			=		request.getParameter("to_store_code");
	String item_class_code			=		request.getParameter("item_class_code");
	String item_class_desc			=		request.getParameter("item_class_desc");
	String doc_ref					=		request.getParameter("doc_ref");
	String doc_date					=		request.getParameter("doc_date");
	String finalize_yn				=		request.getParameter("finalize_yn");
	String autono_yn				=		request.getParameter("autono_yn");
	//String issue_flag				=		request.getParameter("issue_flag");
	//String mode					=		request.getParameter("mode");
	String message					=		"";
	String flag						=		"";
	boolean	result					=		false;
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	
	bean.setLanguageId(locale);
	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println(bean.isDocNoAutoGenYN(doc_type_code));
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
			result					=			true;
		}
		else if(validate.equals("ITEM_CLASS")){
				
				if(item_class_desc.equals("---Select---"))
				{
					item_class_desc	=		"";
				}
			
				bean.setItem_class_desc(item_class_desc);
				bean.setItem_class_code(item_class_code);
			
		
		}
		else if(validate.equals("SET_DETAILS")){

			bean.setDoc_type_code(doc_type_code		);
			if(!locale.equals("en"))
			{
			doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");	
			//bean.setDoc_date(com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale));
			}else
			{
			doc_date=doc_date;
			bean.setDoc_date(doc_date);
			}  
			
			bean.setDoc_date(doc_date);
			bean.setDoc_ref(doc_ref);
			bean.setDoc_no(doc_no	);
//			if(!(bean instanceof eST.RequisitionIssueBean)) {
				bean.setFrom_store_code(from_store_code);
				bean.setTo_store_code(to_store_code);
				bean.setItem_class_code(item_class_code);
//			}
			if (from_store_code.equals(to_store_code)) {
				throw new Exception( "BOTH_STORE_CANNOT_BE_SAME");
			}

			bean.setItem_class_code(item_class_code);
			bean.setAutono_yn(autono_yn);
			bean.setFinalize_yn(finalize_yn);
			int iValidDocDate = bean.isValidDocDate(doc_date);
			if (iValidDocDate > 0) {
				if (iValidDocDate== 1) 
					throw new Exception( "ST_DOC_DT_NOT_LT_PROC_MTH");
				else if (iValidDocDate== 2) 
					throw new Exception( "ST_DOC_DT_NOT_GR_SYSDATE");
			}
			result=	true;
			message=	validate+doc_type_code	+
						doc_date + doc_ref +
						doc_no + to_store_code +
						item_class_code + from_store_code;
		}
		else if(validate.equals("UPDATE_DETAILS")){
			String function_id		 =		(String) hash.get("function_id");
			bean.setFunctionId(function_id);

				if(!locale.equals("en"))
			{
				doc_date =bean.getDoc_date();
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
			}
				else
			{
					doc_date=bean.getDoc_date();
			}
			
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc()+"\", \""+bean.getDoc_no()+"\", \""+bean.getFrom_store_desc()+"\",\""+bean.getTo_store_desc()+"\", \""+bean.checkForNull(bean.getItem_class_Desc())+"\",\""+doc_date+"\", \""+bean.getDoc_ref()+"\", \""+bean.getTo_store_code()+"\", \""+bean.getFrom_store_code()+"\",\""+bean.getItem_class_code()+"\",\""+bean.getFinalize_yn()+"\",\""+bean.getAutono_yn()+"\",\""+bean.getItem_class_code()+"\",\""+bean.getDoc_type_code()+"\");"); 
			result=	true;
			message=	"";
		}
		// Changed on Aug13 to reload the item classes
		else if(validate.equals("RELOAD_ITEM_CLASSES")) {
			String request_on_store		 =		(String) hash.get("from_store_code");
			String request_by_store		 =		(String) hash.get("to_store_code");

			
			//bean.setFrom_store_code(request_by_store);
			//bean.setTo_store_code(request_on_store);
		

			if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
		
			out.println("clearListItems('formStGeneralHeaderForMultiStore.item_class_code'); ");
			ArrayList itemClasses		= new ArrayList();
			if((bean.getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE")||(bean.getFunctionId().equals("ST_ISSUE_REQ_URG"))||(bean.getFunctionId().equals("ST_STOCK_TRANSFER"))))
			itemClasses		=		 bean.getItemClasses(request_on_store, request_by_store);
			else
			itemClasses		=		 bean.getItemClasses(request_by_store, request_on_store);
			HashMap record =  null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				
				out.println("addListItem(\"formStGeneralHeaderForMultiStore.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}			
		}
		else if(validate.equals("LOAD_PARENT_STORE_ISSUE")) {

			from_store_code				=		(String) hash.get("from_store_code");
				//bean.setFrom_store_code(from_store_code);
				
				//To populate the requisition_on_stores
					out.println("clearListItems('formStGeneralHeaderForMultiStore.to_store_code'); ");
					ArrayList req_by_stores = bean.getOnIssueStores(from_store_code);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formStGeneralHeaderForMultiStore.to_store_code\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
			
		}
		else if(validate.equals("SET_TO_STORE_CODE")) {

			to_store_code				=		(String) hash.get("to_store_code");
				//bean.setTo_store_code(to_store_code);
				
				
			
		}
		else if(validate.equals("LOAD_PARENT_STORE")) {
			
			from_store_code				=		(String) hash.get("from_store_code");
			
		
			if (from_store_code != null && from_store_code.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			java.util.HashMap resultMap =		bean.canAuthorize(from_store_code);
			if (resultMap != null) {
				String authorize		=		(String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				String parent_store		=		(String)resultMap.get("PARENT_STORE_CODE");
				parent_store			=		bean.checkForNull(parent_store,"");
				
				//bean.setFrom_store_code(from_store_code);

				//To populate the requisition_on_stores
					out.println("clearListItems('formStGeneralHeaderForMultiStore.to_store_code'); ");
					ArrayList req_by_stores = bean.getOnStores(from_store_code);
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formStGeneralHeaderForMultiStore.to_store_code\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");

						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
			}
		}
	}
	catch (Exception exception){
		result=	false;
		message=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\") ; ") ;
	}
%>
<%
putObjectInBean("stDuoHeaderBean",bean,request);
%>
