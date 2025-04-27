<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
13/12/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
19/07/2012      IN030590		Nijitha			KDAH-CRF-0129												
												
15/07/2013		IN034514		Karthi L	In Clinical Event History, one could see information about patient's visit as a 
08/08/2013		IN042053		Karthi L	System is displaying No event records to the patient at Clinical Event History at 'Tree' view mode by searching the patient in other facility by Patient without encounter function.
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-------------------------------------------------------------------------------------------------------------------------------------
10/10/2016		IN047572		Karthi L											[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the �View Clinical Notes� and �Clinical Event History�
23/10/2018		IN068011		Raja S				23/10/2018		Ramesh G		ML-MMOH-CRF-1204 			
02/01/2019  		IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-CRF-0491
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
03/02/2020		39052			Ramesh											ML-BRU-CRF-0634
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> <!-- import statements IN034514 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title> <fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Connection con = null; // IN034514 - Start
		PreparedStatement pstmt = null;
		ResultSet rset = null; // IN034514 - End
		String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String encid = request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String abnormal = request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
		String normalcy = request.getParameter("normalcy")==null?"":request.getParameter("normalcy");
		String episode_wise = request.getParameter("episode_wise")==null?"":request.getParameter("episode_wise");
		String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String calling_from_2T = request.getParameter("calling_from_2T")==null?"":request.getParameter("calling_from_2T");//IN068011

		if(encid.equals("")) encid = "0";

		String episodetype		= request.getParameter("episode_type")==null?"B":request.getParameter("episode_type");
		if(episodetype.equals("")) episodetype="B";
		String selectedhisttype		= request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
		String selectedeventclass	= request.getParameter("event_class")==null?"": request.getParameter("event_class");
		String selectedeventgroup	= request.getParameter("event_group")==null?"": request.getParameter("event_group");
		String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
		//IN030590 Starts // commented below line for IN042053
		/*if("".equals(facility_id))
		{
			facility_id = (String) session.getValue("facility_id");
		}*/
		//IN030590 Ends
		String selectedeventitem	= request.getParameter("event_item")==null?"":request.getParameter("event_item");
		String sortOrder	= request.getParameter("graphorder")==null?"desc":request.getParameter("graphorder");
		String EHR_YN	= request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");

		String show_mode = request.getParameter("show_mode")==null?"":request.getParameter("show_mode");
		String relationship_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		//IN035950 Starts
		String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");
		String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");
		String p_hist_type		=	request.getParameter("p_hist_type")==null?"":request.getParameter("p_hist_type");
		String patient_class 	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//IN034514 
		String encntr_yn 	=	request.getParameter("encntr_yn")==null?"":request.getParameter("encntr_yn");//IN034514 
		String header_view 	=	request.getParameter("header_view")==null?"":request.getParameter("header_view");//IN034514 
		String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
		String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]	 
		String isSiteSpecificForLabPrint	= request.getParameter("isSiteSpecificForLabPrint")==null?"":request.getParameter("isSiteSpecificForLabPrint");//IN066453
		String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		String archivalYN	= request.getParameter("archivalYN")==null?"": request.getParameter("archivalYN"); //52176
		if("CA_RESULTS_WIDGET".equals(p_called_from))
		selectedhisttype=p_hist_type;
		//IN035950 Ends
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id;//IN035950
		//  String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from	//IN035950 //commented for IN034514
		// IN034514 - Start		
		if(encounterid != null && encounterid != "") {
			try{
				con=ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement("select patient_class from pr_encounter where encounter_id = ?");
				pstmt.setString(1,encounterid);
				rset = pstmt.executeQuery();
				if(rset.next())
				{
						patient_class = rset.getString("patient_class") == null ? "" : rset.getString("patient_class");
				}
				if(rset !=null) rset.close();
				if(pstmt !=null) pstmt.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally {
				if(con != null) con.close();
			}
		}
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&patient_class="+patient_class+"&encntr_yn="+encntr_yn+"&header_view="+header_view+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from;	//IN034514 -- // MMS-QH-CRF-0177 [IN047572]	
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&patient_class="+patient_class+"&encntr_yn="+encntr_yn+"&header_view="+header_view+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code; // MMS-QH-CRF-0177 [IN047572]//Commented for IN068011
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&patient_class="+patient_class+"&encntr_yn="+encntr_yn+"&header_view="+header_view+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&calling_from_2T="+calling_from_2T; //Modified for IN068011->commented for IN066453
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&patient_class="+patient_class+"&encntr_yn="+encntr_yn+"&header_view="+header_view+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&calling_from_2T="+calling_from_2T+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint; //Modified for IN066453 //IN071561
		String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&patient_class="+patient_class+"&encntr_yn="+encntr_yn+"&header_view="+header_view+"&abnormal="+abnormal+"&normalcy="+normalcy+"&episode_wise="+episode_wise+"&view_by="+view_by+"&episode_type="+episodetype+"&hist_type="+selectedhisttype+"&event_class="+selectedeventclass+"&event_group="+selectedeventgroup+"&facility_id="+facility_id+"&event_item="+selectedeventitem+"&sortOrder="+sortOrder+"&enc_id="+encid+"&called_from="+called_from+"&EHR_YN="+EHR_YN+"&show_mode="+show_mode+"&relationship_id="+relationship_id+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&speciality_code="+speciality_code+"&attend_pract_code="+attend_pract_code+"&calling_from_2T="+calling_from_2T+"&isSiteSpecificForLabPrint="+isSiteSpecificForLabPrint+"&p_review_rad_yn="+p_review_rad_yn;//IN071561
		// IN034514 - End
		params=params+"&order_type_3T="+order_type_3T;  //39052
		params=params+"&archivalYN="+archivalYN;  //52176
		
%>
<%-- <frameset rows="*,6%,0%" border=0 frameborder=0>

<!--modifeid by Arvind @ 04-12-2008-->

	<frameset cols="200px,*" border=0>
		<!-- <frameset rows="90%,*" border=0> -->
		<frame  src="../../eCA/jsp/EncountersDetailsTree.jsp?<%=params%>" name="details_f1" id="details_f1" frameborder="0" noresize scrolling="yes">
		<!-- <frame src="../../eCA/jsp/FlowSheetColorLegend.jsp?fromFunction=ClinicalEvents" name="details_Error" frameborder="0" scrolling="yes" noresize>		
		</frameset> -->
 		<frame src="../../eCommon/html/blank.html" name="details_f2" id="details_f2" frameborder="0" noresize> 
	</frameset>
	<frame src="../../eCA/jsp/EncountersButtons.jsp?<%=params%>" name="button_f1" id="button_f1" scrolling="no" frameborder="0" noresize>
	<frame src="../../eCommon/html/blank.html" name="manageEmailFrame" id="manageEmailFrame" frameborder="0" noresize> 
</frameset> --%>

	<div style="height: 95vh; width:98vw; display: flex; flex-direction: row;">
        <iframe src="../../eCA/jsp/EncountersDetailsTree.jsp?<%=params%>" name="details_f1" id="details_f1" style="width: 15vw; height: 94vh; border: none;" scrolling="yes"></iframe>
        <iframe src="../../eCommon/html/blank.html" name="details_f2" id="details_f2" style="flex: 1; height: 94vh;"></iframe>
    </div>
    <iframe src="../../eCA/jsp/EncountersButtons.jsp?<%=params%>" name="button_f1" id="button_f1" style="height: 8vh; width: 100vw; border: none;" scrolling="no"></iframe>
    <iframe src="../../eCommon/html/blank.html" name="manageEmailFrame" id="manageEmailFrame" style="height: 0vh; width: 100vw; border: none;"></iframe>
	
</html>
