 <%--This file is saved on 07/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
    request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	
	try {
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= "PHReportsBean" ;
		String bean_name			= "ePH.PHReportsBean";
		String validate = request.getParameter( "validate" ) ;
		PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id,bean_name,request);
		if ( validate.equals( "disp_timings" ) ) {
			String disp_loc_code=(String)hash.get("disp_loc_code" ) ;
			String working_hours_from="";
			String working_hours_to="";
			ArrayList desptimes = bean.getDespTimings(disp_loc_code) ;
			if (desptimes.size() != 0){
				working_hours_from = (String)desptimes.get(0);
				working_hours_to = (String)desptimes.get(1);
			}          
			out.println("addtimings('"+ working_hours_from + "','"+working_hours_to+"' );") ;
		 }
		 else if(validate.equals( "disp_loc" )){ 
			 String loc_type=(String)hash.get("disp_loc_flag" ) ; 
			 out.println("clearDispLoc();") ;
			ArrayList disp_loc = bean.getDispLocn(loc_type,locale);
			for (int i=0; i<disp_loc.size(); i+=2) {
				out.println("populateDispLoc('"+(String)disp_loc.get(i)+"','"+(String)disp_loc.get(i+1)+"')");
			}
		}
		else if(validate.equals("getPatentDetails")){
			String patient_id=(String)hash.get("patient_id" ) ;
			String main_patientid =bean.DuplicateCheck(patient_id);
			if(!main_patientid.equals("") ){
				out.println("mergedPatientAlert('"+main_patientid+"');");	
				patient_id = main_patientid;
			}
			ArrayList patientdetails = bean.getPatientDetails(patient_id);
			if(patientdetails.size()!=0){
				String p_name=(String)patientdetails.get(0);
				p_name=p_name.replaceAll(" ","%20");
				p_name = java.net.URLEncoder.encode(p_name,"UTF-8");
				p_name=p_name.replaceAll("%2520","%20");
				String p_age  = (String)patientdetails.get(1);
				String p_sex  = (String)patientdetails.get(2);
				out.println("dispPatientDtails(\""+p_name+"\",'"+p_age+"','"+p_sex+"');") ;
			}
			else
				 out.println("alertInvalidPat();") ;
		}
		else if(validate.equals("Querycount")){ //added for MMS-QH-CRF-0110[IN039378]
			String custgrpfrom = (String)hash.get( "custgrpfrom" );
			String custfrom = (String)hash.get("custfrom");
			String custto = (String)hash.get("custto" );
			String fromdate = (String)hash.get("fromdate");
			String todate = (String)hash.get("todate" );
			String p_sal_trn_type = (String)hash.get("p_sal_trn_type");
			int count =bean.getQueyCountCostlyRxCustomer(custgrpfrom,custfrom,fromdate,todate,p_sal_trn_type);
			out.println(count);
		}
		else if(validate.equals("custgrp")){ 
		    ArrayList customer=new ArrayList();
			String custgrpfrom = hash.get("custgrpfrom" )==null?"":(String)hash.get("custgrpfrom" );
			customer=bean.getCustomerBasedCustgrp(custgrpfrom);
			for(int i=0;i<customer.size();i++){
				out.println( "loadCustomer(\"" +(String)customer.get(i)+ "\",\"" +(String)customer.get(++i)+ "\") ; " ) ;
			}
			
		}//added for MMS-QH-CRF-0110[IN045590] end
		else if(validate.equals("storeSeleciton")){  //Added for Bru-HIMS-CRF-415 [IN:045556] -start
			String print_bean_id				= "PrintPrescriptionReportBean" ;
			String print_bean_name			= "ePH.PrintPrescriptionReportBean";
			String selected = (String)hash.get("selected")==null?"":(String)hash.get("selected");
			String dispNo = (String)hash.get("dispNo" )==null?"":(String)hash.get("dispNo" );
			PrintPrescriptionReportBean print_bean = (PrintPrescriptionReportBean)getBeanObject( print_bean_id,print_bean_name, request) ;
			ArrayList selectedDispNos = print_bean.getSelectedDispNos();
			if(selectedDispNos==null)
				selectedDispNos = new ArrayList();
			if(selected.equals("N")){
				if(selectedDispNos.contains(dispNo))
					selectedDispNos.remove(dispNo);
			}
			else if (selected.equals("Y")){
				if(!selectedDispNos.contains(dispNo))
					selectedDispNos.add(dispNo);
			}
			print_bean.setSelectedDispNos(selectedDispNos);
			putObjectInBean(print_bean_id,print_bean,request); 
		}
		else if(validate.equals("getSelectedDispNos")){ 
			String print_bean_id				= "PrintPrescriptionReportBean" ;
			String print_bean_name			= "ePH.PrintPrescriptionReportBean";
			String selected = (String)hash.get("selected")==null?"":(String)hash.get("selected");
			String dispNo = (String)hash.get("dispNo" )==null?"":(String)hash.get("dispNo" );
			PrintPrescriptionReportBean print_bean = (PrintPrescriptionReportBean)getBeanObject( print_bean_id,print_bean_name, request) ;
			ArrayList selectedDispNos = print_bean.getSelectedDispNos();
			if(selectedDispNos !=null && selectedDispNos.size()>0){
				StringBuffer sbSelectedDispNos = new StringBuffer();
				for( int i=0; i<selectedDispNos.size(); i++){
					if(i>0)
						sbSelectedDispNos.append(",");
					sbSelectedDispNos.append((String)selectedDispNos.get(i));
				}
				if(sbSelectedDispNos.length()>0){
					out.println("setSelectedDispNos('"+sbSelectedDispNos.toString()+"');");
				}
			}
		}//Added for Bru-HIMS-CRF-415 [IN:045556] end
		else if(validate.equals("getDispLocByFacilityId")){ 
			String facility_id=(String)hash.get("facility_id" ) ;
			String disp_locn_category=(String)hash.get("disp_locn_category" ) ;
			ArrayList	disp_locns		=	new ArrayList();
			String desc="";
			if("OP".equals(disp_locn_category))
				disp_locns		=	bean.getOPDispLocations(facility_id);
			else
				disp_locns		=	bean.getDispLocation(facility_id);
			out.println("clearList();");
			if(disp_locns.size()>0){
				for(int i=0; i<disp_locns.size(); i+=2) {
					desc = (String)disp_locns.get(i+1)==null?"":(String)disp_locns.get(i+1);
					desc = desc.replaceAll(" ","%20");
					desc =  java.net.URLEncoder.encode(desc,"UTF-8");
					desc = desc.replaceAll("%2520","%20");
					out.println("addList(\""+(String)disp_locns.get(i)+"\",\""+desc+"\");");
				}
			}
		}//added for HSA-CRF-0137 [IN:048413]
		else if (validate.equals("POPULATEENCOUNTER")){ //added forMMS-DM-CRF-0012 [IN:054569]
			String patient_id	= request.getParameter( "patient_id" ) ;
			String patientClass	= request.getParameter( "patientClass" ) ;	
			ArrayList encounterDetails = bean.getEncounterIdDetails(patient_id,patientClass) ;	
			out.println("clearData('document.formPatientDrugProfileList.p_encounter_id');") ;
			if(encounterDetails!=null && encounterDetails.size() > 0){
				for(int i=0; i<encounterDetails.size(); i++) {	
					out.println("addDataDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.formPatientDrugProfileList.p_encounter_id','');") ;			
				}
			}
		}
		putObjectInBean(bean_id,bean,request); 
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>

