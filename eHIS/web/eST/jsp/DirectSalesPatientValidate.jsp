<%@page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
    DirectSalesPatientBean bean = (DirectSalesPatientBean)getBeanObject( "directSalesPatient", "eST.DirectSalesPatientBean" , request) ;  
	bean.setLanguageId(locale);
    String mode =	"";

	String patient_id	    =	request.getParameter("patient_id");
	//String eff_status       =   request.getParameter("eff_status");
    mode                   =   request.getParameter("mode");
	String validate			=	request.getParameter("validate");
	String message			=	"";
	//String flag				=	"INVALID_VALIDATE_FLAG";
	boolean	result			=	false;
	if (validate.equals("PATIENT_NAME")){
	try{			
					String patientName=bean.getPatientName(patient_id.trim());	
					out.println("document.DirectSalesPatientForm.patient_name.value ='"+bean.checkForNull(patientName,"")+"';");
	}catch(Exception exception){
				exception.printStackTrace();
			}
	}else if(validate.equals("PATIENT_ID_IN_ST")) {
		try{
					result=false;

					int count				=	0;	count=Integer.parseInt((String)((HashMap)bean.fetchRecord("SELECT count(PATIENT_ID ) count FROM ST_DIR_SALE_PATIENT_PARAM  WHERE PATIENT_ID=?",patient_id)).get("COUNT"));

					if(count>0){
					result = true;
					}
				out.println("assignResult("+result+",\""+message+"\", \"0\");");

			}catch(Exception exception){
				exception.printStackTrace();
			}

		}
		
		
		
		

	%>
	<%
putObjectInBean("directSalesPatient",bean,request);
%>
