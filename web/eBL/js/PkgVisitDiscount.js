
function onChangePkgCustDtls(obj,index)
{
	
	var formObj=document.PkgDtls;
	if(checkDuplicate(obj,index))
		{
		alert('Alredy selected this same packagecode and customergroup combination');
		obj.value="";
		return;
		}
	
	var st=new Array();	
	if(obj.value != "")
	{
		st=(obj.value).split("~");
		eval("formObj.cust_grp"+index).value=st[0];
		eval("formObj.cust_code"+index).value=st[1];
		eval("formObj.cust_desc"+index).value=st[2];	
	}
	else
	{
		eval("formObj.cust_grp"+index).value="";
		eval("formObj.cust_code"+index).value="";
		eval("formObj.cust_desc"+index).value="";	
	}


}

function checkDuplicate(obj,index)
{
	formObj=parent.PkgVisitAdhocDiscountDtlsFrame.document.PkgDtls;
	table = parent.PkgVisitAdhocDiscountDtlsFrame.document.getElementById('PkgDtls_tbl');	
	rowCount = table.rows.length;
	
	var pkg_dtls,pkg_dtls_cur;
	var cust_dtls,cust_dtls_cur;
	
	
	for(var i =0;i<rowCount-2;i++)
		{
		if( i != index)
			{
			 pkg_dtls = eval('formObj.pkg_dtls'+i+'.value');
			 
			 pkg_dtls_cur=eval('formObj.pkg_dtls'+index+'.value');
			  cust_dtls = eval('formObj.pkg_cust_desc'+i+'.value');
			  cust_dtls_cur=eval('formObj.pkg_cust_desc'+index+'.value');
			  
			  
			  
			if(pkg_dtls == pkg_dtls_cur && cust_dtls == cust_dtls_cur)
				{
				 return true;
				}
		  
			}
		  
		
		}
	
}

function onChangePkgDiscDtls(obj,index)
{
	var formObj=document.PkgDtls;
	
	var st=new Array();	
	if(checkDuplicate(obj,index))
	{
	alert('Alredy selected this same packagecode and customergroup combination');
	obj.value="";
	return;
	}
	
	if(obj.value != "")
	{
		st=(obj.value).split("~~");
		eval("formObj.pkg_code"+index).value=st[0];
		eval("formObj.pkg_desc"+index).value=st[1];
		eval("formObj.pkg_seq_no"+index).value=st[2];
		/* Added V180529-Aravindh/AMS-SCF-0667/if-condition*/
		if(formObj.pkgAmtValidSiteSpec.value == "true" || formObj.pkgAmtValidSiteSpec.value == true) {
			document.getElementById('pkg_amt'+index).value=st[3];
		} else {
			document.getElementById('pkg_amt'+index).value=st[4]; //Added By Vijay FOr MMS-ICN-00025
		}
		//alert(document.getElementById('pkg_amt'+index).value);
	}
	else
	{
		eval("formObj.pkg_code"+index).value="";
		eval("formObj.pkg_desc"+index).value="";
		eval("formObj.pkg_seq_no"+index).value="";	
	}
	
/*	if(obj.value != "")
	{
		checkForDuplicate(formObj,formObj.appr_seq_no.value+"~~"+eval("formObj.pkg_seq_no"+index).value+"~~"+ eval("formObj.pkg_code"+index).value,index);
	}
	*/

//	parent.PkgDiscDtlsFrame.location.href="../../eCommon/html/blank.html";
}

function addRowDiscount(formName)
{
	 
	if(formName=="PkgDtls")
	{
		formObj=parent.PkgVisitAdhocDiscountDtlsFrame.document.PkgDtls;
		table = parent.PkgVisitAdhocDiscountDtlsFrame.document.getElementById('PkgDtls_tbl');	
		rowCount = table.rows.length;			
		index = rowCount-1;	
		index1 = index -1 ;

		/*if( parent.PkgDiscDtlsFrame.document.PkgDiscDtls !=null)
		{
			saveToBean(parent.PkgDtlsFrame.document.PkgDtls,index,'PKGDTLS');
		}*/

		 var pkg_dtls_cur=eval('formObj.pkg_dtls'+index1+'.value');
		 var cust_dtls_cur=eval('formObj.pkg_cust_desc'+index1+'.value');
		 var amnt_cur = eval('formObj.pkg_disc_amt'+index1+'.value');
		 var reason_dsc =eval('formObj.reason_desc'+index1+'.value');
		 
		 
		 if(pkg_dtls_cur =='' || cust_dtls_cur== '' || amnt_cur == '' || reason_dsc=='')
			 {
			 alert('In current row all values are not entered');
			 return;
			 }
		
		row=parent.PkgVisitAdhocDiscountDtlsFrame.document.getElementById('PkgDtls_tbl').insertRow(rowCount);
		
		
			
		var cell1=row.insertCell(0);
		var cell2=row.insertCell(1);
		var cell3=row.insertCell(2);
		var cell4=row.insertCell(3);
		var cell5=row.insertCell(4);
		var cell6=row.insertCell(5);
		var cell7=row.insertCell(6);		
		
				

		var temp="<select name='pkg_dtls"+index+"' id='pkg_dtls"+index+"' onChange='onChangePkgDiscDtls(this,\""+index+"\");'><option value=''>---"+getLabel("Common.defaultSelect.label","common")+"---</option>"

		var st=new Array();	
		st=(formObj.pkgDtlsVals.value).split("^~^");
		if(st!=null && st!="")
		{
			for(var i=0;i<st.length;i++)
			{	
				var tempStr=new Array();
				tempStr=st[i].split("~~");
				//Added by Rajesh V
				var pos = tempStr[0].lastIndexOf("@:");
				if(pos != -1){
					tempStr[0] = tempStr[0].substring(0,pos);
				}
				temp+="<option value='"+st[i]+"'>"+tempStr[0]+"-"+tempStr[1]+"-"+tempStr[2]+"</option>";							
			}
		}
		temp+="<input type='hidden' name = 'pkg_code"+index+"' value=''>";
		temp+="<input type='hidden' name = 'pkg_desc"+index+"' value=''>";
		temp+="<input type='hidden' name = 'pkg_seq_no"+index+"' value=''>";
		temp+="<input type='hidden' name = 'pkg_amt"+index+"' value=''>";
		cell1.innerHTML=temp;
		
		temp='';	
		st1=formObj.plcy_count.value;
		
	
		for(var i=0;i<st1;i++)
		{	
			
			temp+="<option value='"+eval("formObj.cust_dtls"+i+".value")+"'>"+eval("formObj.cust_dtls"+i+".value")+"</option>";							
		}
		
		
		cell2.innerHTML="<select name='pkg_cust_desc"+index+"' id='pkg_cust_desc"+index+"' onChange='onChangePkgCustDtls(this,"+index+")' ><option value=''>---"+getLabel("Common.defaultSelect.label","common")+"---</option>"+temp+"</select> <input type='hidden' name = 'cust_grp"+index+"' value=''><input type='hidden' name = 'cust_code"+index+"' value=''><input type='hidden' name = 'cust_desc"+index+"'' value=''>";
		cell3.innerHTML="<select name='pkg_disc_type"+index+"' id='pkg_disc_type"+index+"' onChange='resetDiscAmt(this,"+index+")' > <option value='A' >"+getLabel("Common.amount.label","common")+"<option value='R'  >"+getLabel("Common.Percent.label","common")+"</option></select>";
		cell4.innerHTML="<input type='text' name='pkg_disc_amt"+index+"' id='pkg_disc_amt"+index+"' size=8 value=''  onBlur='chkAmtDiscPer1(this,"+index+")'>";
		cell5.innerHTML="<input type='text' name='reason_desc"+index+"' id='reason_desc"+index+"' value=''  size='8' maxlength='8'><input type='hidden' name='reason_code"+index+"' id='reason_code"+index+"' value=''><input type='button' class='button' name='reasonbut"+index+"' id='reasonbut"+index+"' value='?' onClick=\"searchDiscountReason('C',"+index+")\"><img src='../../eCommon/images/mandatory.gif'>";
		//cell6.innerHTML= "<a name='addRow_"+index+"'  href='#' onClick=\"addRowDiscount(\'PkgDtls\');\">+</a>";		
		//cell7.innerHTML="";
		cell6.innerHTML="";

		formObj.total_records.value=rowCount;
	}
}

function resetDiscAmt(obj,index)
{
	
	eval("document.forms[0].pkg_disc_amt"+index).value = "";
	
}

function chkAmtDiscPer1(obj,index)
{	
//if(document.forms[0].auth_discount.value=="") //Commented By Muthukumar and added below condition against 31094(Issue -5) on 17/5/12
	//Added by Rajesh V for ICN-008. Added below else-if blocks
	
	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
			obj.value="";
	}
	else if((parseInt(eval("document.forms[0].pkg_disc_amt"+index).value) == 0 
			|| eval("document.forms[0].pkg_disc_amt"+index).value == "")
			&& eval("document.forms[0].reason_code"+index).value != ""){
		var msg = getMessage("BL6322","BL");
		alert(msg+"/"+"0.00");
		eval("document.forms[0].pkg_disc_amt"+index).value = "";
		eval("document.forms[0].reason_code"+index).value = "";
		eval("document.forms[0].reason_desc"+index).value = "";
	}
	else if(eval("document.forms[0].pkg_disc_amt"+index).value == "" && 
		eval("document.forms[0].reason_code"+index).value == ""){
		eval("document.forms[0].pkg_disc_amt"+index).value = "";
	}
	
	if(eval("document.forms[0].pkg_disc_type"+index).value == "R")
	{
		if(obj.value>100 || obj.value<0)
		{			
			alert(getMessage("BL8539","BL"));
			obj.value="";
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
	}
	
	//Added By Vijay For MMS-ICN-00025
	var pkg_amt=document.getElementById('pkg_amt'+index);
	var noofdecimal=document.forms[0].noofdecimal.value;
	putDecimal(obj,13,noofdecimal);
	putDecimal(pkg_amt,13,noofdecimal);

	//alert(obj.value)
	//alert(pkg_amt.value)
	
	if(parseFloat(obj.value)>parseFloat(pkg_amt.value))
			{
			alert('Discount Amount '+obj.value+ ' cannot be Greater than the Package Amount '+pkg_amt.value);
			obj.value="";
			eval("document.forms[0].reason_desc"+index).value = "";
			return false;
			
			}
		//Ends...

	
}




function callPackgeDiscount(patient_id,calling_module_id)
{

	var function_id="";
var bed_type="";

var priorityOneParam  = '';

	if(calling_module_id=="OP")
		function_id="VISIT_REGISTRATION";	
	else if(calling_module_id=="IP"){		
		function_id="ADMISSION";	
		bed_type=document.forms[0].bed_type.value;
		//alert('bed_type='+bed_type);
		//alert('document.forms[0].name='+document.forms[0].name);
		}
		var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var patient_id=patient_id;
	var center='1';
	var dialogTop	= '90';
	var dialogHeight	= '98vh';
	var dialogWidth		= '98vw';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var title=encodeURIComponent(getLabel("eBL.Pack_Subs.label","BL"));
	//var title=encodeURIComponent("Package Subscription");
	
	
	
	if(parent.MainFrame2.InsuranceFrame != undefined){
		if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
			var insBodyFrm = parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain;			
			
			if(insBodyFrm.name == 'add_modify_pat_fin_det_insmain'){
				var totalRecord = insBodyFrm.total_records.value;
				if(totalRecord>0){
					for(var indx=0;indx<totalRecord;indx++){						
						//if(eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.priority'+indx).value==1){
							insCustGrp = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_code'+indx).value;
							insCust = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.cust_3'+indx).value;							
							insCustDesc = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.payer_desc'+indx).value;
							//break;
						//}					
						
						priorityOneParam = ''+ priorityOneParam + '&insCustGrp'+indx+'='+insCustGrp+'&insCust'+indx+'='+insCust+'&insCustDesc'+indx+'='+encodeURIComponent(insCustDesc);
						
						
											
					}					
				}
				
				priorityOneParam=priorityOneParam+'&plcy_count='+totalRecord;
			}
		}
	}
	/*if(insCustGrp.length>0){
		priorityOneParam = '&insCustGrp='+insCustGrp+'&insCust='+insCust+'&insCustGrpDesc='+encodeURIComponent(insCustGrpDesc)+
							'&insCustDesc='+encodeURIComponent(insCustDesc);
	}*/
	
	
	
	
	
	
	
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patientId="+patient_id+"&function_id="+function_id+"&bed_type="+bed_type+"&package_enabled_yn="+package_enabled_yn;
	//alert("param"+param);
	param = param+priorityOneParam;

	param = 
	retVal=window.showModalDialog("../../eBL/jsp/PkgVisitDiscountFrame.jsp?"+param,arguments,features);	
	
	//if(retVal=="Y" && function_id=="VISIT_REGISTRATION"){
	//callPkgDeposit(patient_id,function_id)
	//}
	

}


function packageDiscountDetails(function_id)
{	
	var frmObj="";	
	
	frmObj =  parent.PkgVisitAdhocDiscountDtlsFrame.document.PkgDtls;	
    if( frmObj!=null && frmObj != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "select-multiple" )
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
	}
//alert("xmlStr :"+xmlStr);
	
	var temp_jsp="PkgDiscountValidation.jsp?func_mode=saveToBean&function_id="+function_id;
	xmlStr +=" /></root>";
	//alert("xmlStr :"+xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
//	alert("responseText :"+responseText);
	eval(responseText);
	//return true;
	window.parent.returnValue="Y";
window.close();
 }

async function callAuth()
{   
	var retVal=new Array();
	var dialogHeight= "200px" ;
	var dialogWidth	= "250px" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);
	//alert(retVal);
	//alert('retval '+retVal);
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;
	//alert("fsdds :"+parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value);
	/*document.forms[0].auth_discount.value=retVal;
	if(parent.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		parent.PkgAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;		
	}*/
	
	if(retVal=="Y"){
	parent.PkgVisitAdhocDiscountBtnFrame.document.forms[0].auth_btn.disabled=true;
	}
}


function validateDisInd1(obj,index)
{	
//if(document.forms[0].auth_discount.value=="") //Commented By Muthukumar and added below condition against 31094(Issue -5) on 17/5/12
	if(document.forms[0].auth_discount.value=="N" || document.forms[0].auth_discount.value=="" || document.forms[0].auth_discount.value=="undefined")
	{
		alert(getMessage("BL7495","BL"));
		return;
	}
	else{
		validateDiscInd(obj,index)
	}
}

function validateDiscInd(obj,index)
{
	eval("document.forms[0].pkg_disc_amt"+index).value="";
}

function searchDiscountReason(clng_evnt,index)
			{
				//Modified below if Condition - MMS-ICN-008 Rajesh V
				if(eval("document.forms[0].pkg_disc_amt"+index).value=="" || parseInt(eval("document.forms[0].pkg_disc_amt"+index).value) == 0 )
				{			
					var msg = getMessage("BL6322","BL");
					alert(msg+"/"+"000");
					eval("document.forms[0].reason_desc"+index).value="";
					return false;
				}
				var obj=eval("document.forms[0].reason_desc"+index);
				if(clng_evnt == 'B')
				{
					if(obj.value == "")
					{					
						eval("document.forms[0].reason_desc"+index).value="";
						eval("document.forms[0].reason_code"+index).value="";
						//document.forms[0].reason_code.value="";	
						return;
					}
				}
				var target			= eval("document.forms[0].reason_desc"+index);
				var retVal			=  new String();
				var dialogTop	 = "10";
				var dialogHeight = "10" ;
				var dialogWidth	 = "30" ;
				var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
		//		var title = encodeURIComponent(title);		
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
					eval("document.forms[0].reason_code"+index).value=retArray[0];
					eval("document.forms[0].reason_desc"+index).value=retArray[1];
//					document.forms[0].reason_desc.value=retArray[1];			
								
				}
				else
				{			
					eval("document.forms[0].reason_code"+index).value="";
					eval("document.forms[0].reason_desc"+index).value="";
					//	document.forms[0].reason_code.value="";		
				}
			}


