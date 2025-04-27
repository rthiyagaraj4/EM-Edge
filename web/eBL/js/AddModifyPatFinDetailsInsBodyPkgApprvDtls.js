function showAddlApprv(calling_module_id)
{
	/*if(parent.PayerDtls.document.PayerDtls){	
		parent.PayerDtls.location.reload();
	}*/
//	saveToBean(parent.PayerDtls.document.PayerDtls,'')
	var formObj=document.forms[0];	
	var patient_id=formObj.patient_id.value;
	var function_id="";
	if(calling_module_id=="OP")
		function_id="VISIT_REGISTRATION";	
	else if(calling_module_id=="IP")		
		function_id="ADMISSION";	
	var calling_module_id=formObj.calling_module_id.value;
	var encounter_date=formObj.encounter_date_time.value;
	var encounter_date_time=formObj.encounter_date_time.value;
	var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;
	var policy_eff_frm_date=formObj.policy_eff_frm_date.value;
	var action=formObj.action.value;
	var blng_grp_code="";
	if(action=="add")
	{
		blng_grp_code=formObj.select_billing_group.value;
		//	formObj.select_billing_group.readOnly=true;
	}
	else
	{
		blng_grp_code=formObj.blng_grp_code.value;
		//formObj.blng_grp_code.readOnly=true;
	}
	var payer_grp_code=formObj.ins_cust_group_code.value;
	var payer_code=formObj.cust_3.value;
	var policy_type_code=formObj.policy_type_code.value;
	var policy_no=formObj.policy_no.value;
	var priority=formObj.priority.value;
	var hdr_credit_auth_ref=formObj.credit_auth_ref.value;
	var hdr_appr_seq_no=formObj.appr_seq_no.value;

	/*formObj.ins_cust_group_code.readOnly=true;
	formObj.cust_3.readOnly=true;
	formObj.policy_type_code.readOnly=true;
	formObj.policy_no.readOnly=true;
	formObj.priority.readOnly=true;*/
	
	var oldMapKey=formObj.oldMapKey.value;
	//var currMapKey=trimString(blng_grp_code)+"~~"+trimString(payer_grp_code)+"~~"+trimString(payer_code)+"~~"+trimString(priority)+"~~"+trimString(policy_type_code)+"~~"+trimString(policy_no);
	//do all validations here		
/*	if(oldMapKey!=currMapKey){//rename oldMapKey  with currMapKey in payerDtls collection of PkgApprovalBean
		alert('logic to remove old key')
		renameBeanKey(formObj,oldMapKey,currMapKey,'');
	}*/
	var credit_auth_ref=formObj.credit_auth_ref.value;
	var credit_auth_date=formObj.credit_auth_date.value;
	var credit_apprd_amt=formObj.credit_apprd_amt.value;
	var credit_apprd_days=formObj.credit_apprd_days.value;

	var qryString="function_id="+function_id+"&patient_id="+patient_id+"&action="+action+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&credit_auth_ref="+credit_auth_ref+"&credit_auth_date="+credit_auth_date+"&credit_apprd_amt="+credit_apprd_amt+"&credit_apprd_days="+credit_apprd_days+"&calling_module_id="+calling_module_id+"&priority="+priority+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&hdr_credit_auth_ref="+hdr_credit_auth_ref+"&hdr_appr_seq_no="+hdr_appr_seq_no+"&encounter_date="+encodeURIComponent(encounter_date)+"&encounter_date_time="+encodeURIComponent(encounter_date_time)+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&policy_eff_frm_date="+encodeURIComponent(policy_eff_frm_date);	

	parent.PayerDtls.location.href="../../eBL/jsp/AddModifyPatFinDetailsInsBodyPkgApprvPayerDtls.jsp?"+qryString;
	parent.PkgDtls.location.href="../../eCommon/html/blank.html";
	parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
}

function getPkgDtls(obj,index){
	if(obj.checked){
		if( validatePkgApprvDtlForm()){
			saveToBean(parent.PkgDtls.document.PkgDtls,index);
		}
		obj.value="Y";
		document.getElementById('PayerDtls_tbl').rows(parseInt(index)+1).cells(5).innerHTML ="<input type='checkbox' name='pkg_dtls_yn"+index+"' id='pkg_dtls_yn"+index+"' value='Y' checked onClick='getPkgDtls(this,\""+index+"\");'><a name='pkg_apprv_dtls"+index+"' href='#' onClick='showPkgApprvDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a>";	
		var formObj=document.PayerDtls;			
		var noofdecimal=formObj.noofdecimal.value;
		var payer_code=formObj.payer_code.value;
		var payer_grp_code=formObj.payer_grp_code.value;		
		var patient_id=formObj.patient_id.value;	
		var policy_type_code=formObj.policy_type_code.value;
		var policy_no=formObj.policy_no.value;
		var priority=formObj.priority.value;
		var blng_grp_code=formObj.blng_grp_code.value;		
		var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;		
		var apprd_amt_restrict_check = document.forms[0].apprd_amt_restrict_check.value;	
		var credit_auth_ref=eval("formObj.credit_auth_ref"+index).value;
		var appr_seq_no=eval("formObj.appr_seq_no"+index).value;
			var oldMapKey=formObj.oldMapKey.value;
		var qryString="payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&noofdecimal="+noofdecimal+"&credit_auth_ref="+credit_auth_ref+"&appr_seq_no="+appr_seq_no+"&parent_index="+index+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&patient_id="+patient_id+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&appr_amt_rest_chk="+apprd_amt_restrict_check;;

		parent.PkgDtls.location.href="../../eBL/jsp/AddModifyPatFinDetailsInsBodyPkgApprvDtls.jsp?"+qryString;	
	}else{
		obj.value="N";
		document.getElementById('PayerDtls_tbl').rows(parseInt(index)+1).cells(5).innerHTML ="<input type='checkbox' name='pkg_dtls_yn"+index+"' id='pkg_dtls_yn"+index+"' value='N'  onClick='getPkgDtls(this,\""+index+"\");'>";	
		parent.PkgDtls.location.href="../../eCommon/html/blank.html";
		parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
	}
}
function showPkgApprvDtls(index){
	if( validatePkgApprvDtlForm()){
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
	var formObj=document.PayerDtls;			
	var noofdecimal=formObj.noofdecimal.value;
	var payer_code=formObj.payer_code.value;
	var payer_grp_code=formObj.payer_grp_code.value;		
	var patient_id=formObj.patient_id.value;	
	var policy_type_code=formObj.policy_type_code.value;
	var policy_no=formObj.policy_no.value;
	var blng_grp_code=formObj.blng_grp_code.value;			
	var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;		
	var apprd_amt_restrict_check = document.forms[0].apprd_amt_restrict_check.value;
	var credit_auth_ref=eval("formObj.credit_auth_ref"+index).value;
	var appr_seq_no=eval("formObj.appr_seq_no"+index).value;
		var priority=formObj.priority.value;
			var oldMapKey=formObj.oldMapKey.value;
	var qryString="payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&noofdecimal="+noofdecimal+"&credit_auth_ref="+credit_auth_ref+"&appr_seq_no="+appr_seq_no+"&parent_index="+index+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&patient_id="+patient_id+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&appr_amt_rest_chk="+apprd_amt_restrict_check;

	parent.PkgDtls.location.href="../../eBL/jsp/AddModifyPatFinDetailsInsBodyPkgApprvDtls.jsp?"+qryString;
	parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
}
function addRow(formName)
{
	if(formName=="PayerDtls")
	{		
		formObj=parent.PayerDtls.document.PayerDtls;
		table = parent.PayerDtls.document.getElementById('PayerDtls_tbl');	
		rowCount = table.rows.length;			
		index = rowCount-1;	

		if(!validatePkgApprvDtlForm())
		{			
			return;
		}
		if( parent.PkgDtls.document.PkgDtls !=null)
		{
			saveToBean(parent.PkgDtls.document.PkgDtls,index);
		}
		if(!validatePkgApprvPayerDtlForm())
		{
			return;
		}
		
		var restrict_check=formObj.restrict_check.value;
		var apprd_amt_restrict_check=formObj.apprd_amt_restrict_check.value;
		var apprd_days_restrict_check=formObj.apprd_days_restrict_check.value;
		var cred_auth_req_yn=formObj.cred_auth_req_yn.value;
		var dflt_auth_ref_as_pol_no_yn=formObj.dflt_auth_ref_as_pol_no_yn.value;
		var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;
		var policy_no=formObj.policy_no.value;
		
		var disable_credit_apprd_amt="";
		var credit_apprd_amt="";
		var credit_apprd_days="";
		var disable_credit_apprd_days="";
		var disable_credit_auth="";
		
		var credit_auth_ref="";
		var credit_auth_date="";
		
		if(restrict_check=="R")
		{
			disable_credit_apprd_amt="";
		
			if(apprd_amt_restrict_check=="U")
			{
				disable_credit_apprd_amt = "disabled";
				credit_apprd_amt="";
			}
			if(apprd_days_restrict_check=="U")
			{
				disable_credit_apprd_days = "disabled";
				credit_apprd_days="";
			}
		}
		else if(restrict_check=="U")
		{
			disable_credit_apprd_amt="disabled";
			credit_apprd_amt="";
			disable_credit_apprd_days = "disabled";
			credit_apprd_days="";

		}
		if(cred_auth_req_yn=="Y")
		{
			disable_credit_auth = "";
			if(dflt_auth_ref_as_pol_no_yn=="Y")
			{
				if(!policy_no=="" && credit_auth_ref=="")
				{
					var policy_no_len = policy_no.length;
					if(policy_no_len <=20 )
						credit_auth_ref = policy_no.substring(0,policy_no_len);
					else
						credit_auth_ref = policy_no.substring(0,20);
				}
			}
			if(credit_auth_date=="")
			{
				credit_auth_date = encounter_date_aft_trunc;
			}
		}
		else
		{
			disable_credit_auth = "disabled";
			credit_auth_ref = "";
			credit_auth_date = "";
		}

		row=parent.PayerDtls.document.getElementById('PayerDtls_tbl').insertRow(rowCount);	
		var cell1=row.insertCell(0);
		var cell2=row.insertCell(1);
		var cell3=row.insertCell(2);
		var cell4=row.insertCell(3);
		var cell5=row.insertCell(4);
		var cell6=row.insertCell(5);
		var cell7=row.insertCell(6);
		var prev_appr_seq_no=eval("parent.PayerDtls.document.PayerDtls.appr_seq_no"+(parseInt(index)-1)).value;
		var appr_seq_no=parseInt(prev_appr_seq_no)+1;
		cell1.innerHTML=appr_seq_no+"<input type='hidden' name='appr_seq_no"+index+"' id='appr_seq_no"+index+"' value='"+appr_seq_no+"'>";
		cell2.innerHTML="<input type='text' maxlength='20' size='17' name='credit_auth_ref"+index+"' id='credit_auth_ref"+index+"' value='"+credit_auth_ref+"' onBlur='chkCreditAuthRef(this,\""+index+"\");' onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event);'  "+disable_credit_auth+"><input type='hidden' name='temp_credit_auth_ref"+index+"' id='temp_credit_auth_ref"+index+"' value='"+credit_auth_ref+"'>";
		cell3.innerHTML="<input type='text'   "+disable_credit_auth+" name='credit_auth_date"+index+"' id='credit_auth_date"+index+"' size='10' maxlength='10' value='"+credit_auth_date+"' onBlur='return chkPayerCreditAuthDate(this,\""+index+"\");'  ><img src='../../eCommon/images/CommonCalendar.gif'   "+disable_credit_auth+" onClick='return showCalendar_loc(\"credit_auth_date"+index+"\",credit_auth_date"+index+");'  >";
		cell4.innerHTML="<input type='text' maxlength='10' size='15' name='credit_apprd_amt"+index+"' id='credit_apprd_amt"+index+"' style='text-align:right'  value='"+credit_apprd_amt+"' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onblur='return CheckPayerSplApprAmt(this,\""+index+"\")'  "+disable_credit_apprd_amt+">";
		cell5.innerHTML="<input type='text' maxlength='2' size='3' name='credit_apprd_days"+index+"' id='credit_apprd_days"+index+"' style='text-align:right'  value='"+credit_apprd_days+"' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckSplApprDays(this,\""+index+"\");' "+disable_credit_apprd_days+" >";
		cell6.innerHTML="<input type='checkbox' name='pkg_dtls_yn"+index+"' id='pkg_dtls_yn"+index+"' value='N' onClick='getPkgDtls(this,\""+index+"\");'>";
		cell7.innerHTML="<input type='hidden' name='pol_validity_chk_date"+index+"' id='pol_validity_chk_date"+index+"' value='' >";
		formObj.total_records.value=rowCount;
	}
	else if(formName=="PkgDtls")
	{
		formObj=parent.PkgDtls.document.PkgDtls;
		table = parent.PkgDtls.document.getElementById('PkgDtls_tbl');	
		rowCount = table.rows.length;			
		index = rowCount-1;	
		var appr_amt_rest_chk = document.forms[0].appr_amt_rest_chk.value;
		var appr_amt_disp = "";

		if(validatePkgApprvDtlForm())
		{
			if( parent.PkgDiscDtls.document.PkgDiscDtls !=null)
			{
				saveToBean(parent.PkgDtls.document.PkgDtls,index,'PKGDTLS');
			}

			row=parent.PkgDtls.document.getElementById('PkgDtls_tbl').insertRow(rowCount);
				
			var cell1=row.insertCell(0);
			var cell2=row.insertCell(1);
			var cell3=row.insertCell(2);
			var cell4=row.insertCell(3);
			var cell5=row.insertCell(4);
			var cell6=row.insertCell(5);

			var temp="<select name='pkg_dtls"+index+"' id='pkg_dtls"+index+"' onChange='onChangePkgDtls(this,\""+index+"\");'><option value=''>---"+getLabel("Common.defaultSelect.label","common")+"---</option>"

			var st=new Array();	
			st=(formObj.pkgDtlsVals.value).split("^~^");
			if(st!=null && st!="")
			{
				for(var i=0;i<st.length;i++)
				{	
					var tempStr=new Array();
					tempStr=st[i].split("~~")
					temp+="<option value='"+st[i]+"'>"+tempStr[0]+"-"+tempStr[1]+"-"+tempStr[2]+"</option>";							
				}
			}
			temp+="<input type='hidden' name = 'pkg_seq_no"+index+"' value=''>";
			if(appr_amt_rest_chk == 'U')
			{
				appr_amt_disp = "disabled";
			}

			cell1.innerHTML=temp;
			cell2.innerHTML="<input type='text' name='pkg_code"+index+"' id='pkg_code"+index+"' value='' size='8' maxlength='8'  readonly>";
			cell3.innerHTML="<input type='text' name='pkg_desc"+index+"' id='pkg_desc"+index+"' value='' size='40' maxlength='100'  readonly>";
			cell4.innerHTML="<input type='text' name='aprv_amt"+index+"' id='aprv_amt"+index+"' value='' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value));' style='text-align:right' onblur='return CheckSplApprPkgAmt(this,\""+index+"\")' "+appr_amt_disp+"><input type='hidden' name='pkg_disc_type"+index+"' id='pkg_disc_type"+index+"' value=''><input type='hidden' name='pkg_disc_amt"+index+"' id='pkg_disc_amt"+index+"' value=''><input type='hidden' name='pkg_disc_reason"+index+"' id='pkg_disc_reason"+index+"' value=''><input type='hidden' name='pkg_disc_reason_desc"+index+"' id='pkg_disc_reason_desc"+index+"' value=''>";
			cell5.innerHTML="<a name='pkg_disc_dtls"+index+"' href='#' onClick='showPkgDiscDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a>";		
			cell6.innerHTML="";

			formObj.total_records.value=rowCount;
		}
	}
}

function saveToBean(frmObj,index,calld_frm)
{
	if(frmObj)
	{	
		var form_name=frmObj.form_name.value;
		var parent_index="";
		if(form_name=="PkgDtls" )
		{
			parent_index=frmObj.parent_index.value;				
		}

		if(form_name=="PayerDtls")
		{
			var updation=formValidation(formXMLStringMain(frmObj),"saveToBean");
			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
		}
		else if(form_name=="PkgDtls" &&  parent_index!=index && calld_frm=="PKGDTLS")
		{
			var updation=formValidation(formXMLStringMain(frmObj),"saveToBean");
//			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
		}
		else if(form_name=="PkgDtls" &&  parent_index!=index && calld_frm!="PKGDTLS")
		{
			var updation=formValidation(formXMLStringMain(frmObj),"saveToBean");
			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
		}
	}
}

//function removeFromBean(credit_auth_ref)//IN 20964

function removeFromBean(appr_seq_no)//IN 20964
{

	frmObj=parent.PayerDtls.document.PayerDtls;
	var xmlStr ="<root><SEARCH ";
	//xmlStr+= "credit_auth_ref=\"" +credit_auth_ref+ "\" " ;//if formObj==PayerDtl then key will be credit_auth_ref and if formObj==hdr form ,key will be the mapKey//commented for IN 20964
	xmlStr+= "appr_seq_no=\"" +appr_seq_no+ "\" " ;// added for IN 20964
	xmlStr+= "policy_eff_frm_date=\"" +frmObj.policy_eff_frm_date.value+ "\" " ;
	xmlStr+= "blng_grp_code=\"" +frmObj.blng_grp_code.value+ "\" " ;
	xmlStr+= "payer_grp_code=\"" +frmObj.payer_grp_code.value+ "\" " ;
	xmlStr+= "payer_code=\"" +frmObj.payer_code.value+ "\" " ;
	xmlStr+= "priority=\"" +frmObj.priority.value+ "\" " ;
	xmlStr+= "policy_type_code=\"" +frmObj.policy_type_code.value+ "\" " ;
	xmlStr+= "policy_no=\"" +frmObj.policy_no.value+ "\" " ;	
	xmlStr +=" /></root>";
//alert("xmlStr:"+xmlStr)
	var updation=formValidation(xmlStr,"removeFromBean");
} 
function renameBeanKey(frmObj,oldMapKey,currMapKey,index){	
	var xmlStr ="<root><SEARCH ";
	/*if(oldMapKey==currMapKey){//need to rename the credit_auth_ref	
		xmlStr+= "credit_auth_ref=\"" +eval("frmObj.credit_auth_ref"+index).value + "\" " ;//if formObj==PayerDtl then key will credit_auth_ref and if formObj==hdr form ,key will the mapKey
		xmlStr+= "temp_credit_auth_ref=\"" +eval("frmObj.temp_credit_auth_ref"+index).value+ "\" " ;
	}*/// commented for IN 20964

	xmlStr+= "oldMapKey=\"" +oldMapKey+ "\" " ;
	xmlStr+= "currMapKey=\"" +currMapKey+ "\" " ;
	xmlStr +=" /></root>";
	//alert("xmlStr:"+xmlStr)
	var updation=formValidation(xmlStr,"renameBeanKey");
}

function checkForDuplicate(formObj,item,index)
{
	var  total_records = formObj.total_records.value;
	var form_name=formObj.name;
	if(total_records>1)
	{
		var xmlStr ="<root><SEARCH ";
		for(var i=0;i<total_records; i++)
		{
			/*if(form_name == "PayerDtls")
			{
				if(eval("formObj.credit_auth_ref"+i) != undefined)
				xmlStr+= "code_"+i+"=\"" + eval("formObj.credit_auth_ref"+i).value + "\" " ;
			}
			else */ // comented for IN 20964
			if(form_name == "PkgDtls")
			{
				if(eval("formObj.pkg_code"+i) != undefined)
				//xmlStr+= "code_"+i+"=\"" +formObj.credit_auth_ref.value+"~~" + eval("formObj.pkg_seq_no"+i).value+"~~" + eval("formObj.pkg_code"+i).value+"\" " ;//commented for IN 20964
				xmlStr+= "code_"+i+"=\"" +formObj.appr_seq_no.value+"~~" + eval("formObj.pkg_seq_no"+i).value+"~~" + eval("formObj.pkg_code"+i).value+"\" " ;// changed for IN 20964
			}		

		}
		xmlStr+= "form_name=\"" + form_name + "\" " ;		
		xmlStr+= "item=\""+item+"\" " ;		
		xmlStr+= "index=\"" + index + "\" " ;		
		xmlStr+= "total_records=\"" + total_records + "\" " ;
		xmlStr +=" /></root>";
		//alert("xmlStr:"+xmlStr)
		var updation=formValidation(xmlStr,"dupChk");
	
	}
}
// Duplicate Alert if the serveice/item duplicates
function duplicateAlert(index,form_name)
{
	
	/*if(form_name == "PayerDtls")
	{
		eval("parent.PayerDtls.document.PayerDtls.credit_auth_ref"+index).value= eval("parent.PayerDtls.document.PayerDtls.temp_credit_auth_ref"+index).value;	
		alert(getMessage("BL8608","BL"));
		return false;

	}
	else*///commented for IN 20964
	if(form_name == "PkgDtls")
	{
		eval("parent.PkgDtls.document.PkgDtls.pkg_dtls"+index).value= "";
		eval("parent.PkgDtls.document.PkgDtls.pkg_dtls"+index).selectedIndex= 0;
		eval("parent.PkgDtls.document.PkgDtls.pkg_seq_no"+index).value= "";
		eval("parent.PkgDtls.document.PkgDtls.pkg_code"+index).value= "";
		eval("parent.PkgDtls.document.PkgDtls.pkg_desc"+index).value= "";	
		alert(getMessage("BL8507","BL"));
		return false;
	}
}

function formXMLStringMain(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	
	xmlStr +=" /></root>";
	//alert("xmlStr from common :"+xmlStr)
	}

	return xmlStr;
}

function formValidation(xmlStr,func_mode)
{	   	
	var temp_jsp="PkgApprovalValidation.jsp?func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert("formValidation xmlStr:"+xmlStr)
		//alert("last_link:"+last_link)
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	//alert("responseText :"+responseText);
	eval(responseText);
	//alert("responseText :"+eval(responseText));
	return true;
}



function CheckForSpecCharsAllNotAlwSpc_local(event)
{
    var strCheck = '~`!@#$%^&()=+[]{}\\|;:,<>?\'\"';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	return false ;
}
/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1);
	}
}

function chkCreditAuthRef(obj,index){
	if(!CheckChars_local(obj))
	{
		alert(getMessage("CANNOT_BE_SPECIAL_CHAR","common"));
		obj.select();
		return false;
	}
	
	formObj=parent.PayerDtls.document.PayerDtls;
	checkForDuplicate(formObj,obj.value,index);
	var credit_auth_ref=obj.value;
	//alert("credit_auth_ref="+credit_auth_ref)
	//alert("temp_credit_auth_ref="+eval("formObj.temp_credit_auth_ref"+index).value)
/*	if(eval("formObj.temp_credit_auth_ref"+index).value!="" && credit_auth_ref !=eval("formObj.temp_credit_auth_ref"+index).value){
		if(credit_auth_ref==""){
			if(confirm(getMessage("DELETE_RECORD","common"))){
			//alert("confirm true")
			removeFromBean(eval("formObj.temp_credit_auth_ref"+index).value)
			eval("formObj.credit_auth_date"+index).value="";
			eval("formObj.credit_apprd_amt"+index).value="";
			eval("formObj.credit_apprd_days"+index).value="";
			document.getElementById('PayerDtls_tbl').rows(parseInt(index)+1).cells(5).innerHTML ="<input type='checkbox' name='pkg_dtls_yn"+index+"' id='pkg_dtls_yn"+index+"' value='N'  onClick='getPkgDtls(this,\""+index+"\");'>";	
			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
		}else{
		//alert("confirm false")
			alert(getMessage("BL8602","BL"));
			obj.focus();
			return;
		}
		}
		if(obj.value!=""){
			//alert("in else, credit_auth_ref="+credit_auth_ref)
			//alert("in else,temp_credit_auth_ref="+eval("formObj.temp_credit_auth_ref"+index).value)
			var currMapKey=trimString(formObj.blng_grp_code.value)+"~~"+trimString(formObj.payer_grp_code.value)+"~~"+trimString(formObj.payer_code.value)+"~~"+trimString(formObj.priority.value)+"~~"+trimString(formObj.policy_type_code.value)+"~~"+trimString(formObj.policy_no.value);
			renameBeanKey(formObj,currMapKey,currMapKey,index);// renaming only the credit_auth_ref
			//alert(parent.PkgDtls.document.PkgDtls!=null)
			//alert("parent.PkgDtls.document.PkgDtls.parent_index="+parent.PkgDtls.document.PkgDtls.parent_index.value)
			//alert("index="+index)
			if(parent.PkgDtls.document.PkgDtls!=null && parent.PkgDtls.document.PkgDtls.parent_index.value==index){
			//alert('change bottom credit_auth_ref name')
				parent.PkgDtls.document.PkgDtls.credit_auth_ref.value=credit_auth_ref;	
			}
		}
	}	*/// commented for IN 20964
	
	if( validatePkgApprvDtlForm()){	
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
	

	//eval("document.PayerDtls.temp_credit_auth_ref"+index).value=credit_auth_ref;
	if(index==0)
		parent.frames[0].document.forms[0].credit_auth_ref.value=credit_auth_ref;
}
/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function CheckPayerSplApprAmt(Obj,index)
{
	if( validatePkgApprvDtlForm()){
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
	if(Obj.value=="" || Obj.value==0){			
		var formObj=parent.PayerDtls.document.PayerDtls;
		if(confirm(getMessage("DELETE_RECORD","common"))){
			//alert("confirm true")
			removeFromBean(eval("formObj.appr_seq_no"+index).value)		
			document.getElementById('PayerDtls_tbl').rows(parseInt(index)+1).cells(5).innerHTML ="<input type='checkbox' name='pkg_dtls_yn"+index+"' id='pkg_dtls_yn"+index+"' value='N'  onClick='getPkgDtls(this,\""+index+"\");'>";	
			parent.PkgDtls.location.href="../../eCommon/html/blank.html";
			parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
		}else{
		//alert("confirm false")
			alert(getMessage("BL9564","BL"));
			Obj.focus();
			return;
		}
		
	}
	var flag = CheckForChar(Obj);

	if(flag)
	{
		put_decimal(Obj,document.forms[0].noofdecimal.value);
		if(index==0)
			parent.frames[0].document.forms[0].credit_apprd_amt.value=Obj.value;
		return true;
	}
	else
	{
		return false;
	}
	
}
function CheckSplApprPkgAmt(Obj,index)
{
	var flag = CheckForChar(Obj);

	if(flag)
	{
		put_decimal(Obj,document.forms[0].noofdecimal.value);
		return true;
	}
	else
	{
		return false;
	}
}
function onChangePkgDtls(obj,index)
{
	var formObj=document.PkgDtls
	var st=new Array();	
	if(obj.value != "")
	{
		st=(obj.value).split("~~");
		eval("formObj.pkg_code"+index).value=st[0];
		eval("formObj.pkg_desc"+index).value=st[1];
		eval("formObj.pkg_seq_no"+index).value=st[2];	
	}
	else
	{
		eval("formObj.pkg_code"+index).value="";
		eval("formObj.pkg_desc"+index).value="";
		eval("formObj.pkg_seq_no"+index).value="";	
	}

	if(obj.value != "")
	{
		checkForDuplicate(formObj,formObj.credit_auth_ref.value+"~~"+ eval("formObj.pkg_seq_no"+index).value+"~~"+ eval("formObj.pkg_code"+index).value,index);
	}

	parent.PkgDiscDtls.location.href="../../eCommon/html/blank.html";
}
/*
function pkgSeqNoTxtValLookUp(pkg_seq_no,index){
	var formObj=document.PkgDtls;
	if(formObj!=null){
		if(eval("formObj.pkg_seq_no_temp"+index+".value") != eval("formObj.pkg_seq_no"+index+".value"))
		{
			if(eval("formObj.pkg_seq_no"+index).value != "")
				show_pkgSeqNoLookUp(pkg_seq_no,index);
		}
	}
}
function pkgSeqNoLookUp(pkg_seq_no,index){
	var formObj=document.PkgDtls;
		if(formObj!=null){
			if(eval("formObj.pkg_seq_no"+index).value == ""){
					show_pkgSeqNoLookUp(pkg_seq_no,index);
			}
		}
}
function show_pkgSeqNoLookUp(pkg_seq_no,index){	
	var formObj=document.PkgDtls;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.POLICY.label","BL");
	var locale=formObj.locale.value;
	var facility_id=formObj.facility_id.value;
	var encounter_date_aft_trunc=formObj.encounter_date_aft_trunc.value;
	var patient_id=formObj.patient_id.value;
	

	var sql="SELECT   a.package_seq_no code,  a.package_code description  FROM bl_package_sub_hdr a, bl_package_lang_vw b   WHERE a.operating_facility_id ='"+facility_id+"'   AND a.operating_facility_id = b.operating_facility_id    AND a.package_code = b.package_code   AND b.language_id ='"+locale+"'   AND a.patient_id = '"+patient_id+"'   AND to_date('"+encounter_date_aft_trunc+"','dd/mm/yyyy') BETWEEN trunc(a.EFF_FROM_DATE) AND trunc(NVL(a.eff_to_date,SYSDATE))   AND a.status = 'O' and upper(a.package_seq_no)  like upper(?) and upper(a.package_code) like upper(?) order by a.package_seq_no"
	argumentArray[0]	=  sql
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = pkg_seq_no.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
 	if(retVal != null && retVal != ""){   		
 		pkg_seq_no.value =retVal[0] ;
		eval("formObj.pkg_seq_no_temp"+index).value= retVal[0];	
		eval("formObj.pkg_code"+index).value= retVal[1];	
		checkForDuplicate("PkgDtls",formObj.credit_auth_ref.value+"~~"+ eval("formObj.pkg_seq_no"+index).value+"~~"+ eval("formObj.pkg_code"+index).value,index);	
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patient_id=\""+patient_id+"\" " ;		
		xmlStr+= "encounter_date_aft_trunc=\""+encounter_date_aft_trunc+"\" " ;		
		xmlStr+= "pkg_code=\""+eval("formObj.pkg_code"+index).value+"\" " ;		
		xmlStr+= "pkg_seq_no=\""+eval("formObj.pkg_seq_no"+index).value+"\" " ;		
		xmlStr+= "index=\""+index+"\" " ;	
		xmlStr +=" /></root>";
		var updation=formValidation(xmlStr,"getPkgDesc");
 	}else{   		
   		pkg_seq_no.value = "" ;
		eval("formObj.pkg_seq_no_temp"+index).value= "";	
		eval("formObj.pkg_code"+index).value= "";	
 	}	
}

function setPkgDesc(index,pkg_desc){
	eval("document.PkgDtls.pkg_desc"+index).value=pkg_desc;
}
*/
/**the below function is copied from AddModifyPatFinDetails.js for similar validations***/
function chkPayerCreditAuthDate(credit_auth_date,index)
{

	if( validatePkgApprvDtlForm()){
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
	var locale=document.forms[0].locale.value;

	if(credit_auth_date.value != "")
	{
		if(validDate(credit_auth_date.value,'DMY',locale))
		{
			/*if(!isBeforeNow(credit_auth_date.value,"DMY",locale))
			{
					alert(getMessage("BL9114","BL"));
					credit_auth_date.value="";
					credit_auth_date.select();
					return false;
			
			}*/// Commented for CRF-534.1
			
			if(index==0){
			
				parent.frames[0].document.forms[0].credit_auth_date.value=credit_auth_date.value;
				
				}
			return true;
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			credit_auth_date.value="";
			credit_auth_date.select();
			return false;
		}
	}
	else
	{		
		return true;
	}
	
}



/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
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

/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function CheckSplApprDays(Obj,index)
{
	if( validatePkgApprvDtlForm()){
		saveToBean(parent.PkgDtls.document.PkgDtls,index);
	}
	var flag = CheckForChar(Obj);

	if(flag)
	{
		if(chk_for_decimal(Obj))
		{
			if(chk_for_valid_apprv_days_entry(index))
			{
				if(chk_pol_eff_date_validity(eval("document.forms[0].credit_apprd_days"+index),"I",index))
				{
					if(index==0)
						parent.frames[0].document.forms[0].credit_apprd_days.value=Obj.value;
					return true;
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
/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function chk_for_decimal(obj,cld_frm)
{
	var form_var=obj.value;

	var count="";
	count=form_var.indexOf(".");

	if(parseInt(count) >= 0)
	{
		if(cld_frm != "I")
		{
			alert(getMessage("BL9832","BL"));
		}
		obj.select();
		return false;
	}
	return true;
}
/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function chk_for_valid_apprv_days_entry(index)
{
	var policy_eff_frm_date = parent.frames[0].document.forms[0].policy_eff_frm_date.value;
	var policy_eff_to_date = parent.frames[0].document.forms[0].policy_eff_to_date.value;
	var credit_apprd_days = eval("document.forms[0].credit_apprd_days"+index).value;
	var locale=document.forms[0].locale.value;
	var apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;
	if(apprd_days_restrict_check == "R")
	{
		if(policy_eff_frm_date != "" && policy_eff_to_date != "" && credit_apprd_days !="")
		{
			var no_of_days = eval(daysBetween(policy_eff_frm_date,policy_eff_to_date,"DMY",locale))+1;

			if(eval(credit_apprd_days) >  eval(no_of_days))
			{
				alert(getMessage("BL0029","BL"));

				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}
/**the below function is copied from AddModifyPatFinDetailsInsBodyEdit.jsp for similar validations***/
function chk_pol_eff_date_validity(obj,cld_frm,index)
{
	var policy_eff_frm_date = parent.frames[0].document.forms[0].policy_eff_frm_date;
	var credit_apprd_days = eval("document.forms[0].credit_apprd_days"+index);
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc;
	var locale=document.forms[0].locale.value;
	var apprd_days_restrict_check = document.forms[0].apprd_days_restrict_check.value;
	var module_id = document.forms[0].calling_module_id.value;

	if(module_id != 'MP')
	{

		if(policy_eff_frm_date.value != "" && credit_apprd_days.value != "" && apprd_days_restrict_check=='R')
		{
			if(chk_for_decimal(credit_apprd_days,'I'))
			{
				var pol_validity_chk_date = plusDate(policy_eff_frm_date.value,'DMY',locale,eval(credit_apprd_days.value)-1,'d');

				if(!isAfter(pol_validity_chk_date,encounter_date_aft_trunc.value,'DMY',locale))
				{
					alert(getMessage("BL6203","BL"));

					return false;
				}
			else
				{
					eval("document.forms[0].pol_validity_chk_date"+index).value=pol_validity_chk_date;
					return true;
				}
			}
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
}

function validatePkgApprvPayerDtlForm(){

if(parent.PayerDtls.document.PayerDtls){

	formObj=parent.PayerDtls.document.PayerDtls
	var totRec=formObj.total_records.value;
	var cred_auth_req_yn=formObj.cred_auth_req_yn.value;
	var restrict_check=formObj.restrict_check.value;
	var apprd_amt_restrict_check=formObj.apprd_amt_restrict_check.value;
	var apprd_days_restrict_check=formObj.apprd_days_restrict_check.value;
	for(var i=0;i<totRec;i++){
		
		if(cred_auth_req_yn == "Y")
		{
			if(i==0){
				if(eval("formObj.credit_auth_ref"+i).value=="")
				{
					alert(getMessage("BL8148","BL"));
					return false;
				}
				if(eval("formObj.credit_auth_date"+i).value=="")
				{
					alert(getMessage("BL9562","BL"));
					return false;
				}
			}
			
		}
	
		if(restrict_check=="R")
		{
			if(i==0){
				if(apprd_amt_restrict_check == "R")
				{
					if(eval("formObj.credit_apprd_amt"+i).value =="")
					{
						alert(getMessage("BL9564","BL"));
						
						return false;
					}
				}
				if(apprd_days_restrict_check== "R")
				{
					if(eval("formObj.credit_apprd_days"+i).value =="")
					{
						alert(getMessage("BL9563","BL"));
						
						return false;
					}
				}
			}
		}
	/*	if(eval("formObj.credit_auth_ref"+i).value!=""){ commented on 07/05/2010 after discussing with Karrups
			checkForDuplicate(formObj,eval("formObj.credit_auth_ref"+i).value,i);
			if(eval("formObj.credit_auth_date"+i).value=="")
			{
				alert(getMessage("BL9562","BL"));
				
				return false;
			}
			if(eval("formObj.credit_apprd_amt"+i).value =="")
			{
				alert(getMessage("BL9564","BL"));
				
				return false;
			}
			if(eval("formObj.credit_apprd_days"+i).value =="")
			{
				alert(getMessage("BL9563","BL"));
				
				return false;
			}			
		}*/
		/**** added for IN 20964**start **
		if(eval("formObj.credit_apprd_amt"+i).value =="")
			{
				alert(getMessage("BL9564","BL"));
				
				return false;
			}
			**** added for IN 20964**end **/
	}
	

	}
		return true;
}
function validatePkgApprvDtlForm()
{
	if(parent.PkgDtls.document.PkgDtls)	
	{
		formObj=parent.PkgDtls.document.PkgDtls
		var totRec=formObj.total_records.value;
		var appr_amt_rest_chk = formObj.appr_amt_rest_chk.value;

		for(var i=0;i<totRec;i++)
		{
			if(eval("formObj.pkg_code"+i).value!="" && eval("formObj.aprv_amt"+i).value=="" && appr_amt_rest_chk == "R")
			{
				alert(getMessage("BL8604","BL"));
				eval("formObj.aprv_amt"+i).focus();
				return false;
			}
		}	
	}
	return true;
}
function changePayerDtls(obj){

	if(parent.PayerDtls.document.PayerDtls){
		var formObj=parent.PayerDtls.document.PayerDtls
		if(obj.name=="credit_auth_ref"){
			formObj.credit_auth_ref0.value=obj.value;
		}
		if(obj.name=="credit_auth_date"){
			formObj.credit_auth_date0.value=obj.value;
		}
		if(obj.name=="credit_apprd_amt"){
			formObj.credit_apprd_amt0.value=obj.value;
		}
		if(obj.name=="credit_apprd_days"){
			formObj.credit_apprd_days0.value=obj.value;
		}
	}
}

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
	var appr_amt_rest_chk = document.forms[0].appr_amt_rest_chk.value;

	if(pkg_code == "")
	{
		alert(getMessage("BL8501","BL"));
		return false;
	}
	else if(aprv_amt == "" && appr_amt_rest_chk == "R")
	{
		alert(getMessage("BL8686","BL"));
		return false;
	}

	var qryString="payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&noofdecimal="+noofdecimal+"&credit_auth_ref="+credit_auth_ref+"&appr_seq_no="+appr_seq_no+"&parent_index="+index+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&patient_id="+patient_id+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&pkg_disc_type="+pkg_disc_type+"&pkg_disc_amt="+pkg_disc_amt+"&pkg_disc_reason="+pkg_disc_reason+"&pkg_code="+pkg_code+"&pkg_disc_reason_desc="+encodeURIComponent(pkg_disc_reason_desc);

	parent.PkgDiscDtls.location.href="../../eBL/jsp/AddModifyPatFinDetailsInsBodyPkgDiscDtls.jsp?"+qryString;	

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
		alert(getMessage("BL8589","BL"));
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
		alert(getMessage("BL8589","BL"));//Adhoc Discount Amount cannot be blank
		return false;
	}

	if(document.forms[0].type.value != "" && document.forms[0].adhocDiscount.value != "" && document.forms[0].reason_code.value == "")
	{
//		alert("Adhoc Discount Reason cannot be blank");
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

