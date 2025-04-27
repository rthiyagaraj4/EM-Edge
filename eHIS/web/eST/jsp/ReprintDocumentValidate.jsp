
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


	StockLevelReportBean bean = (StockLevelReportBean)getBeanObject( "stockLevelReportBean",  "eST.StockLevelReportBean",request ) ; 
bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String trn_type	=	request.getParameter("trn_type");
	HashMap hmReportId	=	new HashMap();
	hmReportId.put("GRN","STREP1");	
	hmReportId.put("TRN","STREP1");	
	hmReportId.put("MRN","STREP1");	
	hmReportId.put("ISS","STREP1");	
	hmReportId.put("URG","STREP1");	
	hmReportId.put("REQPIC","STBPKSLP");
	try {
		if (validate.equals("POPULATE_DOC_TYPE_CODE")){

			String site_id = bean.getCustomerID();

			out.println("clearListItems('document.ReprintDocumentCriteria.doc_type_code'); ");
			if (trn_type.equals("CON")) {
				//trn_type="SAL";
			}
			else if(trn_type.equals("REQPIC")) {
				trn_type = "ISS";
			}
//			String []stParameters={bean.getLoginFacilityId(),bean.getLanguageId(),trn_type,trn_type};
			ArrayList stParameters= new ArrayList();
			stParameters.add(bean.getLoginFacilityId());
			stParameters.add(bean.getLanguageId());
			stParameters.add(trn_type);
			stParameters.add(trn_type);
System.out.println("stParameters"+stParameters+"=========getCustomerID"+bean.getCustomerID());
			
			ArrayList alEncounterList = new ArrayList();

			if(site_id.equals("KDAH"))
			{
				alEncounterList = bean.fetchRecords("SELECT	a.doc_type_code, b.short_desc FROM st_trn_doc_type a, sy_doc_type_master_lang_vw b WHERE a.facility_id=? AND b.language_id = ? AND a.doc_type_code = b.doc_type_code AND a.trn_type = DECODE(?,'REQ','ISS',?) AND b.status is NULL ORDER BY	2,1",stParameters);	
			}
			else
			{
				alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SUMM_SELECT_LIST"),stParameters);
			}

		
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
				out.println("addListItem12(\"document.ReprintDocumentCriteria.doc_type_code\", \"" +listRecord+ "\",\"" +desc+ "\") ; ");
			}
			out.println("document.ReprintDocumentCriteria.p_report_id.value=\""+hmReportId.get(trn_type)+"\"");

		}
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
	finally{
	}
%>
<%
putObjectInBean("stockLevelReportBean",bean,request);
%>
