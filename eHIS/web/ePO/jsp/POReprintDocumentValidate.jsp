<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,ePO.*,ePO.Common.*,java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
     
    PORePrintDocReportBean bean = (PORePrintDocReportBean)getBeanObject( "PORePrintDocReportBean",  "ePO.PORePrintDocReportBean",request ) ;
    bean.setLanguageId(locale);
	
	String validate		=	request.getParameter("validate");
	String trn_type	=	request.getParameter("trn_type");
	
	try {
		if (validate.equals("POPULATE_DOC_TYPE_CODE")){
            ArrayList arr_language = new ArrayList();
		    arr_language.add(trn_type);
		    arr_language.add(bean.getLanguageId());
			out.println("clearListItems('document.ReprintDocumentCriteria.doc_type_code'); ");
			ArrayList alList = bean.fetchRecords(PoRepository.getPoKeyValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language);  
			for(int i=0; i< alList.size(); i++) {
				HashMap record	=	(HashMap)alList.get(i);
				String listRecord	=	(String)record.get("MASTER_CODE");
				//String desc	=	(String)record.get("LONG_DESC");
				String desc	=	(String)record.get("SHORT_DESC");// as per query SHORT_DESC getting added against inc#44626
				out.println("addListItem12(\"document.ReprintDocumentCriteria.doc_type_code\", \"" +listRecord+ "\",\"" +desc+ "\") ; ");
			}
		}
		else if(validate.equals("POPULATE_PUR_UNIT_CODE")){
			ArrayList alList1 = new ArrayList();
			ArrayList sqlParam = new ArrayList();		
			sqlParam.add(bean.getLoginById());
			sqlParam.add(bean.getLoginFacilityId());
			out.println("clearListItems('document.ReprintDocumentCriteria.pur_unit'); ");
			if(trn_type.equals("POREQN")){
				 alList1 = bean.fetchRecords(PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_REQ"),sqlParam);  
			}else if(trn_type.equals("PORDER")){
				 alList1 = bean.fetchRecords(PoRepository.getPoKeyValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam);  
			}
			for(int j=0; j< alList1.size(); j++) {
				HashMap record1	=	(HashMap)alList1.get(j);
				String listRecord1	=	(String)record1.get("CODE");
				String desc1	=	(String)record1.get("DESCRIPTION");
				out.println("addListItem12(\"document.ReprintDocumentCriteria.pur_unit\", \"" +listRecord1+ "\",\"" +desc1+ "\") ; ");
			}		
		}		
		
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
	finally{
	}
%>
<%
putObjectInBean("PORePrintDocReportBean",bean,request);
%>
