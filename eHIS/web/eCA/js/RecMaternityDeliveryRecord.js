/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
13/03/2014  IN047666	Chowminya	In Delivery Record screen, select value in field list then delete the value and record 	
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function callPractSearch(obj,target){ //Function for practitioner search.
	
	var practName_FName="";
	var practName_FValue="";	
	var facility_id = document.recMatDeliveryRecordForm.facility_id.value;
	var sqlSec="";
	practName_FName=target.name;
	practName_FValue=target.value;	
	
	//Modified by Ambiga.M for 18848 on 2/8/2010
	sql="SELECT a.practitioner_id practitioner_id, a.practitioner_name,d.position_code dummy,(CASE  WHEN a.pract_type IS NOT NULL       THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL END) practitioner_type, am_get_desc.am_speciality (d.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (d.position_code, '"+localeName+"', 1) job_title  FROM am_practitioner_lang_vw a, am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.pract_type LIKE (?) AND d.facility_id = nvl('"+facility_id+"',d.facility_id)  AND a.practitioner_id = d.practitioner_id   AND UPPER (d.primary_speciality_code) like nvl(replace(?,'%',''),UPPER (a.primary_speciality_code)) AND (UPPER (a.practitioner_id) like UPPER (nvl(?,a.practitioner_id))  OR UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (d.position_code, '123')) LIKE  UPPER (NVL (?, NVL (d.position_code, '123'))) order by 2 ";

	sqlSec="SELECT a.practitioner_id practitioner_id, a.practitioner_name,d.position_code dummy,(CASE  WHEN a.pract_type IS NOT NULL  THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL   END ) practitioner_type, am_get_desc.am_speciality (d.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (d.position_code, '"+localeName+"', 1) job_title   FROM am_practitioner_lang_vw a, am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.pract_type LIKE (?)    AND d.facility_id = nvl('"+facility_id+"',d.facility_id)  AND a.practitioner_id = d.practitioner_id   AND UPPER (d.primary_speciality_code) like nvl(replace(?,'%',''),UPPER (a.primary_speciality_code)) AND (UPPER (a.practitioner_id) like UPPER (nvl(?,a.practitioner_id))  AND UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (d.position_code, '123')) LIKE  UPPER (NVL (?, NVL (d.position_code, '123'))) order by 2 ";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + ""+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);			
}
function getattndpract () // function to call callpractsearch if the text field is empty.
{	
	var formObj = document.recMatDeliveryRecordForm;
	//IN047666 added else condition
	if (formObj.attend_practid_desc.value !="")
	{
		callPractSearch(formObj.pract_id_search1,formObj.attend_practid_desc); 			
		//fixvaluespractitioner();
	}
	else
	{
		formObj.attend_practid_desc.value="";
		formObj.attend_pract_id.value="";
	}
}
function fixvaluespractitioner() //used to set the practitioner information obtained from callpractsearch function.
{
	var formObj = document.recMatDeliveryRecordForm;
	formObj.attend_practid_desc.value=formObj.temp_desc.value;
	formObj.attend_physician_id.value=formObj.temp_physician_id.value;
	formObj.temp_desc.value="";
	//formObj.temp_physician_job_title.value="";
}

function attendingNurse(target)
{
	var formObj = document.recMatDeliveryRecordForm;
	//var att_nurse_newborn_hd=formObj.att_nurse_newborn_hd.value;
	var att_nurse_newborn=formObj.att_nurse_newborn.value;
//	if((target.type=='text' && target.value!='' && att_nurse_newborn_hd!=att_nurse_newborn) || target.type=='button' && (att_nurse_newborn_hd!=att_nurse_newborn || att_nurse_newborn=='')){
	var facility_id=formObj.facility_id.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eMP.AttendingNurse.label","MP")
       
	sql = "SELECT  a.Practitioner_Id code, b.practitioner_name description  FROM am_pract_for_facility a , am_practitioner_lang_vw b  WHERE a.eff_status = 'E'   AND b.eff_status = 'E'   AND a.facility_id = '"+facility_id+"'   AND pract_type IN ('MW','NS')  AND a.PRACTITIONER_ID = b.PRACTITIONER_ID    AND upper(a.Practitioner_Id) like upper(?)  AND upper(b.practitioner_name) like upper(?) AND language_id='"+localeName+"'";	

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";	
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;
	retVal = await CommonLookup( tit, argumentArray );
	var arr=new Array();

	if(retVal != null && retVal != "" )
	{

		var retVal=unescape(retVal);
		
		 arr=retVal.split(",");
		 formObj.att_nurse_newborn.value=arr[1];
		 formObj.attend_nurse_id.value=arr[0];
		 //formObj.att_nurse_newborn_hd.value=arr[1];			
	}
	else
		{
		formObj.att_nurse_newborn.value="";
		formObj.attend_nurse_id.value="";
		}
	//}
}

function chkprocclass() //Call procClass function if the description field is empty
{
	var formObj = document.recMatDeliveryRecordForm;
	//IN047666 added else condition
	if(formObj.proc_class_desc.value != "") 
	{		
		procClass(formObj.proc_id,formObj.proc_class_desc); 
	}
	else
	{
		formObj.proc_class_desc.value="";					
		formObj.proc_classification.value="";
	}	
}

function procClass(obj,target) //Function to obtain Procedure classification
{
	var formObj = document.recMatDeliveryRecordForm;	
	//var proc_class_desc_hd=formObj.proc_class_desc_hd.value;
	var proc_class_desc=formObj.proc_class_desc.value;
	/*if(proc_class_desc_hd!=proc_class_desc || proc_class_desc=='')
	{	*/
		var retVal =    new String();               
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		var tit="";				
		var tit=getLabel("eMP.ProcedureClassification.label","MP");	

		 sql="Select proc_class_code code,short_desc description from mp_proc_classification_lang_vw where eff_status='E' and upper(proc_class_code) like upper(?) and upper(short_desc) like upper(?) and language_id='"+localeName+"'";	  

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = CODE_DESC;

		retVal = await CommonLookup( tit, argumentArray );				
		if(retVal != null && retVal != "" )
		{					
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			formObj.proc_class_desc.value=arr[1];					
			formObj.proc_classification.value=arr[0];
			//formObj.proc_class_desc_hd.value=arr[1];
		}
		else{
			formObj.proc_class_desc.value="";					
			formObj.proc_classification.value="";
		}
	//}
}

function chkdelsurgclass() //Call delSurgClass if the corresponding text field is empty
{
	var formObj = document.recMatDeliveryRecordForm;	
	//IN047666 added else condition
	if (formObj.del_serv_desc.value != "")
	{ 
		delSurgClass(formObj.del_serv_id,formObj.del_serv_desc); 
	}
	else
	{
		formObj.del_serv_desc.value="";					
		formObj.del_surg_classification.value="";
	}	
	
}

function delSurgClass(obj,target) //Function to obtain Delivery Surgical Classification
{
	var formObj = document.recMatDeliveryRecordForm;		
	var del_serv_desc=formObj.del_serv_desc.value;
		//if(del_serv_desc_hd!=del_serv_desc || del_serv_desc==''){
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var tit=getLabel("eMP.DeliverySurgicalClassification.label","MP")
	 sql="Select dely_surg_class_code code,short_desc description from mp_dely_surg_clfn_lang_vw where eff_status='E' and upper(dely_surg_class_code) like upper(?) and upper(short_desc) like upper(?) and language_id='"+localeName+"'";		
	 
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;
  
	retVal = await CommonLookup( tit, argumentArray);				
	
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		formObj.del_serv_desc.value=arr[1];					
		formObj.del_surg_classification.value=arr[0];	
	}
	else{
		formObj.del_serv_desc.value="";					
		formObj.del_surg_classification.value="";
	}
//}
}

function chkvagclass() //call bagclass if the description field is empty
{
	var formObj = document.recMatDeliveryRecordForm;	
	//IN047666 added else condition
	if (formObj.vaginal_del_type_desc.value != "")
	{
		vagClass(formObj.vaginal_del_type_search, formObj.vaginal_del_type_desc);
	}
	else
	{
		formObj.vaginal_del_type_desc.value="";					
		formObj.vaginal_delivery_type.value="";	
	}
}

function vagClass(obj,target) //Function to populate vaginal delivery type
{
	var formObj = document.recMatDeliveryRecordForm;	
	var vaginal_del_type_desc=formObj.vaginal_del_type_desc.value;
//		if(vaginal_del_type_desc_hd!=vaginal_del_type_desc || vaginal_del_type_desc=='' ){
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var tit=getLabel("eMP.VaginalDeliveryType.label","MP")
	sql="SELECT VAG_DELY_TYPE code, short_desc description FROM mp_vaginal_dely_type_lang_vw WHERE eff_status = 'E' AND upper(vag_dely_type) LIKE upper(?) AND upper(short_desc) LIKE upper(?) and language_id='"+localeName+"'";					
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );				
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		formObj.vaginal_del_type_desc.value=arr[1];					
		formObj.vaginal_delivery_type.value=arr[0];
		//formObj.vaginal_del_type_desc_hd.value=arr[1];
	}
	else{
		formObj.vaginal_del_type_desc.value="";					
		formObj.vaginal_delivery_type.value="";
		}
	//}
}

function compDelievary1(obj,callFrom) 
{	
	//IN047666 added else condition
	var formObj = document.recMatDeliveryRecordForm;
	if (obj.value != "")
	{
		compDelievary(obj,callFrom);
	}
	else
	{
		if (callFrom == "comple_of_button")
		{
			
			formObj.comple_ofdel_newborn.value="";
			formObj.comp_of_delivery.value="";
		}
		else if (callFrom == "foetus_comple_of_button")
		{
			formObj.foetus_comple_ofdel_newborn.value="";
			formObj.foetus_comp_of_delivery.value="";
		}	
	}
}

function compDelievary(target,callFrom)
{
	var formObj = document.recMatDeliveryRecordForm;	
	var tit = "";
	var facility_id=formObj.facility_id.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (callFrom == "comple_of_button")
	{
		tit=getLabel("eCA.ComplicationofDelivery.label","CA");
		sql = "select compln_dely_code code, short_desc description from mp_compln_delivery_lang_vw where eff_status = 'E'	 and upper(compln_dely_code) like upper(?) and upper(short_desc) like upper(?)  and  language_id='"+localeName+"' and COMPLN_DELY_TYPE='M'";	
	}else if (callFrom == "foetus_comple_of_button")
	{
		tit=getLabel("eCA.FoetusComplicationofDelivery.label","CA");
		sql = "select compln_dely_code code, short_desc description from mp_compln_delivery_lang_vw where eff_status = 'E'	 and upper(compln_dely_code) like upper(?) and upper(short_desc) like upper(?) and language_id='"+localeName+"' and COMPLN_DELY_TYPE='F' ";	
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";		
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;
	retVal = await CommonLookup( tit, argumentArray );
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		var retVal=unescape(retVal);		
		 arr=retVal.split(",");
		 if (callFrom == "comple_of_button")
		{
			formObj.comple_ofdel_newborn.value=arr[1];
			formObj.comp_of_delivery.value=arr[0];
		}else if (callFrom == "foetus_comple_of_button")
		{
			formObj.foetus_comple_ofdel_newborn.value=arr[1];
			formObj.foetus_comp_of_delivery.value=arr[0];
		}		 
		
	}else
	{
		 if (callFrom == "comple_of_button")
		{
			formObj.comple_ofdel_newborn.value="";
			formObj.comp_of_delivery.value="";
		}else if (callFrom == "foetus_comple_of_button")
		{
			formObj.foetus_comple_ofdel_newborn.value="";
			formObj.foetus_comp_of_delivery.value="";
		}		 
	}	
}

function PractLookupRetVal(retVal,objName) //Part of callPractSearch function.
	{
		var arr;		
		if (retVal != null)
		{
			arr=retVal.split("~");				
			document.forms[0].attend_practid_desc.value=arr[1];
			document.forms[0].attend_pract_id.value=arr[0];					
		}	
		else
		{
			document.forms[0].attend_practid_desc.value="";
			document.forms[0].attend_pract_id.value="";					
		}
	}

function AllowNumbers(obj)
{	
	if ((event.keyCode < 48 || event.keyCode > 57))
			return false;		
	
	return true;

}

function record()
{	
	if(parent.recMatDeliveryDetails.document.recMatDeliveryRecordForm)
	{	
		var formobj = parent.recMatDeliveryDetails.document.recMatDeliveryRecordForm;		var finalize_yn = formobj.finalize_yn.value;					
			
		if(finalize_yn=="Y")
		{
			var fields =  new Array (formobj.delivery_type,formobj.lmp_date,formobj.no_of_birth);
			var names =  new Array (getLabel('eCA.DeliveryType.label','eCA'),getLabel('eCA.LMP.label','eCA'),getLabel('eCA.NoofBirth.label','eCA'));
		}
		else
		{
			var fields =  new Array (formobj.delivery_type,formobj.lmp_date)
			var names = new Array (getLabel('eCA.DeliveryType.label','eCA'),getLabel('eCA.LMP.label','eCA'))

		}
				
		 if(checkFields( fields, names, parent.parent.messageFrame))
		{					
			var locale = formobj.locale.value;
			var systemDate = formobj.currentDate.value;
			var LMP = formobj.lmp_date.value;
			var min_value = formobj.min_gestation.value;
			var max_value =formobj.max_gestation.value;				
			var unit_of_gest_nb =formobj.unit_of_gest_nb.value;		
			var curr_value =  "";
			if (unit_of_gest_nb == "W")
			{
				curr_value = weeksBetween(LMP,systemDate,"DMY",locale); 
			}else{
				curr_value = daysBetween(LMP,systemDate,"DMY",locale); 
			}
			
			var returnVal = validateGestation(curr_value,min_value,max_value,unit_of_gest_nb);			
			if (returnVal == "")
			{
				formobj.lmp_date.disabled= false;
				formobj.lmp_date.value = convertDate(formobj.lmp_date.value,"DMY",locale,"en");
				formobj.action="../../servlet/eCA.RecMaternityConsServlet";
				formobj.method="post";
				formobj.submit();
			}else{
				alert(returnVal);
				return false;
			}
			
		}			
	}
}

function enDisCompls(objVal) 
{
	if(objVal !="") 
	{
		var objVal1 = objVal.split("$");
		deliveryInd = objVal1[1];
		
		if(deliveryInd=='N') 
		{ 			
			document.getElementById("vaginal_del_type_desc").value="";
			document.getElementById("vaginal_delivery_type").value="";
			document.getElementById("vaginal_del_type_desc").disabled=true;
			document.getElementById("vaginal_del_type_search").disabled=true;
			document.getElementById("comple_ofdel_newborn").value = '';	
			document.getElementById("comp_of_delivery").value = '';	
			document.getElementById("comple_ofdel_newborn").disabled=true;
			document.getElementById("comple_of_button").disabled = true;
			document.getElementById("foetus_comple_ofdel_newborn").disabled = false;							
			document.getElementById("foetus_comple_of_button").disabled = false;
		//	document.getElementById("foetus_comple_ofdel_newborn").value = "";									
			//document.getElementById("comp_in_del_stage1").value = "";
			//document.getElementById("comp_in_del_stage2").value = "";
			//document.getElementById("comp_in_del_stage3").value = "";
			document.getElementById("comp_in_del_stage1").disabled = false;
			document.getElementById("comp_in_del_stage2").disabled = false;
			document.getElementById("comp_in_del_stage3").disabled = false;			
			

		} else if(deliveryInd=='C') 
		{						
			document.getElementById("comp_in_del_stage1").value = "";
			document.getElementById("comp_in_del_stage2").value = "";
			document.getElementById("comp_in_del_stage3").value = "";
			//document.getElementById("proc_classification").value="";
			//document.getElementById("del_surg_classification").value="";
			//document.getElementById("comp_of_delivery").value="";
			//document.getElementById("foetus_comp_of_delivery").value="";
			document.getElementById("proc_class_desc").disabled = false;
			document.getElementById("proc_id").disabled = false;
			document.getElementById("del_serv_desc").disabled = false;
			document.getElementById("del_serv_id").disabled = false;
			document.getElementById("comple_ofdel_newborn").disabled = false; 
			document.getElementById("comple_of_button").disabled = false;
			document.getElementById("foetus_comple_ofdel_newborn").disabled = false;							
			document.getElementById("foetus_comple_of_button").disabled = false;
			document.getElementById("comp_in_del_stage1").disabled = true;
			document.getElementById("comp_in_del_stage2").disabled = true;
			document.getElementById("comp_in_del_stage3").disabled = true;		
			document.getElementById("vaginal_del_type_desc").disabled=false;
			document.getElementById("vaginal_del_type_search").disabled=false;
		} else if(deliveryInd=='O') 
		{			
			document.getElementById("vaginal_del_type_desc").value="";
			document.getElementById("vaginal_del_type_desc").disabled=false;
			document.getElementById("vaginal_del_type_search").disabled=false;
			document.getElementById("proc_class_desc").disabled = false;
			document.getElementById("proc_id").disabled = false;
			document.getElementById("del_serv_desc").disabled = false;
			document.getElementById("del_serv_id").disabled = false;
			document.getElementById("comple_ofdel_newborn").disabled = false; 
			document.getElementById("comple_of_button").disabled = false;
			document.getElementById("foetus_comple_ofdel_newborn").disabled = false;							
			document.getElementById("foetus_comple_of_button").disabled = false;
			document.getElementById("comp_in_del_stage1").disabled = false;
			document.getElementById("comp_in_del_stage2").disabled = false;
			document.getElementById("comp_in_del_stage3").disabled = false;			

		} 
	} else 
	{			
			document.getElementById("vaginal_del_type_desc").value="";
			document.getElementById("vaginal_del_type_desc").disabled=false;
			document.getElementById("vaginal_del_type_search").disabled=false;
			document.getElementById("proc_class_desc").disabled = false;
			document.getElementById("proc_id").disabled = false;
			document.getElementById("del_serv_desc").disabled = false;
			document.getElementById("del_serv_id").disabled = false;
			document.getElementById("comple_ofdel_newborn").disabled = false; 
			document.getElementById("comple_of_button").disabled = false;
			document.getElementById("foetus_comple_ofdel_newborn").disabled = false;							
			document.getElementById("foetus_comple_of_button").disabled = false;
			document.getElementById("comp_in_del_stage1").disabled = false;
			document.getElementById("comp_in_del_stage2").disabled = false;
			document.getElementById("comp_in_del_stage3").disabled = false;
	}
}

function setFinalizeValue(obj)
{
	if (obj.checked)
	{
		obj.value = "Y";
		document.getElementById("final_mand").style.display='inline';
	}else{
		obj.value = "N";
		document.getElementById("final_mand").style.display='none';
	}
}

function closep()

{
	 parent.recMatDeliveryView.location.href = '../../eCommon/html/blank.html';
	 parent.recMatConsBtnsFrame.location.href = '../../eCommon/html/blank.html';
	
}

function allowValidNumberLocal(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //alert("APP-0001 Reached Maximum Integer value");
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '123456789';
		
    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function checkingDate(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{		
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("eCA.LMP.label","CA");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			obj.value="";
			obj.focus();
			return false;
		}		
	}
	
	}

}

function validateGestation(curr_value,min_value,max_value,unit_of_gest_nb) //Function to validate gestation period
{			
	var str = "";	
	if ((parseFloat(curr_value) < parseFloat(min_value)) || (parseFloat(curr_value) > parseFloat(max_value)))	{
			str = getMessage("RANGE_CHK_FOR_MIN_MAX","MP");		
			str = str.replace('Valid', "Calculated Gestation");
			if (unit_of_gest_nb == "W")
				unit_of_gest_nb = "Week(s)"
			else if (unit_of_gest_nb == "D")
				unit_of_gest_nb = "Day(s)"

			str = str.replace('$', min_value+" "+unit_of_gest_nb);
			str = str.replace('@', max_value+" "+unit_of_gest_nb);
			return 	str;					
	} 	
	return str;
}

