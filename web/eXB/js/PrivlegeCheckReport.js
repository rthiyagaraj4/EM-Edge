/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//********************************************************************************************
//function searchBllngGrp
//*******************************************************************************************

function searchBllngGrp(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
//			var tit	= getLabel("Common.Organization.label",'Common');
			var tit	= "Billing Group";
            var target=this.document.forms[0].blng_grp_desc;
            var blng_grp_id=this.document.forms[0].p_blng_grp_id;

			sql="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE language_id='en' AND UPPER(BLNG_GRP_ID) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                blng_grp_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                org_id.value=tcode;
            }
}// End of searchOrgID

//********************************************************************************************
//function searchPolicy
//*******************************************************************************************

function searchPolicy(){
     
			var tdesc="";
            var tcode=""; 

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            //var tit= getLabel("Common.Standard.label","common");
			var tit= "Policy Type";

            var target=this.document.forms[0].policy_desc;
            var policy_code=this.document.forms[0].p_policy_type_code;

			sql="SELECT '*A' code,'ALL' description from dual UNION SELECT POLICY_TYPE_CODE code,SHORT_DESC description FROM BL_INS_POLICY_TYPES_LANG_VW WHERE LANGUAGE_ID= 'en'  AND NVL(STATUS,'N') ='N'  AND UPPER(POLICY_TYPE_CODE) LIKE UPPER(?) AND  UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";

 //           alert("sql : "+sql);
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                policy_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                policy_code.value=tcode;
            }
}// End of searchPolicy


//********************************************************************************************
//function searchStoreCode
//*******************************************************************************************

function searchStoreCode(){	   
//            alert("searchStoreCode");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.Store.label",'Common');
            var target=this.document.forms[0].store_desc;
            var store_code=this.document.forms[0].store_code;
        
			sql="SELECT '*A' code,'ALL' description from dual UNION SELECT POLICY_TYPE_CODE code,SHORT_DESC description FROM BL_INS_POLICY_TYPES_LANG_VW WHERE LANGUAGE_ID= 'en'  AND NVL(STATUS,'N') ='N'  AND UPPER(POLICY_TYPE_CODE) LIKE UPPER(?) AND  UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                store_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                store_code.value=tcode;
            }
}

function searchHospitalNo()
{     
	var tdesc="";
	var tcode="";

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit	= getLabel("Common.Organization.label",'Common');
	var tit	= "Hospital Number";
	var target=this.document.forms[0].hosp_name;
	var p_patient_id=this.document.forms[0].p_patient_id;

//	sql="SELECT PATIENT_ID code, SUBSTR(PATIENT_NAME,1,30) description FROM MP_PATIENT WHERE ROWNUM<=20  /* and language_id='en' */ and patient_id='SD00000009' AND UPPER(PATIENT_ID) LIKE UPPER(?) AND UPPER(PATIENT_NAME) LIKE UPPER(?) ORDER BY 1 ";

	sql="SELECT  patient_id code,patient_name description FROM XB_PRIVILEGES_VW WHERE UPPER(PATIENT_ID) LIKE UPPER(?) AND UPPER(PATIENT_NAME) LIKE UPPER(?)   ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
 
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=(arr[1]);
		target.value=(arr[0]);				
		p_patient_id.value=arr[0];
	}
	else
	{
		target.value=tdesc;
		p_patient_id.value=tcode;
	}
}

function run() 
{
	var billingGroup = f_query_add_mod.document.forms[0].blng_grp_desc.value;		
	
	if(billingGroup == "")
	{
		var msg = "Billing Group cannot be balnk.";		
		alert(msg);
		f_query_add_mod.document.forms[0].blng_grp_desc.focus();
		return false;
	}

	f_query_add_mod.document.dummyForm.p_records_per_page.value = f_query_add_mod.document.forms[0].p_records_per_page.value;
	f_query_add_mod.document.dummyForm.p_from_visit_adm_date.value = f_query_add_mod.document.forms[0].p_from_visit_adm_date1.value;
	f_query_add_mod.document.dummyForm.p_to_visit_adm_date.value = f_query_add_mod.document.forms[0].p_to_visit_adm_date1.value;
	f_query_add_mod.document.dummyForm.p_policy_type_code.value = f_query_add_mod.document.forms[0].p_policy_type_code.value;
	f_query_add_mod.document.dummyForm.p_encounter_id.value = f_query_add_mod.document.forms[0].p_encounter_id.value;
	f_query_add_mod.document.dummyForm.p_patient_id.value = f_query_add_mod.document.forms[0].p_patient_id.value;
	f_query_add_mod.document.dummyForm.P_Patient_Class.value = f_query_add_mod.document.forms[0].P_Patient_Class.value;
	f_query_add_mod.document.dummyForm.p_blng_grp_id.value = f_query_add_mod.document.forms[0].p_blng_grp_id.value;
	f_query_add_mod.document.dummyForm.p_from_loaded_date.value = f_query_add_mod.document.forms[0].p_from_loaded_date1.value;
	f_query_add_mod.document.dummyForm.p_to_loaded_date.value = f_query_add_mod.document.forms[0].p_to_loaded_date1.value;

	f_query_add_mod.document.dummyForm.submit();
}

function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}

function sysDateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
				alert("START_DATE_GREATER_SYSDATE");
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}

function validate_date(Obj,ref) 
{
	var formObj = document.frames.document.forms[0];
	if (CheckDate(Obj))
	{
//	 if(ref == "TO_DT_GR_EQ_FM_DT")
	 if(ref == "XB1009")		 
	{
	  from = formObj.p_to_visit_adm_date;   
	  to = formObj.p_from_visit_adm_date;
//	  error_id = getMessage("XB1009","XB");  
	  error_id = "APP-XB1009 To Date should be Greater than or equal to From Date";  
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = formObj.p_from_visit_adm_date;
	  to = formObj.p_to_visit_adm_date;
//	  error_id = getMessage("XB1009","XB"); 
	  error_id = "APP-XB1009 To Date should be Greater than or equal to From Date";  
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
		from = formObj.p_to_visit_adm_date;
		to = formObj.p_from_visit_adm_date;
//		error_id = getMessage("XB1009","XB");
	  error_id = "APP-XB1009 To Date should be Greater than or equal to From Date";  

	}
	else if(ref == "LOADED_DATE")
	{
		from = formObj.p_to_loaded_date;
		to = formObj.p_from_loaded_date;
//		error_id = getMessage("XB1009","XB");
		error_id = "APP-XB1009 To Date should be Greater than or equal to From Date";  
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			from.value="";
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}
