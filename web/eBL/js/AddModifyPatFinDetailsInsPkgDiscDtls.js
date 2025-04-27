function showPkgDiscDtls(index)
{
/*	if( validatePkgApprvDtlForm()){
				alert("test4");
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
*/
	var formObj=document.PkgDtls;			
	var noofdecimal=formObj.noofdecimal.value;
	var payer_code=formObj.payer_code.value;
	var payer_grp_code=formObj.payer_grp_code.value;		
	var patient_id=formObj.patient_id.value;	
	var policy_type_code=formObj.policy_type_code.value;
	var policy_no=formObj.policy_no.value;
	var blng_grp_code=formObj.blng_grp_code.value;			
	var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;		
	var credit_auth_ref=formObj.credit_auth_ref.value;
	var appr_seq_no=formObj.appr_seq_no.value;
	var priority=formObj.priority.value;
	var oldMapKey=formObj.oldMapKey.value;

	var pkg_disc_type = eval("document.forms[0].pkg_disc_type"+index).value;
	var pkg_disc_amt = eval("document.forms[0].pkg_disc_amt"+index).value;
	var pkg_disc_reason = eval("document.forms[0].pkg_disc_reason"+index).value;
	var pkg_disc_reason_desc = eval("document.forms[0].pkg_disc_reason_desc"+index).value;
	var pkg_code = eval("document.forms[0].pkg_code"+index).value;
	var aprv_amt = eval("document.forms[0].aprv_amt"+index).value;

	if(pkg_code == "")
	{
		alert(getMessage("BL8501","BL"));
		return false;
	}
	else if(aprv_amt == "")
	{
		alert(getMessage("BL8686","BL"));
		return false;
	}

	var qryString="payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&noofdecimal="+noofdecimal+"&credit_auth_ref="+credit_auth_ref+"&appr_seq_no="+appr_seq_no+"&parent_index="+index+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&patient_id="+patient_id+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&pkg_disc_type="+pkg_disc_type+"&pkg_disc_amt="+pkg_disc_amt+"&pkg_disc_reason="+pkg_disc_reason+"&pkg_code="+pkg_code+"&pkg_disc_reason_desc="+encodeURIComponent(pkg_disc_reason_desc);
	parent.PkgDiscDtls.location.href="../../eBL/jsp/AddModifyPatFinDetailsPkgDiscDtls.jsp?"+qryString;	
}

function searchReason(clng_evnt)
{
	if(clng_evnt == 'C')
	{
		if(document.forms[0].adhocDiscount.value=="")
		{			
			var msg = getMessage("BL6322","BL");
			alert(msg);
			document.forms[0].reason_desc.value="";
			return false;
		}
	}
	var obj=document.forms[0].reason_desc;
	if(clng_evnt == 'B')
	{
		if(obj.value == "")
		{					
			document.forms[0].reason_desc.value="";
			document.forms[0].reason_code.value="";
			return;
		}
	}
	var target			= document.forms[0].reason_desc;
	var retVal			=  new String();
	var dialogTop	 = "10";
	var dialogHeight = "10" ;
	var dialogWidth	 = "30" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
	
	var locale  = document.forms[0].locale.value;		

	var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='PD' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql2;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;		
	retArray = CommonLookup( title, argArray );		

	if(retArray != null && retArray !="")
	{				
		document.forms[0].reason_code.value=retArray[0];
		document.forms[0].reason_desc.value=retArray[1];
	}
	else
	{			
		document.forms[0].reason_code.value="";
		document.forms[0].reason_desc.value="";
	}
}

function chkAmtPer(obj,noofdecimal)
{
/*	if(document.forms[0].auth_discount.value=="")
	{
		alert("Authorization is required for Adhoc Discount");
		document.forms[0].adhocDiscount.value="";
		return false;
	}
*/
	var flag = CheckForChar(obj);

	if(flag)
	{
		if(document.forms[0].type.value == "R")
		{
			if(obj.value>100 || obj.value<0)
			{			
				alert(getMessage("BL8539","BL"));
				obj.value="";
			}
			else
			{
				putDecimal(obj,13,noofdecimal);
			}
		}
		else
		{
			if(obj.value<0)
			{
				alert(getMessage("BL8640","BL"));
				obj.value  = "";
				obj.focus();
			}
			else
			{
				if(obj.value != "")
				{
					putDecimal(obj,13,noofdecimal);
				}
			}
		}
	}
}

function validateInd(obj)
{
	document.forms[0].adhocDiscount.value="";
}

function chkfornull()
{
	if(document.forms[0].type.value == "")
	{
		alert(getMessage("BL8687","BL"));
		return false;
	}
	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value == "")
	{
		alert(getMessage("BL8589","BL"));//Adhoc Discount Amount cannot be blank
		return false;
	}

	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value != "" && document.forms[0].reason_code.value == "")
	{
		alert(getMessage("BL6268","BL"));
		return false;
	}

	return true;
}
function AddPkgDiscDtls()
{
	var parent_index = document.forms[0].parent_index.value;
	var formObj=parent.PkgDtls.document.PkgDtls;

	var pkg_code = document.forms[0].pkg_code.value;

	if(chkfornull())
	{
		var add_chk = callAuth('A');

		if(add_chk == 'Y')
		{
			eval("formObj.pkg_disc_type"+parent_index).value = document.forms[0].type.value;
			eval("formObj.pkg_disc_amt"+parent_index).value = document.forms[0].adhocDiscount.value;
			eval("formObj.pkg_disc_reason"+parent_index).value = document.forms[0].reason_code.value;
			eval("formObj.pkg_disc_reason_desc"+parent_index).value = document.forms[0].reason_desc.value;
//			alert(getLabel("eBL.PACKAGE_DISC_ADDED.label","BL")+":"+pkg_code);
			parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
		}
	}
}

function ModifyPkgDiscDtls()
{
	var parent_index = document.forms[0].parent_index.value;
	var formObj=parent.PkgDtls.document.PkgDtls;

	var pkg_code = document.forms[0].pkg_code.value;
	if(chkfornull())
	{
		var modify_chk = callAuth('M');

		if(modify_chk == 'Y')
		{
			document.forms[0].type.disabled = false;
			document.forms[0].adhocDiscount.disabled = false;
			document.forms[0].reason_desc.disabled = false;
			document.forms[0].reasonbut.disabled = false;
			document.forms[0].add_button.disabled = true;
			document.forms[0].modify_button.disabled = false;
			document.forms[0].remove_button.disabled = false;

			if(chkfornull())
			{
				eval("formObj.pkg_disc_type"+parent_index).value = document.forms[0].type.value;
				eval("formObj.pkg_disc_amt"+parent_index).value = document.forms[0].adhocDiscount.value;
				eval("formObj.pkg_disc_reason"+parent_index).value = document.forms[0].reason_code.value;
				eval("formObj.pkg_disc_reason_desc"+parent_index).value = document.forms[0].reason_desc.value;
//				alert("Package Discount Modified for "+pkg_code);
				parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
			}
		}		
	}
}

function RemovePkgDiscDtls()
{
	var parent_index = document.forms[0].parent_index.value;
	var formObj=parent.PkgDtls.document.PkgDtls;

	var pkg_code = document.forms[0].pkg_code.value;

	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value == "")
	{
		alert(getMessage("BL8589","BL"));
		return false;
	}

	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value != "" && document.forms[0].reason_code.value == "")
	{
		alert(getMessage("BL6268","BL"));
		return false;
	}

	var remove_chk = callAuth('R');

	if(remove_chk == 'Y')
	{
		eval("formObj.pkg_disc_type"+parent_index).value = "";
		eval("formObj.pkg_disc_amt"+parent_index).value = "";
		eval("formObj.pkg_disc_reason"+parent_index).value = "";
		eval("formObj.pkg_disc_reason_desc"+parent_index).value = "";

//		alert("Package Discount Removed from "+pkg_code);
		parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
	}
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

async function callAuth(cald_frm)
{   
	var retVal=new Array();
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);

	if(cald_frm == 'A')
	{
		parent.PkgDiscDtls.document.forms[0].disc_auth_YN.value=retVal;
/*
		if(retVal=="Y")
		{
			parent.PkgDiscDtls.document.forms[0].auth_btn.disabled=true;
			document.forms[0].type.disabled = false;
			document.forms[0].adhocDiscount.disabled = false;
			document.forms[0].reason_desc.disabled = false;
			document.forms[0].reasonbut.disabled = false;
			document.forms[0].add_button.disabled = false;
		}
		else
		{
			parent.PkgDiscDtls.document.forms[0].auth_btn.disabled=false;
			document.forms[0].type.disabled = true;
			document.forms[0].adhocDiscount.disabled = true;
			document.forms[0].reason_desc.disabled = true;
			document.forms[0].reasonbut.disabled = true;
			document.forms[0].add_button.disabled = true;
		}
*/
	}
/*	else if(cald_frm == 'R')
	{
		return retVal;
	}
*/
	return retVal;
}

function disableitems()
{
	var disc_auth_YN = document.forms[0].disc_auth_YN.value;

	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value != "" && document.forms[0].reason_code.value != "")
	{
		document.forms[0].type.disabled = false;
		document.forms[0].adhocDiscount.disabled = false;
		document.forms[0].reason_desc.disabled = false;
		document.forms[0].reasonbut.disabled = false;
		document.forms[0].add_button.disabled = true;
		document.forms[0].modify_button.disabled = false;
		document.forms[0].remove_button.disabled = false;
	}
	else if(document.forms[0].type.value == "" && document.forms[0].adhocDiscount.value == "" && document.forms[0].reason_code.value == "")
	{
		document.forms[0].type.disabled = false;
		document.forms[0].adhocDiscount.disabled = false;
		document.forms[0].reason_desc.disabled = false;
		document.forms[0].reasonbut.disabled = false;
		document.forms[0].add_button.disabled = false;
		document.forms[0].modify_button.disabled = true;
		document.forms[0].remove_button.disabled = true;
	}
}

function packageDiscountfromVisit(patient_id,calling_module_id)
{
	var function_id="";
	var bed_type="";
	if(calling_module_id=="OP")
		function_id="VISIT_REGISTRATION";	
	else if(calling_module_id=="IP")		
		function_id="ADMISSION";	

	var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var patient_id=patient_id;
	var center='1';
	var dialogTop	= '90';
	var dialogHeight	= '35';
	var dialogWidth		= '72';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var title=encodeURIComponent(getLabel("eBL.PackageDiscount.label","BL"));
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patientId="+patient_id+"&function_id="+function_id+"&package_enabled_yn="+package_enabled_yn;
	//alert("param"+param);
	retVal=window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsPkgApprvDtlsMain.jsp?"+param,arguments,features);	
}
