
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id    = request.getParameter( "bean_id" ) ;
	String bean_name  = request.getParameter( "bean_name" ) ;
	
	String identity   = request.getParameter( "identity" ) ;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	 if (identity.equals("POPULATEENCOUNTER")){
		String patient_id	= request.getParameter( "patient_id" ) ;
		out.println("clearEncList();") ;
		ArrayList patientdetails	= bean.getPatientDetails(patient_id);
		if(patientdetails.size()>0) {
			ArrayList encounterDetails =bean.getEncounterIdDetails(patient_id) ; //HC00003199
			if(encounterDetails!=null && encounterDetails.size()>0){
				for (int i=0; i<encounterDetails.size(); i++) {
					out.println("addEncList('"+ encounterDetails.get(i) + "');") ;
				}
				out.println("defCurrEncounter('"+ encounterDetails.get(0) + "');") ;
			}
			out.println("chkpatID('N');") ;
		}
		else{
			out.println("chkpatID('Y');") ;
		}
	}
	else if (identity.equals("POPULATELOCATION")){
		String encounter_id	= request.getParameter( "encounter_id" ) ;
		String locn_desc, locn_code,pract_name , admin_date;
		ArrayList locationDetails =new ArrayList();
		locationDetails =bean.getLocationForEID(encounter_id) ;
		for (int i=0; i<locationDetails.size(); i+=4) {//i+=2
			locn_desc=(String)locationDetails.get(i);
			locn_desc=locn_desc.replaceAll(" ","%20");
			locn_desc = java.net.URLEncoder.encode(locn_desc,"UTF-8");
			locn_desc=locn_desc.replaceAll("%2520","%20");
			locn_code=(String)locationDetails.get(i+1);
			pract_name=(String)locationDetails.get(i+2);
			pract_name=pract_name.replaceAll(" ","%20");
			pract_name = java.net.URLEncoder.encode(pract_name,"UTF-8");
			pract_name=pract_name.replaceAll("%2520","%20");
			admin_date=(String)locationDetails.get(i+3);
			out.println("addlocation('"+ locn_desc + "','"+ locn_code + "','"+ pract_name + "','"+ admin_date + "');") ;
		} 
	}
	else if (identity.equals("CALEXPECTEDDATE")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String exp_date =(String)bean.getCalExpectedDeate(lmp_date) ;
		out.println("addexpecteddate('"+ exp_date + "');") ;
	}
	else if (identity.equals("CALPERGSTAGE")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String preg_week =(String)bean.getCalPregStage(lmp_date) ;
		
		out.println("addpregweek('"+ preg_week + "');") ;
	}
	else if (identity.equals("GETTRIMSTER")){
		String preg_week	= request.getParameter( "preg_week" ) ;
		String trimster =(String)bean.getTrimster(preg_week) ;
		out.println("assignTrimster('"+ trimster + "');") ;
	} 
	else if (identity.equals("PREG_DAYS")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String temp_date	= request.getParameter( "temp_date" ) ;
		String obj	= request.getParameter( "temp_name" ) ;
		String flag	= request.getParameter( "flag" ) ;
		String preg_days =(String)bean.getPregnencyDays(lmp_date,temp_date) ;
		out.println("chkpregDaysAlert('"+ preg_days + "','"+ obj + "','"+ flag + "');") ;
	} 
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>
