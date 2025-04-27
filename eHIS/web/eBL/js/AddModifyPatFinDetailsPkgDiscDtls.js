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

		var updation=formValidation(xmlStr,"dupChk");
	}
}

function formValidation(xmlStr,func_mode)
{	   	
	var temp_jsp="PkgApprovalValidation.jsp?func_mode="+func_mode;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

function duplicateAlert(index,form_name)
{
	if(form_name == "PkgDtls")
	{
		eval("parent.PkgDtlsFrame.document.PkgDtls.pkg_dtls"+index).value= "";
		eval("parent.PkgDtlsFrame.document.PkgDtls.pkg_dtls"+index).selectedIndex= 0;
		eval("parent.PkgDtlsFrame.document.PkgDtls.pkg_seq_no"+index).value= "";
		eval("parent.PkgDtlsFrame.document.PkgDtls.pkg_code"+index).value= "";
		eval("parent.PkgDtlsFrame.document.PkgDtls.pkg_desc"+index).value= "";	
		alert(getMessage("BL8507","BL"));
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
		checkForDuplicate(formObj,formObj.appr_seq_no.value+"~~"+eval("formObj.pkg_seq_no"+index).value+"~~"+ eval("formObj.pkg_code"+index).value,index);
	}

	parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
}

function addRow(formName)
{
	if(formName=="PkgDtls")
	{
		formObj=parent.PkgDtlsFrame.document.PkgDtls;
		table = parent.PkgDtlsFrame.document.getElementById('PkgDtls_tbl');	
		rowCount = table.rows.length;			
		index = rowCount-1;	

		if( parent.PkgDiscDtlsFrame.document.PkgDiscDtls !=null)
		{
			saveToBean(parent.PkgDtlsFrame.document.PkgDtls,index,'PKGDTLS');
		}

		row=parent.PkgDtlsFrame.document.getElementById('PkgDtls_tbl').insertRow(rowCount);
			
		var cell1=row.insertCell(0);
		var cell2=row.insertCell(1);
		var cell3=row.insertCell(2);
		var cell4=row.insertCell(3);
		var cell5=row.insertCell(4);

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
		
		cell1.innerHTML=temp;
		cell2.innerHTML="<input type='text' name='pkg_code"+index+"' id='pkg_code"+index+"' value='' size='8' maxlength='8'  readonly>";
		cell3.innerHTML="<input type='text' name='pkg_desc"+index+"' id='pkg_desc"+index+"' value='' size='40' maxlength='100' readonly><input type='hidden' name='pkg_disc_type"+index+"' id='pkg_disc_type"+index+"' value=''><input type='hidden' name='pkg_disc_amt"+index+"' id='pkg_disc_amt"+index+"' value=''><input type='hidden' name='pkg_disc_reason"+index+"' id='pkg_disc_reason"+index+"' value=''><input type='hidden' name='pkg_disc_reason_desc"+index+"' id='pkg_disc_reason_desc"+index+"' value=''>";
		cell4.innerHTML="<a name='pkg_disc_dtls"+index+"' href='#' onClick='showPkgDiscDtls(\""+index+"\")'>"+getLabel('eBL.Dtls.label','BL')+"</a>";		
		cell5.innerHTML="";

		formObj.total_records.value=rowCount;
	}
}

function saveToBean(frmObj,index,calld_frm)
{
	if(frmObj)
	{	
//		var form_name=frmObj.form_name.value;

		var updation=formValidation(formXMLStringMain(frmObj),"saveToBean");
		parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
	}
}

function validatePkgApprvDtlForm()
{	
	if(parent.PkgDtlsFrame.document.PkgDtls)	
	{
		formObj=parent.PkgDtlsFrame.document.PkgDtls
		var totRec=formObj.total_records.value;		
	}	
	return true;
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
	}

	return xmlStr;
}

function showPkgDiscDtls(index)
{
/*	if( validatePkgApprvDtlForm()){
				alert("test4");
		saveToBean(parent.PkgDtlsFrame.document.PkgDtls,index);
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

	var pkgDtlsVals = document.forms[0].pkgDtlsVals.value;/* Added V180529-Aravindh/AMS-SCF-0667/ */
	
	if(pkg_code == "")
	{
		alert(getMessage("BL8501","BL"));
		return false;
	}

	/* Modified V180529-Aravindh/AMS-SCF-0667/Added new parameter pkgDtlsVals */
	var qryString="payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&noofdecimal="+noofdecimal
					+"&credit_auth_ref="+credit_auth_ref+"&appr_seq_no="+appr_seq_no+"&parent_index="+index
					+"&encounter_date_aft_trunc="+encodeURIComponent(encounter_date_aft_trunc)+"&patient_id="+patient_id
					+"&blng_grp_code="+blng_grp_code+"&policy_type_code="+policy_type_code+"&policy_no="+policy_no+"&priority="+priority
					+"&oldMapKey="+encodeURIComponent(oldMapKey)+"&pkg_disc_type="+pkg_disc_type+"&pkg_disc_amt="+pkg_disc_amt
					+"&pkg_disc_reason="+pkg_disc_reason+"&pkg_code="+pkg_code+"&pkg_disc_reason_desc="+encodeURIComponent(pkg_disc_reason_desc)
					+"&pkgDtlsVals="+pkgDtlsVals;

	parent.PkgDiscDtlsFrame.location.href="../../eBL/jsp/AddModifyPatFinDetailsPkgDiscDtls.jsp?"+qryString;	
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
					/* Added V180529-Aravindh/AMS-SCF-0667/Starts */
					var pkgAmtTemp = "";
					var pkgCode = document.forms[0].pkg_code;
					var pkgDtlsValsArray = document.forms[0].pkgDtlsVals.value.split("^~^");
					for(var i = 0; i < pkgDtlsValsArray.length; i++) {
						var valsTemp = pkgDtlsValsArray[i].split("~~");
						if(valsTemp[0] == pkgCode.value){
							pkgAmtTemp = valsTemp[3];
						}
					}
					
					if(pkgAmtTemp == "") {
						pkgAmtTemp = "0";
					}
					
					if(parseFloat(obj.value) > parseFloat(pkgAmtTemp))
					{
						alert(getMessage("BL0751","BL")+" "+obj.value+" / "+pkgAmtTemp);
						obj.value="";
						eval('document.forms[0].reason_desc').value="";
						obj.focus();
						return false;
					}
					/* Added V180529-Aravindh/AMS-SCF-0667/Ends */
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
	var formObj=parent.PkgDtlsFrame.document.PkgDtls;

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
			//Added by muthu against 32361 on 24/5/2012		
			formObj.add_button1.value = "Y";
			//Added by muthu against 32361 on 24/5/2012
			parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
		}
	}
}

function ModifyPkgDiscDtls()
{
	var parent_index = document.forms[0].parent_index.value;
	var formObj=parent.PkgDtlsFrame.document.PkgDtls;

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
			//Added by muthu against 32361 on 24/5/2012		
			formObj.add_button1.value = "Y";
			//Added by muthu against 32361 on 24/5/2012
				parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
			}
		}		
	}
}

function RemovePkgDiscDtls()
{
	var parent_index = document.forms[0].parent_index.value;
	var formObj=parent.PkgDtlsFrame.document.PkgDtls;

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

		//Added by muthu against 32361 on 24/5/2012		
			formObj.add_button1.value = "Y";
		//Added by muthu against 32361 on 24/5/2012

//		alert("Package Discount Removed from "+pkg_code);
		parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
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
		parent.PkgDiscDtlsFrame.document.forms[0].disc_auth_YN.value=retVal;
/*
		if(retVal=="Y")
		{
			parent.PkgDiscDtlsFrame.document.forms[0].auth_btn.disabled=true;
			document.forms[0].type.disabled = false;
			document.forms[0].adhocDiscount.disabled = false;
			document.forms[0].reason_desc.disabled = false;
			document.forms[0].reasonbut.disabled = false;
			document.forms[0].add_button.disabled = false;
		}
		else
		{
			parent.PkgDiscDtlsFrame.document.forms[0].auth_btn.disabled=false;
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
	var setlmt_ind = document.forms[0].setlmt_ind.value;
	var adm_rec_flag = document.forms[0].adm_rec_flag.value;
	var payer_grp_code = "";
	var payer_code = "";
	if(setlmt_ind == 'R')//Credit
	{
		payer_grp_code = document.forms[0].cust_group_code_1.value;
		payer_code = document.forms[0].cust_1.value;
	}
	else if(setlmt_ind == 'X' && adm_rec_flag == '1')//Sponsor
	{
		payer_grp_code = document.forms[0].cust_group_code_2.value;
		payer_code = document.forms[0].cust_2.value;		
	}
	var billing_group = document.forms[0].billing_group.value;

	var center='1';
	var dialogTop	= '90';
	var dialogHeight	= '20';
	var dialogWidth		= '60';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var title=encodeURIComponent(getLabel("eBL.PackageDiscount.label","BL"));
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patientId="+patient_id+"&function_id="+function_id+"&package_enabled_yn="+package_enabled_yn+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&blng_grp_code="+billing_group;
	retVal=window.showModalDialog("../../eBL/jsp/AddModifyPatFinDetailsPkgApprvDtlsMain.jsp?"+param,arguments,features);	
}

function closediscwin()
{
	window.close();
}


function funApply()
{
//Added by muthu against 32361 on 24/5/2012
	var add_button1 = parent.PkgDtlsFrame.document.forms[0].add_button1.value; 
	if(add_button1 == "Y"){	
//Added by muthu against 32361 on 24/5/2012
	var billing_group = parent.PkgDtlsFrame.document.forms[0].blng_grp_code.value;
	var payer_grp_code = parent.PkgDtlsFrame.document.forms[0].payer_grp_code.value;
	var payer_code = parent.PkgDtlsFrame.document.forms[0].payer_code.value;
	var appr_seq_no = parent.PkgDtlsFrame.document.forms[0].appr_seq_no.value;


	if(!validatePkgApprvDtlForm())
	{
		return;
	}

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var updation=formValidation(xmlStr,"clearBean");
	saveToBean(parent.PkgDtlsFrame.document.PkgDtls,'');

	var formObj=parent.PkgDtlsFrame.document.forms[0];	
	var oldMapKey=formObj.oldMapKey.value;
	var currMapKey=trimString(billing_group)+"~~"+trimString(payer_grp_code)+"~~"+trimString(payer_code);
	if(oldMapKey!=currMapKey)
	{//rename oldMapKey  with currMapKey in payerDtls collection of PkgApprovalBean
		renameBeanKey(formObj,oldMapKey,currMapKey,'');
	}
	var strNULL = "";
	var xmlStr ="<root><SEARCH ";	
	xmlStr+= "billing_group_desc=\""+strNULL+"\" " ;		
	xmlStr+= "blng_grp_code=\""+billing_group+"\" " ;		
	xmlStr+= "payer_desc=\""+strNULL+"\" " ;		
	xmlStr+= "cust_3=\""+payer_code+"\" " ;		
	xmlStr+= "priority=\""+strNULL+"\" " ;	
	xmlStr+= "policy_type_desc=\""+strNULL+"\" " ;	
	xmlStr+= "policy_type_code=\""+strNULL+"\" " ;	
	xmlStr+= "policy_no=\""+strNULL+"\" " ;	
	xmlStr+= "policy_start_date=\""+strNULL+"\" " ;	
	xmlStr+= "policy_exp_date=\""+strNULL+"\" " ;	
	xmlStr+= "appr_seq_no=\""+appr_seq_no+"\" " ;	
	xmlStr+= "credit_auth_ref=\""+strNULL+"\" " ;	
	xmlStr+= "credit_auth_date=\""+strNULL+"\" " ;	
	xmlStr+= "credit_apprd_amt=\""+strNULL+"\" " ;	
	xmlStr+= "credit_apprd_days=\""+strNULL+"\" " ;	
	xmlStr+= "policy_eff_frm_date=\""+strNULL+"\" " ;	
	xmlStr+= "policy_eff_to_date=\""+strNULL+"\" " ;	
	xmlStr+= "adj_rule_ind=\""+strNULL+"\" " ;	
	xmlStr+= "adj_perc_amt_ind=\""+strNULL+"\" " ;	
	xmlStr+= "adj_perc_amt_value=\""+strNULL+"\" " ;	
	xmlStr+= "pmnt_diff_adj_int=\""+strNULL+"\" " ;	
	xmlStr+= "drg_pmnt_diff_adj_int=\""+strNULL+"\" " ;	
	xmlStr+= "spl_srv_pmnt_diff_adj_int=\""+strNULL+"\" " ;	
	xmlStr+= "restrict_check=\""+strNULL+"\" " ;	
	xmlStr+= "valid_payer_YN=\""+strNULL+"\" " ;	
	xmlStr+= "valid_policy_type_code_YN=\""+strNULL+"\" " ;	
	xmlStr+= "cust_group_code=\""+payer_grp_code+"\" " ;	
	xmlStr+= "policy_coverage_basis_ind=\""+strNULL+"\" " ;	
	xmlStr+= "referral_source_main_code=\""+strNULL+"\" " ;	
	xmlStr+= "referral_source_main_desc=\""+strNULL+"\" " ;	
	xmlStr+= "referral_source_sub_code=\""+strNULL+"\" " ;	
	xmlStr+= "referral_source_sub_desc=\""+strNULL+"\" " ;	
	xmlStr+= "apprd_amt_restrict_check=\""+strNULL+"\" " ;	
	xmlStr+= "apprd_days_restrict_check=\""+strNULL+"\" " ;	
	xmlStr+= "cred_auth_req_yn=\""+strNULL+"\" " ;	
	xmlStr+= "dflt_auth_ref_as_pol_no_yn=\""+strNULL+"\" " ;	
	xmlStr+= "cust_valid_from_date=\""+strNULL+"\" " ;	
	xmlStr+= "cust_valid_to_date=\""+strNULL+"\" " ;	
	xmlStr+= "ins_cust_group_name=\""+strNULL+"\" " ;	
	xmlStr+= "pol_validity_chk_date=\""+strNULL+"\" " ;	
	xmlStr +=" /></root>";		

	var updation=formValidation(xmlStr,"nonInsHdrVals");
	parent.window.close();
 }
 //Added by muthu against 32361 on 24/5/2012
 else
	{
	 alert(getMessage("BL9127","BL"));
	}
//Added by muthu against 32361 on 24/5/2012
/*
	if(!validatePkgApprvPayerDtlForm())
	{	
		return;
	}
	saveToBean(parent.PayerDtls.document.PayerDtls,'')
	*/
}

function renameBeanKey(frmObj,oldMapKey,currMapKey,index)
{	
	var xmlStr ="<root><SEARCH ";

	xmlStr+= "oldMapKey=\"" +oldMapKey+ "\" " ;
	xmlStr+= "currMapKey=\"" +currMapKey+ "\" " ;
	xmlStr +=" /></root>";

	var updation=formValidation(xmlStr,"renameBeanKey");
}

