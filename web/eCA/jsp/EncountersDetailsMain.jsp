<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
07/01/2013		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   
15/07/2013	IN034514		Karthi L	In Clinical Event History, one could see information about patient's visit as a 
												summary which included Patient Admission date, date of discharge, attending practitioner, etc												
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
07/10/2016	IN047572			Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ‘View Clinical Notes’ and ‘Clinical Event History’				
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/Encounters.js" language="JavaScript"></script>
<script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></script>

<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String encid = request.getParameter("enc_id")==null?"":request.getParameter("enc_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String event_date = request.getParameter("event_date")==null?"":request.getParameter("event_date");

		String graphorder = request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

		String abnormal = request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
		String normalcy = request.getParameter("normalcy")==null?"":request.getParameter("normalcy");
		String episode_wise = request.getParameter("episode_wise")==null?"":request.getParameter("episode_wise");
		String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by");
		
		String episodetype		= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
		if(episodetype.equals("")) episodetype="B";
		String selectedhisttype		= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
		String selectedeventclass	= request.getParameter("event_class")==null?"": request.getParameter("event_class");
		String selectedeventgroup	= request.getParameter("event_group")==null?"": request.getParameter("event_group");
		String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String selectedeventitem	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String EHR_YN	= request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
		String show_mode = request.getParameter("show_mode")==null?"":request.getParameter("show_mode");
		//Added By Jyothi on 12/03/2010 to fix 18685
		String page_no = request.getParameter("page_no")==null?"1":request.getParameter("page_no");
		String relationship_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
		String patient_class 	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");// IN034514
		String p_menu_type 	=	request.getParameter("p_menu_type")==null?"":request.getParameter("p_menu_type");// IN034514
		String p_enc_details_tree 	=	request.getParameter("p_enc_details_tree")==null?"":request.getParameter("p_enc_details_tree");// IN034514			
		String encntr_yn 	=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");// IN034514
		String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
		String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		
		String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id;//IN035950
		//Start - IN034514
			//String params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950  // commented for IN034514
			String params = "";
			String params1 = "";
			if(show_mode.equals("E") || show_mode.equals("C")){
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950 -- // MMS-QH-CRF-0177 [IN047572] 
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code;//modified for  MMS-QH-CRF-0177 [IN047572]
				params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn;//modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params=params+"&order_type_3T="+order_type_3T;	 //39052
				if(encounterid.equals("")){
					encounterid = encid;
				}
				//params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN034514 -- // MMS-QH-CRF-0177 [IN047572]
				//params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params1 = "patient_class="+patient_class+"&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params1=params1+"&order_type_3T="+order_type_3T; //39052
			}
			else {
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget;//IN035950 -- // MMS-QH-CRF-0177 [IN047572]
				//params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; //modified for  MMS-QH-CRF-0177 [IN047572]//IN071561
				params = "&encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&event_date="+event_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&viewby="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&graphorder="+graphorder+"&enc_id="+encid+"&EHR_YN="+EHR_YN+"&page_no="+page_no+"&relationship_id="+relationship_id+"&p_event_class_widget="+eventClasswidget+"&p_called_from_widget="+called_from_widget+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&p_review_rad_yn="+p_review_rad_yn; //modified for  MMS-QH-CRF-0177 [IN047572]
				params=params+"&order_type_3T="+order_type_3T; //39052
			}
		//End - IN034514
		String file_name="";
		//Start - IN034514
		String file_name1="";
			if(show_mode.equals("E")){ // IN034514
				file_name1="../../eCA/jsp/EncountersDetails.jsp?"+params1;
				file_name="../../eCA/jsp/ExpandedClinicalEvent.jsp?"+params;
			}
			else if(show_mode.equals("C")){ 
				file_name1="../../eCA/jsp/EncountersDetails.jsp?"+params1;
				file_name="../../eCA/jsp/EncountersDetailsDisplay.jsp?"+params ;
			}

	 	
	if(patient_class.equals("XT") || (encntr_yn.equals("N") && p_menu_type.equals(""))){ 
		if(patient_class.equals("XT") && p_menu_type.equals("H"))  { %>
		
		<frameset rows="20%,*,0%" border=0 frameborder=0>
		<frame src="<%=file_name1%>"  name="DisplayCriteria" id="DisplayCriteria" scrolling="auto" frameborder="0">
		 	
	<% }else if(patient_class.equals("XT") && encntr_yn.equals("")){ %>
		
		<frameset rows="20%,*,0%" border=0 frameborder=0>
		<frame src="<%=file_name1%>"  name="DisplayCriteria"  id="DisplayCriteria" scrolling="auto" frameborder="0">
	
	<% } else { %>
	
			<frameset rows="*,0%" border=0 frameborder=0>
	<% }
	} else if(!patient_class.equals("XT") || p_menu_type.equals("H") || encntr_yn.equals(""))  { 
		if( p_enc_details_tree.equals("tree_builder") && p_menu_type.equals("")) {
	%>	
 		<frameset rows="*,0%" border=0 frameborder=0>  
 	<%
		}else {
 	%>	
		<frameset rows="20%,*,0%" border=0 frameborder=0>
		<frame src="<%=file_name1%>"  name="DisplayCriteria" id="DisplayCriteria" scrolling="auto" frameborder="0"> 
	<%}
	}
		//End - IN034514
	%>
<!-- 	<frame src="<%//=file_name%>?<%//=params%>"  name="DisplayCriteria"  scrolling="auto" frameborder="0">-->
	<frame src="<%=file_name%>"  name="DisplayCriteria"  id="DisplayCriteria" scrolling="auto" frameborder="0">
	<frame src="../../eCommon/html/blank.html" name="DisplayResult" id="DisplayResult" scrolling="auto" frameborder="0">
</frameset>
</html>
