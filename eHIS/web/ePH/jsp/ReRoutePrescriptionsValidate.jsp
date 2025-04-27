<%@page import="java.util.*,java.io.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id="";
	String bean_name="";
	bean_id		= request.getParameter( "bean_id" ) ;
	bean_name		= request.getParameter( "bean_name" ) ;
	String patient_id	= request.getParameter( "patient_id" ) ;
	String validate		= request.getParameter("validate");
	//String facility_id   = (String)session.getValue( "facility_id" );
	//String login_user	= (String)session.getValue("login_user");
  
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	ReRoutePrescriptionsBean bean = (ReRoutePrescriptionsBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	if(validate.equals("CALLPATIENT")){
	    ArrayList patientdetails = bean.getPatientDetails(patient_id);
		if(patientdetails.size()!=0){
			 String p_name=(String)patientdetails.get(0);
			 String p_age  = (String)patientdetails.get(1);
			 String p_sex  = (String)patientdetails.get(2);
			 out.println("assignPatientLine(\""+p_name+"\",'"+p_age+"','"+p_sex+"');") ;
		}
	}	
	else if(validate.equals("GETDISPLOC")){//the  condtion  added for Bru-HIMS-CRF-090 [IN:029956] -- start
		//  ArrayList patientdetails = bean.getPatientDetails(patient_id);
		String facility_id=request.getParameter("facility_id");	
		String user_id	= request.getParameter("user_id");
		String row_no	= request.getParameter("row_no");

		ArrayList disp_loc_codes=bean.getDispenseLocation(user_id,facility_id);
		String	disp_locn_code	= "";
		String	disp_locn_desc	= "";

		for(int i=0;i<disp_loc_codes.size();i=i+2){
			disp_locn_code=(String)disp_loc_codes.get(i);
			disp_locn_desc=(String)disp_loc_codes.get(i+1);
			out.println("addDispLocnDescList('"+disp_locn_code+"','"+disp_locn_desc+"','"+row_no+"','"+facility_id+"')");
		}
	}//for Bru-HIMS-CRF-090 [IN:029956] -- end
	else if(validate.equals("CHECKPATIENTID")){
		ArrayList patientdetails	= bean.getPatientDetails1(patient_id);
		if(patientdetails.size()==0){
			out.println("chkpatID('Y');") ;
		}
		else{
			out.println("chkpatID('N');") ;
		}
	}    
	else if(validate.equals("release")){
	}
	else if(validate.equals("InsertExternalDetails")){//Added for HSA-CRF-0155 [IN048487]-Start
		String print_extr_pres=request.getParameter("print_extr_pres");	
		String ext_facility	= request.getParameter("ext_facility");
		String next_collection_date	= request.getParameter("next_collection_date");
		String referral_remarks	= request.getParameter("referral_remarks");
		referral_remarks=java.net.URLDecoder.decode(referral_remarks,"UTF-8");
		String practioner_id	= request.getParameter("practioner_id");
		String ExtbmsReason	= request.getParameter("ExtbmsReason");
		HashMap record=new HashMap();
		record.put("EXT_FACILITY",ext_facility);
		record.put("NEXT_COLLECTION_DATE",next_collection_date);
		record.put("REFERRAL_REMARKS",referral_remarks);
		record.put("EXTBMSREASON",ExtbmsReason);
		record.put("PRACTIONER_ID",practioner_id);
		bean.setExternalDetails(record);
		out.println(print_extr_pres);
	}
	 else if(validate.equals("PrintExternalPrescription")){
		String user_name= (String) session.getValue( "login_user" ) ;
		String facility_id=(String)session.getValue( "facility_id" );
		String ReportOutput	= "";
		String report_id		= "PHREFLTR";
		ecis.utils.OnlineReports onlineReports		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report				=	null;
		String sysdate			= bean.getTodaysDate();
		Hashtable all_values=null;
		int tot_rec=0;
		all_values=bean.getAllValues();
		tot_rec=Integer.parseInt((String)all_values.get("tot_record_count"));
		for(int i=1;i<=tot_rec;i++){
			if (((String)all_values.get("prescription_type_"+ i)).trim().equals("E") && ((String)all_values.get("chk_"+ i)).trim().equals("Y")){
					report	= new ecis.utils.OnlineReport(facility_id, "PH",report_id) ;
					report.addParameter("p_report_id",report_id) ;
					report.addParameter("p_user_name",user_name) ;
					report.addParameter("p_facility_id",facility_id) ;
					report.addParameter("p_patient_id",((String)all_values.get("patient_id")).trim()) ;
					report.addParameter("p_patient_class",((String)all_values.get("patient_class_"+ i)).trim());
					report.addParameter("p_module_id", "PH") ;
					report.addParameter("p_order_id", ((String)all_values.get("OrderId_"+ i)).trim()) ;
					report.addParameter("p_disp_date",sysdate);
					report.addParameter("p_pat_class",((String)all_values.get("patient_class_"+ i)).trim());
					report.addParameter("p_language_id", locale) ;
					onlineReports.add( report) ;
					ReportOutput = onlineReports.execute( request, response );
				}
			}
	}//Added for HSA-CRF-0155 [IN048487]-End
	putObjectInBean(bean_id,bean,request);
%>
