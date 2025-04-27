/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
13/0/2020	IN072690     Shazana	                                     SKR-SCF-1328
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 



//saved on 27/10/2005
var function_id = "PH_GENERIC_NAME_BY_ATC_CLASS" ;
var result = false ;
var message = "" ;
var flag = "" ;

var globalatcclassification="";
var globalpharmaclassification="";

var start = 0 ;
var end   = 0 ;
var maxRec = 0  ;
var displaySize = 0 ;

var count=0;
var retAllValues="";

function create() {
	if (genericNameFrame.genericname_top != null){
		genericNameFrame.genericname_top.location.href="../../ePH/jsp/GenericNameAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		genericNameFrame.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
	}
	else{
		genericNameFrame.location.href="../../ePH/jsp/GenericNameFrame.jsp?param=createIfFrameIsNull";
	}
}
function query() {

	genericNameFrame.location.href="../../ePH/jsp/GenericNameByATCQueryCriteria.jsp";
}

function apply() {
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var mode="";
	if (genericNameFrame.genericname_top != null){
		mode = genericNameFrame.genericname_top.document.frmGenericNameAddModify.mode.value;
	}
	if (genericNameFrame.frmGenericnameByATCQueryCriteria != null){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	if( mode == MODE_INSERT ) {
		var formObj1=genericNameFrame.genericname_top.document.frmGenericNameAddModify;
		var formObj2=genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify;
		var formObj=new Array (formObj1,formObj2);
		var fields = new Array ( formObj1.generic_name,formObj1.drug_name);
		var names = new Array ( getLabel("Common.name.label","Common"),getLabel("ePH.DrugClass.label","PH"));
		//alert(names)
		if (genericNameFrame.genericname_top.checkFieldsofMst( fields, names, messageFrame)){
			if (genericNameFrame.genericname_bottom.document.getElementById("newRecordsTable") != null){
				var noOfRecords=parseInt(genericNameFrame.genericname_bottom.document.getElementById("newRecordsTable").rows.length - 1);
				for (var i=1;i<=noOfRecords ;i++ ){
					if (eval("formObj2.select"+i).checked==true){
						break;
					}
					else if (eval("formObj2.select"+i).checked==false && (noOfRecords == i)){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","PH");
						return ;
					}
				}
			}
//			alert(formApply(formObj,PH_CONTROLLER));
			eval(formApply(formObj,PH_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				genericNameFrame.genericname_top.location.href="../../ePH/jsp/GenericNameAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
				genericNameFrame.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
			}
		}
	}

	if( mode == MODE_MODIFY ) {
		var formObj1=genericNameFrame.genericname_top.document.frmGenericNameAddModify;
		var formObj2=genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify;	
		
		
		if (formObj1.generic_name!=null && checkDeleteFound(genericNameFrame.genericname_bottom.frmGenericNameByATCAddModify)){			
			var formObj=new Array (formObj1,formObj2);
			var fields = new Array ( formObj1.generic_name,formObj1.drug_name);
			var names = new Array (getLabel("Common.name.label","Common"),getLabel("ePH.DrugClass.label","PH"));
			var enabledisable="";
			if (!formObj1.eff_status.checked){
				enabledisable="disabled";
			}


			if (genericNameFrame.genericname_top.checkFieldsofMst( fields, names, messageFrame)){
               //alert(formApply(formObj,PH_CONTROLLER));
				eval(formApply(formObj,PH_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if (result){
					var drugclass="";
					if (formObj1.drug_name.value == "G"){
						drugclass="General";
					}
					else if (formObj1.drug_name.value == "N"){
						drugclass="Narcotic";
					}
					else if (formObj1.drug_name.value == "C"){
						drugclass="Controlled";
					}
					genericNameFrame.genericname_top.location.href="../../ePH/jsp/GenericNameAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+formObj1.generic_id.value+"&drugclass="+drugclass;
					genericNameFrame.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+formObj1.generic_id.value+"&enabledisable="+enabledisable;
				}
			}

		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		/* @Name - Krishna Kiran 
		 * @Date - 18/12/2009
		 * @Inc# - IN017314
		 * @Desc - allows to apply the gneric name effective status when search by ATC classification is selected 
		 */
		if (formObj2.call_from.value == 'UpdateByATCClassification')
		{
			
			eval(formApply(genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify,PH_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if (!result){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}else{
			genericNameFrame.location.href="../../ePH/jsp/GenericNameByATCQueryCriteria.jsp";
			}
			
		}
	if (mode == ""){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {
	var url = document.genericNameFrame.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("frmgenericnameaddmodify")!=-1) ) {
		if (genericNameFrame.genericname_top != null){
			genericNameFrame.genericname_top.document.frmGenericNameAddModify.reset();
			genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.reset();
		}
		else{
			genericNameFrame.location.href="../../ePH/jsp/GenericNameFrame.jsp?param=createIfFrameIsNull";
		}
	}
	else{

		if (genericNameFrame.genericname_top != null){
			if (genericNameFrame.genericname_top.document.frmGenericNameAddModify != undefined)
			{
				genericNameFrame.genericname_top.document.frmGenericNameAddModify.reset();
				genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.reset();
				if (genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.call_from.value == 'byGenericName')
				{
				var len = genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.mainData.rows.length;
				if(genericNameFrame.genericname_top.document.frmGenericNameAddModify.eff_status.checked){
					for(var i=1;i<len;i++){
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.chkdelete"+i).disabled = false;
					}
				}else{
					for(var i=1;i<len;i++){
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.chkdelete"+i).disabled = true;
					}
				}
				}else if (genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.call_from.value == 'UpdateByATCClassification')
				{
				
					var count = genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.rows_count.value;
					for (i=0;i<count ;i++ )
					{
						if (eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.h_atc_eff_status_"+i).value == "E")
						{
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.atc_eff_status_"+i).checked = true;
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.atc_eff_status_"+i).value = "E";
						}else{
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.atc_eff_status_"+i).checked = false;
						eval("genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.atc_eff_status_"+i).value = "D";
						}
					}
					callResetEnableDisable();

				}
			}
		}
		else if ((genericNameFrame.frmGenericnameByATCQueryCriteria != null)){
			genericNameFrame.frmGenericnameByATCQueryCriteria.reset();
			if (genericNameFrame.frmGenericnameByATCQueryCriteria.drug_name.value=="G")	{
				genericNameFrame.frmGenericnameByATCQueryCriteria.btnExecute1.style.visibility="hidden";
				var objRow=genericNameFrame.queryCriteriaTable.children[1];
				objRow.children[3].style.visibility='visible';
				objRow.children[4].style.visibility='visible';
				objRow.children[5].style.visibility='visible';
				objRow.children[6].style.visibility='visible';
				objRow.children[7].style.visibility='visible';
				objRow.children[8].style.visibility='visible';
				genericNameFrame.frmGenericnameByATCQueryCriteria.generic_name.style.visibility='visible';
				genericNameFrame.frmGenericnameByATCQueryCriteria.drug_class.style.visibility='visible';
				genericNameFrame.frmGenericnameByATCQueryCriteria.eff_status.style.visibility='visible';
			}
		}
	}
}

function Modify(obj) {
	var generic_id    = obj.children[0].value;
	var enabledisable = "";
	if( obj.children[3].children[1].value =="D")
		 enabledisable = "disabled"
	else
		 enabledisable = "enabled"
	parent.genericNameFrame.location.href="../../ePH/jsp/GenericNameFrame.jsp?param=ModifyIfFrameIsNull&generic_id="+generic_id+"&drugclass="+obj.children[2].innerHTML+"&enabledisable="+enabledisable;
}
function checkIsValidForProceed() {

	var url="";
	if (genericNameFrame.genericname_top != null){
		url = genericNameFrame.genericname_top.location.href;
		url = url.toLowerCase();
	}

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("genericnamebyatc")==-1) )
		return true;
	else
		return false;
}
async function callAssociateATC()
{
	var dialogHeight= "700px" ;
	var dialogWidth	= "900px" ;
	var dialogTop = "60px" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationFrames.jsp?called_from=generic_atc&mode="+MODE_INSERT,arguments,features);
	if (retVal == "cancel" || retVal==null || retVal==undefined){}
	else if(retVal!="cancel" && retVal!="undefined")
		{
		count = count+1;
		var result=duplicationCheck(retVal,count);
		
		

		if (result == false){
			return false;
		}
		

		
		if (document.getElementById("mode") != null ){
			
			if (document.getElementById("mode").value==MODE_INSERT){
				if (globalatcclassification == ""){
					globalatcclassification = globalatcclassification+retVal;
				}
				else{
					globalatcclassification = globalatcclassification+"|"+retVal;
				}
				parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&called=atc&mode="+MODE_INSERT+"&atcclassification="+escape(globalatcclassification);
			}
			else {
				retValBackupInModify=globalatcclassification;
				if (globalatcclassification == ""){
					globalatcclassification = globalatcclassification+retVal;
				}
				else{
					globalatcclassification = globalatcclassification+"|"+retVal;
				}
				if (parent.genericname_bottom.document.getElementById("mainData") != null){
					var result=duplicationCheckInModify(retVal,parent.genericname_bottom.document.getElementById("associatedValues").value,parseInt(parent.genericname_bottom.document.getElementById("mainData").rows.length - 1));
					if (result == false){
						parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+document.getElementById("generic_id").value+"&atcclassification="+escape(globalatcclassification)+"&resultByATC=N";
					}
					else{
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ALREADY_SELECTED","PH");
						globalatcclassification=retValBackupInModify;
					}
				}
				else{
					parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+document.getElementById("generic_id").value+"&atcclassification="+escape(globalatcclassification)+"&resultByATC=N";
				}
			}
		}
		else{

		document.frames.location.href="../../ePH/jsp/GenericNameFrame.jsp?param=ATCClassification&atcclassification="+escape(retVal)+"&resultByATC=Y";
		}
	}
}

function displayToolTip(lev1,lev2,lev3,lev4,lev5) {

	buildTable(lev1,lev2,lev3,lev4,lev5);
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var x 	  = event.clientX; //IN072690
	var y 	  = event.clientY; //IN072690
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
	y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(y<bodheight)
	
		y = event.clientY //IN072690
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight)

	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible';
}
function displayToolTipPhar(lev1,lev2,lev3) {

	buildTablePhar(lev1,lev2,lev3);
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var x 	  = event.clientX; //IN072690
	var y 	  = event.clientY; //IN072690
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
	y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(y<bodheight)
		//y = event.y;//COMMENTED FOR IN072690
		y = event.clientY //IN072690
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight)

	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible';
}

function buildTable(lev1,lev2,lev3,lev4,lev5){
	        var  Anatomical_Class = getLabel('ePH.AnatomicalClass.label','PH')
	       
			var TherapeuticMain=getLabel('ePH.TherapeuticClass.label','PH') + "("+ getLabel('ePH.MainClass.label','PH') + ")" 
				
			var  TherapeuticSub=getLabel('ePH.TherapeuticClass.label','PH') + "("+ getLabel('Common.SubClass.label','Common') + ")" 
				
			var  ChemicalMain=getLabel('ePH.ChemicalClass.label','PH') + "("+ getLabel('ePH.MainClass.label','PH') + ")" 	

			var  Chemicalsub=getLabel('ePH.ChemicalClass.label','PH') + "("+ getLabel('Common.SubClass.label','Common') + ")" 	

	       
			var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' >"
			tab_dat     += "<tr><td align='right' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%' class='TOOLTIP' nowrap  >"+Anatomical_Class+"</td> <td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev1+"</td></tr>";
			if (lev2 != " " && lev2 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>"+TherapeuticMain+" </td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev2+"</td></tr>";
			}
			if (lev3 != " " && lev3 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>"+TherapeuticSub+" &nbsp;</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev3+"</td></tr>";
			}
			if (lev4 != " " && lev4 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>"+ChemicalMain+"</td><td align='left' style='font-size:xx-small' class='TOOLTIP'  style='background-color:lightYellow;width:80%'>:&nbsp;"+lev4+"</td></tr>";
			}
			if (lev5 != " " && lev5 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>"+Chemicalsub+"</td><td align='left' style='font-size:xx-small' class='TOOLTIP'  style='background-color:lightYellow;width:80%'>:&nbsp;"+lev5+"</td></tr>";
			}
			tab_dat     += "</table>";
			document.getElementById("t").innerHTML = tab_dat;
}

function buildTablePhar(lev1,lev2,lev3){

			var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' >"
			tab_dat     += "<tr><td align='right' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%' class='TOOLTIP' nowrap  >Pharmacological Class &nbsp;</td> <td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev1+"</td></tr>";
			if (lev2 != " " && lev2 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>Group Class[Level I] &nbsp;</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev2+"</td></tr>";
			}
			if (lev3 != " " && lev3 != "null"){
				tab_dat     += "<tr><td align='right' nowrap  class='TOOLTIP' style='font-size:xx-small;font-weight:bold;background-color:lightYellow;width:20%'>Sub Group Class[Level II] &nbsp;</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+lev3+"</td></tr>";
			}			
			tab_dat     += "</table>";
			document.getElementById("t").innerHTML = tab_dat;
}

function hideToolTip() {
		if(parent.genericname_bottom.document.getElementById("tooltiplayer") != null)
		parent.genericname_bottom.document.getElementById("tooltiplayer").style.visibility='hidden';
}

function hideExecute(obj)
{
	var objRow=document.getElementById("queryCriteriaTable").children(1);
	if (obj.value == "A"){
		document.getElementById("generic_name").style.visibility='hidden';
		document.getElementById("drug_class").style.visibility='hidden';
		document.getElementById("eff_status").style.visibility='hidden';
		document.getElementById("btnExecute1").style.visibility='visible';
		objRow.children(3).style.visibility='hidden';
		objRow.children(4).style.visibility='hidden';
		objRow.children(5).style.visibility='hidden';
		objRow.children(6).style.visibility='hidden';
		objRow.children(7).style.visibility='hidden';
		objRow.children(8).style.visibility='hidden';
	}else if(obj.value == "P"){
		document.getElementById("generic_name").style.visibility='hidden';
		document.getElementById("drug_class").style.visibility='hidden';
		document.getElementById("eff_status").style.visibility='hidden';
		document.getElementById("btnExecute1").style.visibility='visible';
		objRow.children(3).style.visibility='hidden';
		objRow.children(4).style.visibility='hidden';
		objRow.children(5).style.visibility='hidden';
		objRow.children(6).style.visibility='hidden';
		objRow.children(7).style.visibility='hidden';
		objRow.children(8).style.visibility='hidden';
	}
	else{
		document.getElementById("btnExecute1").style.visibility='hidden';
		objRow.children(3).style.visibility='visible';
		objRow.children(4).style.visibility='visible';
		objRow.children(5).style.visibility='visible';
		objRow.children(6).style.visibility='visible';
		objRow.children(7).style.visibility='visible';
		objRow.children(8).style.visibility='visible';
		document.getElementById("generic_name").style.visibility='visible';
		document.getElementById("drug_class").style.visibility='visible';
		document.getElementById("eff_status").style.visibility='visible';
	}
}

function getQueryResult(){

	if (document.getElementById("drug_name").value == "A")	{
		callAssociateATC();
	}else if(document.getElementById("drug_name").value == "P")	{
		//callAssociatePharmaco();
	}
	else {
		document.getElementById("frmGenericnameByATCQueryCriteria").submit();
	}
}
function SubmitLink(from,to,generic_name,drug_name,eff_status){
	var obj=document.frmGenericnameByATCQueryResult;
	obj.from.value=from;
	obj.to.value=to;
	obj.generic_name.value=generic_name;
	obj.drug_class.value=drug_name;
	obj.eff_status.value=eff_status;
	obj.submit();
}
function duplicationCheck(retVal,count){

	retAllValBackup =retAllValues;
	var a1=retVal.split("|");
	var a2=retAllValues.split("|");
	retAllValues = retAllValues+retVal;
	increment=0;
	for (var i=1; i<count; i++)	{
		if (a1[0]==a2[parseInt(0+increment)] && a1[1]==a2[parseInt(1+increment)] && a1[2]==a2[parseInt(2+increment)] && a1[3]==a2[parseInt(3+increment)] &&
		a1[4]==a2[parseInt(4+increment)] && a1[5]==a2[parseInt(5+increment)] &&
		a1[6]==a2[parseInt(6+increment)] && a1[7]==a2[parseInt(7+increment)] &&
		a1[8]==a2[parseInt(8+increment)] && a1[9]==a2[parseInt(9+increment)] ){

			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ALREADY_SELECTED","PH");
			retAllValues =retAllValBackup;
			return false;
		}
		increment = parseInt((increment + 10));
	}
	if (parent.frames[1].name=="GenericNameFrame"){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}

}
function duplicationCheckInModify(retVal,associated,count){

	var arr1 = retVal.split("|");
	var arr2 = associated.split("|");

	var increment =0;
	for (var i=0;i<count ;i++ )
	{
		if (trimString(arr1[0])== trimString(arr2[0+increment]) && trimString(arr1[2])== trimString(arr2[1+increment]) &&
		trimString(arr1[4])== trimString(arr2[2+increment]) && trimString(arr1[6])== trimString(arr2[3+increment]) &&
		trimString(arr1[8])== trimString(arr2[4+increment]) )	{
		return true;
		}
		else{
			increment += 5;
		}
	}
	return false;
}

function SubmitLinkForATCClassification(from,to,code){
	var obj=document.frames.frmGenericNameByATCAddModify;
	obj.from.value=from;
	obj.to.value=to;
	obj.atcclassification.value=code;
	obj.submit();
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function controlDelete(obj)	{
	if(obj.checked==false)	{
		frmObj	=	parent.genericname_bottom.frmGenericNameByATCAddModify;
		var arrObj = frmObj.elements;
				for(i=0;i<arrObj.length;i++) {
				if(arrObj[i].type == "checkbox" && arrObj[i].name.substr(0,5)=="chkde") {
						arrObj[i].disabled = true;
						arrObj[i].checked = false;
					}
				}

		parent.genericname_top.frmGenericNameAddModify.btnSelect.disabled = true;
	}
	else	{
				frmObj	=	parent.genericname_bottom.frmGenericNameByATCAddModify;
		var arrObj = frmObj.elements;
				for(i=0;i<arrObj.length;i++) {
					if(arrObj[i].type == "checkbox") {
						arrObj[i].disabled = false;
					}
				}
		parent.genericname_top.frmGenericNameAddModify.btnSelect.disabled = false;
	}
}


function checkDeleteFound(frmObj)	{
	var found= true;
	var arrObj = frmObj.elements;
	for(i=0;i<arrObj.length;i++) {
		if(arrObj[i].type == "checkbox" && arrObj[i].name.substr(0,5)=="chkde" && arrObj[i].checked == true) {
				if(confirm(getMessage("DELETE_RECORD","Common")))
					found	=	true;
				
				else
					return false;
				break;
		}
	}
	return found;
}

async function callAssociatePharmaco()
{
	var dialogHeight= "32" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PharmacologicalClassificationFrames.jsp?called_from=generic_atc&mode="+MODE_INSERT,arguments,features);

	if (retVal == "cancel" || retVal==null || retVal==undefined){}
	else if(retVal!="cancel")	{
		count = count+1;
		var result=duplicationCheck(retVal,count);
		if (result == false){
			return false;
		}

		if (document.getElementById("mode") != null ){			
			if (document.getElementById("mode").value==MODE_INSERT){
				if (globalpharmaclassification == ""){
					globalpharmaclassification = globalpharmaclassification+retVal;
				}
				else{
					globalpharmaclassification = globalpharmaclassification+"|"+retVal;
				}
				parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByATCAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&called=pharma&atcclassification="+escape(globalpharmaclassification);
			}
			else {
				retValBackupInModify=globalpharmaclassification;
				if (globalpharmaclassification == ""){
					globalpharmaclassification = globalpharmaclassification+retVal;
				}
				else{
					globalpharmaclassification = globalpharmaclassification+"|"+retVal;
				}
				if (parent.genericname_bottom.document.getElementById("mainData") != null){
					var result=duplicationCheckInModify(retVal,parent.genericname_bottom.document.getElementById("associatedValues").value,parseInt(parent.genericname_bottom.document.getElementById("mainData").rows.length - 1));
					if (result == false){
						parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByPharmacoAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+document.getElementById("generic_id").value+"&atcclassification="+escape(globalpharmaclassification)+"&resultByATC=N";
					}
					else{
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ALREADY_SELECTED","PH");
						globalpharmaclassification=retValBackupInModify;
					}
				}
				else{
					parent.genericname_bottom.location.href="../../ePH/jsp/GenericNameByPharmacoAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&generic_id="+document.getElementById("generic_id").value+"&atcclassification="+escape(globalpharmaclassification)+"&resultByATC=N";
				}
			}
		}
		else{
			genericNameFrame.location.href="../../ePH/jsp/GenericNameFrame.jsp?param=ATCClassification&atcclassification="+escape(retVal)+"&resultByATC=Y";
		}
	}
}
/* @Name - Krishna Kiran 
 * @Date - 18/12/2009
 * @Inc# - IN017314
 * @Desc - allows to update the gneric name effective status in the arraylist when we click on the checkbox by calling GenericNameByATCValidate.jsp through AJAX Call
 */

function callEnableDisable(obj,changedAtIndex){

		var changedValue ='';	
			if (obj.checked)
			{
				changedValue ='E';
			}
			else
				changedValue ='D'
			

			//alert(document.frmGenericNameByATCAddModify);
			var bean_id			=	parent.genericname_top.document.frmGenericNameAddModify.bean_id.value;
			var bean_name		=	parent.genericname_top.document.frmGenericNameAddModify.bean_name.value;
							
			var xmlDoc			= "";
			var xmlHttp			= new XMLHttpRequest();
          	var xmlAppend		= "";	
			
			xmlAppend += "changedValue"+"=\""+changedValue+"\" " ;
			xmlAppend += "changedAtIndex"+"=\""+changedAtIndex+"\" " ;

			var xmlStr1 ="<root><SEARCH " ;			
			xmlStr1 =xmlStr1 + xmlAppend ;
			xmlStr1 +=" /></root>" ;

			xmlDoc.loadXML( xmlStr1 ) ;		
			xmlHttp.open( "POST", "GenericNameByATCValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=byATCUpdate", false);		
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;


}

function callResetEnableDisable(){
			
			var bean_id			=	genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.bean_id.value;
			var bean_name		=	genericNameFrame.genericname_bottom.document.frmGenericNameByATCAddModify.bean_name.value;
						
			var xmlDoc			= "";
			var xmlHttp			= new XMLHttpRequest();          	
			

			var xmlStr1 ="<root><SEARCH " ;						
			xmlStr1 +=" /></root>" ;

			xmlDoc.loadXML( xmlStr1 ) ;		
			xmlHttp.open( "POST", "GenericNameByATCValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=resetUpdatedList", false);		
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;


}
