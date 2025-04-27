function reset()
		{  
			//frames[1].document.forms[0].reset();
            /*Above line commented and below line added for this CRF Bru-HIMS-CRF-367*/	
            var function_id=frames[1].document.forms[0].function_id.value;	
			frames[1].location.href = "../../eMO/jsp/MOBodyMovementQueryCriteria.jsp?function_id="+function_id;
			//frames[1].location.href = '../../eMO/jsp/MOBodyMovementQueryCriteria.jsp';
			frames[2].location.href = '../../eCommon/html/blank.html';
			frames[1].document.forms[0].search.disabled=false;
		}
function cancelOperation()
	{
		parent.window.returnValue = "";
		parent.window.close();
	}

function submitPage()
	{	 
	     if(document.forms[0].function_id.value!="ViewMovementHistory") //this line added for this CRF  Bru-HIMS-CRF-367
		 document.forms[0].search.disabled=true;
		 
		var rno = document.forms[0].registration_no.value;
		var pid = document.forms[0].patient_id.value;
		var facilityId = document.forms[0].facilityId.value; //this line added for this CRF  Bru-HIMS-CRF-367
		parent.result.location.href= "../jsp/MOBodyMovementResult.jsp?rno="+rno+"&pid="+pid+"&facilityId="+facilityId;
		
		
	}
  
  
  
  
  
  
	async function callPatient()
	{
	
		var patientid = await PatientSearch('','','','','','','Y','','Y','MO');

		if(patientid !=null)
		{
			document.getElementById("patient_id").value = patientid;
			document.getElementById("patient_id").focus();
			
		}
		else
		{
			document.getElementById("patient_id").value = '';
		}
				
	}

	async function searchCode(obj,target)
	{
			var dialogHeight   = "28" ;
			var dialogWidth	   = "43" ;
			var status		   = "no";
			var arguments	   = "" ;
			var sql			   ="";
			var search_code	   ="";
			var search_desc    ="";
			var retVal         =    new String();
			var argumentArray  =new Array(8);
           
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit			   ="";				
			var facilityId	   = "";
			facilityId		   = document.forms[0].facility_id.value;
			var fieldLegend = new Array() ;
		    fieldLegend["CODE_LEGEND"] = getLabel("Common.registrationno.label","Common");
		    fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
			if(target.name=="registration_no")
			{
				tit=getLabel("eMO.RegistrationDtls.label","MO");
				sql="select registration_no code,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_mortuary_regn_vw where facility_id='"+facilityId+"' and upper(registration_no) like upper(?) and upper(patient_name) like upper(?) order by registration_no";
				
			}
			
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				argumentArray[8] =fieldLegend
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			
			var arr	=ret1.split(",");
			
			if(target.name == 'registration_no')
				document.forms[0].registration_no.value= arr[0];
				//parent.criteria.location.href = '../../eMO/jsp/MOBodyMovementQueryCriteria.jsp?param='+arr[0];
				
		}
		else
		{	
			document.forms[0].patient_id.value= "";
		}
	}
	function clearAll()
	{
	//  parent.criteria.location.href = '../../eMO/jsp/MOBodyMovementQueryCriteria.jsp';
	  parent.result.location.href='../../eCommon/html/blank.html';
	}
 
	function enableVal(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}

	function ChangeToUpper(obj)
	{
		obj.value = obj.value.toUpperCase();
	}


