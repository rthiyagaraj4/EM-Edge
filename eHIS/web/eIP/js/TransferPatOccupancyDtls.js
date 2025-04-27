/*
	@ MODULE		:	InPatient Management..(IP)
	@ Function Name	:	Transfer -> Transfer Patient In && Transfer Patient Out 
	@ Developer		:	Ranjani
	@ Created on	:	22 Feb 2005
*/


function cancel()
{
	window.parent.close();
}

// Added by Sridhar on 2 JULY 2004
// Function chkPractRole will check whether the selected Practitioner is an Consultant Practitioner or not...IF 'Yes'.. then user will have to select another practitioner..
function chkPractRole(practID)
{
	var sStyle = document.forms[0].sStyle.value;
	var encounterId = document.forms[0].encounter_id.value;
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='practRole_form' id='practRole_form' method='post' action='../../eIP/jsp/PractIncompleteError.jsp?criteria=chkPractRole&Function=TransferPatientIn&encounter_ID="+encounterId+"&pract_ID="+practID+"'></form></BODY></HTML>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.practRole_form.submit();
}

function checkForMaxPeriod()
{
	if(parent.frames[2].document.forms[0].bed_blocking_period.value=='' || parent.frames[2].document.forms[0].bed_blocking_period.value =='0')
	{
		parent.frames[2].document.forms[0].bed_block_until.value='';		
	}
	var default_param=eval(parent.frames[2].document.forms[0].max_period.value);
	var period_no=eval(parent.frames[2].document.forms[0].bed_blocking_period.value);
	if(period_no>0)
	{
		 /*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
		if (parent.frames[2].document.forms[0].pseudo_bed.value == "Y" && parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value == "Y")
		{
			var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
			error = error.replace('$',getLabel("Common.blocked.label","Common"));
					
			alert(error);
			return false;
		}/**/else if (eval(parent.frames[2].document.forms[0].bed_blocking_period.value) > eval(parent.frames[2].document.forms[0].max_period.value))
		{	
			parent.frames[2].document.forms[0].bed_blocking_ok.value = "N";
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
//			parent.frames[1].document.getElementById("demo").scrollIntoView();
			alert(error);
			return false;
//			document.forms[0].bed_blocking_period.select();
		}
		else
		{
			parent.frames[2].document.forms[0].bed_blocking_ok.value = "Y";
			getBlockBedDate1();
		}
	}
}

//Added by kishore on 9/25/2004
function defchkMaxPeriod()
{
	//alert("defchkMaxPeriod  ***");
	if(document.forms[0].bed_blocking_period.value=='' ||document.forms[0].bed_blocking_period.value =='0')
	{	
		document.forms[0].bed_block_until.value='';
	}
	var default_param=eval(document.forms[0].max_period.value);
	var period_no=eval(document.forms[0].bed_blocking_period.value);
	if(period_no>0)
	{	
		/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
		if (parent.frames[2].document.forms[0].pseudo_bed.value == "Y" && parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value == "Y")
		{	
			var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
			error = error.replace('$',getLabel("Common.blocked.label","Common"));
					
			alert(error);
			document.getElementById('Occupancy').style.display = 'none';
			document.getElementById('Other').style.display = 'inline';
			document.getElementById('Porterage').style.display = 'none';
			document.getElementById('Medical').style.display = 'none';
			document.getElementById('Patient').style.display = 'none';
			if(document.forms[0].call_function_name.value == 'TransferPatientOut' && document.forms[0].book_conf_yn.value > 0)
				getBlockBedDate();
		}
		else if (eval(document.forms[0].bed_blocking_period.value) > eval(document.forms[0].max_period.value))
		{	
			var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
			error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
			alert(error);
			document.getElementById('Occupancy').style.display = 'none';
			document.getElementById('Other').style.display = 'inline';
			document.getElementById('Porterage').style.display = 'none';
			document.getElementById('Medical').style.display = 'none';
			document.getElementById('Patient').style.display = 'none';
			if(document.forms[0].call_function_name.value == 'TransferPatientOut' && document.forms[0].book_conf_yn.value > 0)
				setTimeout("getBlockBedDate();",200);
//			document.getElementById("demo").scrollIntoView();
//			document.forms[0].bed_blocking_period.select();
		}
		else
		{
			/*4/15/2009 commented for IN009113*/
			//document.getElementById("addr").scrollIntoView();
		}
	}

}

function getBlockBedDates()
{
	disabledef();
	defchkMaxPeriod();
}

function getBlockBedDate1()
{
	var blocking_hrs =parent.frames[2].document.forms[0].bed_blocking_period.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='"+blocking_hrs+"'> "+
	" <input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='block_date1'><input type='hidden' name='field5' id='field5' value='transfer_out'></form></body></html>";						
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dum_form.submit();
}

function CheckDateTimeValue(obj)
{
	if (obj.value != "")
	if (!doDateTimeChk(obj))
	{
		alert(getMessage("INVALID_DATE_TIME","SM"));
		return false;
	}
}

	function allowOnlyNumbers(event)
	{
		if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
			return true;
		else return false;
	}
	
	function validSpecialChars(obj)
	{	
		parent.frames[2].document.forms[0].bed_blocking_ok.value = 'Y';
		var val = obj.value.toUpperCase();			
		obj.value = val;	
		var fields=new Array();
		var names=new Array();
		fields[0]=obj;
		names[0]="Bed Blocking Period";
		if(SpecialCharCheck( fields, names,'',"A",''))
		{
			if (checkForMaxPeriod())
				{
				return true;
			}
			else
				return false;
				
		}
		else
		{
			obj.select();
			obj.focus();
			return false;
		}
	}
	
	function validateVal()
	{

		var allow_transfer=parent.frames[2].document.forms[0].reserve_bed_on_tfr_yn.value;

		var autoCnrmTfrReq	= parent.frames[2].document.forms[0].autoCnrmTfrReq.value;//Added by Thamizh selvi on 15th May 2017 for ML-MMOH-CRF-0617
		
		var fields=new Array();
		var tmpVal = "N";
		if(parent.frames[2].document.forms[0].info_pat_relatives.checked == true)
			tmpVal = "Y";
			
			if(tmpVal== "Y")
			{
				if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientIn" && parent.frames[1].document.forms[0].isArrivalDateAppl.value=="true" && parent.frames[1].document.trf_form.transfer_in_status.value == "01" ) //added by mujafar for ML-MMOH-CRF-1136
					fields[0]= parent.frames[1].document.trf_form.arrival_date;
				else
				fields[0]= parent.frames[1].document.trf_form.pref_date;
				if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientIn")
				{
				
					fields[1]= parent.frames[1].document.trf_form.transfer_in_status;
					fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
					fields[3]= parent.frames[2].document.forms[0].service;
					fields[4]= parent.frames[2].document.forms[0].Splcode_desc;
					fields[5]= parent.frames[2].document.forms[0].pract_desc;
					
					if (parent.frames[1].document.trf_form.transfer_in_status.value == "01")
					{

						fields[6]= parent.frames[2].document.forms[0].Bedcode;
						fields[7]= parent.frames[2].document.forms[0].to_bed_no;
						//fields[8]= parent.frames[2].document.forms[0].to_room_no; 
						/*Saturday, July 11, 2009 IN012178*/

						
						var names = new Array();
						if(parent.frames[1].document.forms[0].isArrivalDateAppl.value=="true" && parent.frames[1].document.trf_form.transfer_in_status.value == "01" ) //added by mujafar for ML-MMOH-CRF-1136
						names[0]	= getLabel("Common.ArrivalDateTime.label","Common");	
						else
						names[0]	= getLabel("eIP.PreferredDateTime.label","IP");
						names[1]	= getLabel("eIP.TransferInStatus.label","IP");
						names[2]	= getLabel("Common.nursingUnit.label","Common");
						names[3]	= getLabel("Common.service.label","Common");
						names[4]	= getLabel("Common.speciality.label","Common");
						names[5]	= getLabel("Common.practitioner.label","Common");
						names[6]	= getLabel("Common.BedClass.label","common");
						names[7]	= getLabel("Common.bedno.label","Common"); 
						//names[8]	= getLabel("Common.roomno.label","Common"); 
						
						var p ;
						
						if(parent.frames[1].document.trf_form.is_reserved_bed_checked && parent.frames[1].document.trf_form.is_reserved_bed_checked.value=='Y')
						{
							fields[8]	= parent.frames[1].document.trf_form.reason_for_reserved_bed;
							names[8]	= getLabel("eIP.ReasonforReserveBed.label","IP");   
							p = 9;
						}
						else
							p = 8;
							
					}
					else
					{

						var names = new Array();
						names[0]	= getLabel("eIP.PreferredDateTime.label","IP");
						names[1]	= getLabel("eIP.TransferInStatus.label","IP");
						names[2]	= getLabel("Common.nursingUnit.label","Common");
						names[3]	= getLabel("Common.service.label","Common");
						names[4]	= getLabel("Common.speciality.label","Common");
						names[5]	= getLabel("Common.practitioner.label","Common");

						var p ;
						
						if(parent.frames[1].document.trf_form.is_reserved_bed_checked && parent.frames[1].document.trf_form.is_reserved_bed_checked.value=='Y')
						{
							fields[6]	= parent.frames[1].document.trf_form.reason_for_reserved_bed;
							names[6]	= getLabel("eIP.ReasonforReserveBed.label","IP");   
							 p = 6;
						}
						else
							p = 7;
					}
				}
				else
				{

					fields[1]= parent.frames[1].document.trf_form.transfer_type_code;
					fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
					fields[3]= parent.frames[2].document.forms[0].service;
					fields[4]= parent.frames[2].document.forms[0].to_bed_class;
					fields[5]= parent.frames[2].document.forms[0].bed_type_code;
					fields[6]= parent.frames[2].document.forms[0].Splcode_desc;
					fields[7]= parent.frames[2].document.forms[0].pract_desc;
					fields[8]= parent.frames[2].document.forms[0].practitioner_desc;
					fields[9]= parent.frames[2].document.forms[0].auth_date_time;
					var names = new Array ();
					names[0]=getLabel("eIP.PreferredDateTime.label","IP");
					names[1]=getLabel("eIP.ReasonforTransfer.label","IP");	
					names[2]=getLabel("Common.nursingUnit.label","Common");	
					names[3]=getLabel("Common.service.label","Common");
					names[4]=getLabel("Common.BedClass.label","common");	
					names[5]=getLabel("Common.bedtype.label","Common");
					names[6]=getLabel("Common.speciality.label","Common");
					names[7]=getLabel("Common.practitioner.label","Common");
					names[8]=getLabel("eIP.TransferringPractitioner.label","IP");
					names[9]=getLabel("eIP.DateTimeOfAuthTransfer.label","IP");
					
					
					/*Added by Thamizh selvi on 10th May 2017 for ML-MMOH-CRF-0617 Start*/
					var p = 9 ;
						
						p++;
					
						if (autoCnrmTfrReq == "Y"){	
							fields[p]= parent.frames[2].document.forms[0].to_bed_no;
							names[p]=getLabel("Common.bedno.label","Common");
							p++;

						}

						if (parent.frames[2].document.forms[0].img_informed_name.style.visibility == "visible" && parent.frames[2].document.forms[0].img_informed_to.style.visibility == "visible" )
						{
							fields[p]= parent.frames[2].document.forms[0].inform_to;
							names[p]=getLabel("eIP.InformedTo.label","IP");
							p++;
							fields[p]= parent.frames[2].document.forms[0].info_pat_name;
							names[p]=getLabel("eIP.InformedName.label","IP");
							p++;
							
						}

						fields[p]= parent.frames[2].document.forms[0].info_date_time;
						names[p]=getLabel("Common.InformedDate/Time.label","Common");

						p++;
						
						if(parent.frames[2].document.forms[0].is_reserved_bed_checked && parent.frames[2].document.forms[0].is_reserved_bed_checked.value=='Y')
						{
							fields[p]	= parent.frames[2].document.forms[0].reason_for_reserved_bed;
							names[p]	= getLabel("eIP.ReasonforReserveBed.label","IP");   
							p++;
						}

						else
							p++;
					/*End*/
				}
			}
			else
			{
				if( parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientIn")
				{
					if(parent.frames[1].document.forms[0].isArrivalDateAppl.value=="true" && parent.frames[1].document.trf_form.transfer_in_status.value == "01" ) //added by mujafar for ML-MMOH-CRF-1136
					fields[0]= parent.frames[1].document.trf_form.arrival_date;
					else
					fields[0]= parent.frames[1].document.trf_form.pref_date;
					fields[1]= parent.frames[1].document.trf_form.transfer_in_status;
					fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
					fields[3]= parent.frames[2].document.forms[0].service;
					fields[4]= parent.frames[2].document.forms[0].Splcode_desc;
					fields[5]= parent.frames[2].document.forms[0].pract_desc;
					if (parent.frames[1].document.trf_form.transfer_in_status.value == "01")
					{
						fields[6]= parent.frames[2].document.forms[0].Bedcode;
						fields[7]= parent.frames[2].document.forms[0].bed_type_code;
						fields[8]= parent.frames[2].document.forms[0].to_bed_no;
						//fields[9]= parent.frames[2].document.forms[0].to_room_no;
						/*Saturday, July 11, 2009 IN012178*/
					
						var names = new Array();
						if(parent.frames[1].document.forms[0].isArrivalDateAppl.value=="true" && parent.frames[1].document.trf_form.transfer_in_status.value == "01" ) //added by mujafar for ML-MMOH-CRF-1136
						names[0]	= getLabel("Common.ArrivalDateTime.label","Common");
						else
						names[0]= getLabel("eIP.PreferredDateTime.label","IP");
						names[1]= getLabel("eIP.TransferInStatus.label","IP");
						names[2]= getLabel("Common.nursingUnit.label","Common");
						names[3]= getLabel("Common.service.label","Common");
						names[4]= getLabel("Common.speciality.label","common");
						names[5]= getLabel("Common.practitioner.label","common");
						names[6]= getLabel("Common.bedtype.label","Common");
						names[7]= getLabel("Common.bedtype.label","Common");
						names[8]= getLabel("Common.bedno.label","Common");
						//names[9]= getLabel("Common.roomno.label","Common");

					var p ;
					}
					else
					{

						var names = new Array() 
						names[0]= getLabel("eIP.PreferredDateTime.label","IP");
						names[1]= getLabel("eIP.TransferInStatus.label","IP");
						names[2]= getLabel("Common.nursingUnit.label","Common");
						names[3]= getLabel("Common.service.label","Common");
						names[4]= getLabel("Common.speciality.label","Common");	
						names[5]=getLabel("Common.practitioner.label","Common");

						var p ;

					}
				}
				else
				{
					if(allow_transfer == 'N')
					{
						fields[0]= parent.frames[1].document.trf_form.pref_date;
						if(eval(parent.frames[2].document.forms[0].book_conf_yn.value)>0 && parent.frames[2].document.forms[0].priority_applicable_yn.value =='N')
							fields[1]= parent.frames[1].document.trf_form.transfer_type1;
						else
							fields[1]= parent.frames[1].document.trf_form.transfer_type_code;
						fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
						fields[3]= parent.frames[2].document.forms[0].service;
						fields[4]= parent.frames[2].document.forms[0].to_bed_class;
						fields[5]= parent.frames[2].document.forms[0].bed_type_code;
						fields[6]= parent.frames[2].document.forms[0].Splcode_desc;
						fields[7]= parent.frames[2].document.forms[0].pract_desc;
						fields[8]= parent.frames[2].document.forms[0].practitioner_desc;
						fields[9]= parent.frames[2].document.forms[0].auth_date_time;
						var names = new Array (getLabel("eIP.PreferredDateTime.label","IP"),
												getLabel("eIP.ReasonforTransfer.label","IP"),
												getLabel("Common.nursingUnit.label","Common"),	
												getLabel("Common.service.label","Common"),	
												getLabel("Common.BedClass.label","common"),	
												getLabel("Common.bedtype.label","Common"),	
												getLabel("Common.speciality.label","Common"),	
												getLabel("Common.practitioner.label","Common"),
												getLabel("eIP.TransferringPractitioner.label","IP"),
												getLabel("eIP.AuthorizationDateTime.label","IP"));
					var p = 10;
						
						/*Added by Thamizh selvi on 15th May 2017 for ML-MMOH-CRF-0617 Start*/
						if (autoCnrmTfrReq == "Y"){
							fields[p]= parent.frames[2].document.forms[0].to_bed_no;
							names[p]=getLabel("Common.bedno.label","Common");
							p++;
						}/*End*/
				}else
				{

					if(parent.frames[2].document.forms[0].reserve_bed_on_tfr_yn.value == 'Y' ){
					if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == true )
					{


						fields[0]= parent.frames[1].document.trf_form.pref_date;
						if(eval(parent.frames[2].document.forms[0].book_conf_yn.value)>0 && parent.frames[2].document.forms[0].priority_applicable_yn.value =='N')
							fields[1]= parent.frames[1].document.trf_form.transfer_type1;
						else
							fields[1]= parent.frames[1].document.trf_form.transfer_type_code;
							fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
							fields[3]= parent.frames[2].document.forms[0].service;
							fields[4]= parent.frames[2].document.forms[0].to_bed_class;
							fields[5]= parent.frames[2].document.forms[0].bed_type_code;
							fields[6]= parent.frames[2].document.forms[0].Splcode_desc;
							fields[7]= parent.frames[2].document.forms[0].pract_desc;
							fields[8]= parent.frames[2].document.forms[0].practitioner_desc;
							fields[9]= parent.frames[2].document.forms[0].auth_date_time;
							fields[10]= parent.frames[2].document.forms[0].reason_for_reserved_bed;
						var names = new Array (getLabel("eIP.PreferredDateTime.label","IP"),
									  getLabel("eIP.ReasonforTransfer.label","IP"),
									  getLabel("Common.nursingUnit.label","Common"),	
									  getLabel("Common.service.label","Common"),	
									  getLabel("Common.BedClass.label","common"),	
									  getLabel("Common.bedtype.label","Common"),	
									  getLabel("Common.speciality.label","Common"),	
									  getLabel("Common.practitioner.label","Common"),
									  getLabel("eIP.TransferringPractitioner.label","IP"),
									  getLabel("eIP.AuthorizationDateTime.label","IP"),
									  getLabel("eIP.ReasonforReserveBed.label","IP"));
					var p = 11;

						/*Added by Thamizh selvi on 15th May 2017 for ML-MMOH-CRF-0617 Start*/
						if (autoCnrmTfrReq == "Y"){	
							fields[p]= parent.frames[2].document.forms[0].to_bed_no;
							names[p]=getLabel("Common.bedno.label","Common");
							p++;
						}/*End*/

					}else{
						
						fields[0]= parent.frames[1].document.trf_form.pref_date;
						if(eval(parent.frames[2].document.forms[0].book_conf_yn.value)>0 && parent.frames[2].document.forms[0].priority_applicable_yn.value =='N')
							fields[1]= parent.frames[1].document.trf_form.transfer_type1;
					else
							fields[1]= parent.frames[1].document.trf_form.transfer_type_code;
							fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
							fields[3]= parent.frames[2].document.forms[0].service;
							fields[4]= parent.frames[2].document.forms[0].to_bed_class;
							fields[5]= parent.frames[2].document.forms[0].bed_type_code;
							fields[6]= parent.frames[2].document.forms[0].Splcode_desc;
							fields[7]= parent.frames[2].document.forms[0].pract_desc;
							fields[8]= parent.frames[2].document.forms[0].practitioner_desc;
							fields[9]= parent.frames[2].document.forms[0].auth_date_time;
						
					var names = new Array (getLabel("eIP.PreferredDateTime.label","IP"),
								  getLabel("eIP.ReasonforTransfer.label","IP"),
								  getLabel("Common.nursingUnit.label","Common"),	
								  getLabel("Common.service.label","Common"),	
								  getLabel("Common.BedClass.label","common"),	
								  getLabel("Common.bedtype.label","Common"),	
								  getLabel("Common.speciality.label","Common"),	
								  getLabel("Common.practitioner.label","Common"),
								  getLabel("eIP.TransferringPractitioner.label","IP"),
								  getLabel("eIP.AuthorizationDateTime.label","IP"));
					var p = 10;

							/*Added by Thamizh selvi on 15th May 2017 for ML-MMOH-CRF-0617 Start*/
							if (autoCnrmTfrReq == "Y"){	
								fields[p]= parent.frames[2].document.forms[0].to_bed_no;
								names[p]=getLabel("Common.bedno.label","Common");
								p++;
							}/*End*/
						}
				}else
					{
						

						fields[0]= parent.frames[1].document.trf_form.pref_date;
						if(eval(parent.frames[2].document.forms[0].book_conf_yn.value)>0 && parent.frames[2].document.forms[0].priority_applicable_yn.value =='N')
							fields[1]= parent.frames[1].document.trf_form.transfer_type1;
					else
							fields[1]= parent.frames[1].document.trf_form.transfer_type_code;
							fields[2]= parent.frames[2].document.forms[0].nursing_unit_desc;
							fields[3]= parent.frames[2].document.forms[0].service;
							fields[4]= parent.frames[2].document.forms[0].to_bed_class;
							fields[5]= parent.frames[2].document.forms[0].bed_type_code;
							fields[6]= parent.frames[2].document.forms[0].Splcode_desc;
							fields[7]= parent.frames[2].document.forms[0].pract_desc;
							fields[8]= parent.frames[2].document.forms[0].practitioner_desc;
							fields[9]= parent.frames[2].document.forms[0].auth_date_time;
					var names = new Array (getLabel("eIP.PreferredDateTime.label","IP"),
							getLabel("eIP.ReasonforTransfer.label","IP"),
							getLabel("Common.nursingUnit.label","Common"),	
							getLabel("Common.service.label","Common"),	
							getLabel("Common.BedClass.label","common"),	
						    getLabel("Common.bedtype.label","Common"),	
							 getLabel("Common.speciality.label","Common"),	
							getLabel("Common.practitioner.label","Common"),
							getLabel("eIP.TransferringPractitioner.label","IP"),
							getLabel("eIP.AuthorizationDateTime.label","IP"));
					var p = 10;
						
						/*Added by Thamizh selvi on 15th May 2017 for ML-MMOH-CRF-0617 Start*/
						if (autoCnrmTfrReq == "Y"){	
							fields[p]= parent.frames[2].document.forms[0].to_bed_no;
							names[p]=getLabel("Common.bedno.label","Common");
							p++;
						}/*End*/
					}
				}
				}
			}

			if(checkFields1( fields, names))
			{
				if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientIn")
				{
						
						if(parent.frames[2].document.forms[0].is_reserved_bed_checked && parent.frames[2].document.forms[0].is_reserved_bed_checked.value=='Y' && parent.frames[2].document.forms[0].reserve_bed_no.value!='' && parent.frames[2].document.forms[0].reserve_bed_no.value== parent.frames[2].document.forms[0].to_bed_no.value)
						{
							var msg = getMessage("BED_RESERVED","IP");
							msg = msg.replace("$",parent.frames[2].document.forms[0].reserve_bed_no.value);
							msg = msg + getMessage("REMOVE_RESERVE_BED","IP") + "and Reserve "+parent.frames[2].document.forms[0].fr_bed_no.value;
							alert(msg);
							parent.frames[2].document.forms[0].is_to_bed_equals_reserve_bed.value = "Y"; 
							parent.frames[2].document.forms[0].confirm_yn.value = "N"; 
							
						}				
						else if(parent.frames[2].document.forms[0].is_reserved_bed_checked && parent.frames[2].document.forms[0].is_reserved_bed_checked.value=='Y' && parent.frames[2].document.forms[0].reserve_bed_no.value!='' && parent.frames[2].document.forms[0].reserve_bed_no.value!= parent.frames[2].document.forms[0].fr_bed_no.value)
						{
							var msg =  getMessage("RESERVE_OR_RETAIN","IP");
							msg = msg.replace("$",parent.frames[2].document.forms[0].reserve_bed_no.value);
							msg = msg.replace("?",parent.frames[2].document.forms[0].reserve_bed_no.value);

							var confirmation_YN = confirm(msg);
							
							if(confirmation_YN)
								parent.frames[2].document.forms[0].confirm_yn.value = "Y"; 
							else
								parent.frames[2].document.forms[0].confirm_yn.value = "N"; 
						}


								
					if((parent.frames[2].document.forms[0].is_reserved_bed_checked && parent.frames[2].document.forms[0].is_reserved_bed_checked.value=='N' && parent.frames[2].document.forms[0].reserve_bed_no.value!='' ) || (parent.frames[2].document.forms[0].is_reserved_bed_checked && parent.frames[2].document.forms[0].is_reserved_bed_checked.value=='N' && parent.frames[2].document.forms[0].reserve_bed_no.value!='' && parent.frames[2].document.forms[0].reserve_bed_no.value== parent.frames[2].document.forms[0].to_bed_no.value))
					{
						parent.frames[2].document.forms[0].is_to_bed_equals_reserve_bed.value = "Y"; 
						alert(getMessage("RESERVE_BED_EXISTS","IP")+" "+parent.frames[2].document.forms[0].reserve_bed_no.value+" "+getMessage("REMOVE_RESERVE_BED","IP"));

					}
							
						
				}
				return true;
			}
			else
				return false;
	}

	function checkFields1( fields, names)
	{	
		document.getElementById('button_s').disabled = true;
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) 
		{	
			if(trimCheck11(fields[i].value)) {}
			else	
			{
				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
			}
		}
		if ( errors.length != 0 ) {
			alert(errors) ;
			
			document.getElementById('button_s').disabled = false;
			return false ;
		}
		return true ;
	}
	
	function trimCheck11(inString)
	{
		var startPos;
		var ch;
		startPos = 0;
		strlength = inString.length;

		for(var i=0;i<=strlength;i++) {
			ch = inString.charAt(startPos);
			if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
			}
		}
		if(startPos == inString.length) return false;
		else return true;
	}

	
	async function getNotifyDetail()
	{
		var	dialogHeight="90vh";
		var	dialogWidth="95vw";
		var	dialogTop="0vh";
		var status = "no";
		var arguments	= "" ;
		var  patient = self.document.forms[0].patient_id.value;
		var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
		var jsp_name;

		jsp_name = "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID=" + patient;

		retVal = await window.showModalDialog(jsp_name,arguments,features);

	}

	function enabledInformDate()
	{
		if (document.forms[0].inform_to.value != "")
		{
			document.forms[0].info_date_time.disabled	= false;
			document.getElementById('ondate1').disabled				= false;
			
			if ((document.forms[0].inform_to.value != "03") && (document.forms[0].info_pat_relatives.checked==true))
				document.forms[0].inform_button.disabled = false;
			else 
				document.forms[0].inform_button.disabled = true;
				document.forms[0].info_pat_name.value="";

		}
		else
		{
			document.forms[0].info_date_time.disabled	= true;
			document.getElementById('ondate1').disabled				= true;	
			document.forms[0].inform_button.disabled	= true;
			
			
		}
		
		if ((document.forms[0].inform_to.value == "01") || (document.forms[0].inform_to.value == "02"))
		{
			var informTo	= document.forms[0].inform_to.value;
			var patientid	= document.forms[0].patient_id.value;

			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/TransferValidation.jsp' ><input type='hidden' name='field1' id='field1' value='TransferOutForm'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value=\""+informTo+"\"><input type='hidden' name='field4' id='field4' value='TransferOutForm'><input type='hidden' name='field5' id='field5' value='TransferOut'></form></body></html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[3].document.dummy_form.submit();
		}
	}
	
	function enableInform()
	{
		if (document.forms[0].info_pat_relatives.checked==true)
		{
			document.forms[0].info_pat_relatives.value="Y";
			document.forms[0].inform_to.disabled		= false;
			document.forms[0].info_date_time.disabled	= true;
			document.forms[0].info_pat_name.disabled	= false;
			document.getElementById('ondate1').disabled				= true;

			document.getElementById('img_informed_date').style.visibility	 = 'visible';

		}
		else
		{
			document.forms[0].info_pat_relatives.value="N";
			document.forms[0].inform_to.disabled		= true;
			document.forms[0].info_date_time.disabled	= true;
			document.forms[0].info_pat_name.disabled	= true;
			document.forms[0].inform_button.disabled		= true;
			document.forms[0].inform_to.value			= "";
			document.forms[0].info_date_time.value		= "";
			document.forms[0].info_pat_name.value		= "";
			document.getElementById('ondate1').disabled				= true;	
			document.getElementById('img_informed_date').style.visibility	 = 'hidden';
		}
	}

	function enabledDisabled()
	{
		if(parent.frames[1].document.forms[0])
			var pr=parent.frames[1].document.forms[0].priority_chk.value;
		if(document.forms[0].call_function_hdd.value == "TransferPatientIn")
		{
			parent.frames[1].document.forms[0].transfer_in_status.focus();
		}
		else
		{
			var nRec = document.forms[0].book_conf_yn.value;
			if(nRec>0)
			{
				disableFields();
				if(pr == '')
				{
					parent.frames[1].document.forms[0].pref_date.focus();
					parent.frames[1].document.forms[0].pref_date.select();
				}
				
			}
			else
			{
				enableFields();
				if(pr == '')
				{
					parent.frames[1].document.forms[0].pref_date.focus();
					parent.frames[1].document.forms[0].pref_date.select();
				}
				else{
					if(parent.frames[1].document.forms[0])
						parent.frames[1].document.forms[0].transfer_type1.focus();
				}
			}
		}
	}
	
	function disableFields()
	{
		
		parent.frames[2].document.forms[0].nursing_unit_desc.disabled = true;
		parent.frames[2].document.forms[0].nursing_unit_lookup.disabled = true;
		parent.frames[2].document.forms[0].service.disabled = true;
		parent.frames[2].document.forms[0].service.onchange();
		parent.frames[2].document.forms[0].sub_service.disabled = true;
		parent.frames[2].document.forms[0].Splcode_desc.disabled = true;
		parent.frames[2].document.forms[0].Splcode_lookup.disabled = true;
		parent.frames[2].document.forms[0].pract_desc.disabled = true;
		parent.frames[2].document.forms[0].pract_id_search.disabled=true;

		parent.frames[2].document.forms[0].pract_desig.disabled = true;
		parent.frames[2].document.forms[0].team_id.disabled = true;
	}
	
	function enableFields()
	{
		parent.frames[2].document.forms[0].nursing_unit_desc.enabled = true;
		parent.frames[2].document.forms[0].nursing_unit_lookup.enabled = true;
		parent.frames[2].document.forms[0].service.enabled = true;
		parent.frames[2].document.forms[0].sub_service.enabled = true;
		parent.frames[2].document.forms[0].Splcode_desc.enabled = true;
		parent.frames[2].document.forms[0].Splcode_lookup.enabled = true;
		parent.frames[2].document.forms[0].pract_desc.enabled = true;
		parent.frames[2].document.forms[0].pract_id_search.enabled=true;
		parent.frames[2].document.forms[0].pract_desig.enabled = true;
		parent.frames[2].document.forms[0].team_id.enabled = true;

	}

function submit_Form()
{	

	if(parent.frames[2].document.forms[0].reserve_bed_on_tfr_yn.value == 'Y'){
	
		if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == true){
			
				parent.frames[2].document.forms[0].is_reserved_bed_checked.value = 'Y';
		}
	}
	if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientOut")
	{	
	
		//validSpecialChars(parent.frames[2].document.forms[0].bed_blocking_period);
		if(parent.frames[2].document.forms[0].bed_blocking_period.value=='' || parent.frames[2].document.forms[0].bed_blocking_period.value =='0')
		{	
	
			parent.frames[2].document.forms[0].bed_block_until.value='';		
		}
		var default_param=eval(parent.frames[2].document.forms[0].max_period.value);
		var period_no=eval(parent.frames[2].document.forms[0].bed_blocking_period.value);
	
		if(period_no>0)
		{	
	
				/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
			if (parent.frames[2].document.forms[0].pseudo_bed.value == "Y" && parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value == "Y")
			{	
				var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
				error = error.replace('$',getLabel("Common.blocked.label","Common"));
						
				alert(error);
				return true;
			}//
			else if (eval(parent.frames[2].document.forms[0].bed_blocking_period.value) > eval(parent.frames[2].document.forms[0].max_period.value))
			{	
				
				parent.frames[2].document.forms[0].bed_blocking_ok.value = "N";
				var error = getMessage('BED_BLK_PRD_CANT_EXCEED','IP');
				error = error.replace('$',getLabel("eIP.BlockPeriod.label","IP"));
				alert(error);
				return true;
			}
		
		}

	}


	else 
		parent.frames[2].document.forms[0].bed_blocking_ok.value = 'Y';

	if(parent.frames[2].document.forms[0].bed_blocking_ok.value = 'Y')
	{ 

		parent.frames[2].document.forms[0].transfer_date.value=parent.frames[1].document.trf_form.pref_date.value;
		parent.frames[2].document.forms[0].transfer_type.value=parent.frames[1].document.trf_form.transfer_type_code.value;

		if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientOut")
		{		
		
			if(eval(parent.frames[2].document.forms[0].book_conf_yn.value)>0 && parent.frames[2].document.forms[0].priority_applicable_yn.value =='N')
				parent.frames[2].document.forms[0].transfer_type.value=parent.frames[1].document.trf_form.transfer_type1.value;
		}
		else
		{
				
			checkValues();				
			parent.frames[2].document.forms[0].transfer_status.value=parent.frames[1].document.trf_form.transfer_in_status.value;
			var tfr_status	=		parent.frames[2].document.forms[0].transfer_status.value;

		}
		
		
		close_me();
		
		if(validateVal())
		{
	
		
			if (parent.frames[2].document.forms[0].fr_nursing_unit_code.value == parent.frames[2].document.forms[0].nursing_unit_code.value)
			{
				var error = getMessage('TFR_SAME_NU_NOT_ALLOW','IP');
				error = error.replace('$',getLabel("Common.nursingUnit.label","Common"));
				alert(error);
				parent.frames[2].document.forms[0].service.value="";
				parent.frames[2].document.forms[0].sub_service.value="";
				parent.frames[2].document.forms[0].nursing_unit_desc.select();
				return;
			}

			if(parent.frames[2].document.forms[0].call_function_hdd.value == "TransferPatientOut")
			{
			
				enableFields();

				if(parent.frames[2].document.forms[0].bl_operational.value == 'Y')
				{
					if(parent.frames[2].document.forms[0].bed_class_allowed.value=='Y' &&						  parent.frames[2].document.forms[0].change_bed_class_yn.value=='Y')
					BLCheckElig();
			
					else if(parent.frames[2].document.forms[0].bed_class_allowed.value=='Y' &&		parent.frames[2].document.forms[0].change_bed_class_yn.value=='N')
						if(parent.frames[2].document.forms[0].bed_change.checked==false)
							BLCheckElig();
						else
							applyone('Y','N');
					else
						applyone('Y','N');
				}
				else
				{
					applyone('Y','N');
				}
			}
			else
			{
				
				if (parent.frames[1].document.trf_form.transfer_in_status.value == "02")
				{	

					
					var status_reject=parent.frames[2].document.forms[0].cancel_reason.value;
					if(status_reject !="")
					{
						getBlockingDetails();
						
						
                
						parent.frames[2].document.forms[0].action="../../servlet/eIP.TransferPatientInServlet";
						parent.frames[2].document.forms[0].target="Dummy_frame";
						document.getElementById('button_s').disabled = true;
						
						parent.frames[2].document.forms[0].submit();	
					}
					else
					{
						var error = getMessage('CAN_NOT_BE_BLANK',"Common");
						error = error.replace('$',getLabel("Common.ReasonforRejection.label",'Common'));
						alert(error);
						document.getElementById('button_s').disabled = false; 
						return false;
						
					}
				}
				else
				{
				
					
					if(parent.frames[2].document.forms[1].port_received_yn.checked == true)
					{
						var receive_value = parent.frames[2].document.forms[1].received.value;
						if(receive_value !='')
						{  
							
							if(parent.frames[2].document.forms[0].bl_interface_yn.value == 'Y' && parent.frames[2].document.forms[0].bed_class_allowed.value == 'N')
								BLCheckElig();
							else
								applyone('Y','N');
						}
						else
						{
						var error = getMessage('CAN_NOT_BE_BLANK',"Common");
						error = error.replace('$',getLabel("eIP.ReceivedPartiallyFully.label","IP"));
						alert(error);
						document.getElementById('button_s').disabled = false;
						return false;
						}
					}
					else
					{	
							
							if(parent.frames[2].document.forms[0].bl_interface_yn.value == 'Y' && 		parent.frames[2].document.forms[0].bed_class_allowed.value=='N')
							{
								BLCheckElig();

							}
						else
						{
						   applyone('Y','N');
						}
					}
					
				}
			}
		}
		
	}

	}

function checkValues()
{

	if (parent.frames[2].document.forms[0].info_pat_relatives.checked == true)
	
		parent.frames[2].document.forms[0].info_pat_relatives.value = "Y";
	else
		parent.frames[2].document.forms[0].info_pat_relatives.value = "N";
}

function clearDesignation()
{
	if (document.forms[0].pract_desc.value == "")
		document.forms[0].pract_desig.value  = "";
}

function checkForValues(obj)
{
	
	if(obj.name != "practitioner_id")
	{
		if ((document.forms[0].nursing_unit_desc.value=="") && (document.forms[0].Splcode_desc.value==""))
		{
			
			flag = 2;
			var errorMsg = getMessage('NU_NOTNULL','IP')+'\n' + getMessage('SPLTY_NOTNULL','IP');
			alert(errorMsg);
			//document.getElementById("demo").scrollIntoView();
			/*Monday, January 25, 2010 , 18509*/
			parent.frames[2].expandCollapse('Occupancy_Details');
			document.forms[0].nursing_unit_desc.focus();
			return false;

		}
		else if (document.forms[0].nursing_unit_desc.value=="")
		{
			
			flag = 2;
			var error = getMessage('NU_NOTNULL','IP');
			alert(error);
			//document.getElementById("demo").scrollIntoView();
			/*Monday, January 25, 2010 , 18509*/
			parent.frames[2].expandCollapse('Occupancy_Details');
			document.forms[0].service.value="";
			document.forms[0].sub_service.value="";
			document.forms[0].nursing_unit_desc.focus();
			return false;
		}
		else if (document.forms[0].Splcode_desc.value=="")
		{
			
			flag = 2;
			var error = getMessage('SPLTY_NOTNULL','IP');
			alert(error);
			//document.getElementById("demo").scrollIntoView();
			/*Monday, January 25, 2010 , 18509*/
			parent.frames[2].expandCollapse('Occupancy_Details');
			document.forms[0].Splcode_desc.focus();
			return false;
		}
	}
	return true;
} // End of checkForValues.


function onServiceChange()
{
	var serviceCode = document.forms[0].service.value;
	PopulateSubService();
}
	
// Added by Sridhar on 6 APR 2004
// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..
function checkNursTxtVal(aNursingUnit, aFacilityId, aLoginUser,aPatientClass)
{   
	if(document.forms[0].nursing_unit_desc.value == ""){
			getNursingUnit(aNursingUnit, aFacilityId, aLoginUser,aPatientClass);
	}
	
}

function checkSpecTxtVal(aSpecialtID, Facility_ID)
{
	if(document.forms[0].Splcode_desc.value == "")
		getSpecialty(aSpecialtID, Facility_ID)
}

function checkPractTxtVal(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc.value == "")
		getPractitionerLocal(obj,target, aFacilityID);
}


// Added by Sridhar on 3 FEB 2004
// Function will check for empty values before calling up the common lookup func..
		
function beforeGetNursingUnit(aNursingUnit, aFacilityId, aLoginUser, aPatientClass)
{ 
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, aPatientClass)
	}
}

function beforeGetSpecialty(aSpecialtID, Facility_ID)
{
	
	if(document.forms[0].spec_desc_hid.value != document.forms[0].Splcode_desc.value)
	{
		if(document.forms[0].Splcode_desc.value =='')
			document.forms[0].Splcode.value='';
		if(document.forms[0].Splcode_desc.value!="")
			getSpecialty(aSpecialtID, Facility_ID);
	}
}

function beforeGetPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
	{
		if(document.forms[0].pract_desc.value!= "")
			getPractitionerLocal(obj,target, aFacilityID)
	}
}



// By Annadurai 26/4/2004 - start
// To check for empty values before calling up the common lookup func..
function beforeGetTransPractitioner(obj,target, aFacilityID)
{
	if(document.forms[0].practitioner_desc_hid.value != document.forms[0].practitioner_desc.value)
	{
		if(document.forms[0].practitioner_desc.value!= "")
			getPractitionerLocal(obj,target, aFacilityID)
		else
			document.forms[0].practitioner_desc_hid.value="";
	}
}

function checkPractTextVal(obj,target, aFacilityID)
{
	if(document.forms[0].practitioner_desc_hid.value == "")
		getPractitionerLocal(obj,target, aFacilityID);
}


function checkForNursing() // To check the presence of Nursing Unit.
{
	if (document.forms[0].nursing_unit_desc.value=="")
	{
		flag = 1;
		var error = getMessage('NU_NOTNULL','IP');
		alert(error);
//		document.getElementById("addr").scrollIntoView();
		return false;
		document.forms[0].nursing_unit_desc.focus();
		

	}
} // End of checkForNursing.


async function getSpecialty(aSpecialtID, Facility_ID)
{
	
	checkForNursing(); // To check for Nursing Unit.
	var code			= document.forms[0].nursing_unit_code.value;
	var desc			= document.forms[0].nursing_unit_desc.value;
	if(code !='' && desc !='')
	{
	var target			= document.forms[0].Splcode_desc;
	
	var FacilityID		= Facility_ID;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	locale=document.forms[0].locale1.value

	sql	=	"Select a.speciality_code code,a.short_desc description from am_speciality_lang_vw a, ip_nurs_unit_for_specialty b where eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and a.language_id='"+locale+"'  and upper(a.speciality_code)  like upper(?) and upper(a.short_desc) like upper(?) ";
	/*Wednesday, May 05, 2010 , modified for PE */
	//sql	=	"Select a.speciality_code code,am_get_desc.am_speciality(a.speciality_code,'"+locale+"',2) description from am_speciality a, ip_nurs_unit_for_specialty b where eff_status like ? and a.speciality_code=b.specialty_code and b.facility_id like ? and b.nursing_unit_code='"+code+"' and  upper(a.speciality_code)  like upper(?) and upper(a.short_desc) like upper(?) ";

	//tit= "'"+getLabel("Common.speciality.label","Common")+"'"	
	// below line is added for  IP_17561_TransferPatientOut_Specialty Tuesday, December 22, 2009
	var tit= getLabel("Common.speciality.label","Common")
	
	dataNameArray[0]	= "eff_status" ;
	dataValueArray[0]	= "E";
	dataTypeArray[0]	= STRING;

	dataNameArray[1]	= "b.facility_id" ;
	dataValueArray[1]	= FacilityID;
	dataTypeArray[1]	= STRING;
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3, 4";
	argumentArray[5] = aSpecialtID.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
		document.forms[0].spec_desc_hid.value = document.forms[0].Splcode_desc.value;
		document.forms[0].pract_desc.value='';
		document.forms[0].practid.value='';
		document.forms[0].team_id.value="";
	}
	else
	{
		document.forms[0].Splcode_desc.value="";
		document.forms[0].Splcode.value="";
		document.forms[0].pract_desc.value="";
		document.forms[0].practid.value="";
		document.forms[0].team_id.value="";
	}
	}
	else{
		document.forms[0].nursing_unit_desc.focus();
	return false;
	}
} // End of getSpecialty().

	function getPractitionerLocal(obj,target, aFacilityID)
	{
		if(checkForValues(obj))
		{
		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		practName_FName=target.name;
		practName_FValue=target.value;
		practId_FName=document.forms[0].practid.name;
		if(obj.name == "practitioner_id")
		{
		var nursing_unit_code	= document.forms[0].fr_nursing_unit_code.value;
		var spl_code			= document.forms[0].fr_speciality_code.value;
		}
		else
		{
		var nursing_unit_code	= document.forms[0].nursing_unit_code.value;
		var spl_code			= document.forms[0].Splcode.value;
		}
		var facility_id = aFacilityID;
		locale=document.forms[0].locale1.value

		getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");

/*
		var sql = " SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name , am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.PRIMARY_SPECIALITY_CODE specialty_code,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2 )  primary_specialty, a.gender gender,am_get_desc.am_position(a.position_code,'"+locale+"',2)  job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.practitioner_id = a.practitioner_id AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER (NVL(?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) or a.position_code is null ) AND 1 = 1 ";
		 
		var sql2 = " SELECT a.facility_id, a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name , am_get_desc.AM_PRACT_TYPE(a.PRACT_TYPE,'"+locale+"',2) practitioner_type,a.PRIMARY_SPECIALITY_CODE specialty_code,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"',2 )  primary_specialty, a.gender gender,am_get_desc.am_position(a.position_code,'"+locale+"',2)  job_title FROM am_pract_all_splty_vw a, ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facility_id+"' AND a.PRIMARY_SPECIALITY_CODE = '"+spl_code+"' AND e.practitioner_id = a.practitioner_id AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+nursing_unit_code+"' AND a.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?) AND ( UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) and UPPER (am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER (NVL(?,a.practitioner_name))) AND a.sex LIKE (?) AND (a.position_code LIKE (?) or a.position_code is null ) AND 1 = 1 ";		

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	= "<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + spl_code+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	

		*/
	  }

	} // End of getPractitioner();

	// To set the values to Attending Practitioner when using  
	// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
	function PractLookupRetVal(retVal,objName)
	{
		var arr;
		if (objName == "practitioner_desc")
		{
			if (retVal != null)
			{
				arr=retVal.split("~");
				document.forms[0].practitioner_id.value		=	arr[0];
				document.forms[0].practitioner_desc.value	=	arr[1];	
				document.forms[0].practitioner_desc_hid.value	=	arr[1];	
				chkPractRole(document.forms[0].practitioner_id.value);

			}
			else
			{
				document.forms[0].practitioner_id.value		=	"";
				document.forms[0].practitioner_desc.value	=	"";	
				document.forms[0].practitioner_desc_hid.value	=	"";	
			}
		}
		else
		{
			if (retVal != null)
			{
				arr=retVal.split("~");
				document.forms[0].practid.value=arr[0];
				document.forms[0].pract_desc.value=arr[1];	
				document.forms[0].pract_desc_hid.value = document.forms[0].pract_desc.value;
				var desig = arr[5];
				if (desig == "CC")  document.forms[0].pract_desig.value = "Chief Consultant";
				if (desig == "CO")  document.forms[0].pract_desig.value = "Consultant";
				if (desig == "RG")  document.forms[0].pract_desig.value = "Registrar";
				if (desig == "RS")  document.forms[0].pract_desig.value = "Resident";
				if (desig == "ST")  document.forms[0].pract_desig.value = "Specialist";
				if (desig == "SC")  document.forms[0].pract_desig.value = "Sr. Consultant";
				if (desig == "SR")  document.forms[0].pract_desig.value = "Sr. Resident";
				if (desig == "SP")  document.forms[0].pract_desig.value = "Sr. Specialist";
				if (desig == "TR")  document.forms[0].pract_desig.value = "Trainee";
				if (desig == "") document.forms[0].pract_desig.value = "";
				PopulateMedicalTeam();
			}
			else
			{
				document.forms[0].practid.value		= "";
				document.forms[0].pract_desc.value	= "";			
				document.forms[0].pract_desig.value = "";
			}
		}
	} // End of PractLookupRetVal().


	function fetchValForBedClass(obj){}
	
	function callHim()
	{
	document.forms[0].nursing_unit_code.value=document.forms[0].fr_nursing_unit_code.value;
	document.forms[0].practid.value=document.forms[0].fr_practitioner_id.value;
	document.forms[0].Splcode.value=document.forms[0].fr_speciality_code.value;
	var count=0
		if(count==0)
		{
			count++;
		}
	}
	
async function showPorterageDetails()
{
				
	var retVal				=    new String();
	var dialogHeight= "500px";
	var dialogWidth = "700px";
	var dialogTop	= "72";
	var status = "no";
	var wherecondn = "REVISE_LEAVE_YN";
	var arguments   = "" ;
	var features    = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	
	var arguments	= document.forms[0].porterage_hid.value;
	var sql="";
	var search_desc="";
	var tit="";

	retVal=await window.showModalDialog("../../eIP/jsp/PorterageDetails.jsp",arguments,features);

	if (!(retVal == null))
	{
		document.forms[0].porterage_hid.value = retVal;
	}
	else
	{
		document.forms[0].porterage_hid.value = "";
	}
}

function enbldisbchk(obj1)
{
	if(parent.frames[2].document.forms[0].bed_change!=null)
	{
	if(obj1.value!="")
	{
		parent.frames[2].document.forms[0].bed_change.disabled = false;
	}
	else
	if(obj1.value=="")
	{
		parent.frames[2].document.forms[0].bed_change.disabled = true;
		parent.frames[2].document.forms[0].bed_change.checked = false;
		setEnable();
	}
	}
}

	function PopulateMedicalTeam()
	{ 	
		var selected = document.forms[0].team_id;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);
		var	str1 = "" ;
		var	str2 = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		var element = parent.frames[1].document.createElement('OPTION');
		element.text = str2; 
		element.value= str1;
		document.forms[0].team_id.add(element);

		var ippractid  = document.forms[0].practid.value;
		var getservice = document.forms[0].practid.value;
		var spl_code = document.forms[0].Splcode.value;
		if (ippractid != null && ippractid != "")
		{
			var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='AssignBed'><input type='hidden' name='med_code' id='med_code' value='tfr_out'><input type='hidden' name='spy_code' id='spy_code' value='"+spl_code+"'><input type='hidden' name='prt_code' id='prt_code' value=''></form></body></html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[3].document.querydept.submit();
		}
	}

	function focusFirst()
	{
		document.forms[2].transfer_type.focus();
	}
	
	function disabledef()
	{
	if (document.forms[0].inform_to.value != "")
				document.getElementById('img_informed_date').style.visibility = "Visible";
		else	
		document.getElementById('img_informed_date').style.visibility = "Hidden";
	}

	function setReserveBedDtls()
	{
		//
		if(parent.Transfer_frame.document.EmergencyTransfer_form.call_function.value == 'Transfer_Out'){
		
			if (document.forms[0].reserved_bed_yn.checked==true) 
			{
			//alert("Entering into setReservedBedDtls **** ")
				/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
				if (document.forms[0].pseudo_bed.value == "Y" && document.forms[0].deactivate_pseudo_bed_yn.value == "Y")
				{ 
						//	alert("Entering into setReservedBedDtls **** ")
					var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
						error = error.replace('$',getLabel("Common.Reserved.label","Common"));
					
					alert(error);
					parent.Transfer_frame.document.EmergencyTransfer_form.reserved_bed_yn.checked = false;
					parent.Transfer_frame.document.EmergencyTransfer_form.is_reserved_bed_checked.value='N';
				}else
				{			
					var blocking_remarks = parent.frames[2].document.EmergencyTransfer_form.reserve_reason_code.value;
					//alert("TransferPatOccupancyDtls+1333");
					var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='c_field4' id='c_field4' value='Transfer_Out'><input type='hidden' name='blocking_remarks' id='blocking_remarks' value='"+blocking_remarks+"'></form></body></html>";
                    //   alert("TransferPatOccupancyDtls+1335");
					//parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.frames[3].document.write(HTMLVal);
					parent.Dummy_frame.document.dum_form1.submit();
					parent.Transfer_frame.document.EmergencyTransfer_form.is_reserved_bed_checked.value='Y';
					parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed.disabled=false;
					parent.Transfer_frame.document.EmergencyTransfer_form.reserved_bed_img.style.visibility='visible';
				}
			}
			else
			{
			//alert("Else part Blocking_remarks **** ");
				parent.Transfer_frame.document.EmergencyTransfer_form.is_reserved_bed_checked.value='N';
				parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed.options[0].selected = true;
				parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed.disabled=true;	
				parent.Transfer_frame.document.EmergencyTransfer_form.reserved_bed_img.style.visibility='hidden';

			}
		}
		if(parent.Transfer_frame.document.EmergencyTransfer_form.call_function.value == "Transfer_In"){
			
			/*if(document.forms[0].reserve_bed_on_tfr_yn.value == 'Y'){
					if(document.forms[0].reserved_bed_yn.checked == true){
					parent.frames[2].document.forms[0].reason_for_reserved_bed.disabled=false;
					parent.frames[2].document.forms[0].reserved_bed_img.style.visibility='visible';
				}else{
					document.forms[0].reason_for_reserved_bed.value = '';
					document.forms[0].reason_for_reserved_bed.disabled=true;
					document.forms[0].reserved_bed_img.style.visibility='hidden';
				}
			}*/
		}
	}
//Added for Transfer Patient In Validations


