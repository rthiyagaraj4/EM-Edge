
 <%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	BlockedBatchesBean bean = (BlockedBatchesBean)getBeanObject("blockedBatchesBean","eST.BlockedBatchesBean",request ) ; 
 	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String trn_type				=	request.getParameter("trn_type");
	try {
		if (validate.equals("POPULATE_DOC_TYPE_CODE")){
			out.println("clearListItems('document.formBlockedBatchesQueryCriteria.doc_type_code'); ");

			String []stParameters={bean.getLoginFacilityId(),trn_type,trn_type,locale};
//Changed "SQL_ST_TRN_DOC_TYPE_SUMM_SELECT_LIST" to "SQL_ST_TRN_DOC_TYPE_BLOCK_LIST" to avoid Consumption defaulted to SAL
			ArrayList alDocType = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_BLOCK_LIST"),stParameters);
			HashMap hmRecords	= new HashMap();
			for(int i=0; i< alDocType.size(); i++) {
				hmRecords	=	(HashMap)alDocType.get(i);
				String code	=	(String)hmRecords.get("DOC_TYPE_CODE");
				String desc	=	(String)hmRecords.get("SHORT_DESC");
				out.println("addListItem(\"document.formBlockedBatchesQueryCriteria.doc_type_code\", \"" +code+ "\",\"" +desc+ "\"); ");
			}
		}
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
%>
<%
putObjectInBean("blockedBatchesBean",bean,request);
%>
