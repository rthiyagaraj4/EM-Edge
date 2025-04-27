/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        Description
----------------------------------------------------------------------------------------------------------------------------------           
03/10/2016    IN06040      	  Mukesh M    For MMS-DM-CRF-0517,New report “List of Items Not Created in Drug Master” is required to 
										  identify items which have been created in ST but not created in PH Drug Setup.
										  
----------------------------------------------------------------------------------------------------------------------------------
-->
*/ 
 
 function run() {
	 	
	 	var frmObject = f_query_add_mod.document.formListOfItemsNotCreatedInDrugMaster;		
		var fields= new Array (frmObject.dt_from,frmObject.dt_to);
		var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));		 
		if(checkFields(fields,names,messageFrame)) {
		 	
		 	 if(!isBefore(frmObject.dt_to.value,frmObject.sys_date.value,"DMY",frmObject.p_language_id.value)) {
		 	
					var	errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
					alert(errors);
					return false;
				}
			
		  	
			 if(!isBefore(frmObject.dt_from.value,frmObject.dt_to.value,"DMY",frmObject.p_language_id.value)) {
			
					var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
					alert(errors);
					return false;			
			 	}
		
			 
		 	
		 	 var max_days=daysBetween(frmObject.dt_from.value,frmObject.dt_to.value,"DMY",frmObject.p_language_id.value);
				if(max_days>7){
					
					var errors=getMessage('PH_DRUG_DATE_DIFFERENCE','PH');
					alert(errors);
					return false;
				}
		frmObject.P_FRDATE.value =	frmObject.dt_from.value;	
		frmObject.P_TODATE.value =	frmObject.dt_to.value;	
		f_query_add_mod.document.formListOfItemsNotCreatedInDrugMaster.action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.formListOfItemsNotCreatedInDrugMaster.submit();
		
		} 
	
}

	// the below method is used for leap year calculation
function CheckDateLeap1(obj){
		var locale=document.formListOfItemsNotCreatedInDrugMaster.p_language_id.value;
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}
function reset() {
    f_query_add_mod.formListOfItemsNotCreatedInDrugMaster.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

