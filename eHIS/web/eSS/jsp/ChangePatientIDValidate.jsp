<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	
	ChangePatientIDBean bean		=		(ChangePatientIDBean)getBeanObject( "changePatientIDBean", "eSS.ChangePatientIDBean",request ) ;

	String owner_store_code			=		request.getParameter("owner_store_code");
	String validate					=		request.getParameter("validate");
	String patient_id				=		request.getParameter("patient_id");
	String message					=		"";
	String flag						=		"";
	boolean	result					=		true;

	try{
		if (validate.equals("POPULATE_BIN_LOCATION")){
			ArrayList alParameters	=	new ArrayList();
			alParameters.add(owner_store_code);
			alParameters.add(bean.getLanguageId());
			ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alParameters);
			for (int i=0;i<alRecords.size();i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"document.formChangePatientIDTrayQueryCriteria.bin_location_code\",\""+hmRecord.get("BIN_LOCATION_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
			}
		}
		else if (validate.equals("PATIENT_NAME")){
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
				//Added by Sakti sankar against //Bru-HIMS-CRF-360 inc#39364
				if(bean.getPatientName(patient_id).equals("") || bean.getPatientName(patient_id)== null ) {
					result = false;
					flag			=	"INVALID_PATIENT";
				}
				//Added ends
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			
			}
		}		
	    putObjectInBean("changePatientIDBean",bean,request);
	}
	catch (Exception exception){
		exception.printStackTrace();
	}
%>
