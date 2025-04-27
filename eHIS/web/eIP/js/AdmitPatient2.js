var currentTab = new String();
currentTab = "admission_tab";
var retVal_BL ="";
/*
	 *	This function is used to populate the reasons for admission
	 */
	async function ReasonLookup()
	{
		var tit				= getLabel("Common.ReasonforAdmission.label","Common");
		/*Below line added for this CRF GDOH-CRF-0129*/
		var isReferral      = document.forms[0].isReferral.value;
		    if(isReferral=="true")	tit=getLabel("Common.Referralfrom.label","Common");
		//End this CRF GDOH-CRF-0129		
		
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var locale = document.forms[0].locale.value;
		// This sql populates the reasons for admission with given search value
		sql=" select complaint_code code, complaint_desc description from AM_COMPLAINT_LANG_VW where language_id ='"+locale+"' and eff_status like ? and upper(complaint_code) like upper(?) and upper(complaint_desc) like upper(?) ";	   
		dataNameArray[0]	= "eff_status" ;
		dataValueArray[0]	= "E";
		dataTypeArray[0]	= STRING;
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3";
		argumentArray[5] = document.forms[0].chief_complaint.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].chief_complaint.value=arr[1];
			document.forms[0].complaintcode.value=arr[0];
			document.forms[0].chief_complaint_hid.value = document.forms[0].chief_complaint.value
			
			/*Below line added for this CRF GDOH-CRF-0129*/
			if(document.forms[0].isReferral && document.forms[0].isReferral.value=="true"){						
				document.forms[0].assigncare_locacode.value=arr[0];
				document.forms[0].assigncare_loctype_ind.value="P";						
			}
			//End this GDOH-CRF-0129
		}
		else
		{
			document.forms[0].chief_complaint.value="";
			document.forms[0].complaintcode.value="";
			//Below line added for this CRF GDOH-CRF-0129
			document.forms[0].assigncare_locacode.value="";
			document.forms[0].assigncare_loctype_ind.value="";	
            //End GDOH-CRF-0129			
			
		}
	}
	

	
	function moveToNextItem()
	{
		tab_click('admission_tab');
		if(!document.forms[0].Bedcode.disabled)
			document.forms[0].Bedcode.focus();	
	}

	function tab_click(objName)
	{
		changeTab(objName);
		if (objName == 'admission_tab' || objName == 'admission_tab1' || objName == 'admission_tab2')
		{
			if(document.getElementById('tab1') != null)
				{
				
				document.getElementById('tab1').scrollIntoView({
					  behavior: "smooth",
					  block: "nearest",
					  inline: "start"
					});

				}
			
				//document.getElementById("tab1").scrollIntoView();

			/*if(document.getElementById("visit_adm_date_time").disabled==false)
				document.getElementById("visit_adm_date_time").focus();*/
		}
/*		else if (objName == 'additional_tab' || objName == 'additional_tab1' || objName == 'additional_tab2')
		{
			document.getElementById("tab2").scrollIntoView();
			if(document.getElementById("ambulatory_status").disabled==false)
				document.getElementById("ambulatory_status").focus();
		}*/
		else if (objName == 'findtl_tab' || objName == 'findtl_tab1' || objName == 'findtl_tab2')
		{
			
			//document.getElementById("tab3").scrollIntoView();
			document.getElementById('tab3').scrollIntoView({
				  behavior: "smooth",
				  block: "nearest",
				  inline: "start"
				});

			var financial_detail_ref_id = "";
			if(document.forms[0].isBlInstalled.value=="Y")
			{				
				if(parent.Select_frame.document.forms[0].referral_id.value != "")
					document.forms[0].financial_detail_ref_id.value = parent.Select_frame.document.forms[0].referral_id.value ;
			}
		
		
			if(parent.frames[2].document.AdmitPatient_form.nursing_unit.value !='')
			{
				/*3/31/2009 modified for IN009408*/
				tab_click('admission_tab');
				parent.frames[2].document.forms[0].visit_adm_type.focus();
				/*3/31/2009*/
				chkOnSub(); 
				
			}
			else
			{	
				if(document.getElementById('tab1') != null)
					{
					//document.getElementById("tab1").scrollIntoView();
					document.getElementById('tab1').scrollIntoView({
						  behavior: "smooth",
						  block: "nearest",
						  inline: "start"
						});

					
					}
				
					

				alert(getMessage('NU_NOTNULL','IP'));
				if(parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.disabled==false)
					parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.focus();
			}
			
		}   
	} 
	function changeTab(TabName) 
	{
		if (currentTab == 'admission_tab' || currentTab == 'admission_tab1' || currentTab == 'admission_tab2')
		{
			document.getElementById('admission_tab').src = '../images/Admission_click.gif';
//			document.getElementById('admission_tab1').src = '../images/Admission_click.gif';
			document.getElementById('admission_tab2').src = '../images/Admission_click.gif';
		}
		else if (currentTab == 'additional_tab' || currentTab == 'additional_tab1' || currentTab == 'additional_tab2')
		{
			document.getElementById('additional_tab').src = '../images/Additional_click.gif';
//			document.getElementById('additional_tab1').src = '../images/Additional_click.gif';
			document.getElementById('additional_tab2').src = '../images/Additional_click.gif';
		}
		else if (currentTab == 'findtl_tab' || currentTab == 'findtl_tab1' || currentTab == 'findtl_tab2')
		{
			document.getElementById('findtl_tab').src = '../../eBL/images/Financial Details_click.gif';
//			document.getElementById('findtl_tab1').src = '../../eBL/images/Financial Details_click.gif';
			document.getElementById('findtl_tab2').src = '../../eBL/images/Financial Details_click.gif';
		}
		if (TabName == 'admission_tab' || TabName == 'admission_tab1' || TabName == 'admission_tab2')
		{
			document.getElementById('admission_tab').src = '../images/Admission.gif';
//			document.getElementById('admission_tab1').src = '../images/Admission.gif';
			document.getElementById('admission_tab2').src = '../images/Admission.gif';
		}
		else if (TabName == 'additional_tab' || TabName == 'additional_tab1' || TabName == 'additional_tab2')
		{
			document.getElementById('additional_tab').src = '../images/Additional.gif';
//			document.getElementById('additional_tab1').src = '../images/Additional.gif';
			document.getElementById('additional_tab2').src = '../images/Additional.gif';
		}
		else if (TabName == 'findtl_tab' || TabName == 'findtl_tab1' || TabName == 'findtl_tab2')
		{
			document.getElementById('findtl_tab').src = '../../eBL/images/Financial Details.gif';
//			document.getElementById('findtl_tab1').src = '../../eBL/images/Financial Details.gif';
			document.getElementById('findtl_tab2').src = '../../eBL/images/Financial Details.gif';
			
		}
		currentTab = TabName;    
	}    

	function setTabFocus(val,obj)
	{
		var continue_yn = true ;
		if(obj !=null)
			if(obj.name == 'room_no' && obj.value != '')
				continue_yn = validateSplchars (obj,getLabel('Common.roomno.label','common'))
		if( continue_yn )
		{
			if(val == 'F')
			{
				if(document.getElementById('tab1') != null)
					{
					document.getElementById('tab1').scrollIntoView({
						  behavior: "smooth",
						  block: "nearest",
						  inline: "start"
						});

					//document.getElementById("tab1").scrollIntoView();
					}
					

				if(document.getElementById("visit_adm_date_time").disabled==false)
					document.getElementById("visit_adm_date_time").focus();
			}
			else
			{
				
				tab_click('admission_tab')
			}
		}
	}

function onBedClassChange()
{
	var obj = document.forms[0].bed_type;
	var length = obj.length;
	for(i=0;i<length;i++)
	{
		obj.remove(0);
	}
	var opt = document.createElement('OPTION');
	opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	opt.value = "";
	obj.add(opt);
   var bed_class = document.forms[0].Bedcode.value;
   var nursingunit_code = document.forms[0].nursing_unit.value;
   var deactivate_pseudo_bed_yn = document.forms[0].deactivate_pseudo_bed_yn.value;

	document.forms[0].bed_no.value = '';
	document.AdmitPatient_form.attend_img.style.visibility = "hidden";

	if(parent.frames[0].document.Select_form.bkg_type.value !='D')
		document.forms[0].room_no.value = '';

	parent.frames[3].document.getElementById('valuables').disabled = true;
	if(bed_class!="")
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='bed_class' id='bed_class' value='"+bed_class+"'><input type='hidden' name='nursingunit_code' id='nursingunit_code' value='"+nursingunit_code+"'><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='"+deactivate_pseudo_bed_yn+"'></form></body></html>";
		parent.dummy.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.dummy.document.dum_form.submit();
	}
	
}

//Billing related nursing_unit
async function chkOnSub()
{
	document.forms[0].bl_success.value = "N";
	var show_hide_blng_class = "HIDE";
	var patient_id     = parent.Select_frame.document.forms[0].patient_id.value;
	var package_flag	= document.forms[0].package_flag.value;
	var ins_auth_flag	= "Y";
	var upd_pat_flag	= "Y";
	var billing_group			= document.forms[0].billing_group;
	var bl_future_admn_YN		= document.forms[0].bl_future_admn_YN.value;

/*
	var billing_class			= document.forms[0].billing_class;
	var employer_code			= document.forms[0].employer_code;
	var cash_set_type1			= document.forms[0].cash_set_type1;
	var cash_insmt_ref1			= document.forms[0].cash_insmt_ref1;
	var cash_insmt_date1		= document.forms[0].cash_insmt_date1;
	var cash_insmt_rmks1		= document.forms[0].cash_insmt_rmks1;
	var cust_1					= document.forms[0].cust_1;
	var credit_doc_ref1			= document.forms[0].credit_doc_ref1;
	var credit_doc_date1		= document.forms[0].credit_doc_date1;
	var cust_2					= document.forms[0].cust_2;
	var credit_doc_ref2			= document.forms[0].credit_doc_ref2;
	var credit_doc_date2		= document.forms[0].credit_doc_date2;
	var cust_3					= document.forms[0].cust_3;
	var policy_type				= document.forms[0].policy_type;
	var policy_no				= document.forms[0].policy_no;
	var policy_expiry_date		= document.forms[0].policy_expiry_date;
	var non_insur_blng_grp		= document.forms[0].non_insur_blng_grp;
	var cash_set_type2			= document.forms[0].cash_set_type2;
	var cash_insmt_ref2			= document.forms[0].cash_insmt_ref2;
	var cash_insmt_date2		= document.forms[0].cash_insmt_date2;
	var cash_insmt_rmks2		= document.forms[0].cash_insmt_rmks2;
	var cust_4					= document.forms[0].cust_4;
	var credit_doc_ref3			= document.forms[0].credit_doc_ref3;
	var credit_doc_date3		= document.forms[0].credit_doc_date3;
	var setlmt_ind				= document.forms[0].setlmt_ind;
	var upd_fin_dtls			= document.forms[0].upd_fin_dtls;
	var credit_auth_ref			= document.forms[0].credit_auth_ref;
	var credit_auth_date		= document.forms[0].credit_auth_date;
	var app_days				= document.forms[0].app_days;
	var app_amount				= document.forms[0].app_amount;
	var eff_frm_date			= document.forms[0].eff_frm_date;
	var remarks					= document.forms[0].remarks;
*/
	var billing_mode			= document.forms[0].billing_mode;
	var operation				= document.forms[0].bl_operation.value;
	var pkg_bill_type			= document.forms[0].pkg_bill_type;
	var pkg_bill_no				= document.forms[0].pkg_bill_no;
/*
	var annual_income	   		= document.forms[0].annual_income;
	var family_asset			= document.forms[0].family_asset;
	var no_of_dependants		= document.forms[0].no_of_dependants;
	var resp_for_payment		= document.forms[0].resp_for_payment;
	var credit_doc_reqd_yn1		= document.forms[0].credit_doc_reqd_yn1;
	var credit_doc_reqd_yn2		= document.forms[0].credit_doc_reqd_yn2;
*/
/*Below line Added for this CRF Bru-HIMS-CRF-261*/
if(parent.frames[2].document.AdmitPatient_form.quick_admission_type)
	var quick_admission	=parent.frames[2].document.AdmitPatient_form.quick_admission_type.value;
	//End Bru-HIMS-CRF-261
	var practitioner_type_ind = "";
	var att_practid				= ""; 
	att_practid				= document.forms[0].att_practid.value; 
	if(att_practid != '') practitioner_type_ind = "P";
	var health_card_expired_yn	= document.forms[0].health_card_expired_yn; 
	var Chg_to_Visitor_Grp		= document.forms[0].Chg_to_Visitor_Grp;		
	if(parent.frames[0].document.Select_form.bkg_type.value=='D')
		parent.frames[2].document.AdmitPatient_form.patient_class_id.value	='DC'
	var calling_module_id		=parent.frames[2].document.AdmitPatient_form.patient_class_id.value;
	var calling_function_id		= "ADMISSION";
	var nursingUnitCode = document.forms[0].nursing_unit.value;
	var admissionType	= document.forms[0].visit_adm_type.value;
	var bedClass		= document.forms[0].Bedcode.value;
	var package_enabled_yn		= document.forms[0].package_enabled_yn.value;// Added for package billing
	var financial_detail_ref_id = "";
	if(document.forms[0].isBlInstalled.value=="Y")
	financial_detail_ref_id = document.forms[0].financial_detail_ref_id.value;
	var episode="";
	var record="";
	//MOD#08 new variable is introduced for bl_interfaced_yn( NOT bl_interface?_yn)  and the logic 

	var bl_interfaced_yn =  document.forms[0].bl_interface_yn.value;
	if ( (bl_interfaced_yn == null) || (bl_interfaced_yn == '') )
	{
		bl_interfaced_yn = 'N';
	}
	var patientclass = parent.frames[2].document.AdmitPatient_form.patient_class_id.value;
	var greg_adm_date = "";
	if(document.forms[0].visit_adm_date_time.value!='')
		greg_adm_date = convertDate(document.forms[0].visit_adm_date_time.value,"DMYHM",localeName,"en");


	// End of mod#08
	var qryStr="patientclass="+patientclass+"&operation="+operation+"&package_flag="+package_flag+"&upd_pat_flag="+upd_pat_flag+"&show_hide_blng_class="+show_hide_blng_class+"&patient_id="+patient_id+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value;
	
	qryStr += "&pkg_bill_type="+pkg_bill_type.value+"&pkg_bill_no="+pkg_bill_no.value;
	qryStr += "&episode="+episode+"&record="+record;
	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
	qryStr += "&health_card_expired_yn="+health_card_expired_yn.value+"&Chg_to_Visitor_Grp="+Chg_to_Visitor_Grp.value;
	qryStr += "&bl_interfaced_yn="+bl_interfaced_yn;	
	qryStr += "&bl_future_admn_YN="+bl_future_admn_YN;
	qryStr += "&nursing_unit_code="+nursingUnitCode+"&bed_class_code="+bedClass+"&visit_adm_type="+admissionType;
	/************** added for package billing*********start***************/
	if(package_enabled_yn=="Y"){
		var bed_type		= document.forms[0].bed_type.value;// Added for package billing
		qryStr += "&bed_type="+bed_type;//changed for package billing
	}
	/************** added for package billing*********end***************/		
	qryStr += "&financial_detail_ref_id="+financial_detail_ref_id+"&org_type_ind="+document.forms[0].org_type_ind.value;
	qryStr += "&practitioner_id="+att_practid+"&practitioner_type_ind="+practitioner_type_ind;
	qryStr += "&encounter_date_time="+greg_adm_date;	
	/*Below line Added for this CRF [Bru-HIMS-CRF-261]*/
	qryStr += "&quick_admission="+quick_admission;
	

	var returnArray = new Array();

	returnArray = await getFinDtl(qryStr);

	if(returnArray.length>0)
	{
		billing_group.value     = returnArray[0];
/*
		billing_class.value     = returnArray[1];
		employer_code.value     = returnArray[2];    
		cash_set_type1.value        = returnArray[3];
		cash_insmt_ref1.value       = returnArray[4];
		cash_insmt_date1.value      = returnArray[5];
		cash_insmt_rmks1.value      = returnArray[6];
		cust_1.value            = returnArray[7];
		credit_doc_ref1.value       = returnArray[8];
		credit_doc_date1.value      = returnArray[9];
		cust_2.value            = returnArray[10];
		credit_doc_ref2.value       = returnArray[11];
		credit_doc_date2.value      = returnArray[12];
		cust_3.value            = returnArray[13];
		policy_type.value       = returnArray[14];
		policy_no.value         = returnArray[15];
		policy_expiry_date.value    = returnArray[16];
		non_insur_blng_grp.value    = returnArray[17];
		cash_set_type2.value        = returnArray[18];
		cash_insmt_ref2.value       = returnArray[19];
		cash_insmt_date2.value      = returnArray[20];
		cash_insmt_rmks2.value      = returnArray[21];
		cust_4.value            = returnArray[22];
		credit_doc_ref3.value       = returnArray[23];
		credit_doc_date3.value      = returnArray[24];
		setlmt_ind.value        = returnArray[25];
		upd_fin_dtls.value      = returnArray[26];
		credit_auth_ref.value       = returnArray[27];
		credit_auth_date.value      = returnArray[28];
		app_days.value          = returnArray[29];
		app_amount.value        = returnArray[30];
		annual_income.value		= returnArray[31];    
		family_asset.value		= returnArray[32];   
		no_of_dependants.value		= returnArray[33];
		resp_for_payment.value		= returnArray[34];
		credit_doc_reqd_yn1.value	= returnArray[35];
		credit_doc_reqd_yn2.value	= returnArray[36];
		eff_frm_date.value      = returnArray[37];
		remarks.value           = returnArray[38];
		
		document.forms[0].user_id.value = returnArray[39];
		document.forms[0].cred_st_dt1.value = returnArray[40];
		document.forms[0].cred_st_dt2.value = returnArray[41];
		document.forms[0].cred_st_dt3.value = returnArray[42];
		document.forms[0].gl_holder_name.value = returnArray[43];
		document.forms[0].gl_holder_reln.value = returnArray[44];
*/
		billing_mode.value      = "Modify"
		document.forms[0].bl_success.value = "Y";
		tab_click('admission_tab');
		document.forms[0].visit_adm_type.focus();
	}
	else 
	{
		tab_click('admission_tab');
		return false;
	}
}

async function getFinDtl(qryStr)
{	
	var retVal;
	/*var dialogHeight= "43" ;
	var dialogWidth = "65" ;
	var dialogTop = "71" ;*/
	//	var dialogHeight= "40" ;
		var dialogHeight= "90vh" ;// changed for package billing
	var dialogWidth = "80vw" ;
	var dialogTop = "87" ;
	var center = "1" ;                                                         
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
	retVal = await top.window.showModalDialog(url,arguments,features);
	if(retVal==null) retVal="";
	return retVal;
}

	function calculateDepAmt()
	{
		var patient_id  = parent.Select_frame.document.forms[0].patient_id.value;
		var p_bed_class_code  =  document.forms[0].Bedcode.value;    
		var p_nursing_unit_code = document.forms[0].nursing_unit.value;   
		var p_bed_no = document.forms[0].bed_no.value;
		var setlmt_ind = document.forms[0].setlmt_ind.value;
		if( (patient_id != "" || patient_id !=null) && (p_bed_class_code != "" || p_bed_class_code !=null) && (p_nursing_unit_code != "" || p_nursing_unit_code !=null) && (p_bed_no != "" || p_bed_no !=null) ) 
		{
			HTMLVal = "<HTML><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='DepCalc' id='DepCalc' method='post' action='../../eBL/jsp/CalulateIPDeposit.jsp'><input name='patientId' id='patientId' type='hidden' value='"+patient_id+"'><input name='p_bed_class_code' id='p_bed_class_code' type='hidden' value='"+p_bed_class_code+"'><input name='p_nursing_unit_code' id='p_nursing_unit_code' type='hidden' value='"+p_nursing_unit_code+"'><input name='p_bed_no' id='p_bed_no' type='hidden' value='"+p_bed_no+"'><input name='setlmt_ind' id='setlmt_ind' type='hidden' value='"+setlmt_ind+"'></form></BODY></HTML>";
			parent.dummy.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.dummy.document.DepCalc.submit();
		}
	}
	//End Billing related
	/*
	 *	This fucntion is used to validate expected days 
	 *  Expected days should not be zero
	 */
	function CheckNumVal(obj)
	{
		if(obj.value.length > 0)
		{
			if (Math.abs(obj.value) == 0 )
			{
				alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
				obj.select();
				obj.focus();
			}
			else
			{
				makeValidString(obj);
				CheckNum(obj);
				calcDate(obj);
			}
		}
		else
		document.forms[0].expecteddischargedate.value = "";
	}
	/*
	* This funtion is used to set the date for admission
	*/
	function setDate(val,dat)
	{
		
		if(val != null)
		{
			if(val.value == "")
			{
				if(dat != "")
				val.value=dat;
			}
		}
	}

	/*
	 * This function is used to validate the expected discharge date
	 */ 

	function validateExpDate(obj)
	{
		//if(obj.value != "")
		//{
			if(validDateObj(obj,'DMYHM',localeName))
			{
			
				var greg_VisitAdmDateTime = convertDate(document.forms[0].visit_adm_date_time.value,'DMYHM',localeName,'en');
				var greg_expectedDischargeDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
				//if(!(ValidateDateTime(document.forms[0].visit_adm_date_time,obj)))
				if(isBefore(greg_expectedDischargeDateTime,greg_VisitAdmDateTime,'DMYHM','en'))
				{
					var msg = getMessage("EXP_DIS_DATE_GT_SYSDATE",'IP');
					msg = msg.replace("or equal to Current Date Time",getLabel('Common.AdmDateTime.label','Common'))
					alert(msg);
					obj.value = "";
				}
				return true;
			}
			else
				return false;
		//}

	}
	
	//Added by kishore on 5/12/2004
	function getpatientcode()
	{
		var nursingunit=document.forms[0].nursing_unit.value;
		if(document.forms[0].nursing_unit_desc.value!="")
		{
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''><input type='hidden' name='field4' id='field4' value='patientcode_value'><input type='hidden' name='field5' id='field5' value=''><input type='hidden' name='patient_nursingunit' id='patient_nursingunit' value='"+nursingunit+"'></form></body></html>";
			parent.dummy.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.dummy.document.dum_form.submit();
		}
	}

	function callLoad()
	{
		var patient_classcode = document.forms[0].nursing_unit.value;
	}
	
	function CheckNursingUnit()
	{		
		var nursingunit=document.forms[0].nursing_unit_desc.value;
		if(nursingunit == '')
		{
			document.forms[0].sub_service.value='';
			document.forms[0].bed_no.value='';
			if(parent.frames[0].document.Select_form.bkg_type.value !='D')
			{
				document.forms[0].room_no.value='';
			}
			var obj =document.forms[0].service;		
			var slength  = obj.length;
			for(i=0;i<=slength;i++) 
			{
				obj.remove(0);
			}
			var opt = parent.frames[2].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj.add(opt);

			var obj1 =document.forms[0].sub_service;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
				obj1.remove(0);
			}
			var opt = parent.frames[2].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj1.add(opt);

			var obj1 =document.forms[0].bed_type;
			var length1  = obj1.length;
			for(i=0;i<length1;i++) 
			{
				obj1.remove(0);
			}
			var opt = parent.frames[2].document.createElement('Option');
			opt.value = "";
			opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt.selected = true;
			obj1.add(opt);

			var obj3 =document.forms[0].Bedcode;		
			var slength3  = obj3.length;
			for(i=0;i<=slength3;i++) 
			{
				obj3.remove(0);
			}
			var opt3 = parent.frames[2].document.createElement('Option');
			opt3.value = "";
			opt3.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
			opt3.selected = true;
			obj3.add(opt3);
		}
	}
	
	//++++++++++++++++++ Admission Validation.jsp functions+++++++++++++
	var continueFlag = "Y";
	var temp2 = "";
	var babyfalgyn='';

async function showBillingRemarks()
{
	var patId = document.forms[0].patId.value;
	var module_id = document.forms[0].module_id.value;
	var calling_function_id = document.forms[0].calling_function_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var visit_id = document.forms[0].visit_id.value;
	var arguments = "";
	var param = "patient_id="+patId+"&module_id="+module_id+"&calling_function_id="+calling_function_id+
	"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	//var dialogTop	= "66" ;	
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	await window.showModalDialog( "../../eBL/jsp/BLPatientRemarks.jsp?"+param,arguments,features);

}

//Addition ends here.
async function callConfirmBilling()
{	var retVal;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eBL/jsp/BLBillingGroupConfirm.jsp",arguments,features);
	return retVal;
}

async function invokePatientReg()
{  
	
	var q_booking_ref_no="";
	var booking_type=parent.frames[1].frames[0].document.Select_form.bkg_type.value;
	q_booking_ref_no =parent.frames[1].frames[0].document.Select_form.booking_ref_no.value;
	
	var retVal =    new String();
	var dialogHeight= "400px" ;
	//var dialogWidth = "40" ;
	var dialogWidth = "700px" ; //Modofied for this CRF HSA-CRF-0289
	
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;

	var loc_params = parent.frames[0].location.href
		retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?func_act=Visitreg&q_from_funct=IP_ADMISSION&q_booking_type="+booking_type+"&q_booking_ref_no="+q_booking_ref_no,arguments,features);
	
	parent.frames[0].location.href  = loc_params
	
	
	/*Below line added for this incident ML-Bru-SCF-1486*/
	var nursingunit ="";
	if(parent.frames[1].frames[2].document.forms[0].nursing_unit)nursingunit=parent.frames[1].frames[2].document.forms[0].nursing_unit.value; 
	

	if(retVal!=null) 
	{
		if(retVal!='C')
		{
			pat_flag=retVal.charAt(0);
			if(pat_flag == 'Y')
			{
				var patientid=retVal.substring(1,retVal.length);
				parent.frames[1].frames[0].document.Select_form.patient_id.value = patientid;
				parent.frames[1].frames[0].document.Select_form.pat_flag.value=pat_flag;
			}
			else
			{
				parent.frames[1].frames[0].document.Select_form.patient_id.value = retVal;
				parent.frames[1].frames[0].document.Select_form.patient_id.disabled=false;
				parent.frames[1].frames[0].document.Select_form.patient_id.onblur();
				parent.frames[1].frames[0].document.Select_form.patient_id.disabled=true;
				pat_flag = 'N';
				parent.frames[1].frames[0].document.Select_form.pat_flag.value=pat_flag;
			}

		if(parent.frames[1].frames[0].document.Select_form.patient_id.disabled == true) 	
			parent.frames[1].frames[0].document.Select_form.patient_id.disabled = false;

		if(parent.frames[1].frames[0].document.Select_form.patient_id.readOnly == true) 	
			parent.frames[1].frames[0].document.Select_form.patient_id.readOnly = false;

			//parent.frames[1].frames[0].document.Select_form.patient_id.select(); //Commented by Ashwini on 06-Mar-2019 for MO-CRF-20148

			/*Thursday, March 24, 2011 , SRR20056-SCF-7110 [IN:026926]*/
			var field2=parent.frames[1].frames[0].document.Select_form.patient_id.value
			//Maheshwaran K added "q_booking_ref_no" for the Inc No : 35907 as on 01/11/2012
			//Since Booking Ref no was going as empty while doing Daycare with bookrefno
			/*Below line modified for this incident ML-Bru-SCF-1486*/
			//var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value='"+q_booking_ref_no+"'><input type='hidden' name='field2' id='field2' value='"+field2+"'><input type='hidden' name='field4' id='field4' value='Select_form'></form></body></html>";
            var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value='"+q_booking_ref_no+"'><input type='hidden' name='field2' id='field2' value='"+field2+"'><input type='hidden' name='field4' id='field4' value='Select_form'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursingunit+"'></form></body></html>";		   
		   
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();
			/**/
		}
		else
		{
			parent.frames[1].frames[2].location.reload();
			parent.frames[1].Select_frame.location.reload();
			
			if(retVal=='C')
				continueFlag = "N";
		}
	}
  }
	
async function invokePatientRegRef(pRefID)
{  
	
	var q_booking_ref_no = parent.frames[1].frames[0].document.Select_form.booking_ref_no.value;
	var booking_type=parent.frames[1].frames[0].document.Select_form.bkg_type.value;
	var retVal =    new String();
	var dialogHeight= "400px" ;
	//var dialogWidth = "40" ;
	var dialogWidth = "700px" ; //Modofied for this CRF HSA-CRF-0289
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	/*Below line added for this incident ML-Bru-SCF-1477*/
	var nursingunit ="";	
	if(parent.frames[1].frames[2].document.forms[0].nursing_unit)nursingunit =parent.frames[1].frames[2].document.forms[0].nursing_unit.value; 
	
	
	var loc_params = parent.frames[0].location.href
		retVal = await window.showModalDialog("../../eMP/jsp/VisitRegistrationPromptPatID.jsp?calledFrom=IP&func_act=REF_SEARCH&q_from_funct=IP_ADMISSION&q_booking_ref_no="+q_booking_ref_no+"&q_booking_type="+booking_type+"&p_referral_id="+pRefID,arguments,features);

	parent.frames[0].location.href  = loc_params
	if(retVal!=null) 
	{
		if(retVal!='C')
		{
			pat_flag=retVal.charAt(0);
			if(pat_flag == 'Y')
			{
				var patientid=retVal.substring(1,retVal.length);
				parent.frames[1].frames[0].document.Select_form.patient_id.value = patientid;
				parent.frames[1].frames[0].document.Select_form.pat_flag.value=pat_flag;
			}
			else
			{
				parent.frames[1].frames[0].document.Select_form.patient_id.value = retVal;
				
				parent.frames[1].frames[0].document.Select_form.patient_id.disabled=false;
				parent.frames[1].frames[0].document.Select_form.patient_id.onblur();
				parent.frames[1].frames[0].document.Select_form.patient_id.disabled=true;
				pat_flag = 'N';
				parent.frames[1].frames[0].document.Select_form.pat_flag.value=pat_flag;
			}

		if(parent.frames[1].frames[0].document.Select_form.patient_id.disabled == true) 	
			parent.frames[1].frames[0].document.Select_form.patient_id.disabled = false;

		if(parent.frames[1].frames[0].document.Select_form.patient_id.readOnly == true) 	
			parent.frames[1].frames[0].document.Select_form.patient_id.readOnly = false;
			
			//parent.frames[1].frames[0].document.Select_form.patient_id.select(); //Commented by Ashwini on 06-Mar-2019 for MO-CRF-20148
			/*Thursday, March 24, 2011 , SRR20056-SCF-7110 [IN:026926]*/
			var field2=parent.frames[1].document.frames[0].document.Select_form.patient_id.value
			/*Below line modified for this incident ML-Bru-SCF-1477*/
			//var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='"+field2+"'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field4' id='field4' value='Select_form'></form></body></html>";
			var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='"+field2+"'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursingunit+"'><input type='hidden' name='field4' id='field4' value='Select_form'></form></body></html>";
		
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.dum_form.submit();
			/**/
			
		}
		else
		{
			
			parent.frames[1].frames[2].location.reload();
			parent.frames[1].Select_frame.location.reload();
	
			if(retVal=='C')
				continueFlag = "N";
		}
	}
}

function enableDisable()
{
	if(document.AdmissionValidation_form.enablespeciality.value == 'Y')
	{
		parent.frames[1].frames[0].document.Select_form.patient_id.readOnly = true;
	}
	parent.frames[1].frames[2].document.AdmitPatient_form.exp_days_stay.readOnly = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.team_id.disabled = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.Bedcode.disabled = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.nursing_unit.disabled = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_type.disabled = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.arrival_code.disabled = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.ambulatory_status.disabled = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.admissiondate_readonly.value=="")
	{
		parent.frames[1].frames[2].document.AdmitPatient_form.visit_adm_date_time.readOnly = false;
		if(parent.frames[1].frames[2].document.AdmitPatient_form.backdated_admission_yn.value=='Y')
			parent.frames[1].frames[2].document.getElementById("AdmissiondateImg").disabled = false;
		if(parent.frames[1].frames[2].document.AdmitPatient_form.AdmitDate!=null)
		parent.frames[1].frames[2].document.AdmitPatient_form.AdmitDate.disabled = false;
	}
	parent.frames[1].frames[2].document.AdmitPatient_form.chief_complaint.readOnly = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.ot_date_time.readOnly = false;
	parent.frames[1].frames[2].document.getElementById('OTDate').disabled = false;	
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_name.readOnly = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln1)
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln1.readOnly = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln2)
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln2.readOnly = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln3)
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln3.readOnly = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln4)
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_ln4.readOnly = false;
	if(parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_postal_code)
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_add_postal_code.readOnly = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_tel_num.readOnly = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.escort_mv_regn_no.readOnly = false;
	parent.frames[1].frames[2].document.AdmitPatient_form.emergency_detail.readOnly = false;	
	//parent.frames[1].frames[0].document.Select_form.booking_ref_no.readOnly = true;	
		/*Above line commented and below line added for this SCF MMS-SCF-0105 [IN:043502]*/
	parent.frames[1].frames[0].document.Select_form.booking_ref_no.disabled = true;
}

function makeDisabled(booleanFlag)
{
	if(parent.frames.length>1)		
	{
	 if(parent.frames[1].frames.length>0)
	 {
		if(parent.frames[1].frames[0].document.Select_form && parent.frames[1].frames[0].name=="Select_frame")
		{
			var booking_ref_no		=	parent.frames[1].frames[0].document.Select_form.booking_ref_no;
			var patient_id			=	parent.frames[1].frames[0].document.Select_form.patient_id;
			var referral_id			=	parent.frames[1].frames[0].document.Select_form.referral_id;
			var book_ref_no_search	=	parent.frames[1].frames[0].document.Select_form.book_ref_no_search;
			var patient_id_search	=	parent.frames[1].frames[0].document.Select_form.patient_id_search;
			var referral_id_search	=	parent.frames[1].frames[0].document.Select_form.referral_id_search;
			if( (trimCheck(booking_ref_no.value)) || (trimCheck(patient_id.value)) || (trimCheck(referral_id.value)))
			{						
				if(parent.frames[1].frames[0].document.Select_form.referral_id.value != "")
					parent.frames[1].frames[3].document.getElementById('referal_details').disabled = false
				else
					parent.frames[1].frames[3].document.getElementById('referal_details').disabled = true

				if(booleanFlag)
				{
					parent.frames[1].frames[0].proceedFurther = true;
				}
				if((parent.frames[1] && parent.frames[1].frames[2]) && (parent.frames[1].frames[2].document.forms[0].from_adv_bed_mgmt && parent.frames[1].frames[2].document.forms[0].from_adv_bed_mgmt.value=='Y')){
					//window.close();
				}else{
				
					/*booking_ref_no.readOnly			=	booleanFlag;
					referral_id.readOnly			=	booleanFlag;*/
					/*Above line commented and belwo line added for this SCF MMS-SCF-0105 [IN:043502]*/
					booking_ref_no.disabled			=	booleanFlag;
					referral_id.disabled			=	booleanFlag;	
					//End MMS-SCF-0105 [IN:043502]					
					book_ref_no_search.disabled		=	booleanFlag;
					referral_id_search.disabled		=	booleanFlag;
				}
				
			}
			else
				parent.frames[1].frames[0].proceedFurther = true;
		 }
	  }
	}
}

function enableFlds()
{
	var call_func = parent.frames[2].document.AdmitPatient_form.call_func.value;
	if(call_func != "PATREG")
	{
		var admissionFor = parent.frames[0].document.getElementsByName('admission_for')[0].value;
		var booking_ref_no = parent.frames[0].document.Select_form.booking_ref_no.value;
		var referral_id = parent.frames[0].document.Select_form.referral_id.value;
		var patient_id = parent.frames[0].document.Select_form.patient_id.value;

		if(admissionFor == 'D')
		{
			if(booking_ref_no != "" || referral_id != "" || patient_id != "")
			{
				parent.frames[0].document.Select_form.reset();
				parent.frames[0].document.Select_form.admission_for.options[2].selected =true;
				parent.frames[1].location.href ="../../eCommon/html/blank.html" ;
				parent.frames[2].location.reload();
				parent.frames[3].location.reload();
				 // added by munisekhar for MMS-QH-CRF-0162
	            var isSiteSpe_change_pat = parent.frames[0].document.Select_form.isSiteSpe_change_pat_dtls.value;
				var userFunRightsCount	= parseInt(parent.frames[0].document.Select_form.userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]

               if(isSiteSpe_change_pat=="true" && userFunRightsCount > 0)
	            parent.frames[0].document.getElementById('Update_pat').style.visibility="hidden";
			}
		
			parent.frames[0].document.Select_form.booking_ref_no.disabled=false;
			parent.frames[0].document.Select_form.booking_ref_no.readOnly=false;
			parent.frames[0].document.Select_form.book_ref_no_search.disabled=false;
			//Below two lines modified by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1289
			parent.frames[0].document.Select_form.referral_id.disabled=false;
			parent.frames[0].document.Select_form.referral_id_search.disabled=false;

			parent.frames[0].document.Select_form.patient_id.disabled=false;
			parent.frames[0].document.Select_form.patient_id.readOnly=false;
			parent.frames[0].document.Select_form.patient_id_search.disabled=false;
		}
		else if(admissionFor == 'I')
		{
			if(booking_ref_no != "" || referral_id != "" || patient_id != "")
			{
				parent.frames[0].document.Select_form.reset();
				parent.frames[0].document.Select_form.admission_for.options[1].selected =true;
				parent.frames[1].location.href ="../../eCommon/html/blank.html" ;
				parent.frames[2].location.reload();
				parent.frames[3].location.reload();
				 // added by munisekhar for MMS-QH-CRF-0162
	            var isSiteSpe_change_pat=parent.frames[0].document.Select_form.isSiteSpe_change_pat_dtls.value;
				var userFunRightsCount	= parseInt(parent.frames[0].document.Select_form.userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]

               if(isSiteSpe_change_pat=="true" && userFunRightsCount > 0)
	            parent.frames[0].document.getElementById('Update_pat').style.visibility="hidden";
			}
			
		}
		else
		{
			parent.frames[0].document.Select_form.booking_ref_no.value='';
			parent.frames[0].document.Select_form.booking_ref_no.disabled=true;
			parent.frames[0].document.Select_form.book_ref_no_search.disabled=true;

			parent.frames[0].document.Select_form.referral_id.value='';
			parent.frames[0].document.Select_form.referral_id.disabled=true;
			parent.frames[0].document.Select_form.referral_id_search.disabled=true;

			parent.frames[0].document.Select_form.patient_id.value='';
			parent.frames[0].document.Select_form.patient_id.disabled=true;
			parent.frames[0].document.Select_form.patient_id_search.disabled=true;
			 // added by munisekhar for MMS-QH-CRF-0162
	            var isSiteSpe_change_pat=parent.frames[0].document.Select_form.isSiteSpe_change_pat_dtls.value;
				var userFunRightsCount	= parseInt(parent.frames[0].document.Select_form.userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]

               if(isSiteSpe_change_pat=="true" && userFunRightsCount > 0)
	            parent.frames[0].document.getElementById('Update_pat').style.visibility="hidden";
			parent.frames[0].location.reload();
			parent.frames[1].location.href ="../../eCommon/html/blank.html" ;
			parent.frames[2].location.reload();
			parent.frames[3].location.reload();
		}
	}
}

// added by Sridhar R on 11/28/2005 ...
// this function will enable & disable patientID/ReferralID/BookingRefNo based on IP param value...
function allowedAdmissionType()
{
	var allowed_admission_type = parent.frames[0].document.Select_form.allowed_admission_type.value;

	parent.frames[0].document.Select_form.bkg_type.value = parent.frames[0].document.Select_form.admission_for.value;

	if(allowed_admission_type == "D") // Direct admission
	{
		parent.frames[0].document.Select_form.booking_ref_no.disabled=false;
		/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.booking_ref_no.readOnly=false;
		parent.frames[0].document.Select_form.book_ref_no_search.disabled=false;
		/*Tuesday, January 19, 2010 condition added to disabled referral when daycare selected , IN017774*/
		//if(parent.frames[0].document.Select_form.admission_for.value != "D")//Commented by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1289
		//{
		parent.frames[0].document.Select_form.referral_id.disabled=false;
		/*Below line commeneted for SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.referral_id.readOnly=false;
		parent.frames[0].document.Select_form.referral_id_search.disabled=false;
		//}
				
		parent.frames[0].document.Select_form.patient_id.disabled=false;
		/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.patient_id.readOnly=false;
		parent.frames[0].document.Select_form.patient_id_search.disabled=false;
	}
	else if(allowed_admission_type == "B") // Admission by booking
	{
		parent.frames[0].document.Select_form.booking_ref_no.disabled=false;
		parent.frames[0].document.Select_form.booking_ref_no.readOnly=false;
		parent.frames[0].document.Select_form.book_ref_no_search.disabled=false;

		parent.frames[0].document.Select_form.referral_id.disabled=true;
		/*Below line commeneted for SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.referral_id.readOnly=true; 
		parent.frames[0].document.Select_form.referral_id_search.disabled=true;

		parent.frames[0].document.Select_form.patient_id.disabled=true;
		/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.patient_id.readOnly=true;
		parent.frames[0].document.Select_form.patient_id_search.disabled=true;
	}
	else if(allowed_admission_type == "R") // Admission by Referral
	{
		/*Tuesday, January 19, 2010 condition added to disabled referral when daycare selected , IN017774*/
		//Below if block commented by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1289
		//if(parent.frames[0].document.Select_form.admission_for.value == "D")
		//{
			/*alert(getMessage("ADM_FOR_DC_NOT_ALLOWD","IP"));
			parent.frames[0].document.Select_form.admission_for.value = "";

			parent.frames[0].document.Select_form.booking_ref_no.disabled=true;
			/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
			//parent.frames[0].document.Select_form.booking_ref_no.readOnly=true;
			/*parent.frames[0].document.Select_form.book_ref_no_search.disabled=true;
			
			parent.frames[0].document.Select_form.patient_id.disabled=true;
			/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
			//parent.frames[0].document.Select_form.patient_id.readOnly=true;
		/*	parent.frames[0].document.Select_form.patient_id_search.disabled=true;

			parent.frames[0].location.reload();
			parent.frames[1].location.href ="../../eCommon/html/blank.html" ;
			parent.frames[2].location.reload();
			parent.frames[3].location.reload();

		}else
		{*/
		        parent.frames[0].document.Select_form.booking_ref_no.disabled=true;
		        parent.frames[0].document.Select_form.booking_ref_no.readOnly=true;
		        parent.frames[0].document.Select_form.book_ref_no_search.disabled=true;

		        parent.frames[0].document.Select_form.referral_id.disabled=false;
				/*Below line commeneted for SCF MMS-SCF-0105 [IN:043502]*/
		        //parent.frames[0].document.Select_form.referral_id.readOnly=false;
		        parent.frames[0].document.Select_form.referral_id_search.disabled=false;

		        parent.frames[0].document.Select_form.patient_id.disabled=true;
				/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
		       // parent.frames[0].document.Select_form.patient_id.readOnly=true;
		        parent.frames[0].document.Select_form.patient_id_search.disabled=true;
	        //}
	}
	if(allowed_admission_type == "Z") // Referral or Booking
	{
		parent.frames[0].document.Select_form.booking_ref_no.disabled=false;
		parent.frames[0].document.Select_form.booking_ref_no.readOnly=false;
		parent.frames[0].document.Select_form.book_ref_no_search.disabled=false;
		/*Tuesday, January 19, 2010 condition added to disabled referral when daycare selected , IN017774*/
		//Below line commented by Thamizh selvi on 31st Jan 2019 against ML-MMOH-CRF-1289
		//if(parent.frames[0].document.Select_form.admission_for.value != "D")
		//{
		parent.frames[0].document.Select_form.referral_id.disabled=false;
		/*Below line commeneted for SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.referral_id.readOnly=false;
		parent.frames[0].document.Select_form.referral_id_search.disabled=false;
		//}
		parent.frames[0].document.Select_form.patient_id.disabled=true;
		/*Below line commented for this SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.patient_id.readOnly=true;
		parent.frames[0].document.Select_form.patient_id_search.disabled=true;
	}
	if(parent.frames[0].document.Select_form.from_adv_bed_mgmt.value=='Y'){
		parent.frames[0].document.Select_form.booking_ref_no.disabled=true;
		parent.frames[0].document.Select_form.booking_ref_no.readOnly=true;
		parent.frames[0].document.Select_form.book_ref_no_search.disabled=true;
		parent.frames[0].document.Select_form.referral_id.disabled=true;
		/*Below line commeneted for SCF MMS-SCF-0105 [IN:043502]*/
		//parent.frames[0].document.Select_form.referral_id.readOnly=true;  
		parent.frames[0].document.Select_form.referral_id_search.disabled=true;
	}
}

 
/*
* This funtion is used to validate id and populates the values
* Arg1		: Calling object like referral id, booking ref no ,patient id
* Arg2		: Calling function like referral, booking ,patient
*/
function validatePat(obj,fld_lgnd) 
{
	/*Thursday, January 20, 2011 , document.Select_form.validatePat_yn.value added for SRR20056-SCF-6544 [IN:026019*/
	/*disabled the patient Search lookup*/
	
	
	if(trimCheck(obj.value)=="") return false;
	if((validatePat!='' && validatePat !=null ) && document.Select_form.validatePat_yn.value == 'N')
	{
		document.Select_form.validatePat_yn.value = 'Y';
		
	  if(document.Select_form.referral_id&&document.Select_form.referral_id.value!="") document.Select_form.patient_id_search.disabled = true;
			
		var fields = new Array(obj);
		var names = new Array(fld_lgnd);
		if(SpecialCharCheck(fields,names,'',"A",'') )
		{
			//validateSelect(obj.name);
			setTimeout("validateSelect(this)",700);			
		}
		else
		{
			obj.select()
			obj.focus()
		}
			
   }   

   
}

/*
 * This function will call the AdmissionValidation.jsp if patient id or referral id * or enocutner id or booking ref no exists
 */
function validateSelect(obj) 
{ 
	parent.frames[1].location.href = '../../eCommon/html/blank.html';
	if( document.Select_form.patient_id.value != "")
		var patient     = document.Select_form.patient_id.value;
	else
		var patient="";
	initFields();
	
	var isUHID_valid_appl = document.Select_form.isUHID_valid_appl.value; // added by mujafar for AMRI-CRF-0357
    var admission_for  = document.Select_form.admission_for.value;
	var bookingref		= document.Select_form.booking_ref_no.value;
	var referralid      = document.Select_form.referral_id.value;
	var operatorstation = document.Select_form.operator_station.value;
	var bkg_type		= document.Select_form.admission_for.value;
	var queryString		= document.Select_form.queryString.value;	
	var bkg_grace_period= document.Select_form.bkg_grace_period.value;	
	var called_from     = document.forms[0].called_from.value

	/*Below line Added for this CRF [Bru-HIMS-CRF-261]*/
	var quick_admission_type="";
	if(document.Select_form.quick_admission_type)
	quick_admission_type=document.Select_form.quick_admission_type.value;
    //End Bru-HIMS-CRF-261]
	var visit_adm_date_time = "";
	if(parent.frames[2].document.AdmitPatient_form != null)
	{
		if(parent.frames[2].document.AdmitPatient_form.visit_adm_date_time)
		//visit_adm_date_time	=	parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.value;
		visit_adm_date_time	=	convertDate(parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.value,'DMYHM',localeName,'en');
	}
	if( !(proceedFurther) && actionOnField!=obj ) 
	{
		return false;
	}
	proceedFurther	=	false;
	actionOnField	=	obj;

	var bl_interface_yn = "N";
	var bl_instal_yn;
	
	
	if (document.Select_form.called_from.value == "NEWBORN_REG")
	{
			bl_interface_yn=document.Select_form.bl_interface_yn.value;
			bl_instal_yn=document.Select_form.bl_install_yn.value;
	}
	else
	{
			if(parent.frames[2].document.AdmitPatient_form.bl_interface_yn != null){
				if(parent.frames[2].document.AdmitPatient_form.bl_interface_yn.value)
				bl_interface_yn = "Y";
				bl_instal_yn=parent.frames[2].document.AdmitPatient_form.bl_install_yn.value;
			}

	}
	/*Saturday, January 09, 2010 ,This code is added to get patient_id when booking reference no is given and tab out from booking ref no field in Admit Patient screen.since patient value is going null to the AdmissionValidation.jsp and validation for CURRENTLY_IN_PATIENT was not working*/
		if(bookingref != "" && patient == "")
		{
			var operatorstation  = document.Select_form.operator_station.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH step='four' bookingref=\""+bookingref+"\"  operatorstation=\""+operatorstation+"\" bkg_type =\""+bkg_type+"\"/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			patient = responseText
			
		}
	
		if(referralid !=''  || bookingref != '' || patient != '' )
		{ 
		   /*Below line Modified for this CRF Bru-HIMS-CRF-261 quick_adm_referralid*/
			
		
		 	var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/AdmissionValidation.jsp'>"+
			"<input type='hidden' name='field1' id='field1' value=\""+bookingref+"\"> "+
			"<input type='hidden' name='bkg_grace_period' id='bkg_grace_period' value=\""+bkg_grace_period+"\"> "+
			"<input type='hidden' name='admission_for' id='admission_for' value=\""+admission_for+"\"> "+
			"<input type='hidden' name='field2' id='field2' value=\""+patient+"\">"+
			"<input type='hidden' name='field4' id='field4' value='Select_form'>"+
			"<input type='hidden' name='field5' id='field5' value=\""+referralid+"\"> "+
			"<input type='hidden' name='queryString' id='queryString' value=\""+queryString+"\"> "+
			"<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value=\""+visit_adm_date_time+"\"> "+
			"<input type='hidden' name='booking_type' id='booking_type' value=\""+bkg_type+"\"> "+
			"<input type='hidden' name='operator_station' id='operator_station' value=\""+operatorstation+"\"> "+
			"<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value=\""+bl_interface_yn+"\"> "+
			"<input type='hidden' name='regfromquery' id='regfromquery' value='Y'> "+
			"<input type='hidden' name='bl_install_yn' id='bl_install_yn' value=\""+bl_instal_yn+"\"> "+
			"<input type='hidden' name='quick_admission_type' id='quick_admission_type' value=\""+quick_admission_type+"\"> "+
			"<input type='hidden' name='chk_pr_enc_ref_man' id='chk_pr_enc_ref_man' value='Y'> "+// Added By Dharma for Non-Citizen Validation on 27th Dec 2013
			"<input type='hidden' name='isUHID_valid_appl' id='isUHID_valid_appl' value=\""+isUHID_valid_appl+"\"> "+ // added by mujfafar for AMRI-CRF-0357
			"</form></body></html>";
			
			if (called_from=="NEWBORN_REG")
			{
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.dum_form.submit();
			}
			else
			{
					if(parent.frames[2].document.forms[0].from_adv_bed_mgmt.value=='N'){//below changed for ABM  CRF 643.1 ICN:36736
						/*if(top.content.messageFrame.document.body)
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						if(top.content.messageFrame.document.dum_form)
						top.content.messageFrame.document.dum_form.submit();*/
						/*Above line commented and below line Added for this CRF  Bru-HIMS-CRF-261*/
						if(parent.frames[2].document.forms[0].quick_admission_type){ 
						 if(parent.frames[2].document.forms[0].quick_admission_type.value=="Y"){ 
						 if(parent.parent.messageFrame.document.body)
							parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						if(parent.parent.messageFrame.document.dum_form)
							parent.parent.messageFrame.document.dum_form.submit();
						}else{ 
						if(top.content.messageFrame.document.body)
						top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						if(top.content.messageFrame.document.dum_form)
						top.content.messageFrame.document.dum_form.submit();
						
						   }
						}
						// End this CRF Bru-HIMS-CRF-261
					}else { 
						if(parent.parent.messageFrame.document.body)
							parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						if(parent.parent.messageFrame.document.dum_form)
							parent.parent.messageFrame.document.dum_form.submit();
					}
			}
			

		}
	

	
}
async function dispAuth(outstamt, patient_id,module_id )
{
	

	if(module_id == 'I')
		module_id = 'IP';
	else if(module_id == 'D')
		module_id = 'DC';
	
	var retVal =    new String();
	var dialogHeight= "400px" ;
	var dialogWidth = "700px" ;
	var status = "no";
	var arguments   = "" ;
	var frame_list;
	frame_list =  parent.frames[1].frames[2].document.forms[0];

	var patient_id=patient_id;
	var outst_amount = outstamt;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eBL/jsp/dispCreditAuth.jsp?patient_id="+patient_id+"&calling_module_id="+module_id+"&outst_amt="+outst_amount,arguments,features);
	
	if (retVal == null) retVal="";	

	if ( retVal[0] == "N" || retVal[0] == undefined ||  retVal[0] == "undefined" )
	{
		if(parent.frames[1].frames[0].document.Select_form.patient_id != null)
		{
			parent.frames[1].frames[0].document.Select_form.patient_id.value = "";
		}
		if(parent.frames[0].document.getElementById('reset')){
			parent.frames[0].document.getElementById('reset').click();
		}
	}
	else
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")  /// this is the new condition added
			{
						frame_list.remarks.value=retVal[2];
						frame_list.user_id.value=retVal[3];
						frame_list.upd_user_flag.value = "Y";						
			}
		}
	}

}
	// code added for scrum 2010 Saturday, January 23, 2010 10638
async function funPatRegCharges(patient_id)
{
	var patient_id =  patient_id;
		//var retVal_BL =    new String();

		var center='1';
		var dialogTop = "30";
		var dialogHeight = "400px" ;
		var dialogWidth = '700px' ;
		var title='Pat Reg Charges'
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"step1=STEP_OTH&function_id=ADMIT_PAT&"+"patient_id="+patient_id;	
		


		retVal_BL= await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDetValidationFrame.jsp?"+param,arguments,features);
		
			if ((retVal_BL == "N")  || (retVal_BL == undefined) ||  (retVal_BL == "undefined"))  
	{
		if(parent.frames[0].document.getElementById('reset')){
			parent.frames[0].document.getElementById('reset').click();
		}			
	}   
		
}
/**********These functions are added for package billing************starts**/
function onPkgEli(obj,package_enabled_yn)
{
	if(package_enabled_yn=="Y")
	{
		var patientid  = parent.Select_frame.document.forms[0].patient_id.value;
		var bed_type=obj.value;
		if(bed_type!="")
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "bed_type=\"" + bed_type + "\" " ;												
			xmlStr+= "patientid=\"" + patientid + "\" " ;												
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/PkgSubscriptionBedTypeValidation.jsp?func_mode=BED_TYPE_CHK";					
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=eval(xmlHttp.responseText) ;
		}
	}
}

function callBedTypeAlert()
{
	//alert("Bed Type Changed. Please Subscribe the Package Again");
	alert(getMessage("BL8667","BL"));
}
/**********added for package billing********************************ends**/

