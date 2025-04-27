<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
12/04/2017		AMRI-SCF-0452			Chithra		Debug MESSAGE@@@ given
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there
---------------------------------------------------------------------------------------------------------------
*/ %>
 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
try{
	String	func_mode       	=request.getParameter("func_mode")==null?"":request.getParameter("func_mode");
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	if(func_mode.equals("PrintReport")){
		String patientid=request.getParameter("patientid");
		String dispno="";
		dispno=request.getParameter("dispno");
		String srlnobatch="";
		srlnobatch=request.getParameter("srlnobatch");
		String srlno="";
		String rtn_medn_no="";
		String today="";
		srlno=request.getParameter("srlno");

		if((!srlno.equals(""))&&(!dispno.equals(""))){

			String facility_id		=	(String)session.getValue("facility_id");
			String login_user		=	(String)session.getValue("login_user");
			String language_id		=   (String)session.getAttribute("LOCALE");
			String report_id		=    "PHPRMDRT";
			String ReportOutput     =    "";

			//StringBuffer disp_str		= new StringBuffer(); //commented for SRR20056-SCF-7551 
			/*commented for SRR20056-SCF-7551 -start
			StringTokenizer dispnoToken = new StringTokenizer(dispno, ",");
			StringTokenizer srlnoToken  = new StringTokenizer(srlno, ",");
			while (dispnoToken.hasMoreTokens())	{
				//srlno	=	srlnoToken.nextToken();
				//dispno	=	dispnoToken.nextToken();
				disp_str.append("'").append(dispnoToken.nextToken()).append("~").append(srlnoToken.nextToken()).append("'");
					if (dispnoToken.hasMoreTokens()) {
						disp_str.append(",");
					}			
			}		
			commented for SRR20056-SCF-7551 -end*/
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
			String bean_name	= "ePH.ReturnMedicationBean";
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			rtn_medn_no=bean.getRtn_medn_no();
			//Added for GHL-SCF-1193 Start
			if(rtn_medn_no == "" || rtn_medn_no == null){
				rtn_medn_no=bean.getRetnMednNo();
			}//Added for GHL-SCF-1193 End
			today=bean.getSysDate();
			System.err.println("login_user for returnMedication SCF-452===="+login_user+"facility_id==="+facility_id+"patientid====="+patientid+"report_id==="+report_id+"language_id==="+language_id+"rtn_medn_no==="+rtn_medn_no+"today==="+today);	
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("p_user_name",login_user);
			report1.addParameter("p_facility_id",facility_id);
			report1.addParameter("p_patient_id",patientid);
			//report1.addParameter("p_srl_no",srlno);
			//report1.addParameter("p_dispense_no",disp_str.toString()); //commented for SRR20056-SCF-7551 
			report1.addParameter("p_report_id",report_id);
			report1.addParameter("p_module_id", "PH") ;
			report1.addParameter("p_language_id",language_id);
			report1.addParameter("p_rtn_medn_no",rtn_medn_no);
			report1.addParameter("p_rtn_date",today);
			System.err.println("report1@@@==="+report1);
			onlineReports.add( report1) ;
			System.err.println("DEBUG MESSAGE@@@ AMRI-SCF-0452===login_user:"+login_user+"facility_id :"+facility_id+"patientid:"+patientid+"report_id:"+report_id+"p_module_id=PH"+"language_id :"+language_id+"rtn_medn_no :"+rtn_medn_no+"p_rtn_date :"+today);

			ReportOutput = onlineReports.execute( request, response );
		}
	   	//batch_str.append(trade_id).append(";").append(batch_id).append(";").append(exp_date).append(";").append(bin_loc_code).append(";").append(issued_qty+"").append(";");


		/*int counter=dispnoToken.countTokens();
		if (counter==1)	{
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_user_name",login_user);
				report1.addParameter("p_facility_id",facility_id);
				report1.addParameter("p_patient_id",patientid);
				report1.addParameter("p_srl_no",srlno);
				report1.addParameter("p_dispense_no",dispno);
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_language_id",language_id);
				onlineReports.add( report1) ;
				 ReportOutput = onlineReports.execute( request, response );
				//out.println(ReportOutput);	

		}	else	{
			while (dispnoToken.hasMoreTokens())	{
					srlno	=	srlnoToken.nextToken();
					dispno	=	dispnoToken.nextToken();
					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
					ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1.addParameter("p_user_name",login_user);
					report1.addParameter("p_facility_id",facility_id);
					report1.addParameter("p_patient_id",patientid);
					report1.addParameter("p_srl_no",srlno);
					report1.addParameter("p_dispense_no",dispno);
					report1.addParameter("p_report_id",report_id);
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_language_id",language_id);
					onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
			}
		}*/
	 }
	 else if(func_mode.equals("onLinePrinting")){

		//java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "ReturnMedicationBean"+login_at_ws_no ; ;
		String bean_name	= "ePH.ReturnMedicationBean";
		ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;	
		String patient_id=request.getParameter("patient_id");
		String flag=request.getParameter("flag");
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport((String)session.getValue( "facility_id" ), "PH", "PHTOKEN") ;

		report2.addParameter("p_module_id", "PH") ;
		report2.addParameter("p_report_id", "PHTOKEN") ;
		report2.addParameter("P_TOKEN_NO", flag) ;
		report2.addParameter("P_TRANS_NAME", "RE") ;
		report2.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" )) ;
		report2.addParameter("P_DISP_LOCN_CODE",  bean.getDispLocnCode()) ;
		report2.addParameter("P_TOKEN_SERIES",bean.getTokenSeriesCode() ) ;
		report2.addParameter("p_language_id", (String)session.getAttribute("LOCALE")) ;
		report2.addParameter("p_patient_id", patient_id) ;
	//	System.err.println("DEBUG_MESSAGE @@@@@@@@@1222:::::p_module_id =PH ,p_report_id =PHTOKEN ,P_TOKEN_NO ="+flag+"P_TRANS_NAME =RE"+"P_FACILITY_ID  :"+(String)session.getValue( "facility_id" )+"P_DISP_LOCN_CODE  :"+bean.getDispLocnCode()+"P_TOKEN_SERIES  :"+bean.getTokenSeriesCode()+"p_language_id  :"+(String)session.getAttribute("LOCALE")+"p_patient_id  :"+p_patient_id);//Debug Message for AMRI-SCF-0452
		onlineReports.add( report2) ;
		String ReportOutput1 = onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );			
	
	 }
	 else if(func_mode.equals("WardReturnonLinePrinting")){
		String bean_id		= "WardReturnBean"+login_at_ws_no ;
		String bean_name	= "ePH.WardReturnBean";
		WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;	
		String patient_id=request.getParameter("patient_id");
		ArrayList retdoclist=bean.getRetdocList();
		int from_ret_doc_no=Integer.parseInt(retdoclist.get(0).toString());
		//int to_ret_doc_no=Integer.parseInt(retdoclist.get(retdoclist.size()-1).toString());

		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report3	= new ecis.utils.OnlineReport( (String)session.getValue( "facility_id" ), "PH","PHPRMDRTBYWARD") ;

		report3.addParameter("p_module_id", "PH") ;
		report3.addParameter("p_report_id", "PHPRMDRTBYWARD");
		report3.addParameter("p_ret_doc_no_from", from_ret_doc_no+"");
		report3.addParameter("p_ret_doc_no_to", from_ret_doc_no+"");
		report3.addParameter("p_patient_id", patient_id);
		report3.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" ));
		report3.addParameter("p_language_id", (String)session.getAttribute("LOCALE")) ;
		report3.addParameter("p_user_name", (String) session.getValue( "login_user")) ;	
		onlineReports.add( report3) ;
		//onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		String ReportOutput1 = onlineReports.execute( request, response );
	}	
}
catch(Exception e){
	e.printStackTrace();
}
%>
