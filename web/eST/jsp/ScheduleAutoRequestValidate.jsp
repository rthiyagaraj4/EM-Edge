<%@	page import="java.util.Hashtable,java.util.ArrayList,eST.ScheduleAutoRequestBean" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");

	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		request.getParameter("bean_id");
	String bean_name						=		request.getParameter("bean_name");
	boolean result							=		false  ;
	String  message							=		"" ; 
	String  flag							=		"" ; 

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ScheduleAutoRequestBean bean				=		(ScheduleAutoRequestBean) getBeanObject(bean_id, bean_name,request  );
	bean.setLanguageId(locale);
	String functionType						=	bean.checkForNull(request.getParameter("function_type"),"");
	Hashtable hash							=		(Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	if(functionType.equals("POPULATEITEMCLASSES"))
		{
			String request_by_store = (String) hash.get("requisition_by_store");
			String request_on_store = (String) hash.get("requisition_on_store");

			out.println("clearListItems('schduleAutoRequestForm.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			HashMap record = new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"schduleAutoRequestForm.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}else if(functionType.equals("CHECHFORDUPLICATESCHDULECODE")){
			try
			{
					flag = "";
					String count="";
					ArrayList alparam=new ArrayList();
					String schdule_code = 	  (String)request.getParameter("schdule_code")==null?"":(String)request.getParameter("schdule_code");
					alparam.add(bean.getLoginFacilityId().trim());
					alparam.add(schdule_code.trim().toUpperCase());
					count=(String)bean.fetchRecord("select COUNT(*) COUNT from ST_AUTO_REQ_rule_HDR where FACILITY_ID=? and  SCH_CODE=?",alparam).get("COUNT");
					if(count.equals("0")){
						result = true;
					}else{
						result = false;
					}
				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("SELECTALL"))	{
			try
			{
	String code= (String)request.getParameter("code")==null?"":(String)request.getParameter("code");
	String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
	int count=0;
	ArrayList		autoSheduleRequestRecordDetails = bean.getApplicableSchduleItems();
	String	temp_auto_type="";

	ArrayList associated_sel=bean.getAssociated_sel();

if(!code.equals("")){
	while((associated_sel != null) && (count < associated_sel.size())){
			temp_auto_type = (String)associated_sel.get(count);
			if(code.equals(temp_auto_type)){
				if(selected_yn.equals("Y")){
					 associated_sel.set(count+2,"Y");
									}else{
					 associated_sel.set(count+2, "N");
				}
					}
			count+=4;

		}

}else{
		int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
		count= from *4;
		to = to *4;

	String tempc="";
		if(to > autoSheduleRequestRecordDetails.size())
			to = autoSheduleRequestRecordDetails.size();
		while((autoSheduleRequestRecordDetails != null) && (count <=to)){
			tempc=(String)autoSheduleRequestRecordDetails.get(count);
			int jj=associated_sel.indexOf(tempc);
			if(selected_yn.equals("Y")){
			associated_sel.set(jj+2, "Y");
			}else{
			associated_sel.set(jj+2, "N");
			}
	
			count+=4;
		}
		}
		}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("CHECHFORATLEASTONERECORD")){
			try
			{
				flag = "";
				int count=0;
				ArrayList beanvalues	= bean.getAssociated_sel();
        		 if(beanvalues.size()!=0)	{
				for(int i=0; i<beanvalues.size(); i=i+4)		{
				String	rec	=	(String)beanvalues.get(i+2);
				if(rec.equals("Y") )  {
				count=count+1;
				}
				}
				}
				if(count==0){
						result = false;
					}else{
						result = true;
					}
				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("POPULATEREQUESTONSTORE")){
			String request_by_store = (String) hash.get("requisition_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			HashMap resultMap = bean.canAuthorize(request_by_store);
			
				String parent_store = (String)resultMap.get("PARENT_STORE_CODE");
				parent_store = bean.checkForNull(parent_store,"");
				
				bean.setRequisition_by_store(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('schduleAutoRequestForm.requisition_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequisition_by_store());
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"schduleAutoRequestForm.requisition_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
		//To populate the item classes 
				if (request_by_store != null && request_by_store.trim() != "") {
					out.println("clearListItems('schduleAutoRequestForm.item_class_code'); ");
					ArrayList itemClasses = bean.getItemClasses(request_by_store,parent_store);
					for(int i=0; i< itemClasses.size(); i++) {
						record = (HashMap)itemClasses.get(i);
						out.println("addListItem(\"schduleAutoRequestForm.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}
				}
			}
		

putObjectInBean(bean_id,bean,request);
%>
