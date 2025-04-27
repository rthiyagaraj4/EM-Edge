function callSlmtValidation()
{
			var bean_id=document.forms[0].bean_id.value
			var service_panel_ind=document.forms[0].serv_panel_ind.value;
			var service_panel_code=document.forms[0].serv_panel_code.value;		
			var patient_id = document.forms[0].patient_id.value;
			var blng_grp_id = document.forms[0].blng_grp_id.value;
			var function_id = document.forms[0].function_id.value;
			var step1="STEP_BL";

			var param = "step1="+step1+"&bean_id="+bean_id+"&service_panel_ind="+service_panel_ind+"&service_panel_code="+service_panel_code+"&blng_grp_id="+blng_grp_id+"&patient_id="+patient_id+"&function_id="+function_id;			
			parent.frames[1].location.href="../../eBL/jsp/BLPatRegValidation.jsp?"+param;

}

async function test()
{	

	var regn_charge_dur_enc_YN = document.forms[0].regn_charge_dur_enc_YN.value;
	var patregnchargeYN = document.forms[0].patregnchargeYN.value;
	//alert("charges exists patregnchargeYN="+patregnchargeYN);
	if(patregnchargeYN == "Y"){
		var pat_reg_chrg_amt = document.forms[0].pat_reg_chrg_amt.value;
		var pat_reg_chrg_pat_amt = document.forms[0].pat_reg_chrg_pat_amt.value;
		var pat_reg_chrg_pat_amt = document.forms[0].pat_reg_chrg_pat_amt.value;
		var serv_panel_ind = document.forms[0].strPatRegServPanelInd.value;
		var serv_panel_code = document.forms[0].strPatRegServPanelCode.value;
		var service_date = document.forms[0].service_date.value;
		var bean_id = document.forms[0].bean_id.value;
		var bean_name = document.forms[0].bean_name.value;
		var patient_id = document.forms[0].patient_id.value;
		var cur_acct_seq_no = document.forms[0].cur_acct_seq_no.value;		
		var blng_grp_id = document.forms[0].blng_grp_id.value;
		var patient_class="";
		var center='1';
		var dialogTop = "30";
		var dialogHeight = "10" ;
		var dialogWidth = "40" ;
		var title="Pat Reg Charges";
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;		
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"pat_reg_chrg_amt="+pat_reg_chrg_amt+"&"+"pat_reg_chrg_pat_amt="+pat_reg_chrg_pat_amt+"&"+"patient_id="+patient_id+"&"+"cur_acct_seq_no="+cur_acct_seq_no+"&"+"cur_acct_seq_no="+cur_acct_seq_no	+"&"+"serv_panel_ind="+serv_panel_ind+"&"+"serv_panel_code="+serv_panel_code+"&"+"service_date="+service_date+"&"+"bean_id="+bean_id+"&"+"bean_name="+bean_name+"&"+"patregnchargeYN="+patregnchargeYN+"&"+"blng_grp_id="+blng_grp_id;	
		//alert("param "+param);

		retVal=await window.showModalDialog("../../eBL/jsp/BLPatRegChargeDet.jsp?"+param,arguments,features);
		var arr=new Array();		
		if(retVal=='undefined' || retVal==undefined)
		{	
			alert("Pateirnt Registration Exists");
			parent.window.returnValue = 'N';
			parent.window.close();

		}
		//var retVal=unescape(retVal);
		/*if(retVal=='undefined' || retVal==undefined)
		{
			alert(1);
			step1="STEP_OTH";
			var param = "step1="+step1+"&patient_id="+patient_id;
			alert("fs :"+param);
			parent.frames[0].location.href="../../eBL/jsp/BLPatRegValidation.jsp?"+param;			
		}
		*/
	
	
//	if(retVal[0]=='Y')
	if(retVal=='Y')
		{
			//parent.parent.frames[0].document.forms[0].patient_id1.value="";			
		/*	var bean_id=retVal[1];//document.forms[0].bean_id.value
			var service_panel_ind=retVal[2];//document.forms[0].serv_panel_ind.value;
			var service_panel_code=retVal[3];//;document.forms[0].serv_panel_code.value;
			var step1=retVal[4];
			var blng_grp_id=retVal[5];
			var patient_id=retVal[6];*/
			var bean_id=document.forms[0].bean_id.value
			var service_panel_ind=document.forms[0].strPatRegServPanelInd.value;
			var service_panel_code=document.forms[0].strPatRegServPanelCode.value;
			//var step1=retVal[4];
			var blng_grp_id=retVal[5];
			var patient_id = document.forms[0].patient_id.value;
			var blng_grp_id = document.forms[0].blng_grp_id.value;
			step1="STEP_BL";

			var param = "step1="+step1+"&bean_id="+bean_id+"&service_panel_ind="+service_panel_ind+"&service_panel_code="+service_panel_code+"&blng_grp_id="+blng_grp_id+"&patient_id="+patient_id
			//parent.frames[2].location.href="../../eBL/jsp/BLPatRegValidation.jsp?"+param;
			parent.frames[0].location.href="../../eBL/jsp/BLPatRegValidation.jsp?"+param;
		}

	}else{
		parent.window.returnValue = 'Y';
			parent.window.close();
	}

		
	}


async function callSlmtorDisc(facility_id,patient_id,strloggeduser,strclientip,locale,doctype,docnum,genlater,totalamt,blng_grp_id,success_message)
{	

	 var dialogHeight    = '90vh' ;
	 var dialogWidth = '90vw' ;	
	 var dialogTop = '10' ;	 
	 var center    = '1'  ;	
	 var arguments =   '';
	 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';	
	 var episode_type="R";
	 var visit_id="";
	 var encounter_id="";
	 //var slmt_reqd_yn='Y';
	 var blnggrp=blng_grp_id;
	 var episode_id="";
	 var called_frm="OTH_MOD"; 	
	 var called_for_reg_chg="pat_reg_chr";
	/*if(genlater=="N")
	{
		alert(success_message);
	}
*/
	if(genlater=="Y")
	{
		var param="patient_id="+patient_id+"&"+"episode_type="+episode_type+"&"+"episode_id="+episode_id+"&"+"visit_id="+visit_id+"&"+"encounter_id="+encounter_id+"&"+"called_frm="+called_frm+"&"+"called_for_reg_chg="+called_for_reg_chg;	
		//alert("param "+param);
		var getUrl  = "../../eBL/jsp/BLAdhocDiscFrame.jsp?"+param;
		 var retVal =await  window.showModalDialog(getUrl,arguments,features);
		 if(retVal == undefined || retVal == 'undefined') {
			// alert("Bill not generted");
			 	parent.window.returnValue = 'Y';
		parent.window.close();
				retVal = '';
			 } 
		 if(retVal != ''){
						arr = retVal.split('|');
						doctype = arr[0];
						docnum  = arr[1];
						} 
	}
		var param="billdoctypecode="+doctype+"&"+"billdocnum="+docnum+"&"+"blnggrp="+blnggrp+"&"+"billgenlater="+genlater;
		var getUrl1  = "../../eBL/jsp/BLBillSlmtMain.jsp?"+param
		var retVal =await  window.showModalDialog(getUrl1,arguments,features)
		//alert("retVal slmt" +retVal);
		
		parent.window.returnValue = 'Y';
		parent.window.close();

}

function continuesettlementbut(step1)
	{
		/*var step1=step1;
		alert("step1 :"+step1);	
		var bean_id=document.forms[0].bean_id.value
		var service_panel_ind=document.forms[0].serv_panel_ind.value;
		var service_panel_code=document.forms[0].serv_panel_code.value;
		var param = "step1="+step1+"&bean_id="+bean_id+"&service_panel_ind="+service_panel_ind+"&service_panel_code="+service_panel_code
	//	parent.frames[2].location.href="../../eBL/jsp/BLPatRegValidation.jsp?step1="+step1;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="../../eBL/jsp/BLPatRegValidation.jsp?"+param;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
	//	var responseText=trimString(xmlHttp.responseText);
	var responseText=xmlHttp.responseText ;
	//eval(responseText);
	//alert(responseText);*/
	var bean_id=document.forms[0].bean_id.value
	var service_panel_ind=document.forms[0].serv_panel_ind.value;
	var service_panel_code=document.forms[0].serv_panel_code.value;
	var service_panel_code=document.forms[0].serv_panel_code.value;
	var blng_grp_id=document.forms[0].blng_grp_id.value;
	var patient_id=document.forms[0].patient_id.value;
	var step1="STEP_BL";
	//var param = "step1="+step1+"&bean_id="+bean_id+"&service_panel_ind="+service_panel_ind+"&service_panel_code="+service_panel_code
	var retArray=new Array();
	retArray[0]="Y";
	retArray[1]=bean_id;
	retArray[2]=service_panel_ind;
	retArray[3]=service_panel_code;
	retArray[4]=step1;
	retArray[5]=blng_grp_id;
	retArray[6]=patient_id;

	
	parent.window.returnValue = 'Y';
	window.close();

	}

	function chkError(error)
	{
		alert(error);
		parent.window.returnValue = 'N';
		parent.window.close();
	}

	function close_det()
	{
		parent.window.returnValue = 'N';
		parent.window.close();
	}


async function pat_reg_chrg()
	{

		var episode_type="R";
		var patient_id = document.forms[0].patient_id.value;
		var visit_id="";
		var episode_id="";
		var encounter_id="";
		var calling_module_id="MP";
		var acc_seq_no=document.forms[0].cur_acct_seq_no.value;
		var patregnchargeYN=document.forms[0].patregnchargeYN.value;

		var service_panel_ind=document.forms[0].serv_panel_ind.value;
		var service_panel_code=document.forms[0].serv_panel_code.value;

		var bean_id=document.forms[0].bean_id.value;
		var bean_name=document.forms[0].bean_name.value;

		var service_date=document.forms[0].service_date.value;
	//	var query_string=document.forms[0].query_string.value;

		var clinic_code="";

		var order_catalog_code="";

		var retArray = new Array();
		
		var include_label=encodeURIComponent(getLabel("Common.Include.label","common"));
		var exclude_label=encodeURIComponent(getLabel("Common.Exclude.label","common"));


		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&acct_seq_no="+acc_seq_no+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+service_date+"&order_catalog_code="+order_catalog_code+"&module_id="+calling_module_id+"&include_label="+include_label+"&exclude_label="+exclude_label+"&patregnchargeYN="+patregnchargeYN+"&bean_id="+bean_id+"&bean_name="+bean_name;

		//alert("param :" +param);
		retArray=await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
		//alert("retArray det:"+retArray);
		if(retArray!=null)
		{
			if(retArray[0]=="Y")
			{
				var total_payable=retArray[1];
				var patient_payable=retArray[2];
				document.getElementById("patregchrgamt").innerText=total_payable;
				document.getElementById("patregchrgpatamt").innerText=patient_payable;
			}
		}
	
	}
