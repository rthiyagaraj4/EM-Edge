function checkOutstdAmtExists(patient_Id,called_from){
	var authYN;	
	var v_episode_type='';
	//var patient_Id=document.forms[0].PatientId.value;
	//var called_from=document.forms[0].p_module_id.value;
	
	//alert("patient_Id/called_from "+patient_Id+"/"+called_from);
	$.ajax({
		type:"POST",
		url:"../../eBL/jsp/BLMedRepOutStdAmt.jsp?patientId="+patient_Id+"&called_from="+called_from,
		dataType:"text",
		async:false,
		success: function(data){
			authYN = $.trim(data);
		},
		 error: function(data){
			 alert(data);
	      }
	});
	
	if(called_from=='MR'){
		v_episode_type='O';
	}
	
	if(authYN=='N'){
		var retVal				= new String();
//		var dialogTop			= "20";
		var dialogHeight		= "20" ;
		var dialogWidth			= "40" ;
		var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var param = "patient_id="+patient_Id+"&calling_module_id="+called_from+"&v_episode_type="+v_episode_type;
	retVal=window.showModalDialog("../../eBL/jsp/dispCreditAuth.jsp?"+param,arguments,features);
	return 'N';
	}
	else if(authYN=='Y'){
		return 'Y';		
	}
	
	
}
