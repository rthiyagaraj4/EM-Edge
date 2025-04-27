
 <%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
24/1/2019				IN063960				Shazana														AMRI-CRF-0346
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import=" eST.SalesAndSalesReturnHistoryBean,java.util.Hashtable,java.util.ArrayList, java.text.SimpleDateFormat"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	SalesAndSalesReturnHistoryBean bean = (SalesAndSalesReturnHistoryBean)getBeanObject( "SalesAndSalesReturnHistoryBean","eST.SalesAndSalesReturnHistoryBean", request ) ;  
	String validate		=	request.getParameter("validate");
	String trn_type	=	request.getParameter("trn_type");
	System.out.println("trn_type--->" + trn_type);
	String start_date = request.getParameter("start_date");
	System.out.println("start_date--->" + start_date);
	String end_date = request.getParameter("end_date");
	System.out.println("end_date--->" + end_date);
	if(end_date==null || end_date.equalsIgnoreCase("")){
		System.out.println("end date is null");  
	}

	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	String patient_id				=	request.getParameter("patient_id");
	System.out.println("patient_id--->" + patient_id);


	
	boolean	result					=	false;
	try {
		 if (validate.equals("PATIENT_NAME")){


			if (patient_id.trim().equals("")) {
				out.println("setPatientName('','');");
				result			=	true;
				return ;
			}
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\",\""+bean.getPatientNationality(patient_id)+"\")");
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
				out.println("setPatientName('','');");
			}
		}
		
		
		if (validate.equals("POPULATE_RETURN_DOC_TYPE_CODE")){
	
			out.println("clearListItems('document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type'); ");//modified againest IN0069649
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());

			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}

		if (validate.equals("POPULATE_SALES_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());
			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		if (validate.equals("POPULATE_BOTH_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			


			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST8"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnHistoryReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		if (validate.equals("CHECK_DOC_DATE")){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        	Date fdate=format.parse(start_date); 
   			 	Date tdate=format.parse(end_date);
      			long diffInDays =  tdate.getTime() - fdate.getTime();
				long differenceInDays =  (diffInDays / (24 * 60 * 60 * 1000));
      			System.out.println("differenceInDays---->" + differenceInDays);
				if(differenceInDays >90)
					result= false;
				else
				result=true;
      			}

	}

	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
%>
<%
//putObjectInBean("SalesAndHistoryBean",bean,request);
%>
