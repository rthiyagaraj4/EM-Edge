<%@page import=" eST.AdjustStockBean,eST.Common.StHeaderBean,eST.SalesBean,eST.SalesReturnBean,java.util.HashMap,java.util.ArrayList"  contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	
	String bean_id			=	 CommonBean.checkForNull(request.getParameter( "bean_id" ),"stHeaderBean") ;
	String bean_name		=	 CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.Common.StHeaderBean") ;
	// Added by Padmapriya
	String Inpatient_yn				=	"";
	String outpatient_yn			=	"";
	String referral_yn				=	"";
	String daycare_yn				=	"";
	String emergency_yn				=	"";
	String directsale_yn			=	"";
	HashMap hmrecord				=	null;
	HashMap dflt_sal_type			=	null;
	String user_id					=   "";  
	String str_code 				=   "";
	String dflt_sal_type_yn 		=   ""; 
	// End by Padmapriya
	
	//Added on 6/19/2005 by Sabari	
	StHeaderBean bean		=	null;
	AdjustStockBean adjStBean=	null;
	if(bean_id.equals("adjustStockBean")){
		adjStBean			=	(AdjustStockBean)getBeanObject( bean_id, bean_name,request);
		bean				=	(StHeaderBean) adjStBean.getStHeaderBean();
	}else
	{
		bean				=	(StHeaderBean)getBeanObject( bean_id, bean_name,request);
			
	}

//	StHeaderBean bean				= (StHeaderBean)getBeanObject( bean_id,bean_name,request);
	String doc_type_code			=	request.getParameter("doc_type_code");
	String validate					=	request.getParameter("validate");

	bean.setLanguageId(locale);
	//adjStBean.setLanguageId(locale);
	String doc_no					=	request.getParameter("doc_no");
	String store_code				=	request.getParameter("store_code");
	String doc_ref					=	request.getParameter("doc_ref");
	String doc_date					=	request.getParameter("doc_date");
	String request_on_store			=	request.getParameter("request_on_store");
	String request_by_store			=	request.getParameter("request_by_store");
	String  item_class_code			=  request.getParameter("item_class_code");

	String item_class_desc			=		request.getParameter("item_class_desc");

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");


	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	
	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println(bean.isDocNoAutoGenYN(doc_type_code));
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
			result	=	true;
		}
		else if(validate.equals("ITEM_CLASS")){
				
				if(item_class_desc.equals("---Select---"))
				{
					item_class_desc	=		"";
					item_class_code	=		"";
				}
			
				bean.setItem_class_desc(item_class_desc);
				bean.setItem_class_code(item_class_code);
				
			
		
		}
		else if(validate.equals("SET_DETAILS")){
			bean.setDoc_type_code	(doc_type_code	);
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
			bean.setDoc_ref			(doc_ref		);
			bean.setDoc_no			(doc_no			);
			bean.setStore_code		(store_code		);
			bean.setItem_class_code (item_class_code);
			int iValidDocDate = bean.isValidDocDate(doc_date);
			if (iValidDocDate > 0) {
				if (iValidDocDate== 1) 
					throw new Exception( "ST_DOC_DT_NOT_LT_PROC_MTH");
				else if (iValidDocDate== 2) 
					throw new Exception( "ST_DOC_DT_NOT_GR_SYSDATE");
			}
			result	=	true;
			message	=	validate+doc_type_code	+
						doc_date		+
						doc_ref		+
						doc_no		+	
						store_code + item_class_code;
		}
		else if(validate.equals("UPDATE_DETAILS")){
			//doc_date =bean.getDoc_date();
			if(!locale.equals("en"))
			{
				doc_date =bean.getDoc_date();
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
			}
				else
			{
					doc_date=bean.getDoc_date();
			}

			
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc()+"\", \""+bean.getDoc_no()+"\", \""+bean.getStore_desc()+"\", \""+doc_date+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\", \""+bean.getStore_code()+"\" , \""+bean.getItem_class_code()+"\");");
			result	=	true;
			message	=	validate+doc_type_code	+
						doc_date		+
						doc_ref		+
						doc_no		+	
						store_code + item_class_code;
						
						
		// Added by Padmapriya		
		
			
		
		if((bean.getfunction_id().equals("ST_SALES")) || (bean.getfunction_id().equals("ST_SALES_RETURN")))			
		{
			
		SalesBean sales_bean = (SalesBean)getBeanObject( "salesBean","eST.SalesBean" ,request) ;  	
		
		String list1	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		String list2	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		String list3	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
		String list4	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.DirectSales.label","st_labels");
		String list5 	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		String list6 	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");			
			
			str_code	=		bean.getStore_code();
			hmrecord	=		sales_bean.getSalesType(str_code);
			
			outpatient_yn		=		(String)hmrecord.get("OUTPATIENT_YN");
			Inpatient_yn		=		(String)hmrecord.get("INPATIENT_YN");
			referral_yn			=		(String)hmrecord.get("REFERRAL_YN");
			daycare_yn			=		(String)hmrecord.get("DAYCARE_YN");
			emergency_yn		=		(String)hmrecord.get("EMERGENCY_YN");
			directsale_yn		=		(String)hmrecord.get("DIRECTSALE_YN");
			
			user_id				= bean.getLoginById();
			dflt_sal_type		= sales_bean.getDfltSalesType(str_code,user_id);
			dflt_sal_type_yn	= (String)dflt_sal_type.get("DFLT_SAL_TRN_TYPE");
			
			//out.println("if(parent.frames[0].document.forms[0].patient_id.disabled == false){");
			//Added by Rabbani #Inc NO : 38346 on 28-MAR-2013
		     out.println("if(parent.frames[0].document.forms[0].patient_id != undefined && parent.frames[0].document.forms[0].patient_id.disabled == false){");
			out.println("clearListItems('document.forms[0].sal_trn_type'); ");
			if((Inpatient_yn.equals("Y")) )
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"I"+ "\",\"" +list2+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(daycare_yn.equals("Y"))
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"D"+ "\",\"" +list6+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(outpatient_yn.equals("Y"))
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"O"+ "\",\"" +list1+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(emergency_yn.equals("Y"))
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"E"+ "\",\"" +list5+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(referral_yn.equals("Y"))
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"R"+ "\",\"" +list3+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
			if(directsale_yn.equals("Y"))
				out.println("addListItem(\"document.forms[0].sal_trn_type\", \"" +"X"+ "\",\"" +list4+ "\" ,\"" +dflt_sal_type_yn+ "\"); ");
				
			out.println("}");
			}			
		}
		
	else if(validate.equals("RELOAD_ITEM_CLASSES")) {
			//String request_on_store = (String) hash.get("store_code");
			//String request_by_store = (String) hash.get("store_code");
			if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}

			out.println("clearListItems('formStGeneralHeaderForSingleStore.item_class_code'); ");
			ArrayList itemClasses = bean.getItemClasses(request_by_store, request_on_store);
			HashMap record = null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formStGeneralHeaderForSingleStore.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}			
		}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
 <%
if(bean_id.equals("adjustStockBean"))
  putObjectInBean(bean_id,adjStBean,request);
else
  putObjectInBean(bean_id,bean,request);
%>
