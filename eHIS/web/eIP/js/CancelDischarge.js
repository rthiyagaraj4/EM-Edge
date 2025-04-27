function tab_click(objName)
{
	
	if (objName == 'discharge_details')
	{
		//document.getElementById("tab1").scrollIntoView();
		document.getElementById("discharge_dtl").style.display = 'inline';
		document.getElementById("addl_dtl").style.display = 'none';
	}
    else if (objName == 'additional_details' )
	{
		
		//document.getElementById("tab2").scrollIntoView();
		document.getElementById("discharge_dtl").style.display = 'none';
		document.getElementById("addl_dtl").style.display = 'inline';
	}
}

async function openBedChart(objName)
{
	var nursingunit		= document.forms[0].nursing_unit_code.value;
	var specialitycode	= document.forms[0].specialty_code.value;
	var bedclasscode	= document.forms[0].bed_class_code.value;
	var bedtypecode		= document.forms[0].bed_type_code.value;
	var func_name		= "";
	var arguments		= "";
	var dialogHeight= "1200px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "10px" ;
	var status = "no";
	var features		=  "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	

	var retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=NuSyBcBt&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&call_function="+func_name,arguments,features);

	if (retVal != null)
			{
				var arr = retVal.split("^");
				
				if (arr.length > 2)
				{
					document.forms[0].cancel_discharge_bed_no.value = arr[1];
							
				}
			}
}


function checkform()
{
}

function record(obj)
{
	

	//var cancel_reason_code = parent.frames[2].document.forms[0].cancel_reason.value;
	//var cancel_bed_no = parent.frames[2].document.forms[0].cancel_discharge_bed_no.value;
	//var cancel_pract_id = parent.frames[2].document.forms[0].cancel_pract_id.value;

		
	var fields = new Array (
							parent.frames[2].document.forms[0].cancel_reason,
							parent.frames[2].document.forms[0].cancel_discharge_bed_no,
							parent.frames[2].document.forms[0].cancel_pract_id
							);

	var names = new Array ( 
						   getLabel("Common.ReasonforCancellation.label","Common"),
						   getLabel("Common.bedno.label","Common"),
						   getLabel("Common.cancelledby.label","Common")		
						   );
	if(parent.frames[2].checkFields( fields, names, parent.message_frame)) 
	{
		if(checkBedEffStatus()) //Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074
		{
			var vals = "";
			vals = "<html><body onKeyDown='lockKey()'><form name='inter_form' id='inter_form' method='post' action='../../servlet/eIP.CancelDischargePatientServlet' >";
					
			for(var i=0;i<parent.frames[2].document.forms[0].elements.length;i++)
			{
				vals += "<input type='hidden' name='"+parent.frames[2].document.forms[0].elements[i].name+"' id='"+parent.frames[2].document.forms[0].elements[i].name+"'value='"+parent.frames[2].document.forms[0].elements[i].value+"'>"
			}
			vals += "</form></body><html>";
			parent.frames[4].document.write(vals);			
			parent.frames[4].document.inter_form.submit();
		}
	}

	

	/*if(cancel_reason_code=="" || cancel_reason_code==null)
	{
		var msg = getMessage("CANCEL_REAS_NOT_BLNK","IP");
		parent.message_frame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;	
		return false;
	}

	if(cancel_bed_no=="" || cancel_bed_no==null)
	{
		var msg = getMessage("BED_NO_NOTNULL","IP");
		parent.message_frame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;	
		return false;
	}*/
	
}


function onSuccess()
{
	
}

function BeforeGetPractID1(obj1,obj2)
{
	//if(document.forms[0].cancel_pract.value!="")
		//getPractitioner(obj1,obj2,'','Q7');	

	var facility_id       = document.forms[0].facility_id.value
	var splty             = document.forms[0].specialty_code.value;
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;	
	
	if(document.forms[0].cancel_pract.value!="")
		getPractitioner(obj1,obj2,facility_id,splty,nursing_unit_code,'Q5');		
}

function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName=='cancel_pract')
		{
			document.forms[0].cancel_pract_id.value=arr[0];
			document.forms[0].cancel_pract.value=arr[1];

		}		

	}
	else
	{
		if(objName=='cancel_pract'){
		
			document.forms[0].cancel_pract_id.value="";
			document.forms[0].cancel_pract.value="";
		}
	}
	
}

/*Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
function checkBedEffStatus()
{
	var dischrg_bed_no		= parent.frames[2].document.forms[0].cancel_discharge_bed_no.value;
	var nursing_unit_code	= parent.frames[2].document.forms[0].nursing_unit_code.value;
	var facility_id			= parent.frames[2].document.forms[0].facility_id.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr="<root><SEARCH dischrg_bed_no=\""+dischrg_bed_no+"\" nursing_unit_code=\""+nursing_unit_code+"\" facility_id=\""+facility_id+"\" action='validateBedNo' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var eff_status = trimString(responseText);

	if(eff_status == 'D')
	{
		alert(getMessage("BED_DISABLED",'AE'));
		return false;
	}else
	{
		return true;
	}
}
/*End ML-MMOH-CRF-1074*/



