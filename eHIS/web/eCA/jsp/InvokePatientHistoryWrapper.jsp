<%
/*
----------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------
19/08/2015	IN054952		Karthi L											ML-BRU-SCF-1588
19/01/2018  IN066218  		PRATHYUSHA P	28/1/2018		Ramesh G			ML-MMOH-CRF-0985.1
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
08/06/2020	IN073001		Ramesh Goli		08/06/2020		Ramesh G			PMG2019-GHL-CRF-0003.2
03/05/2022	28843			Ramesh Goli		03/05/2022		Ramesh GH			NMC-JD-CRF-0155
----------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
System.out.println("1----------------->InvokePatientHistoryWrapper.jsp");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");

	//String queryString = request.getQueryString()== null?"":request.getQueryString();
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");
	String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
	
	String facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
	String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
	String patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");

	//String episode_id = request.getParameter("p_episode_id") == null ? "" : request.getParameter("p_episode_id");
	String encounter_id = request.getParameter("p_encounter_id") == null ? "" : request.getParameter("p_encounter_id");
	String accession_number = request.getParameter("accession_number") == null ? "" : request.getParameter("accession_number");
	String accession_type = request.getParameter("accession_type") == null ? "" : request.getParameter("accession_type");
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	
//Start : Added by Sridhar Reddy On 05/11/2008
	String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
// END : Sridhar Reddy On 05/11/2008

	//IN066218 START
	String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
	String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
	String history_type=request.getParameter("history_type")==null?"":request.getParameter("history_type");
	String event_class=request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String newPrameters="&che_default_mode="+che_default_mode+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type+"&event_class="+event_class+"&from_date="+from_date+"&to_date="+to_date+"&event_item="+event_item;
	//IN066218 END.
	
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	String show_others_unsinged_yn = request.getParameter("SHOW_OTHERS_UNSINGED_YN") == null ? "N" : request.getParameter("SHOW_OTHERS_UNSINGED_YN"); // added for ML-BRU-SCF-1588 [IN054952]
	String senior_radiologist_yn = request.getParameter("senior_radiologist_yn") == null ? "N" : request.getParameter("senior_radiologist_yn"); // added for ML-BRU-SCF-1588 [IN054952]
	//IN073001 Start
	String updateRDExamViewRequest = request.getParameter("updateRDExamViewRequest") == null ? "N" : request.getParameter("updateRDExamViewRequest");
	String request_num = request.getParameter("p_request_num") == null ? "" : request.getParameter("p_request_num");
	String request_line_num = request.getParameter("p_request_line_num") == null ? "" : request.getParameter("p_request_line_num");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------updateRDExamViewRequest-------------->"+updateRDExamViewRequest+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------request_num-------------->"+request_num+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------request_line_num-------------->"+request_line_num+"<-----");
	System.out.println("InvokePatientHistoryWrapper.jsp-----------facility_id-------------->"+facility_id+"<-----");
	String archivalYN = request.getParameter("archivalYN") == null ? "" : request.getParameter("archivalYN"); //52176
	//IN073001 End.
	if(locale.equals(""))
	{
		System.out.println("locale value is comming as empty in InvokePatientHistoryWrapper.jsp");
	}

	session.putValue("LOCALE",locale);
	
	
%>
<script>
	function openHistory(){
		/*window.opener = null;
		self.close();		*/

		/**
			modified by Deepa on 7/8/2010 at 2:15 PM for IN021079
			this code prevents the alert that comes in IE8.
		**/
		 var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  
	     if (ie7) 
		 {
			   //This method is required to close a window without any prompt for IE7/IE8
			   window.open('','_parent','');
			   window.close();
           }
		   else 
           {
			   //This method is required to close a window without any prompt for IE6
			   this.focus();
			   self.opener = this;
			   self.close();
           }


		//window.open('http://dsg10:8887/eHIS/eCA/jsp/InvokePatientHistory.jsp?patient_id=UN00000000000008&episode_id=&login_user=NAREN&resp_id=CA&facility_id=GH','eHIS','height=570,width=790,top=0,left=0,resizable=yes,toolbar=no,menubar=no');
		
		//IN066218 Start.
		//window.open('../../eCA/jsp/InvokePatientHistory.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&accession_num=<%=accession_number%>&accession_type=<%=accession_type%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&limit_function_id=<%=limit_function_id%>&locale=<%=locale%>&note_type=<%=note_type%>&contr_mod_accession_num=<%=contr_mod_accession_num%>&function_id=<%=function_id%>&show_others_unsinged_yn=<%=show_others_unsinged_yn%>&senior_radiologist_yn=<%=senior_radiologist_yn%>','eHIS','location=0,height=700,width=1015,top=0,left=0,resizable=yes');	// added 'show_others_unsinged_yn', 'senior_radiologist_yn' for ML-BRU-SCF-1588 [IN054952]
		//window.open('../../eCA/jsp/InvokePatientHistory.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&accession_num=<%=accession_number%>&accession_type=<%=accession_type%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&limit_function_id=<%=limit_function_id%>&locale=<%=locale%>&note_type=<%=note_type%>&contr_mod_accession_num=<%=contr_mod_accession_num%>&function_id=<%=function_id%>&show_others_unsinged_yn=<%=show_others_unsinged_yn%>&senior_radiologist_yn=<%=senior_radiologist_yn%><%=newPrameters%>','eHIS','location=0,height=700,width=1015,top=0,left=0,resizable=yes');	Prakash
// 28843 	Start	
		var  screenHeight=screen.height;
		var  screenWidth=screen.width;
		var features ="location=0,height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes";
		//window.open('../../eCA/jsp/InvokePatientHistory.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&accession_num=<%=accession_number%>&accession_type=<%=accession_type%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&limit_function_id=<%=limit_function_id%>&locale=<%=locale%>&note_type=<%=note_type%>&contr_mod_accession_num=<%=contr_mod_accession_num%>&function_id=<%=function_id%>&show_others_unsinged_yn=<%=show_others_unsinged_yn%>&senior_radiologist_yn=<%=senior_radiologist_yn%><%=newPrameters%>&p_review_rad_yn=<%=p_review_rad_yn%>&request_num=<%=request_num%>&request_line_num=<%=request_line_num%>&updateRDExamViewRequest=<%=updateRDExamViewRequest%>','eHIS','location=0,height=700,width=1015,top=0,left=0,resizable=yes');//IN071561	
		window.open('../../eCA/jsp/InvokePatientHistory.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&accession_num=<%=accession_number%>&accession_type=<%=accession_type%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&limit_function_id=<%=limit_function_id%>&locale=<%=locale%>&note_type=<%=note_type%>&contr_mod_accession_num=<%=contr_mod_accession_num%>&function_id=<%=function_id%>&show_others_unsinged_yn=<%=show_others_unsinged_yn%>&senior_radiologist_yn=<%=senior_radiologist_yn%><%=newPrameters%>&p_review_rad_yn=<%=p_review_rad_yn%>&request_num=<%=request_num%>&request_line_num=<%=request_line_num%>&updateRDExamViewRequest=<%=updateRDExamViewRequest%>&archivalYN=<%=archivalYN%>','eHIS',features);	
// 28843  End.	
		//IN066218 End.
	}

</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</HEAD>
<BODY onload='openHistory();' onKeyDown='lockKey()'>
</BODY>
</HTML>

