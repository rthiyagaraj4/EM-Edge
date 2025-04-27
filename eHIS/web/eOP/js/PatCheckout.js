//Added for Disposition type
	var deceased_ind_arr = new Array();
	var absconded_ind_arr = new Array(); //Added by Sangeetha for ML-MMOH-CRF-0630
	var mds_code_arr	  = new Array();
	var call_not_around_arr	= new Array();//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
	var count			  = 0;
	var cnt = 0;
	//
	var loc_val="";
	var dest_loc_val="";
	var sub = "Y";
	var location0_array = new Array () ;
//Added for Disposition type

var  obj_arr;  

async function funQry()

{
	if(parent.frames[1].document.forms[0].bl_install_yn.value=="Y")
	{
		 var allow_chkout_with_bill_stmt_yn = parent.frames[1].document.forms[0].allow_chkout_with_bill_stmt_yn.value;
         var module_id = parent.frames[1].document.forms[0].module_id.value;

		 if (module_id == 'AE' && allow_chkout_with_bill_stmt_yn =="Y")
	      {	
		   await get_Billval();
		   var settle_outstanding_bills_yn = parent.frames[1].document.forms[0].settle_outstanding_bills_yn.value;
		   var p_err_msg = parent.frames[1].document.forms[0].p_err_msg.value;
		   var p_error_level = parent.frames[1].document.forms[0].p_error_level.value;
		   var p_error_text = parent.frames[1].document.forms[0].p_error_text.value;

		   //alert('settle_outstanding_bills_yn comessss 111 == '+settle_outstanding_bills_yn);
		   //alert('p_err_msg == comessss 111 ==  '+p_err_msg);

		    if (p_err_msg !='' )
			{
				if (settle_outstanding_bills_yn == 'Y' )
				{
					 alert(getMessage(p_err_msg,"BL"));
					 parent.frames[1].document.getElementById('billingLinktable').style.visibility='visible';
					 return false;  
				}
				else if (settle_outstanding_bills_yn == 'N')
				{
					 alert(getMessage(p_err_msg,"BL"));
					 parent.frames[1].document.getElementById('billingLinktable').style.visibility='hidden';
					 return false;
				}
			}
		  }
		var retVal;

		var dialogHeight= "35vh";

		var dialogWidth  = "45vw";

		var dialogTop = "10";

		var center = "1" ;                                                                                                                                                                           

		var status="no";

		var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		var arguments    = "" ;

		

		var clinic_code=parent.frames[1].document.forms[0].location_code.value

		var visit_type_code=parent.frames[1].document.forms[0].visit_type_code.value;

		var patient_id=parent.frames[1].document.forms[0].patient_id.value    


		var episode_type=parent.frames[1].document.forms[0].episode_type.value
			
		var episode_id=parent.frames[1].document.forms[0].episode_id.value
			

		var visit_id=parent.frames[1].document.forms[0].episode_visit_num.value

		var encounter_id=parent.frames[1].document.forms[0].Encounter.value

		var facility_id=parent.frames[1].document.forms[0].facility_id.value

		var calling_module_id=parent.frames[1].document.forms[0].module_id.value;				

		var calling_function_id="CHECKOUT_VISIT";
		
		var logged_user_id=parent.frames[1].document.forms[0].userid.value
		
		var practitioner_id=parent.frames[1].document.forms[0].attending_practitioner.value

		var practitioner_type_ind="P"
		



// all these values are mandatory for our operation.Kindly pass appropriate values to the above variables

		//CRF-362 Based Bed allocation Bed charges we are contrlloing the 

		var ae_bed_charge_appl_yn=parent.frames[1].document.forms[0].ae_bed_charge_appl_yn.value;
		var ae_treatment_area_code=parent.frames[1].document.forms[0].ae_treatment_area_code.value;
		//var bed_no=parent.frames[1].document.forms[0].bed_no.value;
		var module_id=parent.frames[1].document.forms[0].module_id.value;
		var ae_bed_calYN=parent.frames[1].document.forms[0].ae_bed_calYN.value;
		
		  if(module_id=='AE'&& ae_bed_calYN!='N') {

			if(ae_bed_charge_appl_yn=='N'||ae_treatment_area_code=='') {

			var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_charge_appl_yn="+ae_bed_charge_appl_yn+"&ae_treatment_area_code="+ae_treatment_area_code+"&patientPayble="+document.getElementById("patientPayble").value+"&charge_net_amt="+document.getElementById("charge_net_amt").value+"&ae_bed_charge_appl_yn="+ae_bed_charge_appl_yn+"&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind; 	
				retVal = await window.showModalDialog(url,arguments,features);

		
				} else {
		
			var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="callfunc=bedChargeAEChkOut&patient_id="+patient_id+"&encounterId="+encounter_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"";
				
				var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=trimString(xmlHttp.responseText);
				var retVal = responseText.split("&^&");
				
				
							if(retVal!='') {
							
								if(retVal[0]=='err'){
									var err_message=retVal[1];
									alert(err_message);
									window.returnValue=1;
									
								} else 		{

									var charge_net_amt="";
									var patientPayble="";
									charge_net_amt=retVal[1];
									  patientPayble=retVal[2];

									var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_charge_appl_yn="+ae_bed_charge_appl_yn+"&ae_treatment_area_code="+ae_treatment_area_code+"&patientPayble="+patientPayble+"&charge_net_amt="+charge_net_amt+"&ae_bed_charge_appl_yn="+ae_bed_charge_appl_yn+"&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind; 									

									retVal = await window.showModalDialog(url,arguments,features);

								} 
					       }
		           }
	        } 
			
			else {
				var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?ae_bed_calYN="+ae_bed_calYN+"&call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind; 
				retVal = await window.showModalDialog(url,arguments,features);
			}
		
	
		if(retVal=="1")

		{            return true;  

		}

		else

	    {           return false;

				   

		}
	}
	else
	{
	return true;
	}
}

function get_Billval()
{
	var patient_id		=	parent.frames[1].document.forms[0].patient_id.value;
	var episode_id		=	parent.frames[1].document.forms[0].episode_id.value;
	var visit_id		=	parent.frames[1].document.forms[0].visit_id.value;    
	var encounter_id	=	parent.frames[1].document.forms[0].Encounter.value;
	var module_id		=	parent.frames[1].document.forms[0].module_id.value;
	var function_id		=	"CHECKOUT_VISIT";
	var episode_type	=	"E";
	var bl_install_yn	=	parent.frames[1].document.forms[0].bl_install_yn.value;
	var allow_chkout_with_bill_stmt_yn = parent.frames[1].document.forms[0].allow_chkout_with_bill_stmt_yn.value;


	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
			
	var param="patient_id="+patient_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&module_id="+module_id+"&function_id="+function_id+"&episode_type="+episode_type+"&bl_install_yn="+bl_install_yn+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&bl_flag=Y";

	var temp_jsp="../../eOP/jsp/PatCheckoutGetBLVal.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);

	var retVal = responseText.split("&:&");
	
	parent.frames[1].document.forms[0].settle_outstanding_bills_yn.value = retVal[0];
	var p_error_level_val = retVal[1];
	var p_err_msg_val = retVal[2];
	var p_error_text_val = retVal[3];
    
	if (p_error_level_val==" ")
	{
		p_error_level_val ="";
	}
	if (p_err_msg_val==" ")
	{
		p_err_msg_val ="";
	}
	if (p_error_text_val==" ")
	{
		p_error_text_val ="";
	}
	parent.frames[1].document.forms[0].p_error_level.value = p_error_level_val;
	parent.frames[1].document.forms[0].p_err_msg.value = p_err_msg_val;
	parent.frames[1].document.forms[0].p_error_text.value = p_error_text_val;

}


async function callbilling(){
	    var retVal;
		var center			=	'1';
		var dialogTop		=	"220";
		var dialogHeight	=	"90vh" ;
		var dialogWidth		=	"90vw" ;                             
		var status			=	"no";
		var features        =	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		=	"" ;

		var patient_id		=	parent.frames[1].document.forms[0].patient_id.value
		var episode_id		=	parent.frames[1].document.forms[0].episode_id.value;
		var visit_id		=	parent.frames[1].document.forms[0].visit_id.value;    
		var encounter_id	=	parent.frames[1].document.forms[0].Encounter.value;
		var module_id		=	parent.frames[1].document.forms[0].module_id.value;
		var allow_chkout_with_bill_stmt_yn=parent.frames[1].document.forms[0].allow_chkout_with_bill_stmt_yn.value;		
		var function_id		=	"CHECKOUT_VISIT";
		var episode_type	=	"E";

		var url = "../../eBL/jsp/BLMultiBillSlmtMain.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&module_id="+module_id+"&function_id="+function_id+"&alw_co_wit_bl_slmt_yn="+allow_chkout_with_bill_stmt_yn;     

		retVal = await top.window.showModalDialog(url,arguments,features);

		if(retVal != null && retVal != "" )
	    {
          if (retVal=="Y")
	      {
            parent.frames[1].document.getElementById('billingLinktable').style.visibility='hidden';
		  }
		}
}


function onSuccessCloseWin(p_patient_id,encounter_id) {

	var cls_chart_yn = document.forms[0].cls_pat_chart_on_chkout_yn.value;	

	if(cls_chart_yn=='Y')
	{
		visit_id = document.forms[0].visit_id.value;		
		wname = p_patient_id+encounter_id+visit_id;		
		
		top.content.messageFrame.document.write("<html><body onKeyDown='lockKey();'><form name='openChartWrapperIntermediateForm' id='openChartWrapperIntermediateForm' method='post' action='../eCA/jsp/OpenChartWrapperIntermediate.jsp'><input type='hidden' name='patientID' id='patientID' value='"+p_patient_id+"'><input type='hidden' name='episodeID' id='episodeID' value='"+encounter_id+"'><input type='hidden' name='child_window' id='child_window' value='Y'><input type='hidden' name='FromPatChart' id='FromPatChart' value=''><input type='hidden' name='FromCloseOrSwitch' id='FromCloseOrSwitch' value='Close'><input type='hidden' name='windName' id='windName' value='"+wname+"'></form></body></html>");

		top.content.messageFrame.openChartWrapperIntermediateForm.submit();
		top.opener.focus();			
		
		if(top.opener.location.href) {
			if(top.opener.location.href.indexOf("error.jsp")!=-1) {
				if(top.opener.parent.frames[1].frames[0]!=null)	{
					if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh!=null) {
						if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh) {
							top.opener.parent.frames[1].frames[0].document.forms[0].refresh.click();
						}
					}
				}
			}
		}
	} else {		
		if(top.content.CommonToolbar.document.getElementById('queryString'))
			query_str = top.content.CommonToolbar.document.getElementById('queryString').value;
		
		parent.location.href='../eCA/jsp/ChartSummaryMain.jsp?'+query_str;
		top.content.CommonToolbar.displayFunctionName("View Chart Summary");

		if(top.content.CommonToolbar.ShowMenu)
			top.content.CommonToolbar.ShowMenu.click();

		if(top.opener.location.href) {
			if(top.opener.location.href.indexOf("error.jsp")!=-1) {
				if(top.opener.parent.frames[1].frames[0]!=null)	{
					if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh!=null) {
						if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh) {
							top.opener.parent.frames[1].frames[0].document.forms[0].refresh.click();
						}
					}
				}
			}
		}
	}
}

function disableFields(obj)
{
	var deceased_yn="";
	var n=0;
	var module_id=parent.frames[1].document.forms[0].module_id.value;
	var P_ae_brought_dead_yn = parent.frames[1].document.forms[0].P_ae_brought_dead_yn.value;
	
	if(obj)
	var val=obj.value;
	if(obj)
	{
		n = obj.selectedIndex;	
		deceased_yn = deceased_ind_arr[n-1];
	
		}

	if( document.getElementById('DECEASED_YN')   )
	{
	document.getElementById('DECEASED_YN').value=deceased_yn;           			
	}
	if (deceased_yn == 'Y' || P_ae_brought_dead_yn =="Y")
	{
		document.forms[0].tocomeback.disabled=true;
		document.forms[0].tocomeback.checked=false;
// Tuesday, March 23, 2010 IN020159
			document.forms[0].released_date_time.readOnly=true;
 			document.getElementById('rel_img').disabled=true;


		
		//document.getElementById('sickLeave').disabled=true;	
		parent.frames[1].document.forms[0].dat_val.disabled=true;
		parent.frames[1].document.forms[0].days_unit.disabled=true;
		parent.frames[1].document.forms[0].dat_val.value='';

		parent.frames[1].document.forms[0].reason.disabled=true;
		parent.frames[1].document.forms[0].reason.value="";
		parent.frames[1].document.forms[0].instructionsrecall.disabled=true;
		parent.frames[1].document.forms[0].instructionsrecall.value="";
		parent.frames[1].document.forms[0].cnl_episode.disabled=false;
		document.getElementById('mandatory').style.visibility="hidden";
		parent.frames[1].document.forms[0].bookingappointment.disabled=true;	
		
	}	
	else
	{
			document.forms[0].tocomeback.disabled=false;		
			//document.getElementById("sickLeave").disabled=false;
		
	}
			
	if (module_id =="AE")
	{
		document.forms[0].cnl_episode.disabled=true;
		disableRecallDtlsOnAE();
	}
}

//Added by Sangeetha for ML-MMOH-CRF-0624
function BidChange(objBid){

	var rec_diag_bid_param    = document.forms[0].rec_diag_not_mdt_bid.value;
	var brought_dead_yn_value = parent.frames[1].document.forms[0].P_ae_brought_dead_yn.value;
	var mr_mds_record = document.forms[0].mr_mds_recorded.value;
	var bdead_yn = document.forms[0].bdead_yn.value;
	var modu_id=parent.frames[1].document.forms[0].module_id.value;
	var arrMrMdsRecord	= mr_mds_record.split("#");
	var isChartRecorded		        = arrMrMdsRecord[0];
	var isClinicalNoteRecorded		= arrMrMdsRecord[1];
	var isOrderRecorded		        = arrMrMdsRecord[3];
	//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
	var enableBIDOnCheckout=document.forms[0].enableBIDOnCheckout.value;
	var decease_yn=""; 
	var numb=0;
	/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
	var did_yn				= document.forms[0].did_hid.value;
	var recDiagNotMdtFrDid	= document.forms[0].recDiagNotMdtFrDid.value;
	/*End*/
	if(objBid)
	{
		numb = objBid.selectedIndex;
		decease_yn = deceased_ind_arr[numb-1]; 
	}
	var returnValue	= "true";
	if(rec_diag_bid_param == "Y" || recDiagNotMdtFrDid == "Y")//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
	{
	if(mr_mds_record != "Y")
	{
		if(modu_id == "AE")
		{
			//Modified by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
			if(brought_dead_yn_value == "Y" && enableBIDOnCheckout == "false") 
			{
				
			if( isChartRecorded=="" && isClinicalNoteRecorded=="" && isOrderRecorded=="" ){
					//document.forms[0].record.disabled=false;
					returnValue = "false";
				}else{
					//document.forms[0].record.disabled=true;
					returnValue = "true";
				}
			} 
            
			if(decease_yn == "Y"){
				//Modified by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
				if( bdead_yn == "Y" && rec_diag_bid_param == "Y"){//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
					if( isChartRecorded=="" && isClinicalNoteRecorded=="" && isOrderRecorded=="" ){
						//document.forms[0].record.disabled=false;
						returnValue = "false";
					}else{
						//document.forms[0].record.disabled=true;
						returnValue = "true";
					}
				
					
				} 
				/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
				else if(did_yn == "Y" && recDiagNotMdtFrDid == "Y"){
					if( isChartRecorded=="" && isClinicalNoteRecorded=="" && isOrderRecorded=="" ){
						returnValue = "false";
					}else{
						returnValue = "true";
					}
				}/*End*/
				else if( bdead_yn == "N" || did_yn == "N"){//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
					//document.forms[0].record.disabled=true;
					returnValue = "true";
				}
		   } else if(decease_yn == "N" )
		   {
			//document.forms[0].record.disabled=true;
			returnValue = "true";
		   } 
			
		 } //end of mod_id 

    } else{
		returnValue = "false";
    }
  }
return returnValue;

}

//Added by Sangeetha for ML-MMOH-CRF-0630
function absChange(obj1)
{
	var mod_id=parent.frames[1].document.forms[0].module_id.value;
	var rec_diag_absc_param = document.forms[0].rec_diag_not_mdt_absconded.value;
	var mr_mds_record_yn = document.forms[0].mr_mds_recorded.value;
	var abs_yn=""; 
	var num=0;
	/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
	var recDiagNtMdtFrCallNtAround = document.forms[0].recDiagNtMdtFrCallNtAround.value;
	var callNtAroundYn = "";
	/*End*/
	var returnValue1 = "true";

	if(obj1)
	{
		num = obj1.selectedIndex;
		abs_yn = absconded_ind_arr[num-1]; 
		callNtAroundYn = call_not_around_arr[num-1];//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
	}
    if(rec_diag_absc_param == "Y" || recDiagNtMdtFrCallNtAround == "Y")//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
	{
	if(mr_mds_record_yn != "Y")
	{
	if(mod_id == "AE")	
	{

		if(abs_yn == "Y" && rec_diag_absc_param == "Y"){//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
		 
				var arrMdsRecord	= mr_mds_record_yn.split("#");
				var isChartRecord		        = arrMdsRecord[0];
				var isClinicalNoteRecord		= arrMdsRecord[1];
				var isOrderRecord		        = arrMdsRecord[3];

					if( isChartRecord=="" && isClinicalNoteRecord=="" && isOrderRecord=="" ){
						//document.forms[0].record.disabled=false;
						returnValue1 = "false";
					}else{
						//document.forms[0].record.disabled=true;
						returnValue1 = "true";
					}

		} 
		/*Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783 Start*/
		else if(callNtAroundYn == "Y" && recDiagNtMdtFrCallNtAround == "Y"){
				var arrMdsRecord	= mr_mds_record_yn.split("#");
				var isChartRecord		        = arrMdsRecord[0];
				var isClinicalNoteRecord		= arrMdsRecord[1];
				var isOrderRecord		        = arrMdsRecord[3];

					if( isChartRecord=="" && isClinicalNoteRecord=="" && isOrderRecord=="" ){
						returnValue1 = "false";
					}else{
						returnValue1 = "true";
					}
		}/*End*/ 
		else if(abs_yn == "N" || callNtAroundYn == "N"){//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
			//document.forms[0].record.disabled=true;
			returnValue1 = "true";
		} 
	}
	} else{
		returnValue1 = "false";
	}
	}
	return returnValue1;
}

//Added by Sangeetha for inc[63791] ML-MMOH-CRF-0624
function checkRecordButton()
{
var BIDCheck = BidChange(document.forms[0].disposition_type);
var AbsCheck = absChange(document.forms[0].disposition_type);

	if((document.forms[0].rec_diag_not_mdt_absconded.value == "Y" || document.forms[0].recDiagNtMdtFrCallNtAround.value == "Y") && (document.forms[0].rec_diag_not_mdt_bid.value == "Y" || document.forms[0].recDiagNotMdtFrDid.value == "Y")){
		if(BIDCheck=="true" && AbsCheck=="true")
			document.forms[0].record.disabled=true;
		else
			document.forms[0].record.disabled=false;

	} else if(document.forms[0].rec_diag_not_mdt_absconded.value == "Y" || document.forms[0].recDiagNtMdtFrCallNtAround.value == "Y"){
		if(AbsCheck=="true")
			document.forms[0].record.disabled=true;
		else
			document.forms[0].record.disabled=false;

	} else if(document.forms[0].rec_diag_not_mdt_bid.value == "Y" || document.forms[0].recDiagNotMdtFrDid.value == "Y"){
		if(BIDCheck=="true")
			document.forms[0].record.disabled=true;
		else
			document.forms[0].record.disabled=false;

	} 
}

//Added by Sangeetha for ML-MMOH-CRF-0547
function procedureUnitCheck()
{
	var module_id=parent.frames[1].document.forms[0].module_id.value;
	var diag_recording_not_mndt=parent.frames[1].document.forms[0].diag_recording_not_mndt.value;
	var mr_mds_recorded = document.forms[0].mr_mds_recorded.value;

	if(module_id == "OP" && diag_recording_not_mndt=="Y" && mr_mds_recorded != "Y")
	{
				var arrMdsRecord	= mr_mds_recorded.split("#");
				var isChartRecord		        = arrMdsRecord[0];
				var isClinicalNoteRecord		= arrMdsRecord[1];
				var isOrderRecord		        = arrMdsRecord[3];

					if( isChartRecord=="" && isClinicalNoteRecord=="" && isOrderRecord=="" ){
						document.forms[0].record.disabled=false;
					}else{
						document.forms[0].record.disabled=true;
					}
	}
}

//Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023
function updDeathRegForm(){
	var dec_yn="";
	var n=0;
	var disptype = document.forms[0].disposition_type;
	var enable_death_reg_form=document.forms[0].enable_death_reg_form.value;
	if(disptype)
	{
		n = disptype.selectedIndex;
		dec_yn = deceased_ind_arr[n-1];
	}
	var isDeathRegisterFormAppl=document.forms[0].isDeathRegisterFormAppl.value;
	if(dec_yn == "Y" && isDeathRegisterFormAppl == 'true'){
		if(enable_death_reg_form=='Y'){
			document.getElementById('deathRegFormLink').style.visibility = 'visible';
		}
	}
}
function dischange(obj)
{
	var isDIDCallNtAroundAppl = document.forms[0].isDIDCallNtAroundAppl.value;//Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783
	
	if(document.forms[0].deceased_date_time.value=="")
		document.forms[0].released_date_time.value="";
	var n=0;
	var dec_yn="";

	//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
	var abs_yn="";
	var callNtAroundYn="";
	var invokeRecallForAE = parent.frames[1].document.forms[0].invokeRecallForAE.value;
		
	if(obj)
	{
		n = obj.selectedIndex;
		dec_yn = deceased_ind_arr[n-1];
		
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		abs_yn = absconded_ind_arr[n-1]; 
		callNtAroundYn = call_not_around_arr[n-1];
	}
	var mlcyn=document.forms[0].mlc_yn.value;
	var create_wait_list=document.forms[0].create_wait_list_yn.value;
	var modify_wait_list=document.forms[0].modify_wait_list_yn.value;
	var wait_list_no=document.forms[0].wait_list_no.value;
	var P_ae_brought_dead_yn = parent.frames[1].document.forms[0].P_ae_brought_dead_yn.value;
	var module_id=parent.frames[1].document.forms[0].module_id.value;
	//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
	var enableBIDOnCheckout=document.forms[0].enableBIDOnCheckout.value;
	var isDeathRegisterFormAppl=document.forms[0].isDeathRegisterFormAppl.value;
	var enable_death_reg_form=document.forms[0].enable_death_reg_form.value;
	
	//Added by Ajay Hatwate for AAKH-CRF-0179 on 07-08-2023
	if(dec_yn == "Y"){
		if(isDeathRegisterFormAppl == 'true' && enable_death_reg_form == 'Y'){
			document.getElementById('deathRegFormLink').style.visibility = 'visible';
		}
	}else{
		if(isDeathRegisterFormAppl == 'true' && enable_death_reg_form == 'Y'){
			if(document.getElementById('deathRegFormLink')){
				document.getElementById('deathRegFormLink').style.visibility = 'hidden';
			}
		}
	}
//  Friday, March 19, 2010 at 5.28 PM  20159 Venkat S.
		//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
		if(dec_yn == "Y" || (P_ae_brought_dead_yn=="Y" && enableBIDOnCheckout == "false")) 
		{
			document.forms[0].deceased_date_time.readOnly=false;
			document.getElementById('dec_img').disabled=false;
			document.forms[0].released_date_time.readOnly=false;
			//document.forms[0].released_date_time.value=convertDate(document.forms[0].system_date.value,"DMYHM","en", localeName);//Changes made for SS SCF-673, IN 34277
			document.getElementById('rel_img').disabled=false;
			document.getElementById('gifpopdec').style.visibility='visible';
			document.getElementById('gifpopbody').style.visibility='visible';
			document.forms[0].create_wait_list.disabled=true;
			document.forms[0].modify_wait_list.disabled=true;
			if(module_id == "AE")
			{
			if(P_ae_brought_dead_yn == "Y")
			 {
				//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
				if(enableBIDOnCheckout == "false"){
					document.forms[0].bdead.disabled=true;
					document.forms[0].bdead.checked=true;
					document.forms[0].bdead_yn.value='Y';
				}
				else{
					if(document.forms[0].bdead.checked)
						document.forms[0].bdead_yn.value='Y';
					else
						document.forms[0].bdead_yn.value='N';

					document.forms[0].bdead.disabled=false;

				}
				
			 }
			else
			 {
				document.forms[0].bdead.disabled=false;
				document.forms[0].bdead.checked=false;
				document.forms[0].bdead_yn.value='N';
			 }
			}

			if(mlcyn == "Y")
			{
			parent.frames[1].document.forms[0].postmortem.value='Y';
			parent.frames[1].document.forms[0].postmortem_yn.value='Y';
			parent.frames[1].document.forms[0].postmortem.checked=true;
			parent.frames[1].document.forms[0].postmortem.disabled=true;
			document.getElementById('gifpopbody').style.visibility='visible';
			}else
			{
			parent.frames[1].document.forms[0].postmortem.value='N';
			parent.frames[1].document.forms[0].postmortem_yn.value='N';
			parent.frames[1].document.forms[0].postmortem.checked=false;
			parent.frames[1].document.forms[0].postmortem.disabled=false;

			//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
			if(enableBIDOnCheckout == "false")
			document.getElementById('gifpopbody').style.visibility='hidden';
			}
			parent.frames[1].document.forms[0].high_risk.disabled=false;
			/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
			if(isDIDCallNtAroundAppl == "true" && module_id == "AE"){
				document.forms[0].did_yn.disabled=false;
				document.forms[0].did_yn.checked=false;
				document.forms[0].did_hid.value='N';
			}
			/*End*/
		}
		else
		{	
			document.forms[0].deceased_date_time.value="";
			document.forms[0].deceased_date_time.readOnly=true;
			document.getElementById('dec_img').disabled=true;
			document.forms[0].released_date_time.readOnly=true;
			document.forms[0].released_date_time.value='';
			document.getElementById('rel_img').disabled=true;
			document.getElementById('gifpopdec').style.visibility='hidden';
			document.getElementById('gifpopbody').style.visibility='hidden';
			document.forms[0].bdead.disabled=true;
			document.forms[0].bdead.checked=false;
			document.forms[0].bdead_yn.value='N';

			if(create_wait_list == "Y" && wait_list_no == "")
			{
				document.forms[0].create_wait_list.disabled=false;
				document.forms[0].modify_wait_list.disabled=true;
			}else if(modify_wait_list == "Y" && wait_list_no != "")
			{
				document.forms[0].create_wait_list.disabled=true;
				document.forms[0].modify_wait_list.disabled=false;
			}else
			{
				document.forms[0].create_wait_list.disabled=false;
				document.forms[0].modify_wait_list.disabled=true;
			}
			parent.frames[1].document.forms[0].postmortem.value='N';
			parent.frames[1].document.forms[0].postmortem_yn.value='N';
			parent.frames[1].document.forms[0].postmortem.checked=false;
			parent.frames[1].document.forms[0].postmortem.disabled=true;
			parent.frames[1].document.forms[0].high_risk.disabled=true;
			parent.frames[1].document.forms[0].high_risk.checked=false;
			/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
			if(isDIDCallNtAroundAppl == "true" && module_id == "AE"){
				document.forms[0].did_yn.disabled=true;
				document.forms[0].did_yn.checked=false;
				document.forms[0].did_hid.value='N';
			}
			/*End*/
		}

		if(module_id=='AE')
		{
			document.forms[0].create_wait_list.disabled=true;
			document.forms[0].modify_wait_list.disabled=true;
			
			//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
			if(invokeRecallForAE == 'Y')
			{
				if(dec_yn == 'Y' || abs_yn == 'Y' || callNtAroundYn == 'Y')
				{
					parent.frames[1].document.forms[0].tocomeback.checked =false;
					parent.frames[1].document.forms[0].tocomeback.disabled =true;
					enable_recall();
				}else
				{
					parent.frames[1].document.forms[0].tocomeback.disabled =false;
					enable_recall();
				}
			}else
			{
				parent.frames[1].document.forms[0].tocomeback.checked =false;
				parent.frames[1].document.forms[0].tocomeback.disabled =true;
				enable_recall();
			}
		}

		if(obj.value == '')
		{
			//if(module_id == "AE") // Friday, March 19, 2010 20159
			//{
				if(P_ae_brought_dead_yn == "Y")
			{
				//Added by Sangeetha on 8/may/17 for ML-MMOH-CRF-0628
				if(enableBIDOnCheckout == "false"){
					document.forms[0].bdead.disabled=true;
					document.forms[0].bdead.checked=true;
					document.forms[0].bdead_yn.value='Y';
				}else{
					if(document.forms[0].bdead.checked)
						document.forms[0].bdead_yn.value='Y';
					else
						document.forms[0].bdead_yn.value='N';
				}
				document.getElementById('gifpopbody').style.visibility='hidden';
				document.getElementById('gifpopdec').style.visibility='hidden';
				parent.frames[1].document.forms[0].postmortem.disabled=true;
				if(document.forms[0].deceased_date_time.value=="")
				{
				document.forms[0].released_date_time.value=""
				// Tuesday, March 23, 2010 20159 Venkat S.
				document.forms[0].released_date_time.readOnly=true;
				}
				document.getElementById('rel_img').disabled=true;
				parent.frames[1].document.forms[0].high_risk.checked=false;
				parent.frames[1].document.forms[0].high_risk.disabled=true;

			}
				else
			{
				document.forms[0].bdead.disabled=true;
				document.forms[0].bdead.checked=false;
				document.getElementById('gifpopbody').style.visibility='hidden';
				document.getElementById('gifpopdec').style.visibility='hidden';
				parent.frames[1].document.forms[0].postmortem.disabled=true;
				// Tuesday, March 23, 2010 20159 Venkat S.
				document.forms[0].released_date_time.readOnly=true;
				document.getElementById('rel_img').disabled=true;
				parent.frames[1].document.forms[0].high_risk.checked=false;
				parent.frames[1].document.forms[0].high_risk.disabled=true;

			}
			//}
			document.forms[0].create_wait_list.disabled=true;
			document.forms[0].modify_wait_list.disabled=true;
			/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
			if(isDIDCallNtAroundAppl == "true" && module_id == "AE"){
				document.forms[0].did_yn.disabled=true;
				document.forms[0].did_yn.checked=false;
				document.forms[0].did_hid.value='N';
			}
			/*End*/
		}
}

function checkMaxLen(obj)
{
	if (obj.name == "reason")
	{
		if (obj.value.length>500)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
			error = error.replace("$",getLabel('Common.reason.label','Common'));
			error = error.replace("#","500");
			alert(error)
			obj.focus();
		}
	}
	else
	{
		if (obj.value.length>200)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
			error = error.replace("$",getLabel('Common.Instructions.label','Common'));
			error = error.replace("#","200");
			alert(error)
			obj.focus();
		}
	}
}

function disableRecallDtlsOnAE()
{
	var callingMode=parent.frames[1].document.forms[0].module_id.value;
	//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
	var invokeRecallForAE = parent.frames[1].document.forms[0].invokeRecallForAE.value;

	if(callingMode=="AE")
	{
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		if(invokeRecallForAE == "Y")
		{
			parent.frames[1].document.forms[0].tocomeback.disabled =false;
			enable_recall();
		}else
		{
			parent.frames[1].document.forms[0].tocomeback.checked =false;
			parent.frames[1].document.forms[0].tocomeback.disabled =true;
			enable_recall();
		}
	}
}

//Code added/modified by Tushar .T. Bhat on 12-Feb-04 ends               
function valid_dat(Obj)
{
	if ((Obj.value=="0")||(Obj.value=="00")||(Obj.value=="000"))
	{
		alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
		Obj.value="";
		Obj.focus();
	}
}

/******************added on 17 sept 2003 to pass date into OA appointment********/

function call2functions(obj,event)
{	
	
	if(CheckForSpecChars(event))
		return allowValidNumber(obj,event,3,0)
	else
		return false;

}

function OffsetDate(sysdate)
{
	//we are taking the sysdate to get the current time...cause the local machine may have a wrong time setting ...so we may not want to depend on the local time setiings...on the better side we save time with the local Date() object of JS.. 

	var days= parent.frames[1].document.forms[0].dat_val.value;
	if(days!='')
	{	
	
		/***building current date object from sysdate to avoid local machine date setting errors **/
		var dateArray = sysdate.split("/");
		sysdate1=dateArray[1]+"/"+dateArray[0]+"/"+dateArray[2]
		var tempdate = Date.parse(sysdate1);
		var currentDate=new Date(tempdate);
		/***********************/

		var dwm= parent.frames[1].document.forms[0].days_unit.value;
		var currentMonth=currentDate.getMonth();
		var presentDate=currentDate.getDate();
			
		var finaldate;

		if(dwm=='D')
		{
			finaldate=presentDate+eval(days);
			currentDate.setDate(finaldate);
		}
		else if(dwm=='W')
		{
			finaldate=presentDate+eval(days*7);
			currentDate.setDate(finaldate);
		}
		else
		{
			currentDate.setMonth(eval(currentMonth+eval(days)));
		}
	
		//added to improve the format of date from 17/9/2003  to--> 17/09/2003
		var correctdate=eval(currentDate.getMonth()+1);
		var Stringcorrectdate="";
		if(eval(correctdate)<10)
		{
			Stringcorrectdate="0"+eval(currentDate.getMonth()+1);
		}
		else
		{
			Stringcorrectdate=correctdate;
		}

		parent.frames[1].document.forms[0].recall_date.value=currentDate.getDate()+"/"+Stringcorrectdate+"/"+currentDate.getFullYear();
	
	}
	else
	{	
		parent.frames[1].document.forms[0].recall_date.value="";
	}
}

function validateDateCheck()
{
released_date=parent.frames[1].document.forms[0].released_date_time.value,

deceased_date_time=	parent.frames[1].document.forms[0].deceased_date_time.value
	
var system_date=convertDate(document.forms[0].system_date.value,"DMYHM","en", localeName);

var visit_date=convertDate(parent.frames[1].document.forms[0].visit_adm_date_time.value,"DMYHM","en", localeName);

if(system_date!=""&&released_date!="")
	{
	if(isBefore(released_date,system_date,'DMYHM',localeName)==false)
			{

			msg=getLabel('Common.BodyReleaseDateTime.label','Common');
            var error = getMessage("DATE1_GT_DATE2","OP");
			error = error.replace("$",msg);
			error = error.replace("#",getLabel('Common.SystemDate.label','Common'));
			alert(error);
			return false
			}
	
	
	} 
if(visit_date!="" && deceased_date_time!="")
	{
	if(! parent.frames[1].document.forms[0].bdead.checked) 
		{ /* condition added for   SCF-SSHIMS SS-SCF-0670-*/
		if(isBefore(visit_date,deceased_date_time,'DMYHM',localeName)==false)
			{			
			msg=getLabel('Common.deceaseddatetime.label','Common');
			var error = getMessage("DATE1_LT_DATE2","OP");
			error = error.replace("$",msg);
			error = error.replace("#",getLabel('Common.VisitDate.label','COMMON'));
			alert(error)
			return false;
			}
		} 
		
	
	
	}
	
	if(deceased_date_time!="" &&released_date!="")
	{
	if(isAfter(released_date,deceased_date_time,'DMYHM',localeName)==false){

              msg=getLabel('Common.deceaseddatetime.label','Common');
              var error = getMessage("DATE1_GT_DATE2","OP");
			  error = error.replace("$",msg);
			 error = error.replace("#",getLabel('Common.BodyReleaseDateTime.label','COMMON'));		
			alert(error)
			return false
		}

		if(!isBetween(visit_date,system_date,released_date,'DMYHM',localeName)){
			alert(getMessage("BODY_REL_DATE_BET","OP"));				
				return false
		 }	
	  }
	
	return true;
	

}


async function Apply()
{	

	/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
	var isReconfirmCOTAppl = parent.frames[1].document.forms[0].isReconfirmCOTAppl.value;
	var reconf_cot_param = parent.frames[1].document.forms[0].reconf_cot_param.value;
	var P_module_id = parent.frames[1].document.forms[0].module_id.value;
	var cot_chk = "";

	if(parent.frames[1].document.getElementById("trauma"))
		cot_chk = parent.frames[1].document.getElementById("trauma").checked;
	else if(parent.frames[1].document.forms[0].CaseofTrauma)
		cot_chk = parent.frames[1].document.forms[0].CaseofTrauma.checked;

	if(isReconfirmCOTAppl == "true" && P_module_id == "AE" && reconf_cot_param == 'Y' && cot_chk == false){
		showReconfCot();
	}
	/*End ML-MMOH-CRF-1409*/

	var isCaseDtlsRadioBtnAppl = parent.frames[1].document.forms[0].isCaseDtlsRadioBtnAppl.value;//Modified by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646
	
	var tval=parent.frames[1].document.forms[0].p_queue_date.value;
	var j1="";
	var j2="";
	var j3="";
	if(tval.indexOf("-") >1)
	{
		j1=tval.substring(0,4);
		j2=tval.substring(5,7);
		j3=tval.substring(8,10);
		parent.frames[1].document.forms[0].p_queue_date.value=j3+"/"+j2+"/"+j1;

	}
	var final_alert_message="";

	var aecount=parent.frames[1].document.forms[0].ae_count.value;
	var pmodule_id=parent.frames[1].document.forms[0].module_id.value;
	var diagrecord=parent.frames[1].document.forms[0].diagrecord.value;
	var notesrecord=parent.frames[1].document.forms[0].notesrecord.value;	
	var diagReqd=parent.frames[1].document.forms[0].diagReqd.value;
	var notesReqd=parent.frames[1].document.forms[0].notesReqd.value;	
	var p_practitioner_id=parent.frames[1].document.forms[0].P_practitioner_id.value;

	//Added by Ajay Hatwate for AAKH-CRF-0179
	var enable_death_reg_form=parent.frames[1].document.forms[0].enable_death_reg_form.value;
	var isDeathRegisterFormAppl=parent.frames[1].document.forms[0].isDeathRegisterFormAppl.value;
	var death_reg_form_accession_num=parent.frames[1].document.forms[0].death_reg_form_accession_num.value;
	//Enc of AAKH-CRF-0179
	//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
	var invokeRecallForAE = parent.frames[1].document.forms[0].invokeRecallForAE.value;
	
	if((diagrecord==0||diagrecord==null)&&diagReqd=='Y')
	{
		 alert(getMessage('DIAG_NOT_REC_CHKOUT_NOT_ALLWD','OP'));
		 return false
	}
	if((notesrecord==0||notesrecord==null)&&notesReqd=='Y')
	{
		 alert(getMessage('NOTES_NOT_REC_CHKOUT_NOT_ALLWD','OP'));
		 return false
	}		
	else
	{
		sub = "Y"
		if(parent.frames[1].document.forms[0].attending_practitioner != null)
		if(parent.frames[1].document.forms[0].attending_practitioner.value =="")
		{
			sub = "N";
			//parent.frames[1].document.forms[0].attending_practitioner.focus();
			parent.frames[1].document.forms[0].practitioner_desc.focus();
			var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
			
			error = error.replace('$',getLabel("Common.practitioner.label","Common"));
			final_alert_message=error+"\n";
		}
		
		//Added by Ajay Hatwate for ML-MMOH-CRF-1653
		var caseTypeYn = parent.frames[1].document.forms[0].caseTypeYn.value;
		var caseTypeMandYn = parent.frames[1].document.forms[0].caseTypeMandYn.value;


		if(caseTypeYn == "Y" && caseTypeMandYn =="Y"){
			var caseType = parent.frames[1].document.forms[0].case_type.value;
			if(caseType == ""){

				sub = "N";
				var error = getMessage('CAN_NOT_BE_BLANK','Common');
				error = error.replace('$',getLabel("eAE.CaseType.label","AE"));
				final_alert_message=final_alert_message + error+"\n";
			}
		}
		//End of ML-MMOH-CRF-1653
		/*Added by Thamizh selvi on 26th Mar 2018 against ML-MMOH-CRF-0646 Start*/
		else if(pmodule_id == "AE" && isCaseDtlsRadioBtnAppl == "true"){
			 if(parent.frames[1].document.getElementById("oscc").checked && parent.frames[1].document.forms[0].osccType.value == ""){
				 sub = "N";
				 var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
				 error = error.replace('$',getLabel('Common.oscc.label','Common')+" "+getLabel("Common.type.label","Common"));
				 
				 final_alert_message=final_alert_message+error+"\n";
			 }
		}/*End*/
		else  if(parent.frames[1].document.forms[0].disposition_date_time.value =="" && sub=="Y")
		{
			 sub = "N";
			 parent.frames[1].document.forms[0].disposition_date_time.focus();
			 var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
			 error = error.replace('$',getLabel('Common.datetime.label','Common'));
			 
			 final_alert_message=final_alert_message+error+"\n";
		}
		else if(parent.frames[1].document.forms[0].tocomeback.checked && sub=="Y" )
		{
			//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
			if (pmodule_id == "AE" && invokeRecallForAE == "Y")
			{
				if(parent.frames[1].document.forms[0].dat_val.value =="")
				{
					sub = "N";
					parent.frames[1].document.forms[0].dat_val.focus();
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',"'"+getLabel('Common.After.label','Common')+"'");
					final_alert_message=final_alert_message+error+"\n";
				}
			}
			else
			{	
				if(parent.frames[1].document.forms[0].dat_val.value =="")
				{
					sub = "N";
					parent.frames[1].document.forms[0].dat_val.focus();
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('eOP.ToComeBackAfter.label','OP'));
					final_alert_message=final_alert_message+error+"\n";
				}
				if(parent.frames[1].document.forms[0].dat_val.value =="" && parent.frames[1].document.forms[0].days_unit.value =="")
				{
					sub = "N";
					parent.frames[1].document.forms[0].dat_val.focus();
					var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
					error = error.replace('$',getLabel('eOP.ToComeBackAfter.label','OP'));
					final_alert_message=final_alert_message+error+"\n";
				}
			}
		}

		var deceased_type_temp=document.forms[0].disposition_type.value;
		if( deceased_type_temp=="")			 
		{
			sub = "N";
			document.forms[0].disposition_type.focus();
			var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
			error = error.replace('$',getLabel('Common.type.label','Common'));
			final_alert_message=final_alert_message+error+"\n";						
		}
		if(parent.frames[1].document.getElementById('gifpopdec').style.visibility == 'visible')
		{
		    if(parent.frames[1].document.forms[0].deceased_date_time.value == '')
			{
				sub = "N";
				document.forms[0].deceased_date_time.focus();
				var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
				
				error =error.replace('$',getLabel('Common.deceaseddatetime.label','Common'));
				final_alert_message=final_alert_message+error+"\n";	
			}
 //Added by Ajay Hatwate for AAKH-CRF-0179
		    if(enable_death_reg_form=='Y' && isDeathRegisterFormAppl == 'true'){
		    
		    	if(death_reg_form_accession_num!=''){
		    	var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH death_reg_form_accession_num=\""+death_reg_form_accession_num+"\" action=\"CheckAccNumbSigned\" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eMP/jsp/MPIntermediate.jsp",false);
				xmlHttp.send(xmlDoc);
				var isSigned=trimString(xmlHttp.responseText);
				if(isSigned=='N'){
					sub='N';
					var error = getMessage('DEATH_REG_FORM_HAS_TO_BE_SIGNED','COMMON');
			    	final_alert_message=final_alert_message+error+"\n";	
					parent.frames[1].document.forms[0].callback_mode.value = 'Add';
				}
		    	}else{
		    		sub = "N";
			    	var error = getMessage('DEATH_REG_FORM_HAS_TO_BE_SIGNED','COMMON');
			    	final_alert_message=final_alert_message+error+"\n";	
					parent.frames[1].document.forms[0].callback_mode.value = 'Add';
		    	}	
		    }
		    //End of AAKH-CRF-0179
		}
		if(parent.frames[1].document.getElementById('gifpopbody').style.visibility == 'visible')
		{
			if(parent.frames[1].document.forms[0].released_date_time.value == '')
			{
				sub = "N";
				document.forms[0].released_date_time.focus();
				var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
				error =error.replace('$',getLabel("Common.BodyReleaseDateTime.label","Common"));
				final_alert_message=final_alert_message+error+"\n";	
			}
			
		}	
		//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		/*if( parent.frames[1].document.forms[0].allow_transaction_yn.value == "N")
		{
			sub = "N";
			var error = getMessage('MDS_NOT_ENTERED','COMMON');			
			final_alert_message=final_alert_message+error+"\n";	
		}*/
		if(sub=="N")
		{
			alert(final_alert_message);
		}
		
		/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
		if(sub == "Y")
		{
			var isDeceasedDiagClassDeathRegAppl = document.forms[0].isDeceasedDiagClassDeathRegAppl.value;
			var facility_id = document.forms[0].facility_id.value;
			var patient_id = document.forms[0].patient_id.value;
			var encounter_id = document.forms[0].Encounter.value;

			if(isDeceasedDiagClassDeathRegAppl == "true"){

				if(document.getElementById('DECEASED_YN').value == "Y"){

					var xmlDoc=""
					var xmlHttp = new XMLHttpRequest()
					xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" encounter_id=\""+encounter_id+"\" facility_id=\""+facility_id+"\" action='getDiagClassCDUDCount' /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText = xmlHttp.responseText
					var DiagClassCDUDCount = trimString(responseText);

					var arr = DiagClassCDUDCount.split("~");
					var both_pri_sec_count = arr[0];
					var pri_count = arr[1];
					var sec_count = arr[2];

					var display_message_yn = "N";
					var display_message = "";

					if(document.forms[0].postmortem.checked == true){

						if(document.forms[0].patient_class.value == "OP"){

							if(document.forms[0].pri_mand_postmortem_op_yn.value == "Y" && document.forms[0].sec_mand_postmortem_op_yn.value == "Y"){
								if(both_pri_sec_count == ""){
									display_message_yn = "Y";
									display_message = "PRISECNR";
								}
							}

							else if(document.forms[0].pri_mand_postmortem_op_yn.value == "Y" && document.forms[0].sec_mand_postmortem_op_yn.value == "N"){
								if(pri_count == ""){
									display_message_yn = "Y";
									display_message = "PRINR";
								}
							}

							else if(document.forms[0].pri_mand_postmortem_op_yn.value == "N" && document.forms[0].sec_mand_postmortem_op_yn.value == "Y"){
								if(sec_count == ""){
									display_message_yn = "Y";
									display_message = "SECNR";
								}
							}
						}

						else if(document.forms[0].patient_class.value == "EM"){
							
							if(document.forms[0].pri_mand_postmortem_ae_yn.value == "Y" && document.forms[0].sec_mand_postmortem_ae_yn.value == "Y"){
								if(both_pri_sec_count == ""){
									display_message_yn = "Y";
									display_message = "PRISECNR";
								}
							}

							else if(document.forms[0].pri_mand_postmortem_ae_yn.value == "Y" && document.forms[0].sec_mand_postmortem_ae_yn.value == "N"){
								if(pri_count == ""){
									display_message_yn = "Y";
									display_message = "PRINR";
								}
							}

							else if(document.forms[0].pri_mand_postmortem_ae_yn.value == "N" && document.forms[0].sec_mand_postmortem_ae_yn.value == "Y"){
								if(sec_count == ""){
									display_message_yn = "Y";
									display_message = "SECNR";
								}
							}
						}
					}

					else if(document.forms[0].postmortem.checked == false){

						if(document.forms[0].patient_class.value == "OP"){

							if(document.forms[0].pri_mand_non_postmortem_op_yn.value == "Y" && document.forms[0].sec_mand_non_postmortem_op_yn.value == "Y"){
								if(both_pri_sec_count == ""){
									display_message_yn = "Y";
									display_message = "PRISECNR";
								}
							}

							else if(document.forms[0].pri_mand_non_postmortem_op_yn.value == "Y" && document.forms[0].sec_mand_non_postmortem_op_yn.value == "N"){
								if(pri_count == ""){
									display_message_yn = "Y";
									display_message = "PRINR";
								}
							}

							else if(document.forms[0].pri_mand_non_postmortem_op_yn.value == "N" && document.forms[0].sec_mand_non_postmortem_op_yn.value == "Y"){
								if(sec_count == ""){
									display_message_yn = "Y";
									display_message = "SECNR";
								}
							}
						}

						else if(document.forms[0].patient_class.value == "EM"){

							if(document.forms[0].pri_mand_non_postmortem_ae_yn.value == "Y" && document.forms[0].sec_mand_non_postmortem_ae_yn.value == "Y"){
								if(both_pri_sec_count == ""){
									display_message_yn = "Y";
									display_message = "PRISECNR";
								}
							}

							else if(document.forms[0].pri_mand_non_postmortem_ae_yn.value == "Y" && document.forms[0].sec_mand_non_postmortem_ae_yn.value == "N"){
								if(pri_count == ""){
									display_message_yn = "Y";
									display_message = "PRINR";
								}
							}

							else if(document.forms[0].pri_mand_non_postmortem_ae_yn.value == "N" && document.forms[0].sec_mand_non_postmortem_ae_yn.value == "Y"){
								if(sec_count == ""){
									display_message_yn = "Y";
									display_message = "SECNR";
								}
							}
						}
					}

					if(display_message_yn == "Y"){
						var xmlDoc=""
						var xmlHttp = new XMLHttpRequest()
						xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" encounter_id=\""+encounter_id+"\" facility_id=\""+facility_id+"\" action='getLinkedYn' /></root>"
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
						xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
						xmlHttp.send(xmlDoc)
						responseText = xmlHttp.responseText
						var linked_yn = trimString(responseText);

						if(linked_yn == "Y"){
							display_message_yn = 'N';
						}
					}
					
					if(display_message_yn == "Y"){

						sub = "N";

						var location_type = document.forms[0].location_type.value;
						var location_code = document.forms[0].location_code.value;
						var speciality_code = document.forms[0].spec_code.value;				
						var practitioner_id = document.forms[0].P_practitioner_id.value;
						var practitioner_type = document.forms[0].practitioner_type.value;
						var gender = document.forms[0].patientgender.value;
						var date_of_birth = document.forms[0].date_of_birth.value;	
						var visit_adm_date_time = document.forms[0].visit_adm_date_time.value;
						var patient_class = document.forms[0].patient_class.value;

						var	dialogHeight = "30vh";
						var	dialogWidth = "45vw";
						var	dialogTop = "";
						var status = "no";
						var arguments= "";
						var features = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +"; scroll=yes; status:" + status;
						var jsp_name;
						jsp_name = "../../eIP/jsp/DisplayDiagValidationMsg.jsp?display_message="+display_message+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&location_code="+location_code+"&location_type="+location_type+"&speciality_code="+speciality_code+"&practitioner_id="+practitioner_id+"&practitioner_type="+practitioner_type+"&gender="+gender+"&date_of_birth="+date_of_birth+"&visit_adm_date_time="+visit_adm_date_time+"&patient_class="+patient_class+"&facility_id="+facility_id;
						retVal = await window.showModalDialog(jsp_name,arguments,features);
					}
				}
			}
		}
		/*End ML-MMOH-CRF-1742*/
	
		if(sub == "Y")
		{			
			if(validateDateCheck())
			{
			/*	var HTMLVal = "<html><body><form name='DummyPatCheckout' id='DummyPatCheckout' method='post' action='../../eOP/jsp/PatCheckout.jsp'><input type='hidden' name='practitionerid' id='practitionerid' value='"+p_practitioner_id+"'><input type='hidden' name='patientid' id='patientid' value='"+parent.frames[1].document.forms[0].patient_id.value+"'><input type='hidden' name='encounterid' id='encounterid' value='"+parent.frames[1].document.forms[0].Encounter.value+"'><input type='hidden' name='locncode' id='locncode' value='"+parent.frames[1].document.forms[0].location_code.value+"'><input type='hidden' name='locntype' id='locntype' value='"+parent.frames[1].document.forms[0].location_type.value+"'><input type='hidden' name='dispdatetime' id='dispdatetime' value='"+parent.frames[1].document.forms[0].disposition_date_time.value+"'></form></body></html>";
				parent.Dummy_frame.document.write(HTMLVal);					   
				parent.Dummy_frame.document.DummyPatCheckout.submit();
				parent.window.returnValue = "TRUE";*/
				var checkCall = await funQry();
				if(checkCall)
				{
					var module_id=parent.frames[1].document.forms[0].module_id.value;
				
					var qms_interfaced_yn = parent.frames[1].document.forms[0].qms_interfaced_yn.value;				
				
					if(module_id=='OP' && qms_interfaced_yn=='Y')
					{
						//call finishconsultation
						
						var queue_num=parent.frames[1].document.forms[0].queue_num.value;
						var room_num=parent.frames[1].document.forms[0].room_num.value;
						var patient_id=parent.frames[1].document.forms[0].patient_id.value;
						var encounter_id=parent.frames[1].document.forms[0].Encounter.value;
						var count=0;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						 
						var param="&callfunc=Checkout&queue_num="+queue_num+"&room_num="+room_num+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
						var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						responseText=trimString(xmlHttp.responseText);
					}
					parent.frames[1].document.forms[0].action="../../servlet/eOP.PatCheckoutServlet";
					parent.frames[1].document.forms[0].target="Dummy_frame";
					parent.frames[1].document.forms[0].submit();
				}
				else
				{				
					return false;				
				}			
			}
			else
			{			
				return false;			
			}
		}
	}	
}

function Closewin()
{
	window.returnValue = "FALSE";
	parent.window.close();
	//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
}

async function Concldepisode(service_desc,visit_adm_date_time,systemdatetime)
{

	var encounterid=parent.frames[1].document.forms[0].Encounter.value
	var concludenotes=	parent.frames[1].document.forms[0].concludenotes.value
	var concludenotes=concludenotes;
	var tarr;
	var note;
	var retVal =    new String();
	var dialogHeight= "35vh" ;
	var dialogWidth = "40vw" ;
	var status = "no";
	var scroll = "no";
		
	
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
	var arguments   =concludenotes;
	retVal = await top.window.showModalDialog("../../eOP/jsp/PatConcludeEpisode.jsp?Encounter="+encounterid+"&service_desc="+encodeURIComponent(service_desc)+"&visit_adm_date_time="+visit_adm_date_time+"&sysdate="+systemdatetime,arguments,features);
	if(retVal != ""&&retVal != null)
	{
		tarr = retVal.split("#");
		note = tarr[4];
		parent.frames[1].document.forms[0].concludenotes.value=note;
		parent.frames[1].document.forms[0].conclude.value=retVal;
		
	}

}

function get_val(Obj)
{
	loc_val = Obj.options.value;
	dest_loc_val ="";
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='DummyPatCheckout' id='DummyPatCheckout' method='post' action='../../eOP/jsp/PatCheckoutGetVal.jsp'><input type='hidden' name='practitionerid' id='practitionerid' value='"+loc_val+"'><input type='hidden' name='dest_type' id='dest_type' value='"+dest_loc_val+"'></form></body></html>";
	parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.Dummy_frame.document.DummyPatCheckout.submit();
}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
	selected.remove(selected.options[0]);
	var opt=parent.frames[1].document.createElement("Option");
	opt.text="------------ "+getLabel('Common.defaultSelect.label','Common')+"------------"
	opt.value="";
	field.add(opt);
}

function delete_values1(field)
{
	if(field)
	{
		var selected = field;
		while ( selected.options.length > 0 )
			selected.remove(selected.options[0]);
		var opt=parent.frames[1].document.createElement("Option");
		opt.text="------------ "+getLabel('Common.defaultSelect.label','Common')+"------------"
		opt.value="";
		field.add(opt);
	}
}

function get_val_destination(Obj)
{
	delete_values(parent.frames[1].document.forms[0].destinationlocation);
	delete_values(parent.frames[1].document.forms[0].service);

	dest_loc_val = Obj.options.value;
	loc_val = "";
	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='DummyPatCheckout' id='DummyPatCheckout' method='post' action='../../eOP/jsp/PatCheckoutGetVal.jsp'><input type='hidden' name='practitionerid' id='practitionerid' value='"+loc_val+"'><input type='hidden' name='dest_type' id='dest_type' value='"+dest_loc_val+"'></form></body></html>";
	parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.Dummy_frame.document.DummyPatCheckout.submit();
}

function disable()
{
	if(parent.frames[1].document.forms[0])
	{
	parent.frames[1].document.forms[0].dat_val.disabled=true;
	parent.frames[1].document.forms[0].days_unit.disabled=true;			
	parent.frames[1].document.forms[0].reason.disabled=true;
	parent.frames[1].document.forms[0].instructionsrecall.disabled=true;
	}
}

function enable_recall()
{
	var pmodule_id=parent.frames[1].document.forms[0].module_id.value;
	//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
	var invokeRecallForAE = parent.frames[1].document.forms[0].invokeRecallForAE.value; 

	if(parent.frames[1].document.forms[0].tocomeback.checked == true)
	{	
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		if (pmodule_id == "AE" && invokeRecallForAE == "Y")
		{
			parent.frames[1].document.forms[0].dat_val.disabled=false;
			document.getElementById('mandatory').style.visibility="visible";
		}else
		{
		parent.frames[1].document.forms[0].dat_val.disabled=false;
		parent.frames[1].document.forms[0].days_unit.disabled=false;
		parent.frames[1].document.forms[0].reason.disabled=false;
		parent.frames[1].document.forms[0].instructionsrecall.disabled=false;
		parent.frames[1].document.forms[0].cnl_episode.disabled=true;
		document.getElementById('mandatory').style.visibility="visible";
		parent.frames[1].document.forms[0].bookingappointment.disabled=false;
		}
	}
	else
	{
		parent.frames[1].document.forms[0].dat_val.disabled=true;
		parent.frames[1].document.forms[0].days_unit.disabled=true;
		parent.frames[1].document.forms[0].dat_val.value='';
		parent.frames[1].document.forms[0].reason.disabled=true;
		parent.frames[1].document.forms[0].reason.value="";
		parent.frames[1].document.forms[0].instructionsrecall.disabled=true;
		parent.frames[1].document.forms[0].instructionsrecall.value="";
		parent.frames[1].document.forms[0].cnl_episode.disabled=false;
		document.getElementById('mandatory').style.visibility="hidden";
		parent.frames[1].document.forms[0].bookingappointment.disabled=true;
	}
		
	if (pmodule_id == "AE")
	{
		parent.frames[1].document.forms[0].cnl_episode.disabled=true;
	}
} 

async function ViewRefDetails(refid)
{
	var retVal = 	new String();
	var dialogHeight= "90vh" ;
	var dialogTop = "75" ;
	var dialogWidth	= "85vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+refid,arguments,features);
}

async function RegisterMoreReferral(encounterid,patientid)
{	
	
	var dialogHeight	= '90vh';
	var dialogWidth	= '85vw';
	var dialogTop		= '10';
	var arguments		= ''  ;
	var getUrl = "../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounterid+"&Transaction_type=CO&patient_id="+patientid+"&Module=OP"; 
	
	var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;";
	retVal = await top.window.showModalDialog(getUrl,arguments,features);
	

}

async function ShowPatientValuables(encounterid,patientid,locn_code,specialty_code)
{	
	var dialogHeight	= '90vh';
	var dialogWidth	= '80vw';
	var dialogTop		= '55';
	var arguments		= ''  ;
	var getUrl = "../../eMR/jsp/PatientValuablesMain.jsp?encounterId="+encounterid+"&patientId="+patientid+"&locn_code="+locn_code+"&splty_code="+specialty_code+"&call_function=OP"; 
	
	var features = "dialogHeight:"+dialogHeight+";dialogWidth:"+dialogWidth+"; status=no;";
	retVal =await top.window.showModalDialog(getUrl,arguments,features);
}

async function appointment(confirmAppointment,referral_id) 
{	//New function for Book Appointment from Checkout

	var selectedLocnCode="";	
	var selectedPractId="";
	var splty_code	=	"";

	var from_facility_id =  parent.frames[1].document.forms[0].facility_id.value; 
	var from_encounter_id =  parent.frames[1].document.forms[0].Encounter.value; 

	if(confirmAppointment) 
	{
		parent.frames[1].document.forms[0].tocomeback.checked == true
		enable_recall();
	}

	if(!referral_id)	
		referral_id="N";

	var	recall_date = parent.frames[1].document.forms[0].recall_date.value;	
	
	var dat_val=parent.frames[1].document.forms[0].dat_val.value;		
	
	/*Below two lines commented by venkatesh.S (Em.ID:4008) on 13-Aug-2012 against 34502*/
	
	//if(recall_date =="")
		//recall_date=document.forms[0].xxxx.value;
	
	if(recall_date!="" || confirmAppointment)	
	{     

		var P_patient_id=parent.frames[1].document.forms[0].patient_id.value;		
		var P_locn_code=parent.frames[1].document.forms[0].location_code.value;		
		var P_practitioner_id=parent.frames[1].document.forms[0].i_practitioner_id.value;	
		var P_locn_type=parent.frames[1].document.forms[0].location_type.value;	
		var callingMode=parent.frames[1].document.forms[0].module_id.value;
		
		
		if(recall_date=='') 
			recall_date =parent.frames[1].document.forms[0].sdate.value;

		if(referral_id =='N' || referral_id=='')
		{
			referral_id=document.forms[0].xx.value;
		}
		if(callingMode=="AE")
			callingMode="OP&from_AE=Y";
		else
			callingMode="OP&from_AE=N";

		var retVal = 	new String();
		var dialogHeight= "90vh" ;
		var dialogWidth = "85vw" ;
		var dialogTop 	= "70";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	  
		var h="i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+P_patient_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+""+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id;	
		
		h=h+ "&callingMode="+callingMode+"&visit_flag_OP=Y";


		parent.frames[1].document.forms[0].xxxx.value=recall_date;
		parent.frames[1].document.forms[0].xx.value=referral_id;
        
		
		retVal =await top.window.showModalDialog("../../eOA/jsp/CAOAAppointment.jsp?"+h,arguments,features);

		
		
		if (retVal != null)
		{
			var returnVal = retVal.split("^");
			var mode = returnVal[0];
			h = returnVal[1];			
			
			if (mode=="1")
			{
				h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');					
				retVal = await top.window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);		
				if (retVal=="OP")
					appointment(false);
			}
			else if (mode=="2")
			{
				h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
				retVal = await top.window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
				if (retVal=="OP")
					appointment(false);
			}
			else if (mode=="3")
			{
				h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
				retVal = await top.window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
				if (retVal=="OP")
					appointment(false);
			}
		}		
		
		if(confirmAppointment)
		{
		parent.frames[1].document.forms[0].tocomeback.checked == false
		enable_recall();
		}
		
	}		
	else
	{
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel('eOP.ComeBack.label','OP') +" "+ getLabel('Common.After.label','Common'));
		alert(error);				
	}
}

function chkval(obj)
{
  var isDIDCallNtAroundAppl = document.forms[0].isDIDCallNtAroundAppl.value;//Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783
  if(obj.checked)
	{
	     if(obj.name == "medical")
		 {
			parent.frames[1].document.forms[0].medical.value='Y';
			parent.frames[1].document.forms[0].medical_yn.value='Y';
		 }
		 //Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		 else if(obj.name == "CaseofTrauma")
		 {
			parent.frames[1].document.forms[0].CaseofTrauma.value='Y';
			parent.frames[1].document.forms[0].trauma_yn.value='Y';
		 }
		 else if(obj.name == "surgical")
		 {
			parent.frames[1].document.forms[0].surgical.value='Y';
			parent.frames[1].document.forms[0].surgical_yn.value='Y';
		 }else if(obj.name == "mlc")
		{
			parent.frames[1].document.forms[0].mlc.value='Y';
			parent.frames[1].document.forms[0].mlc_yn.value='Y';
					
			
			

			if(document.getElementById('DECEASED_YN').value == "Y")
			{
				parent.frames[1].document.forms[0].postmortem.value='Y';
				parent.frames[1].document.forms[0].postmortem_yn.value='Y';
				parent.frames[1].document.forms[0].postmortem.checked=true;
				parent.frames[1].document.forms[0].postmortem.disabled=true;
				//document.getElementById("gifpopbody").style.visibility='visible';
			}else
			{
				parent.frames[1].document.forms[0].postmortem.value='N';
				parent.frames[1].document.forms[0].postmortem_yn.value='N';
				parent.frames[1].document.forms[0].postmortem.checked=false;
				parent.frames[1].document.forms[0].postmortem.disabled=true;
				//document.getElementById("gifpopbody").style.visibility='hidden';
			}

		}
		else if(obj.name == "postmortem")
		{
			parent.frames[1].document.forms[0].postmortem.value='Y';
			parent.frames[1].document.forms[0].postmortem_yn.value='Y';
			/*if(document.getElementById("DECEASED_YN").value == "Y")
				document.getElementById("gifpopbody").style.visibility='visible';
			else
				document.getElementById("gifpopbody").style.visibility='hidden';*/
		}else if(obj.name == "high_risk")
		{
			parent.frames[1].document.forms[0].high_risk.value='Y';
			parent.frames[1].document.forms[0].high_risk_yn.value='Y';
		}else if(obj.name =="bdead")
		{
			parent.frames[1].document.forms[0].bdead.value='Y';
			parent.frames[1].document.forms[0].bdead_yn.value='Y';
			/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
			if(isDIDCallNtAroundAppl == "true"){
				parent.frames[1].document.forms[0].did_yn.checked	= false;
				parent.frames[1].document.forms[0].did_yn.value		= 'N';
				parent.frames[1].document.forms[0].did_hid.value	= 'N';
			}
			/*End*/
		
		}
		/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
		else if(obj.name =="did_yn"){
			parent.frames[1].document.forms[0].did_yn.value		= 'Y';
			parent.frames[1].document.forms[0].did_hid.value	= 'Y';
			parent.frames[1].document.forms[0].bdead.checked	= false;
			parent.frames[1].document.forms[0].bdead.value		= 'N';
			parent.frames[1].document.forms[0].bdead_yn.value	= 'N';
		}/*End*/
	}
   else
	{
	   if(obj.name == "medical")
		 {
			parent.frames[1].document.forms[0].medical.value='N';
			parent.frames[1].document.forms[0].medical_yn.value='N';
		 }
		 //Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		 else if(obj.name == "CaseofTrauma")
		 {
			parent.frames[1].document.forms[0].CaseofTrauma.value='N';
			parent.frames[1].document.forms[0].trauma_yn.value='N';
		 }
		 else if(obj.name == "surgical")
		 {
			parent.frames[1].document.forms[0].surgical.value='N';
			parent.frames[1].document.forms[0].surgical_yn.value='N';
		 }else if(obj.name == "mlc")
		{
			parent.frames[1].document.forms[0].mlc.value='N';
			parent.frames[1].document.forms[0].mlc_yn.value='N';
			//document.getElementById('gifpopbody').style.visibility='hidden';
			
			if(document.getElementById('DECEASED_YN').value == "Y")
			{
				parent.frames[1].document.forms[0].postmortem.value='N';
				parent.frames[1].document.forms[0].postmortem_yn.value='N';
				parent.frames[1].document.forms[0].postmortem.checked=false;
				parent.frames[1].document.forms[0].postmortem.disabled=false;
				
			}else
			{
				parent.frames[1].document.forms[0].postmortem.value='N';
				parent.frames[1].document.forms[0].postmortem_yn.value='N';
				parent.frames[1].document.forms[0].postmortem.checked=false;
				parent.frames[1].document.forms[0].postmortem.disabled=true;
				
			}
		
		}else if(obj.name == "postmortem")
		{
			parent.frames[1].document.forms[0].postmortem.value='N';
			parent.frames[1].document.forms[0].postmortem_yn.value='N';
//			document.getElementById('gifpopbody').style.visibility='hidden';
		}else if(obj.name == "high_risk")
		{
			parent.frames[1].document.forms[0].high_risk.value='N';
			parent.frames[1].document.forms[0].high_risk_yn.value='N';
		}else if(obj.name =="bdead")
		{
			parent.frames[1].document.forms[0].bdead.value='N';
			parent.frames[1].document.forms[0].bdead_yn.value='N';
	
		}
		/*Added by Thamizh selvi on 27th Nov 2017 against ML-MMOH-CRF-0783 Start*/
		else if(obj.name =="did_yn"){
			parent.frames[1].document.forms[0].did_yn.value='N';
			parent.frames[1].document.forms[0].did_hid.value='N';
		}/*End*/

	}
}
function clearList(obj)
{
		var len=parent.frames[1].document.forms[0].disposition_type.length;
		for(i=1;i<len;i++)
		{
		  parent.frames[1].document.forms[0].disposition_type.remove(1);
		}
}  

async function WaitList(obj)
{
	var dialogHeight= "100vh" ;
	var dialogTop = "0vh" ;
	var dialogWidth	= "85vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var speciality_op=document.forms[0].spec_code.value;
	var ca_patient_id=document.forms[0].P_patient_id.value;
	var care_locn_ind=document.forms[0].location_type.value;
	var resource_class='';
	var calling_mode='OP';
	var i_clinic_code=document.forms[0].location_code.value;
	var op_practitioner=document.forms[0].P_practitioner_id.value;
	var wait_list_no=document.forms[0].wait_list_no.value;
	var elapsed="N";
	var oper_stn_id=document.forms[0].oper_stn_id.value;

	var from_facility_id =  parent.frames[1].document.forms[0].facility_id.value; 
	var from_encounter_id =  parent.frames[1].document.forms[0].Encounter.value; 
	var install_yn =  parent.frames[1].document.forms[0].install_yn.value; 
	var waitlist_category_appl_yn =  parent.frames[1].document.forms[0].waitlist_category_appl_yn.value; 
	var waitlist_category_reqd_yn =  parent.frames[1].document.forms[0].waitlist_category_reqd_yn.value; 
	var restrict_wl_cat_agst_splty_yn =  parent.frames[1].document.forms[0].restrict_wl_cat_agst_splty_yn.value; 			 
				 
	 
	if(obj.name == "create_wait_list")
	{
	var callurl="../../eOA/jsp/ApptWaitList.jsp?module_id=OA&function_id=APPT_WAIT_LIST&from=ScheduleAppt&function_name=Create Appointment Wait List&function_type=F&menu_id=OA_TRANSACTIONS&access=NYNNN&home_required_yn=Y&speciality_op="+speciality_op+"&ca_patient_id="+ca_patient_id+"&care_locn_ind="+care_locn_ind+"&resource_class="+resource_class+"&calling_mode="+calling_mode+"&i_clinic_code="+i_clinic_code+"&op_practitioner="+op_practitioner+"&oper_stn_id="+oper_stn_id+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id;
	}else if(obj.name == "modify_wait_list")
	{
	var callurl="../../eOA/jsp/WaitListModifyFrame.jsp?waitlist_no="+wait_list_no+"&elapsed="+elapsed+"&oper_stn_id="+oper_stn_id+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&install_yn="+install_yn+"&waitlist_category_appl_yn="+waitlist_category_appl_yn+"&waitlist_category_reqd_yn="+waitlist_category_reqd_yn+"&restrict_wl_cat_agst_splty_yn="+restrict_wl_cat_agst_splty_yn;
	}
	
	var retVal = new String();
	retVal =await top.window.showModalDialog(callurl,arguments,features);

	if(retVal == undefined || retVal == "undefined")
		retVal = "";

	retVal = retVal.split("$");
	var wait_lst_no = retVal[0];
	var success_flag = retVal[1];	

	if(success_flag == 'Y')
	{
		document.forms[0].wait_list_no.value= wait_lst_no;
		document.forms[0].create_wait_list.disabled=true;
		document.forms[0].modify_wait_list.disabled=false;
	}	
}

function beforeGetPractitioner(obj,target_name)
{//avoids the pracittioner query to be executed if the pract name & code already exist.
	if(document.forms[0].practitioner_name1.value==target_name.value &&document.forms[0].practitioner_id1.value==obj.value)
	{
	return;
	}
	target_name.value = trimString(target_name.value);
		 if(target_name.value=='')
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 document.forms[0].practitioner_name1.value="";
			 document.forms[0].practitioner_id1.value="";
			 if(document.forms[0].attending_practitioner!=null)
			 document.forms[0].attending_practitioner.value="";
			 return;
			}
			var prev_pract=document.forms[0].prev_pract_name.value;
			var present_pract=document.forms[0].practitioner_desc.value;
			if(present_pract!="" && prev_pract ==present_pract)
	        {	
		     return; 
	        }
			getPract(obj,target_name);
}
function getPract(obj,target)
{
	var	clinic_code		=	document.forms[0].P_locn_code.value;
	var treatment_area_code=document.forms[0].ae_treatment_area_code.value;
	var open_to_all_pract_yn = document.forms[0].open_to_all_pract_yn.value;
	var specl_code = document.forms[0].specl_code.value;
	var visit_type_code = document.forms[0].visit_type_code.value;
	
	if(document.forms[0].practitioner_id.value == '*ALL')
	{
		document.forms[0].practitioner_id.value = "";
		document.forms[0].attending_practitioner.value = "";
		document.forms[0].practitioner_desc.value = "";	
	}
 
	var open_to_all_practioners_of_clinic= "";
	var open_to_all_pract_of_treatment_area="";
	
    open_to_all_pract_of_treatment_area=document.forms[0].open_to_all_prac_for_clinic_yn.value;
	open_to_all_practioners_of_clinic = document.forms[0].open_to_all_pract_yn.value;  

	var facility_id			=	document.forms[0].facility_id.value;	

if(clinic_code!="") {
   if(treatment_area_code!="") {
		if(open_to_all_pract_of_treatment_area=='N') { 
		  
		getPractitioner(obj,target,facility_id,specl_code,'',clinic_code,treatment_area_code,'','','',"Q1");

 
 /*FirstSql="SELECT  DISTINCT a.practitioner_id  ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )practitioner_name  ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1  ) practitioner_type  ,a.POSITION_CODE  job_title  ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,ae_pract_for_tmt_area b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id=b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND b.treatment_area_code = '"+treatment_area_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))    OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) ORDER BY  2 ";
  
  SecondSql="SELECT  DISTINCT a.practitioner_id  ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )practitioner_name  ,am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',1 ) practitioner_type  ,a.POSITION_CODE  job_title  ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,ae_pract_for_tmt_area b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id=b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND b.treatment_area_code = '"+treatment_area_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     AND UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) ORDER BY  2 ";	*/	
		
		
		} else  if(open_to_all_pract_yn=='Y') {

			getPractitioner(obj,target,facility_id,specl_code,'','','','','','',"Q2");
		
		/*FirstSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',1) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
	
		SecondSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',1) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))    and UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
		*/
		}
			else {
			if(document.forms[0].pract_for_workDay_check)
				document.forms[0].pract_for_workDay_check.value ="Y";
			
			//getPractitioner(obj,target,facility_id,specl_code,'',clinic_code,treatment_area_code,'','','',"Q3");
			
			getPractitioner(obj,target,facility_id,specl_code,'',clinic_code,treatment_area_code,'','',visit_type_code,"Q3");
			
			/*FirstSql="SELECT   DISTINCT a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type  , a.position_code job_title  ,a.gender,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,op_pract_for_clinic b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id = b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
		
			
			SecondSql="SELECT   DISTINCT a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type  , a.position_code job_title  ,a.gender,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,op_pract_for_clinic b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id = b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     AMD UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";*/

			
			}
   }else {  if(open_to_all_pract_yn=='Y') {

	   getPractitioner(obj,target,facility_id,specl_code,'','','','','','',"Q2");
   
	   /*FirstSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',2)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
		
	   SecondSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',2)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     ANd UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";*/
		
   }
	else{

		   //getPractitioner(obj,target,facility_id,specl_code,'',clinic_code,treatment_area_code,'','','',"Q3");
			
		   getPractitioner(obj,target,facility_id,specl_code,'',clinic_code,treatment_area_code,'','',visit_type_code,"Q3");

	       /*
		   FirstSql="SELECT   DISTINCT a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type  , a.position_code job_title  ,a.gender,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,op_pract_for_clinic b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id = b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
		
			
			SecondSql="SELECT   DISTINCT a.practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)practitioner_name  ,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',1) practitioner_type  , a.position_code job_title  ,a.gender,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a   ,op_pract_for_clinic b WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND b.practitioner_id = a.practitioner_id   AND b.eff_status = 'E'   AND a.facility_id = b.facility_id   AND b.facility_id= '"+facility_id+"'   AND b.clinic_code = '"+clinic_code+"'   AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     AND UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))) )   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
			*/

		
			}
		  }
} else 
        {

		getPractitioner(obj,target,facility_id,specl_code,'','','','','','',"Q2");

        /*
		FirstSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',2)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     OR UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   OR DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
	
		SecondSql="SELECT   DISTINCT a.practitioner_id ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',2)practitioner_name  ,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type  ,a.position_code job_title ,a.gender  ,a.primary_splty_short_desc primary_specialty FROM  AM_PRACT_ALL_SPLTY_VW a WHERE UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))   AND UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code))   AND a.facility_id= '"+facility_id+"'  AND   (    UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))     AND UPPER(am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 )) LIKE UPPER(NVL(?,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1 ))))   AND DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U') LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) ORDER BY  2";
		*/
		 
		 }

	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +escape(practitionerName)+ "\""	;
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(FirstSql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(SecondSql)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +escape(specl_code)+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);	
	responseText=xmlHttp.responseText;   
	responseText = trimString(responseText);
	eval(responseText);	
	//return; */
	
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].attending_practitioner.value =arr[0];
		document.forms[0].practitioner_desc.value=unescape(arr[1]);	
		document.forms[0].prev_pract_name.value=unescape(arr[1]);	
		document.forms[0].P_practitioner_id.value=arr[0];
		
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].attending_practitioner.value ="";
		document.forms[0].practitioner_desc.value="";	
		document.forms[0].prev_pract_name.value="";
		document.forms[0].P_practitioner_id.value="";
		
	}

}

function beforeGetPractitionerOP(obj,target_name)
{
	target_name.value = trimString(target_name.value);
		 if(target_name.value=='')
			{
			 document.forms[0].practitioner_desc.value="";
			 document.forms[0].practitioner_id.value="";
			 document.forms[0].attending_practitioner.value="";
			 return;
			}
			var prev_pract=document.forms[0].prev_pract_name.value;
			var present_pract=document.forms[0].practitioner_desc.value;
			if(present_pract!="" && prev_pract ==present_pract)
	        {	
		     return;
	        }
			getPractitionerOP1(obj,target_name);
}
function getPractitionerOP1(target_id,target_name)
{
	
var sql="";
var sql2="";
var practName_FName="";
var practName_FValue="";
var practId_FName="";
practName_FName=target_name.name;
practName_FValue=target_name.value;
var open_to_all_pract=document.forms[0].open_to_all_pract.value;
var  pract_type="";
if(document.forms[0].pract_type)
{
	pract_type=document.forms[0].pract_type.value;
}else
{
pract_type="";
}
var specl_code=document.forms[0].specl_code.value;
var location_code=document.forms[0].location_code.value;
var fac_id=document.forms[0].facility_id.value;
var locale=document.forms[0].locale.value

target_name.value=trimString(target_name.value);
if(target_name.value=="" && window.event.target == target_name)
{
	document.forms[0].prev_pract_name.value="";
	return;
}


getPractitioner(target_id,target_name,fac_id,specl_code,'','','','','','',"Q2");

/*if( open_to_all_pract=="Y"){

	
		sql="SELECT    a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name, am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type, a.position_code job_title,  a.gender gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty FROM  am_pract_for_facility d,  am_practitioner a WHERE   a.PRACTITIONER_ID=d.PRACTITIONER_ID AND  d.facility_id = '"+fac_id+"' 	AND  A.primary_speciality_code ='"+specl_code+"' AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND  UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	OR UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1))))	AND  a.gender	LIKE NVL(UPPER(?),a.gender)AND  UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123')))"
	

	sql2="SELECT    a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type,  a.position_code job_title,  gender,am_get_desc.AM_SPECIALITY(A.primary_speciality_code,'"+locale+"',2) primary_specialty FROM  am_pract_for_facility d,  am_practitioner a WHERE   a.PRACTITIONER_ID=d.PRACTITIONER_ID AND  d.facility_id = '"+fac_id+"' 	AND  A.primary_speciality_code ='"+specl_code+"' AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND  UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) 	AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	AND UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1))))	AND  a.gender	LIKE NVL(UPPER(?),a.gender) AND  UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123')))"

}else
{



sql="SELECT   DISTINCT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id ,'"+locale+"',1) practitioner_name,  am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type,  a.position_code job_title,a.gender gender,  am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty FROM   AM_PRACT_ALL_SPLTY_VW d,  am_practitioner_vw a ,   OP_PRACT_FOR_CLINIC c  ,  (SELECT day_no FROM SM_DAY_OF_WEEK WHERE   day_of_week = RTRIM(TO_CHAR(SYSDATE,'DAY'))) e WHERE  DECODE(e.day_no,'1',c.working_day_1,'2',c.working_day_2,'3',c.working_day_3,  '4',c.working_day_4,'5',c.working_day_5,'6',c.working_day_6,'7',c.working_day_7) = 'Y' AND  a.PRACTITIONER_ID=d.PRACTITIONER_ID AND   a.PRACTITIONER_ID=c.PRACTITIONER_ID   AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND  UPPER(d.specialty_code) LIKE UPPER(NVL(?,d.specialty_code)) 	AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	OR UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1))))	AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND  UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) AND  a.pract_type = NVL('"+pract_type+"',a.pract_type) AND  c.clinic_code = '"+location_code+"'  AND  d.facility_id = '"+fac_id+"'"
;

sql2="SELECT   DISTINCT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id ,'"+locale+"',1) practitioner_name,  am_get_desc.am_pract_type(a.pract_type,'"+locale+"',2) practitioner_type,  a.position_code job_title,a.gender  gender ,  am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty FROM   AM_PRACT_ALL_SPLTY_VW d,  am_practitioner_vw a ,   OP_PRACT_FOR_CLINIC c  ,  (SELECT day_no FROM SM_DAY_OF_WEEK WHERE   day_of_week = RTRIM(TO_CHAR(SYSDATE,'DAY'))) e WHERE  DECODE(e.day_no,'1',c.working_day_1,'2',c.working_day_2,'3',c.working_day_3,  '4',c.working_day_4,'5',c.working_day_5,'6',c.working_day_6,'7',c.working_day_7) = 'Y' AND  a.PRACTITIONER_ID=d.PRACTITIONER_ID AND   a.PRACTITIONER_ID=c.PRACTITIONER_ID   AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))    AND  UPPER(d.specialty_code) LIKE UPPER(NVL(?,d.specialty_code)) 	AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) 	AND UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1))))	AND  DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')	LIKE NVL(UPPER(?),DECODE(UPPER(a.gender),'MALE','M','FEMALE','F','Unknown','U')) AND  UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL(?,NVL(a.position_code,'123'))) AND  a.pract_type = NVL('"+pract_type+"',a.pract_type) AND  c.clinic_code = '"+location_code+"'  AND  d.facility_id = '"+fac_id+"'";
}*/

/*
				sql="";
				sqlSecond="";

	var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";				
	xmlStr += " sql=\"" +escape(sql)+"\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + specl_code + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc.loadXML( xmlStr );
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	
	*/

}	
// Changes made for SS SCF-673, IN 34277 
function deceasedDateTime(id,date_format,time_format){

	showCalendar(id,date_format,time_format);
	if (document.forms[0].deceased_date_time.value!="")
	{
		var cal_time=document.forms[0].deceased_date_time.value;
		
		var dec_date_time=convertDate(document.forms[0].system_date.value,"DMYHM","en", localeName);

		if (!(dec_date_time==null))
		{
			var date1=cal_time.split(' ');
			var time=dec_date_time.split(' ');
			document.forms[0].deceased_date_time.value=date1[0]+" "+time[1];
			//document.forms[0].released_date_time.value=date1[0]+" "+time[1];
		}
		if(document.forms[0].released_date_time.value == "" && !document.forms[0].released_date_time.readOnly)
			document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;
		
			if(document.forms[0].released_date_time.value != "" && document.forms[0].released_date_time.readOnly) {
			document.forms[0].released_date_time.value=document.forms[0].deceased_date_time.value;
			}
	}
}

function releasedDateTime(id,date_format,time_format){

	showCalendar(id,date_format,time_format);
	if (document.forms[0].released_date_time.value!="")
	{
		var cal_time=document.forms[0].released_date_time.value;
		var dec_date_time=convertDate(document.forms[0].system_date.value,"DMYHM","en", localeName);
		if (!(dec_date_time==null))
		{
			var date1=cal_time.split(' ');
			var time=dec_date_time.split(' ');
			document.forms[0].released_date_time.value=date1[0]+" "+time[1];
		}
	}
	
}
// Changes made for SS SCF-673, IN 34277 

/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function chkWithSysDt(obj)
{
	if(obj.value!='')
	{
		if(isAfterNow(obj.value,"DMYHM",localeName))
			return true;
		else{
			alert(getMessage("AFTR_DATE_TIME_VALD","AE"));
			//obj.select();
			obj.value="";
			obj.focus();				
			return false ;
		}
	}		
}
/*End ML-MMOH-CRF-0657*/

/*Added by Thamizh selvi on 12th Mar 2018 against ML-MMOH-CRF-0645 Start*/
function caseDetailsOnChange(obj){
	
	var caseDtl = obj.id;
	if(caseDtl == "trauma"){
		
		document.forms[0].trauma_yn.value='Y';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].non_emerg_yn.value='N';
		document.forms[0].osccType.value = '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
	
	}else if(caseDtl == "oscc"){
	
		document.forms[0].oscc_yn.value='Y';
		
		document.forms[0].trauma_yn.value='N';
  	    document.forms[0].medical_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].non_emerg_yn.value='N';
		document.forms[0].OandG_yn.value='N';

		document.getElementById("osccTypeLabel").style.visibility					= "visible";
		document.forms[0].osccType.style.visibility									= "visible";
		document.forms[0].osccTypeMandImg.style.visibility							= "visible";
		
	}else if(caseDtl == "medical"){
		
		document.forms[0].medical_yn.value='Y';

		document.forms[0].trauma_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].non_emerg_yn.value='N';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].osccType.value			= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
	
	}else if(caseDtl == "surgical"){
		
		document.forms[0].surgical_yn.value='Y';

		document.forms[0].trauma_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].non_emerg_yn.value='N';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].osccType.value= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
	
	}else if(caseDtl == "OandG"){
		
		document.forms[0].OandG_yn.value='Y';

		document.forms[0].trauma_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].non_emerg_yn.value='N';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].osccType.value= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		
	}else if(caseDtl == "NonEmerg"){
		
		document.forms[0].non_emerg_yn.value='Y';

		document.forms[0].trauma_yn.value='N';
		document.forms[0].surgical_yn.value='N';
		document.forms[0].medical_yn.value='N';
		document.forms[0].OandG_yn.value='N';
		document.forms[0].oscc_yn.value='N';
		document.forms[0].osccType.value= '';

		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
		document.forms[0].osccTypeMandImg.style.visibility						= "hidden";
		
	}
}
function onLoadCaseDtlsChk(){
	
	if(document.forms[0].non_emerg_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
	}else if(document.forms[0].OandG_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
	}else if(document.forms[0].surgical_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility					= "hidden";
		document.forms[0].osccType.style.visibility									= "hidden";
	}else if(document.forms[0].medical_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
	}else if(document.forms[0].oscc_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility				= "visible";
		document.forms[0].osccType.style.visibility								= "visible";
		document.forms[0].osccTypeMandImg.style.visibility						= "visible";
		var mechInjSubCatCode	= document.forms[0].mechInjSubCatgCode.value;
		var mechInjrCode		= document.forms[0].mechInjCatgCode.value;
		for(var i=0;i<document.forms[0].osccType.options.length;i++ ){
			var osccTypeArr = document.forms[0].osccType.options[i].value.split(",");
			if(osccTypeArr[0] == mechInjrCode && osccTypeArr[1] == mechInjSubCatCode)
				document.forms[0].osccType.options[i].selected = true;
		}
	}else if(document.forms[0].trauma_yn.value == "Y"){
		document.getElementById("osccTypeLabel").style.visibility				= "hidden";
		document.forms[0].osccType.style.visibility								= "hidden";
	} 
}
/*End*/

/*Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409*/
function showReconfCot()
{
	var retVal;
	var cot_yn = confirm(getMessage("CASE_OF_TRAUMA_YN","AE"));

	if (cot_yn == true) {
	retVal = "Y";
	} else {
	retVal = "N";
	}
	
	if(retVal == "Y")
	{
		if(parent.frames[1].document.getElementById("trauma"))
		{
			parent.frames[1].document.getElementById("trauma").checked = true;
			parent.frames[1].document.getElementById("trauma").onclick();
		}
		else if(parent.frames[1].document.forms[0].CaseofTrauma)
		{
			parent.frames[1].document.forms[0].CaseofTrauma.checked = true;
			parent.frames[1].document.forms[0].CaseofTrauma.onclick();
		}
	}
}
/*End ML-MMOH-CRF-1409*/

//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
async function callCAMainProcedure(){

	var dialogHeight	= "600px";
	var dialogWidth		= "1000px";
	var status			= "no";
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll = auto; status:" + status;
	var title			= getLabel("Common.main.label","common")+" "+getLabel("Common.Procedure.label","common");
	var callingFrom		= "TRANSCTION_BUTTON";

	var action_url		= "../../eOR/jsp/ORMainProcedure.jsp?callingFrom="+callingFrom+"&title="+title+"&patient_id="+parent.frames[1].document.forms[0].patient_id.value+"&episode_id="+parent.frames[1].document.forms[0].Encounter.value+"&encounter_id="+parent.frames[1].document.forms[0].Encounter.value;
	
	var retVal = await window.showModalDialog(action_url,arguments,features);

	if(parent.frames[1].document.forms[0].mds_chk.value > 0)
	{
		var jsp_url = parent.frames[1].document.location.href;

		parent.frames[1].document.location.href = jsp_url+"&reload_yn=Y";
	}
}

