function Cancel123Adm(obj)
{
	var canval = obj.value;  
	if(canval == getLabel("Common.CancelAdmission.label","Common"))
	{    
		parent.frames[1].document.canceladmission_form.cancel_admission.value=getLabel("eIP.ConfirmCancellation.label","IP");
		parent.frames[1].document.canceladmission_form.close.value=getLabel("eIP.AbortCancellation.label","IP");    
		document.getElementById("u").visibility = 'true';    
		document.getElementById("u").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;Cancellation Remarks&nbsp;<input type='text' size='50' name = 'cancel_remarks'>&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'></img>";
	}
}


function reset()
{
	frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	{
		if (frames[1].document.forms[0].soundex.value!='')
		{
			frames[1].document.forms[0].searchby.value="";
			frames[1].document.forms[0].searchby.disabled=true;
		}
		else
		{
			frames[1].document.forms[0].searchby.disabled=false;
			frames[1].document.forms[0].searchby.value="S";
		}
	}
	frames[1].document.forms[0].search.disabled = false;
	frames[2].location.href = '../../eCommon/html/blank.html';
}
//================ Functions copied from addModifyCancelAdmission.jsp ===================
 async function getFinDtl(qryStr)
    {
        var retVal;
        var dialogHeight= "400px" ;
        var dialogWidth = "700px" ;
        var dialogTop = "72" ;
        var center = "1" ;                                                         
        var status="no";
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
        var arguments   = "" ;
        var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
        retVal = await window.showModalDialog(url,arguments,features);
        if(retVal==null) retVal="";
        return retVal;
    }

    function findetails()
    {
        var package_flag="N";
        var ins_auth_flag="N";
        var upd_pat_flag="N";
        var display="Y";
        var patient_id="";
        var billing_group       = parent.frames[1].document.forms[0].billing_group;
        var billing_class       = parent.frames[1].document.forms[0].billing_class;
        var employer_code       = parent.frames[1].document.forms[0].employer_code;
        var cash_set_type1      = parent.frames[1].document.forms[0].cash_set_type1;
        var cash_insmt_ref1     = parent.frames[1].document.forms[0].cash_insmt_ref1;
        var cash_insmt_date1    = parent.frames[1].document.forms[0].cash_insmt_date1;
        var cash_insmt_rmks1    = parent.frames[1].document.forms[0].cash_insmt_rmks1;
        var cust_1              = parent.frames[1].document.forms[0].cust_1;
        var credit_doc_ref1     = parent.frames[1].document.forms[0].credit_doc_ref1;
        var credit_doc_date1    = parent.frames[1].document.forms[0].credit_doc_date1;
        var cust_2              = parent.frames[1].document.forms[0].cust_2;
        var credit_doc_ref2     = parent.frames[1].document.forms[0].credit_doc_ref2;
        var credit_doc_date2    = parent.frames[1].document.forms[0].credit_doc_date2;
        var cust_3              = parent.frames[1].document.forms[0].cust_3;
        var policy_type         = parent.frames[1].document.forms[0].policy_type;
        var policy_no           = parent.frames[1].document.forms[0].policy_no;
        var policy_expiry_date  = parent.frames[1].document.forms[0].policy_expiry_date;
        var non_insur_blng_grp  = parent.frames[1].document.forms[0].non_insur_blng_grp;
        var cash_set_type2      = parent.frames[1].document.forms[0].cash_set_type2;
        var cash_insmt_ref2     = parent.frames[1].document.forms[0].cash_insmt_ref2;
        var cash_insmt_date2    = parent.frames[1].document.forms[0].cash_insmt_date2;
        var cash_insmt_rmks2    = parent.frames[1].document.forms[0].cash_insmt_rmks2;
        var cust_4              = parent.frames[1].document.forms[0].cust_4;
        var credit_doc_ref3     = parent.frames[1].document.forms[0].credit_doc_ref3;
        var credit_doc_date3    = parent.frames[1].document.forms[0].credit_doc_date3;
        var setlmt_ind          = parent.frames[1].document.forms[0].setlmt_ind;
        var upd_fin_dtls        = parent.frames[1].document.forms[0].upd_fin_dtls;
        var credit_auth_ref     = parent.frames[1].document.forms[0].credit_auth_ref;
        var credit_auth_date    = parent.frames[1].document.forms[0].credit_auth_date;
        var app_days            = parent.frames[1].document.forms[0].app_days;
        var app_amount          = parent.frames[1].document.forms[0].app_amount;
        var eff_frm_date        = parent.frames[1].document.forms[0].eff_frm_date;
        var remarks             = parent.frames[1].document.forms[0].remarks;
        var billing_mode        = parent.frames[1].document.forms[0].billing_mode;
        var operation           = parent.frames[1].document.forms[0].bl_operation.value;

		var annual_income	   	  = document.forms[0].annual_income;
	    var family_asset		  = document.forms[0].family_asset;
	    var no_of_dependants	  = document.forms[0].no_of_dependants;
	    var resp_for_payment	  = document.forms[0].resp_for_payment;

	    var credit_doc_reqd_yn1	  = document.forms[0].credit_doc_reqd_yn1;
	    var credit_doc_reqd_yn2	  = document.forms[0].credit_doc_reqd_yn2;
	    var health_card_expired_yn= document.forms[0].health_card_expired_yn; 
		var calling_module_id	= "IP";
		var calling_function_id = "ADMISSION";

        var episode="";
        var record="";
            
        var qryStr="operation="+operation+"&package_flag="+package_flag+"&ins_auth_flag="+ins_auth_flag+"&upd_pat_flag="+upd_pat_flag+"&patient_id="+patient_id+"&display="+display+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value+"&billing_class="+billing_class.value+"&employer_code="+employer_code.value+"&cash_set_type1="+cash_set_type1.value+"&cash_insmt_ref1="+cash_insmt_ref1.value+"&cash_insmt_date1="+cash_insmt_date1.value;
        qryStr += "&cash_insmt_rmks1="+cash_insmt_rmks1.value+"&cust_1="+cust_1.value+"&credit_doc_ref1="+credit_doc_ref1.value+"&credit_doc_date1="+credit_doc_date1.value+"&cust_2="+cust_2.value;
        qryStr += "&credit_doc_ref2="+credit_doc_ref2.value+"&credit_doc_date2="+credit_doc_date2.value+"&cust_3="+cust_3.value+"&policy_type="+escape(policy_type.value);
        qryStr += "&policy_no="+policy_no.value+"&policy_expiry_date="+policy_expiry_date.value+"&non_insur_blng_grp="+non_insur_blng_grp.value+"&cash_set_type2="+cash_set_type2.value;
        qryStr += "&cash_insmt_ref2="+cash_insmt_ref2.value+"&cash_insmt_date2="+cash_insmt_date2.value+"&cash_insmt_rmks2="+cash_insmt_rmks2.value+"&cust_4="+cust_4.value+"&credit_doc_ref3="+credit_doc_ref3.value+"&credit_doc_date3="+credit_doc_date3.value+"&setlmt_ind="+setlmt_ind.value+"&credit_auth_ref="+credit_auth_ref.value+"&credit_auth_date="+credit_auth_date.value+"&app_days="+app_days.value+"&app_amount="+app_amount.value+"&eff_frm_date="+eff_frm_date.value+"&remarks="+remarks.value+"&episode="+episode+"&record="+record;
		
		qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;

		qryStr += "&annual_income="+annual_income.value+"&family_asset="+family_asset.value+"&no_of_dependants="+no_of_dependants.value+"&resp_for_payment="+resp_for_payment.value+"&credit_doc_reqd_yn1="+credit_doc_reqd_yn1.value+"&credit_doc_reqd_yn2="+credit_doc_reqd_yn2.value+"&health_card_expired_yn="+health_card_expired_yn.value;

        var returnArray = new Array();
        returnArray = getFinDtl(qryStr);
        if(returnArray.length>0)
        {
            billing_group.value     = returnArray[0];
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

            billing_mode.value      = "Modify"
        }
        else
            return false;
    }

    function HideVal1()
    {
		document.getElementById("u").style.visibility='hidden';   
	}
	
    function CancelAdm(obj)
    {
      var canval = obj.value;         
      if (canval == getLabel("Common.CancelAdmission.label","Common"))
       {  
		document.getElementById("u").style.visibility = 'visible';              
		document.canceladmission_form.cancel_admission.value=getLabel("eIP.ConfirmCancellation.label","IP");
		document.canceladmission_form.close.value=getLabel("eIP.AbortCancellation.label","IP");         
		document.getElementById("reason_for_cancellation").focus();
       }   
      
       if (canval == getLabel("eIP.ConfirmCancellation.label","IP"))
		{  	
        if ((document.canceladmission_form.reason_for_cancellation.value == "null") || (document.canceladmission_form.reason_for_cancellation.value == "")) 
        {
		var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		error = error.replace('$',getLabel("Common.ReasonforCancellation.label","IP"));         
		alert(error);
        }
        else
        {   
        document.forms[0].target="submitFrame";     
        document.forms[0].submit();		
        }  	
      }  
     
    }
    
    function CloseWin(obj)
    {
     var closeVal = obj.value;
     if(closeVal == getLabel("Common.close.label","IP"));
     {
         //parent.window.close();
	     const dialogTag = parent.parent.document.getElementById("dialog_tag").close();
     }
     
     if(closeVal == getLabel("eIP.AbortCancellation.label","IP"))
    {
		document.getElementById("u").style.visibility='hidden';
		document.canceladmission_form.cancel_admission.value='Cancel Admission';
		//document.canceladmission_form.close.value='Close';
        const dialogTag = parent.parent.document.getElementById("dialog_tag").close();		
    }
           
    }
//================ Functions copied from addModifyCancelAdmission.jsp ******* END ===================

