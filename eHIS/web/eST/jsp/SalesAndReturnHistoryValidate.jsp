
<%@page contentType="text/html;charset=UTF-8" import=" eST.SalesAndReturnHistoryBean,java.util.Hashtable,java.util.ArrayList,java.text.SimpleDateFormat"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	SalesAndReturnHistoryBean bean = (SalesAndReturnHistoryBean)getBeanObject( "SalesAndReturnHistoryBean","eST.SalesAndReturnHistoryBean", request ) ;  
	String validate		=	request.getParameter("validate");
	String trn_type	=	request.getParameter("trn_type");


	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	String patient_id				=	request.getParameter("patient_id");

	
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

			out.println("clearListItems('document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());

			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}

		if (validate.equals("POPULATE_SALES_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());
			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		if (validate.equals("POPULATE_BOTH_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			


			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST8"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndReturnHistoryQueryCriteria.sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		//Added for AMS-CRF-0258 - Start
		if (validate.equals("CHECK_SYS_DATE")){
			
			String from_date = request.getParameter("from_date");
			System.out.println("from_date--->" + from_date);
			String to_date = request.getParameter("to_date");
			System.out.println("to_date--->" + to_date);

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        	Date fdate=format.parse(from_date); 
		 	Date tdate=format.parse(to_date);
  			long diffInDays =  tdate.getTime() - fdate.getTime();
			long differenceInDays =  (diffInDays / (24 * 60 * 60 * 1000));
			if(differenceInDays >365)
				result= false;
			else
		    	result=true;
  			}
		//Added for AMS-CRF-0258 - Start
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
