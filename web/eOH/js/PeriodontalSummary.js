function showGSDetails(quadrant_sno,gs_count,th_count,gingival_recording_by){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;

   	//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	//var params = "quadrant_sno="+quadrant_sno+"&patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&gs_count="+gs_count+"&th_count="+th_count+"&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var params = "quadrant_sno="+quadrant_sno+"&patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&gs_count="+gs_count+"&th_count="+th_count+"&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&mixed_dentition_YN="+mixed_dentition_YN;
	//
	parent.frames[2].frames[1].document.location.href = "../../eOH/jsp/PeriodontalSummaryDetails.jsp?"+params;
	parent.frames[2].frames[0].document.location.href = "../../eOH/jsp/PeriodontalSummaryHeader.jsp?"+params;
	//parent.frames[1].frames[1].document.location.href = "../../eOH/jsp/PeriodontalSummaryDetails.jsp?"+params;
}

// Function for tab Reset
function GS_Tab_Reset_button1(){
	//To reset Error Msg Frame
	parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	GS_Tab_Reset1();
}

//function for reset  button
function GS_Tab_Reset1(){
  	//Refreshing the form values with the original params
    var old_params = parent.parent.frames[2].document.forms[0].params.value;	parent.parent.frames[3].document.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?"+old_params+"&defaultTab=GingivalStatus";
	//alert(parent.parent.frames[3].document.location.href)
  // old_params = old_params+"&gs_dflt_tooth_no_Q1="+gs_dflt_tooth_no_q1+"&gs_dflt_tooth_no_Q2="+gs_dflt_tooth_no_q2+"&gs_dflt_tooth_no_Q3="+gs_dflt_tooth_no_q3+"&gs_dflt_tooth_no_Q4="+gs_dflt_tooth_no_q4+"&gs_dflt_tooth_no_s1="+gs_dflt_tooth_no_s1+"&gs_dflt_tooth_no_s2="+gs_dflt_tooth_no_s2+"&gs_dflt_tooth_no_s3="+gs_dflt_tooth_no_s3+"&gs_dflt_tooth_no_s4="+gs_dflt_tooth_no_s4+"&gs_dflt_tooth_no_s5="+gs_dflt_tooth_no_s5+"&gs_dflt_tooth_no_s6="+gs_dflt_tooth_no_s6;
    document.location.href = "../../eOH/jsp/GingivalStatus.jsp";
	
    var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
	
	//To reset Error Msg Frame
	//parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	

   
}
