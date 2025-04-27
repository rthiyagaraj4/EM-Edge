function submitForm()
{
	setTimeout('submitForm1()',500);	
}
function BLCheckElig()
{
	var bed_ref = "parent.frames[1].document.forms[0].transfer_type";
	var modified_bed_type_ref ="parent.frames[2].document.forms[0].modified_bed_type_code";
	var url = parent.frames[2].location.href;
	var action_url="";
	var HTMLVal = "";

	var reasonForTransfer = parent.frames[2].document.forms[0].transfer_type.value;//Added by Dharma on 24th Oct 2017 against ML-MMOH-CRF-0865.1 [IN:065405]
	if(parent.frames[2].document.forms[0].call_function.value=='Transfer_In')
		bed_ref = "parent.frames[1].document.forms[0].transfer_type";

	if(url.indexOf("/servlet")!=-1)
	{
		HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value=\""+parent.frames[2].document.forms[0].bed_type_code.value+"\"><input type='hidden' name='field2' id='field2' value=\""+parent.frames[2].document.forms[0].billing_group_id.value+"\"><input type='hidden' name='field3' id='field3' value=\""+parent.frames[2].document.forms[0].to_bed_no.value+"\"><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value=\""+bed_ref+"\"><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/TransferPatient.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
		
	}
	else
	{
		HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummy_form1' id='dummy_form1' method='post' action='../../eIP/jsp/IPBLCheckEligibilityValidation.jsp'><input type='hidden' name='field1' id='field1' value='"+parent.frames[2].document.forms[0].bed_type_code.value+"'><input type='hidden' name='field2' id='field2' value='"+parent.frames[2].document.forms[0].billing_group_id.value+"'><input type='hidden' name='field3' id='field3' value='"+parent.frames[2].document.forms[0].to_bed_no.value+"'><input type='hidden' name='field4' id='field4' value='Transfer'><input type='hidden' name='field5' id='field5' value='"+bed_ref+"'><input type='hidden' name='field6' id='field6' value='"+modified_bed_type_ref+"'><input type='hidden' name='field7' id='field7' value='../js/TransferPatient.js'><input type='hidden' name='reasonForTransfer' id='reasonForTransfer' value='"+reasonForTransfer+"' /></form></body></html>";
	}
	//parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dummy_form1.submit();
}

function applyone(difframe,bed_class_chk)
{

/*	var function_name =parent.frames[2].document.forms[0].call_function_name.value;
	if(function_name=='TransferPatientIn')
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPatientInServlet' >";
	else
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPatientOutServlet' >";
	for(var i=0;i<parent.frames[2].document.forms[0].elements.length;i++)
		   val += "<input type='hidden' name='"+ parent.frames[2].document.forms[0].elements[i].name +"' id='"+ parent.frames[2].document.forms[0].elements[i].name +"' value='"+ parent.frames[2].document.forms[0].elements[i].value +"'>"
	
	val += "</form></body><html>";
	parent.frames[3].document.write(val);
	parent.frames[3].document.Dummy_form.submit();*/

	var function_name =parent.frames[2].document.forms[0].call_function_name.value;
	if(function_name=='TransferPatientIn')
	{
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPatientInServlet' >";


		if(parent.frames[2].document.forms[0].reserve_bed_on_tfr_yn.value == 'Y'){
			if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == true){
				parent.frames[2].document.forms[0].reserve_bed_no.value=parent.frames[2].document.forms[0].fr_bed_no.value;
				parent.frames[2].document.forms[0].reserve_room_no.value=parent.frames[2].document.forms[0].fr_room_no.value;
				parent.frames[2].document.forms[0].reserve_nurs_unit_code.value=parent.frames[2].document.forms[0].nursing_unit_code.value;
			}else{
				var to_nursing_unit=parent.frames[2].document.forms[0].nursing_unit_code.value;
				var r_nursing_unit=parent.frames[2].document.forms[0].res_nurs_unit_code.value;
				var r_nursing_unit1=parent.frames[2].document.forms[0].r_nursing_unit.value;
				
				if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == false){
					if(to_nursing_unit != r_nursing_unit){
					
						/*parent.frames[2].document.forms[0].reserve_bed_no.value='';
						parent.frames[2].document.forms[0].reserve_room_no.value='';
						parent.frames[2].document.forms[0].reserve_nurs_unit_code.value='';*/
						//parent.frames[2].document.forms[0].reserve_bed_no.value=parent.frames[2].document.forms[0].res_bed_no.value;
						parent.frames[2].document.forms[0].reserve_bed_no.value=parent.frames[2].document.forms[0].r_bed_no.value;
						//parent.frames[2].document.forms[0].reserve_room_no.value=parent.frames[2].document.forms[0].res_room_no.value;
						parent.frames[2].document.forms[0].reserve_room_no.value=parent.frames[2].document.forms[0].r_room_no.value;
						//parent.frames[2].document.forms[0].reserve_nurs_unit_code.value=parent.frames[2].document.forms[0].res_nurs_unit_code.value;
						parent.frames[2].document.forms[0].reserve_nurs_unit_code.value=parent.frames[2].document.forms[0].r_nursing_unit.value;

					}
					else{
						
						//parent.frames[2].document.forms[0].reserve_bed_no.value=parent.frames[2].document.forms[0].res_bed_no.value;
						parent.frames[2].document.forms[0].reserve_bed_no.value=parent.frames[2].document.forms[0].r_bed_no.value;
						//parent.frames[2].document.forms[0].reserve_room_no.value=parent.frames[2].document.forms[0].res_room_no.value;
						parent.frames[2].document.forms[0].reserve_room_no.value=parent.frames[2].document.forms[0].r_room_no.value;
						//parent.frames[2].document.forms[0].reserve_nurs_unit_code.value=parent.frames[2].document.forms[0].res_nurs_unit_code.value;
						parent.frames[2].document.forms[0].reserve_nurs_unit_code.value=parent.frames[2].document.forms[0].r_nursing_unit.value;
					}
				}
				
			}
		}
		
		var proceed = 'true';
		var mother_status = parent.frames[2].document.forms[0].mother_status.value;
		var transfer_wo_delink_yn = parent.frames[2].document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035
		if (mother_status != '0' && transfer_wo_delink_yn=='Y') {
			proceed=validateMotherBabyBed(parent.frames[2].document.forms[0].fr_nursing_unit_code.value,parent.frames[2].document.forms[0].nursing_unit_code.value,parent.frames[2].document.forms[0].to_bed_no.value,parent.frames[2].document.forms[0].patient_id.value)
		}

		if(proceed!='true'){
			if(confirm(getMessage("TRANSFER_NOT_POSSIBLE","IP"))){
				parent.frames[2].document.forms[0].transfer_wo_delink_yn.value='N';
				proceed='true';
			}
		}
		
		
		//parent.frames[3].document.write(val);
	}
	else
	{
		//parent.frames[2].document.forms[0].button_s.disabled = true;
		parent.Button_frame.document.getElementById('button_s').disabled = true;
		parent.frames[2].document.forms[0].bed_class_chk.value = bed_class_chk ;
		var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPatientOutServlet' >";
	}

	if(function_name=='TransferPatientOut')
	{
		CheckNUnitBedClass();
		parent.frames[1].document.trf_form.transfer_type1.disabled = false;
	}
	else
	{		
		//parent.frames[2].document.forms[0].button_s.disabled = true;
		document.getElementById('button_s').disabled = true;
    		//Following logic added (Transfer Patient In)for the CRF - HSA-CRF-0035 -- start		
	if(parent.frames[1].document.trf_form.isArrivalDateAppl.value=="true") // added by mujafar for ML-MMOH-CRF-1136
		{
		parent.frames[2].document.forms[0].arrival_date.value=parent.frames[1].document.trf_form.arrival_date.value;
		parent.frames[2].document.forms[0].isArrivalDateAppl.value=parent.frames[1].document.trf_form.isArrivalDateAppl.value;
		}
		
		if(proceed=='true'){
			for(var i=0;i<parent.frames[2].document.forms[0].elements.length;i++)
			{
				val += "<input type='hidden' name=\""+ parent.frames[2].document.forms[0].elements[i].name +"\" id=\""+ parent.frames[2].document.forms[0].elements[i].name +"\" value=\""+ parent.frames[2].document.forms[0].elements[i].value +"\">"			
			}
			val += "</form></body><html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',val);
			parent.frames[3].document.Dummy_form.submit();		
		}else{			
				parent.frames[5].button_s.disabled = false;
		}	
		//parent.frames[3].document.Dummy_form.submit();
	}
}

function CheckNUnitBedClass()
{
	

/*10/9/2008 CRF 3698 SRR20056-CRF-0228*/

	var tfr_req_status = parent.frames[2].document.forms[0].tfr_req_status.value;
	var call_function = parent.frames[2].document.forms[0].call_function.value;
	var r_bed_no=parent.frames[2].document.forms[0].r_bed_no.value;
	var r_nursing_unit=parent.frames[2].document.forms[0].r_nursing_unit.value;
	var r_nursing_unit_desc=parent.frames[2].document.forms[0].r_nursing_unit_desc.value;
	var allow_multiple_bed_for_resv_yn=parent.frames[2].document.forms[0].allow_multiple_bed_for_resv_yn.value;
	var reserve_bed_on_tfr_yn=parent.frames[2].document.forms[0].reserve_bed_on_tfr_yn.value;
	var to_bed_no_val=parent.frames[2].document.forms[0].to_bed_no_val.value;
	var to_nursing_unit=parent.frames[2].document.forms[0].nursing_unit_code.value;
	var reserved_bed_cont=parseInt(parent.frames[2].document.forms[0].reserved_bed_cont.value);
if(reserve_bed_on_tfr_yn == 'Y'){
		if(allow_multiple_bed_for_resv_yn == 'N'){
			if(/*tfr_req_status != '1' &&*/ r_bed_no == '')
			{
				if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == true){
					
					
					var valid=confirm(getMessage("RESERVED_BED_CONFIRM","IP"));
					if(valid)
					{
					parent.frames[2].document.forms[0].res_bed_no.value=parent.frames[2].document.forms[0].fr_bed_no.value;
					parent.frames[2].document.forms[0].res_room_no.value=parent.frames[2].document.forms[0].fr_room_no.value;
					parent.frames[2].document.forms[0].res_nursing_unit.value=parent.frames[2].document.forms[0].fr_nursing_unit_code.value;
					
					}
					else
					{
						/*parent.frames[2].document.forms[0].res_bed_no.value='';
						parent.frames[2].document.forms[0].res_room_no.value='';
						parent.frames[2].document.forms[0].res_nursing_unit.value='';*/
						parent.frames[5].button_s.disabled = false;
						return false;
					}
				}
			}
			//}
			else{
				if(parent.frames[2].document.forms[0].reserved_bed_yn.checked == true ){
					
					if(to_bed_no_val != r_bed_no && reserved_bed_cont > 0){
						var valid = getMessage("RESERV_BED_CONFIRM_CANCELLED","IP");
						valid = valid.replace("$",r_nursing_unit_desc);
						valid = valid.replace("#",r_bed_no);
						valid = confirm(valid);
						if(valid)
						{
							parent.frames[2].document.forms[0].res_bed_no.value='';
							parent.frames[2].document.forms[0].res_room_no.value='';
							parent.frames[2].document.forms[0].res_nursing_unit.value='';
						}else
						{
							/*parent.frames[2].document.forms[0].res_bed_no.value=parent.frames[2].document.forms[0].fr_bed_no.value;
							parent.frames[2].document.forms[0].res_room_no.value=parent.frames[2].document.forms[0].fr_room_no.value;;
							parent.frames[2].document.forms[0].res_nursing_unit.value=parent.frames[2].document.forms[0].fr_nursing_unit_code.value;*/
							parent.frames[5].button_s.disabled = false;
							return false;
						}
					}else if(to_bed_no_val == r_bed_no && to_nursing_unit != r_nursing_unit && reserved_bed_cont > 0)
					{
						var valid = getMessage("RESERV_BED_CONFIRM_CANCELLED","IP");
						valid = valid.replace("$",r_nursing_unit_desc);
						valid = valid.replace("#",r_bed_no);
						valid = confirm(valid);
						if(valid)
						{
							parent.frames[2].document.forms[0].res_bed_no.value='';
							parent.frames[2].document.forms[0].res_room_no.value='';
							parent.frames[2].document.forms[0].res_nursing_unit.value='';
						}else
						{
							parent.frames[5].button_s.disabled = false;
							return false;
						}	
					}
				}else{
						if(/*(to_bed_no_val != r_bed_no) ||*/ (to_nursing_unit != r_nursing_unit) && reserved_bed_cont > 0){
							var valid = getMessage("RESERV_BED_CANCELLED","IP");
							valid = valid.replace("$",r_nursing_unit_desc);
							valid = valid.replace("#",r_bed_no);
							valid = confirm(valid);
							if(valid){
								parent.frames[2].document.forms[0].res_bed_no.value='';
								parent.frames[2].document.forms[0].res_room_no.value='';
								parent.frames[2].document.forms[0].res_nursing_unit.value='';
							}else{
								//parent.frames[5].button_s.disabled = false;
								//return false;
								window.close();
								}
						}
				}
			}
		}
	}
/*10/9/2008 CRF 3698 SRR20056-CRF-0228*/

	var to_bed_class = parent.frames[2].document.forms[0].to_bed_class.value;
	var fr_nursing_unit_code = parent.frames[2].document.forms[0].nursing_unit_code.value;
	var to_bed_type = parent.frames[2].document.forms[0].bed_type_code.value;
	var deactivate_pseudo_bed_yn = parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value;

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_forms' id='dum_forms' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field9' id='field9' value='validateNUnitBedClass'><input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class+"'><input type='hidden' name='fr_nursing_unit_code' id='fr_nursing_unit_code' value='"+fr_nursing_unit_code+"'><input type='hidden' name='to_bed_type' id='to_bed_type' value='"+to_bed_type+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
	
	//parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dum_forms.submit();
}

function setBooleanValue(flag)
{
	
	if(flag)
	{

	var val="<html><body onKeyDown='lockKey()'><form name='Dummy_form' id='Dummy_form' method='post' action='../../servlet/eIP.TransferPatientOutServlet' >";
		for(var i=0;i<parent.frames[2].document.forms[0].elements.length;i++)
		{
			   val += "<input type='hidden' name='"+ parent.frames[2].document.forms[0].elements[i].name +"' id='"+ parent.frames[2].document.forms[0].elements[i].name +"' value=\""+ parent.frames[2].document.forms[0].elements[i].value +"\">"
		}

		val += "</form></body><html>";
		parent.frames[4].document.write(val);
		parent.frames[4].document.Dummy_form.submit();
	}
	else
	{
		alert(getMessage("BED_CLASS_NOT_MATC_NURS",'IP'));
		/*Monday, January 25, 2010 , 18509 */
		//parent.frames[2].tab_click('Occupancy_Details');
		parent.frames[2].expandCollapse('Occupancy_Details');
		parent.frames[2].document.forms[0].nursing_unit_desc.select();
		return false;
	}
}

async function callBedAvailChart()
{
	/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
	var autoCnrmTfrReq	= document.forms[0].autoCnrmTfrReq.value;
	var fnName			= document.forms[0].call_function_name.value;
	/*End*/
	
	var ipparam_bed_yn	=document.forms[0].ipparam_bed_yn.value;
	var nursingunit = self.document.forms[0].nursing_unit_code.value;
	var practitionerid = self.document.forms[0].practid.value;
	var specialitycode = self.document.forms[0].Splcode.value;
	/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
	if(autoCnrmTfrReq == "Y" && fnName == "TransferPatientOut")
		var bedclasscode = self.document.forms[0].to_bed_class.value;
	else
		var bedclasscode = self.document.forms[0].Bedcode.value;
	/*End*/
	var gender = self.document.forms[0].gender.value;
	var agevalue = self.document.forms[0].age.value;
	var bedtypecode =document.forms[0].bed_type_code.value;
	var oper_stn_id =document.forms[0].oper_stn_id.value;
	var patient_id = document.forms[0].patient_id.value;

	var age = "";
	var yr = eval(agevalue.indexOf("Y"));
	var mon = eval(agevalue.indexOf("M"));

	if(mon>=0 && yr>=0)
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}
	else if(mon >= 0)
	{
		age = agevalue.substring(0,mon);
		agevalue = "M";
	}
	else
	{
		age = agevalue.substring(0,yr);
		agevalue = "Y";
	}
	var retVal = 	new String();
	var dialogHeight= "500px";
	var dialogWidth = "1200px";
	var dialogTop	= "72";
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN";
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?reserve_bed_selectable=Y&disable_field=BcBt&patient_id="+patient_id+"&nursing_unit_code="+escape(nursingunit)+"&ipparam_bed_yn="+ipparam_bed_yn+"&oper_stn_id="+oper_stn_id+"&speciality_code="+escape(specialitycode)+"&practitioner_id="+escape(practitionerid)+"&bed_class_code="+escape(bedclasscode)+"&bed_type="+escape(bedtypecode)+"&age_value="+escape(agevalue)+"&age="+escape(age)+"&gender="+escape(gender)+"&wherecondn="+escape(wherecondn),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			self.document.forms[0].to_bed_no.value = arr[1];
			self.document.forms[0].nursing_unit_code.value=arr[0];
			self.document.forms[0].nursing_unit_desc.value=arr[9];
			self.document.forms[0].tobedtype.value = arr[2];
			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				self.document.forms[0].Splcode_desc.value=arr[11];
				self.document.forms[0].Splcode.value=arr[10];
			}
			
			/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
			if(autoCnrmTfrReq == "Y" && fnName == "TransferPatientOut")
				p = self.document.forms[0].to_bed_class.options;
			else
				p = self.document.forms[0].Bedcode.options;
			/*End*/

			for (i=0; i<p.options.length; i++) {
				if(p.options[i].value ==arr[3])
					p.options[i].selected = true;
			}
			self.document.forms[0].hid_bed_code.value=arr[3];
				
			if(arr[4] ==null )  	arr[4] ='';
			
			self.document.forms[0].to_room_no.value=arr[4];
			self.document.forms[0].to_daily_rate.value=arr[8];
			var obj =document.forms[0].bed_type_code;
			var opt= document.createElement('Option');
			opt.text=arr[13]
			opt.value=arr[2]; 
			obj.add(opt)
			opt.selected = true;
			document.forms[0].hid_bed_type.value=arr[2];
			// Modified by Muthu on 16/03/2010 for WalkThrough Issue :- Service is getting cleared when bed no changes
			if(nursingunit!=arr[0])
				PopulateService();
			// End of comment
		}
		else
		{			
			self.document.forms[0].nursing_unit_code.value=arr[0];
			if (arr.length == 2)
				self.document.forms[0].nursing_unit_desc.value=arr[1];

			// Modified by Muthu on 16/03/2010 for WalkThrough Issue :- Service is getting cleared when bed no changes
			if(nursingunit!=arr[0])
				PopulateService();
			// End of comment
		}
		if (document.forms[0].bed_status_name != null)
				document.forms[0].bed_status_name.style.visibility = "Hidden" ;
	}
}

function onBedClassChange(obj)
{
	document.forms[0].to_bed_no.value = '';
	document.forms[0].to_room_no.value = '';	
}

function getRoomNo(obj)
{
	
	if(obj.value =='')
	{
		self.document.forms[0].to_room_no.value = '';
		if (document.forms[0].bed_status_name != null)
				document.forms[0].bed_status_name.style.visibility = "Hidden" ;
	}

	if(specialChar(obj,'Char')==true)
	{
		if(obj.value!='')
		{
			self.document.forms[0].to_room_no.value = '';	
			self.document.forms[0].to_daily_rate.value = '';
			var nursingunit = self.document.forms[0].nursing_unit_code.value;
			var fr_bed_no = self.document.forms[0].fr_bed_no.value;
			var bed_change_YN =self.document.forms[0].bed_class_allowed.value;
			if(self.document.forms[0].bed_class_allowed.value=='Y')
			{
			var Bedcode = self.document.forms[0].Bedcode.value;
			var bed_type_code = self.document.forms[0].bed_type_code.value;
			}
			var bedno = obj.value;
			var url = parent.frames[2].location.href;
			var action_url="";
			if(url.indexOf("/servlet")!=-1){
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+Bedcode+"'><input type='hidden' name='field2' id='field2' value='"+bed_type_code+"'> "+
				" <input type='hidden' name='field3' id='field3' value=\""+nursingunit+"\"><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='field8' id='field8' value='from_tfrout'></form><input type='hidden' name='field9' id='field9' value=\""+bed_change_YN+"\"></body></html>";
			}
			else{
				var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
				" <input type='hidden' name='field1' id='field1' value='"+Bedcode+"'><input type='hidden' name='field2' id='field2' value='"+bed_type_code+"'> "+
				" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field5' id='field5' value='"+bedno+"'><input type='hidden' name='fr_bed_no' id='fr_bed_no' value='"+fr_bed_no+"'><input type='hidden' name='field8' id='field8' value='from_tfrout'><input type='hidden' name='field9' id='field9' value='"+bed_change_YN+"'></form></body></html>";
			}
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[3].document.dum_form.submit();
		}
		
	}
	
}
var onload	= 0;
function popDynamicValues(obj)
{
	var nurs_unit_fr=self.document.forms[0].fr_nursing_unit_code.value ;
	var nurs_unit_to=self.document.forms[0].nursing_unit_code.value;
	var spl_fr=self.document.forms[0].fr_speciality_code.value;
	var team_fr=self.document.forms[0].fr_team_id.value;
	var bed_class_fr=self.document.forms[0].fr_bed_class.value;
	
	if(nurs_unit_to != nurs_unit_fr)
	{  
		self.document.forms[0].to_bed_no.value = '';
		self.document.forms[0].to_room_no.value = '';	
		self.document.forms[0].to_daily_rate.value = '';
		if(self.document.forms[0].call_function_name&&!(self.document.forms[0].call_function_name.value=="TransferPatientOut"))self.document.forms[0].practid.value = '';  //Added for GHL-CRF-0340
		self.document.forms[0].team_id.options[0].selected=true;
		spl_fr='';
		tem_fr='';
	}
	else
	{
		document.forms[0].nursing_unit_desc.value=self.document.forms[0].fr_nursing_unit_desc.value ;
		if(onload ==1)
		spl_fr='';
	}
	var val = obj.value;
	if (val != null && val != "")
	{
		onload=	1	;
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value=\""+val+"\"><input type='hidden' name='funct' id='funct' value='spec'><input type ='hidden'  name='spl_fr' id='spl_fr' value=\""+spl_fr+"\"><input type ='hidden'  name='team_fr' id='team_fr' value=\""+team_fr+"\"></form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.query_spec.submit();
	}

}

function checkFields2( fields, names)
{
	
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}
function trimCheck1(inString)
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

function ComputeBlDtl()
{
	
	var fm_nur_code	=	document.forms[0].fr_nursing_unit_code;
	var to_nur_code	=	document.forms[0].nursing_unit_code;
	var fm_bed_no	=	document.forms[0].fr_bed_no;
	var to_bed_no	=	document.forms[0].to_bed_no;
	var fm_bed_class=	document.forms[0].fr_bed_class;
	var to_bed_class=	document.forms[0].Bedcode;
	var trans_code	=	document.forms[0].transfer_type;
	var encount_id	=	document.forms[0].encounter_id;
	
	if(trans_code.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel('eIP.TransferType.label','IP'));
		alert(error);
		trans_code.focus();
		return false;
	}

	if(to_nur_code.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel('Common.TransferTo.label','Common')+""+getLabel('Common.nursingUnit.label','Common'));
		alert(error);
		to_nur_code.focus();
		return false;
	}

	if(to_bed_class.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel('Common.TransferTo.label','Common')+""+ getLabel('Common.BedClass.label','common'));
		alert(error);
		to_bed_class.focus();
		return false;
	}

	if(to_bed_no.value=="")
	{
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel('Common.TransferTo.label','Common')+""+ getLabel('Common.bedno.label','Common'));
		alert(error);
		to_bed_no.focus();
		return false;
	}

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='BLBedTrans' id='BLBedTrans' method='post' action='../../eBL/jsp/BLBedTrans.jsp' >"+
	"<input type='hidden' name='fm_nur_code' id='fm_nur_code' value='"+fm_nur_code.value+"'>"+
	"<input type='hidden' name='to_nur_code' id='to_nur_code' value='"+to_nur_code.value+"'> "+
	"<input type='hidden' name='fm_bed_no' id='fm_bed_no' value='"+fm_bed_no.value+"'> "+
	"<input type='hidden' name='to_bed_no' id='to_bed_no' value='"+to_bed_no.value+"'> "+
	"<input type='hidden' name='fm_bed_class' id='fm_bed_class' value='"+fm_bed_class.value+"'> "+
	"<input type='hidden' name='to_bed_class' id='to_bed_class' value='"+to_bed_class.value+"'> "+
	"<input type='hidden' name='trans_code' id='trans_code' value='"+trans_code.value+"'> "+
	"<input type='hidden' name='encount_id' id='encount_id' value='"+encount_id.value+"'> "+
	"</form></body></html>";
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.BLBedTrans.submit();
}

function getBlockingDetails()
{
	var function_name =	parent.frames[2].document.forms[0].call_function_name.value;
	if(function_name != 'TransferPatientIn')
	{
		parent.frames[2].document.forms[0].blocking_type.disabled=false;
		parent.frames[2].document.forms[0].bed_blocking_period.disabled=false;
		parent.frames[2].document.forms[0].bed_block_remarks.disabled=false;
		parent.frames[2].document.forms[0].bed_block_until.disabled=false;
		var retVal = 	new String();
		retVal = document.forms[0].transfer_type1.value;
		if(retVal != null && retVal !='')
		{
			var arr = retVal.split("=");
			var arr1=arr[0];
			/*Monday, September 13, 2010 SRR20056-SCF-5155 [IN:023680]*/
			if (parent.frames[2].document.forms[0].pseudo_bed.value == "Y" && parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value == "Y" && arr[2] != "")
			{
				var error = getMessage('DEACT_PSEUDO_BED_YN_ENABLED',"IP");
				error = error.replace('$',getLabel("Common.blocked.label","Common"));
						
				alert(error);
				document.forms[0].transfer_type_code.value=arr[0];
				parent.frames[2].document.forms[0].blocking_type_code.value=arr[1];
				parent.frames[2].document.forms[0].blocking_type.value=arr[2];
				parent.frames[2].document.forms[0].bed_block_until.value='';
				parent.frames[2].document.forms[0].bed_blocking_period.value = "";
				parent.frames[2].document.forms[0].bed_blocking_period.readOnly=true;
			}//
			else
			{
				document.forms[0].transfer_type_code.value=arr[0];
				parent.frames[2].document.forms[0].blocking_type_code.value=arr[1];
				parent.frames[2].document.forms[0].blocking_type.value=arr[2];
				parent.frames[2].document.forms[0].bed_blocking_period.value=arr[3];
				
				parent.frames[2].document.forms[0].bed_block_until.value='';
				parent.frames[2].document.forms[0].bed_block_until.value=arr[4];
				
				if(arr[4]!='')
					parent.frames[2].document.forms[0].bed_block_until.value= convertDate(arr[4],'DMYHM','en',localeName);

				parent.frames[2].document.forms[0].override_yn.value=arr[6];
				if(parent.frames[2].document.forms[0].override_yn.value =='')
					parent.frames[2].document.forms[0].override_yn.value='N';
				if(parent.frames[2].document.forms[0].blocking_type.value !='' && parent.frames[2].document.forms[0].bed_blocking_period.value=='')
				{
					parent.frames[2].document.forms[0].bed_blocking_period.value=arr[7];
				}
				if(parent.frames[2].document.forms[0].bed_blocking_period.value =='')
					parent.frames[2].document.forms[0].bed_blocking_period.readOnly=true;
				else
					parent.frames[2].document.forms[0].bed_blocking_period.readOnly=false;
			}
		}
		else
		{
			parent.frames[2].document.forms[0].bed_block_until.value='';

			parent.frames[2].document.forms[0].blocking_type.value ='';
			parent.frames[2].document.forms[0].bed_blocking_period.value='';
			parent.frames[2].document.forms[0].bed_blocking_period.readOnly=true;
			parent.frames[2].document.forms[0].transfer_type.value='';
			document.forms[0].transfer_type_code.value='';
		}
		if(parent.frames[2].document.forms[0].blocking_type.value =='')
		{
			parent.frames[2].document.forms[0].bed_block_remarks.value = '';
			parent.frames[2].document.forms[0].bed_block_remarks.disabled = true;
		}
	}
}


// Added by Mohamed
function specialChar(obj,val)
{
	
	if(obj.value!='')
	{
		var fields1 = new Array(obj);
		var names1 = new Array(obj.name.toUpperCase());
		var messageFrame = ""; var error_page = "";
		if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
		{
			if(val=="Num")
			{
				if(CheckNum(obj))
					{
						 return true;
					}
					else 
					{
						 obj.focus();
						 obj.value='';
						 return false;
					}
			}
			else if(val=="Char")
			{
				return true;
			}
			return true;
		}
		else
		{
		   obj.focus()
		   obj.value='';
		   return false;
		}
	}

}

function validatePractID(obj0, obj1, obj2)
{
	
	var val		= obj0.value;

	if(val != "")
	{
		var nur_code	= obj1.value;
		var spec_code	= obj2.value;

		if(nur_code != "")
		{
			if(spec_code != "")
			{
				if ((val != "") && (nur_code != "") && (spec_code != ""))
				{
					var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='query_spec' id='query_spec' method='post' action='../../eIP/jsp/IPPopSpecPract.jsp'><input type='hidden' name='code' id='code' value='"+val+"'><input type='hidden' name='funct' id='funct' value='pract'><input type='hidden' name='nur_code' id='nur_code' value='"+nur_code+"'><input type='hidden' name='spec_code' id='spec_code' value='"+spec_code+"'></form></body></html>";
					parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					parent.frames[3].document.query_spec.submit();
				}
			}
			else 
			{
				var error = getMessage('CAN_NOT_BE_BLANK','Common');
				error = error.replace('$',getLabel('Common.speciality.label','Common'));
				alert(error);
			}
		}
		else 
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel('Common.nursingUnit.label','Common'));
			alert(error);
		}
	}
}

function PopulateService()
{
	
	var nursingunit = self.document.forms[0].nursing_unit_code.value;
	var patient_id = self.document.forms[0].patient_id.value;
	var def_nursingunit=self.document.forms[0].def_nursing_unit.value;
	var operStaionId = self.document.forms[0].oper_stn_id.value;
	var function_name =	self.document.forms[0].call_function_name.value;

	if(function_name == "TransferPatientIn")
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value='request_tfr'><input type='hidden' name='field2' id='field2' value=\""+patient_id+"\"><input type='hidden' name='field3' id='field3' value=\""+nursingunit+"\"><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field7' id='field7' value=\""+def_nursingunit+"\"><input type='hidden' name='field8' id='field8' value='from_tfrout' ></form></body></html>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.dum_form.submit();
	}
	else
	{
	
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value='request_tfr'><input type='hidden' name='field2' id='field2' value='"+patient_id+"'><input type='hidden' name='field3' id='field3' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field8' id='field8' value='from_tfrout' ><input type='hidden' name='field9' id='field9' value='"+operStaionId+"' ></form></body></html>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.dum_form.submit();
	}
}

async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, aPatientClass)
{
	
	var nursingUnit = aNursingUnit.value;
	var facilityId	= aFacilityId;
	var loginUserId	= aLoginUser;
	var patientclass = aPatientClass;
	var retVal =    new String();
	var function_name =	self.document.forms[0].call_function_name.value;
	var splty_code="";
	var pract_id="";
	var Operator_Station_ID="";
	var call_function =document.forms[0].call_function.value;
	var tit			= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();
	if(function_name == "TransferPatientOut")
	{
	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+loginUserId+"&oper_id="+Operator_Station_ID+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=Y";
	}
	else
	if(function_name == "TransferPatientIn")
	{
	var oper_stn_id = self.document.forms[0].oper_stn_id.value;
	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+loginUserId+"&oper_id="+oper_stn_id+"&patientclass="+patientclass+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&statics_yn=N"+"&call_function="+call_function+"&open_location_yn=N";
	}
	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");
		if(document.forms[0].nursing_unit_desc.value != arr[0])
		{

		}
		self.document.forms[0].nursing_unit_code.value		=	arr[0];
		self.document.forms[0].nursing_unit_desc.value	=	arr[1];
		self.document.forms[0].nurs_desc_hid.value = self.document.forms[0].nursing_unit_desc.value;
		
		popDynamicValues(self.document.forms[0].nursing_unit_code); 
		self.document.forms[0].nursing_unit_desc.focus();
		//self.document.forms[0].Splcode.value=''; //commented for this CRF GHL-CRF-0340
		self.document.forms[0].fr_practitioner_id.value='';
		self.document.forms[0].service.value='';
		//self.document.forms[0].Splcode_desc.value=''; //commented for this CRF GHL-CRF-0340
		//self.document.forms[0].pract_desc.value=''; //commented for this CRF GHL-CRF-0340
		self.document.forms[0].pract_desig.value='';
		if(function_name == "TransferPatientIn")
		{   
		   //Added for this CRF GHL-CRF-0340
		    self.document.forms[0].Splcode.value='';
			self.document.forms[0].Splcode_desc.value='';
			self.document.forms[0].practid.value='';
			self.document.forms[0].pract_desc.value='';
		
			if (document.forms[0].bed_status_name != null)
				document.forms[0].bed_status_name.style.visibility = "Hidden" ;
		}else if(function_name == "TransferPatientOut")
		{
		    //Added for this CRF GHL-CRF-0340			
		    Specialitycheck(document.forms[0].nursing_unit_code.value,document.forms[0].facility_id.value,document.forms[0].Splcode.value);
			Practitionercheck(document.forms[0].nursing_unit_code.value,facilityId,document.forms[0].practid.value);
		    
			if(parseInt(document.forms[0].specialtyCheck.value)==0){
		    self.document.forms[0].Splcode.value='';
			self.document.forms[0].Splcode_desc.value='';			
			}if(parseInt(document.forms[0].practitionerCheck.value)==0){		    
			self.document.forms[0].practid.value='';
			self.document.forms[0].pract_desc.value='';
			}
			//End GHL-CRF-0340
		
		}
		else
		{
		}
		//self.document.forms[0].practid.value=''; //commented for this CRF GHL-CRF-0340
		self.document.forms[0].sub_service.value='';
		PopulateService();
			
	}
	else
	{
		self.document.forms[0].nursing_unit_desc.value='';
		self.document.forms[0].nursing_unit_code.value='';
		self.document.forms[0].Splcode_desc.value='';
		self.document.forms[0].service.value='';
		self.document.forms[0].Splcode_desc.value='';
		self.document.forms[0].pract_desc.value='';
		self.document.forms[0].practid.value='';
		self.document.forms[0].sub_service.value='';
		if(function_name == "TransferPatientIn")
		{
			self.document.forms[0].Bedcode.value='';
		}
		else
		{
			self.document.forms[0].to_bed_class.value='';
		}
		self.document.forms[0].bed_type_code.value='';
	}
}

function PopulateSubService()
{
	
	var nursingunit = self.document.forms[0].nursing_unit_code.value;
	var serviceCode = self.document.forms[0].service.value;

	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post'  action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value=''><input type='hidden' name='field4' id='field4' value='Transfer_form'><input type='hidden' name='field8' id='field8' value='from_tfrout'><input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'></form></body></html>";
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dum_form1.submit();
}


/******************************************************************/
// These functions will be called from TransferPatientOutMain.jsp
/******************************************************************/

function setfocus()
{
	
	if (parent.frames[1].document.forms[0].transfer_in_status.value == "01")
	{
	parent.frames[2].document.forms[0].nursing_unit_desc.focus();
	}
}
//Added by Kishore on 8/21/2004


function compareSystemDate(prefDate)
{
	
	if (prefDate.value != "")
	{
		if(prefDate.value != '' )
		{
			if(!doDateTimeChk(prefDate))
			{
				alert(getMessage('INVALID_DATE_TIME',"SM"));
				prefDate.focus();
				prefDate.select();
				return ;
			}
		}

		if(!(ValidatePrefDateTime(document.forms[0].sysdate, prefDate)))
		{
			var error = getMessage('DATE1_LT_DATE2','IP');
			error = error.replace('$',getLabel('Common.PreferredDate.label','Common'));
			error = error.replace('#',getLabel('Common.SystemDate.label','Common'));
			alert(error);
			prefDate.value =  document.forms[0].sysdate.value;
		}
	}
}

function ChkNumberInput(fld, e, deci)
{
	
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';

   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}


function ValidatePrefDateTime(from,to)
{
   
	from = from.value
    to   = to.value

    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]

    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")

     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]

     splitdate1 =splitdate.split("/")
     splittime1= splittime.split(":")
	 time3=splittime1[1]
	 var strCheck = ':0123456789';

	  for(var i=0;i<=time3.length;i++) {
                if (strCheck.indexOf(time3.charAt(i)) == -1){
					alert(getMessage('INVALID_DATE_FMT','SM'));
                    return false;
                    break;
                }
            }
     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(to_date) < Date.parse(from_date))
    {
        return false;
    }
    else
        return true;
}
//added by kishore on 8/25/2004
function getBlockBedDate()
{
	
	parent.frames[2].document.forms[0].blocking_type.disabled=false;
	parent.frames[2].document.forms[0].bed_blocking_period.disabled=false;
	parent.frames[2].document.forms[0].bed_block_remarks.disabled=false;
	//var tranfer_type =document.trf_form.transfer_type_code.value;
	var tranfer_type =parent.frames[1].document.trf_form.transfer_type1.value;
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field3' id='field3' value=\""+tranfer_type+"\"><input type='hidden' name='field4' id='field4' value='block_date'><input type='hidden' name='field5' id='field5' value='transfer_out'></form></body></html>";
	//parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.dum_form.submit();
}

function getTfrType()
{
	
	var retVal = 	new String();
	retVal = document.forms[0].transfer_type1.value;
	if(retVal != null && retVal !='')
	{
		var arr = retVal.split("=");
		var arr1=arr[0];
		document.forms[0].transfer_type_code.value=arr[0];
	}
}

function tab_click1()
{
	
	
	parent.frames[2].document.getElementById('tab2').scrollIntoView();
//	parent.frames[2].document.forms[0].bed_blocking_period.focus();
	
}
//========= Functions copied from TransferPatientOutMain.jsp==============
function enableAllFields()
{
	
	if (parent.frames[1].document.forms[0].transfer_in_status.value == "01")
	{
		parent.frames[2].document.forms[0].nursing_unit_desc.disabled	= false;
		parent.frames[2].document.forms[0].nursing_unit_lookup.disabled	= false;
		parent.frames[2].document.forms[0].service.disabled				= false;
		parent.frames[2].document.forms[0].sub_service.disabled			= false;
		parent.frames[2].document.forms[0].to_bed_no.disabled			= false;
		parent.frames[2].document.forms[0].to_room_no.disabled			= false;
		parent.frames[2].document.forms[0].Splcode_desc.disabled		= false;
		parent.frames[2].document.forms[0].pract_desc.disabled			= false;
		parent.frames[2].document.forms[0].pract_desig.disabled			= false;
		parent.frames[2].document.forms[0].team_id.disabled				= false;
		//Added by kishore on 5/16/2004
		parent.frames[2].document.forms[0].bed_avail.disabled			= false;
		parent.frames[2].document.forms[0].Splcode_lookup.disabled		= false;
		parent.frames[2].document.getElementById('pract_id_search').disabled		= false;
		/*5/5/2009 comment removed from port_received_yn for IN010338 SRR20056-SCF-2974  */
		parent.frames[2].document.forms[1].port_received_yn.disabled	= false;
		/**/
		parent.frames[2].document.getElementById('img2').style.visibility				= 'visible';
		parent.frames[2].document.getElementById('img3').style.visibility				= 'visible';
		parent.frames[2].document.getElementById('img4').style.visibility				= 'visible';
		parent.frames[2].document.getElementById('img5').style.visibility				= 'visible';
		parent.frames[2].document.getElementById('serv_img').style.visibility			= 'visible';
		parent.frames[2].document.getElementById('img_m').style.visibility			= "hidden";
		parent.frames[2].document.forms[0].cancel_reason.disabled		= true;	 
		parent.frames[2].document.getElementById('cancelreasonid').style.visibility	= "hidden";	 
		parent.frames[2].document.forms[0].cancel_reason.value			= "";	

	var function_name =parent.frames[2].document.forms[0].call_function_name.value;
	if(function_name=='TransferPatientIn')
		{
		if (parent.frames[1].document.forms[0].transfer_in_status.value == "01") // added by mujafar for ML-MMOH-CRF-1136
			{ 
				if(parent.frames[1].document.getElementById('arr_date_disp') && parent.frames[1].document.getElementById('arr_date_disp1'))
				{
				parent.frames[1].document.getElementById('arr_date_disp').style.display = ""; 
				parent.frames[1].document.getElementById('arr_date_disp1').style.display = ""; 
				}
				
			}
			if(parent.frames[2].document.forms[0].pat_check_in_allowed_yn.value=='Y')
				{
				parent.frames[2].document.forms[0].to_bed_class.disabled=true;
				parent.frames[2].document.forms[0].Bedcode.disabled=true;
				parent.frames[2].document.forms[0].bed_type_code.disabled=true;
				}
			else
			if(parent.frames[2].document.forms[0].bed_class_allowed.value == 'N')
				{
				parent.frames[2].document.forms[0].to_bed_class.disabled=false;
				parent.frames[2].document.forms[0].Bedcode.disabled=false;
				parent.frames[2].document.forms[0].bed_type_code.disabled=false;
				}
		}
		else
		if(parent.frames[2].document.forms[0].bed_class_allowed.value == 'N')
		{
			parent.frames[2].document.forms[0].to_bed_class.disabled=false;
			parent.frames[2].document.forms[0].Bedcode.disabled=false;
			parent.frames[2].document.forms[0].bed_type_code.disabled=false;
		}
	}
	else
		disabledAllFields();
}

function disabledAllFields()
{


	parent.frames[2].document.forms[0].nursing_unit_desc.disabled	= true;
	parent.frames[2].document.forms[0].nursing_unit_lookup.disabled	= true;
	parent.frames[2].document.forms[0].service.disabled				= true;
	parent.frames[2].document.forms[0].sub_service.disabled			= true;
	parent.frames[2].document.forms[0].Bedcode.disabled				= true;
	parent.frames[2].document.forms[1].port_received_yn.checked		=false;
	parent.frames[2].document.forms[1].port_received_yn.disabled	= true;
	parent.frames[2].document.forms[1].received.value='';
	parent.frames[2].document.forms[1].received.disabled	= true;
	parent.frames[2].document.forms[1].port_remarks.value='';
	parent.frames[2].document.forms[1].port_remarks.disabled	= true;	
	if (parent.frames[2].document.forms[0].to_bed_class.value == "")
		parent.frames[2].document.forms[0].Bedcode.value				= "";	
	else
		parent.frames[2].document.forms[0].Bedcode.value				= parent.frames[2].document.forms[0].to_bed_class.value;
	parent.frames[2].document.forms[0].bed_type_code.disabled		=true;
	parent.frames[2].document.forms[0].to_bed_no.disabled			= true;
	parent.frames[2].document.forms[0].to_room_no.disabled			= true;
	parent.frames[2].document.forms[0].Splcode_desc.disabled			= true;
	parent.frames[2].document.forms[0].pract_desc.disabled			= true;
	parent.frames[2].document.forms[0].pract_desig.disabled			= true;
	parent.frames[2].document.forms[0].team_id.disabled				= true;
	parent.frames[2].document.forms[0].info_pat_relatives.disabled	= true;
	parent.frames[2].document.forms[0].info_date_time.disabled		= true;
	parent.frames[2].document.forms[0].inform_to.disabled			= true;
	parent.frames[2].document.forms[0].auth_date_time.disabled		= true;
	parent.frames[2].document.forms[0].info_pat_name.disabled		= true;
	parent.frames[2].document.forms[0].bed_avail.disabled			= true;
	parent.frames[2].document.forms[0].Splcode_lookup.disabled		= true;
	parent.frames[2].document.getElementById("pract_id_search").disabled			= true;

	parent.frames[2].document.forms[0].cancel_reason.value			= "";
	parent.frames[2].document.getElementById("ondate1").disabled					= true;	
	parent.frames[2].document.forms[0].inform_button.disabled = true;
	parent.frames[2].document.getElementById('img2').style.visibility				= 'hidden';
	parent.frames[2].document.getElementById('img3').style.visibility				= 'hidden';
	parent.frames[2].document.getElementById('img4').style.visibility				= 'hidden';
	parent.frames[2].document.getElementById('img5').style.visibility				= 'hidden';
	parent.frames[2].document.getElementById('serv_img').style.visibility				= 'hidden';
	parent.frames[2].document.getElementById('ondate1').style.visibility			= 'hidden';
	parent.frames[2].document.getElementById('ondate2').style.visibility			= 'hidden';
	parent.frames[2].document.getElementById('received_img').style.visibility			= 'hidden';
	if(parent.frames[1].document.getElementById('arr_date_disp')  && parent.frames[1].document.getElementById('arr_date_disp1') ) // added by mujafar for ML-MMOH-CRF-1136
	{
	parent.frames[1].document.getElementById('arr_date_disp').style.display = "none";
	parent.frames[1].document.getElementById('arr_date_disp1').style.display = "none";
	parent.frames[1].document.getElementById('arrival_date').value='';
	}

	if (parent.frames[1].document.forms[0].transfer_in_status.value == "02")
	{
		parent.frames[2].document.getElementById('img_m').style.visibility			= "visible";
		parent.frames[2].document.getElementById('cancelreasonid').style.visibility	= "visible";	
		parent.frames[2].document.forms[0].cancel_reason.disabled	= false;	
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'><input type='hidden' name='c_field4' id='c_field4' value='Cancel_Reason'></form></body></html>";
		parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.Dummy_frame.document.dum_form.submit();
	}
	else
	{
		parent.frames[2].document.getElementById('img_m').style.visibility			= "hidden";
		parent.frames[2].document.getElementById('cancelreasonid').style.visibility	= "hidden";
		parent.frames[2].document.forms[0].cancel_reason.disabled	= true;	 
		parent.frames[2].document.forms[0].cancel_reason.value		= "";	 
	}
	parent.frames[2].document.getElementById('img_informed_date').style.visibility = "Hidden";
	parent.frames[2].document.getElementById('img_auth_date').style.visibility = "Hidden";
}


function close_me()
{
	
	var port_vals = "";
	port_vals = 
				
	(parent.frames[2].document.forms[1].Mode_of_Tran_desc.value.length == 0 ? " " : parent.frames[2].document.forms[1].Mode_of_Tran_desc.value) + "^^" + 
	(parent.frames[2].document.forms[1].acc_per1_desc.value.length == 0? " " : parent.frames[2].document.forms[1].acc_per1_desc.value )+ "^^" +
	(parent.frames[2].document.forms[1].acc_per2_desc.value.length == 0? " " :			
	parent.frames[2].document.forms[1].acc_per2_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].acc_per3_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].acc_per3_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].acc_per4_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].acc_per4_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].acc_per5_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].acc_per5_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].acc_per6_desc.value.length == 0 ? " " :	
	parent.frames[2].document.forms[1].acc_per6_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].acc_per7_desc.value.length == 0 ? " " :			
	parent.frames[2].document.forms[1].acc_per7_desc.value) + "^^" +

	(parent.frames[2].document.forms[1].equip1_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].equip1_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip2_desc.value.length == 0 ? " " :			
	parent.frames[2].document.forms[1].equip2_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip3_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].equip3_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip4_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].equip4_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip5_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].equip5_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip6_desc.value.length == 0 ? " " :			
	parent.frames[2].document.forms[1].equip6_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].equip7_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].equip7_desc.value) + "^^" +
				
	(parent.frames[2].document.forms[1].bld_med1_desc.value.length == 0 ? " " : 
	parent.frames[2].document.forms[1].bld_med1_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med2_desc.value.length == 0 ? " " :  			
	parent.frames[2].document.forms[1].bld_med2_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med3_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].bld_med3_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med4_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].bld_med4_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med5_desc.value.length == 0 ? " " :  			
	parent.frames[2].document.forms[1].bld_med5_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med6_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].bld_med6_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med7_desc.value.length == 0 ? " " :  			
	parent.frames[2].document.forms[1].bld_med7_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med8_desc.value.length == 0 ? " " :  			
	parent.frames[2].document.forms[1].bld_med8_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med9_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].bld_med9_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].bld_med10_desc.value.length == 0 ? " " :  			
	parent.frames[2].document.forms[1].bld_med10_desc.value) + "^^" +
				
	(parent.frames[2].document.forms[1].rec_doc1_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].rec_doc1_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].rec_doc2_desc.value.length == 0 ? " " : 
	parent.frames[2].document.forms[1].rec_doc2_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].rec_doc3_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].rec_doc3_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].rec_doc4_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].rec_doc4_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].rec_doc5_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].rec_doc5_desc.value) + "^^" +
				
	(parent.frames[2].document.forms[1].pat_bel1_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].pat_bel1_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel2_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel2_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel3_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel3_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel4_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel4_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel5_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel5_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel6_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel6_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel7_desc.value.length == 0 ? " " : 			
	parent.frames[2].document.forms[1].pat_bel7_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel8_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].pat_bel8_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel9_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].pat_bel9_desc.value) + "^^" +
	(parent.frames[2].document.forms[1].pat_bel10_desc.value.length == 0 ? " " :
	parent.frames[2].document.forms[1].pat_bel10_desc.value)+ "^^" ;
				// By Annadurai 3/5/2004 starts.,
				if (parent.frames[2].document.forms[1].jsp_name_val.value == "TransferPatientIn")
				{	
					port_vals = port_vals +
					(parent.frames[2].document.forms[1].port_received_yn.value.length == 0 ? " " :parent.frames[2].document.forms[1].port_received_yn.value)+ "^^" +
					(parent.frames[2].document.forms[1].received.value.length == 0 ? " " :
					parent.frames[2].document.forms[1].received.value)+ "^^" +
					(parent.frames[2].document.forms[1].port_remarks.value.length == 0 ? " " :
					parent.frames[2].document.forms[1].port_remarks.value);
				}
				// By Annadurai 3/5/2004 ends.,
		parent.frames[2].document.forms[0].porterage_hid.value=port_vals;
}

//========= Functions copied from TransferPatientOutMain.jsp******** END==============

function validateMotherBabyBed(frnursingunitcode,nursing_unit,bed_no,patId){

	var xmlStr ="<root><SEARCH step='Delink' ";
	xmlStr +=" /></root>";
	 
	var param="&frnursingunitcode="+frnursingunitcode+"&tonursingunitcode="+nursing_unit+"&to_bed_no="+bed_no+"&patient_id="+patId;
	var temp_jsp="../../eIP/jsp/BookingGetExpDaysDate.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	//responseText= trimString(responseText);
	return responseText;
	
}

/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
function GetLookupBlur(target1,target2)
{
	if(target1.value != "")
	{
		GetLookup(target1,target2);
	}
}

async function GetLookup(target1,target2){
	
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.user.label",'Common');

	sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
			

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= target1.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target1.value=arr[1];
		target2.value=arr[0];
	}
	else
	{
		target1.value="";
		target2.value="";
	}
}

function chkInformedDtlsMand()
{
	var function_name =	document.forms[0].call_function.value;
	if(function_name != 'TransferPatientIn')
	{
		var selectVal	 = new String();
		selectVal = document.forms[0].transfer_type1.value;
		if(selectVal != null && selectVal !='')
		{
			var arr = selectVal.split("=");
			var dynMandYn=arr[8];

			if (dynMandYn == "Y")
			{
				parent.frames[2].document.forms[0].info_pat_relatives.checked=true;
				parent.frames[2].document.forms[0].info_pat_relatives.value="Y";
				parent.frames[2].document.forms[0].info_pat_relatives.disabled=true;
				parent.frames[2].document.forms[0].inform_to.disabled=false;
				parent.frames[2].document.forms[0].info_pat_name.disabled=false;
				parent.frames[2].document.forms[0].info_date_time.disabled=true;
				parent.frames[2].document.forms[0].ondate1.disabled=true;
				parent.frames[2].document.forms[0].img_informed_to.style.visibility="visible";
				parent.frames[2].document.forms[0].img_informed_name.style.visibility="visible";
				parent.frames[2].document.forms[0].img_informed_date.style.visibility ="visible";
			}
			else if(dynMandYn == "N")
			{
				parent.frames[2].document.forms[0].info_pat_relatives.checked=false;
				parent.frames[2].document.forms[0].info_pat_relatives.value="N";
				parent.frames[2].document.forms[0].info_pat_relatives.disabled=false;
				parent.frames[2].document.forms[0].inform_to.disabled=true;
				parent.frames[2].document.forms[0].info_pat_name.disabled=true;
				parent.frames[2].document.forms[0].info_date_time.disabled=true;
				parent.frames[2].document.forms[0].ondate1.disabled=true;
				parent.frames[2].document.forms[0].inform_to.value="";
				parent.frames[2].document.forms[0].info_pat_name.value="";
				parent.frames[2].document.forms[0].info_date_time.value="";
				parent.frames[2].document.forms[0].img_informed_to.style.visibility="hidden";
				parent.frames[2].document.forms[0].img_informed_name.style.visibility="hidden";
				parent.frames[2].document.forms[0].img_informed_date.style.visibility ="hidden";
			}
		}
		
	}
}

function chkInformedDtlsMandOnLoad()
{
	var staticMandYn = parent.frames[2].document.forms[0].informed_dtls_yn.value;
		if (staticMandYn == "Y")
		{
				parent.frames[2].document.forms[0].info_pat_relatives.checked=true;
				parent.frames[2].document.forms[0].info_pat_relatives.value="Y";
				parent.frames[2].document.forms[0].info_pat_relatives.disabled=true;
				parent.frames[2].document.forms[0].inform_to.disabled=false;
				parent.frames[2].document.forms[0].info_pat_name.disabled=false;
				parent.frames[2].document.forms[0].info_date_time.disabled=true;
				parent.frames[2].document.forms[0].ondate1.disabled=true;
				parent.frames[2].document.forms[0].img_informed_to.style.visibility="visible";
				parent.frames[2].document.forms[0].img_informed_name.style.visibility="visible";
				parent.frames[2].document.forms[0].img_informed_date.style.visibility ="visible";
		}
}

function enableBedNo()
{
	parent.frames[2].document.forms[0].to_bed_no.disabled	= false;
	parent.frames[2].document.forms[0].bed_avail.disabled	= false;
}
/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 End*/

//Added by Sangeetha on 23/05/17 for GDOH-CRF-0151
function chkforVacantNormalBed(){
	var bed_no			  = document.forms[0].to_bed_no.value;
	var nursing_unit_code = document.forms[0].nursing_unit_code.value;
	var facility_id		  = document.forms[0].facility_id.value;
	var Bedcode			  = document.forms[0].hid_bed_code.value;
	var bed_type		  = document.forms[0].bed_type_code.value;

 if(bed_no!="" && nursing_unit_code!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\"  nursing_unit_code=\""+nursing_unit_code+"\" action='chkforVacantNormalBed' facility_id=\""+facility_id+"\" Bedcode=\""+Bedcode+"\" bed_type=\""+bed_type+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
	
		if(responseText == "Y"){
			var msg = getMessage("RESTRICT_PSEUDO_BED","IP");
			alert(msg);
			document.forms[0].to_bed_no.value  ="";
			document.forms[0].to_room_no.value ="";
			document.forms[0].bed_avail.focus();
		}
	}

}

