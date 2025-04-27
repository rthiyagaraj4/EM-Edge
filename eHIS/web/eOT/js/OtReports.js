/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function run(){
	var formObj = f_query_rep.document.OtReportOptionsForm;
	
	var retVal = checkMandatory(formObj);
	if(retVal==true) {
		retVal = CompareFields(formObj);
	}
	if(retVal==true)
		retVal = CompareDateFields(formObj);
	if(retVal==true){
	if (formObj.p_report_id.value=='OTRSTOPG' || formObj.p_report_id.value=='OTRSTOSG' ||formObj.p_report_id.value =='OTROPTPCA' || formObj.p_report_id.value =='OTROPTPST')
	{//215
	var locale=formObj.locale.value;
	var fromDate=formObj.param1.value;
	var cur_date=formObj.cur_date.value;
	var toDate=formObj.param2.value;
	var cur_val=isBefore(fromDate, cur_date, "MY", locale)
	if(formObj.p_report_id.value =='OTROPTPCA' || formObj.p_report_id.value =='OTROPTPST'){
		cur_val=isBefore(fromDate, toDate, "MY", locale)
	}
	if(cur_val==true){
	var mon_val=isBefore(fromDate, toDate, "MY", locale)
	}else{
		var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var from_month=getLabel("eOT.FromRegistrationMonth.Label","ot_labels");
		var to_month=getLabel("eOT.CurrentMonth.Label","ot_labels");
		//215 starts
		if(formObj.p_report_id.value =='OTROPTPCA' || formObj.p_report_id.value =='OTROPTPST'){
			from_month=getLabel("eOT.FromOperationMonth.Label","ot_labels");
			to_month=getLabel("eOT.ToOperationMonth.Label","ot_labels");
			alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
			return false;
		}else{
		alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
		}
			return false;
		}
		//215 ends
	if (mon_val==false)
		{		
		var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var from_month=getLabel("eOT.FromRegistrationMonth.Label","ot_labels");
		var to_month=getLabel("eOT.ToRegistrationMonth.Label","ot_labels");
		//215 correct stats
		if(formObj.p_report_id.value =='OTROPTPCA' || formObj.p_report_id.value =='OTROPTPST'){
			from_month=getLabel("eOT.FromOperationMonth.Label","ot_labels");
			to_month=getLabel("eOT.ToOperationMonth.Label","ot_labels");
		}//215 correct ends
		alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
			return false;
		}
	}
	}

	// Added by Bhavani on 14th May 2007. Copied from V3
	var gVal =true;
	if(retVal==true)

	if (formObj.p_report_id.value=='OTRSOTST')
	{
		var gVal = check_all_date_dmy(); 
		if (gVal==false)
		{
			return false;
		}
	}
	// Added by Bhavani on 14th May 2007 till here. Copied from V3

	if(retVal==true){
	if (formObj.p_report_id.value =='OTRDCBKG'){
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp' id='frm_temp'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param11' id='param11' value='"+formObj.param11.value+"'>";
		htmlVal += "<input type='hidden' name='param12' id='param12' value='"+formObj.param12.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";
		htmlVal += "<input type='hidden' name='param10' id='param10' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_name.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp.target="messageFrame";
		dummy_rep_frame.document.frm_temp.submit();		
	}
	else if (formObj.p_report_id.value =='OTRUNSOR' || formObj.p_report_id.value =='OTRNUGRP')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";
		htmlVal += "<input type='hidden' name='param9' id='param9' value='"+formObj.param9.value+"'>";
		htmlVal += "<input type='hidden' name='param10' id='param10' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='param11' id='param11' value='"+formObj.param11.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		//SRR
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();		
	}else if (formObj.p_report_id.value =='OTRDCGRP')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param9' id='param9' value='"+formObj.param9.value+"'>";
		htmlVal += "<input type='hidden' name='param10' id='param10' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='param11' id='param11' value='"+formObj.param11.value+"'>";
		htmlVal += "<input type='hidden' name='param12' id='param12' value='"+formObj.param12.value+"'>";
		htmlVal += "<input type='hidden' name='param14' id='param14' value='"+formObj.param14.value+"'>";
		htmlVal += "<input type='hidden' name='param15' id='param15' value='"+formObj.param15.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();		


	}else if (formObj.p_report_id.value =='OTRUNUOR')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param9' id='param9' value='"+formObj.param9.value+"'>";
		htmlVal += "<input type='hidden' name='param10' id='param10' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";		
		htmlVal += "<input type='hidden' name='param11' id='param11' value='"+formObj.param11.value+"'>";
		htmlVal += "<input type='hidden' name='param12' id='param12' value='"+formObj.param12.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		//SRR
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();		


	}else if (formObj.p_report_id.value =='OTREMGOP')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";
		htmlVal += "<input type='hidden' name='param9' id='param9' value='"+formObj.param9.value+"'>";
		htmlVal += "<input type='hidden' name='param10' id='param10' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='param11' id='param11' value='"+formObj.param11.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		//SRR - BR
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();	
	}	
	else if (formObj.p_report_id.value =='OTRSOTST')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='P_PERIODICITY' id='P_PERIODICITY' value='"+formObj.P_PERIODICITY.value+"'>";
		htmlVal += "<input type='hidden' name='P_FROM_YEAR' id='P_FROM_YEAR' value='"+formObj.P_FROM_YEAR.value+"'>";
		htmlVal += "<input type='hidden' name='P_TO_YEAR' id='P_TO_YEAR' value='"+formObj.P_TO_YEAR.value+"'>";
		htmlVal += "<input type='hidden' name='P_FROM' id='P_FROM' value='"+formObj.P_FROM.value+"'>";
		htmlVal += "<input type='hidden' name='P_TO' id='P_TO' value='"+formObj.P_TO.value+"'>";
		//Added against 43878
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		//Added against 43878
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";
		htmlVal += "<input type='hidden' name='param9' id='param9' value='"+formObj.param9.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();	
	}else if (formObj.p_report_id.value =='OTRMSBSP' || formObj.p_report_id.value =='OTRMSBCT'|| formObj.p_report_id.value =='OTRMSBSC' || formObj.p_report_id.value =='OTRMSBOP')
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='param1' id='param1' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='param2' id='param2' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='param7' id='param7' value='"+formObj.param7.value+"'>";
		htmlVal += "<input type='hidden' name='param4' id='param4' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='param3' id='param3' value='"+formObj.param3.value+"'>";
		htmlVal += "<input type='hidden' name='param5' id='param5' value='"+formObj.param5.value+"'>";
		htmlVal += "<input type='hidden' name='param6' id='param6' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='param8' id='param8' value='"+formObj.param8.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='user_id' id='user_id' value='"+formObj.user_id.value+"'>";
		htmlVal += "</form></body></html>";
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();	
	}
	
//AAKH-CRF-71
	else if (formObj.p_report_id.value =='OTORLIST' )
	{				
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='P_BOOKING_DATE' id='P_BOOKING_DATE' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION1_FROM' id='SECTION1_FROM' value='"+formObj.section1_from.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION2_FROM' id='SECTION2_FROM' value='"+formObj.section2_from.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION3_FROM' id='SECTION3_FROM' value='"+formObj.section3_from.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION1_TO' id='SECTION1_TO' value='"+formObj.section1_to.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION2_TO' id='SECTION2_TO' value='"+formObj.section2_to.value+"'>";
		htmlVal += "<input type='hidden' name='SECTION3_TO' id='SECTION3_TO' value='"+formObj.section3_to.value+"'>";
		htmlVal += "<input type='hidden' name='P_OPER_ROOM_CODE' id='P_OPER_ROOM_CODE' value='"+formObj.P_OPER_ROOM_CODE.value+"'>";
		htmlVal += "<input type='hidden' name='P_OPER_ROOM_DESC' id='P_OPER_ROOM_DESC' value='"+formObj.from_oper_room_desc.value+"'>";
		htmlVal += "<input type='hidden' name='P_SPECIALITY_CODE' id='P_SPECIALITY_CODE' value='"+formObj.P_SPECIALITY_CODE.value+"'>";
		htmlVal += "<input type='hidden' name='P_SPECIALITY_DESC' id='P_SPECIALITY_DESC' value='"+formObj.from_speciality_desc.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGEON_CODE' id='P_SURGEON_CODE' value='"+formObj.surgeon.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGEON_DESC' id='P_SURGEON_DESC' value='"+encodeURIComponent(formObj.param16_desc.value)+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_TYPE_CODE' id='P_LOCATION_TYPE_CODE' value='"+formObj.location_type.value+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_TYPE_DESC' id='P_LOCATION_TYPE_DESC' value='"+formObj.location_type.options[formObj.location_type.selectedIndex].text+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_CODE' id='P_LOCATION_CODE' value='"+formObj.locationCode.value+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_DESC' id='P_LOCATION_DESC' value='"+formObj.location.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGERY_TYPE_CODE' id='P_SURGERY_TYPE_CODE' value='"+formObj.param12.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGERY_TYPE_DESC' id='P_SURGERY_TYPE_DESC' value='"+formObj.param12.options[formObj.param12.selectedIndex].text+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();	
	}
//AAKH-CRF-71
	//215 crf starts
	else if (formObj.p_report_id.value =='OTROPTPCA' || formObj.p_report_id.value =='OTROPTPSP' || formObj.p_report_id.value =='OTROPTPST'){
	var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_from_date' id='p_from_date' value='"+formObj.param1.value+"'>";
		htmlVal += "<input type='hidden' name='p_to_date' id='p_to_date' value='"+formObj.param2.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_type' id='p_oper_type' value='"+formObj.param4.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_code' id='p_oper_code' value='"+formObj.param6.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_room' id='p_oper_room' value='"+formObj.param17.value+"'>";
		htmlVal += "<input type='hidden' name='p_speciality_code' id='p_speciality_code' value='"+formObj.param10.value+"'>";
		htmlVal += "<input type='hidden' name='p_surgeon_code' id='p_surgeon_code' value='"+formObj.param12.value+"'>";
		if(formObj.param9_desc.value=="" || formObj.param9_desc.value=="null"){
			htmlVal += "<input type='hidden' name='p_speciality_desc' id='p_speciality_desc' value='ALL'>";
		}else{
		htmlVal += "<input type='hidden' name='p_speciality_desc' id='p_speciality_desc' value='"+formObj.param9_desc.value+"'>";
		}
		if(formObj.param11_desc.value=="" || formObj.param11_desc.value=="null"){
		htmlVal += "<input type='hidden' name='p_surgeon_desc' id='p_surgeon_desc' value='ALL'>";
		}else{
		htmlVal += "<input type='hidden' name='p_surgeon_desc' id='p_surgeon_desc' value='"+formObj.param11_desc.value+"'>";
		}
		
		/*htmlVal += "<input type='hidden' name='p_surgeon_desc' id='p_surgeon_desc' value='"+formObj.surgeon.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGEON_DESC' id='P_SURGEON_DESC' value='"+encodeURIComponent(formObj.param16_desc.value)+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_TYPE_CODE' id='P_LOCATION_TYPE_CODE' value='"+formObj.location_type.value+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_TYPE_DESC' id='P_LOCATION_TYPE_DESC' value='"+formObj.location_type.options[formObj.location_type.selectedIndex].text+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_CODE' id='P_LOCATION_CODE' value='"+formObj.locationCode.value+"'>";
		htmlVal += "<input type='hidden' name='P_LOCATION_DESC' id='P_LOCATION_DESC' value='"+formObj.location.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGERY_TYPE_CODE' id='P_SURGERY_TYPE_CODE' value='"+formObj.param12.value+"'>";
		htmlVal += "<input type='hidden' name='P_SURGERY_TYPE_DESC' id='P_SURGERY_TYPE_DESC' value='"+formObj.param12.options[formObj.param12.selectedIndex].text+"'>";*/
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_id' id='p_user_id' value='"+formObj.p_user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_user_name' id='p_user_name' value='"+formObj.user_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formObj.p_module_id.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formObj.pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.p_language_id.value+"'>";
		htmlVal += "</form></body></html>";		
		dummy_rep_frame.document.body.innerHTML ='';
		dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		dummy_rep_frame.document.frm_temp1.action="../../eCommon/jsp/report_options.jsp";
    	dummy_rep_frame.document.frm_temp1.target="messageFrame";
		dummy_rep_frame.document.frm_temp1.submit();	
	}
	//2015 crf ends
	else
	{
	//if (formObj.p_report_id.value!='OTRDCBKG' || formObj.p_report_id.value!='OTRUNSOR'){
		f_query_rep.document.OtReportOptionsForm.action="../../eCommon/jsp/report_options.jsp";
    	f_query_rep.document.OtReportOptionsForm.target="messageFrame";
		f_query_rep.document.OtReportOptionsForm.submit();
		window.returnValue=true;
		window.close();
	}
	}
}

function checkMandatory(formObj){
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var no_of_mandatory_fields = formObj.no_of_mandatory_fields.value;
	if(formObj.no_of_mandatory_fields!=null){
		for(i=1;i<=no_of_mandatory_fields;i++){
		
			var field_names = eval("formObj.mandatory_fm_"+i).value;
			var arr=field_names.split("##");
			obj_name  = arr[0];
			obj_text  = arr[1];
			
			
			if(eval("formObj."+obj_name).value ==""){
				alert(msgArray[0]+""+obj_text+""+msgArray[1]);
				return false;
			}
		}
	}
	return true;
}


function CompareFields(formObj){
	if(formObj.no_of_comparison_fields!=null){
		var no_of_comparison_fields = formObj.no_of_comparison_fields.value;
		var locale=formObj.locale.value;
		for(i=1;i<=no_of_comparison_fields;i++){
			frm_field_text = eval("formObj.compare_fm_"+i).value;
			arr=frm_field_text.split("##");
			obj_text	= arr[1];
			frm_obj_name  = arr[0];
			
			to_obj_name = eval("formObj.compare_to_"+i).value;
			fromobj = eval("formObj."+frm_obj_name);
			toobj = eval("formObj."+to_obj_name);
			
			validate_flag = CheckString(obj_text,fromobj,toobj,messageFrame);
			if(validate_flag ==false)
				return false;
		}
	}
	return true;
}

/*String.prototype.endsWith = function(suffix) {  

     return this.match(suffix + "$") == suffix;  

 }*/ 

function CompareDateFields(formObj){
	var verifyFlag = 0;
	if(formObj.no_of_compare_date_fields!=null){
		var no_of_compare_date_fields = formObj.no_of_compare_date_fields.value;
		var flag="";
		var locale = formObj.locale.value;
		for(i=1;i<=no_of_compare_date_fields;i++){
			frm_field_text = eval("formObj.compare_date_fm_"+i).value;
			
			arr=frm_field_text.split("##");
			obj_text	= arr[1];

			frm_obj_name  = arr[0];
			to_obj_name = eval("formObj.compare_date_to_"+i).value;

			from_obj = eval("formObj."+frm_obj_name).value;
			//Modified by DhanasekarV against issue IN026581
		if(from_obj.length < 11)	
			fromobj = from_obj+" 00:00";			
			else
		fromobj = from_obj;
			
			to_obj = eval("formObj."+to_obj_name).value;
		//Modified by DhanasekarV against issue IN026581
		if(to_obj.length < 11)
			toobj = to_obj+ " 00:00";
		else
			toobj = to_obj;
			validate_flag = compareDates(fromobj,toobj,locale,'DMYHM');
			if(validate_flag ==false){				
				var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArray = msg.split("#");
				var to_date=getLabel("Common.todate.label","Common");
				var from_date =getLabel("Common.fromdate.label","Common");
				//215 starts
				if(formObj.p_report_id.value =='OTROPTPCA' ||  formObj.p_report_id.value =='OTROPTPST' ){
				
				to_date=getLabel("eOT.FromOperationMonth.Label","OT");
				from_date =getLabel("eOT.ToOperationMonth.Label","OT");				
				
				}else if(formObj.p_report_id.value =='OTROPTPSP'){
				to_date=getLabel("eOT.FromOperationDate.Label","OT");
				from_date =getLabel("eOT.ToOperationDate.Label","OT")
				alert(msgArray[0]+to_date+(msgArray[1])+from_date+(msgArray[2]));
				return false;
				}
				
				else{
					to_date=getLabel("Common.todate.label","Common");
					from_date =getLabel("Common.fromdate.label","Common");
				}
				
				alert(msgArray[0]+from_date+(msgArray[1])+to_date+(msgArray[2]));
				return false;
			}
			//Added by lakshmi against SKR-SCF-0540 and RUT-SCF-0165 starts here
			if(formObj.p_report_id.value == "OTRORBKG")
				return true;
			//Added by lakshmi against SKR-SCF-0540 and RUT-SCF-0165 ends here
			var val_flag=cehckSysdate(fromobj,toobj)
				
			if(val_flag==false){
				return false;
			} 
		}
	}

	return true;
}

function cehckSysdate(from_obj,to_obj){	
	var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
	var msgArray = msg.split("#");
	var curr_date=getLabel("Common.CurrentDate.label","Common");
	var from_date =getLabel("Common.fromdate.label","Common");
	var to_date =getLabel("Common.todate.label","Common");
	var formObj = f_query_rep.document.OtReportOptionsForm;
	var locale=formObj.locale.value;
	var sql="select sysdate from dual";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);

	var sys_date=retVal.split(" ");
	var date_form=sys_date[0].split("-");
	//Modified by DhanasekarV against issue IN026581
	var time_form = sys_date[1].split(":");
	var sys_date=date_form[2]+"/"+date_form[1]+"/"+date_form[0];
	var sys_time= time_form[0]+":"+time_form[1]; 
	var verify_from = from_obj.split(" ");	
	
	if(verify_from[1] == "00:00") 
		sys_date = sys_date+" 00:00";	
	else
	sys_date = sys_date+" "+sys_time;

	
	var from_th_date=convertDate(from_obj,'DMYHM',locale,'en') ;
	var to_th_date=convertDate(to_obj,'DMYHM',locale,'en') ;

  	var from_validate_flag = compareDates(from_th_date,sys_date,locale,'DMYHM');
	var to_validate_flag = compareDates(to_th_date,sys_date,locale,'DMYHM');

		if(from_validate_flag==false || to_validate_flag==false ){
			if(formObj.p_report_id.value =='OTROPTPSP'){		
				var from_date =getLabel("eOT.FromOperationDate.Label","OT");
				var to_date =getLabel("eOT.ToOperationDate.Label","OT");
				alert(msgArray[0]+from_date+""+to_date+(msgArray[1])+curr_date);
			}
			else{
				alert(msgArray[0]+from_date+" OR "+to_date+(msgArray[1])+curr_date);
			}
			return false;
		}
		return true;

}

function CaseSlipRun(){

	OtReportOptionsForm.submit();
	const diagElement = parent.document.getElementsByTagName("dialog");
    var i = 0; var j = 0;
    for (i = 0; i < diagElement.length; i++) {
    	for (j = 0; j < diagElement[i].children.length; j++) {
    		var element = diagElement[i].children[j];
    		let dialogSrc = element.src;
    		if (typeof dialogSrc !== "undefined")
    		{ 
	    		if (dialogSrc.includes("BookingReports.jsp"))
	        	{	  
	        		
	        		const dialogTag = diagElement[i];    
	        	    dialogTag.close();
	        	}
    		}    		
    	} 
	}
	//window.close();
}

function reset()
{
	var formObj = f_query_rep.document.OtReportOptionsForm;
	f_query_rep.document.OtReportOptionsForm.reset();
	location.reload();//215
	if(formObj.p_report_id.value == 'OTORLIST'){
		f_query_rep.document.OtReportOptionsForm.btnLocation.disabled = true;
		f_query_rep.document.OtReportOptionsForm.location.disabled = true;
		}
}

function assignGroupBy(obj){
	//alert(obj.name);
	var formObj = f_query_rep.document.OtReportOptionsForm;
	formObj.p_report_id = obj.value;
	formObj.pgm_id		= obj.value;
}
function getTimes(obj){
	var formObj = document.OtReportOptionsForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var url="ReportsGetTimeRanges.jsp?time_range_code="+obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	retVal=xmlHttp.responseText;
	//alert(retVal);
	if(retVal!="undefined"){
		var times_arr  = retVal.split("::");	
		// NOTE: times_arr[0] is blank
		for(i=1;i<=10;i++)
			eval("formObj.time"+i).value = times_arr[i];
	}
}


async function searchCode(obj,target, tit, sql){
	var facility_id=document.forms[0].facility_id.value;
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified by rajesh forlookup issues
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	//alert("Inside searchCode -- enter tit -- "+tit+" argumentArray -- "+argumentArray);//sanjay 
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		//alert("enter "+returnedValues);//sanjay 
		target.value=arr[1];
		obj.value=arr[0];
	} else{
		target.value='';
		obj.value='';
	}
}


async function searchSurgeon(obj,target, totarget, tit, sql){

	var facility_id=document.forms[0].facility_id.value;
	//alert(sql);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
    argumentArray[4] = "2,1"; 
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	//alert("enter");
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//alert("enter"+returnedValues);
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[1];
		obj.value=arr[0];
		totarget.value=arr[0];
	}else{
	target.value='';
		obj.value='';
	}
}

async function srchCommonCode(obj,target, totarget, tit, sql){	
	var facility_id=document.forms[0].facility_id.value;
//	var tit = obj.title;
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified By Rajesh for LOokup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[1];
		obj.value=arr[0];
		totarget.value=arr[0];
	}else{
		target.value='';
		obj.value='';
	}
	
}
// Modified by rajesh for common lookup search for speciality/anaesthetist/surgeon/ward/oper_room
async function callCommonLookup(obj){
	var flag=CheckChars1(obj);
	if(flag==true)
	{
	var formObj = document.forms[0];
	var tit = obj.title;
	//var key = obj.key;
	//var param1 = obj.param1;
	//var param2 = obj.param2;
	var key = obj.getAttribute("key");
	var param1 = obj.getAttribute("param1");
	var param2 = obj.getAttribute("param2");
	var target = eval("formObj."+param1);
	var totarget = eval("formObj."+param2);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 
	
	argumentArray[0] = getSqlString(key);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;

	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		// alert("ret1:"+ret1);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[0];
		obj.value=arr[1];
		totarget.value=arr[0];
		
	}else{
		target.value='';
		obj.value='';
		totarget.value='';
	}
	}else
	{
		return;
	}
	
}
async function callCommonLookupORList(obj,obj2){

	var flag=CheckChars1(obj);
	if(flag==true)
	{
	var formObj = document.forms[0];
	//var tit = obj.title;	
	var tit = obj.getAttribute('title');
	//var key = obj.key;
	var key = obj.getAttribute('key');
	//var param1 = obj.param1;
	//var param2 = obj.param2;
	
        var param1 = obj.getAttribute('param1');
        var param2 = obj.getAttribute('param2');
	var target = eval("formObj."+param1);
	var totarget = eval("formObj."+param2);
	
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ; 
	
	argumentArray[0] = getSqlString(key);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {

		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj2.value=arr[0];
		obj.value=arr[1];

		target.value=arr[0];
		obj.value=arr[1];
		totarget.value=arr[0];
		
	}else{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		target.value='';
		obj.value='';
		obj2.value='';
		totarget.value='';
	}
	}else
	{
		return;
	}

}

// The below code is copied by Bhavani from V3 area on 14th May 2007:
function check_all_date_dmy(){
	var formObj = f_query_rep.document.OtReportOptionsForm;
	var locale = formObj.locale.value;
	var obj=formObj.P_PERIODICITY;
	var objFromYr=formObj.P_FROM_YEAR;
	var objToYr=formObj.P_TO_YEAR;
	var objFrom=formObj.P_FROM;
	var objTo=formObj.P_TO;
	var objFDate=formObj.param1;
	var objTDate=formObj.param2;
	var cur_date = getSysDate();
	var date_arr = cur_date.split("/");
	var yer = date_arr[2];
	var mseg = "";
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");		
	var all_msg = "";
	if (obj.value==""||obj.value==null){
		all_msg = msgArray[0]+getLabel("eOT.ReportPeriodicity.Label","OT")+msgArray[1]+"<BR>";
		//alert('Report Periodicity cannot be null');
	}

	if ((obj.value=='Q') ||(obj.value=='M')||(obj.value=='B')){
		if (objFrom.value==""||objFrom.value==null||objTo.value==""||objTo.value==null)  {
			//mseg ="APP-000001 Period From/To cannot be null";
			if(objFrom.value==""||objFrom.value==null)
				all_msg = all_msg+msgArray[0]+getLabel("Common.periodfrom.label","Common")+msgArray[1]+"<BR>";
			if(objTo.value==""||objTo.value==null)
				all_msg = all_msg+msgArray[0]+getLabel("Common.periodto.label","Common")+msgArray[1]+"<BR>";
		}
	}

	if (obj.value=='A' || obj.value=='Q' || obj.value=='M' || obj.value=='B'){
		if (objFromYr.value==""||objFromYr.value==null||objToYr.value==""||objToYr.value==null){
			//mseg ="APP-000001 Year Field cannot be null";
			all_msg = all_msg+all_msg+msgArray[0]+getLabel("Common.year.label","Common")+msgArray[1]+"<BR>";			
		}

	   if (objFromYr.value!=objToYr.value){
			  //mseg ="APP-000001 From Year and To Year should be the same";
			  all_msg=all_msg+getMessage("APP-OT0119","OT")+"<BR>";
	   }

	   if (objFromYr.value > yer || objToYr.value > yer ){
			//mseg ="APP-000001 From Year and To Year cannot be greater than current year";
			if (objFromYr.value > yer)
			  all_msg=all_msg+getMessage("APP-OT0120","OT")+"<BR>";
			if (objToYr.value > yer)
			  all_msg=all_msg+getMessage("APP-OT0121","OT")+"<BR>";
	   }

		/* commented by Bhavani.As != validation mentioned above will take care. APP-OT0119
	   if (objFromYr.value > objToYr.value)
	   {
			  mseg ="APP-000001 From Year cannot be greater than To Year";
			  window.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mseg;
		  //alert('From Year cannot be greater than To Year');
		  return false;
	   }
	   */
	}

if (obj.value=='D'){
	if (objFDate.value==""||objFDate.value==null||objTDate.value==""||objTDate.value==null){
		//mseg ="APP-000001 From/To Operation Date Field cannot be null";
		if (objFDate.value=="" || objFDate.value==null)
			all_msg = all_msg+msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]+"<BR>";

		if (objTDate.value=="" || objTDate.value==null)
			all_msg = all_msg+msgArray[0]+getLabel("Common.todate.label","Common")+msgArray[1]+"<BR>";
	}

        var returnVal2 = compareDates1(objFDate.value,cur_date);
		var date_msg_array = (getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT")).split("#");
		if(returnVal2==false){
			//mseg = "APP-000001 From/To Date should not be greater than current date";
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.fromdate.label","Common")+date_msg_array[1]+getLabel("Common.CurrentDate.label","Common")+date_msg_array[2]+"<BR>";
		}

		returnVal2 ="";
        returnVal2 = compareDates1(objTDate.value,cur_date);
		if(returnVal2==false){
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.todate.label","Common")+date_msg_array[1]+getLabel("Common.CurrentDate.label","Common")+date_msg_array[2]+"<BR>";
		}
		returnVal2 ="";
        returnVal2 = compareDates1(objFDate.value,objTDate.value);
		if(returnVal2==false){
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.fromdate.label","Common")+date_msg_array[1]+getLabel("Common.todate.label","Common")+date_msg_array[2]+"<BR>";
		}
}
	if(all_msg.length>0){
		  window.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+all_msg;
		  return false;
	}
}

function getSysDate(){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysDate";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return trimString(responseText);
}

function compareDates1(fromdate,todate) {
	var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi

			if(Date.parse(fromdt) > Date.parse(todt)) {
                return false;
            }
    }
	return true;
}

async function callPatientSearch(){
	var patient_id	=	document.forms[0].p_patient_id;
	var patient_name	=document.forms[0].patientname;
	var return_value =	"";
	//alert("patient_id--->"+patient_id.value)
	//return_value	=	PatientSearch();	
	document.forms[0].patientname.value="";
	return_value	=	(patient_id.value.length>0)?patient_id.value:await PatientSearch();
	if(return_value==null)  return;
	var obj=document.forms[0];
	if(return_value!=null){
		obj.p_patient_id.value	=	return_value;
	}else{
		obj.p_patient_id.value	="";
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP"));
			patient_id.value="";
			patient_name.value="";
			//date_of_birth.value="";
			//sex.value = ""; 
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			//patient name is coming with "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  at the beginning.
			const toRemove = "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  ";
			const regex = new RegExp("^" + toRemove);
		  patient_name.value = patient_name.value.replace(regex, "");
			//date_of_birth.value 	= retVal_arr[1];
			//sex.value = (retVal_arr[2]=="MALE")?male:(retVal_arr[2]=="FEMALE")?female:unknown;
	}
	document.forms[0].patientname.value=getPatientName(return_value);
}
function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.p_patient_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientname.value="";
	
}
function getPatientName(patient_id){
	var formobj=document.forms[0];
	var locale=formobj.locale.value;
	var sql="SELECT decode ('"+locale+"','en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1 FROM MP_PATIENT WHERE PATIENT_ID ='"+patient_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}


function callClearParam(obj1,obj2){
	obj1.value="";
	obj2.value="";

}

async function callAnaesthesia(obj,target){
		var all_anaes_leg=getLabel("eOT.Allanaesthesia.Label","OT");
		var locale=document.forms[0].locale.value;
		var retVal =    new String();               
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("eOT.Allanaesthesia.Label","OT")
		//sql="SELECT '"+all_anaes_leg+"' DESCRIPTION,'ALL' CODE FROM DUAL  UNION  SELECT  ANAESTHESIA_CODE CODE, INITCAP(SHORT_DESC) DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 1";	
		sql=" SELECT  ANAESTHESIA_CODE CODE, INITCAP(SHORT_DESC) DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 1 ";	
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] =CODE_DESC;
		retVal = await CommonLookup( tit, argumentArray );				
		if(retVal != null && retVal != "" ) {					
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
			document.forms[0].param7_desc.value=arr[1];					
			document.forms[0].param7.value=arr[0];
			document.forms[0].param8.value=arr[0];
		}else{
			document.forms[0].param7_desc.value="";					
			document.forms[0].param7.value="";
			document.forms[0].param8.value="";
		}
	}

//Newly Created by Rajesh for SPR-6585 for date validation...

	function isValidDate(obj){
	if(obj.value!=""){
	var	locale = document.forms[0].locale.value;	
			
	var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) {
			obj.value = "" ;
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		}
		
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}

		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
//Modified by DhanasekarV on 21/02/2011
		var str_date1;
	  if( flag != false)
		{
		str_date1 = convertDate(str_date,'DMY',locale,'en');
		arr_date = str_date1.split('/');
		}
		dt_date.setYear(arr_date[2]);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		if (flag==false){
			obj.value = "" ;
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		//Against leap year Starts
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].P_FROM_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].P_TO_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}
		if(obj.name=='param11_disp'){
			document.forms[0].param11.value=convertDate(obj.value,'DMY',locale,'en');
		}
		//param11
		}else{		
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value='';
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value='';
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value='';
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value='';
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].param1.value='';
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].param2.value='';
		}
		if(obj.name=='param11_disp'){
			document.forms[0].param11.value='';
		}
		//param11
		//Against for leap year ends
	}
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

//Newly Created by Rajesh for SPR-6585 for date validation...

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

/*function isValidMonth(obj){
	//var RE_NUM =/^\d{2}\/(19|20)\d{2}$/ //(0[1-9]|1[012])\/(19|20)\d\d 
	var RE_NUM =/^(\d{1,2})\/((19|20|25)\d{2})$/
	var str_date = obj.value;
	var dt_date = new Date();
	if(obj.value!=""){
		if(!RE_NUM.test(str_date) )	return cal_error ("Invalid date format: '" +str_date + "'. Format accepted is MM/(19|20)YY.",obj);
		if(RegExp.$1<10 && RegExp.$1.length==1 ) obj.value="0"+obj.value;
		var dt_date1= new Date(RegExp.$2,Number(RegExp.$1-1),1);
		if (RegExp.$1 < 1 || RegExp.$1 > 12) return cal_error ("Invalid month value: '" + RegExp.$1 + "'. Allowed range is 01-12.",obj);
	//	if( RegExp.$2>dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + RegExp.$2 + "'. Greater than Current Year Not Allowed .",obj);
	//	if(dt_date1>dt_date)  return cal_error ("Month value: '" +RegExp.$1 + "'. Greater than Current Month Not Allowed .",obj);
		
	}
	return true
}*/



//Included by rajesh for Roles from 5.1

async function searchRoles(obj,target,tit,sql){
	var rol_type=document.forms[0].param7.value;
	var facility_id=document.forms[0].facility_id.value;
	var sql1=sql.replace("@@",rol_type);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql1;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
    argumentArray[4] = "2,1"; 
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//alert("enter"+returnedValues);
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[1];
		obj.value=arr[0];
//		totarget.value=returnedValues[0];
	}else{
	target.value='';
		obj.value='';
	}
}

async function callDialog(param){
	var dialogTop			= "40";
	var dialogHeight		= "600";
	var dialogWidth			= "900";
	var features			= "dialogTop:"+dialogTop+"px;dialogHeight:" + dialogHeight + "px; dialogWidth:" + dialogWidth +"px;status=no";
	var arguments			= "";
//	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchResult.jsp?"+param);
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}



function checkNull(retVal){
//START FUNCTION DIARYSHCEDULE
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


/*
function callSurgeryType(){
	var obj=document.forms[0];
	var locale=obj.locale.value;
	var column_sizes = escape("60%,20%,10%");        
	var srgry_type_desc=getLabel('Common.SurgeryType.label','Common')+" "+getLabel('Common.description.label','Common');
	var elec_emer=getLabel('Common.elective.label','Common')+"/"+getLabel('Common.emergency.label','Common');
	var tit = srgry_type_desc+','+getLabel('Common.SurgeryType.label','Common')+','+elec_emer;
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, NATURE_CODE  NATURE_CODE1, NATURE_TYPE NATURE_TYPE1 FROM OT_NATURE_OF_SURGERY WHERE NVL(STATUS,'E') = 'E'");
	var title=getLabel("Common.SurgeryType.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		obj.param7_desc.value=arr[0];
		obj.param8.value=arr[1];
		obj.param7.value=arr[2];	
	}else{
		obj.param7_desc.value="";
		obj.param8.value="";
		obj.param7.value="";	
	}
}


*/

async function callSurgeryType(){

   
	var column_sizes = escape("40%,20%,10%,20%,10%");             
	var surg_type_desc=document.forms[0].param7_desc.value
	var srgry_type_desc=getLabel('Common.SurgeryType.label','Common')+" "+getLabel('Common.description.label','Common');
	var elec_emer=getLabel('Common.elective.label','Common')+"/"+getLabel('Common.emergency.label','Common');
	var tit = srgry_type_desc+','+getLabel('Common.SurgeryType.label','Common')+','+elec_emer; 
	var column_descriptions = encodeURIComponent(tit);   
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1, NATURE_CODE  NATURE_CODE1, decode(NATURE_TYPE,'EL','Elective','EM','Emergency') NATURE_TYPE1 FROM OT_NATURE_OF_SURGERY ");
	var title=getLabel("Common.SurgeryType.label","Common");
	title=encodeURIComponent(title); 
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal= await callDialog(param);
	
	
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		arr[2]="";
		}
		//alert(arr[2])
		if(arr[2]=="EL"){
			arr[2]=getLabel('Common.elective.label','Common');
		}else{
			arr[2]=getLabel('Common.emergency.label','Common');
		}
		obj.param7_desc.value=arr[0];
		obj.param8.value=arr[1];
		obj.param7.value=arr[2];	
	}else{
		obj.param7_desc.value="";
		obj.param8.value="";
		obj.param7.value="";	
	}
}




function CheckForSpecChars_local(event)
{   
    var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+~`!@#$(){}[]|:;',/\"&<>?^\\ ";  

    var whichCode = (window.Event) ? event.which : event.keyCode;
	//alert("whichCode===="+whichCode)
    key = String.fromCharCode(whichCode); 
	

	if(event.keyCode<200)
	{
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;
	}
	return true ;
}
function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            //if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10) ||(str.charCodeAt(u)>200));
			if(str.charCodeAt(u)==37)
			{
				specCharsExist = true;
                break;
			}
			/*
			Special Characters keycodes are below 200 only. for other language like thai charcters should work properly for that purpose  (str.charCodeAt(u)>200) condition given. added by sathsh against CRF-0783
			*/     
        }
		//alert("specCharsExist==="+specCharsExist)
        return specCharsExist;
    }
	function CheckChars1(obj)
	{  //alert("obj==="+obj.value) 
	   var specCharsExist=CheckChars2(obj);
       //alert(specCharsExist)
	   
	   if(specCharsExist==true) 
		{
		 alert("% Character not allowed");
		 //alert(getMessage("APP-OT0162","OT"));
		
		  obj.focus();
	      return;
		}
		else{
			return true;
		}
	}

function isValidDateTime(obj){

	if(obj.value!=""){
		var str=obj.value;
		var dflag=true;
		var tflag=true;
		var dateValArr = str.split(' ');
		if (dateValArr.length != 2) 
			{
			 alert(getMessage('INVALID_DATE_FMT','SM'));			 
			 obj.focus();
			}
			else
			{
			 dflag=checkDate(dateValArr[0]);
			 tflag=checkTime(dateValArr[1]);
			 if(dflag==true && tflag==true)
				{
				}
				else
					{
					 obj.focus();
					}
			}
		
		
	}

}	

function checkDate(objval)
{
	//alert('checkdate -Otreports.js');

		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = objval;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) 
			{
			alert(getMessage('INVALID_DATE_FMT','SM'));		
			flag=false;
		}
		else
		{//flag=false;
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (arr_date[0].length!=2) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (arr_date[1].length!=2) flag=false;
		if (!arr_date[2]) flag=false;
		if (!RE_NUM.exec(arr_date[2])) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);

		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);

		//alert(dt_date.getMonth()+ " and  " + (arr_date[1]-1));
			
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		
		if (flag==false){
				alert(getMessage('INVALID_DATE_FMT','SM'));			 
			}
		}
		return flag;
}

function checkTime(field)
  {
    var errorMsg = "";
    // regular expression to match required time format
    re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
    var flag=true;
    if(field.value != '') {
      if(regs = field.match(re)) {
        if(regs[4]) {
          // 12-hour time format with am/pm
          if(regs[1] < 1 || regs[1] > 12 || regs[1].length!=2) {
				  alert(getMessage('INVALID_DATE_FMT','SM'))
					  flag=false;
          }
        } else {
          // 24-hour time format
          if(regs[1] > 23  || regs[1].length!=2) {
			  alert(getMessage('INVALID_DATE_FMT','SM'));	
			   flag=false;
          }
        }
        if(!errorMsg && regs[2] > 59) {
			 alert(getMessage('INVALID_DATE_FMT','SM'));	
			  flag=false;
        }
      } else {
			 alert(getMessage('INVALID_DATE_FMT','SM'));	
			  flag=false;
      }
    }

    if(errorMsg != "") {
      alert(errorMsg);
      return false;
    }
    
    return flag;
  }
//215 starts  
function doDate(obj)
{
	if(obj.value!='')
	{
		if(!validDateObj(obj,'DMY',localeName))
		{
			obj.select();
		}
		else
		{
		if(isBeforeNow(obj.value,"DMY",localeName))
		return true;
	else {
		alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
					obj.select();
					return false ;
	 }
	}
	}
}
//215 ends


