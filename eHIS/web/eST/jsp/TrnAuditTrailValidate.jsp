
<%@ page import=" eST.TrnAuditTrailBean" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%	
	String locale			= (String)session.getAttribute("LOCALE");
	TrnAuditTrailBean bean = (TrnAuditTrailBean)getBeanObject("trnAuditTrailBean","eST.TrnAuditTrailBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	try {
		   if(validate.equals("TRNTYPE")){
			result = true;
			flag = "";
			String trn_type = request.getParameter("trn_type");
			bean.setTrn_type(trn_type);
			out.println("clearListItems('document.formTrnAuditTrail.doc_type_code'); ");
			ArrayList alDocTypeList = bean.getDocTypeArrayList();
			HashMap record	=	null;
	
			for(int i=0; i< alDocTypeList.size(); i++) {
				record	=	(HashMap)alDocTypeList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formTrnAuditTrail.doc_type_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}
		}else  if(validate.equals("TTORDER")){
			
			String TTorder = request.getParameter("TTorder");
			String header = request.getParameter("header");
			bean.getDeletedDocs(TTorder,header);
		/*	ArrayList deletedDocs = bean.getDeletedDocDetails();
			ArrayList trn_typedesc = new ArrayList();
			ArrayList trn_typedesc_dummy = new ArrayList();
			for(int i=0;i<deletedDocs.size();i++){
			HashMap hh=(HashMap)deletedDocs.get(i);
			if(!trn_typedesc.contains((String)hh.get(header)))
			trn_typedesc.add((String)hh.get(header));
			trn_typedesc_dummy.add((String)hh.get(header));
			}

			if(header.equals("DOC_NO")){
			trn_typedesc=new ArrayList();
			for(int u=0;u<trn_typedesc_dummy.size();u++){
			trn_typedesc.add(new Integer(Integer.parseInt((String)trn_typedesc_dummy.get(u))));

				}
			}

			Collections.sort(trn_typedesc);

			ArrayList sorted = new ArrayList();
			if(TTorder.equals("DESC") || TTorder.equals("")){
			for(int i=0;i<trn_typedesc.size();i++){
			for(int j=0;j<deletedDocs.size();j++){
			HashMap hh=(HashMap)deletedDocs.get(j);
			String trn_desc=(String)hh.get(header);
			String trn_desc1=(String)trn_typedesc.get(i);
			if(trn_desc.equals(trn_desc1))
			sorted.add(hh);
			}
			}
			}else{
			for(int i=trn_typedesc.size()-1;i>=0;i--){
			for(int j=0;j<deletedDocs.size();j++){
			HashMap hh=(HashMap)deletedDocs.get(j);
			String trn_desc=(String)hh.get(header);
			String trn_desc1=(String)trn_typedesc.get(i);
			if(trn_desc.equals(trn_desc1))
			sorted.add(hh);
			}
			}
			}
			bean.clear();

			bean.setDeletedDocDetails(sorted);*/
		}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
		flag=validate;
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}
%>
<%
	putObjectInBean("trnAuditTrailBean",bean,request);
%>
